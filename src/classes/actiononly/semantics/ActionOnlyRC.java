package actiononly.semantics;

import actiononly.semantics.operationalrules.SelectAction;

import ail.semantics.AILAgent;
import ail.semantics.RCStage;
import ail.semantics.ReasoningCycle;
import ail.semantics.operationalrules.Perceive;
import ail.semantics.operationalrules.GenerateApplicableCapabilities;
import ail.semantics.operationalrules.HandleGeneralAction;

import java.util.LinkedList;

/**
 * A reasoning cycle for agents which consist essentially of a set of actions with preconditions and some
 * external selection function (or possibly internal selection function) TBD.
 * @author lad
 *
 */
public class ActionOnlyRC implements ReasoningCycle {
	
	Perceive perceive = new Perceive();
	GenerateApplicableCapabilities rule1 = new GenerateApplicableCapabilities();
	SelectAction rule2 = new SelectAction();
	HandleGeneralAction rule3 = new HandleGeneralAction(new LinkedList<Integer>());
	
	private RCStage generate_actions = new ActionOnlyStage(1, "Stage 1");
	private RCStage select_action = new ActionOnlyStage(2, "Stage 2");
	private RCStage execute_action = new ActionOnlyStage(3, "Stage 3");
	private RCStage perception = new ActionOnlyStage(4, "Stage 4");
	
	private RCStage currentstage = perception;
	
	private boolean stopandcheck = false;
	
	/**
	 * Constructor.  Assign rules to stages.
	 */
	public ActionOnlyRC() {
		generate_actions.setRule(rule1);
		select_action.setRule(rule2);
		execute_action.setRule(rule3);
		perception.setRule(perceive);
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.ReasoningCycle#setStopandCheck(boolean)
	 */
	public void setStopandCheck(boolean b) {
		stopandcheck = b;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.ReasoningCycle#stopandcheck()
	 */
	public boolean stopandcheck() {
		return stopandcheck;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.ReasoningCycle#cycle(ail.semantics.AILAgent)
	 */
	public void cycle(AILAgent ag) {
		if (currentstage == perception) {
			currentstage = generate_actions;
		} else if (currentstage == generate_actions) {
			currentstage = select_action;
		} else if (currentstage == select_action) {
			currentstage = execute_action;
		} else {
			currentstage = perception;
			setStopandCheck(true);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.ReasoningCycle#getStage()
	 */
	public RCStage getStage() {
		return currentstage;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.ReasoningCycle#setCurrentStage(ail.semantics.RCStage)
	 */
	public void setCurrentStage(RCStage rcs) {
		currentstage = rcs;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.ReasoningCycle#not_interrupted()
	 */
	public boolean not_interrupted() {
		return false;
	}

}
