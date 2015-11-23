/// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
// 
// This file is part of Agent JPF (AJPF)
//
// AJPF is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// AJPF is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with AJPF if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package ajpf.psl;

import java.util.TreeSet;
import java.util.Set;

/**
 * Default class for properties which are conjunctions.
 * 
 * @author louiseadennis
 *
 */
public class And implements MCAPLProperty {
	/**
	 * The properties
	 */
	private MCAPLProperty inL;
	private MCAPLProperty inR;
	
	private boolean keepinold = false;
	private int hashcode;
	
	/**
	 * Constructor.
	 * 
	 * @param p1 the property on the left.
	 * @param p2 the property on the right.
	 */
	public And(MCAPLProperty p1, MCAPLProperty p2) {
		inL = p1;
		inR = p2;
		hashcode = p1.hashCode() ^ p2.hashCode();
	}
	
	/**
	 * Conjunctions are true if both conjuncts are true.
	 */
	public boolean check() {
		return (inR.check() && inL.check());
	}
	
	/**
	 * Conjunctions are true if both conjuncts are true.
	 */
	public boolean check(Set<Proposition> props) {
		return (inR.check(props) && inL.check(props));
	}

	/**
	 * Whether this is an until property.  No.
	 */
	public boolean isUntil() {
		return false;
	}
	
	/**
	 * Whether this is a release property.  No.
	 */
	public boolean isRelease() {
		return false;
	}
	
	/**
	 * Is this a proposition that forms a contradiction with the properties in s.
	 * This is not a proposition.
	 */
	public boolean isContradiction(Set<MCAPLProperty> s) {
		return false;
	}
	
	/**
	 * Is this a proposition.  Answer no.
	 */
	public boolean isProposition() {
		return false;
	}
	
	/**
	 * Two Or formulas are equal if their properties are equal.
	 */
	public boolean equals(Object phi) {
		if (phi instanceof And) {
			return (((And) phi).getInL().equals(inL) && ((And) phi).getInR().equals(inR));
		}
		
		return false;
	}
	public int hashCode() {
		return hashcode;
	}
	
	/**
	 * Getter method for the inL.
	 * 
	 * @return inL.
	 */
	public MCAPLProperty getInL() {
		return inL;
	}
	
	/**
	 * Getter method for the inR.
	 * 
	 * @return inR.
	 */
	public MCAPLProperty getInR() {
		return inR;
	}
	
	/**
	 * And properties do not split the state.
	 */
	public boolean splitsAutomataState() {
		return false;
	}
	
	// Definitions for addtoNew etc. all taken from 
	// Simple On-th-fly Automatic Verification of Linear Temporal Logic by
	// R. Gerth et. al, Protocol Specification, Verification and Testing, 1995.
	/**
	 * Split property into its sub-properties.
	 */
	public Set<MCAPLProperty> addtoNew(Set<MCAPLProperty> old) {
		TreeSet<MCAPLProperty> tmp = new TreeSet<MCAPLProperty>();
		if (!old.contains(inL)) {
			tmp.add(inL);
		}
		if (!old.contains(inR)) {
			tmp.add(inR);
		}
		return (tmp);
	}	
	
	/**
	 * And Properties do not split the state.
	 */
	public Set<MCAPLProperty> addtoNew1(Set<MCAPLProperty> old, Set<MCAPLProperty> newp) {
		return (new TreeSet<MCAPLProperty>());
	}
	
	/**
	 * And Properties do not splite the state.
	 */
	public Set<MCAPLProperty> addtoNew2(Set<MCAPLProperty> old, Set<MCAPLProperty> newp) {
		return (new TreeSet<MCAPLProperty>());
	}

	/**
	 * Add whole property to old.
	 */
	public Set<MCAPLProperty> addtoOld() {
		TreeSet<MCAPLProperty> old1 = new TreeSet<MCAPLProperty>();
		if (keepinold) {
			old1.add(this);
		}
		return old1;
	}
	
	/**
	 * And Properties do not split the state.
	 */
	public Set<MCAPLProperty> addtoOld1() {
		return (new TreeSet<MCAPLProperty>());
	}
	
	/**
	 * And Properties do not split the state.
	 */
	public Set<MCAPLProperty> addtoOld2() {
		return (new TreeSet<MCAPLProperty>());
	}
	/**
	 * And properties leave no obligations for next, per se.
	 */
	public Set<MCAPLProperty> addtoNext() {
		return (new TreeSet<MCAPLProperty>());
	}

	/**
	 *  And Properties do not split the state.
	 */
	public Set<MCAPLProperty> addtoNext1() {
		return (new TreeSet<MCAPLProperty>());
	}

	/**
	 *  And Properties do not split the state.
	 */
	public Set<MCAPLProperty> addtoNext2() {
		return (new TreeSet<MCAPLProperty>());
	}
	
	/*
	 * (non-Javadoc)
	 * @see mcapl.psl.MCAPLProperty#negate()
	 */
	public MCAPLProperty negate() {
		return (new Or(inL.negate(), inR.negate()));
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String s = inL.toString() + " /\\ " + inR.toString();
		return s;		
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.MCAPLProperty#getProps()
	 */
	public Set<Proposition> getProps() {
		TreeSet<Proposition> props = new TreeSet<Proposition>();
		props.addAll(inL.getProps());
		props.addAll(inR.getProps());
		return(props);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.MCAPLProperty#getUntils()
	 */
	public Set<Until> getUntils() {
		TreeSet<Until> props = new TreeSet<Until>();
		props.addAll(inL.getUntils());
		props.addAll(inR.getUntils());
		return(props);
	}
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.MCAPLProperty#keepInOld()
	 */
	public boolean keepInOld() {
		return keepinold;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.MCAPLProperty#noteKeep()
	 */
	public void noteKeep() {
		keepinold = true;
		inL.noteKeep();
		inR.noteKeep();
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(MCAPLProperty p) {
		if (p instanceof And) {
			int compInl = getInL().compareTo(((And) p).getInL());
			if (compInl == 0) {
				return getInR().compareTo(((And) p).getInR());
			} else {
				return compInl;
			}
		} else {
			int myq = quickCompareVal();
			int pq = p.quickCompareVal();
		
			if (myq < pq) {
				return -1;
			} else {
				return 1;
			}
		} 
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.MCAPLProperty#quickCompareVal()
	 */
	public int quickCompareVal() {
		return 14;
	}

}
