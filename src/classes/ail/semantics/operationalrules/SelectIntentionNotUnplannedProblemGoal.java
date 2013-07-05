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

import ail.syntax.Intention;
import ail.semantics.AILAgent;


/**
 * Select an intention and check it isn't an unplanned problem/drop goal event.
 * 
 * @author lad
 *
 */
public class SelectIntentionNotUnplannedProblemGoal extends SelectIntention {
	private static final String name = "Select Intention not Unplanned Problem Goal";
		
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#getName()
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.SelectIntention#checkPreconditions(ail.semantics.AILAgent)
	 */
	public boolean checkPreconditions(AILAgent a) {

		if (super.checkPreconditions(a)) {
			ArrayList<Intention> is = new ArrayList<Intention>();
			for (Intention ip: a.getIntentions()) {
				is.add(ip);
			}
			Intention i = a.getIntention();
		    if (i == null) {
		    	iprime = a.selectIntention(is);
		    } else  if (!i.locked() && !i.empty()) {
		    	if (!i.suspended()) {
		    		is.add(i);
		    	}
		    	
		    	iprime = a.selectIntention(is);
		    	if (i.suspended()) {
		    		is.add(i);
		    	}
		    } else {
		    	iprime = i;
		    }
			
			Is = is;
			
			if (! iprime.empty()) {
				if (! (iprime.hdE().referstoGoal() && iprime.hdE().isDeletion() && (iprime.noplan()))) {
					return true;
				}
			} 
		}
		return false;
	}
}