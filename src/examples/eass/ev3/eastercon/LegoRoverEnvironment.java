// ----------------------------------------------------------------------------
// Copyright (C) 2015 Louise A. Dennis, and  Michael Fisher 
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

package eass.ev3.eastercon;

import ail.util.AILexception;
import ail.mas.scheduling.RoundRobinScheduler;
import ail.syntax.Unifier;
import ail.syntax.Action;
import ail.syntax.Literal;
import eass.mas.ev3.EASSEV3Environment;
import eass.mas.ev3.EASSTouchSensor;
import eass.mas.ev3.EASSUltrasonicSensor;
import eass.mas.ev3.LegoRobot;
import eass.mas.ev3.BasicRobot;
import eass.mas.ev3.EASSSensor;
import lejos.remote.ev3.RemoteRequestPilot;
import lejos.remote.ev3.RemoteRequestEV3;

import java.io.PrintStream;


/**
 * A simple environment for an EV3 Robot with an Ultrasonic sensor.  Developed to illstrate a talk "How do I know my robot is safe"? presented
 * at Eastercon 2015.
 * 
 * @author louiseadennis
 *
 */
public class LegoRoverEnvironment extends EASSEV3Environment {
	boolean rule1 = false;
	boolean rule2 = false;
	boolean rule3 = false;
	
	/**
	 * Construct the Environment.
	 */
	public LegoRoverEnvironment() {
		super();
		RoundRobinScheduler s = new RoundRobinScheduler();
		s.addJobber(this);
		setScheduler(s);
		addPerceptListener(s);
	}
	
	/**
	 * Create the relevant object for the robot.
	 */
	public Dysprosium createRobot(String agent) {
		Dysprosium robot;
		try {
			System.err.println("Contacting Robot");
			robot = new Dysprosium("10.0.1.1");
			System.err.println("Connection Established");
			addRobot(agent, robot);
			return robot;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see eass.mas.nxt.EASSNXTEnvironment#executeAction(java.lang.String, ail.syntax.Action)
	 */
	public Unifier executeAction(String agName, Action act) throws AILexception {
		   Unifier u = new Unifier();
		   String rname = rationalName(agName);
		   Dysprosium robot = (Dysprosium) getRobot(rname);
		  
			     
		   	if (act.getFunctor().equals("forward")) {
		   		robot.getPilot().backward();
		   	} else if (act.getFunctor().equals("shutdown")) {
		   		this.setDone(true);
		   	} else if (act.getFunctor().equals("stop")) {
		   		robot.getPilot().stop();
		   	} else if (act.getFunctor().equals("right")) {
		   		((RemoteRequestPilot) robot.getPilot()).steer(100);
		   	} else if (act.getFunctor().equals("right90")) {
		   		robot.getPilot().rotate(-90);
		   	} else if (act.getFunctor().equals("left90")) {
		   		robot.getPilot().rotate(90);
		   	} else if (act.getFunctor().equals("backward")) {
		   		robot.getPilot().travel(-10);
		   	} else if (act.getFunctor().equals("rule1")) {
		   		if (!rule1) {
		   			addSharedBelief(rname, new Literal("rule1"));
		   			rule1 = true;
		   		} else {
		   			removeSharedBelief(rname, new Literal("rule1"));
		   			rule1 = false;
		   		}
		   	} else if (act.getFunctor().equals("rule2")) {
		   		if (!rule2) {
		   			addSharedBelief(rname, new Literal("rule2"));
		   			rule2 = true;
		   		} else {
		   			removeSharedBelief(rname, new Literal("rule2"));
		   			rule2 = false;
		   		}
		   	} else if (act.getFunctor().equals("rule3")) {
		   		if (!rule3) {
		   			addSharedBelief(rname, new Literal("rule3"));
		   			rule3 = true;
		   		} else {
		   			removeSharedBelief(rname, new Literal("rule3"));
		   			rule3 = false;
		   		}
		   	} else if (act.getFunctor().equals("wait")) {
				try {
	    			Thread.sleep(500);
	    		} catch (InterruptedException ie) {
	    			System.out.println("catching interrupt");
	    		}
				addSharedBelief(rname, new Literal("waited"));
		   	} else {
		   		u = super.executeAction(agName, act);
		   	}
		   	
		   	return u;
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
		LegoRobot robot = getRobot(rname);
		if (robot instanceof Dysprosium) {
			((Dysprosium) robot).setUPrintStream(s);
		}
	}
	
	/**
	 * A class for Noor type robots (Robots with one ultrasonic sensor) and two motors.
	 * @author louiseadennis
	 *
	 */
	public class Dysprosium extends BasicRobot {
		RemoteRequestPilot pilot;
		PrintStream uPrintStream = System.out;
		PrintStream tPrintStream = System.out;
		
		/**
		 * Set up the configuration of the robot.
		 * @param name
		 * @param address
		 */
		public Dysprosium(String address) throws Exception {
			super(address);
			
//			if (isConnected()) {
				RemoteRequestEV3 brick = getBrick();
				try {
					EASSUltrasonicSensor uSensor = new EASSUltrasonicSensor(brick, "S1");
					setSensor(1, uSensor);
					uSensor.setPrintStream(uPrintStream);
					EASSTouchSensor tSensor = new EASSTouchSensor(brick, "S2", "abstraction_dysprosium");
					setSensor(2, tSensor);
					tSensor.setPrintStream(tPrintStream);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
				pilot = (RemoteRequestPilot) brick.createPilot(5, 15, "B", "A");
				pilot.setTravelSpeed(10);
				pilot.setRotateSpeed(15);
				setPilot(pilot); 
//			}
		}
		
		/**
		 * Grab the print stream from the ultrasonic sensor.
		 * @param s
		 */
		public void setUPrintStream(PrintStream s) {
			uPrintStream = s;
			EASSSensor uSensor = getSensor(1);
			if (uSensor != null) {
				uSensor.setPrintStream(s);
			}
		}
		
		/**
		 * Setter for the robot's travel speed.
		 * @param speed
		 */
		public void setSpeed(int speed) {
			pilot.setTravelSpeed(speed);
		}
		
		/**
		 * Setter for the robot's rotation speed.
		 * @param speed
		 */
		public void setRotateSpeed(int speed) {
			pilot.setRotateSpeed(speed);
		}
		
		
		/**
		 * Set a pilot for the robot.
		 */
		public void setPilot(RemoteRequestPilot npilot) {
			pilot = npilot;
		}
		
		/**
		 * Get the robot's pilot.
		 */
		public RemoteRequestPilot getPilot() {
			return pilot;
		}

		
		public void close() {
			pilot.close();
			super.close();
		}
	}
	
	@Override
	public void cleanup() {
		LegoRobot dysprosium = this.getRobot("dysprosium");
		dysprosium.close();
	}


}
