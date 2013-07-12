// ----------------------------------------------------------------------------
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


package goal.syntax;

import ail.syntax.BroadcastMessage;
import ail.syntax.StringTerm;

/**
 * Broadcast Message class. For Messages to go to multiple recipients  Environments may
 * need to serialize these messages for transmission.  Specialised for use with GOAL.
 * 
 * @author louiseadennis
 *
 */
public class GoalMessage extends BroadcastMessage {

	public GoalMessage(BroadcastMessage m) {
		super(m.getIlForce(), m.getSender(), m.getReceivers(), m.getPropCont(), m.getMsgId(), m.getThreadId());
	}

	/**
	 * Goal messages are part of conversations.  We use the thread ID for this.
	 * @return
	 */
	public StringTerm getConversationID() {
		return getThreadId();
	}
	
	/**
	 * Setter for conversatoin id.
	 * @param id
	 */
	public void setConversationID(StringTerm id) {
		setThreadId(id);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		if (o instanceof GoalMessage) {
			GoalMessage gm = (GoalMessage) o;
			if (getConversationID().equals(gm.getConversationID())) {
				if (getSender().equals(gm.getSender())) {
					if (getIlForce() == gm.getIlForce()) {
						if (getReceivers().equals(gm.getReceivers())) {
							if (getPropCont().equals(gm.getPropCont())) {
								return true;
							}
						}
					}
				}
			}
		} 
		
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.BroadcastMessage#clone()
	 */
	public GoalMessage clone() {
		return new GoalMessage(super.clone());
	}

}
