generate_env(TraceExpression, FileName, TraceExpressionFile) :-
    load_files(['../../../../../classes/monitor/prolog_files/abstract_environment_compiler.pl',TraceExpressionFile],[]),
    trace_expression(TraceExpression, _GlobalProtocol, Preamble, Protocol, Constraints),
    extract_belief_part(Protocol, ProtocolBel),
    extract_msg_part(Protocol, ProtocolMsg),
    generate_abstract_environment(FileName, 'eass.cruise_control.runtime', 'EASSVerificationEnvironment', 'eass.mas.verification', Preamble, ProtocolBel, ProtocolMsg, Constraints), !.


