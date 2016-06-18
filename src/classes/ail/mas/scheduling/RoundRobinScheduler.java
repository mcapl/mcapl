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

import ajpf.MCAPLJobber;
import ajpf.MCAPLScheduler;
import ajpf.PerceptListener;
import ajpf.util.VerifyList;

/**
 * This is a scheduler that executes each Jobber (typically the agents and the
 * Environment) in turn (and switches between them when something changes).  
 * Since there is no random element using a Round Robin
 * Scheduler with model checking does not create branch points whenever control
 * changes between jobbers.  This will reduce state space but may reduce the
 * fidelity to the system of interest.
 * 
 * @author louiseadennis
 *
 */
public class RoundRobinScheduler implements MCAPLScheduler, PerceptListener  {
	private TreeMap<String, MCAPLJobber> agnames = new TreeMap<String, MCAPLJobber>();
	/* We use VerifyLists to reduce the state space during verification */
	private VerifyList<String> agents = new VerifyList<String>();
	private int turn = 0;

	/*Flag that indicates a change in the  system somewhere indicating a new choice of 
	 * agent is wanted
	 */
	// private boolean somethinghaschanged = true;

	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLScheduler#getActiveAgents()
	 */
	public List<MCAPLJobber> getActiveJobbers() {
		List<MCAPLJobber> ags = new VerifyList<MCAPLJobber>();
		for (String name: agents) {
			ags.add(agnames.get(name));
		}
		return ags;
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLScheduler#getActiveJobberNames()
	 */
	public List<String> getActiveJobberNames() {
		List<String> ags = new VerifyList<String>();
		for (String name: agents) {
			ags.add(name);
		}
		return ags;
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLScheduler#notActive(java.lang.String)
	 */
	public void notActive(String agName) {
		// somethinghaschanged = true;
		if (agents.contains(agName)) {
			if (agents.indexOf(agName) <= turn) {
				turn--;
			}
		}
		agents.remove(agName);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLScheduler#isActive(ajpf.MCAPLAgent)
	 */
	public void isActive(String a) {
		// somethinghaschanged = true;
		if (!agents.contains(a)) {
			agents.add(a);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLScheduler#addAg(ajpf.MCAPLAgent)
	 */
	public void addJobber(MCAPLJobber a) {
		agnames.put(a.getName(), a);
		agents.put(a.getName());
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLScheduler#removeJobber(ajpf.MCAPLJobber)
	 */
	public void removeJobber(String a) {
		agnames.remove(a);
		agents.remove(a);
	}

	
	/*
	 * (non-Javadoc)
	 * @see ajpf.PerceptListener#perceptChanged()
	 */
	public void perceptChanged() {
		// somethinghaschanged = true;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.PerceptListener#perceptChanged(java.lang.String)
	 */
	public void perceptChanged(String s) {
		// somethinghaschanged = true;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.PerceptListener#getListenerName()
	 */
	public String getListenerName() {
		return "scheduler";
	}
	
	/**
	 * Find out which agent's turn it is.
	 * @return
	 */
	public int getTurn() {
		return turn;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLScheduler#doNotSchedule(java.lang.String)
	 */
	public void doNotSchedule(String a) {
		agents.remove(a);
	//	somethinghaschanged = true;
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLScheduler#resumeScheduling(java.lang.String)
	 */
	public void resumeScheduling(String a) {
		agents.add(a);
	//	somethinghaschanged = true;
	}


	@Override
	public List<MCAPLJobber> getAvailableJobbers() {
		List<MCAPLJobber> ags = new VerifyList<MCAPLJobber>();
		if (agents.size() > 0) {
			String name = agents.get(turn);
			ags.add(agnames.get(name));
			turn++;
			if (turn == agents.size()) {
				turn = 0;
			}
		}
// 		somethinghaschanged = false;
		return ags;
	}


}
