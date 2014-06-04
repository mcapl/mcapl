package eass.sticky_wheel;

import eass.mas.vehicle.EASSVehicle;
import ail.semantics.AILAgent;
import ail.syntax.Action;
import ail.syntax.Unifier;
import ail.util.AILexception;

public class TwoWheeledRobot extends EASSVehicle {
	double motor1power = 0;
	double motor2power = 0;
	double x = 0;
	double y = 0;
	double theta = 0;
	
	public TwoWheeledRobot(AILAgent a) {
		addAgent(a);
		a.setEnv(this);
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
			setMotor1Power(10.0);
			setMotor2Power(10.0);
			super.executeAction(agName, new Action("engageBothMotors"));
		}
		
		return super.executeAction(agName, act);
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
	
	public void setX(double d) {
		x = d;
	}
	
	public void setY(double d) {
		y = d;
	}
	
	public void setTheta(double d) {
		theta = d;
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
}
