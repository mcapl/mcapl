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

import ail.syntax.Event;
import ail.syntax.Goal;
import ail.syntax.Literal;
import ail.syntax.Term;

import gov.nasa.jpf.annotation.FilterField;
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
 * A class for abstract AIL events.
 * 
 * @author louiseadennis
 *
 */
public class Abstract_Event extends Abstract_BaseAILStructure  {

    /**
	 * Category for start events.
	 */
	@FilterField
	public static final byte	Estart = 10;

	/**
	 * Logical content of the event.
	 */
	Abstract_Term content;
	
	/**
	 * Trigger type of the event.
	 */
	int trigtype = 0;
	
	/**
	 * Construct an event of a given category.
	 * 
	 * @param b the cateogry.
	 */
	public Abstract_Event(byte b) {
		super(b);
	}
	
	/**
	 * Get the logical content of the event.
	 * @return
	 */
	public Abstract_Term getContent() {
		return content;
	}
	
	/**
	 * Construct an event with a given add/delete flag, category and literal.
	 * 
	 * @param t the add/delete flag.
	 * @param b the category.
	 * @param l the literal.
	 */
	public Abstract_Event(int t, byte b, Abstract_Literal l) {
		super(b);
		trigtype = t;
		content = l;
	}
	
	
	/**
	 * Construct and event with a given add/delete flag and goal.
	 * 
	 * @param t the add/delete flag.
	 * @param g the goal.
	 */
	public Abstract_Event(int t, Abstract_Goal g) {
		super(AILGoal);
		trigtype = t;
		content = g;
	}
		
	/**
	 * Is this a start event?
	 * 
	 * @return whether this is a start event.
	 */
	public boolean isStart() {
		return (getCategory() == Estart);
	}
	
	/**
	 * Is the event trigger an addition?
	 * @return
	 */
	boolean isAddition() {
		return trigtype == AILAddition;
	}
	
	/**
	 * Is the event trigger a deletion?
	 * @return
	 */
	boolean isDeletion() {
		return trigtype == AILDeletion;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (isStart()) {
			s.append("start");
		} else {
			if (isAddition())
				s.append("+");
			else
				s.append("x");
			if (content != null & content instanceof Abstract_Goal) {
				s.append("!");
				s.append(content.toString());
			} else {
				s.append(content.toString());
			}
		}
		return s.toString();
	}
	

	public Event toMCAPL() {
		if (content != null) {
			Term content_term = (Term) content.toMCAPL();
			if (content_term instanceof Goal) {
				return new Event(trigtype, (Goal) content_term);
			}
			if (content_term instanceof Literal) {
				return new Event(trigtype, getCategory(), (Literal) content_term);
			}
		} 
		Event e = new Event(getCategory());
		return e;

	}
	    
	public int newJPFObject(MJIEnv env) {
		int ref = env.newObject("ail.syntax.ast.Abstract_Event");
		if (content != null) {
			env.setReferenceField(ref, "content", content.newJPFObject(env));
		}
		env.setByteField(ref,  "category", getCategory());
		env.setIntField(ref, "trigtype", trigtype);
		return ref;

	}


}
