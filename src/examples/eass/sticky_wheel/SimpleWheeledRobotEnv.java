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
import ajpf.MCAPLJobber;

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
	
	public SimpleWheeledRobotEnv() {
		super();
		ActionScheduler s = new ActionScheduler();
		scheduler = s;
		setScheduler(s);
		s.addJobber(this);
		addPerceptListener(s);
	}
	

	public void addAgent(AILAgent a) {
		EASSAgent eass = (EASSAgent) a;
		
		if (contains(eass.getReasoningName())) {
			this.addAgentToVehicle(eass);
			Predicate position = new Predicate("position");
			position.addTerm(new NumberTermImpl(x));
			position.addTerm(new NumberTermImpl(y));
			position.addTerm(new NumberTermImpl(theta));
			getVehicle(eass.getReasoningName()).addPercept(position);
		} else {
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
			double motorpower2 = motorp2 - (motorp2*sticky_modifier);
			
			
			// For the  time being we assume all constants are 1 so motorpower is directly equivalent to the forward velocity of each wheel
			
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
				Predicate position = new Predicate("position");
				position.addTerm(new NumberTermImpl(x));
				position.addTerm(new NumberTermImpl(y));
				position.addTerm(new NumberTermImpl(theta));
			 
				getVehicle(agName).addPercept(position);

				((WheeledRobotUI) gui).updateGraphics(x, y, theta);
				count++;
			}
			System.err.println("(" + x + " ," + y + ")");

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
		addPercept(rname, p);
	}
	
	public void setInterface(WheeledRobotUI ui) {
		gui = ui;
	}
	
	public void setGUI(WheeledRobotUI ui) {
		gui = ui;
	}

	
	public boolean done() {
		return false;
	}


	@Override
	public int compareTo(MCAPLJobber o) {
		return 0;
	}


	@Override
	public void do_job() {
		// TODO Auto-generated method stub
		int activeJobbers = scheduler.getActiveJobbers().size();
		if (activeJobbers > 1 || activeJobbers < 1) {
			notifyListeners("scheduler");
		} else {
			done();
		}
	}


	@Override
	public String getName() {
		return name;
	}
	
	public void setStickiness(double s) {
		sticky_modifier = s/100;
	}

}
