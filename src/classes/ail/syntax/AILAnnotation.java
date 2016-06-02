// ----------------------------------------------------------------------------
// Copyright (C) 2008-2015 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
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
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package ail.syntax;

/**
 * Interface for language specific information used by language specific
 * extensions to AIL.  We anticipate that annotations will need to support
 * unification and may need to be tagged of specific types.  
 * 
 * A couple of specific annotations, intended to track the sources of information
 * and the belief bases information is stored in are provided in ail.syntax.annotation
 * 
 * @author louiseadennis
 *
 */
public interface AILAnnotation extends Cloneable, Comparable<AILAnnotation> {
	
	// Predefined Annotation Types
	public static byte SOURCEANNOT = 0;
	public static byte BBAnnot = 1;

	/**
	 * Generates a new object which is a copy of the Annotation.  Important
	 * for when several agents share the same plan.  We actually want each to
	 * have their own copy.
	 * 
	 * @return An AILAnnotation identical to this.
	 */
	public AILAnnotation clone();
	
	/**
	 * Is this annotation is ground for the purposes of unification.
	 * @return
	 */
	public boolean isGround();
	
	/**
	 * What happens when a unifier is applied to this annotation.
	 * @param u
	 * @return
	 */
	public boolean apply(Unifier u);
	
	/**
	 * Is this annotation empty.
	 * @return
	 */
	public boolean isEmpty();
	
	/**
	 * Is this annotation "compatible" (whatever that may mean in a specific situation) with another,
	 * given some unifier.
	 * @param a
	 * @param u
	 * @return
	 */
	public boolean compatibleAnnotations(AILAnnotation a, Unifier u);
	
	/**
	 * Add another annotation to this.
	 * @param a
	 * @return
	 */
	public boolean addAnnot(AILAnnotation a);
		
	/**
	 * What type is this annotation?
	 * @return
	 */
	public byte getType();
	

}
