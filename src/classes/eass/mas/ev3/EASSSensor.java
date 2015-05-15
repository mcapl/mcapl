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

import java.io.PrintStream;

/**
 * Interface for a sensor that encapsulates an EV3 robot sensor and which
 * can be used within an EASS environment.
 * @author louiseadennis
 *
 */
public interface EASSSensor {
	/**
	 * Add a percept to this sensor.
	 * @param env
	 */
	public void addPercept(EASSEV3Environment env);
	
	/**
	 * Set the printstream where values from this sensor should be displayed.
	 * @param o
	 */
	public void setPrintStream(PrintStream o);
	
	/**
	 * Close the sensor and perform clean up.
	 */
	public void close();
}