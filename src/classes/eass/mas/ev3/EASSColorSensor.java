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
import lejos.remote.ev3.RemoteRequestEV3;
import lejos.remote.ev3.RemoteRequestSampleProvider;
import lejos.robotics.SampleProvider;

/**
 * Encapsulation of an Ultrasonic Sensor to be used with an EASS environment.
 * @author louiseadennis
 *
 */
public class EASSColorSensor implements EASSSensor {
	PrintStream out = System.out;
	RemoteRequestSampleProvider sensor;
//	SampleProvider distances;
	
	public EASSColorSensor(RemoteRequestEV3 brick, String portName) throws RemoteException {
		try {
			sensor = (RemoteRequestSampleProvider) brick.createSampleProvider(portName, "lejos.hardware.sensor.EV3ColorSensor", "RGB");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
//		distances = sensor.getDistanceMode();
	}
	
	/*
	 * (non-Javadoc)
	 * @see eass.mas.nxt.EASSSensor#addPercept(eass.mas.nxt.EASSNXTEnvironment)
	 */
	public void addPercept(EASSEV3Environment env) {
		try {
			float[] sample = new float[1];
			sensor.fetchSample(sample, 0);
			float colorvalue = sample[0];
			System.out.println("light level is " + colorvalue);
			out.println("light level is " + colorvalue);
			Literal color = new Literal("light");
			color.addTerm(new NumberTermImpl(colorvalue));
			env.addUniquePercept("light", color);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see eass.mas.nxt.EASSSensor#setPrintStream(java.io.PrintStream)
	 */
	public void setPrintStream(PrintStream s) {
		out = s;
	}
	
	public void close() {
		try {
			sensor.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}