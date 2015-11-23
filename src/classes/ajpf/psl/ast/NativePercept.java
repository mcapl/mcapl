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

import gov.nasa.jpf.vm.ElementInfo;
import gov.nasa.jpf.vm.VM;

/**
 * The formula P(phi) means phi is "true" in the environment.
 * 
 * @author louiseadennis
 * 
 */
public class NativePercept extends Native_Proposition {
	
	/**
	 * The formula that is the percept.
	 */
	private Abstract_Formula percept;
	
	
	/**
	 * Constructor.
	 * @param m the multi-agent system.
	 * @param f the formula to be checked.
	 */
	public NativePercept(Abstract_Formula f) {
		percept = f;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see mcapl.psl.Proposition#equals(mcapl.psl.MCAPLProperty)
	 */
	// As with last action this assume it will only ever be compared to percepts using the same mas.
	public boolean equals(Object p) {
		if (p instanceof NativePercept) {
			return (((NativePercept) p).getPercept().equals(percept));
		}
		
		return false;
	}
	

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return percept.hashCode();
	}
	
	/**
	 * Getter method for the Formula.
	 * 
	 * @return the formula/percept/proposition.
	 */
	public Abstract_Formula getPercept() {
		return percept;
	}
	
	
	/**
	 * We don't need to clone the agent - its the same one we want to query.
	 */
	public NativePercept clone() {
		return(new NativePercept(percept));
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String s = "P(" + percept.toString() + ")";
		return s;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.ast.Native_Proposition#getEquivalentJPFClass()
	 */
	public String getEquivalentJPFClass() {
		return "ajpf.psl.ast.Abstract_Percept";
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.ast.Native_Proposition#createInJPF(gov.nasa.jpf.vm.VM)
	 */
	public int createInJPF(VM vm) {
		int objref = super.createInJPF(vm);
		ElementInfo ei = vm.getElementInfo(objref);
		ei.setReferenceField("percept", percept.createInJPF(vm));
		return objref;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.MCAPLProperty#quickCompareVal()
	 */
	public int quickCompareVal() {
		return 5;
	}

	    
}
