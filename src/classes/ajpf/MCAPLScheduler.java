// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of Agent JPF (AJPF)
// 
// AJPF is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// AJPF is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with AJPF; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ajpf;
import java.util.List;

/**
 * Interface to be implemented by schedulers in a multi-agent system.
 * 
 * @author louiseadennis
 *
 */
public interface MCAPLScheduler extends PerceptListener {
	/**
	 * Get the currently active jobbers.
	 * @return
	 */
	public List<MCAPLJobber> getActiveJobbers();
	
	/**
	 * Get the currently available jobbers.  These are jobbers that are both active and that the scheduler is making available for scheduling choices.
	 * @return
	 */
	public List<MCAPLJobber> getAvailableJobbers();

	/**
	 * Note that this jobber is inactive.
	 * @param a
	 */
	public void notActive(String a);
	
	/**
	 * Note that this jobber is active.
	 * @param a
	 */
	public void isActive(String a);
	
	/**
	 * Add a jobber to the scheduler.
	 * @param a
	 */
	public void addJobber(MCAPLJobber a);
	
	/**
	 * Get the names of the currently active jobbers.
	 * @return
	 */
	public List<String> getActiveJobberNames();
	
	/**
	 * Remove a jobber from the scheduler;
	 * @param a
	 */
	public void removeJobber(String jobberName);
	
	/**
	 * Remove an agent from scheduling irrespective of its sleeping or waking status.
	 * @param a
	 */
	public void doNotSchedule(String a);
	
	/**
	 * Return an agent to scheduling.
	 * @param a
	 */
	public void resumeScheduling(String a);
}
