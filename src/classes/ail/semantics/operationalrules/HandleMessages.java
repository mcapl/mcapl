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

import java.util.ArrayList;
import java.util.List;

import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import ail.syntax.Event;
import ail.syntax.Intention;
import ail.syntax.Message;
import ail.syntax.Predicate;
import ail.syntax.annotation.SourceAnnotation;
import ail.tracing.events.CreateIntentionEvent;
import ail.tracing.events.ModificationEvent;

/**
 * A Rule that converts the agent's inbox into intentions.
 * 
 * @author lad
 *
 */
public class HandleMessages implements OSRule {
	private static final String name = "Handle Messages";
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#getName()
	 */
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#checkPreconditions(ail.semantics.AILAgent)
	 */
	public boolean checkPreconditions(AILAgent a) {
		return ! a.getInbox().isEmpty();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		List<Message> msgs = a.getInbox();
		List<Intention> is = a.getIntentions();
		for (Message m: msgs) {
			Predicate sender = new Predicate("source");
			sender.addTerm(new Predicate(m.getSender()));
			Intention i = new Intention(new Event(Event.AILAddition, Event.AILReceived, m), new SourceAnnotation(sender), a.getPrettyPrinter());
			is.add(i);
			if (a.shouldTrace()) {
				a.trace(new CreateIntentionEvent(i));
			}
		}
		
		List<Message> inbox = a.getInbox();
		if (!inbox.isEmpty() && a.shouldTrace()) {
			List<Predicate> predicates = new ArrayList<>(inbox.size());
			for (Message msg : inbox) {
				predicates.add(msg.toTerm());
			}
			a.trace(new ModificationEvent(ModificationEvent.INBOX, null, null, predicates));
		}
		a.clearInbox();
	}

}