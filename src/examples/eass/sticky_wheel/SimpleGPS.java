// ----------------------------------------------------------------------------
// Copyright (C) 2015 Louise A. Dennis, and Michael Fisher 
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

package eass.sticky_wheel;

import java.util.ArrayList;
import java.util.List;

import ail.mas.vehicle.Sensor;
import ail.syntax.Predicate;
import ail.syntax.NumberTerm;

import ajpf.util.AJPFLogger;

/**
 * This is a class to mimic a sensor that gives position and orientation information to a robot.  It's called
 * SimpleGPS but its actually an idealised combination of a GPS and a compass.
 * @author louiseadennis
 *
 */
public class SimpleGPS implements Sensor {
	Predicate position;
	
	static final String logname = "eass.sticky_wheel.SimpleGPS";

	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Sensor o) {
		// All SimpleGPS sensors are the same.  Be wary of this behaviour.
		if (o instanceof SimpleGPS) {
			return 0;
		} else {
			return -1;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see ail.mas.vehicle.Sensor#getPercepts()
	 */
	public List<Predicate> getPercepts() {
		ArrayList<Predicate> percepts = new ArrayList<Predicate>();
		// The sensor returns (X, Y) coordinates and Theta (orientation)
		if (position != null) {
			percepts.add(position);
		}
		return percepts;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.mas.vehicle.Sensor#addPercept(ail.syntax.Predicate)
	 */
	public void addPercept(Predicate l) {
		if (l.getFunctor().equals("position")) {
			position = l;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see ail.mas.vehicle.Sensor#removePercept(ail.syntax.Predicate)
	 */
	public void removePercept(Predicate l) {
		AJPFLogger.warning(logname, "SimpleGPS does not remove predicates");
	}

	/*
	 * (non-Javadoc)
	 * @see ail.mas.vehicle.Sensor#clearPercepts()
	 */
	public void clearPercepts() {
		AJPFLogger.warning(logname, "SimpleGPS does not remove predicates");
	}
	
	/**
	 * Return the x coordinate.
	 * @return
	 */
	public double getX() {
		return ((NumberTerm) position.getTerm(0)).solve();
	}
	
	/**
	 * Return the y coordinate.
	 * @return
	 */
	public double getY() {
		return ((NumberTerm) position.getTerm(1)).solve();
	}

	/**
	 * Return theta.
	 * @return
	 */
	public double getTheta() {
		return ((NumberTerm) position.getTerm(2)).solve();
	}


}
