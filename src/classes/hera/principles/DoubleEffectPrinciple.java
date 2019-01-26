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

import hera.language.And;
import hera.language.Causes;
import hera.language.Exists;
import hera.language.Forall;
import hera.language.Formula;
import hera.language.FormulaString;
import hera.language.Geq;
import hera.language.Gt;
import hera.language.I;
import hera.language.Impl;
import hera.language.IntegerTerm;
import hera.language.U;
import hera.semantics.CausalModel;
import hera.semantics.Model;

/**
 * Formulation of the Double Effect Principle.
 * @author louisedennis
 *
 */
public class DoubleEffectPrinciple extends Principle {
	ArrayList<Formula> cons;
	
	public boolean notapplicable = false;
	
	/**
	 * Constructor.
	 */
	public DoubleEffectPrinciple() {
		label = "Double Effect Principle";
	}
	
	/**
	 * The priniciple is initialised with a Hera model.
	 */
	public void init(Model m) {
		model = m;
	}
	
	// The principle is represented by a set of formulae.  Each of these is constructed
	// using a method.
	public Formula _condition1() {
		return new Geq(new U(((CausalModel) model).action), new IntegerTerm(0));
	}
	
	public Formula _condition2a() {
		FormulaString x = new FormulaString("__x__");
		Formula f = new Forall(x, new Impl(new I(x), new Geq(new U(x), new IntegerTerm(0))));
		f.restrictoevents(); 
		return f;
	}
	
	public Formula _condition2b() {
		FormulaString x = new FormulaString("__x__");
		return new Exists(x, new And(new I(x), new Gt(new U(x), new IntegerTerm(0))));
	}
	
	public Formula _condition3() {
		FormulaString x = new FormulaString("__x__");
		FormulaString y = new FormulaString("__y__");
		Formula f1 = new Forall(y, new Impl(new And(new Causes(x, y), new Gt(new IntegerTerm(0), new U(x))), new Gt(new IntegerTerm(0), new U(y))));
		f1.restrictoevents();
		Formula f = new Forall(x, f1);
		f.restrictoevents();
		return f;
	}
	
	public Formula _condition4() {
		Formula f = null;
		for (Formula c : cons) {
			if (f == null) {
				f = c;
			} else {
				f = new And(f, c);
			}
		}
		return new Gt(new U(f), new IntegerTerm(0));
	}

	/*
	 * (non-Javadoc)
	 * @see hera.principles.Principle#_check()
	 */
	@Override
	public ArrayList<Boolean> _check() {
		cons = ((CausalModel) model).getDirectConsequences();
		
		CausalModel cmodel = (CausalModel) model;
		if (cmodel.intentions.isEmpty()) {
			for (String s: cmodel.goalbase) {
				// If the goal is not a direct consequence of the action then
				// is is assumed not to be a goal of the action.
				boolean isgoal = true;
				if (! cons.contains(new FormulaString(s))) {
				//if (cmodel.world.containsKey(new FormulaString(s))) {
				//	if (cmodel.world.get(new FormulaString(s))) {
						isgoal = false;
				//	}				
				}
				if (isgoal & cmodel.models(new FormulaString(s))) {
					ArrayList<Formula> cs = cmodel.getDirectConsequences();
					ArrayList<String> intentions = new ArrayList<String>();
					for (Formula c: cs) {
						ArrayList<Formula> goals = new ArrayList<Formula>();
						goals.add(c);
						if (cmodel.path(goals, new FormulaString(s), new ArrayList<Formula>())) {
							// System.err.println(cmodel.action + " " + c);
							intentions.add(((FormulaString) c).getString());
						}
					}
					cmodel.setIntention(cmodel.action, intentions);
				}
			}
		}

		
		
		formulae.add(_condition1());
		formulae.add(_condition2a());
		formulae.add(_condition2b());
		formulae.add(_condition3());
		formulae.add(_condition4());
		
		if (cons.size() == 0) {
			notapplicable = true;
			result = null;
			return new ArrayList<Boolean>();
		}
		for (Formula f: formulae) {
			result.add(model.models(f));
			// System.err.println(f);
		}
		cmodel.clearIntentions();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see hera.principles.Principle#permissible()
	 */
	@Override
	public int permissible() {
		_check();
		if (result == null) return NOT_APPLICABLE;
		else {
			ArrayList<Boolean> trues = new ArrayList<Boolean>();
			trues.add(true);
			trues.add(true);
			trues.add(true);
			trues.add(true);
			trues.add(true);
			if ( result.equals(trues) ) {
				return PERMISSIBLE;
			} else {
				return NOT_PERMISSIBLE;
			}
		}
	}

}
