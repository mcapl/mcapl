/// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
// 
// This file is part of GOAL (AIL version) - GOAL-AIL
//
// GOAL-AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// GOAL-AIL is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with GOAL-AIL if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package goal.semantics.operationalrules;

import ail.semantics.AILAgent;
import ail.semantics.operationalrules.HandleAction;
import ail.syntax.Action;
import ail.syntax.BroadcastSendAction;

import goal.syntax.GoalMessage;
import gov.nasa.jpf.annotation.FilterField;
//import gov.nasa.jpf.jvm.abstraction.filter.FilterField;
import gov.nasa.jpf.jvm.Verify;

/**
 * Handle a send action.  Calls immediately executeAction in the environment but also
 * adds the action to the agent's list.
 * 
 * @author lad
 *
 */
public class HandleGoalSend extends HandleAction {
	@FilterField
	private static final String name = "Handle Send Action";
		
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#getName()
	 */
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.HandleActionwProblem#checkPreconditions(ail.semantics.AILAgent)
	 */
	public boolean checkPreconditions(AILAgent a) {
		return (super.checkPreconditions(a) && (((Action) topdeed.getTerm()).getActionType()) == Action.sendAction);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.HandleAction#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		Verify.beginAtomic();
		BroadcastSendAction send = (BroadcastSendAction) topdeed.getTerm();
		send.apply(thetahd);
		GoalMessage msg = new GoalMessage(send.getMessage(a.getAgName()));
		send.setMessage(msg);
		Verify.endAtomic();
		super.apply(a);
	}
}