package ail.tracing.explanations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import ail.syntax.Action;
import ail.syntax.Deed;
import ail.syntax.Event;
import ail.syntax.Predicate;
import ail.syntax.PredicatewAnnotation;
import ail.tracing.EventStorage;
import ail.tracing.EventTable;
import ail.tracing.events.AbstractEvent;
import ail.tracing.events.ActionEvent;
import ail.tracing.events.CreateIntentionEvent;
import ail.tracing.events.GeneratePlansEvent;
import ail.tracing.events.GuardEvent;
import ail.tracing.events.ModificationEvent;
import ail.tracing.events.ModifyIntentionEvent;
import ail.tracing.events.SelectIntentionEvent;
import ail.tracing.events.SelectPlanEvent;
import ail.util.Tuple;

/**
 * Supports generating explanations ({@link AbstractReason}s) from an agent
 * trace based on the 'Debugging is Explaining' paper (Hindriks 2012).
 */
public class WhyQuestions {
	private final EventStorage storage;
	private Set<Tuple<Predicate, Integer>> beliefs;
	private List<Tuple<Predicate, Integer>> goals;
	private Set<Tuple<Action, Integer>> actions;

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
		this.goals = new ArrayList<>();
		this.actions = new LinkedHashSet<>();
		int step = 0;
		for (final AbstractEvent event : this.storage.getAll()) {
			if (event instanceof ModificationEvent) {
				final ModificationEvent modification = (ModificationEvent) event;
				switch (modification.getBase()) {
				case "beliefs":
					for (Predicate bel : modification.getAdded()) {
						if (bel instanceof PredicatewAnnotation) {
							bel = new Predicate(bel);
						}
						this.beliefs.add(new Tuple(bel, step));
					}
					break;
				case "goals":
					for (Predicate goal : modification.getAdded()) {
						if (goal instanceof PredicatewAnnotation) {
							goal = new Predicate(goal);
						}
						this.goals.add(new Tuple(goal, step));
					}
					break;
				default:
					break;
				}
			} else if (event instanceof ActionEvent) {
				final Action executed = ((ActionEvent) event).getAction();
				if (executed != null) {
					this.actions.add(new Tuple(executed, step));
				}
			}
			step++;
		}
	}

	/**
	 * @return All beliefs (instantiated or not) that can be found in the trace,
	 *         either queried or actually believed at some point. Call
	 *         {@link #process()} first to update the returned beliefs.
	 */
	public Set<Tuple<Predicate, Integer>> getAllBeliefs() {
		return Collections.unmodifiableSet(this.beliefs);
	}

	/**
	 * @return All goals (instantiated or not) that can be found in the trace,
	 *         either queried or actually to be achieved at some point. Call
	 *         {@link #process()} first to update the returned goals.
	 */
	public List<Tuple<Predicate, Integer>> getAllGoals() {
		return Collections.unmodifiableList(this.goals);
	}

	/**
	 * @return All actions (instantiated or not) that can be found in the trace,
	 *         either tried or actually executed at some point. Call
	 *         {@link #process()} first to update the returned actions.
	 */
	public Set<Tuple<Action, Integer>> getAllActions() {
		return Collections.unmodifiableSet(this.actions);
	}

	// TODO: we are missing the new intention modification events here now

	
	// From paper:
	// 1.  why(selp((e, ds), i_k)N, T) = bel((e, ds), g, theta, i'_k)_N' and crei(((e, npy)_k)_N'' or add((e, npy), i''_k)_N'')
	// 2.  why(b_N, T) = crei((e, +b)_N'' because why(crei((e, +b))_N', T) or addb(b, start)
	// 3.  why(!g_N, T) = add((+!g, npy), i)_N' because why(add((+!g, npy), i)_N', T) or crei ((e, +!g), i)_N' because why(crei((e, +!g), i)_N', T)
	// 4.  why(add((+!g, npy), i_k)_N, T) = selp((e, ds), i'_k)_N' because why(selp(e, ds), i'_k)_N', T) and +!g \in ds or crei((e, +!g)_k)_N' because why(crei((e, +!g)_k)_N', T)
	// 5.  why(act(a, i_k)_N, T) = selp((e, ds), i'_k)_N' because why(selp((e, ds), i'_k)_N', T) and a \in ds
	// 6.  why(crei((start, d))_N, T) = start
	// 7.  why(crei((perecept, d))_N, T) = percept
	// 8.  why(crei((e, npy)_k)_N, T) - selp((e, ds), i_k)_N' because why(selp((e, ds), i_k)_N', T) and e \in ds
	
	/**
	 * @param action An action from which we want to know why it was executed.
	 * @return One or more {@link ActionReason}s (if the action was actually
	 *         executed) explaining why this action was executed (each entry
	 *         corresponds to one successful execution).
	 */
	public List<AbstractReason> whyAction(final Action action, int tindex) {
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
				if (current.getParent() == null
						&& !((SelectPlanEvent) event).isContinue() 
						// && ((SelectPlanEvent) event).contains(new Deed(current.getAction()))
						&& (current.getIID() == ((SelectPlanEvent) event).getIID())) {
					final SelectPlanEvent spe = (SelectPlanEvent) event;
					final SelectPlanReason spr = new SelectPlanReason(i, spe);
					current.setParent(spr);
					
					whySelectPlan(spe, spr, trace, i);
				}
			} 
		}
		return new ArrayList<>(stack);
	}
	
	// 1.  why(selp((e, ds), i_k)N, T) = bel((e, ds), g, theta, i'_k)_N' and crei(((e, npy)_k)_N'' or add((e, npy), i''_k)_N'')
	public void whySelectPlan(final SelectPlanEvent spe, SelectPlanReason spr, List<AbstractEvent> trace, int n) {
		int intention_id = spe.getIID();
		for (int i = n; i >= 0; --i) {
			final AbstractEvent event = trace.get(i);
			if (event instanceof GuardEvent) {
				GuardEvent g_event = (GuardEvent) event;
				// I don't think we need this check since generate plans goes straight to select plans
				// without switching intentions.  But just in case.
				spr.setParent(new GuardReason(i, g_event));
				if (intention_id == g_event.getIntention().getID()) {
					for (int j = i; j >= 0; --j) {
						final AbstractEvent e2 = trace.get(j);
						if (e2 instanceof CreateIntentionEvent) {
							CreateIntentionEvent crei = (CreateIntentionEvent) e2;
							if (intention_id == crei.getIntention().getID() && crei.getIntention().hdE().equals(spe.getPlan().getEvent())) {
								CreateIntentionReason crer = new CreateIntentionReason(j, crei);
								// whyCreateIntention(crei, crer, trace, j);
								spr.setParent2(crer);
								break;
							} else {
								
							}
						} else if (e2 instanceof ModifyIntentionEvent) {
							ModifyIntentionEvent add = (ModifyIntentionEvent) e2;
							if (intention_id == add.getIntention().getID() && add.getIntention().hdE().equals(spe.getPlan().getEvent())) {
								ModifyIntentionReason addr = new ModifyIntentionReason(j, add);
								// whyModifyIntention(add, addr, trace, j);
								spr.setParent2(addr);
								break;
							} else {
								
							}
						}
					}
					break;
				} else {
					
				}
			}
			/* if (event instanceof GeneratePlansEvent) {
				if (spr.getParent() == null) {
					final GeneratePlansReason gpr = new GeneratePlansReason(i, (GeneratePlansEvent) event);
					spr.setParent(gpr);
					whyGeneratePlans((GeneratePlansEvent) event, gpr, trace, i, spe.getPlan().getID());
				} else {
					break;
				}
			} */
		} 
	}
	
	public void whyGeneratePlans(final GeneratePlansEvent gpe, GeneratePlansReason gpr, List<AbstractEvent> trace, int n, int plan_id) {
			boolean eventfound = false;
			for (int i = n; i >= 0; --i) {
				final AbstractEvent event = trace.get(i);
				Event postevent = gpe.getEvent();
				if  (event instanceof GuardEvent) {
					if (gpr.getParent() == null && ((GuardEvent) event).getPlan().getID() == plan_id) {
						final GuardReason ger = new GuardReason(i, (GuardEvent) event);
						gpr.setParent(ger);
					}
				} else if (event instanceof ModifyIntentionEvent) {
					ModifyIntentionEvent me = (ModifyIntentionEvent) event;
					if (!eventfound && !me.getIntention().events().isEmpty() && me.getIntention().hdE() != null && me.getIntention().hdE() == postevent && me.getIntention().getID() == gpe.getIID()) {
						final ModifyIntentionReason mer = new ModifyIntentionReason(i, me);
						gpr.setPostEvent(mer);
						eventfound = true;
					}
				} else if (event instanceof CreateIntentionEvent) {
					CreateIntentionEvent ce = (CreateIntentionEvent) event;
					if (!eventfound 
						&& ce.getIntention().hdE().equals(postevent)
						&& ce.getIntention().getID() == gpe.getIID()) {
						final CreateIntentionReason cer = new CreateIntentionReason(i, ce);
						gpr.setPostEvent(cer);
						eventfound = true;
					}
				}
			}
	}
	/* public List<AbstractReason> whyAction(final Action action) {
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
	} */

	/**
	 * @param belief A belief {@link Predicate} from which we want to know why it
	 *               was inserted.
	 * @return One or more {@link ModificationReason}s (if the belief was actually
	 *         inserted) explaining why this belief was inserted (each entry
	 *         corresponds to one successful non-duplicate insertion).
	 */
	public List<AbstractReason> whyBelief(final Predicate belief) {
		final Deque<ModificationReason> stack = new LinkedList<>();
		final List<AbstractEvent> trace = this.storage.getAll();
		for (int i = (trace.size() - 1); i >= 0; --i) {
			final AbstractEvent event = trace.get(i);
			if (event instanceof ModificationEvent) {
				// match the requested predicate
				final ModificationEvent me = (ModificationEvent) event;
				if (me.getBase().equals("beliefs") && me.contains(belief, true)) {
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
	public List<AbstractReason> whyGoal(final Predicate goal) {
		final Deque<ModificationReason> stack = new LinkedList<>();
		final List<AbstractEvent> trace = this.storage.getAll();
		for (int i = (trace.size() - 1); i >= 0; --i) {
			final AbstractEvent event = trace.get(i);
			if (event instanceof ModificationEvent) {
				// match the requested predicate
				final ModificationEvent me = (ModificationEvent) event;
				if (me.getBase().equals("goals") && me.contains(goal, true)) {
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
			// spr.setParent(gpr);
		}
	}

	private static void processGE(final int i, final GuardEvent ge, final SelectPlanReason spr) {
		if (spr != null && ge.getPlan().getID() == spr.getEvent().getPlan().getID()) {
			//final GeneratePlansReason gpr = spr.getParent();
			//if (gpr != null && gpr.getParent() == null) {
			//	final GuardReason gr = new GuardReason(i, ge);
			//	gpr.setParent(gr);
			//}
		}
	}

	private static void processSIE(final int i, final SelectIntentionEvent sie, final SelectPlanReason spr) {
		if (spr != null) {
			// final GeneratePlansReason gpr = spr.getParent();
			//if (gpr != null) {
			//	final GuardReason gr = gpr.getParent();
			//	if (gr != null && gr.getParent() == null
			//			&& sie.getIntention().getID() == gr.getEvent().getIntention().getID()) {
			//		final SelectIntentionReason sir = new SelectIntentionReason(i, sie);
			//		gr.setParent(sir);
			//	}
			//}
		}
	}

	private static void processMIE(final int i, final ModifyIntentionEvent mie, final SelectPlanReason spr) {
		if (spr != null) {
			//final GeneratePlansReason gpr = spr.getParent();
			//if (gpr != null) {
			//	final GuardReason gr = gpr.getParent();
			//	if (gr != null && mie.getIntention().getID() == gr.getEvent().getIntention().getID()) {
			//		final SelectIntentionReason sir = gr.getParent();
			//		if (sir != null) {
			//			sir.addModification(mie);
			//		}
			//	}
			//}
		}
	}

	private static void processCIE(final int i, final CreateIntentionEvent cie, final SelectPlanReason spr) {
		if (spr != null) {
		//	final GeneratePlansReason gpr = spr.getParent();
		//	if (gpr != null) {
		//		final GuardReason gr = gpr.getParent();
		//		if (gr != null && cie.getIntention().getID() == gr.getEvent().getIntention().getID()) {
		//			final SelectIntentionReason sir = gr.getParent();
		//			if (sir != null && sir.getParent() == null) {
		//				final CreateIntentionReason cir = new CreateIntentionReason(i, cie);
		//				sir.setParent(cir);
		//			}
		//		}
		//	}
		}
	}
	
	public AbstractEvent getEvent(int i) {
		return this.storage.getAll().get(i);
	}
	
	public List<AbstractEvent> getTrace() {
		return this.storage.getAll();
	}
	
	public String toString() {
		String s = "";
		for (final AbstractEvent event : this.storage.getAll()) {
			s += EventTable.getDescription(event);
			s += "\n";
		}
		return s;
	}
	
	public String verboseString() {
		String s = "";
		int i = 0;
		for (final AbstractEvent event: this.storage.getAll()) {
			s += i + ". ";
			i++;
			s += event.toString();
			s += "\n";
		}
		return s;
	}
}