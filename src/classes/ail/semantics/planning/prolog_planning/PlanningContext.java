package ail.semantics.planning.prolog_planning;

import ail.syntax.BeliefBase;
import ail.syntax.Predicate;
import ail.syntax.RuleBase;

public class PlanningContext {
	
	BeliefBase initial_conditions = new BeliefBase();
	RuleBase rules = new RuleBase();
	Predicate goal;
	
	public PlanningContext() {
		/* %%% This is one of the example programs from the textbook:
		%%%
		%%% Artificial Intelligence: 
		%%% Structures and strategies for complex problem solving
		%%%
		%%% by George F. Luger and William A. Stubblefield
		%%% 
		%%% Corrections by Christopher E. Davis (chris2d@cs.unm.edu)
		%%%
		%%% These programs are copyrighted by Benjamin/Cummings Publishers.
		%%%
		%%% We offer them for use, free of charge, for educational purposes only.
		%%%
		%%% Disclaimer: These programs are provided with no warranty whatsoever as to
		%%% their correctness, reliability, or any other property.  We have written 
		%%% them for specific educational purposes, and have made no effort
		%%% to produce commercial quality computer programs.  Please do not expect 
		%%% more of them then we have intended.
		%%%
		%%% This code has been tested with SWI-Prolog (Multi-threaded, Version 5.2.13)
		%%% and appears to function as intended. */
		
		
		// plan(State, Goal, _, Moves) :- 	equal_set(State, Goal). 
		// plan(State, Goal, Been_list, Moves) :- 	
		//		move(Name, Preconditions, Actions),
		//  	conditions_met(Preconditions, State),
		//  	change_state(State, Actions, Child_state),
		//		not(member_state(Child_state, Been_list)),
		//		stack(Child_state, Been_list, New_been_list),
		//		stack(Name, Moves, New_moves),
		//		plan(Child_state, Goal, New_been_list, New_moves),!.

		// change_state(S, [], S).
		// change_state(S, [add(P)|T], S_new) :-	change_state(S, T, S2),
		//		add_to_set(P, S2, S_new), !.
		// change_state(S, [del(P)|T], S_new) :-	change_state(S, T, S2),
		//		remove_from_set(P, S2, S_new), !.
		// conditions_met(P, S) :- subset(P, S).


		// member_state(S, [H|_]) :- 	equal_set(S, H).
		// member_state(S, [_|T]) :- 	member_state(S, T).

		
		
	}
	
	public void add_initial_condition(Predicate b) {
		initial_conditions.add(new Literal(true, b));
	}
	
	public void addRule(Rule r) {
		rules.add(r);
	}
	
	public void addGoal(Predicate goal) {
		Predicate holds = new Predicate("holds");
		holds.addTerm(goal);
		holds.addTerm(new VarTerm("S"));
		this.goal = holds;
	}
	
	public Term plan() {
		if (goal != null) {
			Unifier un = new Unifier();
			EvaluationAndRuleBaseIterator logic_planner = new EvaluationAndRuleBaseIterator(new NamedEvaluationBase(initial_conditions, "init"), rules, un, goal, goal.getVarNames() );
			Unifier u = logic_planner.next();
			goal.apply(u);
		}
		
		return goal.getTerm(1);
	}

}
