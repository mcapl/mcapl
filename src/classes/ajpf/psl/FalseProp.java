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

import java.util.Stack;
import java.util.Set;

/**
 * Class for the property F (false).
 * 
 * @author louiseadennis
 *
 */
public class FalseProp extends Proposition {
		
	/**
	 * Whether this is a true or not an atomic proposition.  It's a proposition
	 * that is always ga;se.
	 */
	public boolean check() {
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.Proposition#check(java.util.Set)
	 */
	public boolean check(Set<Proposition> s) {
		return false;
	}
	
	/**
	 * Is this a proposition that forms a contradiction with the properties in s.
	 * This is always false so automatically forms a contradiction.
	 */
	public boolean isContradiction(Stack<MCAPLProperty> s) {
		return true;
	}
	
	
	/**
	 * False is equal to fale.
	 */
	public boolean equals(Object phi) {
		if (phi instanceof FalseProp) {
			return true;
		}

		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return 2;
	}
	
	/*
	 * (non-Javadoc)
	 * @see mcapl.psl.Proposition#clone()
	 */
	public FalseProp clone() {
		return (new FalseProp());
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ("F");
	}
	
	/*
	 * (non-Javadoc)
	 * @see mcapl.psl.Proposition#negate()
	 */
	public MCAPLProperty negate() {
		return (new TrueProp());
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.MCAPLProperty#quickCompareVal()
	 */
	public int quickCompareVal() {
		return 10;
	}
	
}
