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

import java.util.HashSet;
import java.util.Stack;
import java.util.Set;

import ajpf.psl.ast.Abstract_Property;

/**
 * Class for the property T.
 * 
 * @author louiseadennis
 *
 */
public class TrueProp extends Proposition {
	
	
	/**
	 * Whether this is a true or not an atomic proposition.  It's a proposition
	 * that is always true.
	 */
	public boolean check() {
		return true;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.Proposition#check(java.util.Set)
	 */
	public boolean check(Set<Proposition> props) {
		return true;
	}
	/**
	 * Is this a proposition that forms a contradiction with the properties in s.
	 * This is always true so can not, of itself, cause a contradiction.
	 */
	public boolean isContradiction(Stack<Abstract_Property> s) {
		return false;
	}
	
	
	/**
	 * True is equal to true.
	 */
	public boolean equals(Object phi) {
		if (phi instanceof TrueProp) {
			return true;
		}

		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return 1;
	}
	
	/*
	 * (non-Javadoc)
	 * @see mcapl.psl.Proposition#clone()
	 */
	public TrueProp clone() {
		return (new TrueProp());
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ("T");
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.Proposition#getProps()
	 */
	public HashSet<Proposition> getProps() {
		HashSet<Proposition> props = new HashSet<Proposition>();
		return(props);
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.MCAPLProperty#quickCompareVal()
	 */
	public int quickCompareVal() {
		return 11;
	}

}
