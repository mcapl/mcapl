// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
// 
// This file is part of Gwendolen
//
// Gwendolen is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Gwendolen is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with Gwendolen if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package gwendolen.failuredetection.environments;

import ail.mas.AIL;
import ail.mas.DurativeActionEnvironment;
import ail.mas.EnvWithCapLibrary;
import ail.mas.MAS;
import ail.semantics.AILAgent;
import ail.syntax.*;
import ail.util.AILexception;
import ajpf.MCAPLJobber;
import ajpf.util.AJPFLogger;
import ajpf.util.choice.UniformBoolChoice;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.HashSet;
import java.util.Set;
import java.util.Random;

/**
 * A Simple Blocks' World Environment.
 *
 * @author louiseadennis
 *
 */
public class ReconfigurationWaypointsEnvironment extends DurativeActionEnvironment implements MCAPLJobber, EnvWithCapLibrary {
	static String logname = "gwendolen.failuredetection.DurativeActionEnv";

	// temporarily required for clock
	public int seconds = 0;
	protected boolean done = false;

	public Capability capability;

	UniformBoolChoice r;
	public CapabilityLibrary capLibrary = new CapabilityLibrary();
	public Literal atW0 = new Literal("at");
	public Literal atW1 = new Literal("at");
	public Literal atW2 = new Literal("at");
	public Literal atW3 = new Literal("at");
	public Literal atW4 = new Literal("at");
	public Literal atW5 = new Literal("at");
	public Literal atW6 = new Literal("at");
	public Literal atW7 = new Literal("at");
	public Literal atW8 = new Literal("at");
	public Literal move0_1 = new Literal("move");
	public Literal move0_3 = new Literal("move");
	public Literal move0_4 = new Literal("move");
	public Literal move1_0 = new Literal("move");
	public Literal move1_2 = new Literal("move");
	public Literal move1_3 = new Literal("move");
	public Literal move1_4 = new Literal("move");
	public Literal move1_5 = new Literal("move");
	public Literal move2_1 = new Literal("move");
	public Literal move2_4 = new Literal("move");
	public Literal move2_5 = new Literal("move");
	public Literal move3_0 = new Literal("move");
	public Literal move3_1 = new Literal("move");
	public Literal move3_4 = new Literal("move");
	public Literal move3_6 = new Literal("move");
	public Literal move3_7 = new Literal("move");
	public Literal move4_0 = new Literal("move");
	public Literal move4_1 = new Literal("move");
	public Literal move4_2 = new Literal("move");
	public Literal move4_3 = new Literal("move");
	public Literal move4_5 = new Literal("move");
	public Literal move4_6 = new Literal("move");
	public Literal move4_7 = new Literal("move");
	public Literal move4_8 = new Literal("move");
	public Literal move5_1 = new Literal("move");
	public Literal move5_2 = new Literal("move");
	public Literal move5_4 = new Literal("move");
	public Literal move5_7 = new Literal("move");
	public Literal move5_8 = new Literal("move");
	public Literal move6_3 = new Literal("move");
	public Literal move6_4 = new Literal("move");
	public Literal move6_7 = new Literal("move");
	public Literal move7_3 = new Literal("move");
	public Literal move7_4 = new Literal("move");
	public Literal move7_5 = new Literal("move");
	public Literal move7_6 = new Literal("move");
	public Literal move7_8 = new Literal("move");
	public Literal move8_4 = new Literal("move");
	public Literal move8_5 = new Literal("move");
	public Literal move8_7 = new Literal("move");

	public DurativeAction moveW0W1;
	public DurativeAction moveW0W3;
	public DurativeAction moveW0W4;
	public DurativeAction moveW1W0;
	public DurativeAction moveW1W2;
	public DurativeAction moveW1W3;
	public DurativeAction moveW1W4;
	public DurativeAction moveW1W5;
	public DurativeAction moveW2W1;
	public DurativeAction moveW2W4;
	public DurativeAction moveW2W5;
	public DurativeAction moveW3W0;
	public DurativeAction moveW3W1;
	public DurativeAction moveW3W4;
	public DurativeAction moveW3W6;
	public DurativeAction moveW3W7;
	public DurativeAction moveW4W0;
	public DurativeAction moveW4W1;
	public DurativeAction moveW4W2;
	public DurativeAction moveW4W3;
	public DurativeAction moveW4W5;
	public DurativeAction moveW4W6;
	public DurativeAction moveW4W7;
	public DurativeAction moveW4W8;
	public DurativeAction moveW5W1;
	public DurativeAction moveW5W2;
	public DurativeAction moveW5W4;
	public DurativeAction moveW5W7;
	public DurativeAction moveW5W8;
	public DurativeAction moveW6W3;
	public DurativeAction moveW6W4;
	public DurativeAction moveW6W7;
	public DurativeAction moveW7W3;
	public DurativeAction moveW7W4;
	public DurativeAction moveW7W5;
	public DurativeAction moveW7W6;
	public DurativeAction moveW7W8;
	public DurativeAction moveW8W4;
	public DurativeAction moveW8W5;
	public DurativeAction moveW8W7;

	public ReconfigurationWaypointsEnvironment() {
		// Make environment
		super();
		AJPFLogger.fine(logname, "Environment Created");

		//Literal atW0, atW1, atW2, atW3, atW4, atW5, atW6, atW7, atW8 = new Literal("at");

		// Construct GBeliefs for grid of 9 waypoints

		//	0---1---2
		//	| X | X |
		//	3---4---5
		//	| X | X |
		//	6---7---8

		// --- AT ---
		atW0.addTerm(new NumberTermImpl(0));
		atW1.addTerm(new NumberTermImpl(1));
		atW2.addTerm(new NumberTermImpl(2));
		atW3.addTerm(new NumberTermImpl(3));
		atW4.addTerm(new NumberTermImpl(4));
		atW5.addTerm(new NumberTermImpl(5));
		atW6.addTerm(new NumberTermImpl(6));
		atW7.addTerm(new NumberTermImpl(7));
		atW8.addTerm(new NumberTermImpl(8));

		System.out.println("A");

		// --- MOVE ---
		//FROM
		move0_1.addTerm(new NumberTermImpl(0));
		move0_3.addTerm(new NumberTermImpl(0));
		move0_4.addTerm(new NumberTermImpl(0));
		move1_0.addTerm(new NumberTermImpl(1));
		move1_2.addTerm(new NumberTermImpl(1));
		move1_3.addTerm(new NumberTermImpl(1));
		move1_4.addTerm(new NumberTermImpl(1));
		move1_5.addTerm(new NumberTermImpl(1));
		move2_1.addTerm(new NumberTermImpl(2));
		move2_4.addTerm(new NumberTermImpl(2));
		move2_5.addTerm(new NumberTermImpl(2));
		move3_0.addTerm(new NumberTermImpl(3));
		move3_1.addTerm(new NumberTermImpl(3));
		move3_4.addTerm(new NumberTermImpl(3));
		move3_6.addTerm(new NumberTermImpl(3));
		move3_7.addTerm(new NumberTermImpl(3));
		move4_0.addTerm(new NumberTermImpl(4));
		move4_1.addTerm(new NumberTermImpl(4));
		move4_2.addTerm(new NumberTermImpl(4));
		move4_3.addTerm(new NumberTermImpl(4));
		move4_5.addTerm(new NumberTermImpl(4));
		move4_6.addTerm(new NumberTermImpl(4));
		move4_7.addTerm(new NumberTermImpl(4));
		move4_8.addTerm(new NumberTermImpl(4));
		move5_1.addTerm(new NumberTermImpl(5));
		move5_2.addTerm(new NumberTermImpl(5));
		move5_4.addTerm(new NumberTermImpl(5));
		move5_7.addTerm(new NumberTermImpl(5));
		move5_8.addTerm(new NumberTermImpl(5));
		move6_3.addTerm(new NumberTermImpl(6));
		move6_4.addTerm(new NumberTermImpl(6));
		move6_7.addTerm(new NumberTermImpl(6));
		move7_3.addTerm(new NumberTermImpl(7));
		move7_4.addTerm(new NumberTermImpl(7));
		move7_5.addTerm(new NumberTermImpl(7));
		move7_6.addTerm(new NumberTermImpl(7));
		move7_8.addTerm(new NumberTermImpl(7));
		move8_4.addTerm(new NumberTermImpl(8));
		move8_5.addTerm(new NumberTermImpl(8));
		move8_7.addTerm(new NumberTermImpl(8));

		System.out.println("B");

		//TO
		move0_1.addTerm(new NumberTermImpl(1));
		move0_3.addTerm(new NumberTermImpl(3));
		move0_4.addTerm(new NumberTermImpl(4));
		move1_0.addTerm(new NumberTermImpl(0));
		move1_2.addTerm(new NumberTermImpl(2));
		move1_3.addTerm(new NumberTermImpl(3));
		move1_4.addTerm(new NumberTermImpl(4));
		move1_5.addTerm(new NumberTermImpl(5));
		move2_1.addTerm(new NumberTermImpl(1));
		move2_4.addTerm(new NumberTermImpl(4));
		move2_5.addTerm(new NumberTermImpl(5));
		move3_0.addTerm(new NumberTermImpl(0));
		move3_1.addTerm(new NumberTermImpl(1));
		move3_4.addTerm(new NumberTermImpl(4));
		move3_6.addTerm(new NumberTermImpl(6));
		move3_7.addTerm(new NumberTermImpl(7));
		move0_1.addTerm(new NumberTermImpl(1));
		move4_0.addTerm(new NumberTermImpl(0));
		move4_1.addTerm(new NumberTermImpl(1));
		move4_2.addTerm(new NumberTermImpl(2));
		move4_3.addTerm(new NumberTermImpl(3));
		move4_5.addTerm(new NumberTermImpl(5));
		move4_6.addTerm(new NumberTermImpl(6));
		move4_7.addTerm(new NumberTermImpl(7));
		move4_8.addTerm(new NumberTermImpl(8));
		move5_1.addTerm(new NumberTermImpl(1));
		move5_2.addTerm(new NumberTermImpl(2));
		move5_4.addTerm(new NumberTermImpl(4));
		move5_7.addTerm(new NumberTermImpl(7));
		move5_8.addTerm(new NumberTermImpl(8));
		move6_3.addTerm(new NumberTermImpl(3));
		move6_4.addTerm(new NumberTermImpl(4));
		move6_7.addTerm(new NumberTermImpl(7));
		move7_3.addTerm(new NumberTermImpl(3));
		move7_4.addTerm(new NumberTermImpl(4));
		move7_5.addTerm(new NumberTermImpl(5));
		move7_6.addTerm(new NumberTermImpl(6));
		move7_8.addTerm(new NumberTermImpl(8));
		move8_4.addTerm(new NumberTermImpl(4));
		move8_5.addTerm(new NumberTermImpl(5));
		move8_7.addTerm(new NumberTermImpl(7));

		System.out.println("C");

		DurativeAction moveW0W1 = new DurativeAction(new Action(move0_1, Action.normalAction), 2, 1, new GBelief(atW0), new GBelief(atW1));
		DurativeAction moveW0W3 = new DurativeAction(new Action(move0_3, Action.normalAction), 2, 1, new GBelief(atW0), new GBelief(atW3));
		DurativeAction moveW0W4 = new DurativeAction(new Action(move0_4, Action.normalAction), 2, 1, new GBelief(atW0), new GBelief(atW4));

		DurativeAction moveW1W0 = new DurativeAction(new Action(move1_0, Action.normalAction), 2, 1, new GBelief(atW1), new GBelief(atW0));
		DurativeAction moveW1W2 = new DurativeAction(new Action(move1_2, Action.normalAction), 2, 1, new GBelief(atW1), new GBelief(atW2));
		DurativeAction moveW1W3 = new DurativeAction(new Action(move1_3, Action.normalAction), 2, 1, new GBelief(atW1), new GBelief(atW3));
		DurativeAction moveW1W4 = new DurativeAction(new Action(move1_4, Action.normalAction), 2, 1, new GBelief(atW1), new GBelief(atW4));
		DurativeAction moveW1W5 = new DurativeAction(new Action(move1_5, Action.normalAction), 2, 1, new GBelief(atW1), new GBelief(atW5));

		DurativeAction moveW2W1 = new DurativeAction(new Action(move2_1, Action.normalAction), 2, 1, new GBelief(atW2), new GBelief(atW1));
		DurativeAction moveW2W4 = new DurativeAction(new Action(move2_4, Action.normalAction), 2, 1, new GBelief(atW2), new GBelief(atW4));
		DurativeAction moveW2W5 = new DurativeAction(new Action(move2_5, Action.normalAction), 2, 1, new GBelief(atW2), new GBelief(atW5));

		DurativeAction moveW3W0 = new DurativeAction(new Action(move3_0, Action.normalAction), 2, 1, new GBelief(atW3), new GBelief(atW0));
		DurativeAction moveW3W1 = new DurativeAction(new Action(move3_1, Action.normalAction), 2, 1, new GBelief(atW3), new GBelief(atW1));
		DurativeAction moveW3W4 = new DurativeAction(new Action(move3_4, Action.normalAction), 2, 1, new GBelief(atW3), new GBelief(atW4));
		DurativeAction moveW3W6 = new DurativeAction(new Action(move3_6, Action.normalAction), 2, 1, new GBelief(atW3), new GBelief(atW6));
		DurativeAction moveW3W7 = new DurativeAction(new Action(move3_7, Action.normalAction), 2, 1, new GBelief(atW3), new GBelief(atW7));

		DurativeAction moveW4W0 = new DurativeAction(new Action(move4_0, Action.normalAction), 2, 1, new GBelief(atW4), new GBelief(atW0));
		DurativeAction moveW4W1 = new DurativeAction(new Action(move4_1, Action.normalAction), 2, 1, new GBelief(atW4), new GBelief(atW1));
		DurativeAction moveW4W2 = new DurativeAction(new Action(move4_2, Action.normalAction), 2, 1, new GBelief(atW4), new GBelief(atW2));
		DurativeAction moveW4W3 = new DurativeAction(new Action(move4_3, Action.normalAction), 2, 1, new GBelief(atW4), new GBelief(atW3));
		DurativeAction moveW4W5 = new DurativeAction(new Action(move4_5, Action.normalAction), 2, 1, new GBelief(atW4), new GBelief(atW5));
		DurativeAction moveW4W6 = new DurativeAction(new Action(move4_6, Action.normalAction), 2, 1, new GBelief(atW4), new GBelief(atW6));
		DurativeAction moveW4W7 = new DurativeAction(new Action(move4_7, Action.normalAction), 2, 1, new GBelief(atW4), new GBelief(atW7));
		DurativeAction moveW4W8 = new DurativeAction(new Action(move4_8, Action.normalAction), 2, 1, new GBelief(atW4), new GBelief(atW8));

		DurativeAction moveW5W1 = new DurativeAction(new Action(move5_1, Action.normalAction), 2, 1, new GBelief(atW5), new GBelief(atW1));
		DurativeAction moveW5W2 = new DurativeAction(new Action(move5_2, Action.normalAction), 2, 1, new GBelief(atW5), new GBelief(atW2));
		DurativeAction moveW5W4 = new DurativeAction(new Action(move5_4, Action.normalAction), 2, 1, new GBelief(atW5), new GBelief(atW4));
		DurativeAction moveW5W7 = new DurativeAction(new Action(move5_7, Action.normalAction), 2, 1, new GBelief(atW5), new GBelief(atW7));
		DurativeAction moveW5W8 = new DurativeAction(new Action(move5_8, Action.normalAction), 2, 1, new GBelief(atW5), new GBelief(atW8));

		DurativeAction moveW6W3 = new DurativeAction(new Action(move6_3, Action.normalAction), 2, 1, new GBelief(atW6), new GBelief(atW3));
		DurativeAction moveW6W4 = new DurativeAction(new Action(move6_4, Action.normalAction), 2, 1, new GBelief(atW6), new GBelief(atW4));
		DurativeAction moveW6W7 = new DurativeAction(new Action(move6_7, Action.normalAction), 2, 1, new GBelief(atW6), new GBelief(atW7));

		DurativeAction moveW7W3 = new DurativeAction(new Action(move7_3, Action.normalAction), 2, 1, new GBelief(atW7), new GBelief(atW3));
		DurativeAction moveW7W4 = new DurativeAction(new Action(move7_4, Action.normalAction), 2, 1, new GBelief(atW7), new GBelief(atW4));
		DurativeAction moveW7W5 = new DurativeAction(new Action(move7_5, Action.normalAction), 2, 1, new GBelief(atW7), new GBelief(atW5));
		DurativeAction moveW7W6 = new DurativeAction(new Action(move7_6, Action.normalAction), 2, 1, new GBelief(atW7), new GBelief(atW6));
		DurativeAction moveW7W8 = new DurativeAction(new Action(move7_8, Action.normalAction), 2, 1, new GBelief(atW7), new GBelief(atW8));

		DurativeAction moveW8W4 = new DurativeAction(new Action(move8_4, Action.normalAction), 2, 1, new GBelief(atW8), new GBelief(atW4));
		DurativeAction moveW8W5 = new DurativeAction(new Action(move8_5, Action.normalAction), 2, 1, new GBelief(atW8), new GBelief(atW5));
		DurativeAction moveW8W7 = new DurativeAction(new Action(move8_7, Action.normalAction), 2, 1, new GBelief(atW8), new GBelief(atW7));

		capLibrary.add(moveW0W1);
		capLibrary.add(moveW0W3);
		capLibrary.add(moveW0W4);
		capLibrary.add(moveW1W0);
		capLibrary.add(moveW1W2);
		capLibrary.add(moveW1W3);
		capLibrary.add(moveW1W4);
		capLibrary.add(moveW1W5);
		capLibrary.add(moveW2W1);
		capLibrary.add(moveW2W4);
		capLibrary.add(moveW2W5);
		capLibrary.add(moveW3W0);
		capLibrary.add(moveW3W1);
		capLibrary.add(moveW3W4);
		capLibrary.add(moveW3W6);
		capLibrary.add(moveW3W7);
		capLibrary.add(moveW4W0);
		capLibrary.add(moveW4W1);
		capLibrary.add(moveW4W2);
		capLibrary.add(moveW4W3);
		capLibrary.add(moveW4W5);
		capLibrary.add(moveW4W6);
		capLibrary.add(moveW4W7);
		capLibrary.add(moveW4W8);
		capLibrary.add(moveW5W1);
		capLibrary.add(moveW5W2);
		capLibrary.add(moveW5W4);
		capLibrary.add(moveW5W7);
		capLibrary.add(moveW5W8);
		capLibrary.add(moveW6W3);
		capLibrary.add(moveW6W4);
		capLibrary.add(moveW6W7);
		capLibrary.add(moveW7W3);
		capLibrary.add(moveW7W4);
		capLibrary.add(moveW7W5);
		capLibrary.add(moveW7W6);
		capLibrary.add(moveW7W8);
		capLibrary.add(moveW8W4);
		capLibrary.add(moveW8W5);
		capLibrary.add(moveW8W7);
		System.out.println("D");

		// Add percept for start location (fixes annotation issue for initial beliefs)
		addPercept(atW0);
		System.out.println("E");

		getScheduler().addJobber(this);
		System.out.println("F");

	}

	public void init_after_adding_agents(){
		for (AILAgent a: agentmap.values()){
			a.setCapabilityLibrary(capLibrary);
		}
	}
	public boolean checkAction(Action act, int a, int b){
		Literal action = new Literal("move");
		action.addTerm(new NumberTermImpl(a));
		action.addTerm(new NumberTermImpl(b));
		if (act.equals(action)) {
			return true;
		} else {
			return false;
		}
	}

	public void processMovement(String agName, Capability capability) {
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			throw new RuntimeException(e);
//		}
		//gwendolen format required: move(term0, term1)
		// wait for the duration allowed in the capability
		// ----- logic here -----

		// if (env.config == AIL.Config.PROGRAMMATIC) {
		//System.out.print(capability.toString());
		Action act = capability.getAction();
		Term origin = act.getTerm(0);
		Term destination = act.getTerm(1);
		Predicate new_position = new Predicate("at");
		Predicate old_position = new Predicate("at");
//		new_position.addTerm(destination);
//		old_position.addTerm(origin);
//		removePercept(old_position);
//		addPercept(new_position);

				if (checkAction(act, 0, 1)) {
					//System.out.println("Swapping location for failure one");
					new_position.addTerm(new NumberTermImpl(2));
					old_position.addTerm(origin);
					removePercept(old_position);
					addPercept(new_position);
					//System.out.println(percepts);
				}  else {
					//System.out.println("No failure detected");
					new_position.addTerm(destination);
					old_position.addTerm(origin);
					removePercept(old_position);
					addPercept(new_position);

				}
			}


	public Unifier executeAction(String agName, Action act) throws AILexception {
		if (!act.getFunctor().equals("abort")) {
			//AJPFLogger.info(logname, "Executing action: " + act.toPredicate().toString());
		}
		Unifier theta = new Unifier();
		if (act.getFunctor().equals("move")) {
			updateTimePassed(0);
			// find the corresponding action in the caplibrary
			if (capLibrary.getCapability(act) != null) {
				//System.out.println("cap found");
				Capability capability = capLibrary.getCapability(act);
				// FUTURE WORK - check if preconditions for action are believed before execution
				//if (perceptsToLiterals().containsAll(capability.postConditionsToLiterals())) {
				//System.out.println("At Starting Position for cap");
				processMovement(agName, capability);
				//}
			}
		} else if (act.getFunctor().equals("abort")) {
			updateTimePassed(0);
			//robot_at_x = 0;
			//robot_dest_y = 0;
			System.err.println("ABORTING ACTION - TIMED OUT");

		} else if (act.getFunctor().equals("printlogs")) {
			agentmap.get(agName).printActionLog();
		}
		try {
			theta = super.executeAction(agName, act);
			Thread.sleep(1500);

		} catch (AILexception e) {
			throw e;
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		return theta;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#setMAS(ail.mas.MAS)
	 */
	public void setMAS(MAS m) {
		super.setMAS(m);
		r = new UniformBoolChoice(m.getController());
	}

	public int clock() {
		seconds++;
		return seconds;
	}

	public Set<Literal> perceptsToLiterals() {
		Set<Literal> p = new HashSet<Literal>();
		if (! percepts.isEmpty()) {
			for (Predicate per: percepts) {
				p.add(new Literal((Predicate) per.clone()));
			}
		}
		return p;
	}
	@Override
	public int compareTo(MCAPLJobber o) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void do_job() {
		// If at start, do the saved cap
		Literal atW0 = new Literal("at");
		atW0.addTerm(new NumberTermImpl(0));
		if (agPercepts.containsValue(atW0)) {
			int timepassed = clock();
			updateTimePassed(timepassed);
			processMovement(lastAgent, capability);
		} else {
			addPercept(new Literal("something"));
		}
	}

	public boolean done() {
		//Literal atW4 = new Literal("at");
		//atW4.addTerm(new NumberTermImpl(4));
		//return (percepts.contains(atW4));
		return true;
	}

	public void updateTimePassed(int seconds) {
		Literal oldtime = new Literal("timepassed");
		oldtime.addTerm(new VarTerm("Any"));
		//removeUnifiesPercept(oldtime);
		Literal time = new Literal("timepassed");
		time.addTerm(new NumberTermImpl(seconds));
		//addPercept(time);

	}


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "WaypointEnv";
	}


	@Override
	public CapabilityLibrary getCapabilityLibrary() {
		return capLibrary;

	}

}