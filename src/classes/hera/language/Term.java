// ----------------------------------------------------------------------------
// Copyright (C) 2018 Louise A. Dennis, Felix Lindner, Martin Moze Bentzen, Michael Fisher
//
// This file is part of Juno
//
// Juno is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Juno is distributed in the hope that it will be useful,
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

package hera.language;

import gov.nasa.jpf.vm.MJIEnv;

/**
 * A Term in the HERA representation.
 * @author louisedennis
 *
 */
public class Term {
	// Most terms have two sub-terms.
	public Term t1;
	public Term t2;
	
	/**
	 * COnstructor.
	 * @param t1
	 * @param t2
	 */
	public Term(Term t1, Term t2) {
		this.t1 = t1;
		this.t2 = t2;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Term) {
			return t1 == ((Term) o).t1 && t2 == ((Term) o).t2;
		}
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		if (t2 != null) {
			return t1.hashCode() + t2.hashCode();
		} else {
			return t1.hashCode();
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
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
	
	/**
	 * If this object has been constructed in the native JVM during model-checking then
	 * this method allows it to be recreated in the JPF JVM.
	 * @param env
	 * @return
	 */
	public int newJPFObject(MJIEnv env) {
		if (this instanceof IntegerTerm) {
			int ref = env.newObject("hera.language.IntegerTerm");
			env.setIntField(ref, "i", ((IntegerTerm) this).getInt());
			return ref;
		}
				
		if (this instanceof U) {
			int ref = env.newObject("hera.language.U");
			int t1ref = t1.newJPFObject(env);
			env.setReferenceField(ref, "t1", t1ref);
			return ref;
		}
		if (this instanceof DR) {
			int ref = env.newObject("hera.language.DR");
			int t1ref = t1.newJPFObject(env);
			int t2ref = t2.newJPFObject(env);
			env.setReferenceField(ref, "t1", t1ref);
			env.setReferenceField(ref, "t2", t2ref);
			return ref;
		}
		if (this instanceof DB) {
			int ref = env.newObject("hera.language.DB");
			int t1ref = t1.newJPFObject(env);
			int t2ref = t2.newJPFObject(env);
			env.setReferenceField(ref, "t1", t1ref);
			env.setReferenceField(ref, "t2", t2ref);
			return ref;
		}
		if (this instanceof Minus) {
			int ref = env.newObject("hera.language.Minus");
			int t1ref = t1.newJPFObject(env);
			env.setReferenceField(ref, "t1", t1ref);
			return ref;
		}
		if (this instanceof Sub) {
			int ref = env.newObject("hera.language.Sub");
			int t1ref = t1.newJPFObject(env);
			int t2ref = t2.newJPFObject(env);
			env.setReferenceField(ref, "t1", t1ref);
			env.setReferenceField(ref, "t2", t2ref);
			return ref;
		}
		if (this instanceof Add) {
			int ref = env.newObject("hera.language.Add");
			int t1ref = t1.newJPFObject(env);
			int t2ref = t2.newJPFObject(env);
			env.setReferenceField(ref, "t1", t1ref);
			env.setReferenceField(ref, "t2", t2ref);
			return ref;
		}
		if (this instanceof FormulaTerm) {
			int ref = env.newObject("hera.language.FormulaTerm");
			int fref = ((FormulaTerm) this).getFormula().newJPFObject(env);
			env.setReferenceField(ref, "f", fref);
			return ref;
			
		}

		return 0;
	}


}
