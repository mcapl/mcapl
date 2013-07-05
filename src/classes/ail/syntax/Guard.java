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
 * AIL Guards.  This is really just a wrapper on top of LogicalExpression providing a few extra methods that are
 * not strictly logical in nature.
 * 
 * @author lad
 *
 */
public class Guard {

	/**
	 * The logical expression that represents the guard.
	 */
	private LogExpr guardexpression;
	
	/** 
	 * This guard is trivially true.
	 */
	private boolean istrivial = true;
	
	/**
	 * Constructs an empty guard.
	 *
	 */
	public Guard() {
	}
	
	/**
	 * Construct a guard from a single GBelief.  This is presumed to be a 
	 * positive belief.
	 * 
	 * @param g The GBelief in the guard.
	 */
	public Guard(GuardAtom g) {
		add(g);
	}

	/**
	 * Constructs a guard from a GBelief and a flag showing whether or not it 
	 * is to be believed.
	 * 
	 * @param g The GBelief.
	 * @param tf A flag showing whether the belief is to be believed or not.
	 */
	public Guard(GuardAtom g, boolean tf) {
		add(g, tf);
	}
	
	/**
	 * Construct a Guard from a Logical Expression.
	 * @param l
	 * @param b
	 */
	public Guard(LogExpr l, boolean b) {
		istrivial = b;
		guardexpression = l;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		if (o instanceof Guard) {
			Guard gu = (Guard) o;
			return (guardexpression.equals(gu.getGuardExpression()));
		}
		
		return false;
	}
	
	/*
	 * 
	 */
	public int hashcode() {
		return guardexpression.hashCode();
	}
	
	/**
	 * Getter for the logical expression.
	 * @return
	 */
	public LogExpr getGuardExpression() {
		return guardexpression;
	}
	
	/**
	 * Setter for the logical expression.
	 * @param l
	 */
	public void setGuardExpression(LogExpr l) {
		guardexpression = l;
	}
	
	/**
	 * Convert the Guard to an explicit conjuction term.
	 * 
	 * @return the term constructed from the guard.
	 */
	public Term toTerm() {
		return guardexpression.toTerm();
	}

	/**
	 * Add a new GBelief (conjunct) to the guard.  By default this is to be believed.
	 * 
	 * @param gb  The belief to be added.
	 * @return whether the belief was successfully added.
	 */
	public boolean add(GuardAtom gb) {
		return add(gb, true);
	}
	
	/**
	 * Add a GBelief to the guard with a flag showing whether or not it should be
	 * believed or disbelieved for the guard to be true.
	 * 
	 * @param gb The GBelief.
	 * @param b Flag indiciatin whether gb should be believed or disbelieved.
	 * @return
	 */
	public boolean add(GuardAtom gb, boolean b) {
  
		if (isTrivial()) {
			if (b) {
				if (!gb.isTrivial()) {
					istrivial = false;
				}
			}
		}

		if (guardexpression == null) {
			if (b) {
				guardexpression = new LogExpr(LogExpr.LogicalOp.none, gb);
			} else {
				guardexpression = new LogExpr(LogExpr.LogicalOp.not, gb);
			}
		} else {
			if (b) {
				if (! isTrivial()) {
					guardexpression = new LogExpr(guardexpression, LogExpr.LogicalOp.and, gb);
				}
			} else {
				if (! isTrivial()) {
					guardexpression = new LogExpr(guardexpression, LogExpr.LogicalOp.and, new LogExpr(LogExpr.LogicalOp.not, gb));
				}
			}
		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return guardexpression.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Guard clone() {
		Guard g = new Guard((LogExpr) guardexpression.clone(), isTrivial());
	
		return g;
	}
	    
	/**
	 * Succeeds if the Guard is trivial (ie., contains the belief True).
	 * 
	 * @return whether the guard contains the true belief.
	 */
	public boolean isTrivial() {
		return istrivial;
	}
	    
	/**
	 * Returns an iterators of unifiers that satisfy agent believes this
	 * 
	 * @param ag The agent
	 * @param un An initial unifier
	 * @return An iterator of unifiers that the agent believes this guard.
	 */
	public Iterator<Unifier> logicalConsequence(final AILAgent ag, final Unifier un) {
		return guardexpression.logicalConsequence(ag, un);
	}
	   
	/**
	 * List of the predicate indicators for positive guards that are of
	 * belief type.  Can be used for quick filtering of plans.
	 * @return
	 */
	public ArrayList<PredicateIndicator>  posbelInd() {
		ArrayList <PredicateIndicator> pis = new ArrayList<PredicateIndicator>();
		for (LogicalFormula lf: guardexpression.getPosTerms()) {
			if (lf instanceof GBelief) {
				GBelief b = (GBelief) lf;
				if (b.getCategory() == GBelief.AILBel) {
					pis.add(b.getLiteral().getPredicateIndicator());
				}
			}
		}
		return pis;
		
	}
	
	/**
	 * Return the variable names in the guard.
	 * @return
	 */
	public List<String> getVarNames() {
		return guardexpression.getVarNames();
	}
	
}
