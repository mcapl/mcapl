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

package eass.mas.nxt;

import java.util.ArrayList;

import lejos.robotics.navigation.DifferentialPilot;

public class BasicRobot implements LegoRobot {
	NXTBrick brick;
	DifferentialPilot pilot;
	boolean haspilot = false;
	
	EASSSensor sensor1;
	EASSSensor sensor2;
	EASSSensor sensor3;
	EASSSensor sensor4;
	
	public BasicRobot(String name, String address) {
		brick = new NXTBrick(name, address);
	}
	
	public boolean hasPilot() {
		return haspilot;
	}
	public void setPilot(DifferentialPilot npilot) {
		pilot = npilot;
		haspilot = true;
	}
	public DifferentialPilot getPilot() {
		return pilot;
	}

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
	
	public void addPercepts(EASSNXTEnvironment env) {
		for (EASSSensor sensor: getSensors()) {
			sensor.addPercept(env);
		}
	}
	
	public NXTBrick getBrick() {
		return brick;
	}
	
	public boolean isConnected() {
		return getBrick().isConnected();
	}
	
	public void close() {
		brick.close();
	}
}