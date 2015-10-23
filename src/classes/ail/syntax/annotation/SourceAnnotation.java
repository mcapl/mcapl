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
 * An annotation indicating the source (as a predicate) of some information.
 * @author lad
 *
 */
public class SourceAnnotation implements AILAnnotation {
	Predicate source;
	
	/**
	 * Constructor.
	 * @param p
	 */
	public SourceAnnotation(Predicate p) {
		source = p;
	}

	@Override
	public boolean isGround() {
		return source.isGround();
	}

	@Override
	public boolean apply(Unifier u) {
		return source.apply(u);
	}

	@Override
	public boolean isEmpty() {
		return source == null;
	}

	@Override
	public boolean compatibleAnnotations(AILAnnotation a, Unifier u) {
		if (a instanceof SourceAnnotation) {
			if (((SourceAnnotation) a).getSource() != null && source != null) {
				return source.unifies(((SourceAnnotation) a).getSource(), u);
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Setter for the source.
	 * @return
	 */
	public Predicate getSource() {
		return source;
	}
	
	/**
	 * You can not add additional annotations to source annotations.
	 */
	public boolean addAnnot(AILAnnotation a) {return false;};
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public AILAnnotation clone() {
		return new SourceAnnotation((Predicate) source.clone());
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(AILAnnotation a) {
		if (a instanceof SourceAnnotation) {
			return ((SourceAnnotation) a).getSource().compareTo(source);
		} else {
			return ((Byte) getType()).compareTo(a.getType());
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.AILAnnotation#getType()
	 */
	public byte getType() {
		return SOURCEANNOT;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "[" + source.toString() + "]";
	}
	
}
