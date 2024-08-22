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

import ail.util.Tuple;
import gov.nasa.jpf.vm.MJIEnv;

import java.util.Collections;
import java.util.Map;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.Collection;

/**
 * A map class which maintains equal maps in the same canonical form in order to
 * optimise state matching within JPF.
 * @author louiseadennis
 *
 * @param <K>
 * @param <V>
 */
public class VerifyMap<K extends Comparable<? super K>, V> implements Map<K, V> {
	ArrayList<Tuple<K, V>> tuplearray = new ArrayList<Tuple<K, V>>();
	 
	public VerifyMap() {
		tuplearray.trimToSize();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.Map#size()
	 */
	public int size() {
		return tuplearray.size();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.Map#isEmpty()
	 */
	public boolean isEmpty() {
		return tuplearray.isEmpty();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.Map#containsKey(java.lang.Object)
	 */
	public boolean containsKey(Object key) {
		for (Tuple<K, V> t: tuplearray) {
			if (t.matches(key)) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.Map#containsValue(java.lang.Object)
	 */
	public boolean containsValue(Object value) {
		for (Tuple<K, V> t: tuplearray) {
			if (t.valueMatch(value)) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.Map#get(java.lang.Object)
	 */
	public V get(Object key) {
		for (Tuple<K, V> t: tuplearray) {
			if (t.matches(key)) {
				return t.getValue();
			}
		}
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
	 */
	public V put(K key, V value) {
		V out = insert(new Tuple<K, V>(key, value));
		return out;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.Map#remove(java.lang.Object)
	 */
	public V remove(Object key) {
		if (containsKey(key)) {
			for (Tuple<K, V> tuple: tuplearray) {
				if (tuple.getKey().equals(key)) {
					tuplearray.remove(tuple);
					tuplearray.trimToSize();
					return tuple.getValue();
				}
			}
			
		} 
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.Map#putAll(java.util.Map)
	 */
	public void putAll(Map<? extends K, ? extends V> m) {
		for (K key: m.keySet()) {
			put(key, m.get(key));
		}
	}
		
	/*
	 * (non-Javadoc)
	 * @see java.util.Map#clear()
	 */
	public void clear() {
		tuplearray.clear();
		tuplearray.trimToSize();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.Map#keySet()
	 */
	public Set<K> keySet() {
		TreeSet<K> set = new TreeSet<K>();
		for (Tuple<K, V> t: tuplearray) {
			set.add(t.getKey());
		}
		return set;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.Map#values()
	 */
	public Collection<V> values() {
		ArrayList<V> values = new ArrayList<V>();
		for (Tuple<K, V> t: tuplearray) {
			values.add(t.getValue());
		}
		return values;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.Map#entrySet()
	 */
	public Set<Map.Entry<K, V>> entrySet() {
		TreeSet<Map.Entry<K, V>> set = new TreeSet<Map.Entry<K, V>>();
		for (Tuple<K, V> t: tuplearray) {
			set.add(t);
		}
		return set;		
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		int h = 0;
		for (Tuple<K, V> t: tuplearray) {
			h += t.hashCode();
		}	
		return h;
	}
	
	/**
	 * Insert an key value tuple into the map.
	 * @param t
	 * @return
	 */
	private V insert(Tuple<K, V> t) {
		//fatma - changing this so we do dont modify the array (add things) in the loop
		V element_to_return = null;
		int index_to_add_at = -1;
		for (int i = 0; i < tuplearray.size(); i++) {
			Tuple<K, V> t1 = tuplearray.get(i);
			int comparison = t.getKey().compareTo(t1.getKey());
			if (comparison < 0) {
				index_to_add_at = i;
				break;
			} else if (comparison == 0) {
				element_to_return = t1.getValue();
				index_to_add_at = i;
				break;
			}
		}
		if(index_to_add_at != -1)
		{
			if(element_to_return!=null)
			{
				tuplearray.remove(index_to_add_at);
				tuplearray.trimToSize();
				tuplearray.add(index_to_add_at,t);
			}
			else{
				tuplearray.add(index_to_add_at,t);
				tuplearray.trimToSize();
			}
		}
		else {
			tuplearray.add(t);
			tuplearray.trimToSize();
		}
		return element_to_return;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		if (o instanceof Map<?, ?>) {
			return ((Map<?, ?>) o).entrySet().equals(entrySet());
		}
		return false;
	}

	/**
	 * A tuple class.
	 * @author louiseadennis
	 *
	 * @param <K1>
	 * @param <V1>
	 */
	private class Tuple<K1 extends Comparable<? super K1>, V1> implements Comparable<Tuple<K1, V1>>, Map.Entry<K1, V1> {
		K1 key;
		V1 value;
		
		public Tuple (K1 k, V1 v) {
			key = k;
			value = v;
		}
		
		/**
		 * Return the key of the tuple.
		 */
		public K1 getKey() {
			return key;
		}
		
		/**
		 * Return the value of the tuple.
		 */
		public V1 getValue() {
			return value;
		}
		
		/**
		 * Returns true if the keys match.
		 * @param k
		 * @return
		 */
		public boolean matches(Object k) {
			return (key == null ? k == null : key.equals(k) );
		}
		
		/**
		 * Returns true if the values match.
		 * @param v
		 * @return
		 */
		public boolean valueMatch(Object v) {
			return (value == null ? v == null : value.equals(v));
		}
				
		/*
		 * (non-Javadoc)
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		public int compareTo(Tuple<K1, V1> t) {
			return t.getKey().compareTo(getKey());
		}
		
		/*
		 * (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			return key + "=" + value;
		}
		
		/*
		 * (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		public int hashCode() {
			return key.hashCode() + value.hashCode()*7;
		}
		
		/**
		 * Set the value of the tuple.
		 */
		public V1 setValue(V1 v) { 
			V1 oldvalue = value;
			value = v;
			return oldvalue;
		}
		
		/*
		 * (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@SuppressWarnings("unchecked")
		public boolean equals( Object other) { 
		    if (this == other) return true; 
		    if (other == null) return false;  
		    if (this.getClass() != other.getClass()) return false;
		    Tuple<?, ?> otherTuple = (Tuple<?, ?>) other; 
		    return (this.key.equals(otherTuple.key)  
		         && this.value.equals(otherTuple.value)); 
		  } 

	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return tuplearray.toString();
	}
	
	public VerifyMap<K, V> clone() {
		VerifyMap<K, V> clone = new VerifyMap();
		for (K k: keySet()) {
			clone.put(k, get(k));
		}
		return clone;
	}
} ///:~