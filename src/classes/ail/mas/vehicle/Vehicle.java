// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of the Agent Infrastructure Layer (AIL)
// 
// This AIL is free software; you can redistribute it and/or
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

package ail.mas.vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import ajpf.util.VerifySet;
import ajpf.util.VerifyList;
import ajpf.MCAPLScheduler;
import ajpf.PerceptListener;
import ail.mas.MAS;
import ail.semantics.AILAgent;
import ail.syntax.Action;
import ail.syntax.Unifier;
import ail.syntax.Predicate;
import ail.syntax.Message;
import ail.util.AILConfig;
import ail.util.AILexception;

/**
 * A Basic class for Vehicles controlled by some agent that exist in an environment.  The vehicles act as an environment to the agent, but
 * actually pass most information and actions through to the outer environment.
 * @author louiseadennis
 *
 */
public class Vehicle implements VehicleInterface {
	/**
	 * The agent that controls the vehicle.
	 */
	AILAgent agent;
	/**
	 * The vehicle's sensors.
	 */
	VerifyList<Sensor> sensors = new VerifyList<Sensor>();
	/**
	 * The environment the vehicle operates in.
	 */
	VehicleEnv env;
	/**
	 * The vehicle's inbox.
	 */
	VerifySet<Message> inbox = new VerifySet<Message>();
	
	/**
	 * The multi-agent system.
	 */
	MAS mas;
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#executeAction(java.lang.String, ail.syntax.Action)
	 * 
	 * When the agent executes an action this is passed through to the environment.  If we add actuators to vehicles
	 * then they should mediate between the vehicle and the environment.
	 */
	public Unifier executeAction(String agName, Action act) throws AILexception {
		return env.executeAction(agName, act);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#getPercepts(java.lang.String, boolean)
	 * 
	 * The agent gets percepts from the vehicle's sensors.
	 */
	public Set<Predicate> getPercepts(String ag, boolean b) {
		TreeSet<Predicate> percepts = new TreeSet<Predicate>();
		for (Sensor s: sensors) {
			percepts.addAll(s.getPercepts());
		}
		return percepts;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#getMessages(java.lang.String)
	 */
	public Set<Message> getMessages(String s) {
		VerifySet<Message> messages = new VerifySet<Message>();
		for (Message m: inbox) {
			messages.add(m);
		}
		inbox.clear();
		return messages;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#done()
	 */
	public boolean done() {
		return env.done();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#begin()
	 */
	public void begin() {}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#lastAction()
	 */
	public Action lastAction() {
		return env.lastAction();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#lastActionby()
	 */
	public String lastActionby() {
		return env.lastActionby();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#configure(ail.util.AILConfig)
	 */
	public void configure(AILConfig config) {
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#addPerceptListener(ajpf.PerceptListener)
	 */
	public void addPerceptListener(PerceptListener p) {
		env.addPerceptListener(p);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#addAgent(ail.semantics.AILAgent)
	 */
	public void addAgent(AILAgent a) {
		agent = a;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#getScheduler()
	 */
	public MCAPLScheduler getScheduler() {
		return env.getScheduler();
	}
	    
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#setScheduler(ajpf.MCAPLScheduler)
	 */
	public void setScheduler(MCAPLScheduler s) {
		env.setScheduler(s);
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Vehicle v) {
		return getName().compareTo(v.getName());
	}
	
	/**
	 * We use the name of the agent as a name for the vehicle.  And use this to provide a hacky version of compareTo.
	 * @return
	 */
	public String getName() {
		return agent.getAgName();
	}
	
	/**
	 * Add a message to the inbox.
	 * @param m
	 */
	public void addMessage(String agName, Message m) {
		inbox.add(m);
	}
	
	/**
	 * Remove a message from the inbox.
	 * @param m
	 */
	public void removeMessage(Message m) {
		inbox.remove(m);
	}
	
	/**
	 * Clear the inbox.
	 */
	public void clearMessages() {
		inbox.clear();
	}

	/**
	 * Add a percept to the sensors.
	 * @param l
	 */
	public void addPercept(Predicate l) {
		for (Sensor s: sensors) {
			s.addPercept(l);
		}
	}

	/**
	 * Remove a percept from the sensors.
	 * @param l
	 */
	public boolean removePercept(Predicate l) {
		for (Sensor s: sensors) {
			s.removePercept(l);
		}
		
		return true;
	}
	
	/**
	 * Clear the sensors.
	 */
	public void clearPercepts() {
		for (Sensor s: sensors) {
			s.clearPercepts();
		}
	}
	
	/**
	 * Add a sensor to the vehicle.
	 * @param s
	 */
	public void addSensor(Sensor s) {
		sensors.add(s);
	}
	
	/**
	 * Set the vehicle's environment.
	 * @param e
	 */
	public void setEnv(VehicleEnv e) {
		env = e;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	public void cleanup() {}

	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#init_before_adding_agents()
	 */
	@Override
	public void init_before_adding_agents() {}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#init_after_adding_agents()
	 */
	@Override
	public void init_after_adding_agents() {}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#executing(java.lang.String, ail.syntax.Action)
	 */
	public boolean executing(String agName, Action act) {
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#actionResult(java.lang.String, ail.syntax.Action)
	 */
	public Unifier actionResult(String agName, Action act) {
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#agentIsUpToDate(java.lang.String)
	 */
	public boolean agentIsUpToDate(String agName) {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#setMAS(ail.mas.MAS)
	 */
	@Override
	public void setMAS(MAS m) {
		mas = m;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#notifyListeners()
	 */
	@Override
	public void notifyListeners() {
		env.notifyListeners();
	}

	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#notifyListeners(java.lang.String)
	 */
	@Override
	public void notifyListeners(String name) {
		env.notifyListeners(name);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#getAgents()
	 */
	@Override
	public List<AILAgent> getAgents() {
		ArrayList<AILAgent> agents = new ArrayList<AILAgent>();
		agents.add(agent);
		return agents;
	}

}
