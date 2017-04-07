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

import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import goal.semantics.executorStages.ModuleExecutorStage;
import goal.syntax.GOALModule;
import goal.semantics.GOALAgent;

public class ModuleExit implements OSRule {
	ModuleExecutorStage mes;
	
	public ModuleExit(ModuleExecutorStage mes) {
		this.mes = mes;
	}

	@Override
	public boolean checkPreconditions(AILAgent a) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void apply(AILAgent a) {
		((GOALAgent) a).exitModule(mes.getModule());
		// TODO Auto-generated method stub
/*		mes.getModule().setModuleTerminated(true);
		if (mes.getModule().getType() == GOALModule.ModuleType.ANONYMOUS) {
			return;
		}
		
		switch(mes.getModule().getType()) {
		case EVENT:
		case INIT:
			((GOALAgent) a).setTopLevelContext(GOALModule.ModuleType.MAIN);
			break;
		default:
			break;
		}
		((GOALAgent) a).activeStackOfModules.pop(); */
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Exit Module";
	}

}
