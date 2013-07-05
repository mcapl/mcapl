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

import ail.syntax.VarTerm;
import gov.nasa.jpf.annotation.FilterField;

/**
 * Represents an unnamed variable '_'.
 * 
 * @author jomi
 */
public class UnnamedVar extends VarTerm {

	@FilterField
	private static int varCont = 1;

	/**
	 * Constructor.
	 */
    public UnnamedVar() {
        super("_" + (varCont++));
    }

    /**
     * Constructor.
     * @param name
     */
    private UnnamedVar(String name) {
        super(name);
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.VarTerm#clone()
     */
    public UnnamedVar clone() {
        if (hasValue()) {
            return (UnnamedVar) getValue().clone();
        } else {
        	return new UnnamedVar(getFunctor());
        }

     }

    /*
     * (non-Javadoc)
     * @see ail.syntax.VarTerm#isUnnamedVar()
     */
    public boolean isUnnamedVar() {
        return !hasValue();
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.VarTerm#toString()
     */
    public String toString() {
        if (hasValue())
            return getValue().toString();
        else
            return "_";
    }

}
