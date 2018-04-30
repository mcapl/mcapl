// ----------------------------------------------------------------------------
// Copyright (C) 2008-2018 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
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

lexer grammar GwendolenLexer;

@lexer::members {
    public int plain_nesting = 0;
    public int sq_nesting = 0;
    public int curly_nesting = 0;
//    public boolean stringterm = false;
//    public boolean gwendolen = true;
//    public int belief_rules = 0;
}	

GWENDOLEN	:'GWENDOLEN';

// Top Level sections
GOALS		:	':Initial Goals:';
BELIEFS		:	':Initial Beliefs:';
BELIEFRULES :	':Reasoning Rules:' ;
PLANS		:	':Plans:';
NAME		:	':name:';

// Deeds
SEND		:	'.send';
LOCK		:	'.lock';
ADD_PLAN	:	'.plan';
// ADD_CONSTRAINT	: '.constraint';
// ADD_CONTENT	:	'.n';
// ADD_CONTEXT	:	'.x';

TELL		:	':tell';
PERFORM 	:	':perform';
ACHIEVE 	:	':achieve';
// TELLHOW	:	':how';
//CONSTRAINT :	':constrain';

// Goals
ACHIEVEGOAL	: {sq_nesting > 0}? 'achieve';
PERFORMGOAL	:  {sq_nesting > 0}? 'perform';

// Rules
BRULEARROW 	:	':-';
RULEARROW 	:	'<-';

// Plan Guards
NOT			:	'~';
TRUE		:	'True';
RECEIVED	:   '.received';
BELIEVE		:	 {curly_nesting > 0 && plain_nesting == 0}? ('B' | '.B') ;
GOAL		:	{curly_nesting > 0 && plain_nesting == 0}? ('G' | '.G') ;
// IN_CONTENT	:	{curly_nesting > 0 && plain_nesting == 0}?=> ('N') ;
// IN_CONTEXT	:	{curly_nesting > 0 && plain_nesting == 0}?=> ('X') ;
SENT		:	 '.sent';


// General AIL Lexing stuff
CONST	:	('a'..'z'|'A'..'Z'|'0'..'9'|'_')+;
QUOTED_STRING: ('"' .*? '"' | '\'' .*? '\'');

OPEN	: 	'(' {plain_nesting++;};
CLOSE	:	')' {plain_nesting--;};
CURLYOPEN:  '{' {curly_nesting++;};
CURLYCLOSE: '}' {curly_nesting--;};
SQOPEN: '[' {sq_nesting++;};
SQCLOSE: ']'{sq_nesting--;};

COMMASEP	:	',' ;
IDPUNCT:	'.';
BAR: '|';

// LESS	:	'<';
// EQ	: 	'==';
SEMI	:	';';
COLON	:	':';
QUERY	:	'?';
MULT	:	'*';
PLUS	:	'+';
MINUS	:	'-';
SHRIEK	:	'!';
// DIV	:	'/';
// MOD	:	'%';

COMMENT		: '/*' .*? '*/' -> skip;
LINE_COMMENT	: '//' ~('\n'|'\r')* '\r'? '\n' -> skip;
NEWLINE		:'\r'? '\n' -> skip;
WS  			: (' '|'\t')+ -> skip ;


