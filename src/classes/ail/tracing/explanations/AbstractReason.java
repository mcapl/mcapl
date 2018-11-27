package ail.tracing.explanations;

import java.util.ArrayList;

import org.apache.commons.text.StringEscapeUtils;

import ail.tracing.events.AbstractEvent;

public abstract class AbstractReason {
	protected final int state;

	protected AbstractReason(final int state) {
		this.state = state;
	}

	public abstract AbstractEvent getEvent();

	public abstract AbstractReason getParent();

	public abstract String getExplanation(ExplanationLevel level, PredicateDescriptions descriptions);

	@Override
	public final String toString() {
		return getExplanation(ExplanationLevel.FINEST, new PredicateDescriptions(new ArrayList<>(0)));
	}

	protected static String inCourier(final Object string) {
		return "<font face=\"Courier New\">" + StringEscapeUtils.escapeHtml4(string.toString()) + "</font>";
	}
}
