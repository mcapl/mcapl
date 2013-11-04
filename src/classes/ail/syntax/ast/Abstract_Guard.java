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

import gov.nasa.jpf.annotation.FilterField;
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
public class Abstract_Guard {

	/**
	 * A positive (to be believed) guard.
	 */
	@FilterField
	public static boolean GPos = true;
	/**
	 * A negative (to be disbelieved) guard.
	 */
	@FilterField
	public static boolean GNeg = false;

	/**
	 * The guard represented as  logical expression.
	 */
	public Abstract_LogExpr guardexpression;
	
	/**
	 * Guard is trivially true.
	 */
	public boolean istrivial = true;
	
	/**
	 * Constructs an empty guard.
	 *
	 */
	public Abstract_Guard() {
	}
	
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
	public Abstract_Guard(Abstract_GuardAtom g, boolean tf) {
		add(g, tf);
	}
	
	/**
	 * Construct the guard from a logical expression.
	 * @param l
	 * @param b
	 */
	public Abstract_Guard(Abstract_LogExpr l, boolean b) {
		istrivial = b;
		guardexpression = l;
	}
	
	/**
	 * Get the logical expression for the guard.
	 * @return
	 */
	public Abstract_LogExpr getGuardExpression() {
		return guardexpression;
	}
	
	/**
	 * Set the logical expression for the guard.
	 * @param l
	 */
	public void setGuardExpression(Abstract_LogExpr l) {
		guardexpression = l;
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
	
	/**
	 * Add a GBelief to the guard with a flag showing whether or not it should be
	 * believed or disbelieved for the guard to be true.
	 * 
	 * @param gb The GBelief.
	 * @param b Flag indiciatin whether gb should be believed or disbelieved.
	 * @return
	 */
	public boolean add(Abstract_GuardAtom gb, boolean b) {
  
		if (isTrivial()) {
			if (b) {
				if (!gb.isTrivial()) {
					istrivial = false;
				}
			} else {
				istrivial = false;
			}
		}

		if (guardexpression == null) {
			if (b) {
				guardexpression = new Abstract_LogExpr(Abstract_LogExpr.none, gb);
			} else {
				guardexpression = new Abstract_LogExpr(Abstract_LogExpr.not, gb);
			}
		} else {
			if (b) {
				if (! isTrivial()) {
					guardexpression = new Abstract_LogExpr(guardexpression, Abstract_LogExpr.and, gb);
				}
			} else {
				if (! isTrivial()) {
					guardexpression = new Abstract_LogExpr(guardexpression, Abstract_LogExpr.and, new Abstract_LogExpr(Abstract_LogExpr.not, gb));
				}
			}
		}

		return true;
	}

	/*
	 * 	    (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return guardexpression.toString();
	}

	    
	/**
	 * Succeeds if the Guard is trivial (ie., contains the belief True).
	 * 
	 * @return whether the guard contains the true belief.
	 */
	public boolean isTrivial() {
		return istrivial;
	}
	    
	/**
	 * Transform this to a concrete guard.
	 * @return
	 */
	public Guard toMCAPL() {
		return new Guard(guardexpression.toMCAPL(), istrivial);
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
		env.setReferenceField(objref, "guardexpression", guardexpression.newJPFObject(env));
		env.setBooleanField(objref, "istrivial", istrivial);
		return objref;
	}

}
