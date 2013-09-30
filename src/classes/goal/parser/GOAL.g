// ----------------------------------------------------------------------------
// Copyright (C) 2013 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of GOAL (AIL version) - GOAL-AIL
// 
// GOAL-AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// GOAL-AIL is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with GOAL-AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

grammar GOAL;


@header {
package goal.parser;

import ail.syntax.ast.*;
import goal.syntax.ast.*;
import java.util.HashMap;
}

@lexer::header {
package goal.parser;
}

@members {
	private static HashMap<String,Abstract_VarTerm> variables = new HashMap<String,Abstract_VarTerm>();
	private String name = "";
}

@lexer::members {
}

// GOAL Grammar from Programming Rational Agents in GOAL by Koen Hindriks.
program returns [Abstract_MAS mas]	:  {$mas = new Abstract_MAS(); ArrayList<Abstract_GOALAgent> agents = new ArrayList<Abstract_GOALAgent>();}   
	                 MAIN COLON i=id CURLYOPEN 
		{ Abstract_GOALAgent gl = new Abstract_GOALAgent($i.s); agents.add(gl);}
  	                (KNOWLEDGE CURLYOPEN krspec[$gl] CURLYCLOSE)?
                                        (BELIEFS CURLYOPEN brspec[$gl] CURLYCLOSE)?
                                        (GOALS CURLYOPEN poslitconj* CURLYCLOSE)?
                                         MAIN MODULE CURLYOPEN module CURLYCLOSE
                                         (EVENT MODULE CURLYOPEN module CURLYCLOSE)?
                                         (ACTIONSPEC CURLYOPEN actionspec+ CURLYCLOSE)?
                                              
                                         CURLYCLOSE
                                              {mas.setAgs(agents);};
                                   
module	: (KNOWLEDGE CURLYOPEN krspec CURLYCLOSE)?
                             (GOALS CURLYOPEN poslitconj* CURLYCLOSE)?
                             PROGRAM (optionorder)? CURLYOPEN
                                 macro*
                                 actionrule+
                             CURLYCLOSE
                             (ACTIONSPEC CURLYOPEN actionspec+ CURLYCLOSE)?;
                             
krspec[Abstract_GOALAgent gl]:  (hd=atom (STOP {gl.addFact($hd.l);} | PROLOGARROW body=litconj STOP {gl.addKRule($hd.l, $body.f)}))+;
    
brspec[Abstract_GOALAgent gl]:  (hd=atom (STOP {gl.addBel($hd.l);} | PROLOGARROW body=litconj STOP {gl.addRule($hd.l,$body.f)}))+;
                                     
poslitconj	: atom (COMMA atom)* STOP;

litconj returns [Abstract_LogicalFormula f]: $l=literal (COMMA $l1=literal {$l = new Abstract_LogExpr($l.l, Abstract_LogExpr.and, $l1.l);})* ;

literal returns[Abstract_Literal l] : atom | NOT OPEN atom CLOSE;

atom	: (id ( parameters)? | equation);

parameters	: OPEN term (COMMA term)* CLOSE;	

optionorder	: SQOPEN ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL ) SQCLOSE;

macro	: HASH DEFINE id parameters mentalstatecond STOP;

actionrule   	: IF (mentalstatecond | id parameters) THEN actioncombo STOP;	

mentalstatecond
	: mentalliteral (COMMA mentalliteral)*;	
	
mentalliteral
	: TRUE | mentalatom | NOT OPEN mentalatom CLOSE;
	
mentalatom
	: BEL OPEN litconj CLOSE | GOAL OPEN litconj CLOSE;
	

actionspec: action CURLYOPEN PRE CURLYOPEN litconj CURLYCLOSE POST CURLYOPEN litconj CURLYCLOSE CURLYCLOSE;

actioncombo
	: action (PLUS action)*;
	
action	: userdefaction | builtinaction | communication;

userdefaction
	: id (parameters)+;
	
builtinaction
	: INSERT OPEN litconj CLOSE |
	 DELETE OPEN litconj CLOSE |
	  ADOPT OPEN litconj CLOSE |
	  DROP OPEN litconj CLOSE;
	  
communication
	: SEND OPEN id COMMA poslitconj CLOSE;
                                         
id returns [String s]	: (CONST {$s = $CONST.getText();}| VAR {$s = $VAR.getText();}); //| '_' | '$') (CONST | VAR | '_' | NUMBER | '$')*;	
                                                 
// GOAL keywords
MAIN: 'main';	
 KNOWLEDGE:	 'knowledge';   
 BELIEFS:	'beliefs';
 GOALS	:	'goals';
 EVENT	: 'event';
 ACTIONSPEC
 	: 'actionspec';
 MODULE	:	'module';
 PROGRAM: 'program';
 PROLOGARROW
 	:	':-';
 NOT	:	'not';
 ORDER	:'order';
 EQUALS	:	'=';
 LINEAR	:	'linear';
 LINEARALL
 	:	'linearall';
 RANDOM	:	'random';
 RANDOMALL
 	:	'randomall';
 DEFINE	:	'define';
 IF	:	'if';
 THEN	:	'then';
 TRUE	:	'true';
 BEL	:	'bel';
 GOAL	:	'a-goal';
 PRE	:	'pre';
 POST	:	'post';
 PLUS	:	'+';
 INSERT	:	'insert';
 DELETE	:	'delete';
 ADOPT	:	'adopt';
 DROP	:	'drop';
 SEND	:	'send';
 
 // term syntax
 equation
 	: arithexpr eqoper arithexpr;
 term	: (stringterm | function_term | arithexpr | listterm);
 function_term 
 	:	CONST (OPEN term (COMMA term)* CLOSE)?;
 atom_term 
 	: (numberstring | var);
 stringterm
 	: DOUBLEQUOTE word DOUBLEQUOTE;
 var	:	VAR;
 numberstring 
 	:	 (MINUS)? (NUMBER (STOP NUMBER)?);
 	
 arithexpr
 	: multexpr (addoper multexpr)?;
multexpr:	atom_term (multoper atom_term)?;
  word	: (CONST | VAR | NUMBER)*;
 
 listterm
 	: SQOPEN (term (COMMA term)* (BAR VAR)? )? SQCLOSE;
 	
 addoper:	(PLUS | MINUS);
 multoper
 	:	(MULT | DIV );
 eqoper	: (LESS | EQUALS);
 	                                              
// Lexer Misc Syntax
COLON	: ':';
CURLYOPEN: '{';
CURLYCLOSE
	:'}';
STOP	: '.';
COMMA	: ',';
OPEN	: '(';
CLOSE	: ')';
SQOPEN	: '[';
SQCLOSE	: ']';
HASH: '#';
DOUBLEQUOTE
	: '"';
BAR	: '|';

CONST 	: 	'a'..'z' ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
VAR	:	('A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
NUMBER	:	'0'..'9' ('0'..'9')*;

MINUS	:	'-';
MULT	:	'*';
DIV	:	'/';
LESS	:	'<';

COMMENT
    : '/*' .* '*/' {$channel=HIDDEN;}
    ;
LINE_COMMENT
    : ('//'|'%') ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    ;
NEWLINE:'\r'? '\n' {skip();} ;
WS  :   (' '|'\t')+ {skip();} ;
