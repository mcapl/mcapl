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

import ail.semantics.AILAgent;
import ail.syntax.Intention;
import ail.syntax.Unifier;
import ail.tracing.events.CreateIntentionEvent;
import ail.tracing.events.SelectIntentionEvent;
import ail.syntax.Deed;
import ail.syntax.Guard;
import ail.syntax.GBelief;
import ail.syntax.Literal;

import gov.nasa.jpf.annotation.FilterField;

/**
 * A Rule that puts the agent to sleep when encountering a wait intention.
 * NB.  THis combines with Perception - should be renamed because it must always run.
 * 
 * @author lad
 *
 */
public class HandleWaitForDirect extends DirectPerception {
	@FilterField
	Intention i;
	
	@FilterField
	Unifier thetahd;
	
	@FilterField
	Unifier thetab;
	
	@FilterField
	Deed topdeed;
	
	@FilterField
	private static final String name = "Handle Wait For Direct";

	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#getName()
	 */
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.Perceive#checkPreconditions(ail.semantics.AILAgent)
	 */
	public boolean checkPreconditions(AILAgent a) {
		
		i  = a.getIntention();

		if ((! i.deeds().isEmpty())) {
			thetahd = i.hdU();
			Iterator<Unifier> ui = a.believes(i.hdG(), thetahd);
			
			if (ui.hasNext()) {
				thetab = ui.next();
	
				topdeed = i.hdD();
				topdeed.apply(thetab);
			
				if (topdeed.getCategory() == Deed.Dwaitfor) {
					return true;
				}
			}
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.Perceive#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		// First perform perception
		// super.apply(a);

		Literal waitingfor = (Literal) topdeed.getContent().clone();
		Iterator<Unifier> beliefs;
		if (waitingfor.negated()) {
			waitingfor.setNegated(false);
			GBelief wfgb = new GBelief(waitingfor);
			// System.err.println("Checking not " + wfgb);
			beliefs = a.believes(new Guard(Guard.GLogicalOp.not, wfgb), thetab);
			
		} else {
			GBelief wfgb = new GBelief(waitingfor);
			// System.err.println("Checking " + wfgb);
			beliefs = a.believes(new Guard(wfgb), thetab);
		}
				
		if (beliefs.hasNext()) {
			//System.err.println("I believe" + wfgb);
			i.tlI(a);
			thetahd.compose(beliefs.next());
			i.compose(thetahd);
			a.setIntention(i);
			if (a.shouldTrace()) {
				a.trace(new SelectIntentionEvent(i));
			}
		} else {
			i.suspendFor(waitingfor);
			i.hdE().apply(thetahd);
			if (a.allintentionssuspended()) {
				a.getIntentions().add(i);
				//a.sleep();
				Intention empty = new Intention(a.getPrettyPrinter());
				if (a.shouldTrace()) {
					a.trace(new CreateIntentionEvent(empty));
				}
				a.setIntention(empty);
				if (a.shouldTrace()) {
					a.trace(new SelectIntentionEvent(empty));
				}
			} else {
				a.setIntention(i);
				if (a.shouldTrace()) {
					a.trace(new SelectIntentionEvent(i));
				}
			}
			a.sortIntentions();
		}
	}
}