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

public class TwoWheeledRobot extends EASSVehicle {
	double motor1power = 0;
	double motor2power = 0;
	SimpleGPS gps = new SimpleGPS();
		
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
	 * When the agent executes an action this is passed through to the environment.  If we add actuators to vehicles
	 * then they should mediate between the vehicle and the environment.
	 */
	public Unifier executeAction(String agName, Action act) throws AILexception {
		if (act.getFunctor().equals("forward")) {
			setMotor1Power(1);
			setMotor2Power(1);
			double distance = ((NumberTerm) act.getTerm(0)).solve();
			Action engage = new Action("engageBothMotors");
			engage.addTerm(act.getTerm(0));
			super.executeAction(agName, engage);
		} else if (act.getFunctor().equals("turn")) {
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
			double current_x = ((NumberTerm) act.getTerm(0)).solve();
			double current_y = ((NumberTerm) act.getTerm(1)).solve();
			double target_x = ((NumberTerm) act.getTerm(2)).solve();
			double target_y = ((NumberTerm) act.getTerm(3)).solve();
			
			double distance = calculatedistance(current_x, current_y, target_x, target_y);
			Unifier U = new Unifier();
			U.unifies(act.getTerm(4), new NumberTermImpl(distance));
			return U;
			
		} else if (act.getFunctor().equals("feedback_control")) {
			double target_x = ((NumberTerm) act.getTerm(0)).solve();
			double target_y = ((NumberTerm) act.getTerm(1)).solve();
			
			double current_x = gps.getX();
			double current_y = gps.getY();
			double theta = gps.getTheta();
			
			while (calculatedistance(current_x, current_y, target_x, target_y) > 1) {
				double tantheta = (target_y - current_y)/(target_x - current_x);
				double desiredtheta = Math.toDegrees(Math.atan(tantheta));
				
				double thetadiff = (theta - desiredtheta);
				double scaling = 1;
				setMotor1Power(1);
				setMotor2Power(1);
				if (thetadiff > 1) {
					scaling = thetadiff;
				} else if (thetadiff < -1 ){
					scaling = -thetadiff;
				}
				
				if (thetadiff > 0) {
					setMotor1Power(1 - thetadiff/360);
					setMotor2Power(scaling*(1 + thetadiff/360));					
				} else if (thetadiff < 0){
					setMotor1Power(scaling*(1 - thetadiff/360));
					setMotor2Power(1 + thetadiff/360);
				}
				Action engage = new Action("engageBothMotors");
				engage.addTerm(new NumberTermImpl(1));
				super.executeAction(agName, engage);		
				
				current_x = gps.getX();
				current_y = gps.getY();
				theta = gps.getTheta();
			}
		} else if (act.getFunctor().equals("substitute_in_plans")) {
			Predicate capname = (Predicate) act.getTerm(0);
			Predicate post = (Predicate) act.getTerm(1);
			Predicate pre = (Predicate) act.getTerm(2);
			
			AILAgent ag = getAgent();
			Iterator<Plan> plans = ag.getPL().getPlansContainingCap(capname);
			Capability c = ag.getCL().findEquivalent(capname, pre, post, ag.getRuleBase());
			while (plans.hasNext()) {
				Plan p = plans.next();
				Plan newplan = (Plan) p.clone();
				
				newplan.replaceCap(capname, c);
				
				ag.removePlan(p);
				ag.addPlan(newplan);
			}
		}
		
		return super.executeAction(agName, act);
	}
	
	private double calculatedistance(double cx, double cy, double tx, double ty) {
		double xdiff = cx - tx;
		double ydiff = cy - ty;
		return Math.sqrt(xdiff*xdiff + ydiff*ydiff);
	}
	
	public void setMotor1Power(double d) {
		motor1power = d;
	}

	public void setMotor2Power(double d) {
		motor2power = d;
	}
	
	public double getMotor1Power() {
		return motor1power;
	}
	
	public double getMotor2Power() {
		return motor2power;
	}
	
	
	public void setInterface(WheeledRobotUI ui) {
		super.setInterface(ui);
	}
	
	public class startSensor implements Sensor {
		Predicate percept;

		@Override
		public int compareTo(Sensor o) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public List<Predicate> getPercepts() {
			// TODO Auto-generated method stub
			ArrayList<Predicate> percepts = new ArrayList<Predicate>();
			if (percept != null) {
				percepts.add(percept);
			}
			return percepts;
		}

		@Override
		public void addPercept(Predicate l) {
			// TODO Auto-generated method stub
			if (l.getFunctor().equals("target")) {
				percept = l;
			}
			
		}

		@Override
		public void removePercept(Predicate l) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void clearPercepts() {
			// TODO Auto-generated method stub
			
		}
		
	}
}
