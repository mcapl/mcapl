// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
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
// License along with AJPF; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ajpf.util;

import java.util.SortedSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collection;
import java.util.Comparator;

/**
 * A Set class that stores objects in a canonical form in order to assist state 
 * matching.
 * @author louiseadennis
 *
 * @param <K>
 */
public class VerifySet<K extends Comparable<? super K>> implements SortedSet<K> {
	ArrayList<K> sortedlist = new ArrayList<K>();
	
	public VerifySet() {
		sortedlist.trimToSize();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.Set#size()
	 */
	public int size() {
		return sortedlist.size();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.Set#isEmpty()
	 */
	public boolean isEmpty() {
		return sortedlist.isEmpty();
	}
		
	/*
	 * (non-Javadoc)
	 * @see java.util.Set#add(java.lang.Object)
	 */
	public boolean add(K e) {
		if (contains(e)) {
			return false;
		} else {
			insert(e);
			return true;
		}
	}
	
	/*
	 * 	(non-Javadoc)
	 * @see java.util.Set#addAll(java.util.Collection)
	 */
	public boolean addAll(Collection<? extends K> c) {
		boolean b = false;
		for (K elem: c) {
			if (add(elem)) {
				b = true;
			}
		}
		return b;
	}

	/*
	 * 	(non-Javadoc)
	 * @see java.util.Set#clear()
	 */
	public void clear() {
		sortedlist.clear();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.Set#contains(java.lang.Object)
	 */
	public boolean contains(Object e) {
		return sortedlist.contains(e);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.Set#containsAll(java.util.Collection)
	 */
	public boolean containsAll(Collection<?> e) {
		return sortedlist.containsAll(e);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return sortedlist.hashCode();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.Set#iterator()
	 */
	public Iterator<K> iterator() {
		return sortedlist.iterator();
	}
	
	/**
	 * Insert an element into the appropriate place in the sortedlist that represents
	 * the canonical form of this set.
	 * @param t
	 * @return
	 */
	private K insert(K t) {
		//fatma changing this to move the addition
		// outside - hopefully avoid concurrent comodification errors
		int index_to_add_at = -1;
		K element_to_return = null;

		for (int i = 0; i < sortedlist.size(); i++) {
			K t1 = sortedlist.get(i);
			int comparison = t.compareTo(t1);
			if (comparison < 0) {
				index_to_add_at = i;
				break;
//				sortedlist.add(i, t);
//				return null;
			} else if (comparison == 0) {
				index_to_add_at = i;
				element_to_return = t1;
				break;
//				sortedlist.add(i, t);
//				return t1;
			}
		}
		if(index_to_add_at != -1)
		{
			sortedlist.add(index_to_add_at,t);
		}else
		sortedlist.add(t);
		return element_to_return;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		if (o instanceof Set<?>) {
			Set<?> set = (Set<?>) o;
			if (set.size() == size()) {
				for (K e: sortedlist) {
					if (!set.contains(e)) {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Set#remove(java.lang.Object)
	 */
	public boolean remove(Object o) {
		return sortedlist.remove(o);
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Set#removeAll(java.util.Collection)
	 */
	public boolean removeAll(Collection<?> c) {
		return sortedlist.removeAll(c);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.Set#retainAll(java.util.Collection)
	 */
	public boolean retainAll(Collection<?> c) {
		return sortedlist.retainAll(c);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.Set#toArray()
	 */
	public Object[] toArray() {
		return sortedlist.toArray();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.Set#toArray(T[])
	 */
	public <T> T[] toArray(T[] a) {
		return sortedlist.toArray(a);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return sortedlist.toString();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.SortedSet#comparator()
	 */
	public Comparator<? super K> comparator() {
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.SortedSet#first()
	 */
	public K first() {
		return sortedlist.get(0);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.SortedSet#last()
	 */
	public K last() {
		return sortedlist.get(size() - 1);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.SortedSet#headSet(java.lang.Object)
	 */
	public SortedSet<K> headSet(K e) {
		VerifySet<K> hs = new VerifySet<K>();
		for (K elem: sortedlist) {
			if (elem.compareTo(e) < 0) {
				hs.add(elem);
			}
		}
		return hs;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.SortedSet#tailSet(java.lang.Object)
	 */
	public SortedSet<K> tailSet(K e) {
		VerifySet<K> hs = new VerifySet<K>();
		for (K elem: sortedlist) {
			if (elem.compareTo(e) >= 0) {
				hs.add(elem);
			}
		}
		return hs;
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.SortedSet#subSet(java.lang.Object, java.lang.Object)
	 */
	public SortedSet<K> subSet(K e1, K e2) {
		VerifySet<K> hs = new VerifySet<K>();
		for (K elem: sortedlist) {
			if (elem.compareTo(e1) >= 0 && elem.compareTo(e2) <= 0) {
				hs.add(elem);
			}
		}
		return hs;
	}
} ///:~