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
import ail.syntax.Intention;
import ail.syntax.ApplicablePlan;
import ail.syntax.DefaultAILStructure;
import ail.syntax.Event;
import ail.syntax.GBelief;
import ail.syntax.Guard;
import ail.syntax.Literal;
import ail.semantics.OSRule;

import gov.nasa.jpf.annotation.FilterField;
//import gov.nasa.jpf.jvm.abstraction.filter.FilterField;

/**
 * This rule plans the goal using conditional actions.
 * 
 * @author lad
 *
 */
public class PlanWithActionRule implements OSRule {
	@FilterField
	private static final String name = "Plan with Cond Actions";
	@FilterField
	private Iterator<ApplicablePlan> aps = new ArrayList<ApplicablePlan>().iterator();
	
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
		aps = a.filterPlans(a.appPlans(new Intention()));
		/* Verify.beginAtomic();
		System.err.println(aps);
		Verify.endAtomic(); */

		if (aps.hasNext()) return true;
		
		// aps = new LinkedList<ApplicablePlan>();
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
		Intention i = a.getIntention();

		if (aps.hasNext()) {
		
			// get the plan
			ApplicablePlan p = a.selectPlan(aps, i);
//			Verify.beginAtomic();
//			System.out.println(aps);
//			System.out.println("Plan: " + p);
//			Verify.endAtomic();

			if (p.getN() == 0 && (! (p.getGuard().isEmpty()) && (! (p.getGuard().get(p.getGuard().size() - 1).isTrivial())))) {
					// A reactive plan.
					Literal gl = new Literal("state");
					gl.addTerm(p.getGuard().get(p.getGuard().size() - 1).toTerm());
					Event state = new Event(Event.AILAddition, DefaultAILStructure.AILBel, gl);
					p.getGuard().set(p.getGuard().size() - 1, new Guard(new GBelief(GBelief.GTrue)));
					a.setIntention(new Intention(state, p.getPrefix(), p.getGuard(), p.getUnifier().clone(), AILAgent.refertoself()));
					if (!i.empty()) {
						a.getIntentions().add(i);
					}
			} else if (p.getN() == 0 && (! (p.getGuard().isEmpty()) && ((p.getGuard().get(p.getGuard().size() - 1).isTrivial())))) {
				Literal gl = new Literal("alwaystrue");
				Event state = new Event(Event.AILAddition, DefaultAILStructure.AILBel, gl);
				a.setIntention(new Intention(state, p.getPrefix(), p.getGuard(), p.getUnifier().clone(), AILAgent.refertoself()));	
				if (i != null) {
					a.getIntentions().add(i);
				}
			} else {
					System.err.println("Encountering a triggered Action Rule:  This should not happen!");
			}
		
		}
		aps = new ArrayList<ApplicablePlan>().iterator();

	}
}