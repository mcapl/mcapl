// ----------------------------------------------------------------------------
// Copyright (C) 2016 Louise A. Dennis, Michael Fisher, Marija Slavkovik and Matt Webster
// 
// This file is part of Ethical Gwendolen
//
// Ethical Gwendolen is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Ethical Gwendolen is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with Ethical Gwendolen if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package ethical_gwen.syntax.annotation;

import ail.syntax.AILAnnotation;
import ail.syntax.Unifier;
import ail.syntax.Predicate;
import ail.syntax.ListTerm;

/**
 * Where there are multiple belief bases it is necessary to track which belief base a belief belongs to.  This is done
 * via annotations on GBeliefs.
 * @author lad
 *
 */
public class EthicsAnnotation implements AILAnnotation {
	public static byte EthicsAnnot = 2;

	// Belief bases are represented by predicates.
	ListTerm ethics;
	
	/**
	 * Constructor setting up the predicate associated with the belief base.
	 * @param p
	 */
	public EthicsAnnotation(ListTerm e) {
		ethics = e;
	}
	
	/**
	 * Getter for the belief base predicate.
	 * @return
	 */
	public ListTerm getEthics() {
		return ethics;
	}

	@Override
	public int compareTo(AILAnnotation a) {
		if (a instanceof EthicsAnnotation) {
			return ((EthicsAnnotation) a).getEthics().compareTo(ethics);
		} else {
			return ((Byte) getType()).compareTo(a.getType());
		}
	}

	@Override
	public boolean isGround() {
		return ethics.isGround();
	}

	@Override
	public boolean apply(Unifier u) {
		return ethics.apply(u);
	}

	@Override
	public boolean isEmpty() {
		return (ethics != null);
	}

	@Override
	public boolean compatibleAnnotations(AILAnnotation a, Unifier u) {
		if (a instanceof EthicsAnnotation) {
			if (((EthicsAnnotation) a).getEthics() != null && ethics != null) {
				return ethics.unifies(((EthicsAnnotation) a).getEthics(), u);
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
		return EthicsAnnot;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ethics.toString();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public AILAnnotation clone() {
		return new EthicsAnnotation((ListTerm) ethics.clone());
	}

}
