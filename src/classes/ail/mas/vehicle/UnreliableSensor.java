// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of the Agent Infrastructure Layer (AIL)
// 
// This AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The AIL is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ail.mas.vehicle;

import java.util.List;
import java.util.ArrayList;

import ajpf.MCAPLcontroller;
import ajpf.util.VerifyMap;
import ajpf.util.VerifyList;
import ajpf.util.choice.Choice;
import ail.syntax.Predicate;

/**
 * Basic class for unreliable sensors.  Intended for subclassing.  An unreliable sensor takes incoming information and, one a probabilistic
 * basis converts this to a set of sensor data which may be passed on to an agent.
 * @author louiseadennis
 *
 */
public class UnreliableSensor extends Choice<Predicate> implements Sensor {
	/**
	 * The sensor has a name.  Used for a simple, if inefficient, implementation of Comparable.
	 */
	String name;
	
	/**
	 * The list of current data provided by the sensor to an agent.
	 */
	VerifyList<Predicate> percepts = new VerifyList<Predicate>();
	
	/**
	 * A map from an incoming detectable to a set of percepts.  The use of the Choice object means there is only a certain probability
	 * that the set of percepts will actually be added to the sensor's data.
	 */
	VerifyMap<Predicate, Choice<ArrayList<Predicate>>> choices = new VerifyMap<Predicate, Choice<ArrayList<Predicate>>>();
		
	/**
	 * Constructor.  Sets the name of the sensor.
	 * @param s
	 */
	public UnreliableSensor(String s, MCAPLcontroller control) {
		super(control);
		name = s;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Sensor s) {
		if (s instanceof UnreliableSensor) {
			UnreliableSensor us = (UnreliableSensor) s;
			return getName().compareTo(us.getName());
		}
		return -1;
	}
	
	/**
	 * Getter for the name of the sensor.
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns current sensor data on request.
	 */
	public List<Predicate> getPercepts() {
		return percepts;
	}
	
	/**
	 * If something becomes detectable look it up to see if it is something this sensor can detect.  If so, add the relevant sensor
	 * data to percepts, assuming that probability means the detectable is actually detected.
	 */
	public void addPercept(Predicate l) {
		if (choices.containsKey(l)) {
			percepts.addAll(choices.get(l).get_choice());
		}
	}
	
	/**
	 * Currently nothing happens if a detectable vanishes.  This needs to be thought about further!!!
	 */
	public void removePercept(Predicate l) {
		percepts.remove(l);
	}
	
	/**
	 * Clear the percepts.
	 */
	public void clearPercepts() {
		percepts.clear();
	}
	
	/**
	 * This is used when setting up a sensor to create an item in the choices map.
	 * @param l this is the  literal for some detectable.
	 * @param ls  these are the literals that should be returned by the sensor if l becomes detectable.
	 * @param p this is the probability that the ls will be returned if l is detected.
	 */
	public void detectOccurs(Predicate l, ArrayList<Predicate> ls, double p) {
		Choice<ArrayList<Predicate>> choice = new Choice<ArrayList<Predicate>>(control);
		choice.addChoice(p, ls);
		choice.addChoice(1 - p, new ArrayList<Predicate>());
		choices.put(l, choice);
	}
}
