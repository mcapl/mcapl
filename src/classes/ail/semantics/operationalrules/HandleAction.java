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

import ail.util.AILexception;
import ail.semantics.AILAgent;
import ail.syntax.Unifier;
import ail.tracing.events.ActionEvent;
import ail.syntax.Action;
import ail.syntax.Deed;

/**
 * Handle an action.  Calls immediately executeAction in the environment.
 * 
 * @author lad
 *
 */
public class HandleAction extends HandleTopDeed {
	private static final String name = "Handle Action";

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#getName()
	 */
	public String getName() {
		return name;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.HandleTopDeed#checkPreconditions(ail.semantics.AILAgent)
	 */
	public boolean checkPreconditions(AILAgent a) {
		if (super.checkPreconditions(a) && topdeed.getCategory() == Deed.DAction) {
			return true;
		}

		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.HandleTopDeed#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		/**
		 * The action to be handled
		 */
		Action act = (Action) topdeed.getContent();

		try {
			Unifier thetaa = a.getEnv().actionResult(a.getAgName(), act);
			if (thetaa == null) {
				thetahd.compose(thetab);
				act.apply(thetahd);
				thetaa = a.getEnv().executeAction(a.getAgName(), act);
				if (a.shouldTrace()) {
					a.trace(new ActionEvent(act, i_id));
				}
			} 
			if (a.getEnv().executing(a.getAgName(), act)) {
				a.getReasoningCycle().setStopandCheck(true);
			} else {	
				i.tlI(a);
				thetahd.compose(thetaa);
				i.compose(thetahd);
			}
		} catch (AILexception ex) {
			i.tlI(a);
			i.compose(thetahd);
		}
	}
}