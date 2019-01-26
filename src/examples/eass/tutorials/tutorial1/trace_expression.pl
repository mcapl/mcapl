/****************************************************************************/
/* 	          The protocol-dependent part starts here                   */
/****************************************************************************/

% match(event(Agent, assert_shared(at_speed_limit)), bel(Agent, at_speed_limit)).
% match(event(Agent, assert_shared(start)), bel(Agent, start)).
% match(event(_Agent, assert_shared(at_speed_limit)), bel(at_speed_limit)).
% match(event(_Agent, assert_shared(start)), bel(start)).

match(event(Agent, assert_shared(Belief)), bel(Agent, Belief)).
match(event(_Agent, assert_shared(Belief)), bel(Belief)).

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

match(msg(PInt, S, R, C), msg(PEnum, S, R, C)) :-
  (PInt = 1, PEnum = tell);
  (PInt = 2, PEnum = perform);
  (PInt = 3, PEnum = achieve).
% match(action(Agent, accelerate), accelerate(Agent)).
% match(action(Agent, maintain_speed), maintain_speed(Agent)).


trace_expression(test_tutorial1, Protocol) :-
  ProtocolBel = (Start * AtSpeedLimit)\/epsilon,
  Start = ((bel(abstraction_car, start):epsilon)\/epsilon),
  AtSpeedLimit = ((bel(abstraction_car, at_speed_limit):AtSpeedLimit)\/epsilon),
  ProtocolMsg = epsilon,
  NotAction = ((not_action:NotAction)\/epsilon), % a preamble for all that beliefs that appears before of the real first action
	%NotAction = ((bel(at_speed_limit):epsilon)|(bel(start):epsilon)),
	Protocol = NotAction * Protocol1,
	Protocol1 =  Protocol2 * Protocol1,
	Protocol2 = (action(any_action):(ProtocolBel | ProtocolMsg)).


trace_expression(test_tutorial1_2cars, Protocol) :-
  ProtocolBel = (Start * AtSpeedLimit)\/epsilon,
  Start = (((bel(abstraction_car, start):epsilon)\/epsilon)|((bel(abstraction_car1, start):epsilon)\/epsilon)),
  AtSpeedLimit = (AtSpeedLimit1 | AtSpeedLimit2),
  AtSpeedLimit1 = ((bel(abstraction_car, at_speed_limit):AtSpeedLimit1)\/epsilon),
  AtSpeedLimit2 = ((bel(abstraction_car1, at_speed_limit):AtSpeedLimit2)\/epsilon),
  ProtocolMsg = ((msg(tell, car, car1, hello):epsilon)\/epsilon),
  NotAction = ((not_action:NotAction)\/epsilon), % a preamble for all that beliefs that appears before of the real first action
	%NotAction = ((bel(at_speed_limit):epsilon)|(bel(start):epsilon)),
	Protocol = NotAction * Protocol1,
	Protocol1 =  Protocol2 * Protocol1,
	Protocol2 = (action(any_action):(ProtocolBel | ProtocolMsg)).

trace_expression(test_tutorial1_old, Protocol) :-
  ProtocolBel = (Start | AtSpeedLimit),
  Start = (((bel(abstraction_car, start):epsilon)\/epsilon)|((bel(abstraction_car1, start):epsilon)\/epsilon)),
  AtSpeedLimit = (AtSpeedLimit1 | AtSpeedLimit2),
  AtSpeedLimit1 = ((bel(abstraction_car, at_speed_limit):AtSpeedLimit1)\/epsilon),
  AtSpeedLimit2 = ((bel(abstraction_car1, at_speed_limit):AtSpeedLimit2)\/epsilon),
  ProtocolMsg = ((msg(tell, car, car1, hello):epsilon)\/epsilon),
  NotAction = ((not_action:NotAction)\/epsilon), % a preamble for all that beliefs that appears before of the real first action
  Protocol = NotAction * Protocol1,
  Protocol1 =  ((action(any_action):(ProtocolBel | ProtocolMsg)) * Protocol1).
  % it is non deterministic, but in this particular case is fine because we give precedence on the head,
  % that is the part involving the events (the tail is the any_action part, less important).



%
%
% % without the explicitation of the agents involved in the actions, beliefs, etc...
% trace_expression(test_tutorial1_old, Protocol) :-
%   ProtocolBel = (((bel(start):epsilon)\/epsilon)
%               | ((bel(at_speed_limit):epsilon)\/epsilon)),
%   ProtocolMsg = ((msg(tell, car, car1, hello):epsilon)\/epsilon),
%   Protocol =  ((action(any_action):(ProtocolBel | ProtocolMsg)) * Protocol).
%   % it is non deterministic, but in this particular case is fine because we give precedence on the head,
%   % that is the part involving the events (the tail is the any_action part, less important).
%
% % with the explicitation of the agents involved in the actions, beliefs, etc...
% trace_expression(test_tutorial1_old_old, Protocol) :-
%   ProtocolBel1 = (((bel(abstraction_car, start):epsilon)\/epsilon)
%               | ((bel(abstraction_car, at_speed_limit):epsilon)\/epsilon)),
%   ProtocolBel2 = (((bel(abstraction_car1, start):epsilon)\/epsilon)
%               | ((bel(abstraction_car1, at_speed_limit):epsilon)\/epsilon)),
%   ProtocolBel = (ProtocolBel1 | ProtocolBel2),
%   ProtocolMsg = ((msg(tell, car, car1, hello):epsilon)\/epsilon),
%   Protocol =  ((action(any_action):(ProtocolBel | ProtocolMsg)) * Protocol).
%   % it is non deterministic, but in this particular case is fine because we give precedence on the head,
%   % that is the part involving the events (the tail is the any_action part, less important).




% trace_expression(test_tutorial1_old, Protocol) :-
%   Protocol1 = bel(abstraction_car, start):(AtSpeedLimit1 | (msg(tell, car, car1, hello):epsilon)),
%   AtSpeedLimit1 = bel(abstraction_car, at_speed_limit):AtSpeedLimit1,
%   Protocol2 = bel(abstraction_car1, start):AtSpeedLimit2,
%   AtSpeedLimit2 = bel(abstraction_car1, at_speed_limit):AtSpeedLimit2,
%   Protocol = (Protocol1 | Protocol2).
%
% % old version considering also actions
% trace_expression(test_tutorial1_old_old, Protocol) :- % test protocol for eass tutorial1
%   Protocol1 = start(abstraction_car):UntilSpeedLimit1,
%   UntilSpeedLimit1 = ((accelerate(abstraction_car):UntilSpeedLimit1) \/ (at_speed_limit(abstraction_car):MaintainSpeed1)),
%   MaintainSpeed1 = ((maintain_speed(abstraction_car):SpeedLimit1) | (at_speed_limit(abstraction_car):MaintainSpeed1)),
%   SpeedLimit1 = (at_speed_limit(abstraction_car):SpeedLimit1),
%   Protocol2 = start(abstraction_car1):UntilSpeedLimit2,
%   UntilSpeedLimit2 = ((accelerate(abstraction_car1):UntilSpeedLimit2) \/ (at_speed_limit(abstraction_car1):MaintainSpeed2)),
%   MaintainSpeed2 = ((maintain_speed(abstraction_car1):SpeedLimit2) | (at_speed_limit(abstraction_car1):MaintainSpeed2)),
%   SpeedLimit2 = (at_speed_limit(abstraction_car1):SpeedLimit2),
%   Protocol = (Protocol1 | Protocol2).
