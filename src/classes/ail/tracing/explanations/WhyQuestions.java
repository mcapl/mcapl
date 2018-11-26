package ail.tracing.explanations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import ail.syntax.Action;
import ail.syntax.Predicate;
import ail.tracing.EventStorage;
import ail.tracing.events.AbstractEvent;
import ail.tracing.events.ActionEvent;
import ail.tracing.events.CreateIntentionEvent;
import ail.tracing.events.GeneratePlansEvent;
import ail.tracing.events.GuardEvent;
import ail.tracing.events.ModificationAction;
import ail.tracing.events.ModificationBase;
import ail.tracing.events.ModificationEvent;
import ail.tracing.events.ModifyIntentionEvent;
import ail.tracing.events.SelectIntentionEvent;
import ail.tracing.events.SelectPlanEvent;

/**
 * Supports generating explanations ({@link AbstractReason}s) from an agent
 * trace based on the 'Debugging is Explaining' paper (Hindriks 2012).
 */
public class WhyQuestions {
	private final EventStorage storage;
	private Set<Predicate> beliefs;
	private Set<Predicate> goals;
	private Set<Action> actions;

	public WhyQuestions(final EventStorage storage) {
		this.storage = storage;
	}

	public PredicateDescriptions getDescriptions() {
		return this.storage.getDescriptions();
	}

	/**
	 * Call this to update the info returned by {@link #getAllActions()},
	 * {@link #getAllBeliefs()}, and {@link #getAllGoals()}.
	 */
	public void process() {
		this.beliefs = new LinkedHashSet<>();
		this.goals = new LinkedHashSet<>();
		this.actions = new LinkedHashSet<>();
		for (final AbstractEvent event : this.storage.getAll()) {
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

	// TODO: we are missing the new intention modification events here now

	/**
	 * @param action An action from which we want to know why it was excuted.
	 * @return One or more {@link ActionReason}s (if the action was actually
	 *         executed) explaining why this action was executed (each entry
	 *         corresponds to one successful execution).
	 */
	public List<ActionReason> whyAction(final Action action) {
		final Deque<ActionReason> stack = new LinkedList<>();
		final List<AbstractEvent> trace = this.storage.getAll();
		for (int i = (trace.size() - 1); i >= 0; --i) {
			final AbstractEvent event = trace.get(i);
			if (event instanceof ActionEvent) {
				// match the requested action
				final ActionEvent ae = (ActionEvent) event;
				if (action.equals(ae.getAction())) {
					stack.push(new ActionReason(i, ae));
				}
			} else if (event instanceof SelectPlanEvent && !stack.isEmpty()) {
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
				for (final ActionReason current : stack) {
					processGPE(i, gpe, current.getParent());
				}
			} else if (event instanceof GuardEvent) {
				// a plan is only generated if its guard was evaluated at some point
				final GuardEvent ge = (GuardEvent) event;
				for (final ActionReason current : stack) {
					processGE(i, ge, current.getParent());
				}
			} else if (event instanceof SelectIntentionEvent) {
				// a guard is evaluated because of some intention selection event
				final SelectIntentionEvent sie = (SelectIntentionEvent) event;
				for (final ActionReason current : stack) {
					processSIE(i, sie, current.getParent());
				}
			} else if (event instanceof ModifyIntentionEvent) {
				final ModifyIntentionEvent mie = (ModifyIntentionEvent) event;
				for (final ActionReason current : stack) {
					processMIE(i, mie, current.getParent());
				}
			} else if (event instanceof CreateIntentionEvent) {
				// an intention can only be selected if it was created for an event sometime
				final CreateIntentionEvent cie = (CreateIntentionEvent) event;
				for (final ActionReason current : stack) {
					processCIE(i, cie, current.getParent());
				}
			}
		}
		return new ArrayList<>(stack);
	}

	/**
	 * @param belief A belief {@link Predicate} from which we want to know why it
	 *               was inserted.
	 * @return One or more {@link ModificationReason}s (if the belief was actually
	 *         inserted) explaining why this belief was inserted (each entry
	 *         corresponds to one successful non-duplicate insertion).
	 */
	public List<ModificationReason> whyBelief(final Predicate belief) {
		final Deque<ModificationReason> stack = new LinkedList<>();
		final List<AbstractEvent> trace = this.storage.getAll();
		for (int i = (trace.size() - 1); i >= 0; --i) {
			final AbstractEvent event = trace.get(i);
			if (event instanceof ModificationEvent) {
				// match the requested predicate
				final ModificationEvent me = (ModificationEvent) event;
				if (me.getUpdate().getBase() == ModificationBase.BELIEFS
						&& me.getUpdate().getAdded().contains(belief)) {
					stack.push(new ModificationReason(i, me));
				}
			} else if (event instanceof SelectPlanEvent && !stack.isEmpty()) {
				// an insertion follows directly from a plan selection
				final ModificationReason current = stack.peek();
				if (current.getParent() == null) {
					final SelectPlanEvent spe = (SelectPlanEvent) event;
					final SelectPlanReason spr = new SelectPlanReason(i, spe);
					current.setParent(spr);
				}
			} else if (event instanceof GeneratePlansEvent) {
				// a plan selection follows from the plan being generated at some point
				final GeneratePlansEvent gpe = (GeneratePlansEvent) event;
				for (final ModificationReason current : stack) {
					processGPE(i, gpe, current.getParent());
				}
			} else if (event instanceof GuardEvent) {
				// a plan is only generated if its guard was evaluated at some point
				final GuardEvent ge = (GuardEvent) event;
				for (final ModificationReason current : stack) {
					processGE(i, ge, current.getParent());
				}
			} else if (event instanceof SelectIntentionEvent) {
				// a guard is evaluated because of some intention selection event
				final SelectIntentionEvent sie = (SelectIntentionEvent) event;
				for (final ModificationReason current : stack) {
					processSIE(i, sie, current.getParent());
				}
			} else if (event instanceof ModifyIntentionEvent) {
				final ModifyIntentionEvent mie = (ModifyIntentionEvent) event;
				for (final ModificationReason current : stack) {
					processMIE(i, mie, current.getParent());
				}
			} else if (event instanceof CreateIntentionEvent) {
				// an intention can only be selected if it was created for an event sometime
				final CreateIntentionEvent cie = (CreateIntentionEvent) event;
				for (final ModificationReason current : stack) {
					processCIE(i, cie, current.getParent());
				}
			}
		}
		return new ArrayList<>(stack);
	}

	/**
	 * @param goal A goal {@link Predicate} from which we want to know why it was
	 *             adopted.
	 * @return One or more {@link ModificationReason}s (if the goal was actually
	 *         adopted) explaining why this goal was adopted (each entry corresponds
	 *         to one successful non-duplicate adoption).
	 */
	public List<ModificationReason> whyGoal(final Predicate goal) {
		final Deque<ModificationReason> stack = new LinkedList<>();
		final List<AbstractEvent> trace = this.storage.getAll();
		for (int i = (trace.size() - 1); i >= 0; --i) {
			final AbstractEvent event = trace.get(i);
			if (event instanceof ModificationEvent) {
				// match the requested predicate
				final ModificationEvent me = (ModificationEvent) event;
				if (me.getUpdate().getBase() == ModificationBase.GOALS && me.getUpdate().getAdded().contains(goal)) {
					stack.push(new ModificationReason(i, me));
				}
			} else if (event instanceof SelectPlanEvent && !stack.isEmpty()) {
				// an adoption follows directly from a plan selection
				final ModificationReason current = stack.peek();
				if (current.getParent() == null) {
					final SelectPlanEvent spe = (SelectPlanEvent) event;
					final SelectPlanReason spr = new SelectPlanReason(i, spe);
					current.setParent(spr);
				}
			} else if (event instanceof GeneratePlansEvent) {
				// a plan selection follows from the plan being generated at some point
				final GeneratePlansEvent gpe = (GeneratePlansEvent) event;
				for (final ModificationReason current : stack) {
					processGPE(i, gpe, current.getParent());
				}
			} else if (event instanceof GuardEvent) {
				// a plan is only generated if its guard was evaluated at some point
				final GuardEvent ge = (GuardEvent) event;
				for (final ModificationReason current : stack) {
					processGE(i, ge, current.getParent());
				}
			} else if (event instanceof SelectIntentionEvent) {
				// a guard is evaluated because of some intention selection event
				final SelectIntentionEvent sie = (SelectIntentionEvent) event;
				for (final ModificationReason current : stack) {
					processSIE(i, sie, current.getParent());
				}
			} else if (event instanceof ModifyIntentionEvent) {
				final ModifyIntentionEvent mie = (ModifyIntentionEvent) event;
				for (final ModificationReason current : stack) {
					processMIE(i, mie, current.getParent());
				}
			} else if (event instanceof CreateIntentionEvent) {
				// an intention can only be selected if it was created for an event sometime
				final CreateIntentionEvent cie = (CreateIntentionEvent) event;
				for (final ModificationReason current : stack) {
					processCIE(i, cie, current.getParent());
				}
			}
		}
		return new ArrayList<>(stack);
	}

	private static void processGPE(final int i, final GeneratePlansEvent gpe, final SelectPlanReason spr) {
		if (spr != null && spr.getParent() == null && gpe.getPlanIDs().contains(spr.getEvent().getPlan().getID())) {
			final GeneratePlansReason gpr = new GeneratePlansReason(i, gpe);
			spr.setParent(gpr);
		}
	}

	private static void processGE(final int i, final GuardEvent ge, final SelectPlanReason spr) {
		if (spr != null && ge.getPlan().getID() == spr.getEvent().getPlan().getID()) {
			final GeneratePlansReason gpr = spr.getParent();
			if (gpr != null && gpr.getParent() == null) {
				final GuardReason gr = new GuardReason(i, ge);
				gpr.setParent(gr);
			}
		}
	}

	private static void processSIE(final int i, final SelectIntentionEvent sie, final SelectPlanReason spr) {
		if (spr != null) {
			final GeneratePlansReason gpr = spr.getParent();
			if (gpr != null) {
				final GuardReason gr = gpr.getParent();
				if (gr != null && gr.getParent() == null
						&& sie.getIntention().getID() == gr.getEvent().getIntention().getID()) {
					final SelectIntentionReason sir = new SelectIntentionReason(i, sie);
					gr.setParent(sir);
				}
			}
		}
	}

	private static void processMIE(final int i, final ModifyIntentionEvent mie, final SelectPlanReason spr) {
		if (spr != null) {
			final GeneratePlansReason gpr = spr.getParent();
			if (gpr != null) {
				final GuardReason gr = gpr.getParent();
				if (gr != null && mie.getIntention().getID() == gr.getEvent().getIntention().getID()) {
					final SelectIntentionReason sir = gr.getParent();
					if (sir != null) {
						sir.addModification(mie);
					}
				}
			}
		}
	}

	private static void processCIE(final int i, final CreateIntentionEvent cie, final SelectPlanReason spr) {
		if (spr != null) {
			final GeneratePlansReason gpr = spr.getParent();
			if (gpr != null) {
				final GuardReason gr = gpr.getParent();
				if (gr != null && cie.getIntention().getID() == gr.getEvent().getIntention().getID()) {
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