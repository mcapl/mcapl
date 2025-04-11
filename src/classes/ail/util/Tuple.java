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
package ail.util;

import gov.nasa.jpf.vm.MJIEnv;

/**
 * A Class for tuples of two items.
 * @author louiseadennis
 *
 * @param <K>
 * @param <L>
 */
public class Tuple<K, L> {
	K left;
	L right;
	
	public Tuple(K k, L l) {
		left = k;
		right = l;
	}
	
	/**
	 * Get the "left" element of the tuple.
	 * @return
	 */
	public K getLeft() {
		return left;
	}
	
	/**
	 * Get the "right" element of the tuple.
	 * @return
	 */
	public L getRight() {
		return right;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String s = "<" + left + ", " + right + ">";
		return s;
	}

	public int newJPFStringDouble(MJIEnv env) {
		int tsRef = env.newString((String) getLeft());
		int tdRef = env.newDouble((Double) getRight());
		int tRef = env.newObject("ail.util.Tuple");
		env.setReferenceField(tRef, "left", tsRef);
		env.setReferenceField(tRef, "right", tdRef);
		return tRef;
	}

	public int newJPFStringString(MJIEnv env) {
		int tsRef = env.newString((String) getLeft());
		int tdRef = env.newString((String) getRight());
		int tRef = env.newObject("ail.util.Tuple");
		env.setReferenceField(tRef, "left", tsRef);
		env.setReferenceField(tRef, "right", tdRef);
		return tRef;
	}


}
