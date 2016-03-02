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

package eass.mas.ev3;

import java.util.ArrayList;

import lejos.remote.ev3.RemoteRequestEV3;
import lejos.remote.ev3.RemoteRequestPilot;

/**
 * A class that encapsulates a basic Lego EV3 Robot that is running leJOS on the
 * hardware and is operating within a multi-agent system.  
 * 
 * The EV3 is run remotely from the computer where this class is executed. 
 * @author louiseadennis
 *
 */
public class BasicRobot implements LegoRobot {
	RemoteRequestEV3 brick;
	RemoteRequestPilot pilot;
	boolean haspilot = false;
	protected boolean disconnected = false;
	
	EASSSensor sensor1;
	EASSSensor sensor2;
	EASSSensor sensor3;
	EASSSensor sensor4;
	
	/**
	 * Construct the robot from a name and the Bluetooth address.
	 * @param name
	 * @param address
	 */
	public BasicRobot(String address) throws Exception {
		brick = new RemoteRequestEV3(address);
	}
	
	/*
	 * (non-Javadoc)
	 * @see eass.mas.ev3.LegoRobot#setSensor(int, eass.mas.ev3.EASSSensor)
	 */
	@Override
	public void setSensor(int portnumber, EASSSensor sensor) {
		if (portnumber == 1) {
			sensor1 = sensor;
		}
		if (portnumber == 2) {
			sensor2 = sensor;
		}
		if (portnumber == 3) {
			sensor3 = sensor;
		}
		if (portnumber == 4) {
			sensor4 = sensor;
		}

	}
	
	/**
	 * Get the sensor for port portnumber.
	 * @param portnumber
	 * @return
	 */
	public EASSSensor getSensor(int portnumber) {
		if (portnumber == 1) {
			return sensor1;
		}
		if (portnumber == 2) {
			return sensor2;
		}
		if (portnumber == 3) {
			return sensor3;
		}
		if (portnumber == 4) {
			return sensor4;
		}		
		
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see eass.mas.ev3.LegoRobot#getSensors()
	 */
	@Override
	public ArrayList<EASSSensor> getSensors() {
		ArrayList<EASSSensor> sensors = new ArrayList<EASSSensor>();
		
		if (sensor1 != null) {
			sensors.add(sensor1);
		} 
		if (sensor2 != null) {
			sensors.add(sensor2);
		} 
		if (sensor3 != null) {
			sensors.add(sensor3);
		} 
		if (sensor4 != null) {
			sensors.add(sensor4);
		} 
		return sensors;
	}
	
	/*
	 * (non-Javadoc)
	 * @see eass.mas.ev3.LegoRobot#addPercepts(eass.mas.ev3.EASSEV3Environment)
	 */
	@Override
	public void addPercepts(EASSEV3Environment env) {
		if (! disconnected ) {
			for (EASSSensor sensor: getSensors()) {
				sensor.addPercept(env);
			}
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see eass.mas.ev3.LegoRobot#getBrick()
	 */
	@Override
	public RemoteRequestEV3 getBrick() {
		return brick;
	}

	/*
	 * (non-Javadoc)
	 * @see eass.mas.ev3.LegoRobot#close()
	 */
	@Override
	public void close() {
		disconnected = true;
		if (sensor1 != null) {
			System.err.println("   Closing Sensor 1");
			sensor1.close();
		}
		
		if (sensor2 != null) {
			System.err.println("   Closing Sensor 2");
			sensor2.close();
		}
		
		if (sensor3 != null) {
			System.err.println("   Closing Sensor 3");
			sensor3.close();
		}
		
		if (sensor4 != null) {
			System.err.println("   Closing Sensor 4");
			sensor4.close();
		}
		
		try {
			wait(500);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		System.err.println("   Disconnecting Brick");
		brick.disConnect();
	}
		

}