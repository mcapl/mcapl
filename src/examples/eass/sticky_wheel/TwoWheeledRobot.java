package eass.sticky_wheel;

import java.util.List;
import java.util.ArrayList;

import eass.mas.vehicle.EASSVehicle;
import ail.semantics.AILAgent;
import ail.syntax.Action;
import ail.syntax.Predicate;
import ail.syntax.Unifier;
import ail.util.AILexception;
import ail.mas.vehicle.Sensor;

public class TwoWheeledRobot extends EASSVehicle {
	double motor1power = 0;
	double motor2power = 0;
	
	WheeledRobotUI gui;
	
	public TwoWheeledRobot(AILAgent a) {
		addAgent(a);
		a.setEnv(this);
		addSensor(new startSensor());
		addSensor(new SimpleGPS());
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
			gui.updateGraphics(x, y);
		} else if (act.getFunctor().equals("turn")) {
		
		} else if (act.getFunctor().equals("calculate_angle")) {
			
		} else if (act.getFunctor().equals("calculate_distance")) {
			
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
	
	public void setInterface(WheeledRobotUI ui) {
		gui = ui;
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
