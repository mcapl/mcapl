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
package eass.cruise_control.runtime;

import org.junit.Assert;
import org.junit.Test;

import ail.mas.AIL;
import ail.mas.MAS;
import ail.util.AILConfig;
import ajpf.MCAPLcontroller;
import motorwaysim.MotorwayComplex;
import motorwaysim.MotorwayConfig;
import motorwaysim.Car;

public class MonitorSimplePrologTest {
	
	  @Test //----------------------------------------------------------------------
	  public void two_constraints () {
		final MotorwayConfig config = new MotorwayConfig("/src/examples/eass/cruise_control/runtime/remote_motorway_config.txt");
		
		MotorwayThread motorwayThread = new MotorwayThread(config);
		
		AILThread ailThread = new AILThread("/src/examples/eass/cruise_control/runtime/two_constraints.ail");
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

				
		MotorwayComplex motorway = motorwayThread.getMotorway();
		Car car = motorway.getCar(0);
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
	  
	  public class MotorwayThread extends Thread {
		  MotorwayConfig config;
		  
		  MotorwayThread(MotorwayConfig conf) {
			  config = conf;
		  }
		  
		  MotorwayComplex motorway;
		  public void run() {
			  motorway = new MotorwayComplex(config.getProperty("car1.control"));
			 
			  motorway.run();
		  }
		  
		  public MotorwayComplex getMotorway() {
			  return motorway;
		  }
	  }
}
