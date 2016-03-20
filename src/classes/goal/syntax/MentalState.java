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

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MentalState {
	MentalModel ownModel = new MentalModel();
	
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
	
	public void addMessage(Message m){
		
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
	
	public void adopt(ConjGoal g) {
		if (! g.getAsGuard().logicalConsequence(ownModel, new Unifier(), g.getVarNames(), AILAgent.SelectionOrder.LINEAR).hasNext()) {
			ownModel.adopt(g);
		}
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



	
}
