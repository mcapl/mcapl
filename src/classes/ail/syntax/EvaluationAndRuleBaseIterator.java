package ail.syntax;

import gov.nasa.jpf.annotation.FilterField;

import java.util.Iterator;
import java.util.LinkedList;

import ail.util.Tuple;
import ail.syntax.annotation.BeliefBaseAnnotation;

import ajpf.util.AJPFLogger;

public class EvaluationAndRuleBaseIterator<K extends PredicateTerm> implements Iterator<Unifier> {
	// A list(iterator) of literals that might unify.
	// The agent may believe several things that can unify
	// with the query.
	Iterator<Tuple<K, String>> il;
	Iterator<Rule> rl;
   
	EvaluationBasewNames<K> eb;
	RuleBase rb;
	Unifier un;
	K logical_term;
	
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
	
	String logname = "ail.syntax.EvaluationAndRuleBaseIterator";
	
	public EvaluationAndRuleBaseIterator(EvaluationBase<LogicalFormula> e) {
		
	}


	public EvaluationAndRuleBaseIterator(EvaluationBasewNames<K> e, RuleBase r, Unifier u, K t) {
		eb = e;
		rb = r;
		un = u;
		logical_term = t;
		il = eb.getRelevantTuple(logical_term);
		rl = rb.getRelevant((Predicate) logical_term);
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
	private void get() {
		current = null;
    		
		// try rule iterator, if it has been created I've worked through all of il
		// and am now chaining through rules.
		while (ruleIt != null && ruleIt.hasNext()) {
			// unifies the rule head with the result of rule evaluation
			Unifier ruleUn = ruleIt.next(); // evaluation result
			current = ruleUn;
			return;
		}
                      		

		// il is all possible Beliefs/messages/whatever that potentially unify with this GBelief
		if (il != null) {
			while (il.hasNext()) {
				Unifier unC = (Unifier) un.clone();
				Tuple<K, String> t = il.next();
				PredicateTerm u = (PredicateTerm) t.getLeft();
				Unifiable h2 = logical_term.clone();
				if (h2 instanceof GuardAtom<?>) {
					if (((GuardAtom<PredicateTerm>) h2).unifieswith(u, unC, t.getRight())) {
						current = unC;
						return;
					}
				} 
					
				if (h2.unifies(u, unC)) {
						current = unC;
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
				ruleC.standardise_apart(h, unC);
				// This this will just unify the head!!
				if (ruleC.unifies(h, unC)) {
					// ruleUn is now (one possible) unifier for this GBelief and the head of the rule.
					// This GBelief should be ground? so only one possibility (?)
					ruleIt = ruleC.getBody().logicalConsequence(eb, rb, unC);
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
