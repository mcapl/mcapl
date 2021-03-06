// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of the Agent Infrastructure Layer (AIL)
// 
// The AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The AIL is distributed in the hope that it will be useful,
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

package ail.syntax.ast;

import gov.nasa.jpf.annotation.FilterField;

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
 * A class that defines several common features of AIL structures.
 * 
 * @author louiseadennis;
 *
 */
public abstract class Abstract_BaseAILStructure implements Abstract_AILStructure {
	
	/**
	 * Define some useful alias for Belief and Goal Categories and 
	 * Addition and Deletion flags.
	 */
	@FilterField
	public final static byte AILBel = 0;
	@FilterField
	public final static byte AILGoal = 1;
	@FilterField
	public final static byte AILAction = 2;
	@FilterField
	public final static byte AILSent = 3;
	@FilterField
	public final static byte AILContent = 4;
	@FilterField
	public final static byte AILContext = 5;
	@FilterField
	public final static byte AILReceived = 6;
	@FilterField
	public final static byte AILPlan = 7;
	@FilterField
	public final static byte AILConstraint = 8;
	@FilterField
	public final static int AILAddition = 0;
	@FilterField
	public final static int AILDeletion = 1;
	@FilterField
	public final static int AILUpdate = 2;
	
	/**
	 * The Structure's category.
	 */
	private byte category;
	
	/**
	 * Empty constructor.  Use with caution.
	 */
	public Abstract_BaseAILStructure() {}

	/**
	 * Construct an AIL Structure with a given category.
	 * 
	 * @param b the Category for the structure.
	 */
	public Abstract_BaseAILStructure(byte b) {
		setCategory(b);
	}
	
	/* (non-Javadoc)
	 * @see ail.syntax.AILStructure#getCategory()
	 */
	public byte getCategory() {
		return category;
	}

	/* (non-Javadoc)
	 * @see ail.syntax.AILStructure#setCategory()
	 */
	public void setCategory(byte b) {
		category = b;
	}


}
