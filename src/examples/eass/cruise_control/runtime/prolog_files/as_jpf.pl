trace_expression(as_jpf, Protocol, NotAction, SingleStepProtocol, epsilon) :-
        Safe = ((bel(safe):epsilon) \/ (not_bel(safe):epsilon) \/ epsilon),
        AtSpeedLimit =((bel(at_speed_limit):epsilon) \/ (not_bel(at_speed_limit):epsilon) \/ epsilon),
        Accelerates = ((bel(driver_accelerates):epsilon) \/ (not_bel(driver_accelerates):epsilon) \/epsilon),
        Brakes = ((bel(driver_brakes):epsilon) \/ (not_bel(driver_brakes):epsilon) \/epsilon),
        ProtocolBel = (Safe|AtSpeedLimit|Accelerates|Brakes),
        ProtocolMsg = epsilon,

        NotAction = ((not_action:NotAction)\/epsilon), % a preamble for all that beliefs that appears before of the real first action

        SingleStepProtocol = (action(any_action):((ProtocolBel) | ProtocolMsg) * NotAction),
        NewActionStepProtocol =  SingleStepProtocol * NewActionStepProtocol,

        Protocol = NotAction * NewActionStepProtocol.
