package goal.semantics.executorStages;

import java.util.Iterator;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.ArrayList;


import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import ail.syntax.Message;
import ail.syntax.Predicate;
import goal.semantics.AbstractGoalStage;
import goal.semantics.GOALRC;
import goal.semantics.GOALRCStage;
import goal.semantics.operationalrules.ProcessMessages;
import goal.semantics.operationalrules.ProcessPercepts;
import goal.semantics.operationalrules.GOALSleepRule;

public class startCycleStage extends AbstractGoalStage {
    private Set<Predicate> previousPercepts = new LinkedHashSet<>();
    private Set<Message> previousMessages = new LinkedHashSet<>();

	
	GOALSleepRule sleep = new GOALSleepRule(this);
	ProcessMessages messages = new ProcessMessages();
	ProcessPercepts percepts = new ProcessPercepts();
	
	OSRule atstart = percepts;

	@Override
	public void advance(AILAgent ag) {
		if (atstart instanceof ProcessPercepts) {
			atstart = sleep;
		} else if (atstart instanceof ProcessMessages) {
			atstart = percepts;
		} else if (atstart instanceof GOALSleepRule) {
			atstart = sleep;
		}
	}

	@Override
	public GOALRCStage getNextStage(GOALRC rc) {
		if (atstart instanceof ProcessPercepts) {
			if (rc.initModule != null) {
				return rc.initModule;
			} else if (rc.eventModule != null) {
				return rc.eventModule;
			}
			return rc.mainModule;
		} else {
		// TODO Auto-generated method stub
			return this;
		}
	}

	@Override
	public String getStageName() {
		// TODO Auto-generated method stub
		return "startCycle";
	}

	@Override
	public Iterator<OSRule> getStageRules() {
		// TODO Auto-generated method stub
		ArrayList<OSRule> rules = new ArrayList<OSRule>();
		rules.add(atstart);
		return rules.iterator();
	}

}
