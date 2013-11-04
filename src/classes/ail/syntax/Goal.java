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
//----------------------------------------------------------------------------

package ail.syntax;

import ail.semantics.AILAgent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import gov.nasa.jpf.annotation.FilterField;

/**
 * A class for MCAPL Goals.  These are literals plus a goal type.  They may also appear in guards
 * to be checked to see if they are a goal of the agent.  Hence they also implement GuardAtom.
 * 
 * @author louiseadennis
 *
 */
public class Goal extends PredicatewAnnotation implements GuardAtom {
	/**
	 * The four types of goal: achieve, test, perform and maint.
	 */
	@FilterField
	public final static int achieveGoal = 0;
	@FilterField
	public final static int testGoal = 1;
	@FilterField
	public final static int performGoal = 2;
	@FilterField
	public final static int maintainGoal = 3;
		
	/**
	 * By default a goal is an achieve goal.
	 */
	private int goaltype = achieveGoal;
	
	/**
	 * By default there is only one goal base.
	 * CHANGE STATIC REFERENCE
	 */
	private StringTerm goalbase = new StringTermImpl(AILAgent.AILdefaultGBname);
	
	/**
	 * A Goal can be a literal or a variable.  When it is instantiated 
	 * the var should get moved to the literal.  If it is instantiated to
	 * a non literal it is converted to a positive literal.
	 */
	private VarTerm var;
	
	/**
	 * A Goal can be a literal or a variable.  When it is instantiated 
	 * the var should get moved to the literal.  If it is instantiated to
	 * a non literal it is converted to a positive literal.
	 */
	private Literal l;
	
	/**
	 * A Goal which contains a variable.
	 * 
	 * @param vt the Variable term.
	 * @param i the goal type.
	 */
	public Goal(VarTerm vt, int i) {
		if (vt.isVar()) {
			var = vt;
		} else if (vt.isLiteral()) {
			l = vt;
		} else {
			l = new Literal((Literal) vt);
		}
		goaltype = i;
	}
	
	/**
	 * Create an achieve goal from a string.  Assumes this goal is NOT
	 * a variable.
	 * 
	 * @param s the string.
	 */
	public Goal(String s) {
		l = new Literal(s);
	}
	
	/**
	 * Create a goal from a string and a goal type.
	 * 
	 * @param s The string represented the goal formula.
	 * @param n The type of the goal.
	 */
	public Goal(String s, int n) {
		this(new Literal(s), n);
		goaltype = n;
	}
	
	/**
	 * Construct a goal from a literal and a goal type.
	 * 
	 * @param l The literal representing the goal.
	 * @param n The type of the goal.
	 */
	public Goal(Literal lit, int n) {
		l = lit;
		goaltype = n;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.DefaultTerm#apply(ail.semantics.Unifier)
	 */
	public boolean apply(Unifier u) {
		if (l == null) {
			boolean b = var.apply(u);
			
			if (var.isVar()) {
				return b;
			} else if (var.isLiteral()) {
				l = var;
				var = null;
				return b;
			} else {
				l = new Literal(var);
				var = null;
				return b;
			}
		} else {
			return  l.apply(u);
		}
	}
	
	/**
	 * Getter method for the goal type.
	 * 
	 * @return the type of the goal.
	 */
	public int getGoalType() {
		return goaltype;
	}
	
	/**
	 * Getter method for the goal base.
	 * @return
	 */
	public StringTerm getGoalBase() {
		return goalbase;
	}
	
	public StringTerm getDBnum() {
		return getGoalBase();
	}

	/**
	 * Setter method for the Goalbase.
	 * @param i
	 */
	public void setGoalBase(StringTerm i) {
		goalbase = i;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Literal#clone()
	 */
	public Goal clone() {
		Goal gl = null;
		if (var != null) {
			Term v = var.clone();
			if (v instanceof VarTerm) {
				gl = new Goal((VarTerm) v, getGoalType());
			} else {
				gl = new Goal((Literal) v, getGoalType());
			}
		} else {
			Literal lit = (Literal) l.clone();
			gl = new Goal(lit, getGoalType());
			// gl.setGoalBase(getGoalBase().clone());
		}
		
		gl.setGoalBase((StringTerm) getGoalBase().clone());
		return gl;
	}
	
	/**
	 * Convert the goal to a guard.  Useful for checking achieve goals have been achieved.
	 * 
	 * @return a Guard representing the goal.
	 */
	public Guard toGuard() {
		Guard g = new Guard();
		GBelief gb = new GBelief(GBelief.AILBel, getContent());
		gb.setDBnum(getGoalBase());
		g.add(gb);
		
		return g;
	}
	
	/**
	 * Returns either the variables or the literal.
	 * @return
	 */
	private Literal getContent() {
		if (var == null) {
			return l;
		} else {
			return var;
		}
	}
		
	/**
	 * Returns the literal part of the goal.
	 * @return
	 */
	public Literal getLiteral() {
		return getContent();
	}
	
	/**
	 * Since goals get used in unification we need to be able to annonymise
	 * their variables.
	 *
	 */
	public void makeVarsAnnon() {
		getContent().makeVarsAnnon();
	}
	
	/**
	 * Get the literal functor. 
	 * 
	 * @return
	 */
	public String getFunctor() {
		return(getContent().getFunctor());
	}
	
	/**
	 * Get the literal term size.
	 * @return
	 */
	public int getTermsSize() {
		return(getContent().getTermsSize());
	}
	
	/**
	 * Add a term to the literal.
	 * @param t
	 */
	public void addTerm(Term t) {
		getContent().addTerm(t);
	}
	
	/**
	 * Get the ith sub-term of the literal.
	 * @param i
	 * @return
	 */
	public Term getTerm(int i) {
		return (getContent().getTerm(i));
	}
	
	/**
	 * Represent as a string.
	 */
	public String toString() {
		StringBuilder s1 = new StringBuilder("_");
		s1.append(typeString());
		s1.append(getContent().toString());
		s1.append("(");
		s1.append(getGoalBase().toString());
		s1.append(")");
		String s = s1.toString();
		return (s);
	}
	
	/**
	 * Generate a string for the goal type.
	 * @return a string representing the goal type.
	 */
	public String typeString() {
		if (getGoalType() == achieveGoal) {
			return "a";
		} else if (getGoalType() == performGoal) {
			return "p";
		} else if (getGoalType() == testGoal) {
			return "t";
		} else {
			return "m";
		}
	}
	
	   /*
     * (non-Javadoc)
     * @see ail.syntax.DefaultTerm#calcHashCode()
     */
    protected int calcHashCode() {
        final int PRIME = 11;
        int result = getGoalType();
        if (getContent() != null) {
            result = PRIME * result + getContent().hashCode();
        }
        final int ts = getTermsSize();
        if (ts > 0) {
            result = PRIME * result + getTermsSize();
            for (int i=0; i<ts; i++) {
                result = PRIME * result + getTerm(i).hashCode();
            }
        }
        return result;
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.DefaultTerm#unifies(ail.syntax.Unifiable, ail.semantics.Unifier)
     */
    public boolean unifies(Unifiable g, Unifier u) {
		Goal g1 = (Goal) g;

		if (g1.getGoalType() == getGoalType()) {
			return(u.unifies(getLiteral(), g1.getLiteral()));
		} else {
			return false;
		}
	}
    
    /**
     * Return the predicate indicator for swift lookup.
     * @return
     */
    public PredicateIndicator getPredicateIndicator() {
    	return getContent().getPredicateIndicator();
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Term#strip_varterm()
     */
    public Term strip_varterm() {
    	l = (Literal) l.strip_varterm();
    	return this;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object o) {
    	if (o instanceof Goal) {
    		Goal g = (Goal) o;
    		if (getGoalBase().equals(g.getGoalBase())) {
    			if (getGoalType() == g.getGoalType()) {
    				if (getLiteral().equals(g.getLiteral())) {
    					return true;
    				}
    			}
    		}
    	}
    	
    	return false;
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.DefaultTerm#hashCode()
     */
    public int hashCode() {
    	return (41 * (41 * (41 * getGoalBase().hashCode()) + getGoalType()) + getLiteral().hashCode());
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Predicate#getVarNames()
     */
    public List<String> getVarNames() {
    	List<String> varnames = getContent().getVarNames();
    	varnames.addAll(getGoalBase().getVarNames());
    	return varnames;
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Predicate#renameVar(java.lang.String, java.lang.String)
     */
    public void renameVar(String oldname, String newname) {
    	getContent().renameVar(oldname, newname);
    	getGoalBase().renameVar(oldname, newname);
    }
    
    public Term toTerm() {
    	return l;
    }
    
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.LogicalFormula#getPosTerms()
	 */
	public List<LogicalFormula> getPosTerms() {
		LinkedList<LogicalFormula> l = new LinkedList<LogicalFormula>();
		l.add(this);
		return l;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.GuardAtom#getRelevant(ail.semantics.AILAgent)
	 */
	public Iterator<Unifiable> getRelevant(AILAgent ag) {
      	Iterator<Goal> ll = ag.getGoals();
    	List<Unifiable> ul = new LinkedList<Unifiable>();
    	while (ll.hasNext()) {
    		Goal lln = ll.next();
    		if (getGoalBase().isVar()) {
    			ul.add(lln);
    		} else if (lln.getGoalBase().equals(getGoalBase())) {
    			ul.add(lln);
    		}
    	}
    	return ul.iterator();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.GuardAtom#isTrivial()
	 */
	public boolean isTrivial() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.DefaultTerm#isVar()
	 */
	public boolean isVar() {
		if (var != null && var.isVar()) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.LogicalFormula#logicalConsequence(ail.semantics.AILAgent, ail.syntax.Unifier)
	 */
	public Iterator<Unifier> logicalConsequence(AILAgent ag, Unifier u) {
		return GBelief.logicalConsequence(ag, u, this);
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
