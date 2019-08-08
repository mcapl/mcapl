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
import ail.tracing.events.AbstractEvent;
import ail.tracing.explanations.AbstractReason;
import ail.tracing.explanations.ExplanationLevel;
import ail.tracing.explanations.PredicateDescriptions;

public class BeliefReason extends AbstractReason {
	AbstractReason parent;
	Predicate belief;
	int index;
	
	public BeliefReason(Predicate b, int state) {
		super(state);
		belief = b;
	}

	@Override
	public AbstractEvent getEvent() {
		return null;
	}

	@Override
	public AbstractReason getParent() {
		return parent;
	}
	
	public void setParent(AbstractReason r) {
		parent = r;
	}

	@Override
	public String getExplanation(ExplanationLevel level, PredicateDescriptions descriptions) {
		final StringBuilder string = new StringBuilder();
		string.append(belief.toString(descriptions)).append(" was believed in state ").append(state).append(" because ");
		string.append(getParent().getExplanation(level, descriptions));
		return string.toString();
	}

}
