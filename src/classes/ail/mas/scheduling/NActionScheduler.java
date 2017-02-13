// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of the Agent Infrastructure Layer (AIL)
// 
// The AIL is free software; you can redistribute it and/or
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

package ail.mas.scheduling;

import java.util.List;

import ajpf.MCAPLJobber;

/**
 * Like the ActionScheduler but forces the system to pick a new Jobber
 * every N cycles irrespective of whether anything has "changed".  This
 * can be useful in applications where there are streams of incoming information
 * which may not be registering as changed information - e.g., the Environment
 * thread has to execute before the perception change is noted.
 * 
 * Not really a good idea to use this one with model checking since the
 * counters will prevent state matching.
 * @author lad
 *
 */
public class NActionScheduler extends ActionScheduler {
	int counter = 0;
	int max_count;
	
	/**
	 * Constructor.
	 * @param count
	 */
	public NActionScheduler(int count) {
		max_count = count;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLScheduler#getActiveAgents()
	 */
	@Override
	public List<MCAPLJobber> getActiveJobbers() {
		if (counter >= max_count) {
			super.perceptChanged();
			counter = 0;
		} else {
			counter++;
		}
		return super.getActiveJobbers();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLScheduler#getActiveAgents()
	 */
	@Override
	public List<MCAPLJobber> getAvailableJobbers() {
		if (counter >= max_count) {
			super.perceptChanged();
			counter = 0;
		} else {
			counter++;
		}
		return super.getActiveJobbers();
	}


}
