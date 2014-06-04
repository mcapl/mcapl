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

import ajpf.util.VerifyMap;

import ail.mas.DefaultEnvironment;
import ail.syntax.Predicate;
import ail.syntax.Message;

/**
 * An environment which contains a number of agent controlled vehicles.  I'm not sure if this really wants to extend Default Environment, 
 * but we will leave as is for now.
 * @author louiseadennis
 *
 */
public class VehicleEnvironment extends DefaultEnvironment implements VehicleEnv {
	/**
	 * The vehicles in the environment, indexed by their names.
	 */
	VerifyMap<String, VehicleInterface> vehicles = new VerifyMap<String, VehicleInterface>();
	
	/**
	 * Add a vehicle to the environment.
	 * @param v
	 */
	public void addVehicle(VehicleInterface v) {
		v.setEnv(this);
		vehicles.put(v.getName(), v);
	}
	
	public VehicleInterface getVehicle(String name) {
		return vehicles.get(name);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#addMessage(java.lang.String, ail.syntax.Message)
	 */
	public void addMessage(String agName, Message msg) {
		if (msg != null && agName != null) {
			VehicleInterface v = vehicles.get(agName);
			v.addMessage(agName, msg);
		}
		notifyListeners(agName);
	}

	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#addPercept(ail.syntax.Literal)
	 */
	public void addPercept(Predicate per) {
		if (per != null) {
			for (VehicleInterface v: vehicles.values()) {
				v.addPercept(per);
			}
		}
		super.addPercept(per);
			
		notifyListeners();
	}

	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#addPercept(java.lang.String, ail.syntax.Literal)
	 */
	public void addPercept(String agName, Predicate per) {
		if (per != null && agName != null) {
			VehicleInterface v = vehicles.get(agName);
			v.addPercept(per);
		}
		super.addPercept(agName, per);
			
		notifyListeners(agName);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#removePercept(java.lang.String, ail.syntax.Literal)
	 */
	public boolean removePercept(String agName, Predicate per) {
		if (per != null && agName != null) {
			VehicleInterface v = vehicles.get(agName);
			v.removePercept(per);
				// calcHashCode();
		}
		
		notifyListeners(agName);
		return false;
	
	}

	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#clearPercepts(java.lang.String)
	 */
	public void clearPercepts(String agName) {
		VehicleInterface v = vehicles.get(agName);
		v.clearPercepts();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#removePercept(ail.syntax.Literal)
	 */
	public boolean removePercept(Predicate per) {
		for (VehicleInterface v: vehicles.values()) {
			v.removePercept(per);
		}
		super.removePercept(per);
		notifyListeners();
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#clearPercepts()
	 */
	public void clearPercepts() {
		for (VehicleInterface v: vehicles.values()) {
			v.clearPercepts();
		}
		notifyListeners();
	}
	
	public boolean contains(String vname) {
		return vehicles.containsKey(vname);
	}
	
	

}
