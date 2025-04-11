package ail.syntax;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ail.semantics.AILAgent.SelectionOrder;
import ail.tracing.explanations.PredicateDescriptions;
import ail.semantics.AgentMentalState;

public class Is extends AILComparison {
	Term variable;
	Predicate value;
	
	public Is(VarTerm v, Predicate predicate) {
		variable = v;
		value = predicate;
	}

	public Is(Term v, Predicate predicate) {
		variable = v;
		value = predicate;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#unifies(ail.syntax.Unifiable, ail.syntax.Unifier)
	 */
	@Override
	public boolean unifies(Unifiable t, Unifier u) {
	   	if (t instanceof Is) {
    		Is e = (Is) t;
    		if (variable.unifies(e.getLHS(), u)) {
    			return value.unifies(e.getRHS(), u);
    		}
    	}
    	
    	return false;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#standardise_apart(ail.syntax.Unifiable, ail.syntax.Unifier, java.util.List)
	 */
	@Override
	public void standardise_apart(Unifiable t, Unifier u, Set<String> varnames) {
		Set<String> tvarnames = t.getVarNames();
    	Set<String> myvarnames = getVarNames();
    	tvarnames.addAll(varnames);
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
	 * @see ail.syntax.Unifiable#getVarNames()
	 */
	@Override
	public Set<String> getVarNames() {
		Set<String> varnames = new HashSet<String>();
		varnames.addAll(variable.getVarNames());
		varnames.addAll(value.getVarNames());
		return varnames;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#renameVar(java.lang.String, java.lang.String)
	 */
	@Override
	public void renameVar(String oldname, String newname) {
		variable.renameVar(oldname, newname);
		value.renameVar(oldname, newname);
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#match(ail.syntax.Unifiable, ail.syntax.Unifier)
	 */
	@Override
	public boolean match(Unifiable t, Unifier u) {
	   	if (t instanceof Is) {
    		Is e = (Is) t;
    		if (variable.match(e.getLHS(), u)) {
    			return value.match(e.getRHS(), u);
    		}
    	}
    	
    	return false;
	}
	
	/**
	 * Return the LHS of this is equivalence.
	 * @return
	 */
	public Term getLHS() {
		return variable;
	}
	
	/**
	 * Return the RHS of this is equivalence.ß
	 * @return
	 */
	public Term getRHS() {
		return value;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#matchNG(ail.syntax.Unifiable, ail.syntax.Unifier)
	 */
	@Override
	public boolean matchNG(Unifiable t, Unifier u) {
	   	if (t instanceof Is) {
    		Is e = (Is) t;
    		if (variable.matchNG(e.getLHS(), u)) {
    			return value.matchNG(e.getRHS(), u);
    		}
    	}
    	
    	return false;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#isGround()
	 */
	@Override
	public boolean isGround() {
		return (variable.isGround() && value.isGround());
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#apply(ail.syntax.Unifier)
	 */
	@Override
	public boolean apply(Unifier theta) {
		return (variable.apply(theta) && value.apply(theta));
	}
	
	@Override
	public Unifiable substitute(Unifiable term, Unifiable subst) {
		if (equals(term)) return subst;
		
		return new Is((Term) variable.substitute(term, subst), (Predicate) value.substitute(term, subst));
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#makeVarsAnnon()
	 */
	@Override
	public void makeVarsAnnon() {
		variable.makeVarsAnnon();
		value.makeVarsAnnon();
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#strip_varterm()
	 */
	@Override
	public Unifiable strip_varterm() {
		return new Is(variable.strip_varterm(), (Predicate) value.strip_varterm());
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#resolveVarsClusters()
	 */
	@Override
	public Unifiable resolveVarsClusters() {
		return new Is(variable.resolveVarsClusters(), (Predicate) value.resolveVarsClusters());
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.GLogicalFormula#logicalConsequence(ail.semantics.AgentMentalState, ail.syntax.Unifier, java.util.List, ail.semantics.AILAgent.SelectionOrder)
	 */
	@Override
	public Iterator<Unifier> logicalConsequence(AgentMentalState ag,
			Unifier un, Set<String> varnames, SelectionOrder so) {
		// Equilvances are true or false regardless of context.
		return logicalConsequence(un);
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.LogicalFormula#logicalConsequence(ail.syntax.EvaluationBasewNames, ail.syntax.RuleBase, ail.syntax.Unifier, java.util.List, ail.semantics.AILAgent.SelectionOrder)
	 */
	@Override
	public Iterator<Unifier> logicalConsequence(
			EvaluationBasewNames<PredicateTerm> eb, RuleBase rb, Unifier un,
			Set<String> varnames, SelectionOrder so) {
		// Equilvances are true or false regardless of context.
		return logicalConsequence(un);
	}
	
	/**
	 * Does this equation hold true given a particularly unifier?
	 * @param un
	 * @return
	 */
    private Iterator<Unifier> logicalConsequence(Unifier un) {
       	Is ec = (Is) this.clone();
       	Term elhs = ec.getLHS();
        	Term erhs = ec.getRHS();

	       if (elhs.isGround() & erhs.isGround()) {
	       	if (elhs.match(erhs, un)) {
	       		return Equation.createUnifIterator(un);
	       	}
	        } else {
	        	ArrayList<Unifier> uns = new ArrayList<Unifier>();
	        	Unifier unc = un.clone();
	        	elhs.unifies(erhs, unc);
	        	uns.add(unc);
	        	return uns.iterator();
	        }
	        ArrayList<Unifier> empty = new ArrayList<Unifier>();
	        return empty.iterator();  // empty iterator for unifier
    }   


	/*
	 * (non-Javadoc)
	 * @see ail.syntax.AILComparison#clone()
	 */
	@Override
	public Is clone() {
		return new Is((Term) variable.clone(), value.clone());
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return variable + " is " + value;
	}
	
	@Override
    public String toString(PredicateDescriptions descriptions ) {
		return variable.toString(descriptions) + " is " + value.toString(descriptions);
    }
}
