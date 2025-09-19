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

options { tokenVocab = GwendolenLexer; }

// Mas involving Gwendolen Agents
mas  : glist=gwendolenagents;

gwendolenagents : GWENDOLEN (g=gwendolenagent)+;

// Gwendolen Agent stuff
gwendolenagent :  (GWENDOLEN?) 
	(NAME | NAME_PM) w=CONST 
	// BELIEF_BLOCKS should all be litlists from LogicalFmlas grammar
	BELIEFS (bs=BELIEF_BLOCK)*
	// RR_BLOCKS should be rulelists from LogicalFmlas grammar
	(BELIEFRULES (RR_NEWLINE)* (rr=RR_BLOCK)* )?
	(GOAL_IB | GOAL_RR) (gs=initial_goal)*
	PLANS (p=plan)+;
	

initial_goal: g=GOAL_BLOCK GL_SQOPEN (GL_ACHIEVEGOAL | GL_PERFORMGOAL) GL_SQCLOSE;

plan : e=event  
		COLON CURLYOPEN  gb=guard_atom  (COMMA  gb=guard_atom )* CURLYCLOSE 
		(RULEARROW
		 d=deed  (COMMA d=deed )*)? 
		SEMI ;


guard_atom  : ( (NOT)? (BELIEVE l=fof_expr | GOAL gl=goal | eq = fof_expr
			|	SENT OPEN  (s=agentnameterm )  COMMA  (an2=agentnameterm COMMA )? p=performative COMMA t=fof_expr CLOSE  )
				| TRUE  );
					
event : ( PLUS
	  		(RECEIVED OPEN p=performative COMMA t=fof_expr CLOSE |
	  			(l = fof_expr | SHRIEK g=goal)
	   		) 
		) |
		( MINUS
			(l = fof_expr | SHRIEK g=goal)
	   	);

performative  : (TELL  | COLON PL_PERFORMGOAL  | COLON PL_ACHIEVEGOAL );
								
deed  : (
			((PLUS (l=fof_expr  | SHRIEK g=goal | LOCK))
				| 
			(MINUS (l=fof_expr  | SHRIEK g=goal | LOCK)))
				|
			a=action |
			wf=waitfor
		);


goal: g=fof_expr PL_SQOPEN (PL_ACHIEVEGOAL | PL_PERFORMGOAL) PL_SQCLOSE;

					
waitfor  :  MULT (NOT)? l=fof_expr ;

action  : 
	(SEND OPEN an=fof_expr COMMA p=performative COMMA t=fof_expr CLOSE ) | 
	t=fof_expr;
	      
fof_expr: ((MINUS)? NUMBER | PL_VAR) (oper ((MINUS)? NUMBER | PL_VAR))? |
		  (const_var ( IDPUNCT const_var)* (OPEN (fof_expr | QUOTED_STRING) (COMMA (fof_expr | QUOTED_STRING))* CLOSE)? 
	      | PL_SQOPEN (fof_expr (COMMA fof_expr)* (PL_BAR PL_VAR)?)? PL_SQCLOSE |
	      OPEN fof_expr CLOSE);
	      
const_var: PL_CONST | PL_VAR;
oper : EQUAL | LESS | PLUS | MINUS;

// General AIL Parsing stuff

// environment : w=classpath;
// classpath : w=word (IDPUNCT w1=word )+;                                                                                     
// word  : CONST;                                                                                     

agentnameterm  : PL_CONST  | PL_VAR ;
