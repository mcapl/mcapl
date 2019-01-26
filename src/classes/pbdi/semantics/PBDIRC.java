// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis and Michael Fisher
//
// This file is part of the Python BDI Agent Model (PBDI) Library.
// 
// The EASS Library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The EASS Library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the EASS Library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package pbdi.semantics;

import java.util.LinkedList;

import ail.semantics.ReasoningCycle;
import ail.semantics.RCStage;
import ail.semantics.AILAgent;
import ail.semantics.operationalrules.*;

//import gov.nasa.jpf.jvm.abstraction.filter.FilterField;
import gov.nasa.jpf.annotation.FilterField;
import pbdi.semantics.operational_rules.PythonCalculations;
/**
 * An EASS Reasonning Cycle. 
 * 
 * @author louiseadennis
 *
 */
public class PBDIRC implements ReasoningCycle {
	/**
	 * Place holder for the current stage of the reasoning cycle.
	 */
	private PBDIRCStage currentstage;

	/**
	 * Set up the reasoning cycle stages.
	 */
	private PBDIRCStage Sleep = new PBDIRCStage(6, "Sleep");
	private PBDIRCStage Perception = new PBDIRCStage(0, "Perception");
	private PBDIRCStage Calculation = new PBDIRCStage(1, "Calculations");
	private PBDIRCStage ManageGoals = new PBDIRCStage(2, "ManageGoals");
	private PBDIRCStage SelectRule = new PBDIRCStage(3, "SelectRule");
	private PBDIRCStage ApplyRule = new PBDIRCStage(4, "ApplyRule");
	private PBDIRCStage ExecuteRule = new PBDIRCStage(5, "ExecuteRule");

	/**
	 * Flag indicating whether this is a point where the properties of the 
	 * multi-agent system should be checked.
	 */
	@FilterField
	private boolean stopandcheck = false;
			
	/**
	 * Start at Stage A.
	 *
	 */
	public PBDIRC() {
		currentstage = Perception;
		
		// Create Rules
		DirectPerception rule1 = new DirectPerception();
		PythonCalculations rule1a = new PythonCalculations();
		MatchDropGoal rule2 = new MatchDropGoal();
		GenerateApplicablePlansIfNonEmpty rule3 = new GenerateApplicablePlansIfNonEmpty();
		ApplyApplicablePlans rule4 = new ApplyApplicablePlans();

		
		// Then we set these rules to the appropriate stage in the reasoning cycle.
		getPerception().setRule(rule1);
		getCalculation().setRule(rule1a);
		getManageGoals().setRule(rule2);
		getSelectRule().setRule(rule3);
		getApplyRule().setRule(rule4);
				
		HandleEmptyDeedStack rule5 = new HandleEmptyDeedStack();
		HandleAddAchieveTestGoal rule6 = new HandleAddAchieveTestGoal();

		LinkedList<Integer> excludedGoals = new LinkedList<Integer>();
		HandleDropGeneralGoal rule7 = new HandleDropGeneralGoal(excludedGoals);

		HandleAddBelief rule8 = new HandleAddBelief();
		HandleDropBelief rule9 = new HandleDropBelief();
		
		// Set up list of actions with special semantics.
		LinkedList<Integer> excludedActions = new LinkedList<Integer>();
		HandleGeneralAction rule10 = new HandleGeneralAction(excludedActions);
		HandleNull rule11 = new HandleNull();
		
		RCStage StageD = getExecuteRule();
		StageD.setRule(rule5);
		StageD.setRule(rule6);
		StageD.setRule(rule7);
		StageD.setRule(rule8);
		StageD.setRule(rule9);
		StageD.setRule(rule10);
		StageD.setRule(rule11);
		
		SleepIfEmpty sleep_rule = new SleepIfEmpty();
		getSleep().setRule(sleep_rule);
		
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.ReasoningCycle#cycle(ail.semantics.AILAgent)
	 */
	public void cycle(AILAgent ag) {
		if (currentstage  == Perception) {
			currentstage = Calculation;
		} else if (currentstage == Calculation) {
			currentstage = ManageGoals;
		} else if (currentstage == ManageGoals) {
			currentstage = SelectRule;
		} else if (currentstage == SelectRule) {
			currentstage = ApplyRule;
		} else if (currentstage == ApplyRule) {
			currentstage = ExecuteRule;
		} else if (currentstage == ExecuteRule) {
			if (ag.getIntention() != null && ag.getIntention().empty() && (ag.getIntentions().isEmpty() || ag.allintentionssuspended())) {
				setStopandCheck(true);
				currentstage = Sleep;
			} else if (ag.getIntention() == null ) {
				setStopandCheck(true);
				currentstage = Sleep;
			} else {
				setStopandCheck(true);
				currentstage = ExecuteRule;
			} 			
		} else if (currentstage == Sleep) {
			currentstage = Perception;
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
	 * @see ail.semantics.ReasoningCycle#stopandcheck()
	 */
	public boolean stopandcheck() {
		boolean tmp = stopandcheck;
		return tmp;
	} 
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.ReasoningCycle#setStopandCheck(boolean)
	 */
	public void setStopandCheck(boolean b) {
		stopandcheck = b;
	}
	

	public RCStage getPerception() {
		return Perception;
	}
	public RCStage getCalculation() {
		return Calculation;
	}
	public RCStage getManageGoals() {
		return ManageGoals;
	}
	public RCStage getSelectRule() {
		return SelectRule;
	}
	public RCStage getExecuteRule() {
		return ExecuteRule;
	}
	public RCStage getApplyRule() {
		return ApplyRule;
	}
	public RCStage getSleep() {
		return Sleep;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.ReasoningCycle#setCurrentStage(ail.semantics.RCStage)
	 */
	public void setCurrentStage(RCStage rcs) {
		currentstage = (PBDIRCStage) rcs;
	}

	@Override
	public boolean not_interrupted() {
		return true;
	}

}
