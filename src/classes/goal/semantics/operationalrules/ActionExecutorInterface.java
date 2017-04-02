package goal.semantics.operationalrules;

import goal.syntax.GOALModule;
import ail.semantics.OSRule;

public interface ActionExecutorInterface extends OSRule {
	public void setModule(GOALModule m);

}
