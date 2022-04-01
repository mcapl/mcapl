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

package gwendolen.failuredetection;

import ail.mas.DefaultEnvironment;
import ail.mas.EnvWithCapLibrary;
import ail.mas.MAS;
import ail.syntax.*;
import ail.util.AILexception;
import ajpf.MCAPLJobber;
import ajpf.util.AJPFLogger;
import ajpf.util.VerifyMap;
import ajpf.util.choice.UniformBoolChoice;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * A Simple Blocks' World Environment.
 *
 * @author louiseadennis
 *
 */
public class DurativeActionRouteEnv extends DefaultEnvironment implements MCAPLJobber, EnvWithCapLibrary {
	static String logname = "gwendolen.failuredetection.DurativeActionEnv";

	// temporarily required for clock
	int seconds = 0;
	int failureCount = 0;
	protected boolean done = false;

	// set robot start co-ords to (0,0)
	double robot1_x = 0;
	double robot1_y = 0;
	
	double robot_at_x = 0;
	double robot_dest_y = 0;

	UniformBoolChoice r;
	CapabilityLibrary capLibrary = new CapabilityLibrary();

	public DurativeActionRouteEnv() {
		// Make environment
		super();
		AJPFLogger.fine(logname, "Environment Created");

		// Construct GBeliefs for grid
		// --- AT ---
		Literal atW0 = new Literal("at");
		atW0.addTerm(new NumberTermImpl(0));

		Literal atW1 = new Literal("at");
		atW1.addTerm(new NumberTermImpl(1));

		Literal atW2 = new Literal("at");
		atW2.addTerm(new NumberTermImpl(2));

		Literal atW3 = new Literal("at");
		atW3.addTerm(new NumberTermImpl(3));

		Literal atW4 = new Literal("at");
		atW4.addTerm(new NumberTermImpl(4));

		// --- MOVE ---
		//to 0
		Literal move1_0 = new Literal("move");
		move1_0.addTerm(new NumberTermImpl(1));
		move1_0.addTerm(new NumberTermImpl(0));
		Literal move2_0 = new Literal("move");
		move2_0.addTerm(new NumberTermImpl(2));
		move2_0.addTerm(new NumberTermImpl(0));
		Literal move3_0 = new Literal("move");
		move3_0.addTerm(new NumberTermImpl(3));
		move3_0.addTerm(new NumberTermImpl(0));
		Literal move4_0 = new Literal("move");
		move4_0.addTerm(new NumberTermImpl(4));
		move4_0.addTerm(new NumberTermImpl(0));
		//to 1
		Literal move0_1 = new Literal("move");
		move0_1.addTerm(new NumberTermImpl(0));
		move0_1.addTerm(new NumberTermImpl(1));
		Literal move2_1 = new Literal("move");
		move2_1.addTerm(new NumberTermImpl(2));
		move2_1.addTerm(new NumberTermImpl(1));
		Literal move3_1 = new Literal("move");
		move3_1.addTerm(new NumberTermImpl(3));
		move3_1.addTerm(new NumberTermImpl(1));
		Literal move4_1 = new Literal("move");
		move4_1.addTerm(new NumberTermImpl(4));
		move4_1.addTerm(new NumberTermImpl(1));
		//to 2
		Literal move0_2 = new Literal("move");
		move0_2.addTerm(new NumberTermImpl(0));
		move0_2.addTerm(new NumberTermImpl(2));
		Literal move1_2 = new Literal("move");
		move1_2.addTerm(new NumberTermImpl(1));
		move1_2.addTerm(new NumberTermImpl(2));
		Literal move3_2 = new Literal("move");
		move3_2.addTerm(new NumberTermImpl(3));
		move3_2.addTerm(new NumberTermImpl(2));
		Literal move4_2 = new Literal("move");
		move4_2.addTerm(new NumberTermImpl(4));
		move4_2.addTerm(new NumberTermImpl(2));
		//to 3
		Literal move0_3 = new Literal("move");
		move0_3.addTerm(new NumberTermImpl(0));
		move0_3.addTerm(new NumberTermImpl(3));
		Literal move1_3 = new Literal("move");
		move1_3.addTerm(new NumberTermImpl(1));
		move1_3.addTerm(new NumberTermImpl(3));
		Literal move2_3 = new Literal("move");
		move2_3.addTerm(new NumberTermImpl(2));
		move2_3.addTerm(new NumberTermImpl(3));
		Literal move4_3 = new Literal("move");
		move4_3.addTerm(new NumberTermImpl(4));
		move4_3.addTerm(new NumberTermImpl(3));
		//to 4
		Literal move0_4 = new Literal("move");
		move0_4.addTerm(new NumberTermImpl(0));
		move0_4.addTerm(new NumberTermImpl(4));
		Literal move1_4 = new Literal("move");
		move1_4.addTerm(new NumberTermImpl(1));
		move1_4.addTerm(new NumberTermImpl(4));
		Literal move2_4 = new Literal("move");
		move2_4.addTerm(new NumberTermImpl(2));
		move2_4.addTerm(new NumberTermImpl(4));
		Literal move3_4 = new Literal("move");
		move3_4.addTerm(new NumberTermImpl(3));
		move3_4.addTerm(new NumberTermImpl(4));


		DurativeAction moveW1W0 = new DurativeAction(new Action(move1_0, Action.normalAction), 2, 1, new GBelief(atW1), new Guard(new GBelief(atW0)));
		DurativeAction moveW2W0 = new DurativeAction(new Action(move2_0, Action.normalAction), 2, 1, new GBelief(atW2), new Guard(new GBelief(atW0)));
		DurativeAction moveW3W0 = new DurativeAction(new Action(move3_0, Action.normalAction), 2, 1, new GBelief(atW3), new Guard(new GBelief(atW0)));
		DurativeAction moveW4W0 = new DurativeAction(new Action(move4_0, Action.normalAction), 2, 1, new GBelief(atW4), new Guard(new GBelief(atW0)));

		DurativeAction moveW0W1 = new DurativeAction(new Action(move0_1, Action.normalAction), 2, 1, new GBelief(atW0), new Guard(new GBelief(atW1)));
		DurativeAction moveW2W1 = new DurativeAction(new Action(move2_1, Action.normalAction), 2, 1, new GBelief(atW2), new Guard(new GBelief(atW1)));
		DurativeAction moveW3W1 = new DurativeAction(new Action(move3_1, Action.normalAction), 2, 1, new GBelief(atW3), new Guard(new GBelief(atW1)));
		DurativeAction moveW4W1 = new DurativeAction(new Action(move4_1, Action.normalAction), 2, 1, new GBelief(atW4), new Guard(new GBelief(atW1)));

		DurativeAction moveW0W2 = new DurativeAction(new Action(move0_2, Action.normalAction), 2, 1, new GBelief(atW0), new Guard(new GBelief(atW2)));
		DurativeAction moveW1W2 = new DurativeAction(new Action(move1_2, Action.normalAction), 2, 1, new GBelief(atW1), new Guard(new GBelief(atW2)));
		DurativeAction moveW3W2 = new DurativeAction(new Action(move3_2, Action.normalAction), 2, 1, new GBelief(atW3), new Guard(new GBelief(atW2)));
		DurativeAction moveW4W2 = new DurativeAction(new Action(move4_2, Action.normalAction), 2, 1, new GBelief(atW4), new Guard(new GBelief(atW2)));

		DurativeAction moveW0W3 = new DurativeAction(new Action(move0_3, Action.normalAction), 2, 1, new GBelief(atW0), new Guard(new GBelief(atW3)));
		DurativeAction moveW1W3 = new DurativeAction(new Action(move1_3, Action.normalAction), 2, 1, new GBelief(atW1), new Guard(new GBelief(atW3)));
		DurativeAction moveW2W3 = new DurativeAction(new Action(move2_3, Action.normalAction), 2, 1, new GBelief(atW2), new Guard(new GBelief(atW3)));
		DurativeAction moveW4W3 = new DurativeAction(new Action(move4_3, Action.normalAction), 2, 1, new GBelief(atW4), new Guard(new GBelief(atW3)));

		DurativeAction moveW0W4 = new DurativeAction(new Action(move0_4, Action.normalAction), 2, 1, new GBelief(atW0), new Guard(new GBelief(atW4)));
		DurativeAction moveW1W4 = new DurativeAction(new Action(move1_4, Action.normalAction), 2, 1, new GBelief(atW1), new Guard(new GBelief(atW4)));
		DurativeAction moveW2W4 = new DurativeAction(new Action(move2_4, Action.normalAction), 2, 1, new GBelief(atW2), new Guard(new GBelief(atW4)));
		DurativeAction moveW3W4 = new DurativeAction(new Action(move3_4, Action.normalAction), 2, 1, new GBelief(atW3), new Guard(new GBelief(atW4)));


		// Add capabilities to environment
		capLibrary.add(moveW1W0);
		capLibrary.add(moveW2W0);
		capLibrary.add(moveW3W0);
		capLibrary.add(moveW4W0);

		capLibrary.add(moveW0W1);
		capLibrary.add(moveW2W1);
		capLibrary.add(moveW3W1);
		capLibrary.add(moveW4W1);

		capLibrary.add(moveW0W2);
		capLibrary.add(moveW1W2);
		capLibrary.add(moveW3W2);
		capLibrary.add(moveW4W2);

		capLibrary.add(moveW0W3);
		capLibrary.add(moveW1W3);
		capLibrary.add(moveW2W3);
		capLibrary.add(moveW4W3);

		capLibrary.add(moveW0W4);
		capLibrary.add(moveW1W4);
		capLibrary.add(moveW2W4);
		capLibrary.add(moveW3W4);

		
		//RoundRobinScheduler scheduler = new RoundRobinScheduler();
		//this.setScheduler(scheduler);
		//addPerceptListener(scheduler);

		// Add percept for start location (fixes annotation issue for initial beliefs)
		addPercept(atW0);

		getScheduler().addJobber(this);

	}

	//public void robotMovingTo(double x, double y) {
		public void robotMovingTo(double x, double y) {
		// This should be set up properly using the Choice class but no time...
		Random r = new Random();
		double f = r.nextDouble();
		//if (true) {
			if (f < 0.7) {
			Predicate new_position = new Predicate("at");
			new_position.addTerm(new NumberTermImpl(y));
	
			Predicate old_position = new Predicate("at");
			old_position.addTerm(new NumberTermImpl(x));

			double origin;
			double destination;
			origin = x;
			destination = y;
			robot1_x = origin;
			robot1_y = destination;

			removePercept(old_position);
			addPercept(new_position);
		//;} else if (false) {
		} else if (f < 1.0) {
			Predicate new_position = new Predicate("at");
			new_position.addTerm(new NumberTermImpl(0));
			Predicate old_position = new Predicate("at");
			old_position.addTerm(new NumberTermImpl(x));

			robot1_x = x;
			robot1_y = 0;
			removePercept(old_position);
			addPercept(new_position);
		}
	}

	public Unifier executeAction(String agName, Action act) throws AILexception {
		if (!act.getFunctor().equals("abort")) {
			AJPFLogger.info(logname, "Executing action: " + act.toPredicate().toString());
		}
		Unifier theta = new Unifier();
		byte action_state;
		//AJPFLogger.info(logname, act.getFunctor());
		if (act.getFunctor().equals("move")) {
			updateTimePassed(0);
			double x = ((NumberTerm) act.getTerm(0)).solve();
			double y = ((NumberTerm) act.getTerm(1)).solve();
			robot_at_x = x;
			robot_dest_y = y;
			robotMovingTo(x, y);

		} else if (act.getFunctor().equals("abort")) {
			updateTimePassed(0);
			robot_at_x = 0;
			robot_dest_y = 0;
			System.err.println("ABORTING ACTION - TIMED OUT");

		} else if (act.getFunctor().equals("printlogs")) {
			agentmap.get(agName).printActionLog();
		}

		try {
			theta = super.executeAction(agName, act);
		} catch (AILexception e) {
			throw e;
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
		
		if (robot_dest_y != 0) {
			int timepassed = clock();
			updateTimePassed(timepassed);
			
			//robotMovingTo(robot_dest_x, robot_dest_y);
			robotMovingTo(robot_at_x, robot_dest_y);
		} else {
			addPercept(new Literal("something"));
		}
	}
	
	public boolean done() {
		return (robot1_y == 4);
	}
	
	public void updateTimePassed(int seconds) {
		Literal oldtime = new Literal("timepassed");
		oldtime.addTerm(new VarTerm("Any"));
		removeUnifiesPercept(oldtime);
		Literal time = new Literal("timepassed");
		time.addTerm(new NumberTermImpl(seconds));
		addPercept(time);
		
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