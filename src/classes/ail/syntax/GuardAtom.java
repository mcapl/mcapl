// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
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
//
// This file is based on code from the Open Source software "Jason", copyright
// by Jomi F. Hubner and Rafael H. Bordini.  http://jason.sf.net
//----------------------------------------------------------------------------

package ail.syntax;

import java.util.Iterator;
import java.util.List;

import ail.semantics.AILAgent;

/**
 * This is an interface for objects that may appear atomically in guards - i.e. not proper logical formulae
 * with connectives but the base objects than may be checked against the agents state.
 * @author lad
 *
 */
public interface GuardAtom extends LogicalFormula, Cloneable, Unifiable {

	/**
	 * Get a set of relevant things this may unify against from the agent's state.  E.g. all goals
	 * or all beliefs.
	 * @param a
	 * @return
	 */
	public Iterator<Unifiable> getRelevant(AILAgent a);
	
	/**
	 * Is this a variable?
	 * @return
	 */
	public boolean isVar();
	
	/**
	 * Predicate indicators are often used to index parts of the agent state, e.g. the belief base
	 * in order to speed up access and checking.  Guard Atoms should have a predicate indicator.
	 * @return
	 */
	public PredicateIndicator getPredicateIndicator();
	
	/**
	 * Is this trivial?  I.e. simply equivalent to true.
	 * @return
	 */
	public boolean isTrivial();
	
    /**
     * Return a list of the conjuncts that make up this logical forumla
     * @return
     */
    public List<LogicalFormula> conjuncts();
    
    /**
     * If an agent has several structures of a particular type.
	 * E.g. several belief bases, the one to be consulted for this
	 * GuardAtom is the one numbered DBnum.
	 * 
     * @return
     */
    public StringTerm getDBnum();

}
