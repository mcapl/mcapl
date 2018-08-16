package juno.semantics.operationalrules;

import java.util.ArrayList;
import java.util.HashMap;

import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import ail.syntax.Literal;
import hera.language.Formula;
import hera.language.FormulaString;
import hera.semantics.CausalModel;
import hera.semantics.Model;
import juno.semantics.JunoAgent;
import juno.semantics.JunoCausalModel;

public class ReasonAboutActions implements OSRule {

	@Override
	public boolean checkPreconditions(AILAgent a) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void apply(AILAgent a) {
		// TODO Auto-generated method stub
		ArrayList<HashMap<Formula, Boolean>> worlds = new ArrayList<HashMap<Formula, Boolean>>();
		JunoAgent juno = (JunoAgent) a;
		for (String action: juno.getHeraActions()) {
			HashMap<Formula, Boolean> world = new HashMap<Formula, Boolean>();
			world.put(new FormulaString(action), true);
			for (String action2 : juno.getHeraActions()) {
				if (!action2.equals(action)) {
					world.put(new FormulaString(action2), false);
				}
			}
			worlds.add(world);
		}
		
		ArrayList<Model> models = new ArrayList<Model>();
		for (HashMap<Formula, Boolean> world: worlds) {
			for (Literal bel: juno.getBB().getAll()) {
				world.put(new FormulaString(bel.toString()), true);
			}
			JunoCausalModel model = new JunoCausalModel(juno, world);
			models.add(model);
		}
		
		ArrayList<FormulaString> actions = new ArrayList<FormulaString>();
		for (Model model: models) {
			model.setAlternatives(models);
			
			
			Boolean b = ((CausalModel) model).evaluate(juno.getEthicalPrinciple());
			if (b != null && b) {
				actions.add(((CausalModel) model).getAction());
			}
		}
		
		if (actions.isEmpty()) {
			juno.setAction(null);
		} else {
			juno.setAction(actions.get(0));
		}
		

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
