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

import ail.syntax.AILComparison;
import ail.syntax.Equation;
import ail.syntax.Is;
import ail.syntax.NumberTerm;
import ail.syntax.Predicate;
import ail.syntax.VarTerm;
import gov.nasa.jpf.vm.MJIEnv;

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
 *  An abstract version of an expression that may appear in a guard statement and represents some kind of equation 
 *  (i.e., an (in)equality).
 */
public class Abstract_Equation implements Abstract_GLogicalFormula, Abstract_LogicalFormula {

	/**
	 * What sort of equation is this.
	 */
	public static int none = 0;
	public static int less = 1;
	public static int equal = 2; 

	/**
	 * It has a left and right hand side.
	 */
	private  Abstract_NumberTerm lhs, rhs;
	private Abstract_Term term_rhs;
	/**
	 * By default an equation has no operator.
	 */
	private  int      op = none;
	
	/**
	 * Empty Constructor.
	 */
	public Abstract_Equation() {	}
	
	/**
	 * Construct and equation from two number terms and an operator.
	 * @param f1
	 * @param oper
	 * @param f2
	 */
	public Abstract_Equation(Abstract_NumberTerm f1, int oper, Abstract_Term f2) {
		lhs = f1;
		op = oper;
		if (f2 instanceof Abstract_NumberTerm) {
			rhs = (Abstract_NumberTerm) f2;
		} else {
			term_rhs = f2;
		}
	}
	
	/**
	 * The operator also needs to be translated to the concrete version from the concrete Equation classes
	 * inner class for operators.
	 * @return
	 */
	Equation.NumericOp opToMCAPL() {
		if (op == none) {
			return Equation.NumericOp.none;
		}
		if (op == less) {
			return Equation.NumericOp.less;
		}
		return Equation.NumericOp.equal;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_GBelief#toMCAPL()
	 */
	public AILComparison toMCAPL() {
		if (term_rhs == null ) {
			return new Equation((NumberTerm) lhs.toMCAPL(), opToMCAPL(), (NumberTerm) rhs.toMCAPL());
		} else {
			return new Is((VarTerm) lhs.toMCAPL(), (Predicate) term_rhs.toMCAPL());
		}
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_GBelief#newJPFObject(gov.nasa.jpf.jvm.MJIEnv)
	 */
	public int newJPFObject(MJIEnv env) {
		int objref = env.newObject("ail.syntax.ast.Abstract_Equation");
		env.setReferenceField(objref, "lhs", lhs.newJPFObject(env));
		if (rhs != null) {
			env.setReferenceField(objref, "rhs", rhs.newJPFObject(env));
		} else {
			env.setReferenceField(objref, "term_rhs", term_rhs.newJPFObject(env));
		}
		env.setIntField(objref, "op", op);
		return objref;
	}

	@Override
	public boolean isTrivial() {
		// TODO Auto-generated method stub
		return false;
	}

	

}
