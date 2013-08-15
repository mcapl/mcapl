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

import gov.nasa.jpf.vm.MJIEnv;

import ajpf.MCAPLmas;
import ajpf.MCAPLcontroller;
import ajpf.psl.MCAPLProperty;
import ajpf.psl.MCAPLPercept;
import ajpf.psl.MCAPLFormula;

//import ail.syntax.Literal;

/**
 * The formula P(phi) means phi is "true" in the environment.
 * 
 * @author louiseadennis
 * 
 */
public class Abstract_Percept extends Abstract_Proposition {
	
	/**
	 * The formula that is the percept.
	 */
	private Abstract_Formula percept;
	
	/**
	 * Constructor.
	 * @param m the multi-agent system.
	 * @param f the formula to be checked.
	 */
	public Abstract_Percept(Abstract_Formula f) {
		percept = f;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String s = "P(" + percept.toString() + ")";
		return s;
	}
	
	public MCAPLProperty toMCAPL(MCAPLmas m, MCAPLcontroller c) {
		return new MCAPLPercept(m, (MCAPLFormula) percept.toMCAPL());
	}
	
	public MCAPLProperty toMCAPLNative() {
		return new NativePercept(percept);
	}

	public int newJPFObject(MJIEnv env) {
		int ref = env.newObject("ajpf.psl.ast.Abstract_Percept");
		env.setReferenceField(ref, "percept", percept.newJPFObject(env));
		return ref;
	}
	    
}
