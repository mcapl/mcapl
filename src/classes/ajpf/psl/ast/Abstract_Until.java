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
 * Generic Description of Abstract Classes in AIL and AJPF
 * -------------------------------------------------------
 * 
 * We use "Abstract" versions of syntax items for all bits of state that we sometimes wish to store in the native
 * java VM as well in the JavaPathfinder VM.  In particular files are parsed into the native VM and then the relevant
 * initial state of the multi-agent system is reconstructed in the model-checking VM.  This is done to improve
 * efficiency of parsing (the native VM is faster).  We also represent properties for model checking in the native VM 
 * and, indeed the property automata is stored only in the native VM.  We used Abstract classes partly because less
 * computational content is needed for these objects in the native VM and so a smaller representation can be used
 * but also because specific support is needed for transferring information between the two virtual machines both
 * in terms of methods and in terms of the data types chosen for the various fields.  It was felt preferable to 
 * separate these things out from the classes used for the objects that determine the run time behaviour of a MAS.
 * 
 * Abstract classes all have a method (toMCAPL) for creating a class for the equivalent concrete object used
 * when executing the MAS.  They also have a method (newJPFObject) that will create an equivalent object in the 
 * model-checking virtual machine from one that is held in the native VM.  At the start of execution the agent
 * program is parsed into abstract classes in the native VM.  An equivalent structure is then created in the JVM
 * using calls to newJPFObject and this structure is then converted into the structures used for executing the MAS
 * by calls to toMCAPL.
 * 
 */

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
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.ast.Abstract_Property#toMCAPL(ajpf.MCAPLmas, ajpf.MCAPLcontroller)
	 */
	public MCAPLProperty toMCAPL(MCAPLmas mas, MCAPLcontroller c) {
		return new Until(trueuntil.toMCAPL(mas, c), finalprop.toMCAPL(mas, c));
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.ast.Abstract_Property#toMCAPLNative()
	 */
	public MCAPLProperty toMCAPLNative() {
		return new Until(trueuntil.toMCAPLNative(), finalprop.toMCAPLNative());
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.ast.Abstract_Property#newJPFObject(gov.nasa.jpf.vm.MJIEnv)
	 */
	public int newJPFObject(MJIEnv env) {
		int ref = env.newObject("ajpf.psl.ast.Abstract_Until");
		env.setReferenceField(ref, "trueuntil", trueuntil.newJPFObject(env));
		env.setReferenceField(ref, "finalprop", finalprop.newJPFObject(env));
		return ref;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.ast.Abstract_Property#toNormalForm()
	 */
	public Abstract_Property toNormalForm() {
		return new Abstract_Until(trueuntil.toNormalForm(), finalprop.toNormalForm());
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.ast.Abstract_Property#negate()
	 */
	public Abstract_Property negate() {
		return new Abstract_Release(trueuntil.negate(), finalprop.negate());
	}


}
