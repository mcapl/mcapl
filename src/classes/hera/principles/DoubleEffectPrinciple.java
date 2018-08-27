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
import hera.language.Term;
import hera.language.U;
import hera.semantics.CausalModel;
import hera.semantics.Model;

public class DoubleEffectPrinciple extends Principle {
	ArrayList<Formula> cons;
	
	public DoubleEffectPrinciple() {
		label = "Double Effect Principle";
	}
	
	public void init(Model m) {
		model = m;
	}
	
	public Formula _condition1() {
		return new Geq(new U(((CausalModel) model).action), new IntegerTerm(0));
	}
	
	public Formula _condition2a() {
		FormulaString x = new FormulaString("__x__");
		return new Forall(x, new Impl(new I(x), new Geq(new U(x), new IntegerTerm(0))));
	}
	
	public Formula _condition2b() {
		FormulaString x = new FormulaString("__x__");
		return new Exists(x, new And(new I(x), new Gt(new U(x), new IntegerTerm(0))));
	}
	
	public Formula _condition3() {
		FormulaString x = new FormulaString("__x__");
		FormulaString y = new FormulaString("__y__");
		return new Forall(x, new Forall(y, new Impl(new And(new Causes(x, y), new Gt(new IntegerTerm(0), new U(x))), new Gt(new IntegerTerm(0), new U(y)))));
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

	@Override
	public ArrayList<Boolean> _check() {
		cons = ((CausalModel) model).getDirectConsequences();
		
		CausalModel cmodel = (CausalModel) model;
		if (cmodel.intentions.isEmpty()) {
			for (String s: cmodel.goalbase) {
				// If the model achieves the goal then it is assumed to be the goal of the action.
				boolean isgoal = true;
				if (cmodel.world.containsKey(new FormulaString(s))) {
					if (cmodel.world.get(new FormulaString(s))) {
						isgoal = false;
					}				
				}
				if (isgoal & cmodel.models(new FormulaString(s))) {
					ArrayList<Formula> cs = cmodel.getDirectConsequences();
					ArrayList<String> intentions = new ArrayList<String>();
					for (Formula c: cs) {
						ArrayList<Formula> goals = new ArrayList<Formula>();
						goals.add(c);
						if (cmodel.path(goals, new FormulaString(s), new ArrayList<Formula>())) {
							System.err.println(cmodel.action + " " + c);
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
			result = null;
			return null;
		}
		for (Formula f: formulae) {
			result.add(model.models(f));
			// System.err.println(f);
		}
		cmodel.clearIntentions();
		return result;
	}

	@Override
	public Boolean permissible() {
		_check();
		if (result == null) return null;
		else {
			ArrayList<Boolean> trues = new ArrayList<Boolean>();
			trues.add(true);
			trues.add(true);
			trues.add(true);
			trues.add(true);
			trues.add(true);
			return result.equals(trues);
		}
	}

}
