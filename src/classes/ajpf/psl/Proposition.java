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

import ajpf.util.AJPFLogger;

/**
 * Default class for properties which are proposition.
 * 
 * @author louiseadennis
 *
 */
public abstract class Proposition implements MCAPLProperty {
	boolean keepinold;
	boolean current_truth_value;
	
	
	/**
	 * By default we assume a Proposition isn't true.
	 */
	public abstract boolean check();
	
	/**
	 * Check against a set of propositions rather than a state;
	 */
	public boolean check(Set<Proposition> props) {
		for (Proposition p: props) {
			if (p.equals(this)) {
				return true;
			}
		}
		
		return false;
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
	 * Is this a proposition that forms a contradiction with the properties in s
	 * if s contains not(P).
	 */
	public boolean isContradiction(Set<MCAPLProperty> s) {
		for (MCAPLProperty p: s) {
			if (p instanceof Not) {
				Proposition negated = ((Not) p).getProp();
				if (negated.equals(this)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Is this a proposition.  Answer yes.
	 */
	public boolean isProposition() {
		return true;
	}
	
	public abstract boolean equals(Object phi); 
	
	/**
	 * Atomic proposition do not split the automata state.
	 */
	public boolean splitsAutomataState() {
		return false;
	}
	
	/**
	 * Propositions do not leave anything in new once expanded.
	 */
	public Set<MCAPLProperty> addtoNew(Set<MCAPLProperty> old) {
		return (new TreeSet<MCAPLProperty>());
	}
	
	/**
	 * Propositions do not split the state.
	 */
	public Set<MCAPLProperty> addtoNew1(Set<MCAPLProperty> old, Set<MCAPLProperty> newp) {
		return (new TreeSet<MCAPLProperty>());
	}
	
	/**
	 * Propositions do not split the state.
	 */
	public Set<MCAPLProperty> addtoNew2(Set<MCAPLProperty> old, Set<MCAPLProperty> newp) {
		return (new TreeSet<MCAPLProperty>());
	}

	/**
	 * Propositions are moved to the old field.
	 */
	public Set<MCAPLProperty> addtoOld() {
		TreeSet<MCAPLProperty> tmp = new TreeSet<MCAPLProperty>();
		tmp.add(this);
		return tmp;
	}
	
	/**
	 * Propositions do not split the state.
	 */
	public Set<MCAPLProperty> addtoOld1() {
		return (new TreeSet<MCAPLProperty>());
	}
	
	/**
	 * Propositions do not split the state.
	 */
	public Set<MCAPLProperty> addtoOld2() {
		return (new TreeSet<MCAPLProperty>());
	}
	
	/**
	 * Propositions place no obligations on the next state.
	 */
	public Set<MCAPLProperty> addtoNext() {
		return (new TreeSet<MCAPLProperty>());
	}

	/**
	 * Propositions do not split the state.
	 */
	public Set<MCAPLProperty> addtoNext1() {
		return (new TreeSet<MCAPLProperty>());
	}

	/**
	 * Propositions do not split the state.
	 */
	public Set<MCAPLProperty> addtoNext2() {
		return (new TreeSet<MCAPLProperty>());
	}

	/**
	 * Cloning must return a proposition.
	 */
	public abstract Proposition clone();
	
	/*
	 * (non-Javadoc)
	 * @see mcapl.psl.MCAPLProperty#negate()
	 */
	public MCAPLProperty negate() {
		return(new Not(this));
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.MCAPLProperty#getProps()
	 */
	public Set<Proposition> getProps() {
		TreeSet<Proposition> props = new TreeSet<Proposition>();
		if (this instanceof FalseProp) {
			
		} else if (this instanceof TrueProp) {
			
		} else {
			props.add(this);
		}
		return(props);
	}
	
	public Set<Until> getUntils() {
		return new TreeSet<Until>();
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
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(MCAPLProperty p) {
		int myq = quickCompareVal();
		int pq = p.quickCompareVal();
		
		if (myq < pq) {
			return -1;
		} else if (myq > pq){
			return 1;
		} else {
			return (this.toString().compareTo(p.toString()));
		}
	}
	
	/**
	 * Updates the current truth value of this proposition.
	 */
	public void updateTV() {
		current_truth_value = check();
		if (AJPFLogger.ltFine("ajpf.psl.Proposition")) {
			AJPFLogger.fine("ajpf.psl.Proposition", "Updating " + this + " to " + current_truth_value);
		}
	}
	
	/**
	 * Getter method for the current truth value of this proposition
	 * @return
	 */
	public boolean getTV() {
		return current_truth_value;
	}
		
}
