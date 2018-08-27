package hera.principles;

import java.util.ArrayList;

import hera.language.And;
import hera.language.BooleanFormula;
import hera.language.Formula;
import hera.language.Geq;
import hera.language.Term;
import hera.language.U;
import hera.semantics.CausalModel;
import hera.semantics.Model;

public class UtilitarianPrinciple extends Principle {
	
	public UtilitarianPrinciple() {
		label = "Utilitarianism";
	}
	
	@Override
	public ArrayList<Boolean> _check() {
		CausalModel cmodel = (CausalModel) model;
		Term u = new U(Formula.makeConjunction(((CausalModel) model).getAllConsequences()));
		ArrayList<Term> v = new ArrayList<Term>();
		for (Model w: model.alternatives) {
			if (! model.equals(w)) {
				v.add(new U(Formula.makeConjunction(((CausalModel) w).getAllConsequences())));
			}
		}
		
		Formula f = null;
		for (Term w: v) {
			// System.err.println(w);
			if (f == null ) {
				f = new Geq(u, w);
			} else {
				f = new And(f, new Geq(u, w));
			}
		}
		
		if (f == null) {
			f = new BooleanFormula(true);
		}
		
		formulae.add(f);
		result.add(model.models(f));
		return result;
	}

	@Override
	public Boolean permissible() {
		_check();
		return result.get(result.size() - 1);
	}

}
