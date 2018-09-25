// ----------------------------------------------------------------------------
// Copyright (C) 2018 Louise A. Dennis, Felix Lindner, Martin Moze Bentzen, Michael Fisher
//
// This file is part of Juno
//
// Juno is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Juno is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package hera.principles;

import java.util.ArrayList;

import hera.language.Impl;
import hera.language.Means;
import hera.semantics.CausalModel;
import hera.language.Forall;
import hera.language.Formula;
import hera.language.FormulaString;
import hera.language.Goal;

/**
 * Formulation of Kant's Categorical Imperative.  You may not use someone as a means to an end.
 * @author louisedennis
 *
 */
public class KantianHumanityPrincipleReading1 extends Principle {
	
	/**
	 * Constructor.
	 */
	public KantianHumanityPrincipleReading1() {
		label = "KantianHumanityPrincipleReading1";
	}

	/*
	 * (non-Javadoc)
	 * @see hera.principles.Principle#_check()
	 */
	@Override
	public ArrayList<Boolean> _check() {
		// Populate Goals
		CausalModel cmodel = (CausalModel) model;
		ArrayList<Formula> cons = ((CausalModel) model).getDirectConsequences();
		if (cmodel.goals.isEmpty()) {
			if (cmodel.intentions.isEmpty()) {
				for (String s: cmodel.goalbase) {
					// If the goal is not a direct consequence of the action then
					// is is assumed not to be a goal of the action.
					boolean isgoal = true;
					if (! cons.contains(new FormulaString(s))) {
						isgoal = false;
					}				
					if (isgoal & cmodel.models(new FormulaString(s))) {
						cmodel.addGoal(s);
					}
				}
			}
		}
		
		
		FormulaString x = new FormulaString("__x__");
		Formula f1 = new Forall(x, new Impl(new Means(new FormulaString("Reading-1"), x), new Goal(x)));
		f1.restrictopatients();
		formulae.add(f1);
		result.add(model.models(f1));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see hera.principles.Principle#permissible()
	 */
	@Override
	public int permissible() {
		_check();
		if ( result.get(0).equals(true) ) {
			return PERMISSIBLE;
		} else {
			return NOT_PERMISSIBLE;
		}
	}

}
