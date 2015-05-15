// ----------------------------------------------------------------------------
// Copyright (C) 2015 Strategic Facilities Technology Council 
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
package eass.ev3.cheltenham;

import java.io.PrintStream;

import lejos.remote.ev3.RemoteRequestEV3;
import lejos.remote.ev3.RemoteRequestPilot;
import lejos.remote.ev3.RemoteRequestRegulatedMotor;
import lejos.robotics.RegulatedMotor;
import eass.mas.ev3.BasicRobot;
import eass.mas.ev3.EASSRGBColorSensor;
import eass.mas.ev3.EASSSensor;
import eass.mas.ev3.EASSUltrasonicSensor;

/**
 * A class representing control of a lego robot dinosaur built to resemble the Dinor3x model.
 * @author lad
 *
 */
public class Dinor3x extends BasicRobot {
		RemoteRequestPilot pilot;
		RemoteRequestRegulatedMotor motor;
		private boolean closed = false;
		
		/**
		 * Set up the configuration of the robot.
		 * @param name
		 * @param address
		 */
		public Dinor3x(String address) throws Exception {
			super(address);
			RemoteRequestEV3 brick = getBrick();

			EASSUltrasonicSensor uSensor;
			try {
				System.err.println("Connecting to Ultrasonic Sensor");
				uSensor = new EASSUltrasonicSensor(brick, "S1");
				System.err.println("Connected to Sensor");
				setSensor(1, uSensor);
			} catch (Exception e) {
				brick.disConnect();
				throw e;
			}
			
			EASSRGBColorSensor cSensor;
			try {
				System.err.println("Connected to Colour Sensor");
				cSensor = new EASSRGBColorSensor(brick, "S2");
				System.err.println("Connected to Sensor");
				setSensor(2, cSensor);
			} catch (Exception e) {
				uSensor.close();
				brick.disConnect();
				throw e;
			}
			
			try {
				System.err.println("Creating Pilot");
				pilot = (RemoteRequestPilot) brick.createPilot(5, 15, "B", "A");
				System.err.println("Created Pilot");
			} catch (Exception e) {
				uSensor.close();
				cSensor.close();
				brick.disConnect();
				throw e;
			}
			pilot.setTravelSpeed(10);
			pilot.setRotateSpeed(15);
			setPilot(pilot); 
			
			try {
				System.err.println("Contacting Medium Motor");
				motor = (RemoteRequestRegulatedMotor) brick.createRegulatedMotor("C", 'M');
				System.err.println("Created Medium Motor");
			} catch (Exception e) {
				uSensor.close();
				cSensor.close();
				pilot.close();
				brick.disConnect();
				throw e;
			}
		}
		
		/*
		 * (non-Javadoc)
		 * @see eass.mas.ev3.BasicRobot#getPilot()
		 */
		@Override
		public RemoteRequestPilot getPilot() {
			return pilot;
		}
		
		/**
		 * Grab the print stream from the ultrasonic sensor.
		 * @param s
		 */
		public void setUPrintStream(PrintStream s) {
			//uPrintStream = s;
			EASSSensor uSensor = getSensor(1);
			if (uSensor != null) {
				uSensor.setPrintStream(s);
			}
		}
		
		/**
		 * Grab the red light print stream from the RGB sensor.
		 * @param s
		 */
		public void setRedPrintStream(PrintStream s) {
			EASSRGBColorSensor rgbSensor = (EASSRGBColorSensor) getSensor(2);
			if (rgbSensor != null) {
				rgbSensor.setRedPrintStream(s);
			}
		}
	 
		/**
		 * Grab the blue light print stream from the RGB sensor.
		 * @param s
		 */
		public void setBluePrintStream(PrintStream s) {
			EASSRGBColorSensor rgbSensor = (EASSRGBColorSensor) getSensor(2);
			if (rgbSensor != null) {
				rgbSensor.setBluePrintStream(s);
			}
		}
	

		/**
		 * Close down all the hardware components and sockets.
		 */
		public void close() {
			if (! closed) {
				System.err.println("Closing Dinor3x");
				try {
					motor.stop();
					motor.close();
					pilot.stop();
					pilot.close();
				} catch (Exception e) {
				
				}
				super.close();
			}
			closed = true;
		}
		
		/**
		 * Get the medium motor that control the dinosaur's jaws.
		 * @return
		 */
		public RegulatedMotor getMotor() {
			return motor;
		}
		
}
