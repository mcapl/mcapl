// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
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
// License along with the AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ail.syntax.annotation;

import ail.syntax.AILAnnotation;
import ail.syntax.Unifier;
import ail.syntax.Predicate;

/**
 * Where there are multiple belief bases it is necessary to track which belief base a belief belongs to.  This is done
 * via annotations on GBeliefs.
 * @author lad
 *
 */
public class BeliefBaseAnnotation implements AILAnnotation {
	// Belief bases are represented by predicates.
	Predicate beliefbase;
	
	/**
	 * Constructor setting up the predicate associated with the belief base.
	 * @param p
	 */
	public BeliefBaseAnnotation(Predicate p) {
		beliefbase = p;
	}
	
	/**
	 * Getter for the belief base predicate.
	 * @return
	 */
	public Predicate getBB() {
		return beliefbase;
	}

	@Override
	public int compareTo(AILAnnotation a) {
		if (a instanceof BeliefBaseAnnotation) {
			return ((BeliefBaseAnnotation) a).getBB().compareTo(beliefbase);
		} else {
			return ((Byte) getType()).compareTo(a.getType());
		}
	}

	@Override
	public boolean isGround() {
		return beliefbase.isGround();
	}

	@Override
	public boolean apply(Unifier u) {
		return beliefbase.apply(u);
	}

	@Override
	public boolean isEmpty() {
		return (beliefbase != null);
	}

	@Override
	public boolean compatibleAnnotations(AILAnnotation a, Unifier u) {
		if (a instanceof BeliefBaseAnnotation) {
			if (((BeliefBaseAnnotation) a).getBB() != null && beliefbase != null) {
				return beliefbase.unifies(((BeliefBaseAnnotation) a).getBB(), u);
			}
			return true;
		} else {
			return false;
		}
	}

	@Override
	/**
	 * We can not add new annotations to a belief base annotation.
	 */
	public boolean addAnnot(AILAnnotation a) {
		return false;
	}

	@Override
	public byte getType() {
		return BBAnnot;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "[" + beliefbase.toString() + "]";
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public AILAnnotation clone() {
		return new BeliefBaseAnnotation((Predicate) beliefbase.clone());
	}

}
