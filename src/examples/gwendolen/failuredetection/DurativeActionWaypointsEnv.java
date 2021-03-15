// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
// 
// This file is part of Gwendolen
//
// Gwendolen is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Gwendolen is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with Gwendolen if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package gwendolen.failuredetection;

import ail.mas.DefaultEnvironment;
import ail.mas.MAS;
import ail.semantics.AILAgent;
import ail.syntax.*;
import ail.util.AILexception;
import ajpf.util.AJPFLogger;
import ajpf.util.choice.UniformBoolChoice;

import java.util.ArrayList;

/**
 * A Simple Blocks' World Environment.
 *
 * @author louiseadennis
 *
 */
public class DurativeActionWaypointsEnv extends DefaultEnvironment {
	static String logname = "gwendolen.failuredetection.DurativeActionEnv";

	// temporarily required for clock
	int seconds = 0;
	int failureCount = 1;
	protected boolean done = false;

	UniformBoolChoice r;
	CapabilityLibrary capLibrary = new CapabilityLibrary();

	public DurativeActionWaypointsEnv() {
		// Make environment
		super();
		AJPFLogger.info(logname, "Environment Created");

		// Make capabilities
/*
		Capability moveW0W1 = new Capability(new GBelief(new Literal("at(waypoint0)")), new Action("moveW0W1"), new Guard(new GBelief(new Literal("-at(waypoint0)")), Guard.GLogicalOp.and, new GBelief(new Literal("at(waypoint1)"))));
		Capability moveW1W2 = new Capability(new GBelief(new Literal("at(waypoint1)")), new Action("moveW0W2"), new Guard(new GBelief(new Literal("-at(waypoint1)")), Guard.GLogicalOp.and, new GBelief(new Literal("at(waypoint2)"))));
		Capability moveW2W3 = new Capability(new GBelief(new Literal("at(waypoint2)")), new Action("moveW0W3"), new Guard(new GBelief(new Literal("-at(waypoint2)")), Guard.GLogicalOp.and, new GBelief(new Literal("at(waypoint3)"))));
		Capability moveW3W4 = new Capability(new GBelief(new Literal("at(waypoint3)")), new Action("moveW0W4"), new Guard(new GBelief(new Literal("-at(waypoint3)")), Guard.GLogicalOp.and, new GBelief(new Literal("at(waypoint4)"))));
*/

		Capability moveW0W1 = new Capability(new GBelief(new Literal("at(waypoint0)")), new Action("moveW0W1"), new GBelief(new Literal("at(waypoint1)")));
		Capability moveW1W2 = new Capability(new GBelief(new Literal("at(waypoint1)")), new Action("moveW0W2"), new GBelief(new Literal("at(waypoint2)")));
		Capability moveW2W3 = new Capability(new GBelief(new Literal("at(waypoint2)")), new Action("moveW0W3"), new GBelief(new Literal("at(waypoint3)")));
		Capability moveW3W4 = new Capability(new GBelief(new Literal("at(waypoint3)")), new Action("moveW0W4"), new GBelief(new Literal("at(waypoint4)")));


		// Add capabilities to environment
		capLibrary.add(moveW0W1);
		capLibrary.add(moveW1W2);
		capLibrary.add(moveW2W3);
		capLibrary.add(moveW3W4);

	}

	/**
	 * When a pickup action is executed the environment stores new perceptions
	 * for the agent - that its picked something up and its hands are now longer
	 * empty.
	 */
	public Unifier executeAction(String agName, Action act) throws AILexception {
		AJPFLogger.info(logname, "Action execution attempted for " + act.getFunctor());
		Unifier theta = new Unifier();
		byte action_state;

		if (act.getFunctor().equals("moveW0W1")) {
			DurativeAction moveW0W1 = new DurativeAction(act, 0, 3);
			if (r.nextBoolean()) {
				Predicate oldlocation = (Predicate) act.getTerm(0);
				Predicate newlocation = new Predicate("at(waypoint1)");
				removePercept(oldlocation);
				addPercept(newlocation);
			}
			action_state = monitorActionState(agName, moveW0W1);
			if (action_state == DurativeAction.actionSucceeded){ //done();
			} else if (action_state == DurativeAction.actionFailed) { executeAction(agName, act);
			} else if (action_state == DurativeAction.actionAbort) { done(); }

		} else if (act.getFunctor().equals("moveW1W2")) {
			DurativeAction moveW1W2 = new DurativeAction(act, 0, 3);
			if (r.nextBoolean()) {
				Predicate oldlocation = (Predicate) act.getTerm(0);
				Predicate newlocation = new Predicate("at(waypoint2)");
				removePercept(oldlocation);
				addPercept(newlocation);
			}
			action_state = monitorActionState(agName, moveW1W2);
			if (action_state == DurativeAction.actionSucceeded){ //done();
			} else if (action_state == DurativeAction.actionFailed) { executeAction(agName, act);
			} else if (action_state == DurativeAction.actionAbort) { done(); }

		} else if (act.getFunctor().equals("moveW2W3")) {
			DurativeAction moveW2W3 = new DurativeAction(act, 0, 3);
			if (r.nextBoolean()) {
				Predicate oldlocation = (Predicate) act.getTerm(0);
				Predicate newlocation = new Predicate("at(waypoint3)");
				removePercept(oldlocation);
				addPercept(newlocation);
			}
			action_state = monitorActionState(agName, moveW2W3);
			if (action_state == DurativeAction.actionSucceeded){ //done();
			} else if (action_state == DurativeAction.actionFailed) { executeAction(agName, act);
			} else if (action_state == DurativeAction.actionAbort) { done(); }

		} else if (act.getFunctor().equals("moveW3W4")) {
			DurativeAction moveW3W4 = new DurativeAction(act, 0, 3);
			if (r.nextBoolean()) {
				Predicate oldlocation = (Predicate) act.getTerm(0);
				Predicate newlocation = new Predicate("at(waypoint4)");
				removePercept(oldlocation);
				addPercept(newlocation);
			}
			action_state = monitorActionState(agName, moveW3W4);
			if (action_state == DurativeAction.actionSucceeded){ //done();
			} else if (action_state == DurativeAction.actionFailed) { executeAction(agName, act);
			} else if (action_state == DurativeAction.actionAbort) { done(); }
		}

		try {
			theta = super.executeAction(agName, act);
		} catch (AILexception e) {
			throw e;
		}

		return theta;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#setMAS(ail.mas.MAS)
	 */
	public void setMAS(MAS m) {
		super.setMAS(m);
		r = new UniformBoolChoice(m.getController());
	}


// fake clock

	public int clock() {
		seconds++;
		return seconds;
	}


// Set termination conditions here

	public byte updateActionState(String agName, DurativeAction act) {
		AILAgent a = agentmap.get(agName);
		ArrayList<Literal> postConditions = capLibrary.getRelevant(act.toPredicate(), AILAgent.SelectionOrder.LINEAR).next().postConditionsToLiterals();

		//cycle the clock and record time passed
		int timepassed = clock();

		if (act.duration > 0) {
			if (act.duration > timepassed) {
				// if action duration < clock, set state to active
				act.setState(DurativeAction.actionActive);
			} else {
				act.setState(DurativeAction.actionPending);
			}
		}
		if ((act.duration == 0 || act.duration == timepassed) && !percepts.containsAll(postConditions)) {
			// if action postconditions =/= percepts
			act.setState(DurativeAction.actionFailed);
			failureCount++;
			agentmap.get(agName).getAFLog().put(act.getFunctor(), failureCount);

			if (a.getAFLog().get(act.getFunctor()) > act.getThreshold(act)){
				act.setState(DurativeAction.actionAbort);
			}

		} else if ((act.duration == 0 || act.duration == timepassed) && percepts.contains(postConditions)) {
			// if action at least one postcondition is part of percepts
			act.setState(DurativeAction.actionSucceededwithFailure);

		} else if ((act.duration == 0 || act.duration == timepassed) && percepts.containsAll(postConditions)) {
			// if action postconditions == percepts
			act.setState(DurativeAction.actionSucceeded);
		} else if (act.duration < timepassed && act.duration != 0) {
			// if action duration < clock, set state to timedout
			act.setState(DurativeAction.actionTimedout);

		}


		return act.getActionState();

	}

	public byte monitorActionState(String agName, DurativeAction act) {

		byte action_state;
		
		do { action_state = updateActionState(agName, act);
			AJPFLogger.info(logname, act.getFunctor() + " is active.");
		} while (action_state == DurativeAction.actionActive);

		if (action_state == DurativeAction.actionTimedout) {
			AJPFLogger.info(logname, act.getFunctor() + " has timed out.");
			seconds = 0;
			return action_state;
		} else if (action_state == DurativeAction.actionFailed) {
			AJPFLogger.info(logname, act.getFunctor() + " has failed.");
			seconds = 0;
			return action_state;
		} else if (action_state == DurativeAction.actionAbort) {
			AJPFLogger.info(logname, act.getFunctor() + " has been aborted due to excessive failure.");
			seconds = 0;
			return action_state;
		} else if (action_state == DurativeAction.actionSucceededwithFailure) {
			AJPFLogger.info(logname, act.getFunctor() + " has succeeded with failure.");
			seconds = 0;
			return action_state;
		} else if (action_state == DurativeAction.actionSucceeded) {
			agentmap.get(agName).getAFLog().put(act.getFunctor(), failureCount);
			AJPFLogger.info(logname, act.getFunctor() + " has succeeded after " + agentmap.get(agName).getAFLog().get(act.getFunctor()).toString() + " attempt(s).");
			failureCount = 1;
			seconds = 0;
			return action_state;
		} else {
			AJPFLogger.info(logname, "Error with action: " + act.getFunctor() + " - Action state pending.");
			return action_state;
		}
	}

/*

	public boolean done() {
		setDone(true);
		return super.done();
	}

	public void setDone(boolean b) {
		done = b;
	}
*/

}