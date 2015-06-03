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
	RemoteRequestPilot pilot;
	SimpleTouch touch;
	private boolean closed = false;
	private boolean wheeled = true;
	private boolean straight = false;
		
	int touchport = 1;
	int ultra_port = 2;
	int color_port = 3;
	
	int slow_turn = 70;
	int fast_turn = 80;
	int travel_speed = 10;
	

	/**
	 * Set up the configuration of the robot.
	 * @param name
	 * @param address
	 */
	public Dinor3x(String address) throws Exception {
		super(address);
		RemoteRequestEV3 brick = getBrick();
		
		EASSUltrasonicSensor uSensor;
		String touchportstring = "S" + touchport;
		String ultra_portstring = "S" + ultra_port;
		String color_portstring = "S" + color_port;
		
		try {
			System.err.println("Connecting to Ultrasonic Sensor");
			uSensor = new EASSUltrasonicSensor(brick, ultra_portstring);
			System.err.println("Connected to Sensor");
			setSensor(ultra_port, uSensor);
		} catch (Exception e) {
			brick.disConnect();
			throw e;
		}
			
		EASSRGBColorSensor cSensor;
		try {
			System.err.println("Connecting to Colour Sensor");
			cSensor = new EASSRGBColorSensor(brick, color_portstring);
			System.err.println("Connected to Sensor");
			setSensor(color_port, cSensor);
		} catch (Exception e) {
			uSensor.close();
			brick.disConnect();
			throw e;
		}
		
		try{
			System.err.println("Connecting to Touch Sensor");
			touch = new SimpleTouch(brick, touchportstring);
			System.err.println("Connected to Sensor");
		} catch (Exception e) {
			uSensor.close();
			cSensor.close();
			brick.disConnect();
			throw e;
		}
			
		try {
			System.err.println("Creating Pilot");
			// Creating motors as well as pilot in order to allow turning on the spot.
			motorR = (RemoteRequestRegulatedMotor) brick.createRegulatedMotor("B", 'L');
			motorL = (RemoteRequestRegulatedMotor) brick.createRegulatedMotor("C", 'L');
			motorR.setSpeed(200);
			motorL.setSpeed(200);
			pilot = (RemoteRequestPilot) brick.createPilot(7, 20, "C", "B");
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
	}
		
	/**
	 * Grab the print stream from the ultrasonic sensor.
	 * @param s
	 */
	public void setUPrintStream(PrintStream s) {
		//uPrintStream = s;
		EASSSensor uSensor = getSensor(ultra_port);
		if (uSensor != null) {
			uSensor.setPrintStream(s);
		}
	}
		
	/**
	 * Grab the red light print stream from the RGB sensor.
	 * @param s
	 */
	public void setRedPrintStream(PrintStream s) {
		EASSRGBColorSensor rgbSensor = (EASSRGBColorSensor) getSensor(color_port);
		if (rgbSensor != null) {
			rgbSensor.setRedPrintStream(s);
		}
	}
	 
	/**
	 * Grab the blue light print stream from the RGB sensor.
	 * @param s
	 */
	public void setGreenPrintStream(PrintStream s) {
		EASSRGBColorSensor rgbSensor = (EASSRGBColorSensor) getSensor(color_port);
		if (rgbSensor != null) {
			rgbSensor.setGreenPrintStream(s);
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
				System.err.println("   Closing Jaw Motor");
				motor.close();
				wait(10);
				motorR.stop();
				motorL.stop();
				System.err.println("   Closing Right Motor");
				motorR.close();
				wait(10);
				System.err.println("   Closing Left Motor");
				motorL.close();
				wait(10);
				pilot.stop();
				System.err.println("   Closing Pilot");
				pilot.close();
				wait(10);
				System.err.println("   Closing Touch Sensor");
				touch.close();
				wait(10);
			} catch (Exception e) {
				
			}
			System.err.println("   Closing Remaining Sensors");
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
		
	/**
	 * Move forward
	 */
	public void forward() {
		pilot.setTravelSpeed(travel_speed);
		if (!wheeled & !straight) {
			calibrate();
			straight = true;
		}
		if (! wheeled ) {
			pilot.backward();
		} else {
			pilot.forward();
		}
	}
	
	/**
	 * Move forward a short distance.
	 */
	public void short_forward() {
		pilot.setTravelSpeed(travel_speed);
		if (!wheeled & !straight) {
			calibrate();
			straight = true;
		}
		if (! wheeled) {
			pilot.travel(-10);
		} else {
			pilot.travel(10);
		}
	}
	
		
	/**
	 * Move backward
	 */
	public void backward() {
		pilot.setTravelSpeed(travel_speed);
		if (!wheeled & ! straight) {
			calibrate();
			straight = true;
		}
		if (!wheeled) {
			pilot.forward();
		} else {
			pilot.backward();
		}
	}
		
	/**
	 * Move backward a short distance.
	 */
	public void short_backward() {
		pilot.setTravelSpeed(travel_speed);
		if (!wheeled & !straight) {
			calibrate();
			straight = true;
		}
		if (! wheeled) {
			pilot.travel(10);
		} else {
			pilot.travel(-10);
		}
	}

	/**
	 * Stop.
	 */
	public void stop() {
		pilot.stop();
	}
	
	/**
	 * Turn left on the spot.
	 */
	public void left() {
		motorR.setSpeed(fast_turn);
		motorL.setSpeed(fast_turn);
		
		if (!wheeled) {
			motorR.forward();
			motorL.backward();
		} else {
			motorR.backward();
			motorL.forward();
		}
		straight = false;
	}
	
	/**
	 * Turn left through an angle (approx 90 on the wheeled robots).
	 */
	public void short_left() {
		pilot.setRotateSpeed(travel_speed);
		if (!wheeled) {
			pilot.rotate(720);
		} else {
			pilot.rotate(-90);
		}
		straight = false;
	}
		
	/**
	 * Move left around stopped wheel.
	 */
	public void forward_left() {
		motorL.setSpeed(slow_turn);
		if (!wheeled) {
			motorL.backward();
		} else {
			motorL.forward();
		}
		motorR.stop();
		straight = false;
	}

	/**
	 * Turn right on the spot.
	 */
	public void right() {
		motorR.setSpeed(fast_turn);
		motorL.setSpeed(fast_turn);

		if (!wheeled) {
			motorR.backward();
			motorL.forward();
		} else {
			motorR.forward();
			motorL.backward();
		}
		straight = false;
	}
	
	/**
	 * Turn a short distance right (approx 90 on a wheeled robot)
	 */
	public void short_right() {
		pilot.setRotateSpeed(travel_speed);
		if (!wheeled) {
			pilot.rotate(-720);
		} else {
			pilot.rotate(90);
		}
		straight = false;
	}

		
	/**
	 * Turn right around stopped left whell.
	 */
	public void forward_right() {
		motorR.setSpeed(slow_turn);
		if (!wheeled) {
			motorR.backward();
		} else {
			motorR.forward();
		}
		motorL.stop();
		straight = false;
	}
	
	/**
	 * Snap jaws to scare something.
	 */
	public void scare() {
   		int pos = motor.getTachoCount();
   		motor.rotateTo(pos + 20);
   		motor.waitComplete();
   		motor.rotateTo(pos);
   		motor.waitComplete();
   		motor.rotateTo(pos + 20);
   		motor.waitComplete();
   		motor.rotateTo(pos);
   		motor.waitComplete();
	}
	
	/**
	 * Rotate right motor some angle.
	 * @param d
	 */
	public void turn(int d) {
		motorR.rotate(d);
	}

	/**
	 * If the robot is legged, calibrate the leg positions for motion.
	 */
	private void calibrate() {
		motorL.setSpeed(70);
		motorR.setSpeed(140);
		motorR.forward();
		motorL.forward();
		while(touch.isPressed()) {
					
		}
		stop();
		motorR.setSpeed(200);
		motorL.setSpeed(200);
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
	
	/**
	 * A class for the touch sensor used for calibration when the robot has legs.
	 * @author louiseadennis
	 *
	 */
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
	
	/**
	 * Set whether this robot has wheels.
	 * @param w
	 */
	public void setWheeled(boolean w) {
		wheeled = w;
		if (wheeled) {
			slow_turn = 35;
			fast_turn = 40;
		} else {
			slow_turn = 70;
			fast_turn = 80;
		}
		travel_speed = 10;
		pilot.setTravelSpeed(travel_speed);
		motorL.setSpeed(fast_turn);
		motorR.setSpeed(fast_turn);
	}
	
	public EASSSensor getRGBSensor() {
		return super.getSensor(color_port);
	}

				
		
}
