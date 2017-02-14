/****************************************************************************/
/* 	          The protocol-dependent part starts here                   */
/****************************************************************************/

% match(event(Agent, assert_shared(at_speed_limit)), bel(Agent, at_speed_limit)).
% match(event(Agent, assert_shared(start)), bel(Agent, start)).
% match(event(_Agent, assert_shared(at_speed_limit)), bel(at_speed_limit)).
% match(event(_Agent, assert_shared(start)), bel(start)).

match(event(Agent, assert_shared(Belief)), bel(Agent, Belief)).
match(event(Agent, remove_shared(Belief)), bel(Agent, not(Belief))).
match(event(_Agent, assert_shared(Belief)), bel(Belief)).
match(event(_Agent, remove_shared(Belief)), bel(not(Belief))).

match(event(_Agent, SomeAction), action(any_action)) :-
  functor(SomeAction, F, _),
  F \= assert_shared.
match(event(Agent, SomeAction), action(Agent, any_action)) :-
  functor(SomeAction, F, _),
  F \= assert_shared.
match(event(Agent, Action), action(Agent, Action)) :-
  functor(Action, F, _),
  F \= assert_shared.
match(event(_Agent, Action), action(Action)) :-
  functor(Action, F, _),
  F \= assert_shared.

match(Event, not_action) :-
  not(match(Event, action(any_action))).

match(Event, not_bel(Belief)) :-
  not(match(Event, bel(Belief))).
match(Event, not_bel(Agent, Belief)) :-
  not(match(Event, bel(Agent, Belief))).

match(_Event, anything).

match(msg(PInt, S, R, C), msg(PEnum, S, R, C)) :-
  (PInt = 1, PEnum = tell);
  (PInt = 2, PEnum = perform);
  (PInt = 3, PEnum = achieve).
% match(action(Agent, accelerate), accelerate(Agent)).
% match(action(Agent, maintain_speed), maintain_speed(Agent)).

match(E, myContent) :-
  current_content(Content),
  member(ET, Content),
  match(E, ET), !.

event(_).

extract_content(epsilon, [], _).
extract_content(T, [], A) :-
  get_assoc(T, A, _), !.
extract_content(ET:T, [ET|Content], A) :-
  ET \== not_action, !,
  put_assoc(ET:T, A, _, A1),
  extract_content(T, Content, A1).
extract_content(ET:T, Content, A) :-
  put_assoc(ET:T, A, _, A1),
  extract_content(T, Content, A1).
extract_content(T1\/T2, Content, A) :-
  put_assoc(T1\/T2, A, _, A1),
  extract_content(T1, Content1, A1),
  extract_content(T2, Content2, A1),
  append(Content1, Content2, Content).
extract_content(T1|T2, Content, A) :-
  put_assoc(T1|T2, A, _, A1),
  extract_content(T1, Content1, A1),
  extract_content(T2, Content2, A1),
  append(Content1, Content2, Content).
extract_content(T1*T2, Content, A) :-
  put_assoc(T1*T2, A, _, A1),
  extract_content(T1, Content1, A1),
  extract_content(T2, Content2, A1),
  append(Content1, Content2, Content).
extract_content(T1/\T2, Content, A) :-
  put_assoc(T1/\T2, A, _, A1),
  extract_content(T1, Content1, A1),
  extract_content(T2, Content2, A1),
  append(Content1, Content2, Content).
extract_content(ET>>T, Content, A) :-
  put_assoc(ET>>T, A, _, A1),
  extract_content(T, Content, A1).

% post_processing(T, T1) :-
% 	empty_assoc(A),
% 	post_processing(T, T1, A).
% post_processing(epsilon, epsilon, _).
% post_processing(T, T1, A) :-
% 	get_assoc(T, A, T1), !.
% post_processing(ET:T, T1, A) :-
%   ET \= msg(_,_,_,_), !,
%   put_assoc(ET:T, A, T1, A1),
% 	from_prefix_to_shuffles(ET:T, Shuffles, Continuation),
% 	(var(Continuation) ->
%     (T1 = Shuffles * T1);
%     (post_processing(Continuation, Continuation1, A1),
%      T1 = Shuffles * Continuation1)).
% post_processing(ET:T, ET:T1, A) :-
%   put_assoc(ET:T, A, ET:T1, A1),
%   post_processing(T, T1, A1).
% post_processing(T1\/T2, T3\/T4, A) :-
% 	put_assoc(T1\/T2, A, T3\/T4, A1),
% 	post_processing(T1, T3, A1),
% 	post_processing(T2, T4, A1).
% post_processing(T1|T2, T3|T4, A) :-
% 	put_assoc(T1|T2, A, T3|T4, A1),
% 	post_processing(T1, T3, A1),
% 	post_processing(T2, T4, A1).
% post_processing(T1*T2, T3*T4, A) :-
% 	put_assoc(T1*T2, A, T3*T4, A1),
% 	post_processing(T1, T3, A1),
% 	post_processing(T2, T4, A1).
% post_processing(T1/\T2, T3/\T4, A) :-
% 	put_assoc(T1\/T2, A, T3/\T4, A1),
% 	post_processing(T1, T3, A1),
% 	post_processing(T2, T4, A1).
% post_processing(ET>>T, ET>>T1, A) :-
% 	put_assoc(ET>>T, A, ET>>T1, A1),
% 	post_processing(T, T1, A1).
%
% from_prefix_to_shuffles(T, T1, Continuation) :-
% 	empty_assoc(A),
% 	from_prefix_to_shuffles(T, T1, Continuation, A).
% from_prefix_to_shuffles(T, epsilon, _, A) :-
% 	get_assoc(T, A, _), !.
% from_prefix_to_shuffles(ET:T, T2, Continuation, A) :-
% 	!, put_assoc(ET:T, A, T2, A1),
% 	from_prefix_to_shuffles(T, T1, Continuation, A1),
% 	(T1 \== epsilon -> (T2 = ((ET:epsilon)|T1));(T2 = (ET:epsilon))).
% from_prefix_to_shuffles(Continuation, epsilon, Continuation, _).

trace_expression(Name, myContent >> Protocol) :-
  trace_expression(Name, Protocol, _, _),
  empty_assoc(A),
  extract_content(Protocol, Content, A),
  retractall(current_content(_)),
  asserta(current_content(Content)).
  %post_processing(Protocol1, Protocol).
% trace_expression(cruise_control_protocol, NotSafe) :-
%   NotSafe1 = (not_bel(safe):epsilon),
%   NotSafe2 = (not_bel(accelerate):epsilon),
%   NotSafe = (((NotSafe1 /\ NotSafe2) * NotSafe) \/ (bel(safe):Safe)),
%   Safe = ((bel(not(safe)):NotSafe)\/(not_bel(not(safe)):Safe)).

trace_expression(motorway1, Protocol, NotAction, SingleStepProtocol) :-
	ProtocolBel = ((bel(safe):epsilon)\/(bel(at_speed_limit):epsilon))\/epsilon,
	ProtocolMsg = epsilon,
	NotAction = ((not_action:NotAction)\/epsilon), % a preamble for all that beliefs that appears before of the real first action
	%NotAction = ((bel(at_speed_limit):epsilon)|(bel(start):epsilon)),
	Protocol = NotAction * NewActionStepProtocol,
	NewActionStepProtocol =  SingleStepProtocol * NewActionStepProtocol,
	SingleStepProtocol = (action(any_action):(ProtocolBel | ProtocolMsg)).

trace_expression(motorwayNoSingleLaneNoOvertaking, Protocol, NotAction, SingleStepProtocol) :-
	ProtocolBel = (((bel(at_exit):epsilon)\/epsilon)|
                 ((bel(leaving_at_chosen_exit):epsilon)\/epsilon)|
                 ((bel(chosen_exit_approaching):epsilon)\/epsilon)),
	ProtocolMsg = epsilon,
	NotAction = ((not_action:NotAction)\/epsilon), % a preamble for all that beliefs that appears before of the real first action
	%NotAction = ((bel(at_speed_limit):epsilon)|(bel(start):epsilon)),
	Protocol = NotAction * NewActionStepProtocol,
	NewActionStepProtocol =  SingleStepProtocol * NewActionStepProtocol,
	SingleStepProtocol = (action(any_action):(ProtocolBel | ProtocolMsg)).

trace_expression(motorwayWithSingleLaneNoOvertaking, Protocol, NotAction, SingleStepProtocol) :-
	ProtocolBel = (((bel(safe):epsilon)\/epsilon)|
                 ((bel(at_speed_limit):epsilon)\/epsilon)|
                 ((bel(driver_accelerates):epsilon)\/epsilon)|
                 ((bel(driver_brakes):epsilon)\/epsilon)),
	ProtocolMsg = epsilon,
	NotAction = ((not_action:NotAction)\/epsilon), % a preamble for all that beliefs that appears before of the real first action
	%NotAction = ((bel(at_speed_limit):epsilon)|(bel(start):epsilon)),
	Protocol = NotAction * NewActionStepProtocol,
	NewActionStepProtocol =  SingleStepProtocol * NewActionStepProtocol,
	SingleStepProtocol = (action(any_action):(ProtocolBel | ProtocolMsg)).

trace_expression(motorwayNoSingleLaneWithOvertaking, Protocol, NotAction, SingleStepProtocol) :-
	ProtocolBel =
		(((bel(in_leftmost_lane):epsilon)\/epsilon)|
     ((bel(in_rightmost_lane):epsilon)\/epsilon)|
     ((bel(changed_lane):epsilon)\/epsilon)|
		 ((bel(safe_right):epsilon)\/epsilon)|
     ((bel(safe_left):epsilon)\/epsilon)|
     ((bel(car_ahead_in_lane):epsilon)\/epsilon)|
		 ((bel(car_ahead_in_left_lane):epsilon)\/epsilon)),
	ProtocolMsg = epsilon,
	NotAction = ((not_action:NotAction)\/epsilon), % a preamble for all that beliefs that appears before of the real first action
	%NotAction = ((bel(at_speed_limit):epsilon)|(bel(start):epsilon)),
	Protocol = NotAction * NewActionStepProtocol,
	NewActionStepProtocol =  SingleStepProtocol * NewActionStepProtocol,
	SingleStepProtocol = (action(any_action):(ProtocolBel | ProtocolMsg)).

trace_expression(motorwayWithSingleLaneWithOvertaking, Protocol, NotAction, SingleStepProtocol) :-
	ProtocolBel =
  (((bel(in_leftmost_lane):epsilon)\/epsilon)|
   ((bel(in_rightmost_lane):epsilon)\/epsilon)|
   ((bel(changed_lane):epsilon)\/epsilon)|
   ((bel(safe_right):epsilon)\/epsilon)|
   ((bel(safe_left):epsilon)\/epsilon)|
   ((bel(car_ahead_in_lane):epsilon)\/epsilon)|
   ((bel(car_ahead_in_left_lane):epsilon)\/epsilon)|
   ((bel(at_exit):epsilon)\/epsilon)|
   ((bel(leaving_at_chosen_exit):epsilon)\/epsilon)|
   ((bel(chosen_exit_approaching):epsilon)\/epsilon)),
	ProtocolMsg = epsilon,
	NotAction = ((not_action:NotAction)\/epsilon), % a preamble for all that beliefs that appears before of the real first action
	%NotAction = ((bel(at_speed_limit):epsilon)|(bel(start):epsilon)),
	Protocol = NotAction * NewActionStepProtocol,
	NewActionStepProtocol =  SingleStepProtocol * NewActionStepProtocol,
	SingleStepProtocol = (action(any_action):(ProtocolBel | ProtocolMsg)).
