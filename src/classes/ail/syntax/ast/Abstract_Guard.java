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

import ail.syntax.Guard;
import ail.util.AILexception;
import ajpf.util.AJPFLogger;
import gov.nasa.jpf.vm.ClassInfo;
import gov.nasa.jpf.vm.ClassLoaderInfo;
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
 * AIL Guards.  It's easiest to think of these as sets of literals to be checked 
 * against beliefs and goals etc.
 * 
 * @author lad
 *
 */
public class Abstract_Guard implements Abstract_GLogicalFormula {
	static String logname = "ail.syntax.ast.Abstract_Guard";
	
	/**
	 * Possible operataors
	 */
	public static int none = 0;
	public static int not = 1;
	public static int and = 2;
	public static int or = 3;
	
	/**
	 * The LHS and RHS of the expression.
	 */
	protected  Abstract_GLogicalFormula lhs, rhs;
	/**
	 * The operator.
	 */
	protected  int      op = none;
	
	
	/**
	 * Constructs an empty guard.
	 *
	 */
	public Abstract_Guard() {}
	
	/**
	 * Construct a guard from a single GBelief.  This is presumed to be a 
	 * positive belief.
	 * 
	 * @param g The GBelief in the guard.
	 */
	public Abstract_Guard(Abstract_GuardAtom g) {
		add(g);
	}

	/**
	 * Constructs a guard from a GBelief and a flag showing whether or not it 
	 * is to be believed.
	 * 
	 * @param g The GBelief.
	 * @param tf A flag showing whether the belief is to be believed or not.
	 */
	public Abstract_Guard(Abstract_GLogicalFormula g, boolean tf) {
		add(g, tf);
	}
	
	public Abstract_Guard(int gop, Abstract_GLogicalFormula g) {
		op = gop;
		rhs = g;
	}
	
	public Abstract_Guard(Abstract_GLogicalFormula g2, int gop, Abstract_GLogicalFormula g) {
		lhs = g2;
		op = gop;
		rhs = g;
	}
	

	/**
	 * Add a new GBelief (conjunct) to the guard.  By default this is to be believed.
	 * 
	 * @param gb  The belief to be added.
	 * @return whether the belief was successfully added.
	 */
	public boolean add(Abstract_GuardAtom gb) {
		return add(gb, true);
	}
	
	public Abstract_GLogicalFormula getLHS() {
		return lhs;
	}
	
	public Abstract_GLogicalFormula getRHS() {
		return rhs;
	}
	
	public int getOp() {
		return op;
	}
	
	/**
     * Operators must also be converted to the relevant concrete class.
     * @return
     */
    Guard.GLogicalOp opToMCAPL() {
    	if (op == none) {
    		return Guard.GLogicalOp.none;
    	}
    	if (op == not) {
    		return Guard.GLogicalOp.not;
    	}
    	if (op == or) {
    		return Guard.GLogicalOp.or;
    	}
    	
    	return Guard.GLogicalOp.and;
    }

    /**
	 * Add a GBelief to the guard with a flag showing whether or not it should be
	 * believed or disbelieved for the guard to be true.
	 * 
	 * @param gb The GBelief.
	 * @param b Flag indiciatin whether gb should be believed or disbelieved.
	 * @return
	 */
	public boolean add(Abstract_GLogicalFormula gb, boolean b) {
		  
		if (isTrivial()) {
			if (b) {
				if (!gb.isTrivial()) {
					op = none;
					rhs = gb;
				}
			} else {
				if (!gb.isTrivial()) {
					op = not;
					rhs = gb;
				} else {
					/// This shouldn't happen but should there be a case anyway?
				}
			}
		} else {
			if (b) {
				if (op == none) {
					lhs = rhs;
					rhs = gb;
					op = and;
				} else {
					lhs = guard_clone();
					rhs = gb;
					op = and;
				}
			} else {
				Abstract_Guard ng = new Abstract_Guard(gb, false);
				if (op == none) {
					lhs = rhs;
					rhs = ng;
					op = and;
				} else {
					lhs = guard_clone();
					rhs = ng;
					op = and;
				}
			}
		}

		return true;
	}
	
	public void negate() {
		if (isTrivial()) {
			AJPFLogger.warning(logname, "Trying to negate trivial guard");
		} else {
			if (op == none) {
				op = not;
			} else if (op == not) {
				op = none;
			} else {
				rhs = new Abstract_Guard(lhs, op, rhs);
				op =  not;
				lhs = null;
			}
		}
	}
	
	/**
	 * Make a copy of this guard.
	 * @return
	 */
	private Abstract_Guard guard_clone() {
		Abstract_Guard gu = new Abstract_Guard();
		if (lhs != null) {
			gu.setLHS(lhs);
		}
		gu.setOP(op);
		gu.setRHS(rhs);
		return gu;
	}
	
	/**
	 * Setter for the RHS.
	 * @param lf
	 */
	private void setRHS(Abstract_GLogicalFormula lf) {
		rhs = lf;
	}

	/**
	 * Setter for the LHS.
	 * @param lf
	 */
	private void setLHS(Abstract_GLogicalFormula lf) {
		lhs = lf;
	}
	
	/**
	 * Setter for the operator.
	 * @param i
	 */
	private void setOP(int i) {
		op = i;
	}
	    
	/**
	 * Succeeds if the Guard is trivial (ie., contains the belief True).
	 * 
	 * @return whether the guard contains the true belief.
	 */
	public boolean isTrivial() {
		return (rhs == null);
	}
	    
	/**
	 * Transform this to a concrete guard.
	 * @return
	 */
	public Guard toMCAPL() {
		if (lhs == null) {
			if (rhs == null) {
				return new Guard();
			} else {
				return new Guard(opToMCAPL(), rhs.toMCAPL());
			}
		} else {
			return new Guard(lhs.toMCAPL(), opToMCAPL(), rhs.toMCAPL());
		}
	}
	    
	/**
	 * Replicate this in the JVM.
	 * @param env
	 * @return
	 */
	public int newJPFObject(MJIEnv env) {
		ClassInfo ci = ClassLoaderInfo.getCurrentClassLoader().getResolvedClassInfo("ail.syntax.ast.Abstract_Guard");
		if (env.requiresClinitExecution(ci)) {
			env.repeatInvocation();
			return 0;
		}
		int objref = env.newObject("ail.syntax.ast.Abstract_Guard");
		if (rhs != null) {
			env.setReferenceField(objref, "rhs", rhs.newJPFObject(env));
		}
		if (lhs != null) {
			env.setReferenceField(objref, "lhs", lhs.newJPFObject(env));
		}
		env.setIntField(objref, "op", op);
		return objref;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String s = "";
		if (op == none) {
			s = rhs.toString();
		} else if (op == not) {
			s = "not (" + rhs.toString() + ")";
		} else {
			s = lhs.toString() + " and " + rhs.toString();
		}
		
		return s;
	}

}
