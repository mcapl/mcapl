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

package ail.mas.eis;

import java.util.Collection;
import java.util.Set;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.HashSet;

import ail.mas.AILEnv;
import ail.mas.MAS;
import ail.semantics.AILAgent;
import ail.syntax.Action;
import ail.syntax.Message;
import ail.syntax.Predicate;
import ail.syntax.Unifier;
import ail.util.AILConfig;
import ail.util.AILexception;

import ajpf.MCAPLScheduler;
import ajpf.MCAPLcontroller;
import ajpf.PerceptListener;
import ajpf.util.AJPFLogger;

import eis.*;
import eis.iilang.EnvironmentState;
import eis.iilang.Percept;
import eis.exceptions.*;
import gov.nasa.jpf.annotation.FilterField;

import com.igormaznitsa.prologparser.PrologParser;

public class EISEnvironmentWrapper implements AILEnv, EnvironmentListener,
		AgentListener {
	EnvironmentInterfaceStandard eis_environment = null;
	String logname = "ail.mas.eas.EISEnvironmentWrapper";
	Map<String, Set<Predicate>> agentpercepts = new HashMap<String, Set<Predicate>>();
	PrologParser parser;
	MCAPLScheduler scheduler;
	List<AILAgent> agents = new ArrayList<AILAgent>();

	/**
	 * The multi-agent system this environment is part of.
	 */
	protected MAS mas;
	
	/**
	 * The list of percept listeners.
	 */
	@FilterField
	private static List<PerceptListener> perceptListeners = new ArrayList<PerceptListener>();
	
	public EISEnvironmentWrapper(String jarFileName) {
		try {
			String filename = MCAPLcontroller.getFilename(jarFileName);
			eis_environment = EILoader.fromJarFile(new File(filename));
		} catch (Exception e) {
			AJPFLogger.severe(logname, e.getMessage());
		}
		
		eis_environment.attachEnvironmentListener(this);
	}
	
	public void begin() {
		try {
			if (eis_environment.getState().equals(EnvironmentState.PAUSED)) {
				if (eis_environment.isStartSupported()) {
					eis_environment.start();
				}				
			} else {
				if (eis_environment.isPauseSupported()) {
					eis_environment.pause();
					if (eis_environment.isStartSupported()) {
						eis_environment.start();
					}
				}
			}
		} catch (Exception e) {
			AJPFLogger.severe(logname, e.getMessage());
		}		
	}
	
	public EnvironmentInterfaceStandard getEISEnvironment() {
		return eis_environment;
	}

	@Override
	public void handlePercept(String arg0, Percept arg1) {
			agentpercepts.get(arg0).add(new EISPercept(arg1).toPredicate());
			notifyListeners(arg0);
	}
	

	@Override
	public void handleDeletedEntity(String arg0, Collection<String> arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleFreeEntity(String arg0, Collection<String> arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleNewEntity(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleStateChange(EnvironmentState arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Unifier executeAction(String agName, Action act) throws AILexception {
		try {
			eis_environment.performAction(agName, new EISAction(act).getAction());
			Map<String, PerceptUpdate> ps = eis_environment.getPercepts(agName);
		//	eis_environment.getAllPercepts(arg0, arg1)
			for (String ag: ps.keySet()) {
				for (Percept p: ps.get(ag).getAddList()) {
					Predicate ep = (new EISPercept(p)).toPredicate();
					(agentpercepts.get(agName)).add(ep);
				}
			}
		} catch (ActException e) {
			AJPFLogger.severe(logname, e.getMessage());
		} catch (PerceiveException e) {
			AJPFLogger.severe(logname, e.getMessage());
        }

        notifyListeners();
		return new Unifier();
	}

	@Override
	public Set<Predicate> getPercepts(String agName, boolean update) {
		// TODO Auto-generated method stub
		Set<Predicate> preds = new HashSet<Predicate>();
		for (Predicate p: agentpercepts.get(agName)) {
			preds.add(p);
		}
		try {
			for (PerceptUpdate ps: (eis_environment.getPercepts(agName)).values()) {
				for (Percept p: ps.getAddList()) {
					preds.add(new EISPercept(p).toPredicate());
					//System.err.println(p);
				}
			}
			for (String e_name: eis_environment.getAssociatedEntities(agName)) {
				for (PerceptUpdate ps: (eis_environment.getPercepts(agName, e_name)).values()) {
					for (Percept p: ps.getAddList()) {
						preds.add(new EISPercept(p).toPredicate());
					}
				}
				
			}
		} catch (Exception e) {
			AJPFLogger.warning(logname, e.getMessage());
		}
		
		agentpercepts.get(agName).clear();
		return preds;
	}

	@Override
	public Set<Message> getMessages(String AgName) {
		// TODO Auto-generated method stub
		return new HashSet<Message>();
	}

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Action lastAction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String lastActionby() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void configure(AILConfig config) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPerceptListener(PerceptListener p) {
		perceptListeners.add(p);

	}

	@Override
	public void addAgent(AILAgent a) {
		// TODO Auto-generated method stub
		try {
			eis_environment.registerAgent(a.getAgName());
		} catch (AgentException e) {
			AJPFLogger.severe(logname, e.getMessage());
		} catch (Exception e) {
			AJPFLogger.warning(logname, e.getMessage());
			e.printStackTrace();
		}
		eis_environment.attachAgentListener(a.getAgName(), this);
		agentpercepts.put(a.getAgName(), new HashSet<Predicate>());
		agents.add(a);
		
	}

	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#getScheduler()
	 */
	public MCAPLScheduler getScheduler() {
		return scheduler;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#setScheduler(ajpf.MCAPLScheduler)
	 */
	public void setScheduler(MCAPLScheduler s) {
		scheduler = s;
	}

	@Override
	public void init_before_adding_agents() {
		// TODO Auto-generated method stub

	}
	
	public void init_after_adding_agents() {
		
	}
	
	public void cleanup() {
		try {
			if (eis_environment.isKillSupported()) {
				eis_environment.kill();
			}
		} catch (ManagementException e) {
			AJPFLogger.warning(logname, e.getMessage());
		}
	}

	@Override
	public boolean executing(String agName, Action act) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Unifier actionResult(String agName, Action act) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean agentIsUpToDate(String agName) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public EnvironmentInterfaceStandard getEIS() {
		return eis_environment;
	}
	
    /**
     * Notify the listeners that the perceptions have changed.
     *
     */
    public void notifyListeners() {
    	if (perceptListeners != null) {
    		for (PerceptListener l: perceptListeners) {
    			l.perceptChanged("perception changed");
     		}
    	}
    }

    /**
     * Notify the listeners that a particular agent's perceptions have changed.
     * 
     * @param s the name of the agent whose perceptions have changed.
     */
    public void notifyListeners(String s) {
     	if (perceptListeners != null) {
    		for (PerceptListener l: perceptListeners) {
    			// NB.  We also inform the scheduler as well as any listener associated with the agent.
     			if (l.getListenerName().equals(s) || l.getListenerName().equals("scheduler")) {
    				l.perceptChanged(s);
    			}
    		}
    	}
     	
    }
    
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#setMAS(ail.mas.MAS)
	 */
	@Override
	public void setMAS(MAS m) {
		mas = m;
	}

	
	@Override
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#getAgents()
	 */
	public List<AILAgent> getAgents() {
		return agents;
	}



}
