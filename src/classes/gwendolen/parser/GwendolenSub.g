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

grammar GwendolenSub;

@header {
package gwendolen.parser;

import ail.syntax.ast.*;
import gwendolen.syntax.ast.*;
import java.util.HashMap;
}

@members {
	private static HashMap<String,Abstract_VarTerm> variables = new HashMap<String,Abstract_VarTerm>();
    private boolean stringterm = false;
}

descriptions returns[ArrayList<Abstract_PredicateDescription> ds]: 
	{$ds=new ArrayList<Abstract_PredicateDescription>();} 
	(d=description {$ds.add($d.d);})+;
description returns [Abstract_PredicateDescription d] : f=function COLON s=stringterm {		 
                   $d = new Abstract_PredicateDescription($f.f,$s.s);};

function returns [Abstract_Predicate f]: CONST {$f = new Abstract_Predicate($CONST.getText());} (OPEN terms[$f] CLOSE)?;

terms[Abstract_Predicate f] : t=term {$f.addTerm($t.t);} (COMMA terms[$f])? ;
term	returns [Abstract_Term t]:  a = atom {$t = $a.t;} | 
	s = stringterm {$t = $s.s;} | 
	f=function {$t = $f.f;} |
	l = listterm {$t = $l.l;};

atom	returns [Abstract_NumberTerm t]	:	n = numberstring {$t = new Abstract_NumberTermImpl($n.s);}| 
					v=var {$t = $v.v;} | OPEN a=arithexpr CLOSE {$t = $a.t;};

stringterm returns [Abstract_StringTerm s] : DOUBLEQUOTE STRING DOUBLEQUOTE {		 
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

// General Lexing stuff
COMMENT
    : '/*' .*? '*/' -> channel(HIDDEN)
    ;
LINE_COMMENT
    : '//' ~('\n'|'\r')* '\r'? '\n' -> channel(HIDDEN)
    ;
NEWLINE:'\r'? '\n' {skip();} ;
WS  :  {!stringterm}?=>(' '|'\t')+ {skip();} ;

TRUE	:	'True';
OPEN	: 	'(';
CLOSE	:	')';
SQOPEN	:	'[';
SQCLOSE	:	']';
CURLYOPEN	: '{';
CURLYCLOSE	: '}';
DOUBLEQUOTE
		:	'"' {if (stringterm) {stringterm = false;} else {stringterm = true;}};
NOT		:	'~';

STRING	:	{stringterm}?=> ~[\r\n"]*;
CONST 	: 	{!stringterm}?=>'a'..'z' ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
VAR		:	{!stringterm}?=>'A'..'Z' ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
NUMBER	:	{!stringterm}?=>'0'..'9' ('0'..'9')*;
UNNAMEDVAR
		:	{!stringterm}?=>'_';

LESS	:	'<';
EQ		: 	'==';
POINT	:	{!stringterm}?=>'.';
MULT	:	'*';
PLUS	:	'+';
MINUS	:	'-';
DIV		:	'/';
MOD		:	'%';

SHRIEK	:	'!';
COMMA	:	',';
SEMI	:	';';
COLON	:	':';
QUERY	:	'?';
BAR		:	'|';
