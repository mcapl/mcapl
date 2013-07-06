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

function Occur=any_future_collision(U)
%Agent callable function to predict a future collision of satellite agents 
%based upon no action

%checks across the entire cluster for any collision
display('->Checking cluster for collision');
t=U(1);
Bound=U(2);
%retrieve required items from physical engine:
%-number of agents
NumAgents=RequestMemoryItem('ClusterMemory.Agent1.GroupSize');
muE=RequestMemoryItem('ClusterMemory.Agent1.muE');
LeadAgentGeocentric=RequestMemoryItem('ClusterMemory.Agent1.LeadAgentGeocentric');
a=norm(LeadAgentGeocentric(1:3));
Om=inv(sqrt(a^3/muE));

%-agent locations (current state)
State=zeros(6,NumAgents);
for j=1:NumAgents,
    State(:,j)=RequestDataItem(sprintf('A%dStateInfo',j));
end
    

%Predict future paths over time duration t
Path=[];
for i=1:NumAgents
    NewPath=FuturePath(t,State(:,i),Om);    
    %only interested in position and know that time instances tally, so....
    NewPath(1,:)=[];NewPath(4:6,:)=[];
    Path=[Path;NewPath];
end

display('-->Paths predicted, checking for temporal intersection');
%check for temporal collision
Occur=PathIntersection(Path,Bound);

if Occur,
    display(['-->Future collision in ',sprintf('%d',t),' seconds predicted']);
else
    display(['-->No collision in ',sprintf('%d',t),' seconds predicted']);
end

