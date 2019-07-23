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

import ail.tracing.events.SelectPlanEvent;
import ail.tracing.explanations.AbstractReason;
import ail.tracing.explanations.ExplanationLevel;
import ail.tracing.explanations.PredicateDescriptions;

public class SelectPlanReason extends AbstractReason {
	private final SelectPlanEvent event;
	// private GeneratePlansReason parent;
	private GuardReason guard;
	private CreateIntentionReason crei = null;
	private ModifyIntentionReason add = null;

	public SelectPlanReason(final int state, final SelectPlanEvent event) {
		super(state);
		this.event = event;
	}

	@Override
	public SelectPlanEvent getEvent() {
		return this.event;
	}

	public void setParent(final GuardReason parent) {
		this.guard = parent;
	//	this.parent = parent;
	}

	@Override
	public GuardReason getParent() {
		return this.guard;
	}
	
	public void setParent2(CreateIntentionReason c) {
		crei = c;
	}
	
	public void setParent2(ModifyIntentionReason add) {
		this.add = add;
	}

	@Override
	public String getExplanation(final ExplanationLevel level, final PredicateDescriptions descriptions) {
		final StringBuilder string = new StringBuilder();
		if (!this.event.isContinue()) {
			string.append(inCourier(this.event.getPlan()));
		}
		switch(level) {
		/* case FINEST:
			System.err.println("1A");
			string.append(" was selected in state ").append(this.state);
			if (this.guard != null) {
			//	string.append(", because it was included in ").append(this.parent.getExplanation(level, descriptions));
				string.append(this.guard.getExplanation(level, descriptions));
				string.append(" and ");
				if (crei != null) {
					string.append(this.crei.getExplanation(level, descriptions));
				} else {
					string.append(this.add.getExplanation(level, descriptions));
				}
			}
			break; */
		default:
			//System.err.println("1B");
			if (!this.event.isContinue()) {
				string.append(" was selected in state ").append(this.state).append(" ");
			}
			if (this.guard != null) {
				string.append("because ");
				if (!this.guard.getEvent().isContinuation() && !this.guard.getEvent().getGuard().isTrivial()) {
					string.append(this.guard.toString());
					// string.append(" held");
					string.append(" and ");
				}
				if (crei != null) {
					// System.err.println("1B1");
					string.append(this.crei.toString(descriptions));
				} else {
					//System.err.println("1B2");
					string.append(this.add.toString(descriptions)); // + " in state " + this.add.state + " because it was an initial goal.");
				}
			}
		}
		if (this.guard == null) {
			string.append(".");
		}
		return string.toString();
	}
}
