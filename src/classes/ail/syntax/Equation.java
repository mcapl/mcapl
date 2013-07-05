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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ail.semantics.AILAgent;

/** 
 *  represents an (in)equality. 
 */
public class Equation extends GBelief {

	/**
	 * The various comparators.
	 * @author lad
	 *
	 */
	public enum NumericOp { 
		none   { public String toString() { return ""; } }, 
		less   { public String toString() { return "<"; } }, 
		equal    { public String toString() { return "="; } }, 
	}

	/**
	 * LHS and RHS of the (in)equality.
	 */
	private  NumberTerm lhs, rhs;
	/**
	 * The operator.
	 */
	private  NumericOp      op = NumericOp.none;
	
	/**
	 * Constructor.
	 */
	public Equation() {
		super(GBelief.GpureR);
	}
	
	/**
	 * Constructor.
	 * @param f1
	 * @param oper
	 * @param f2
	 */
	public Equation(NumberTerm f1, NumericOp oper, NumberTerm f2) {
		super(GBelief.GpureR);
		lhs = f1;
		op = oper;
		rhs = f2;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.DefaultAILStructure#apply(ail.semantics.Unifier)
	 */
	public boolean apply(Unifier un) {
		return (lhs.apply(un) & rhs.apply(un));
	}
    
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.GBelief#logicalConsequence(ail.semantics.AILAgent, ail.semantics.Unifier)
	 */
    public Iterator<Unifier> logicalConsequence(final AILAgent ag, Unifier un) {
        try {
        	Equation ec = (Equation) this.clone();
        	ec.apply(un);
        	NumberTerm elhs = ec.getLHS();
        	NumberTerm erhs = ec.getRHS();
	        int comp = elhs.eqcompareTo(erhs);
	        if (!elhs.isGround() & !erhs.isGround()) {
	        	comp = 1;
	        }
	        
	        switch (op) {
	        
	        case none:
	        	return createUnifIterator(un);
	        	
	        case less:
	        	if (comp < 0) {
	        		return createUnifIterator(un);
	        	} 
	        	
	        	break;
	            
	        case equal:
	        	if (comp == 0) {
	        		return createUnifIterator(un);
	        	}
	        	
	        	break;
	        }
	  	    } catch (Exception e) {
 
	  	    }
    	ArrayList<Unifier> empty = new ArrayList<Unifier>();
        return empty.iterator();  // empty iterator for unifier
    }   

    /** create an iterator for a list of unifiers */
    static public Iterator<Unifier> createUnifIterator(Unifier... unifs) {
        List<Unifier> r = new ArrayList<Unifier>(unifs.length);
        for (int i=0; i<unifs.length; i++) {
            r.add(unifs[i]);
        }
        return r.iterator();
    }
	
	/** make a hard copy of the terms */
	public GBelief clone() {
		// do not call constructor with term parameter!
		Equation t = new Equation();
		if (lhs != null) {
			t.lhs = (NumberTerm) lhs.clone();
		}

		t.op = this.op;
		
		if (rhs != null) {
			t.rhs = (NumberTerm) rhs.clone();
		}
		return t;
	}
	

    @Override
	public boolean equals(Object t) {
		if (t != null && t instanceof Equation) {
			Equation eprt = (Equation)t;
			if (lhs == null && eprt.lhs != null) {
				return false;
			}
			if (lhs != null && !lhs.equals(eprt.lhs)) {
				return false;
			}
			
			if (op != eprt.op) {
				return false;
			}

			if (rhs == null && eprt.rhs != null) {
				return false;
			}
			if (rhs != null && !rhs.equals(eprt.rhs)) {
				return false;
			}
			return true;
		} 
		return false;
	}
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.GBelief#calcHashCode()
     */
    protected int calcHashCode() {
    	final int PRIME = 7;
    	int result = 1;
    	if (op != null) {
    		result = PRIME * result + op.hashCode();
    	}
    	if (lhs != null) {
    		result = PRIME * result + lhs.hashCode();
    	}
    	if (rhs != null) {
    		result = PRIME * result + rhs.hashCode();
    	}
    	return result;
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.DefaultAILStructure#hashCode()
     */
    public int hashCode() {
        int code = op.hashCode();
        if (lhs != null)
            code += lhs.hashCode();
        if (rhs != null)
            code += rhs.hashCode();
        return code;
    }	
    
	/** gets the Operation of this Expression */
	public NumericOp getOp() {
		return op;
	}
	
	/** gets the LHS of this Expression */
	public NumberTerm getLHS() {
		return lhs;
	}
	
	/** gets the RHS of this Expression */
	public NumberTerm getRHS() {
		return rhs;
	}
	
	/**
	 * Is a unary expression.
	 * @return
	 */
	public boolean isUnary() {
		return lhs == null;
	}

	
    @Override
    public String toString() {
		if (lhs == null) {
			return op+"("+rhs+")";
		} else {
			return "("+lhs+op+rhs+")";
		}
	}

    /*
     * (non-Javadoc)
     * @see ail.syntax.DefaultAILStructure#standardise_apart(ail.syntax.Unifiable, ail.syntax.Unifier)
     */
    public void standardise_apart(Unifiable t, Unifier u) {
    	List<String> tvarnames = t.getVarNames();
    	List<String> myvarnames = getVarNames();
    	ArrayList<String> replacednames = new ArrayList<String>();
    	ArrayList<String> newnames = new ArrayList<String>();
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
     * @see ail.syntax.GBelief#getVarNames()
     */
    public List<String> getVarNames() {
    	List<String> varnames = getRHS().getVarNames();
    	if (!isUnary()) {
    		varnames.addAll(getLHS().getVarNames());
    	}
    	return varnames;
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.GBelief#renameVar(java.lang.String, java.lang.String)
     */
    public void renameVar(String oldname, String newname) {
    	getRHS().renameVar(oldname, newname);
    	if (!isUnary()) {
    		getLHS().renameVar(oldname, newname);
    	}
    }

}
