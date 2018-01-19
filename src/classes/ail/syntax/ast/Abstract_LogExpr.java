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

import gov.nasa.jpf.vm.ClassInfo;
import gov.nasa.jpf.vm.ClassLoaderInfo;
import gov.nasa.jpf.vm.MJIEnv;
import ail.syntax.LogExpr;
import ail.syntax.LogicalFormula;
import ail.syntax.Unifier;

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
 *  represents a logical formula with some logical operator ("&amp;",  "|", "not").
 */
public class Abstract_LogExpr implements Abstract_LogicalFormula {

	/**
	 * Possible operataors
	 */
	public static int none = 0;
	public static int not = 1;
	public static int and = 2;
	public static int or = 3;
	public static int forall = 4;

	/**
	 * Can have a right hand side and a left hand side
	 */
	private  Abstract_LogicalFormula lhs, rhs;
	
	/**
	 * By default there is no operator.
	 */
	private  int      op = none;
	
	/**
	 * Constructor.
	 */
	public Abstract_LogExpr() {
		super();
	}
	
	/**
	 * Construct from two logical expressions and an operator.
	 * @param f1
	 * @param oper
	 * @param f2
	 */
	public Abstract_LogExpr(Abstract_LogicalFormula f1, int oper, Abstract_LogicalFormula f2) {
		lhs = f1;
		op = oper;
		rhs = f2;
	}

	/**
	 * Construct from one logical expression and an operator.
	 * @param oper
	 * @param f
	 */
	public Abstract_LogExpr(int oper, Abstract_LogicalFormula f) {
		op = oper;
		rhs = f;
	}
	
	public Abstract_LogExpr(ArrayList<Abstract_LogicalFormula> tl) {
		this(none, lflist_to_lf(tl));
	}
	
	public static Abstract_LogExpr termlist_to_lf(ArrayList<Abstract_Term> tl) {
		if (tl.size() < 2) {
			if (tl.isEmpty()) {
				return new Abstract_LogExpr();
			} else {
				return new Abstract_LogExpr(none, (Abstract_Predicate) tl.get(0));
			}
		} else {
			Abstract_Term t = tl.remove(0);
			return new Abstract_LogExpr((Abstract_Predicate) t, and, termlist_to_lf(tl));
		}
	}
    
	public static Abstract_LogExpr lflist_to_lf(ArrayList<Abstract_LogicalFormula> tl) {
		if (tl.size() < 2) {
			if (tl.isEmpty()) {
				return new Abstract_LogExpr();
			} else {
				return new Abstract_LogExpr(none, tl.get(0));
			}
		} else {
			Abstract_LogicalFormula t = tl.remove(0);
			return new Abstract_LogExpr( t, and, lflist_to_lf(tl));
		}
	}

	/** gets the Operation of this Expression */
	public int getOp() {
		return op;
	}
	
	/** gets the LHS of this Expression */
	public Abstract_LogicalFormula getLHS() {
		return lhs;
	}
	
	/** gets the RHS of this Expression */
	public Abstract_LogicalFormula getRHS() {
		return rhs;
	}
	
	
    @Override
    public String toString() {
		if (lhs == null) {
			return op+"("+rhs+")";
		} else {
			return "("+lhs+op+rhs+")";
		}
	}
    
    /**
     * Operators must also be converted to the relevant concrete class.
     * @return
     */
    LogExpr.LogicalOp opToMCAPL() {
    	if (op == none) {
    		return LogExpr.LogicalOp.none;
    	}
    	if (op == not) {
    		return LogExpr.LogicalOp.not;
    	}
    	if (op == and) {
    		return LogExpr.LogicalOp.and;
    	}
    	return LogExpr.LogicalOp.or;
    }
    
  
    /*
     * (non-Javadoc)
     * @see ail.syntax.ast.Abstract_LogicalFormula#toMCAPL()
     */
	public LogExpr toMCAPL() {
		if (op == forall) {
			return new LogExpr(LogExpr.LogicalOp.not,
					new LogExpr((LogicalFormula) lhs.toMCAPL(), LogExpr.LogicalOp.and,
							new LogExpr(LogExpr.LogicalOp.not, (LogicalFormula) rhs.toMCAPL())
							)
					);
		}
		
		LogExpr ae = new LogExpr();
		if (rhs == null) {
			
		} else {
			if (lhs == null) {
				ae = new LogExpr(opToMCAPL(), (LogicalFormula) rhs.toMCAPL());
				return ae;
			}	else {
				ae = new LogExpr((LogicalFormula) lhs.toMCAPL(), opToMCAPL(), (LogicalFormula) rhs.toMCAPL());
				return ae;
			}
		}
		return ae;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_LogicalFormula#newJPFObject(gov.nasa.jpf.jvm.MJIEnv)
	 */
	public int newJPFObject(MJIEnv env) {
		ClassInfo ci = ClassLoaderInfo.getCurrentClassLoader().getResolvedClassInfo("ail.syntax.ast.Abstract_LogExpr");
		if (env.requiresClinitExecution(ci)) {
			env.repeatInvocation();
			return 0;
		}
		int ref = env.newObject("ail.syntax.ast.Abstract_LogExpr");
		if (rhs != null) {
			env.setReferenceField(ref, "rhs", rhs.newJPFObject(env));
		}
		if (lhs != null) {
			env.setReferenceField(ref, "lhs", lhs.newJPFObject(env));
		}
		env.setIntField(ref, "op", op);
		return ref;

	}
	
	public boolean isTrivial() {
		if (lhs == null && rhs == null) {
			return true;
		}
		return false;
	}
	
}
