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

import ail.util.AILexception;

import ajpf.psl.MCAPLNumberTermImpl;
import ajpf.psl.MCAPLListTerm;
import ajpf.psl.MCAPLPredicate;
import ajpf.psl.MCAPLTerm;
import ajpf.psl.MCAPLTermImpl;
import ajpf.util.AJPFLogger;

import java.util.List;

import gov.nasa.jpf.annotation.FilterField;
import gov.nasa.jpf.vm.MJIEnv;

/**
 * Base class for all terms.  Based heavily on that for Jason terms by
 * Rafael H. Bordini, Jomi F. Hubner, et. al.
 */
public abstract class DefaultTerm implements Term {
	static String logname = "ail.syntax.DefaultTerm";
	
	/**
	 * Most terms, but not all (see ListTerms) have a functor string;
	 */
	String functor;

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

	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
    public int compareTo(Term t) {
        return this.toString().compareTo(t.toString());
    }
        
    /*
     * (non-Javadoc)
     * @see ail.syntax.Term#isVar()
     */
    public boolean isVar() {
        return false;
    }
    /*
     * (non-Javadoc)
     * @see ail.syntax.Term#isLiteral()
     */
    public boolean isLiteral() {
        return false;
    }
    /*
     * (non-Javadoc)
     * @see ail.syntax.Term#isRule()
     */
    public boolean isRule() {
        return false;
    }
    /*
     * (non-Javadoc)
     * @see ail.syntax.Term#isList()
     */
    public boolean isList() {
        return false;
    }
    /*
     * (non-Javadoc)
     * @see ail.syntax.Term#isString()
     */
    public boolean isString() {
        return false;
    }
    /*
     * (non-Javadoc)
     * @see ail.syntax.Term#isInternalAction()
     */
    public boolean isInternalAction() {
        return false;
    }
    /*
     * (non-Javadoc)
     * @see ail.syntax.Term#isArithExpr()
     */
    public boolean isArithExpr() {
        return false;
    }
    /*
     * (non-Javadoc)
     * @see ail.syntax.Term#isNumeric()
     */
    public boolean isNumeric() {
        return false;
    }
    /*
     * (non-Javadoc)
     * @see ail.syntax.Term#isPred()
     */
    public boolean hasAnnotation() {
        return false;
    }
    /*
     * (non-Javadoc)
     * @see ail.syntax.Term#isStructure()
     */
    public boolean isPredicate() {
        return false;
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.Term#isGround()
     */
    public boolean isGround() {
        return true;
    }
    /*
     * (non-Javadoc)
     * @see ail.syntax.Term#hasVar(ail.syntax.Term)
     */
    public boolean hasVar(Term t) {
        return false;
    }
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    abstract public Term clone();
    /*
     * (non-Javadoc)
     * @see ail.syntax.Term#apply(ail.semantics.Unifier)
     */
    public boolean apply(Unifier u) {
    	return false;
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Unifiable#unifies(ail.syntax.Unifiable, ail.semantics.Unifier)
     */
    public boolean unifies(Unifiable t1g, Unifier u) {
    	Term t1 = (Term) t1g;
    	boolean ok = false;
    	if (isGround()) {
    		ok = u.matchTerms(this, t1);
    	} else {
    		ok = u.unifyTerms(this, t1);
    	}

    	return ok;
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Unifiable#match(ail.syntax.Unifiable, ail.syntax.Unifier)
     */
    public boolean match(Unifiable t1g, Unifier u) {
    	Term t1 = (Term) t1g;
    	
    	boolean ok = u.matchTerms(this, t1);

    	return ok;
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Unifiable#match(ail.syntax.Unifiable, ail.syntax.Unifier)
     */
    public boolean matchNG(Unifiable t1g, Unifier u) {
    	Term t1 = (Term) t1g;
    	
    	boolean ok = u.matchTermsNG(this, t1);

    	return ok;
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.Unifiable#standardise_apart(ail.syntax.Unifiable, ail.syntax.Unifier)
     */
   public void standardise_apart(Unifiable t, Unifier u) {
    	
    }
	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
   public int compareTo(MCAPLTerm t) {
       return this.toString().compareTo(t.toString());
   }
   
   /*
    * (non-Javadoc)
    * @see ajpf.psl.MCAPLTerm#getFunctor()
    */
   public String getFunctor() {
	   return functor;
   }
  
   /*
    * (non-Javadoc)
    * @see ajpf.psl.MCAPLTerm#getTerms()
    */
   public List<Term> getTerms() {
	   return null;
   }
   
   /*
    * (non-Javadoc)
    * @see ajpf.psl.MCAPLTerm#getTermsSize()
    */
   public int getTermsSize() {
	   return 0;
   }
  
   /*
    * (non-Javadoc)
    * @see ail.syntax.Term#isConstant()
    */
   public boolean isConstant() {
	   return false;
   }
  
   /*
    * (non-Javadoc)
    * @see ajpf.psl.MCAPLTerm#isUnnamedVar()
    */
   public boolean isUnnamedVar() {
	   return false;
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
   
   /// For working with terms in MJI.  This is a worker class for returning the right sort of Term
   // WORK IN PROGRESS
   public static Term constructFromRef(MJIEnv env, int ref) throws AILexception {
	   String classname = env.getClassName(ref);
	   
	   if (classname.equals("ail.syntax.ArithExpr")) {
		   return new ArithExpr(env, ref);
	   } else {
		   AJPFLogger.severe(logname, "unknown class name: " + classname);
		   throw new AILexception(" Unknown Class Name ");
	   }
   }

   
}
