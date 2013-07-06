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


function [OUT]=plan_named_approach_to_location_multi(U)
%AIL called function to form a plan to move to a location within the Hill
%problem. The default function of the code is to form plan, save plan and
%inform AIL of the plan name, all wrt to named agent (arg 13 in U)

%U(13,1) is supplied data, corresponding to hill errors and desired hill location
%U[current position(3,1);current velocity(3,1);desired position(3,1);desired velocity(3,1);agentnumber(1,1)]

%read in thruster usage current and data store
AgentNumber=U(7);aname=sprintf('Agent%d',AgentNumber);dname=sprintf('A%d',AgentNumber);
HillDes=U(1:6);

%spacecraft agent memory
m=RequestMemoryItem(strcat('ClusterMemory.',(aname),'.AgentMass'));
Tsw=RequestMemoryItem(strcat('ClusterMemory.',(aname),'.Tswitch'));
F0=RequestMemoryItem(strcat('ClusterMemory.',(aname),'.ThrustSaturation'));
TG=RequestMemoryItem(strcat('ClusterMemory.',(aname),'.ThrusterGains'));
TU=RequestMemoryItem(strcat('ClusterMemory.',(aname),'.ThrusterUse'));
theta=RequestMemoryItem(strcat('ClusterMemory.',(aname),'.theta'));
phi=RequestMemoryItem(strcat('ClusterMemory.',(aname),'.phi'));
muE=RequestMemoryItem(strcat('ClusterMemory.',(aname),'.muE'));
LeadAgentGeocentric=RequestMemoryItem(strcat('ClusterMemory.',(aname),'.LeadAgentGeocentric'));

%required data
StateNow=RequestDataItem(strcat((dname),'StateInfo'));

%angular velocity of reference orbit(assume circular)
%via keplers 3rd law: tau=2*pi*sqrt(a^3/muE);om=2pi/tau
a=norm(LeadAgentGeocentric(1:3));
om=inv(sqrt(a^3/muE));

Fxyz=TG(4)*[F0*cos(theta)*cos(phi);F0*sin(phi);F0*cos(pi/2-theta)*cos(phi)];
if TU(1)==0 && TU(4)==1, %X not being used, XYZ replacement
   Fmax=[Fxyz(1);Fxyz(2)+F0*TG(2) ; Fxyz(3)+F0*TG(3)];
elseif TU(2)==0 && TU(4)==1, %Y not being used
   Fmax=[Fxyz(1)+F0*M.TG(1) ;Fxyz(2); Fxyz(3)+F0*TG(3)];
elseif TU(3)==0 && TU(4)==1, %Z not being used
   Fmax=[Fxyz(1)+F0*TG(1) ;Fxyz(2)+F0*TG(2) ; Fxyz(3)];  
elseif TU(1)==1 && TU(4)==1, %X and XYZ replacement being used
   Fmax=[Fxyz(1);Fxyz(2)+F0*TG(2) ; Fxyz(3)+F0*TG(3)];
elseif TU(2)==1 && TU(4)==1, %Y and XYZ
   Fmax=[Fxyz(1)+F0*TG(1) ;Fxyz(2); Fxyz(3)+F0*TG(3)];
elseif TU(3)==1 && TU(4)==1, %Z and XYZ
   Fmax=[Fxyz(1)+F0*TG(1) ;Fxyz(2)+F0*TG(2) ; Fxyz(3)]; 
else
   Fmax=F0*TG(1:3); 
end

display(sprintf('-->Planning path for Agent%d',AgentNumber));
%concantenate relevant parts
U=[StateNow;HillDes;Fmax;Tsw;m;om]; %[hill data;umax;tswitch;mass;omega](18,1);
[AILthrust,AILpath]=feasible_movement_to_location_multi(U);
display(sprintf('-->Plan of duration %3.2f seconds completed',AILthrust(1,end)));
display(sprintf('-->[%3.1f,%3.1f,%3.1f] Hill error targetted',AILpath(1,end),AILpath(2,end),AILpath(3,end)));


%modify to account for thruster gains
%-here we are adjusting thrust calls to account for PERCIEVED gains.
%-Percieved gains are modified in runtime via simple_thruster_gain.m
AILthrust(2:4,:)=diag(TG(1:3))\AILthrust(2:4,:);
PlanAIL.Thrust=AILthrust;
PlanAIL.Path=AILpath;


%selectively save plan name.
global NameIndex; if isempty(NameIndex),NameIndex=0;end
Name=strcat('PlanAIL',num2str(NameIndex));
NameIndex=NameIndex+1;
save(Name,'PlanAIL');
display(sprintf('-->Plan saved as "%s"',Name));

%return plan name 
OUT=Name;