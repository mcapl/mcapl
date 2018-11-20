package ail.tracing.explanations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import ail.syntax.Action;
import ail.syntax.ApplicablePlan;
import ail.syntax.Intention;
import ail.syntax.Predicate;
import ail.tracing.events.AbstractEvent;
import ail.tracing.events.ActionEvent;
import ail.tracing.events.CreateIntentionEvent;
import ail.tracing.events.GeneratePlansEvent;
import ail.tracing.events.GuardEvent;
import ail.tracing.events.ModificationAction;
import ail.tracing.events.ModificationEvent;
import ail.tracing.events.SelectIntentionEvent;
import ail.tracing.events.SelectPlanEvent;

/**
 * Supports generating explanations ({@link AbstractReason}s) from an agent trace based
 * on the 'Debugging is Explaining' paper (Hindriks 2012).
 */
public class WhyQuestions {
	private final List<AbstractEvent> trace;
	private Set<Predicate> beliefs;
	private Set<Predicate> goals;
	private Set<Action> actions;

	public WhyQuestions(final List<AbstractEvent> trace) {
		this.trace = trace;
	}

	/**
	 * Call this to update the info returned by {@link #getAllActions()},
	 * {@link #getAllBeliefs()}, and {@link #getAllGoals()}.
	 */
	public void process() {
		this.beliefs = new LinkedHashSet<>();
		this.goals = new LinkedHashSet<>();
		this.actions = new LinkedHashSet<>();
		for (final AbstractEvent event : this.trace) {
			if (event instanceof ModificationEvent) {
				final ModificationAction modification = ((ModificationEvent) event).getUpdate();
				switch (modification.getBase()) {
				case BELIEFS:
					this.beliefs.addAll(modification.getAdded());
					this.beliefs.addAll(modification.getRemoved());
					break;
				case GOALS:
					this.goals.addAll(modification.getAdded());
					this.goals.addAll(modification.getRemoved());
					break;
				default:
					break;
				}
			} else if (event instanceof ActionEvent) {
				final Action executed = ((ActionEvent) event).getAction();
				if (executed != null) {
					this.actions.add(executed);
				}
			}
		}
	}

	/**
	 * @return All beliefs (instantiated or not) that can be found in the trace,
	 *         either queried or actually believed at some point. Call
	 *         {@link #process()} first to update the returned beliefs.
	 */
	public Set<Predicate> getAllBeliefs() {
		return Collections.unmodifiableSet(this.beliefs);
	}

	/**
	 * @return All goals (instantiated or not) that can be found in the trace,
	 *         either queried or actually to be achieved at some point. Call
	 *         {@link #process()} first to update the returned goals.
	 */
	public Set<Predicate> getAllGoals() {
		return Collections.unmodifiableSet(this.goals);
	}

	/**
	 * @return All actions (instantiated or not) that can be found in the trace,
	 *         either tried or actually executed at some point. Call
	 *         {@link #process()} first to update the returned actions.
	 */
	public Set<Action> getAllActions() {
		return Collections.unmodifiableSet(this.actions);
	}

	/**
	 * @param action An action from which we want to know why it was excuted.
	 * @return One or more {@link ActionReason}s (if the action was actually
	 *         executed) explaining why this action was executed (each entry
	 *         corresponds to one successful execution).
	 */
	public List<AbstractReason> whyAction(final Action action) {
		final Stack<ActionReason> stack = new Stack<>();
		for (int i = (this.trace.size() - 1); i >= 0; --i) {
			final AbstractEvent event = this.trace.get(i);
			if (event instanceof ActionEvent) {
				// match the requested action
				final ActionEvent ae = (ActionEvent) event;
				if (action.equals(ae.getAction())) {
					stack.push(new ActionReason(i, ae));
				}
			} else if (event instanceof SelectPlanEvent && !stack.empty()) {
				// an action follows directly from a plan selection
				final ActionReason current = stack.peek();
				if (current.getParent() == null) {
					final SelectPlanEvent spe = (SelectPlanEvent) event;
					final SelectPlanReason spr = new SelectPlanReason(i, spe);
					current.setParent(spr);
				}
			} else if (event instanceof GeneratePlansEvent) {
				// a plan selection follows from the plan being generated at some point
				final GeneratePlansEvent gpe = (GeneratePlansEvent) event;
				final List<Integer> planIDs = gpe.getPlanIDs();
				for (final ActionReason current : stack) {
					final SelectPlanReason spr = current.getParent();
					if (spr != null && spr.getParent() == null && planIDs.contains(spr.getEvent().getPlan().getID())) {
						final GeneratePlansReason gpr = new GeneratePlansReason(i, gpe);
						spr.setParent(gpr);
					}
				}
			} else if (event instanceof GuardEvent) {
				// a plan is only generated if its guard was evaluated at some point
				final GuardEvent ge = (GuardEvent) event;
				final ApplicablePlan plan = ge.getPlan();
				for (final ActionReason current : stack) {
					final SelectPlanReason spr = current.getParent();
					if (spr != null && plan.getID() == spr.getEvent().getPlan().getID()) {
						final GeneratePlansReason gpr = spr.getParent();
						if (gpr != null && gpr.getParent() == null) {
							final GuardReason gr = new GuardReason(i, ge);
							gpr.setParent(gr);
						}
					}
				}
			} else if (event instanceof SelectIntentionEvent) {
				// a guard is evaluated because of some intention selection event
				final SelectIntentionEvent sie = (SelectIntentionEvent) event;
				final Intention intention = sie.getIntention();
				for (final ActionReason current : stack) {
					final SelectPlanReason spr = current.getParent();
					if (spr != null) {
						final GeneratePlansReason gpr = spr.getParent();
						if (gpr != null) {
							final GuardReason gr = gpr.getParent();
							if (gr != null && gr.getParent() == null
									&& intention.getID() == gr.getEvent().getIntention().getID()) {
								final SelectIntentionReason sir = new SelectIntentionReason(i, sie);
								gr.setParent(sir);
							}
						}
					}
				}
			} else if (event instanceof CreateIntentionEvent) {
				// an intention can only be selected if it was created for an event sometime
				final CreateIntentionEvent cie = (CreateIntentionEvent) event;
				final Intention intention = cie.getIntention();
				for (final ActionReason current : stack) {
					final SelectPlanReason spr = current.getParent();
					if (spr != null) {
						final GeneratePlansReason gpr = spr.getParent();
						if (gpr != null) {
							final GuardReason gr = gpr.getParent();
							if (gr != null && intention.getID() == gr.getEvent().getIntention().getID()) {
								final SelectIntentionReason sir = gr.getParent();
								if (sir != null && sir.getParent() == null) {
									final CreateIntentionReason cir = new CreateIntentionReason(i, cie);
									sir.setParent(cir);
								}
							}
						}
					}
				}
			}
		}
		return new ArrayList<>(stack);
	}
}