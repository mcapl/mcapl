package eass.sticky_wheel;

import gwendolen.uavs.prism.SimpleUAV;
import ail.mas.RoundRobinScheduler;
import ail.mas.vehicle.VehicleEnv;
import eass.mas.vehicle.EASSVehicleEnvironment;
import eass.semantics.EASSAgent;
import ail.semantics.AILAgent;
import ail.syntax.Action;
import ail.syntax.Unifier;
import ail.util.AILexception;

public class SimpleWheeledRobotEnv extends EASSVehicleEnvironment {
	String name = "Simple Wheeled Robot Env";
	
	public SimpleWheeledRobotEnv() {
		super();
		RoundRobinScheduler s = new RoundRobinScheduler();
		setScheduler(s);
		addPerceptListener(s);
		connectedtomatlab = false;
	}
	
	public void addAgent(AILAgent a) {
		if (((EASSAgent) a).isAbstractionEngine()) {
			TwoWheeledRobot r = new TwoWheeledRobot(a);
			addVehicle(r);
		}
		super.addAgent(a);
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
			double motorpower1 = r.getMotor1Power();
			double motorpower2 = r.getMotor2Power();
			
			double theta = r.getTheta();
			
			// For the  time being we assume all constants are 1 so motorpower is directly equivalent to the forward velocity of each wheel
			
			double robot_velocity = (motorpower1 + motorpower2)/2;
			double xdot = Math.cos(theta) * robot_velocity;
			double ydot = Math.sin(theta) * robot_velocity;
			double thetadot = (motorpower1 - motorpower2)/2;
			
			// We assume 1 time step has elapsed
			r.setX(xdot);
			r.setY(ydot);
			r.setTheta(thetadot);
		} 
		
		return super.executeAction(agName, act);
	}

}
