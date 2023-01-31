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

/**
 * A list class with a canonical form (based on sorting the list elements) in order to assist state matching when running in JPF.
 * Essentially this can only be used where a list class is intended to be a set with an indexing on elements, rather
 * than something where the order of the list is important.
 * @author louiseadennis
 *
 * @param <K>
 */
public class VerifyList<K extends Comparable<? super K>> implements List<K> {
	ArrayList<K> sortedlist = new ArrayList<K>();
	
	public VerifyList() {
		sortedlist.trimToSize();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.List#size()
	 */
	public int size() {
		return sortedlist.size();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.List#isEmpty()
	 */
	public boolean isEmpty() {
		return sortedlist.isEmpty();
	}
		
	/*
	 * (non-Javadoc)
	 * @see java.util.List#get(int)
	 */
	public K get(int i) {
		return sortedlist.get(i);
	}
	
	/**
	 * Inserts e into its canonical place in the list.  WARNING: This does
	 * not implement the behaviour specified in List which states the element
	 * should be added at the end of the list.
	 */
	public boolean add(K e) {
		insert(e);
		return true;
		//return sortedlist.add(e);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.List#add(int, java.lang.Object)
	 */
	public void add(int index, K e) {
		sortedlist.add(index, e);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.List#addAll(int, java.util.Collection)
	 */
	public boolean addAll(int index, Collection<? extends K> c) {
		return sortedlist.addAll(index, c);
	}
		
	/**
	 * Inserts elements of c into their canonical places in the List.  WARNING: This
	 * contravenes the specification in List which states they should be placed at the end
	 * of the list.
	 */
	public boolean addAll(Collection<? extends K> c) {
		putAll(c);
		return true;
	}

	/**
	 * Add all elements of a list to this list.  Should be used in preference
	 * to addAll in order to maintain sortedness.
	 * @param m
	 */
	public void putAll(Collection<? extends K> m) {
		for (K key: m) {
			insert(key);
		}
	}
		
	/*
	 * (non-Javadoc)
	 * @see java.util.List#clear()
	 */
	public void clear() {
		sortedlist.clear();
	}
	
	/**
	 * Insert an element into the list maintaining canonical form.
	 * @param e
	 */
	public void put(K e) {
		add(e);
	} 
	
	/*
	 * (non-Javadoc)
	 * @see java.util.List#contains(java.lang.Object)
	 */
	public boolean contains(Object e) {
		return sortedlist.contains(e);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.List#containsAll(java.util.Collection)
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
	 * @see java.util.List#indexOf(java.lang.Object)
	 */
	public int indexOf(Object o) {
		return sortedlist.indexOf(o);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.List#iterator()
	 */
	public Iterator<K> iterator() {
		return sortedlist.iterator();
	}
	
	/**
	 * Insert an element into the list in its place according to sort order.
	 * @param t
	 * @return
	 */
	private K insert(K t) {
		//fatma - modifying to get remove addition of elements in loop
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
		if(index_to_add_at!=-1)
		{
			sortedlist.add(index_to_add_at,t);
		}
		else {
			sortedlist.add(t);
		}
		return element_to_return;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		if (o instanceof List<?>) {
			return ((List<?>) o).equals(sortedlist);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.List#lastIndexOf(java.lang.Object)
	 */
	public int lastIndexOf(Object o) {
		return sortedlist.lastIndexOf(o);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.List#listIterator()
	 */
	public ListIterator<K> listIterator() {
		return sortedlist.listIterator();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.List#listIterator(int)
	 */
	public ListIterator<K> listIterator(int index) {
		return sortedlist.listIterator(index);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.List#remove(int)
	 */
	public K remove(int index) {
		K element = sortedlist.remove(index);
		sortedlist.trimToSize();
		return element;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.List#remove(java.lang.Object)
	 */
	public boolean remove(Object o) {
		boolean element = sortedlist.remove(o);
		sortedlist.trimToSize();
		return element;
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.List#removeAll(java.util.Collection)
	 */
	public boolean removeAll(Collection<?> c) {
		return sortedlist.removeAll(c);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.List#retainAll(java.util.Collection)
	 */
	public boolean retainAll(Collection<?> c) {
		return sortedlist.retainAll(c);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.List#set(int, java.lang.Object)
	 */
	public K set(int index, K element) {
		return sortedlist.set(index, element);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.List#subList(int, int)
	 */
	public List<K> subList(int fromIndex, int toIndex) {
		return sortedlist.subList(fromIndex, toIndex);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.List#toArray()
	 */
	public Object[] toArray() {
		return sortedlist.toArray();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.List#toArray(T[])
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
} ///:~