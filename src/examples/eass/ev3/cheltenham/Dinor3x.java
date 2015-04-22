package eass.ev3.cheltenham;

import java.io.PrintStream;

import lejos.remote.ev3.RemoteRequestEV3;
import lejos.remote.ev3.RemoteRequestPilot;
import lejos.remote.ev3.RemoteRequestRegulatedMotor;
import lejos.robotics.RegulatedMotor;
import eass.mas.ev3.BasicRobot;
import eass.mas.ev3.EASSRGBColorSensor;
import eass.mas.ev3.EASSRedColorSensor;
import eass.mas.ev3.EASSRemoteRequestEV3;
import eass.mas.ev3.EASSRemoteRequestRegulatedMotor;
import eass.mas.ev3.EASSSensor;
import eass.mas.ev3.EASSUltrasonicSensor;

public class Dinor3x extends BasicRobot {
		RemoteRequestPilot pilot;
		RemoteRequestRegulatedMotor motor;
		PrintStream uPrintStream = System.out;
		
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
				uSensor.setPrintStream(uPrintStream);
			} catch (Exception e) {
				brick.disConnect();
				throw e;
			}
			
			EASSRedColorSensor cSensor;
			try {
				System.err.println("Connected to Colour Sensor");
				cSensor = new EASSRedColorSensor(brick, "S2");
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
		
	@Override
	public RemoteRequestPilot getPilot() {
		return pilot;
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
		System.err.println("Closing Dinor3x");
		// pilot.close();
		try {
			motor.close();
		} catch (Exception e) {
			
		}
		super.close();
	}
	
	public RegulatedMotor getMotor() {
		return motor;
	}
	
	public void growl() {
		try {
			motor.resetTachoCount();
			motor.forward();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void stopGrowling() {
		try {
			motor.flt();
//			motor.stop();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}


}
