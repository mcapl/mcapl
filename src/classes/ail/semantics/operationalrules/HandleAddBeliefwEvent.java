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
import ail.syntax.Guard;
import ail.syntax.GBelief;

/**
 * Add a belief to the agent and register a event noting the belief has been added.
 * 
 * @author lad
 *
 */
public class HandleAddBeliefwEvent extends HandleAddBelief {
	private static final String name = "Handle Add Belief with Event";
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#getName()
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.HandleAddBelief#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		boolean alreadybelieved = false;
		if (a.believesyn(new Guard(new GBelief(b)), thetab)) {
			alreadybelieved = true;
		}
		
		super.apply(a);

		// Add a new intention noting the belief change
		if (!alreadybelieved) {
			Intention i = new Intention(new Event(Event.AILAddition, Event.AILBel, b), AILAgent.refertoself(), a.getPrettyPrinter());
			a.getIntentions().add(i);
			if (a.shouldTrace()) {
				a.trace(new CreateIntentionEvent(i));
			}
		}
	}
}