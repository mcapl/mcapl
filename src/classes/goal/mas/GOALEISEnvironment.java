// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis, Michael Fisher, and Koen Hindriks
// 
// This file is part of AIL GOAL.  An AIL Implementation of the GOAL Programming
// Language
//
// AIL GOAL is free software: you can redistribute it and/or modify it under
// the terms of the GNU General Public License as published by the Free Software
// Foundation, either version 3 of the License, or (at your option) any later
// version.
//
// AIL GOAL is distributed in the hope that it will be useful, but WITHOUT
// ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
// FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
// details.
//
// You should have received a copy of the GNU General Public License along with
// this program. If not, see <http://www.gnu.org/licenses/>.
//
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------
package goal.mas;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import eis.EnvironmentInterfaceStandard;
import eis.iilang.Identifier;
import eis.iilang.Parameter;
import goal.syntax.GoalMessage;
import goal.util.LaunchPolicy;
import ail.mas.eis.EISEnvironmentWrapper;
import ail.mas.scheduling.ActionScheduler;
import ail.semantics.AILAgent;
import ail.syntax.Message;
import ail.syntax.Predicate;
import ail.util.AILConfig;
import ajpf.MCAPLcontroller;
import ajpf.util.AJPFLogger;
import ajpf.util.VerifyMap;
import ajpf.util.VerifySet;

public class GOALEISEnvironment extends EISEnvironmentWrapper implements GOALEnv {
	
	String logname = "goal.mas.GOALEISEnvironment";
	
	LaunchPolicy lp;
	Map<String, Parameter> initMap = new HashMap<String, Parameter>();

	/**
	 * A map of agents to their pending messages.
	 */
	private Map<String, VerifySet<Message>> agMessages = new VerifyMap<String, VerifySet<Message>>();

	
	public GOALEISEnvironment(String filename) {
		super(filename);
		ActionScheduler s = new ActionScheduler();
		setScheduler(s);
		addPerceptListener(s);
		lp = new LaunchPolicy(getEISEnvironment());
	}
	
	public LaunchPolicy getLaunchPolicy() {
		return lp;
	}
	
	@Override
	public void addAgent(AILAgent a) {
		super.addAgent(a);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.eis.EISEnvironmentWrapper#init_before_adding_agents()
	 */
	@Override
	public void init_before_adding_agents() {
		EnvironmentInterfaceStandard eis = getEISEnvironment();
		
		try {
			eis.init(initMap);
		} catch (Exception e) {
			AJPFLogger.severe(logname, e.getMessage());
		}
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.eis.EISEnvironmentWrapper#init_after_adding_agents()
	 */
	public void init_after_adding_agents() {
		getLaunchPolicy().associateEntities();
		GoalEnvironment.sendEnvironmentAgentBeliefs(this);
	}

	public void addFileToInitMap(String s, String f) {
		try {
			String filename = MCAPLcontroller.getFilename(f);
			initMap.put(s, new Identifier(filename));
		} catch (Exception e) {
			AJPFLogger.severe(logname, e.getMessage());
		}
	}
	
	public void addToInitMap(String s, Identifier i) {
		try {
			initMap.put(s, i);
		} catch (Exception e) {
			AJPFLogger.severe(logname, e.getMessage());
		}
	}

	@Override
	public void handleNewEntity(String arg0) {
		getLaunchPolicy().handleNewEntity(arg0);
	}
	
	@Override
	public Set<Message> getMessages(String agName) {
		// NB.  agMessages is not being initialised for EIS environments.  This probably needs fixing.
    	if (agMessages.get(agName) == null || agMessages.get(agName).isEmpty()) {
			return new VerifySet<Message>();
		}

    	Set<Message> agl = agMessages.get(agName);
     	VerifySet<Message> p = new VerifySet<Message>();
		
    	if (agl != null) {
    		p.addAll(agl);
    		clearMessages(agName);
    	}
		
    	return p;
	}
	
	/** Clears the list of  messages of a specific agent */
	private void clearMessages(String agName) {
			if (agName != null) {
				VerifySet<Message> agl = agMessages.get(agName);
				if (agl != null) {
					 agl.clear();
				}
			}
	 }

	@Override
	public void postMessage(GoalMessage msg) {
		Set<String> rs = msg.getReceivers();
		for (String agName: rs) {
			if (msg != null && agName != null) {
				VerifySet<Message> msgl = agMessages.get(agName);
				if (msgl == null) {
					msgl = new VerifySet<Message>();
					msgl.add(msg);
					agMessages.put( agName, msgl);
				} else {
					boolean havem = false;
					for (Message m: msgl) {
						if (m.compareTo(msg) == 0) {
							havem = true;
							break;
						}
					}
					if (!havem) {
						msgl.add(msg);
					}
				}
			}
			notifyListeners(agName);	
		}
	}
	
	@Override
	public void configure(AILConfig config) {
		for (String s: config.stringPropertyNames()) {
			if (s.startsWith("goal.launchpolicy")) {
				getLaunchPolicy().configure(config);
				break;
			}
		}
	}




	
}
