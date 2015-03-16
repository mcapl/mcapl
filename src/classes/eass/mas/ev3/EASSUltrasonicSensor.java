// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis and Michael Fisher
// 
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
// 
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.liverpool.ac.uk/~lad
// http://www.csc.liv.ac.uk/~michael/
//
//----------------------------------------------------------------------------

package eass.mas.ev3;

import ail.syntax.Literal;
import ail.syntax.NumberTermImpl;

import java.io.PrintStream;
import java.rmi.RemoteException;

import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.remote.ev3.RMIRemoteSampleProvider;
import lejos.remote.ev3.RemoteEV3;
import lejos.robotics.SampleProvider;

/**
 * Encapsulation of an Ultrasonic Sensor to be used with an EASS environment.
 * @author louiseadennis
 *
 */
public class EASSUltrasonicSensor implements EASSSensor {
	PrintStream out = System.out;
	EV3UltrasonicSensor sensor;
	SampleProvider distances;
	
	public EASSUltrasonicSensor(RemoteEV3 brick, String portName) throws RemoteException {
		sensor = new EV3UltrasonicSensor(brick.getPort(portName));
		distances = sensor.getDistanceMode();
	}
	
	/*
	 * (non-Javadoc)
	 * @see eass.mas.nxt.EASSSensor#addPercept(eass.mas.nxt.EASSNXTEnvironment)
	 */
	public void addPercept(EASSEV3Environment env) {
		float[] sample = new float[1];
		distances.fetchSample(sample, 0);
		float distancevalue = sample[0];
		out.println("distance is " + distancevalue);
		Literal distance = new Literal("distance");
		distance.addTerm(new NumberTermImpl(distancevalue));
		env.addUniquePercept("distance", distance);
	}
	
	/*
	 * (non-Javadoc)
	 * @see eass.mas.nxt.EASSSensor#setPrintStream(java.io.PrintStream)
	 */
	public void setPrintStream(PrintStream s) {
		out = s;
	}
}