// ----------------------------------------------------------------------------
// Copyright (C) 2014-2017 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of the Agent Infrastructure Layer (AIL)
// 
// The AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The AIL is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

grammar ActionOnly;
// import LogicalFmlas;

options { tokenVocab = ActionOnlyLexer; }

// Mas involving ActionOnly Agents
mas  :  aoagents;

aoagents: ACTIONONLY (aoagent)+;

// Agent stuff
aoagent  : 
    (ACTIONONLY?) 
	NAME w=WORD  
	// BELIEF_BLOCKS should all be litlists from LogicalFmlas grammar
	BELIEFS ((bs=BELIEF_BLOCK)? IB_NEWLINE)*
	// RR_BLCOKS should be rulelists from LogicalFmlas grammar
	(BELIEFRULES (RR_NEWLINE)* (RR_BLOCK RR_NEWLINE) ((RR_BLOCK)? RR_NEWLINE)* )? 
	// GOAL_BLOCKS should all be litlists from LogicalFmlas grammar
	(GOAL_RR | GOAL_IB) (GL_NEWLINE)* (gs=GOAL_BLOCK GL_NEWLINE) ((GOAL_BLOCK)? GL_NEWLINE)*
	ACTIONS (c = capability)*;
					

// pres should be a logicalfmla from LogicalFmlas grammar and a should be pred from LogicalFmlas grammar
capability : CURLYOPEN (pres=ACTION_BLOCK)? CURLYCLOSE a=ACTION_BLOCK; 

