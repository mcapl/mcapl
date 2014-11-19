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

import gov.nasa.jpf.vm.ClassInfo;
import gov.nasa.jpf.vm.ClassLoaderInfo;
import gov.nasa.jpf.vm.ElementInfo;
import gov.nasa.jpf.vm.Heap;
import gov.nasa.jpf.vm.VM;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.ThreadInfo;
import ajpf.util.AJPFLogger;
import ajpf.psl.MCAPLListTermImpl;

/**
 * An implementation of abstract lists of terms that can be used in AJPF supporting systems.
 * @author louiseadennis
 *
 */
public class Abstract_MCAPLListTermImpl implements Abstract_MCAPLListTerm {
	private String logname = "ajpf.psl.ast.Abstract_MCAPLListTerm";
	protected Abstract_MCAPLTerm head;
	protected Abstract_MCAPLListTerm tail;
	
	public Abstract_MCAPLListTermImpl(Abstract_MCAPLTerm h) {
		head = h;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Abstract_MCAPLListTermImpl clone() {
		return this;
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.ast.Abstract_MCAPLTerm#createInJPF(gov.nasa.jpf.jvm.JVM)
	 */
	public int createInJPF(VM vm) {
		Heap heap = vm.getHeap();
		ThreadInfo ti = vm.getCurrentThread();
		ClassInfo ci = ClassLoaderInfo.getCurrentClassLoader().getResolvedClassInfo("ajpf.psl.ast.Abstract_MCAPLListTermImpl");
		ElementInfo ei = heap.newObject(ci, ti);
		int objref = ei.getObjectRef();
		ei.setReferenceField("head", head.createInJPF(vm));
		if (tail != null) {
			ei.setReferenceField("tail", tail.createInJPF(vm));
		}

		return objref;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.ast.Abstract_MCAPLTerm#newJPFObject(gov.nasa.jpf.jvm.MJIEnv)
	 */
	public int newJPFObject(MJIEnv env) {
		int ref = env.newObject("ajpf.psl.ast.Abstract_MCAPLListTermImpl");
		env.setReferenceField(ref, "head", head.newJPFObject(env));
		if (tail != null) {
			env.setReferenceField(ref, "tail", tail.newJPFObject(env));
		}
		return ref;
	}



	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.ast.Abstract_MCAPLTerm#toMCAPL()
	 */
	public MCAPLListTermImpl toMCAPL() {
		MCAPLListTermImpl newlist = new MCAPLListTermImpl(head.toMCAPL());
		if (tail != null) {
			newlist.setTail((MCAPLListTermImpl) tail.toMCAPL());
		}
		return newlist;
	}
	

	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.ast.Abstract_MCAPLListTerm#addEnd(ajpf.psl.ast.Abstract_MCAPLListTerm)
	 */
	public void addEnd(Abstract_MCAPLTerm t) {
		if (tail == null) {
			tail = new Abstract_MCAPLListTermImpl(t);
		} else {
			tail.addEnd(t);
		}
		AJPFLogger.fine(logname, this.toString());

	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String s = new String("[");
		s += head.toString();
		if (tail != null) {
			s += tail.toString();
		}
		s += "]";
		return s;
	}

}
