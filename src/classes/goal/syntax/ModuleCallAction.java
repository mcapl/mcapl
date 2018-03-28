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
package goal.syntax;

import java.util.ArrayList;

import ail.syntax.Action;
import ail.syntax.Plan;
import ail.syntax.Term;
import ail.syntax.Unifier;

public class ModuleCallAction extends Action {
	GOALModule module;
	
	public ModuleCallAction() {
		this(new Action("module_call"), GOALModule.ModuleType.ANONYMOUS);
	}

	public ModuleCallAction(Action name) {
		this(name, GOALModule.ModuleType.USERDEF);
	}
	
	public ModuleCallAction(Action  name, GOALModule.ModuleType type) {
		super(name);
		module = new GOALModule(type, name);
	}

	public ModuleCallAction(GOALModule mcapl) {
		super("module_call");
		module = mcapl;
	}

	public void addActionRule(ActionRule r) {
		module.addActionRule(r);
	}

	public GOALModule getModule() {
		return module;
	}

	public Unifier getUnifier() {
		return new Unifier();
	}
	
	@Override
	public boolean apply(Unifier u) {
		boolean b = super.apply(u);
		//for (Plan r: module.getRules().getPlans()) {
		//	b = b && r.apply(u);
		//}
		//module.setRule(null);
		module.mergeModuleSubti(u);
		return b;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Action#clone()
	 */
	@Override
	public ModuleCallAction clone() {
		ModuleCallAction clone = new ModuleCallAction(module);
		// module.setRule(null);
		if (getTerms() != null) {
			for (Term term: getTerms()) {
				clone.addTerm((Term) term.clone()); 
			}
		}
		return clone;
	}
	
	public void resetModuleCall() {
		module.setRule(null);
	}
}
