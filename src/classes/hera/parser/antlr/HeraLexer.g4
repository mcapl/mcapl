// ----------------------------------------------------------------------------
// Copyright (C) 2018 Louise A. Dennis, Felix Lindner, Martin Moze Bentzen, Michael Fisher
//
// This file is part of Juno
//
// Juno is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Juno is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

lexer grammar HeraLexer;

ATOM: 'Atom';
NOT: 'Not';
OR: 'Or';
AND: 'And';
IMPL: 'Impl';
AFFECTS: 'Affects';
AFFECTSPOS: 'AffectsPos';
AFFECTSNEG: 'AffectsNeg';
I: 'I';
GOAL: 'Goal';
MEANS: 'Means';
CAUSES: 'Causes';
PCAUSES: 'PCauses';
SCAUSES: 'SCauses';
EXPLAINS: 'Explains';
PREVENTS: 'Prevents';
INTERVENTION: 'Intervention';
EXISTS: 'Exists';
FORALL: 'Forall';
GT: 'Gt';
GEQ: 'Geq';
MUST: 'Must';
MAY: 'May';
K: 'K';
CONSEQUENCE: 'Consequence';

U: 'U';
DR: 'DR';
DB: 'DB';
MINUS: 'Minus';
SUB: 'Sub';
ADD: 'Add';

INT: ('0'..'9')+;
WORD:	('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'-')+;
QUOTE: '\'';
COMMA: ',';
OPEN: '(';
CLOSE: ')';

COMMENT : '/*' .*? '*/' -> skip ;
LINE_COMMENT : '//' ~[\n]* -> skip ;
NEWLINE:'\r'? '\n' -> skip  ;
WS  :   (' '|'\t') -> skip ;

