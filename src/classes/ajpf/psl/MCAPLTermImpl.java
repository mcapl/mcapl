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
// License along with AJPF; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
// This file is based on code from the Open Source software "Jason", copyright
// by Jomi F. Hubner and Rafael H. Bordini.  http://jason.sf.net
//----------------------------------------------------------------------------

package ajpf.psl;

import java.util.List;
import java.util.ArrayList;

/**
 * Represents an atom (a structure with no arguments), it is an
 * immutable object.  It extends Literal, so can be used in place of a
 * Literal, but does not allow operations on terms and annotations.
 * 
 * Slight adaptations from Jason's Java class, mostly to remove serialization
 * (for simplicity we can re-add later) and loggers which JPF doesn't like.
 */
public class MCAPLTermImpl implements MCAPLTerm {
	String functor;
	
	ArrayList<MCAPLTerm> terms = new ArrayList<MCAPLTerm>();
	
	int size = 0;

	/**
	 * Create an atom from a string.
	 * 
	 * @param functor
	 */
    public MCAPLTermImpl(String f) {
    	functor = f;
    }
    
    public MCAPLTermImpl() {}
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Literal#clone()
     */
    public MCAPLTermImpl clone() {
		return this; // since this object is immutable
    }
    
    
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.MCAPLTerm#isNumeric()
	 */
    public boolean isNumeric() {
        return false;
    }
	
    /*
     * (non-Javadoc)
     * @see ajpf.psl.MCAPLTerm#isString()
     */
	public boolean isString() {
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.MCAPLTerm#isList()
	 */
	public boolean  isList() {
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(MCAPLTerm t) {
		if (t.getFunctor() == getFunctor()) {
			if (getTermsSize() == t.getTermsSize()) {
				int i = 0;
				for (MCAPLTerm t1 : getTerms()) {
					if (i <= size) {
						int termcomp = t1.compareTo(terms.get(i));
						if (termcomp != 0) {
							return termcomp;
						}
					} 
					i++;
				}
				return 0;
			} else {
				if (size < t.getTermsSize()) {
					return -1;
				} else {
					return 1;
				}
			}
		} else {
			return (getFunctor().compareTo(t.getFunctor()));
		}
	}

	/**
	 * Getter for the string representing the actual content of the term.
	 * @return
	 */
    public String getFunctor() {
    	return functor;
    }
    
    /*
     * (non-Javadoc)
     * @see ajpf.psl.MCAPLTerm#getTerms()
     */
    public List<MCAPLTerm> getTerms() {
    	return terms;
    }
    
    /*
     * (non-Javadoc)
     * @see ajpf.psl.MCAPLTerm#getTermsSize()
     */
    public int getTermsSize() {
    	return size;
    }
    
    /**
     * Add a new argument to this term.
     * @param t
     */
     public void addTerm(MCAPLTerm t) {
    	terms.add(t);
    	size++;
    }
    
     /*
      * (non-Javadoc)
      * @see ajpf.psl.MCAPLTerm#isUnnamedVar()
      */
    public boolean isUnnamedVar() {
    	if (functor != null) {
    		if (this.functor.equals("_")) {
    			return true;
    		} 
    	}
    	return false;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
	   public String toString() {
	         StringBuilder s = new StringBuilder();
	         if (functor != null) {
	            s.append(functor);
	          }
	         if (terms != null) {
	            s.append("(");
	            for (MCAPLTerm t: terms) {
	            	s.append(t.toString());
	            		s.append(",");
	            }
	            s.append(")");
	        }
	        return s.toString();
	    }

}
