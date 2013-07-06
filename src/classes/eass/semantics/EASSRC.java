// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, Michael Fisher, Nicholas K. Lincoln, Alexei
// Lisitsa and Sandor M. Veres
//
// This file is part of the Engineering Autonomous Space Software (EASS) Library.
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

package eass.semantics;

import java.util.LinkedList;

import ail.semantics.ReasoningCycle;
import ail.semantics.RCStage;
import ail.semantics.AILAgent;
import ail.semantics.operationalrules.*;
import ail.syntax.Action;
import ail.syntax.Goal;

//import gov.nasa.jpf.jvm.abstraction.filter.FilterField;
import gov.nasa.jpf.annotation.FilterField;
/**
 * An EASS Reasonning Cycle. 
 * 
 * @author louiseadennis
 *
 */
public class EASSRC implements ReasoningCycle {
	/**
	 * Place holder for the current stage of the reasoning cycle.
	 */
	private EASSRCStage currentstage;

	/**
	 * Set up the reasoning cycle stages.
	 */
	private EASSRCStage StageA = new EASSRCStage(0, "StageA");
	private EASSRCStage StageB = new EASSRCStage(1, "StageB");
	private EASSRCStage StageC = new EASSRCStage(2, "StageC");
	private EASSRCStage StageD = new EASSRCStage(3, "StageD");
	private EASSRCStage StageE = new EASSRCStage(4, "StageE");
	private EASSRCStage StageF = new EASSRCStage(5, "StageF");
	/**
	 * Flag indicating whether this is a point where the properties of the 
	 * multi-agent system should be checked.
	 */
	@FilterField
	private boolean stopandcheck = false;
	private boolean interrupted = false;
			
	/**
	 * Start at Stage A.
	 *
	 */
	public EASSRC() {
		currentstage = StageE;
		
		/* Stage A Rules */
		// First we create versions of the rules we want in Stage A
		SelectIntentionNotUnplannedProblemGoal rule1 = new SelectIntentionNotUnplannedProblemGoal();
		SleepIfEmpty rule2 = new SleepIfEmpty();
		DropIntentionIfEmpty rule3 = new DropIntentionIfEmpty();
		MatchDropGoal rule4 = new MatchDropGoal();
		// Then we set these rules to the appropriate stage in the reasoning cycle.
		RCStage StageA = getStageA();
		StageA.setRule(rule1);  
		StageA.setRule(rule2);
		StageA.setRule(rule3);
		StageA.setRule(rule4);
		
		/* Stage B Rules */
		
		GenerateApplicablePlansIfNonEmpty rule5 = new GenerateApplicablePlansIfNonEmpty();
		GenerateApplicablePlansEmptyProblemGoal rule6 = new GenerateApplicablePlansEmptyProblemGoal();
		
		RCStage StageB = getStageB();
		StageB.setRule(rule5);
		StageB.setRule(rule6);
		
		/* Stage C Rules */
		
		ApplyApplicablePlans rule7 = new ApplyApplicablePlans();
		
		RCStage StageC = getStageC();
		StageC.setRule(rule7);
		
		/* Stage D Rules */
		
		HandleGuardNotSatisfied rule8 = new HandleGuardNotSatisfied();
		HandleEmptyDeedStack rule9 = new HandleEmptyDeedStack();
		HandleAddAchieveTestGoalwEvent rule10 = new HandleAddAchieveTestGoalwEvent();
		HandleAddPerformGoalwEvent rule10a = new HandleAddPerformGoalwEvent();

		LinkedList<Integer> excludedGoals = new LinkedList<Integer>();
		excludedGoals.add(new Integer(Goal.maintainGoal));
		HandleDropGeneralGoal rule11 = new HandleDropGeneralGoal(excludedGoals);

		HandleAddBeliefwEvent rule12 = new HandleAddBeliefwEvent();
		HandleUpdateBeliefwEvent rule12a = new HandleUpdateBeliefwEvent();
		HandleDropBeliefwEvent rule13 = new HandleDropBeliefwEvent();
		HandleLockUnLock rule14 = new HandleLockUnLock();
		HandleWaitForDirect rulehwf = new HandleWaitForDirect();
		IgnoreUnplannedProblemGoal ruleiup = new IgnoreUnplannedProblemGoal();
		
		// Set up list of actions with special semantics.
		LinkedList<Integer> excludedActions = new LinkedList<Integer>();
		excludedActions.add(new Integer(Action.sendAction));
		excludedActions.add(new Integer(Action.synchronisedJoin));
		excludedActions.add(new Integer(Action.synchronisedAdopt));
		HandleGeneralAction rule15 = new HandleGeneralAction(excludedActions);
		HandleSendAction rule15a = new HandleSendAction();
		HandleNull rulehn = new HandleNull();
		
		RCStage StageD = getStageD();
		StageD.setRule(rule8);
		StageD.setRule(rule9);
		StageD.setRule(rulehn);
		StageD.setRule(rule10);
		StageD.setRule(rule10a);
		StageD.setRule(rule11);
		StageD.setRule(rule12);
		StageD.setRule(rule12a);
		StageD.setRule(rule13);
		StageD.setRule(rule14);
		StageD.setRule(rulehwf);
		StageD.setRule(rule15);
		StageD.setRule(rule15a);
		StageD.setRule(ruleiup);
		
		/* Stage E Rules */
		
		DirectPerceptionwEvents rule16 = new DirectPerceptionwEvents();
		getStageE().setRule(rule16);
		
		/* Stage F Rules */
		
		HandleMessages rule17 = new HandleMessages();
		getStageF().setRule(rule17);
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.ReasoningCycle#cycle(ail.semantics.AILAgent)
	 */
	public void cycle(AILAgent ag) {
		if (currentstage  == StageA) {
			if (ag.getIntention() != null && ag.getIntention().empty() && (ag.getIntentions().isEmpty() || ag.allintentionssuspended())) {
				setStopandCheck(true);
				currentstage = StageE;
			} else if (ag.getIntention() == null) {
				setStopandCheck(true);
				currentstage = StageE;
			} else {
				currentstage = StageB;
			}
		} else if (currentstage == StageB) {
			currentstage = StageC;
		} else if (currentstage == StageC) {
			setStopandCheck(true);
			if (ag.getIntention() != null & ag.getIntention().empty()) {
				currentstage = StageE;
			} else {
				currentstage = StageD;
			}
		} else if (currentstage == StageD) {
			if (ag.lastruleexecuted.equals("Handle General Action")) {
				setStopandCheck(true);
			}
			if (ag.lastruleexecuted.equals("Handle Send Action")) {
				setStopandCheck(true);
			}
			setStopandCheck(true);
			currentstage = StageE;
		} else if (currentstage == StageE) {
			currentstage = StageF;
		} else if (currentstage == StageF) {
			currentstage = StageA;
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
	
	public void setStopandCheck(boolean b) {
		stopandcheck = b;
	}
	

	public RCStage getStageA() {
		return StageA;
	}
	public RCStage getStageB() {
		return StageB;
	}
	public RCStage getStageC() {
		return StageC;
	}
	public RCStage getStageD() {
		return StageD;
	}
	public RCStage getStageE() {
		return StageE;
	}
	public RCStage getStageF() {
		return StageF;
	}

	public void setCurrentStage(RCStage rcs) {
		currentstage = (EASSRCStage) rcs;
	}

	public boolean not_interrupted() {
		return !interrupted;
	}
}
