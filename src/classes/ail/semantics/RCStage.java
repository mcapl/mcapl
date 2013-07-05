// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
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

package ail.semantics;

import java.util.Iterator;

/**
 * Inteface class for a stage in a reasoning cycle.
 * 
 * @author louiseadennis
 *
 */
public interface RCStage {
	/**
	 * A string representing a unique name for the stage.
	 * 
	 * @return a string representing a unique name for the stage.
	 */
	public String getStageName();
	
	/**
	 * An iterator over the operational semantic rules associated with this
	 * stage.
	 * 
	 * @return An iterator over the operational semantic rules associated with
	 * this stage.
	 */
	public Iterator<OSRule> getStageRules();
	
	/**
	 * Assign a rule to a reasoning stage.
	 * 
	 * @param r The rule to be assigned to the stage.
	 */
	public void setRule(OSRule r);

}
