package eass.sticky_wheel;

import gwendolen.uavs.prism.SimpleUAV;
import ail.mas.ActionScheduler;
import ail.mas.vehicle.VehicleEnv;
import eass.mas.vehicle.EASSVehicleEnvironment;
import eass.semantics.EASSAgent;
import ail.semantics.AILAgent;
import ail.syntax.Action;
import ail.syntax.Unifier;
import ail.syntax.Predicate;
import ail.syntax.NumberTermImpl;
import ail.syntax.NumberTerm;
import ail.util.AILexception;

public class SimpleWheeledRobotEnv extends EASSVehicleEnvironment {
	String name = "Simple Wheeled Robot Env";
	
	// Assume one robot for the time being
	double x;
	double y;
	double theta;
	
	WheeledRobotUI gui;
	
	public SimpleWheeledRobotEnv() {
		super();
		ActionScheduler s = new ActionScheduler();
		setScheduler(s);
		addPerceptListener(s);
	}
	

	public void addAgent(AILAgent a) {
		EASSAgent eass = (EASSAgent) a;
		
		if (contains(eass.getReasoningName())) {
			this.addAgentToVehicle(eass);
		} else {
			TwoWheeledRobot r = new TwoWheeledRobot(a);
			addVehicle(r);
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
			double motorpower2 = r.getMotor2Power();
			
			
			// For the  time being we assume all constants are 1 so motorpower is directly equivalent to the forward velocity of each wheel
			
			int count = 0;
			while (count < iterations) {
				double robot_velocity = (motorpower1 + motorpower2)/2;
				double xdot = Math.cos(theta) * robot_velocity;
				double ydot = Math.sin(theta) * robot_velocity;
				double thetadot = (motorpower1 - motorpower2)/2;
					
			
				// We assume 1 time step has elapsed
				x += xdot;
				y += ydot;
				theta += thetadot;
				Predicate position = new Predicate("position");
				position.addTerm(new NumberTermImpl(x));
				position.addTerm(new NumberTermImpl(y));
				position.addTerm(new NumberTermImpl(theta));
			 
				getVehicle(agName.substring(12)).addPercept(position);

				((WheeledRobotUI) gui).updateGraphics(xdot, ydot, thetadot);
				count++;
			}

		} 
		
		return super.executeAction(agName, act);
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getTheta() {
		return theta;
	}
	
	public void setTarget(String rname, Predicate p) {
		getVehicle(rname).addPercept(p);
	}
	
	public void setInterface(WheeledRobotUI ui) {
		gui = ui;
	}

	
	public boolean done() {
		return false;
	}

}
