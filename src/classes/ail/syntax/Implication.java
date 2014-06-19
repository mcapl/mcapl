package ail.syntax;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ail.semantics.AILAgent;

public class Implication implements LogicalFormula, GLogicalFormula {
	LogicalFormula antecedant;
	LogicalFormula consequent;
	
	public Implication(LogicalFormula ant, LogicalFormula conseq) {
		antecedant = ant;
		consequent = conseq;
	}
	
	public Implication clone() {
		return new Implication(antecedant.clone(), consequent.clone());
	}
	
	public LogicalFormula getAnt() {
		return antecedant;
	}
	
	public LogicalFormula getConseq() {
		return consequent;
	}

	@Override
	public boolean unifies(Unifiable t, Unifier u) {
		if (t instanceof Implication) {
			LogExpr l = new LogExpr(antecedant, LogExpr.LogicalOp.and, consequent);
			LogExpr tg = new LogExpr(((Implication) t).getAnt(), LogExpr.LogicalOp.and, ((Implication) t).getConseq());
			return l.unifies(tg, u);
		}
		return false;
	}

	@Override
	public void standardise_apart(Unifiable t, Unifier u, List<String> varnames) {
	   	List<String> tvarnames = t.getVarNames();
    	List<String> myvarnames = getVarNames();
    	tvarnames.addAll(varnames);
    	ArrayList<String> replacednames = new ArrayList<String>();
    	ArrayList<String> newnames = new ArrayList<String>();
    	for (String s:myvarnames) {
    		if (tvarnames.contains(s)) {
    			if (!replacednames.contains(s)) {
    				String s1 = DefaultAILStructure.generate_fresh(s, tvarnames, myvarnames, newnames, u);
    				renameVar(s, s1);
    				u.renameVar(s, s1);
    			}
    		}
    	}

	}

	@Override
	public List<String> getVarNames() {
		ArrayList<String> vnames = new ArrayList<String>();
		vnames.addAll(antecedant.getVarNames());
		vnames.addAll(consequent.getVarNames());
		return vnames;
	}

	@Override
	public void renameVar(String oldname, String newname) {
		antecedant.renameVar(oldname, newname);
		consequent.renameVar(oldname, newname);
	}

	@Override
	public boolean match(Unifiable t, Unifier u) {
		if (t instanceof Implication) {
			LogExpr l = new LogExpr(antecedant, LogExpr.LogicalOp.and, consequent);
			LogExpr tg = new LogExpr(((Implication) t).getAnt(), LogExpr.LogicalOp.and, ((Implication) t).getConseq());
			return l.match(tg, u);
		}
		return false;
	}

	@Override
	public boolean matchNG(Unifiable t, Unifier u) {
		if (t instanceof Implication) {
			LogExpr l = new LogExpr(antecedant, LogExpr.LogicalOp.and, consequent);
			LogExpr tg = new LogExpr(((Implication) t).getAnt(), LogExpr.LogicalOp.and, ((Implication) t).getConseq());
			return l.matchNG(tg, u);
		}
		return false;
	}

	@Override
	public boolean isGround() {
		return antecedant.isGround() && consequent.isGround();
	}

	@Override
	public boolean apply(Unifier theta) {
		return antecedant.apply(theta) && consequent.apply(theta);
	}

	@Override
	public void makeVarsAnnon() {
		antecedant.makeVarsAnnon();
		consequent.makeVarsAnnon();
	}

	@Override
	public Unifiable strip_varterm() {
		return new Implication((LogicalFormula) antecedant.strip_varterm(),(LogicalFormula) consequent.strip_varterm());
	}

	@Override
	public Iterator<Unifier> logicalConsequence(AILAgent ag, Unifier un,
			List<String> varnames) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Unifier> logicalConsequence(
			EvaluationBasewNames<PredicateTerm> eb, RuleBase rb, Unifier un,
			List<String> varnames) {
		BeliefBase abase = new BeliefBase();
		LogExpr lant = (LogExpr) antecedant;
		
		// Need logial formulae to have some kind of to EB method.
		if (lant.getOp() == LogExpr.LogicalOp.none) {
			Literal ant = (Literal) lant.getRHS();
			abase.add(ant);
		} else {
			Literal ant1 = (Literal) lant.getLHS();
			Literal ant2 = (Literal) lant.getRHS();
			abase.add(ant1);
			abase.add(ant2);
		}
		MergeEvaluationBase<PredicateTerm> joint = new MergeEvaluationBase(new NamedEvaluationBase(abase, "impant"), eb);
		return consequent.logicalConsequence(joint, rb, un, varnames);
	}

}
