// ----------------------------------------------------------------------------
// Copyright (C) 2014 Louise A. Dennis, and  Michael Fisher 
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
package actiononly.semantics;

import ail.semantics.AILAgent;
import ail.mas.MAS;

/**
 * A class for agents that have a set of actions/capabilities and a goal.
 * @author lad
 *
 */
public class ActionOnlyAgent extends AILAgent {
	/**
	 * Constructor.
	 */
	public ActionOnlyAgent() {
		super();
		setReasoningCycle(new ActionOnlyRC());
	}

	/**
	 * Construct an agent from its name.
	 * @param name
	 */
	public ActionOnlyAgent(String name) {
		super(name);
		setReasoningCycle(new ActionOnlyRC());
	}
	
	/**
	 * Construct an agent from its name and the MAS.
	 * @param mas
	 * @param name
	 */
	public ActionOnlyAgent(MAS mas, String name) {
		super(mas, name);
		setReasoningCycle(new ActionOnlyRC());
	}
	
}
