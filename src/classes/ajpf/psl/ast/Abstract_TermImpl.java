// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of Agent JPF (AJPF)
// 
// AJPF is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// AJPF is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with AJPF; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ajpf.psl.ast;

import ajpf.psl.MCAPLPredicate;
import ajpf.psl.MCAPLTerm;

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
 * Represents a structure: a functor with <i>n</i> arguments, e.g.: val(10,x(3)). <i>n</i> can be
 * 0, so this class also represents atoms.
 */
public class Abstract_TermImpl implements Abstract_MCAPLTerm {
	
	private String functor; // immutable field- not if you want to rename variables!
    private Abstract_MCAPLTerm[] terms = new Abstract_MCAPLTerm[0];
    
    public Abstract_TermImpl(String functor) {
        this.functor = functor;
    }
    
    public Abstract_TermImpl() {};
    
    /**
     * The number of arguments to the term.
     * @return
     */
    public int getTermSize() {
    	return terms.length;
    }
    
    /**
     * Add an argument to the term.
     * @param t
     */
    public void addTerm(Abstract_MCAPLTerm t) {
    	int newsize = terms.length + 1;
    	Abstract_MCAPLTerm[] newterms = new Abstract_MCAPLTerm[newsize];
    	for (int i = 0; i < terms.length; i++) {
    		newterms[i] = terms[i];
    	}
    	newterms[terms.length] = t;
    	terms = newterms;
    }
    
    /**
     * Getter for the term functor.
     * @return
     */
    public String getFunctor() {
    	return functor;
    }
    
    /**
     * Setter for the term functor.
     * @param s
     */
    public void setFunctor(String s) {
    	functor = s;
    }
    
    /**
     * Return the term's arguments.
     * @return
     */
    public Abstract_MCAPLTerm[] getTerms() {
    	return terms;
    }
    
    /**
     * Set the term's arguments.
     * @param tArray
     * @param size
     */
    public void setTerms(Abstract_MCAPLTerm[] tArray, int size) {
    	terms = tArray;
    }

    /**
     * Get argument i.
     * @param i
     * @return
     */
    public Abstract_MCAPLTerm getTerm(int i) {
    	return terms[i];
    }
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    public Abstract_TermImpl clone() {
    	Abstract_TermImpl s = new Abstract_TermImpl(getFunctor());
    	Abstract_MCAPLTerm[] tArray = new Abstract_MCAPLTerm[terms.length];
    	for (int i = 0; i < terms.length; i++) {
    		tArray[i] = terms[i].clone();
    	}
    	s.setTerms(tArray, terms.length);
    	return s;
    }
    
    /*
     * (non-Javadoc)
     * @see ajpf.psl.ast.Abstract_MCAPLTerm#toMCAPL()
     */
	public MCAPLPredicate toMCAPL() {
		MCAPLPredicate s = new MCAPLPredicate(functor);
		for (Abstract_MCAPLTerm t: terms) {
			s.addTerm((MCAPLTerm) t.toMCAPL());
		}
		return s;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.ast.Abstract_MCAPLTerm#newJPFObject(gov.nasa.jpf.vm.MJIEnv)
	 */
	public int newJPFObject(MJIEnv env) {
		int ref = env.newObject("ajpf.psl.ast.Abstract_MCAPLPredicate");
		env.setReferenceField(ref, "functor", env.newString(functor));
		env.setReferenceField(ref, "terms", newJPFTermArray(env));
		return ref;

	}
	
	protected int newJPFTermArray(MJIEnv env) {
		int aRef = env.newObjectArray("ajpf.psl.MCAPLTerm" , terms.length);
		for (int index = 0; index < terms.length; index++) {
			env.setReferenceArrayElement(aRef, index, terms[index].newJPFObject(env));
		}
		return aRef;
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.ast.Abstract_MCAPLTerm#createInJPF(gov.nasa.jpf.vm.VM)
	 */
	public int createInJPF(VM vm) {
		Heap heap = vm.getHeap();
		ThreadInfo ti = vm.getCurrentThread();
		ClassInfo ci = ClassLoaderInfo.getCurrentClassLoader().getResolvedClassInfo("ajpf.psl.ast.Abstract_MCAPLPredicate");
		ElementInfo ei = heap.newObject(ci, ti);
		int objref = ei.getObjectRef();
		ei.setReferenceField("functor", heap.newString(functor, ti).getObjectRef());
  	    String elementClsName = Types.getTypeSignature("ajpf.psl.Abstract_MCAPLTerm", false);
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
	   
	   
	   @Override
	   public boolean equals(Object p) {
		   if (p instanceof Abstract_TermImpl) {
			   Abstract_TermImpl t = (Abstract_TermImpl) p;
			   if (t.functor.equals(functor)) {
				   for (int i = 0; i < terms.length; i++) {
					   if (!t.getTerms()[i].equals(terms[i])) {
						   return false;
					   }
				   }
				   return true;
			   }
		   }
		   
		   return false;
	   }
	    

}
