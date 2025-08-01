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

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import eass.mas.vehicle.EASSVehicle;
import ail.semantics.AILAgent;
import ail.syntax.Action;
import ail.syntax.Predicate;
import ail.syntax.Unifier;
import ail.syntax.NumberTerm;
import ail.syntax.NumberTermImpl;
import ail.syntax.Capability;
import ail.syntax.Plan;
import ail.util.AILexception;
import ail.mas.vehicle.Sensor;

/**
 * A TwoWheeledRobot represents the control system for a two-wheeled robot.  It implements the EASSVehicle class and exists in 
 * a larger environment which reports the outcomes of the control system.
 * @author lad
 *
 */
public class TwoWheeledRobot extends EASSVehicle {
	double motor1power = 0;
	double motor2power = 0;
	SimpleGPS gps = new SimpleGPS();
		
	/**
	 * A Two wheeled robot use a gps sensor for position and orientation information and a "start sensor" to get information 
	 * about user commands from the interface.
	 * @param a
	 */
	public TwoWheeledRobot(AILAgent a) {
		addAgent(a);
		a.setEnv(this);
		addSensor(new startSensor());
		addSensor(gps);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#executeAction(java.lang.String, ail.syntax.Action)
	 * 
	 * When the agent executes an action this executes something in the control system which then, in turn, calls
	 * an action in the larger environment (engageBothMotors) typically.
	 */
	public Unifier executeAction(String agName, Action act) throws AILexception {
		if (act.getFunctor().equals("forward")) {
			//To move forward N engage both motors at power 1 for N iterations.
			setMotor1Power(1);
			setMotor2Power(1);

			Action engage = new Action("engageBothMotors");
			engage.addTerm(act.getTerm(0));
			super.executeAction(agName, engage);
		} else if (act.getFunctor().equals("turn")) {
			// To turn theta engage one motor at 1 and one at -1 for theta iterations.
			double angle = ((NumberTerm) act.getTerm(0)).solve();
			if (angle > 0) {
				setMotor1Power(1);
				setMotor2Power(-1);
			} else {
				setMotor1Power(-1);
				setMotor2Power(1);
			}
			Action engage = new Action("engageBothMotors");
			engage.addTerm(act.getTerm(0));
			super.executeAction(agName, engage);		
		} else if (act.getFunctor().equals("calculate_angle")) {
			// Maths for calculating the angle the robot needs to turn to in order to face some target point.
			
			double current_x = ((NumberTerm) act.getTerm(0)).solve();
			double current_y = ((NumberTerm) act.getTerm(1)).solve();
			double current_angle = ((NumberTerm) act.getTerm(2)).solve();
			double target_x = ((NumberTerm) act.getTerm(3)).solve();
			double target_y = ((NumberTerm) act.getTerm(4)).solve();
			
			double theta = 0;
			if (target_x != current_x) {
				double tantheta = (target_y - current_y)/(target_x - current_x);
				theta = Math.toDegrees(Math.atan(tantheta));
			}  else if (target_y > current_y){
				theta = 90;
			}  else {
				theta = 270;
			}
			
			double new_angle = current_angle + theta;
			Unifier U = new Unifier();
			U.unifies(act.getTerm(5), new NumberTermImpl(new_angle));
			return U;
		} else if (act.getFunctor().equals("calculate_distance")) {
			// Maths for calculating the distance to some target point.
			double current_x = ((NumberTerm) act.getTerm(0)).solve();
			double current_y = ((NumberTerm) act.getTerm(1)).solve();
			double target_x = ((NumberTerm) act.getTerm(2)).solve();
			double target_y = ((NumberTerm) act.getTerm(3)).solve();
			
			double distance = calculatedistance(current_x, current_y, target_x, target_y);
			Unifier U = new Unifier();
			U.unifies(act.getTerm(4), new NumberTermImpl(distance));
			return U;
			
		} else if (act.getFunctor().equals("feedback_control")) {
			// Use a simple feedback controller to move so some point.
			double target_x = ((NumberTerm) act.getTerm(0)).solve();
			double target_y = ((NumberTerm) act.getTerm(1)).solve();
			
			double current_x = gps.getX();
			double current_y = gps.getY();
			double theta = gps.getTheta();
			
			while (calculatedistance(current_x, current_y, target_x, target_y) > 1) {
				double tantheta = (target_y - current_y)/(target_x - current_x);
				double desiredtheta = Math.toDegrees(Math.atan(tantheta));
				
				// thetadiff represents how far the robot needs to turn to face the target.
				double thetadiff = (theta - desiredtheta);

				// We set the motors to turn towards the target with a slow forward movement.
				setMotor1Power(1-thetadiff);
				setMotor2Power(1+thetadiff);
				
				// Engage the motors for 1 iteration and then repeat the calculuations.
				Action engage = new Action("engageBothMotors");
				engage.addTerm(new NumberTermImpl(1));
				super.executeAction(agName, engage);		
				
				current_x = gps.getX();
				current_y = gps.getY();
				theta = gps.getTheta();
			}
		} else if (act.getFunctor().equals("substitute_in_plans")) {
			/* // This finds a new capability in the agents plans if the current capability has failed.
			// This code should probably appear elsewhere in the Capability or Plan classes.
			Predicate capname = (Predicate) act.getTerm(1);
			Predicate post = (Predicate) act.getTerm(0);
			// Predicate pre = (Predicate) act.getTerm(2);
			
			AILAgent ag = getAgent();
			Iterator<Plan> plans = ag.getPL().getPlansContainingCap(capname);
			Unifier u = new Unifier();
			Capability oldcap = ag.getCL().getRelevant(capname, AILAgent.SelectionOrder.LINEAR).next();
			Capability c = ag.getCL().findEquivalent(oldcap, post, ag.getRuleBase(), u );
			oldcap.apply(u);
			while (plans.hasNext()) {
				Plan p = plans.next();
				Plan newplan = (Plan) p.clone();
				
				newplan.replaceCap(capname, c, oldcap);
				newplan.resolveVarsClusters();
				
				ag.removePlan(p);
				ag.addPlan(newplan);
			} */
		}
		
		return super.executeAction(agName, act);
	}
	
	/**
	 * Standard maths for calculating a distance between two sets of coordinates.
	 * @param cx
	 * @param cy
	 * @param tx
	 * @param ty
	 * @return
	 */
	private double calculatedistance(double cx, double cy, double tx, double ty) {
		double xdiff = cx - tx;
		double ydiff = cy - ty;
		return Math.sqrt(xdiff*xdiff + ydiff*ydiff);
	}
	
	/**
	 * Setter for the power of motor 1.
	 * @param d
	 */
	public void setMotor1Power(double d) {
		motor1power = d;
	}

	/**
	 * Setter for the power of motor 2.
	 * @param d
	 */
	public void setMotor2Power(double d) {
		motor2power = d;
	}
	
	/**
	 * Getter for the power of motor 1.
	 * @return
	 */
	public double getMotor1Power() {
		return motor1power;
	}
	
	/**
	 * Getter for the power of motor 2.
	 * @return
	 */
	public double getMotor2Power() {
		return motor2power;
	}
	
	/**
	 * A mechanism to get user commands from the interface, implemented as a sensor.
	 * @author lad
	 *
	 */
	public class startSensor implements Sensor {
		// The sensor only ever contains one percept - the current vehicle target.
		Predicate percept;

		/*
		 * (non-Javadoc)
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		public int compareTo(Sensor o) {
			if (o instanceof startSensor) {
				return 0;
			} else {
				return -1;
			}
		}

		/*
		 * (non-Javadoc)
		 * @see ail.mas.vehicle.Sensor#getPercepts()
		 */
		public List<Predicate> getPercepts() {
			ArrayList<Predicate> percepts = new ArrayList<Predicate>();
			if (percept != null) {
				percepts.add(percept);
			}
			return percepts;
		}

		/*
		 * (non-Javadoc)
		 * @see ail.mas.vehicle.Sensor#addPercept(ail.syntax.Predicate)
		 */
		public void addPercept(Predicate l) {
			// Basically the only thing this senses is the addition of new targets for the robot.
			if (l.getFunctor().equals("target")) {
				percept = l;
			}
			
		}

		/*
		 * (non-Javadoc)
		 * @see ail.mas.vehicle.Sensor#removePercept(ail.syntax.Predicate)
		 */
		public void removePercept(Predicate l) {
		}

		/*
		 * (non-Javadoc)
		 * @see ail.mas.vehicle.Sensor#clearPercepts()
		 */
		public void clearPercepts() {
		}
		
	}
}
