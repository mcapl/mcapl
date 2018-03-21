package hera.semantics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import ail.util.Tuple;
import hera.language.Add;
import hera.language.Affects;
import hera.language.AffectsNeg;
import hera.language.AffectsPos;
import hera.language.And;
import hera.language.Causes;
import hera.language.Consequence;
import hera.language.DB;
import hera.language.DR;
import hera.language.Exists;
import hera.language.Explains;
import hera.language.Forall;
import hera.language.Formula;
import hera.language.FormulaString;
import hera.language.FormulaTerm;
import hera.language.Geq;
import hera.language.Goal;
import hera.language.Gt;
import hera.language.I;
import hera.language.Impl;
import hera.language.IntegerTerm;
import hera.language.Intervention;
import hera.language.K;
import hera.language.Means;
import hera.language.Minus;
import hera.language.Not;
import hera.language.Or;
import hera.language.PCauses;
import hera.language.Prevents;
import hera.language.SCauses;
import hera.language.Sub;
import hera.language.Term;
import hera.language.TermFormula;
import hera.language.U;

public class CausalModelChecker extends Checker {
	
	public boolean _intended(ArrayList<String> intentions, Formula formula) {
		if (formula instanceof FormulaString) {
			return intentions.contains(((FormulaString) formula).getString());
		} else if (formula instanceof And) {
			boolean and1 = _intended(intentions, ((And) formula).f1);
			boolean and2 = _intended(intentions, ((And) formula).f2);
			return (and1 && and2);
		}
		
		return false;
	}
	
	public boolean _affects(ArrayList<Tuple<String, String>> affects, Formula f, String posneg) {
		if (f instanceof FormulaString) {
			for (Tuple<String, String> i: affects) {
				if (i.getLeft().equals(((FormulaString) f).getString())) {
					if (i.getRight().equals(posneg)) {
						return true;
					}
				}
			}
		} else if (f instanceof And) {
			boolean and1 = _affects(affects, ((And) f).f1, posneg);
			boolean and2 = _affects(affects, ((And) f).f2, posneg);
			return (and1 && and2);
		}
		
		return false;
	}
	
	public Double evaluateTerm(CausalModel m, Term t) {
		if (t instanceof IntegerTerm) {
			return new Double(((IntegerTerm) t).getInt());
		}
		
		if (t instanceof Minus) {
			return -1*evaluateTerm(m, t.t1);
		}
		
		if (t instanceof Add) {
			return evaluateTerm(m, t.t1) + evaluateTerm(m, t.t2);
		}
		
		if (t instanceof Sub) {
			return evaluateTerm(m, t.t1) - evaluateTerm(m, t.t2);
		}
		
		if (t instanceof U) {
			return _sumUp(m, ((U) t).getFormula());
		}
		
		if (t instanceof DR) {
			return _computeDR(m, ((FormulaTerm) t.t1).getFormula(), ((FormulaTerm) t.t2).getFormula());
		}
		
		if (t instanceof DB) {
			return _computeDB(m, ((FormulaTerm) t.t1).getFormula(), ((FormulaTerm) t.t2).getFormula());
		}
		
		return null;
	}
	
	public double _computeDB(CausalModel model, Formula f1, Formula f2) {
		double r = 0;
		for (Model w: model.epistemic) {
			CausalModel cw = (CausalModel) w;
			r = r + w.probability * ((CausalModelChecker) cw.checker)._computeDR(model, f1, f2);
		}
		return r;
	}
	
	public double _computeDR(CausalModel model, Formula f1, Formula f2) {
		Tuple<Boolean, Formula> bc = _partialCause(model, new PCauses(f1, f2));
		if (! bc.getLeft()) { return 0; }
		else {
			Tuple<Boolean, ArrayList<Formula>> bw = _findWitness(model, new Causes(bc.getRight(), f2));
			return 1/bw.getRight().size();
		}
	}
	
	public Double _sumUp(CausalModel model, Formula formula) {
		if (formula == null) { return new Double(0); }
		// AARGH BOOL
		if (formula instanceof FormulaString) {
			if (model.utilities.containsKey(((FormulaString) formula).getString())) {
				return model.utilities.get(((FormulaString) formula).getString());
			} else {
				return new Double(0);
			}
		}
		
		if (formula instanceof Not) {
			if (formula.f1 instanceof FormulaString) {
				if (model.utilities.containsKey(((FormulaString) formula.f1).getString())) {
					return model.utilities.get(((FormulaString) formula.f1).getString());
				} else {
					return new Double(0);
				}				
			} else if (formula.f1 instanceof Not) {
				return _sumUp(model, formula.f1.f1);
			}
		}
		
		if (formula  instanceof And) {
			return _sumUp(model, formula.f1) + _sumUp(model, formula.f2);
		}
		
		return null;
	}
	
	public boolean _allAreIndirectParents(CausalModel model, Formula p, Formula e) {
		ArrayList<Formula> pLit = new ArrayList<Formula>();
		if (p instanceof FormulaString) {
			pLit.add(p);
		} else {
			pLit.addAll(p.getPosLiteralsEvent());
		}
		return processLiterals(model, pLit, e);
	}
	
	public boolean _allAreIndirectParentsSet(CausalModel model, HashSet<Formula> p, Formula e) {
		ArrayList<Formula> pLit = new ArrayList<Formula>();
		for (Formula pf: p) {
			pLit.add(pf);
		}
		return processLiterals(model, pLit, e);
	}

	public boolean processLiterals(CausalModel model, ArrayList<Formula> pLit, Formula e) {
		
		ArrayList<Formula> eLit = new ArrayList<Formula>();
		
		if (e instanceof FormulaString) {
			eLit.add(e);
		} else {
			eLit.addAll(e.getPosLiteralsEvent());
		}
		
		for (Formula l1: pLit) {
			boolean found = false;
			for (Formula l2: eLit) {
				ArrayList<Formula> l1list = new ArrayList<Formula>();
				l1list.add(l1);
				if (model.path(l1list, l2, new ArrayList<Formula>())) {
					found = true;
					break;
				}
			}
			
			if (! found) {
				return false;
			}
		}
		
		return true;
	}
	
	public Tuple<Boolean, ArrayList<Formula>> _findWitness(CausalModel model, Causes formula) {
		ArrayList<Formula> maybeCause = new ArrayList<Formula>();
		if (formula.f1 instanceof FormulaString) {
			maybeCause.add(formula.f1);
		} else {
			maybeCause.addAll(formula.f1.getAllLiteralsEvent());
		}
		
		model.setFlippedIntervention(maybeCause);
		
		ArrayList<Formula> cs = new ArrayList<Formula>();
		for (String c: model.consequences) {
			FormulaString cf = new FormulaString(c);
			if (!maybeCause.contains(cf)) {
				cs.add(cf);
			}
		}
		
		for (HashSet<Formula> w: model.powerset(cs)) {
			if (w.size() == 0 || _allAreIndirectParentsSet(model, w, formula.f2)) {
				model.setInterventionWithVariablesFixedToOriginal(w);
				boolean check = models(model, formula.f2);
				model.clearIntervention();
				
				if (check == false) {
					if (formula.f1 instanceof FormulaString) {
						maybeCause.addAll(w);
						return new Tuple<Boolean, ArrayList<Formula>>(true, maybeCause);
					}
					
					boolean found = false;
					for (HashSet<Formula> s: model.powerset(maybeCause)) {
						if (s.size() > 0 && s.size() < maybeCause.size()) {
							Formula f = Formula.makeConjunction(s);
							if (model.models(new Causes(f, formula.f2))) {
								found = true;
								break;
							}
						}
					}
					
					if (! found) {
						maybeCause.addAll(w);
						return new Tuple<Boolean, ArrayList<Formula>>(true, maybeCause);
					}
				}
			}
		}
		
		return new Tuple<Boolean, ArrayList<Formula>>(false, new ArrayList<Formula>());
	}
	
	public Tuple<Boolean, Formula> _partialCause(CausalModel model, PCauses formula) {
		if (models(model, new Causes(formula.f1, formula.f2))) {
			return new Tuple(true, formula.f1);
		}
		
		ArrayList<String> lits = new ArrayList<String>();
		lits.addAll(model.background);
		lits.addAll(model.actions);
		lits.addAll(model.consequences);
		
		ArrayList<Formula> allLits = new ArrayList<Formula>();
		for (String s: lits) {
			if (models(model, new FormulaString(s))) {
				allLits.add(new FormulaString(s));
			} else {
				allLits.add(new Not(new FormulaString(s)));
			}
		}
			
		ArrayList<Formula> formulaLit = new ArrayList<Formula>();
		if (formula.f1 instanceof FormulaString) {
			formulaLit.add(formula.f1);
		} else {
			formulaLit.addAll(formula.f1.getAllLiteralsEvent());
		}
			
		ArrayList<Formula> l = new ArrayList<Formula>();
		for (Formula e: allLits) {
			if (! formulaLit.contains(e)) {
				l.add(e);
			}
		}
		for (HashSet<Formula> x: model.powerset(l) ) {
			Formula f = Formula.makeConjunction(x);
			if (f != null) {
				if (models(model, new Causes(new And(formula.f1, f), formula.f2))) {
					return new Tuple<Boolean, Formula>(true, (new And(formula.f1, f)));
				}
			}
		}
		return new Tuple<Boolean, Formula>(false, null);
		
		
	}
	
	public boolean _sufficientCauseInEveryModel(Model model, Formula f1, Formula f2) {
		Formula f = new And(f1, f2);
		ArrayList<Model> w_f = model.getEpistemicAlternatives(f);
		for (Model w: w_f) {
			if (!w.models(new SCauses(f1, f2))) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean models(Model m, Formula formula) {
		CausalModel model = (CausalModel) m;
		/// AAARGH bool
		if (formula instanceof FormulaString) {
			if (model.intervention.containsKey(formula)) {
				return model.intervention.get(formula);
			}
			if (model.world.containsKey(formula)) {
				return model.world.get(formula);
			}
			if (model.mechanisms.containsKey(((FormulaString) formula).getString())) {
				return models(model, model.mechanisms.get(((FormulaString) formula).getString()));
			}
		}
		
		if (formula instanceof Not) {
			return (! models(model, formula.f1));
		}
		
		if (formula instanceof Or) {
			return (models(model, formula.f1) || models(model, formula.f2));
		}
		
		if (formula instanceof And) {
			return (models(model, formula.f1) && models(model, formula.f2));			
		}
		
		if (formula instanceof Impl) {
			return (! models(model, formula.f1) || models(model, formula.f2));			
		}
		
		if (formula instanceof I) {
			return _intended(model.intentions.get(model.action), formula.f1);
		}
		
		if (formula instanceof Affects) {
			return _affects(model.affects.get(formula.f1), formula.f2, "+") || _affects(model.affects.get(formula.f1), formula.f2, "-");
		}
		
		if (formula instanceof Causes) {
			if (models(model, formula.f1)  && models(model, formula.f2)) {
				if (formula.f1.equals(formula.f2)) {
					return true;
				}
				if (formula.f1.equals(new Not(formula.f2))) {
					return false;
				}
				if (! _allAreIndirectParents(model, formula.f1, formula.f2)) {
					return false;
				}
				
				Tuple<Boolean, ArrayList<Formula>> bw = _findWitness(model, (Causes) formula);
				if (bw.getLeft()) {
					return true;
				}
				return false;
			}
		}
		
		if (formula instanceof PCauses) {
			Tuple<Boolean, Formula> bc = _partialCause(model, (PCauses) formula);
			return bc.getLeft();
		}
		
		if (formula instanceof SCauses) {
			if (!models(model, formula.f1) || !models(model, formula.f2)) {
				return false;
			}
			
			ArrayList<Formula> conj = new ArrayList<Formula>();
			if (formula.f1 instanceof FormulaString) {
				conj.add(formula.f1);
			} else {
				conj.addAll(formula.f1.getAllLiteralsEvent());
			}
			
			boolean b_c = false;
			for (Formula c: conj) {
				if (models(model, new PCauses(c, formula.f2))) {
					b_c = true;
					break;
				}
			}
			
			if (!b_c) {
				return false;
			}
			
			if (!models(model, new K(new Intervention(formula.f1, formula.f2)))) {
				return false;
			}
			
			// if isintance (conj, str) return True
			
			boolean found = false;
			for (HashSet<Formula> s: model.powerset(conj)) {
				if (s.size() > 0 && s.size() < conj.size()) {
					Formula f = Formula.makeConjunction(s);
					if (model.models(new SCauses(f, formula.f2))) {
						found = true;
						break;
					}
				}
			}
			
			if (!found) {
				return true;
			}
			return false;
		}
		
		if (formula instanceof Prevents) {
			ArrayList<Formula> prevented = new ArrayList<Formula>();
			if (formula instanceof FormulaString) {
				prevented.add(formula);
			} else {
				prevented.addAll(formula.getAllLiteralsEvent());
			}
			
			for (Formula e: prevented) {
				Formula f;
				if (e instanceof FormulaString) {
					f = new Not(e);
				} else {
					f = e.f1;
				}
				
				if (models(model, new Causes(formula.f1, f))) {
					return true;
				}
			}
			return false;
		}
		
		if (formula instanceof Explains) {
			if (! _sufficientCauseInEveryModel(model, formula.f1, formula.f2)) {
				return false;
			}
			
			ArrayList<Formula> conj = new ArrayList<Formula>();
			
			if (formula.f1 instanceof FormulaString) {
				conj.add(formula.f1);
			} else {
				conj.addAll(formula.f1.getAllLiteralsEvent());
			}
			
			// EX2 - don't understand
			
			if (model.getEpistemicAlternatives(new And(formula.f1, formula.f2)).size() == 0) {
				return false;
			}
			
			if (! (models(model, new Not(new K(formula.f1))))) {
				return false;
			}
			return true;
		}
		
		if (formula instanceof Intervention) {
			ArrayList<Formula> i = new ArrayList<Formula>();
			if (formula.f1 instanceof FormulaString) {
				i.add(formula.f1);
			} else {
				i.addAll(formula.f1.getAllLiteralsEvent());
			}
			model.setNewIntervention(i);
			boolean b = models(model, formula.f2);
			model.clearIntervention();
			return b;
		}
		
		// Eq here - not mentioned elsewhere
		
		if (formula instanceof Gt) {
			return evaluateTerm(model, ((TermFormula) formula.f1).getTerm()) > evaluateTerm(model, ((TermFormula) formula.f2).getTerm());
		}
		
		if (formula instanceof Geq) {
			return evaluateTerm(model, ((TermFormula) formula.f1).getTerm()) >= evaluateTerm(model, ((TermFormula) formula.f2).getTerm());
		}
		
		if (formula instanceof K) {
			return _trueInEveryAlternative(model, formula.f1);
		}
		
		if (formula instanceof Goal) {
			boolean foundPos = false;
			for (String i: model.goals.get(model.action)) {
				if (models(model, new AffectsNeg(new FormulaString(i), formula.f1))) {
					return false;
				}
				
				if (!foundPos && models(model, new AffectsPos(new FormulaString(i), formula.f1))) {
					foundPos = true;
				}
			}
			return foundPos;
		}
		
		if (formula instanceof Means) {
			ArrayList<Formula> l = new ArrayList<Formula>();
			l.add(model.action);
			l.addAll(model.getDirectConsequences());
			for (Formula i: l) {
				if (((FormulaString) formula.f1).getString().equals("Reading-1")) {
					for (String g: model.goals.get(model.action)) {
						if (models(model, new And(new Causes(i, new FormulaString(g)), new Affects(i, formula.f2)))) {
							return true;
						}
					}
				}
				
				if (((FormulaString) formula.f1).getString().equals("Reading-2")) {
					if (models(model, new Affects(i, formula.f2))) {
						return true;
					}
				}
			}
			return false;
		}
		
		if (formula instanceof Forall) {
			Formula f = null;
			for (String e: model.domainOfQuantification) {
				Formula s = substituteVariable(formula.f1, e, formula.f2);
				if (f == null) {
					f = s;
				} else {
					f = new And(s, f);
				}
			}
			return models(model, f);
		}
		
		if (formula instanceof Exists) {
			Formula f = new Not(new Forall(formula.f1, new Not(formula.f2)));
			return models(model, f);
		}
		
		if (formula instanceof Consequence) {
			return model.consequences.contains(formula.toString());
		}
	}

}
