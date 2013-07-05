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
import ajpf.MCAPLcontroller;
import ajpf.MCAPLmas;
import ajpf.psl.MCAPLAgIntention;
import ajpf.psl.MCAPLProperty;
import ajpf.psl.MCAPLFormula;

/**
 * The formula I(a, phi) - a has intention phi.
 * 
 * @author louiseadennis
 * 
 */
public class Abstract_AgIntention extends Abstract_Proposition {
	
	/**
	 * The agent which is required to have the goal.
	 */
	private String agent;
	/**
	 * The formula that is the agent's goal.
	 */
	private Abstract_Formula goal;
	
	/**
	 * Constructor.
	 * 
	 * @param a  The agent which has the goal.
	 * @param f  The goal.
	 */
	public Abstract_AgIntention(String a, Abstract_Formula f) {
		goal = f;
		agent = a;
	}

	public String toString() {
		String s = "I(" + agent + "," + goal.toString() + ")";
		return s;
	}

	public MCAPLProperty toMCAPL(MCAPLmas mas, MCAPLcontroller c) {
		return new MCAPLAgIntention(c.getAgent(agent), (MCAPLFormula) goal.toMCAPL());
	}
	
	public MCAPLProperty toMCAPLNative() {
		return new NativeAgIntention(agent, goal);
	}

	public int newJPFObject(MJIEnv env) {
		int ref = env.newObject("ajpf.psl.ast.Abstract_AgIntention");
		env.setReferenceField(ref, "goal", goal.newJPFObject(env));
		env.setReferenceField(ref, "agent", env.newString(agent));
		return ref;
	}	    
}
