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

package eass.mas.nxt;

import ail.syntax.Literal;
import ail.syntax.NumberTermImpl;

import java.io.PrintStream;

/**
 * Encapsulation of an Ultrasonic Sensor to be used with an EASS environment.
 * @author louiseadennis
 *
 */
public class EASSUltrasonicSensor extends UltrasonicSensor implements EASSSensor {
	PrintStream out = System.out;
	
	public EASSUltrasonicSensor(NXTBrick brick, int i) {
		super(brick.getSensorPort(i), brick.getNXTCommand());
	}
	
	/*
	 * (non-Javadoc)
	 * @see eass.mas.nxt.EASSSensor#addPercept(eass.mas.nxt.EASSNXTEnvironment)
	 */
	public void addPercept(EASSNXTEnvironment env) {
		ping();
		int distancevalue = getDistance();
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