// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
// 
// This file is part of GOAL (AIL version) - GOAL-AIL
//
// GOAL-AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// GOAL-AIL is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with GOAL-AIL if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

grammar GOAL;


@header {
package goal.parser;

import ail.syntax.ast.*;
import goal.syntax.ast.*;
import java.util.HashMap;
}

@lexer::header {
package goal.parser;
}

@members {
	private static HashMap<String,Abstract_VarTerm> variables = new HashMap<String,Abstract_VarTerm>();
	private String name = "";
}

@lexer::members {
    public int plain_nesting = 0;
    public int sq_nesting = 0;
    public int curly_nesting = 0;
    public boolean stringterm = false;
    public boolean preconditiontypemode = false;
    public boolean condaction = false;
    public boolean actionspec = false;
    public boolean start = true;
    public int commacount = 0;
}

// Mas involving GOAL and OOPL Agents
mas returns [Abstract_MAS mas] : {$mas = new Abstract_MAS();} 
	glist=goalagents {$mas.setAgs($glist.gags);};

goalagents returns[ArrayList<Abstract_GOALAgent> gags]: GOAL {gags=new ArrayList<Abstract_GOALAgent>();} 
	(g=goalagent {gags.add($g.g);})+;
                                                                                                                                                                           
brule returns [Abstract_Rule r]: head=literal BRULEARROW gb=fmla {$r = new Abstract_Rule(new Abstract_GBelief(Abstract_GBelief.AILBel, $head.l), $gb.f);} ;
	
fmla returns [Abstract_LogicalFormula f] : gb = literal {$f = new Abstract_GBelief(Abstract_GBelief.AILBel, $gb.l);} 
	(COMMA and=fmla {$f = new Abstract_LogExpr(new Abstract_GBelief(Abstract_GBelief.AILBel, $gb.l), Abstract_LogExpr.and, $and.f);}
	 |
	(SEMI and=fmla {$f = new Abstract_LogExpr(new Abstract_GBelief(Abstract_GBelief.AILBel, $gb.l), Abstract_LogExpr.or, $and.f);}))*;

// GOAL Agent stuff
goalagent returns [Abstract_GOALAgent g] : NAME w=word {name = $w.s;}
		{try {$g = new Abstract_GOALAgent($w.s);} catch (Exception e) {System.err.println(e);}}
	BELIEFS (l=literal {$g.addInitialBel($l.l);})*
	BRULES (r=brule {$g.addRule($r.r);})*
	GOALS ({Abstract_StringTerm zero = new Abstract_StringTermImpl("");} l1=literal {$g.addGoal($l1.l, new Abstract_StringTermImpl(""));})*
	CONDACTIONS (ca=condaction {try {$g.addPlan($ca.cact);} catch (Exception e) {System.err.println(e);}})*
	CAPABILITIES (cap=capability {try {$g.addPlan($cap.c);} catch (Exception e) {System.err.println(e);}})*;
	
goal[Abstract_StringTerm i] returns [Abstract_Goal g] :  l=literal {Abstract_Literal l1 = $l.l;} 
	(AND l2=literal {Abstract_Literal l3 = new Abstract_Literal("and"); l3.addTerm(l1); l3.addTerm($l2.l); l1 = l3;})* 
	{$g = new Abstract_Goal(l1, Abstract_Goal.achieveGoal); $g.setGoalBase(i);};

capability returns [Abstract_ActionSpec c]
	: g=capname {ArrayList<Abstract_Deed> deeds=new ArrayList<Abstract_Deed>();} 
	 CURLYOPEN ms = precondition CURLYCLOSE
	 CURLYOPEN postcondition[deeds] CURLYCLOSE {$c = new Abstract_ActionSpec($g.g, $ms.ms, deeds); variables.clear();};
	
condaction returns [Abstract_ActionRule cact]
	: IF	ms=precondition THEN {ArrayList<Abstract_Deed> deeds = new ArrayList<Abstract_Deed>();} ca=capostcondition[deeds]  {$cact = new Abstract_ActionRule(ms, deeds); $cact.reverseBody(); variables.clear();};

capostcondition[ArrayList<Abstract_Deed> deeds]
	: {Abstract_StringTerm s1 = new Abstract_StringTermImpl("");} 
	(INS OPEN (s2=dbnumb COMMA {s1 = $s2.i;})? l=literal CLOSE {Abstract_Deed d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILBel, l); d.setDBnum(s1); deeds.add(d);} |
	  DEL  OPEN (s2=dbnumb COMMA {s1 = $s2.i;})? l=literal CLOSE {Abstract_Deed d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILBel, l); d.setDBnum(s1); deeds.add(d);} |
	  ADOPT  OPEN (s2=dbnumb COMMA {s1 = $s2.i;})? g=goal[s1] CLOSE {deeds.add(new Abstract_Deed(Abstract_Deed.AILAddition, $g.g));} |
	  DROP  OPEN (s2=dbnumb COMMA {s1 = $s2.i;})? g=goal[s1] CLOSE {deeds.add(new Abstract_Deed(Abstract_Deed.AILDeletion, $g.g));} |
	  CONTENT OPEN l=literal CLOSE {deeds.add(new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILContent, $l.l));} |
	  CONTEXT OPEN l=literal CLOSE {deeds.add(new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILContext, $l.l));} |
	  SEND OPEN st=conv_id ':' {ArrayList<Abstract_Term> rs = new ArrayList<Abstract_Term>(); int ilf = 0;} 
	  	SQOPEN (i=dbnumb {rs.add($i.i);})+ SQCLOSE COMMA
	  	(MULT {ilf = 4;} | MOD {ilf = 5;} | QUERY {ilf = 3;} | SHRIEK {ilf = 2;} | POINT {ilf = 1;}) t=literal 
	  	{deeds.add(new Abstract_Deed(new Abstract_BroadcastSendAction(rs, ilf, $t.l, $st.s)));} 
	  	(COMMA (QUERY {ilf = 3;} | SHRIEK {ilf = 2;} | POINT {ilf = 1;}) t1=literal
	  	{deeds.add(new Abstract_Deed(new Abstract_BroadcastSendAction(rs, ilf, $t1.l, $st.s)));})*
	  	CLOSE |
	  CLOSEKEY OPEN s=conv_id CLOSE {Abstract_Predicate cl=new Abstract_Predicate("close"); cl.addTerm($s.s); deeds.add(new Abstract_Deed(new Abstract_Action(cl, 0)));} |
	  gl=capname {deeds.add(new Abstract_Deed(Abstract_Deed.AILAddition, $gl.g));}
	) (COMMA capostcondition[deeds])*;
	
conv_id returns [Abstract_StringTerm s]: v=var {$s = $v.v;} | CONST {$s = new Abstract_StringTermImpl($CONST.getText());};

dbnumb returns [Abstract_StringTerm i] : 
		(CONST {$i = new Abstract_StringTermImpl($CONST.getText());} | 
				v=var {$i = $v.v;});

capname returns [Abstract_Goal g] : l=literal {$g = new Abstract_Goal($l.l, Abstract_Goal.performGoal);};

//action returns [Action a] :  t=term {$a = new Action($t.t, Action.normalAction);};

precondition returns [Abstract_MentalState ms]
	: ( {boolean negflag=false;} (NOT {negflag = true;})?
	(TRUE {$ms = new Abstract_MentalState(new Abstract_GBelief(Abstract_GBelief.GTrue));}| 
	BELIEVE {Abstract_StringTerm i = new Abstract_StringTermImpl("");} ( NUMMARKER i1=dbnumb {i = $i1.i;})? l=literal {$ms = new Abstract_MentalState(i, new Abstract_GBelief(Abstract_GBelief.AILBel, $l.l)); 
	                                  if (negflag) {$ms = new Abstract_MentalState($ms);}} | 
	HAVEGOAL {Abstract_StringTerm i = new Abstract_StringTermImpl("");} (NUMMARKER i1=dbnumb {i = $i1.i;})? g=goal[i] 
			{$ms = new Abstract_MentalState($g.g); if (negflag) {$ms = new Abstract_MentalState($ms);}} |
	IN_CONTENT  NUMMARKER i1=dbnumb {$ms = new Abstract_MentalState(new Abstract_GBelief(Abstract_GBelief.AILContent, $i1.i)); if (negflag) {$ms = new Abstract_MentalState($ms);}} |
	IN_CONTEXT  NUMMARKER i1=dbnumb {$ms = new Abstract_MentalState(new Abstract_GBelief(Abstract_GBelief.AILContext, $i1.i)); if (negflag) {$ms = new Abstract_MentalState($ms);}}
			)) 
	(COMMA ms1=precondition {Abstract_MentalState mstmp = $ms; $ms = new Abstract_MentalState(mstmp, $ms1.ms);})*;

postcondition[ArrayList<Abstract_Deed> deeds]
	:	l=literal {boolean flag = !$l.l.negated(); int intflag; if (flag) {intflag = 0;} else {intflag = 1;}; $l.l.setNegated(true); 
	                   deeds.add(0, new Abstract_Deed(intflag, Abstract_Deed.AILBel, l));} (COMMA postcondition[deeds])*;

GOALS	:	':goals';
BELIEFS	:	':beliefs';
CAPABILITIES
	:	':Action Specifications:' {actionspec=true; condaction=false;};
CONDACTIONS : ':Conditional Actions:' {condaction=true;};
GOAL	:	{start}?=> 'GOAL' {start = false;};
NAME	:	':name:' {actionspec=false;};
AGNAME	:	':me';
TRUE	:	'True';
IF	:	{condaction}?=> 'if' {preconditiontypemode = true;};
THEN	:	{condaction}?=> 'then'{preconditiontypemode = false;};
BELIEVE :	{(preconditiontypemode && plain_nesting == 0) || (actionspec && curly_nesting > 0 && plain_nesting == 0)}?=> 'B';
HAVEGOAL 
	:	{(preconditiontypemode && plain_nesting == 0) || (actionspec && curly_nesting > 0 && plain_nesting == 0)}?=> 'G';
IN_CONTENT 
	:	{(preconditiontypemode && plain_nesting == 0) || (actionspec && curly_nesting > 0 && plain_nesting == 0)}?=> 'N';
IN_CONTEXT 
	:	{(preconditiontypemode && plain_nesting == 0) || (actionspec && curly_nesting > 0 && plain_nesting == 0)}?=> 'X';
AND	: 	'&';
NUMMARKER
	:	'_';
BRULEARROW	: ':-';
BRULES 	:	':Belief Rules:';
DEL	:	{(condaction==true && preconditiontypemode==false && plain_nesting==0)}?=> 'del';
ADOPT	:	{(condaction==true && preconditiontypemode==false && plain_nesting==0)}?=>'adopt';
CLOSEKEY	:	{(condaction==true && preconditiontypemode==false && plain_nesting==0)}?=>'close';
SEND	:	{(condaction==true && preconditiontypemode==false && plain_nesting==0)}?=>'send';
DROP	:	{(condaction==true && preconditiontypemode==false && plain_nesting==0)}?=>'drop';
INS	:	{(condaction==true && preconditiontypemode==false && plain_nesting==0)}?=>'ins';
CONTENT	:	{(condaction==true && preconditiontypemode==false && plain_nesting==0)}?=>'nt';
CONTEXT	:	{(condaction==true && preconditiontypemode==false && plain_nesting==0)}?=>'xt';

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
term	returns [Abstract_Term t]:  a = atom {$t = $a.t;} | s = stringterm {$t = $s.s;} | f=function {$t = $f.f;} | AGNAME {$t = new Abstract_Predicate(name);};

atom	returns [Abstract_NumberTerm t]	:	n = numberstring {$t = new Abstract_NumberTermImpl($n.s);}| 
					v=var {$t = $v.v;} | OPEN a=arithexpr CLOSE {$t = $a.t;};
stringterm returns [Abstract_StringTerm s] : DOUBLEQUOTE  STRING DOUBLEQUOTE {$s = new Abstract_StringTermImpl($STRING.getText());};

var 	returns [Abstract_VarTerm v]:	(VAR {
	if (variables.containsKey($VAR.getText())) {
		$v = variables.get($VAR.getText());
		} else {
		$v = new Abstract_VarTerm($VAR.getText());
		variables.put($VAR.getText(), $v);
		}
	} | ANON_VAR {$v = new Abstract_UnnamedVar();});

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
ANON_VAR	:	{!stringterm}?=>'_';


LESS	:	'<';
EQ	: 	'==';
POINT	:	'.';
MULT	:	'*';
PLUS	:	'+';
MINUS	:	'-';
DIV	:	'/';
MOD	:	'%';

SHRIEK	:	'!';
COMMA	:	',' {commacount++;};
SEMI	:	';';
COLON	:	':';
QUERY	:	'?';
