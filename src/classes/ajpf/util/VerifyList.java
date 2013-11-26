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

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Collection;

public class VerifyList<K extends Comparable<? super K>> implements List<K> {
	ArrayList<K> sortedlist = new ArrayList<K>();
	
	public int size() {
		return sortedlist.size();
	}
	
	public boolean isEmpty() {
		return sortedlist.isEmpty();
	}
		
	public K get(int i) {
		return sortedlist.get(i);
	}
	
	public boolean add(K e) {
		return sortedlist.add(e);
	}
	
	public void add(int index, K e) {
		sortedlist.add(index, e);
	}
	
	public boolean addAll(int index, Collection<? extends K> c) {
		return sortedlist.addAll(index, c);
	}
		
	public boolean addAll(Collection<? extends K> c) {
		return sortedlist.addAll(c);
	}

	public void putAll(List<? extends K> m) {
		for (K key: m) {
			insert(key);
		}
	}
		
	public void clear() {
		sortedlist.clear();
	}
	
	public void put(K e) {
		insert(e);
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
	
	public int indexOf(Object o) {
		return sortedlist.indexOf(o);
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
		if (o instanceof List<?>) {
			return ((List<?>) o).equals(sortedlist);
		}
		return false;
	}

	public int lastIndexOf(Object o) {
		return sortedlist.lastIndexOf(o);
	}
	
	public ListIterator<K> listIterator() {
		return sortedlist.listIterator();
	}
	
	public ListIterator<K> listIterator(int index) {
		return sortedlist.listIterator(index);
	}
	
	public K remove(int index) {
		return sortedlist.remove(index);
	}
	
	public boolean remove(Object o) {
		if (sortedlist.contains(o)) {
			return sortedlist.remove(o);
		} else {
			return false;
		}
	}

	public boolean removeAll(Collection<?> c) {
		return sortedlist.removeAll(c);
	}
	
	public boolean retainAll(Collection<?> c) {
		return sortedlist.retainAll(c);
	}
	
	public K set(int index, K element) {
		return sortedlist.set(index, element);
	}
	
	public List<K> subList(int fromIndex, int toIndex) {
		return sortedlist.subList(fromIndex, toIndex);
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
} ///:~