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
import ail.syntax.Unifier;
import ail.syntax.Deed;
import ail.syntax.Event;
import ail.syntax.GBelief;
import ail.syntax.Guard;

/**
 * Rule for the addition of perform goals.
 * 
 * @author lad
 *
 */
public class HandleAddPerformGoalwEvent extends HandleAddGoal {
	private static final String name = "Handle Add Perform Goal with Event";

	
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
		return (super.checkPreconditions(a));
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.HandleTopDeed#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		super.apply(a);
		Event e = i.hdE();
		Unifier u = i.hdU();
		Unifier newu = new Unifier();
		newu.compose(u);
		newu.compose(thetahd);
		//i.tlI(a);
		i.iReplace(e, new Deed(Deed.DNull), new Guard(new GBelief()), thetahd);
		i.iCons(new Event(Event.AILAddition, g), new Deed(Deed.Dnpy), new Guard(new GBelief()), thetahd);	
	}
}