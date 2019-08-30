// ----------------------------------------------------------------------------
// Copyright (C) 2014 Louise A. Dennis, and  Michael Fisher 
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

package ail.syntax;

import junit.framework.Assert;

import org.junit.Test;

import ail.semantics.AILAgent;
import ail.semantics.operationalrules.HandleAddAchieveTestGoal;

/**
 * Regression test method checking that the system recognises when a goal has been achieved.
 * @author louiseadennis
 *
 */
public class GoalAchievedQuickTests {
	@Test public void goalAchievedTest() {
		Literal empty = new Literal("empty");
		// empty.addAnnot(BeliefBase.TSelf);
		
		AILAgent ag = new AILAgent();
		ag.addBel(new GBelief(empty), BeliefBase.TSelf);
		
		Goal emptyg = new Goal("empty");
		
		Intention i = new Intention(emptyg, AILAgent.refertoself(), ag.getPrettyPrinter());
		ag.setIntention(i);

		HandleAddAchieveTestGoal addgoal = new HandleAddAchieveTestGoal();
		
		Assert.assertTrue(addgoal.checkPreconditions(ag));
		addgoal.apply(ag);
		Assert.assertFalse(ag.getGoals().hasNext());
	}

}
