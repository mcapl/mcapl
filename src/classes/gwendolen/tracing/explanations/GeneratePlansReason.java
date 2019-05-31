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

import ail.tracing.events.GeneratePlansEvent;
import ail.tracing.explanations.AbstractReason;
import ail.tracing.explanations.ExplanationLevel;
import ail.tracing.explanations.PredicateDescriptions;

public class GeneratePlansReason extends AbstractReason {
	private final GeneratePlansEvent event;
	private GuardReason parent;
	private AbstractReason postevent;

	public GeneratePlansReason(final int state, final GeneratePlansEvent event) {
		super(state);
		this.event = event;
	}

	@Override
	public GeneratePlansEvent getEvent() {
		return this.event;
	}

	public void setParent(final GuardReason parent) {
		this.parent = parent;
	}

	@Override
	public GuardReason getParent() {
		return this.parent;
	}
	
	public void setPostEvent(AbstractReason pe) {
		this.postevent = pe;
	}
	

	@Override
	public String getExplanation(final ExplanationLevel level, final PredicateDescriptions descriptions) {
		final StringBuilder string = new StringBuilder();
		switch (level) {
		case FINEST:
			//string.append("the applicable plans generated in state ").append(this.state).append(" ")
			//		.append(inCourier(this.event.getPlans()));
			if (this.parent != null) {
				string.append(", because ").append(this.parent.getExplanation(level, descriptions));
				string.append(" and ").append(this.postevent.getExplanation(level, descriptions));
			}
			break;
		default:
			if (this.parent != null) {
				string.append(this.parent.getExplanation(level, descriptions));
			}
			break;
		}
		if (this.parent == null) {
			string.append(".");
		}
		return string.toString();
	}
}
