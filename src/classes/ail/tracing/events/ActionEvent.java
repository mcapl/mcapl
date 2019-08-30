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
import ail.syntax.Action;
import ail.tracing.explanations.PredicateDescriptions;

/**
 * An {@link Action} has been executed.
 */
public class ActionEvent extends AbstractEvent {
	private final Action action;
	private final int intentionID;

	public ActionEvent(final Action action, final int IntentionID) {
		this.action = action;
		this.intentionID = IntentionID;
	}

	public Action getAction() {
		return this.action;
	}
	
	public int getIID() {
		return this.intentionID;
	}

	@Override
	public List<String> getLookupData() {
		final List<String> result = new ArrayList<>(1);
		result.add(action.getPredicateIndicator().toString());
		return result;
	}

	@Override
	public void execute(final AILAgent agent, final boolean reverse) {
	}

	@Override
	public String toString(final PredicateDescriptions descriptions) {
		final StringBuilder builder = new StringBuilder();
		builder.append("performed ").append(action.toString(descriptions)).append(".");
		return builder.toString();
	}
}
