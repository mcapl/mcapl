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


import ajpf.MCAPLcontroller;
import ajpf.MCAPLmas;
import ajpf.psl.MCAPLProperty;
import ajpf.psl.Until;

import gov.nasa.jpf.vm.MJIEnv;

/**
 * Class for until properties, phi U psi.
 * 
 * @author louiseadennis
 *
 */
public class Abstract_Until implements Abstract_Property {
	/**
	 * The property that must hold until the second becomes true.
	 */
	private Abstract_Property trueuntil;
	/**
	 * The property that must hold eventually.
	 */
	protected Abstract_Property finalprop;
	
	/**
	 * Constructure.
	 * 
	 * @param p The property that must hold until the second becomes true.
	 * @param q The property that must hold eventually.
	 */
	public Abstract_Until (Abstract_Property p, Abstract_Property q) {
		trueuntil = p;
		finalprop = q;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder s = new StringBuilder(trueuntil.toString()).append(" U ").append(finalprop.toString());
		return s.toString();
	}
	
	public MCAPLProperty toMCAPL(MCAPLmas mas, MCAPLcontroller c) {
		return new Until(trueuntil.toMCAPL(mas, c), finalprop.toMCAPL(mas, c));
	}
	
	public MCAPLProperty toMCAPLNative() {
		return new Until(trueuntil.toMCAPLNative(), finalprop.toMCAPLNative());
	}

	public int newJPFObject(MJIEnv env) {
		int ref = env.newObject("ajpf.psl.ast.Abstract_Until");
		env.setReferenceField(ref, "trueuntil", trueuntil.newJPFObject(env));
		env.setReferenceField(ref, "finalprop", finalprop.newJPFObject(env));
		return ref;
	}
	
	public Abstract_Property toNormalForm() {
		return new Abstract_Until(trueuntil.toNormalForm(), finalprop.toNormalForm());
	}
	
	public Abstract_Property negate() {
		return new Abstract_Release(trueuntil.negate(), finalprop.negate());
	}


}
