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
import java.util.Iterator;
import java.util.List;

import ail.semantics.AILAgent;
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
	public enum LogicalOp { 
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
    public Iterator<Unifier> logicalConsequence(final AILAgent ag, Unifier un) {
        try {
	        final Iterator<Unifier> ileft;
	        switch (op) {
	        
	        	case not:
	        		if (!rhs.logicalConsequence(ag,un).hasNext()) {
	        			return createUnifIterator(un);
	        		}
	        		break;
	        	case none:
	        		return rhs.logicalConsequence(ag, un);
	        
	        	case and:
	        		ileft = lhs.logicalConsequence(ag,un);
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
	        				while ((iright == null || !iright.hasNext()) && ileft.hasNext()) {
	        					Unifier ul = ileft.next();
	        					iright = rhs.logicalConsequence(ag, ul);
	        				}
	        				if (iright != null && iright.hasNext()) {
	        					current = iright.next();	 
	        				}
	        			}
	        			public void remove() {}
	        		};
	            
	        	case or:
	            ileft = lhs.logicalConsequence(ag,un);
	            final Iterator<Unifier> iright = rhs.logicalConsequence(ag,un);
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
        			Iterator<Unifier> i = lhs.logicalConsequence(ag,un);
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
        			Iterator<Unifier> i = rhs.logicalConsequence(ag,un);
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
    public String toString() {
		if (lhs == null) {
			return op+"("+rhs+")";
		} else {
			return "("+lhs+op+rhs+")";
		}
	}
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Unifiable#getVarNames()
     */
    public List<String> getVarNames() {
    	List<String> varnames = getRHS().getVarNames();
    	if (!isUnary()) {
    		varnames.addAll(getLHS().getVarNames());
    	}
    	return varnames;
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Unifiable#renameVar(java.lang.String, java.lang.String)
     */
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
    public void standardise_apart(Unifiable t, Unifier u) {
    	List<String> tvarnames = t.getVarNames();
    	List<String> myvarnames = getVarNames();
    	ArrayList<String> replacednames = new ArrayList<String>();
    	ArrayList<String> newnames = new ArrayList<String>();
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
     * @see ail.syntax.Unifiable#isRule()
     */
    public boolean isRule() {
    	return false;
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Unifiable#unifies(ail.syntax.Unifiable, ail.syntax.Unifier)
     */
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
     * @see ail.syntax.Unifiable#unifies(ail.syntax.Unifiable, ail.syntax.Unifier)
     */
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
     * @see ail.syntax.Unifiable#unifies(ail.syntax.Unifiable, ail.syntax.Unifier)
     */
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
     * @see ail.syntax.LogicalFormula#toTerm()
     */
    public Term toTerm() {
    	switch (op) {
    	case none:
    		return getRHS().toTerm();
    	case not:
    		Predicate s = new Predicate("not");
    		s.addTerm(getRHS().toTerm());
    		return s;
    	case and:
    		Predicate s1 = new Predicate("and");
    		s1.addTerm(getLHS().toTerm());
    		s1.addTerm(getRHS().toTerm());
    		return s1;
    	case or:
    		Predicate s2 = new Predicate("or");
    		s2.addTerm(getLHS().toTerm());
    		s2.addTerm(getRHS().toTerm());
    		return s2;
    	}
    	
    	return (new Predicate("error"));
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.LogicalFormula#getPosTerms()
     */
    public ArrayList<LogicalFormula> getPosTerms() {
    	ArrayList<LogicalFormula> posterms = new ArrayList<LogicalFormula>();
    	switch (op) {
    		case none:
    			posterms.add(getRHS());
    			return posterms;
    		case not:
    			return posterms;
    		case and:
    			posterms.addAll(getLHS().getPosTerms());
    			posterms.addAll(getRHS().getPosTerms());
    			return posterms;
    		case or:
    			// Safer to return none than too many
    			return posterms;   			
    	}
    	return posterms;
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Unifiable#isGround()
     */
    public boolean isGround() {
    	if (lhs == null) {
    		return rhs.isGround();
    	} else {
    		return lhs.isGround() && rhs.isGround();
    	}
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.LogicalFormula#conjuncts()
     */
	public List<LogicalFormula> conjuncts() {
		ArrayList<LogicalFormula> gs = new ArrayList<LogicalFormula>();
		switch (getOp()) {
			case and :
				gs.addAll(getLHS().conjuncts());
				gs.addAll(getRHS().conjuncts());
				return gs;
			case none:
				gs.addAll(getRHS().conjuncts());
				return gs;
			default:
				gs.add(this);
				return gs;
		}
			
	}



}
