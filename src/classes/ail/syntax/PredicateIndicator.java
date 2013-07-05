// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
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
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
// This file is based on code from the Open Source software "Jason", copyright
// by Jomi F. Hubner and Rafael H. Bordini.  http://jason.sf.net
//----------------------------------------------------------------------------

package ail.syntax;

import gov.nasa.jpf.annotation.FilterField;

/**
 * Represents the "type" of a predicate, e.g.: ask/4
 * Same implementation as in Jason.
 * 
 * @author jomi
 */
public final class PredicateIndicator implements Comparable<PredicateIndicator> {
	
	/**
	 * The predicate functor name.
	 */
    private final String functor;
    /**
     * The predicate's arity.
     */
    private final int    arity;
    @FilterField
    private final int    hash;
    
    /**
     * Constructor.
     * @param functor
     * @param arity
     */
    public PredicateIndicator(String functor, int arity) {
        this.functor = functor;
        this.arity   = arity;
        hash         = calcHash();
    }

    /**
     * Constructor.
     * @param prefix
     * @param pi
     */
    public PredicateIndicator(String prefix, PredicateIndicator pi) {
        this.functor = prefix + pi.functor;
        this.arity   = pi.arity;
        hash         = calcHash();
    }

    /**
     * Getter for the functor.
     * @return
     */
    public String getFunctor() {
        return functor;
    }
    
    /**
     * Getter for the arity.
     * @return
     */
    public int getArity() {
        return arity;
    }
        
    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o != null && o instanceof PredicateIndicator && o.hashCode() == this.hashCode()) {
            final PredicateIndicator pi = (PredicateIndicator)o;
            return arity == pi.arity && functor.equals(pi.functor);
        } 
        return false;
    }
    
    /*
     * (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(PredicateIndicator o) {
    	return (this.toString().compareTo(o.toString()));
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return hash;
    }
    
    /**
     * Calculate a hash code for this object.
     * @return
     */
    private int calcHash() {
        final int PRIME = 31;
        int t  = PRIME * arity;
        if (functor != null) {
            t = PRIME * t + functor.hashCode();
        }
        return t;
    }
      
    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
    	StringBuilder s = new StringBuilder(functor);
    	s.append("/");
    	s.append(arity);
        return s.toString();
    }
}
