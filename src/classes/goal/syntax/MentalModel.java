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
package goal.syntax;

import ail.semantics.AILAgent;
import ail.semantics.AgentMentalState;
import ail.syntax.BeliefBase;
import ail.syntax.CapabilityLibrary;
import ail.syntax.GoalBase;
import ail.syntax.Goal;
import ail.syntax.Message;
import ail.syntax.PlanLibrary;
import ail.syntax.RuleBase;
import ail.syntax.Predicate;
import ail.syntax.Guard;
import ail.syntax.GBelief;
import ail.syntax.StringTerm;
import ail.syntax.StringTermImpl;
import ail.syntax.Unifier;
import ail.syntax.NamedEvaluationBase;
import ail.syntax.PredicateTerm;
import ail.syntax.Literal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Stack;

public class MentalModel implements AgentMentalState {
    /**
     * A map containing the various {@link BeliefBase}s of type {@link BASETYPE}
     * maintained by this {@link MentalModel}.
     * <p>
     * The knowledge of the agent is stored in its knowledge base. This base is
     * static and does not change during runtime.
     * </p>
     * <p>
     * A knowledge base is only used for the agent itself (the owner of this
     * mental model) and not for other agents whose mental state is may be
     * modeling. The idea here is that an agent does not have any direct or
     * indirect access to the knowledge of another agent.
     * </p>
     * <p>
     * The percepts the agent receives from its environment are stored in its
     * percept base. This base is cleaned every reasoning cycle and the new
     * percepts received are inserted.
     * </p>
     * <p>
     * A percept base is only used for the agent itself (the owner of this
     * mental model) and not for other agents because the agent does not have
     * access to what another agent observes (and should store what it believes
     * another agent has observed in that agent's mental model's belief base).
     * </p>
     * <p>
     * The mail messages the agent receives from and sents to other agents are
     * stored in its mailbox. This base is not cleaned but new messages are
     * added. It is up to the agent itself to remove old messages.
     * </p>
     * <p>
     * For reasons similar to those given for percepts above, a mailbox is only
     * used for the agent itself (the owner of this mental model) and not for
     * other agents.
     * </p>
     * <p>
     * The beliefs of the agent that represent its environment are stored in its
     * belief base. This is a base that is updated at runtime and used for
     * maintaining an accurate picture of the actual state of affairs.
     * </p>
     * <p>
     * A belief base is also used for other modeling the beliefs of other agents
     * than the agent itself. That is, for maintaining a mental model of another
     * agent's beliefs. The agent, of course, does not have direct access to
     * another agent's beliefs and has to base such a mental model on what it
     * observes the other agent is doing (from messages received, actions it
     * performs).
     * </p>
     */
    private final Map<MentalState.BASETYPE, BeliefBase> beliefBases = new LinkedHashMap<>();

    public Stack<ConjGoalBase> goalbases = new Stack<>();
	RuleBase rb;
	
	public MentalModel() {
		beliefBases.put(MentalState.BASETYPE.PERCEPTBASE, new BeliefBase());
		addMessageBase(new BeliefBase());
	}

	
	public void addBB(BeliefBase b) {
		beliefBases.put(MentalState.BASETYPE.BELIEFBASE, b);
	}
	
	public void addPerceptBase(BeliefBase b) {
		beliefBases.put(MentalState.BASETYPE.PERCEPTBASE, b);
	}
	
	public void addMessageBase(BeliefBase b) {
		beliefBases.put(MentalState.BASETYPE.MESSAGEBASE, b);
	}
	
	public void addGB(ConjGoalBase g) {
		goalbases.push(g);
	}
	
	public void addRB(RuleBase rb) {
		this.rb = rb;
	}
	
	public Iterator<Literal> getPercepts() {
		return beliefBases.get(MentalState.BASETYPE.PERCEPTBASE).getPercepts();
	}
	
	public void updateGoalState() {
		if (goalbases.isEmpty()) {
			return;
		}
		
        List<ConjGoal> goals = getAttentionSet(true).getAllConjGoals();
        List<ConjGoal> goalsToBeRemoved = new LinkedList<>();
        for (ConjGoal goal : goals) {
        	Guard gb = goal.getAsGuard();
        		
        	if (gb.logicalConsequence(this, new Unifier(), gb.getVarNames(), AILAgent.SelectionOrder.LINEAR).hasNext()) {
        		goalsToBeRemoved.add(goal);
        	}
        }

        for (ConjGoal goal : goalsToBeRemoved) {
        	getAttentionSet(true).remove(goal);
        }
        
	}
	
    protected ConjGoalBase getAttentionSet(boolean use) {
    	return goalbases.peek();
    }
    
    public BeliefBase getBB() {
    	return getBB(new StringTermImpl(""));
    }
    
    public BeliefBase getPerceptBase() {
    	return beliefBases.get(MentalState.BASETYPE.PERCEPTBASE);
    }
    
    public BeliefBase getMessageBase() {
    	return beliefBases.get(MentalState.BASETYPE.MESSAGEBASE);
    }
    
    public void adopt(ConjGoal g) {
    	getAttentionSet(true).add(g);
    }

	@Override
	public BeliefBase getBB(StringTerm s) {
		// TODO Auto-generated method stub
		return beliefBases.get(MentalState.BASETYPE.BELIEFBASE);
	}

	@Override
	public Set<String> getBBList() {
		// TODO Auto-generated method stub
		Set<String> bblist = new HashSet<String>();
		bblist.add("");
		bblist.add("percepts");
		bblist.add("messages");
		return bblist;
	}

	@Override
	public RuleBase getRuleBase() {
		// TODO Auto-generated method stub
		if (rb != null) {
			return rb;
		} else {
			return new RuleBase();
		}
	}

	@Override
	public CapabilityLibrary getCL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getOutbox() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getInbox() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GoalBase getGoalBase(StringTerm s) {
		// TODO Auto-generated method stub
		return goalbases.peek();
	}

	@Override
	public Set<String> getGBList() {
		HashSet<String> bblist = new HashSet<String>();
		bblist.add("");
		return bblist;
	}

	@Override
	public PlanLibrary getPL() {
		// TODO Auto-generated method stub
		return null;
	}

	public void focus(ConjGoalBase newAttentionSet) {
		addGB(newAttentionSet);
	}

	public List<Goal> getGoals() {
		return getAttentionSet().getAll();
	}
	
	ConjGoalBase getAttentionSet() {
		return goalbases.peek();
	}
	
	public void defocus() {
		ConjGoalBase oldAttentionSet = goalbases.pop();
		oldAttentionSet.cleanup();
		updateGoalState();
	}
	
	 /**
     * @param type
     *            The type to fetch.
     * @return The base for the given type.
     */
    public BeliefBase getBase(MentalState.BASETYPE type) {
            return this.beliefBases.get(type);
    }
    
    public String toString() {
    	String s = "";
    	s += "   beliefs:";
    	s += getBB().toString();
    	s += "\n";
    	
    	s += "   percepts:";
    	s += getPerceptBase().toString();
    	s += "\n";
    	
    	s += "   messages:";
    	s += getMessageBase().toString();
    	s += "\n";
    	
    	s += "   goals:";
    	s += getGoals().toString();
    	s += "\n";
    	
    	return s;
    	
    }



}
