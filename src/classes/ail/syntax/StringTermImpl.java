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

/** 
 * Immutable class for string terms.
 * 
 * @author jomi
 */
public final class StringTermImpl extends DefaultTerm implements StringTerm {
	/**
	 * The String.
	 */
    private final String fValue;

    /**
     * Constructor.
     */
	public StringTermImpl() {
		super();
		fValue = null;
	}
	
	/**
	 * Construct from a string.
	 * @param fs
	 */
	public StringTermImpl(String fs) {
		fValue = fs;
	}
	
	/**
	 * Construct from another StringTermIMpl
	 * @param t
	 */
	public StringTermImpl(StringTermImpl t) {
		fValue = t.getString();
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.StringTerm#getString()
	 */
	public String getString() {
		return fValue;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.DefaultTerm#clone()
	 */
	public StringTerm clone() {
		return this;
	}
	
    /*
     * (non-Javadoc)
     * @see ail.syntax.DefaultTerm#isString()
     */
	public boolean isString() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.StringTerm#length()
	 */
 	public int length() {
		return fValue.length();
	}

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object t) {
        if (t == this) return true;

        if (t != null && t instanceof StringTerm) {
            StringTerm st = (StringTerm)t;
            return fValue.equals(st.getString());
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.DefaultTerm#calcHashCode()
     */
    protected int calcHashCode() {
        return fValue.hashCode();
    }
	
    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
	public String toString() {
		return "\""+fValue+"\"";
	//	return fValue;
	}
	
	public String fullstring() {
		return "STI:" + toString();
	}
	
	public String toString(PredicateDescriptions descriptions ) {
		return toString();
	}

    /*
     * (non-Javadoc)
     * @see ail.syntax.Term#strip_varterm()
     */
    public Term strip_varterm() {
    	return this;
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Term#resolveVarsClusters()
     */
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
    public void renameVar(String oldname, String newname) {
    	
    }

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#makeVarsAnnon()
	 */
	public void makeVarsAnnon() {
		
	}
	
	@Override
	public Unifiable substitute(Unifiable term, Unifiable subst) {
		if (equals(term)) return subst;
		
		else return this;
	}
  
}
