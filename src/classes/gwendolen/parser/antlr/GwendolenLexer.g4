// ----------------------------------------------------------------------------
// Copyright (C) 2022 Louise A. Dennis
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

lexer grammar GwendolenLexer;

@lexer::members {
    public int plain_nesting = 0;
    public int sq_nesting = 0;
    public int curly_nesting = 0;
}


GWENDOLEN	:'GWENDOLEN' ;

NAME	:	':name:';
CONST	:	('a'..'z'|'A'..'Z'|'0'..'9'|'_')+;

COMMENT : '/*' .*? '*/' -> skip ;
LINE_COMMENT : '//' ~[\n]* -> skip ;
NEWLINE:'\r'? '\n' -> skip  ;
WS  :   (' '|'\t') -> skip ;

BELIEFS	:	':Initial Beliefs:' -> mode(INITIAL_BELIEFS);

mode INITIAL_BELIEFS;
BELIEFRULES : ':Reasoning Rules:' -> mode(REASONING_RULES); 
GOAL_IB	:	':Initial Goals:' -> mode(GOALS);
CAP_IB: 'Capabilities:' -> mode(CAPABILITIES);
IB_COMMENT : '/*' .*? '*/' -> skip ;
IB_LINE_COMMENT : '//' ~[\n]* -> skip ;
IB_NEWLINE:'\r'? '\n' -> skip;
IB_WS  :   (' '|'\t') -> skip ;
BELIEF_BLOCK: ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'('|')'|','|'.'|' '|'\t'|'\n'|'\r'|'-'|'['|']'|'|'|'"')+;

mode REASONING_RULES;
GOAL_RR	:	':Initial Goals:' -> mode(GOALS);
CAP_RR: 'Capabilities:' -> mode(CAPABILITIES);
RR_COMMENT : '/*' .*? '*/' -> skip ;
RR_LINE_COMMENT : '//' ~[\n]* -> skip ;
RR_NEWLINE:'\r'? '\n'   ;
RR_WS  :   (' '|'\t') -> skip ;
RR_BLOCK: ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'('|')'|','|':-'|' '|'\t'|'\n'|'\r'|';'|'~'|'['|']'|'|'|'!'|'<')+ ;

mode CAPABILITIES;
GOAL_C: 'Initial Goals:' -> mode(GOALS);
CAP_COMMENT : '/*' .*? '*/' -> skip ;
CAP_LINE_COMMENT : '//' ~[\n]* -> skip ;
CAP_NEWLINE:'\r'? '\n'   ;
CAP_WS  :   (' '|'\t') -> skip ;
CAP_CURLYOPEN	: '{' {curly_nesting++;};
CAP_CURLYCLOSE	: '}' {curly_nesting--;};
CAP_BLOCK: ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'('|')'|','|':-'|' '|'\t'|'\n'|'\r'|';'|'~'|'['|']'|'|'|'!')+ ;

mode GOALS;
PLANS	:	':Plans:' -> mode(PLANS_MODE);
GL_COMMENT : '/*' .*? '*/' -> skip ;
GL_LINE_COMMENT : '//' ~[\n]* -> skip ;
GL_NEWLINE:'\r'? '\n' -> skip ;
GL_WS  :   (' '|'\t') -> skip ;
GL_ACHIEVEGOAL	:  {sq_nesting > 0}? 'achieve';
GL_PERFORMGOAL	:   {sq_nesting > 0}? 'perform';
GL_SQOPEN : '[' {sq_nesting++;};
GL_SQCLOSE : ']'{sq_nesting--;};
GOAL_BLOCK: ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'('|')'|','|'.'|' ')+;

mode PLANS_MODE;
NAME_PM : ':name:' -> mode(DEFAULT_MODE);
PL_COMMENT : '/*' .*? '*/' -> skip ;
PL_LINE_COMMENT : '//' ~[\n]* -> skip ;
PL_NEWLINE:'\r'? '\n' -> skip ;
PL_WS  :   (' '|'\t') -> channel(HIDDEN) ;
SEND	:	'.send';
RECEIVED: '.received';
BELIEVE	:	{curly_nesting > 0}? ('B' | '.B') ;
GOAL	:	{curly_nesting > 0}?  ('G' | '.G') ;
SENT	:	 '.sent';
LOCK	:	'.lock';
//CALCULATE :	'.calculate';
QUERYCOM	:	'.query';
//WAIT	:	'.wait';
//SUBSTITUTE	:	'.substitute';

// ADD_PLAN	:	'.plan';

PL_ACHIEVEGOAL	: 'achieve';
PL_PERFORMGOAL	:  'perform';
PL_SQOPEN : '[';
PL_SQCLOSE : ']';
PL_BAR : '|';
NOT	:	'~';
COLON	:	':';
CURLYOPEN	: '{' {curly_nesting++;};
CURLYCLOSE	: '}' {curly_nesting--;};
COMMA	:	',';
SEMI	:	';';


TELL	:	':tell';

SHRIEK	:	'!';
OPEN	: 	'(' {plain_nesting++;};
CLOSE	:	')' {plain_nesting--;};
MULT	:	'*';
PLUS	:	'+';
MINUS	:	'-';
LESS	:	'<';
EQUAL	:	'==';
IDPUNCT : 	'.';


RULEARROW :	'<-';

TRUE		:	 'True';
PL_CONST	:	('a'..'z')('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'.')*;
PL_VAR		:	('A'..'Z'|'_')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
NUMBER 		: 	('0'..'9')('0'..'9'|'.')*;

QUOTED_STRING: ('"' .*? '"' | '\'' .*? '\'');


