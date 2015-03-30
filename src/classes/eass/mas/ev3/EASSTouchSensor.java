// ----------------------------------------------------------------------------
// Copyright (C) 2015 Louise A. Dennis and Michael Fisher
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

import ail.syntax.GBelief;
import ail.syntax.Guard;
import ail.syntax.Literal;
import ail.syntax.NumberTermImpl;
import ail.syntax.Predicate;
import ail.syntax.Unifier;

import java.io.PrintStream;
import java.rmi.RemoteException;

import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.remote.ev3.RMIRemoteSampleProvider;
import lejos.remote.ev3.RemoteRequestEV3;
import lejos.remote.ev3.RemoteRequestSampleProvider;
import lejos.robotics.SampleProvider;

/**
 * Encapsulation of an Touch Sensor to be used with an EASS environment.
 * @author louiseadennis
 *
 */
public class EASSTouchSensor implements EASSSensor {
	PrintStream out = System.out;
	RemoteRequestSampleProvider sensor;
	boolean bumped = false;
	String agName;
//	SampleProvider distances;
	
	public EASSTouchSensor(RemoteRequestEV3 brick, String portName, String agName) throws RemoteException {
		sensor = (RemoteRequestSampleProvider) brick.createSampleProvider(portName, "lejos.hardware.sensor.EV3TouchSensor", "Touch");
		this.agName = agName;
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
			float bump = sample[0];
			if (bump > 0) {
				if (!bumped) {
					out.println("bumped");
				}
				env.addPercept(new Literal("bump"));
				bumped = true;
			} else {
				bumped = false;
				if (env.agentmap.get(agName).believesyn(new Guard(new GBelief(new Literal("bump"))), new Unifier())) {
					env.removePercept(new Literal("bump"));
					System.err.println("removing bump");
				}
			}
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