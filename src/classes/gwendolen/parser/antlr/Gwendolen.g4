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
	NAME w=word 	BELIEFS (l=fof_expr)*
	(BELIEFRULES (r=brule )*)?
	GOALS (gl=goal )*
	PLANS (p=plan )*;
	

guard_atom  : (BELIEVE l=fof_expr  |
				GOAL gl=goal  |
				SENT OPEN  (s=agentnameterm ) COMMASEP  (an2=agentnameterm 
					COMMASEP )? p=performative 
					COMMASEP t=fof_expr CLOSE  |
//				eq = equation  |
				eq = fof_expr | 
				TRUE  );
				
goal  : l=fof_expr SQOPEN (ACHIEVEGOAL  | PERFORMGOAL ) SQCLOSE;
plan 
	: e=event  COLON 
		CURLYOPEN  g1=pn_guard_atom (COMMASEP gs=pn_guard_atom )* CURLYCLOSE 
		(RULEARROW d=deed  (COMMASEP ds=deed )*)? 
		SEMI ;
		
pn_guard_atom : (NOT)? gb=guard_atom;
	
event  : (PLUS (RECEIVED OPEN p=performative COMMASEP t=fof_expr CLOSE |
				(l=fof_expr  |
				SHRIEK g=goal ) |
//				ADD_CONTENT l=literal {$e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILContent, $l.l);} |
//				ADD_CONTEXT l=literal {$e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILContext, $l.l);}
				) |
			   MINUS (l=fof_expr  |
				SHRIEK g=goal  |
			//	ADD_CONTENT l=literal {$e = new Abstract_Event(Abstract_Event.AILDeletion, Abstract_Event.AILContent, $l.l);} |
			//	ADD_CONTEXT l=literal {$e = new Abstract_Event(Abstract_Event.AILDeletion, Abstract_Event.AILContext, $l.l);}
				));

performative  : (TELL  | PERFORM  | ACHIEVE ); // | TELLHOW  | CONSTRAINT );
								
deed  : (((PLUS (l=fof_expr  |
				SHRIEK g=goal  |
//				ADD_CONTENT l=literal  |
//				ADD_CONTEXT l=literal {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILContext, $l.l);} |
				ADD_PLAN p=fof_expr  |
//				ADD_CONSTRAINT c=literal {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILConstraint, $c.l);} |
				LOCK ) |
			   MINUS (l=fof_expr  |
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
// brule : head=fof_expr (BRULEARROW f=logicalfmla  SEMI | SEMI );
brule : head=fof_expr (BRULEARROW f=fof_expr  SEMI | SEMI );
	

waitfor  :  MULT l=fof_expr;

action  : 
	(SEND OPEN an=fof_expr COMMASEP p=performative COMMASEP t=fof_expr CLOSE ) | 
	t=fof_expr ;
	
environment  : w=classpath ;
classpath  : w=word  (POINT w1=word )+;                                                                                     
word  : (CONST  | VAR );                                                                                     

agentnameterm  : CONST  | VAR | UNNAMEDVAR ;

// fof_expr: (CONST | IDPUNCT | OPEN fof_expr CLOSE)+;
fof_expr: (CONST ( IDPUNCT CONST)* (OPEN (fof_expr | QUOTED_STRING) (COMMASEP (fof_expr | QUOTED_STRING))* CLOSE)? 
	      | SQOPEN fof_expr (COMMASEP fof_expr)* (BAR VAR)? SQCLOSE );

