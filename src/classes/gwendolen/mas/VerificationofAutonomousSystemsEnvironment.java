// ----------------------------------------------------------------------------
// Copyright (C) 2016 Louise A. Dennis and Michael Fisher
//
// This file is part of the Engineering Autonomous Space Software (EASS) Library.
// 
// The EASS Library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The EASS Library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the EASS Library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------
package gwendolen.mas;

import java.util.Set;
import java.util.TreeSet;

import ail.syntax.Action;
import ail.syntax.Message;
import ail.syntax.Predicate;
import ail.syntax.SendAction;
import ail.syntax.Unifier;
import ail.util.AILexception;
import ail.mas.DefaultEnvironment;
import ail.mas.MAS;
import ail.mas.scheduling.SingleAgentScheduler;
import ajpf.util.AJPFLogger;
import ajpf.util.choice.UniformBoolChoice;
import ajpf.util.choice.UniformIntChoice;

/**
 * An environment for verifying an Autonomous Systems.
 * @author louiseadennis
 *
 */
public abstract class VerificationofAutonomousSystemsEnvironment extends DefaultEnvironment {
	String logname = "gwendolen.mas.verification.VerificationofAutonomousSystemsEnvironment";

	protected UniformBoolChoice random_bool_generator;
	protected UniformIntChoice random_int_generator;
	
	// We generate a random set of perceptions at the start.  After that perceptions are only generated
	// when actions are taken.
	public boolean at_start_percepts = true;
	public boolean at_start_messages = true;
	
	/**
	 * Constructor.
	 */
	public VerificationofAutonomousSystemsEnvironment() {
		SingleAgentScheduler scheduler = new SingleAgentScheduler();
		setScheduler(scheduler);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#getPercepts(java.lang.String, boolean)
	 */
	public Set<Predicate> getPercepts(String agName, boolean update) {
		TreeSet<Predicate> percepts = new TreeSet<Predicate>();
		// At the start we generate this set, after that we use percepts.
		if (at_start_percepts && mas != null) {
			percepts.addAll(generate_percepts());
			for (Predicate p: percepts) {
				addPercept(p);
			}
			at_start_percepts = false;
			return percepts;
		} 
			
		Set<Predicate> ps = super.getPercepts(agName, update);
		if (ps != null ) {
			percepts.addAll(ps);
		} else {
			return null;
		}		
		return percepts;
	}
	
	/**
	 * 
	 */
	public Set<Message> getMessages(String agName) {
		TreeSet<Message> messages = new TreeSet<Message>();
		if (at_start_messages) {
			// messages.addAll(generate_messages());
			at_start_messages = false;
			return messages;
		} else {
			return super.getMessages(agName);
		}		
	}

	/**
	 * This is where the application generates perceptions at random.
	 * @return
	 */
	public abstract Set<Predicate> generate_percepts();
	
	/**
	 * This is where the application generates messages at random.
	 * @return
	 */
	public abstract Set<Message> generate_messages();

	/**
	 * Action execution simply causes the random generation of perceptions and messages.
	 */
	public Unifier executeAction(String agName, Action act) throws AILexception {
	   	if (AJPFLogger.ltInfo(logname) && !act.getFunctor().equals("print")) {
	   		AJPFLogger.info(logname, agName + " about to do " + act);
	   	}

	   	// We exclude remove_shared and assert_shared assuming these are instantaneous.
	   	if (!act.getFunctor().equals("print") && !act.getFunctor().equals("remove_shared") && !act.getFunctor().equals("assert_shared")) {
			Set<Predicate> percepts = generate_percepts();
			Set<Message> messages = generate_messages();
			clearPercepts();
			
			for (Predicate p: percepts) {
				addPercept(p);
			}
			
			for (Message m: messages) {
				addMessage(agName, m);
			}
		}
		
	   	final_turn = 0;
	   	if (! (act instanceof SendAction)) {
	   		return super.executeAction(agName, act);
	   	} else {
	   	   	decidetostop(agName, act);
	   	   	lastAgent = agName;
	   	   	lastAction = act;
	    	
	    	Unifier u = new Unifier();
		   	if (AJPFLogger.ltInfo("ail.mas.DefaultEnvironment")) {
		   		AJPFLogger.info("ail.mas.DefaultEnvironment", agName + " done " + printAction(act));
		   	}
		   	
		   	return (u);

	   	} 
		
	}
	
	int final_turn = 0;
	
//	@Override
public boolean done() {
		try {
			if (getScheduler() != null && getScheduler().getActiveJobbers().isEmpty()) {
				if (final_turn == 1) {
					//System.err.println("1!!!!!!!!!!!!!!!!!");
					Set<Predicate> percepts = generate_percepts();
					Set<Message> messages = generate_messages();
					clearPercepts();
					
					for (Predicate p: percepts) {
						addPercept(p);
					}
					
					for (String agName: agentmap.keySet()) {
						for (Message m: messages) {
							addMessage(agName, m);
						}
					}
					final_turn = 2;
					return false;
				} else if (final_turn == 0){
					//System.err.println("0!!!!!!!!!!!!!!!!!");
					final_turn++;
					return false;
				} else {
					//System.err.println("2+!!!!!!!!!!!!!!!!!");
					return true;
				} 
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	} 
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#setMAS(ail.mas.MAS)
	 */
	@Override
	public void setMAS(MAS m) {
		super.setMAS(m);
		// System.err.println("Setting MAS");
		random_bool_generator = new UniformBoolChoice(m.getController());
		random_int_generator = new UniformIntChoice(m.getController());
	}



}
