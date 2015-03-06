package goal.semantics.operationalrules;

import ail.semantics.AILAgent;
import ail.semantics.OSRule;

import goal.semantics.executorStages.ModuleExecutorStage;

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
