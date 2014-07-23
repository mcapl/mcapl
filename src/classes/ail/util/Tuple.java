package ail.util;

import java.util.Random;

public class Tuple<K, L> {
	K left;
	L right;
	
	public Tuple(K k, L l) {
		left = k;
		right = l;
	}
	
	public K getLeft() {
		return left;
	}
	
	public L getRight() {
		return right;
	}
	
	public String toString() {
		String s = "<" + left + ", " + right + ">";
		return s;
	} 

}
