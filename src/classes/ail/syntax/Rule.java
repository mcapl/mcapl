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

import ail.semantics.AILAgent;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

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
	private GuardAtom head = null;

	/**
	 * Create a rule from a head and a body.
	 * @param h
	 * @param body
	 */
    public Rule(GuardAtom h, LogicalFormula body) {
        head = h;
        this.body = body;
    }
    
    /**
     * Create a rule with just a head - i.e. true by default.
     * @param head
     */
    public Rule(GuardAtom head) {
    	this(head, new GBelief(GBelief.GTrue));
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
            return super.equals(o) && body.equals(r.body);
        } 
        return false;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return super.hashCode() + body.hashCode();
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
    public GuardAtom getHead() {
    	return head;
    }

    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    public Rule clone() {
        return new Rule((GuardAtom) head.clone(), (LogicalFormula)body.clone());
    }

    /**
     * Clone just the head.
     * @return
     */
  //  public GuardAtom headClone() {
 //       return (GuardAtom) head.clone();
 //   }
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return head.toString() + " :- " + body;
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.Unifiable#getVarNames()
     */
    public List<String> getVarNames() {
    	List<String> varnames = head.getVarNames();
    	varnames.addAll(getBody().getVarNames());
    	return varnames;
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Unifiable#renameVar(java.lang.String, java.lang.String)
     */
    public void renameVar(String oldname, String newname) {
    	head.renameVar(oldname, newname);
    	getBody().renameVar(oldname, newname);
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.LogicalFormula#logicalConsequence(ail.semantics.AILAgent, ail.syntax.Unifier)
     */
    public Iterator<Unifier> logicalConsequence(AILAgent ag, Unifier un) {
    	return head.logicalConsequence(ag, un);
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
     * @see ail.syntax.LogicalFormula#toTerm()
     */
    public Term toTerm() {
    	return head.toTerm();
    }
    
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.DefaultTerm#standardise_apart(ail.syntax.Unifiable, ail.syntax.Unifier)
	 */
    public void standardise_apart(Unifiable t, Unifier u) {
    	List<String> tvarnames = t.getVarNames();
    	List<String> myvarnames = getVarNames();
    	ArrayList<String> replacednames = new ArrayList<String>();
    	ArrayList<String> newnames = new ArrayList<String>();
    	for (String s:myvarnames) {
    		if (tvarnames.contains(s) || u.containsVarName(s)) {
    			if (!replacednames.contains(s)) {
    				String s1 = DefaultAILStructure.generate_fresh(s, tvarnames, myvarnames, newnames, u);
    				renameVar(s, s1);
    				replacednames.add(s);
    				newnames.add(s1);
    			}
    		}
    	}
 
    } 
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.LogicalFormula#getPosTerms()
     */
    public List<LogicalFormula> getPosTerms() {
    	return head.getPosTerms();
    }
    
    /*
     * 
     */
    public PredicateIndicator getPredicateIndicator() {
    	return head.getPredicateIndicator();
    }
    
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

 
}
