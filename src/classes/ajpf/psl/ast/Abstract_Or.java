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
import ajpf.MCAPLcontroller;
import ajpf.MCAPLmas;
import ajpf.psl.Or;
import ajpf.psl.MCAPLProperty;

/**
 * Default class for properties which are disjunctions.
 * 
 * @author louiseadennis
 *
 */
public class Abstract_Or implements Abstract_Property {
	/**
	 * The properties
	 */
	private Abstract_Property inL;
	private Abstract_Property inR;
	
	/**
	 * Constructor.
	 * 
	 * @param p1 the property on the left.
	 * @param p2 the property on the right.
	 */
	public Abstract_Or(Abstract_Property p1, Abstract_Property p2) {
		inL = p1;
		inR = p2;
	}
	
	public MCAPLProperty toMCAPL(MCAPLmas mas, MCAPLcontroller c) {
		return new Or(inL.toMCAPL(mas, c), inR.toMCAPL(mas, c));
	}
	
	public MCAPLProperty toMCAPLNative() {
		return new Or(inL.toMCAPLNative(), inR.toMCAPLNative());
	}

	public int newJPFObject(MJIEnv env) {
		int ref = env.newObject("ajpf.psl.ast.Abstract_Or");
		env.setReferenceField(ref, "inL", inL.newJPFObject(env));
		env.setReferenceField(ref, "inR", inR.newJPFObject(env));
		return ref;
	}
	
	public Abstract_Property toNormalForm() {
		return new Abstract_Or(inL.toNormalForm(), inR.toNormalForm());
	}
	
	public Abstract_Property negate() {
		return new Abstract_And(inL.negate(), inR.negate());
	}
	
	public String toString() {
		String s = "(" + inL.toString();
		s += " \\/ " + inR.toString() + ")";
		return s;
		
	}

}
