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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import ail.semantics.AILAgent;
import ail.semantics.AgentMentalState;
import ail.tracing.explanations.PredicateDescriptions;

/** 
 *  represents an (in)equality. 
 */
public class Equation extends AILComparison {

	/**
	 * The various comparators.
	 * @author lad
	 *
	 */
	public static enum NumericOp { 
		none   { public String toString() { return ""; } }, 
		less   { public String toString() { return "<"; } }, 
		equal    { public String toString() { return "="; } }, 
	}

	/**
	 * LHS and RHS of the (in)equality.
	 */
	private  NumberTerm lhs, rhs;
	/**
	 * The operator.
	 */
	private  NumericOp      op = NumericOp.none;
	
	
	/**
	 * Constructor.
	 * @param f1
	 * @param oper
	 * @param f2
	 */
	public Equation(NumberTerm f1, NumericOp oper, NumberTerm f2) {
		lhs = f1;
		op = oper;
		rhs = f2;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.DefaultAILStructure#apply(ail.semantics.Unifier)
	 */
	@Override
	public boolean apply(Unifier un) {
		return (lhs.apply(un) & rhs.apply(un));
	}
	
	@Override 
	public Unifiable substitute(Unifiable term, Unifiable subst) {
		if (equals(term)) {
			return subst;
		}
		return new Equation((NumberTerm) lhs.substitute(term, subst), getOp(), (NumberTerm) rhs.substitute(term, subst));
	}
    
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.GLogicalFormula#logicalConsequence(ail.semantics.AILAgent, ail.syntax.Unifier, java.util.List)
	 */
	@Override
	public Iterator<Unifier> logicalConsequence(AgentMentalState ag, Unifier u, Set<String> varnames, AILAgent.SelectionOrder so) {
		// Equations are true or false regardless of context.
		return logicalConsequence(u);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.LogicalFormula#logicalConsequence(ail.syntax.EvaluationBasewNames, ail.syntax.RuleBase, ail.syntax.Unifier, java.util.List)
	 */
	@Override
	public Iterator<Unifier> logicalConsequence(EvaluationBasewNames<PredicateTerm> e, RuleBase r, Unifier u, Set<String> varnames, AILAgent.SelectionOrder so) {
		// Equations are true or false regardless of context.
		return logicalConsequence(u);
	}
	
	/**
	 * Does this equation hold true given a particularly unifier?
	 * @param un
	 * @return
	 */
    private Iterator<Unifier> logicalConsequence(Unifier un) {
        try {
        	Equation ec = (Equation) this.clone();
        	ec.apply(un);
        	NumberTerm elhs = ec.getLHS();
        	NumberTerm erhs = ec.getRHS();
	        if (!elhs.isGround() & !erhs.isGround()) {
	        	ArrayList<Unifier> empty = new ArrayList<Unifier>();
	            return empty.iterator();
	        }
	        
	        switch (op) {
	        
	        case none:
	        	return createUnifIterator(un);
	        	
	        case less:
		        int comp = elhs.eqcompareTo(erhs);
	        	if (comp < 0) {
	        		return createUnifIterator(un);
	        	} 
	        	
	        	break;
	            
	        case equal:
	        	if (elhs.isGround() & erhs.isGround()) {
	        		int comp1 = elhs.eqcompareTo(erhs);
	        		if (comp1 == 0) {
	        			return createUnifIterator(un);
	        		}
	        	} else {
	        		ArrayList<Unifier> uns = new ArrayList<Unifier>();
	        		Unifier unc = un.clone();
	        		elhs.unifies(erhs, unc);
	        		uns.add(unc);
	        		return uns.iterator();
	        	}
	        	
	        	break;
	        }
	  	    } catch (Exception e) {
 
	  	    }
    	ArrayList<Unifier> empty = new ArrayList<Unifier>();
        return empty.iterator();  // empty iterator for unifier
    }   

    /** create an iterator for a list of unifiers */
    static public Iterator<Unifier> createUnifIterator(Unifier... unifs) {
        List<Unifier> r = new ArrayList<Unifier>(unifs.length);
        for (int i=0; i<unifs.length; i++) {
            r.add(unifs[i]);
        }
        return r.iterator();
    }
	

    /*
     * (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    @Override
    public Equation clone() {
		NumberTerm nlhs = (NumberTerm) lhs.clone();
		NumericOp nop = this.op;
		NumberTerm nrhs = (NumberTerm) rhs.clone();
		
		return new Equation(nlhs, nop, nrhs);
	}
	

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
	public boolean equals(Object t) {
		if (t != null && t instanceof Equation) {
			Equation eprt = (Equation)t;
			if (lhs == null && eprt.lhs != null) {
				return false;
			}
			if (lhs != null && !lhs.equals(eprt.lhs)) {
				return false;
			}
			
			if (op != eprt.op) {
				return false;
			}

			if (rhs == null && eprt.rhs != null) {
				return false;
			}
			if (rhs != null && !rhs.equals(eprt.rhs)) {
				return false;
			}
			return true;
		} 
		return false;
	}

    /*
     * (non-Javadoc)
     * @see ail.syntax.DefaultAILStructure#hashCode()
     */
    @Override
    public int hashCode() {
        int code = op.hashCode();
        if (lhs != null)
            code += lhs.hashCode();
        if (rhs != null)
            code += rhs.hashCode();
        return code;
    }	
    
	/** gets the Operation of this Expression */
	public NumericOp getOp() {
		return op;
	}
	
	/** gets the LHS of this Expression */
	public NumberTerm getLHS() {
		return lhs;
	}
	
	/** gets the RHS of this Expression */
	public NumberTerm getRHS() {
		return rhs;
	}
	
	/**
	 * Is a unary expression.
	 * @return
	 */
	public boolean isUnary() {
		return lhs == null;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
    public String toString() {
		if (lhs == null) {
			return op+"("+rhs+")";
		} else {
			return "("+lhs+op+rhs+")";
		}
	}
	
	@Override
    public String toString(PredicateDescriptions descriptions ) {
		if (lhs == null) {
			return op+"("+rhs.toString(descriptions)+")";
		} else {
			return "("+lhs.toString(descriptions)+op+rhs.toString(descriptions)+")";
		}
	}
    
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Unifiable#unifies(ail.syntax.Unifiable, ail.syntax.Unifier)
     */
	@Override
    public boolean unifies(Unifiable t, Unifier u) {
    	if (t instanceof Equation) {
    		Equation e = (Equation) t;
    		if (e.getOp().equals(op)) {
    			if (lhs.unifies(e.getLHS(), u)) {
    				return rhs.unifies(e.getRHS(), u);
    			}
    		}
    	}
    	
    	return false;
    };
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Unifiable#match(ail.syntax.Unifiable, ail.syntax.Unifier)
     */
    @Override
    public boolean match(Unifiable t, Unifier u) {
    	if (t instanceof Equation) {
    		Equation e = (Equation) t;
    		if (e.getOp().equals(op)) {
    			if (lhs.match(e.getLHS(), u)) {
    				return rhs.match(e.getRHS(), u);
    			}
    		}
    	}
    	
    	return false;
    	
    };
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Unifiable#matchNG(ail.syntax.Unifiable, ail.syntax.Unifier)
     */
    @Override
    public boolean matchNG(Unifiable t, Unifier u) {
    	if (t instanceof Equation) {
    		Equation e = (Equation) t;
    		if (e.getOp().equals(op)) {
    			if (lhs.matchNG(e.getLHS(), u)) {
    				return rhs.matchNG(e.getRHS(), u);
    			}
    		}
    	}
    	
    	return false;
    	
    };
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Unifiable#isGround()
     */
    @Override
    public boolean isGround() {
    	return lhs.isGround() && rhs.isGround();
    };
    

    /*
     * (non-Javadoc)
     * @see ail.syntax.Unifiable#standardise_apart(ail.syntax.Unifiable, ail.syntax.Unifier, java.util.List)
     */
    @Override
     public void standardise_apart(Unifiable t, Unifier u, Set<String> varnames) {
    	DefaultAILStructure.standardise_apart(t, u, varnames, this);
    } 
    
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#makeVarsAnnon()
	 */
    @Override
	   public void makeVarsAnnon() {
		   lhs.makeVarsAnnon();
		   rhs.makeVarsAnnon();
	    }	 
	   
	   /*
	    * (non-Javadoc)
	    * @see ail.syntax.Unifiable#strip_varterm()
	    */
    @Override
	   public Equation strip_varterm() {
		   return new Equation((NumberTerm) lhs.strip_varterm(), op, (NumberTerm) rhs.strip_varterm());
	   }

	   /*
	    * (non-Javadoc)
	    * @see ail.syntax.Unifiable#resolveVarsClusters()
	    */
    @Override
	   public Equation resolveVarsClusters() {
		   return new Equation((NumberTerm) lhs.resolveVarsClusters(), op, (NumberTerm) rhs.resolveVarsClusters());
	   }

	   /*
     * (non-Javadoc)
     * @see ail.syntax.GBelief#getVarNames()
     */
    @Override
    public Set<String> getVarNames() {
    	Set<String> varnames = getRHS().getVarNames();
    	if (!isUnary()) {
    		varnames.addAll(getLHS().getVarNames());
    	}
    	return varnames;
    }
        
    /*
     * (non-Javadoc)
     * @see ail.syntax.GBelief#renameVar(java.lang.String, java.lang.String)
     */
    @Override
    public void renameVar(String oldname, String newname) {
    	getRHS().renameVar(oldname, newname);
    	if (!isUnary()) {
    		getLHS().renameVar(oldname, newname);
    	}
    }

	// For the time being we do not reason symbolically about equations!!!!
	public Set<List<PredicateTerm>> groundSets() {
		return new HashSet<List<PredicateTerm>>();
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.LogicalFormula#ground()
	 */
	public LogicalFormula ground() {
		return Predicate.PTrue;
	}

}
