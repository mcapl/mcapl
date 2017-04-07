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

import java.util.ArrayList;

import goal.syntax.GOALModule;
import ail.semantics.AILAgent;
import ail.semantics.operationalrules.HandleDropGeneralGoal;

public class GOALHandleDropGeneralGoal extends HandleDropGeneralGoal implements
		ActionExecutorInterface {
	
	public GOALHandleDropGeneralGoal(ArrayList<Integer> list) {
		super(list);
	}

	GOALModule module;
	
	public void apply(AILAgent a) {
		super.apply(a);
		module.clearRuleItIfNotApplyAll();
	}

	@Override
	public void setModule(GOALModule m) {
		module = m;
	}

}
