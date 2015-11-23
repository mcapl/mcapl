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

import ajpf.psl.MCAPLTerm;

import eis.iilang.Parameter;

/**
 * Common interface for all kind of Terms
 */
public interface Term extends  Unifiable, MCAPLTerm {
		
	/**
	 * Is this a variable?
	 */
	public boolean isVar();
	
    /**
     * Is this a literal?
     * @return
     */
    public boolean isLiteral();
    
    /**
     * Is this a predicate?
     * @return
     */
    public boolean isPredicate();
    
    /**
     * Is this ground?
     * @return
     */
    public boolean isGround();

    /**
     * Does this contain the variable?
     * @param t
     * @return
     */
    public boolean hasVar(Term t);

    /**
     * Does this contain an annotation?
     * @return
     */
    public boolean hasAnnotation();
     
    /**
     * Is this an arithmetic expression?
     * @return
     */
    public boolean isArithExpr();

    /** 
     *  Applies variables's values in an unifier to the variables in the term.
     *  Returns true if some variable was applied.  
     */
    public boolean apply(Unifier u);
    
    /**
     * Get the object hash code.
     * @return
     */
    public int hashCode();
    
    /**
     * Remove all unwanted VarTerm wrappers where the variable has been instantiated - useful for state matching in JPF.
     * @return
     */
    public Term strip_varterm();
    
    public Term resolveVarsClusters();
    
    public String fullstring();
    
    /**
     * For compatibility with EIS interfaces, terms need to be convertible to EIS parameters.
     * @return
     */
    public Parameter toEISParameter();
        	      
}
