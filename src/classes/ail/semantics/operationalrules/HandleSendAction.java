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

import ail.semantics.AILAgent;
import ail.syntax.Action;
import ail.syntax.Event;
import ail.syntax.Intention;
import ail.syntax.Message;
import ail.syntax.SendAction;
import ail.tracing.events.CreateIntentionEvent;
import ail.tracing.events.ModificationEvent;

/**
 * Handle a send action.  Calls immediately executeAction in the environment but also
 * adds the action to the agent's list.
 * 
 * @author lad
 *
 */
public class HandleSendAction extends HandleActionwProblem {
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
		return (super.checkPreconditions(a) && (((Action) topdeed.getContent()).getActionType()) == SendAction.sendAction);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.HandleActionwProblem#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		SendAction send = (SendAction) topdeed.getContent();
		Message msg = send.getMessage(a.getAgName());
		msg.apply(thetahd);
		
		Message varless_msg = (Message) msg.strip_varterm();
		super.apply(a);
		if (succeeded) {
			Intention i = new Intention(new Event(Event.AILAddition, Event.AILSent, varless_msg), thetahd, AILAgent.refertoself(), a.getPrettyPrinter());
			a.getIntentions().add(i);
			if (a.shouldTrace()) {
				a.trace(new CreateIntentionEvent(i));
			}
			if (a.newSentMessage(varless_msg) && a.shouldTrace()) {
				a.trace(new ModificationEvent(ModificationEvent.OUTBOX, null, msg.toTerm(), null));
			}
		}
	}
}