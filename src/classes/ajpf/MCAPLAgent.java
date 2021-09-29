// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
// 
// This file is part of Agent JPF (AJPF)
//
// AJPF is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// AJPF is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with AJPF if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package ajpf;


import ajpf.psl.MCAPLFormula;
import ajpf.util.AJPFLogger;
//import gov.nasa.jpf.jvm.abstraction.filter.FilterField;
import gov.nasa.jpf.annotation.FilterField;

/**
 * An encapsulation class for agents in the agent programming language.
 * 
 * @author louiseadennis
 */
public class MCAPLAgent implements PerceptListener, MCAPLJobber {
	/**
	 * The agent that is encapsulated.
	 */
	@FilterField
	private MCAPLLanguageAgent agent;

	/**
	 * The controller within which the agent runs.
	 */
	private MCAPLcontroller controller;
	/**
	 * The name of the agent.
	 */
	private String name;
	
	private String logname = "ajpf.MCAPLAgent";
	
	/**
	 * Constructor.
	 * 
	 * @param a   The Agent that is encapsulated.
	 * @param c   The controller in which this agent runs.
	 */
	public MCAPLAgent(MCAPLLanguageAgent a, MCAPLcontroller c) {
		agent = a;
		controller = c;
		name = a.getMCAPLAgName();
 	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLJobber#getName()
	 */
	public String getName() {
		return getAgName();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLJobber#do_job()
	 */
	public void do_job() {
		reason();
	}
	
	/**
	 * One step of the agents reasoning cycle.  This first calls
	 * one step of the encapsulated agent's reasoning and then
	 * accesses the system specification from the controller and
	 * updates the state of the specification.  Synchronized to
	 * ensure that properties are checked on each update of each
	 * agent's cycle.
	 */
	 public void reason() {
		 AJPFLogger.fine("ajpf.MCAPLAgent", "Entering reason");
			 // This is the actual program and should ideally be run in full.
			 agent.MCAPLreason();
			 // On the other hand the specification is not being checked and should be
			 // treated as a single transition except where it branches (see BuchiAutomaton class).
			 // We also keep as much of the sleeping behaviour within the atomic transition
			 // as possible since this is part of the MCAP implementation of agents and is
			 // used to enforce thread switching.  We can't really speak for the sleeping behaviour
			 // within any interpreter actually used to run the program and we'd like to
			 // avoid the excess branching caused by this.
			// controller.getSpecification().checkProperties();
			 AJPFLogger.fine("ajpf.MCAPLAgent", "Looking for sleeping behaviour");
			 if (agent.MCAPLwantstosleep()){
				 AJPFLogger.fine("ajpf.MCAPLAgent", "agent wants to sleep");
					sendtoSleep();
			 } else {
				 // If the agent doesn't want to sleep we make sure everything is 
				 // arranged so it doesn't do so.  We also assume that it will
				 // check for new percepts and messages before possibly sleeping again.
				 // System.err.println("wants to sleep failed");
				 agent.MCAPLtellawake();
			 }
			 AJPFLogger.fine("ajpf.MCAPLAgent", "Leaving reason");
	 }
	 
	 /**
	  * Informs the thread whether it should continue running.  Accesses
	  * this information by referring to the encapsulated agent.
	  * 
	  * @return whether or not the agents should continue running.
	  */
	public boolean isRunning() {
			return(agent.MCAPLcontinueRunning());
	}
	
	/**
	 * This will cause the agent thread to wait provided its
	 * got no unresolved notifications.  Currently it "resolves"
	 * notifications by trying and failing to sleep this forces 
	 * notifications to be reset.  It must attempt to sleep again
	 * before it can succeed forcing handling of any new notifications
	 * in the interim.
	 *
	 */
	public void sendtoSleep() {
		if (AJPFLogger.ltFine(logname)) {
			AJPFLogger.fine(logname, "agent isn't notifed");	
		}

		try {
			controller.addAsleep(getAgName());
			// if the whole system has finished don't sleep but let the controller
			// shut everything down.
			if (! controller.checkEnd() && isRunning()) {
				if (AJPFLogger.ltInfo(logname)) {
					AJPFLogger.info(logname, "Sleeping agent " + name);	
				}
				controller.getScheduler().notActive(this.getName());
			} 	
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
		
	/**
	 * Wakes up the agent and registers a notification.
	 *
	 */
	public void wakeUP() {
		if (! controller.getScheduler().getActiveJobberNames().contains(getName())) {
			controller.getScheduler().isActive(this.getName());
		
			agent.MCAPLtellawake();
			controller.addAwake(getAgName());
			if (AJPFLogger.ltInfo(logname)) {
				AJPFLogger.info("ajpf.MCAPLAgent", "Waking agent " + getAgName());
			}
		}
	} 
		
	// Methods used by the Property Specification Language
	
	/**
	 * Succeeds if the agent reports it believes a formula.
	 * 
	 * @param phi The formula to be believed
	 * @return  whether or not the agent believes phi
	 */
	public boolean believes(MCAPLFormula phi) {
		return (agent.MCAPLbelieves(phi));
	}
	
	/**
	 * Succeds if the agent reports it has intention phi.
	 * 
	 * @param phi The formulat for the intention.
	 * @return
	 */
	public boolean hasIntention(MCAPLFormula phi) {
		return agent.MCAPLhasIntention(phi);
	}
	
	/**
	 * Succeeds if the agent reports it has a goal.
	 * 
	 * @param phi the goal.
	 * @return whether the agent has the goal.
	 */
	public boolean hasGoal(MCAPLFormula phi) {
	 	return (agent.MCAPLhasGoal(phi));
	}
	
	/**
	 * Succeeds if the agent intends to perform some action.
	 * @param phi
	 * @return
	 */
	public boolean intendsToDo(MCAPLFormula phi) {
		return agent.MCAPLintendsToDo(phi);
	}
	
	// Miscellaneous other methods.
	
	/**
	 * Getter for the agent name.
	 * 
	 * @return the name of the agent.
	 */
	public String getAgName() {
		return name;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.PerceptListener#getListenerName()
	 */
	public String getListenerName() {
		return name;
	}

	/**
	 * Wake all the agents in the system.
	 */
	public void perceptChanged() {
		wakeUP();
	}
	
	/**
	 * Wake a particular agent.
	 */
	public void perceptChanged(String name) {
		wakeUP();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return getAgName();
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(MCAPLJobber j) {
		return j.getName().compareTo(getName());
	}
	    
}
