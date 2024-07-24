// ----------------------------------------------------------------------------
// Copyright (C) 2014 Louise A. Dennis, Michael Fisher and Alan Winfield
// 
// This file is part of Declarative Ethical Governor (DEG)
// 
// The DEG is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The DEG is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------
package ethical_governor.syntax.ast;

import gov.nasa.jpf.vm.MJIEnv;

/**
 * A helper class for tuples of strings used in Abstract Syntax Trees.
 * @author louiseadennis
 *
 */
public class StringTuple {
	String a;
	String b;
		
	/**
	 * Constructor.
	 * @param s1
	 * @param s2
	 */
	public StringTuple(String s1, String s2) {
		a = s1;
		b = s2;
	}
	
	public String getS1() {
		return a;
	}
	
	public String getS2() {
		return b;
	}
		
	/**
	 * For recreating the tuple in a JPF virtual machine.
	 * @param env
	 * @return
	 */
	public int newJPFObject(MJIEnv env) {
		int objref = env.newObject("ethical_governor.syntax.ast.StringTuple");
		env.setReferenceField(objref, "a", env.newString(a));
		env.setReferenceField(objref, "b", env.newString(b));
		return objref;
	}
}
