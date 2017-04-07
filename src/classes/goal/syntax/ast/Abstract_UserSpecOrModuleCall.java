// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis, Michael Fisher, and Koen Hindriks
// 
// This file is part of AIL GOAL.  An AIL Implementation of the GOAL Programming
// Language
//
// AIL GOAL is free software: you can redistribute it and/or modify it under
// the terms of the GNU General Public License as published by the Free Software
// Foundation, either version 3 of the License, or (at your option) any later
// version.
//
// AIL GOAL is distributed in the hope that it will be useful, but WITHOUT
// ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
// FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
// details.
//
// You should have received a copy of the GNU General Public License along with
// this program. If not, see <http://www.gnu.org/licenses/>.
//
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------
package goal.syntax.ast;

import gov.nasa.jpf.vm.MJIEnv;
import ail.syntax.ast.Abstract_Action;
import ail.syntax.ast.Abstract_Predicate;
import ail.syntax.ast.Abstract_Term;

public class Abstract_UserSpecOrModuleCall extends Abstract_Action {
	
	public Abstract_UserSpecOrModuleCall(Abstract_Predicate p) {
		super(p.getFunctor());
		for (Abstract_Term t: p.getTerms()) {
			super.addTerm(t);
		}
	}
	
	
	public int newJPFObject(MJIEnv env) {
		int objref = env.newObject("goal.syntax.ast.Abstract_UserSpecOrModuleCall");
		super.JPFFields(objref, env);
		return objref;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Abstract_Predicate) {
			Abstract_Predicate p = (Abstract_Predicate) o;
			if (getFunctor().equals(p.getFunctor())) {
				int size = getTerms().length;
				for (int i = 0; i < size; i++) {
					if (! getTerm(i).equals(p.getTerm(i))) {
						return false;
					}
				}
				return true;
			} else {
				return false;
			}
		} else {
			return super.equals(o);
		}

	} 
}
