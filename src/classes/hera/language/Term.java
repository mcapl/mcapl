// ----------------------------------------------------------------------------
// Copyright (C) 2018 Louise A. Dennis, Martin Mose Bentzen, Michael Fisher 
// 
// This file is part of HERA Java Implementation
// 
// HERA Java is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// HERA Java is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with HERA Java; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package hera.language;

public class Term {
	public Term t1;
	public Term t2;
	
	public Term(Term t1, Term t2) {
		this.t1 = t1;
		this.t2 = t2;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Term) {
			return t1 == ((Term) o).t1 && t2 == ((Term) o).t2;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		if (t2 != null) {
			return t1.hashCode() + t2.hashCode();
		} else {
			return t1.hashCode();
		}
	}
	
	@Override
	public String toString() {
		String t1s = "";
		String t2s = "";
		
		if (t1 != null && t1 instanceof IntegerTerm) {
			t1s =  "'" + ((IntegerTerm) t1).getInt() + "'";
		} else if (t1 != null) {
			t1s = t1.toString();
		}
		
		
		if (t2 != null && t2 instanceof IntegerTerm) {
			t2s =  "'" + ((IntegerTerm) t2).getInt() + "'";
		} else if (t2 != null ){
			t1s = t2.toString();
		}
		
		if (this instanceof U) {
			return "U(" + t1s + ")";
		}
		if (this instanceof DR) {
			return "DR(" + t1s + ", " + t2s + ")";
		}
		if (this instanceof DB) {
			return "DB(" + t1s + ", " + t2s + ")";
		}
		if (this instanceof Minus) {
			return "Minus(" + t1s + ")";
		}
		if (this instanceof Sub) {
			return "Sub(" + t1s + ", " + t2s + ")";
		}
		if (this instanceof Add) {
			return "Add(" + t1s + ", " + t2s + ")";
		}
		
		return "";

	}

}
