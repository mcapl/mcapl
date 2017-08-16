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
	BELIEFS (bs=BELIEF_BLOCK )?
//	(BELIEFRULES brs=RR_BLOCK )? 
//	(GOAL_RR | GOAL_IB) gs=GOAL_BLOCK;
	GOAL_IB gs=GOAL_BLOCK;
//	ACTIONS (c = capability)*;
					

//capability : CURLYOPEN (pres=ACTION_BLOCK)? CURLYCLOSE a=ACTION_BLOCK; 

