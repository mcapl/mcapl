// ----------------------------------------------------------------------------
// Copyright (C) 2014 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of the Agent Infrastructure Layer (AIL)
// 
// The AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The AIL is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------
package ail.syntax;

import java.util.Iterator;
import java.util.ArrayList;

import ail.util.AILexception;

import ajpf.util.AJPFLogger;

/**
 * This is an evaluation base for some arbitrary conjunction.  I.e., instead of some set within an agent this is 
 * for more logical abstract expression (if they are conjunctions of atoms) and checking that something follows from them.
 * @author lad
 *
 */
public class ConjunctionFormulaEvaluationBase implements EvaluationBase<PredicateTerm> {
	ArrayList<Literal> ll = new ArrayList<Literal>();
	static String logname = "ail.syntax.ConjunctionFormulaEvaluationBase";
	
	/**
	 * Construct an evaluation base from a logical formula.
	 * @param lf
	 */
	public ConjunctionFormulaEvaluationBase(GLogicalFormula lf) {
		try {
			addConjuncts(lf);
		} catch (AILexception e) {
			AJPFLogger.warning(logname, e.getMessage());
		}
	}
	
	/**
	 * Add conjunctions to the evaluation base.
	 * @param lf
	 * @throws AILexception
	 */
	private void addConjuncts(GLogicalFormula lf) throws AILexception {
		if (lf instanceof Guard) {
			Guard le = (Guard)  lf;
			if (le.getOp() == Guard.GLogicalOp.and) {
				addConjuncts(le.getLHS());
				addConjuncts(le.getRHS());
			} else if (le.getOp() == Guard.GLogicalOp.none) {
				addConjuncts(le.getRHS());
			} else if (le.getOp() == Guard.GLogicalOp.not) {
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
				ptl.add(l);
			}
		}
		return ptl.iterator();
	}

}
