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
		return true;
	}
			
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		AILEnv env = a.getEnv();

		// if Action Log for Agent is empty then nothing can be learned.
		if (a.getActionLog() != null) {
			//separate actions into their own logs.
			ActionLog al = a.getActionLog();
			ActionLog singleActionLog = al.getLogsFor(al.getLatestEntry());
			//weight the log entries with most recent entries being worth more.
			Map<Integer, ActionLogEntry> logMap = new VerifyMap<Integer, ActionLogEntry>();
			int w = 0;
			for (ActionLogEntry e: singleActionLog.getArrayList()) {
				++w;
				logMap.put(w, e);
			}
			// -- ACTION OUTCOME DISCOVERY -- maximise confidence level
			// Loop through action log, until the action outcome is different to the stored one. If it is the same - break loop
			for (ActionLogEntry e: singleActionLog.getArrayList()) {
				if (e.getActionOutcome() == ActionLogEntry.actionSucceeded);
				singleActionLog.removeEntry(e);
			}
			// --
			// then loop through again adding the weights up for the same action - making the confidence level.

			//compare to currently stored action outcome

			//if confidence level is higher current stored action outcome - replace.
		}
	}
} 