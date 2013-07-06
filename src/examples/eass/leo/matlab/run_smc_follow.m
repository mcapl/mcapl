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

function Forces=run_smc_follow(Agent,TrackPoint,Hill,HillDot,Fmax)
%Function to generate sliding mode control stabilizing forces to position 
%maintencac
% -law from SFF using variable structure model reference control 

global ClusterMemory;

% form components etc
%-retrieve from memory
a=norm(ClusterMemory.(Agent).LeadAgentGeocentric);
muE=ClusterMemory.(Agent).muE;
%tau=2*pi*sqrt(a^3/muE); %orbital period
n=inv(sqrt(a^3/muE));
Kp=ClusterMemory.(Agent).Kp;
Kv=ClusterMemory.(Agent).Kv;
alpha=ClusterMemory.(Agent).alpha;
Xdes=TrackPoint;
m=ClusterMemory.(Agent).AgentMass;

%apply:
e=Xdes-Hill;
H1=[eye(3),eye(3)];
H2=[Kp*eye(3),Kv*eye(3)];
B=[zeros(3);1/m*eye(3)];
A=[zeros(3),eye(3);
    3*n^2,0,0,0,2*n,0;
    0,0,0,-2*n,0,0;
    0,0,-n^2,0,0,0];
S=H1*e;

%saturate surface
SatS=saturate_surface(S);

%HillDot=zeros(6,1);
ForcesIdeal=-pinv(H2*B)*(H2*A*Hill+ H2*A*HillDot - alpha*SatS);

%saturate output
Forces=saturate_thrust(ForcesIdeal,Fmax);