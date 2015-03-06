package goal.semantics.operationalrules;

import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import goal.semantics.executorStages.ModuleExecutorStage;
import goal.syntax.GOALModule;
import goal.semantics.GOALAgent;

public class ModuleExit implements OSRule {
	ModuleExecutorStage mes;
	
	public ModuleExit(ModuleExecutorStage mes) {
		this.mes = mes;
	}

	@Override
	public boolean checkPreconditions(AILAgent a) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void apply(AILAgent a) {
		// TODO Auto-generated method stub
		if (mes.getModule().getType() == GOALModule.ModuleType.ANONYMOUS) {
			return;
		}
		
		switch(mes.getModule().getType()) {
		case EVENT:
		case INIT:
			((GOALAgent) a).setTopLevelContext(GOALModule.ModuleType.MAIN);
			break;
		default:
			break;
		}
		// a.activeStackOfModule.pop();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
