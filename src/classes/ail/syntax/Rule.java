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
import java.util.List;
import java.util.Iterator;
import java.util.Set;

import ail.semantics.AILAgent;
import ail.tracing.explanations.PredicateDescriptions;

/**
 * A rule is a Literal (head) with an optional body, as in "a :- b &amp; c".
 */
public class Rule implements LogicalFormula {
	/**
	 * The Body.
	 */
	private LogicalFormula body   = null;
	/**
	 * The Head
	 */
	private Predicate head = null;

	/**
	 * Create a rule from a head and a body.
	 * @param h
	 * @param body
	 */
    public Rule(Predicate h, LogicalFormula body) {
        head = h;
        this.body = body;
    }
    
    /**
     * Create a rule with just a head - i.e. true by default.
     * @param head
     */
    public Rule(Predicate h) {
    	head = h;
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Unifiable#isRule()
     */
    public boolean isRule() {
        return true;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object o) {
        if (o != null && o instanceof Rule) {
            Rule r = (Rule) o;
            if (body != null) {
            	return super.equals(o) && body.equals(r.body);
            } else {
            	if (r.body == null) {
            		return super.equals(o);
            	}
            }
        } 
        return false;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
    	int hash = super.hashCode();
    	if (body != null) {
    		hash += body.hashCode();
    	}
        return hash;
    }
    
    /**
     * Getter for the body of the rule.
     * @return
     */
    public LogicalFormula getBody() {
        return body;
    }
    
    /**
     * Getter for the body.
     * @return
     */
    public Predicate getHead() {
    	return head;
    }

    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    public Rule clone() {
    	if (body != null) {
    		return new Rule((Predicate) head.clone(), (LogicalFormula)body.clone());
    	} else {
    		return new Rule((Predicate) head.clone());
    	}
    }
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
    	if (body != null) {
    		return head + " :- " + body;
    	} else {
    		return head + "";
    	}
    }
    
    @Override
	public String toString(PredicateDescriptions descriptions) {
    	if (body != null) {
    		return head.toString(descriptions) + " :- " + body;
    	} else {
    		return head.toString(descriptions);
    	}
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.Unifiable#getVarNames()
     */
    public Set<String> getVarNames() {
    	Set<String> varnames = head.getVarNames();
    	if (body != null) {
    		varnames.addAll(getBody().getVarNames());
    	}
    	return varnames;
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Unifiable#renameVar(java.lang.String, java.lang.String)
     */
    public void renameVar(String oldname, String newname) {
    	head.renameVar(oldname, newname);
    	if (body != null) {
    		getBody().renameVar(oldname, newname);
    	}
    }
        
    /*
     * (non-Javadoc)
     * @see ail.syntax.Unifiable#unifies(ail.syntax.Unifiable, ail.syntax.Unifier)
     */
    public boolean unifies(Unifiable u, Unifier un) {
    	return head.unifies(u, un);
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Unifiable#unifies(ail.syntax.Unifiable, ail.syntax.Unifier)
     */
    public boolean match(Unifiable u, Unifier un) {
    	return head.match(u, un);
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.Unifiable#matchNG(ail.syntax.Unifiable, ail.syntax.Unifier)
     */
    public boolean matchNG(Unifiable u, Unifier un) {
    	return head.matchNG(u, un);
    }
        
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.DefaultTerm#standardise_apart(ail.syntax.Unifiable, ail.syntax.Unifier)
	 */
    @Override
    public void standardise_apart(Unifiable t, Unifier u, Set<String> topvarnames) {
    	DefaultAILStructure.standardise_apart(t, u, topvarnames, this);
     } 
        
    /**
     * Get a predicate indicator from the head literal.
     * @return
     */
     public PredicateIndicator getPredicateIndicator() {
    	return head.getPredicateIndicator();
    }
    
     /*
      * (non-Javadoc)
      * @see ail.syntax.Unifiable#isGround()
      */
    public boolean isGround() {
    	if (body != null) {
    		return head.isGround() && body.isGround();
    	} else {
    		return head.isGround();
    	}
    }
    
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.LogicalFormula#conjuncts()
	 */
	public List<LogicalFormula> conjuncts() {
		ArrayList<LogicalFormula> l = new ArrayList<LogicalFormula>();
		l.add(this);
		return l;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#apply(ail.syntax.Unifier)
	 */
	public boolean apply(Unifier theta) {
		if (head.apply(theta)) {
			if (body != null) {
				return body.apply(theta);
			} else {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public Unifiable substitute(Unifiable term, Unifiable subst) {
		if (equals(term)) return subst;
		
		return new Rule((Predicate) head.substitute(term, subst), (LogicalFormula) body.substitute(term, subst));
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#makeVarsAnnon()
	 */
	public void makeVarsAnnon() {
		head.makeVarsAnnon();
		if (body != null) {
			body.makeVarsAnnon();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#strip_varterm()
	 */
	public Unifiable strip_varterm() {
		if (body != null) {
			return new Rule((Predicate) head.strip_varterm(), (LogicalFormula) body.strip_varterm());
		} else {
			return new Rule((Predicate) head.strip_varterm());
		}
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#resolveVarsClusters()
	 */
	public Unifiable resolveVarsClusters() {
		if (body != null) {
			return new Rule((Predicate) head.resolveVarsClusters(), (LogicalFormula) body.resolveVarsClusters());
		} else {
			return new Rule((Predicate) head.resolveVarsClusters());
		}
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.LogicalFormula#logicalConsequence(ail.syntax.EvaluationBasewNames, ail.syntax.RuleBase, ail.syntax.Unifier, java.util.List)
	 */
	@Override
	public Iterator<Unifier> logicalConsequence(
			EvaluationBasewNames<PredicateTerm> eb, RuleBase rb, Unifier un, Set<String> varnames, AILAgent.SelectionOrder so) {
		return head.logicalConsequence(eb, rb, un, varnames, so);
	}


 
}
