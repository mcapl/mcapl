package hera.principles;

import java.util.ArrayList;

import hera.language.Impl;
import hera.language.Means;
import hera.semantics.CausalModel;
import hera.language.Forall;
import hera.language.Formula;
import hera.language.FormulaString;
import hera.language.Goal;

public class KantianHumanityPrincipleReading1 extends Principle {
	
	public KantianHumanityPrincipleReading1() {
		label = "KantianHumanityPrincipleReading1";
	}

	@Override
	public ArrayList<Boolean> _check() {
		// Populate Goals
		CausalModel cmodel = (CausalModel) model;
		if (cmodel.goals.isEmpty()) {
			for (String s: cmodel.goalbase) {
				// If the model achieves the goal then it is assumed to be the goal of the action.
				boolean isgoal = true;
				if (cmodel.world.containsKey(new FormulaString(s))) {
					if (cmodel.world.get(new FormulaString(s))) {
						isgoal = false;
					}				
				}
				if (isgoal & cmodel.models(new FormulaString(s))) {
					cmodel.addGoal(s);
				}
			}
		}
		
		
		FormulaString x = new FormulaString("__x__");
		Formula f1 = new Forall(x, new Impl(new Means(new FormulaString("Reading-1"), x), new Goal(x)));
		formulae.add(f1);
		result.add(model.models(f1));
		return result;
	}

	@Override
	public Boolean permissible() {
		_check();
		return result.get(0).equals(true);
	}

}
