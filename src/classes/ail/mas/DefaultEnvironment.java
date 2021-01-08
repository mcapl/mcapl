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
//
// This file is based on code from the Open Source software "Jason", copyright
// by Jomi F. Hubner and Rafael H. Bordini.  http://jason.sf.net
//----------------------------------------------------------------------------

package ail.mas;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashSet;

import gov.nasa.jpf.annotation.FilterField;
import ail.util.AILexception;
import ail.util.AILConfig;
import ail.mas.scheduling.ActionScheduler;
import ail.semantics.AILAgent;
import ail.syntax.Unifier;
import ail.syntax.Message;
import ail.syntax.Action;
import ail.syntax.SendAction;
import ail.syntax.BroadcastSendAction;
import ail.syntax.Term;
import ail.syntax.VarTerm;
import ail.syntax.NumberTermImpl;
import ail.syntax.NumberTerm;
import ail.syntax.StringTerm;
import ail.syntax.StringTermImpl;
import ail.syntax.Predicate;
import ajpf.util.VerifySet;
import ajpf.util.VerifyMap;
import ajpf.PerceptListener;
import ajpf.MCAPLScheduler;
import ajpf.util.AJPFLogger;
import monitor.Monitor;
import monitor.Monitorable;
import ail.syntax.PredicatewAnnotation;


/**
 * A more or less straightforward implementation of AILEnv.  Intended for use in languages
 * which don't require a specific environment and sub-classable for specific applications.
 *
 * @author louiseadennis
 *
 */
public class DefaultEnvironment implements AILEnv {

	/**
	 * List of things that all agents can perceive
	 */
	protected VerifySet<Predicate> percepts = new VerifySet<Predicate>();
	/**
	 * List of things only some agents can percieve indexed by agent.
	 */
	protected Map<String,VerifySet<Predicate>>  agPercepts = new VerifyMap<String, VerifySet<Predicate>>();
	/**
	 * List of agents who have already "collected" the current set of percepts.
	 */
	protected VerifySet<String> uptodateAgs = new VerifySet<String>();

	/**
	 * A map of agents to their pending messages.
	 */
	protected Map<String, VerifySet<Message>> agMessages = new VerifyMap<String, VerifySet<Message>>();

	/**
	 * The list of percept listeners.
	 */
	@FilterField
	private static List<PerceptListener> perceptListeners = new ArrayList<PerceptListener>();

	/**
	 * Maps agent names to their objects - useful for print outs.
	 */
	public Map<String, AILAgent> agentmap = new VerifyMap<String, AILAgent>();

	/**
	 * The last agent to do an action.
	 */
	@FilterField
	public String lastAgent;

	/**
	 * The last action performed.
	 */
	@FilterField
	public Action lastAction;

	/**
	 * The scheduler associated with this environment
	 */
	protected MCAPLScheduler scheduler;

	/**
	 * The multi-agent system this environment is part of.
	 */
	protected MAS mas;

	private Monitor monitor;

	private String lastEvent;

	private boolean consistent = true;

	/**
	 * Name for logging.
	 */
	@FilterField
	String logname = "ail.mas.DefaultEnvironment";

	/**
	 * Create a new Default Environment and set the scheduler as an Action Scheduler.
	 */
	public DefaultEnvironment() {
		ActionScheduler s = new ActionScheduler();
		setScheduler(s);
		addPerceptListener(s);
	}
	
	public void initialise_monitor() {
		if(this instanceof Monitorable){
			Monitorable monMe = (Monitorable) this;
			monitor = new Monitor(monMe.getTraceExpressionPath());
			monitor.initialize(monMe.getLogFilePath(), monMe.getProtocolName());
		}
	}

	/**
	 * Add an agent to the list the environment knows about.
	 * @param a
	 */
	public void addAgent(AILAgent a) {
		agentmap.put(a.getAgName(), a);
		VerifySet<Message> msgl = new VerifySet<Message>();
		if (agMessages.get(a.getAgName()) == null) {
			agMessages.put(a.getAgName(), msgl);
			// Random dummy message added and removed to assist state matching during verification.
			addMessage(a.getAgName(), new Message());
			clearMessages(a.getAgName());
		}
		if (agPercepts.get(a.getAgName()) == null) {
			VerifySet<Predicate> agl = new VerifySet<Predicate>();
			agPercepts.put(a.getAgName(), agl);
		}
	}

	/**
	 * Add a percept listener to the environment.
	 * @param l
	 */
	public void addPerceptListener(PerceptListener l) {
		if (perceptListeners == null) {
			perceptListeners = new ArrayList<PerceptListener>();
		}
		perceptListeners.add(l);
	 }

	/**
	 * Remove a percept listener from the environment.
	 * @param l
	 */
	public void removePerceptListener(PerceptListener l) {
	 		perceptListeners.remove(l);
	}


	/**
	 * The conditions under which an agent reasoning cycle should be stopped
	 * and conditions checked.
	 * @param agName
	 * @param act
	 */
	public void decidetostop(String agName, Action act) {
		if (agentmap.get(agName) != null) {
			agentmap.get(agName).getReasoningCycle().setStopandCheck(true);
		}
	}


	/*
	 * (non-Javadoc)
	 * @see ail.others.AILEnv#executeAction(java.lang.String, ail.syntax.Structure)
	 */
    public Unifier executeAction(String agName, Action act) throws AILexception {

    	decidetostop(agName, act);
    	if (!act.getFunctor().equals("print")) {
    		lastAgent = agName;
    		lastAction = act;
    	}
    	Unifier u = new Unifier();

    	// Some basic actions you might expect all environments to support
    	if (act instanceof SendAction) {
    		executeSendAction(agName, (SendAction) act);
    	}

    	if (act.getFunctor().equals("sum")) {
    		NumberTerm x = (NumberTerm) act.getTerm(0);
    		NumberTerm y = (NumberTerm) act.getTerm(1);
    		VarTerm sum = (VarTerm) act.getTerm(2);
    		double d = x.solve() + y.solve();
    		NumberTermImpl z = new NumberTermImpl(d);
    		u.unifies(sum, z);
    	}
    	if (act.getFunctor().equals("minus")) {
    		NumberTerm x = (NumberTerm) act.getTerm(0);
    		NumberTerm y = (NumberTerm) act.getTerm(1);
    		VarTerm sum = (VarTerm) act.getTerm(2);
    		double d = x.solve() - y.solve();
    		NumberTermImpl z = new NumberTermImpl(d);
    		u.unifies(sum, z);
    	}
    	if (act.getFunctor().equals("div")) {
    		NumberTerm x = (NumberTerm) act.getTerm(0);
    		NumberTerm y = (NumberTerm) act.getTerm(1);
    		VarTerm sum = (VarTerm) act.getTerm(2);
    		double d = x.solve()/y.solve();
    		NumberTermImpl z = new NumberTermImpl(d);
    		u.unifies(sum, z);
    	}
    	if (act.getFunctor().equals("times")) {
    		NumberTerm x = (NumberTerm) act.getTerm(0);
    		NumberTerm y = (NumberTerm) act.getTerm(1);
    		VarTerm sum = (VarTerm) act.getTerm(2);
    		double d = x.solve()*y.solve();
    		NumberTermImpl z = new NumberTermImpl(d);
    		u.unifies(sum, z);
    	}

    	if (act.getFunctor().equals("append")) {
    		StringTerm x = (StringTerm) act.getTerm(0);
    		StringTerm y = (StringTerm) act.getTerm(1);
    		String append = x.getString() + y.getString();
    		VarTerm result = (VarTerm) act.getTerm(2);
    		StringTermImpl z = new StringTermImpl(append);
    		u.unifies(result, z);
    	}

    	if (act.getFunctor().equals("toString")) {
    		Term x = act.getTerm(0);

    		String s = x.toString();
    		VarTerm result = (VarTerm) act.getTerm(1);

    		u.unifies(result, new StringTermImpl(s));
    	}

	   	if (act.getFunctor().equals("print")) {
	   		String s = "";
	   		 for (Term t: act.getTerms()) {
	   			 if (t instanceof VarTerm) {
	   				 if (t.isGround()) {
	   					 Term tg = ((VarTerm) t).getValue();
	   					 if (tg instanceof StringTerm) {
	   						 s += ((StringTerm) tg).getString();
	   					 } else {
	   						 s += tg.toString();
	   					 }
	   				 } else {
	   					 s += t.toString();
	   				 }
	   			 } else if (t instanceof StringTerm) {
	   				 s += ((StringTerm) t).getString();
	   			 } else {
	   				 s += t.toString();
	   			 }
	   		 }
	    	 // Term content = (Term) act.getTerm(0);
	    	 System.out.println(s);
	    	 act.setLogLevel(AJPFLogger.FINER);
	     }

	   	if (act.getFunctor().equals("printstate") || act.getFunctor().equals("printagentstate")) {
	   		System.out.println(agentmap.get(agName).toString());
	   		act.setLogLevel(AJPFLogger.FINER);
	   	}

	   	if (AJPFLogger.ltInfo(logname)) {
	   		if (act.getLogLevel() == AJPFLogger.INFO) {
	   			AJPFLogger.info(logname, agName + " done " + printAction(act));
	   		} else if (act.getLogLevel() == AJPFLogger.FINE) {
	   			AJPFLogger.fine(logname, agName + " done " + printAction(act));
	   		} else if (act.getLogLevel() == AJPFLogger.FINER) {
	   			AJPFLogger.finer(logname, agName + " done " + printAction(act));
	   		} else if (act.getLogLevel() == AJPFLogger.FINEST) {
	   			AJPFLogger.finest(logname, agName + " done " + printAction(act));
	   		}
	   	}

	   	if (act.getLogLevel() == AJPFLogger.SEVERE) {
	   		AJPFLogger.severe(logname, agName + " done " + printAction(act));
	   	} else if (act.getLogLevel() == AJPFLogger.WARNING) {
	   		AJPFLogger.warning(logname, agName + " done " + printAction(act));
	   	}


			if(this instanceof Monitorable && consistent){
				Monitorable monMe = (Monitorable) this;

				if (act instanceof SendAction) {
					Message m = ((SendAction)act).getMessage(agName);
					if(!monitor.check("msg(" + m.getIlForce() + ", " + agName + ", " + m.getReceiver() + ", " + m.getPropCont() + ")")){
						monMe.manageProtocolViolation();
					}
				} else{

				//for(String event : monMe.getEventsToCatch()){
					//if (act.getFunctor().equals(event)) {
					if(!("event(" + agName + ", " + act.toString() + ")").equals(lastEvent)){
						lastEvent = "event(" + agName + ", " + act.toString() + ")";
						if(!monitor.check("event(" + agName + ", " + act.toString() + ")")){
							consistent = false;
							monMe.manageProtocolViolation();
						}
					}
						//break;
					//}
				//}
				}
			}


	   	return (u);
    }

    /**
     * Helper method for pretty printing actions during logging.
     * @param act
     * @return
     */
     protected String printAction(Action act) {
    	if (act instanceof SendAction) {
    		SendAction sa = (SendAction) act;
     		String s = "send(" + ilfString(sa.getILF()) + sa.getContent().toString() + ", " + sa.getReceiver().toString() + ")";
    		return s;
    	} else if (act instanceof BroadcastSendAction) {
    		BroadcastSendAction sa = (BroadcastSendAction) act;
     		String s = "send(" + ilfString(sa.getILF()) + sa.getContent().toString() + ", " + sa.getReceivers().toString() + ")";
    		return s;
    	}
    	
    	return act.toString();

    }

     /**
      * Default method for sending messages.  Simply adds the message to the receiver's inbox.
      * @param agName
      * @param act
      */
     public void executeSendAction(String agName, SendAction act) {
 		Message m = act.getMessage(agName);
 		String r = m.getReceiver();
 		addMessage(r, m);
     }

    /**
     * Overridable method for printing illocutionary forces.
     * @param ilf
     * @return
     */
    protected  String ilfString(int ilf) {
    	String s = ilf + ":";
    	return s;
    }

    /*
     * (non-Javadoc)
     * @see ail.others.AILEnv#getPercepts(java.lang.String)
     */
    public Set<Predicate> getPercepts(String agName, boolean update) {
		// check whether this agent needs to access the perception lists
    	// or whether it is uptodate
    	// System.err.println("HERE");
    	if (uptodateAgs.contains(agName)) {
    		return null;
		}

    	// add agName to the set of uptodate agents
    	// only happens if its the agent checking - not the property automata
    	if (update) {
    		// System.out.println(uptodateAgs)
    		uptodateAgs.add(agName);
    	}

    	Set<Predicate> agl = agPercepts.get(agName);
    	Set<Predicate> p = new HashSet<Predicate>();

    	if (! percepts.isEmpty()) { // has global perception?
    		for (Predicate per: percepts) {
    			p.add((Predicate) per.clone());
    		}
    	}

    	if (agl != null) { // add agent personal perception
    		p.addAll(agl);
    	}
     	return p;
     }


    /*
     * (non-Javadoc)
     * @see ail.others.AILEnv#getMessages(java.lang.String)
     */
    public Set<Message> getMessages(String agName) {
    	if (agMessages.get(agName).isEmpty()) {
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

    /**
     * Notify the listeners that the perceptions have changed.
     *
     */
    @Override
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
    @Override
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

    /**
     * Add a general percept
     * @param per
     */
  	public void addPercept(Predicate per) {
  		if (per != null) {
  			if (! percepts.contains(per)) {
  				percepts.add(per);
  				uptodateAgs.clear();
  			}
  		}
		notifyListeners();
	}

  	/*
  	 * (non-Javadoc)
  	 * @see ail.mas.AILEnv#agentIsUpToDate(java.lang.String)
  	 */
  	public boolean agentIsUpToDate(String agName) {
  		// System.out.println(uptodateAgs.contains(agName));
  		return (uptodateAgs.contains(agName) && agMessages.get(agName).isEmpty());
  	}


  	/**
  	 * Remove a general percept.
  	 * @param per
  	 * @return
  	 */
  	public boolean removePercept(Predicate per) {
  		if (per != null) {
  			uptodateAgs.clear();
  			boolean b =  percepts.remove(per);
  			notifyListeners();
  			return b;
  		}
  		return false;
	}


  	/**
  	 * Remove a percept that unifies with the one given.
  	 * @param per
  	 * @return
  	 */
	public boolean removeUnifiesPercept(String agName, Predicate per) {
		boolean b = false;
		Predicate rper = null;
		if (per != null && agName != null) {
			VerifySet<Predicate> agl = agPercepts.get(agName);
			if (agl != null) {
				uptodateAgs.remove(agName);
				for (Predicate p: agl) {
					if (p.unifies(per, new Unifier())) {
						rper = p;
					}
				}

				if (rper != null) {
					notifyListeners(agName);
					b = agl.remove(rper);
				}
			return b;
			}
		}
		return false;
	}

	/**
  	 * Remove a percept that unifies with the one given.
  	 * @param per
  	 * @return
  	 */
	public boolean removeUnifiesPercept(Predicate per) {
		boolean b = false;
		Predicate rper = null;
		if (per != null) {
			uptodateAgs.clear();
			for (Predicate p: percepts) {
				if (p.unifies(per, new Unifier())) {
					rper = p;
				}
			}

			if (rper != null) {
				b = percepts.remove(rper);
			}
			notifyListeners();
			return b;
		}
		return false;
	}

	/** Clears the list of global perceptions */
	public synchronized void clearPercepts() {
		if (!percepts.isEmpty()) {
			uptodateAgs.clear();
			percepts.clear();
		}
	}


	/** Adds a perception for a specific agent */
	public void addMessage(String agName, Message msg) {
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


	/** Adds a perception for a specific agent */
	public void addPercept(String agName, Predicate per) {
		if (per != null && agName != null) {
			VerifySet<Predicate> agl = agPercepts.get(agName);
			if (agl == null) {
				agl = new VerifySet<Predicate>();
				uptodateAgs.remove(agName);
				agl.add(per);
				agPercepts.put( agName, agl);
			} else {
				if (! agl.contains(per)) {
					uptodateAgs.remove(agName);
					agl.add(per);
				}
			}
		}
		notifyListeners(agName);
	}

	/** Removes a perception for one agent */
	public boolean removePercept(String agName, Predicate per) {
		if (per != null && agName != null) {
			VerifySet<Predicate> agl = agPercepts.get(agName);
			if (agl != null) {
				uptodateAgs.remove(agName);
				for (Predicate l: agl) {
					if (l.equals(per)) {
						notifyListeners(agName);
						boolean result = agl.remove(l);
						return result;
					}
				}
			}
		}

		notifyListeners(agName);
		return false;
	}


	/** Clears the list of perceptions of a specific agent */
	public void clearPercepts(String agName) {
		if (agName != null) {
			VerifySet<Predicate> agl = agPercepts.get(agName);
			if (agl != null) {
				uptodateAgs.remove(agName);
				agl.clear();
			}
		}
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

	/*
	 * (non-Javadoc)
	 * @see java.lang.Thread#toString()
	 */
	public String toString() {
			StringBuilder s = new StringBuilder("General Percepts:");
			for (Predicate l : percepts) {
				s.append(l.toString()).append(", ");
			}
			percepts.toString();

			for (String sAg : agPercepts.keySet()) {
				s.append("\n").append(sAg).append(":");
				for (Predicate l : agPercepts.get(sAg)) {
					s.append(l.toString()).append(", ");
				}
			}

			for (String sAg : agMessages.keySet()) {
				s.append("\n").append(sAg).append(":");
				for (Message l : agMessages.get(sAg)) {
					s.append(l.toString()).append(", ");
				}
			}

			s.append("\n").append("Up to date:").append(uptodateAgs);

			return s.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see ail.others.AILEnv#done()
	 */
	public boolean done() {
		// The environment doesn't do anything of it is own accord, therefore it is always done.
		return true;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#begin()
	 */
	public void begin() {
		
	}
	
 
	/*
	 * (non-Javadoc)
	 * @see ail.others.AILEnv#lastAction()
	 */
	public Action lastAction() {
		return lastAction;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.others.AILEnv#lastActionby()
	 */
	public String lastActionby(){
		return lastAgent;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#configure(ail.util.AILConfig)
	 */
	public void configure(AILConfig config) {
	}

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
	 * @see java.lang.Object#finalize()
	 */
	public void cleanup() {}

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

	/**
	 * A crude method for stopping all agents.  Use with caution.
	 */
	public void stopagents() {
		MCAPLScheduler scheduler = getScheduler();
		for (String jobber: scheduler.getActiveJobberNames()) {
			scheduler.notActive(jobber);
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

	public static void setup_scheduler(AILEnv env, MCAPLScheduler s) {
		env.setScheduler(s);
		env.addPerceptListener(s);
	}

	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#getAgents()
	 */
	@Override
	public List<AILAgent> getAgents() {
		ArrayList<AILAgent> agents = new ArrayList<AILAgent>();
		agents.addAll(agentmap.values());
		return agents;
	}


}