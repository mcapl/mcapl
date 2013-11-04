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
import ail.syntax.Literal;
import ail.syntax.VarTerm;
import ail.syntax.Term;
import ail.syntax.PredicateIndicator;

import ajpf.util.AJPFLogger;

/**
 * "Update" an agent's belief.  That is remove the previous value and replace it with a new
 * one.
 * 
 * @author lad
 *
 */
public class HandleUpdateBelief extends HandleBelief {
	private static final String name = "Handle Update Belief";
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
		return(super.checkPreconditions(a) && topdeed.isUpdate() && a.consistent(b));
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.HandleTopDeed#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		i.tlI(a);
		Iterator<Literal> bl = a.getBB(topdeed.getDBnum()).iterator();
		PredicateIndicator pi = b.getPredicateIndicator();
		
		while (bl.hasNext()) {
			Literal bp = bl.next();
			Unifier un = new Unifier();
			PredicateIndicator bpi = bp.getPredicateIndicator();
						
			if (a.relevant(bp, b)) {
				if (bpi.equals(pi)) {
					a.delBel(topdeed.getDBnum(), bp);
					if (AJPFLogger.ltFine(logname)) {
						AJPFLogger.fine(logname, a.getAgName() + " dropped " + bp);
					}
								
					thetahd.compose(un);
				}
			}
		}
		
		thetahd.compose(thetab);
		i.compose(thetahd);
		b.apply(thetahd);
		if (b instanceof VarTerm) {
			Term k = ((VarTerm) b).getValue();
			System.err.println(k);
		}
	
		a.addBel(b, AILAgent.refertoself(), topdeed.getDBnum());
		if (AJPFLogger.ltFine(logname)) {
			AJPFLogger.fine(logname, a.getAgName() + " added " + b);
		}
		
		for (Intention i: a.getIntentions()) {
			i.unsuspendFor(b);
		}
	}
}