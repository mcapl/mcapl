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
package goal.semantics.operationalrules;

import java.util.Iterator;

import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import goal.semantics.executorStages.ModuleExecutorStage;
import goal.syntax.ConjGoal;
import goal.syntax.GOALModule;
import goal.semantics.GOALAgent;
import ail.syntax.BeliefBase;
import ail.syntax.Capability;
import ail.syntax.Goal;
import ail.syntax.Literal;
import ail.syntax.Rule;

public class ModuleInitialisation implements OSRule {
	ModuleExecutorStage mes;
	
	public ModuleInitialisation(ModuleExecutorStage mes) {
		this.mes = mes;
	}

	@Override
	public boolean checkPreconditions(AILAgent a) {
		// TODO Auto-generated method stub
		return mes.first();
	}

	@Override
	public void apply(AILAgent a) {
		GOALModule m = mes.getModule();
		((GOALAgent) a).enteredModule(m);
		for (Literal l: m.getBB().getAll()) {
			a.addBel(l, BeliefBase.TSelf);
		}
				
		for (Rule r : m.getRuleBase().getAll()) {
			a.addRule(r);
		}
		
		for (ConjGoal g: m.getGB().getAllConjGoals()) {
			((GOALAgent) a).adopt(g);
		}
		
		if (mes.getModule().getType() == GOALModule.ModuleType.INIT) {
			Iterator<Capability> initcaps = m.getCL().iterator();
			while (initcaps.hasNext()) {
				a.addCap(initcaps.next());
			}
		}
		// TODO Auto-generated method stub
		// Add module beliefs to agent
		// Adopt modules goals 
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Module Initialisation";
	}

}
