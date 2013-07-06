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

function ThrusterAssign=ThrusterTracking(u)

%function to track the usage change of the thrusters and if detected, note
%this change in the memory.

%obsolete: tracking maintained within global variable ClusterMemory and may
%be accessed by continuous engine via socket comms if required.

%see if ThrusterUse defined (only ever used once)
if ~exist('ThrusterUse.mat')
    ThrusterUse.X=0;
    ThrusterUse.Y=0;
    ThrusterUse.Z=0;
    ThrusterUse.XYZ=0;
    
    save ThrusterUse;     
end

%now read in current usage and compare to what is being prescribed
load ThrusterUse;
OldUsage=[ThrusterUse.X;ThrusterUse.Y;ThrusterUse.Z;ThrusterUse.XYZ];
NewUsage=u;

if NewUsage==OldUsage
    ThrusterAssign=u;
else
    ThrusterUse.X=u(1);
    ThrusterUse.Y=u(2);
    ThrusterUse.Z=u(3);
    ThrusterUse.XYZ=u(4);
    save ThrusterUse;
    clear ThrusterUse;
    
    ThrusterAssign=u;
end