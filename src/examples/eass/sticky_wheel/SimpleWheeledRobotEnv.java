// ----------------------------------------------------------------------------
// Copyright (C) 2015 Louise A. Dennis, and Michael Fisher 
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
package eass.sticky_wheel;

import ail.mas.scheduling.ActionScheduler;
import eass.mas.vehicle.EASSVehicleEnvironment;
import eass.semantics.EASSAgent;
import ail.semantics.AILAgent;
import ail.syntax.Action;
import ail.syntax.Unifier;
import ail.syntax.Predicate;
import ail.syntax.NumberTermImpl;
import ail.syntax.NumberTerm;
import ail.util.AILexception;
import ajpf.MCAPLJobber;

/**
 * SimpleWheeledRobot Env is an environment for a simple wheeled robot.  This is using the EASS classes for
 * Vehicles, so the environment contains vehicles which in turn act as environments for sets of agents which control that
 * individual vehicle.  
 * 
 * This environment determines what happens when a wheeled robot moves (i.e., engages both its motors).  It contains no obstacles 
 * or anything else but it does allow one of a robot's wheels to become sticky and calculates the effect this has on movement.
 * @author louiseadennis
 *
 */
public class SimpleWheeledRobotEnv extends EASSVehicleEnvironment implements MCAPLJobber {
	String name = "Simple Wheeled Robot Env";
	ActionScheduler scheduler;
	String rName;
	double sticky_modifier = 0;
	
	// Assume one robot for the time being
	double x = 50;
	double y = 50;
	double theta = 0;
	
	WheeledRobotUI gui;
	
	/**
	 * Standard constructor formulation for an EASS Environment.
	 */
	public SimpleWheeledRobotEnv() {
		super();
		ActionScheduler s = new ActionScheduler();
		scheduler = s;
		setScheduler(s);
		s.addJobber(this);
		addPerceptListener(s);
	}
	

	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#addAgent(ail.semantics.AILAgent)
	 */
	public void addAgent(AILAgent a) {
		// NB. We are implicitly assuming that abstraction engines will be added before reasoning engines.
		EASSAgent eass = (EASSAgent) a;
		
		// If the agent is an reasoning engine, connect it to its Vehicle.
		if (contains(eass.getReasoningName())) {
			this.addAgentToVehicle(eass);
			Predicate position = new Predicate("position");
			position.addTerm(new NumberTermImpl(x));
			position.addTerm(new NumberTermImpl(y));
			position.addTerm(new NumberTermImpl(theta));
			getVehicle(eass.getReasoningName()).addPercept(position);
		} else {
			// Else create a TwoWheeledRobot object to act as the environment for the agent.
			TwoWheeledRobot r = new TwoWheeledRobot(a);
			addVehicle(r);
			rName = r.getName();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#executeAction(java.lang.String, ail.syntax.Action)
	 * 
	 * When the agent executes an action this is passed through to the environment.  If we add actuators to vehicles
	 * then they should mediate between the vehicle and the environment.
	 */
	public Unifier executeAction(String agName, Action act) throws AILexception {
		if (act.getFunctor().equals("engageBothMotors")) {
			TwoWheeledRobot r = (TwoWheeledRobot) getVehicle(agName);
			double iterations  = ((NumberTerm) act.getTerm(0)).solve();
			double motorpower1 = r.getMotor1Power();
			double motorp2 = r.getMotor2Power();
			// Motor 2's actual power depends upon the stickiness of the wheel.
			double motorpower2 = motorp2 - (motorp2*sticky_modifier);
			
			// For the  time being we assume all constants (for wheel size etc.) are 1 
			// so motorpower is directly equivalent to the forward velocity of each wheel.
			
			int count = 0;
			while (count < iterations) {
				double robot_velocity = (motorpower1 + motorpower2)/2;
				double xdot = Math.cos(Math.toRadians(theta)) * robot_velocity;
				double ydot = Math.sin(Math.toRadians(theta)) * robot_velocity;
				double thetadot = (motorpower1 - motorpower2)/2;
			
				// We assume 1 time step has elapsed
				x += xdot;
				y += ydot;
				theta += thetadot;
				
				// NB. The above equations are standard but don't always accurately give the movement
				// e.g., if one wheel isn't turning at all.
				
				Predicate position = new Predicate("position");
				position.addTerm(new NumberTermImpl(x));
				position.addTerm(new NumberTermImpl(y));
				position.addTerm(new NumberTermImpl(theta));
			 
				getVehicle(agName).addPercept(position);

				// Vehicle environments may have GUI interfaces.  We assume that we have a WheeledRobotUI interface for this and
				// update it with the robot's new position.  NB. It might be nice to make this more generic via an interface at some point.
				((WheeledRobotUI) gui).updateGraphics(x, y, theta);
				count++;
			}
		} 
		
		return super.executeAction(agName, act);
	}
	
	/**
	 * Return the x position of the vehicle.
	 * @return
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * Return the y position of the vehicle.
	 * @return
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * Return the orientation of the vehicle.
	 * @return
	 */
	public double getTheta() {
		return theta;
	}
	
	/**
	 * Set the target location for the robot - presumably coming in from an external control system.
	 * @param rname
	 * @param p
	 */
	public void setTarget(String rname, Predicate p) {
		addPercept(rname, p);
	}
	
	/**
	 * Set the environment's GUI interface.
	 * @param ui
	 */
	public void setGUI(WheeledRobotUI ui) {
		gui = ui;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#done()
	 */
	public boolean done() {
		return false;
	}


	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(MCAPLJobber o) {
		return (getName().compareTo(o.getName()));
	}


	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLJobber#do_job()
	 */
	public void do_job() {
		int activeJobbers = scheduler.getActiveJobbers().size();
		if (activeJobbers > 1 || activeJobbers < 1) {
			notifyListeners("scheduler");
		} else {
			done();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLJobber#getName()
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set the stickiness of the Wheel.
	 * @param s
	 */
	public void setStickiness(double s) {
		sticky_modifier = s/100;
	}

}
