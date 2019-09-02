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

import java.util.Iterator;
import java.util.List;

import ail.semantics.AILAgent;
import ail.syntax.Deed;
import ail.syntax.Event;
import ail.syntax.GBelief;
import ail.syntax.Goal;
import ail.syntax.Guard;
import ail.syntax.Intention;
import ail.syntax.Unifier;
import ail.tracing.events.ModificationEvent;
import ail.tracing.events.ModifyIntentionEvent;


/**
 * Rule for handling the addition of achieve and test goals.  Adds a new commitment
 * to the intention if they are not believed, does nothing if they are.
 * 
 * @author lad
 *
 */
public class HandleAddAchieveTestGoalwEvent extends HandleAddAchieveTestGoal {
	private static final String name = "Handle Add Achieve Test Goal with Event";
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#getName()
	 */
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.HandleAddGoal#checkPreconditions(ail.semantics.AILAgent)
	 */
	public boolean checkPreconditions(AILAgent a) {
		return(super.checkPreconditions(a));
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.HandleTopDeed#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		Iterator<Unifier> ui2 = a.believes(g.achievedBelief(), new Unifier());
		if (ui2.hasNext()) {
			Unifier thetag = ui2.next();
			i.tlI(a);
			thetahd.compose(thetab);
			thetahd.compose(thetag);
			i.compose(thetahd);
			
			// Testing to see if another intention is also trying to achieve this goal.  If so we don't want to
			// remove it.
			List<Intention> is = a.getIntentions();
			boolean flag = false;
			for (Intention ip: is) {
				for (Event e3: ip.eventsUnified()) {
					if (!flag & e3.referstoGoal()) {
						if (thetahd.matchesNG((Goal) e3.getContent(), g)) {
							flag = true;
							break;
						}
					}
				}
				if (flag) {
					break;
				}
			}

			if (!flag) {
				if (a.removeGoal(g) & a.shouldTrace()) {
					a.trace(new ModificationEvent(i.getID(), ModificationEvent.GOALS, null, null, g));
				}
			}
		} else {
			Iterator<Goal> goal_it = a.getGoals();
			
			// Don't add this goal if another intention is already working on it.  Have a suspicion this could 
			// cause trouble as implemented since the intention will continue as if the goal has been achieved.
			// possibly it should wait for goal achievement?
			while (goal_it.hasNext()) {
				Goal gt = goal_it.next();
				if (gt.unifies(g, thetab)) {
					i.tlI(a);
					thetahd.compose(thetab);
					i.compose(thetahd);
					return;
				}
			}

			if (a.addGoal(g) && a.shouldTrace()) {
				a.trace(new ModificationEvent(i.getID(), ModificationEvent.GOALS, null, g, null));
			}
			i.iCons(new Event(Event.AILAddition, g), new Deed(Deed.Dnpy), new Guard(new GBelief()), thetahd);
			if (a.shouldTrace()) {
				a.trace(new ModifyIntentionEvent(i, ModifyIntentionEvent.POST_EVENT));
			}
		}	
	}
}