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
import ail.semantics.operationalrules.*;
import ail.syntax.*;
import ail.util.AILPrettyPrinter;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
		ag.al.add(a, new ArrayList(), new ArrayList(), ActionLogEntry.actionSucceeded);
		/* Log a failed action */
		ag.al.add(a, new ArrayList(), new ArrayList(), ActionLogEntry.actionFailed);
		/* Log an aborted action */
		ag.al.add(a, new ArrayList(), new ArrayList(), ActionLogEntry.actionAbort);
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
		GLogicalFormula pre = new GBelief(new Literal("at_0"));
		Predicate p = new Predicate("c");
		GLogicalFormula post = new GBelief(new Literal("at_entrance"));
		Capability c = new Capability(pre, p, post);
		ag.getCL().add(c);
		/* Make a durative action from the capability */
		DurativeAction a = new DurativeAction(c, 10, 2 );

		/* Log a successful action */
		ag.addBel(new Literal("at_entrance"), AILAgent.refertoself());
		ag.al.add(a, new ArrayList(), ag.getBB().getAll(), ActionLogEntry.actionSucceeded);
		ag.delBel(new Literal("at_entrance"));
		/* Log the threshold amount of failures with a different post condition*/
		ag.al.add(a, new ArrayList(), ag.getBB().getAll(), ActionLogEntry.actionFailed);
		ag.al.add(a, new ArrayList(), ag.getBB().getAll(), ActionLogEntry.actionFailed);
		ag.al.add(a, new ArrayList(), ag.getBB().getAll(), ActionLogEntry.actionFailed);
		/* Trigger deductive learning on action log */
		Learn learn = new Learn();

		junit.framework.Assert.assertTrue(learn.checkPreconditions(ag));
		learn.apply(ag);
		/* Log another action */
		ag.al.add(a, new ArrayList(), ag.getBB().getAll(), ActionLogEntry.actionSucceeded);
		/* Check if post-condition has been updated OR if action has been marked as deprecated */
		Capability newc = ag.getCL().getRelevant(p, AILAgent.SelectionOrder.LINEAR).next();
		System.out.print("\n");
		System.out.print(newc.getPost().toString() + "\n");
		System.out.print(post.toString());

		Assert.assertTrue(newc.getPost() != post);
// The new capability isnt being stored because it has no postcondition... Store it as null?

	}
	
	@Test public void ActionPartiallySuccessful() {
		/* Make an agent */
		AILAgent ag = new AILAgent();
		/* Make a capability */
		GLogicalFormula pre = new GBelief(new Literal("at_0"));
		Predicate p = new Predicate("c");
		GLogicalFormula post = new Guard(new GBelief(new Literal("at_entrance")), Guard.GLogicalOp.and, new GBelief(new Literal("photo_taken")));
		Capability c = new Capability(pre, p, post);
		ag.getCL().add(c);
		/* Make a durative action from the capability */
		DurativeAction a = new DurativeAction(c, 10, 2 );

		/* Log a successful action */
		ag.addBel(new Literal("at_entrance"), AILAgent.refertoself());
		ag.addBel(new Literal("photo_taken"), AILAgent.refertoself());
		ag.al.add(a, new ArrayList(), ag.getBB().getAll(), ActionLogEntry.actionSucceeded);
		ag.delBel(new Literal("at_entrance"));
		/* Add belief for only one postcondition of the action */
		ag.addBel(new Literal("at_entrance"), AILAgent.refertoself());
		/* Log the threshold amount of failures with a different post condition*/
		ag.al.add(a, new ArrayList(), ag.getBB().getAll(), ActionLogEntry.actionFailed);
		ag.al.add(a, new ArrayList(), ag.getBB().getAll(), ActionLogEntry.actionFailed);
		ag.al.add(a, new ArrayList(), ag.getBB().getAll(), ActionLogEntry.actionFailed);
		/* Trigger deductive learning on action log */
		Learn learn = new Learn();

		junit.framework.Assert.assertTrue(learn.checkPreconditions(ag));
		learn.apply(ag);
		/* Log another action */
		ag.al.add(a, new ArrayList(), ag.getBB().getAll(), ActionLogEntry.actionSucceeded);
		/* Check if post-condition has been updated OR if action has been marked as deprecated */
		Capability newc = ag.getCL().getRelevant(p, AILAgent.SelectionOrder.LINEAR).next();
		System.out.print("\n");
		System.out.print(newc.getPost().toString() + "\n");
		System.out.print(post.toString());

		Assert.assertTrue(newc.getPost() != post);


	}
	
	@Test public void ActionHasDifferentOutcome() {

		/* Make an agent */
		AILAgent ag = new AILAgent();
		/* Make a capability */
		GLogicalFormula pre = new GBelief(new Literal("at_0"));
		Predicate p = new Predicate("c");
		GLogicalFormula post = new GBelief(new Literal("at_entrance"));
		Capability c = new Capability(pre, p, post);
		//ag.getCL().add(c);
		/* Make a durative action from the capability */
		DurativeAction a = new DurativeAction(c, 10, 2 );
		ag.getCL().add(a);

		/* Log a successful action */
		ag.addBel(new Literal("at_entrance"), AILAgent.refertoself());
		ag.al.add(a, new ArrayList(), ag.getBB().getAll(), ActionLogEntry.actionSucceeded);
		ag.delBel(new Literal("at_entrance"));
		/* add a belief to show a different outcome is now happening after action execution*/
		ag.addBel(new Literal("at_exit"), AILAgent.refertoself());
		/* Log the threshold amount of failures with a different post condition*/
		ag.al.add(a, new ArrayList(), ag.getBB().getAll(), ActionLogEntry.actionFailed);
		ag.al.add(a, new ArrayList(), ag.getBB().getAll(), ActionLogEntry.actionFailed);
		ag.al.add(a, new ArrayList(), ag.getBB().getAll(), ActionLogEntry.actionFailed);
		/* Trigger deductive learning on action log */
		Learn learn = new Learn();

		junit.framework.Assert.assertTrue(learn.checkPreconditions(ag));
		learn.apply(ag);

		/* Log another action */  ///******************* This needs to log an actionLog that is auto generated - NOT fixed like below.
		ag.al.add(new ActionLogEntry(ag.getCL().getRelevant(a, AILAgent.SelectionOrder.LINEAR).next(), ag.prebeliefs, ag.getBB().getAll(), ActionLogEntry.actionSucceeded));

		/* Check if post-condition has been updated OR if action has been marked as deprecated */
		Capability newc = ag.getCL().getRelevant(p, AILAgent.SelectionOrder.LINEAR).next();
		//System.out.print("\n");
		//System.out.print(newc.getPost().toString() + "\n");
		//System.out.print(post.toString());

		System.out.print("\n");
		System.out.print("* * * Action Log * * *");
		System.out.print("\n");
		System.out.print(ag.al);

		Assert.assertTrue(newc.getPost() != post);


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
		ag.al.add(a, new ArrayList(), ag.getBB().getAll(), ActionLogEntry.actionSucceeded);
		ag.al.add(a, new ArrayList(), ag.getBB().getAll(), ActionLogEntry.actionSucceeded);
		ag.al.add(a, new ArrayList(), ag.getBB().getAll(), ActionLogEntry.actionSucceeded);
		/* add a belief to show a different outcome is now happening after action execution*/
		//ag.addBel();
		/* Log the threshold amount of failures with a different post condition*/
		ag.al.add(a, new ArrayList(), ag.getBB().getAll(), ActionLogEntry.actionFailed);
		ag.al.add(a, new ArrayList(), ag.getBB().getAll(), ActionLogEntry.actionFailed);
		ag.al.add(a, new ArrayList(), ag.getBB().getAll(), ActionLogEntry.actionFailed);
		/* Trigger deductive learning on action log */

		/* Log another action */
		ag.al.add(a, new ArrayList(), ag.getBB().getAll(), ActionLogEntry.actionSucceeded);
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
