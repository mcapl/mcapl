package goal.semantics.operationalrules;

import goal.semantics.GOALAgent;
import goal.syntax.GOALModule;
import ail.semantics.AILAgent;
import ail.semantics.OSRule;

public abstract class ActionExecutor implements ActionExecutorInterface {
	GOALModule module;

	@Override
	public boolean checkPreconditions(AILAgent a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void apply(AILAgent a) {
		// TODO Auto-generated method stub
		// THis needs to be activated only if first action succeeds
		((GOALAgent) a).actionPerformed(); 
		module.clearRuleItIfNotApplyAll();

	}
	
    public void setModule(GOALModule m) {
    	this.module = m;
    }


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Action Executor";
	}

}
