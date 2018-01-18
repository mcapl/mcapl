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

import ail.semantics.AILAgent;
import ail.syntax.Goal;
import ail.syntax.StringTerm;

import gov.nasa.jpf.annotation.FilterField;
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
 * A class for MCAPL Goals.  These are literals plus a goal type.
 * 
 * @author louiseadennis
 *
 */
public class Abstract_Goal extends Abstract_Pred implements Abstract_GuardAtom {
	/**
	 * The four types of goal: achieve, test, perform and maintain.
	 */
	@FilterField
	public final static int achieveGoal = 0;
	@FilterField
	public final static int testGoal = 1;
	@FilterField
	public final static int performGoal = 2;
	@FilterField
	public final static int maintainGoal = 3;
		
	/**
	 * By default a goal is an achieve goal.
	 */
	private int goaltype = achieveGoal;
	
	/**
	 * By default there is only one goal base.
	 * 
	 */
	protected Abstract_StringTerm goalbase = new Abstract_StringTermImpl(AILAgent.AILdefaultGBname);
	
	/**
	 * This goal is a variable.
	 */
	private boolean isVariable = false;
	
	/**
	 * Construct from a literal and a goal type.
	 * @param l
	 * @param i
	 */
	public Abstract_Goal(Abstract_Predicate l, int i) {
		if (l instanceof Abstract_VarTerm) {
			isVariable = true;
		}
		setFunctor(l.getFunctor());
		setTerms(l.getTerms());
		goaltype = i;
	}
		
	/**
	 * Construct from a literal and a goal type.
	 * @param l
	 * @param i
	 */
	public Abstract_Goal(Abstract_Literal l, int i) {
		if (l instanceof Abstract_VarTerm) {
			isVariable = true;
		}
		setFunctor(l.getFunctor());
		setTerms(l.getTerms());
		goaltype = i;
	}
	/**
	 * Constructor.
	 * @param g
	 */
	public Abstract_Goal(Abstract_Goal g) {
		goaltype = g.getGoalType();
		goalbase = g.getGoalBase();
		isVariable = g.isVariable();
		setFunctor(g.getFunctor());
		setTerms(g.getTerms());
	}
	
	/**
	 * Getter method for the goal type.
	 * 
	 * @return the type of the goal.
	 */
	public int getGoalType() {
		return goaltype;
	}
	
	/**
	 * Getter method for the goal base.
	 * @return
	 */
	public Abstract_StringTerm getGoalBase() {
		return goalbase;
	}
	
	/**
	 * Setter method for the Goalbase.
	 * @param i
	 */
	public void setGoalBase(String i) {
		goalbase = new Abstract_StringTermImpl(i);
	}
	
	/**
	 * Set the goal base.
	 * @param i
	 */
	public void setGoalBase(Abstract_StringTerm i) {
		goalbase = i;
	}
	
	/**
	 * Represent as a string.
	 */
	@Override
	public String toString() {
		StringBuilder s1 = new StringBuilder("_");
		s1.append(typeString());
		s1.append(super.toString());
		s1.append("(");
		s1.append(getGoalBase().toString());
		s1.append(")");
		String s = s1.toString();
		return (s);
	}
	
	/**
	 * Generate a string for the goal type.
	 * @return a string representing the goal type.
	 */
	public String typeString() {
		if (getGoalType() == achieveGoal) {
			return "a";
		} else if (getGoalType() == performGoal) {
			return "p";
		} else if (getGoalType() == testGoal) {
			return "t";
		} else {
			return "m";
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_Pred#toMCAPL()
	 */
	@Override
	public Goal toMCAPL() {
		Goal g;
		if (isVariable()) {
			g = new Goal(super.getFunctor(), getGoalType());
		} else {
			g = new Goal(super.toMCAPL(), getGoalType());
		}
		g.setGoalBase((StringTerm) getGoalBase().toMCAPL());
		return g;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_Pred#newJPFObject(gov.nasa.jpf.jvm.MJIEnv)
	 */
	@Override
	public int newJPFObject(MJIEnv env) {
		int objref = env.newObject("ail.syntax.ast.Abstract_Goal");
		String functor = getFunctor();
		if (strings.containsKey(functor)) {
			env.setReferenceField(objref, "functor", strings.get(functor));
		} else {
			env.setReferenceField(objref, "functor", env.newString(getFunctor()));
		}
		env.setReferenceField(objref, "terms", newJPFTermArray(env));
		env.setIntField(objref, "goaltype", getGoalType());
		env.setReferenceField(objref, "goalbase", goalbase.newJPFObject(env));
		env.setBooleanField(objref, "isVariable", isVariable());
		return objref;
	}
	
	/**
	 * Is this a variable?
	 * @return
	 */
	public boolean isVariable() {
		return isVariable;
	}
	
	/**
	 * Goals should not be trivial.  I.e. the agent should not attempt to achieve true.
	 */
	@Override
	public boolean isTrivial() {
		return false;
	}
	
	/**
	 * Required by the interface, but this should not do anything here since the Category must be GOAL.
	 */
	public void setCategory(byte b) {};
	
}
