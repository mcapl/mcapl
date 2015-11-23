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

package ail.semantics.operationalrules;

import java.util.LinkedList;

import ail.syntax.Action;
import ail.semantics.AILAgent;

import gov.nasa.jpf.annotation.FilterField;

/**
 * Retricts HandleAction by excluding some specific named actions with difference semantics.
 * 
 * @author lad
 *
 */
public class HandleGeneralAction extends HandleActionwProblem {
	@FilterField
	private String name = "Handle General Action";
	
	@FilterField
	private LinkedList<Integer> excludedActions = new LinkedList<Integer>();
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#getName()
	 */
	public String getName() {
		return name;
	}

	/**
	 * Constructor to create rule with a list of excluded action types.
	 * 
	 * @param sl
	 */
	public HandleGeneralAction(LinkedList<Integer> sl) {
		excludedActions = sl;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.HandleActionwProblem#checkPreconditions(ail.semantics.AILAgent)
	 */
	public boolean checkPreconditions(AILAgent a) {
		return (super.checkPreconditions(a) && (! excludedActions.contains((Integer) ((Action) topdeed.getContent()).getActionType())));
	}
}