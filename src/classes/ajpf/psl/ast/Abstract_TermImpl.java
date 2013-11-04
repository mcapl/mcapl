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


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import ajpf.MCAPLcontroller;
import ajpf.MCAPLmas;
import ajpf.psl.MCAPLProperty;
import ajpf.util.VerifyMap;
import ajpf.psl.ast.Abstract_Formula;
import ajpf.psl.MCAPLPredicate;
import ajpf.psl.MCAPLTerm;

//import gov.nasa.jpf.jvm.abstraction.filter.FilterField;
import gov.nasa.jpf.annotation.FilterField;
import gov.nasa.jpf.vm.ClassInfo;
import gov.nasa.jpf.vm.ClassLoaderInfo;
import gov.nasa.jpf.vm.ElementInfo;
import gov.nasa.jpf.vm.Heap;
import gov.nasa.jpf.vm.VM;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.Types;

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
    
     
    public int getTermSize() {
    	return terms.length;
    }
    
    public void addTerm(Abstract_MCAPLTerm t) {
    	int newsize = terms.length + 1;
    	Abstract_MCAPLTerm[] newterms = new Abstract_MCAPLTerm[newsize];
    	for (int i = 0; i < terms.length; i++) {
    		newterms[i] = terms[i];
    	}
    	newterms[terms.length] = t;
    	terms = newterms;
    }
    
    public String getFunctor() {
    	return functor;
    }
    
    public void setFunctor(String s) {
    	functor = s;
    }
    
    public Abstract_MCAPLTerm[] getTerms() {
    	return terms;
    }
    
    
    public void setTerms(Abstract_MCAPLTerm[] tArray, int size) {
    	terms = tArray;
    }

    public Abstract_MCAPLTerm getTerm(int i) {
    	return terms[i];
    }
    
    public Abstract_TermImpl clone() {
    	Abstract_TermImpl s = new Abstract_TermImpl(getFunctor());
    	Abstract_MCAPLTerm[] tArray = new Abstract_MCAPLTerm[terms.length];
    	for (int i = 0; i < terms.length; i++) {
    		tArray[i] = terms[i].clone();
    	}
    	s.setTerms(tArray, terms.length);
    	return s;
    }
    
	public MCAPLPredicate toMCAPL() {
		MCAPLPredicate s = new MCAPLPredicate(functor);
		for (Abstract_MCAPLTerm t: terms) {
			s.addTerm((MCAPLTerm) t.toMCAPL());
		}
		return s;
	}
	
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
	    

}
