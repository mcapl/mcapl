// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
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
// License along with AJPF; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ajpf.product;

import gov.nasa.jpf.JPF;

import java.util.Set;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import ajpf.psl.Proposition;
import ajpf.util.AJPFException;

/**
 * A state in the model consists of the number of the JPF state and,
 *  a Set of atomic propositions true in this state,
 *  and possibly an annotation.
 * @author louiseadennis
 *
 */
public class ModelState implements Comparable<ModelState> {
	 protected static Logger log = JPF.getLogger("ajpf.product.ModelState");
	/* The JPF state number for this point in the program */
	int JPFstatenum;
	
	/* Atomic propositions true in this state */
	Set<Proposition> props = new HashSet<Proposition>();
	
	/* Any annotation on the state*/
	ModelAnnotation a;
	
	/* done states whether all outgoing edges from this state are left to be explored */
	boolean done = false;
	
	/**
	 * Mark this state as fully explored.
	 */
	public void markdone() {
		if (lowerLogLevelThan(Level.FINE)) {
			log.fine("In ModelState: " + this + "  Setting done");
		}
		done = true;
	}
	
	/**
	 * Is this state fully explored?	
	 * @return
	 */
	public boolean done() {
		return done;
	}
	
	/**
	 * Getter for the JPF state number.
	 * @return
	 */
	public int getNum() {
		return JPFstatenum;
	}
	
	/**
	 * Constructor.
	 * @param statenum
	 * @param buchi
	 */
	public ModelState(int statenum, Set<Proposition> product_props) {
		if (lowerLogLevelThan(Level.FINER)) {
			log.finer("Creating ModelState " + JPFstatenum);
		}
		JPFstatenum = statenum;
		for (Proposition p: product_props) {
			if (p.check()) {
				if (log.getLevel().intValue() <= java.util.logging.Level.FINE.intValue()) {
					log.fine("proposition " + p + " added to " + JPFstatenum);
				}
				props.add(p);
			}
		}
		log.finer("Created ModelState");
	}
	

	public ModelState(int statenum, ModelState ms) {
		if (lowerLogLevelThan(Level.FINER)) {
			log.finer("Creating ModelState " + JPFstatenum);
		}
		JPFstatenum = statenum;
		for (Proposition p: ms.getProps()) {
			if (log.getLevel().intValue() <= java.util.logging.Level.FINE.intValue()) {
				log.fine("proposition " + p + " added to " + JPFstatenum);
			}
			props.add(p);
		}
	}

	/**
	 * Equate states associated with the same JPF state number;
	 */
	public int hashCode() {
		return JPFstatenum;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		if (o instanceof ModelState) {
			ModelState ms = (ModelState) o;
			return hashCode() == ms.hashCode();
		}
		return false;
	}
	
	/**
	 * Getter for the propositions.
	 * @return
	 */
	public Set<Proposition> getProps() {
		return props;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String s = "" + JPFstatenum;
		return s;
	}
	
	/**
	 * Variation of the standard v
	 * @return
	 */
	public String toVerboseString() {
		String s = "" + JPFstatenum + ":\n";
		for (Proposition p: props) {
			s += "   ::";
			s += p.toString();
			s += "\n";
		}
		return s;
	}

	/**
	 * Getter for the annotation.
	 * @return
	 */
	public ModelAnnotation getAnnotation() {
		return a;
	}
	
	/**
	 * Annotate the edge between this state and i with d.
	 * @param i
	 * @param d
	 */
	public void edge_annotate_double(Integer i, double d) throws AJPFException{
		try {
			a.edge_annotate_double(i, d);
		} catch (AJPFException e) {
			throw e;
		}
	}
	
	/**
	 * Setter for the annotation.
	 * @param ann
	 */
	public void setAnnotation(ModelAnnotation ann) {
		a = ann;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(ModelState s) {
		return ((Integer) JPFstatenum).compareTo((Integer) s.getNum());
	}
	
	/**
	 * I'm under the impression that composition of strings is quite inefficient in java.  Therefore we don't want to
	 * perform such compositions for logging messages unless absolutely necessary.  This is a "helper" function for simply
	 * determing the log level and it is wrapped around any log message that requires string composition.  I _think_ using
	 * this function doesn't introduce a competeing overhead because it is static, but I could be wrong.
	 * @param l
	 * @return
	 */
	private static boolean lowerLogLevelThan(Level l) {
		if  (log.getLevel().intValue() <= l.intValue()) {
			return true;
		}
		return false;
	}

}