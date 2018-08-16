package juno.semantics;

import ail.semantics.AILAgent;
import ail.semantics.RCStage;
import ail.semantics.ReasoningCycle;
import ail.semantics.operationalrules.DirectPerception;
import ail.semantics.operationalrules.GenerateApplicablePlans;
import gov.nasa.jpf.annotation.FilterField;
import juno.semantics.operationalrules.HandleHeraAction;
import juno.semantics.operationalrules.ReasonAboutActions;
import juno.semantics.operationalrules.UpdateBackground;
import juno.semantics.operationalrules.UpdateUtilities;

public class JunoRC implements ReasoningCycle {
	private JunoRCStage currentstage;
	
	private JunoRCStage Perception = new JunoRCStage(0, "Perception");
	private JunoRCStage UpdateModelUtilities = new JunoRCStage(1, "UpdateModelU");
	private JunoRCStage UpdateModelBackground = new JunoRCStage(2, "UpdateModelB");
	private JunoRCStage EthicalReasoning = new JunoRCStage(3, "EthicalReasoning");
	private JunoRCStage Act = new JunoRCStage(4, "Act");

	@FilterField
	private boolean stopandcheck = false;

	public JunoRC() {
		currentstage = Perception;
		
		// Create Rules
		DirectPerception rule1 = new DirectPerception();
		Perception.setRule(rule1);
		
		UpdateUtilities rule2 = new UpdateUtilities();
		UpdateModelUtilities.setRule(rule2);
		
		UpdateBackground rule3 = new UpdateBackground();
		UpdateModelBackground.setRule(rule3);
		
		ReasonAboutActions rule4 = new ReasonAboutActions();
		EthicalReasoning.setRule(rule4);
		
		HandleHeraAction rule5 = new HandleHeraAction();
		Act.setRule(rule5);
		

	}
	
	@Override
	public void setStopandCheck(boolean b) {
		stopandcheck = b;
	}

	@Override
	public boolean stopandcheck() {
		// TODO Auto-generated method stub
		return stopandcheck;
	}

	@Override
	public void cycle(AILAgent ag) {
		if (currentstage == Perception) {
			currentstage = UpdateModelUtilities;
		} else if (currentstage == UpdateModelUtilities) {
			currentstage = UpdateModelBackground;
		} else if (currentstage == UpdateModelBackground) {
			currentstage = EthicalReasoning;
		} else if (currentstage == EthicalReasoning) {
			currentstage = Act;
		} else {
			setStopandCheck(true);
			currentstage = Perception;
		}
	}

	@Override
	public RCStage getStage() {
		// TODO Auto-generated method stub
		return currentstage;
	}

	@Override
	public void setCurrentStage(RCStage rcs) {
		currentstage = (JunoRCStage) rcs;
	}

	@Override
	public boolean not_interrupted() {
		// TODO Auto-generated method stub
		return true;
	}

}
