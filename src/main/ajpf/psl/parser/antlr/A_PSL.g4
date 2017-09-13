// ----------------------------------------------------------------------------
// Copyright (C) 2008-2017 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
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

options { tokenVocab = A_PSLLexer; }

spec : p = property;

property  : untilproperty ;
			
untilproperty  : releaseproperty  (UNTIL releaseproperty)* ;
	
releaseproperty  : impproperty  (RELEASE impproperty )* ;
	
impproperty  : andproperty  (IMP andproperty )* ;
	
andproperty : orproperty (AND orproperty )* ;
	
orproperty : alwaysproperty (OR alwaysproperty )*;
	
alwaysproperty : finallyproperty | ALWAYS finallyproperty;

finallyproperty : notproperty | FINALLY notproperty ;

notproperty : atom | NOT atom ;
	
atom  : proposition  | OPENBRACKET property CLOSEBRACKET;
	
proposition : beliefproperty  | goalproperty | falseprop | intentionproperty | lastactionproperty | 
	perceptproperty | intendtodoproperty  | trueprop ;
	
beliefproperty : BELIEVE OPENBRACKET agentname COMMASEP FOF_BLOCK CLOSEBRACKET ;
goalproperty  : GOAL OPENBRACKET agentname COMMASEP FOF_BLOCK CLOSEBRACKET ;
falseprop  : FALSE ;
intentionproperty : INTENTION OPENBRACKET agentname COMMASEP FOF_BLOCK CLOSEBRACKET ;
lastactionproperty  : ACTION OPENBRACKET agentname COMMASEP FOF_BLOCK CLOSEBRACKET ;
perceptproperty  : PERCEPT OPENBRACKET FOF_BLOCK CLOSEBRACKET ;
intendtodoproperty : INTENDTODO OPENBRACKET agentname COMMASEP FOF_BLOCK CLOSEBRACKET ;
trueprop  : TRUE ;	
	
agentname :	CONST {$s = $CONST.getText();};


