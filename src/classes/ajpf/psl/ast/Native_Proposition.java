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

import java.util.logging.Logger;
import java.util.logging.Level;

import gov.nasa.jpf.JPF;
import gov.nasa.jpf.vm.ClassInfo;
import gov.nasa.jpf.vm.ClassLoaderInfo;
import gov.nasa.jpf.vm.ElementInfo;
import gov.nasa.jpf.vm.VM;
import gov.nasa.jpf.vm.Heap;
import gov.nasa.jpf.vm.ThreadInfo;

import ajpf.psl.Proposition;

/**
 * Default concrete class for properties which are propositions in the native VM.  These
 * maintain a link to propositions in the JPF VM.
 * 
 * @author louiseadennis
 *
 */
public abstract class Native_Proposition extends Proposition {
	protected static Logger log = JPF.getLogger("ajpf.psl.ast.Native_Proposition");
	int objref;
	
	VM vm;

	
	/**
	 * 
	 * 
	 * @return the truth of the formula.
	 */
	public boolean check() {
		ElementInfo ei = vm.getElementInfo(objref);
		if (log.getLevel().intValue() <= Level.FINE.intValue()) {
			log.fine("About to check proof of " + objref);
		}
		try {
			boolean b = ei.getBooleanField("truth_value");
			if (log.getLevel().intValue() <= Level.FINE.intValue()) {
				log.fine("Returning " + b + " for " + objref);
			}
			return (b);
		} catch (NullPointerException e) {
			log.warning("Native Proposition doesn't Exist returning true");
			return false;
		}
	}

	/**
	 * Create an equivalent to this class in the JPF JVM.  For reasons of simplicity
	 * this is the Abstract version of the proposition rather than the concrete one.
	 * @param jvm
	 * @return
	 */
	public int createInJPF(VM jvm) {
		vm = jvm;
		Heap heap = vm.getHeap();
		ThreadInfo ti = vm.getCurrentThread();
		ClassInfo ci = ClassLoaderInfo.getCurrentClassLoader().getResolvedClassInfo(getEquivalentJPFClass());
		objref = heap.newObject(ci, ti).getObjectRef();
		return objref;
	}
	
	/**
	 * What is the equivalent class for this proposition in the JPF JVM?
	 * @return
	 */
	public abstract String getEquivalentJPFClass();
	
}
