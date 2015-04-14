// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
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
import ail.mas.NActionScheduler;
import ail.mas.RoundRobinScheduler;
import ail.syntax.Predicate;
import ail.syntax.Term;
import ail.syntax.Unifier;
import ail.syntax.Action;
import ail.syntax.Literal;
import ail.syntax.NumberTerm;
import ail.syntax.VarTerm;
import eass.mas.ev3.EASSEV3Environment;
import eass.mas.ev3.EASSUltrasonicSensor;
import eass.mas.ev3.LegoRobot;
import eass.mas.ev3.BasicRobot;
import eass.mas.ev3.EASSSensor;
import lejos.hardware.device.NXTMMX;
import lejos.hardware.motor.NXTRegulatedMotor;
import lejos.hardware.port.SensorPort;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.remote.ev3.RemoteRequestPilot;
import lejos.remote.ev3.RemoteRequestRegulatedMotor;
import lejos.remote.ev3.RemoteRequestEV3;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.ArcRotateMoveController;

import java.io.PrintStream;


/**
 * A simple environment for NXT Robots including sub-classes for two robot builds.  We need a more generic way of representing different robots
 * and robot configurations.
 * 
 * @author louiseadennis
 *
 */
public class DinoEnvironment extends EASSEV3Environment {
	boolean rule1 = false;
	boolean rule2 = false;
	
	static Literal activer1 = new Literal("active");
	static {activer1.addTerm(new Literal("rule1"));};
	
	static Literal activer2 = new Literal("active");
	static {activer2.addTerm(new Literal("rule2"));};
	
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
	 * Create the relevant object for the robot.
	 */
	public LegoRobot createRobot(String agent) {
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
			return robot;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			try {
				System.err.println("Trying to Contact Robot Again");
				robot = new Dinor3x("10.0.1.1");
				System.err.println("Connection Established");
				addRobot(agent, robot);
				return robot;
			} catch (Exception e1) {
				System.err.println(e1.getMessage());
				return null;
			}
		}
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see eass.mas.nxt.EASSNXTEnvironment#executeAction(java.lang.String, ail.syntax.Action)
	 */
	public Unifier executeAction(String agName, Action act) throws AILexception {
		   Unifier u = new Unifier();
		   String rname = rationalName(agName);
		   Dinor3x robot = (Dinor3x) getRobot(rname);
		  
			     
		   	if (act.getFunctor().equals("forward")) {
		   		if (robot.hasPilot()) {
		   			robot.getPilot().forward();
		   		}
		   	} else if (act.getFunctor().equals("stop")) {
		   		if (robot.hasPilot()) {
		   			robot.getPilot().stop();
		   		}
		   	} else if (act.getFunctor().equals("right")) {
		   		if (robot.hasPilot()) {
		   			robot.getPilot().steer(100);
		   		}
		   	} else if (act.getFunctor().equals("left")) {
		   		if (robot.hasPilot()) {
		   			robot.getPilot().steer(-100);
		   		}
		   	} else if (act.getFunctor().equals("backward")) {
		   		if (robot.hasPilot()) {
		   			robot.getPilot().backward();
		   		}
		   	} else if (act.getFunctor().equals("rule1")) {
		   		if (!rule1) {
		   			addSharedBelief(rname, activer1);
		   			rule1 = true;
		   		} else {
		   			removeSharedBelief(rname, activer1);
		   			rule1 = false;
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
		   	}
		   	
		   	u = super.executeAction(agName, act);
		   	return u;
	}
	
	private void change_rule_action(String rname, Action act, String rule_string, String action_string) {
   		removeUnifiesShared(rname, create_rule_action(rule_string, action_string, new VarTerm("A")));
   		addSharedBelief(rname, create_rule_action(rule_string, action_string, act.getTerm(0)));
		
	}
	
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
			robot.setUPrintStream(s);
	}
	
	public void cleanup(String rname) {
		Dinor3x robot = (Dinor3x) getRobot(rname);
		robot.close();
	}
	


}
