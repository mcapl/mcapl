// ----------------------------------------------------------------------------
// Copyright (C) 2013 Louise A. Dennis, and Michael Fisher
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

import java.util.Iterator;

/**
 * Class for merging to iterators so that first the contents of the first are returned and then the contents of the second.
 * @author louiseadennis
 *
 * @param <E>
 */
public class MergeIterator<E> implements Iterator<E> {
	Iterator<E> firstIterator;
	Iterator<E> secondIterator;
	/**
	 * Flag to keep track of which iterator is currently being examined.
	 */
	boolean onFirst = true;
	
	/**
	 * Constructor.
	 * @param it1
	 * @param it2
	 */
	public MergeIterator(Iterator<E> it1, Iterator<E> it2 ) {
		firstIterator = it1;
		secondIterator = it2;
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Iterator#hasNext()
	 */
	public boolean hasNext() {
		if (onFirst) {
			if (firstIterator.hasNext()) {
				return true;
			} else {
				onFirst = false;
			}
		}
		return secondIterator.hasNext();
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Iterator#next()
	 */
	public E next() {
		if (onFirst) {
			if (firstIterator.hasNext()) {
				return firstIterator.next();
			} else {
				onFirst = false;
			}
		}
		return secondIterator.next();
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Iterator#remove()
	 */
	public void remove() {
		if (onFirst) {
			firstIterator.remove();
		} else {
			secondIterator.remove();
		}
	}

}
