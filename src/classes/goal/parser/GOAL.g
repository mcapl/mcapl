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
program	:    MAIN COLON id CURLYOPEN
                                        (KNOWLEDGE CURLYOPEN kr-spec CURLYCLOSE)
                                        (BELIEFS CURLYOPEN kr-spec CURLYCLOSE)
                                        (GOALS CURLYOPEN poslitconj* CURLYCLOSE)
                                         MAIN MODULE CURLYOPEN module CURLYCLOSE
                                         EVENT MODULE CURLYOPEN module CURLYCLOSE
                                         (ACTIONSPEC CURLYOPEN actionspec+ CURLYCLOSE)
                                         CURLYCLOSE;
                                         
id	: ('a'..'z' | 'A'..'Z' | '_' | '$') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9' | '$')*;	
                                                 
// GOAL keywords
MAIN: 'main';	
 KNOWLEDGE:	 'knowledge';   
                                              
// Lexer Misc Syntax
COLON	: ':';
CURLYOPEN: '{';
