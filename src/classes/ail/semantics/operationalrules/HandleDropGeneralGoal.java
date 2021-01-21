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
import java.util.LinkedList;
import java.util.List;

import ail.semantics.AILAgent;
import ail.syntax.Deed;
import ail.syntax.Event;
import ail.syntax.Goal;
import ail.syntax.Intention;
import ail.syntax.Unifier;
import ail.tracing.events.ModificationEvent;
import gov.nasa.jpf.annotation.FilterField;

/**
 * Drop a goal assuming it is not a maintenance goal and assuming that intentions are involved.
 * NB.  This also assumes that the deed on the intention _before_ the goal was added asks
 * for the goal to be adopted.  This deed is _also_ dropped so, for the intention, it is as if
 * the goal was achieved.  This may have uninteded consequences.
 * 
 * @author lad
 *
 */
public class HandleDropGeneralGoal extends HandleDropGoal {
	@FilterField
	private static final String name = "Handle Drop General Goal";
	
	@FilterField
	private List<Integer> excludedGoalTypes = new LinkedList<Integer>();
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#getName()
	 */
	public String getName() {
		return name;
	}
		
	/**
	 * Special constructor allows the rule to be supplied on creation with a list of
	 * goal types not to be treated in this way.
	 * 
	 * @param sl
	 */
	public HandleDropGeneralGoal(List<Integer> sl) {
		excludedGoalTypes = sl;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.HandleDropGoal#checkPreconditions(ail.semantics.AILAgent)
	 */
	public boolean checkPreconditions(AILAgent a) {
		return (super.checkPreconditions(a) && (! excludedGoalTypes.contains(gt)));
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.HandleTopDeed#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		super.apply(a);
		Unifier thetae  = new Unifier();
		Event goal_addition_event = new Event(Event.AILAddition, g);
		boolean flag = false;
		ArrayList<Goal> subgoals = new ArrayList<Goal>();
	
		// If any of the events in the intention stack unify with +!g
		// find the earliest such event (what matchcount is doing)
		// i is current intention
		ArrayList<Goal> temp_subgoals = new ArrayList<Goal>();
		for (Event e3: i.eventsUnified()) {
			if (e3.referstoGoal()) {
				temp_subgoals.add((Goal) e3.getContent());
			}
			if (thetae.matchesNG(e3, goal_addition_event)) {
				flag = true;
				subgoals = temp_subgoals;
			}
		}
	
		// Drop back to the earliest occurence of +!g.
		if (flag) {
			i.dropGoal(goal_addition_event, thetae);
			i.tlI(a);
		} else {
			// Otherwise explore other intention stacks
			List<Intention> is = a.getIntentions();
			for (Intention ip: is) {
				flag = false;
				temp_subgoals = new ArrayList<Goal>();
				for (Event e3: ip.eventsUnified()) {
					if (e3.referstoGoal()) {
						temp_subgoals.add((Goal) e3.getContent());
					}
					if (!flag) {
						if (thetae.matchesNG(e3, goal_addition_event)) {
							flag = true;
						}
					}
				}
				
				
				if (flag) {
					ip.dropGoal(goal_addition_event, thetae);
					ip.tlI(a);
					if (ip.suspended()) {
						ip.unsuspend();
					}
					subgoals = temp_subgoals;
				} else {
					if (ip.hdD().referstoGoal() && ip.hdD().isAddition()  && g.getGoalType() == Goal.performGoal) {
						Deed goal_addition_deed = new Deed(Deed.AILAddition, g);
						if (thetae.matchesNG(ip.hdD(), goal_addition_deed)) {
							ip.tlI(a);
						}
					}
				}
			}
			
			i.tlI(a);
		}
		
		for (Goal sg: subgoals) {
			if (a.removeGoal(sg) && a.shouldTrace()) {
				a.trace(new ModificationEvent(i.getID(), ModificationEvent.GOALS, null, null, sg));
			}
		}
	}
}