package actiononly.semantics;

import ail.semantics.AILAgent;
import ail.semantics.RCStage;
import ail.semantics.ReasoningCycle;
import ail.semantics.operationalrules.Perceive;

public class ActionOnlyRC implements ReasoningCycle {
	
	Perceive perceive = new Perceive();
	GenerateApplicableCapabilities rule1 = new GenerateApplicableCapabilities();
	SelectAction rule2 = new SelectAction();
	ExecuteAction rule3 = new ExecuteAction();
	
	private RCStage generate_actions = new ActionOnlyStage(?);
	private RCStage select_action = new ActionOnlyStage(?);
	private RCStage execute_action = new ActionOnlyStage(?);
	
	public ActionOnlyRC() {
		generate_actions.setRule(rule1);
		select_action.setRule(rule2);
		execute_action.setRule(rule3);
	}

	@Override
	public void setStopandCheck(boolean b) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean stopandcheck() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void cycle(AILAgent ag) {
		// TODO Auto-generated method stub

	}

	@Override
	public RCStage getStage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCurrentStage(RCStage rcs) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean not_interrupted() {
		// TODO Auto-generated method stub
		return false;
	}

}
