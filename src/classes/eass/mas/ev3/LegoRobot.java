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

import lejos.remote.ev3.RemoteRequestEV3;

import java.util.ArrayList;

/**
 * An interface for a Lego EV3 Robot to be used in an EASS environment.
 * @author louiseadennis
 *
 */
public interface LegoRobot {
	/**
	 * Get the brick associated with this robot.
	 * @return
	 */
	public RemoteRequestEV3 getBrick();
		
	/**
	 * Attach a sensor to a port.
	 * @param portnumber
	 * @param sensor
	 */
	public void setSensor(int portnumber, EASSSensor sensor);
	
	/**
	 * Get this robot's sensors.
	 * @return
	 */
	public ArrayList<EASSSensor> getSensors();
	
	/**
	 * Add percepts from an EASS environement.
	 * @param env
	 */
	public void addPercepts(EASSEV3Environment env);
	
	/**
	 * Close sockets and clean up.
	 */
	public void close();
	
}