// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
// 
// This file is part of GOAL (AIL version) - GOAL-AIL
//
// GOAL-AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// GOAL-AIL is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with GOAL-AIL if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package goal.semantics;

import java.util.LinkedList;

import ail.semantics.ReasoningCycle;
import ail.semantics.RCStage;
import ail.semantics.AILAgent;
import ail.semantics.operationalrules.*;
import ail.semantics.OSRule;
import ail.syntax.Goal;

import goal.semantics.operationalrules.*;

import gov.nasa.jpf.annotation.FilterField;
//import gov.nasa.jpf.jvm.abstraction.filter.FilterField;

/**
 * The GOAL Reasonning Cycle.
 * 
 * @author louiseadennis
 *
 */
public class GOALRC implements ReasoningCycle {
	/**
	 * Place holder for the current stage of the reasoning cycle.
	 */
	private GOALRCStage currentstage;

	/**
	 * Set up the reasoning cycle stages: Apply Action Rule.
	 */
	@FilterField
	public GOALRCStage ActionRuleStage = new GOALRCStage(0, "Apply Action Rule");
	@FilterField
	public GOALRCStage TransformerFunction = new GOALRCStage(0, "Transformer Function");
	@FilterField
	public GOALRCStage MessageReceipt = new GOALRCStage(0, "Message Receipt");
	@FilterField
	public GOALRCStage Perception = new GOALRCStage(0, "Perception");
	/**
	 * Set up the reasoning cycle stages: Goal Stage.
	 */
	/**
	 * Flag indicating whether this is a point where the properties of the 
	 * multi-agent system should be checked.
	 */
	private boolean stopandcheck = false;
	private boolean interrupted = false;
		
	/**
	 * Start at Main Stage.
	 *
	 */
	public GOALRC() {
		currentstage = ActionRuleStage;
		
		PlanWithActionRule plActionRule = new PlanWithActionRule();		
		//HouseKeeping
		SleepIfNothingToDo sleep = new SleepIfNothingToDo();
		DropIntentionIfEmpty dropint = new DropIntentionIfEmpty();
		
		ActionRuleStage.setRule(dropint);
		ActionRuleStage.setRule(plActionRule);
		ActionRuleStage.setRule(sleep);
		
		HandleAddBelief addBelief = new HandleAddBelief();
		HandleDropBelief delBelief = new HandleDropBelief();
		AddGoal addGoal = new AddGoal();
		HandleDropGeneralGoal dropGoal = new HandleDropGeneralGoal(new LinkedList<Integer>());
		HandleGoalSend sendAction = new HandleGoalSend();
		PlanWithActionSpec actionspec = new PlanWithActionSpec();
		HandleAction closeAction = new HandleAction();
		HandleAddGoal handleactspec = new HandleAddGoal();
		HandleNull handlenull = new HandleNull();
		DoNothing donothing = new DoNothing();
		HandleAddContent handleaddcontent = new HandleAddContent();
		HandleAddContext handleaddcontext = new HandleAddContext();
		
		TransformerFunction.setRule(addBelief);
		TransformerFunction.setRule(delBelief);
		TransformerFunction.setRule(addGoal);
		TransformerFunction.setRule(dropGoal);
		TransformerFunction.setRule(sendAction);
		TransformerFunction.setRule(closeAction);
		TransformerFunction.setRule(handleactspec);
		TransformerFunction.setRule(handlenull);
		TransformerFunction.setRule(handleaddcontent);
		TransformerFunction.setRule(handleaddcontext);
		TransformerFunction.setRule(actionspec);
		TransformerFunction.setRule(donothing);
		
		DirectPerception perception = new DirectPerception();
		Perception.setRule(perception);
		
		HandleGoalMessages messages = new HandleGoalMessages();
		MessageReceipt.setRule(messages);
		

	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.ReasoningCycle#cycle(ail.semantics.AILAgent)
	 */
	public void cycle(AILAgent ag) {
		// Stage a is the only complex one. 
		// If the current intention is empty and teh other intentions are
		// also empty then we want to remain in stage A.
		if (currentstage == ActionRuleStage) {
			if (! ag.lastruleexecuted.equals("Drop Intention If Empty")) {
				currentstage = TransformerFunction;	
			} 
		} else if (currentstage == TransformerFunction) {
			if (ag.getIntention() == null || ag.getIntention().empty() || (ag.getIntention().hdE().referstoGoal() && ag.getIntention().hdE().getGoal().getGoalType() == Goal.achieveGoal)) {
				currentstage = Perception;			
				setStopandCheck(true);
			} else {
				currentstage = TransformerFunction;
			}
		} else if (currentstage == Perception) {
			currentstage = MessageReceipt;
		} else {
			currentstage = ActionRuleStage;
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
		// stopandcheck = false;
		return tmp;
	} 
	
	public void setStopandCheck(boolean b) {
		stopandcheck = b;
	}

	public void setCurrentStage(RCStage rcs) {
		currentstage = (GOALRCStage) rcs;
	}
	
	public boolean not_interrupted() {
		return !interrupted;
	}

}
