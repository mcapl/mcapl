// ----------------------------------------------------------------------------
// Copyright (C) 2022 Louise A. Dennis
// 
// This file is part of Gwendolen
//
// Gwendolen is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Gwendolen is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with Gwendolen if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

grammar Gwendolen;


// Mas involving Gwendolen Agents
mas  : glist=gwendolenagents;

gwendolenagents : GWENDOLEN (g=gwendolenagent)+;

// Gwendolen Agent stuff
gwendolenagent :  (GWENDOLEN?) 
	NAME w=word 
	// BELIEF_BLOCKS should all be litlists from LogicalFmlas grammar
	BELIEFS ((bs=BELIEF_BLOCK)? IB_NEWLINE)*
	// RR_BLOCKS should be rulelists from LogicalFmlas grammar
	(BELIEFRULES (RR_NEWLINE)* (RR_BLOCK RR_NEWLINE) ((RR_BLOCK)? RR_NEWLINE)* )? 
	(GOAL_RR | GOAL_IB) (GL_NEWLINE)* (gs=GOAL_BLOCK SQOPEN (ACHIVEGOAL | PERFORMGOAL) SQCLOSE GL_NEWLINE) ((GOAL_BLOCK)? GL_NEWLINE)*
	PLANS (p=plan )*;
	

plan : e=event  
		COLON CURLYOPEN  (NOT )? gb=guard_atom 
		(COMMA  (NOT )? gb=guard_atom )* CURLYCLOSE (RULEARROW
		d=deed  (COMMA d=deed )*)? 
		SEMI ;


guard_atom  : (BELIEVE l=fof_expr |
				GOAL gl=goal  |
				SENT OPEN  (s=agentnameterm )  COMMA  (an2=agentnameterm COMMA )? p=performative COMMA t=pred CLOSE  |
				eq = equation  |
				TRUE  );
				
	
event : (PLUS (RECEIVED OPEN p=performative COMMA t=pred CLOSE |
				(l=fof_expr  | SHRIEK g=goal ) |
				ADD_CONTENT l=fof_expr  |
				ADD_CONTEXT l=fof_expr 
				) |
			   MINUS (l=fof_expr  |
				SHRIEK g=goal |
				ADD_CONTENT l=fof_expr  |
				ADD_CONTEXT l=fof_expr 
				));

performative  : (TELL  | PERFORM  | ACHIEVE| TELLHOW | CONSTRAINT );
								
deed  : (((PLUS (l=fof_expr  | SHRIEK g=goal  |
				ADD_CONTENT l=fof_expr  |
				ADD_CONTEXT l=fof_expr  |
				ADD_PLAN p=fof_expr |
				ADD_CONSTRAINT c=fof_expr |
				LOCK ) |
		 MINUS (l=fof_expr  | SHRIEK g=goal |
				ADD_CONTENT l=fof_expr  |
				ADD_CONTEXT l=fof_expr  |
				LOCK
				)) |
				a=action  |
				wf=waitfor 
				)
				;
					
waitfor  :  MULT l=fof_expr ;

action  : 
	(SEND OPEN an=fof_expr COMMA p=performative COMMA t=pred CLOSE ) | 
	t=pred;



// General AIL Parsing stuff

environment : w=classpath;
classpath : w=word (POINT w1=word )+;                                                                                     
word  : (CONST  | VAR );                                                                                     

agentnameterm  : CONST  | v=var ;

fof_expr: (CONST ( IDPUNCT CONST)* (OPEN (fof_expr | QUOTED_STRING) (COMMASEP (fof_expr | QUOTED_STRING))* CLOSE)? 
	      | SQOPEN fof_expr (COMMASEP fof_expr)* SQCLOSE );


