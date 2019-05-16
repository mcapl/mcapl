// ----------------------------------------------------------------------------
// Copyright (C) 2018 Louise A. Dennis, Michael Fisher, and Vincent Koeman
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
// License along with the AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------
package ail.tracing.events;

import java.util.ArrayList;
import java.util.List;

import ail.semantics.AILAgent;
import ail.syntax.Intention;
import ail.tracing.explanations.PredicateDescriptions;

/**
 * An {@link Intention} has been selected.
 */
public class SelectIntentionEvent extends AbstractEvent {
	private final Intention intention;

	public SelectIntentionEvent(final Intention intention) {
		this.intention = intention.clone();
	}

	public Intention getIntention() {
		return this.intention;
	}

	@Override
	public List<String> getLookupData() {
		final List<String> data = new ArrayList<>(1);
		data.add("intention " + intention.getID());
		return data;
	}

	@Override
	public void execute(final AILAgent agent, final boolean reverse) {
	}

	@Override
	public String toString(final PredicateDescriptions descriptions) {
		final StringBuilder builder = new StringBuilder();
		builder.append("selected ").append(intention).append(".");
		return builder.toString();
	}
}