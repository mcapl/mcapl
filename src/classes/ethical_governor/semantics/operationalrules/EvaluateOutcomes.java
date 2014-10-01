// ----------------------------------------------------------------------------
// Copyright (C) 2014 Louise A. Dennis, Michael Fisher and Alan Winfield
// 
// This file is part of Declarative Ethical Governor (DEG)
// 
// The DEG is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The DEG is distributed in the hope that it will be useful,
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
package ethical_governor.semantics.operationalrules;

import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import ail.syntax.Predicate;
import ail.syntax.Action;

import ethical_governor.semantics.EthicalGovernor;
import ethical_governor.semantics.AnnotatedAction;

import java.util.ArrayList;

/**
 * A rules that evaluates the outcomes of an action (stated as predicates), using some internal logic in 
 * order to create a subset of actions.
 * @author louiseadennis
 *
 */
public class EvaluateOutcomes implements OSRule {
	private static String name = "Evaluate Outcomes of Actions";

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.OSRule#checkPreconditions(ail.semantics.AILAgent)
	 */
	public boolean checkPreconditions(AILAgent a) {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.OSRule#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		EthicalGovernor eg = (EthicalGovernor) a;
		
		ArrayList<AnnotatedAction> aas = eg.getAnnotatedActions();
		ArrayList<Predicate> ethical_precedence = eg.getEthicalPrecedence();
		
		ArrayList<Action> best_actions = new ArrayList<Action>();
		ArrayList<AnnotatedAction> currently_best = new ArrayList<AnnotatedAction>();
		ArrayList<AnnotatedAction> currently_best2 = new ArrayList<AnnotatedAction>();
		currently_best = aas;
		for (Predicate actor: ethical_precedence) {
			best_actions = new ArrayList<Action>();
			currently_best2 = new ArrayList<AnnotatedAction>();
			int outcome_score = 100;
			for (AnnotatedAction aact: currently_best) {
				ArrayList<Predicate> outcomes = aact.getAnnotations();
				Action act = aact.getAction();
				int worst_outcome = 0;
				for (Predicate outcome: outcomes) {
					if (outcome.getFunctor().equals(actor.getFunctor())) {
						int score = eg.score(((Predicate) outcome.getTerm(0)).getFunctor(), actor);
						//if (score < worst_outcome) {
						//	worst_outcome = score;
						//}
						worst_outcome += score;
					}						
				}
				
				if (worst_outcome < outcome_score) {
					outcome_score = worst_outcome;
					best_actions = new ArrayList<Action>();
					best_actions.add(act);
					currently_best2 = new ArrayList<AnnotatedAction>();
					currently_best2.add(aact);
				} else if (worst_outcome == outcome_score) {
					best_actions.add(act);
					currently_best2.add(aact);
				} else {
				}

			}
			
			currently_best = currently_best2;
		}
		
		eg.setSelectedActions(best_actions);
		
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.OSRule#getName()
	 */
	public String getName() {
		return name;
	}

}
