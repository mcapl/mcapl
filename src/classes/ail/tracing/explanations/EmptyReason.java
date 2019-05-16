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
package ail.tracing.explanations;

import ail.tracing.events.AbstractEvent;

/**
 * A kind of default class for reasons that have not been implemented for whatever reason.
 * @author louisedennis
 *
 */
public class EmptyReason extends AbstractReason {
	
	public EmptyReason(int state) {
		super(state);
	}

	@Override
	public AbstractEvent getEvent() {
		return null;
	}

	@Override
	public AbstractReason getParent() {
		return null;
	}

	@Override
	public String getExplanation(ExplanationLevel level, PredicateDescriptions descriptions) {
		return "No Explanations for this Language";
	}

}
