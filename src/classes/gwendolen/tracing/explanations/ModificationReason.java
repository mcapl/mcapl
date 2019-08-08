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

import ail.syntax.Predicate;
import ail.tracing.events.ModificationEvent;
import ail.tracing.events.SelectPlanEvent;
import ail.tracing.explanations.AbstractReason;
import ail.tracing.explanations.ExplanationLevel;
import ail.tracing.explanations.PredicateDescriptions;

public class ModificationReason extends AbstractReason {
	private final ModificationEvent event;
	private AbstractReason parent;

	public ModificationReason(final int state, final ModificationEvent event) {
		super(state);
		this.event = event;
	}

	@Override
	public ModificationEvent getEvent() {
		return this.event;
	}

	public void setParent(final AbstractReason parent) {
		this.parent = parent;
	}

	@Override
	public AbstractReason getParent() {
		return this.parent;
	}

	private String getPredicateDescriptor() {
		switch (event.getBase()) {
		case "beliefs":
			return "belief";
		case "goals":
			return "goal(s)";
		case "inbox":
		case "outbox":
			return "message(s)";
		default:
			return "";
		}
	}

	private String getAdded(final PredicateDescriptions descriptions) {
		final StringBuilder s = new StringBuilder();
		boolean first = true;
		for (final Predicate p : event.getAdded()) {
			if (first) {
				first = false;
			} else {
				s.append(", ");
			}
			s.append(p.toString(descriptions));
		}
		return s.toString();
	}

	private String getActionDescriptor() {
		switch (event.getBase()) {
		case "beliefs":
		case "goals":
			return "added";
		case "inbox":
			return "received";
		case "outbox":
			return "sent";
		default:
			return "";
		}
	}

	@Override
	public String getExplanation(final ExplanationLevel level, final PredicateDescriptions descriptions) {
		final StringBuilder string = new StringBuilder();
		string.append("the ").append(getPredicateDescriptor()).append(" ").append(inCourier(getAdded(descriptions)))
				.append(" was ").append(getActionDescriptor());
		switch (level) {
		//case FINEST:
		//	string.append(" in state ").append(this.state);
		//	if (this.parent != null) {
		//		string.append(", because ").append(this.parent.getExplanation(level, descriptions));
		//	}
		//	break;
		default:
			if (this.parent != null) {
				string.append(" because ");
			//	string.append(" because ").append(this.parent.getExplanation(level, descriptions));
			//}
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
				} 
				break;
			}
			if (this.parent == null) {
				string.append(" upon starting the agent.");
			}
		}
		//if (this.parent == null) {
		//	string.append(" upon starting the agent.");
		//}
		return string.toString();
	}
}
