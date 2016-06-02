// ----------------------------------------------------------------------------
// Copyright (C) 2014 Louise A. Dennis, Michael Fisher
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
 * An interface for objects that act like predicates - i.e., they can appear atomically
 * in logical formulae and can be evaluated against Evaluation bases particular ones that
 * are associated with a prolog-style rule base.
 * @author louiseadennis
 *
 */
public interface PredicateTerm extends LogicalFormula, EBCompare<PredicateTerm> {
	/**
	 * Is this PredicateTerm a variable?
	 * @return
	 */
	public boolean isVar();
	
	/**
	 * This is used for efficient lookup against Belief Bases and the like.  It basically
	 * creates an index of which can be used as a key in a hash.
	 * @return
	 */
	public PredicateIndicator getPredicateIndicator();
	
	/**
	 * Return the functor of the Predicate Term.
	 * @return
	 */
	public String getFunctor();
	
	/**
	 * Return the number of arguments in the PredicateTerm.
	 * @return
	 */
	public int getTermsSize();
	
}
