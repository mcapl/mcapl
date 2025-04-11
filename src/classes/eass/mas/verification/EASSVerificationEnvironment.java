// ----------------------------------------------------------------------------
// Copyright (C) 2015 Louise A. Dennis and Michael Fisher
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
package eass.mas.verification;

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
 * An environment for verifying a single EASS Reasoning engine.
 * @author louiseadennis
 *
 */
public abstract class EASSVerificationEnvironment extends DefaultEnvironment {
	String logname = "eass.mas.verification.EASSVerificationEnvironment";

	protected UniformBoolChoice random_bool_generator;
	protected UniformIntChoice random_int_generator;

	// We generate a random set of perceptions at the start.  After that perceptions are only generated
	// when actions are taken.
	public boolean at_start_percepts = true;
	public boolean at_start_messages = true;

	/**
	 * Constructor.
	 */
	public EASSVerificationEnvironment() {
		System.err.println("starting EASS Verification Environment");
		SingleAgentScheduler scheduler = new SingleAgentScheduler();
		setScheduler(scheduler);
	}

	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#getPercepts(java.lang.String, boolean)
	 */
	public Set<Predicate> getPercepts(String agName, boolean update) {
		Set<Predicate> percepts = new TreeSet<Predicate>();
		// At the start we generate this set, after that we use percepts.
		if (at_start_percepts && mas != null) {
			//percepts = add_random_beliefs(agName, null);
			percepts.addAll(generate_sharedbeliefs(agName, null));
			for (Predicate p: percepts) {
				addPercept(p);
			}
			at_start_percepts = false;
			return percepts;
		}

		Set<Predicate> ps = super.getPercepts(agName, update);
		if (ps != null ) {
			// percepts = new TreeSet<Predicate>();
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
		Set<Message> messages = new TreeSet<Message>();
		if (at_start_messages) {
			//messages = add_random_messages(agName, null);
			messages.addAll(generate_messages(agName, null));
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
	public abstract Set<Predicate> generate_sharedbeliefs(String agName, Action act);

	/**
	 * This is where the application generates messages at random.
	 * @return
	 */
	public abstract Set<Message> generate_messages(String agName, Action act);

	/**
	* Added by Angelo
	*/
	//public abstract Set<Predicate> add_random_beliefs(String agName, Action act);

	/**
	* Added by Angelo
	*/
	//public abstract Set<Message> add_random_messages(String agName, Action act);

	/**
	 * Action execution simply causes the random generation of perceptions and messages.
	 */
	public Unifier executeAction(String agName, Action act) throws AILexception {
	   	if (AJPFLogger.ltInfo(logname) && !act.getFunctor().equals("print")) {
	   		AJPFLogger.info(logname, agName + " about to do " + act);
	   	}

	   	// We exclude remove_shared and assert_shared assuming these are instantaneous.
	   	if (!act.getFunctor().equals("print") && !act.getFunctor().equals("remove_shared") && !act.getFunctor().equals("assert_shared")) {
			Set<Predicate> percepts = generate_sharedbeliefs(agName, act);
			Set<Message> messages = generate_messages(agName, act);
			clearPercepts();

			//add_random_beliefs(agName, act);

			//add_random_messages(agName, act);

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
					for (String agName: agentmap.keySet()) {
						Set<Predicate> percepts = generate_sharedbeliefs(agName, new Action("done"));
						Set<Message> messages = generate_messages(agName, new Action("done"));
					}
					clearPercepts();


					//for (String agName: agentmap.keySet()) {
					//	add_random_beliefs(agName, new Action("done"));
					//	add_random_messages(agName, new Action("done"));
					//}
					final_turn = 2;
					return false;
				} else if (final_turn == 0){
					final_turn++;
					return false;
				} else {
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
	public void setMAS(MAS m) {
		super.setMAS(m);
		random_bool_generator = new UniformBoolChoice(m.getController());
		random_int_generator = new UniformIntChoice(m.getController());
	}



}
