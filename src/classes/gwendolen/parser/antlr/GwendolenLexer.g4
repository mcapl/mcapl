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




GWENDOLEN	:'GWENDOLEN' ;

BELIEFS	:	':Initial Beliefs:' -> mode(INITIAL_BELIEFS);
NAME	:	':name:';

COMMENT : '/*' .*? '*/' -> skip ;
LINE_COMMENT : '//' ~[\n]* -> skip ;
NEWLINE:'\r'? '\n' -> skip  ;
WS  :   (' '|'\t') -> skip ;

mode INITIAL_BELIEFS;
BELIEFRULES : ':Reasoning Rules:' -> mode(REASONING_RULES); 
GOAL_IB	:	':Initial Goals:' -> mode(GOALS);
IB_COMMENT : '/*' .*? '*/' -> skip ;
IB_LINE_COMMENT : '//' ~[\n]* -> skip ;
IB_NEWLINE:'\r'? '\n' ;
IB_WS  :   (' '|'\t') -> skip ;
BELIEF_BLOCK: ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'('|')'|','|'.'|' ')+;

mode REASONING_RULES;
GOAL_RR	:	':Initial Goals:' -> mode(GOALS);
RR_COMMENT : '/*' .*? '*/' -> skip ;
RR_LINE_COMMENT : '//' ~[\n]* -> skip ;
RR_NEWLINE:'\r'? '\n'   ;
RR_WS  :   (' '|'\t') -> skip ;
RR_BLOCK: ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'('|')'|','|':-'|' ')+;

mode GOALS;
PLANS	:	':Plans:' -> mode(PLANS_MODE);
GL_COMMENT : '/*' .*? '*/' -> skip ;
GL_LINE_COMMENT : '//' ~[\n]* -> skip ;
GL_NEWLINE:'\r'? '\n';
GL_WS  :   (' '|'\t') -> skip ;
GOAL_BLOCK: ('a'..'z'|'A'..'Z'|'0'..'9'|'_')+;
ACHIEVEGOAL	: 'achieve';
PERFORMGOAL	:  'perform';
SQOPEN : '[';
SQCLOSE : ']';

mode PLANS_MODE;
SEND	:	'.send';
RECEIVED:	'.received';
BELIEVE	:	('B' | '.B') ;
GOAL	:	 ('G' | '.G') ;
IN_CONTENT	:	('N') ;
IN_CONTEXT	:	('X') ;
SENT	:	 '.sent';
LOCK	:	'.lock';
ADD_PLAN	:	'.plan';
ADD_CONSTRAINT	: '.constraint';
ADD_CONTENT
	:	'.n';
ADD_CONTEXT	:	'.x';

ACHIEVEGOAL_PL	: 'achieve';
PERFORMGOAL_PL	:  'perform';
SQOPEN_PL : '[';
SQCLOSE_PL : ']';

TELL	:	':tell';
PERFORM :	':perform';
ACHIEVE :	':achieve';
TELLHOW	:	':how';
CONSTRAINT 
	:	':constrain';

RULEARROW :	'<-';

TRUE	:	 'True';





