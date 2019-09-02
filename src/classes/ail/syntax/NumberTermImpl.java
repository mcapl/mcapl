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

import java.util.HashSet;
import java.util.Set;

import ail.tracing.explanations.PredicateDescriptions;
import ajpf.psl.MCAPLNumberTermImpl;
import ajpf.util.AJPFLogger;
import eis.iilang.Parameter;
import eis.iilang.Numeral;

/** Immutable class that implements a term that represents a number */
public final class NumberTermImpl extends DefaultTerm implements NumberTerm {

	/**
	 * The value represented by this number term.
	 */
	private final double fValue;
	
	/**
	 * Constructor.
	 */
	public NumberTermImpl() {
		super();
		fValue = 0;
	}
	
	/**
	 * Constructor.
	 * @param n
	 */
	public NumberTermImpl(MCAPLNumberTermImpl n) {
		fValue = n.solve();
	}
	
	/**
	 * Constructor.
	 * @param sn
	 */
	public NumberTermImpl(String sn) {
		double t = 0;
		try {
			t = Double.parseDouble(sn);
		} catch (Exception e) {
			AJPFLogger.severe("ail.syntax.NumberTermImpl", "Error setting number term value from "+sn);
		}
		fValue = t;
	}
	
	/**
	 * Constructor.
	 * @param vl
	 */
	public NumberTermImpl(double vl) {
		fValue = vl;
	}
	
	/**
	 * Constructor.
	 * @param t
	 */
	public NumberTermImpl(NumberTermImpl t) {
		fValue = t.solve();
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.NumberTerm#solve()
	 */
	@Override
	public double solve() {
		return fValue;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.DefaultTerm#clone()
	 */
	@Override
	public NumberTerm clone() {
    	if (isGround()) {
    		return this;
    	}

    	return new NumberTermImpl(solve());
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.DefaultTerm#isNumeric()
	 */
	@Override
	public boolean isNumeric() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
    public boolean equals(Object o) {
        if (o == this) return true;

        if (o != null && o instanceof NumberTerm) {
            NumberTerm st = (NumberTerm)o;
			if (st.isVar() || st.isArithExpr()) 
                return false;
            else
                return Double.doubleToLongBits(solve()) == Double.doubleToLongBits(st.solve());
		} 
		return false;
	}
    
    public Unifiable substitute(Unifiable term, Unifiable subst) {
    		if (equals(term)) return subst;
    		
    		return this;
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.DefaultTerm#calcHashCode()
     */
    @Override
    protected int calcHashCode() {
        return 37 * (int)solve();
    }
    
    /**
     * Compare two number.
     * @param st
     * @return
     */
    //public int compareTo(NumberTerm st) {
    //	if (solve() > st.solve()) return 1;
    //	if (solve() < st.solve()) return -1;
    //	return 0;
    //}

    /*
     * (non-Javadoc)
     * @see ail.syntax.NumberTerm#eqcompareTo(ail.syntax.NumberTerm)
     */
    @Override
    public int eqcompareTo(NumberTerm st) {
    	if (solve() > st.solve()) return 1;
    	if (solve() < st.solve()) return -1;
    	return 0;
    }
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
	public String toString() {
		long r = Math.round(fValue);
		if (fValue == (double)r) {
			return String.valueOf(r);
		} else {
			return String.valueOf(fValue);
		}
	}
	
    /*
     * (non-Javadoc)
     * @see ail.syntax.Term#fullstring()
     */
    @Override
	public String fullstring() {
		return "NTI:" + toString();
	}
    
    @Override
    public String toString(PredicateDescriptions descriptions ) {
    	return toString();
    }
     
    /*
     * (non-Javadoc)
     * @see ail.syntax.Term#strip_varterm()
     */
    @Override
    public Term strip_varterm() {
    	return this;
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Term#resolveVarsClusters()
     */
    @Override
    public Term resolveVarsClusters() {
    	return this;
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Unifiable#getVarNames()
     */
    @Override
    public Set<String> getVarNames() {
    	return new HashSet<String>();
    }
 
    /*
     * (non-Javadoc)
     * @see ail.syntax.Unifiable#renameVar(java.lang.String, java.lang.String)
     */
    @Override
    public void renameVar(String oldname, String newname) {
    	
    }

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#makeVarsAnnon()
	 */
    @Override
	public void makeVarsAnnon() {
		
	}
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.DefaultTerm#toEISParameter()
     */
    public Parameter toEISParameter() {
    	return new Numeral(fValue);
    }
}
