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
import ajpf.util.AJPFLogger;
import ajpf.util.VerifyMap;
import com.google.common.collect.Sets;
import org.apache.commons.collections15.buffer.CircularFifoBuffer;

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
		ActionLogEntry e = al.getLatestEntry();
		// If the latest log is for a Durative Action, that has a final log of anything but success, and has been logged more than the threshold...
		System.out.print("Performing Check Preconditions");
		if (e != null) {
			if ((e.getAction() instanceof DurativeAction)) {
				System.out.print("Passed Check 1");
				if ((e.getActionOutcomeToString() != "Succeeded")) {
					System.out.print("Passed Check 2");
					if ((al.getLogsForAction(e).getArrayList().size() >= ((DurativeAction) e.getAction()).threshold)) {
						System.out.print("Passed Check 3");
						return true;
					}
					System.out.print(al.getLogsForAction(e).getArrayList().size());
					System.out.print(((DurativeAction) e.getAction()).threshold);

					System.out.print("Failed Check 3");
					return false;
				}
				System.out.print(e.getActionOutcomeToString());
				System.out.print("Failed Check 2");
				return false;
			}
			System.out.print("Failed Check 1");
		}
		return false;


		//if ((e.getAction() instanceof DurativeAction) && (e.getActionOutcome() != ActionLogEntry.actionSucceeded) || (al.getLogsForAction(e).getArrayList().size() >= ((DurativeAction) e.getAction()).threshold)) {
		//	return true;
		//}
		//return false;
	}
			
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		//get environment
		AILEnv env = a.getEnv();
		//init new action postconditions
		Set<Literal> newpc = null;
		//init current success postconditions
		Set<Literal> oldpc;



		// if Action Log for Agent is empty then nothing can be learned.
		if (a.getActionLog() != null) {
			System.out.print("Learning new action description..." + "\n");
			//separate actions into their own logs.
			ActionLog al = a.getActionLog();
			ArrayList<ActionLogEntry> singleActionLog = al.getLogsForAction(al.getLatestEntry()).getArrayList();


			//get the durative action from the last log
			DurativeAction dact = (DurativeAction) al.getLatestEntry().getAction();


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
				if (!e.equals(singleActionLog.get(0))){
					allEqual = false;
				}
				allEqual = true;
			}
			newpc = singleActionLog.get(0).getBeliefs();
			if (allEqual) {
				// convert set of literals to GLogicalFormula - this can live somewhere else.
				GLogicalFormula postconditions = new GBelief();
				//System.out.print("All log entries are identical.");

				if (false){
					for (Literal l : newpc) {
						postconditions = new GBelief(l);
					}
					//System.out.print("I am setting pcs");
				} else {
					for (Literal l : newpc) {
						GLogicalFormula next = new GBelief(l);
						//next means something in temporal logic dont use it as a varaiable name.
						postconditions = new Guard(postconditions, Guard.GLogicalOp.and, next);
						//I can perhaps remove the empty TRUE GBelief after this statement?
					}
				}

				// change action description in agent's cap library
				// get the action predicate
				Predicate p = dact.getActionPredicate();
				// make a new capability with new postconditions
				Capability c = dact.updatePost(postconditions);
				// remove existing capability from agent's caplibrary
				a.getCL().removeRelevant(p);
				// add new cap to library
				System.out.print("New action description learned for" + p.toString() + "\n");
				System.out.print(al.toString());
				a.getCL().add(c);
			} else {
				// if they aren't the same -- count up weights and set new action postconditions to highest scoring log.


				//weight the log entries with most recent entries being worth more.
				Map<Integer, ActionLogEntry> logMap = new VerifyMap<Integer, ActionLogEntry>();
				int w = 0;
				for (ActionLogEntry e : singleActionLog) {
					++w;
					logMap.put(w, e);
				}

				// then loop through again adding the weights up for the same action - making the confidence level.

				//compare to currently stored action outcome

				//OLD IDEA - might work with self model?  if confidence level is higher current stored action outcome - replace.
			}
		}
	}
} 