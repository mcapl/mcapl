// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
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
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package ail.semantics.operationalrules;

import ail.semantics.AILAgent;
import ail.syntax.Intention;
import ail.tracing.events.CreateIntentionEvent;
import ail.syntax.Event;

/**
 * "Update" an agent's belief.  That is remove the previous value and replace it with a new
 * one.
 * 
 * @author lad
 *
 */
public class HandleUpdateBeliefwEvent extends HandleUpdateBelief {
	private static final String name = "Handle Update Belief with Event";
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#getName()
	 */
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.HandleUpdateBelief#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		super.apply(a);
		
		Intention i = new Intention(new Event(Event.AILAddition, Event.AILBel, b), AILAgent.refertoself(), a.getPrettyPrinter());
		a.getIntentions().add(i);
		if (a.shouldTrace()) {
			a.trace(new CreateIntentionEvent(i));
		}
	}
}