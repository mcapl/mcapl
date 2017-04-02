// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis, Michael Fisher and Koen Hindriks
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

import goal.syntax.GOALModule;
import goal.syntax.PrintAction;
import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import ail.syntax.Action;
import ail.syntax.Deed;

public class PrintActionExecutor extends ActionExecutor {
	Action action;

	@Override
	public boolean checkPreconditions(AILAgent a) {
		Deed d = a.getIntention().hdD();
		
		boolean isaction = d.getCategory() == Deed.DAction;
		
		if (isaction) {
			action = (Action) d.getContent();
			action.apply(a.getIntention().hdU());
			return (action instanceof PrintAction);
		} else {
			return false;
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void apply(AILAgent a) {
		super.apply(a);
		System.out.println(action.getTerm(0));
		a.getIntention().tlI(a);
	//	a.setIntention(null);
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Print Action Executor";
	}

}
