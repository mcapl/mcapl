package juno.semantics;

import ail.semantics.AILAgent;
import ail.semantics.RCStage;
import ail.semantics.ReasoningCycle;
import ail.semantics.operationalrules.DirectPerception;
import juno.semantics.operationalrules.UpdateUtilities;

public class JunoRC implements ReasoningCycle {
	private JunoRCStage currentstage;
	
	private JunoRCStage Perception = new JunoRCStage(0, "Perception");
	private JunoRCStage UpdateModel = new JunoRCStage(1, "UpdateModel");
	private JunoRCStage EthicalReasoning = new JunoRCStage(2, "EthicalReasoning");
	private JunoRCStage Act = new JunoRCStage(3, "Act");

	public JunoRC() {
		currentstage = Perception;
		
		// Create Rules
		DirectPerception rule1 = new DirectPerception();
		Perception.setRule(rule1);
		
		UpdateUtilities rule2 = new UpdateUtilities();
		UpdateModel.setRule(rule2);

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
