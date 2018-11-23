package ail.tracing.events;

import java.util.ArrayList;
import java.util.List;

import ail.semantics.AILAgent;
import ail.syntax.Action;

public class ActionEvent extends AbstractEvent {
	private final Action action;

	public ActionEvent(final Action action) {
		this.action = action;
	}
	
	public Action getAction() {
		return this.action;
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
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("performed ").append(action).append(".");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return this.action.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null || !(obj instanceof ActionEvent)) {
			return false;
		}
		ActionEvent other = (ActionEvent) obj;
		return (this.action == other.action);
	}
}
