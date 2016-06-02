// ----------------------------------------------------------------------------
// Copyright (C) 2016 Louise A. Dennis, Michael Fisher, Marija Slavkovik and Matt Webster
// 
// This file is part of Ethical Gwendolen
//
// Ethical Gwendolen is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Ethical Gwendolen is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with Ethical Gwendolen if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package ethical_gwen.semantics.operationalrules;

import java.util.Iterator;

import ail.semantics.AILAgent;
import ail.semantics.operationalrules.HandleAddGoal;
import ail.syntax.Unifier;
import ail.syntax.Deed;
import ail.syntax.Goal;
import ail.syntax.Event;
import ail.syntax.GBelief;
import ail.syntax.Guard;

import ethical_gwen.semantics.EthicalGwendolenAgent;


/**
 * Rule for handling the addition of achieve and test goals.  Adds a new commitment
 * to the intention if they are not believed, does nothing if they are.
 * 
 * @author lad
 *
 */
public class HandleAddAchieveTestGoalEthics extends HandleAddGoal {
	private static final String name = "Handle Add Achieve Test Goal with Ethics";
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#getName()
	 */
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.HandleAddGoal#checkPreconditions(ail.semantics.AILAgent)
	 */
	public boolean checkPreconditions(AILAgent a) {
		return(super.checkPreconditions(a) && (gt == Goal.achieveGoal || gt == Goal.testGoal));
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.HandleTopDeed#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		Iterator<Unifier> ui2 = a.believes(((Goal) topdeed.getContent()).achievedBelief(), new Unifier());
		
		if (ui2.hasNext()) {
			Unifier thetag = ui2.next();
			
			i.tlI(a);
			thetahd.compose(thetab);
			thetahd.compose(thetag);
			i.compose(thetahd);
			((EthicalGwendolenAgent) a).clearPlanLibrary(topdeed.toString());
		} else {
			a.addGoal((Goal) topdeed.getContent());
			i.iCons(new Event(Event.AILAddition, g), new Deed(Deed.Dnpy), new Guard(new GBelief()), thetahd);
		}	
	}
}