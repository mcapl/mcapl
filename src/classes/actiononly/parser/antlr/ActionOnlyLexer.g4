// ----------------------------------------------------------------------------
// Copyright (C) 2014-2017 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of the Agent Infrastructure Layer (AIL)
// 
// The AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The AIL is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

lexer grammar ActionOnlyLexer;

ACTIONONLY	: 'AO'; 

BELIEFS	:	':Initial Beliefs:' -> mode(INITIAL_BELIEFS);
NAME	:	':name:';
WORD:	('a'..'z'|'A'..'Z'|'0'..'9'|'_')+;

COMMENT : '/*' .*? '*/' -> skip ;
LINE_COMMENT : '//' ~[\n]* -> skip ;
NEWLINE:'\r'? '\n' -> skip  ;
WS  :   (' '|'\t') -> skip ;

mode INITIAL_BELIEFS;
BELIEFRULES : ':Reasoning Rules:' -> mode(REASONING_RULES); 
GOAL_IB	:	':Initial Goal:' -> mode(GOALS);
IB_COMMENT : '/*' .*? '*/' -> skip ;
IB_LINE_COMMENT : '//' ~[\n]* -> skip ;
IB_NEWLINE:'\r'? '\n' ;
IB_WS  :   (' '|'\t') -> skip ;
BELIEF_BLOCK: ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'('|')'|','|'.'|' ')+;

mode REASONING_RULES;
GOAL_RR	:	':Initial Goal:' -> mode(GOALS);
RR_COMMENT : '/*' .*? '*/' -> skip ;
RR_LINE_COMMENT : '//' ~[\n]* -> skip ;
RR_NEWLINE:'\r'? '\n'   ;
RR_WS  :   (' '|'\t') -> skip ;
RR_BLOCK: ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'('|')'|','|':-'|' ')+;

mode GOALS;
ACTIONS	:	':Actions:' -> mode(ACTIONS_MODE);
GL_COMMENT : '/*' .*? '*/' -> skip ;
GL_LINE_COMMENT : '//' ~[\n]* -> skip ;
GL_NEWLINE:'\r'? '\n';
GL_WS  :   (' '|'\t') -> skip ;
GOAL_BLOCK: ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'('|')'|','|'.'|' ')+;

mode ACTIONS_MODE;
CURLYOPEN	: '{';
CURLYCLOSE	: '}';
A_COMMENT : '/*' .*? '*/' -> skip ;
A_LINE_COMMENT : '//' ~[\n]* -> skip ;
A_NEWLINE:'\r'? '\n' -> skip  ;
A_WS  :   (' '|'\t') -> skip ;
ACTION_BLOCK: ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'('|')'|','|'.'|' ')+;



