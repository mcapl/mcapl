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

import java.util.Iterator;
import java.util.Set;

import ail.semantics.AILAgent;
import ail.semantics.AgentMentalState;
import ail.tracing.explanations.PredicateDescriptions;
import gov.nasa.jpf.annotation.FilterField;

/**
 * GBeliefs are beliefs that are "checked" e.g., by guards etc.
 * 
 * @author louiseadennis
 *
 */
public class GBelief extends Literal implements GuardAtom<PredicateTerm> {
	static String logname = "ail.syntax.GBelief";
	
	/**
	 * A Special type of Belief: True - for when there is no condition to be checked.
	 * This is the category used in most AIL Structures for Goals - hence the use
	 * of the referstoGoal() method to check this not a category check.
	 */
	@FilterField
    public static final byte 	  GTrue = 10;
	
	/**
	 * Is this a proper belief or trivial?
	 */
	public byte category = DefaultAILStructure.AILBel;

	/**
     * Predicate and arity represented as a string - may prove useful for swift
     * access of belief base at some point.
     */
	@FilterField
    private PredicateIndicator piCache;
	
	/**
	 * If an agent has several structures of a particular type.
	 * E.g. several belief bases, the one to be consulted for this
	 * GBelief is the one numbered DBnum.
	 * 
	 */
	private StringTerm DBnum = new StringTermImpl(AILAgent.AILdefaultBBname);

    /**
     * Construct a GBelief from a category - intended for construction of GTrue.
     * @param b
     */
    public GBelief() {
    	super("true");
    	category = GTrue;
    }
    
    /**
     * Construct a GBelief from a category and a literal.
     * 
     * @param b the Belief Category.
     * @param l the Literal/
     */
    public GBelief(Literal l) {
    	super(l);
    }
        
    /**
     * Construct a GBelief from a category and a term.
     * @param b the category.
     * @param t the term.
     */
    public GBelief(Term t) {
    	super(Literal.LPos, new PredicatewAnnotation((Predicate) t));
    }
    
    /**
     * Constructor for cloning.
     * @param b
     */
    public GBelief(GBelief b) {
    	super(b);
    	setEB(b.getEB());
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.PredicatewAnnotation#isGround()
     */
    @Override
	public boolean isGround() {
		if (super.isGround()) {
			return DBnum.isGround();
		}
		
		return false;
	}
    
    /**
     * Setter for the DB num.
     * @param n
     */
    public void setEB(StringTerm n) {
    	DBnum = n;
    }
        
    /**
     * Getter for the DB num.
     * @return
     */
    @Override
    public StringTerm getEB() {
    	return DBnum;
    }
        
    /**
     * Whether or not this is the distinguished "True" marker.
     * 
     * @return whether this is a trivially true belief.
     */
	public boolean isTrue() {
		return (getEBType() == GTrue);
	}
	
	
	/** return [+|-][!] super.getFunctorArity */
	public PredicateIndicator getPredicateIndicator() {
        if (piCache == null) {

        	if (! isTrue()) {
            	piCache = new PredicateIndicator(getFunctor(), getTermsSize());
        
            } else  {
            	String s = "True";
            	piCache = new PredicateIndicator(s, 0);
            }
        }
        return piCache;
    }
	
	@Override
	public PredicateIndicator getPurePredicateIndicator() {
       	return getPredicateIndicator();		
	}
	
	/**
	 * Clone this GBelief - useful when propagating guards through intention structures.
	 */
	@Override
	public GBelief clone() {
		if (! isTrue()) {
			GBelief gb1 = new GBelief(super.clone());
			gb1.setEB((StringTerm) getEB().clone());
			return gb1;
		} else {
			GBelief gb1 = new GBelief();
			gb1.setEB((StringTerm) getEB().clone());
			return gb1;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!isTrue()) {
			s.append(super.toString());
			String num = getEB().toString();
			if (num.length() > 2) { // more than just quotes
				s.append("(").append(num).append(")");
			}
		}  else {
			s.append("True");
		}
		return s.toString();
	}
	
	@Override
	public String toString(PredicateDescriptions descriptions) {
		return descriptions.isEmpty() ? toString() : ("BELIEVE " + super.toString(descriptions));
	}

	/**
	 * Flag a GBelief as a varialble if the literal is a variable.
	 */
	@Override
	public boolean isVar() {
		if (!isTrue()) {
			return super.isVar();
		} else {
			return false;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.GuardAtom#isTrivial()
	 */
	@Override
	public boolean isTrivial() {
		return isTrue();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.LogicalFormula#logicalConsequence(ail.semantics.AILAgent, ail.semantics.Unifier)
	 */
	@Override
	public Iterator<Unifier> logicalConsequence(final AgentMentalState ag, final Unifier un, Set<String> varnames, AILAgent.SelectionOrder so) {
     	StringTerm ebname =  getEB();
     	EvaluationBasewNames<PredicateTerm> eb = new TrivialEvaluationBase<PredicateTerm>();
    	if (ebname instanceof VarTerm) {
    		VarTerm ebv = (VarTerm) ebname;
    		if (ebv.hasValue()) {
    			eb = new NamedEvaluationBase<PredicateTerm>(ag.getBB(getEB()), ((StringTerm) ebv.getValue()).getString());
    		} else {
    			for (String ebnames: ag.getBBList()) {
    				EvaluationBase<PredicateTerm> new_eb = ag.getBB(new StringTermImpl(ebnames));
    				if (eb instanceof TrivialEvaluationBase) {
    					eb = new NamedEvaluationBase<PredicateTerm>(new_eb, ebnames);
    				} else {
    					eb = new MergeEvaluationBase<PredicateTerm>(new NamedEvaluationBase<PredicateTerm>(new_eb, ebnames), eb);
    				}
    			}
    		}
    	} else {
    		eb = new NamedEvaluationBase<PredicateTerm>(ag.getBB(getEB()), ebname.getString());
    	}
    	    	
    	return new EvaluationAndRuleBaseIterator(eb, ag.getRuleBase(), un, this, varnames, so);
 	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.DefaultTerm#unifies(ail.syntax.Unifiable, ail.semantics.Unifier)
	 */
	@Override
	public boolean unifies(Unifiable u, Unifier un) {
		if (u instanceof GBelief) {
			GBelief gu = (GBelief) u;
			if (gu.getEBType() == getEBType()) {
				if (DBnum.unifies(gu.getEB(), un)) {
					if (! isTrue()) {
						return super.unifies((Literal) gu, un);
					} else {
						return true;
					}
				}
			} else {
				return false;
			}
		} else if (u instanceof Literal) {
			return unifieswith((Literal) u, un, DBnum.getString());
		} 
		
		return false;
	}
	
	/**
	 * Return this Belief as a literal.
	 * @return
	 */
	public Literal toLiteral() {
		return new Literal(! negated(), new PredicatewAnnotation((PredicatewAnnotation) this));
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.PredicatewAnnotation#unifieswith(ail.syntax.PredicateTerm, ail.syntax.Unifier, java.lang.String)
	 */
	@Override
	public boolean unifieswith(PredicateTerm p, Unifier un, String s) {
		if (DBnum.unifies(new StringTermImpl(s), un)) {
			return toLiteral().unifies(p, un);
		}
		
		return false;
	}
		
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.DefaultAILStructure#calcHashCode()
	 */
	@Override
	protected int calcHashCode() {
		return (41 * getEB().hashCode() + super.calcHashCode());
	}
	   
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.DefaultAILStructure#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof GBelief) {
			return (((GBelief) o).getEB().equals(getEB()) && super.equals(o));
		}
		   
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#getVarNames()
	 */
	@Override
	public Set<String> getVarNames() {
		Set<String> varnames = super.getVarNames();
		varnames.addAll(getEB().getVarNames());
		return varnames;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#renameVar(java.lang.String, java.lang.String)
	 */
	@Override
	public void renameVar(String oldname, String newname) {
		super.renameVar(oldname, newname);
		getEB().renameVar(oldname, newname);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.GuardAtom#getEBType()
	 */
	@Override
	public byte getEBType() {
		return category;
	}

}
