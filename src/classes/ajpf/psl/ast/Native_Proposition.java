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

import gov.nasa.jpf.JPF;
import gov.nasa.jpf.vm.ClassInfo;
import gov.nasa.jpf.vm.ClassLoaderInfo;
import gov.nasa.jpf.vm.ElementInfo;
import gov.nasa.jpf.vm.VM;
import gov.nasa.jpf.vm.Heap;
import gov.nasa.jpf.vm.ThreadInfo;

import ajpf.psl.Proposition;

/**
 * Default class for properties which are proposition.
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
		boolean b = ei.getBooleanField("truth_value");
		log.fine("Returning " + b + " for " + objref);
		return (b);
	}

	public int createInJPF(VM jvm) {
		vm = jvm;
		Heap heap = vm.getHeap();
		ThreadInfo ti = vm.getCurrentThread();
		ClassInfo ci = ClassLoaderInfo.getCurrentClassLoader().getResolvedClassInfo(getEquivalentJPFClass());
		objref = heap.newObject(ci, ti).getObjectRef();
		return objref;
	}
	
	public abstract String getEquivalentJPFClass();
	
}
