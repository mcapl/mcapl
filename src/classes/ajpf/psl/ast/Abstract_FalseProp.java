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
import ajpf.psl.MCAPLProperty;
import ajpf.psl.FalseProp;
import ajpf.MCAPLmas;
import ajpf.MCAPLcontroller;

/**
 * Class for the property F (false).
 * 
 * @author louiseadennis
 *
 */
public class Abstract_FalseProp extends Abstract_Proposition {
		
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ("F");
	}
	
	public MCAPLProperty toMCAPL(MCAPLmas mas, MCAPLcontroller c) {
		return new FalseProp();
	}

	public MCAPLProperty toMCAPLNative() {
		return new FalseProp();
	}

	public int newJPFObject(MJIEnv env) {
		int ref = env.newObject("ajpf.psl.ast.Abstract_FalseProp");
		return ref;
	}
	public Abstract_Property negate() {
		return new Abstract_TrueProp();
	}

}
