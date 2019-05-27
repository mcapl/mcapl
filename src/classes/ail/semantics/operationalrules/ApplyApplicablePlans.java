// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
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
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package ail.semantics.operationalrules;

import java.util.ArrayList;
import java.util.Iterator;

import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import ail.syntax.ApplicablePlan;
import ail.syntax.Deed;
import ail.syntax.DefaultAILStructure;
import ail.syntax.Event;
import ail.syntax.GBelief;
import ail.syntax.Goal;
import ail.syntax.Guard;
import ail.syntax.Intention;
import ail.syntax.Literal;
import ail.tracing.events.CreateIntentionEvent;
import ail.tracing.events.ModificationEvent;
import ail.tracing.events.ModifyIntentionEvent;
import ail.tracing.events.SelectIntentionEvent;
import ail.tracing.events.SelectPlanEvent;


/**
 * Applying one of the applicable plans to the current intention.
 * 
 * @author lad
 *
 */
public class ApplyApplicablePlans implements OSRule {
	// The name of the rule.
	private static final String name = "ApplyApplicablePlans";
	
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
		return (a.getApplicablePlans().hasNext());
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		Intention i = a.getIntention();
		Iterator<ApplicablePlan> aps = a.getApplicablePlans();
		
		ApplicablePlan p = a.selectPlan(aps, i);
		if (a.shouldTrace()) {
			a.trace(new SelectPlanEvent(p, i.getID()));
		}
		
		//if (! p.noChangePlan()) {
		
			ArrayList<Guard> guardstack = p.getGuard();
		
			if (p.getN() == 0 && (! (guardstack.isEmpty()) && (! (guardstack.get(guardstack.size() - 1).isTrivial())))) {
			// This plan has not been triggered by an event and so should form a new intention.
			
				Literal state_literal = new Literal("state");
				// state_literal.addTerm(guardstack.get(guardstack.size() - 1).toTerm());
				Event state = new Event(Deed.AILAddition, DefaultAILStructure.AILBel, state_literal);
				// change the head of the guardstack to trivial - we've already checked it holds
				guardstack.set(guardstack.size() - 1, new Guard(new GBelief()));
				Intention set = new Intention(state, p.getPrefix(), guardstack, p.getUnifier().clone(), a.getPrettyPrinter());
				if (a.shouldTrace()) {
					a.trace(new CreateIntentionEvent(set));
				}
				a.setIntention(set);
				if (a.shouldTrace()) {
					a.trace(new SelectIntentionEvent(set));
				}
			} else {
				// This plan has been triggered by an event and should be added to the intention associated with that event.
                if (p.getPrefix().size() == 0) {
                    if (i.hdE().referstoGoal()) {
                            Goal g = (Goal) i.hdE().getContent();
                            Goal gcloned = g.clone();
                            gcloned.apply(i.hdU());
                            i.dropP(p.getN());
                            if (!i.hdE().referstoGoal() || (Goal) i.hdE().getContent() != g) {
                            	if (a.removeGoal(gcloned) && a.shouldTrace()) {
                        			a.trace(new ModificationEvent(i.getID(), ModificationEvent.GOALS, null, null, gcloned));
                        		}
                            }
                    } else {
                            i.dropP(p.getN());
                            if (a.shouldTrace()) {
        						a.trace(new ModifyIntentionEvent(i, ModifyIntentionEvent.DELETE_TOP_DEEDS, p));
        					}
                    }
                } else {
            
                    i.dropP(p.getN());
                    // Don't record modify intention here because it will by handled by p.getPrefix().size() != 0 below
                }
			
				// NOTE HACK - top of guardstack presumably already tested!
				if (! (guardstack.isEmpty()) && (! (guardstack.get(guardstack.size() - 1).isTrivial()))) {
					guardstack.set(guardstack.size() - 1, new Guard(new GBelief()));			
				}
			
				if (p.getPrefix().size() != 0) {			
					i.iConcat(p.getEvent(), p.getPrefix(), guardstack, p.getUnifier().clone());
					if (a.shouldTrace() && p.getID() != 0) {
						a.trace(new ModifyIntentionEvent(i, ModifyIntentionEvent.MERGE_PLAN, p));
					}
				} else if(! i.empty()) {
					i.hdU().compose(p.getUnifier().clone());
				}
				
				
			}
		//}
		
		// To encourage state matching during model checking we clear the list of applicable plans.
		a.clearApplicablePlans();

	}
}