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
import ail.syntax.CapabilityLibrary;
import ail.syntax.Goal;
import ail.syntax.Message;
import ail.syntax.Literal;
import ail.syntax.PlanLibrary;
import ail.syntax.Predicate;
import ail.syntax.BeliefBase;
import ail.syntax.GoalBase;
import ail.syntax.RuleBase;
import ail.syntax.StringTerm;
import ail.syntax.Unifier;
import ail.util.AILexception;
import ajpf.util.VerifyMap;
import ajpf.util.VerifySet;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MentalState {
	MentalModel ownModel = new MentalModel();
	
	private final Set<String> knownAgents = new VerifySet<>();
	private String agentId;
	private final Map<String, MentalModel> models = new VerifyMap<>();

	public MentalState(String agentId) {
	}
	
	public enum BASETYPE {
		/**
		 * A knowledge base. Note that GOAL does not explicitly store the knowledge
		 * base of an agent, but only a list of formulae in the KB, present in the
		 * agent's AgentProgram. This value is mostly there so that the
		 * DatabasePanel can identify that it contains information of the knowledge
		 * base.
		 */
		KNOWLEDGEBASE("knowledge base"),
		/**
		 * database storing data from the belief section, and insert()'ed objects.
		 * There is only 1 beliefbase for an agent. Beliefbase automatically
		 * inherits the Knowledge base.
		 */
		BELIEFBASE("belief base"),
		/**
		 * database storing a single goal, either a single line from a goal section
		 * or from single adopt() actions. Goal bases automatically inherit the
		 * knowledge base; Note that this feature is implemented by the KR layer.
		 */
		GOALBASE("goal base"),
		/**
		 * Database storing messages.
		 */
		MESSAGEBASE("message base"),
		/**
		 * Database storing percepts.
		 */
		PERCEPTBASE("percept base");

		/**
		 * The proper string-representation of this {@link BASETYPE}.
		 */
		private String displayName;

		private BASETYPE(String displayName) {
			this.displayName = displayName;
		}

		@Override
		public String toString() {
			return this.displayName;
		}
	}
	
	public void updateGoalState() {
		ownModel.updateGoalState();
	};
	
	public void updateGoalState(String agentId) {
		this.models.get(agentId).updateGoalState();
	};

	public void addReceivedMessage(GoalMessage m){
		ownModel.getMessageBase().add(new Literal(m.toReceivedTerm()));
	};
	
	public Iterator<Literal> getPercepts() {
		return ownModel.getPercepts();
	};
	
	public void addPercepts(Set<Predicate> ps) {
		ownModel.getPerceptBase().addPercepts(ps);
	};
	
	public void removePercepts() {
		ownModel.getPerceptBase().removePercepts();
	};
	
	public void addBB(BeliefBase b) {
		ownModel.addBB(b);
	}
	
	public void addPerceptBase(BeliefBase b) {
		ownModel.addPerceptBase(b);
	}
	
	public void addMessageBase(BeliefBase b) {
		ownModel.addMessageBase(b);
	}
	
	public void addGB(ConjGoalBase g) {
		ownModel.addGB(g);
	}
	
	public void addRB(RuleBase r) {
		ownModel.addRB(r);
	}
	
	public boolean adopt(ConjGoal g) {
		if (! g.getAsGuard().logicalConsequence(ownModel, new Unifier(), g.getVarNames(), AILAgent.SelectionOrder.LINEAR).hasNext()) {
			ownModel.adopt(g);
			return true; // FIXME: migth want further checks
		}
		return false;
	}

	public void focus(ConjGoalBase newAttentionSet) {
		ownModel.focus(newAttentionSet);
	}

	public MentalModel getOwnModel() {
		return ownModel;
	}

	public List<Goal> getGoals() {
		return ownModel.getGoals();
	}

	public void defocus() {
		ownModel.defocus();
	}
	
	/**
     * Returns the names of the other agents for which this {@link MentalState}
     * maintains {@link MentalModel}s.
     *
     * @return The names of other agents whose mental state are modeled in this
     *         mental state.
     */
    public Set<String> getKnownAgents() {
            return this.knownAgents;
    }
    
    /**
     * Adds a {@link MentalModel} for a (new) agent. Also used to create a
     * mental model for the owner of this {@link MentalState}.
     *
     * CHECK that this method is thread safe. The agent may be running when this
     * is called!
     *
     * @param id
     *            The agent for which a mental model should be created.
     * @param debugger
     *            debugger to report on associated belief update. <b>Note:</b>
     *            As during initialization the debugger needs to be different
     *            (in order to avoid halting on this action) than during agent
     *            execution (when the agent's debugger should be used), debugger
     *            is a parameter of the method.
     * @throws KRInitFailedException
     *             If the KR technology failed to create the requested
     *             databases.
     * @throws KRQueryFailedException
     * @throws KRDatabaseException
     * @throws UnknownObjectException
     */
    public synchronized void addAgentModel(String id) {
            // true if its me, the owner of this mental state.
            // boolean me = id.equals(this.agentId);

            // if (me || this.usesMentalModeling) {
                    /**
                     * DO NOT CHANGE THE ORDER OF CREATION OF DATABASES BELOW! The
                     * {@link KnowledgeBase} of an agent must be created before any
                     * {@link GoalBase} or {@link BeliefBase} is created. This is
                     * because the latter import the knowledge base. Also, the order of
                     * introducing the mailbox, percept base, and belief base is
                     * important. The belief base may assume that the mailbox and
                     * percept base have already been created.
                     */

                    // TODO: lazy creation of OTHER agents' models.

                    // Add a mental model that can be used to model the (other) agent.
                    // We know
                    // that there is an(other) agent because we have a(n empty) mental
                    // state.
                    MentalModel model = new MentalModel();

                    // Get content for the initial belief and goal base.
                   /* if (me) {
                            // Create the bases from the parsed GOAL agent program.
                            model.addBase(this.agentProgram, this.agentId, this.state,
                                            this.agentProgram.getAllKnowledge(),
                                            BASETYPE.KNOWLEDGEBASE);
                            model.addBase(this.agentProgram, this.agentId, this.state,
                                            new LinkedList<DatabaseFormula>(), BASETYPE.MAILBOX);
                            model.addBase(this.agentProgram, this.agentId, this.state,
                                            new LinkedList<DatabaseFormula>(), BASETYPE.PERCEPTBASE);
                    } */
                    // Create the belief base.
                    model.addBB(new BeliefBase());
                    // Create the goal base.
                    model.addGB(new ConjGoalBase());

                    // Add the mental model to the map of mental models maintained by
                    // this
                    // mental state.
                    this.models.put(id, model);
            //}

            // Insert the agent's existence as a fact 'agent(name)' in the belief
            // base.
            //getOwnBase(BASETYPE.BELIEFBASE).updateAgentFact(true, id, me);
            this.knownAgents.add(id);
    }


	
    /**
     * Returns a {@link BeliefBase} that is of a particular {@link BASETYPE}.
     * <p>
     * Can ask for {@link BASETYPE#KNOWLEDGEBASE}, {@link BASETYPE#BELIEFBASE},
     * {@link BASETYPE#PERCEPTBASE}, {@link BASETYPE#MAILBOX}. Other types are
     * not supported by this method.
     *
     * @param type
     *            The type of belief base.
     * @return A belief base of a particular type.
     */
    public BeliefBase getOwnBase(BASETYPE type) throws AILexception {
            if (type.equals(BASETYPE.GOALBASE)) {
                    throw new AILexception(
                                    "A goal base should not be accessed via method getBase() from the class "
                                                    + getClass());
            }
            return getOwnModel().getBase(type);
    }

    
    public boolean insert(Literal p, BASETYPE b, String agentId) {
    	return this.models.get(agentId).getBase(b).add(p);
    }
    
    public boolean delete(Literal l, BASETYPE b, String name) {
    	return this.models.get(name).getBase(b).remove(l);
    }
    
    public boolean adopt(Predicate p, boolean focus, String name) {
    	ConjGoal cg = new ConjGoal();
    	cg.addConj(p);
    	if (this.models.get(name).getAttentionSet(focus).getAllConjGoals().contains(cg)) {
    		return false;
    	}
    	this.models.get(name).getAttentionSet(focus).add(cg);
    	return true;
    }
    
    public String toString() {
    	String str = new String("");
    	for (String s: models.keySet()) {
    		str += s + " mental model:\n";
    		str += models.get(s).toString();
    	}
    	return str;
    }

    public void setAgName(String name) {
    	models.remove(this.agentId);
		this.agentId = name;
		models.put(this.agentId, ownModel);
    }

	
}
