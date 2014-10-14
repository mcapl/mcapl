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
package actiononly.semantics;

import actiononly.semantics.operationalrules.SelectAction;

import ail.semantics.AILAgent;
import ail.semantics.RCStage;
import ail.semantics.ReasoningCycle;
import ail.semantics.operationalrules.DirectPerception;
import ail.semantics.operationalrules.GenerateApplicableCapabilities;
import ail.semantics.operationalrules.HandleGeneralAction;
import ail.semantics.operationalrules.SleepIfGoalAchieved;
import ail.semantics.operationalrules.RemoveAchievedGoals;

import java.util.LinkedList;

/**
 * A reasoning cycle for agents which consist essentially of a set of actions with preconditions and some
 * external selection function (or possibly internal selection function) TBD.
 * @author lad
 *
 */
public class ActionOnlyRC implements ReasoningCycle {
	
	DirectPerception perceive = new DirectPerception();
	GenerateApplicableCapabilities rule1 = new GenerateApplicableCapabilities();
	SelectAction rule2 = new SelectAction();
	HandleGeneralAction rule3 = new HandleGeneralAction(new LinkedList<Integer>());
	SleepIfGoalAchieved rule4 = new SleepIfGoalAchieved();
	RemoveAchievedGoals rule5 = new RemoveAchievedGoals();
	
	private RCStage generate_actions = new ActionOnlyStage(1, "Stage 1");
	private RCStage select_action = new ActionOnlyStage(2, "Stage 2");
	private RCStage execute_action = new ActionOnlyStage(3, "Stage 3");
	private RCStage perception = new ActionOnlyStage(4, "Stage 4");
	private RCStage goalsachieved = new ActionOnlyStage(5, "Stage 5");
	
	private RCStage currentstage = perception;
	
	private boolean stopandcheck = false;
	
	/**
	 * Constructor.  Assign rules to stages.
	 */
	public ActionOnlyRC() {
		generate_actions.setRule(rule4);
		generate_actions.setRule(rule1);
		select_action.setRule(rule2);
		execute_action.setRule(rule3);
		perception.setRule(perceive);
		goalsachieved.setRule(rule5);
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
		if (currentstage == perception) {
			currentstage = goalsachieved;
		} else if (currentstage == goalsachieved) {
			currentstage = generate_actions;
		} else if (currentstage == generate_actions) {
			currentstage = select_action;
		} else if (currentstage == select_action) {
			currentstage = execute_action;
		} else {
			currentstage = perception;
			setStopandCheck(true);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.ReasoningCycle#getStage()
	 */
	public RCStage getStage() {
		return currentstage;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.ReasoningCycle#setCurrentStage(ail.semantics.RCStage)
	 */
	public void setCurrentStage(RCStage rcs) {
		currentstage = rcs;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.ReasoningCycle#not_interrupted()
	 */
	public boolean not_interrupted() {
		return true;
	}

}
