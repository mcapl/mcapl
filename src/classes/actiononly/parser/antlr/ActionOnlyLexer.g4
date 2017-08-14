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
// import LogicalFmlas;

ACTIONONLY	: 'AO'; // {curly_nesting == 0}? 'AO' {ao = true;};

BELIEFS	:	':Initial Beliefs:';
BELIEFRULES 
	:	':Reasoning Rules:'; // {belief_rules = 1;};
GOAL	:	':Initial Goal:';
NAME	:	':name:';

BELIEVE	:	('B' | '.B') ; // {curly_nesting > 0 && plain_nesting == 0 || belief_rules==1}? ('B' | '.B') ;
ACTIONS	:	':Actions:';

FOF_BLOCK: .*?;
PRED_BLOCK: .*?;

CURLYOPEN	: '{';
CURLYCLOSE	: '}';
POINT	:	'.';
WORD:	('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
