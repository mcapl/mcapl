
match(event(Agent, assert_shared(Belief)), bel(Agent, Belief)).
match(event(Agent, remove_shared(Belief)), not_bel(Agent, Belief)).
match(event(_Agent, assert_shared(Belief)), bel(Belief)).
match(event(_Agent, remove_shared(Belief)), not_bel(Belief)).

match(event(_Agent, SomeAction), action(any_action)) :-
  functor(SomeAction, F, _),
  F \= assert_shared,
  F \= remove_shared.
match(event(Agent, SomeAction), action(Agent, any_action)) :-
  functor(SomeAction, F, _),
  F \= assert_shared,
  F \= remove_shared.
match(event(Agent, Action), action(Agent, Action)) :-
  functor(Action, F, _),
  F \= assert_shared,
  F \= remove_shared.
match(event(_Agent, Action), action(Action)) :-
  functor(Action, F, _),
  F \= assert_shared,
  F \= remove_shared.

match(Event, not_action) :-
  not(match(Event, action(any_action))).

% match(Event, not_bel(Belief)) :-
%   not(match(Event, bel(Belief))).
% match(Event, not_bel(Agent, Belief)) :-
%   not(match(Event, bel(Agent, Belief))).

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

match(E, accelerates_or_safe) :-
  match(E, bel(driver_accelerates));
  match(E, bel(safe));
  match(E, not_bel(safe)).

match(E, change_left_or_safe_left) :-
  match(E, bel(safe_left));
  match(E, not_bel(safe_left));
  match(E, action(change_left));
  match(E, action(_, change_left)).

match(E, change_right_or_safe_right) :-
  match(E, bel(safe_right));
  match(E, not_bel(safe_right));
  match(E, action(change_right));
  match(E, action(_, change_right)).

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

check(T) :-
  print('Check protocol correctness'), nl(),
  ((T = Preamble * (ActionSteps/\Constraints), !);(T = _ * ActionSteps)),
  all_shuffles(Preamble),
  print('Preamble presence checked'), nl(),
  ActionSteps = ActionStep * ActionSteps,
  print('Cyclicity of the actions steps checked'), nl(),
  all_unions_of_actions(ActionStep, ProtocolBelMsgs),
  print('All actions divided by unions checked'), nl(),
  findall(ProtocolBelMsg, (member(ProtocolBelMsg, ProtocolBelMsgs), ProtocolBelMsg \= (Bel|Msg)), []),
  print('All continuations of the actions are shuffles checked'), nl(),
  findall((Bel|Msg), (member((Bel|Msg), ProtocolBelMsgs), (not(contains_only_beliefs(Bel)); not(contains_only_msgs(Msg)))), []),
  print('All shuffle in the left part contains only beliefs checked'), nl(),
  print('All shuffle in the right part contains only messages checked'), nl(),
  ((var(Constraints))->(true);(check_constraints(Constraints))),
  print('Constraints checked'), nl().

check_constraints(T) :-
  empty_assoc(A),
  check_constraints(T, A).
check_constraints(T1/\T2, A) :-
  put_assoc(T1/\T2, A, _, A1),
  check_constraints(T1, A1),
  check_constraints(T2, A1).
check_constraints(ET>>Constraint, A) :-
  Constraint = (Conditions * (ConstrainedET:(Negations*Constraint))),
  all_shuffles_of_add_remove_bel(Conditions, BeliefsCond),
  all_shuffles_of_remove_bel(Negations, BeliefsNeg),
  append(BeliefsCond, BeliefsNeg, BeliefsCondNeg),
  match_at_least(ET, [ConstrainedET|BeliefsCondNeg]),
  findall(E, (member(bel(Bel), BeliefsCond), not(member(not_bel(Bel), BeliefsNeg))), []),
  findall(E, (member(bel(A, Bel), BeliefsCond), not(member(not_bel(A, Bel), BeliefsNeg))), []),
  findall(E, (member(not_bel(Bel), BeliefsCond), not(member(bel(Bel), BeliefsNeg))), []),
  findall(E, (member(not_bel(A, Bel), BeliefsCond), not(member(bel(A, Bel), BeliefsNeg))), []),
  findall(E, (member(bel(Bel), BeliefsNeg), not(member(not_bel(Bel), BeliefsCond))), []),
  findall(E, (member(bel(A, Bel), BeliefsNeg), not(member(not_bel(A, Bel), BeliefsCond))), []),
  findall(E, (member(not_bel(Bel), BeliefsNeg), not(member(bel(Bel), BeliefsCond))), []),
  findall(E, (member(not_bel(A, Bel), BeliefsNeg), not(member(bel(A, Bel), BeliefsCond))), []).

match_at_least(_, []).
match_at_least(ET, [H|T]) :-
  match(E, H), match(E, ET), !,
  match_at_least(ET, T).

all_shuffles(T) :-
  empty_assoc(A),
  all_shuffles(T, A).
all_shuffles(T, A) :-
  get_assoc(T, A, _), !.
all_shuffles(_:epsilon, _).
%all_shuffles((_:epsilon)\/epsilon, _).
all_shuffles(((not_action:_)\/epsilon), _).
all_shuffles(T1|T2, A) :-
  put_assoc(T1|T2, A, _, A1),
  all_shuffles(T1, A1),
  all_shuffles(T2, A1).

all_unions_of_actions(T, ProtocolBelMsgs) :-
  empty_assoc(A),
  all_unions_of_actions(T, A, ProtocolBelMsgs).
all_unions_of_actions(T, A, []) :-
  get_assoc(T, A, _), !.
all_unions_of_actions(ET:T, _, [T]) :-
  ET = action(_); ET = action(_,_).
all_unions_of_actions(T1\/T2, A, ProtocolBelMsgs) :-
  put_assoc(T1\/T2, A, _, A1),
  all_unions_of_actions(T1, A1, ProtocolBelMsgs1),
  all_unions_of_actions(T2, A1, ProtocolBelMsgs2),
  append(ProtocolBelMsgs1, ProtocolBelMsgs2, ProtocolBelMsgs).

all_shuffles_of_add_remove_bel(T, Beliefs) :-
  empty_assoc(A),
  all_shuffles_of_add_remove_bel(T, A, Beliefs).
all_shuffles_of_add_remove_bel(T, A, []) :-
  get_assoc(T, A, _), !.
all_shuffles_of_add_remove_bel(TT, _, [ET]) :-
  TT = (NET:TT)\/(ET:(T1\/T2)),
  ((T1 = epsilon);(T2 = epsilon)),
  (((ET = bel(Belief); ET = bel(_, Belief)),
  (NET = not_bel(Belief); NET = not_bel(_, Belief)));
  ((ET = not_bel(Belief); ET = not_bel(_, Belief)),
  (NET = bel(Belief); NET = bel(_, Belief)))).
  %((End = epsilon);(End = TT)).
all_shuffles_of_add_remove_bel(T1|T2, A, Beliefs) :-
  put_assoc(T1|T2, A, _, A1),
  all_shuffles_of_add_remove_bel(T1, A1, Beliefs1),
  all_shuffles_of_add_remove_bel(T2, A1, Beliefs2),
  append(Beliefs1, Beliefs2, Beliefs3),
  list_to_set(Beliefs3, Beliefs).

all_shuffles_of_remove_bel(T, Beliefs) :-
  empty_assoc(A),
  all_shuffles_of_remove_bel(T, A, Beliefs).
all_shuffles_of_remove_bel(T, A, []) :-
  get_assoc(T, A, _), !.
all_shuffles_of_remove_bel(ET:epsilon, _, [ET]).
% all_shuffles_of_remove_bel(T1*_, A, Beliefs) :-
%   all_shuffles_of_remove_bel(T1, A, Beliefs).
all_shuffles_of_remove_bel(T1|T2, A, Beliefs) :-
  put_assoc(T1|T2, A, _, A1),
  all_shuffles_of_remove_bel(T1, A1, Beliefs1),
  all_shuffles_of_remove_bel(T2, A1, Beliefs2),
  append(Beliefs1, Beliefs2, Beliefs3),
  list_to_set(Beliefs3, Beliefs).

contains_only_beliefs(T) :-
  empty_assoc(A),
  contains_only_beliefs(T, A).
contains_only_beliefs(epsilon, _).
contains_only_beliefs(T, A) :-
  get_assoc(T, A, _), !.
contains_only_beliefs(ET:T, A) :-
  (ET = bel(_); ET = not_bel(_); ET = bel(_, _); ET = not_bel(_, _)),
  put_assoc(ET:T, A, _, A1),
  contains_only_beliefs(T, A1).
contains_only_beliefs(T1\/T2, A) :-
  put_assoc(T1\/T2, A, _, A1),
  contains_only_beliefs(T1, A1),
  contains_only_beliefs(T2, A1).
contains_only_beliefs(T1|T2, A) :-
  put_assoc(T1|T2, A, _, A1),
  contains_only_beliefs(T1, A1),
  contains_only_beliefs(T2, A1).
contains_only_beliefs(T1*T2, A) :-
  put_assoc(T1*T2, A, _, A1),
  contains_only_beliefs(T1, A1),
  contains_only_beliefs(T2, A1).
contains_only_beliefs(T1/\T2, A) :-
  put_assoc(T1/\T2, A, _, A1),
  contains_only_beliefs(T1, A1),
  contains_only_beliefs(T2, A1).
contains_only_beliefs(ET>>T, A) :-
  put_assoc(ET>>T, A, _, A1),
  contains_only_beliefs(T, A1).

contains_only_msgs(T) :-
  empty_assoc(A),
  contains_only_msgs(T, A).
contains_only_msgs(epsilon, _).
contains_only_msgs(T, A) :-
  get_assoc(T, A, _), !.
contains_only_msgs(ET:T, A) :-
  ET = msg(_,_,_,_),
  put_assoc(ET:T, A, _, A1),
  contains_only_msgs(T, A1).
contains_only_msgs(T1\/T2, A) :-
  put_assoc(T1\/T2, A, _, A1),
  contains_only_msgs(T1, A1),
  contains_only_msgs(T2, A1).
contains_only_msgs(T1|T2, A) :-
  put_assoc(T1|T2, A, _, A1),
  contains_only_msgs(T1, A1),
  contains_only_msgs(T2, A1).
contains_only_msgs(T1*T2, A) :-
  put_assoc(T1*T2, A, _, A1),
  contains_only_msgs(T1, A1),
  contains_only_msgs(T2, A1).
contains_only_msgs(T1/\T2, A) :-
  put_assoc(T1/\T2, A, _, A1),
  contains_only_msgs(T1, A1),
  contains_only_msgs(T2, A1).
contains_only_msgs(ET>>T, A) :-
  put_assoc(ET>>T, A, _, A1),
  contains_only_msgs(T, A1).


trace_expression(Name, myContent >> Protocol) :-
  trace_expression(Name, Protocol, _, _, _),
  check(Protocol),
  empty_assoc(A),
  extract_content(Protocol, Content1, A),
  list_to_set(Content1, Content),
  retractall(current_content(_)),
  asserta(current_content(Content)).
  %post_processing(Protocol1, Protocol).
% trace_expression(cruise_control_protocol, NotSafe) :-
%   NotSafe1 = (not_bel(safe):epsilon),
%   NotSafe2 = (not_bel(accelerate):epsilon),
%   NotSafe = (((NotSafe1 /\ NotSafe2) * NotSafe) \/ (bel(safe):Safe)),
%   Safe = ((bel(not(safe)):NotSafe)\/(not_bel(not(safe)):Safe)).

trace_expression(motorwayNew1, Protocol, NotAction, SingleStepProtocol, Constraints) :-
	ProtocolBel = (Safe|BrakesSpeedLimit),
  Safe = (((bel(safe):epsilon)\/epsilon)|
                  ((not_bel(safe):epsilon)\/epsilon)),
  BrakesSpeedLimit = ((((bel(driver_brakes):epsilon)\/epsilon)|AtSpeedLimit|Accelerates)),
  AtSpeedLimit = (bel(at_speed_limit):AtSpeedLimit)\/epsilon,
  Accelerates = (bel(driver_accelerates):epsilon)\/epsilon,
	ProtocolMsg = epsilon,
	NotAction = ((not_action:NotAction)\/epsilon), % a preamble for all that beliefs that appears before of the real first action
	%NotAction = ((bel(at_speed_limit):epsilon)|(bel(start):epsilon)),
	Protocol = NotAction * (NewActionStepProtocol/\Constraints),
	NewActionStepProtocol =  SingleStepProtocol * NewActionStepProtocol,
  Constraints = (accelerates_or_safe>>Constraints1),
  Constraints1 = (SafeBeforeAccelerates * (bel(driver_accelerates):((not_bel(safe):epsilon) * Constraints1))),
  SafeBeforeAccelerates =
    (not_bel(safe):SafeBeforeAccelerates)\/
    (bel(safe):(epsilon\/(SafeBeforeAccelerates))),
    SingleStepProtocol = (action(any_action):((ProtocolBel) | ProtocolMsg)).

trace_expression(motorwayNew1LD, Protocol, NotAction, SingleStepProtocol, Constraints) :-
    Safe = ((bel(safe):epsilon)\/epsilon),
    AcceleratesOrBrakes = (((bel(driver_accelerates):epsilon)\/(bel(driver_brakes):epsilon))\/epsilon),
    ProtocolBel = (Safe|AcceleratesOrBrakes),
    ProtocolMsg = epsilon,
    NotAction = ((not_action:NotAction)\/epsilon), % a preamble for all that beliefs that appears before of the real first action
 
    SingleStepProtocol = (action(any_action):((ProtocolBel) | ProtocolMsg)),
    NewActionStepProtocol =  SingleStepProtocol * NewActionStepProtocol,
    Protocol = NotAction * (NewActionStepProtocol/\Constraints),
    
    Constraints = (accelerates_or_safe>>Constraints1),
    Constraints1 = (SafeBeforeAccelerates * (bel(driver_accelerates):((not_bel(safe):epsilon) * Constraints1))),
    SafeBeforeAccelerates =
        (not_bel(safe):SafeBeforeAccelerates)\/
        (bel(safe):(epsilon\/(SafeBeforeAccelerates))).



%        Safe = ((bel(safe):epsilon)\/epsilon),
%        AcceleratesOrBrakes = (((bel(driver_accelerates):epsilon)\/(bel(driver_brakes):epsilon))\/epsilon),
%        ProtocolBel = (Safe|AcceleratesOrBrakes),
%        ProtocolMsg = epsilon,

%        NotAction = (not_action:NotAction\/epsilon), % a preamble for all that beliefs that appears before of the real first action

%        SingleStepProtocol = (action(any_action):(ProtocolBel | ProtocolMsg)),
%        NewActionStepProtocol =  SingleStepProtocol * NewActionStepProtocol,

%        Protocol = NotAction * (NewActionStepProtocol/\Constraints),

%        Constraints = (accelerates_or_safe>>Constraints1),

%        Constraints1 = (SafeBeforeAccelerates * (bel(driver_accelerates):((not_bel(safe):epsilon) * Constraints1))),

%        SafeBeforeAccelerates =
%             (not_bel(safe):SafeBeforeAccelerates)\/
%                     (bel(safe):(epsilon\/(SafeBeforeAccelerates))).

trace_expression(motorwayNew, Protocol, NotAction, SingleStepProtocol, Constraints) :-
	ProtocolBel = (Safe|SafeLeft|SafeRight|Accelerates),
  Safe = (((bel(safe):epsilon)\/epsilon)|
                  ((not_bel(safe):epsilon)\/epsilon)),
  SafeLeft = (((bel(safe_left):epsilon)\/epsilon)|
                  ((not_bel(safe_left):epsilon)\/epsilon)),
  SafeRight = (((bel(safe_right):epsilon)\/epsilon)|
                  ((not_bel(safe_right):epsilon)\/epsilon)),
  Accelerates = (bel(driver_accelerates):epsilon)\/epsilon,
	ProtocolMsg = epsilon,
	NotAction = ((not_action:NotAction)\/epsilon), % a preamble for all that beliefs that appears before of the real first action
	%NotAction = ((bel(at_speed_limit):epsilon)|(bel(start):epsilon)),
	Protocol = NotAction * (NewActionStepProtocol/\Constraints),
	NewActionStepProtocol =  SingleStepProtocol * NewActionStepProtocol,
  Constraints = ((accelerates_or_safe>>Constraints1) /\
                 (change_left_or_safe_left>>Constraints2) /\
                 (change_right_or_safe_right>>Constraints3)),
  Constraints1 = (SafeBeforeAccelerates * (bel(driver_accelerates):((not_bel(safe):epsilon) * Constraints1))),
  Constraints2 = (SafeLeftBeforeChangeLeft * (action(change_left):((not_bel(safe_left):epsilon) * Constraints2))),
  Constraints3 = (SafeRightBeforeChangeRight * (action(change_right):((not_bel(safe_right):epsilon) * Constraints3))),
  SafeBeforeAccelerates =
    (not_bel(safe):SafeBeforeAccelerates)\/
    (bel(safe):(epsilon\/(SafeBeforeAccelerates))),
  SafeLeftBeforeChangeLeft =
    (not_bel(safe_left):SafeLeftBeforeChangeLeft)\/
    (bel(safe_left):(epsilon\/(SafeLeftBeforeChangeLeft))),
  SafeRightBeforeChangeRight =
    (not_bel(safe_right):SafeRightBeforeChangeRight)\/
    (bel(safe_right):(epsilon\/(SafeRightBeforeChangeRight))),
	SingleStepProtocol = ((action(change_left):((ProtocolBel) | ProtocolMsg))\/
                        (action(change_right):((ProtocolBel) | ProtocolMsg))\/
                        (action(any_action):((ProtocolBel) | ProtocolMsg))).

trace_expression(motorway1, Protocol, NotAction, SingleStepProtocol) :-
  ProtocolBel = ((bel(safe):epsilon)\/(bel(at_speed_limit):epsilon))\/epsilon,
  ProtocolMsg = epsilon,
  NotAction = ((not_action:NotAction)\/epsilon), % a preamble for all that beliefs that appears before of the real first action
  %NotAction = ((bel(at_speed_limit):epsilon)|(bel(start):epsilon)),
  Protocol = NotAction * NewActionStepProtocol,
  NewActionStepProtocol =  SingleStepProtocol * NewActionStepProtocol,
  SingleStepProtocol = (action(any_action):(ProtocolBel | ProtocolMsg)).

trace_expression(motorwayNew_old, Protocol, NotAction, SingleStepProtocol) :-
	ProtocolBel = (Accelerates\/BrakesSpeedLimit),
  Accelerates = ((bel(driver_accelerates):epsilon)\/epsilon),
  BrakesSpeedLimit = ((((bel(driver_brakes):epsilon)\/epsilon)|AtSpeedLimit)),
  AtSpeedLimit = (bel(at_speed_limit):AtSpeedLimit)\/epsilon,
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
