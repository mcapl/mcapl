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
public class Until implements MCAPLProperty {
	/**
	 * The property that must hold until the second becomes true.
	 */
	private MCAPLProperty trueuntil;
	/**
	 * The property that must hold eventually.
	 */
	protected MCAPLProperty finalprop;
	
	private boolean keepinold = false;
	
	private int hashcode;
	
	/**
	 * Constructure.
	 * 
	 * @param p The property that must hold until the second becomes true.
	 * @param q The property that must hold eventually.
	 */
	public Until (MCAPLProperty p, MCAPLProperty q) {
		trueuntil = p;
		finalprop = q;
		trueuntil.noteKeep();
		hashcode = trueuntil.hashCode() ^ finalprop.hashCode();
	}
	
	/**
	 * Getter method for the phi in phi U psi;
	 * 
	 * @return the property phi from phi U psi.
	 */
	public MCAPLProperty getFmla1() {
		return trueuntil;
	}
	
	/**
	 * Getter method for the psi in phi U psi;
	 * 
	 * @return the property psi from phi U psi;
	 */
	public MCAPLProperty getFmla2() {
		return finalprop;
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
	 * Obviously this is an until property.
	 */
	public boolean isUntil() {
		return true;
	}
	
	/**
	 * Whether this is a relase property.  No.
	 */
	public boolean isRelease() {
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
	 * An Until formal is equal to another Until formula with the same two
	 * sub formulae.
	 */
	public boolean equals(Object phi) {
		if (phi instanceof Until) {
			return(((Until) phi).getFmla1().equals(trueuntil) && ((Until) phi).getFmla2().equals(finalprop));
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
	 * There are two ways an Until formula psi U phi is can be discharged.  
	 * Either phi is true, or psi is true and psi U phi is true.
	 */
	public boolean splitsAutomataState() {
		return true;
	}
	
	/**
	 * Until properties split the state.
	 */
	public Set<MCAPLProperty> addtoNew(Set<MCAPLProperty> old) {
		return (new TreeSet<MCAPLProperty>());
	}
	
	/**
	 * The first state in a split is that where trueuntil holds.
	 */
	public Set<MCAPLProperty> addtoNew1(Set<MCAPLProperty> old, Set<MCAPLProperty> newp) {
		TreeSet<MCAPLProperty> new1 = new TreeSet<MCAPLProperty>();
		
		// Really not sure about this bit.  Its an attempt to reduce search space but may effect
		// validity
		boolean flag = true;
		if (finalprop instanceof Proposition) {
			MCAPLProperty notfinal = new Not((Proposition) finalprop);
			
			for (MCAPLProperty p: old) {
				if (p.equals(notfinal)) {
					flag = false;
				}			
			}
			
			if (flag) {
				new1.add(notfinal);
			}
		}
		
		if (finalprop instanceof Not) {
			MCAPLProperty notfinal = ((Not) finalprop).getProp();
			
			for (MCAPLProperty p: old) {
				if (p.equals(notfinal)) {
					flag = false;
				}			
			}
			
			if (flag) {
				new1.add(notfinal);
			}
		}  
		
		for (MCAPLProperty p: old) {
			if (p.equals(trueuntil)) {
				return new1;
			}
		}
		
		new1.add(trueuntil);
		return new1;
	}
	
	/**
	 * The second state in a split is that where finalprop holds.
	 */
	public Set<MCAPLProperty> addtoNew2(Set<MCAPLProperty> old, Set<MCAPLProperty> newp) {
		TreeSet<MCAPLProperty> new1 = new TreeSet<MCAPLProperty>();
		
		for (MCAPLProperty p: old) {
			if (p.equals(finalprop)) {
				return new1;
			}
		}
		
		new1.add(finalprop);
		return new1;
	}

	/**
	 * Until properties split the state.
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
	 * Until properties split the state.
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
		StringBuilder s = new StringBuilder(trueuntil.toString()).append(" U ").append(finalprop.toString());
		return s.toString();
	}
	
	/*
	 * (non-Javadoc)
	 * @see mcapl.psl.MCAPLProperty#negate()
	 */
	public MCAPLProperty negate() {
		return (new Release(trueuntil.negate(), finalprop.negate()));
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.MCAPLProperty#getProps()
	 */
	public Set<Proposition> getProps() {
		TreeSet<Proposition> props = new TreeSet<Proposition>();
		props.addAll(finalprop.getProps());
		props.addAll(trueuntil.getProps());
		return(props);
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.MCAPLProperty#getUntils()
	 */
	public Set<Until> getUntils() {
		TreeSet<Until> props = new TreeSet<Until>();
		props.addAll(finalprop.getUntils());
		props.addAll(trueuntil.getUntils());
		props.add(this);
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
		finalprop.noteKeep();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(MCAPLProperty p) {
	if (p instanceof Until) {
			int compInl = getFmla1().compareTo(((Until) p).getFmla1());
			if (compInl == 0) {
				return getFmla2().compareTo(((Until) p).getFmla2());
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
		return 17;
	}

}
