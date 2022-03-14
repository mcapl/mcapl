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
	int failureCount = 1;
	protected boolean done = false;

	// set robot start co-ords to (0,0)
	//double robot1_x = 0;
	double robot1_y = 0;
	
	//double robot_dest_x = 0;
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



		DurativeAction moveW1W0 = new DurativeAction(new Action(move10, Action.normalAction), 2, 1, new GBelief(atW1), new Guard(new GBelief(atW0)));
		DurativeAction moveW2W0 = new DurativeAction(new Action(move20, Action.normalAction), 2, 1, new GBelief(atW2), new Guard(new GBelief(atW0)));
		DurativeAction moveW3W0 = new DurativeAction(new Action(move30, Action.normalAction), 2, 1, new GBelief(atW3), new Guard(new GBelief(atW0)));
		DurativeAction moveW4W0 = new DurativeAction(new Action(move40, Action.normalAction), 2, 1, new GBelief(atW4), new Guard(new GBelief(atW0)));

		DurativeAction moveW0W1 = new DurativeAction(new Action(move01, Action.normalAction), 2, 1, new GBelief(atW0), new Guard(new GBelief(atW1)));
		DurativeAction moveW2W1 = new DurativeAction(new Action(move01, Action.normalAction), 2, 1, new GBelief(atW2), new Guard(new GBelief(atW1)));
		DurativeAction moveW3W1 = new DurativeAction(new Action(move01, Action.normalAction), 2, 1, new GBelief(atW3), new Guard(new GBelief(atW1)));
		DurativeAction moveW4W1 = new DurativeAction(new Action(move01, Action.normalAction), 2, 1, new GBelief(atW4), new Guard(new GBelief(atW1)));

		DurativeAction moveW0W2 = new DurativeAction(new Action(move02, Action.normalAction), 2, 1, new GBelief(atW0), new Guard(new GBelief(atW2)));
		DurativeAction moveW1W2 = new DurativeAction(new Action(move02, Action.normalAction), 2, 1, new GBelief(atW1), new Guard(new GBelief(atW2)));
		DurativeAction moveW3W2 = new DurativeAction(new Action(move02, Action.normalAction), 2, 1, new GBelief(atW3), new Guard(new GBelief(atW2)));
		DurativeAction moveW4W2 = new DurativeAction(new Action(move02, Action.normalAction), 2, 1, new GBelief(atW4), new Guard(new GBelief(atW2)));

		DurativeAction moveW0W3 = new DurativeAction(new Action(move03, Action.normalAction), 2, 1, new GBelief(atW0), new Guard(new GBelief(atW3)));
		DurativeAction moveW1W3 = new DurativeAction(new Action(move03, Action.normalAction), 2, 1, new GBelief(atW1), new Guard(new GBelief(atW3)));
		DurativeAction moveW2W3 = new DurativeAction(new Action(move03, Action.normalAction), 2, 1, new GBelief(atW2), new Guard(new GBelief(atW3)));
		DurativeAction moveW4W3 = new DurativeAction(new Action(move03, Action.normalAction), 2, 1, new GBelief(atW4), new Guard(new GBelief(atW3)));

		DurativeAction moveW0W4 = new DurativeAction(new Action(move04, Action.normalAction), 2, 1, new GBelief(atW0), new Guard(new GBelief(atW4)));
		DurativeAction moveW1W4 = new DurativeAction(new Action(move04, Action.normalAction), 2, 1, new GBelief(atW1), new Guard(new GBelief(atW4)));
		DurativeAction moveW2W4 = new DurativeAction(new Action(move04, Action.normalAction), 2, 1, new GBelief(atW2), new Guard(new GBelief(atW4)));
		DurativeAction moveW3W4 = new DurativeAction(new Action(move04, Action.normalAction), 2, 1, new GBelief(atW3), new Guard(new GBelief(atW4)));


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
		
		getScheduler().addJobber(this);

	}

	//public void robotMovingTo(double x, double y) {
		public void robotMovingTo(double y) {
		// This should be set up properly using the Choice class but no time...
		Random r = new Random();
		double f = r.nextDouble();
		if (true) {
			//if (f < 0.7) {
			Predicate at = new Predicate("at");
			//at.addTerm(new NumberTermImpl(x));
			at.addTerm(new NumberTermImpl(y));
	
			Predicate old_pos = new Predicate("at");
	
			//double robot_x;
			double robot_y;
			//double new_robot_x;
			double new_robot_y;
	
			//robot_x = robot1_x;
			robot_y = robot1_y;
			//robot1_x = x;
			robot1_y = y;
			//new_robot_x = x;
			new_robot_y = y;
	
			//old_pos.addTerm(new NumberTermImpl(robot_x));
			old_pos.addTerm(new NumberTermImpl(robot_y));
	
			removePercept(old_pos);
			addPercept(at);
		} else if (false) {
		//} else if (f < 1.0) {
			Predicate at = new Predicate("at");
			//at.addTerm(new NumberTermImpl(0));
			at.addTerm(new NumberTermImpl(3));
			Predicate old_pos = new Predicate("at");
			//old_pos.addTerm(new NumberTermImpl(robot1_x));
			old_pos.addTerm(new NumberTermImpl(robot1_y));
	
			//robot1_x = 0;
			robot1_y = 3;
			removePercept(old_pos);
			addPercept(at);
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
			double y = ((NumberTerm) act.getTerm(1)).solve();
			robot_dest_y = y;
			robotMovingTo(y);

		} else if (act.getFunctor().equals("abort")) {
			updateTimePassed(0);
			//robot_dest_x = 0;
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
			robotMovingTo(robot_dest_y);
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