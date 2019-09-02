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

import ail.syntax.Event;
import ail.tracing.events.ModifyIntentionEvent;
import ail.tracing.events.SelectPlanEvent;
import ail.tracing.explanations.AbstractReason;
import ail.tracing.explanations.ExplanationLevel;
import ail.tracing.explanations.PredicateDescriptions;

public class ModifyIntentionReason extends AbstractReason {
	private final ModifyIntentionEvent event;
	AbstractReason parent;

	public ModifyIntentionReason(final int state, final ModifyIntentionEvent event) {
		super(state);
		this.event = event;
	}

	@Override
	public ModifyIntentionEvent getEvent() {
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
		final Event i_event = this.event.getIntention().hdE();
		switch (level) {
		/* case FINEST:
			// string.append("it was created in state ").append(this.state);
			if (i_event != null) {
				string.append(" the event ").append(inCourier(i_event.toString(descriptions)));
				string.append(" was posted ");
				// string.append(" was posted because it appeared next in intention ").append(this.event.getIntention().getID());
			}
			break; */
		default:
			if (i_event != null) {
				// string.append("Event: ");
				string.append(i_event.toString(descriptions));
				string.append(" was posted in state ").append(state).append(" because ");
				if (this.getParent() instanceof CreateIntentionReason) {
					string.append(((CreateIntentionReason) this.getParent()).getExplanation(level, descriptions));
				} else if (this.getParent() instanceof SelectPlanReason) {
					SelectPlanReason spr = (SelectPlanReason) this.getParent();
					SelectPlanEvent spe = spr.getEvent();
					if (spe.isContinue()) {
						string.append(((SelectPlanReason) this.getParent()).getExplanation(level, descriptions));
					} else {
						string.append(inCourier(spe.getPlan())).append(" was selected in state ").append(spr.state);
					}
				} else {
					string.append("it appeared next in intention ").append(this.event.getIntention().getID());
				}
			}
			break;
		}
		string.append("");
		return string.toString();
	}
}
