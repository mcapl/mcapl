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

import goal.syntax.PrintAction;
import gov.nasa.jpf.vm.MJIEnv;

import java.util.ArrayList;

import ail.syntax.Action;
import ail.syntax.Predicate;
import ail.syntax.ast.Abstract_Deed;
import ail.syntax.ast.Abstract_Literal;
import ail.syntax.ast.Abstract_Predicate;
import ail.syntax.ast.Abstract_Term;
import ail.syntax.ast.Abstract_Action;

public class Abstract_PrintAction extends Abstract_Action {
	public Abstract_PrintAction() {
		super("print");
	}
	
	@Override
	public void addParams(ArrayList<Abstract_Term> tl) {
		addTerm(tl.get(0));
	}
	
	@Override
	public PrintAction toMCAPL() {
		return new PrintAction(super.toMCAPL());
	}
	
	@Override
	public int newJPFObject(MJIEnv env) {
		int objref = env.newObject("goal.syntax.ast.Abstract_PrintAction");
		JPFFields(objref, env);
		return objref;
	}
}
