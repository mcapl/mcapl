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
import ail.syntax.Action;
import ail.syntax.Predicate;

import ethical_governor.semantics.EthicalGovernor;
import ethical_governor.semantics.AnnotatedAction;
import ethical_governor.mas.EthicalGovernorEnv;

import java.util.ArrayList;

/**
 * A rule that invokes an external simulator to model the outcome of a possible action the 
 * agent is planning.
 * @author louiseadennis
 *
 */
public class ModelApplicableActions implements OSRule {
	private static 
	String name = "Model Applicable Actions";

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
		ArrayList<Action> as = eg.getApplicableActions();
		ArrayList<AnnotatedAction> aas = new ArrayList<AnnotatedAction>();
		for (Action act: as) {
			ArrayList<Predicate> outcomes = ((EthicalGovernorEnv) eg.getEnv()).model(act, eg.getAgName());
			AnnotatedAction aa = new AnnotatedAction(act, outcomes);
			aas.add(aa);
		}
		eg.setAnnotatedActions(aas);
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.OSRule#getName()
	 */
	public String getName() {
		return name;
	}

}
