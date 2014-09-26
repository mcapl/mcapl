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

package ethical_governor.semantics;

import ail.semantics.AILAgent;
import ail.semantics.RCStage;
import ail.semantics.ReasoningCycle;

import ethical_governor.semantics.operationalrules.*;

public class EthicalGovernorRC implements ReasoningCycle {
	
	ModelApplicableActions rule1 = new ModelApplicableActions();
	EvaluateOutcomes rule2 = new EvaluateOutcomes();
	
	private boolean stopandcheck = false;
	
	private RCStage model_actions = new EthicalGovernorStage(1, "Model Actions");
	private RCStage filter_actions = new EthicalGovernorStage(2, "Filter Actions");
	
	private RCStage current_stage = model_actions;
	
	public EthicalGovernorRC() {
		model_actions.setRule(rule1);
		filter_actions.setRule(rule2);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.ReasoningCycle#setStopandCheck(boolean)
	 */
	public void setStopandCheck(boolean b) {
		stopandcheck = b;
		
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.ReasoningCycle#stopandcheck()
	 */
	public boolean stopandcheck() {
		return stopandcheck;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.ReasoningCycle#cycle(ail.semantics.AILAgent)
	 */
	public void cycle(AILAgent ag) {
		if (current_stage == model_actions) {
			current_stage = filter_actions;
		} else {
			current_stage = model_actions;
			setStopandCheck(true);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.ReasoningCycle#getStage()
	 */
	public RCStage getStage() {
		return current_stage;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.ReasoningCycle#setCurrentStage(ail.semantics.RCStage)
	 */
	public void setCurrentStage(RCStage rcs) {
		current_stage = rcs;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.ReasoningCycle#not_interrupted()
	 */
	public boolean not_interrupted() {
		return true;
	}

}
