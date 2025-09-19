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
 * Class for until properties, phi U psi.
 * 
 * @author louiseadennis
 *
 */
public class Release implements MCAPLProperty {
	/**
	 * The property that when it holds the other no longer holds.
	 */
	protected MCAPLProperty trueuntil;
	/**
	 * The property that must hold eventually.
	 */
	protected MCAPLProperty releases;
	
	private boolean keepinold = false;
	
	private int hashcode;
	
	/**
	 * Constructure.
	 * 
	 * @param p The property that releases q.
	 * @param q The property that is true forever or until p..
	 */
	public Release (MCAPLProperty p, MCAPLProperty q) {
		trueuntil = q;
		releases = p;
		trueuntil.noteKeep();
		hashcode = trueuntil.hashCode() ^ releases.hashCode();
	}
	
	/**
	 * Getter method for the phi in phi R psi;
	 * 
	 * @return the property phi from phi R psi.
	 */
	public MCAPLProperty getFmla1() {
		return releases;
	}
	
	/**
	 * Getter method for the psi in phi R psi;
	 * 
	 * @return the property psi from phi R psi;
	 */
	public MCAPLProperty getFmla2() {
		return trueuntil;
	}
	
	/**
	 * Whether this is a true or not an atomic proposition.  This is a temporal
	 * property so returns true.
	 */
	public boolean check() {
		return true;
	}
	
	/**
	 * Whether this is a true or not an atomic proposition.  This is a temporal
	 * property so returns true.
	 */
	public boolean check(Set<Proposition> props) {
		return true;
	}
	

	/**
	 * Obviously this is a release property.
	 */
	public boolean isRelease() {
		return true;
	}
	
	/**
	 * Not an until property.
	 */
	public boolean isUntil() {
		return false;
	}
	
	/**
	 * Is this a proposition that forms a contradiction with the properties in s.
	 * This is not a proposition and so returns false.
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
	 * An Relase formal is equal to another Release formula with the same two
	 * sub formulae.
	 */
	public boolean equals(Object phi) {
		if (phi instanceof Release) {
			return(((Release) phi).getFmla2().equals(trueuntil) && ((Release) phi).getFmla1().equals(releases));
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
	 * There are two ways an Release formula psi R phi is can be discharged.  
	 * Either psi is true, or phi is true and psi R phi is true.
	 */
	public boolean splitsAutomataState() {
		return true;
	}
	
	/**
	 * Release properties split the state.
	 */
	public Set<MCAPLProperty> addtoNew(Set<MCAPLProperty> old) {
		return (new TreeSet<MCAPLProperty>());
	}
	
	/**
	 * The first state in a split is that where trueuntil holds.
	 */
	public Set<MCAPLProperty> addtoNew1(Set<MCAPLProperty> old, Set<MCAPLProperty> newp) {
		TreeSet<MCAPLProperty> new1 = new TreeSet<MCAPLProperty>();
		
		for (MCAPLProperty p: old) {
			if (p.equals(trueuntil)) {
				return new1;
			}
		}
		
		new1.add(trueuntil);
		return new1;
	}
	
	/**
	 * The second state in a split is that where finalprop and trueuntil hold.
	 */
	public Set<MCAPLProperty> addtoNew2(Set<MCAPLProperty> old, Set<MCAPLProperty> newp) {
		TreeSet<MCAPLProperty> new1 = new TreeSet<MCAPLProperty>();
		boolean finalpropinold = false;
		boolean trueuntilinold = false;
		
		for (MCAPLProperty p: old) {
			if (p.equals(releases)) {
				finalpropinold = true;
			}
			
			if (p.equals(trueuntil)) {
				trueuntilinold = true;
			}
		}
		
		if (! trueuntilinold) {
			new1.add(trueuntil);
		}
		
		if (!finalpropinold) {
			new1.add(releases);
		}
		return new1;
	}

	/**
	 * Release properties split the state.
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
	 * Release properties split the state.
	 */
	public Set<MCAPLProperty> addtoNext() {
		return (new TreeSet<MCAPLProperty>());
	}

	/**
	 * Add whole property to next in first case.
	 */
	public Set<MCAPLProperty> addtoNext1() {
		TreeSet<MCAPLProperty> old1 = new TreeSet<MCAPLProperty>();
		old1.add(this);
		return old1;
	}

	/**
	 * In the second case nothing is necessary.
	 */
	public Set<MCAPLProperty> addtoNext2() {
		return (new TreeSet<MCAPLProperty>());
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String s = releases.toString() + " R " + trueuntil.toString();
		return s;
	}
	
	/*
	 * (non-Javadoc)
	 * @see mcapl.psl.MCAPLProperty#negate()
	 */
	public MCAPLProperty negate() {
		return (new Until(releases.negate(), trueuntil.negate()));
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.MCAPLProperty#getProps()
	 */
	public Set<Proposition> getProps() {
		TreeSet<Proposition> props = new TreeSet<Proposition>();
		props.addAll(releases.getProps());
		props.addAll(trueuntil.getProps());
		return(props);
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.MCAPLProperty#getProps()
	 */
	public Set<Until> getUntils() {
		TreeSet<Until> props = new TreeSet<Until>();
		props.addAll(releases.getUntils());
		props.addAll(trueuntil.getUntils());
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
		trueuntil.noteKeep();
		releases.noteKeep();
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(MCAPLProperty p) {
		if (p instanceof Release) {
			int compInl = getFmla1().compareTo(((Release) p).getFmla1());
			if (compInl == 0) {
				return getFmla2().compareTo(((Release) p).getFmla2());
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
		return 15;
	}


}
