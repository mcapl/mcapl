// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, Michael Fisher, Nicholas K. Lincoln, Alexei
// Lisitsa and Sandor M. Veres
//
// This file is part of the Engineering Autonomous Space Software (EASS) Library.
// 
// The EASS Library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The EASS Library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the EASS Library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

grammar EASS;

options {
	k = 4;
	}

@header {
package eass.parser;

import ail.syntax.ast.*;
import eass.syntax.ast.*;
import gwendolen.syntax.ast.*;
import java.util.HashMap;
}

@lexer::header {
package eass.parser;
}

@members {
	private static HashMap<String,Abstract_VarTerm> variables = new HashMap<String,Abstract_VarTerm>();
	private Abstract_StringTerm agentname = new Abstract_StringTermImpl("");
	}
	
@lexer::members {
    public int plain_nesting = 0;
    public int sq_nesting = 0;
    public int curly_nesting = 0;
    public boolean stringterm = false;
    public int belief_rules = 0;
}

// Mas involving EASS Agents
mas returns [Abstract_MAS mas] : {$mas = new Abstract_MAS();} glist=eassagents {$mas.setAgs(glist);};


eassagents returns[ArrayList<Abstract_EASSAgent> gags]: EASS {gags=new ArrayList<Abstract_EASSAgent>();} 
	(g=eassagent {gags.add($g.g);})+;
// EASS Agent stuff
eassagent returns [Abstract_EASSAgent g] : 
	(NAME w=word {try {$g = new Abstract_EASSAgent($w.s);} catch (Exception e) {System.err.println(e);}
	              agentname = new Abstract_StringTermImpl($w.s);} |
	ABSTRACTION w=word {String s = "abstraction_" + $w.s; $g = new Abstract_EASSAgent(s); g.setAbstraction($w.s);} 
				)
	BELIEFS (l=literal {$g.addInitialBel($l.l);})*
	(BELIEFRULES (r=brule {$g.addRule($r.r);})*)?
	(CAPABILITIES (c=capability {$g.addCap($c.c);})*)?
	GOALS (gl=goal {$g.addInitialGoal($gl.g);})*
	PLANS (p=plan {try {$g.addPlan($p.p);} catch (Exception e) {System.err.println(e);}})*
	; 

goal returns [Abstract_Goal g] : l=literal SQOPEN (ACHIEVEGOAL {$g = new Abstract_Goal($l.l, Abstract_Goal.achieveGoal);} | 
	PERFORMGOAL {$g = new Abstract_Goal($l.l, Abstract_Goal.performGoal);}) SQCLOSE;
	
capability returns [Abstract_Capability c] : 
	CURLYOPEN (pre=clogicalfmla)? CURLYCLOSE 
	cap=pred {$c = new Abstract_Capability($cap.t); if ($pre.f != null) {$c.addPre($pre.f);}}
	CURLYOPEN post=clogicalfmla {$c.addPost($post.f);} CURLYCLOSE;  


plan returns [Abstract_GPlan p]
	: e=event  {ArrayList<Abstract_Deed> deeds=new ArrayList<Abstract_Deed>(); Abstract_Guard g = new Abstract_Guard();} 
		COLON CURLYOPEN {boolean gneg=true;} (NOT {gneg=false;})? gb=guard_atom {g.add($gb.g, gneg);} 
		(COMMA {gneg=true;} (NOT {gneg=false;})? gb=guard_atom {g.add($gb.g, gneg);})* CURLYCLOSE (RULEARROW
	d=deed[deeds] {deeds.add($d.d);} (COMMA d=deed[deeds] {deeds.add($d.d);})*)? 
	SEMI {$p = new Abstract_GPlan($e.e, g, deeds); $p.reverseBody(); variables.clear();}; 
	
event returns [Abstract_Event e] : (PLUS (RECEIVED OPEN p=performative COMMA t=pred CLOSE
					{Abstract_GMessage message = new Abstract_GMessage(new Abstract_VarTerm("From"), 
					new Abstract_VarTerm("To"), $p.b, $t.t); 
					$e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILReceived, message);}|
				(l=literal {$e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILBel, $l.l);} |
				SHRIEK g=goal {$e = new Abstract_Event(Abstract_Event.AILAddition, $g.g);})) |
			   MINUS (l=literal {$e = new Abstract_Event(Abstract_Event.AILDeletion, Abstract_Event.AILBel, $l.l);} |
				SHRIEK g=goal {$e = new Abstract_Event(Abstract_Event.AILDeletion, $g.g);})); 
				
guard_atom returns [Abstract_GLogicalFormula g] : (BELIEVE l=literal {$g = new Abstract_GBelief($l.l);} |
				GOAL gl=goal {$g = new Abstract_Goal($gl.g);} |
				SENT OPEN {Abstract_StringTerm an1=agentname;} (st=stringterm {an1=st;} | v=var {an1 = v;}) COMMA {Abstract_StringTerm agn = agentname;} (an2=stringterm 
					COMMA {agn = an2;})? p=performative 
					COMMA t=pred CLOSE {$g = new Abstract_GuardMessage(Abstract_BaseAILStructure.AILSent, agn, an1, $p.b, $t.t);} |
				eq = equation {$g = $eq.eq;} |
				// CAPABILITY OPEN pre=pred COMMA cap=pred COMMA pst=pred CLOSE 
				//	{$g = new Abstract_GuardCap($pre.t, $cap.t, $pst.t);} |
				//PLAN OPEN {Abstract_NumberTerm n=new Abstract_NumberTermImpl("0");} (v=var {n = $v.v;}| s=numberstring {n = new Abstract_NumberTermImpl($s.s);}) COMMA
				 //                                       ga=pred COMMA 
				 //                                       c=pred COMMA post=pred CLOSE 
				//                                          {$g = new Abstract_GuardPlan(n, $c.t, $ga.t, $post.t);} |
				TRUE {$g = new Abstract_GBelief();} ); 
				
deed[ArrayList<Abstract_Deed> ds] returns [Abstract_Deed d] : (((PLUS (l=literal {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILBel, $l.l);} |
				SHRIEK g=goal {$d = new Abstract_Deed(Abstract_Deed.AILAddition, $g.g);} |
				LOCK {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dlock);}|
				PLAN OPEN p=pred CLOSE {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.DPlan, $p.t);}) |
			   MINUS (l=literal {$d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILBel, $l.l);} |
				SHRIEK g=goal {$d = new Abstract_Deed(Abstract_Deed.AILDeletion, $g.g);} |
				LOCK {$d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.Dlock);} |
				PLAN OPEN p=pred CLOSE {$d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.DPlan, $p.t);}
				)) |
				UPDATE (l=literal {$d = new Abstract_Deed(Abstract_Deed.AILUpdate, Abstract_Deed.AILBel, $l.l);}) |
				CALCULATE c=calculation[ds]  {$d = $c.d;}|
				QUERYCOM q=query[ds] {$d = $q.d;}	|
				WAIT w=wait[ds] {$d = $w.d;}	|
				a=action {$d = new Abstract_Deed($a.a);}) |
				wf=waitfor {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dwaitfor, $wf.wf);} |
				SUBSTITUTE s=substitution[ds] {$d = $s.d;}
				)
				; 
				
substitution[ArrayList<Abstract_Deed> ds] returns [Abstract_Deed d]	: OPEN pl1=pred COMMA c1 = pred COMMA c2 =pred COMMA pl2 = pred CLOSE
	{Abstract_Action a = new Abstract_Action("substitute"); a.addTerm($pl1.t); a.addTerm($c1.t); a.addTerm($c2.t); a.addTerm($pl2.t); $d = new Abstract_Deed(a);}; 

calculation[ArrayList<Abstract_Deed> ds] returns [Abstract_Deed d]	: OPEN l1 = literal COMMA v=var CLOSE
	{Abstract_Action a = new Abstract_Action("calculate"); a.addTerm($l1.l); a.addTerm(new Abstract_VarTerm("NewVarForCalculate")); ds.add(new Abstract_Deed(a));
	Abstract_Literal wf = new Abstract_Literal("result"); wf.addTerm($l1.l); wf.addTerm($v.v); ds.add(new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dwaitfor, wf));
	Abstract_Action rs = new Abstract_Action("remove_shared"); rs.addTerm(wf); $d = new Abstract_Deed(rs);};
	
query[ArrayList<Abstract_Deed> ds] returns [Abstract_Deed d]	: OPEN l1 = literal  CLOSE 
	{Abstract_Action a = new Abstract_Action("query"); a.addTerm($l1.l); ds.add(new Abstract_Deed(a));
	ds.add(new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dwaitfor, $l1.l));
	Abstract_Action rs = new Abstract_Action("remove_shared"); rs.addTerm($l1.l); $d = new Abstract_Deed(rs);};
	
wait[ArrayList<Abstract_Deed> ds] returns [Abstract_Deed d]	: OPEN l1 = term COMMA l2=literal CLOSE 
	{Abstract_Action a = new Abstract_Action("wait"); a.addTerm($l1.t); a.addTerm($l2.l); ds.add(new Abstract_Deed(a));
	Abstract_Literal wf = new Abstract_Literal("waited"); wf.addTerm($l2.l); ds.add(new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dwaitfor, wf));
	Abstract_Action rs = new Abstract_Action("remove_shared"); rs.addTerm(wf); $d = new Abstract_Deed(rs);}; 
				
brule returns [Abstract_Rule r] : head=pred (BRULEARROW f=logicalfmla {$r = new Abstract_Rule(head, $f.f);} SEMI | SEMI {$r = new Abstract_Rule(head);}); 

logicalfmla returns [Abstract_LogicalFormula f] : n=notfmla {$f = $n.f;}
               (COMMA n2=notfmla {$f = new Abstract_LogExpr($f, Abstract_LogExpr.and, $n2.f);})*;
               // | and=subfmla {$f = new Abstract_LogExpr($n.f, Abstract_LogExpr.and, $and.f);}))?; 
notfmla returns [Abstract_LogicalFormula f] : (gb = pred {$f = gb;} |   SQOPEN eq = equation {$f = eq;} SQCLOSE) | 
                                                                              NOT (gb2 = pred {$f = new Abstract_LogExpr(Abstract_LogExpr.not, gb2);} |
                                                                              SQOPEN eq = equation SQCLOSE {$f = new Abstract_LogExpr(Abstract_LogExpr.not, eq);} |
                                                                               lf = subfmla {$f = new Abstract_LogExpr(Abstract_LogExpr.not, $lf.f);});
subfmla returns [Abstract_LogicalFormula f] : OPEN lf = logicalfmla {$f = $lf.f;} CLOSE; 

clogicalfmla returns [Abstract_GLogicalFormula f] : n=cnotfmla {$f = $n.f;}
               (COMMA n2=cnotfmla {$f = new Abstract_Guard($f, Abstract_Guard.and, $n2.f);})*;
               // | and=subfmla {$f = new Abstract_LogExpr($n.f, Abstract_LogExpr.and, $and.f);}))?; 
cnotfmla returns [Abstract_GLogicalFormula f] : gb = pred {$f = new Abstract_GBelief(new Abstract_Literal(gb));} | 
                                                                              NOT (gb2 = pred {$f = new Abstract_Guard(Abstract_Guard.not, new Abstract_GBelief(new Abstract_Literal(gb2)));} | 
                                                                              lf = csubfmla {$f = new Abstract_Guard(Abstract_Guard.not, $lf.f);});
csubfmla returns [Abstract_GLogicalFormula f] : OPEN lf = clogicalfmla {$f = $lf.f;} CLOSE; 

	
waitfor returns [Abstract_Literal wf] :  MULT l=literal {$wf = $l.l;}; 

action returns [Abstract_Action a] : 
	(a1=atom PLUS a2=atom EQ_ASSGN v=var {$a = new Abstract_Action("sum"); $a.addTerm($a1.t); $a.addTerm($a2.t); $a.addTerm($v.v); }) |
	(SEND OPEN an=literal COMMA p=performative COMMA t=pred CLOSE {$a = new Abstract_SendAction($an.l, $p.b, $t.t);}) | 
	t=pred {$a = new Abstract_Action($t.t, Abstract_Action.normalAction);}; 

performative returns [int b] : (TELL {$b=1;} | PERFORM {$b=2;} | ACHIEVE {$b = 3;}); 

UPDATE 	:	'>' ;
TELL	:	':tell';
PERFORM :	':perform';
ACHIEVE :	':achieve';
SEND	:	'.send';
RECEIVED:	'.received';
CALCULATE
	:	'.calculate';
QUERYCOM	:	'.query';
WAIT	:	'.wait';
CAPABILITY	:	'.cap';
PLAN	:	'.plan';
IMPLICATION	:	'.imp';
SUBSTITUTE
	:	'.substitute';
BELIEVE	:	{curly_nesting > 0 && plain_nesting == 0 || belief_rules==1}?=> ('B' | '.B') ;
GOAL	:	{curly_nesting > 0 && plain_nesting == 0|| belief_rules==1}?=> ('G' | '.G') ;
SENT	:	{curly_nesting > 0 && plain_nesting == 0|| belief_rules==1}?=> '.sent';
LOCK	:	'.lock';
GOALS	:	':Initial Goals:' {belief_rules=0;};
BELIEFS	:	':Initial Beliefs:';
BELIEFRULES 
	:	':Reasoning Rules:' {belief_rules=1;};
CAPABILITIES:	':Capabilities:';
PLANS	:	':Plans:';
EASS	:	{curly_nesting == 0}?=> 'EASS';
NAME	:	':name:';
ABSTRACTION
	:	':abstraction:';
TRUE	:	{curly_nesting > 0 && plain_nesting == 0}?=> 'True';
ACHIEVEGOAL	: {sq_nesting > 0}?=> 'achieve';
PERFORMGOAL	: {sq_nesting > 0}?=> 'perform';

BRULEARROW 
	:	':-';
RULEARROW :	'<-';
EQ_ASSGN	:	'=';
ARROW	:	'->';

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

pred 	returns [Abstract_Predicate t]:	v=var {$t = $v.v;}| f=function {$t = $f.f;}; 
function returns [Abstract_Predicate f]: CONST {$f = new Abstract_Predicate($CONST.getText());} (OPEN terms[$f] CLOSE)?; 

terms[Abstract_Predicate f] : t=term {$f.addTerm($t.t);} (COMMA terms[$f])? ;
term	returns [Abstract_Term t]:  a = atom {$t = $a.t;} | 
	s = stringterm {$t = $s.s;}  |
	f=function {$t = $f.f;} |
	l = listterm {$t = $l.l;}; 

atom	returns [Abstract_NumberTerm t]	:	n = numberstring {$t = new Abstract_NumberTermImpl($n.s);}| 
					v=var {$t = $v.v;} | OPEN a=arithexpr CLOSE {$t = $a.t;};

stringterm returns [Abstract_StringTerm s] : DOUBLEQUOTE  STRING DOUBLEQUOTE {		 
                   $s = new Abstract_StringTermImpl($STRING.getText());};
                   
listterm returns [Abstract_ListTerm l] : {$l = new Abstract_ListTermImpl();} SQOPEN (hl=listheads {$l.addAll($hl.tl);} (BAR v=var {$l.addTail($v.v);})?)? SQCLOSE; 

listheads returns [ArrayList<Abstract_Term> tl]: t1 = term {$tl = new ArrayList<Abstract_Term>(); $tl.add($t1.t);} (COMMA tl2= term {$tl.add($tl2.t);})*;


var 	returns [Abstract_VarTerm v]:	(VAR {
	if (variables.containsKey($VAR.getText())) {
		$v = variables.get($VAR.getText());
		} else {
		$v = new Abstract_VarTerm($VAR.getText());
		variables.put($VAR.getText(), $v);
		}
	} | UNNAMEDVAR {$v = new Abstract_UnnamedVar();});

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
WS  :  {!stringterm}?=>(' '|'\t')+ {skip();} ;


OPEN	: 	'(' {plain_nesting++;};
CLOSE	:	')' {plain_nesting--;};
SQOPEN	:	'[' {sq_nesting++;};
SQCLOSE	:	']' {sq_nesting--;};
CURLYOPEN	: '{' {curly_nesting++;};
CURLYCLOSE	: '}' {curly_nesting--;};
DOUBLEQUOTE
	:	'"' {if (stringterm) {stringterm = false;} else {stringterm = true;}};

NOT	:	'~';

STRING	:	{stringterm}?=> ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|' '|'.')+;
CONST 	: 	{!stringterm}?=>'a'..'z' ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
VAR	:	{!stringterm}?=>'A'..'Z'('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
NUMBER	:	{!stringterm}?=>'0'..'9' ('0'..'9')*;
UNNAMEDVAR
	:	{!stringterm}?=>'_';


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
BAR	:	'|';
