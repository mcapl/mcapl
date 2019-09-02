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
//----------------------------------------------------------------------------

package ail.syntax;

import ail.semantics.AILAgent;
import ail.semantics.AgentMentalState;
import ail.tracing.explanations.PredicateDescriptions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import gov.nasa.jpf.annotation.FilterField;

/**
 * A class for MCAPL Goals.  These are literals plus a goal type.  They may also appear in guards
 * to be checked to see if they are a goal of the agent.  Hence they also implement GuardAtom.
 * 
 * @author louiseadennis
 *
 */
public class Goal extends Literal implements GuardAtom<PredicateTerm> {
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
	 * By default there is only one goal base and it has the default goal base name, so by default goals belong to 
	 * this goalbase.
	 */
	private StringTerm goalbase = new StringTermImpl(AILAgent.AILdefaultGBname);
			
	/**
	 * Create an achieve goal from a string.  Assumes this goal is NOT
	 * a variable.
	 * 
	 * @param s the string.
	 */
	public Goal(String s) {
		super(s);
	}
	
	/**
	 * Create a goal from a string and a goal type.
	 * 
	 * @param s The string represented the goal formula.
	 * @param n The type of the goal.
	 */
	public Goal(String s, int n) {
		super(s);
		goaltype = n;
	}
	
	/**
	 * Create a goal from a predicate and a goal type.
	 * @param p
	 * @param n
	 */
	public Goal(PredicatewAnnotation p, int n) {
		super(p.getFunctor());
		this.addTerms(p.getTerms());
		this.addAnnotFrom(p);
		goaltype = n;
	}
			
	public Goal(Predicate p, int n) {
		super(p.getFunctor());
		this.addTerms(p.getTerms());
//		this.addAnnotFrom(p);
		goaltype = n;
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
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.GuardAtom#getEB()
	 */
	@Override
	public StringTerm getEB() {
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
	@Override
	public Goal clone() {
		Goal gl = null;
		if (isVar()) {
			gl = new Goal(getFunctor(), getGoalType());
		} else {
			PredicatewAnnotation p = (PredicatewAnnotation) super.clone();
			gl = new Goal(p, getGoalType());
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
	public Guard achievedBelief() {
		Literal achievementLiteral = new Literal(getFunctor());
		achievementLiteral.addTerms(getTerms());
		achievementLiteral.addAnnot(getAnnot());
		Guard g = new Guard(new GBelief(achievementLiteral));
		
		return g;
	}
	
	
	/**
	 * Since goals get used in unification we need to be able to annonymise
	 * their variables.
	 *
	 */
	@Override
	public void makeVarsAnnon() {
		super.makeVarsAnnon();
		goalbase.makeVarsAnnon();
	}
		
	/**
	 * Represent as a string.
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("_");
		s.append(typeString()).append(super.toString());
		
		String name = getGoalBase().toString();
		if (name.length() > 2) { // more than just quotes
			s.append("(").append(name).append(")");
		}
		
		return s.toString();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Literal#fullstring()
	 */
	@Override
	public String fullstring() {
		return toString();
	}
	
	@Override
	public String toString(PredicateDescriptions descriptions) {
		if (descriptions.isEmpty()) {
			return toString();
		}
		String pre;
		switch (getGoalType()) {
		case achieveGoal:
			pre = "achieve";
			break;
		case performGoal:
			pre = "perform";
			break;
		case testGoal:
			pre = "test";
			break;
		default:
		case maintainGoal:
			pre = "maintain";
			break;
		}
		return pre + " " + super.toString(descriptions);
	}
	
	/**
	 * Generate a string for the goal type.
	 * @return a string representing the goal type.
	 */
	public String typeString() {
		switch (getGoalType()) {
		case achieveGoal:
			return "a";
		case performGoal:
			return "p";
		case testGoal:
			return "t";
		default:
		case maintainGoal:
			return "m";
		}
	}
	
	   /*
     * (non-Javadoc)
     * @see ail.syntax.DefaultTerm#calcHashCode()
     */
	@Override
    protected int calcHashCode() {
        final int PRIME = 11;
        int result = getGoalType();
        result = PRIME * result + super.calcHashCode();
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
	@Override
    public boolean unifies(Unifiable g, Unifier u) {
    	if (g instanceof Goal) {
			Goal g1 = (Goal) g;
	   		
			if (g1.getGoalType() == getGoalType()) {
				if (getGoalBase().unifies(g1.getGoalBase(), u)) {
					if (Character.isUpperCase(getFunctor().charAt(0))) {
			    		VarTerm v = new VarTerm(getFunctor());
			    		Literal l = new Literal(g1.getFunctor());
			    		l.setTerms(g1.getTerms());
			    		return v.unifies(l, u);
					} else {
						return super.unifies(g1, u);
					}
				}
			}
			return false;
		} else {
			return false;
		}
	}
    
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.PredicatewAnnotation#apply(ail.syntax.Unifier)
	 */
    @SuppressWarnings("unchecked")
    @Override
    public boolean apply(Unifier u) {
    	boolean r = getGoalBase().apply(u);
    		
    	if (Character.isUpperCase(getFunctor().charAt(0))) {
    		VarTerm v = new VarTerm(getFunctor());
   			boolean r1 = v.apply(u);
   			if (v.hasValue()) {
   				setFunctor(v.getValue().getFunctor()); 
   				setTerms((List<Term>) v.getValue().getTerms());
   			}
   			return r || r1;
    	} else {
   			boolean r1 = super.apply(u);
   			return r || r1;
   		}
     }
    
        
    /*
     * (non-Javadoc)
     * @see ail.syntax.Term#strip_varterm()
     */
    @Override
    public Term strip_varterm() {
    	Goal gl = null;
    	if (isVar()) {
    		gl = new Goal(getFunctor(), goaltype);
    	} else {
    		gl = new Goal((PredicatewAnnotation) super.strip_varterm(), goaltype);
    	}
    	gl.setGoalBase((StringTerm) goalbase.strip_varterm());
    	return gl;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
    	if (o instanceof Goal) {
    		Goal g = (Goal) o;
    		if (getGoalBase().equals(g.getGoalBase())) {
    			if (getGoalType() == g.getGoalType()) {
    				return super.equals((PredicatewAnnotation) g);
    			}
    		}
    	}
    	
    	return false;
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.DefaultTerm#hashCode()
     */
    @Override
    public int hashCode() {
    	return (41 * (41 * (41 * getGoalBase().hashCode()) + getGoalType()) + super.hashCode());
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Predicate#getVarNames()
     */
    @Override
    public Set<String> getVarNames() {
    	Set<String> varnames = super.getVarNames();
    	varnames.addAll(getGoalBase().getVarNames());
    	return varnames;
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Predicate#renameVar(java.lang.String, java.lang.String)
     */
    @Override
    public void renameVar(String oldname, String newname) {
    	super.renameVar(oldname, newname);
    	getGoalBase().renameVar(oldname, newname);
    }
    	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.GuardAtom#isTrivial()
	 */
    @Override
	public boolean isTrivial() {
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.PredicatewAnnotation#isGround()
	 */
    @Override
	public boolean isGround() {
		if (Character.isLowerCase(getFunctor().charAt(0))) {
			if (super.isGround()) {
				return goalbase.isGround();
			}
		}
		
		return false;
	}
	
    /**
     * Check if the predicate content of the goal is equal to some predicate p.
     * @param p
     * @return
     */
	public boolean contentequals(PredicatewAnnotation p) {
		if (isVar()) {
			return false;
		} else {
			if (super.equals(p)) {
				return true;
			} else {
				return super.unifies(p, new Unifier());
			}
		}
	} 
	

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.GLogicalFormula#logicalConsequence(ail.semantics.AILAgent, ail.syntax.Unifier)
	 */
	@Override
	public Iterator<Unifier> logicalConsequence(AgentMentalState ag, Unifier un, Set<String> varnames, AILAgent.SelectionOrder so) {
     	StringTerm ebname =  getEB();
     	EvaluationBasewNames<PredicateTerm> eb = new TrivialEvaluationBase<PredicateTerm>();
    	if (ebname instanceof VarTerm) {
    		VarTerm ebv = (VarTerm) ebname;
    		if (ebv.hasValue()) {
    			eb = new NamedEvaluationBase<PredicateTerm>(ag.getGoalBase(getEB()), ((StringTerm) ebv.getValue()).getString());
    		} else {
    			for (String ebnames: ag.getGBList()) {
    				EvaluationBasewNames<PredicateTerm> new_eb = new NamedEvaluationBase<PredicateTerm>(ag.getGoalBase(new StringTermImpl(ebnames)), ebnames);
        	     	// Temporary fix for need to evaluate against Belief Base as well.
    				/* if (ag.getBB(new StringTermImpl(ebnames)) != null) {
	        			EvaluationBasewNames<PredicateTerm> bb = new NamedEvaluationBase<PredicateTerm>(ag.getBB(new StringTermImpl(ebnames)), ebnames);
	        			new_eb = new MergeEvaluationBase<PredicateTerm>(bb, new_eb);
        			} */
   				if (eb instanceof TrivialEvaluationBase) {
    					eb = new_eb;
    				} else {
    					eb = new MergeEvaluationBase<PredicateTerm>(new_eb, eb);
    				}
    			}
    		}
    	} else {
    		eb = new NamedEvaluationBase<PredicateTerm>(ag.getGoalBase(getEB()), ebname.getString());
    	}
    	
    	return logicalConsequence(eb, ag.getRuleBase(), un, varnames, so);
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.GuardAtom#getEBType()
	 */
    @Override
	public byte getEBType() {
		return DefaultAILStructure.AILGoal;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.DefaultTerm#isVar()
	 */
    @Override
	public boolean isVar() {
		return Character.isUpperCase(getFunctor().charAt(0));
	}
    
	public Predicate getLogicalContent() {
		return this;
	}

	@Override
	public PredicateIndicator getPurePredicateIndicator() {
		return getPredicateIndicator();
	}


}
