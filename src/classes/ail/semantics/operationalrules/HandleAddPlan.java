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
import ail.syntax.Intention;
import ail.syntax.Plan;

import ajpf.util.AJPFLogger;

/**
 * Add a belief to the agent.
 * 
 * @author lad
 *
 */
public class HandleAddPlan extends HandlePlan {
	private static final String name = "Handle Add Plan";
	private static final String logname = "ail.semantics.operationalrules";
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#getName()
	 */
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.HandleBelief#checkPreconditions(ail.semantics.AILAgent)
	 */
	public boolean checkPreconditions(AILAgent a) {
		return(super.checkPreconditions(a) && topdeed.isAddition());
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.HandleTopDeed#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		i.tlI(a);
		thetahd.compose(thetab);
		i.compose(thetahd);
		p.apply(thetahd);
		
		if (i.getSource().equals(AILAgent.refertopercept())) {
			try {
				a.addPlan(new Plan(p), i.getSource());
			} catch  (Exception e) {
				AJPFLogger.warning(logname, "failed to add " + p);
			}
		} else {
			try {
				a.addPlan(new Plan(p), AILAgent.refertoself());
			} catch (Exception e) {
				AJPFLogger.warning(logname, "failed to add " + p);
			}
		}
		// Unsuspend all intentions since circumstances have changed
		for (Intention i: a.getIntentions()) {
			i.unsuspend();
		}
	}
}