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
import ail.syntax.ApplicablePlan;
import ail.syntax.Intention;
import ail.tracing.events.GeneratePlansEvent;
import ail.syntax.Event;
import ail.syntax.Deed;
import ail.syntax.Guard;
import ail.syntax.GBelief;
import ail.syntax.Goal;

import ajpf.util.AJPFLogger;

import java.util.ArrayList;

/**
 * What do do if there are no applicable plans - note there is a problem with the goal
 * if this is a goal based intention, otherwise simply drop the intention.  
 * 
 * @author lad
 *
 */
public class GenerateApplicablePlansEmptyProblemGoal extends GenerateApplicablePlansEmpty {
	private static final String name = "Generate Applicable Plans Empty with Problem Goal";
	
	private static final String logname = "ail.semantics.operationalrules.GenerateApplicablePlansEmptyProblemGoal";
	
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
			ArrayList<Deed> ds = new ArrayList<Deed>();
			ArrayList<Guard> gs = new ArrayList<Guard>();
			Event e = new Event(Event.AILDeletion, (Goal) I.hdE().getContent());

			ds.add(new Deed(Deed.Dnpy));
			gs.add(new Guard(new GBelief()));
			Plp.add(new ApplicablePlan(e, ds, gs, 0, I.hdU(), 0, AILAgent.AILdefaultPLname, a.getPrettyPrinter()));
			a.setApplicablePlans(Plp.iterator());

			AJPFLogger.warning(logname, "Warning no applicable plan for goal " + I.hdE().getContent() );
			if (a.shouldTrace()) {
				a.trace(new GeneratePlansEvent(Plp, GeneratePlansEvent.NO_APPLICABLE_PLANS_FOR_GOAL, a.getIntention().getID()));
			}
		} else {
			super.apply(a);
		}
	}
		
}