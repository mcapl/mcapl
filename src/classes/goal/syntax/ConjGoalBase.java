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
import java.util.List;

import ail.syntax.Goal;
import ail.syntax.GoalBase;
import ail.syntax.Predicate;
import ail.syntax.Term;

public class ConjGoalBase extends GoalBase {
	ArrayList<ConjGoal> conjgoals = new ArrayList<ConjGoal>();
	
	public void add(ConjGoal cg) {
		conjgoals.add(cg);
		
		List<Term> goals = cg.getTerms();
		
		for (Term t: goals) {
			add(new Goal((Predicate) t, cg.getGoalType()));
		}
	}
	
	public void remove(ConjGoal cg) {
		conjgoals.remove(cg);
		
		for (Goal g: cg.getAtomicGoals()) {
			remove(g);
		}
	}
	
	public List<ConjGoal> getAllConjGoals() {
		return conjgoals;
	}

	public void cleanup() {
		List<ConjGoal> tbr = new ArrayList<ConjGoal>();
		for (ConjGoal cg: conjgoals) {
			tbr.add(cg);
		}
		for (ConjGoal cg: tbr) {
			remove(cg);
		}
	}

}
