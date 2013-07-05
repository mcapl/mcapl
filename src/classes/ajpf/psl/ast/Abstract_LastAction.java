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

import gov.nasa.jpf.jvm.MJIEnv;
//import ail.syntax.Literal;
//import ail.syntax.ast.Abstract_Structure;
import ajpf.MCAPLcontroller;
import ajpf.MCAPLmas;
import ajpf.psl.MCAPLLastAction;
import ajpf.psl.MCAPLProperty;
import ajpf.psl.MCAPLFormula;

/**
 * The formula A(a, phi) - the last action performed was agent a doing phi.
 * 
 * @author louiseadennis
 * 
 */
public class Abstract_LastAction extends Abstract_Proposition {
	
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
	public Abstract_LastAction(String agName, Abstract_Formula f) {
		action =  f;
		agent = agName;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String s = "A(" + agent + "," + action.toString() + ")";
		return s;
	}
	    
	public MCAPLProperty toMCAPL(MCAPLmas mas, MCAPLcontroller c) {
		return new MCAPLLastAction(mas, agent, (MCAPLFormula) action.toMCAPL());
	}

	public MCAPLProperty toMCAPLNative() {
		return new NativeLastAction(agent, action);
	}

	public int newJPFObject(MJIEnv env) {
		int ref = env.newObject("ajpf.psl.ast.Abstract_LastAction");
		env.setReferenceField(ref, "action", action.newJPFObject(env));
		env.setReferenceField(ref, "agent", env.newString(agent));
		return ref;
	}
}
