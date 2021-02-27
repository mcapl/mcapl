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
import ail.syntax.*;
import ail.util.AILexception;
import ajpf.util.AJPFLogger;
import ajpf.util.choice.UniformBoolChoice;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Timer;

/**
 * A Simple Blocks' World Environment.
 *
 * @author louiseadennis
 *
 */
public class DurativeActionEnv extends DefaultEnvironment {
	static String logname = "gwendolen.failuredetection.DurativeActionEnv";
	UniformBoolChoice r;
	public DurativeActionEnv() {
		super();
	}

	//HashMap<String, String> actionDescriptions = new HashMap<String, String, String>();
   // actionDescriptions.put("England", "London");


	/**
	 * When a pickup action is executed the environment stores new perceptions
	 * for the agent - that its picked something up and its hands are now longer
	 * empty.
	 */
	public Unifier executeAction(String agName, DurativeAction act) throws AILexception {
		Unifier theta = new Unifier();

		if (act.getFunctor().equals("pickup")) {

			addPercept(agName, new DurativeAction(new Action("holding_block"), 10));
	}

/*			if (act.getFunctor().equals("pickup")) {
				Predicate object = (Predicate) act.getTerm(0);
				removePercept(object);
			} else if (act.getFunctor().equals("putdown")) {
				Predicate object = (Predicate) act.getTerm(0);
				addPercept(object);
			} else if (act.getFunctor().equals("pickup1")) {
				if (r.nextBoolean()) {
					addPercept(new Predicate("block1"));
				}
				if (r.nextBoolean()) {
					addPercept(new Predicate("block2"));
				}
			} else if (act.getFunctor().equals("pickup2")) {
				if (r.nextBoolean()) {
					addPercept(new Predicate("block1"));
				}
				if (r.nextBoolean()) {
					addPercept(new Predicate("block2"));
				}
			} else if (act.getFunctor().equals("random")) {
				if (r.nextBoolean()) {
					AJPFLogger.info(logname, "Block 1 is visible");
					addPercept(new Predicate("block1"));
				} else {
					AJPFLogger.info(logname, "Block 1 is not visible");
				}
				if (r.nextBoolean()) {
					AJPFLogger.info(logname, "Block 2 is visible");
					addPercept(new Predicate("block2"));
				} else {
					AJPFLogger.info(logname, "Block 2 is not visible");
				}
			}
*/

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
		int seconds = 0;
		seconds++;
		return seconds;
	}


// Set termination conditions here

	public byte updateActionState(DurativeAction act) {
		int timepassed = clock();
		if (act.duration < timepassed) {
			// if action duration < clock, set state to timedout
			act.setState(DurativeAction.actionTimedout);

		} else if (!act.getTerms().containsAll((Collection<?>) agPercepts)) {
			// if action postconditions =/= percepts
			act.setState(DurativeAction.actionFailed);

		} else if (((Collection<?>) agPercepts).contains(act.getTerms())) {
			// if action at least one postcondition is part of percepts
			act.setState(DurativeAction.actionSucceededwithFailure);

		} else if (act.getTerms().containsAll((Collection<?>) agPercepts)) {
			// if action postconditions == percepts
			act.setState(DurativeAction.actionSucceeded);
		} else if (act.duration > timepassed) {
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
		} while (action_state == DurativeAction.actionActive);

		if (action_state == DurativeAction.actionTimedout) {
			AJPFLogger.info(logname, act.getFunctor() + "has timed out.");
			return action_state;
		} else if (action_state == DurativeAction.actionFailed) {
			AJPFLogger.info(logname, act.getFunctor() + "has failed.");
			return action_state;
		} else if (action_state == DurativeAction.actionSucceededwithFailure) {
			AJPFLogger.info(logname, act.getFunctor() + "has succeeded with failure.");
			return action_state;
		} else if (action_state == DurativeAction.actionSucceeded) {
			AJPFLogger.info(logname, act.getFunctor() + "has succeeded.");
			return action_state;
		} else {
			AJPFLogger.info(logname, act.getFunctor() + "Error - Action state pending.");
			return action_state;
		}
	}


	/*
	 * (non-Javadoc)
	 * @see eass.mas.DefaultEASSEnvironment#done()
	 */
	public boolean done() {
		setDone(true);
		return super.done();
	}

	public void setDone(boolean b) {
		done = b;
	}
	protected boolean done = false;

}