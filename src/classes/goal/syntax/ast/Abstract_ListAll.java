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

import goal.syntax.ListAll;
import goal.syntax.MentalState;
import gov.nasa.jpf.vm.MJIEnv;

import java.util.Iterator;
import java.util.List;

import ail.semantics.AILAgent.SelectionOrder;
import ail.semantics.AgentMentalState;
import ail.syntax.GLogicalFormula;
import ail.syntax.Unifiable;
import ail.syntax.Unifier;
import ail.syntax.ast.Abstract_GLogicalFormula;
import ail.syntax.ast.Abstract_VarTerm;

public class Abstract_ListAll implements Abstract_GLogicalFormula {
	Abstract_VarTerm v;
	Abstract_MentalState ms;
	
	public Abstract_ListAll(Abstract_VarTerm v, Abstract_MentalState ms) {
		this.v = v;
		this.ms = ms;
	}

	@Override
	public ListAll toMCAPL() {
		return new ListAll(v.toMCAPL(), ms);
	}

	@Override
	public int newJPFObject(MJIEnv env) {
    	int objref = env.newObject("goal.syntax.ast.Abstract_ListAll");
    	env.setReferenceField(objref, "v", v.newJPFObject(env));
    	env.setReferenceField(objref, "ms", ms.newJPFObject(env));
    	return objref;
	}

	@Override
	public boolean isTrivial() {
		return false;
	}
	
	@Override
	public String toString() {
		String s = "listall " +  v.toString();
		s += " <- ";
		s += ms.toString();
		return s;
	}
}
