package goal.semantics.operationalrules;

import goal.semantics.GOALAgent;
import goal.syntax.GOALModule;
import ail.semantics.AILAgent;
import ail.semantics.OSRule;

public abstract class ActionExecutor implements OSRule {
	GOALModule module;

	@Override
	public boolean checkPreconditions(AILAgent a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void apply(AILAgent a) {
		// TODO Auto-generated method stub
		// THis nees to be activated only if first action succeeds
		((GOALAgent) a).actionPerformed(); 
		module.setRule(null);

	}
    public void setModule(GOALModule m) {
    	this.module = m;
    }


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
