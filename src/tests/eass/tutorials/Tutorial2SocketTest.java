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
import eass.tutorials.motorwaysim.Motorway;
import eass.tutorials.motorwaysim.MotorwayConfig;
import eass.tutorials.motorwaysim.Car;

public class Tutorial2SocketTest {
	

	  @Test //----------------------------------------------------------------------
	  public void tutorialexample () {
		final MotorwayConfig config = new MotorwayConfig("/src/examples/eass/tutorials/motorwaysim/config.txt");
		
		MotorwayThread motorwayThread = new MotorwayThread(config);
		AILThread ailThread = new AILThread("/src/examples/eass/tutorials/tutorial2/answers/car_ex1.ail");
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

		
		Motorway motorway = motorwayThread.getMotorway();
		Car car = motorway.getCar1();

		motorway.start();
		while (car.getYTot() < 1000 ) {
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				System.out.println("Interrupted: " + e.getMessage());
			}
		}
		motorway.stop();
		Assert.assertTrue(car.getX() <= 100); 

	  }
	  
	  @Test //----------------------------------------------------------------------
	  public void tutorialex2 () {
		final MotorwayConfig config = new MotorwayConfig("/src/examples/eass/tutorials/tutorial2/config.txt");
		
		MotorwayThread motorwayThread = new MotorwayThread(config);
		AILThread ailThread = new AILThread("/src/examples/eass/tutorials/tutorial2/answers/car_ex2.ail");
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

		
		Motorway motorway = motorwayThread.getMotorway();
		Car car = motorway.getCar1();

		motorway.start();
		while (car.getYTot() < 1000 ) {
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				System.out.println("Interrupted: " + e.getMessage());
			}
		}
		Assert.assertTrue(car.getX() > 0);
		motorway.stop(); 
	  }

	  
	  public class AILThread extends Thread {
		  String filename;
		  
		  public AILThread(String s) {
			  filename = s;
		  }
		  
		  public void run() {
				AIL.runAIL(filename);			  
		  }
	  }
	  
	  public class MotorwayThread extends Thread {
		  MotorwayConfig config;
		  
		  MotorwayThread(MotorwayConfig conf) {
			  config = conf;
		  }
		  
		  Motorway motorway;
		  public void run() {
			  motorway = new Motorway(config.getProperty("car1.control"));
			  motorway.configure(config);
			 
			  motorway.run();
		  }
		  
		  public Motorway getMotorway() {
			  return motorway;
		  }
	  }
}
