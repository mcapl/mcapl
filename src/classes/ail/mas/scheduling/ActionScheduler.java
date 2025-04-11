// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
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

package ail.mas.scheduling;

import java.util.TreeMap;
import java.util.List;

import ajpf.util.VerifyList;
import ajpf.PerceptListener;
import ajpf.MCAPLScheduler;
import ajpf.MCAPLJobber;
import ajpf.util.AJPFLogger;


/**
 * A Scheduler for agent reasoning which picks and agent (or environment) "at random" and executes it until perceptions
 * change somewhere in the system or the agent goes to sleep.
 * 
 * Note this means that if some part of the system is intended to be continuously operational -
 * e.g. the Environment persistently inserts new perceptions into the system - then this will
 * only happen when agents take actions.  It is better to use the default scheduler for these systems.
 *  
 * @author louiseadennis
 *
 */
public class ActionScheduler implements MCAPLScheduler, PerceptListener { 
	private TreeMap<String, MCAPLJobber> agnames = new TreeMap<String, MCAPLJobber>();
	/* We use VerifyLists to reduce the state space during verification */
	private VerifyList<String> activeAgents = new VerifyList<String>();
	private VerifyList<String> inactiveAgents = new VerifyList<String>();
	private VerifyList<String> donotSchedule = new VerifyList<String>();
	
	private String logname = "ail.mas.ActionScheduler";
	
	/* Flag that indicates a change in the  system somewhere indicating a new choice of 
	 * agent is wanted
	 */
	private boolean somethinghaschanged = true;
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLScheduler#getAvailableJobbers()
	 */
	public List<MCAPLJobber> getAvailableJobbers() {
		List<MCAPLJobber> ags = new VerifyList<MCAPLJobber>();
		if (somethinghaschanged) {
			// Got a Concurrent Modification Error here in the Sticky Wheel example.
			try {
				for (String s: activeAgents) {
					ags.add(agnames.get(s));
				}
			} catch (Exception e) {
				AJPFLogger.warning(logname, e.getMessage());
			}
		}
		somethinghaschanged = false;
		return ags;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLScheduler#getActiveJobberNames()
	 */
	public List<String> getActiveJobberNames() {
		List<String> ags = new VerifyList<String>();
		for (int i = 0; i < activeAgents.size(); i++) {
			ags.add(activeAgents.get(i));
		}
		return ags;
	}

	
	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLScheduler#notActive(java.lang.String)
	 */
	public void notActive(String agName) {
		if (activeAgents.contains(agName)) {
			activeAgents.remove(agName);
			if (!inactiveAgents.contains(agName)) {
				inactiveAgents.put(agName);
			}
		}
		somethinghaschanged = true;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLScheduler#isActive(ajpf.MCAPLAgent)
	 */
	public void isActive(String a) {
		if (!activeAgents.contains(a) && !donotSchedule.contains(a)) {
			activeAgents.put(a);
		}
		somethinghaschanged = true;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLScheduler#addAg(ajpf.MCAPLAgent)
	 */
	public void addJobber(MCAPLJobber a) {
		// System.err.println("Adding jobber " + a.getName());
		agnames.put(a.getName(), a);
		if (!donotSchedule.contains(a.getName())) {
			activeAgents.put(a.getName());
		}
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLScheduler#removeJobber(ajpf.MCAPLJobber)
	 */
	public void removeJobber(String a) {
		agnames.remove(a);
		activeAgents.remove(a);
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.PerceptListener#perceptChanged()
	 */
	public void perceptChanged() {
		// System.err.println("perceptCHanged()");
		somethinghaschanged = true;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.PerceptListener#perceptChanged(java.lang.String)
	 */
	public void perceptChanged(String s) {
		// System.err.println("perceptHCanged" + s);
		somethinghaschanged = true;
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.PerceptListener#getListenerName()
	 */
	public String getListenerName() {
		return "scheduler";
	}

	@Override
	public List<MCAPLJobber> getActiveJobbers() {
		List<MCAPLJobber> ags = new VerifyList<MCAPLJobber>();
		for (int i = 0; i < activeAgents.size(); i++) {
			ags.add(agnames.get(activeAgents.get(i)));
		}
		return ags;
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLScheduler#doNotSchedule(java.lang.String)
	 */
	public void doNotSchedule(String a) {
		donotSchedule.add(a);
		if (activeAgents.contains(a)) {
			activeAgents.remove(a);
		}
		somethinghaschanged = true;
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLScheduler#resumeScheduling(java.lang.String)
	 */
	public void resumeScheduling(String a) {
		donotSchedule.remove(a);
		if (!inactiveAgents.contains(a)) {
			activeAgents.add(a);
		}
		somethinghaschanged = true;
	}
	
	
}