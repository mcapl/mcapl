// ----------------------------------------------------------------------------
// Copyright (C) 2008-2015 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
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

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import ail.tracing.explanations.PredicateDescriptions;
import gov.nasa.jpf.annotation.FilterField;

/**
 * Represents and solve arithmetic expressions like "10 < 30".
 */
public class ArithExpr extends DefaultTerm implements NumberTerm {

	/**
	 * Inner enumeration for arithmetic operations.  All associated with relevant java method.
	 * @author lad
	 *
	 */
	public static enum ArithmeticOp {
        none {
            double eval(double x, double y) {
                return 0;
            }

            public String toString() {
                return "";
            }
        },
        plus {
            double eval(double x, double y) {
                return x + y;
            }

            public String toString() {
                return "+";
            }
        },
        minus {
            double eval(double x, double y) {
                return x - y;
            }

            public String toString() {
                return "-";
            }
        },
        times {
            double eval(double x, double y) {
                return x * y;
            }

            public String toString() {
                return "*";
            }
        },
        div {
            double eval(double x, double y) {
                return x / y;
            }

            public String toString() {
                return "/";
            }
        },
        mod {
            double eval(double x, double y) {
                return x % y;
            }

            public String toString() {
                return " mod ";
            }
        },
        pow {
            double eval(double x, double y) {
                return Math.pow(x, y);
            }

            public String toString() {
                return "**";
            }
        },
        intdiv {
            double eval(double x, double y) {
                return (int) x / (int) y;
            }

            public String toString() {
                return " div ";
            }
        };

        abstract double eval(double x, double y);
        
    }

	@FilterField
    private NumberTerm    lhs, rhs;

	@FilterField
    private ArithmeticOp  op     = ArithmeticOp.none;

	@FilterField
    private NumberTerm fValue = null; // value, when evaluated	

	/**
	 * Constructor.
	 */
    private ArithExpr() {
        super();
    }

    /**
     * Constructor.
     * @param t1
     * @param oper
     * @param t2
     */
    public ArithExpr(NumberTerm t1, ArithmeticOp oper, NumberTerm t2) {
        lhs = t1;
        op = oper;
        rhs = t2;
    }

    /**
     * Constructor.
     * @param oper
     * @param t1
     */
    public ArithExpr(ArithmeticOp oper, NumberTerm t1) {
        op = oper;
        lhs = t1;
    }

    /** returns true if the expression was already evaluated */
    public boolean isEvaluated() {
        return lhs == null;
    }
    
    /** 
     *  Set the value of this expression by calling solve(). After this method execution,
     *  the object behaviour is like a contant number.
     */
    public void evaluate() {
    	fValue = new NumberTermImpl(solve());
        lhs = null;
        rhs = null;
        super.resetHashCodeCache();
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.DefaultTerm#apply(ail.semantics.Unifier)
     */
    @Override
    public boolean apply(Unifier u) {
    	if (isEvaluated()) return false;
    	
        getLHS().apply(u);
        getRHS().apply(u);

        if (isGround()) {
        		evaluate();
        }
        
        return true;
    }
        
    /** make a hard copy of the terms */
    @Override
    public NumberTerm clone() {
        if (isEvaluated()) {
            return fValue;
        } else {
            ArithExpr t = new ArithExpr();
            if (lhs != null) {
                t.lhs = (NumberTerm) lhs.clone();
            }

            t.op = this.op;

            if (rhs != null) {
                t.rhs = (NumberTerm) rhs.clone();
            }
            return t;
        }
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object t) {
        if (t == null) 
            return false;
        if (isEvaluated()) {
            return fValue.equals(t);
        }
        if (t instanceof ArithExpr) {
            ArithExpr eprt = (ArithExpr) t;
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

    /**
     * Implementation of is this less, equal or greater than.
     * @param st
     * @return
     */
    public int compareTo(NumberTerm st) {
    	if (solve() > st.solve()) return 1;
    	if (solve() < st.solve()) return -1;
    	return 0;
     }

    /*
     * (non-Javadoc)
     * @see ail.syntax.DefaultTerm#calcHashCode()
     */
    @Override
    protected int calcHashCode() {
        if (isEvaluated())
            return fValue.hashCode();
        
        final int PRIME = 31;
        int code = PRIME * op.hashCode();
        if (lhs != null)
            code = PRIME * code + lhs.hashCode();
        if (rhs != null)
            code = PRIME * code + rhs.hashCode();
        return code;
    }
    
    
    
    /** gets the Operation of this Expression */
    public ArithmeticOp getOp() {
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

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.DefaultTerm#isNumeric()
	 */
    @Override
	public boolean isNumeric() {
		return true;
	}

    /*
     * (non-Javadoc)
     * @see ail.syntax.DefaultTerm#isArithExpr()
     */
    @Override
    public boolean isArithExpr() {
        return !isEvaluated();
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.DefaultTerm#isGround()
     */
    @Override
    public boolean isGround() {
        return isEvaluated() || (lhs.isGround() && rhs.isGround());
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.NumberTerm#solve()
     */
    @Override
    public double solve() {
        if (isEvaluated()) {
            // this expr already has a value
            return fValue.solve();
        }
        double l = lhs.solve();
        if (rhs == null && op == ArithmeticOp.minus) {
            return -l;
        } else if (rhs != null) {
            double r = rhs.solve();
            return op.eval(l, r);
        }
        return 0;
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.NumberTerm#eqcompareTo(ail.syntax.NumberTerm)
     */
    @Override
    public int eqcompareTo(NumberTerm st) {
    	if (solve() > st.solve()) return 1;
    	if (solve() < st.solve()) return -1;
    	return 0;
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Term#strip_varterm()
     */
    @Override
    public Term strip_varterm() {
    	if (isEvaluated()) {
    		return fValue;
    	} else {
    	if (rhs != null) {
    		return (new ArithExpr((NumberTerm) lhs.strip_varterm(), op, (NumberTerm) rhs.strip_varterm()));
    	} else {
    		return (new ArithExpr(op, (NumberTerm) lhs.strip_varterm()));
    	}
    	}
    }

    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Term#resolveVarsClusters()
     */
    @Override
    public Term resolveVarsClusters() {
    	if (isEvaluated()) {
    		return fValue;
    	} else {
    	if (rhs != null) {
    		return (new ArithExpr((NumberTerm) lhs.resolveVarsClusters(), op, (NumberTerm) rhs.resolveVarsClusters()));
    	} else {
    		return (new ArithExpr(op, (NumberTerm) lhs.resolveVarsClusters()));
    	}
    	}
    }

    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        if (isEvaluated()) {
            return fValue.toString();
        } else {
            if (rhs == null) {
                return "(" + op + lhs + ")";
            } else {
                return "(" + lhs + op + rhs + ")";
            }
        }
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Term#fullstring()
     */
    @Override
    public String fullstring() {
    	return toString();
    }
    
    @Override
    public String toString(PredicateDescriptions descriptions ) {
    	return toString();
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Unifiable#getVarNames()
     */
    @Override
    public Set<String> getVarNames() {
    	HashSet<String> varnames = new HashSet<String>();
    	if (! isEvaluated()) {
    		varnames.addAll(getLHS().getVarNames());
    		varnames.addAll(getRHS().getVarNames());
    	}
    	return varnames;
    }
        	
    /*
     * (non-Javadoc)
     * @see ail.syntax.Unifiable#renameVar(java.lang.String, java.lang.String)
     */
    public void renameVar(String oldname, String newname) {
    	if (! isEvaluated()) {
    		getLHS().renameVar(oldname, newname);
    		getRHS().renameVar(oldname, newname);
     	}
    }
    	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#makeVarsAnnon()
	 */
    @Override
    public void makeVarsAnnon() {
		   lhs.makeVarsAnnon();
		   rhs.makeVarsAnnon();
		   hashCodeCache = null;
    }

	@Override
	public Unifiable substitute(Unifiable term, Unifiable subst) {
		if (isEvaluated()) {
			if (equals(term)) {
				return subst;
			}
		}
    	
        ArithExpr new_arith =  new ArithExpr((NumberTerm) getLHS().substitute(term, subst), op, (NumberTerm) getRHS().substitute(term, subst));

        if (new_arith.isGround()) {
        		evaluate();
        }
        
        return new_arith;
	}	 


}
