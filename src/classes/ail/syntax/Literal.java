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

import java.util.ArrayList;

import gov.nasa.jpf.annotation.FilterField;

/**
 * A Literal is a Predicate with an annotation and strong negation (~).  This implementation is based
 * heavily on the Jason Literal class by Rafael H. Bordini, Jomi F. Huber, et al.
 * 
 * @author louiseadennis
 */
public class Literal extends PredicatewAnnotation {

	/**
	 * Some useful constants for positive and negative literals.
	 */
	@FilterField
	public static final boolean LPos   = true;
	/**
	 * Some useful constants for positive and negative literals.
	 */
	@FilterField
    public static final boolean LNeg   = false;
    
    /**
     * Whether the literal is positive or negative.
     */
	private boolean type = LPos;

	/** creates a positive literal */
	public Literal(String functor) {
		super(functor);
	}

	/** if pos == true, the literal is positive, otherwise it is negative */
	public Literal(boolean pos, String functor) {
		super(functor);
		type = pos;
	}

	/** if pos == true, the literal is positive, otherwise it is negative */
	public Literal(boolean pos, PredicatewAnnotation p) {
		super(p);
		type = pos;
	}
	
	/** if pos == true, the literal is positive, otherwise it is negative */
	public Literal(boolean pos, Predicate p) {
		super(p);
		type = pos;
	}

	/**
	 * By default a literal created from a predicate is positive.
	 * @param p
	 */
	public Literal(Predicate p) {
		this(true, p);
	}
	
	/**
	 * This looks like a strange constructor but is used by sub-classes.
	 * 
	 * @param l a literal to create the literal from.
	 */
	public Literal(Literal l) {
		super((PredicatewAnnotation) l);
		type = l.type;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.DefaultTerm#isLiteral()
	 */
	@Override
	public boolean isLiteral() {
		return true;
	}
		
	/**
	 * Is this literal a negated?
	 * 
	 * @return whether the literal is negated.
	 */
	public boolean negated() {
		return (type == LNeg);
	}
    
	/**
	 * Setter method for whether or not the literal is negated.
	 * 
	 * @param b false if the literal is negated, true if the literal is not.
	 */
    public void setNegated(boolean b) {
        type = !b;
        hashCodeCache = null;
    }

 

    /*
     * (non-Javadoc)
     * @see ail.syntax.Pred#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;

        if (o instanceof Literal) {
			final Literal l = (Literal) o;
			return type == l.type 
			&& super.equals(l);
		} else if (o instanceof Predicate) {
			return !negated() && super.equals(o);
		}
        return false;
	}
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.PredicatewAnnotation#equalsInclAnnots(java.lang.Object)
     */
    @Override
    public boolean equalsInclAnnots(Object o) {
        if (o == null) return false;
        if (o == this) return true;

        if (o instanceof Literal) {
			final Literal l = (Literal) o;
			return type == l.type 
			&& super.equalsInclAnnots(l);
		} else if (o instanceof Predicate) {
			return !negated() && super.equalsInclAnnots(o);
		}
        return false;
	}
    /*
     * (non-Javadoc)
     * @see ail.syntax.DefaultTerm#compareTo(ail.syntax.Term)
     */
    // @Override
  /*  public int compareTo(Term t) {
        if (t.isLiteral()) {
            Literal tl = (Literal)t;
            if (!negated() && tl.negated()) {
                return -1;
            } if (negated() && !tl.negated()) {
                return 1;
            }
        }
        int c = super.compareTo(t);
        if (c != 0)
            return c;
        return 0;
    }   */     

    /*
     * (non-Javadoc)
     * @see ail.syntax.Pred#clone()
     */
    @Override
	public Literal clone() {
    	Literal c = new Literal(this);
        c.predicateIndicatorCache = this.predicateIndicatorCache;
        c.hashCodeCache = this.hashCodeCache;
        return c;
	}
	
	/** return [~] super.getFunctorArity */
	@Override 
    public PredicateIndicator getPredicateIndicator() {
		if (predicateIndicatorCache == null) {
		    predicateIndicatorCache = new PredicateIndicator(((type == LPos) ? "" : "~")+getFunctor(),getTermsSize());
		}
		return predicateIndicatorCache;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Pred#toString()
	 */
	@Override
	public String toString() {
		if (type == LPos)
			return super.toString();
		else {
			StringBuilder s1 = new StringBuilder("~");
			s1.append(super.toString());
			return s1.toString();
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.PredicatewAnnotation#fullstring()
	 */
	@Override
	public String fullstring() {
		if (type == LPos)
			return "Lit" + super.fullstring();
		else {
			StringBuilder s1 = new StringBuilder("~");
			s1.append(super.fullstring());
			return s1.toString();
		}
		
	}
	
	@Override
	public Unifiable substitute(Unifiable term, Unifiable subst) {
		return new Literal((Predicate) super.substitute(term, subst));
	}
	
	public static void add_literal_to_sorted(Literal lit, ArrayList<Literal> list) {
		int index = 0;
		if (list.isEmpty()) {
			list.add(lit);
			return;
		}
		for (Literal l : list) {
			if (lit.compareTo(l) < 0) {
				list.add(index, lit);
				return;
			}
			index ++;
		}
		list.add(index, lit);
	}

    
}
