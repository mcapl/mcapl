// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis, Michael Fisher, and Koen Hindriks
// 
// This file is part of AIL GOAL.  An AIL Implementation of the GOAL Programming
// Language
//
// AIL GOAL is free software: you can redistribute it and/or modify it under
// the terms of the GNU General Public License as published by the Free Software
// Foundation, either version 3 of the License, or (at your option) any later
// version.
//
// AIL GOAL is distributed in the hope that it will be useful, but WITHOUT
// ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
// FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
// details.
//
// You should have received a copy of the GNU General Public License along with
// this program. If not, see <http://www.gnu.org/licenses/>.
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
	private static final String name = "Apply Action Rule";
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
		if (module.hasRuleSet()) {
			if ( module.getRule().hasNext() ) {
				return true;
			} else {
				module.setRule(null);
			}
		}
		
		// What happens to reasoning cycle in this case?
		return false;
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
		Iterator<ApplicablePlan> ruleIt = module.getRule();
		ApplicablePlan p = ruleIt.next();
		// module.note_applied_rule();
			
		if (module.isIfThenRule(p)) {
			IntentionFromPlan(p, a);
		} else {
			IntentionFromPlan(p, a);
			int id = p.getID();
			while (ruleIt.hasNext()) {
				ApplicablePlan pp = ruleIt.next();
				if (pp.getID() == id) {
					IntentionFromPlan(pp, a);
				}
			}
		}

	}
	
	private static void IntentionFromPlan(ApplicablePlan p, AILAgent a) {
		ArrayList<Guard> guardstack = p.getGuard();
		
		Literal state_literal = new Literal("state");
		// state_literal.addTerm(guardstack.get(guardstack.size() - 1).toTerm());
		Event state = new Event(Deed.AILAddition, DefaultAILStructure.AILBel, state_literal);
		// change the head of the guardstack to trivial - we've already checked it holds
		guardstack.set(guardstack.size() - 1, new Guard(new GBelief()));
		a.setIntention(new Intention(state, p.getPrefix(), guardstack, p.getUnifier().clone(), a.getPrettyPrinter()));
		
	}
}