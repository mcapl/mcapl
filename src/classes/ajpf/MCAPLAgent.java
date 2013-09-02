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
	 * A flag indicating whether or not this is a model checking run.  Currently
	 * unused but I anticipate it may be handy.
	 */
	@FilterField
	private int outputlevel = 0;
	/**
	 * The controller within which the agent runs.
	 */
	private MCAPLcontroller controller;
	/**
	 * The name of the agent.
	 */
	private String name;
	
	//private boolean notified;
	
	
	/**
	 * Flag showing whether the agent is asleep or not.
	 */
//	@FilterField
//	private boolean sleeping  = false;
	
	/**
	 * Pregenerated to save time when model checking.
	 */
	//@FilterField
	//private String sleepmessage = "";

	/**
	 * Constructor.
	 * 
	 * @param a   The Agent that is encapsulated.
	 * @param mc  A flag indicating whether or not this is a model checking run.
	 *            This is currently unused but I anticipate it may be handy.
	 * @param c   The controller in which this agent runs.
	 */
	public MCAPLAgent(MCAPLLanguageAgent a, int mc, MCAPLcontroller c) {
		agent = a;
		outputlevel = mc;
		controller = c;
		name = a.getMCAPLAgName();
 	}
	
	
	public String getName() {
		return getAgName();
	}
	
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
			 agent.MCAPLreason(outputlevel);
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
		// synchronized (this) {
			// System.err.println("b");
		//	if (!notified) {
					AJPFLogger.fine("ajpf.MCAPLAgent", "agent isn't notifed");					
			// wait can not be called inside an atomic otherwise JPF deadlocks.
			// System.err.println("a");
				try {
					controller.addAsleep(getAgName());
				//	sleeping = true;
				// if the whole system has finished don't sleep but let the controller
				// shut everything down.
					if (! controller.checkEnd() && isRunning()) {
					//if (outputlevel > 1) {
						AJPFLogger.info("ajpf.MCAPLAgent", "Sleeping agent " + name);					
					// System.err.println(name + " sleeping");
					//	wait();
						controller.getScheduler().notActive(this.getName());
					// System.err.println(name + " has definitely woken up");
					} 	
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
	//		} else {
			// To reduce the search space we assume that a run in which something in the
			// environment is pending for the agent is invalid only if there is an invalid
			// run at this point where the pending action took place before the agent
			// decided to sleep.  This is a slightly dodgy assumption and we might want
			// to create a conditional test so this becomes an AJPF control option.
		//		agent.MCAPLtellawake();
		//		notified = false;
		//	}
		//}
	}
		
	/**
	 * Wakes up the agent and registers a notificaiton.
	 *
	 */
	public void wakeUP() {
	//	synchronized (this) {
			//notify();
		// Only wake an agent up if it is asleep!  Should really encapsulate this better
		if (! controller.getScheduler().getActiveJobberNames().contains(getName())) {
			controller.getScheduler().isActive(this.getName());
		
			agent.MCAPLtellawake();
		//	notified = true;
			controller.addAwake(getAgName());
			//sleeping = false;
			AJPFLogger.info("ajpf.MCAPLAgent", "Waking agent " + getAgName());
		}
	//	}
	} 
	
	/**
	 * Called when the thread starts.  Repeatedly calls steps
	 * of the reasoning cycle, which the agents reports it should
	 * still be running.
	 */
	/* public void run() {
	//	Verify.beginAtomic();
		if (! controller.beginfinished()) {
			// Again to reduce search space.  This prunes the space where the main thread
			// has not finished running from consideration.
			clearacceptingstate();
		//	Verify.ignoreIf(! controller.beginfinished());
		}
		while (isRunning()) {
		//	System.err.println(name + " running");
			 reason();
	    }
	//	Verify.endAtomic();
	} */
	
	/**
	 * Dummy method call to trigger actions in the MCAPL listener.  In this case it
	 * dumps any calculations that the current state leads to an accepting one.
	 *
	 */
	/* public void clearacceptingstate() {} */

	
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
	
	// Miscellaneous other methods.
	
	/**
	 * Getter for the agent name.
	 * 
	 * @return the name of the agent.
	 */
	public String getAgName() {
		return name;
	}
	
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
	
	public String toString() {
		return getAgName();
	}

	/**
	 * Returns the status of the agent thread.
	 * 
	 * @return true if the agent is awake and false if it is asleep.
	 */
//	public boolean isAwake() {
//		return (! sleeping);
//	}
	
	public int compareTo(MCAPLJobber j) {
		return j.getName().compareTo(getName());
	}
	    
}
