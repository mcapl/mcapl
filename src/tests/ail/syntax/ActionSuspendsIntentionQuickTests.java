package ail.syntax;

import static org.junit.Assert.*;


import org.junit.Test;

import ail.semantics.AILAgent;
import ail.semantics.operationalrules.HandleSuspendIntentionForAction;
import junit.framework.Assert;

public class ActionSuspendsIntentionQuickTests {

	@Test
	public void goalSuspendedTest() {
		
		//Create new AIL agent
		AILAgent a = new AILAgent();
		Unifier u = new Unifier();
		
		
		//Create a new Intention containing sent action deed
		Intention i = new Intention(new Event(Event.AILSent), u, AILAgent.refertoself(), a.getPrettyPrinter());
		a.setIntention(i);
		//Set the agent to complete the new intention
		HandleSuspendIntentionForAction suspendintention = new HandleSuspendIntentionForAction();
		
		// Test that TRUE is returned when checking the required preconditions for the rule
		Assert.assertTrue(suspendintention.checkPreconditions(a));
		
		// Apply suspend rule to the agent
		suspendintention.apply(a);
		// Test that TRUE is returned when checking if the **intention** is suspended.
		Assert.assertTrue(i.suspended());
	}

}
