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

import ail.syntax.NumberTermImpl;
import ajpf.util.AJPFLogger;
import gov.nasa.jpf.vm.ClassInfo;
import gov.nasa.jpf.vm.ClassLoaderInfo;
import gov.nasa.jpf.vm.ElementInfo;
import gov.nasa.jpf.vm.Heap;
import gov.nasa.jpf.vm.VM;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.ThreadInfo;

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

/** Implements a term that represents a number */
public final class Abstract_NumberTermImpl implements Abstract_NumberTerm {

	/**
	 * The actual value
	 */
	private final double fValue;
	
	/**
	 * Constructor
	 */
	public Abstract_NumberTermImpl() {
		super();
		fValue = 0;
	}
	
	/**
	 * Construct from a string representing a number.
	 * @param sn
	 */
	public Abstract_NumberTermImpl(String sn) {
		double t = 0;
		try {
			t = Double.parseDouble(sn);
		} catch (Exception e) {
			AJPFLogger.severe("ail.syntax.ast.Abstract_NumberTermImpl", "Error setting number term value from "+sn);
		}
		fValue = t;
	}
	
	/**
	 * Construct from a double.
	 * @param vl
	 */
	public Abstract_NumberTermImpl(double vl) {
		fValue = vl;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Abstract_NumberTermImpl clone() {
		return this;
	}
	
    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
	public String toString() {
		return String.valueOf(fValue);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.ast.Abstract_MCAPLTerm#toMCAPL()
	 */
	public NumberTermImpl toMCAPL() {
		NumberTermImpl n = (NumberTermImpl) GroundPredSets.check_add(new NumberTermImpl(fValue));
		return n;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.ast.Abstract_MCAPLTerm#newJPFObject(gov.nasa.jpf.jvm.MJIEnv)
	 */
	public int newJPFObject(MJIEnv env) {
		int ref = env.newObject("ail.syntax.ast.Abstract_NumberTermImpl");
		env.setDoubleField(ref, "fValue", fValue);
		return ref;

	}

	public int createInJPF(VM vm) {
		Heap heap = vm.getHeap();
		ThreadInfo ti = vm.getCurrentThread();
		ClassInfo ci = ClassLoaderInfo.getCurrentClassLoader().getResolvedClassInfo("ail.syntax.ast.Abstract_NumberTermImpl");
		ElementInfo ei = heap.newObject(ci, ti);
		ei.setDoubleField("fValue", fValue);
		int objref = ei.getObjectRef();

		return objref;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_Term#getTerm(int)
	 */
	public Abstract_Term getTerm(int i) {
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_Term#unifies(ail.syntax.ast.Abstract_Term, ail.syntax.ast.Abstract_Unifier)
	 */
	public void unifies(Abstract_Term t, Abstract_Unifier u) {};
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_Term#apply(ail.syntax.ast.Abstract_Unifier)
	 */
	public Abstract_Term applyu(Abstract_Unifier u) {return this;};
    
	@Override
	public void addParams(ArrayList<Abstract_Term> tl) {
		System.err.println("WARNING: Do not add params to a NumberTerm");
		
	}
	
	public double getValue() {
		return fValue;
	}

}
