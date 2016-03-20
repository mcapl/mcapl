package goal.semantics.operationalrules;

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

public class SendActionExecutor extends ActionExecutor {
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
				return true;
			}
		} 
		
		return false;		
	}
	
    @Override
    public void apply(AILAgent a) {
    	GOALAgent gag = (GOALAgent) a;
    	MentalState mentalState = gag.getMentalState();

        GoalMessage message = this.action.getMessage(gag.getAgName());

        // message.setReceivers(receivers);
        // message.setSender(mentalState.getAgentId());

        try {
        	((GOALEnv) gag.getEnv()).postMessage(message);
        
        	Literal messagelit = new Literal("sent");
        	messagelit.addTerm(message.toTerm());

        	mentalState.getOwnBase(MentalState.BASETYPE.MESSAGEBASE).add(messagelit);
        } catch (Exception e) {
        	System.err.println("Problem Sending Message" + e);
        }

        mentalState.updateGoalState(); // TRAC #749
    }


}
