package eass.sticky_wheel.ros;

import java.util.Iterator;

import ail.semantics.AILAgent;
import ail.syntax.Action;
import ail.syntax.Capability;
import ail.syntax.NumberTerm;
import ail.syntax.NumberTermImpl;
import ail.syntax.Plan;
import ail.syntax.Predicate;
import ail.syntax.Unifier;
import ail.util.AILexception;
import eass.mas.ros.EASSROSEnvironment;

public class StickyWheelROSEnvironment extends EASSROSEnvironment {
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
			// This finds a new capability in the agents plans if the current capability has failed.
			// This code should probably appear elsewhere in the Capability or Plan classes.
			Predicate capname = (Predicate) act.getTerm(1);
			Predicate post = (Predicate) act.getTerm(0);
			// Predicate pre = (Predicate) act.getTerm(2);
			
			AILAgent ag = getAgent();
			Iterator<Plan> plans = ag.getPL().getPlansContainingCap(capname);
			Unifier u = new Unifier();
			Capability oldcap = ag.getCL().getRelevant(capname).next();
			Capability c = ag.getCL().findEquivalent(oldcap, post, ag.getRuleBase(), u );
			oldcap.apply(u);
			while (plans.hasNext()) {
				Plan p = plans.next();
				Plan newplan = (Plan) p.clone();
				
				newplan.replaceCap(capname, c, oldcap);
				newplan.resolveVarsClusters();
				
				ag.removePlan(p);
				ag.addPlan(newplan);
			}
		}
		
		return super.executeAction(agName, act);
	}
	
}
