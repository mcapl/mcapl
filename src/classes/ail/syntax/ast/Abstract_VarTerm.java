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

import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.ClassInfo;
import gov.nasa.jpf.vm.ClassLoaderInfo;
import ail.syntax.Literal;
import ail.syntax.PredicatewAnnotation;
import ail.syntax.Term;
import ail.syntax.Unifier;
import ail.syntax.VarTerm;
import ail.syntax.VarsCluster;

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
 * Represents a variable Term: like X (starts with upper case). It may have a
 * value, afert {@link Unifier}.apply.
 * 
 * @author jomi
 */
public class Abstract_VarTerm extends Abstract_Literal 
	implements Abstract_NumberTerm, Abstract_ListTerm, Abstract_StringTerm, Comparable<Abstract_VarTerm> {

	/**
	 * Constructor.
	 * @param s
	 */
	public Abstract_VarTerm(String s) {
        super(s);
        if (s != null && Character.isLowerCase(s.charAt(0))) {
        	Exception e = new Exception("stack");
        	e.printStackTrace();
        }
    }
     
	/**
	 * Constructor.
	 */
	public Abstract_VarTerm() {
		super();
	}

    // -----------------------
    // StringTerm interface implementation
    // -----------------------
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_StringTerm#getString()
	 */
    public String getString() {
            return null;
    }
    
    // -----------------------
    // ListTerm interface implementation
    // -----------------------
    /*
     * (non-Javadoc)
     * @see ail.syntax.ast.Abstract_ListTerm#append(ail.syntax.ast.Abstract_Term)
     */
    public Abstract_ListTerm append(Abstract_Term t) {
    	return null;
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.ast.Abstract_ListTerm#addAll(java.util.ArrayList)
     */
    public void addAll(ArrayList<Abstract_Term> tl) {
    	
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.ast.Abstract_ListTerm#addHead(ail.syntax.ast.Abstract_Term)
     */
    public void addHead(Abstract_Term h) {
    	
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.ast.Abstract_ListTerm#addTail(ail.syntax.ast.Abstract_ListTerm)
     */
    public void addTail(Abstract_ListTerm h) {
    	
    }
    
    //---------------------------------------------
    // Conversion to concrete types and general JPF wrangling.
    //---------------------------------------------

    /*
     * (non-Javadoc)
     * @see ail.syntax.ast.Abstract_Literal#toMCAPL()
     */
	public VarTerm toMCAPL() {
		// PredicatewAnnotation s = super.toMCAPL();
		return new VarTerm(getFunctor());
	}
 
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_Literal#newJPFObject(gov.nasa.jpf.jvm.MJIEnv)
	 */
	public int newJPFObject(MJIEnv env) {
		ClassInfo ci = ClassLoaderInfo.getCurrentClassLoader().getResolvedClassInfo("ail.syntax.ast.Abstract_VarTerm");
		if (env.requiresClinitExecution(ci)) {
			env.repeatInvocation();
			return 0;
		}
		
		int ref = env.newObject("ail.syntax.ast.Abstract_VarTerm");
		String functor = getFunctor();
		if (Abstract_Predicate.strings.containsKey(functor)) {
			env.setReferenceField(ref, "functor", Abstract_Predicate.strings.get(functor));
		} else {
			int stringref = env.newString(functor);
			Abstract_Predicate.strings.put(functor, stringref);
			env.setReferenceField(ref, "functor", stringref);
		}
		env.setReferenceField(ref, "terms", newJPFTermArray(env));
		env.setBooleanField(ref, "type", getType());
		return ref;

	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_Predicate#apply(ail.syntax.Unifier)
	 */
    public Abstract_Term applyu(Abstract_Unifier u) {
    	Abstract_Term vl = u.get(this);
    	if (vl != null) {
    		return vl.applyu(u);
     	} else {
     		return this;
     	}
    }    
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.ast.Abstract_Predicate#unifies(ail.syntax.ast.Abstract_Term, ail.syntax.ast.Abstract_Unifier)
     */
    public void unifies(Abstract_Term t, Abstract_Unifier u) {
    	if (!t.equals(this)) {
    		u.put(this, t);
    	}
    }
    
    /*
     * (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(Abstract_VarTerm v) {
    	return getFunctor().compareTo(v.getFunctor());
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.ast.Abstract_ListTerm#isEmpty()
     */
    public boolean isEmpty() {
    	return false;
    }


}
