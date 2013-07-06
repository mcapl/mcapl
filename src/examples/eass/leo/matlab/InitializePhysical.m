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

%Agent Framework file to perform automatic configuring of socket ports for
%the Physical Engine

function InitializePhysical

global Phys2Cont;
global clientsocket;

if isempty(clientsocket),
    clientsocket=ail.util.AILSocketClient();
    display('=>Connected to Java');
else
    if (~ clientsocket.isClosed()), clientsocket.close(); end
    clientsocket=ail.util.AILSocketClient();
    display('=>Connected to Java');
end


if isempty(Phys2Cont)
    display('...Awaiting Continuous Engine Connection...');
    Phys2Cont=ail.util.AILSocketServer(6255);
    display('=>Connected to Continuous Engine');
else
    Phys2Cont.close();
    display('...Awaiting Continuous Engine Connection...');
    Phys2Cont=ail.util.AILSocketServer(6255);
    display('=>Connected to Continuous Engine');
end

