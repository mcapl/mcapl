// ----------------------------------------------------------------------------
// Copyright (C) 2018 Louise A. Dennis, Felix Lindner, Martin Moze Bentzen, Michael Fisher
//
// This file is part of Juno
//
// Juno is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Juno is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------
package juno.semantics.operationalrules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import ail.syntax.Literal;
import hera.language.Formula;
import hera.language.FormulaString;
import hera.principles.DoubleEffectPrinciple;
import hera.principles.KantianHumanityPrincipleReading1;
import hera.principles.Principle;
import hera.principles.UtilitarianPrinciple;
import hera.semantics.CausalModel;
import hera.semantics.Model;
import juno.semantics.JunoAgent;
import juno.semantics.JunoCausalModel;

/**
 * Transition in which a Juno Agents uses Hera to reason about available actions and then selects one.
 * @author louisedennis
 *
 */
public class ReasonAboutActions implements OSRule {
	private static final String name = "Ethical Reasoning";
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.OSRule#checkPreconditions(ail.semantics.AILAgent)
	 */
	@Override
	public boolean checkPreconditions(AILAgent a) {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.OSRule#apply(ail.semantics.AILAgent)
	 */
	@Override
	public void apply(AILAgent a) {
		JunoAgent juno = (JunoAgent) a;
		//System.err.println("Calling Hera Actions");
		List<FormulaString> actions = filterActions(juno.getHeraActions(), juno, juno.ethical_system);
		// System.err.println("Got Hera Actions");
		
		if (actions.isEmpty()) {
			// If there are no options refrain (i.e., do nothing)
			// Not sure this is quite right since doing nothing may
			// have been deemed impermissible.
			juno.setAction(new FormulaString("refrain"));
		} else {
			// If we have more than one choice and are not reasoning using utilitarianism, then
			// further refine selection using utilitarian reasoning.
			// See discussion in Verifying Ethical Reasoning in Changing Contexts paper.
			if (actions.size() > 1 && juno.ethical_system != JunoAgent.UTILITARIAN) {
				ArrayList<String> action_strings = new ArrayList<String>();
				for (FormulaString action:actions) {
					action_strings.add(action.getString());
				}
				action_strings.add("refrain");
				actions = filterActions(action_strings, juno, JunoAgent.UTILITARIAN);
			}
			if (actions.isEmpty()) {
				juno.setAction(new FormulaString("refrain"));
			} else {
				juno.setAction(actions.get(0));
			}
		}
		// System.err.println("Actions Chosen");
		

	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.OSRule#getName()
	 */
	@Override
	public String getName() {
		return name;
	}
	
	/**
	 * Filter actions creates a world for each action under consideration and then reasons
	 * about that world using Hera in order to decide if it is permissible.
	 * 
	 * @param actions_in
	 * @param juno
	 * @param ethical_system
	 * @return
	 */
	private ArrayList<FormulaString> filterActions(ArrayList<String> actions_in, JunoAgent juno, int ethical_system) {
		ArrayList<HashMap<Formula, Boolean>> worlds = new ArrayList<HashMap<Formula, Boolean>>();
		for (String action: actions_in) {
			HashMap<Formula, Boolean> world = new HashMap<Formula, Boolean>();
			world.put(new FormulaString(action), true);
			for (String action2 : actions_in) {
				if (!action2.equals(action)) {
					world.put(new FormulaString(action2), false);
				}
			}
			worlds.add(world);
		}

		ArrayList<Model> models = new ArrayList<Model>();
		for (HashMap<Formula, Boolean> world: worlds) {
			for (Literal bel: juno.getBB().getAll()) {
				world.put(new FormulaString(bel.getFunctor().toString()), true);
			}
			JunoCausalModel model = new JunoCausalModel(juno, world);
			models.add(model);
		}

		ArrayList<FormulaString> actions = new ArrayList<FormulaString>();
		for (Model model: models) {
			model.setAlternatives(models);
			// System.err.println("Calling Evaluate");
			int b = ((CausalModel) model).evaluate(getPrinciple(ethical_system));
			// System.err.println("Evaluate Returned");
			if (b == Principle.PERMISSIBLE) {
				actions.add(((CausalModel) model).getAction());
			}
			
		}

		//System.err.println("Available Actions:");
		//System.err.println(actions);
		return actions;
	}
	
	/**
	 * Return the current ethical system being used by the agent.
	 * @param ethical_system
	 * @return
	 */
	private Principle getPrinciple(int ethical_system) {
		if (ethical_system == JunoAgent.UTILITARIAN) {
			return new UtilitarianPrinciple();
		} else if (ethical_system == JunoAgent.KANTIAN) {
			return new KantianHumanityPrincipleReading1();
		} else {
			return new DoubleEffectPrinciple();
		}
	}

}
