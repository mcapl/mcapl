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

import ail.syntax.Predicate;

/**
 * A basic interface for sensors in environments involving vehicles.
 * @author louiseadennis
 *
 */
public interface Sensor extends Comparable<Sensor> {
	/**
	 * The sensor should be able to return a list of percepts (Structures) to an agent.
	 * @return
	 */
	public List<Predicate> getPercepts();
	
	/**
	 * If something becomes detectable in the external environment the it should be reacted to by the sensor.  Depending upon the sensor this might
	 * reliably record the perception, only occasionally record the perception, convert the perceptible into some other set of values...
	 * @param l
	 */
	public void addPercept(Predicate l);
	
	/**
	 * If something ceases to be detectable in the external environment then the sensor should react.
	 * @param l
	 */
	public void removePercept(Predicate l);
	
	/**
	 * In housekeeping situations it may be desirable to clear all the information from the sensor.
	 */
	public void clearPercepts();
}
