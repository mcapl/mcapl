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

package goal.semantics.operationalrules;

import java.util.ArrayList;
import java.util.LinkedList;
import ail.semantics.operationalrules.*;

import ail.semantics.AILAgent;
import ail.syntax.Intention;
import ail.syntax.ApplicablePlan;
import ail.syntax.DefaultAILStructure;
import ail.syntax.Event;
import ail.syntax.GBelief;
import ail.syntax.Goal;
import ail.syntax.Guard;
import ail.syntax.Literal;
import ail.semantics.OSRule;
import goal.mas.GoalEnvironment;
import goal.semantics.executorStages.ModuleExecutorStage;

import java.util.Iterator;

import ajpf.util.AJPFLogger;

import gov.nasa.jpf.annotation.FilterField;
//import gov.nasa.jpf.jvm.abstraction.filter.FilterField;
import gov.nasa.jpf.vm.Verify;

/**
 * This rules selects a capability to use to achieve the agent's goals.
 * 
 * @author lad
 *
 */
public class UserSpecAction implements OSRule {
	@FilterField
	private final static String name = "Plan with Action Specs";
	
	public UserSpecAction(ModuleExecutorStage mes) {
		
	}
	
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#checkPreconditions(ail.semantics.AILAgent)
	 */
	public boolean checkPreconditions(AILAgent a) {
		Intention i = a.getIntention();
		if (i == null) {
			return false;
		}
		if (i.empty()) {
			return false;
		}
		if (i.hdE().getCategory() == Event.AILContent) {
			return false;
		}
		if (i.hdE().getCategory() == Event.AILContext) {
			return false;
		}
	/*	if (!(i.hdE().getGoal() == null) && i.hdE().getGoal().getGoalType() == Goal.achieveGoal) { 
			return false;
		} */
		
		return true;

	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		Intention i = a.getIntention();
		Iterator<ApplicablePlan> aps = a.filterPlans(a.appPlans(i));
		// System.err.println(((GOALAgent) a).generatedthis);
		
		if (aps.hasNext()) {
			ApplicablePlan p = aps.next();
		
			ArrayList<Guard> guardstack = p.getGuard();
			
/*			if (p.getN() == 0 && (! (guardstack.isEmpty()) && (! (guardstack.get(guardstack.size() - 1).isTrivial())))) {
				Literal gl = new Literal("state");
				gl.addTerm(guardstack.get(guardstack.size() - 1).toTerm());
				Event state = new Event(Event.AILAddition, DefaultAILStructure.AILBel, gl);
				// change the head of the guardstack to trivial - presumably the head should be false by the time the plan has finished executing
				guardstack.set(guardstack.size() - 1, new Guard(new GBelief(GBelief.GTrue)));
				a.setIntention(new Intention(state, p.getPrefix(), guardstack, p.getUnifier().clone(), AILAgent.refertoself()));
				a.getIntentions().add(i);
				AJPFLogger.info("goal.semantics.operationalrules.PlanWithActionSpec", a.getAgName() + " does " + p.getEvent());
				((GoalEnvironment) a.getEnv()).notifyListeners("scheduler");
			} else if (p.getN() == 0 && (! (guardstack.isEmpty()) && ((guardstack.get(guardstack.size() - 1).isTrivial())))) {
				Literal gl = new Literal("alwaystrue");
				Event state = new Event(Event.AILAddition, DefaultAILStructure.AILBel, gl);
				a.setIntention(new Intention(state, p.getPrefix(), guardstack, p.getUnifier().clone(), AILAgent.refertoself()));				
				a.getIntentions().add(i);
				AJPFLogger.info("goal.semantics.operationalrules.PlanWithActionSpec", a.getAgName() + " does " + p.getEvent());
				((GoalEnvironment) a.getEnv()).notifyListeners("scheduler");
			} else {
				i.dropP(p.getN());
				i.compose(p.getUnifier().clone());
				i.iConcat(p.getEvent(), p.getPrefix(), p.getGuard(), p.getUnifier().clone());
				AJPFLogger.info("goal.semantics.operationalrules.PlanWithActionSpec", a.getAgName() + " does " + p.getEvent() + p.getUnifier());
				((GoalEnvironment) a.getEnv()).notifyListeners("scheduler");
			} */
		} else {
		/*	if (i.hdE().referstoGoal() && i.hdE().getGoal().getGoalType() == Goal.performGoal) {
				i.dropE(i.size());
			} */
		} 
	}
}