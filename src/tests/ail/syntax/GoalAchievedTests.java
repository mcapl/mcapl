package ail.syntax;

import junit.framework.Assert;

import org.junit.Test;

import java.util.Random;

import ail.semantics.AILAgent;
import ail.semantics.operationalrules.HandleAddAchieveTestGoal;
import ail.semantics.operationalrules.HandleAddAchieveTestGoalwEvent;

public class GoalAchievedTests {
	@Test public void goalAchievedTest() {
		Literal empty = new Literal("empty");
		
		AILAgent ag = new AILAgent();
		ag.addBel(new GBelief(empty), BeliefBase.TSelf);
		
		Goal emptyg = new Goal("empty");
		
		Intention i = new Intention(emptyg, AILAgent.refertoself());
		ag.setIntention(i);

		HandleAddAchieveTestGoal addgoal = new HandleAddAchieveTestGoal();
		
		Assert.assertTrue(addgoal.checkPreconditions(ag));
		addgoal.apply(ag);
		Assert.assertFalse(ag.getGoals().hasNext());
	}

}
