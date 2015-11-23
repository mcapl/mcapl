// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis,  and Michael Fisher
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
// License along with Gwendolen; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package gwendolen.uavs.prism;

import ail.mas.vehicle.UnreliableSensor;
import ail.syntax.Predicate;
import ajpf.MCAPLcontroller;

import java.util.ArrayList;

/**
 * A Simple Radar Sensor which is correct 90% of the time.
 * @author lad
 *
 */
public class SimpleRadar extends UnreliableSensor {
	public SimpleRadar(MCAPLcontroller control) {
		super("Radar", control);
		ArrayList<Predicate> ls = new ArrayList<Predicate>();
		ls.add(new Predicate("collision"));
		detectOccurs(new Predicate("collision"), ls, 0.9);
	}
}
