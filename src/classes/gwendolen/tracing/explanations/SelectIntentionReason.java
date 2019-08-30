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

import java.util.LinkedList;
import java.util.List;

import ail.tracing.events.ModifyIntentionEvent;
import ail.tracing.events.SelectIntentionEvent;
import ail.tracing.explanations.AbstractReason;
import ail.tracing.explanations.ExplanationLevel;
import ail.tracing.explanations.PredicateDescriptions;

public class SelectIntentionReason extends AbstractReason {
	private final SelectIntentionEvent event;
	private final List<ModifyIntentionEvent> modifications;
	private CreateIntentionReason parent;

	public SelectIntentionReason(final int state, final SelectIntentionEvent event) {
		super(state);
		this.event = event;
		this.modifications = new LinkedList<>();
	}

	public void addModification(final ModifyIntentionEvent mie) {
		this.modifications.add(mie);
	}

	@Override
	public SelectIntentionEvent getEvent() {
		return this.event;
	}

	public void setParent(final CreateIntentionReason parent) {
		this.parent = parent;
	}

	@Override
	public CreateIntentionReason getParent() {
		return this.parent;
	}

	@Override
	public String getExplanation(final ExplanationLevel level, final PredicateDescriptions descriptions) {
		final StringBuilder string = new StringBuilder();
		switch (level) {
		case FINEST:
			string.append(inCourier(this.event.getIntention())).append(" was selected in state ").append(this.state);
			// string.append(" ").append(modifications); TODO
			if (this.parent != null) {
				string.append(", because ").append(this.parent.getExplanation(level, descriptions));
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
