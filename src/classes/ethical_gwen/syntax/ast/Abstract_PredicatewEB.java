// ----------------------------------------------------------------------------
// Copyright (C) 2016 Louise A. Dennis, Michael Fisher, Marija Slavkovik and Matt Webster
// 
// This file is part of Ethical Gwendolen
//
// Ethical Gwendolen is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Ethical Gwendolen is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with Ethical Gwendolen if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------
package ethical_gwen.syntax.ast;

import java.util.HashMap;

import ethical_gwen.syntax.PredicatewEB;
import gov.nasa.jpf.vm.MJIEnv;
import ail.syntax.Predicate;
import ail.syntax.Term;
import ail.syntax.ast.Abstract_Predicate;
import ail.syntax.ast.Abstract_Term;

public class Abstract_PredicatewEB extends Abstract_Predicate {
	static HashMap<String,Integer> strings = new HashMap<String,Integer>();
	String eb;
	
	public Abstract_PredicatewEB(Abstract_Predicate t, String w) {
		super(t.getFunctor());
		setTerms(t.getTerms());
		eb = w;
		
	}
	
	public PredicatewEB toMCAPL() {
		Predicate s = new Predicate(getFunctor());
		for (Abstract_Term t: getTerms()) {
			s.addTerm((Term) t.toMCAPL());
		}
		return new PredicatewEB(s, eb);

	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.ast.Abstract_MCAPLTerm#newJPFObject(gov.nasa.jpf.jvm.MJIEnv)
	 */
	public int newJPFObject(MJIEnv env) {
		int ref = env.newObject("ethical_gwen.syntax.ast.Abstract_PredicatewEB");
		if (strings.containsKey(getFunctor())) {
			env.setReferenceField(ref, "functor", strings.get(getFunctor()));
		} else {
			int stringref = env.newString(getFunctor());
			strings.put(getFunctor(), stringref);
			env.setReferenceField(ref, "functor", stringref);
		}
		env.setReferenceField(ref, "terms", newJPFTermArray(env));
		env.setReferenceField(ref, "eb", env.newString(eb));
		return ref;

	}



}
