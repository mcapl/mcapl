package juno.semantics.operationalrules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import ail.syntax.Literal;
import ajpf.util.VerifyList;
import ajpf.util.VerifyMap;
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

public class ReasonAboutActions implements OSRule {
	private static final String name = "Ethical Reasoning";
	
	@Override
	public boolean checkPreconditions(AILAgent a) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void apply(AILAgent a) {
		// TODO Auto-generated method stub
		JunoAgent juno = (JunoAgent) a;
		List<FormulaString> actions = filterActions(juno.getHeraActions(), juno, juno.ethical_system);
		
		if (actions.isEmpty()) {
			juno.setAction(null);
		} else {
			if (actions.size() > 1 && juno.ethical_system != JunoAgent.UTILITARIAN) {
				VerifyList<String> action_strings = new VerifyList<String>();
				for (FormulaString action:actions) {
					action_strings.add(action.getString());
				}
				action_strings.add("refrain");
				actions = filterActions(action_strings, juno, JunoAgent.UTILITARIAN);
			}
			if (actions.isEmpty()) {
				juno.setAction(null);
			} else {
				juno.setAction(actions.get(0));
			}
		}
		

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	private ArrayList<FormulaString> filterActions(VerifyList<String> actions_in, JunoAgent juno, int ethical_system) {
		ArrayList<VerifyMap<Formula, Boolean>> worlds = new ArrayList<VerifyMap<Formula, Boolean>>();
		for (String action: actions_in) {
			VerifyMap<Formula, Boolean> world = new VerifyMap<Formula, Boolean>();
			world.put(new FormulaString(action), true);
			for (String action2 : actions_in) {
				if (!action2.equals(action)) {
					world.put(new FormulaString(action2), false);
				}
			}
			worlds.add(world);
		}
		
		ArrayList<Model> models = new ArrayList<Model>();
		for (VerifyMap<Formula, Boolean> world: worlds) {
			for (Literal bel: juno.getBB().getAll()) {
				world.put(new FormulaString(bel.getFunctor().toString()), true);
			}
			JunoCausalModel model = new JunoCausalModel(juno, world);
			models.add(model);
		}
		
		ArrayList<FormulaString> actions = new ArrayList<FormulaString>();
		for (Model model: models) {
			model.setAlternatives(models);
			
			Boolean b = ((CausalModel) model).evaluate(getPrinciple(ethical_system));
			if (b != null && b) {
				actions.add(((CausalModel) model).getAction());
			}
			
		}
		
		return actions;
	}
	
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
