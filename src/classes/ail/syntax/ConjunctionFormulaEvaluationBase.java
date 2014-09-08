package ail.syntax;

import java.util.Iterator;
import java.util.ArrayList;

import ail.util.Tuple;
import ail.util.AILexception;

import ajpf.util.AJPFLogger;

import java.util.Random;

public class ConjunctionFormulaEvaluationBase implements EvaluationBase<PredicateTerm> {
	ArrayList<Literal> ll = new ArrayList<Literal>();
	static String logname = "ail.syntax.ConjunctionFormulaEvaluationBase";
	
	public ConjunctionFormulaEvaluationBase(LogicalFormula lf) {
		try {
			addConjuncts(lf);
		} catch (AILexception e) {
			AJPFLogger.warning(logname, e.getMessage());
		}
	}
	
	public void addConjuncts(LogicalFormula lf) throws AILexception {
		if (lf instanceof LogExpr) {
			LogExpr le = (LogExpr)  lf;
			if (le.getOp() == LogExpr.LogicalOp.and) {
				addConjuncts(le.getLHS());
				addConjuncts(le.getRHS());
			} else if (le.getOp() == LogExpr.LogicalOp.none) {
				addConjuncts(le.getRHS());
			} else if (le.getOp() == LogExpr.LogicalOp.not) {
				if (le.getRHS() instanceof Predicate) {
					ll.add(new Literal(false, (Predicate)le.getRHS()));
				} else {
					throw new AILexception("Formula contains possible Disjunction");
				}
			} else {
				throw new AILexception("Formula contains Disjunctions");
			}
		} else if (lf instanceof PredicateTerm) {
			if (lf instanceof Predicate) {
				ll.add(new Literal(true, (Predicate) lf));
			}  else if (lf instanceof Literal) {
				ll.add((Literal) lf);
			} else {
				throw new AILexception("Formula is not a LogExpr or Literal/Predicate");
			}
		}
		
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.EvaluationBase#getRelevant(ail.syntax.EBCompare)
	 */
	public Iterator<PredicateTerm> getRelevant(EBCompare<PredicateTerm> ga) {
		ArrayList<PredicateTerm> ptl = new ArrayList<PredicateTerm>();
		for (Literal l: ll) {
			PredicateTerm p = (PredicateTerm) ga;
			if (p.getPredicateIndicator().equals(l.getPredicateIndicator())) {
				ptl.add(p);
			}
		}
		return ptl.iterator();
	}

}
