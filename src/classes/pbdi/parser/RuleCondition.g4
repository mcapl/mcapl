// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis and Michael Fisher
//
// This file is part of the Python BDI Agent Model (PBDI) Library.
// 
// The PBDI Library is free software; you can redistribute it and/or
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


grammar RuleCondition;

rule_condition: dot_expr DOT BELIEVE OPEN_BRACKET SINGLE_QUOTE WORD SINGLE_QUOTE CLOSE_BRACKET SEMI;
dot_expr: WORD (DOT WORD)*;

WS  :   (' '|'\t')+ -> skip ;

BELIEVE: 'believe';
WORD: ('a'..'z'|'A'..'Z'|'0'..'9'|'_')+;
SINGLE_QUOTE: '\'';
OPEN_BRACKET: '(';
CLOSE_BRACKET: ')';
DOT: '.';
SEMI: ';';