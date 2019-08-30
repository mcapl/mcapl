// ----------------------------------------------------------------------------
// Copyright (C) 2014 Louise A. Dennis and  Michael Fisher
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

/**
 * This is an interface for objects that may appear atomically in guards - i.e. logical formulae
 * without connectives -- the base objects than may be checked against the agents state.
 * @author lad
 *
 */
public interface GuardAtom<K extends Unifiable> extends GLogicalFormula, EBCompare<K> {
	
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
	 * A predicate indicator stripped of syntactic stuff that indicates additions/deletions/goals etc.
	 * @return
	 */
	public PredicateIndicator getPurePredicateIndicator();
		
	/**
	 * Is this trivial?  I.e. simply equivalent to true.
	 * @return
	 */
	public boolean isTrivial();
	    
    /**
     * If an agent has several structures of a particular category.
	 * E.g. several belief bases, the one to be consulted for this
	 * GuardAtom is the one so named.  It is a term so that a variable may be
	 * used if it means _any_ relevant evaluation base.
	 * 
     * @return
     */
     public StringTerm getEB();
     
     /**
      * Return the category of evaluation base relevant to this guard atom.  These are
      * assumed to align with the categories defined by DefaultAILStructure.
      * 
      */
     public byte getEBType();
                   
     /*
      * (non-Javadoc)
      * @see ail.syntax.GLogicalFormula#clone()
      */
     public GuardAtom<K> clone();
}
