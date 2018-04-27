// ----------------------------------------------------------------------------
// Copyright (C) 2008-2018 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
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
mas :  glist=gwendolenagents;

gwendolenagents : GWENDOLEN (g=gwendolenagent)+;

// Gwendolen Agent stuff
gwendolenagent  :  (GWENDOLEN?) 
	NAME w=word 	BELIEFS (ls=BELIEF_BLOCK)
	(BELIEFRULES (r=brule )*)?
	GOALS (gl=goal )*
	PLANS (p=plan )*;
	

guard_atom  : (BELIEVE l=literal  |
				GOAL gl=goal  |
				SENT OPEN  (s=agentnameterm ) COMMA  (an2=agentnameterm 
					COMMA )? p=performative 
					COMMA t=pred CLOSE  |
				eq = equation  |
				TRUE  );
				
goal  : l=literal SQOPEN (ACHIEVEGOAL  | PERFORMGOAL ) SQCLOSE;
plan 
	: e=event  COLON 
		CURLYOPEN  (NOT )? gb=guard_atom  
		(COMMA  (NOT )? gb=guard_atom )* CURLYCLOSE (RULEARROW
	d=deed  (COMMA d=deed )*)? 
	SEMI ;
	
event  : (PLUS (RECEIVED OPEN p=performative COMMA t=pred CLOSE |
				(l=literal  |
				SHRIEK g=goal ) |
//				ADD_CONTENT l=literal {$e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILContent, $l.l);} |
//				ADD_CONTEXT l=literal {$e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILContext, $l.l);}
				) |
			   MINUS (l=literal  |
				SHRIEK g=goal  |
			//	ADD_CONTENT l=literal {$e = new Abstract_Event(Abstract_Event.AILDeletion, Abstract_Event.AILContent, $l.l);} |
			//	ADD_CONTEXT l=literal {$e = new Abstract_Event(Abstract_Event.AILDeletion, Abstract_Event.AILContext, $l.l);}
				));

performative  : (TELL  | PERFORM  | ACHIEVE ); // | TELLHOW  | CONSTRAINT );
								
deed  : (((PLUS (l=literal  |
				SHRIEK g=goal  |
//				ADD_CONTENT l=literal  |
//				ADD_CONTEXT l=literal {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILContext, $l.l);} |
				ADD_PLAN p=literal  |
//				ADD_CONSTRAINT c=literal {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILConstraint, $c.l);} |
				LOCK ) |
			   MINUS (l=literal  |
				SHRIEK g=goal  |
	//			ADD_CONTENT l=literal {$d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILContent, $l.l);} |
	//			ADD_CONTEXT l=literal {$d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILContext, $l.l);} |
				LOCK 
				)) |
				a=action) |
				wf=waitfor 
				)
				;
					
// brule returns [Rule r] : head=gbelief BRULEARROW gb=gbelief {$r = new Rule($head.g, $gb.g);} 
//	(COMMA and=andfmla {LogExpr body = new LogExpr($gb.g, LogExpr.LogicalOp.and, $and.f); 
//		$r = new Rule($head.g, body);})? SEMI;
brule : head=pred (BRULEARROW f=logicalfmla  SEMI | SEMI );
	

waitfor  :  MULT l=literal;

action  : 
	(SEND OPEN an=literal COMMA p=performative COMMA t=pred CLOSE ) | 
	t=pred ;
	
environment  : w=classpath ;
classpath  : w=word  (POINT w1=word )+;                                                                                     
word  : (CONST  | VAR );                                                                                     

agentnameterm  : CONST  | v=var ;


