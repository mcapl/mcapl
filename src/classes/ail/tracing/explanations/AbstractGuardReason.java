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
 * Largely superfluous class since it duplicates AbstractReason but establishes the
 * principle that BDI languages should be able to explain their mental states.
 * @author louisedennis
 *
 */
public abstract class AbstractGuardReason extends AbstractReason {

	protected AbstractGuardReason(int state) {
		super(state);
	}

	@Override
	public abstract AbstractEvent getEvent(); 

	@Override
	public abstract AbstractReason getParent(); 

	@Override
	public abstract String getExplanation(ExplanationLevel level, PredicateDescriptions descriptions);

}
