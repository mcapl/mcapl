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
import ail.semantics.OSRule;
import ail.syntax.ApplicablePlan;
import ail.syntax.Intention;
import ail.syntax.Unifier;
import ail.tracing.events.GeneratePlansEvent;
import ail.syntax.Deed;
import ail.syntax.Guard;

/**
 * What do do if there are no applicable plans
 * If the current intention isn't empty, set it as a continuation, otherwise set an 
 * empty plan list.
 * 
 * @author lad
 *
 */
public class GenerateApplicablePlansEmpty implements OSRule {
	private static final String name = "Generate Applicable Plans Empty";
	
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
		if (a.getIntention() == null ) {
			return false;
		}
		return (! a.filterPlans(a.appPlans(a.getIntention())).hasNext());
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		Intention I = a.getIntention();
		ArrayList<ApplicablePlan> Plp = new ArrayList<ApplicablePlan>();
		
		if ((! I.empty()) && I.noplan()) {
			Plp.add(new ApplicablePlan(I.hdE(), new ArrayList<Deed>(), new ArrayList<Guard>(), 1, new Unifier(), 0, AILAgent.AILdefaultPLname, a.getPrettyPrinter()));
		} else {
			if (!I.empty()) {
				Plp.add(new ApplicablePlan(I.hdE(), new ArrayList<Deed>(), new ArrayList<Guard>(), 0, new Unifier(), 0, AILAgent.AILdefaultPLname, a.getPrettyPrinter()));
			} 
		}
		
		a.setApplicablePlans(Plp.iterator());
		if (a.shouldTrace()) {
			a.trace(new GeneratePlansEvent(Plp, GeneratePlansEvent.NO_APPLICABLE_PLANS, a.getIntention().getID()));
		}
	}
		
}