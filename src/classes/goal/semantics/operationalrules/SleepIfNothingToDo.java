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

import ail.semantics.AILAgent;
import ail.syntax.Intention;
import ail.semantics.OSRule;

import gov.nasa.jpf.annotation.FilterField;
//import gov.nasa.jpf.jvm.abstraction.filter.FilterField;

/**
 * Sends the current intention to wait.
 * 
 * @author lad
 *
 */
public class SleepIfNothingToDo implements OSRule {
	@FilterField
	private final static String name = "Sleep if Nothing to Do";
	
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
		Intention i = a.getIntention();
		
		// If no more plans are applicable in this situation
		if (a.filterPlans(a.appPlans(i)).hasNext()) return false;
		else {
			for (Intention ip : a.getIntentions()) {
				if (a.filterPlans(a.appPlans(ip)).hasNext()) return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Don't need to do anything with the current intention in this situation because it
	 * is empty.
	 */
	public void apply(AILAgent a) {
		
		a.sleep();
			
		// At present sleeping isn't a field in agent state change so this can't
		// actually be represented via MJI.
		
	}
} 