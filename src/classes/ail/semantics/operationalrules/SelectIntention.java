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

import java.util.ArrayList;

import ail.semantics.AILAgent;
import ail.syntax.Intention;
import ail.tracing.events.SelectIntentionEvent;
import ail.semantics.OSRule;

import gov.nasa.jpf.annotation.FilterField;
/**
 * This rules selects a new current intention for the agent.
 * 
 * @author lad
 *
 */
public class SelectIntention implements OSRule {
	private static final String name = "Select Intention";
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#getName()
	 */
	public String getName() {
		return name;
	}

	/**
	 * The new current intention - may be set by check preconditions in subclasses.
	 */
	@FilterField
	Intention iprime = null;
	/**
	 * The new list of intentions - may be set by check preconditions in subclasses.
	 */
	@FilterField
	ArrayList<Intention> Is = new ArrayList<Intention>();;
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#checkPreconditions(ail.semantics.AILAgent)
	 */
	public boolean checkPreconditions(AILAgent a) {
		return ( ((a.getIntention() == null && ! a.getIntentions().isEmpty()) || (a.getIntention() != null && ! a.getIntention().empty())) && ! a.allintentionssuspended());
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		Intention i = a.getIntention();
  		if (i == null || !i.locked()) {
  			if (Is == null) {
  				ArrayList<Intention> Is2 = a.getIntentions();
  				if ((Is2.isEmpty())) {
  					if (i != null) {
   						Is2.add(i);	
  					}
  				}
  				Is = Is2;
  			}
  			
  			if (iprime == null) {
  				iprime = a.selectIntention(Is);
  			} 

			a.setIntentions(Is);
			a.setIntention(iprime);
			if (a.shouldTrace()) {
				a.trace(new SelectIntentionEvent(iprime));
			}
		} 
  		Is = new ArrayList<Intention>();
  		iprime = null;
	}
}