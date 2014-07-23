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
import ajpf.psl.MCAPLProperty;
import ajpf.psl.Not;
import ajpf.psl.Proposition;
import ajpf.MCAPLmas;
import ajpf.MCAPLcontroller;

/**
 * Default class for properties which are negated propositions.
 * 
 * @author louiseadennis
 *
 */
public class Abstract_Not implements Abstract_Property {
	/**
	 * The proposition that is negated.
	 */
	private Abstract_Property p;
	
	/**
	 * Constructor - we assume negation normal form so the
	 * argument has to be a proposition.
	 * 
	 * @param prop the proposition to be negated.
	 */
	public Abstract_Not(Abstract_Proposition prop) {
		p = prop;
	}
	
	public Abstract_Not(Abstract_Property prop) {
		p = prop;
	}	
	
	public Abstract_Property toNormalForm() {
		if (p instanceof Abstract_Proposition) {
			return this;
		} else {
			return p.negate().toNormalForm();
		}
	}
	
	public Abstract_Property negate() {
		return p;
	}
	
	public MCAPLProperty toMCAPL(MCAPLmas m, MCAPLcontroller c) {
		return new Not((Proposition) p.toMCAPL(m, c));
	}
	
	public MCAPLProperty toMCAPLNative() {
		return new Not((Native_Proposition) p.toMCAPLNative());
	}

	public int newJPFObject(MJIEnv env) {
		int ref = env.newObject("ajpf.psl.ast.Abstract_Not");
		env.setReferenceField(ref, "p", p.newJPFObject(env));
		return ref;
	}
	
	public String toString() {
		String s = "~";
		s += p.toString();
		return s;
	}

	
}
