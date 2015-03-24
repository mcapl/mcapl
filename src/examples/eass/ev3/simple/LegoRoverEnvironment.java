// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
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

package eass.ev3.simple;

import ail.util.AILexception;
import ail.mas.NActionScheduler;
import ail.syntax.Unifier;
import ail.syntax.Action;
import ail.syntax.Literal;
import ail.syntax.NumberTerm;
import eass.mas.ev3.EASSEV3Environment;
import eass.mas.ev3.EASSUltrasonicSensor;
import eass.mas.ev3.LegoRobot;
import eass.mas.ev3.BasicRobot;
import eass.mas.ev3.EASSSensor;
import lejos.hardware.Brick;
import lejos.hardware.BrickFinder;
import lejos.hardware.BrickInfo;
import lejos.hardware.device.NXTMMX;
import lejos.hardware.motor.NXTRegulatedMotor;
import lejos.hardware.port.SensorPort;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.remote.ev3.RemoteEV3;
import lejos.remote.ev3.RemoteRequestPilot;
import lejos.remote.ev3.RemoteRequestRegulatedMotor;
import lejos.remote.ev3.RemoteRequestEV3;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.ArcRotateMoveController;

import java.io.PrintStream;


/**
 * A simple environment for NXT Robots including sub-classes for two robot builds.  We need a more generic way of representing different robots
 * and robot configurations.
 * 
 * @author louiseadennis
 *
 */
public class LegoRoverEnvironment extends EASSEV3Environment {
	
	/**
	 * Construct the Environment.
	 */
	public LegoRoverEnvironment() {
		super();
		NActionScheduler s = new NActionScheduler(50);
		s.addJobber(this);
		setScheduler(s);
		addPerceptListener(s);
	}
	
	/**
	 * Create the relevant object for the robot.
	 */
	public LegoRobot createRobot(String agent) {
		LegoRobot robot;
		
		try {
			BrickInfo[] bricks = BrickFinder.discover();

			for(BrickInfo info: bricks) {
			   Brick brick = new RemoteEV3(info.getIPAddress());
			   brick.getAudio().systemSound(0);
			   System.err.println(info.getIPAddress());
			}

			
			robot = new Noor("10.0.1.1");
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
		   LegoRobot robot = getRobot(rname);
		  
			     
		   	if (act.getFunctor().equals("forward")) {
		   		if (robot.hasPilot()) {
		   			robot.getPilot().forward();
		   		}
		   	} else if (act.getFunctor().equals("stop")) {
		   		if (robot.hasPilot()) {
		   			robot.getPilot().stop();
		   		}
		   	} else if (act.getFunctor().equals("right90")) {
		   		if (robot.hasPilot()) {
		   			robot.getPilot().travelArc(1000, 1000);
		   		}
		   	} else if (act.getFunctor().equals("left90")) {
		   		if (robot.hasPilot()) {
		   			robot.getPilot().rotate(90);
		   		}
		   	} else if (act.getFunctor().equals("backward")) {
		   		if (robot.hasPilot()) {
		   			robot.getPilot().backward();
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
		if (robot instanceof Noor) {
			((Noor) robot).setUPrintStream(s);
		}
	}
	
	/**
	 * A class for Noor type robots (Robots with one ultrasonic sensor) and two motors.
	 * @author louiseadennis
	 *
	 */
	public class Noor extends BasicRobot {
		RemoteRequestPilot pilot;
		PrintStream uPrintStream = System.out;
		
		/**
		 * Set up the configuration of the robot.
		 * @param name
		 * @param address
		 */
		public Noor(String address) throws Exception {
			super(address);
			
//			if (isConnected()) {
				RemoteRequestEV3 brick = getBrick();
				try {
				//	EASSUltrasonicSensor uSensor = new EASSUltrasonicSensor(brick, "S1");
				//	setSensor(1, uSensor);
				//	uSensor.setPrintStream(uPrintStream);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
		//		RemoteRequestRegulatedMotor claudia_motorLeft = brick.createRegulatedMotor("B", 'L');
		//		RemoteRequestRegulatedMotor  claudia_motorRight = brick.createRegulatedMotor("A", 'L');
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
		
		public void close() {
			pilot.close();
			super.close();
		}
	}


}
