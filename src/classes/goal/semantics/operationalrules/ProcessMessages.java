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

import java.util.List;
import java.util.Set;

import ail.semantics.AILAgent;
import ail.syntax.Message;
import ail.semantics.OSRule;
import ail.syntax.Literal;
import ail.syntax.StringTermImpl;
import ail.syntax.Predicate;
import ail.syntax.Term;
import ail.syntax.annotation.SourceAnnotation;
import goal.syntax.GoalMessage;
import goal.syntax.MentalState.BASETYPE;
import goal.mas.GoalEnvironment;
import goal.semantics.GOALAgent;
import goal.syntax.ActionRule;
import gov.nasa.jpf.annotation.FilterField;
import goal.semantics.executorStages.startCycleStage;
//import gov.nasa.jpf.jvm.abstraction.filter.FilterField;

/**
 * A Rule that converts the agent's inbox into intentions.
 * 
 * @author lad
 *
 */
public class ProcessMessages implements OSRule {
	@FilterField
	private static final String name = "Handle Goal Messages";
	private startCycleStage scs;
	
	public enum SentenceMood {
        /**
         * Indicative mood is used for exchanging information.
         */
        INDICATIVE,
        /**
         * Interrogative mood is used for asking questions.
         */
        INTERROGATIVE,
        /**
         * Imperative mood is used for requests and commands.
         */
        IMPERATIVE;

        @Override
        public String toString() {
                switch (this) {
                case INDICATIVE:
                        return ":";
                case INTERROGATIVE:
                        return "?";
                case IMPERATIVE:
                        return "!";
                default:
                        return "";
                }
        }
        
        static public SentenceMood intToSentenceMood(int i) {
        	if (i == 3) {
        		return INDICATIVE;
        	} else if (i == 1) {
        		return INTERROGATIVE;
        	} else {
        		return IMPERATIVE;
        	}
    	}

	}

	public ProcessMessages(startCycleStage scs) {
		this.scs = scs;
	}
	
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
		return true;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		GOALAgent ga = (GOALAgent) a;
		Set<Message> messages = scs.getMessages();
		
        for (Message message : messages) {
            processMessageMentalModel(message, ga);
        	((GOALAgent) a).getMentalState().addReceivedMessage((GoalMessage) message);
        }

    // Check if goals have been achieved and, if so, update goal base.
        ((GOALAgent) a).getMentalState().updateGoalState();


	
		a.clearInbox();
	}
	
	/**
     * Process one message that we received by updating the mental models. This
     * does not update the message box, see also
     * {@link #processMessageToMessagebox(Message)}
     *
     * @param message
     *            the new message
     */
    public static void processMessageMentalModel(Message message, GOALAgent ga) {
            Term update = message.getPropCont();
            String sender = message.getSender();

          //  if (this.usesMentalModels) {
                    if (!ga.getMentalState().getKnownAgents().contains(sender)  && sender != ga.getAgName()) {
                           // try {
                                    ga.getMentalState().addAgentModel(sender);
                       //     } catch (Exception e) {
                       //             throw new IllegalStateException(String.format(
                       //                             Resources.get(WarningStrings.FAILED_ADD_MODEL),
                       //                             sender.getName()), e);
                       //     }
                    }

              switch (SentenceMood.intToSentenceMood(message.getIlForce())) {
                    case INDICATIVE:
                             ga.getMentalState().insert(new Literal((Predicate) update), BASETYPE.BELIEFBASE, sender);
                            break;
                    case IMPERATIVE:
                            ga.getMentalState()
                                            .adopt((Predicate) update, true, sender);
                            ga.getMentalState().delete(new Literal((Predicate) update), BASETYPE.BELIEFBASE,
                                            sender);
                            break;
                    case INTERROGATIVE:
                            ga.getMentalState().delete(new Literal((Predicate) update), BASETYPE.BELIEFBASE,
                                            sender);
                            break;
                    default:
                            //throw new GOALBug("Received a message with unexpected mood: " //$NON-NLS-1$
                            //                + message.getMood());
                    }
                    ga.getMentalState().updateGoalState(sender);
            
    }
    
    public static Literal receivedMessageToTerm(Message message) {
        Term update = message.getPropCont();
        String sender = message.getSender();
        
        Literal l = new Literal("received");
        l.addTerm(new Predicate(sender));
        
        switch (SentenceMood.intToSentenceMood(message.getIlForce())) {
        	case INTERROGATIVE:
        		Predicate cont = new Predicate("int");
        		cont.addTerm(update);
        		l.addTerm(cont);
        		break;
        	case IMPERATIVE:
        		cont = new Predicate("imp");
        		cont.addTerm(update);
        		l.addTerm(cont);
        		break;
        	case INDICATIVE:
        		l.addTerm(update);
        			
        }
        return l;
   	
    }

    public static Literal messageToTerm(Message message) {
        Term update = message.getPropCont();
        String sender = message.getSender();
                
        switch (SentenceMood.intToSentenceMood(message.getIlForce())) {
        	case INTERROGATIVE:
        		Predicate cont = new Predicate("int");
        		cont.addTerm(update);
        		return new Literal(cont);
        	case IMPERATIVE:
        		cont = new Predicate("imp");
        		cont.addTerm(update);
        		return new Literal(cont);
         	case INDICATIVE:
        		return new Literal((Predicate) update);
        			
        }
        return new Literal((Predicate) update);
    	
    }

}