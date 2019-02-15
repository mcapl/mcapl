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

import java.util.List;
import java.util.Iterator;

import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import ail.syntax.Intention;
import ail.syntax.Unifier;
import ail.tracing.events.SelectIntentionEvent;
import ail.syntax.Deed;
import ail.syntax.Guard;
import ail.syntax.GBelief;

/**
 * If the selected intention asks for a goal to be dropped match it to all the relevant
 * intentions.
 * 
 * @author lad
 *
 */
public class MatchDropGoal implements OSRule {
	private static final String name = "Match Drop Goal";
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#getName()
	 */
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#checkPreconditions(ail.semantics.AILAgent)
	 */
	public boolean checkPreconditions(AILAgent a) {
		Intention I = a.getIntention();
		if (I != null && !I.empty() && I.hdE().referstoGoal() && I.hdE().isDeletion() &&  I.noplan()) {
			return true;
		} else {
			return false;
		}
	}
		
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		List<Intention> Is = a.getIntentions();
		Iterator<Intention> ii = Is.iterator();
	  		    		
		while (ii.hasNext()) {
			Unifier u = new Unifier();
			Intention i1 = ii.next();
			Intention I = a.getIntention();
		
			if (i1.getSource() == I.getSource()) {
				for (int j = 0; j < i1.size(); j++) {
					if (i1.tr(j).referstoGoal() && i1.tr(j).isAddition()) {
						if (u.sunifies(I.hdE(), i1.tr(j))) {
							i1.iCons(I.hdE(), new Deed(Deed.Dnpy), new Guard(new GBelief()), u);
						}								
					}
				}
			}
		}
						
		Intention ipp = a.selectIntention(Is);
		a.setIntention(ipp);
		if (a.shouldTrace()) {
			a.trace(new SelectIntentionEvent(ipp));
		}
	} 
}