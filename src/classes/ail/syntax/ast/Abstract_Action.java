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

import gov.nasa.jpf.annotation.FilterField;
import gov.nasa.jpf.vm.MJIEnv;
//import gov.nasa.jpf.jvm.abstraction.filter.FilterField;
import ail.syntax.Predicate;
import ail.syntax.Action;

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
 * An abstract class for AIL Actions.  
 * 
 * @author louiseadennis
 *
 */
public class Abstract_Action extends Abstract_Predicate {
	/**
	 * Normally actions are just predicates, but we may want special actions
	 * with particular content.  AIL defines some here.
	 */
	@FilterField
	public final static int normalAction = 0;
	@FilterField
	public final static int sendAction = 1;
	
	/**
	 * By default an action is a normalAction (i.e. a term).
	 */
	@FilterField
	public int actiontype = normalAction;
	

	/**
	 * Create an action from a String.
	 * 
	 * @param s the string.
	 */
	public Abstract_Action(String s) {
		super(s);
	}
	
	/**
	 * Create an action from a string and an action type.
	 * 
	 * @param s The string represented the action predicate.
	 * @param n The type of the action.
	 */
	public Abstract_Action(String s, int n) {
		super(s);
		actiontype = n;
	}
	
	/**
	 * Create an Action from a predicate and an action type.
	 * @param s
	 * @param i
	 */
	public Abstract_Action(Abstract_Predicate s, int i) {
		setFunctor(s.getFunctor());
		setTerms(s.getTerms());
		actiontype = i;
	}
	
	
	public Abstract_Action(Abstract_Predicate dp) {
		this(dp, normalAction);
	}

	/**
	 * Getter method for the action type.
	 * 
	 * @return the type of the action.
	 */
	public int getActionType() {
		return actiontype;
	}
	
	/**
	 * Setter for the actiontype.  Protected so the type can
	 * only be set by sub-classes.
	 * 
	 * @param i the new action type.
	 */
	protected void setActionType(int i) {
		actiontype = i;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_Predicate#toMCAPL()
	 */
	public Action toMCAPL() {
		Predicate s = super.toMCAPL();
		Action a = new Action(s, getActionType());
		return a;
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_Predicate#newJPFObject(gov.nasa.jpf.jvm.MJIEnv)
	 */
	public int newJPFObject(MJIEnv env) {
		int objref = env.newObject("ail.syntax.ast.Abstract_Action");
		JPFFields(objref, env);
		return objref;
	}
	
	protected void JPFFields(int objref, MJIEnv env) {
		String functor = getFunctor();
		if (strings.containsKey(functor)) {
			try {
				env.getStringObject(strings.get(functor));
				env.setReferenceField(objref, "functor", strings.get(functor));
			} catch (Exception e) {
				int stringref = env.newString(functor);
				strings.put(functor, stringref);
				env.setReferenceField(objref, "functor", stringref);
			}
		} else {
			int stringref = env.newString(functor);
			strings.put(functor, stringref);
			env.setReferenceField(objref, "functor", stringref);
		}
		env.setReferenceField(objref, "terms", newJPFTermArray(env));
		env.setIntField(objref, "actiontype", actiontype);
		
	}

}
