// ----------------------------------------------------------------------------
// Copyright (C) 2016 Louise A. Dennis, Michael Fisher, Marija Slavkovik and Matt Webster
// 
// This file is part of Ethical Gwendolen
//
// Ethical Gwendolen is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Ethical Gwendolen is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with Ethical Gwendolen if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

grammar EthicalGwendolen;

options {
	k = 5;
	}

@header {
package ethical_gwen.parser;

import ail.syntax.ast.*;
import gwendolen.syntax.ast.*;
import ethical_gwen.syntax.ast.*;
import java.util.HashMap;
}

@members {
	private static HashMap<String,Abstract_VarTerm> variables = new HashMap<String,Abstract_VarTerm>();
	private Abstract_StringTerm agentname = new Abstract_StringTermImpl("");
	}

@lexer::header {
package ethical_gwen.parser;
}
	
@lexer::members {
    public int plain_nesting = 0;
    public int sq_nesting = 0;
    public int curly_nesting = 0;
    public boolean stringterm = false;
    public boolean gwendolen = true;
    public int belief_rules = 0;
}

// Mas involving Gwendolen Agents
mas returns [Abstract_MAS mas] : {$mas = new Abstract_MAS();} 
	glist=egwendolenagents {$mas.setAgs($glist.gags);};

egwendolenagents returns[ArrayList<Abstract_EthicalGwendolenAgent> gags]: 
	{gags=new ArrayList<Abstract_EthicalGwendolenAgent>();} 
	(g=gwendolenagent {gags.add($g.g);})+;

// Gwendolen Agent stuff
gwendolenagent returns [Abstract_EthicalGwendolenAgent g] : 
        (GWENDOLEN?) 
	NAME w=word {try {$g = new Abstract_EthicalGwendolenAgent($w.s);} 
		catch (Exception ex) {System.err.println(ex); agentname = new Abstract_StringTermImpl($w.s);}}
	ETHICS (e=ethic {$g.addEthic($e.e);})*
	BELIEFS (l=literal {$g.addInitialBel($l.l);})*
	(BELIEFRULES (r=brule {$g.addRule($r.r);})*)?
	GOALS (gl=goal {$g.addInitialGoal($gl.g);})*
	PLANS (p=plan {try {$g.addPlan($p.p);} catch (Exception ex) {System.err.println(ex);}})*;
	
ethic returns [Abstract_Ethic e] : ETHIC OPEN c=pred COMMA e1=pred COMMA n=NUMBER CLOSE {$e = new Abstract_Ethic($c.t, $e1.t, $n.getText());};
	
guard_atom returns [Abstract_GLogicalFormula g] : (BELIEVE l=literal {$g = new Abstract_GBelief($l.l);} |
				GOAL gl=goal {$g = new Abstract_Goal($gl.g);} |
				SENT OPEN {Abstract_StringTerm an1=agentname;} (s=agentnameterm {an1 = s;}) 
				                        COMMA {Abstract_StringTerm agn = agentname;} (an2=agentnameterm 
					COMMA {agn = an2;})? p=performative 
					COMMA t=pred CLOSE {$g = new Abstract_GuardMessage(Abstract_BaseAILStructure.AILSent, agn, an1, $p.b, $t.t);} |
				eq = equation {$g = $eq.eq;} |
				TRUE {$g = new Abstract_GBelief();} );

goal returns [Abstract_Goal g] : l=literal SQOPEN (ACHIEVEGOAL {$g = new Abstract_Goal($l.l, Abstract_Goal.achieveGoal);} | 
			PERFORMGOAL {$g = new Abstract_Goal($l.l, Abstract_Goal.performGoal);}) SQCLOSE;
plan returns [Abstract_GPlan p]
	: e=event  {ArrayList<Abstract_Deed> deeds=new ArrayList<Abstract_Deed>(); Abstract_Guard g = new Abstract_Guard();} 
		COLON CURLYOPEN {boolean gneg=true;} (NOT {gneg=false;})? gb=guard_atom {g.add($gb.g, gneg);} 
		(COMMA {gneg=true;} (NOT {gneg=false;})? gb=guard_atom {g.add($gb.g, gneg);})* CURLYCLOSE (RULEARROW
	d=deed {deeds.add($d.d);} (COMMA d=deed {deeds.add($d.d);})*)? 
	SEMI {$p = new Abstract_GPlan($e.e, g, deeds); $p.reverseBody(); variables.clear();};
	
event returns [Abstract_Event e] : (PLUS (RECEIVED OPEN p=performative COMMA t=pred CLOSE 
					{Abstract_GMessage message = new Abstract_GMessage(new Abstract_VarTerm("From"), 
						new Abstract_VarTerm("To"), $p.b, $t.t); 
						$e = new Abstract_Event(Abstract_Event.AILAddition, 
						Abstract_Event.AILReceived, message);}|
				(l=literal {$e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILBel, $l.l);} |
				SHRIEK g=goal {$e = new Abstract_Event(Abstract_Event.AILAddition, $g.g);}) |
				ADD_CONTENT l=literal {$e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILContent, $l.l);} |
				ADD_CONTEXT l=literal {$e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILContext, $l.l);}
				) |
			   MINUS (l=literal {$e = new Abstract_Event(Abstract_Event.AILDeletion, Abstract_Event.AILBel, $l.l);} |
				SHRIEK g=goal {$e = new Abstract_Event(Abstract_Event.AILDeletion, $g.g);} |
				ADD_CONTENT l=literal {$e = new Abstract_Event(Abstract_Event.AILDeletion, Abstract_Event.AILContent, $l.l);} |
				ADD_CONTEXT l=literal {$e = new Abstract_Event(Abstract_Event.AILDeletion, Abstract_Event.AILContext, $l.l);}
				));

performative returns [int b] : (TELL {$b=1;} | PERFORM {$b=2;} | ACHIEVE {$b = 3;} | TELLHOW {$b = 4;} | CONSTRAINT {$b = 5;});
								
deed returns [Abstract_Deed d] : (((PLUS (l=literal {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILBel, $l.l);} |
				SHRIEK g=goal {$d = new Abstract_Deed(Abstract_Deed.AILAddition, $g.g);} |
				ADD_CONTENT l=literal {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILContent, $l.l);} |
				ADD_CONTEXT l=literal {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILContext, $l.l);} |
				ADD_PLAN p=literal {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILPlan, $p.l);} |
				ADD_CONSTRAINT c=literal {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILConstraint, $c.l);} |
				LOCK {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dlock);}) |
			   MINUS (l=literal {$d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILBel, $l.l);} |
				SHRIEK g=goal {$d = new Abstract_Deed(Abstract_Deed.AILDeletion, $g.g);} |
				ADD_CONTENT l=literal {$d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILContent, $l.l);} |
				ADD_CONTEXT l=literal {$d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILContext, $l.l);} |
				LOCK {$d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.Dlock);}
				)) |
				a=action {$d = new Abstract_Deed($a.a);}) |
				wf=waitfor {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dwaitfor, $wf.wf);}
				)
				;
					
// brule returns [Rule r] : head=gbelief BRULEARROW gb=gbelief {$r = new Rule($head.g, $gb.g);} 
//	(COMMA and=andfmla {LogExpr body = new LogExpr($gb.g, LogExpr.LogicalOp.and, $and.f); 
//		$r = new Rule($head.g, body);})? SEMI;
brule returns [Abstract_Rule r] : head=pred (BRULEARROW f=logicalfmla {$r = new Abstract_Rule(head, $f.f);} SEMI | SEMI {$r = new Abstract_Rule(head);});

logicalfmla returns [Abstract_LogicalFormula f] : n=notfmla {$f = $n.f;}
               (COMMA n2=notfmla {$f = new Abstract_LogExpr($f, Abstract_LogExpr.and, $n2.f);})*;
               // | and=subfmla {$f = new Abstract_LogExpr($n.f, Abstract_LogExpr.and, $and.f);}))?; 
notfmla returns [Abstract_LogicalFormula f] : gb = pred {$f = gb;} | 
                                                                              NOT (gb2 = pred {$f = new Abstract_LogExpr(Abstract_LogExpr.not, gb2);} | lf = subfmla {$f = new Abstract_LogExpr(Abstract_LogExpr.not, $lf.f);});
subfmla returns [Abstract_LogicalFormula f] : OPEN lf = logicalfmla {$f = $lf.f;} CLOSE;

waitfor returns [Abstract_Literal wf] :  MULT l=literal {$wf = $l.l;};

action returns [Abstract_Action a] : 
	(SEND OPEN an=literal COMMA p=performative COMMA t=pred CLOSE {$a = new Abstract_SendAction($an.l, $p.b, $t.t);}) | 
	t=pred {$a = new Abstract_Action($t.t, Abstract_Action.normalAction);};

GWENDOLEN	:{curly_nesting == 0}?=>'GWENDOLEN' {gwendolen = true;};

ETHICS  :	':Ethical Policy:' {belief_rules = 1;};
GOALS	:	':Initial Goals:' {belief_rules = 0;};
BELIEFS	:	':Initial Beliefs:';
BELIEFRULES 
	:	':Reasoning Rules:' {belief_rules = 1;};
PLANS	:	':Plans:';
NAME	:	':name:';

SEND	:	'.send';
RECEIVED:	{gwendolen}?=> '.received';
ETHIC	:	{curly_nesting > 0 && plain_nesting == 0 || belief_rules==1}?=> ('E') ;
BELIEVE	:	{curly_nesting > 0 && plain_nesting == 0 || belief_rules==1}?=> ('B' | '.B') ;
GOAL	:	{curly_nesting > 0 && plain_nesting == 0|| belief_rules==1}?=> ('G' | '.G') ;
IN_CONTENT	:	{curly_nesting > 0 && plain_nesting == 0 || belief_rules==1}?=> ('N') ;
IN_CONTEXT	:	{curly_nesting > 0 && plain_nesting == 0|| belief_rules==1}?=> ('X') ;
SENT	:	{curly_nesting > 0 && plain_nesting == 0|| belief_rules==1}?=> '.sent';
LOCK	:	'.lock';
ADD_PLAN	:	'.plan';
ADD_CONSTRAINT	: '.constraint';
ADD_CONTENT
	:	'.n';
ADD_CONTEXT	:	'.x';

TELL	:	':tell';
PERFORM :	':perform';
ACHIEVE :	':achieve';
TELLHOW	:	':how';
CONSTRAINT 
	:	':constrain';

ACHIEVEGOAL	: {sq_nesting > 0}?=> 'achieve';
PERFORMGOAL	: {sq_nesting > 0}?=> 'perform';
BRULEARROW 
	:	':-';
RULEARROW :	'<-';

TRUE	:	{curly_nesting > 0 && plain_nesting == 0}?=> 'True';

// General AIL Parsing stuff

environment returns [String env] : w=classpath {$env = $w.s;};
classpath returns [String s] : w=word {$s = $w.s;} (POINT w1=word {$s+="."; $s+=$w1.s;})+;                                                                                     
word returns [String s] : (CONST {$s=$CONST.getText();} | VAR {$s=$VAR.getText();});                                                                                     

agentnameterm returns [Abstract_StringTerm s] : CONST {$s = new Abstract_StringTermImpl($CONST.getText());} | v=var {$s = $v.v;};

// littest returns [Literal l]: LITTEST literal;
literal returns [Abstract_Literal l]:  (TRUE {$l = new Abstract_Literal(Abstract_Literal.LTrue);} | 
				NOT nt=pred {
				if ($nt.t instanceof Abstract_VarTerm) 
					{$l = (Abstract_VarTerm) $nt.t; $l.setNegated(false);}
					else { $l = new Abstract_Literal(Abstract_Literal.LNeg, new Abstract_Pred($nt.t));}}) | 
				t=pred {if ($t.t instanceof Abstract_VarTerm) 
				            {$l = (Abstract_VarTerm) $t.t;} 
				            else {$l = new Abstract_Literal(Abstract_Literal.LPos, new Abstract_Pred($t.t));}};

pred 	returns [Abstract_Predicate t]:	(v=var {$t = $v.v;}| f=function {$t = $f.f;}) (SQOPEN w=word SQCLOSE {$t = new Abstract_PredicatewEB($t, $w.s);})?;
function returns [Abstract_Predicate f]: CONST {$f = new Abstract_Predicate($CONST.getText());} (OPEN terms[$f] CLOSE)?;

terms[Abstract_Predicate f] : t=term {$f.addTerm($t.t);} (COMMA terms[$f])? ;
term	returns [Abstract_Term t]:  a = atom {$t = $a.t;} | s = stringterm {$t = $s.s;} | l = listterm {$t = $l.l;} |f=function {$t = $f.f;};

atom	returns [Abstract_NumberTerm t]	:	n = numberstring {$t = new Abstract_NumberTermImpl($n.s);}| 
					v=var {$t = $v.v;} | OPEN a=arithexpr CLOSE {$t = $a.t;};
stringterm returns [Abstract_StringTerm s] : DOUBLEQUOTE  STRING DOUBLEQUOTE {$s = new Abstract_StringTermImpl($STRING.getText());};
listterm returns [Abstract_ListTerm l] : SQOPEN {$l = new Abstract_ListTermImpl();} (h = term '|' t = term {$l.addHead($h.t); $l.addTail((Abstract_ListTerm) $t.t);})? SQCLOSE;

var 	returns [Abstract_VarTerm v]:	VAR {
	if (variables.containsKey($VAR.getText())) {
		$v = variables.get($VAR.getText());
		} else {
		$v = new Abstract_VarTerm($VAR.getText());
		variables.put($VAR.getText(), $v);
		}
	};

numberstring returns [String s] :	{$s = "";} (MINUS {$s += "-";})? (n1=NUMBER {$s += $n1.getText();}
					(POINT {$s += ".";} n2=NUMBER {$s += $n2.getText();})?);
equation returns[Abstract_Equation eq] : a1=arithexpr oper=eqoper a2=arithexpr  {$eq = new Abstract_Equation($a1.t, $oper.oper, $a2.t);};
eqoper returns [int oper] : LESS {$oper=Abstract_Equation.less;} | EQ {$oper=Abstract_Equation.equal;};

arithexpr returns [Abstract_NumberTerm t]	:	m=multexpr {$t = $m.t;} ( oper=addoper m1=multexpr {$t = new Abstract_ArithExpr($m.t, $oper.oper, $m1.t);})?;
multexpr returns [Abstract_NumberTerm t]	:	a=atom {$t = $a.t;} (oper=multoper a1=atom {$t = new Abstract_ArithExpr($a.t, $oper.oper, $a1.t);})?;

addoper	returns [int oper] :	(PLUS {$oper=Abstract_ArithExpr.plus;}| MINUS {$oper=Abstract_ArithExpr.minus;});
multoper returns [int oper] : (MULT {$oper=Abstract_ArithExpr.times;} | DIV {$oper=Abstract_ArithExpr.div;} | MOD {$oper=Abstract_ArithExpr.mod;});

// General AIL Lexing stuff
COMMENT
    : '/*' .* '*/' {$channel=HIDDEN;}
    ;
LINE_COMMENT
    : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    ;
NEWLINE:'\r'? '\n' {skip();} ;
WS  :   (' '|'\t')+ {skip();} ;


OPEN	: 	'(' {plain_nesting++;};
CLOSE	:	')' {plain_nesting--;};
SQOPEN	:	'[' {sq_nesting++;};
SQCLOSE	:	']' {sq_nesting--;};
CURLYOPEN	: '{' {curly_nesting++;};
CURLYCLOSE	: '}' {curly_nesting--;};
DOUBLEQUOTE
	:	'"' {if (stringterm) {stringterm = false;} else {stringterm = true;}};
NOT	:	'~';

STRING	:	{stringterm}?=> ('a'..'z'|'A'..'Z'|'0'..'9'|'_')+;
CONST 	: 	{!stringterm}?=>'a'..'z' ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
VAR	:	{!stringterm}?=>'A'..'Z' ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
NUMBER	:	{!stringterm}?=>'0'..'9' ('0'..'9')*;


LESS	:	'<';
EQ	: 	'==';
POINT	:	'.';
MULT	:	'*';
PLUS	:	'+';
MINUS	:	'-';
DIV	:	'/';
MOD	:	'%';

SHRIEK	:	'!';
COMMA	:	',';
SEMI	:	';';
COLON	:	':';
QUERY	:	'?';
