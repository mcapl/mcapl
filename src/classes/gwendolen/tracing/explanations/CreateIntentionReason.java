// ----------------------------------------------------------------------------
// Copyright (C) 2018 Louise A. Dennis, Michael Fisher, and Vincent Koeman
//
// This file is part of the Gwendolen
// 
// Gwendolen is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Gwendolen is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------
package gwendolen.tracing.explanations;

import ail.syntax.Deed;
import ail.syntax.Event;
import ail.tracing.events.CreateIntentionEvent;
import ail.tracing.explanations.AbstractReason;
import ail.tracing.explanations.ExplanationLevel;
import ail.tracing.explanations.PredicateDescriptions;

public class CreateIntentionReason extends AbstractReason {
	private final CreateIntentionEvent event;
	public AbstractReason parent = null;

	public CreateIntentionReason(final int state, final CreateIntentionEvent event) {
		super(state);
		this.event = event;
	}

	@Override
	public CreateIntentionEvent getEvent() {
		return this.event;
	}

	@Override
	public AbstractReason getParent() {
		return parent;
	}
	
	public void setParent(AbstractReason r) {
		parent = r;
	}

	@Override
	public String getExplanation(final ExplanationLevel level, final PredicateDescriptions descriptions) {
		final StringBuilder string = new StringBuilder();
		final Event event = this.event.getEvent();
		switch (level) {
		//case FINEST:
		//	System.err.println("8A");
		//	if (event != null && event.getCategory() == Event.FromPercept) {
		//		Deed d = this.event.getIntention().deeds().get(0);
		//		string.append(d.toString(descriptions)).append(" was perceived in state ").append(this.state);
		//	} else if (event != null && !event.toString(descriptions).equals("start")) {
		//		string.append(" event ").append(inCourier(event.toString(descriptions)));
		//		string.append(" was posted at the start."); //.append(this.state);
		//	} else if (event != null) {
		//		Deed d = this.event.getIntention().deeds().get(0);
		//		string.append("starting goal ").append(d.toString(descriptions));
		//		string.append(" was posted in state ").append(this.state);
		//	}
		//	break;
		default:
			// System.err.println("8B");
			// string.append(this.event.intentionString(descriptions)).append(" was created in state ").append(state).append(" because ");
			if (event != null) {
				if (event.getCategory() == Event.FromPercept) {
					string.append(this.event.getIntention().hdD().getContent().toString(descriptions)).append(" was perceived in state ").append(this.state);
				} else if (event.getCategory() == Event.Estart && this.event.getIntention().hdD().getCategory() == Deed.AILBel) {
					string.append(this.event.getIntention().hdD().toString(descriptions)).append(" was an initial belief");
				} else if (event.getCategory() == Event.Estart && this.event.getIntention().hdD().getCategory() == Deed.AILGoal) {
					string.append(this.event.getIntention().hdD().toString(descriptions)).append(" was an initial goal.");
				} else if (this.event.getIntention().hdE().getCategory() == Event.AILReceived) {
					string.append(" the message ").append(this.event.getIntention().hdE().getContent().toString()).append(" was received in state ").append(this.state);
				} else {
					string.append(parent.getExplanation(level, descriptions));
				}
			}
			break;
		}
		// string.append(".");
		return string.toString();
	}
}
