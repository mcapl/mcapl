// ----------------------------------------------------------------------------
// Copyright (C) 2024 Louise A. Dennis
//
// This file is part of the Engineering Autonomous Space Software (EASS) Library.
//
// The EASS Library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
//
// The EASS Library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with the EASS Library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
//
// To contact the authors:
// http://www.cs.man.ac.uk/~dennisl/index.html
//
//----------------------------------------------------------------------------

grammar EASS;

options { tokenVocab = EASSLexer; }

import Gwendolen;

mas  : glist=eassagents;

eassagents : EASS (g=eassagent)+;


//eassagent returns [Abstract_EASSAgent g] :
//	(NAME w=word {try {$g = new Abstract_EASSAgent($w.s);} catch (Exception e) {System.err.println(e);}
//	              agentname = new Abstract_StringTermImpl($w.s);} |
//	ABSTRACTION w=word {String s = "abstraction_" + $w.s; $g = new Abstract_EASSAgent(s); g.setAbstraction($w.s);}
//				)
//	BELIEFS (l=literal {$g.addInitialBel($l.l);})*
//	(BELIEFRULES (r=brule {$g.addRule($r.r);})*)?
//	(CAPABILITIES (c=capability {$g.addCap($c.c);})*)?
//	GOALS (gl=goal {$g.addInitialGoal($gl.g);})*
//	PLANS (p=plan {try {$g.addPlan($p.p);} catch (Exception e) {System.err.println(e);}})*
//	;
// Gwendolen Agent stuff
eassagent :  (EASS?)
	(NAME | NAME_PM | ABSTRACTION) w=CONST
	// BELIEF_BLOCKS should all be litlists from LogicalFmlas grammar
	BELIEFS (bs=BELIEF_BLOCK)*
	// RR_BLOCKS should be rulelists from LogicalFmlas grammar
	(BELIEFRULES (RR_NEWLINE)*  (rr=RR_BLOCK)* )?
	((CAP_IB | CAP_RR) (CAP_NEWLINE)* (cap=CAP_BLOCK)*)?
	(GOAL_IB | GOAL_RR | GOAL_C) (gs=initial_goal)*
	PLANS (p=plan)+;