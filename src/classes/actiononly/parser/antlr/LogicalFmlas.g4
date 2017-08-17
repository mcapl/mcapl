// ----------------------------------------------------------------------------
// Copyright (C) 2008-2017 Louise A. Dennis, and Michael Fisher and 
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

grammar LogicalFmlas;

rulelist: prolog_rule (rulelist )?;
rulelist_poss_empty: (rulelist)?;
prolog_rule  : head=pred (RULEARROW f=logicalfmla SEMI | 
	SEMI );
logicalfmla : n=notfmla (COMMA n2=notfmla )*?;
               // | and=subfmla {$f = new Abstract_LogExpr($n.f, Abstract_LogExpr.and, $and.f);}))?; 
notfmla  : (gb = pred | SQOPEN eq = equation SQCLOSE) | 
            NOT (gb2 = pred  | SQOPEN eq2 = equation SQCLOSE  | lf = subfmla );
subfmla  : OPEN lf = logicalfmla CLOSE;

litlist :  literal (litlist)?;
litlist_poss_empty: litlist?;
literal	:  (TRUE  | NOT pred | pred);

pred	:  v=var | f=function;
function: CONST (OPEN terms CLOSE)?;

terms	: t=term (COMMA terms)? ;
term	: a = atom | s = stringterm | f=function;

atom	: n = numberstring | v=var | OPEN a=arithexpr CLOSE;
stringterm : QUOTED_STRING ; 

var 	:	VAR;

numberstring :	(MINUS)? (n1=NUMBER (POINT n2=NUMBER)?);
equation	: a1=arithexpr oper=eqoper a2=arithexpr; 
eqoper		: LESS | EQ ;

arithexpr	: m1=multexpr (addoper m2=multexpr)?;
multexpr	: a1=atom (multoper a2=atom)?; 

addoper	 	: (PLUS | MINUS ); 
multoper  	: (MULT  | DIV  | MOD );

// General AIL Lexing stuff
COMMENT
    : '/*' .*? '*/' -> skip ;
LINE_COMMENT
    : '//' ~[\n]* -> skip ;
NEWLINE:'\r'? '\n' -> skip  ;
WS  :   (' '|'\t')+ -> skip ;


OPEN	: 	'('; 
CLOSE	:	')'; 
SQOPEN	:	'['; 
SQCLOSE	:	']';
CURLYOPEN	: '{';
CURLYCLOSE	: '}';
//DOUBLEQUOTE
//	:	'"' {if (stringterm) {stringterm = false;} else {stringterm = true;}};
QUOTED_STRING: '"' .*? '"';
NOT	:	'~';
TRUE: 	'True';

// STRING	:	{stringterm}? ('a'..'z'|'A'..'Z'|'0'..'9'|'_')+;
CONST 	: 	'a'..'z' ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
VAR	:	 'A'..'Z' ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
NUMBER	:	 '0'..'9' ('0'..'9')*;

RULEARROW :	':-';

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
