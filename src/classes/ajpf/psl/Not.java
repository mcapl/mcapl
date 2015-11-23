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
 * Default class for properties which are negated propositions.
 * 
 * @author louiseadennis
 *
 */
public class Not implements MCAPLProperty {
	/**
	 * The proposition that is negated.
	 */
	private Proposition p;
	
	private boolean keepinold = false;
	
	/**
	 * Constructor - we assume negation normal form so the
	 * argument has to be a proposition.
	 * 
	 * @param prop the proposition to be negated.
	 */
	public Not(Proposition prop) {
		p = prop;
	}
	
	/**
	 * Negation by failure.  Not is true if the proposition is false.
	 */
	public boolean check() {
		return (! p.check());
	}
	
	/**
	 * Negation by failure.  Not is true if the proposition is false.
	 */
	public boolean check(Set<Proposition> props) {
		return (! p.check(props));
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
	 * Yes, if prop is in s.
	 */
	public boolean isContradiction(Set<MCAPLProperty> s) {
		if (p instanceof TrueProp) {
			return true;
		}

		for (MCAPLProperty prop: s) {
			if (prop instanceof Proposition) {
			  if (prop.equals(p)) {
				  return true;
			  }
			}
		}
				
		return false;
	}
	
	/**
	 * Is this a proposition.  Answer no.
	 */
	public boolean isProposition() {
		return false;
	}
	
	/**
	 * Two Not formulas are equal if their propositions are equal.
	 */
	public boolean equals(Object phi) {
		if (phi instanceof Not) {
			return ((Not) phi).getProp().equals(p);
		}
		
		return false;
	}
	
	public int hashCode() {
		return p.hashCode();
	}
	
	/**
	 * Getter method for the Proposition.
	 * 
	 * @return the proposition that is negated.
	 */
	public Proposition getProp() {
		return p;
	}
	
	/**
	 * Negated propositions do not split the automata state.
	 */
	public boolean splitsAutomataState() {
		return false;
	}
	
	/**
	 * Once expanded, negated properties do not add anything to New.
	 */
	public Set<MCAPLProperty> addtoNew(Set<MCAPLProperty> old) {
		return (new TreeSet<MCAPLProperty>());
	}	
	
	/**
	 * Negated propositions do not split the automata state.
	 */
	public Set<MCAPLProperty> addtoNew1(Set<MCAPLProperty> old, Set<MCAPLProperty> newp) {
		return (new TreeSet<MCAPLProperty>());
	}
	
	/**
	 * Negated propositions do not split the automata state.
	 */
	public Set<MCAPLProperty> addtoNew2(Set<MCAPLProperty> old, Set<MCAPLProperty> newp) {
		return (new TreeSet<MCAPLProperty>());
	}

	/**
	 * Negated propositions are moved to the old field.
	 */
	public Set<MCAPLProperty> addtoOld() {
		TreeSet<MCAPLProperty> tmp = new TreeSet<MCAPLProperty>();
		tmp.add(this);
		return tmp;
	}
	
	/**
	 * Negated propositions do not split the automata state.
	 */
	public Set<MCAPLProperty> addtoOld1() {
		return (new TreeSet<MCAPLProperty>());
	}
	
	/**
	 * Negated propositions do not split the state.
	 */
	public Set<MCAPLProperty> addtoOld2() {
		return (new TreeSet<MCAPLProperty>());
	}
	
	/**
	 * Negated propositions place no obligations on the next state.
	 */
	public Set<MCAPLProperty> addtoNext() {
		return (new TreeSet<MCAPLProperty>());
	}

	/**
	 * Negated propositions do not split the automata state.
	 */
	public Set<MCAPLProperty> addtoNext1() {
		return (new TreeSet<MCAPLProperty>());
	}

	/**
	 * Negated propositions do not split the automata state.
	 */
	public Set<MCAPLProperty> addtoNext2() {
		return (new TreeSet<MCAPLProperty>());
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public MCAPLProperty clone() {
		return (new Not(p.clone()));
	}
	
	/*
	 * (non-Javadoc)
	 * @see mcapl.psl.MCAPLProperty#negate()
	 */
	public MCAPLProperty negate() {
		return p;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String s = "~";
		s += p.toString();
		return s;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.MCAPLProperty#getProps()
	 */
	public Set<Proposition> getProps() {
		TreeSet<Proposition> props = new TreeSet<Proposition>();
		props.add(p);
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
		p.noteKeep();
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(MCAPLProperty p) {
		if (p instanceof Not) {
			return getProp().compareTo(((Not) p).getProp());
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
		return 12;
	}

}
