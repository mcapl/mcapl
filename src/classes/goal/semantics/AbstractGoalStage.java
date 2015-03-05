package goal.semantics;

import java.util.Iterator;

import ail.semantics.AILAgent;
import ail.semantics.OSRule;

public abstract class AbstractGoalStage implements GOALRCStage {
	@Override
	public abstract String getStageName();

	@Override
	public abstract Iterator<OSRule> getStageRules();

	@Override
	public void setRule(OSRule r) {	}

	
	public String toString() {
		return getStageName();
	}

}
