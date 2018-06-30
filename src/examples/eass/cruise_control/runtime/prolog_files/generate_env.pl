%% ----------------------------------------------------------------------------
%% Copyright (C) 2018 Angelo Ferrando, Louise A. Dennis, Davide Ancona, Michael Fisher and Viviana Mascardi
%%
%% This file is part of the Runtime Verification for MCAPL (RVMCAPL) Library.
%% 
%% The RVMCAPL Library is free software; you can redistribute it and/or
%% modify it under the terms of the GNU Lesser General Public
%% License as published by the Free Software Foundation; either
%% version 3 of the License, or (at your option) any later version.
%% 
%% The EASS Library is distributed in the hope that it will be useful,
%% but WITHOUT ANY WARRANTY; without even the implied warranty of
%% MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
%% Lesser General Public License for more details.
%% 
%% You should have received a copy of the GNU Lesser General Public
%% License along with the EASS Library; if not, write to the Free Software
%% Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
%% 
%% To contact the authors:
%% http://www.csc.liv.ac.uk/~lad
%%
%% ----------------------------------------------------------------------------

generate_env(TraceExpression, FileName, TraceExpressionFile) :-
    load_files(['../../../../../classes/monitor/prolog_files/abstract_environment_compiler.pl',TraceExpressionFile],[]),
    trace_expression(TraceExpression, _GlobalProtocol, Preamble, Protocol, Constraints),
    extract_belief_part(Protocol, ProtocolBel),
    extract_msg_part(Protocol, ProtocolMsg),
    generate_abstract_environment(FileName, 'eass.cruise_control.runtime', 'EASSVerificationEnvironment', 'eass.mas.verification', Preamble, ProtocolBel, ProtocolMsg, Constraints), !.


