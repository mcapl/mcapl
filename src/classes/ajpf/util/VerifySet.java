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
import java.util.ListIterator;
import java.util.Collection;
import java.util.Comparator;

public class VerifySet<K extends Comparable<? super K>> implements SortedSet<K> {
	ArrayList<K> sortedlist = new ArrayList<K>();
	
	public int size() {
		return sortedlist.size();
	}
	
	public boolean isEmpty() {
		return sortedlist.isEmpty();
	}
		
	public boolean add(K e) {
		if (contains(e)) {
			return false;
		} else {
			insert(e);
			return true;
		}
	}
	
		
	public boolean addAll(Collection<? extends K> c) {
		boolean b = false;
		for (K elem: c) {
			if (add(elem)) {
				b = true;
			}
		}
		return b;
	}

		
	public void clear() {
		sortedlist.clear();
	}
	
	public boolean contains(Object e) {
		return sortedlist.contains(e);
	}
		
	public boolean containsAll(Collection<?> e) {
		return sortedlist.containsAll(e);
	}
		
	public int hashCode() {
		return sortedlist.hashCode();
	}
	
	public Iterator<K> iterator() {
		return sortedlist.iterator();
	}
	
	private K insert(K t) {
		for (int i = 0; i < sortedlist.size(); i++) {
			K t1 = sortedlist.get(i);
			int comparison = t.compareTo(t1);
			if (comparison < 0) {
				sortedlist.add(i, t);
				return null;
			} else if (comparison == 0) {
				sortedlist.add(i, t);
				return t1;
			}
		}
		
		sortedlist.add(t);
		return null;
	}
	
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

	public boolean remove(Object o) {
		return sortedlist.remove(o);
	}

	public boolean removeAll(Collection<?> c) {
		return sortedlist.removeAll(c);
	}
	
	public boolean retainAll(Collection<?> c) {
		return sortedlist.retainAll(c);
	}
	
	
	public Object[] toArray() {
		return sortedlist.toArray();
	}
	
	public <T> T[] toArray(T[] a) {
		return sortedlist.toArray(a);
	}
	
	public String toString() {
		return sortedlist.toString();
	}
	
	public Comparator<? super K> comparator() {
		return null;
	}
	
	public K first() {
		return sortedlist.get(0);
	}
	
	public K last() {
		return sortedlist.get(size() - 1);
	}
	
	public SortedSet<K> headSet(K e) {
		VerifySet<K> hs = new VerifySet<K>();
		for (K elem: sortedlist) {
			if (elem.compareTo(e) < 0) {
				hs.add(elem);
			}
		}
		return hs;
	}
	
	public SortedSet<K> tailSet(K e) {
		VerifySet<K> hs = new VerifySet<K>();
		for (K elem: sortedlist) {
			if (elem.compareTo(e) >= 0) {
				hs.add(elem);
			}
		}
		return hs;
	}

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