package goal.semantics.operationalrules;

import goal.semantics.executorStages.startCycleStage;
import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import ail.syntax.Predicate;
import goal.semantics.GOALAgent;
import java.util.Set;

public class ProcessPercepts implements OSRule {

	private startCycleStage scs;
	
	public ProcessPercepts(startCycleStage scs) {
		this.scs = scs;
	}

	@Override
	public boolean checkPreconditions(AILAgent a) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void apply(AILAgent a) {
		Set<Predicate> percepts = scs.getPercepts();
		// TODO Auto-generated method stub
		GOALAgent gag = (GOALAgent) a;
		gag.getMentalState().removePercepts();
		gag.getMentalState().addPercepts(percepts);
		// We don't update the goal state because this will be done by process messages 
		// which is executed next....
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
