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

import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import ail.syntax.Goal;
import ail.syntax.Unifier;
import ail.tracing.events.ModificationEvent;


/**
 * Rule for removing all achieved achievement goals.
 * 
 * @author lad
 *
 */
public class RemoveAchievedGoals implements OSRule {
	private static final String name = "Remove Achieved Goals";
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#getName()
	 */
	public String getName() {
		return name;
	}

	/*
	 * 
	 */
	public boolean checkPreconditions(AILAgent a) {
		return true;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.HandleTopDeed#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		Iterator<Goal> goals = a.getGoals();
		while(goals.hasNext()) {
			Goal g = goals.next();
			if (g.getGoalType() == Goal.achieveGoal && a.believesyn(g.achievedBelief(), new Unifier())) {
				if (a.removeGoal(g) && a.shouldTrace()) {
					a.trace(new ModificationEvent(ModificationEvent.GOALS, null, null, g));
				}
			}
		}
		
	}
}