// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
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
// License along with AJPF if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package ajpf.psl;

import java.util.Set;

/**
 * Interface for formulas in the MCAPL Property Specification Language.
 * 
 * @author louiseadennis
 *
 */
public interface MCAPLProperty extends Comparable<MCAPLProperty> {
	/**
	 * Checks if the property is either temporal or true in the current agent state.
	 * 
	 * @return whether the property is temporal or true.
	 */
	boolean check();
	
	/**
	 * Check if the property appears in a list of propositions.
	 * @param props
	 * @return
	 */
	boolean check(Set<Proposition> props);
	
	/**
	 * True if the property is an Until property.
	 * 
	 * @return whether the property is an until formula.
	 */
	boolean isUntil();
	
	/**
	 * True if the property is a Release property.
	 * 
	 * @return whether the property is a Relase property.
	 */
	boolean isRelease();
		
	/**
	 * Returns true if the property is a proposition and 
	 * forms a contradiction with the formulas in the set.
	 * 
	 * @param props the properties with which this may form
	 *              a contradiction.
	 * @return if the node forms a contradiction.
	 */
	public boolean isContradiction(Set<MCAPLProperty> props);
	
	/**
	 * Some properties, on expansion, split a Buchi Automat state into two 
	 * possibilities e.g., OR properties.
	 * 
	 * @return whether this is a property that will split a Buchi Automata state
	 * into two alternatives when being expanded.
	 */
	public boolean splitsAutomataState();
	
	/**
	 * During expansion, assuming this property doesn't cause the node to split, the
	 * state's new field should have the following properties added.  If the 
	 * property would split the state this should return an empty set.
	 * 
	 * @param old  The Old properities (i.e., those already processed, to prevent dupilcation)
	 * @return Propeties to add to the states new field.
	 */
	public Set<MCAPLProperty> addtoNew(Set<MCAPLProperty> old);
	
	/**
	 * During expansion, assuming this property causes the node to split, these are the
	 * property that should be added to the New field of the first new Buchi State.  If
	 * the node is not caused to split this should return an empty Stack.
	 * 
	 * @param old The Old properities (i.e., those already processed, to prevent dupilcation)
	 * @return A stack of MCAPLProperties to be added to the new field of the first BuchiState
	 *         in the split.
	 */
	public Set<MCAPLProperty> addtoNew1(Set<MCAPLProperty> old, Set<MCAPLProperty> newp);
	
	/**
	 * During expansion, assuming this property causes the node to split, these are the
	 * property that should be added to the New field of the second new Buchi State.  If
	 * the node is not caused to split this should return an empty Stack.
	 * 
	 * @param old The Old properities (i.e., those already processed, to prevent dupilcation)
	 * @return A stack of MCAPLProperties to be added to the new field of the second BuchiState
	 *         in the split.
	 */
	public Set<MCAPLProperty> addtoNew2(Set<MCAPLProperty> old, Set<MCAPLProperty> newp);
	
	/**
	 * During expansion, assuming this property doesn't cause the node to split, the
	 * state's old field should have the following properties added.  If the 
	 * property would split the state this should return an empty set.
	 * 
	 * @return Propeties to add to the states old field.
	 */
	public Set<MCAPLProperty> addtoOld();

	/**
	 * During expansion of a Buchi State, assuming this property causes the node to 
	 * split, these are the properties that should be added to the Old field of the first new
	 * Buchi State.  If the node is not caused to split this should return and empty Stack.
	 * 
	 * @return A stack of MCAPLProperties to be added to the old field of the first BuchiState
	 *         in the split.
	 */
	public Set<MCAPLProperty> addtoOld1();
	
	/**
	 * During expansion of a Buchi State, assuming this property causes the node to 
	 * split, these are the properties that should be added to the Old field of the second new
	 * Buchi State.  If the node is not caused to split this should return and empty Stack.
	 * 
	 * @return A stack of MCAPLProperties to be added to the old field of the second BuchiState
	 *         in the split.
	 */
	public Set<MCAPLProperty> addtoOld2();
	
	/**
	 * During expansion, assuming this property doesn't cause the node to split, the
	 * state's next field should have the following properties added.  If the 
	 * property would split the state this should return an empty set.
	 * 
	 * @return Propeties to add to the state's next field.
	 */
	public Set<MCAPLProperty> addtoNext();

	/**
	 * During expansion of a Buchi State, assuming this property causes the node to 
	 * split, these are the properties that should be added to the Next field of the first new
	 * Buchi State.  If the node is not caused to split this should return and empty Stack.
	 * 
	 * @return A stack of MCAPLProperties to be added to the next field of the first BuchiState
	 *         in the split.
	 */
	public Set<MCAPLProperty> addtoNext1();
	
	/**
	 * During expansion of a Buchi State, assuming this property causes the node to 
	 * split, these are the properties that should be added to the Next field of the second new
	 * Buchi State.  If the node is not caused to split this should return and empty Stack.
	 * 
	 * @return A stack of MCAPLProperties to be added to the next field of the second BuchiState
	 *         in the split.
	 */
	public Set<MCAPLProperty> addtoNext2();
	
	/**
	 * The negation of this property in negation normal form.
	 * 
	 * @return the negation of this property in negation normal form.
	 */
	public MCAPLProperty negate();
	
	/**
	 * When updating the property automata it is useful to know just the propositions
	 * that appear in the automata, since this allows a quick assessment of any
	 * changes in truth value.  This method assists with that.
	 * @return
	 */
	public Set<Proposition> getProps();
	
	/**
	 * Return the until expressions appearing in the property.  It is important to track
	 * these properly in the property automaton.
	 * @return
	 */
	public Set<Until> getUntils();
	
	/**
	 * For producing efficient automata its useful, for instance, to remove properties like A v B
	 * from the property set, once it has been divided up.  However this doesn't work if the property
	 * is under an always quantifier.  This method returns whether such property should be kept.
	 * @return
	 */
	public boolean keepInOld();
	
	/**
	 * For producing efficient automata its useful, for instance, to remove properties like A v B
	 * from the property set, once it has been divided up.  However this doesn't work if the property
	 * is under an always quantifier.  This method sets whether such a property should be kept.
	 */
	public void noteKeep();
	
	/**
	 * Return an integer representing the property class for quick comparisons.
	 * @return
	 */
	public int quickCompareVal();

}