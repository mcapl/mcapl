// ----------------------------------------------------------------------------
// Copyright (C) 2014 Louise A. Dennis, and Michael Fisher 
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
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package actiononly.mas;

import ail.mas.AILEnv;

import ail.syntax.Action;
import ail.syntax.Capability;

import java.util.Iterator;

/**
 * An interface that includes an explicit method for selecting an action from a list of capabilities.
 * @author lad
 *
 */
public interface ActionOnlyEnv extends AILEnv {
	/**
	 * Select an action from an iterator over capabilities.
	 * @param ic
	 * @return
	 */
	public Action selectAction(Iterator<Capability> ic, String agName);
}
