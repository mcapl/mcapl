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
import lejos.remote.ev3.RemoteRequestSampleProvider;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.filter.AbstractFilter;
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
	RemoteRequestRegulatedMotor motorL;
	RemoteRequestRegulatedMotor motorR;
	RemoteRequestRegulatedMotor motor;
	SimpleTouch touch;
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
			uSensor = new EASSUltrasonicSensor(brick, "S2");
			System.err.println("Connected to Sensor");
			setSensor(1, uSensor);
		} catch (Exception e) {
			brick.disConnect();
			throw e;
		}
			
		EASSRGBColorSensor cSensor;
		try {
			System.err.println("Connecting to Colour Sensor");
			cSensor = new EASSRGBColorSensor(brick, "S3");
			System.err.println("Connected to Sensor");
			setSensor(2, cSensor);
		} catch (Exception e) {
			uSensor.close();
			brick.disConnect();
			throw e;
		}
		
		try{
			System.err.println("Connecting to Touch Sensor");
			touch = new SimpleTouch(brick, "S1");
			System.err.println("Connected to Sensor");
		} catch (Exception e) {
			uSensor.close();
			cSensor.close();
			brick.disConnect();
			throw e;
		}
			
		try {
			System.err.println("Creating Pilot");
			motorR = (RemoteRequestRegulatedMotor) brick.createRegulatedMotor("B", 'L');
			motorL = (RemoteRequestRegulatedMotor) brick.createRegulatedMotor("C", 'L');
			System.err.println("Created Pilot");
		} catch (Exception e) {
			uSensor.close();
			cSensor.close();
			touch.close();
			brick.disConnect();
			throw e;
		}
			
		try {
			System.err.println("Contacting Medium Motor");
			motor = (RemoteRequestRegulatedMotor) brick.createRegulatedMotor("A", 'M');
			System.err.println("Created Medium Motor");
		} catch (Exception e) {
			uSensor.close();
			cSensor.close();
			touch.close();
			motorR.close();
			motorL.close();
			brick.disConnect();
			throw e;
		}
		
		System.err.println(motorR.getSpeed());
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
			super.disconnected = true;
			System.err.println("Closing Dinor3x");
			try {
				motor.stop();
				motor.close();
				motorR.stop();
				motorL.stop();
				motorR.close();
				motorL.close();
				touch.close();
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
		
	public void forward() {
		motorR.backward();
		motorL.backward();
	}
		
	public void backward() {
		motorR.forward();
		motorL.forward();
	}
		
	public void stop() {
		motorR.stop();
		motorL.stop();
	}
		
	public void left() {
		motorR.forward();
		motorL.backward();
	}
		
	public void right() {
		motorR.backward();
		motorL.forward();
	}
		
	public void calibrate() {
		motorL.setSpeed(50);
		motorR.setSpeed(100);
		motorR.forward();
		motorL.forward();
		while(touch.isPressed()) {
					
		}
		stop();
		motorR.setSpeed(100);
		motorL.setSpeed(100);
		motorR.forward();
		while(!touch.isPressed()) {
			
		}
		stop();
		motorR.rotate(-72);
		motorL.forward();
		while(!touch.isPressed()) {
			
		}
		stop();
		motorL.rotate(-72);
		motorR.setSpeed(360);
		motorL.setSpeed(360);
		
	}
	
	public class SimpleTouch {
		  private float[] sample;
		  RemoteRequestSampleProvider sensor;
		  
		  public SimpleTouch(RemoteRequestEV3 brick, String portName) {
			sensor = (RemoteRequestSampleProvider) brick.createSampleProvider(portName, "lejos.hardware.sensor.EV3TouchSensor", "Touch");
		    sample = new float[sensor.sampleSize()];
		  }

		  public boolean isPressed() {
		    sensor.fetchSample(sample, 0);
		    if (sample[0] == 0)
		      return false;
		    return true;
		  }
		  
		  public void close() {
			  sensor.close();
		  }

	}

				
		
}
