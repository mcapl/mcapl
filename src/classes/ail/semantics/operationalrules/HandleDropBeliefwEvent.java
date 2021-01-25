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
import ail.syntax.Event;
import ail.syntax.Intention;
import ail.syntax.Literal;
import ail.syntax.PredicateTerm;
import ail.syntax.StringTerm;
import ail.syntax.Unifier;
import ail.tracing.events.CreateIntentionEvent;
import ail.tracing.events.ModificationEvent;
import ajpf.util.AJPFLogger;

/**
 * Rule to drop a belief from the Belief Base.  Starts a new event noting the loss of the belief.
 * 
 * @author lad
 *
 */
public class HandleDropBeliefwEvent extends HandleDropBelief {
	private static final String name = "Handle Drop Belief with Event";
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
	 * @see ail.semantics.operationalrules.HandleDropBelief#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {	
		StringTerm db = topdeed.getDBnum();
		Iterator<PredicateTerm> bl = a.getBB(db).getRelevant(b, AILAgent.SelectionOrder.LINEAR);
				
		while (bl.hasNext()) {
			Literal bp = (Literal) bl.next();
			Unifier un = new Unifier();
						
			if (a.relevant(bp, b)) {
				if (un.sunifies(b, bp)) {
					a.delBel(db, bp);
					if (AJPFLogger.ltFine(logname)) {
						AJPFLogger.fine(logname, a.getAgName() + " dropped " + bp);
					}
					if (a.shouldTrace()) {
						a.trace(new ModificationEvent(ModificationEvent.BELIEFS, db.toString(), null, bp));
					}
					Intention i = new Intention(new Event(Event.AILDeletion, Event.AILBel, b), AILAgent.refertoself(), a.getPrettyPrinter());
					a.getIntentions().add(i);
					if (a.shouldTrace()) {
						a.trace(new CreateIntentionEvent(i));
					}
					thetahd.compose(thetab);
					thetahd.compose(un);
				}
			}
		}
		
		i.tlI(a);
		i.compose(thetahd);
		
		for (Intention i: a.getIntentions()) {
			Literal b_clone = (Literal) b.clone();
			// b_clone.setNegated(true);
			i.unsuspendFor(b_clone);
		}
	}
}