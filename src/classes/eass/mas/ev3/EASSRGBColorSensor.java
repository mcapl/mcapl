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

import ail.syntax.Literal;
import ail.syntax.NumberTermImpl;

import java.io.PrintStream;
import java.rmi.RemoteException;

import lejos.remote.ev3.RemoteRequestEV3;
import lejos.remote.ev3.RemoteRequestSampleProvider;

/**
 * Encapsulation of an RGB Sensor to be used with an EASS EV3 environment.
 * @author louiseadennis
 *
 */
public class EASSRGBColorSensor implements EASSSensor {
	PrintStream blueout;
	PrintStream redout;
	PrintStream greenout;
	RemoteRequestSampleProvider sensor;
	
	public EASSRGBColorSensor(RemoteRequestEV3 brick, String portName) throws RemoteException {
		try {
			sensor = (RemoteRequestSampleProvider) brick.createSampleProvider(portName, "lejos.hardware.sensor.EV3ColorSensor", "RGB");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see eass.mas.ev3.EASSSensor#addPercept(eass.mas.ev3.EASSEV3Environment)
	 */
	@Override
	public void addPercept(EASSEV3Environment env) {
		try {
			float[] sample = new float[3];
			sensor.fetchSample(sample, 0);
			float red = sample[0];
			float green = sample[1];
			float blue = sample[2];
			if (redout != null) {
				redout.println("red light level is " + red);
			}
			Literal r = new Literal("red");
			r.addTerm(new NumberTermImpl(red));
			env.addUniquePercept("red", r);
			if (greenout != null) {
				greenout.println("green light level is " + green);
			}
			Literal g = new Literal("green");
			g.addTerm(new NumberTermImpl(green));
			env.addUniquePercept("green", g);
			if (blueout != null) {
				blueout.println("blue light level is " + blue);
			}
			Literal b = new Literal("blue");
			b.addTerm(new NumberTermImpl(blue));
			env.addUniquePercept("blue", b);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	/**
	 * Set the print stream for the blue light values;
	 * @param s
	 */
	public void setBluePrintStream(PrintStream s) {
		blueout = s;
	}
	
	/**
	 * Set the print stream for the red light values.
	 * @param s
	 */
	public void setRedPrintStream(PrintStream s) {
		redout = s;
	}
	
	/**
	 * Set the print stream for the green light values.
	 * @param s
	 */
	public void setGreenPrintStream(PrintStream s) {
		greenout = s;
	}
	
	/*
	 * (non-Javadoc)
	 * @see eass.mas.ev3.EASSSensor#close()
	 */
	@Override
	public void close() {
		try {
			sensor.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * @see eass.mas.ev3.EASSSensor#setPrintStream(java.io.PrintStream)
	 */
	@Override
	public void setPrintStream(PrintStream o) {
		setBluePrintStream(o);
		setRedPrintStream(o);
		setGreenPrintStream(o);
	}
}