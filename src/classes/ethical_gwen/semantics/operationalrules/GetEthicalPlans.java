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

import ail.semantics.AILAgent;
import ail.semantics.operationalrules.GenerateApplicablePlansEmpty;
import ail.syntax.ApplicablePlan;
import ail.syntax.Intention;
import ail.syntax.Event;
import ail.syntax.Deed;
import ail.syntax.Guard;
import ail.syntax.GBelief;
import ail.syntax.PlanLibrary;
import ail.syntax.ListTerm;

import ethical_gwen.semantics.EthicalGwendolenAgent;
import ethical_gwen.mas.DefaultEthicalEnvironment;

import java.util.ArrayList;

/**
 * What do do if there are no applicable plans - note there is a problem with the goal
 * if this is a goal based intention, otherwise simply drop the intention.  
 * 
 * @author lad
 *
 */
public class GetEthicalPlans extends GenerateApplicablePlansEmpty {
	private static final String name = "Get Ethical Plans";
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#getName()
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.GenerateApplicablePlansEmpty#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		Intention I = a.getIntention();
		
		if (I != null && I.events().size() > 1 && I.hdE().referstoGoal() && I.hdE().isAddition()) {
			ArrayList<ApplicablePlan> Plp = new ArrayList<ApplicablePlan>();
			ListTerm policy = ((EthicalGwendolenAgent) a).getCurrentPolicy();
			if (a.getPL(I.hdE().toString()) == null) {
				PlanLibrary pl = ((DefaultEthicalEnvironment) a.getEnv()).invokeEthicalPlanner(I.hdE(), policy);
				if (pl.size() != 0) {
					a.setPlanLibrary(pl, I.hdE().toString());
					// OOh! This is a bad bad thing to do.  But I'm doing it to control the reasoning cycle.
					a.setApplicablePlans(null);
				} else {
					a.setApplicablePlans(Plp.iterator());
				}
			} else {
				a.setApplicablePlans(Plp.iterator());
			}
		} else {
			super.apply(a);
		}
	}
		
}