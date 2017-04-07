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

import ail.syntax.GBelief;
import ail.syntax.Goal;
import ail.syntax.Guard;
import ail.syntax.Predicate;
import ail.syntax.Term;

public class ConjGoal extends Goal {
	
	
	public ConjGoal() {
		super("conjgoal");
	}
	
	public void addConj(Predicate p) {
		addTerm(p);
	}
	
	public List<Goal> getAtomicGoals() {
		ArrayList<Goal> atoms = new ArrayList<Goal>();
		for (Term t: getTerms()) {
			atoms.add(new Goal((Predicate) t, getGoalType()));
		}
		return atoms;
	}
	
	public Guard getAsGuard() {
		Guard g = new Guard();
		for (Goal gl: getAtomicGoals()) {
			g.add(new GBelief(gl.getLogicalContent()));
		}
		return g;
	}

}
