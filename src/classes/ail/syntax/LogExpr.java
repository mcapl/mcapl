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
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import ail.semantics.AILAgent;
import ail.tracing.explanations.PredicateDescriptions;
import ajpf.util.AJPFLogger;

/** 
 *  represents a logical formula with some logical operator ("&amp;",  "|", "not").
 *  
 *  Implementation closely based on the Jason implementation by Jomi Hubner.
 */
public class LogExpr implements LogicalFormula {

	/**
	 * The possible operators of the logical expression
	 * @author lad
	 *
	 */
	public static enum LogicalOp { 
		none   { public String toString() { return ""; } }, 
		not    { public String toString() { return "not "; } }, 
		and    { public String toString() { return " & "; } },
		or     { public String toString() { return " | "; } };
	}

	/**
	 * The LHS and RHS of the expression.
	 */
	private  LogicalFormula lhs, rhs;
	/**
	 * The operator.
	 */
	private  LogicalOp      op = LogicalOp.none;
	
	/**
	 * 
	 */
	private boolean above_a_passed_cut = false;
	
	/**
	 * Constuctor.
	 */
	public LogExpr() {
		super();
	}
	
	/**
	 * Construct a logical expression from two subexpressions and an operator.
	 * @param f1
	 * @param oper
	 * @param f2
	 */
	public LogExpr(LogicalFormula f1, LogicalOp oper, LogicalFormula f2) {
		lhs = f1;
		op = oper;
		rhs = f2;
	}

	/**
	 * Construct a logical expression from one subexpression and an operator.
	 * @param oper
	 * @param f
	 */
	public LogExpr(LogicalOp oper, LogicalFormula f) {
		op = oper;
		rhs = f;
	}
    
	/**
	 * Implements backtracking to find a unifier which makes the expression true against the internal state of an agent.
	 */
	@Override
    public Iterator<Unifier> logicalConsequence(final EvaluationBasewNames<PredicateTerm> eb, final RuleBase rb, Unifier un, final Set<String> varnames, AILAgent.SelectionOrder so) {
        try {
	        final Iterator<Unifier> ileft;
	        switch (op) {
	        
	        	case not:
	        		if (!rhs.logicalConsequence(eb,rb,un,varnames, so).hasNext()) {
	        			return createUnifIterator(un);
	        		}
	        		break;
	        	case none:
	        		return rhs.logicalConsequence(eb, rb, un, varnames, so);
	        
	        	case and:
	        		ileft = lhs.logicalConsequence(eb,rb,un, varnames, so);
	        		return new Iterator<Unifier>() {
	        			Unifier current = null;
	        			Iterator<Unifier> iright = null;
	        			public boolean hasNext() {
							if (current == null) get();
							return current != null;
	        			}
	        			public Unifier next() {
	        				if (current == null) get();
	        				Unifier a = current;
	        				current = null; 
	        				return a;
	        			}
	        			private void get() {
	        				current = null;
	        				while ((iright == null || !iright.hasNext()) && ileft.hasNext() && uncut()) {
	        					Unifier ul = ileft.next();
	        					if (lhs instanceof PrologCut) {
	        						cut();
	        					}
	        					if (lhs instanceof LogExpr) {
	        						if (((LogExpr) lhs).contains_cut()) {
	        							cut();
	        						}
	        					}
	        					iright = rhs.logicalConsequence(eb, rb, ul, varnames, so);
	        				}
	        				if (iright != null && iright.hasNext()) {
	        					current = iright.next();
	        					if (rhs instanceof PrologCut) {
	        						cut();
	        					}
	        					if (rhs instanceof LogExpr) {
	        						if (((LogExpr) rhs).contains_cut()) {
	        							cut();
	        						}
	        					}
	        				}
	        			}
	        			public void remove() {}
	        			
	        			public String toString() {
	        				String s = "Iterator for :" + LogExpr.this + " -- " + un + "\n";
	        				s += "Current Unifier: ";
	        				s += current;
	        				return s;
	        			}
	        		};
	            
	        	case or:
	            ileft = lhs.logicalConsequence(eb, rb, un, varnames, so);
	            final Iterator<Unifier> iright = rhs.logicalConsequence(eb, rb, un,varnames, so);
	            return new Iterator<Unifier>() {
	                Unifier current = null;
	                public boolean hasNext() {
	                    if (current == null) get();
	                    return current != null;
	                }
	                public Unifier next() {
	                    if (current == null) get();
	                    Unifier a = current;
	                    get();
	                    return a;
	                }
	                private void get() {
	                    current = null;
	                    if (ileft.hasNext()) {
	                        current = ileft.next();
	                    } else if (iright.hasNext()) {
	                        current = iright.next();
	                    }
	                }
	                public void remove() {}
	            };
	        	}
    	    } catch (Exception e) {
        		String slhs = "is null";
        		if (lhs != null) {
        			Iterator<Unifier> i = lhs.logicalConsequence(eb, rb, un, varnames, so);
        			if (i != null) {
        				slhs = "";
        				while (i.hasNext()) {
        					slhs += i.next().toString()+", ";
        				}
        			} else {
        				slhs = "iterator is null";
        			}
        		} 
        		String srhs = "is null";
        		if (lhs != null) {
        			Iterator<Unifier> i = rhs.logicalConsequence(eb, rb, un, varnames, so);
        			if (i != null) {
        				srhs = "";
        				while (i.hasNext()) {
        					srhs += i.next().toString()+", ";
        				}
        			} else {
        				srhs = "iterator is null";
        			}
        		} 
        		
        		AJPFLogger.severe("ail.syntax.LogExpr", "Error evaluating expression "+this+". \nlhs elements="+slhs+". \nrhs elements="+srhs);
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
	
	/** make a hard copy of the terms */
    @Override
	public LogExpr clone() {
		// do not call constructor with term parameter!
		LogExpr t = new LogExpr();
		if (lhs != null) {
			t.lhs = (LogicalFormula) lhs.clone();
		}

		t.op = this.op;
		
		if (rhs != null) {
			t.rhs = (LogicalFormula) rhs.clone();
		}
		return t;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
    @Override
	public boolean equals(Object t) {
		if (t != null && t instanceof LogExpr) {
			LogExpr eprt = (LogExpr)t;
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
	 * @see java.lang.Object#hashCode()
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
	public LogicalOp getOp() {
		return op;
	}
	
	/** gets the LHS of this Expression */
	public LogicalFormula getLHS() {
		return lhs;
	}
	
	/** gets the RHS of this Expression */
	public LogicalFormula getRHS() {
		return rhs;
	}
	
	/**
	 * Is this a unary expression
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
     * @see ail.syntax.Unifiable#getVarNames()
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
     * @see ail.syntax.Unifiable#renameVar(java.lang.String, java.lang.String)
     */
	@Override
    public void renameVar(String oldname, String newname) {
    	getRHS().renameVar(oldname, newname);
    	if (!isUnary()) {
    		getLHS().renameVar(oldname, newname);
    	}
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Unifiable#standardise_apart(ail.syntax.Unifiable, ail.syntax.Unifier)
     */
    @Override
    public void standardise_apart(Unifiable t, Unifier u, Set<String> varnames) {
    	DefaultAILStructure.standardise_apart(t, u, varnames, this);
    } 
    
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Unifiable#unifies(ail.syntax.Unifiable, ail.syntax.Unifier)
     */
	@Override
    public boolean unifies(Unifiable t, Unifier u) {
    	if (t instanceof LogExpr) {
    		LogExpr le = (LogExpr) t;
    		if (le.getOp().equals(getOp())) {
    			boolean result = getRHS().unifies(le.getRHS(), u);
    			if (!isUnary() && result) {
    				result = getLHS().unifies(le.getLHS(), u);
    				return result;
    			}
    		}
    		return false;
    	} else {
    		return false;
    	}
    }
    
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#match(ail.syntax.Unifiable, ail.syntax.Unifier)
	 */
	@Override
    public boolean match(Unifiable t, Unifier u) {
    	if (t instanceof LogExpr) {
    		LogExpr le = (LogExpr) t;
    		if (le.getOp().equals(getOp())) {
    			boolean result = getRHS().match(le.getRHS(), u);
    			if (!isUnary() && result) {
    				result = getLHS().match(le.getLHS(), u);
    				return result;
    			}
    		}
    		return false;
    	} else {
    		return false;
    	}
    }

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#matchNG(ail.syntax.Unifiable, ail.syntax.Unifier)
	 */
	@Override
    public boolean matchNG(Unifiable t, Unifier u) {
    	if (t instanceof LogExpr) {
    		LogExpr le = (LogExpr) t;
    		if (le.getOp().equals(getOp())) {
    			boolean result = getRHS().matchNG(le.getRHS(), u);
    			if (!isUnary() && result) {
    				result = getLHS().matchNG(le.getLHS(), u);
    				return result;
    			}
    		}
    		return false;
    	} else {
    		return false;
    	}
    }
        
     
    /*
     * (non-Javadoc)
     * @see ail.syntax.Unifiable#isGround()
     */
	@Override
    public boolean isGround() {
    	if (lhs == null) {
    		return rhs.isGround();
    	} else {
    		return lhs.isGround() && rhs.isGround();
    	}
    }
    

    /*
     * (non-Javadoc)
     * @see ail.syntax.Unifiable#apply(ail.syntax.Unifier)
     */
	@Override
	public boolean apply(Unifier theta) {
		if (getRHS().apply(theta)) {
			if (getLHS() != null) {
				return getLHS().apply(theta);
			}
			return true;
		} 
		
		return false;
	}
	
	@Override
	public Unifiable substitute(Unifiable term, Unifiable subst) {
		if (equals(term)) return subst;
		
		return new LogExpr((LogicalFormula) getLHS().substitute(term, subst), getOp(), (LogicalFormula) getRHS().substitute(term, subst));
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#makeVarsAnnon()
	 */
	@Override
	public void makeVarsAnnon() {
		if (getLHS() != null) {
			getLHS().makeVarsAnnon();
		}
		getRHS().makeVarsAnnon();
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#strip_varterm()
	 */
	@Override
	public Unifiable strip_varterm() {
		if (getLHS() != null) {
			return new LogExpr((LogicalFormula) getLHS().strip_varterm(), getOp(), (LogicalFormula) getRHS().strip_varterm());
		} else {
			return new LogExpr(getOp(), (LogicalFormula) getRHS().strip_varterm());				
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#resolveVarsClusters()
	 */
	@Override
	public Unifiable resolveVarsClusters() {
		if (getLHS() != null) {
			return new LogExpr((LogicalFormula) getLHS().resolveVarsClusters(), getOp(), (LogicalFormula) getRHS().resolveVarsClusters());
		} else {
			return new LogExpr(getOp(), (LogicalFormula) getRHS().resolveVarsClusters());				
		}
	}
	
	/**
	 * Evaluation of this expression has not yet passed a cut.
	 * @return
	 */
	public boolean uncut() {
		return above_a_passed_cut == false;
	}
	
	/**
	 * Evaluation of this expression has now passed a cut.
	 */
	public void cut() {
		above_a_passed_cut = true;
	}
	
	/**
	 * Is this logical expression a conjunction that contains a Prolog Cut?
	 * @return
	 */
	public boolean contains_cut() {		
		if (this.getOp() == LogicalOp.none) {
			return rhs instanceof PrologCut;
		}

			
		if (this.getOp() == LogicalOp.and) {
			if (lhs instanceof PrologCut || rhs instanceof PrologCut) {
				return true;
			}

			if (lhs instanceof LogExpr && ((LogExpr) lhs).contains_cut()) {
				return true;
			}

			if (rhs instanceof LogExpr && ((LogExpr) rhs).contains_cut()) {
				return true;
			}
		}
		
		return false;
	}




}
