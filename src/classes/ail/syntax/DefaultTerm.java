// ----------------------------------------------------------------------------
// Copyright (C) 2008-2016 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
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

import ajpf.psl.MCAPLNumberTermImpl;
import ajpf.psl.MCAPLListTerm;
import ajpf.psl.MCAPLPredicate;
import ajpf.psl.MCAPLTerm;
import ajpf.psl.MCAPLTermImpl;

import eis.iilang.Parameter;
import eis.iilang.Function;
import eis.iilang.Identifier;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import gov.nasa.jpf.annotation.FilterField;

/**
 * Base class for all terms.  Based heavily on that for Jason terms by
 * Rafael H. Bordini, Jomi F. Hubner, et. al.
 */
public abstract class DefaultTerm implements Term {
	@FilterField
	static String logname = "ail.syntax.DefaultTerm";
	
	/**
	 * We need to override hashCode in order to use hash maps with terms
	 * as keys elsewhere in the system.  Java expects equal objects to 
	 * have the same hashsode.
	 */
	@FilterField
	protected Integer hashCodeCache = null;

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
        if (hashCodeCache == null) {
            hashCodeCache = calcHashCode();
        }
        return hashCodeCache;
    }
    
	/**
	 * Calculate the object hashcode.
	 * @return
	 */
    abstract protected int calcHashCode();

    /**
     * Reset the hashCode.
     *
     */
    public void resetHashCodeCache() {
        hashCodeCache = null;
    }
    
    /**
     * Convert a MCAPL Term into an AIL Term
     * @param t
     * @return
     */
    static Term toAIL(MCAPLTerm t) {
    	if (t instanceof MCAPLPredicate) {
    		if (t.isUnnamedVar()) {
    			return new UnnamedVar();
    		} else {
    			return new Predicate((MCAPLPredicate) t);
    		}
    	} else if (t instanceof MCAPLNumberTermImpl) {
    		return new NumberTermImpl((MCAPLNumberTermImpl) t);
    	} else if (t instanceof MCAPLListTerm) {
    		return new ListTermImpl((MCAPLListTerm) t);
    	} else if (t instanceof MCAPLTermImpl) {
    		if (t.isUnnamedVar()) {
    			return new UnnamedVar();
    		} else {
    			return new Predicate((MCAPLTermImpl) t);    	
    		}
    	} else {
    		return null;
    	}
    }


    // Methods required by Comparable
  
     /*
      * (non-Javadoc)
      * @see java.lang.Comparable#compareTo(java.lang.Object)
      */
     @Override
     public int compareTo(MCAPLTerm t) {
    	 return this.toString().compareTo(t.toString());
     }

   // Methods required by MCAPLTerm
         
    /*
     * (non-Javadoc)
     * @see ajpf.psl.MCAPLTerm#isList()
     */
    @Override
    public boolean isList() {
    	return false;
    }
     
    /*
     * (non-Javadoc)
     * @see ajpf.psl.MCAPLTerm#isString()
     */
    @Override
    public boolean isString() {
    	return false;
    }

    /*
     * (non-Javadoc)
     * @see ajpf.psl.MCAPLTerm#isNumeric()
     */
    @Override
    public boolean isNumeric() {
    	return false;
    }
     
    /*
     * (non-Javadoc)
     * @see ajpf.psl.MCAPLTerm#getFunctor()
     */
    @Override
    public String getFunctor() {
  	   return null;
    }
    
    /*
     * (non-Javadoc)
     * @see ajpf.psl.MCAPLTerm#getTerms()
     */
    @Override
    public List<Term> getTerms() {
    	return null;
    }
     
    /*
     * (non-Javadoc)
     * @see ajpf.psl.MCAPLTerm#getTermsSize()
     */
    @Override
    public int getTermsSize() {
    	return 0;
    }
      
    /*
     * (non-Javadoc)
     * @see ajpf.psl.MCAPLTerm#isUnnamedVar()
     */
    @Override
    public boolean isUnnamedVar() {
    	return false;
    }


     // Methods required by Term
    
     /*
      * (non-Javadoc)
      * @see ail.syntax.Term#isVar()
      */
    @Override
    public boolean isVar() {
    	return false;
    }
      
    /*
     * (non-Javadoc)
     * @see ail.syntax.Term#isLiteral()
     */
    @Override
    public boolean isLiteral() {
        return false;
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Term#isArithExpr()
     */
    @Override
    public boolean isArithExpr() {
        return false;
    }
     
    /*
     * (non-Javadoc)
     * @see ail.syntax.Term#hasAnnotation()
     */
    @Override
    public boolean hasAnnotation() {
        return false;
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Term#isPredicate()
     */
    @Override
    public boolean isPredicate() {
        return false;
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.Term#isGround()
     */
    @Override
    public boolean isGround() {
        return true;
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.Term#hasVar(ail.syntax.Term)
     */
    @Override
    public boolean hasVar(Term t) {
        return false;
    }
    
    // Methods required by Cloneable
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    @Override
    abstract public Term clone();
    
    // Methods required by Unifiable
 
    /*
     * (non-Javadoc)
     * @see ail.syntax.Term#apply(ail.semantics.Unifier)
     */
    @Override
    public boolean apply(Unifier u) {
    	return false;
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Unifiable#unifies(ail.syntax.Unifiable, ail.semantics.Unifier)
     */
    @Override
    public boolean unifies(Unifiable t1g, Unifier u) {
    	Term t1 = (Term) t1g;
    	boolean ok = false;
    	if (isGround()) {
    		ok = u.matchTerms((DefaultTerm) this, t1);
    	} else {
    		ok = u.unifyTerms((DefaultTerm) this, t1);
    	}

    	return ok;
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Unifiable#match(ail.syntax.Unifiable, ail.syntax.Unifier)
     */
    @Override
    public boolean match(Unifiable t1g, Unifier u) {
    	Term t1 = (Term) t1g;
    	
    	boolean ok = u.matchTerms(this, t1);

    	return ok;
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Unifiable#match(ail.syntax.Unifiable, ail.syntax.Unifier)
     */
    @Override
    public boolean matchNG(Unifiable t1g, Unifier u) {
    	Term t1 = (Term) t1g;
    	
    	boolean ok = u.matchTermsNG(this, t1);

    	return ok;
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.Unifiable#standardise_apart(ail.syntax.Unifiable, ail.syntax.Unifier)
     */
    @Override
    public void standardise_apart(Unifiable t, Unifier u, Set<String> varnames) {
       	Set<String> tvarnames = t.getVarNames();
    	Set<String> myvarnames = getVarNames();
    	HashSet<String> replacednames = new HashSet<String>();
    	HashSet<String> newnames = new HashSet<String>();
    	for (String s:myvarnames) {
    		if (tvarnames.contains(s)) {
    			if (!replacednames.contains(s)) {
    				String s1 = DefaultAILStructure.generate_fresh(s, tvarnames, myvarnames, newnames, u);
    				renameVar(s, s1);
    				u.renameVar(s, s1);
    			}
    		}
    	}
 
    }   
   
   
           
   /*
    * (non-Javadoc)
    * @see ail.syntax.Term#toEISParameter()
    */
   public Parameter toEISParameter() {
	   if (getTermsSize() == 0) {
		   return new Identifier(getFunctor().toString());
	   } else {
		   LinkedList<Parameter> params = new LinkedList<Parameter>();
		   for (Term t: getTerms()) {
			   params.add(t.toEISParameter());
		   }
		   return new Function(getFunctor().toString(), params);
	   }
   }

   
}
