// ----------------------------------------------------------------------------
// Copyright (C) 2013 Louise A. Dennis, Michael Fisher and Matt Webster.
// 
// This file is part of Gwendolen
//
// Gwendolen is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Gwendolen is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with Gwendolen if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package gwendolen.uavs.prism;

import java.util.List;

import ail.mas.vehicle.Sensor;
import ail.syntax.Predicate;
import ajpf.util.VerifyList;

public class navMan implements Sensor {
	/**
	 * The list of current data provided by the sensor to an agent.
	 */
	VerifyList<Predicate> percepts = new VerifyList<Predicate>();

	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Sensor arg0) {
			if (arg0 instanceof navMan) {
				return 1;
			}
			return -1;
		}

	/*
	 * (non-Javadoc)
	 * @see ail.mas.vehicle.Sensor#getPercepts()
	 */
	public List<Predicate> getPercepts() {
		return percepts;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.mas.vehicle.Sensor#addPercept(ail.syntax.Predicate)
	 */
	public void addPercept(Predicate l) {
		String s = l.getFunctor();
		if (s.equals("landing") || s.equals("changeHeading") || s.equals("headingOK")) {
			percepts.clear();
			percepts.add(l);
		}

	}


	/*
	 * (non-Javadoc)
	 * @see ail.mas.vehicle.Sensor#removePercept(ail.syntax.Predicate)
	 */
	public void removePercept(Predicate l) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * @see ail.mas.vehicle.Sensor#clearPercepts()
	 */
	public void clearPercepts() {
		percepts.clear();
	}

}
