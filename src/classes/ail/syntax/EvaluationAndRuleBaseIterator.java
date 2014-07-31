// ----------------------------------------------------------------------------
// Copyright (C) 2014 Louise A. Dennis, Michael Fisher
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
//----------------------------------------------------------------------------
package ail.syntax;

import gov.nasa.jpf.annotation.FilterField;

import java.util.Iterator;
import java.util.List;

import ail.util.Tuple;

import ajpf.util.AJPFLogger;

/**
 * This is an iterator for Evaluation Bases upon which Prolog style reasoning can be performed.  The Iterator returns potential unifiers 
 * for objects within the Evaluation Base.
 * @author louiseadennis
 *
 * @param <K>
 */
public class EvaluationAndRuleBaseIterator implements Iterator<Unifier> {
	// A list(iterator) of literals that might unify.
	// The agent may believe several things that can unify
	// with the query.
	Iterator<Tuple<PredicateTerm, String>> il;
	// An iterator of Prolog style rules whose heads may unify.
	Iterator<Rule> rl;
   
	// The relevant Evaluation Base 
	EvaluationBasewNames<PredicateTerm> eb;
	// The relevant Rule Base
	RuleBase rb;
	// The initial Unifier
	Unifier un;
	// The logical term to be evaluated against the evaluation and rule bases.
	PredicateTerm logical_term;
	// An initial list of variable names appearing in some top level term, to be used in standardisation apart.
	List<String> varnames;
	
	/**
	 * This holds the current unification solution.
	 */
 	@FilterField
	Unifier current = null;
 	/**
 	 * A helper field when processing prolog like rules.
 	 */
	@FilterField
	Iterator<Unifier> ruleIt = null; // current rule solutions iterator
	/**
	 * If we're doing prolog style reasoning the curren rule we
	 * are using.
	 */
	@FilterField
	Rule rule = null; // current rule
	
	// Name for error logging.
	String logname = "ail.syntax.EvaluationAndRuleBaseIterator";
	
	/**
	 * Constructor.
	 * @param e
	 */
	public EvaluationAndRuleBaseIterator(EvaluationBase<LogicalFormula> e) {}

	/**
	 * Constructor.
	 * @param e
	 * @param r
	 * @param u
	 * @param t
	 * @param vars
	 */
	public EvaluationAndRuleBaseIterator(EvaluationBasewNames<PredicateTerm> e, RuleBase r, Unifier u, PredicateTerm t, List<String> vars) {
		eb = e;
		rb = r;
		un = u;
		logical_term = t;
		il = eb.getRelevantTuple(logical_term);
		rl = rb.getRelevant((Predicate) logical_term);
		varnames = vars;
	}
	
          
	/*
	 * (non-Javadoc)
	 * @see java.util.Iterator#hasNext()
	 */
	public boolean hasNext() {
		if (current == null)
			get();
		return current != null;
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Iterator#next()
	 */
	public Unifier next() {
		if (current == null)
			get();
		Unifier a = current;
		current = null; //get();
		return a;
	}

	/**
	 * Work horse method that calculate the next unifier.
	 *
	 */
	@SuppressWarnings("unchecked")
	private void get() {
		if (AJPFLogger.ltFine("ail.syntax.EvaluationAndRuleBaseIterator")) {
			AJPFLogger.fine("ail.syntax.EvaluationAndRuleBaseIterator", "Checking unification of " + logical_term + " with unifier " + un);
		}		        					
		current = null;
    		
		// try rule iterator, if it has been created I've worked through all of il
		// and am now chaining through rules.
		while (ruleIt != null && ruleIt.hasNext()) {
			// unifies the rule head with the result of rule evaluation
			Unifier ruleUn = ruleIt.next(); // evaluation result
			current = ruleUn;
			if (AJPFLogger.ltFine("ail.syntax.EvaluationAndRuleBaseIterator")) {
				AJPFLogger.fine("ail.syntax.EvaluationAndRuleBaseIterator", logical_term + " matches the head of a rule.");
			}		        					
			return;
		}
                      		

		// il is all possible Beliefs/messages/whatever that potentially unify with this GBelief
		if (il != null) {
			while (il.hasNext()) {
				Unifier unC = (Unifier) un.clone();
				Tuple<PredicateTerm, String> t = il.next();
				if (AJPFLogger.ltFine("ail.syntax.EvaluationAndRuleBaseIterator")) {
					AJPFLogger.fine("ail.syntax.EvaluationAndRuleBaseIterator", "Checking unification of " + logical_term + " and " + t);
				}		        					
				PredicateTerm u = (PredicateTerm) t.getLeft();
				Unifiable h2 = logical_term.clone();
				if (h2 instanceof EBCompare<?>) {
					if (((EBCompare<PredicateTerm>) h2).unifieswith(u, unC, t.getRight())) {
						current = unC;
						if (AJPFLogger.ltFine("ail.syntax.EvaluationAndRuleBaseIterator")) {
							AJPFLogger.fine("ail.syntax.EvaluationAndRuleBaseIterator", "Unifier for " + logical_term + " and " + t + " is " + unC);
						}		        					
						return;
					}
				} 
					
				if (h2.unifies(u, unC)) {
						current = unC;
						if (AJPFLogger.ltFine("ail.syntax.EvaluationAndRuleBaseIterator")) {
							AJPFLogger.fine("ail.syntax.EvaluationAndRuleBaseIterator", "Unifier for " + logical_term + " and " + t + " is " + unC);
						}		        					
						return;
				 }
			}
		}
    		       		
		if (rl != null) {
			while (rl.hasNext()) {
				Unifier unC = (Unifier) un.clone();
				rule = rl.next();
				Rule ruleC = rule.clone();
				Unifiable h = logical_term.clone();
				ruleC.standardise_apart(h, unC, varnames);
				// This this will just unify the head!!
				if (AJPFLogger.ltFine("ail.syntax.EvaluationAndRuleBaseIterator")) {
					AJPFLogger.fine("ail.syntax.EvaluationAndRuleBaseIterator", "Looking for a rule match for " + ruleC + " and " + h);
				}		        					
				if (ruleC.unifies(h, unC)) {
					// ruleUn is now (one possible) unifier for this GBelief and the head of the rule.
					// This GBelief should be ground? so only one possibility (?)
					ruleIt = ruleC.getBody().logicalConsequence(eb, rb, unC, varnames);
					// ruleIt is an iterator over all possible unifiers for the rule body.
					get();
					if (current != null) {
						if (AJPFLogger.ltFine(logname)) {
							AJPFLogger.fine(logname, "Rule instantiated with " + current);
						}
						return;
					}
				}
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Iterator#remove()
	 */
	public void remove() {
	}

}
