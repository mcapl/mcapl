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
 * Interface class for the various AIL specific structures such as deeds, events
 * beliefs and so forth.  These form a rather mixed bag of objects but there are a
 * number of common features.  All come is a variety of categories with some
 * distinguished objects - suct as the no-plan-yet deed.  Many can be either
 * and addition or deletion and many contain either a literal or a term.
 * 
 * @author louiseadennis
 *
 */
public interface AILStructure extends Term {
	/**
	 * Is the AIL Structure a free variable?
	 * 
	 * @return whether the AIL Structure is a variable.
	 */
	public boolean isVar();
	
	/**
	 * Is AIL Structure a Deed?
	 * 
	 * @return whether the AIL Structure is a Deed.
	 */
	public boolean isDeed();
	
	/**
	 * Is the AIL Structure an Event?
	 * 
	 * @return whether the AIL Structure is an Event.
	 */
	public boolean isEvent();
	
	/**
	 * Is the AIL Structure a belief to be checked (i.e., appearing
	 * in a guard).
	 * 
	 * @return whether the AIL Structure is a belief to be checked.
	 */
	public boolean isGBelief();
	
	/**
	 * Is the AIL Structure a belief to be added or removed from
	 * the Belief Base (i.e., appearing in the deed stack).
	 * 
	 * @return whether the AIL Structure is a belief to be added or deleted.
	 */
	public boolean isDBelief();

	/**
	 * What category of this particular type of AIL Structure is this? e.g., 
	 * no-plan-yet?
	 * 
	 * @return the category of the AIL Structure for this particular sort of
	 * AIL Structure.
	 */
	public byte getCategory();
	
	/**
	 * Set the Category of this structure.  Category depends on the sort of
	 * structure it is - deed, event, etc.
	 * 
	 * @param b the category for the structure.
	 */
	public void setCategory(byte b);
	
	/**
	 * Does the structure have some content that can be unified with something.
	 * @return
	 */
	public boolean hasContent();
	
	/**
	 * Get the unifiable content of this structure.
	 * @return
	 */
	public Unifiable getContent();

	/**
	 * Set the content of this structure.
	 * @param u
	 */
	public void setContent(Unifiable u);

		
	/**
	 * Is the structure an addition or deletion?
	 * 
	 * @return whether the structure is an addition or deletion.
	 */
	public boolean hasTrigType();
	
	/**
	 * Set whether the structure is an addition or deletion.
	 * 
	 * @param b whether the structure should be an addition (true) or
	 *          deletion (false).
	 */
	public void setTrigType(int b);
	
	/**
	 * Get whether the structure is an addition or deletion.
	 * 
	 * @return whether the structure is an addition (0) or deletion (1) or updated (2) or something else..
	 */
	public int getTrigType();
	
	/**
	 * Succeeds if the structure is an addition.
	 * 
	 * @return whether the structure is an addition.
	 */
	public boolean isAddition();
	
	/**
	 * Succeeds if the structure is a deletion
	 */
	public boolean isDeletion();
	
	/**
	 * Succeeds if the structure is an update.
	 */
	
	public boolean isUpdate();
		
	/**
	 * Is this she same sort of structure (Deed, Event) as another?
	 * 
	 * @param a the AIL Structure to be compared against.
	 * @return whether the two structures are of the same sort.
	 */
	public boolean sameType(AILStructure a);
	
	/**
	 * Whether the structure refers in some way to a goal (e.g. an add goal
	 * event).
	 * 
	 * @return whether the structure refers in some way to a gaol.
	 */
	public boolean referstoGoal();
	
	/**
	 * Whether the structure refers in some way to a belief (e.g., an add belief
	 * event).
	 * 
	 * @return whether the structure refers in some way to a belief.
	 */
	public boolean referstoBelief();

	/**
	 * Those parts of the structure that are available for unification represented
	 * as a term.
	 * 
	 * @return a regular Structure for unification.
	 */
	public Unifiable UnifyingTerm();
	
}
