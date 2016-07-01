package goal.semantics.operationalrules;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import ail.semantics.AILAgent;
import ail.syntax.Action;
import ail.syntax.BroadcastMessage;
import ail.syntax.Deed;
import ail.syntax.Literal;
import goal.mas.GOALEnv;
import goal.semantics.GOALAgent;
import goal.syntax.GOALSendAction;
import goal.syntax.GoalMessage;
import goal.syntax.MentalState;
import goal.syntax.PrintAction;
import gov.nasa.jpf.annotation.FilterField;

public class SendOnceActionExecutor extends ActionExecutor {
	@FilterField
	private final static String name = "Send Action Executor";

	private GOALSendAction action;
		
	public String getName() {
		return name;
	}

	@Override
	public boolean checkPreconditions(AILAgent a) {
		Deed d = a.getIntention().hdD();
		
		boolean isaction = d.getCategory() == Deed.DAction;
		
		if (isaction) {
			Action act = (Action) d.getContent();
			if (act instanceof GOALSendAction) {
				action = (GOALSendAction) act;
				if (action.getType() == GOALSendAction.SENDONCE) {
					return true;
				}
			}
		} 
		
		return false;		
	}
	
    @Override
    public void apply(AILAgent a) {
    	GOALAgent gag = (GOALAgent) a;
    	MentalState mentalState = gag.getMentalState();
    	
    	action.apply(a.getIntention().hdU());

        GoalMessage message = this.action.getMessage(gag.getAgName());
        
        // Set<String> receivers = message.getReceivers();
        // Set<String> done = new LinkedHashSet<>();
        
        // NB. GOAL seems to be sending to a receiver at a time, below we just check if the message has been sent!!
        
        
        //for (String agent: receivers) {
        	// update is the update to the mental state required by the action, filtered through conversion from mental  state representation.
        	//Update update = mentalState.getState().convert(
            //        this.action.getMessage(), true, receiver);
        	// If we queried the  mental state with the update, return set of query is true for.
        	//if (!mentalState
            //        .query(update.toQuery(), BASETYPE.MAILBOX, debugger)
           //         .isEmpty()) {
        	//	done.add(receiver);
        	//}	
       // }

        // message.setReceivers(receivers);
        // message.setSender(mentalState.getAgentId());

    	Literal messagelit = new Literal("sent");
    	messagelit.addTerm(message.toTerm());
    	try {
    		if ( mentalState.getOwnBase(MentalState.BASETYPE.MESSAGEBASE).contains(messagelit) == null) {
    			((GOALEnv) gag.getEnv()).postMessage(message);
	        
	
	        	mentalState.getOwnBase(MentalState.BASETYPE.MESSAGEBASE).add(messagelit);
    		}
    	} catch (Exception e) {
	        	System.err.println("Problem Sending Message" + e);
    	}

        mentalState.updateGoalState(); 
		a.getIntention().tlI(a);

    }


}
