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
import ail.syntax.GBelief;
import ail.syntax.StringTerm;
import ail.syntax.Goal;
import ail.syntax.Literal;

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
 * GBeliefs are beliefs that are "checked" e.g., by guards etc.  This is an abstract version of GBeliefs.
 * 
 * @author louiseadennis
 *
 */
public class Abstract_GBelief extends Abstract_Literal implements Abstract_GuardAtom {
	/**
	 * A Special type of Belief: True - for when there is no condition to be checked.
	 * This is the category used in most AIL Structures for Goals - hence the use
	 * of the referstoGoal() method to check this not a category check.
	 */
	@FilterField
    public static final byte 	  GTrue = 10;
		
	/**
	 * Is this a proper belief or trivial?
	 */
	public byte category = Abstract_BaseAILStructure.AILBel;
 	
	/**
	 * If an agent has several structures of a particular type.
	 * E.g. several belief bases, the one to be consulted for this
	 * GBelief is the one numbered DBnum.
	 * 
	 */
	private Abstract_StringTerm DBnum = new Abstract_StringTermImpl(AILAgent.AILdefaultBBname);

    /**
     * Construct a GBelief from a category - intended for construction of GTrue.
     * @param b
     */
    public Abstract_GBelief() {
    		super("true");
    		category = GTrue;
    }
    
    public Abstract_GBelief(Abstract_Literal l) {
    	super(l);
    }
    
    @Override
    public Abstract_GBelief clone() {
    	Abstract_Literal l = super.clone();
    	return new Abstract_GBelief(l);
    }
    
    /**
     * Construct a GBelief for Content/Context - maybe get rid of this?
     * @param b
     * @param s
     */
/*	public Abstract_GBelief(byte b, String s) {
		this(b);
		if (b == AILContent) {
			Abstract_Predicate incontent = new Abstract_Predicate("in_content");
			incontent.addTerm(new Abstract_Predicate(s));
			content = incontent;
		} else if (b == AILContext) {
			Abstract_Predicate incontext = new Abstract_Predicate("in_context");
			incontext.addTerm(new Abstract_Predicate(s));
			content = incontext;
		}
	} */

    
    /**
     * Setter for the DB num.
     * @param n
     */
    public void setDBnum(Abstract_StringTerm n) {
    	DBnum = n;
    }
    
    /**
     * Setter for DB num - converts from in to StringTerm.
     * @param n
     */
    public void setDBnum(int n) {
    	DBnum = new Abstract_StringTermImpl(Integer.toString(n));
    }
    
    /**
     * Getter for the DB num.
     * @return
     */
    public Abstract_StringTerm getDBnum() {
    	return DBnum;
    }
        
 	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (isTrivial()) {
			s.append("True");
		} else {
			s.append(super.toString());
			String num = getDBnum().toString();
			if (num.length() > 2) { // more than just quotes
				s.append("(").append(num).append(")");
			}
		}
		
		return s.toString();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_AILStructure#toMCAPL()
	 */
	public GBelief toMCAPL() {
		if (!isTrivial()) {
			GBelief g =  new GBelief(super.toMCAPL());
			g.setEB((StringTerm) DBnum.toMCAPL());
			return g;			
		} else {
			GBelief g = new GBelief();
			g.setEB((StringTerm) DBnum.toMCAPL());
			return g;
		}
	}
	
	/**
	 * What type of GBelief is this?
	 * @return
	 */
	public byte getCategory() {
		return category;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_AILStructure#newJPFObject(gov.nasa.jpf.jvm.MJIEnv)
	 */
	public int newJPFObject(MJIEnv env) {
		int ref = env.newObject("ail.syntax.ast.Abstract_GBelief");
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
		env.setByteField(ref,  "category", getCategory());
		env.setReferenceField(ref, "DBnum", DBnum.newJPFObject(env));
		return ref;
	}
	
	/**
     * Whether or not this is the distinguished "True" marker.
     * 
     * @return whether this is a trivially true belief.
     */
	public boolean isTrivial() {
		return (getCategory() == GTrue);
	}	
}
