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

import goal.syntax.GOALModule;
import goal.syntax.ModuleCallAction;
import gov.nasa.jpf.vm.MJIEnv;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ail.syntax.ast.Abstract_Action;
import ail.syntax.ast.Abstract_Deed;
import ail.syntax.ast.Abstract_Guard;
import ail.syntax.ast.Abstract_Predicate;
import ail.syntax.ast.Abstract_VarTerm;

public class Abstract_ModuleCallAction extends Abstract_Action {
	
	Abstract_ActionRule[] rules = new Abstract_ActionRule[0];
	Abstract_GOALModule module;

	public Abstract_ModuleCallAction(Abstract_Guard context, List<Abstract_ActionRule> rules) {
		super("module_call");
		Set<String> thisvarnames = new HashSet<String>();
		thisvarnames.add("Any");
		for (String s: context.toMCAPL().getVarNames()) {
			if (!thisvarnames.contains(s)) {
				this.addTerm(new Abstract_VarTerm(s));
				thisvarnames.add(s);
			}
		}
		for (Abstract_ActionRule rule: rules) {
			addRule(rule);
			for (String s: rule.toMCAPL().getVarNames()) {
				if (!thisvarnames.contains(s) && !s.startsWith("_")) {
					this.addTerm(new Abstract_VarTerm(s));
					thisvarnames.add(s);
				}
			}
		}
	}
	
	public Abstract_ModuleCallAction(Abstract_Predicate dp) {
		super(dp);
	}

	public Abstract_ModuleCallAction(Abstract_GOALModule abstract_GOALModule) {
		super("module_call");
		module = abstract_GOALModule;
	}

	public void addRule(Abstract_ActionRule rule) {
		int newsize = rules.length + 1;
		Abstract_ActionRule[] newrules = new Abstract_ActionRule[newsize];
		for (int i = 0; i < rules.length; i++) {
			newrules[i] = rules[i];
		}
		newrules[rules.length] = rule;
		rules = newrules;

	}
	
	public ModuleCallAction toMCAPL() {
		if (module == null) {
			ModuleCallAction mca;
			if (this.getFunctor().equals("module_call")) {
				mca = new ModuleCallAction(super.toMCAPL(), GOALModule.ModuleType.ANONYMOUS);
			} else {
				mca = new ModuleCallAction(super.toMCAPL(), GOALModule.ModuleType.USERDEF);
			}
			for (Abstract_ActionRule rule: rules) {
				mca.addActionRule(rule.toMCAPL());
			}
			return mca;
		} else {
			return new ModuleCallAction(module.toMCAPL());
		}
	}
	
	public int newJPFObject(MJIEnv env) {
    	int objref = env.newObject("goal.syntax.ast.Abstract_ModuleCallAction");
		int rRef = env.newObjectArray("goal.syntax.ast.Abstract_Rule", rules.length);
		for (int i = 0; i < rules.length; i++) {
			env.setReferenceArrayElement(rRef, i, rules[i].newJPFObject(env));
		}
		super.JPFFields(objref, env);
		env.setReferenceField(objref, "rules", rRef);
		return objref;

	}
}
