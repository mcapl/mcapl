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


import java.util.Set;

import ail.tracing.explanations.PredicateDescriptions;

/**
 * Interface for things which can be unified.
 * @author louiseadennis
 *
 */
public interface Unifiable extends Cloneable {
	
	/**
	 * Does this unfiable unify with t according to the unifier u?  As as side effect
	 * the unifier is updated accordingly.
	 * 
	 * @param t The unifiable to check against.
	 * @param u An existing unifier, is modifed by the method.
	 * @return
	 */
	public boolean unifies(Unifiable t, Unifier u);
	
	/**
	 * Standardise apart the variables in here from the set of variable names supplied.
	 * @param varnames
	 * @return
	 */
	public void standardise_apart(Unifiable t, Unifier u, Set<String> varnames);
	
	/**
	 * What are the names of the variables mentioned in this term?
	 * @return
	 */
	public Set<String> getVarNames();
	
	/**
	 * Rename all appearances of some variable.
	 * @param oldname
	 * @param newname
	 */
	public void renameVar(String oldname, String newname);
    
	/**
	 * Is this a prolog rule?
	 * @return
	 */
	// public boolean isRule();
	
	/**
	 * To be used when this unifiable is ground.
	 * @param t
	 * @param u
	 * @return
	 */
	public boolean match(Unifiable t, Unifier u);
	
	/**
	 * To be used when this unifiable is not to be changed but may not be ground.
	 * @param t
	 * @param u
	 * @return
	 */
	public boolean matchNG(Unifiable t, Unifier u);

	/**
	 * Is this unifiable ground?
	 * @return
	 */
	public boolean isGround();
	
	/**
	 * Apply a unifier to this Unifiable
	 */
	public boolean apply(Unifier theta);
	
	/**
	 * Anonymise all the vars in this unifiable.
	 */
	public void makeVarsAnnon();
	
	/**
	 * If variables have been instantiated replace the VarTerms with the instantiation - to assist matching during model-checking.
	 * @return
	 */
	public Unifiable strip_varterm();
	
	/**
	 * Sometimes a term may end up containing clusters of variables, these will need to be replaced by a variable from the cluster in some way.
	 * @return
	 */
	public Unifiable resolveVarsClusters();
	
	/**
	 * 
	 */
	public Object clone();
	
	public Unifiable substitute(Unifiable term, Unifiable subst);

	public String toString(PredicateDescriptions descriptions);
}
