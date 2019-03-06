lexer grammar JunoLexer;

COMMENT : '/*' .*? '*/' -> skip ;
LINE_COMMENT : '//' ~[\n]* -> skip ;
NEWLINE:'\r'? '\n' -> skip  ;
WS  :   (' '|'\t') -> skip ;

CURLYOPEN	: '{';
CURLYCLOSE	: '}';
OPEN	: '(';
CLOSE	:	')';

ADD: '+';
DEL: '-';
ARROW: '<-';
COMMA: ',';

CONST	:	('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'<')+;
FILE_BLOCK: ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'/'|'.')+;