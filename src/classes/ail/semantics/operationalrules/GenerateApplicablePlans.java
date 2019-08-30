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

import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;

import ail.semantics.AILAgent;
import ail.semantics.OSRule;
//import gov.nasa.jpf.jvm.abstraction.filter.FilterField;
import ail.syntax.ApplicablePlan;
import ail.tracing.events.GeneratePlansEvent;
import gov.nasa.jpf.annotation.FilterField;

/**
 * Generate all applicable plans for an agent.
 * 
 * @author lad
 *
 */
public class GenerateApplicablePlans implements OSRule {
	@FilterField
	private static final String name = "Generate Applicable Plans";
	
	// This might be instantiated in some subclasses.
	protected Iterator<ApplicablePlan> iterator;
	
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
		return true;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		if (iterator == null) {
			iterator = a.filterPlans(a.appPlans(a.getIntention()));
		}
		List<ApplicablePlan> plans = null;
		if (a.shouldTrace()) { // this is bad, but don't see how to do it otherwise
			plans = Lists.newArrayList(iterator);
			iterator = plans.iterator();
		}
		a.setApplicablePlans(iterator);
		if (a.shouldTrace()  && !a.getIntention().empty()) {
			a.trace(new GeneratePlansEvent(plans, GeneratePlansEvent.FOR_EVENT, a.getIntention().getID(), a.getIntention().hdE()));
		}
	}
}