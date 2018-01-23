trace_expression(brake_or_accelerate, Protocol, NotAction, SingleStepProtocol, Constraints) :-
        Safe = ((bel(safe):epsilon) \/ (not_bel(safe):epsilon) \/ epsilon),
        AtSpeedLimit =((bel(at_speed_limit):epsilon) \/ (not_bel(at_speed_limit):epsilon) \/ epsilon),
        Accelerates = ((bel(driver_accelerates):epsilon) \/ (not_bel(driver_accelerates):epsilon) \/epsilon),
        Brakes = ((bel(driver_brakes):epsilon) \/ (not_bel(driver_brakes):epsilon) \/epsilon),
        ProtocolBel = (Safe|AtSpeedLimit|Accelerates|Brakes),
        ProtocolMsg = epsilon,

        NotAction = ((not_action:NotAction)\/epsilon), % a preamble for all that beliefs that appears before of the real first action

        SingleStepProtocol = (action(any_action):((ProtocolBel) | ProtocolMsg) * NotAction),
        NewActionStepProtocol =  SingleStepProtocol * NewActionStepProtocol,

        Protocol = NotAction * (NewActionStepProtocol/\Constraints),

        Constraints = (brake_or_accelerate>>BrakeOrAccelerate),
				BrakeOrAccelerate = (bel(driver_accelerates):AccelOnly) \/ (((not_bel(driver_accelerates):epsilon) \/ (not_bel(driver_brakes):epsilon)) * BrakeOrAccelerate) \/ (bel(driver_brakes):BrakeOnly),
				AccelOnly = (not_bel(driver_accelerates):BrakeOrAccelerate) \/ (((bel(driver_accelerates):epsilon) \/ (not_bel(driver_brakes):epsilon)) * AccelOnly),
				BrakeOnly = (not_bel(driver_brakes):BrakeOrAccelerate) \/ (((bel(driver_brakes):epsilon) \/ (not_bel(driver_accelerates):epsilon)) * BrakeOnly).


generate_brake_or_acc(FileName) :-
trace_expression(brake_or_accelerate, _GlobalProtocol, Preamble, Protocol, Constraints),
extract_belief_part(Protocol, ProtocolBel),
extract_msg_part(Protocol, ProtocolMsg),
generate_abstract_environment(FileName, 'eass.cruise_control.runtime', 'EASSVerificationEnvironment', 'eass.mas.verification', Preamble, ProtocolBel, ProtocolMsg, Constraints), !.

