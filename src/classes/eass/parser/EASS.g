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
	private Abstract_Literal agentname = new Abstract_Literal("");
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
	              agentname = new Abstract_Literal($w.s);} |
	ABSTRACTION w=word {String s = "abstraction_" + $w.s; $g = new Abstract_EASSAgent(s); g.setAbstraction($w.s);} 
				)
	BELIEFS (l=literal {$g.addInitialBel($l.l);})*
	(BELIEFRULES (r=brule {$g.addRule($r.r);})*)?
	GOALS (gl=goal {$g.addInitialGoal($gl.g);})*
	PLANS (p=plan {try {$g.addPlan($p.p);} catch (Exception e) {System.err.println(e);}})*
	;

goal returns [Abstract_Goal g] : l=literal SQOPEN (ACHIEVEGOAL {$g = new Abstract_Goal($l.l, Abstract_Goal.achieveGoal);} | 
	PERFORMGOAL {$g = new Abstract_Goal($l.l, Abstract_Goal.performGoal);}) SQCLOSE;


plan returns [Abstract_GPlan p]
	: e=event  {ArrayList<Abstract_Deed> deeds=new ArrayList<Abstract_Deed>(); Abstract_Guard g = new Abstract_Guard();} 
		COLON CURLYOPEN {boolean gneg=true;} (NOT {gneg=false;})? gb=guard_atom {g.add($gb.g, gneg);} 
		(COMMA {gneg=true;} (NOT {gneg=false;})? gb=guard_atom {g.add($gb.g, gneg);})* CURLYCLOSE (RULEARROW
	d=deed[deeds] {deeds.add($d.d);} (',' d=deed[deeds] {deeds.add($d.d);})*)? 
	SEMI {$p = new Abstract_GPlan($e.e, g, deeds); $p.reverseBody(); variables.clear();};
	
event returns [Abstract_Event e] : (PLUS (RECEIVED OPEN p=performative ',' t=pred ')' 
					{Abstract_GMessage message = new Abstract_GMessage(new Abstract_VarTerm("From"), 
					new Abstract_VarTerm("To"), $p.b, $t.t); 
					$e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILReceived, message);}|
				(l=literal {$e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILBel, $l.l);} |
				SHRIEK g=goal {$e = new Abstract_Event(Abstract_Event.AILAddition, $g.g);})) |
			   MINUS (l=literal {$e = new Abstract_Event(Abstract_Event.AILDeletion, Abstract_Event.AILBel, $l.l);} |
				SHRIEK g=goal {$e = new Abstract_Event(Abstract_Event.AILDeletion, $g.g);}));
				
guard_atom returns [Abstract_GuardAtom g] : (BELIEVE l=literal {$g = new Abstract_GBelief(Abstract_GBelief.AILBel, $l.l);} |
				GOAL gl=goal {$g = new Abstract_Goal($gl.g);} |
				SENT OPEN an1=literal COMMA {Abstract_Literal agn = agentname;} (an2=literal 
					COMMA {agn = $an2.l;})? p=performative 
					COMMA t=pred CLOSE {Abstract_GMessage mess = new Abstract_GMessage(agn, $an1.l, $p.b, $t.t); 
								$g = new Abstract_GBelief(Abstract_GBelief.AILSent, mess);} |
				eq = equation {$g = $eq.eq;} |
				TRUE {$g = new Abstract_GBelief(Abstract_GBelief.GTrue);} );
				
deed[ArrayList<Abstract_Deed> ds] returns [Abstract_Deed d] : (((PLUS (l=literal {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILBel, $l.l);} |
				SHRIEK g=goal {$d = new Abstract_Deed(Abstract_Deed.AILAddition, $g.g);} |
				LOCK {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dlock);}) |
			   MINUS (l=literal {$d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILBel, $l.l);} |
				SHRIEK g=goal {$d = new Abstract_Deed(Abstract_Deed.AILDeletion, $g.g);} |
				LOCK {$d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.Dlock);}
				)) |
				UPDATE (l=literal {$d = new Abstract_Deed(Abstract_Deed.AILUpdate, Abstract_Deed.AILBel, $l.l);}) |
				CALCULATE c=calculation[ds]  {$d = $c.d;}|
				QUERYCOM q=query[ds] {$d = $q.d;}	|
				WAIT w=wait[ds] {$d = $w.d;}	|
				a=action {$d = new Abstract_Deed($a.a);}) |
				wf=waitfor {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dwaitfor, $wf.wf);}
				)
				;
				
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
				
brule returns [Abstract_Rule r] : head=guard_atom (BRULEARROW f=logicalfmla {$r = new Abstract_Rule($head.g, $f.f);} SEMI | SEMI {$r = new Abstract_Rule($head.g);});

logicalfmla returns [Abstract_LogicalFormula f] : n=notfmla {$f = $n.f;}
               (COMMA (n2=notfmla {$f = new Abstract_LogExpr($n.f, Abstract_LogExpr.and, $n2.f);} | and=subfmla {$f = new Abstract_LogExpr($n.f, Abstract_LogExpr.and, $and.f);}))?; 
notfmla returns [Abstract_LogicalFormula f] : gb = guard_atom {$f = $gb.g;} | 
                                                                              NOT (gb2 = guard_atom {$f = new Abstract_LogExpr(Abstract_LogExpr.not, $gb2.g);} | lf = subfmla {$f = new Abstract_LogExpr(Abstract_LogExpr.not, $lf.f);});
subfmla returns [Abstract_LogicalFormula f] : SQOPEN lf = logicalfmla {$f = $lf.f;} SQCLOSE;
	
waitfor returns [Abstract_Literal wf] :  MULT l=literal {$wf = $l.l;};

action returns [Abstract_Action a] : 
	(a1=atom PLUS a2=atom EQ_ASSGN v=var {$a = new Abstract_Action("sum"); $a.addTerm($a1.t); $a.addTerm($a2.t); $a.addTerm($v.v); }) |
	(SEND OPEN an=literal COMMA p=performative COMMA t=pred CLOSE {$a = new Abstract_SendAction($an.l, $p.b, $t.t);}) | 
	t=pred {$a = new Abstract_Action($t.t, Abstract_Action.normalAction);};

performative returns [int b] : (TELL {$b=1;} | PERFORM {$b=2;} | ACHIEVE {$b = 3;});

UPDATE 	:	'±' ;
TELL	:	':tell';
PERFORM :	':perform';
ACHIEVE :	':achieve';
SEND	:	'.send';
RECEIVED:	'.received';
CALCULATE
	:	'.calculate';
QUERYCOM	:	'.query';
WAIT	:	'.wait';
BELIEVE	:	{curly_nesting > 0 && plain_nesting == 0 || belief_rules==1}?=> ('B' | '.B') ;
GOAL	:	{curly_nesting > 0 && plain_nesting == 0|| belief_rules==1}?=> ('G' | '.G') ;
SENT	:	{curly_nesting > 0 && plain_nesting == 0|| belief_rules==1}?=> '.sent';
LOCK	:	'.lock';
GOALS	:	':Initial Goals:' {belief_rules=0;};
BELIEFS	:	':Initial Beliefs:';
BELIEFRULES 
	:	':Belief Rules:' {belief_rules=1;};
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
term	returns [Abstract_Term t]:  a = atom {$t = $a.t;} | s = stringterm {$t = $s.s;} | f=function {$t = $f.f;};

atom	returns [Abstract_NumberTerm t]	:	n = numberstring {$t = new Abstract_NumberTermImpl($n.s);}| 
					v=var {$t = $v.v;} | OPEN a=arithexpr CLOSE {$t = $a.t;};
stringterm returns [Abstract_StringTerm s] : DOUBLEQUOTE  STRING DOUBLEQUOTE {$s = new Abstract_StringTermImpl($STRING.getText());};

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
