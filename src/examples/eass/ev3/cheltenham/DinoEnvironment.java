// ----------------------------------------------------------------------------
// Copyright (C) 2015 Strategic Facilities Technology Council 
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
package eass.ev3.cheltenham;

import ail.util.AILexception;
import ail.mas.RoundRobinScheduler;
import ail.syntax.Predicate;
import ail.syntax.Term;
import ail.syntax.Unifier;
import ail.syntax.Action;
import ail.syntax.Literal;
import ail.syntax.NumberTerm;
import ail.syntax.VarTerm;
import eass.mas.ev3.EASSEV3Environment;
import eass.mas.ev3.LegoRobot;

import java.io.PrintStream;
import java.util.Random;
import java.util.Set;


/**
 * An environment for Lego Robot Dinosaurs - specifically an adaptation of the Dinor3x model to be used at Cheltenham Science Festival 2015.
 * 
 * The robots should be able to move around a custom built table, detect obstacles, follow paths and detect white, black and blue areas on the
 * table top.
 * 
 * @author louiseadennis
 *
 */
public class DinoEnvironment extends EASSEV3Environment {
	boolean rule1 = false;
	boolean rule2 = false;
	boolean rule3 = false;
	boolean rule4 = false;
	boolean do_growl = false;
	boolean achieve_water = false;
	
	public double path_threshold = 0.03;
    public double dthreshold=0.4;
    public double wuthreshold=0.09;
    public double wlthreshold=0.06;
	
	static Literal activer1 = new Literal("active");
	static {activer1.addTerm(new Literal("rule1"));};
	
	static Literal activer2 = new Literal("active");
	static {activer2.addTerm(new Literal("rule2"));};
	
	static Literal activer3 = new Literal("active");
	static {activer3.addTerm(new Literal("rule3"));};
	
	static Literal activer4 = new Literal("active");
	static {activer4.addTerm(new Literal("rule4"));};
	
	static Literal scaregoal = new Literal("goal");
	static {scaregoal.addTerm(new Literal("scare"));};
	
	static Literal watergoal = new Literal("goal");
	static {watergoal.addTerm(new Literal("water"));};
	
	private LineFollowingThread line_follower;
	private RandomMotionThread random;
	
	DinoUI ui;
	
	/**
	 * Construct the Environment.
	 */
	public DinoEnvironment() {
		super();
		RoundRobinScheduler s = new RoundRobinScheduler();
		s.addJobber(this);
		setScheduler(s);
		addPerceptListener(s);
	}
	
	/**
	 * The the UI for the robot.  Some actions alter parameters to be displayed in the UI.
	 * @param ui
	 */
	public void setUI(DinoUI ui) {
		this.ui = ui;
	}
	
	/**
	 * Create the relevant object for the robot and perform other set up that requires the robot object to exist..
	 */
	public LegoRobot createRobot(String agent) throws Exception {
		Dinor3x robot;
		try {
			System.err.println("Contacting Robot");
			robot = new Dinor3x("10.0.1.1");
			System.err.println("Connection Established");
			addRobot(agent, robot);
			addSharedBelief(agent, create_rule_action("rule1", "act1", new Predicate("do_nothing")));
			addSharedBelief(agent, create_rule_action("rule1", "act2", new Predicate("do_nothing")));
			addSharedBelief(agent, create_rule_action("rule1", "act3", new Predicate("do_nothing")));
			addSharedBelief(agent, create_rule_action("rule2", "act1", new Predicate("do_nothing")));
			addSharedBelief(agent, create_rule_action("rule2", "act2", new Predicate("do_nothing")));
			addSharedBelief(agent, create_rule_action("rule2", "act3", new Predicate("do_nothing")));
			addSharedBelief(agent, create_rule_action("rule3", "act1", new Predicate("do_nothing")));
			addSharedBelief(agent, create_rule_action("rule3", "act2", new Predicate("do_nothing")));
			addSharedBelief(agent, create_rule_action("rule3", "act3", new Predicate("do_nothing")));
			addSharedBelief(agent, create_rule_action("rule4", "act1", new Predicate("do_nothing")));
			addSharedBelief(agent, create_rule_action("rule4", "act2", new Predicate("do_nothing")));
			addSharedBelief(agent, create_rule_action("rule4", "act3", new Predicate("do_nothing")));
			addSharedBelief(agent, create_rule_context("rule1", new Predicate("anything")));
			addSharedBelief(agent, create_rule_context("rule2", new Predicate("anything")));
			addSharedBelief(agent, create_rule_context("rule3", new Predicate("anything")));
			addSharedBelief(agent, create_rule_context("rule4", new Predicate("anything")));
			return robot;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			throw e;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see eass.mas.DefaultEASSEnvironment#getPercepts(java.lang.String, boolean)
	 */
	@Override
	public Set<Predicate> getPercepts(String agName, boolean update) {
		   String rname = rationalName(agName);
		   Dinor3x robot = (Dinor3x) getRobot(rname);
		   synchronized(robot) {
			   return super.getPercepts(agName, update);
		   }
		
	}

	/*
	 * (non-Javadoc)
	 * @see eass.mas.nxt.EASSNXTEnvironment#executeAction(java.lang.String, ail.syntax.Action)
	 */
	@Override
	public Unifier executeAction(String agName, Action act) throws AILexception {
			/* Most of the interaction between the physical robot, the User Interface and the agent seems to end up going through this class.
			 * Even though its intention is simply to control the agent's effect on the robot.
			 */
			
		
		   Unifier u = new Unifier();
		   String rname = rationalName(agName);
		   Dinor3x robot = (Dinor3x) getRobot(rname);
		   synchronized(robot) {
			   
			   // Teleoperation commands.
			   	if (act.getFunctor().equals("forward")) {
			   		stopLineFollowing();
			   		stopRandom();
			   		robot.forward();
			   	} else if (act.getFunctor().equals("forward_a_bit")) {
			   		stopLineFollowing();
			   		stopRandom();
			   		robot.short_forward();
			   	}else if (act.getFunctor().equals("stop")) {
			   		stopLineFollowing();
			   		stopRandom();
			   		robot.stop();
			   	} else if (act.getFunctor().equals("right")) {
			   		stopLineFollowing();
			   		stopRandom();
			   		robot.right();
			   	} else if (act.getFunctor().equals("right_a_bit")) {
			   		stopLineFollowing();
			   		stopRandom();
			   		robot.short_right();
			   	} else if (act.getFunctor().equals("left")) {
			   		stopLineFollowing();
			   		stopRandom();
			   		robot.left();
			   	} else if (act.getFunctor().equals("left_a_bit")) {
			   		stopLineFollowing();
			   		stopRandom();
			   		robot.short_left();
			   	} else if (act.getFunctor().equals("backward")) {
			   		stopLineFollowing();
			   		stopRandom();
			   		robot.backward();
			   	} else if (act.getFunctor().equals("backward_a_bit")) {
			   		stopLineFollowing();
			   		stopRandom();
			   		robot.short_backward();
			   	} else if (act.getFunctor().equals("follow_line")) {
			   		stopRandom();
			   		if (line_follower == null) {
			   			line_follower = new LineFollowingThread(robot);
			   			synchronized (line_follower) {
			   				if (!line_follower.isAlive()) {
			   					line_follower.start();
			   				}
			   			}
			   		}
			   	} else if (act.getFunctor().equals("random")) {
			   		stopLineFollowing();
			   		if (random == null) {
			   			random = new RandomMotionThread(robot);
				   		synchronized (random) {
				   			if (!random.isAlive()) {
				   				random.start();
				   			}
				   		}
			   		}
			   	} else if (act.getFunctor().equals("scare")) {
			   		robot.scare();
			   	} else if (act.getFunctor().equals("stop_line")) {
			   		stopLineFollowing();
			   	} else if (act.getFunctor().equals("stop_random")) {
			   		stopRandom();
			   	}
			   	
			   	// Goal setting and dropping
			   	else if (act.getFunctor().equals("achieve_water")) {
			   		if (!achieve_water) {
			   			addSharedBelief(rname, watergoal);
			   			achieve_water = true;
			   		} 
			   	} else if (act.getFunctor().equals("drop_goal")) {
			   		if (achieve_water) {
			   			stopLineFollowing();
			   			stopRandom();
			   			removeSharedBelief(rname, watergoal);
			   			achieve_water = false;
			   		}
			   	} 
			   	
			   	// Enabling, disabling and customising rules.
			   	else if (act.getFunctor().equals("rule1")) {
			   		if (!rule1) {
			   			addSharedBelief(rname, activer1);
			   			rule1 = true;
			   		} else {
			   			removeSharedBelief(rname, activer1);
			   			rule1 = false;
			   		}
			   		return u;
			   	} else if (act.getFunctor().equals("rule3")) {
			   		if (!rule3) {
			   			addSharedBelief(rname, activer3);
			   			rule3 = true;
			   		} else {
			   			removeSharedBelief(rname, activer3);
			   			rule3 = false;
			   		}
			   		return u;
			   	} else if (act.getFunctor().equals("rule4")) {
			   		if (!rule4) {
			   			addSharedBelief(rname, activer4);
			   			rule4 = true;
			   		} else {
			   			removeSharedBelief(rname, activer4);
			   			rule4 = false;
			   		}
			   		return u;
			   	} else if (act.getFunctor().equals("rule2")) {
			   		if (!rule2) {
			   			addSharedBelief(rname, activer2);
			   			rule2 = true;
			   		} else {
			   			removeSharedBelief(rname, activer2);
			   			rule2 = false;
			   		}
			   		return u;
			   	} else if (act.getFunctor().equals("r1action1")) {
			   		change_rule_action(rname, act, "rule1", "act1");
			   		return u;
			   	} else if (act.getFunctor().equals("r1action2")) {
			   		change_rule_action(rname, act, "rule1", "act2");
			   		return u;
			   	} else if (act.getFunctor().equals("r1action3")) {
			   		change_rule_action(rname, act, "rule1", "act3");
			   		return u;
			   	} else if (act.getFunctor().equals("r2action1")) {
			   		change_rule_action(rname, act, "rule2", "act1");
			   		return u;
			   	} else if (act.getFunctor().equals("r2action2")) {
			   		change_rule_action(rname, act, "rule2", "act2");
			   		return u;
			   	} else if (act.getFunctor().equals("r2action3")) {
			   		change_rule_action(rname, act, "rule2", "act3");
			   		return u;
			   	} else if (act.getFunctor().equals("r3action1")) {
			   		change_rule_action(rname, act, "rule3", "act1");
			   		return u;
			   	} else if (act.getFunctor().equals("r3action2")) {
			   		change_rule_action(rname, act, "rule3", "act2");
			   		return u;
			   	} else if (act.getFunctor().equals("r3action3")) {
			   		change_rule_action(rname, act, "rule3", "act3");
			   		return u;
			   	} else if (act.getFunctor().equals("r4action1")) {
			   		change_rule_action(rname, act, "rule4", "act1");
			   		return u;
			   	} else if (act.getFunctor().equals("r4action2")) {
			   		change_rule_action(rname, act, "rule4", "act2");
			   		return u;
			   	} else if (act.getFunctor().equals("r4action3")) {
			   		change_rule_action(rname, act, "rule4", "act3");
			   		return u;
			   	} else if (act.getFunctor().equals("r1context")) {
			   		change_rule_context(rname, act.getTerm(0), "rule1");
			   		return u;
			   	} else if (act.getFunctor().equals("r2context")) {
			   		change_rule_context(rname, act.getTerm(0), "rule2");
			   		return u;
			   	} else if (act.getFunctor().equals("r3context")) {
			   		change_rule_context(rname, act.getTerm(0), "rule3");
			   		return u;
			   	} else if (act.getFunctor().equals("r4context")) {
			   		change_rule_context(rname, act.getTerm(0), "rule4");
			   		return u;
			   	} 
			   	
			   	// Setting sensor thresholds.
			   	else if (act.getFunctor().equals("obstacle_distance")) {
			   		Literal distance_threshold = new Literal("change_distance");
			   		distance_threshold.addTerm(act.getTerm(0));
			   		String abstraction_name = "abstraction_" + rname;
			   		addPercept(abstraction_name, distance_threshold);
			   		dthreshold  = ((NumberTerm) act.getTerm(0)).solve();
			   		ui.changeDistanceThreshold(((NumberTerm) act.getTerm(0)).solve());
			   	} else if (act.getFunctor().equals("water_levels")) {
			   		Literal water_threshold = new Literal("change_water");
			   		water_threshold.addTerm(act.getTerm(0));
			   		water_threshold.addTerm(act.getTerm(1));
			   		String abstraction_name = "abstraction_" + rname;
			   		addPercept(abstraction_name, water_threshold);
			   		wuthreshold = ((NumberTerm) act.getTerm(0)).solve();
			   		wlthreshold = ((NumberTerm) act.getTerm(1)).solve();
			   		ui.changeWaterThresholds(((NumberTerm) act.getTerm(0)).solve(), ((NumberTerm) act.getTerm(1)).solve());
			   	} else if (act.getFunctor().equals("path_threshold")) {
			   		Literal path = new Literal("change_path");
			   		path.addTerm(act.getTerm(0));
			   		String abstraction_name = "abstraction_" + rname;
			   		addPercept(abstraction_name, path);
			   		path_threshold = ((NumberTerm) act.getTerm(0)).solve();
			   		ui.changePathThreshold(((NumberTerm) act.getTerm(0)).solve());
			   	} 
			   	
			   	// Commands to pass stuff back to the interace
			   	else if (act.getFunctor().equals("show_belief")) {
			   		Predicate belief = (Predicate) act.getTerm(0);
			   		ui.addToBeliefList(belief.toString());
			   	} else if (act.getFunctor().equals("remove_belief")) {
			   		Predicate belief = (Predicate) act.getTerm(0);
			   		ui.removeFromBeliefList(belief.toString());
			   	} else if (act.getFunctor().equals("show_goal")) {
			   		Predicate belief = (Predicate) act.getTerm(0);
			   		ui.addToGoalList(belief.toString());
			   	} else if (act.getFunctor().equals("remove_goal")) {
			   		Predicate belief = (Predicate) act.getTerm(0);
			   		ui.removeFromGoalList(belief.toString());
			   	}
		   }
		   	
		   	u = super.executeAction(agName, act);
		   	return u;
	}
	
	/**
	 * Controls the beliefs that change when a rules actions are altered in the interface.
	 * @param rname
	 * @param act
	 * @param rule_string
	 * @param action_string
	 */
	private void change_rule_action(String rname, Action act, String rule_string, String action_string) {
   		removeUnifiesShared(rname, create_rule_action(rule_string, action_string, new VarTerm("A")));
   		addSharedBelief(rname, create_rule_action(rule_string, action_string, act.getTerm(0)));
		
	}
	
	/**
	 * Controls the beliefs that change when a rule's guard is changed in the interface.
	 * @param rname
	 * @param context
	 * @param rule_string
	 */
	private void change_rule_context(String rname, Term context, String rule_string) {
		Predicate finalcontext = Predicate.PTrue;
		if (context.getFunctor().equals("there is water")) {
			finalcontext = new Predicate("water");
		} else if (context.getFunctor().equals("there is no water")) {
			finalcontext = new Predicate("no_water");
		} else {
			finalcontext = new Predicate("anything");
		}
   		removeUnifiesShared(rname, create_rule_context(rule_string, new VarTerm("A")));
   		addSharedBelief(rname, create_rule_context(rule_string, finalcontext));
		
	}

	/**
	 * Create a guard for a rule.
	 * @param rule_string
	 * @param context
	 * @return
	 */
	private Literal create_rule_context(String rule_string, Term context) {
  		Literal ract = new Literal("context");
   		ract.addTerm(new Literal(rule_string));
   		ract.addTerm(context);
   		return ract;	
	}

	/**
	 * Create an action in a rule.
	 * @param rule_string
	 * @param action_string
	 * @param action
	 * @return
	 */
	private Literal create_rule_action(String rule_string, String action_string, Term action) {
  		Literal ract = new Literal("rule");
   		ract.addTerm(new Literal(rule_string));
   		ract.addTerm(new Literal(action_string));
   		ract.addTerm(action);
   		return ract;	
	}
	
	/**
	 * Actions are called by an agent called abstract_rname, but the actual robot's name is just rname.  This method does
	 * the necessary string manipulations.
	 * @param name
	 * @return
	 */
	public String rationalName(String name) {
		int index = 12;
		if (name.length() > index) {
			return name.substring(index);
		} else {
			return name;
		}
	}
	
	/**
	 * Setting the print stream if the robot has an Ultrasonic sensor.  This means output from the sensor can be piped to the
	 * interface.
	 * @param rname
	 * @param s
	 */
	public void setUltraPrintStream(String rname, PrintStream s) {
		Dinor3x robot = (Dinor3x) getRobot(rname);
		if (robot != null) {
			robot.setUPrintStream(s);
		}
	}
	
	/**
	 * Setting the print stream for the Red Light from the RGB sensor so it can be piped to the interface.
	 * @param rname
	 * @param s
	 */
	public void setRedPrintStream(String rname, PrintStream s)  {
		Dinor3x robot = (Dinor3x) getRobot(rname);
		if (robot != null) {
			robot.setRedPrintStream(s);
		}
	}
	
	/**
	 * Setting the print stream for Blue Light from the RGB sensor so it can be piped to the interface.
	 * @param rname
	 * @param s
	 */
	public void setGreenPrintStream(String rname, PrintStream s)  {
		Dinor3x robot = (Dinor3x) getRobot(rname);
		if (robot != null) {
			robot.setGreenPrintStream(s);
		}
	}
	
	public void stopRandom() {
		if (random != null) {
			random.stopRandomBehaviour();
			random = null;
		}
	}

	
	public void stopLineFollowing() {
		if (line_follower != null) {
			line_follower.stopFollowingBehaviour();
			line_follower = null;
		}
	}
	
	/**
	 * Close sockets on program exit.
	 * @param rname
	 */
	public void cleanup(String rname) {
		Dinor3x robot = (Dinor3x) getRobot(rname);
		synchronized(robot) {
			robot.close();
		}
	}
	
	/**
	 * A Thread allowing random-ish motion around the table.
	 * @author lad
	 *
	 */
	public class RandomMotionThread extends Thread {
		boolean isrunning = false;
		Dinor3x robot;
		Random r = new Random();
		
		public RandomMotionThread(Dinor3x dino) {
			robot = dino;
		}
		
		public void run() {
			isrunning = true;
			boolean turning = false;
			boolean moving = false;
			boolean randomturn = false;
			while (isrunning) {
				synchronized (robot) {
					if (DinoEnvironment.this.values.containsKey("distance")) {
						Predicate distance = DinoEnvironment.this.values.get("distance");
						double value = ((NumberTerm) distance.getTerm(0)).solve();
						if (value < dthreshold) {
							if (!turning) {
								robot.right();
								moving = false;
								randomturn = false;
								turning = true;
							}
						} else {
							if (!moving && !randomturn) {
								int angle = r.nextInt(180);
								robot.turn(angle);
								turning = false;
								moving = false;
								randomturn = true;
							} else {
								if (randomturn) {
									robot.forward();
									randomturn = false;
									turning = false;
									moving = true;
								}
							}
						}
					}
				}
			}
		}

		public boolean isRunning() {
    		return isrunning;
    	}
    	
    	/**
    	 * Stop following the line.
    	 */
    	public void stopRandomBehaviour() {
    		isrunning = false;
    		try {
    			wait(5);
    		} catch (Exception e) {
    			System.err.println(e.getMessage());
    		}
    		DinoEnvironment.this.addSharedBelief("dinor3x", new Literal("rstopped"));
    	}
	}
	
	/**
	 * Line following needs to happen in a separate thread so it can continue while the user interacts with the interface and the
	 * robot continues to check for obstacles etc.,
	 * @author lad
	 *
	 */
	public class LineFollowingThread extends Thread {
    	boolean isrunning = false;
    	Dinor3x robot;
    	
    	public LineFollowingThread(Dinor3x dino) {
    		robot = dino;
    	}
    	
    	/*
    	 * (non-Javadoc)
    	 * @see java.lang.Thread#run()
    	 */
    	public void run() {
    		isrunning = true;
    		boolean steering_right = false;
    		boolean steering_left = false;
    		while (isrunning) {
    			synchronized(robot) {
    			//	robot.getRGBSensor().addPercept(DinoEnvironment.this);
    				if (DinoEnvironment.this.values.containsKey("red")) {
    					Predicate light = DinoEnvironment.this.values.get("red");
    					double value = ((NumberTerm) light.getTerm(0)).solve();
    					// Basic line following algorithm.
			   			if (value > path_threshold) {
			   				if (!steering_right) {
			   					robot.forward_right();
			   					steering_left = false;
			   					steering_right = true;
			   				}
			   			} else {
			   				if (!steering_left) {
			   					robot.forward_left();
			   					steering_left = true;
			   					steering_right = false;
			   				}
			   			}
			   		}
    			}
    		}
    	}
    	
    	public boolean isRunning() {
    		return isrunning;
    	}
    	
    	/**
    	 * Stop following the line.
    	 */
    	public void stopFollowingBehaviour() {
    		isrunning = false;
    		try {
    			wait(5);
    		} catch (Exception e) {
    			System.err.println(e.getMessage());
    		}
    		DinoEnvironment.this.addSharedBelief("dinor3x", new Literal("lfstopped"));
    	}
    	
	}


}
