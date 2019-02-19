package ail.tracing.events;

import java.util.ArrayList;
import java.util.List;

import ail.semantics.AILAgent;
import ail.syntax.Action;
import ail.tracing.explanations.PredicateDescriptions;

/**
 * An {@link Action} has been executed.
 */
public class ActionEvent extends AbstractEvent {
	private final Action action;
	private final int intentionID;

	public ActionEvent(final Action action, final int IntentionID) {
		this.action = action;
		this.intentionID = IntentionID;
	}

	public Action getAction() {
		return this.action;
	}
	
	public int getIID() {
		return this.intentionID;
	}

	@Override
	public List<String> getLookupData() {
		final List<String> result = new ArrayList<>(1);
		result.add(action.getPredicateIndicator().toString());
		return result;
	}

	@Override
	public void execute(final AILAgent agent, final boolean reverse) {
	}

	@Override
	public String toString(final PredicateDescriptions descriptions) {
		final StringBuilder builder = new StringBuilder();
		builder.append("performed ").append(action.toString(descriptions)).append(".");
		return builder.toString();
	}
}
