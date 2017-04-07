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

import goal.semantics.executorStages.startCycleStage;
import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import ail.syntax.Predicate;
import goal.semantics.GOALAgent;
import java.util.Set;

public class ProcessPercepts implements OSRule {

	private startCycleStage scs;
	
	public ProcessPercepts(startCycleStage scs) {
		this.scs = scs;
	}

	@Override
	public boolean checkPreconditions(AILAgent a) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void apply(AILAgent a) {
		Set<Predicate> percepts = scs.getPercepts();
		// TODO Auto-generated method stub
		GOALAgent gag = (GOALAgent) a;
		gag.getMentalState().removePercepts();
		gag.getMentalState().addPercepts(percepts);
		// We don't update the goal state because this will be done by process messages 
		// which is executed next....
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
