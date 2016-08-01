// ----------------------------------------------------------------------------
// Copyright (C) 2014 Louise A. Dennis, Michael Fisher and Alan Winfield
// 
// This file is part of Declarative Ethical Governor (DEG)
// 
// The DEG is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The DEG is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------
package ethical_governor.semantics;

import ail.mas.MAS;
import ail.semantics.AILAgent;
import ail.syntax.Action;
import ail.syntax.Capability;
import ail.syntax.Predicate;
import ail.syntax.Literal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;

/**
 * An Agent that represents an ethical governor.  Or, at least, a thing with an operational semantics.
 * @author louiseadennis
 *
 */
public class EthicalGovernor extends AILAgent {
	// The actions to be selected among.
	ArrayList<Action> applicable_actions = new ArrayList<Action>();
	
	//A list of actions annotated with predicates (representing outcomes).
	ArrayList<AnnotatedAction> annotated_actions = new ArrayList<AnnotatedAction>();
	
	// The agent this is a governor for.
	String governed_agent;
	
	// The action that is selected
	ArrayList<Action> selectedActions;
	
	// A List ordering actors in the order there safety should be prioritised.
	ArrayList<Predicate> ethical_precedence = new ArrayList<Predicate>();
	
	// A Map of outcomes to numeric scores
	HashMap<String, Integer> ethical_scores = new HashMap<String, Integer>();
	
	/**
	 * Constructor.
	 * @param agname
	 */
	public EthicalGovernor(String agname) {
		super(agname);
		setReasoningCycle(new EthicalGovernorRC());
	}
	
	/**
	 * Constructor.
	 * @param mas
	 * @param agname
	 */
	public EthicalGovernor(MAS mas, String agname) {
		super(mas, agname);
		setReasoningCycle(new EthicalGovernorRC());
	}

	/**
	 * This is method that selects some action from a list presented for consideration.  It does this by calling
	 * one turn of the reasoning cycle.
	 * @param ic
	 * @return
	 */
	public ArrayList<Action> govern(Iterator<Capability> ic) {
		clearApplicableActions();
		clearSelectedActions();
		
		while (ic.hasNext()) {
			Action a = new Action(ic.next().getCap(), Action.normalAction);
			applicable_actions.add(a);
			Literal action_belief = new Literal("applicable_action");
			action_belief.addTerm(a);
			addBel(action_belief, AILAgent.refertoself());
		}
		
		reason();
		
		return selectedActions;
		
	}
	
	/**
	 * Re-initialise the applicable actions.
	 */
	public void clearApplicableActions() {
		applicable_actions = new ArrayList<Action>();
	}
	
	/**
	 * Get the actions applicable in this situation.
	 * @return
	 */
	public ArrayList<Action> getApplicableActions() {
		return applicable_actions;
	}
	
	/**
	 * Clear out the selected action.
	 */
	public void clearSelectedActions() {
		selectedActions = null;
	}
	
	/**
	 * Setter for the selected actions.
	 * @param as
	 */
	public void setSelectedActions(ArrayList<Action> as) {
		selectedActions = as;
		for (Action a: as) {
			Literal selected = new Literal("selected");
			selected.addTerm(a);
			addBel(selected, AILAgent.refertoself());
		}
	}
	
	/**
	 * Getter for the agent that is governed.
	 * @return
	 */
	public String getGovernorFor() {
		return governed_agent;
	}
	
	/**
	 * Setter for the agent that is governed.
	 * @param s
	 */
	public void setGoverned(String s) {
		governed_agent = s;
	}
	
	/**
	 * Setter for the Annotated Actions.
	 * @param as
	 */
	public void setAnnotatedActions(ArrayList<AnnotatedAction> as) {
		annotated_actions = as;
		
		
		for (AnnotatedAction a: as) {
			for (Predicate p: a.getAnnotations()) {
				Literal outcome = new Literal("outcome");
				outcome.addTerm(a.getAction());
				outcome.addTerm(p);
				addBel(outcome, AILAgent.refertoself());
				
			}
		}

	}
	
	/**
	 * Getter for the Annotated Actions.
	 * @return
	 */
	public ArrayList<AnnotatedAction> getAnnotatedActions() {
		return annotated_actions;
	}
	
	/**
	 * Getter for the ethical precedence relation.
	 * @return
	 */
	public ArrayList<Predicate> getEthicalPrecedence() {
		return ethical_precedence;
	}
	
	/**
	 * Add a new precendecen to the end of the list;
	 * @param p
	 */
	public void addPrec(Predicate p) {
		ethical_precedence.add(p);
	}
	
	/**
	 * Scoring of ethical outcomes;
	 * @param outcome
	 * @return
	 */
	public int score(String outcome, Predicate actor) {
		return ethical_scores.get(outcome);
	}
	
	/**
	 * Setting the score for some outcome.
	 * @param outcome
	 * @param score
	 */
	public void setScore(String outcome, int score) {
		ethical_scores.put(outcome, score);
	}

}
