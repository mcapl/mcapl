// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
// 
// This file is part of Agent JPF (AJPF)
//
// AJPF is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// AJPF is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with AJPF if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

grammar A_PSL;

@header {
package ajpf.psl.parser;

import ajpf.psl.ast.*;
import ajpf.*;
}

@members {
	MCAPLmas mas;
	MCAPLcontroller c;
}

@lexer::header {
package ajpf.psl.parser;
}

@lexer::members {
	int nesting = 0;
	boolean informula = false;
}

spec returns [Abstract_Property p1] : p = property {$p1 = $p.p1;};

property returns [Abstract_Property p1] : p=untilproperty {$p1 = $p.p;};
			
untilproperty returns [Abstract_Property p] :
	rp = releaseproperty {Abstract_Property prop = $rp.p;} (UNTIL a = releaseproperty {prop = new Abstract_Until(prop, $a.p);})* {$p = prop;};
	
releaseproperty returns [Abstract_Property p] :
	ip = impproperty {Abstract_Property prop = $ip.p;} (RELEASE a = impproperty {prop = new Abstract_Release(prop, $a.p);})* {$p = prop;};
	
impproperty returns [Abstract_Property p] :
	ap = andproperty {Abstract_Property prop = $ap.p;} (IMP a = andproperty {prop = new Abstract_Or(new Abstract_Not(prop), $a.p);})* {$p = prop;};
	
andproperty returns [Abstract_Property p] :
	at = orproperty {Abstract_Property prop = $at.p;} (AND a = orproperty {prop = new Abstract_And(prop, $a.p);})* {$p = prop;};
	
orproperty returns [Abstract_Property p] :
	at = alwaysproperty {Abstract_Property prop = $at.p;} (OR a = alwaysproperty {prop = new Abstract_Or(prop, $a.p);})* {$p = prop;};
	
alwaysproperty returns [Abstract_Property p] :
	np = finallyproperty {$p = $np.p;} |
	ALWAYS pl = finallyproperty {$p = new Abstract_Always($pl.p);};

finallyproperty returns [Abstract_Property p] :
	np = notproperty {$p = $np.p;} |
	FINALLY pl = notproperty {$p = new Abstract_Finally($pl.p);};

notproperty returns [Abstract_Property p] :
	at = atom {$p = $at.p;}|
	NOT p1 = atom {$p = new Abstract_Not($p1.p);};
	
atom returns [Abstract_Property p] : 
	prop = proposition {$p = $prop.p1;} |
	OPENBRACKET tp = property {$p = $tp.p1;} CLOSEBRACKET;
	
proposition returns [Abstract_Proposition p1] :
	p2 = beliefproperty  {$p1 = (Abstract_Proposition) $p2.p;} |
	p3 = goalproperty {$p1 = (Abstract_Proposition) $p3.p;} | p4 = falseprop {$p1 = (Abstract_Proposition) $p4.p;} | 
	p5 = intentionproperty {$p1 = (Abstract_Proposition) $p5.p;} | p6 = lastactionproperty {$p1 = (Abstract_Proposition) $p6.p;} |
	p7 = perceptproperty {$p1 = (Abstract_Proposition) $p7.p;} | 
	p8 = intendtodoproperty {$p1 = (Abstract_Proposition) $p8.p;} |
	p = trueprop {$p1 = (Abstract_Proposition) $p.p;};
	
beliefproperty returns [Abstract_AgBelief p] :
	BELIEVE OPENBRACKET ag=agentname COMMASEP f=formula CLOSEBRACKET {$p = new Abstract_AgBelief($ag.s, (Abstract_Formula) $f.f);};
goalproperty returns [Abstract_AgGoal p] :
	GOAL OPENBRACKET ag=agentname COMMASEP f=formula CLOSEBRACKET {$p = new Abstract_AgGoal($ag.s, (Abstract_Formula) $f.f);};
falseprop returns [Abstract_FalseProp p] :
	FALSE {$p = new Abstract_FalseProp();};
intentionproperty returns [Abstract_AgIntention p] :
	INTENTION OPENBRACKET ag=agentname COMMASEP f=formula CLOSEBRACKET {$p = new Abstract_AgIntention($ag.s, (Abstract_Formula) $f.f);};
lastactionproperty returns [Abstract_LastAction p] :
	ACTION OPENBRACKET ag=agentname COMMASEP f=formula CLOSEBRACKET {$p = new Abstract_LastAction($ag.s, (Abstract_Formula) $f.f);};
perceptproperty returns [Abstract_Percept p] :
	PERCEPT OPENBRACKET f = formula CLOSEBRACKET {$p = new Abstract_Percept((Abstract_Formula) $f.f);};
intendtodoproperty returns [Abstract_AgIntendToDo p]:
	INTENDTODO OPENBRACKET ag=agentname COMMASEP f = formula CLOSEBRACKET {$p = new Abstract_AgIntendToDo($ag.s, (Abstract_Formula) $f.f);};
trueprop returns [Abstract_TrueProp p] :
	TRUE {$p = new Abstract_TrueProp();};	
	
agentname returns [String s]
	:	CONST {$s = $CONST.getText();};

formula	returns [Abstract_Formula f]: 
				CONST {$f = new Abstract_MCAPLPredicate($CONST.getText());} 
				(OPENBRACKET terms[$f] CLOSEBRACKET)?;

subformula	returns [Abstract_MCAPLTerm f]: (NUMBER {$f = new Abstract_MCAPLNumberTermImpl($NUMBER.getText());} |
                              UNNAMED_VAR {$f = new Abstract_TermImpl($UNNAMED_VAR.getText());} |
                              SQOPENBRACKET h=subformula {$f = new Abstract_MCAPLListTermImpl($h.f);} ( COMMASEP t=subformula {((Abstract_MCAPLListTerm) $f).addEnd($t.f);})* SQCLOSEBRACKET |
			      CONST {$f = new Abstract_TermImpl($CONST.getText());}
			      (OPENBRACKET terms[$f] CLOSEBRACKET)?);

terms[Abstract_MCAPLTerm f] : t=subformula {((Abstract_TermImpl) $f).addTerm($t.f);} (COMMASEP terms[$f])?;


	
ALWAYS 	:	{!informula }?=> ('A' | '[]');
FINALLY	:	{!informula }?=> ('E' | '<>');
UNTIL	:	{!informula }?=> 'U';
RELEASE	:	{!informula }?=> 'R';
AND 	:	{!informula }?=> '&';
OR	:	{!informula }?=> '||';
NOT	:	{!informula }?=> '~';
IMP	:	{!informula }?=> '->';
BELIEVE      
	:	 {!informula }?=> 'B' {informula=true;};
GOAL 	:	{!informula }?=> 'G' {informula=true;};
FALSE	: 	{!informula }?=> 'F';
INTENTION
	:	{!informula }?=> 'I' {informula=true;};
ACTION	:	{!informula }?=> 'D' {informula=true;};
PERCEPT	:	{!informula }?=> 'P' { informula=true;};
TRUE	:	{!informula }?=> 'T';
INTENDTODO
	:	{!informula}?=> 'ItD';

CONST	:	'a'..'z' ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
UNNAMED_VAR	:	'_';
NUMBER	:	'0'..'9' ('0'..'9')*;

OPENBRACKET	: 	'(' {if (informula) {nesting++;}};
CLOSEBRACKET	:	')' {if (informula) {if (nesting > 0) {nesting--;} if (nesting == 0) {informula=false;}}};
SQOPENBRACKET	: 	'[' {if (informula) {nesting++;}};
SQCLOSEBRACKET	:	']' {if (informula) {if (nesting > 0) {nesting--;} if (nesting == 0) {informula=false;}}};
COMMASEP	:	',' ;
NEWLINE:'\r'? '\n' {skip();} ;
WS  :   (' '|'\t')+ {skip();} ;

COMMENT 
	:	'/*' (options {greedy=false;} : .)* '*/' {$channel=HIDDEN;};
