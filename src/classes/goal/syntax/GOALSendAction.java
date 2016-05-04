// ----------------------------------------------------------------------------
// Copyright (C) 2016 Louise A. Dennis and Michael Fisher
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
package goal.syntax;

import java.util.ArrayList;

import ail.syntax.Action;
import ail.syntax.BroadcastSendAction;
import ail.syntax.ListTerm;
import ail.syntax.ListTermImpl;
import ail.syntax.SendAction;
import ail.syntax.Term;

public class GOALSendAction extends BroadcastSendAction {
	public static final int SEND = 0;
	public static final int SENDONCE = 1;
	
	int type = SEND;
	
	public GOALSendAction(Action a, int ilf, int type) {
		super(a, ilf);
		this.type = type;
	}
	
	public GoalMessage getMessage(String agName) {
		return new GoalMessage(super.getMessage(agName));
	}
	
	/**
	 * getter for the recipeint.
	 * 
	 * @return
	 */
	public Term getReceivers() {
		Term receiver =  getTerm(1);
		ListTerm receivers = new ListTermImpl();
		receivers.cons(receiver);
		return receivers;
	}

	
	@Override
	public GOALSendAction clone() {
		BroadcastSendAction aclone = super.clone();
		return new GOALSendAction(aclone, ilf, type);
	}
	
	/**
	 * Is this SEND or SENDONCE?
	 * @return
	 */
	public int getType() {
		return type;
	}

}
