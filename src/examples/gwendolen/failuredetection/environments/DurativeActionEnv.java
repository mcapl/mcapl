/*
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
import ajpf.util.VerifySet;
import ajpf.util.choice.UniformBoolChoice;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

*
 * A Simple Blocks' World Environment.
 *
 * @author louiseadennis
 *


public class DurativeActionEnv extends DefaultEnvironment {
	static String logname = "gwendolen.failuredetection.DurativeActionEnv";
	// temporarily required for clock
	int seconds = 0;

	UniformBoolChoice r;

	//this might trigger errors in old test file.
	protected boolean done = false;

	// Make Capability Library
	CapabilityLibrary capLibrary = new CapabilityLibrary();


	public DurativeActionEnv() {
		// Make environment
		super();


		// Make capabilities
		Capability pickup = new Capability(new GBelief(new Literal("empty")), new Action("pickup"), new GBelief(new Literal("holding_block")));

		// Add capabilities to environment
		capLibrary.add(pickup);

	}

*
	 * When a pickup action is executed the environment stores new perceptions
	 * for the agent - that its picked something up and its hands are now longer
	 * empty.


	public Unifier executeAction(String agName, DurativeAction act) throws AILexception {
		Unifier theta = new Unifier();
 if (act.getFunctor().equals("pickup")) {
			DurativeAction pickup = new DurativeAction(act, 10, 3);
			if (monitorActionState(agName, pickup) == DurativeAction.actionSucceeded){
				addPercept(new Predicate("holding_block"));
			}
		} else if (act.getFunctor().equals("putdown")) {
			DurativeAction putdown = new DurativeAction(act, 10, 3);
			if (monitorActionState(agName, putdown) == DurativeAction.actionSucceeded){
				addPercept(new Predicate("not_holding_block"));
				done();
			}
		}



		try {
			theta = super.executeAction(agName, act);
		} catch (AILexception e) {
			throw e;
		}

		return theta;
	}

	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#setMAS(ail.mas.MAS)


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

	public byte updateActionState(DurativeAction act) {
		//need to rework for multi-agent -  agentmap.get?agName
		AILAgent a = super.getAgents().get(0);

		//create the required sets for the if statements
		Set<Predicate> agentPercepts = percepts;
		Set<String> postConditions = capLibrary.getRelevant(act.toPredicate(), AILAgent.SelectionOrder.LINEAR).next().getPost().getVarNames();
		//cycle the clock and record time passed
		int timepassed = clock();

		if (act.duration < timepassed) {
			// if action duration < clock, set state to timedout
			act.setState(DurativeAction.actionTimedout);

		} else if (!percepts.containsAll(postConditions)) {
			// if action postconditions =/= percepts
			act.setState(DurativeAction.actionFailed);

		} else if (agentPercepts.contains(postConditions)) {
			// if action at least one postcondition is part of percepts
			act.setState(DurativeAction.actionSucceededwithFailure);

		} else if (postConditions.containsAll(agentPercepts)) {
			// if action postconditions == percepts
			act.setState(DurativeAction.actionSucceeded);
		}

		if (act.duration > timepassed) {
			// if action duration < clock, set state to active
			act.setState(DurativeAction.actionActive);
		} else {
			act.setState(DurativeAction.actionPending);
		}

		return act.getActionState();

	}

	public byte monitorActionState(String agName, DurativeAction act) {

		byte action_state;

		do { action_state = updateActionState(act);
			AJPFLogger.info(logname, act.getFunctor() + " is active.");
		} while (action_state == DurativeAction.actionActive);

		if (action_state == DurativeAction.actionTimedout) {
			AJPFLogger.info(logname, act.getFunctor() + " has timed out.");
			return action_state;
		} else if (action_state == DurativeAction.actionFailed) {
			AJPFLogger.info(logname, act.getFunctor() + " has failed.");
			return action_state;
		} else if (action_state == DurativeAction.actionSucceededwithFailure) {
			AJPFLogger.info(logname, act.getFunctor() + " has succeeded with failure.");
			return action_state;
		} else if (action_state == DurativeAction.actionSucceeded) {
			AJPFLogger.info(logname, act.getFunctor() + " has succeeded.");
			return action_state;
		} else {
			AJPFLogger.info(logname, "Error with action: " + act.getFunctor() + " - Action state pending.");
			return action_state;
		}
	}


	public boolean done() {
		setDone(true);
		return super.done();
	}

	public void setDone(boolean b) {
		done = b;
	}

}
*/
