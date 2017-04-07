// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis, Michael Fisher, and Koen Hindriks
// 
// This file is part of AIL GOAL.  An AIL Implementation of the GOAL Programming
// Language
//
// AIL GOAL is free software: you can redistribute it and/or modify it under
// the terms of the GNU General Public License as published by the Free Software
// Foundation, either version 3 of the License, or (at your option) any later
// version.
//
// AIL GOAL is distributed in the hope that it will be useful, but WITHOUT
// ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
// FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
// details.
//
// You should have received a copy of the GNU General Public License along with
// this program. If not, see <http://www.gnu.org/licenses/>.
//
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package goal.syntax;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import goal.semantics.operationalrules.ProcessMessages;
import ail.syntax.BroadcastMessage;
import ail.syntax.ListTerm;
import ail.syntax.Predicate;
import ail.syntax.StringTerm;
import ail.syntax.Term;

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
	 * Setter for conversation id.
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
	
	@Override
	public Predicate toTerm() {
		return ProcessMessages.messageToTerm(this);
	}

	public Predicate toReceivedTerm() {
		return ProcessMessages.receivedMessageToTerm(this);
	}
	
	public void addReceivers(ListTerm rs) {
		HashSet<String> new_rs = new HashSet<String>();
		Iterator<Term> rs_list_it = rs.iterator();
		while (rs_list_it.hasNext()) {
			String s = ((Predicate) rs_list_it.next()).getFunctor();
			new_rs.add(s);
		}
		super.setReceivers(new_rs);
	}
	
	
}
