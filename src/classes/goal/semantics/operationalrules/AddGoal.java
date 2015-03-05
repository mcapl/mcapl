// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
// 
// This file is part of GOAL (AIL version) - GOAL-AIL
//
// GOAL-AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// GOAL-AIL is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with GOAL-AIL if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package goal.semantics.operationalrules;

import java.util.ArrayList;
import java.util.Iterator;

import ail.semantics.AILAgent;
import ail.syntax.Unifier;
import ail.semantics.operationalrules.HandleAddGoal;
import ail.syntax.GBelief;
import ail.syntax.Goal;
import ail.syntax.Event;
import ail.syntax.Guard;
import ail.syntax.Intention;

import goal.semantics.GOALAgent;

import gov.nasa.jpf.annotation.FilterField;
//import gov.nasa.jpf.jvm.abstraction.filter.FilterField;

/**
 * Rule for handling the addition of achieve goals.  Starts a new
 * intention if they are not believed, does nothing if they are.
 * 
 * @author lad
 *
 */
public class AddGoal extends HandleAddGoal {
	@FilterField
	private static final String name = "Handle Add Goal";
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#getName()
	 */
	public String getName() {
		return name;
	}

	public boolean checkPreconditions(AILAgent a) {
		return(super.checkPreconditions(a) && (gt == Goal.achieveGoal));
	}
	
	public void apply(AILAgent a) {
		// Some working to check if goal is believed even if it is a 
		// conjunction.
/*	   	ArrayList<Goal> gls1 = ((GOALAgent) a).splitgoals(topdeed.getGoal());
    	Guard gu = new Guard();
    	for (Goal g1: gls1) {
    		gu.add(new GBelief(GBelief.AILBel, g1.getLiteral()));
    	}
    	
    	if (gls1.isEmpty()) {
    		gu.add(new GBelief(GBelief.GTrue));
    	}
    		
    	Iterator<Unifier> ui2 = a.believes(gu, new Unifier());
    	
		
		i.tlI(a);
		thetahd.compose(thetab);
		if (ui2.hasNext()) {
			Unifier thetag = ui2.next();
			thetahd.compose(thetag);
		} else {	
			i.compose(thetahd);
			GOALAgent ga = (GOALAgent) a;
			Iterator<Goal> gls = ga.getUnSplitGoals();
			boolean flag = true;
			while (gls.hasNext()) {
				if (gls.next().equals(g)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				Intention newi = new Intention(new Event(Event.AILAddition, g), thetahd, AILAgent.refertoself());
				a.getIntentions().add(newi);
			}
		}
		
		// If re-implementing this method to run through MJI then an AgentStateChange
		// object will need to be created and its intention set to i before it is returned.
		// return (new AgentStateChange(a.getAgName())); */
	
	}
}