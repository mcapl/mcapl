// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
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
// License along with the AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ail.syntax.ast;

import java.util.ArrayList;

import ail.syntax.ArithExpr;
import ail.syntax.NumberTerm;
import ail.syntax.Term;
import ail.syntax.Unifiable;
import ail.syntax.Unifier;
import gov.nasa.jpf.annotation.FilterField;
import gov.nasa.jpf.vm.VM;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.Verify;

/**
 * Generic Description of Abstract Classes in AIL and AJPF
 * -------------------------------------------------------
 * 
 * We use "Abstract" versions of syntax items for all bits of state that we sometimes wish to store in the native
 * java VM as well in the JavaPathfinder VM.  In particular files are parsed into the native VM and then the relevant
 * initial state of the multi-agent system is reconstructed in the model-checking VM.  This is done to improve
 * efficiency of parsing (the native VM is faster).  We also represent properties for model checking in the native VM 
 * and, indeed the property automata is stored only in the native VM.  We used Abstract classes partly because less
 * computational content is needed for these objects in the native VM and so a smaller representation can be used
 * but also because specific support is needed for transferring information between the two virtual machines both
 * in terms of methods and in terms of the data types chosen for the various fields.  It was felt preferable to 
 * separate these things out from the classes used for the objects that determine the run time behaviour of a MAS.
 * 
 * Abstract classes all have a method (toMCAPL) for creating a class for the equivalent concrete object used
 * when executing the MAS.  They also have a method (newJPFObject) that will create an equivalent object in the 
 * model-checking virtual machine from one that is held in the native VM.  At the start of execution the agent
 * program is parsed into abstract classes in the native VM.  An equivalent structure is then created in the JVM
 * using calls to newJPFObject and this structure is then converted into the structures used for executing the MAS
 * by calls to toMCAPL.
 * 
 */


/**
 * Represents arithmetic expressions like "10 < 30".
 */
public class Abstract_ArithExpr implements Abstract_NumberTerm {
	
	public static int none = 0;
	public static int plus = 1;
	public static int minus = 2;
	public static int times = 3;
	public static int div = 4;
	public static int mod = 5;
	public static int pow = 6;
	public static int intdiv = 7;

	@FilterField
    private Abstract_NumberTerm    lhs, rhs;

	@FilterField
    private int  op     = none;

	/**
	 * Constructor
	 */
    private Abstract_ArithExpr() {
        super();
    }

    /**
     * Constructor for expressions of the form x op y.
     * @param t1
     * @param oper
     * @param t2
     */
    public Abstract_ArithExpr(Abstract_NumberTerm t1, int oper, Abstract_NumberTerm t2) {
        lhs = t1;
        op = oper;
        rhs = t2;
    }

    /** make a hard copy of the terms */
    public Abstract_ArithExpr clone() {
    	Abstract_ArithExpr t = new Abstract_ArithExpr();
    	if (lhs != null) {
    		t.lhs = (Abstract_NumberTerm) lhs.clone();
    	}

    	t.op = this.op;

    	if (rhs != null) {
    		t.rhs = (Abstract_NumberTerm) rhs.clone();
    	}
    	return t;
    }

     
    /** gets the Operation of this Expression */
    public int getOp() {
        return op;
    }

    /** gets the LHS of this Expression */
    public Abstract_NumberTerm getLHS() {
        return lhs;
    }

    /** gets the RHS of this Expression */
    public Abstract_NumberTerm getRHS() {
        return rhs;
    }

    @Override
    public String toString() {
    	if (rhs == null) {
    		return "(" + op + lhs + ")";
    	} else {
    		return "(" + lhs + op + rhs + ")";
    	}
    }
    

    /**
     * Need to aslo convert the operation to an equivalent operation in the inner class in the concrete
     * syntax.
     * @return
     */
    ArithExpr.ArithmeticOp opToMCAPL() {
	    	if (op == none) {
	    		return ArithExpr.ArithmeticOp.none;
	    	}
	    	if (op == plus) {
	    		return ArithExpr.ArithmeticOp.plus;
	    	}
	    	if (op == minus) {
	    		return ArithExpr.ArithmeticOp.minus;
	    	}
	    	if (op == times) {
	    		return ArithExpr.ArithmeticOp.times;
	    	}
	    	if (op == div) {
	    		return ArithExpr.ArithmeticOp.div;
	    	}
	    	if (op == pow) {
	    		return ArithExpr.ArithmeticOp.pow;
	    	}
	    	if (op == mod) {
	    		return ArithExpr.ArithmeticOp.mod;
	    	}
	    	return ArithExpr.ArithmeticOp.intdiv;
	    }

    /*
     * (non-Javadoc)
     * @see ajpf.psl.ast.Abstract_MCAPLTerm#toMCAPL()
     */
     public ArithExpr toMCAPL() {
		if (rhs == null) {
			ArithExpr ae = new ArithExpr(opToMCAPL(), (NumberTerm) lhs.toMCAPL());
			return ae;
		}	else {
			ArithExpr ae = new ArithExpr((NumberTerm) lhs.toMCAPL(), opToMCAPL(), (NumberTerm) rhs.toMCAPL());
			return ae;
		}
	}
	
     /*
      * (non-Javadoc)
      * @see ajpf.psl.ast.Abstract_MCAPLTerm#newJPFObject(gov.nasa.jpf.jvm.MJIEnv)
      */
	public int newJPFObject(MJIEnv env) {
		int ref = env.newObject("ail.syntax.ast.Abstract_ArithExpr");
		if (rhs != null) {
			env.setReferenceField(ref, "rhs", rhs.newJPFObject(env));
		}
		env.setReferenceField(ref, "lhs", lhs.newJPFObject(env));
		env.setIntField(ref, "op", op);
		return ref;

	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.ast.Abstract_MCAPLTerm#createInJPF(gov.nasa.jpf.jvm.JVM)
	 */
	public int createInJPF(VM vm) {
		Verify.log("ail.syntax.ast", Verify.WARNING, "Abstract_ArithExpr should not be being created from Listener");
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_Term#getTerm(int)
	 */
	public Abstract_Term getTerm(int i) {
		if (i == 0) {
			return lhs;
		} 
		if (i == 1) {
			return rhs;
		}
		
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_Term#apply(ail.syntax.ast.Abstract_Unifier)
	 */
	   public Abstract_Term applyu(Abstract_Unifier u) {
		   
		   return new Abstract_ArithExpr((Abstract_NumberTerm) getLHS().applyu(u), getOp(), (Abstract_NumberTerm) getRHS().applyu(u));
	    }

	   /*
	    * (non-Javadoc)
	    * @see ail.syntax.ast.Abstract_Term#unifies(ail.syntax.ast.Abstract_Term, ail.syntax.ast.Abstract_Unifier)
	    */
	    public void unifies(Abstract_Term t, Abstract_Unifier u) {
	    	Abstract_ArithExpr ae = (Abstract_ArithExpr) t;
	    	getLHS().unifies(ae.getLHS(), u);
	    	getRHS().unifies(ae.getRHS(), u);
	    }
	    
	  
	    public void addParams(ArrayList<Abstract_Term> tl) {
	    	System.err.println("WARNING: should not add parameters to an arithmetic expressions");
	    }


}
