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

import java.util.ArrayList;

import goal.syntax.ConjGoal;
import gov.nasa.jpf.vm.MJIEnv;
import ail.syntax.Goal;
import ail.syntax.StringTerm;
import ail.syntax.ast.Abstract_BaseAILStructure;
import ail.syntax.ast.Abstract_Goal;
import ail.syntax.ast.Abstract_Predicate;
import ail.syntax.ast.Abstract_Term;

public class Abstract_ConjGoal extends Abstract_Goal {
	
	Abstract_Predicate[] goals = new Abstract_Predicate[0];

	public Abstract_ConjGoal(ArrayList<Abstract_Term> tl) {
		super(new Abstract_Predicate(), Abstract_Goal.achieveGoal);
		for (Abstract_Term t: tl) {
			addGoal((Abstract_Predicate) t);
		}		
	}
	
	public void addGoal(Abstract_Predicate p) {
		int newsize = goals.length + 1;
		Abstract_Predicate[] newgoals = new Abstract_Predicate[newsize];
		for (int i = 0; i < goals.length; i++) {
			newgoals[i] = goals[i];
		}
		newgoals[goals.length] = p;
		goals = newgoals;
	}

	public ConjGoal toMCAPL() {
		ConjGoal g = new ConjGoal();
		for (Abstract_Predicate gl: goals) {
			g.addConj(gl.toMCAPL());
		}
		g.setGoalBase((StringTerm) getGoalBase().toMCAPL());
		return g;
		
	}
	
    public int newJPFObject(MJIEnv env) {
    	int objref = env.newObject("goal.syntax.ast.Abstract_ConjGoal");
    	int gRef = env.newObjectArray("ail.syntax.Abstract_Predicate", goals.length);
       	for (int i = 0; i < goals.length; i++) {
       		env.setReferenceArrayElement(gRef, i, goals[i].newJPFObject(env));
       	}
      	env.setReferenceField(objref, "goals", gRef);
		env.setReferenceField(objref, "functor", env.newString(getFunctor()));
		env.setReferenceField(objref, "terms", newJPFTermArray(env));
		env.setIntField(objref, "goaltype", getGoalType());
		env.setReferenceField(objref, "goalbase", goalbase.newJPFObject(env));
		env.setBooleanField(objref, "isVariable", isVariable());
      	return objref;
   }

}
