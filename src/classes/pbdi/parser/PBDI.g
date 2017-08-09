grammar PBDI;

@header {
package pbdi.parser;

}

pythonfunction 
	:	DEF string OPEN CLOSE COLON
	
OPEN	:	'('
CLOSE	:	')'
DEF	:	'def'
STRING	:	('a'..'z'|'A'..'Z'|'0'..'9'|'_'|' '|'.')+;
COLON	: 	':'


COMMENT
    :   '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    |   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

