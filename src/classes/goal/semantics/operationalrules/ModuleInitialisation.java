package goal.semantics.operationalrules;

import java.util.Iterator;

import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import goal.semantics.executorStages.ModuleExecutorStage;
import goal.syntax.GOALModule;
import goal.semantics.GOALAgent;
import ail.syntax.BeliefBase;
import ail.syntax.Capability;
import ail.syntax.Goal;
import ail.syntax.Literal;

public class ModuleInitialisation implements OSRule {
	ModuleExecutorStage mes;
	
	public ModuleInitialisation(ModuleExecutorStage mes) {
		this.mes = mes;
	}

	@Override
	public boolean checkPreconditions(AILAgent a) {
		// TODO Auto-generated method stub
		return mes.first();
	}

	@Override
	public void apply(AILAgent a) {
		GOALModule m = mes.getModule();
		((GOALAgent) a).enteredModule(m);
		for (Literal l: m.getBB().getAll()) {
			a.addBel(l, BeliefBase.TSelf);
		}
		
		for (Goal g: m.getGB().getAll()) {
			((GOALAgent) a).adopt(g);
		}
		
		if (mes.getModule().getType() == GOALModule.ModuleType.INIT) {
			Iterator<Capability> initcaps = m.getCL().iterator();
			while (initcaps.hasNext()) {
				a.addCap(initcaps.next());
			}
		}
		// TODO Auto-generated method stub
		// Add module beliefs to agent
		// Adopt modules goals 
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Module Initialisation";
	}

}
