// ----------------------------------------------------------------------------
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

import java.util.Set;
import java.util.TreeSet;

/**
 * Default class for properties which are disjunctions.
 * 
 * @author louiseadennis
 *
 */
public class Or implements MCAPLProperty {
	/**
	 * The properties
	 */
	private MCAPLProperty inL;
	private MCAPLProperty inR;
	
	private int hashcode;
	
	private boolean keepinold = false;
	
	/**
	 * Constructor.
	 * 
	 * @param p1 the property on the left.
	 * @param p2 the property on the right.
	 */
	public Or(MCAPLProperty p1, MCAPLProperty p2) {
		inL = p1;
		inR = p2;
		hashcode = p1.hashCode() ^ p2.hashCode();
	}
	
	/**
	 * Disjunction is true if a disjunct is true.
	 */
	public boolean check(Set<Proposition> props) {
		if (inL.check(props)) {
			return true;
		} else {
			return (inR.check(props));
		}
	}
	
	/**
	 * Disjunction is true if a disjunct is true.
	 */
	public boolean check() {
		if (inL.check()) {
			return true;
		} else {
			return (inR.check());
		}
	}
	

	/**
	 * Whether this is an until property.  No.
	 */
	public boolean isUntil() {
		return false;
	}
	
	/**
	 * Whether this is a relase property.  No.
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
		if (phi instanceof Or) {
			return (((Or) phi).getInL().equals(inL) && ((Or) phi).getInR().equals(inR));
		}
		
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
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
	 * Or properties split the automata state.
	 */
	public boolean splitsAutomataState() {
		return true;
	}
	
	/**
	 * Or properties split the state so this is empty.
	 */
	public Set<MCAPLProperty> addtoNew(Set<MCAPLProperty> old) {
		return (new TreeSet<MCAPLProperty>());
	}	
	
	/**
	 * r properties split the state into one with inL and one with Inr.
	 */
	public Set<MCAPLProperty> addtoNew1(Set<MCAPLProperty> old, Set<MCAPLProperty> newp) {
		TreeSet<MCAPLProperty> tmp = new TreeSet<MCAPLProperty>();
		// Not sure about this condition
		if (!old.contains(inR) && !old.contains(inL) && !newp.contains(inR)) {
			tmp.add(inL);
		}
		return(tmp);
	}
	
	/**
	 * Or properties split the state into one with inL and one with Inr.
	 */
	public Set<MCAPLProperty> addtoNew2(Set<MCAPLProperty> old, Set<MCAPLProperty> newp) {
		TreeSet<MCAPLProperty> tmp = new TreeSet<MCAPLProperty>();
		// Not sure about this condition
		if (!old.contains(inL) && !old.contains(inR) && !newp.contains(inR)) {
			tmp.add(inR);
		}
		return(tmp);
	}

	/**
	 * Or properties split the state.
	 */
	public Set<MCAPLProperty> addtoOld() {
		return (new TreeSet<MCAPLProperty>());
	}
	
	/**
	 * Add whole property to old - in both cases.
	 */
	public Set<MCAPLProperty> addtoOld1() {
		TreeSet<MCAPLProperty> old1 = new TreeSet<MCAPLProperty>();
		old1.add(this);
		return old1;
	}
	
	/**
	 * Add whole property to old - in both cases.
	 */
	public Set<MCAPLProperty> addtoOld2() {
		TreeSet<MCAPLProperty> old1 = new TreeSet<MCAPLProperty>();
		old1.add(this);
		return old1;
	}
	/**
	 * Or properties split the state.
	 */
	public Set<MCAPLProperty> addtoNext() {
		return (new TreeSet<MCAPLProperty>());
	}

	/**
	 * No obligations on future states.
	 */
	public Set<MCAPLProperty> addtoNext1() {
		return (new TreeSet<MCAPLProperty>());
	}

	/**
	 * No obligations on future states.
	 */
	public Set<MCAPLProperty> addtoNext2() {
		return (new TreeSet<MCAPLProperty>());
	}
	
	/*
	 * (non-Javadoc)
	 * @see mcapl.psl.MCAPLProperty#negate()
	 */
	public MCAPLProperty negate() {
		return (new And(inL.negate(), inR.negate()));
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String s = inL.toString() + " \\/ " + inR.toString();
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
		if (p instanceof Or) {
			int compInl = getInL().compareTo(((Or) p).getInL());
			if (compInl == 0) {
				return getInR().compareTo(((Or) p).getInR());
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
		return 13;
	}


}
