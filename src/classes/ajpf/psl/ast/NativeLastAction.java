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

import gov.nasa.jpf.vm.VM;
import gov.nasa.jpf.vm.ElementInfo;

import ajpf.psl.ast.Abstract_Formula;

/**
 * The formula A(a, phi) - the last action performed was agent a doing phi.
 * 
 * @author louiseadennis
 * 
 */
public class NativeLastAction extends Native_Proposition {
	
	/**
	 * The agent which is required to have the goal.
	 */
	private String agent;
	/**
	 * The formula that is the agent's goal.
	 */
	private Abstract_Formula action;
	
	/**
	 * Constructor.
	 * @param m The multi-agent system (from which the environment can be extracted).
	 * @param agName the name of the agent.
	 * @param f the formula.
	 */
	public NativeLastAction(String agName, Abstract_Formula f) {
		action = f;
		agent = agName;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see mcapl.psl.Proposition#equals(mcapl.psl.MCAPLProperty)
	 */
	// NB.  Does not use the MAS for equality reasoning - this assumes it will only be compared to properties
	// that refer to the same MAS
	public boolean equals(Object p) {
		if (p instanceof NativeLastAction) {
			return (((NativeLastAction) p).getAction().equals(action) && ((NativeLastAction) p).getAgent().equals(agent));
		}
		
		return false;
	}
	
	
	/**
	 * Getter method for the Action.
	 * 
	 * @return the Action.
	 */
	public Abstract_Formula getAction() {
		return action;
	}
	
	/**
	 * Getter method for the Agent.
	 * 
	 * @return the agent who should have the goal.
	 */
	public String getAgent() {
		return agent;
	}
	
	
	/**
	 * We don't need to clone the agent - its the same one we want to query.
	 */
	public NativeLastAction clone() {
		return(new NativeLastAction(agent, action));
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String s = "A(" + agent + "," + action.toString() + ")";
		return s;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.ast.Native_Proposition#getEquivalentJPFClass()
	 */
	public String getEquivalentJPFClass() {
		return "ajpf.psl.ast.Abstract_LastAction";
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.ast.Native_Proposition#createInJPF(gov.nasa.jpf.vm.VM)
	 */
	public int createInJPF(VM vm) {
		int objref = super.createInJPF(vm);
		ElementInfo ei = vm.getElementInfo(objref);
		ei.setReferenceField("action", action.createInJPF(vm));
		ei.setReferenceField("agent", vm.getHeap().newString(agent, vm.getCurrentThread()).getObjectRef());
		return objref;
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.MCAPLProperty#quickCompareVal()
	 */
	public int quickCompareVal() {
		return 4;
	}

	    
}
