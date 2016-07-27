// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
// 
// This file is part of Gwendolen
//
// Gwendolen is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Gwendolen is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with Gwendolen if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

grammar ActionOnly;

options {
	k = 5;
	}

@header {
package actiononly.parser;

import ail.syntax.ast.*;
import actiononly.syntax.ast.*;
import java.util.HashMap;
}

@members {
	private static HashMap<String,Abstract_VarTerm> variables = new HashMap<String,Abstract_VarTerm>();
	private Abstract_StringTerm agentname = new Abstract_StringTermImpl("");
	}

@lexer::header {
package actiononly.parser;
}
	
@lexer::members {
    public int plain_nesting = 0;
    public int sq_nesting = 0;
    public int curly_nesting = 0;
    public boolean stringterm = false;
    public boolean ao = true;
    public int belief_rules = 0;
}

// Mas involving Gwendolen Agents
mas returns [Abstract_MAS mas] : {$mas = new Abstract_MAS();} 
	glist=aoagents {$mas.setAgs($glist.gags);};

aoagents returns[ArrayList<Abstract_ActionOnlyAgent> gags]: ACTIONONLY 
	{gags=new ArrayList<Abstract_ActionOnlyAgent>();} 
	(g=aoagent {gags.add($g.g);})+;

// Gwendolen Agent stuff
aoagent returns [Abstract_ActionOnlyAgent g] : 
        (ACTIONONLY?) 
	NAME w=word {try {$g = new Abstract_ActionOnlyAgent($w.s);} 
		catch (Exception e) {System.err.println(e); agentname = new Abstract_StringTermImpl($w.s);}}
	BELIEFS (l=literal {$g.addInitialBel($l.l);})*
	(BELIEFRULES (r=brule {$g.addRule($r.r);})*)?
	GOAL (l = literal {$g.addInitialGoal(new Abstract_Goal($l.l, Abstract_Goal.achieveGoal));})+
	ACTIONS (c = capability {$g.addCapability($c.c);})*;
	

guard_atom returns [Abstract_GLogicalFormula g] : (BELIEVE l=literal {$g = new Abstract_GBelief($l.l);} |
				eq = equation {$g = $eq.eq;} |
				TRUE {$g = new Abstract_GBelief();} );
				
brule returns [Abstract_Rule r] : head=pred (BRULEARROW f=logicalfmla {$r = new Abstract_Rule(head, $f.f);} SEMI | SEMI {$r = new Abstract_Rule(head);});

capability returns [Abstract_Capability c] : CURLYOPEN (f=clogicalfmla)? CURLYCLOSE a=action {$c = new Abstract_Capability($a.a); if ($f.f != null) {$c.addPre($f.f); $c.addPost(new Abstract_GBelief());}};

logicalfmla returns [Abstract_LogicalFormula f] : n=notfmla {$f = $n.f;}
               (COMMA n2=notfmla {$f = new Abstract_LogExpr($f, Abstract_LogExpr.and, $n2.f);})*;
               // | and=subfmla {$f = new Abstract_LogExpr($n.f, Abstract_LogExpr.and, $and.f);}))?; 
notfmla returns [Abstract_LogicalFormula f] : (gb = pred {$f = gb;} | SQOPEN eq = equation {$f = eq;} SQCLOSE) | 
                                                                              NOT (gb2 = pred {$f = new Abstract_LogExpr(Abstract_LogExpr.not, gb2);} | 
                                                                                SQOPEN eq = equation SQCLOSE {$f = new Abstract_LogExpr(Abstract_LogExpr.not, eq);} |
                                                                              	lf = subfmla {$f = new Abstract_LogExpr(Abstract_LogExpr.not, $lf.f);});
subfmla returns [Abstract_LogicalFormula f] : OPEN lf = logicalfmla {$f = $lf.f;} CLOSE;
	
clogicalfmla returns [Abstract_GLogicalFormula f] : n=cnotfmla {$f = $n.f;}
               (COMMA n2=cnotfmla {$f = new Abstract_Guard($f, Abstract_Guard.and, $n2.f);})*;
 cnotfmla returns [Abstract_GLogicalFormula f] : gb = pred {$f = new Abstract_GBelief(new Abstract_Literal(gb));} | 
                                                                              NOT (gb2 = pred {$f = new Abstract_Guard(Abstract_Guard.not, new Abstract_GBelief(new Abstract_Literal(gb2)));} | 
                                                                              lf = csubfmla {$f = new Abstract_Guard(Abstract_Guard.not, $lf.f);});
csubfmla returns [Abstract_GLogicalFormula f] : OPEN lf = clogicalfmla {$f = $lf.f;} CLOSE;



action returns [Abstract_Action a] : 
		t=pred {$a = new Abstract_Action($t.t, Abstract_Action.normalAction);};

ACTIONONLY	:{curly_nesting == 0}?=>'AO' {ao = true;};

BELIEFS	:	':Initial Beliefs:';
BELIEFRULES 
	:	':Reasoning Rules:' {belief_rules = 1;};
GOAL	:	':Initial Goal:';
NAME	:	':name:';

BELIEVE	:	{curly_nesting > 0 && plain_nesting == 0 || belief_rules==1}?=> ('B' | '.B') ;
BRULEARROW 
	:	':-';
ACTIONS	:	':Actions:';
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

pred 	returns [Abstract_Predicate t]:	v=var {$t = $v.v;}| f=function {$t = $f.f;};
function returns [Abstract_Predicate f]: CONST {$f = new Abstract_Predicate($CONST.getText());} (OPEN terms[$f] CLOSE)?;

terms[Abstract_Predicate f] : t=term {$f.addTerm($t.t);} (COMMA terms[$f])? ;
term	returns [Abstract_Term t]:  a = atom {$t = $a.t;} | s = stringterm {$t = $s.s;} | f=function {$t = $f.f;};

atom	returns [Abstract_NumberTerm t]	:	n = numberstring {$t = new Abstract_NumberTermImpl($n.s);}| 
					v=var {$t = $v.v;} | OPEN a=arithexpr CLOSE {$t = $a.t;};
stringterm returns [Abstract_StringTerm s] : DOUBLEQUOTE  STRING DOUBLEQUOTE {		 
                   $s = new Abstract_StringTermImpl($STRING.getText());};

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
