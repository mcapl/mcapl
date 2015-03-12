// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
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
// License along with GOAL-AIL if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package goal.semantics.operationalrules;

import java.util.ArrayList;
import java.util.Iterator;

import ail.semantics.AILAgent;
import ail.syntax.Deed;
import ail.syntax.Intention;
import ail.syntax.ApplicablePlan;
import ail.syntax.DefaultAILStructure;
import ail.syntax.Event;
import ail.syntax.GBelief;
import ail.syntax.Guard;
import ail.syntax.Literal;
import ail.semantics.OSRule;
import goal.semantics.GOALAgent;
import goal.syntax.GOALModule;
import gov.nasa.jpf.annotation.FilterField;
//import gov.nasa.jpf.jvm.abstraction.filter.FilterField;

/**
 * This rule plans the goal using conditional actions.
 * 
 * @author lad
 *
 */
public class ActionRuleExecutor implements OSRule {
	@FilterField
	private static final String name = "Plan with Cond Actions";
	@FilterField
	private Iterator<ApplicablePlan> aps = new ArrayList<ApplicablePlan>().iterator();
	
	private GOALModule module;
	
	public void setModule(GOALModule module) {
		this.module = module;
	}
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#getName()
	 */
	public String getName() {
		return name;
	}
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#checkPreconditions(ail.semantics.AILAgent)
	 */
	public boolean checkPreconditions(AILAgent a) {
		return module.hasRuleSet();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#apply(ail.semantics.AILAgent)
	 */
	// NB. as it stands this method will calculcate iprime and Is, but in a subclass
	// these may be set by checkPreconditions, in which case that may need to be run
	// first in MJI to check everything is in the correct state.
	public void apply(AILAgent a) {
		// Note GOAL implementation has some stuff about SingleGoals here
		
		// What happens next also depends upon whether this is an ifthenrule or not.
		ApplicablePlan p = module.getRule();
		
		ArrayList<Guard> guardstack = p.getGuard();

		Literal state_literal = new Literal("state");
		// state_literal.addTerm(guardstack.get(guardstack.size() - 1).toTerm());
		Event state = new Event(Deed.AILAddition, DefaultAILStructure.AILBel, state_literal);
		// change the head of the guardstack to trivial - we've already checked it holds
		guardstack.set(guardstack.size() - 1, new Guard(new GBelief()));
		a.setIntention(new Intention(state, p.getPrefix(), guardstack, p.getUnifier().clone()));
		((GOALAgent) a).actionPerformed(); 
	}
}