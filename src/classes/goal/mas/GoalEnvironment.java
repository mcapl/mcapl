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

package goal.mas;

import ail.util.AILConfig;
import ail.util.AILexception;
import ajpf.MCAPLScheduler;
import ajpf.PerceptListener;
import ail.semantics.AILAgent;
import ail.syntax.Message;
import ail.syntax.Unifier;
import ail.syntax.Action;
import ail.syntax.Literal;
import ail.syntax.BroadcastSendAction;
import ail.syntax.StringTerm;
import ail.syntax.StringTermImpl;
import ail.syntax.Predicate;
import ajpf.util.AJPFLogger;

import ajpf.util.AJPFLogger;
import ajpf.util.VerifySet;

import goal.syntax.GoalMessage;
import gov.nasa.jpf.vm.Verify;
import gov.nasa.jpf.annotation.FilterField;
//import gov.nasa.jpf.jvm.abstraction.filter.FilterField;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import ail.mas.AILEnv;
import ail.mas.ActionScheduler;

/**
 * An environment for Goal Agents with the semantics or GOAL with communication as developed by Hindriks and
 * van Riemsdijk from "A Computational Semantics for Communicating Rational Agents
 * Based on Mental Models", ProMAS'09, 2009.
 * 
 *  This handles the creation, selection and removal of conversatoins and conversation ids
 *  as specified in the above paper.
 * @author louiseadennis
 *
 */
public class GoalEnvironment implements AILEnv { 

	/**
	 * Three types of message.
	 */
	public static byte Declarative = 1;
	public static byte Imperative = 2;
	public static byte Interrogative = 3;
	public static byte InformPlan = 4;
	public static byte InformConstraint = 5;

	/**
	 * Output level for debuggin.
	 */
	//private int outputlevel = 0;
	
	/**
	 * The list of percept listeners.
	 */
	public List<PerceptListener> perceptListeners = null;
	
	// The last action performed and the agent performing it.
	@FilterField
	private Action lastAction;
	@FilterField
	private String lastAgent;
	// Tracks the last conversation to be closed.  Assists in preventing confusion
	// about conversations among agents.
	@FilterField
	private int conversationnumber = 0;
		
		
	/**
	 * A map of agents to their pending messages.
	 */
	private Map<String, List<GoalMessage>> agMessages = new HashMap<String, List<GoalMessage>>();
	/**
	 * List of agents who have already "collected" the current set of percepts.
	 */
	@FilterField
	protected List<String> uptodateAgs = new ArrayList<String>();
	
	/**
	 * Conversations that have been requested but are not yet active.
	 */
	protected final Queue<GoalMessage> pendingConversations = new LinkedList<GoalMessage>();
	/**
	 * Active Conversations.
	 */
	protected final Queue<String> activeConversations = new LinkedList<String>();
	/**
	 * Conversations an agent is involved in,  indexed by agent name.
	 */
	protected final HashMap<String, List<String>> agentConversations = new HashMap<String, List<String>>();
	/**
	 * Initiators of conversattions.
	 */
	protected final HashMap<String, String> conversationInitiators = new HashMap<String, String>();
	/**
	 * The start messages of currently active conversations.
	 */
	@FilterField
	protected final HashMap<String, GoalMessage> activeStartMessages = new HashMap<String, GoalMessage>();
	/**
	 * List of things only some agents can percieve indexed by agent.
	 */
	private Map<String,Set<Predicate>>  agPercepts = new HashMap<String, Set<Predicate>>();
	
	private ArrayList<AILAgent> agents = new ArrayList<AILAgent>();
	
	private boolean isdone = false;
	
	MCAPLScheduler scheduler;
	
	public GoalEnvironment() {
		ActionScheduler s = new ActionScheduler();
		setScheduler(s);
		addPerceptListener(s);
	}
	
	/**
	 * Add an agent to the list the environment knows about.
	 * @param a
	 */
	public void addAgent(AILAgent a) {
		agents.add(a);
		ArrayList<GoalMessage> msgl = new ArrayList<GoalMessage>();
		if (agMessages.get(a.getAgName()) == null) {
			agMessages.put(a.getAgName(), msgl);
		}
		if (agPercepts.get(a.getAgName()) == null) {
			VerifySet<Predicate> agl = new VerifySet<Predicate>();
			agPercepts.put(a.getAgName(), agl);
		}
	}

	/**
	 * Create a conversation from message m.
	 * @param m
	 */
	protected void createconversation(GoalMessage m) {
		int numconv = activeConversations.size() + 1;
		for (int i = 0; i <= numconv; i++) {
			String pid = ((Integer) i).toString();
			// Find a pid of a conversation that hasn't been recently closed.
			// NB. We want to recycle conversation numbers to allow looping
			// during model checking.
			if (! activeConversations.contains(pid) && conversationnumber != i) {
				pid = ((Integer) i).toString();
				// At the id to the list of active conversations
				// and archive it's start message.
				activeConversations.add(pid);
				activeStartMessages.put(pid, (GoalMessage) m.clone());
				// Get the other participants int he conversation.
				ArrayList<String> conversers = (ArrayList<String>) m.getReceivers().clone();
				
				// Create conversatoin literal and add to relevant agent percepts.
				Literal conversation = new Literal("conversation");
				conversation.addTerm(new StringTermImpl(pid));
				conversation.addTerm(new Predicate (m.getSender()));
				m.setConversationID(new StringTermImpl(pid));
				
				for (String r: m.getReceivers()) {
					addMessage(r, m);
					addPercept(r, conversation);
				}
				conversers.add(m.getSender());
				Collections.sort(conversers);
				
				agentConversations.put(pid, conversers);
				conversationInitiators.put(pid, m.getSender());
				
				addPercept(m.getSender(), conversation);
			}
		}
	} 
	
	/**
	 * Remove the perceptions about the conversation from agents.
	 * @param id
	 */
	protected void removeconversationpercepts(StringTerm id) {
		Literal conversation = new Literal("conversation");
		conversation.addTerm(id);
		conversation.addTerm(new Predicate (conversationInitiators.get(id.getString())));
		for (String ag: agentConversations.get(id.getString())) {
			removePercept(ag, conversation);
		}
	} 
	
	/** Adds a perception for a specific agent.
	 * NB.  NOT thread safe, should only be called from synchornized contexts.
	 * */
	public void addPercept(String agName, Literal per) {
		if (per != null && agName != null) {
			Set<Predicate> agl = agPercepts.get(agName);
			if (agl == null) {
				agl = new VerifySet<Predicate>();
				uptodateAgs.remove(agName);
				agl.add(per);
				agPercepts.put( agName, agl);
			} else {
				if (! agl.contains(per)) {
					uptodateAgs.remove(agName);
					agl.add(per);
				}
			}
		}
		notifyListeners(agName);
	}
	
	/** Removes a perception for one agent */
	public boolean removePercept(String agName, Literal per) {
			if (per != null && agName != null) {
				Set<Predicate> agl = agPercepts.get(agName);
				if (agl != null) {
					uptodateAgs.remove(agName);
					for (Predicate l: agl) {
						if (l.equals(per)) {
							return agl.remove(l);
						}
					}
				}
			}
		
			notifyListeners(agName);
			return false;
	}


	/** Clears the list of  messages of a specific agent */
	private void clearMessages(String agName) {
			if (agName != null) {
				List<GoalMessage> agl = agMessages.get(agName);
				if (agl != null) {
					agl.clear();
				}
			}
	 } 
	

	/** Adds a message for a specific agent */
	public void addMessage(String agName, Message msg) {
		boolean updateandnotify = true;
		//synchronized (busyperceptflag) {
			if (msg != null && agName != null) {
				List<GoalMessage> msgl = agMessages.get(agName);
				if (msgl == null) {
					msgl = new ArrayList<GoalMessage>();
					msgl.add((GoalMessage) msg);
					agMessages.put( agName, msgl);
				} else {
//					synchronized(msgl) {
					if (!msgl.contains((GoalMessage) msg)) {
//						System.err.println(msgl);
						msgl.add((GoalMessage) msg);
				//		System.err.println(msgl);
					} else {
						updateandnotify = false;
					}
				//	System.err.println(msgl);
				//	System.err.println(msg);
					Collections.sort(msgl);
	//				}
				}
				if (updateandnotify) {
					uptodateAgs.remove(agName);
					try {
						Collections.sort(uptodateAgs);
					} catch (Exception e) {
						System.err.println(e);
					}
				}
			}
		//}
		
 
			if (updateandnotify) {
				notifyListeners(agName);
			}
	}

	 public Set<Message> getMessages(String agName) {
			int size;

	    		List<GoalMessage> agl = agMessages.get(agName);
				if (agl != null) {
					size = agl.size();
				} else {
					size = 0;
				}
				Set<Message> p = new VerifySet<Message>();
			
				if (agl != null) {
					p.addAll(agl);
					clearMessages(agName);
				}
			
				if (!uptodateAgs.contains(agName)) {
					uptodateAgs.add(agName);	
					Collections.sort(uptodateAgs);
				}
				
				return p;
	    }
	 
	 /**
	  * Selects a new conversation to become active, bearing in mind agents
	  * can only be involved in one conversation.  See paper for description.
	  * @return
	  */
	 public ArrayList<GoalMessage> MaxFifoList() {
		 ArrayList<String> conversers = new ArrayList<String>();
		 ArrayList<GoalMessage> messages = new ArrayList<GoalMessage>();
		 for (List<String> cs: agentConversations.values()) {
			 conversers.addAll(cs);
		 }

		 for (GoalMessage m: pendingConversations) {
			 boolean viableflag = true;
			 if (! conversers.contains(m.getSender())) {
				 for (String r: m.getReceivers()) {
					 if (conversers.contains(r)) {
						 viableflag = false;
						 break;
					 }
				 }
				 
				 if (viableflag) {
					 conversers.add(m.getSender());
					 conversers.addAll(m.getReceivers());
					 messages.add(m);
				 }
			 }
		 }
		 
		 return messages;
	 }
	 

	 /**
	  * Handle the actions - i.e. send and close actions of the agents.
	  */
	public Unifier executeAction(String agName, Action act) throws AILexception {
	    lastAgent = agName;
	    lastAction = act;
	    boolean somethinghappened = true;
	    	    	
	    if (act instanceof BroadcastSendAction) {
   		BroadcastSendAction sent = (BroadcastSendAction) act;
   		GoalMessage m = (GoalMessage) sent.getMessage(agName);
   		StringTerm id = (StringTerm) m.getConversationID();
   		String idstring = id.getString();
   		ArrayList<String> receivers = m.getReceivers();
   		
   		// If the agent is not trying to initiate a new conversatoin.
   		if (! idstring.equals("new")) {
   			// Assuming this is a message in a still open conversation
   			// add the message to relevant message lists.
   			if (activeConversations.contains(idstring)) {	
   				for (String r: receivers) {
    						addMessage(r, m);
   				}
   			} else {
   				somethinghappened = false;
   			}
   			//System.err.println(agMessages);
   		} else {
   			// This is a new conversation.  Let's assume it won't have
   			// to wait.
   			boolean pendingflag = false;
   			
   			// Let's discover which agents are currently involved in conversations.
   			//synchronized(busyperceptflag) {
   			if (!pendingConversations.contains(m) && ! activeStartMessages.values().contains(m)) {
   				//synchronized (busyperceptflag) {
   					ArrayList<String> conversers = new ArrayList<String>();
   					for (List<String> conv : agentConversations.values()) {
   						conversers.addAll(conv);
   					}
   			
   			// If one of them is the sender of this message then it's going
   			// to have to become pending.
   					if (conversers.contains(m.getSender())) {
   						if (! pendingConversations.contains(m)) {
   							if (! activeStartMessages.values().contains(m)) {
   									pendingConversations.add(m);	
   							}
   						}
   					} else {
   				// Similarly if one of them is a recipient of this message.
   						for (String r: receivers) {
   							if (conversers.contains(r)) {
   								if (! pendingConversations.contains(m)) {
   										pendingConversations.add(m);
   								}
   								pendingflag = true;
   								break;
   							}
   						}
   		
   				// Otherwise create a new conversation.
   						if (!pendingflag) {
   								createconversation(m);
   						}
   					}
   			
   			} else {
   				somethinghappened = false;
  			//	ping();
   			}
   		}
	    } else {
	    	// If a conversation is being closed.
    		if (act.getFunctor().equals("close")) {
    			StringTerm cid = ((StringTerm) act.getTerm(0));
    			removeconversationpercepts(cid);
    				activeConversations.remove(cid.getString());
    				agentConversations.remove(cid.getString());
    				conversationInitiators.remove(cid.getString());
    				activeStartMessages.remove(cid);
    			
    			// See if any new ones can now start.
    				ArrayList<GoalMessage> fifo = MaxFifoList();
    				pendingConversations.removeAll(fifo);
    			
    				conversationnumber = Integer.parseInt(cid.getString());
    				for (GoalMessage m1: fifo) {
    					createconversation(m1);
    				}
     		}
    		
//				synchronized(busyperceptflag) {
 //  				}

     	}
 
	    	// Using StringBuffers for efficiency and atomic because they aren't thread safe.
	    if (somethinghappened ) {
	    	StringBuilder s = new StringBuilder();
	    	s.append(agName);
	    	s.append(" done ");
	    	s.append(printAction(act));
	    
	    	AJPFLogger.info("goal.mas.GoalEnvironment", s.toString());
	    }
	    
	    return new Unifier();

	}
	   
	
	/*
	 * (non-Javadoc)
	 * @see ail.others.AILEnv#getPercepts(java.lang.String, boolean)
	 */
	public Set<Predicate> getPercepts(String agName, boolean update) {
		int size;
    		Set<Predicate> agl = agPercepts.get(agName);
			if (agl != null) {
				size = agl.size();
			} else {
				size = 0;
			}
			Set<Predicate> p = new VerifySet<Predicate>();
		
			if (agl != null) {
				for (Predicate per: agl) {
					p.add((Literal) per.clone());
				}
			}
		
			uptodateAgs.add(agName);
			
			if (isdone) {
				p.add(new Literal("done"));
			}
			
			return p;
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.others.AILEnv#done()
	 */    
	public boolean done() {
		return true;
	}
	    
	/*
	 * (non-Javadoc)
	 * @see ail.others.AILEnv#lastAction()
	 */
	public Action lastAction() {
	    return( lastAction );
	}
	 
	/*
	 * (non-Javadoc)
	 * @see ail.others.AILEnv#lastActionby()
	 */
	public String lastActionby() {
	    return( lastAgent );
	}
	  
	/*
	 * (non-Javadoc)
	 * @see ail.others.AILEnv#nothingPending(java.lang.String)
	 */
	public boolean nothingPending(String agName) {
		//synchronized (busyperceptflag) {
			return ((agMessages.get(agName) == null || agMessages.get(agName).isEmpty()) && uptodateAgs.contains(agName) );
		//}
	}
/*
 * (non-Javadoc)
 * @see ail.others.AILEnv#separateThread()
 */
	public boolean separateThread() {
	    return( false );
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
 		Verify.beginAtomic();
 		StringBuffer s = new StringBuffer();
 		s.append("active: ");
 		s.append(activeConversations.toString());
 		s.append("\n pending: ");
 		s.append(pendingConversations.toString());
 		s.append("\n messages: ");
 		s.append(agMessages.toString());
 		String s1 = s.toString();
 		Verify.endAtomic();
 		return s1;
 	}
	
	/**
	 * Add a percept listener to the environment.
	 * @param l
	 */
	public void addPerceptListener(PerceptListener l) {
		if (perceptListeners == null) {
			perceptListeners = new ArrayList<PerceptListener>();
		}
		perceptListeners.add(l);
	 }
	
	   /**
     * Notify the listeners that the perceptions have changed.
     *
     */
    public void notifyListeners() {
    	if (perceptListeners != null) {
    		for (PerceptListener l: perceptListeners) {
    			l.perceptChanged("perception changed");
     		}
    	}
    }

    /**
     * Notify the listents that a particular agent's perceptions have changed.
     * 
     * @param s the name of the agent whose perceptions have changed.
     */
    public void notifyListeners(String s) {
     	if (perceptListeners != null) {
    		for (PerceptListener l: perceptListeners) {
    			// NB.  We also inform the scheduler as well as any listener associated with the agent.
     			if (l.getListenerName().equals(s) || l.getListenerName().equals("scheduler")) {
    				l.perceptChanged(s);
    			}
    		}
    	}
    }
    
    /**
     * Pretting printing for actions - specifically sending of messages
     * with performatives.
     * @param act
     * @return
     */
    protected String printAction(Action act) {
    	if (act instanceof BroadcastSendAction) {
    		BroadcastSendAction sa = (BroadcastSendAction) act;
    		Verify.beginAtomic();
    		StringBuffer sb = new StringBuffer();
    		sb.append("send(");
    		sb.append(ilfString(sa.getILF()));
    		sb.append(sa.getContent().toString());
    		sb.append(", ");
    		sb.append(sa.getReceivers().toString());
    		sb.append(")");
    		String s = sb.toString();
    		Verify.endAtomic();
    		return s;
    	} else {
    		return act.toString();
    	}
    }
    
    /**
     * Return the string to represent various performatices.
     * @param i
     * @return
     */
    protected String ilfString(int i) {
    	if (i == Declarative) {
    		return ".";
    	} else if (i == Imperative) {
    		return "!";
    	} else {
    		return "?";
    	}
    }
    
     
    /*
     * (non-Javadoc)
     * @see ail.others.AILEnv#setOutputLevel(int)
     */
     
    public void cleanup() {
    	isdone = true;
    }
    
    public void init() {
    	
    }
 
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#configure(ail.util.AILConfig)
	 */
	public void configure(AILConfig config) {
	}

	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#getScheduler()
	 */
	public MCAPLScheduler getScheduler() {
		return scheduler;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#setScheduler(ajpf.MCAPLScheduler)
	 */
	public void setScheduler(MCAPLScheduler s) {
		scheduler = s;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() {}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#initialise()
	 */
	public void initialise() {}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#executing(java.lang.String, ail.syntax.Action)
	 */
	public boolean executing(String agName, Action act) {
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#actionResult(java.lang.String, ail.syntax.Action)
	 */
	public Unifier actionResult(String agName, Action act) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#agentIsUpToDate(java.lang.String)
	 */
	public boolean agentIsUpToDate(String agName) {
		return false;
	}

}
