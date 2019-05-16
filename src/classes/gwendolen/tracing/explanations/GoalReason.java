package gwendolen.tracing.explanations;

import ail.syntax.Predicate;
import ail.tracing.events.AbstractEvent;
import ail.tracing.explanations.AbstractGoalReason;
import ail.tracing.explanations.AbstractReason;
import ail.tracing.explanations.ExplanationLevel;
import ail.tracing.explanations.PredicateDescriptions;

public class GoalReason extends AbstractGoalReason {
	AbstractReason parent;
	Predicate goal;
	int index;
	
	public GoalReason(Predicate b, int state) {
		super(state);
		goal = b;
	}

	@Override
	public AbstractEvent getEvent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractReason getParent() {
		// TODO Auto-generated method stub
		return parent;
	}
	
	public void setParent(AbstractReason r) {
		parent = r;
	}

	@Override
	public String getExplanation(ExplanationLevel level, PredicateDescriptions descriptions) {
		final StringBuilder string = new StringBuilder();
		string.append(goal.toString(descriptions)).append(" was a goal in state ").append(state).append(" because ");
		string.append(getParent().getExplanation(level, descriptions));
		return string.toString();
	}

}
