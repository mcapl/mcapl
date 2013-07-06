% Copyright (C) 2012 Nicholas K. Lincoln, Sandor M. Veres, Louise Dennis,
% Michael Fisher, and Alexei Lisitsa.
% 
% This file is part of the EASS (Engineering Autonomous Space Software) 
% Demonstrator Set.
% 
% The EASS Demonstrator Set is free software: you can redistribute it 
% and/or modify it under the terms of the GNU Lesser General Public License
% as published by the Free Software Foundation, either version 3 of the 
% License, or (at your option) any later version.
% 
% The EASS Demonstrator Set is distributed in the hope that it will be 
% useful, but WITHOUT ANY WARRANTY; without even the implied warranty of 
% MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
% General Public License for more details.
% 
% You should have received a copy of the GNU Lesser General Public License 
% along with the EASS Demonstrator Set.  If not, see 
% <http://www.gnu.org/licenses/>.

function InitializeContinuous(U)
%Agent Framework file to perform automatic configuring of socket ports for
%the Continuous Engine

redundant_variable=U;
global MatlabSocket;
global Cont2Phys;

if isempty(MatlabSocket),
    MatlabSocket=ail.util.AILSocketClient(6254);
    display('=>Connected to Java');
else
    if (~ MatlabSocket.isClosed()), MatlabSocket.close(); end
    MatlabSocket=ail.util.AILSocketClient(6254);
    display('=>Connected to Java');
end

if isempty(Cont2Phys),
    Cont2Phys=ail.util.AILSocketClient(6255);
    display('=>Connected to Phsical Engine');
else
    if (~ Cont2Phys.isClosed()), Cont2Phys.close(); end
    Cont2Phys=ail.util.AILSocketClient(6255);
    display('=>Connected to Phsical Engine');
end