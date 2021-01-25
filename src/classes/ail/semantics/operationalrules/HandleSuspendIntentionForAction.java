package ail.semantics.operationalrules;

import java.util.Iterator;

import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import ail.syntax.Action;
import ail.syntax.Deed;
import ail.syntax.Event;
import ail.syntax.Goal;
import ail.syntax.Intention;
import ail.syntax.SendAction;
import ail.syntax.Unifier;
import ajpf.util.VerifySet;
import gov.nasa.jpf.annotation.FilterField;

/*
	This rule suspends an action's intention and waits until the action has 1) Completed with success, 2) Failed, or 3) Aborted
	@author pws
*/
public class HandleSuspendIntentionForAction extends HandleTopDeed {
	
	private static final String name = "Suspend Intention";
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#getName()
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#checkPreconditions(ail.semantics.AILAgent)
	 */
	public boolean checkPreconditions(AILAgent a) {
		if (super.checkPreconditions(a) && topdeed.getCategory() == Event.AILSent) {
			return true;
		}

		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		// get the current intention from the agent
		i = a.getIntention();
		// suspend the current action's intention
		i.suspend();
		// i.suspendFor(beliefcondition);
		
		// update the agent? find out if i.suspend^ does this
		a.setIntention(i);
		// wait until action has completed.
		
		
	}
	
}
