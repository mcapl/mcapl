package ail.syntax;

import org.junit.Test;
import ail.semantics.AILAgent;
import ail.semantics.operationalrules.HandleActionwIntentionSuspend;
import ail.util.AILPrettyPrinter;
import junit.framework.Assert;

public class ActionSuspendsIntentionQuickTests {

	@Test
	public void goalSuspendedTest() {
		
		// --- Agent ---
		
		//Create new AIL agent & other required bits
		AILAgent a = new AILAgent();
		Unifier u = new Unifier();
		Goal g1 = new Goal("goal1", Goal.achieveGoal);
		Action a1 = new Action("action1");
		//Create new intention with a goal
		Intention i = new Intention(g1, AILAgent.refertoself(), new AILPrettyPrinter());
		a.addGoal(g1);
		//Assign intention to agent
		a.setIntention(i);
		//Send a new Intention containing sent action deed to top of stack
		i.iCons(new Event(Event.AILAction), new Deed(a1), new Guard(new GBelief()), u);
		a.setIntention(i);
		
		// --- Environment ---
		
		
		
		
		
		// --- Testing ---
		
		//Set the agent to complete the new intention
		HandleActionwIntentionSuspend suspendintention = new HandleActionwIntentionSuspend();
		// Test that TRUE is returned when checking the required preconditions for the rule
		Assert.assertTrue(suspendintention.checkPreconditions(a));
		
		
		// Test Requires an environment to run action in, I haven't found a simple way to spoof this yet.
		
		// Apply suspend rule to the agent
		//suspendintention.apply(a);
		// Test that TRUE is returned when checking if the **intention** is suspended.
		//Assert.assertTrue(i.suspended());
	}

}
