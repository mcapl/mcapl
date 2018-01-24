// ----------------------------------------------------------------------------
// Copyright (C) 2018 Angelo Ferrando, Davide Ancona,  and Viviana Mascardi
//
// This file is part of the Runtime Verification for MCAPL (RVMCAPL) Library.
// 
// The RVMCAPL Library is free software; you can redistribute it and/or
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
// ----------------------------------------------------------------------------

package monitor;


/**
 *
 * Interface used in order to make monitorable an environment.
 * When an environment implements this interface, inside the DefaultEnvironment all
 * events will be catched and checked on the global specification contained in the Prolog file.
 *
 * @author angeloferrando
 *
 */
public interface Monitorable {

	/**
	*
	* Returns the path to the Prolog file containing the trace expression representing
	* the global specification (the protocol used to do the runtime verification process)
	*
	*/
	public String getTraceExpressionPath();

	/**
	*
	* Returns the name of the logfile which is created during the runtime verification process.
	*
	*/
	public String getLogFilePath();

	/**
	*
	* Returns the name of the protocol used in the current verification (it must be defined in
	* the Prolog file).
	*
	*/
	public String getProtocolName();

	/**
	*
	* Returns the events that are catched by the monitor (it is the list of the functors).
	*
	*/
	//public String[] getEventsToCatch();

	/**
	*
	* Manages what to do when a protocol violation is identified by the monitor.
	*
	*/
	public void manageProtocolViolation();

}
