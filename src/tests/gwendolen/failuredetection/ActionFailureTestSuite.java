// ----------------------------------------------------------------------------
// Copyright (C) 2013 Louise A. Dennis, and  Michael Fisher 
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

package gwendolen.failuredetection;

import ail.semantics.AILAgent;
import ail.semantics.operationalrules.HandleAddAchieveTestGoalwEvent;
import ail.semantics.operationalrules.HandleDropGeneralGoal;
import ail.syntax.*;
import ail.util.AILPrettyPrinter;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

import static ail.syntax.Guard.GLogicalOp.and;

/**
 * Various tests for methods in ail.semantics.operationalrules.HandleActionwProblem.
 * @author pws
 *
 */
public class ActionFailureTestSuite {


	/**
	 * Simple test for agent action log
	 */
	@Test public void ActionLogEntries() {
		/* Make an agent */
		AILAgent ag = new AILAgent();
		/* Make a capability */
		GLogicalFormula pre = new GBelief();
		Predicate p = new Predicate("c");
		GLogicalFormula post = new GBelief();
		Capability c = new Capability(pre, p, post);
		/* Make a durative action from the capability */
		DurativeAction a = new DurativeAction(c, 10, 10 );
		/* Log a successful action */
		ag.al.add(a, new BeliefBase(), new BeliefBase(), ActionLogEntry.actionSucceeded);
		/* Log a failed action */
		ag.al.add(a, new BeliefBase(), new BeliefBase(), ActionLogEntry.actionFailed);
		/* Log an aborted action */
		ag.al.add(a, new BeliefBase(), new BeliefBase(), ActionLogEntry.actionAbort);
		/* Check if action log reflects the above log */

		Assert.assertTrue(
				ag.al.checkLogFor(ActionLogEntry.actionSucceeded) > 0 &&
				ag.al.checkLogFor(ActionLogEntry.actionFailed) > 0 &&
				ag.al.checkLogFor(ActionLogEntry.actionAbort) > 0
				);
		//log print
		System.out.print(ag.al.toString());

	}

	/**
	 * Post Condition no longer achieved by action.
	 */
	@Test public void ActionNoLongerHasResult() {
		/* Make an agent */
		AILAgent ag = new AILAgent();
		/* Make a capability */
		GLogicalFormula pre = new GBelief();
		Predicate p = new Predicate("c");
		GLogicalFormula post = new GBelief();
		Capability c = new Capability(pre, p, post);
		/* Make a durative action from the capability */
		DurativeAction a = new DurativeAction(c, 10, 5 );
		/* Make a note of success conditions */
		GLogicalFormula originalConditions = a.getSuccess();
		/* Log some successful actions */
		ag.al.add(a, new BeliefBase(), ag.getBB(), ActionLogEntry.actionSucceeded);
		ag.al.add(a, new BeliefBase(), ag.getBB(), ActionLogEntry.actionSucceeded);
		ag.al.add(a, new BeliefBase(), ag.getBB(), ActionLogEntry.actionSucceeded);
		/* Log the threshold amount of failures with a different post condition*/
		ag.al.add(a, new BeliefBase(), ag.getBB(), ActionLogEntry.actionFailed);
		ag.al.add(a, new BeliefBase(), ag.getBB(), ActionLogEntry.actionFailed);
		ag.al.add(a, new BeliefBase(), ag.getBB(), ActionLogEntry.actionFailed);
		ag.al.add(a, new BeliefBase(), ag.getBB(), ActionLogEntry.actionFailed);
		ag.al.add(a, new BeliefBase(), ag.getBB(), ActionLogEntry.actionFailed);
		/* Trigger deductive learning on action log */
		// Spoof learning for now

		/* Log another action */
		ag.al.add(a, new BeliefBase(), ag.getBB(), ActionLogEntry.actionSucceeded);
		/* Check if post-condition has been updated OR if action has been marked as deprecated */
		Assert.assertNotSame(a.getSuccess(), originalConditions);

	}
	
	@Test public void ActionPartiallySuccessful() {
		/* Make an agent */
		AILAgent ag = new AILAgent();
		/* Make a capability */
			/* Empty precondition */
		GLogicalFormula pre = new GBelief();
		Predicate p = new Predicate("c");
			/* Create two postconditions and combine with the and operator from guard subclass */
		GLogicalFormula post1 = new GBelief();
		GLogicalFormula post2 = new GBelief();
		Guard postconditions = new Guard(post1, and, post2);
			/* set postcondition */
		GLogicalFormula post = postconditions;
			/* populate a capability */
		Capability c = new Capability(pre, p, post);
		/* Make a durative action from the capability */
		DurativeAction a = new DurativeAction(c, 10, 10 );
		/* Log some successful actions */
		ag.al.add(a, new BeliefBase(), ag.getBB(), ActionLogEntry.actionSucceeded);
		ag.al.add(a, new BeliefBase(), ag.getBB(), ActionLogEntry.actionSucceeded);
		ag.al.add(a, new BeliefBase(), ag.getBB(), ActionLogEntry.actionSucceeded);
		/* Log the threshold amount of failures with a different post condition*/
		ag.al.add(a, new BeliefBase(), ag.getBB(), ActionLogEntry.actionSucceededwithFailure);
		ag.al.add(a, new BeliefBase(), ag.getBB(), ActionLogEntry.actionSucceededwithFailure);
		ag.al.add(a, new BeliefBase(), ag.getBB(), ActionLogEntry.actionSucceededwithFailure);
		ag.al.add(a, new BeliefBase(), ag.getBB(), ActionLogEntry.actionSucceededwithFailure);
		ag.al.add(a, new BeliefBase(), ag.getBB(), ActionLogEntry.actionSucceededwithFailure);
		/* Trigger deductive learning on action log */

		/* Log another action */
		ag.al.add(a, new BeliefBase(), ag.getBB(), ActionLogEntry.actionSucceeded);
		/* Check if the affected post-condition has been updated */
		Assert.assertTrue(post1 == a.getSuccess() || post2 == a.getSuccess());

	}
	
	@Test public void ActionHasDifferentOutcome() {

		/* Make an agent */
		AILAgent ag = new AILAgent();
		/* Make a capability */
		GLogicalFormula pre = new GBelief();
		Predicate p = new Predicate("c");
		GLogicalFormula post = new GBelief();
		Capability c = new Capability(pre, p, post);
		/* Make a durative action from the capability */
		DurativeAction a = new DurativeAction(c, 10, 10 );
		/* Log some successful actions */
		ag.al.add(a, new BeliefBase(), ag.getBB(), ActionLogEntry.actionSucceeded);
		ag.al.add(a, new BeliefBase(), ag.getBB(), ActionLogEntry.actionSucceeded);
		ag.al.add(a, new BeliefBase(), ag.getBB(), ActionLogEntry.actionSucceeded);
		/* add a belief to show a different outcome is now happening after action execution*/
		//ag.addBel();
		/* Log the threshold amount of failures with a different post condition*/
		ag.al.add(a, new BeliefBase(), ag.getBB(), ActionLogEntry.actionFailed);
		ag.al.add(a, new BeliefBase(), ag.getBB(), ActionLogEntry.actionFailed);
		ag.al.add(a, new BeliefBase(), ag.getBB(), ActionLogEntry.actionFailed);
		/* Trigger deductive learning on action log */

		/* Log another action */
		ag.al.add(a, new BeliefBase(), ag.getBB(), ActionLogEntry.actionSucceeded);
		/* Check if post-condition has been updated OR if action has been marked as deprecated */
		Assert.assertTrue(a.getPost() != post);

	}

	@Test public void ActionHasDifferentOutcomewithVariables() {

		/* Make an agent */
		AILAgent ag = new AILAgent();
		/* Make a capability */
		GLogicalFormula pre = new GBelief();
		Predicate p = new Predicate("c");
		GLogicalFormula post = new GBelief();
		Capability c = new Capability(pre, p, post);
		/* Make a durative action from the capability */
		DurativeAction a = new DurativeAction(c, 10, 10 );
		/* Log some successful actions */
		ag.al.add(a, new BeliefBase(), ag.getBB(), ActionLogEntry.actionSucceeded);
		ag.al.add(a, new BeliefBase(), ag.getBB(), ActionLogEntry.actionSucceeded);
		ag.al.add(a, new BeliefBase(), ag.getBB(), ActionLogEntry.actionSucceeded);
		/* add a belief to show a different outcome is now happening after action execution*/
		//ag.addBel();
		/* Log the threshold amount of failures with a different post condition*/
		ag.al.add(a, new BeliefBase(), ag.getBB(), ActionLogEntry.actionFailed);
		ag.al.add(a, new BeliefBase(), ag.getBB(), ActionLogEntry.actionFailed);
		ag.al.add(a, new BeliefBase(), ag.getBB(), ActionLogEntry.actionFailed);
		/* Trigger deductive learning on action log */

		/* Log another action */
		ag.al.add(a, new BeliefBase(), ag.getBB(), ActionLogEntry.actionSucceeded);
		/* Check if post-condition has been updated OR if action has been marked as deprecated */
		Assert.assertTrue(a.getPost() != post);

	}

	@Test public void ActionTimesOut() {
		// Timeouts dont work as I want them to at the moment so I'll make this test when I'm dealing with time.
		Assert.assertTrue(false);
	}


	@Test public void ActionFailsForSpecificParameters() {
		// Not quite sure how to go about testing this one yet.
		Assert.assertTrue(false);
	}

}
