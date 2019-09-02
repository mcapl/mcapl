// ----------------------------------------------------------------------------
// Copyright (C) 2018 Louise A. Dennis, Michael Fisher, and Vincent Koeman
//
// This file is part of the Gwendolen
// 
// Gwendolen is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Gwendolen is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------
package gwendolen.tracing.explanations;

import java.util.ArrayList;
import java.util.List;

import ail.syntax.Action;
import ail.syntax.Deed;
import ail.syntax.Event;
import ail.syntax.Goal;
import ail.syntax.Message;
import ail.syntax.Predicate;
import ail.syntax.Unifier;
import ail.tracing.EventStorage;
import ail.tracing.EventTable;
import ail.tracing.events.AbstractEvent;
import ail.tracing.events.ActionEvent;
import ail.tracing.events.CreateIntentionEvent;
import ail.tracing.events.GeneratePlansEvent;
import ail.tracing.events.GuardEvent;
import ail.tracing.events.ModificationEvent;
import ail.tracing.events.ModifyIntentionEvent;
import ail.tracing.events.SelectPlanEvent;
import ail.tracing.explanations.AbstractReason;
import ail.tracing.explanations.WhyQuestionsBase;

/**
 * Supports generating explanations ({@link AbstractReason}s) from an agent
 * trace based on the 'Debugging is Explaining' paper (Hindriks 2012).
 */
public class WhyQuestions extends WhyQuestionsBase {

	public WhyQuestions(final EventStorage storage) {
		super(storage);
	}



	// TODO: we are missing the new intention modification events here now

	
	// From paper:
	// 1.  why(selp((e, ds), i_k)N, T) = bel((e, ds), g, theta, i'_k)_N' and crei(((e, npy)_k)_N'' or add((e, npy), i''_k)_N'')
	// 2.  why(b_N, T) = crei((e, +b)_N'' because why(crei((e, +b))_N', T) or addb(b, start)
	// 3.  why(!g_N, T) = add((+!g, npy), i)_N' because why(add((+!g, npy), i)_N', T) or crei ((e, +!g), i)_N' because why(crei((e, +!g), i)_N', T)
	// 4.  why(add((+!g, npy), i_k)_N, T) = selp((e, ds), i'_k)_N' because why(selp(e, ds), i'_k)_N', T) and +!g \in ds or crei((e, +!g)_k)_N' because why(crei((e, +!g)_k)_N', T)
	// 5.  why(act(a, i_k)_N, T) = selp((e, ds), i'_k)_N' because why(selp((e, ds), i'_k)_N', T) and a \in ds
	// 6.  why(crei((start, d))_N, T) = start
	// 7.  why(crei((percept, d))_N, T) = percept
	// 8.  why(crei((e, npy)_k)_N, T) = selp((e, ds), i_k)_N' because why(selp((e, ds), i_k)_N', T) and e \in ds
	
	// 5.  why(act(a, i_k)_N, T) = selp((e, ds), i'_k)_N' because why(selp((e, ds), i'_k)_N', T) and a \in ds
	/**
	 * @param action An action from which we want to know why it was executed.
	 * @return One or more {@link ActionReason}s (if the action was actually
	 *         executed) explaining why this action was executed (each entry
	 *         corresponds to one successful execution).
	 */
	public ActionReason whyAction(final Action action, int tindex) {
		// final Deque<ActionReason> stack = new LinkedList<>();
		final List<AbstractEvent> trace = this.storage.getAll();
		final AbstractEvent event = trace.get(tindex);
		ActionReason current = new ActionReason(tindex, (ActionEvent) event);
		for (int i = tindex; i >= 0; --i) {
			AbstractEvent r_event = trace.get(i);
			if (r_event instanceof SelectPlanEvent) {
				if (current.getParent() == null
						&& !((SelectPlanEvent) r_event).isContinue() 
						// && ((SelectPlanEvent) event).contains(new Deed(current.getAction()))
						&& (current.getIID() == ((SelectPlanEvent) r_event).getIID())) {
					ArrayList<Deed> deeds = ((SelectPlanEvent) r_event).getPlan().getPrefix();
					for (Deed d: deeds) {
						d.apply(((SelectPlanEvent) r_event).getPlan().getUnifier());
						if (d.getContent().equals(action)) {
							final SelectPlanEvent spe = (SelectPlanEvent) r_event;
							final SelectPlanReason spr = new SelectPlanReason(i, spe);
							current.setParent(spr);
							// System.err.println("5");
							whySelectPlan(spe, spr, trace, i);
							break;
							
						}
					}
					if (current.getParent() != null) {
						break;
					}
				}
			} 
		}
		return current;
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
				if (intention_id == g_event.getIntention().getID() && spe.getPlan().getID() == g_event.getPlan().getID()) {
					for (int j = i; j >= 0; --j) {
						final AbstractEvent e2 = trace.get(j);
						if (e2 instanceof CreateIntentionEvent) {
							CreateIntentionEvent crei = (CreateIntentionEvent) e2;
							Event plan_event = spe.getPlan().getEvent();
							Unifier plan_unifier = spe.getPlan().getUnifier();
							plan_event.apply(plan_unifier);
							if (intention_id == crei.getIntention().getID()) {
								if (crei.getIntention().hdE().equals(plan_event)) {
									CreateIntentionReason crer = new CreateIntentionReason(j, crei);
								// System.err.println("1.1");
									whyCreateIntention(crei, crer, trace, j);
									spr.setParent2(crer);
									break;
								}
								Event trigger = crei.getIntention().hdE();
								if (trigger.hasContent() && trigger.getContent() instanceof Message) {
									Predicate trig_term = ((Message) trigger.getContent()).toTerm();
									if (trig_term.equals(plan_event.getContent())) {
										CreateIntentionReason crer = new CreateIntentionReason(j, crei);
										// System.err.println("1.1a");
											whyCreateIntention(crei, crer, trace, j);
											spr.setParent2(crer);
											break;
									}
								}

							} else {
								// System.err.println("1.?1");
							}
						} else if (e2 instanceof ModifyIntentionEvent) {
							ModifyIntentionEvent add = (ModifyIntentionEvent) e2;
							if (intention_id == add.getIntention().getID() && add.getIntention().hdE().equals(spe.getPlan().getEvent())) {
								ModifyIntentionReason addr = new ModifyIntentionReason(j, add);
								// System.err.println("1.2");
								whyAddGoal(add, addr, trace, j);
								spr.setParent2(addr);
								break;
							} else {
								// System.err.println("1.?2");
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
	
	// 4.  why(add((+!g, npy), i_k)_N, T) = selp((e, ds), i'_k)_N' because why(selp(e, ds), i'_k)_N', T) and +!g \in ds or crei((e, +!g)_k)_N' because why(crei((e, +!g)_k)_N', T)
	public void whyAddGoal(final ModifyIntentionEvent age, ModifyIntentionReason mir, List<AbstractEvent> trace, int n) {
		int intention_id = age.getIID();
		Goal g = (Goal) age.getIntention().hdE().getContent();
		for (int i = n; i >= 0; --i) {
			final AbstractEvent event = trace.get(i);
			if (event instanceof SelectPlanEvent) {
				SelectPlanEvent spe = (SelectPlanEvent) event;
				if (spe.getIID() == intention_id  && !spe.isContinue()) {
					List<Deed> deeds = spe.getPlan().getPrefix();
					for (Deed d: deeds) {
						d.getContent().apply(spe.getPlan().getUnifier());
						if (d.getContent().equals(g)) {
							// System.err.println("4.1");
							SelectPlanReason spr = new SelectPlanReason(i, spe);
							if (spe.isContinue()) {
								// System.err.println("4.1.1");
								whySelectPlan(spe, spr, trace, i);
							} 
							mir.setParent(spr);
							break;
						}
					}
					
					if (mir.getParent() != null) {
						break;
					}
				}
			} else if (event instanceof CreateIntentionEvent){
				CreateIntentionEvent crei = (CreateIntentionEvent) event;
				if (crei.getIntention().getID() == intention_id && crei.getIntention().hdD().getContent().equals(g)) {
					CreateIntentionReason crer = new CreateIntentionReason(i, crei);
					// System.err.println("4.2");
					whyCreateIntention(crei, crer, trace, i);
					mir.setParent(crer);
					break;
				} else {
					
				}
			}
		}
	}
	
	// NEW: 	// 2.  why(((+b, npy), i)_N', T) = crei((e, +b)_N'' because why(crei((e, +b))_N', T) or addb(b, start) or selp((e, ds), i'_k)_N' because why(selp(e, ds), i'_k)_N', T) and +b \in ds 
	public void whyAddBelief(final ModificationEvent age, ModificationReason mir, List<AbstractEvent> trace, int n, Predicate b) {
		int intention_id = age.getIID();
		//Predicate b = (Predicate) age.getIntention().hdE().getContent();
		for (int i = n; i >= 0; --i) {
			final AbstractEvent event = trace.get(i);
			if (event instanceof SelectPlanEvent) {
				SelectPlanEvent spe = (SelectPlanEvent) event;
				if (spe.getIID() == intention_id  && !spe.isContinue()) {
					List<Deed> deeds = spe.getPlan().getPrefix();
					for (Deed d: deeds) {
						d.getContent().apply(spe.getPlan().getUnifier());
						if (d.getContent().equals(b)) {
							SelectPlanReason spr = new SelectPlanReason(i, spe);
							// System.err.println("2n.3");
							whySelectPlan(spe, spr, trace, i);
							mir.setParent(spr);
							break;
						}
					}
					
					if (mir.getParent() != null) {
						break;
					}
				}
			} else if (event instanceof CreateIntentionEvent){
				CreateIntentionEvent crei = (CreateIntentionEvent) event;
				if (crei.getIntention().getID() == intention_id && crei.getIntention().hdD().getContent().equals(b)) {
					CreateIntentionReason crer = new CreateIntentionReason(i, crei);
					// System.err.println("2n.1");
					whyCreateIntention(crei, crer, trace, i);
					mir.setParent(crer);
					break;
				} else {
					
				}
			}
		}
	}

	
	// 6.  why(crei((start, d))_N, T) = start
	// 7.  why(crei((percept, d))_N, T) = percept
	// 8.  why(crei((e, npy)_k)_N, T) = selp((e, ds), i_k)_N' because why(selp((e, ds), i_k)_N', T) and e \in ds
	public void whyCreateIntention(final CreateIntentionEvent crei, CreateIntentionReason crer, List<AbstractEvent> trace, int n) {
		// int intention_id = crei.getIntention().getID();
		Event trigger = crei.getIntention().hdE();
		
		if (trigger.getCategory() == Event.Estart || trigger.getCategory() == Event.FromPercept  || trigger.getCategory() == Event.AILReceived) {
			// System.err.println("6&7");
			return;
		} else {
			for (int i = n; i >= 0; --i) {
				final AbstractEvent event = trace.get(i);
				if (event instanceof SelectPlanEvent) {
					SelectPlanEvent spe = (SelectPlanEvent) event;
					if (!spe.isContinue()) {
						//if (spe.getIID() == intention_id) {
						List<Deed> deeds = spe.getPlan().getPrefix();
						for (Deed d: deeds) {
							if (d.hasContent()) {
								d.getContent().apply(spe.getPlan().getUnifier());
								if (d.getContent().equals(trigger.getContent())) {
									// System.err.println("8");
									SelectPlanReason spr = new SelectPlanReason(i, spe);
									whySelectPlan(spe, spr, trace, i);
									crer.setParent(spr);
									break;
								}
							}
						}
					}
				} else if (event instanceof CreateIntentionEvent) {
					CreateIntentionEvent crei2 = (CreateIntentionEvent) event;
					if (crei2.getIntention().hdD().getContent() != null && crei2.getIntention().hdD().getContent().equals(crei.getIntention().hdE().getContent())) {
						CreateIntentionReason crer2 = new CreateIntentionReason(i, crei2);
						// System.err.println("2n.1");
						whyCreateIntention(crei2, crer2, trace, i);	
						crer.setParent(crer2);
						break;
					}
				}
			}
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
						System.err.println("?.1");
					}
				} else if (event instanceof ModifyIntentionEvent) {
					ModifyIntentionEvent me = (ModifyIntentionEvent) event;
					if (!eventfound && !me.getIntention().events().isEmpty() && me.getIntention().hdE() != null && me.getIntention().hdE() == postevent && me.getIntention().getID() == gpe.getIID()) {
						final ModifyIntentionReason mer = new ModifyIntentionReason(i, me);
						gpr.setPostEvent(mer);
						System.err.println("?.2");
						eventfound = true;
					}
				} else if (event instanceof CreateIntentionEvent) {
					CreateIntentionEvent ce = (CreateIntentionEvent) event;
					if (!eventfound 
						&& ce.getIntention().hdE().equals(postevent)
						&& ce.getIntention().getID() == gpe.getIID()) {
						final CreateIntentionReason cer = new CreateIntentionReason(i, ce);
						gpr.setPostEvent(cer);
						System.err.println("?.3");
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
	// 2.  why(b_N, T) = crei((e, +b)_N'' because why(crei((e, +b))_N', T) or addb(b, start) or why(add(+b, npy, i)_N', T)
	public BeliefReason whyBelief(final Predicate belief, int n) {
		// final Deque<AbstractReason> stack = new LinkedList<>();
		final BeliefReason br = new BeliefReason(belief, n);
		final List<AbstractEvent> trace = this.storage.getAll();
		for (int i = n; i >= 0; --i) {
			final AbstractEvent event = trace.get(i);
			/*if (event instanceof CreateIntentionEvent) {
				CreateIntentionEvent crei = (CreateIntentionEvent) event;
				Deed d = crei.getIntention().hdD();
				if (d.getCategory() == Deed.AILBel && d.getTrigType() == Deed.AILAddition && d.getContent().equals(belief)) {
					CreateIntentionReason crer = new CreateIntentionReason(i, crei);
					// whyCreateIntention(crei, crer, trace, j);
					// System.err.println("2.1");
					br.setParent(crer);
					// return crer;
					break;
					
				}
			} else */
			if (event instanceof ModificationEvent) {
				// match the requested predicate
				final ModificationEvent me = (ModificationEvent) event;
				//if (me.getBase().equals("beliefs") && me.contains(belief, true) && me.isInitial()) {
					//ModificationReason mir = new ModificationReason(i, me);
					//whyAddBelief(me, mir, trace, i, belief);
					//System.err.println("2.2");
					//br.setParent(new ModificationReason(i, me));
					//return new ModificationReason(i, me);
					// return me;
					//break;
				//} else 
				if (me.getBase().equals("beliefs") && me.contains(belief, true)) {
					ModificationReason mir = new ModificationReason(i, me);
					// System.err.println("2.3");
					whyAddBelief(me, mir, trace, i, belief);
					br.setParent(mir);
					//return new ModificationReason(i, me);
					// return me;
					break;
				}
			} 
		}
		return br;
	}

	// 3.  why(!g_N, T) = add((+!g, npy), i)_N' because why(add((+!g, npy), i)_N', T) or crei ((e, +!g), i)_N' because why(crei((e, +!g), i)_N', T)
	/**
	 * @param goal A goal {@link Predicate} from which we want to know why it was
	 *             adopted.
	 * @return One or more {@link ModificationReason}s (if the goal was actually
	 *         adopted) explaining why this goal was adopted (each entry corresponds
	 *         to one successful non-duplicate adoption).
	 */
	public GoalReason whyGoal(final Predicate goal, int n) {
		final GoalReason gr = new GoalReason(goal, n);
		final List<AbstractEvent> trace = this.storage.getAll();
		for (int i = n; i >= 0; --i) {
			final AbstractEvent event = trace.get(i);
			
			/* if (event instanceof CreateIntentionEvent) {
				CreateIntentionEvent crei = (CreateIntentionEvent) event;
				Deed d = crei.getIntention().hdD();
				if (d.getCategory() == Deed.AILGoal && d.getTrigType() == Deed.AILAddition && d.getContent().equals(new Goal(goal, Goal.achieveGoal))) {
					CreateIntentionReason crer = new CreateIntentionReason(i, crei);
					//System.err.println("3.2");
					whyCreateIntention(crei, crer, trace, i);
					gr.setParent(crer);
					// return crer;
					break;
					
				}
			} else */
			if (event instanceof ModifyIntentionEvent) {
				// match the requested predicate
				final ModifyIntentionEvent me = (ModifyIntentionEvent) event;
				Event trigger = me.getIntention().hdE();
				if (trigger.referstoGoal() && trigger.getTrigType() == Event.AILAddition && trigger.getContent().equals(new Goal(goal, Goal.achieveGoal))) {
					ModifyIntentionReason mir = new ModifyIntentionReason(i, me);
					// System.err.println("3.1");
					whyAddGoal(me, mir, trace, i);
					gr.setParent(mir);
					//return new ModificationReason(i, me);
					// return me;
					break;
				}
			} 
		}
		return gr;
/*		final Deque<ModificationReason> stack = new LinkedList<>();
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
		return new ArrayList<>(stack); */
	}

/*	private static void processGPE(final int i, final GeneratePlansEvent gpe, final SelectPlanReason spr) {
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
	} */
	
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