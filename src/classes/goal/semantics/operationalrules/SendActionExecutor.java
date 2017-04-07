// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis, Michael Fisher, and Koen Hindriks
// 
// This file is part of AIL GOAL.  An AIL Implementation of the GOAL Programming
// Language
//
// AIL GOAL is free software: you can redistribute it and/or modify it under
// the terms of the GNU General Public License as published by the Free Software
// Foundation, either version 3 of the License, or (at your option) any later
// version.
//
// AIL GOAL is distributed in the hope that it will be useful, but WITHOUT
// ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
// FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
// details.
//
// You should have received a copy of the GNU General Public License along with
// this program. If not, see <http://www.gnu.org/licenses/>.
//
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------
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
				if (action.getType() == GOALSendAction.SEND) {
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

    	action.clearReceivers();
        action.setReceivers(gag);
        GoalMessage message = this.action.getMessage(gag.getAgName());
        message.addReceivers(action.getReceivers());

       // message.setSender(mentalState.getAgentId());

        try {
        	((GOALEnv) gag.getEnv()).postMessage(message);
        
        	Literal messagelit = new Literal("sent");
        	messagelit.addTerm(message.toTerm());

        	mentalState.getOwnBase(MentalState.BASETYPE.MESSAGEBASE).add(messagelit);
        } catch (Exception e) {
        	System.err.println("Problem Sending Message" + e);
        }

        mentalState.updateGoalState(); 
		a.getIntention().tlI(a);
		module.clearRuleItIfNotApplyAll();

    }


}
