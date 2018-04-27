// ----------------------------------------------------------------------------
// Copyright (C) 2015 Louise A. Dennis,  and Michael Fisher
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
package eass.tutorials;

import org.junit.Assert;
import org.junit.Test;

import ail.mas.AIL;
import ail.mas.MAS;
import ail.util.AILConfig;
import ajpf.MCAPLcontroller;
import eass.tutorials.motorwaysim.Motorway;
import eass.tutorials.motorwaysim.MotorwayConfig;
import eass.tutorials.motorwaysim.Car;

public class Tutorial1SocketTest {
	
	  @Test //----------------------------------------------------------------------
	  public void basicmotorway () {
		
		Motorway motorway = new Motorway("default");
		
		Thread motorwayThread = new Thread(motorway);
		motorway.start();
		motorwayThread.start();
		Car car = motorway.getCar1();
		car.setYDot(1);
		while (car.getY() < 10 ) {
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				System.out.println("Interrupted: " + e.getMessage());
			}
		}
		motorway.stop();
		Assert.assertTrue(car.getY() >= 10); 

	  }

	  @Test //----------------------------------------------------------------------
	  public void tutorialexample () {
		  final MotorwayConfig config = new MotorwayConfig("/src/examples/eass/tutorials/motorwaysim/config.txt");
		
		MotorwayR motorwayR = new MotorwayR(config);
		Thread motorwayThread = new Thread(motorwayR);
		AILThread ailThread = new AILThread("/src/examples/eass/tutorials/tutorial1/car.ail");
		motorwayThread.start();

		// Allowing times for sockets to start up.
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			System.out.println("Interrupted: " + e.getMessage());
		}
		ailThread.start();

		// Allowing times for sockets to start up.
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			System.out.println("Interrupted: " + e.getMessage());
		}

		
		Motorway motorway = motorwayR.getMotorway();
		Car car = motorway.getCar1();

		motorway.start();
		while (car.getYTot() < 1500 ) {
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				System.out.println("Interrupted: " + e.getMessage());
			}
		}
		ailThread.stopAIL();
		motorway.stop();
		Assert.assertTrue(car.getYDot() >= 5); 

	  }
	  
	  @Test //----------------------------------------------------------------------
	  public void tutorialex2 () {
	 	final MotorwayConfig config = new MotorwayConfig("/src/examples/eass/tutorials/motorwaysim/config.txt");
		
	 	MotorwayR motorwayR = new MotorwayR(config);
		Thread motorwayThread = new Thread(motorwayR);
		AILThread ailThread = new AILThread("/src/examples/eass/tutorials/tutorial1/answers/car_ex2.ail");
		motorwayThread.start();

		// Allowing times for sockets to start up.
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			System.out.println("Interrupted: " + e.getMessage());
		}
		ailThread.start();

		// Allowing times for sockets to start up.
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			System.out.println("Interrupted: " + e.getMessage());
		}

		
		Motorway motorway = motorwayR.getMotorway();
		Car car = motorway.getCar1();

		motorway.start();
		while (car.getYTot() < 500 ) {
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				System.out.println("Interrupted: " + e.getMessage());
			}
		}

		while (car.getYDot() > 0 ) {
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				System.out.println("Interrupted: " + e.getMessage());
			}
		}
		ailThread.stopAIL();
		motorway.stop(); 
	  }

	  
	  public class AILThread extends Thread {
		  String filename;
		  MCAPLcontroller mccontrol;
		  
		  public AILThread(String s) {
			  filename = s;
		  }
		  
		  public void run() {
				AILConfig config = new AILConfig(filename);
				AIL.configureLogging(config);
			
				mccontrol = new MCAPLcontroller(config, "");

				// Create the initial state of the multi-agent program.
				MAS mas = AIL.AILSetup(config, mccontrol);
				
				// Set up a controller
				mccontrol.setMAS(mas);
				
				// Begin!
				mccontrol.begin(); 
				mas.cleanup();
		  }
		  
		  public void stopAIL() {
			  mccontrol.stop();
		  }
	  }
	  
	  public class MotorwayR implements Runnable {
		  MotorwayConfig config;
		  
		  MotorwayR(MotorwayConfig conf) {
			  config = conf;
		  }
		  
		  Motorway motorway;
		  public void run() {
			  motorway = new Motorway(config.getProperty("car1.control"));
			 
			  motorway.run();
		  }
		  
		  public Motorway getMotorway() {
			  return motorway;
		  }
	  }
}
