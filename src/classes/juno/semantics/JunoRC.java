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
package juno.semantics;

import ail.semantics.AILAgent;
import ail.semantics.RCStage;
import ail.semantics.ReasoningCycle;
import ail.semantics.operationalrules.DirectPerception;
import gov.nasa.jpf.annotation.FilterField;
import juno.semantics.operationalrules.HandleHeraAction;
import juno.semantics.operationalrules.ReasonAboutActions;
import juno.semantics.operationalrules.UpdateAffects;
import juno.semantics.operationalrules.UpdateBackground;
import juno.semantics.operationalrules.UpdateGoals;
import juno.semantics.operationalrules.UpdateUtilities;

/**
 * A Reasoning Cycle for a Juno Agent.
 * @author louisedennis
 *
 */
public class JunoRC implements ReasoningCycle {
	private JunoRCStage currentstage;
	
	private JunoRCStage Perception = new JunoRCStage(0, "Perception");
	private JunoRCStage UpdateModelUtilities = new JunoRCStage(1, "UpdateModelU");
	private JunoRCStage UpdateModelBackground = new JunoRCStage(2, "UpdateModelB");
	private JunoRCStage UpdateModelAffects = new JunoRCStage(3, "UpdateModelA");
	private JunoRCStage UpdateModelGoals = new JunoRCStage(4, "UpdateModelG");
	private JunoRCStage EthicalReasoning = new JunoRCStage(5, "EthicalReasoning");
	private JunoRCStage Act = new JunoRCStage(6, "Act");

	@FilterField
	private boolean stopandcheck = false;

	/**
	 * Sets up a reasoning cycle of perception, followed by updating the model, reasoning using the model and then enacting the chosen action.
	 */
	public JunoRC() {
		currentstage = Perception;
		
		// Create Rules
		DirectPerception rule1 = new DirectPerception();
		Perception.setRule(rule1);
		
		UpdateUtilities rule2 = new UpdateUtilities();
		UpdateModelUtilities.setRule(rule2);
		
		UpdateBackground rule3 = new UpdateBackground();
		UpdateModelBackground.setRule(rule3);
		
		UpdateAffects rule3a = new UpdateAffects();
		UpdateModelAffects.setRule(rule3a);
		
		UpdateGoals rule3b = new UpdateGoals();
		UpdateModelGoals.setRule(rule3b);
		
		ReasonAboutActions rule4 = new ReasonAboutActions();
		EthicalReasoning.setRule(rule4);
		
		HandleHeraAction rule5 = new HandleHeraAction();
		Act.setRule(rule5);
		

	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.ReasoningCycle#setStopandCheck(boolean)
	 */
	@Override
	public void setStopandCheck(boolean b) {
		stopandcheck = b;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.ReasoningCycle#stopandcheck()
	 */
	@Override
	public boolean stopandcheck() {
		return stopandcheck;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.ReasoningCycle#cycle(ail.semantics.AILAgent)
	 */
	@Override
	public void cycle(AILAgent ag) {
		if (currentstage == Perception) {
			setStopandCheck(true);
			currentstage = UpdateModelUtilities;
		} else if (currentstage == UpdateModelUtilities) {
			currentstage = UpdateModelBackground;
		} else if (currentstage == UpdateModelBackground) {
			currentstage = UpdateModelAffects;
		} else if (currentstage == UpdateModelAffects) {
			currentstage = UpdateModelGoals;
		} else if (currentstage == UpdateModelGoals) {
			currentstage = EthicalReasoning;
		} else if (currentstage == EthicalReasoning) {
			currentstage = Act;
		} else {
			currentstage = Perception;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.ReasoningCycle#getStage()
	 */
	@Override
	public RCStage getStage() {
		return currentstage;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.ReasoningCycle#setCurrentStage(ail.semantics.RCStage)
	 */
	@Override
	public void setCurrentStage(RCStage rcs) {
		currentstage = (JunoRCStage) rcs;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.ReasoningCycle#not_interrupted()
	 */
	@Override
	public boolean not_interrupted() {
		return true;
	}

}
