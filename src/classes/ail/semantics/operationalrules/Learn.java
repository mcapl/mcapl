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

import ail.mas.AILEnv;
import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import ail.syntax.*;
import ajpf.util.VerifyMap;
import gov.nasa.jpf.util.Pair;

import java.lang.reflect.Array;
import java.util.*;


/**
 * Perception rule.  Gets a list of all literals the agent can perceive from the
 * environment.  It all gets a list of things the agent believes it can perceive
 * from the agent and compares the two.  Any discrepancies are turned into intentions
 * to either add or delete beliefs.
 * 
 * @author lad
 *
 */
public class Learn implements OSRule {
	private static final String name = "Learn";
	String logname = "ail.semantics.operationalrules.Learn";
	
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
		ActionLog al = a.getActionLog();
		//ActionLogEntry e = al.getLatestEntry();

		// If the latest log is for a Durative Action, that has a final log of anything but success, and has been logged more than the threshold...
		//System.out.print("Performing Check Preconditions");
		if (!a.getDA().isEmpty()) {
			DurativeAction dact = a.getDA().get(0);
			ActionLogEntry e = al.getLogsForAction(dact).getLatestEntry();
			if (e != null) {
				if (dact instanceof DurativeAction) {
					//System.out.print("Passed Check 1");
					if ((e.getActionOutcomeToString() != "Succeeded")) {
						//System.out.print("Passed Check 2");
						if (al.getLogsForAction(e).getArrayList().size() >= dact.threshold) {
							//System.out.print("Passed Check 3");
							return true;
						}
						System.out.print(al.getLogsForAction(e).getArrayList().size());
						System.out.print(dact.threshold);

						System.out.print("Failed Check 3 - Action is a Success" + "\n");
						return false;
					}
					//System.out.print(e.getActionOutcomeToString());
					System.out.print("Failed Check 2 - Action is not Durative" + "\n");
					return false;
				}
				System.out.print("Failed Check 1 - Action Log is null" + "\n");
			}
		}
		return false;
	}
			
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		CapabilityLibrary cl = a.getCL();
		//get environment
		AILEnv env = a.getEnv();
		//init new action postconditions
		Set<Literal> newpc = null;
		//init current success postconditions
		Set<Literal> oldpc;
		// if Action Log for Agent is empty then nothing can be learned.
		DurativeAction dact = a.getDA().get(0);
		Guard postconditions = null;
		if (a.getActionLog() != null) {
			System.out.print("Learning new action description..." + "\n");
			//separate actions into their own logs.
			ActionLog al = a.getActionLog();
			ArrayList<ActionLogEntry> singleActionLog = al.getLogsForAction(dact).getArrayList();
			// Loop through action log, until the action outcome is different to the stored one. If it is the same - break loop
			ArrayList<ActionLogEntry> entriesToRemove = new ArrayList<>();

			for (ActionLogEntry e : singleActionLog) {
				//for now just remove any successes but take note of their postconditions.
				if (e.getActionOutcome() == ActionLogEntry.actionSucceeded) {
					oldpc = e.getBeliefs();
					entriesToRemove.add(e);
				}
				singleActionLog.removeAll(entriesToRemove);
			}
			// -- check if the failures are the same EXACT failure, if they are then update postconditions.
			boolean allEqual = false;
			for (ActionLogEntry e : singleActionLog) {
				if (!e.equals(singleActionLog.get(0))) {
					allEqual = false;
				}
				allEqual = true;
			}
			if (allEqual) {
				newpc = singleActionLog.get(0).getBeliefs();
			} else {
				//weight the log entries with most recent entries being worth more.
				List<Pair<ActionLogEntry, Integer>> weightArray = new ArrayList<Pair<ActionLogEntry, Integer>>();
				int index = 0;
				int value = 0;
				for (ActionLogEntry e : singleActionLog) {
					if (weightArray.contains(e)) {
						for (Pair weightEntry : weightArray) {
							index = weightArray.indexOf(e);
						}
						value = value + weightArray.get(index)._2;
						weightArray.remove(e);
						weightArray.set(index, new Pair(e, value));
					} else {
						weightArray.add(index, new Pair(e, value));
					}
					++index;
					++value;
				}
				value = 0;
				index = 0;
				while (weightArray.size() > index){
					if (weightArray.get(index)._2 > value) {
						newpc = weightArray.get(index)._1.getBeliefs();
					}
				}
			}
			// set new postconditions
			boolean firstloop = true;
			for (Literal l : newpc) {
				GLogicalFormula belief = new GBelief(l);
				if (firstloop = true) {
					postconditions = new Guard(belief);
					firstloop = false;
				} else {
					postconditions = new Guard(postconditions, Guard.GLogicalOp.and, belief);
				}
			}
		}

		// change action description in agent's cap library
		// get the action predicate
		cl.removeCapability(dact);
		//System.out.println(cl.getCapabilitiesArrayList());
		Predicate p = dact.getActionPredicate();
		// make a new capability with new postconditions
		DurativeAction dactprime = dact.updatePost(postconditions);
		// remove existing capability from agent's caplibrary

		// add new cap to library
		//System.out.print("New postcondition learned for" + " " + p.toString() + ": " + dactprime.getPost().toString() + "\n");
		//System.out.print(al.toString());
		a.getCL().add(dactprime);
		a.addToLearnedActions(dactprime);
		a.getSA().remove(dactprime);
		a.getDA().remove(dactprime);
		//System.out.println(a.getLA().toString());
		//System.out.print(a.getBB().toString()+ "\n");
		//a.getReasoningCycle().setStopandCheck(true);
	}
}
			//compare to currently stored action outcome

			//OLD IDEA - might work with self model?  if confidence level is higher current stored action outcome - replace.

