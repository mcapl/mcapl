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

import ajpf.psl.ast.Abstract_Formula;
import ail.syntax.Predicate;
import ail.syntax.Term;
import ail.syntax.Unifier;

import java.util.ArrayList;
import java.util.HashMap;

import gov.nasa.jpf.vm.ClassInfo;
import gov.nasa.jpf.vm.ClassLoaderInfo;
import gov.nasa.jpf.vm.ElementInfo;
import gov.nasa.jpf.vm.Heap;
import gov.nasa.jpf.vm.VM;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.Types;

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
 * Represents a Predicate in First-Order Logic.
 */
public class Abstract_Predicate implements Abstract_Term, Abstract_Formula, Abstract_LogicalFormula {
	public static HashMap<String,Integer> strings = new HashMap<String,Integer>();
	
	/**
	 * The functor.
	 */
	private String functor;
	/**
	 * The arguments.
	 */
    private Abstract_Term[] terms = new Abstract_Term[0];
    
    /**
     * Constructor/
     * @param functor
     */
    public Abstract_Predicate(String functor) {
        this.functor = functor;
    }
    
    /**
     * Constructor.
     */
    public Abstract_Predicate() {};
    
    /**
     * Setter for the arguments.
     * @param ts
     */
    public void setTerms(Abstract_Term[] ts) {
    	terms = ts;
    }
    
    public void setTerms(ArrayList<Abstract_Term> ts) {
    	terms = (Abstract_Term[]) ts.toArray();
    }
    

    
    /**
     * Get the number of arguments to this predicate.
     * @return
     */
    public int getTermSize() {
    	return terms.length;
    }
    
    /**
     * Add a new argument.
     * @param t
     */
    public void addTerm(Abstract_Term t) {
    	int newsize = terms.length + 1;
    	Abstract_Term[] newterms = new Abstract_Term[newsize];
    	for (int i = 0; i < terms.length; i++) {
    		newterms[i] = terms[i];
    	}
    	newterms[terms.length] = t;
    	terms = newterms;
    }
    
    /**
     * Getter for the functor.
     * @return
     */
    public String getFunctor() {
    	return functor;
    }
    
    /**
     * Setter for the functor.
     * @param s
     */
    public void setFunctor(String s) {
    	functor = s;
    }
    
    /**
     * Getter for the arguments.
     * @return
     */
    public Abstract_Term[] getTerms() {
    	return terms;
    }
    
    /**
     * 
     * @param tArray
     * @param size
     */
   // public void setTerms(Abstract_Term[] tArray, int size) {
   // 	terms = tArray;
   // }

    /**
     * Get argument i.
     */
    public Abstract_Term getTerm(int i) {
    	return terms[i];
    }
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    public Abstract_Predicate clone() {
    	Abstract_Predicate s = new Abstract_Predicate(getFunctor());
    	Abstract_Term[] tArray = new Abstract_Term[terms.length];
    	for (int i = 0; i < terms.length; i++) {
    		tArray[i] = terms[i].clone();
    	}
    	s.setTerms(tArray);
    	return s;
    }
    
    /*
     * (non-Javadoc)
     * @see ajpf.psl.ast.Abstract_MCAPLTerm#toMCAPL()
     */
    @Override
	public Predicate toMCAPL() {
		Predicate s = new Predicate(functor);
		for (Abstract_Term t: terms) {
			s.addTerm((Term) t.toMCAPL());
		}
		
		if (s.isGround()) {
			return GroundPredSets.check_add(s);
		}
		return s;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.ast.Abstract_MCAPLTerm#newJPFObject(gov.nasa.jpf.jvm.MJIEnv)
	 */
	public int newJPFObject(MJIEnv env) {
		int ref = env.newObject("ail.syntax.ast.Abstract_Predicate");
		if (strings.containsKey(functor)) {
			try {
				env.getStringObject(strings.get(functor));
				env.setReferenceField(ref, "functor", strings.get(functor));
			} catch (Exception e) {
				int stringref = env.newString(functor);
				strings.put(functor, stringref);
				env.setReferenceField(ref, "functor", stringref);
			}
		} else {
			int stringref = env.newString(functor);
			strings.put(functor, stringref);
			env.setReferenceField(ref, "functor", stringref);
		}
		env.setReferenceField(ref, "terms", newJPFTermArray(env));
		return ref;

	}
	
	/**
	 * Helper method to construct an array of terms in the JVM.
	 * @param env
	 * @return
	 */
	protected int newJPFTermArray(MJIEnv env) {
		int aRef = env.newObjectArray("ail.syntax.Term" , terms.length);
		for (int index = 0; index < terms.length; index++) {
			env.setReferenceArrayElement(aRef, index, terms[index].newJPFObject(env));
		}
		return aRef;
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.ast.Abstract_MCAPLTerm#createInJPF(gov.nasa.jpf.jvm.JVM)
	 */
	public int createInJPF(VM vm) {
		Heap heap = vm.getHeap();
		ThreadInfo ti = vm.getCurrentThread();
		ClassInfo ci = ClassLoaderInfo.getCurrentClassLoader().getResolvedClassInfo("ail.syntax.ast.Abstract_Predicate");
		ElementInfo ei = heap.newObject(ci, ti);
		int objref = ei.getObjectRef();
		ei.setReferenceField("functor", heap.newString(functor, ti).getObjectRef());
  	    String elementClsName = Types.getTypeSignature("ail.syntax.ast.Abstract_Term", false);
		ElementInfo array_ei = heap.newArray(elementClsName, terms.length, ti);
		int aRef = array_ei.getObjectRef();
		for (int index = 0; index < terms.length; index++) {
			array_ei.setReferenceElement(index, terms[index].createInJPF(vm));
		}
		ei.setReferenceField("terms", aRef);

		return objref;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (functor != null) {
			s.append(functor);
		}
		if (terms != null) {
			s.append("(");
			for (int i = 0; i < terms.length; i++) {
				s.append(terms[i].toString());
				if (i < terms.length - 1) {
					s.append(",");
				}
			}
			s.append(")");
		}
		return s.toString();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_Term#apply(ail.syntax.ast.Abstract_Unifier)
	 */
    public Abstract_Term applyu(Abstract_Unifier u) {
    	Abstract_Predicate p = new Abstract_Predicate(functor);
        final int tss = getTermSize();
        for (int i = 0; i < tss; i++) {
        	p.addTerm(getTerm(i).applyu(u)); 
        }
        return p;
     }

    /*
     * (non-Javadoc)
     * @see ail.syntax.ast.Abstract_Term#unifies(ail.syntax.ast.Abstract_Term, ail.syntax.ast.Abstract_Unifier)
     */
	 public void unifies(Abstract_Term t, Abstract_Unifier u) {
		 Abstract_Predicate p = (Abstract_Predicate) t;
	     final int tss = getTermSize();
		 for (int i = 0; i < tss; i++) {
			 getTerm(i).unifies(p.getTerm(i), u);
		 }
	 }

	@Override
	public void addParams(ArrayList<Abstract_Term> tl) {
		for (Abstract_Term t: tl) {
			addTerm(t);
		}
	}

}
