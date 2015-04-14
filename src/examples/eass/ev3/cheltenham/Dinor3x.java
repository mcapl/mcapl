package eass.ev3.cheltenham;

import java.io.PrintStream;

import lejos.remote.ev3.RemoteRequestEV3;
import lejos.remote.ev3.RemoteRequestPilot;
import eass.mas.ev3.BasicRobot;
import eass.mas.ev3.EASSSensor;
import eass.mas.ev3.EASSUltrasonicSensor;

public class Dinor3x extends BasicRobot {
		RemoteRequestPilot pilot;
		PrintStream uPrintStream = System.out;
		
		/**
		 * Set up the configuration of the robot.
		 * @param name
		 * @param address
		 */
		public Dinor3x(String address) throws Exception {
			super(address);
			
			RemoteRequestEV3 brick = getBrick();
			try {
				EASSUltrasonicSensor uSensor = new EASSUltrasonicSensor(brick, "S1");
				setSensor(1, uSensor);
				uSensor.setPrintStream(uPrintStream);
			} catch (Exception e) {
				throw e;
			}
			pilot = (RemoteRequestPilot) brick.createPilot(5, 15, "B", "A");
			pilot.setTravelSpeed(10);
			pilot.setRotateSpeed(15);
			setPilot(pilot); 
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
		super.close();
	}


}
