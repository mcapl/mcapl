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

