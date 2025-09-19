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
import ail.syntax.PredicatewAnnotation;
import ail.syntax.Literal;

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
 * Abstract syntax class for literals.
 * 
 * @author louiseadennis
 */
public class Abstract_Literal extends Abstract_Pred {

	/**
	 * Some useful constants for positive and negative literals.
	 */
	@FilterField
	public static final boolean LPos   = true;
	/**
	 * Some useful constants for positive and negative literals.
	 */
	@FilterField
    public static final boolean LNeg   = false;
    
	   /**
     * The true and false literals.
     */
	@FilterField
    public static final Abstract_Literal LTrue  = new Abstract_Literal("true");
    /**
     * The true and false literals.
     */
	@FilterField
	public static final Abstract_Literal LFalse = new Abstract_Literal("false");
	
	/**
	 * Is this a positive or negative literal.
	 */
	private boolean type = Literal.LPos;
    
	/**
	 * Construct from a string.
	 * @param s
	 */
	public Abstract_Literal(String s) {
		super(s);
	}
	
	/**
	 * Constructore.
	 */
	public Abstract_Literal() {
		super();
	}
	
	/**
	 * Construct from a true/false type and a predicate.
	 * @param lType
	 * @param p
	 */
	public Abstract_Literal(boolean lType, Abstract_Pred p) {
		type = lType;
		setFunctor(p.getFunctor());
		setTerms(p.getTerms());
	}
	
	/**
	 * Construct from a pred - assume true.
	 * @param p
	 */
	public Abstract_Literal(Abstract_Predicate p) {
		this (Literal.LPos, new Abstract_Pred(p));
	}

	/**
	 * Set positive or negative.
	 * @param b
	 */
	public void setType(boolean b) {
		type = b;
	}
	
	/**
	 * Get positive or negative.
	 * @return
	 */
	public boolean getType() {
		return type;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_Pred#toMCAPL()
	 */
	public Literal toMCAPL() {
		PredicatewAnnotation s = super.toMCAPL();
		Literal l = new Literal(type, s);
		if (l.isGround()) {
			return GroundPredSets.check_add(l);
		}
		return l;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_Pred#clone()
	 */
	public Abstract_Literal clone() {
		Abstract_Pred p = super.clone();
		Abstract_Literal l = new Abstract_Literal(p);
		l.setType(getType());
		return l;
	}
	
	/**
	 * Set this as a negative literal.
	 * @param b
	 */
	public void setNegated(boolean b) {
		type = b;
	}
	
	/**
	 * Is this a negative literal?
	 * @return
	 */
	public boolean negated() {
		return (type == LNeg);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_Pred#newJPFObject(gov.nasa.jpf.jvm.MJIEnv)
	 */
	public int newJPFObject(MJIEnv env) {
		int ref = env.newObject("ail.syntax.ast.Abstract_Literal");
		String functor = getFunctor();
		if (strings.containsKey(functor)) {
			env.setReferenceField(ref, "functor", strings.get(functor));
		} else {
			int stringref = env.newString(functor);
			strings.put(functor, stringref);
			env.setReferenceField(ref, "functor", stringref);
		}
		env.setReferenceField(ref, "terms", newJPFTermArray(env));
		env.setBooleanField(ref, "type", getType());
		return ref;

	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		if (negated()) {
			s.append("~");
		}
		s.append(super.toString());
		return s.toString();
	}
}
