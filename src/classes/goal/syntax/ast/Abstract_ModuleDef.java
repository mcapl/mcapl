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

import ail.syntax.Predicate;
import ail.syntax.ast.Abstract_Predicate;
import gov.nasa.jpf.vm.MJIEnv;

public class Abstract_ModuleDef {
	Abstract_Predicate name;
	int type = 100;
	
	public Abstract_ModuleDef(Abstract_Predicate p) {
		name = p;
	}
	
	public Abstract_ModuleDef(int i) {
		type = i;
	}

	public int newJPFObject(MJIEnv env) {
		int objref = env.newObject("goal.syntax.ast.Abstract_ModuleDef");
		if (name != null) {
			int nameref = name.newJPFObject(env);
			env.setReferenceField(objref, "name", nameref);
		}
		env.setIntField(objref, "type", type);
		return objref;
	}
	
	public boolean hasName() {
		return (name != null);
	}
	
	public Abstract_Predicate getName() {
		return name;
	}
}
