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

function Collide=PathIntersection(Path,Bound)

%determines path intersections based upon concatenated [Path] of the form
%[PathA;PathB;Path_n|...|PathA;PathB;Path_n]
%columns correcspond temporally and only contain position information

%Bound is the permissable distance (norm) between items before collision is
%flagged

TotAgents=size(Path,1)/3; %number of agents being considered

%consider all
for i=1:(TotAgents-1)
    Anow=Path(1:3,:);           %agent path being considered
    Others=Path(4:end,:);       %other agent paths
    TotOthers=size(Others,1)/3; %number of other agents
    
    %look thru agents sequentially
    for j=1:TotOthers,
        
        %look thru time instances
        for k=1:size(Path,2) %time steps
            D1=Anow(:,k)-Others(1:3,k);
            if norm(D1)<=Bound,
                Collide=1;
                return;
            end
        end
        Others(1:3,:)=[];   %remove agent that has passed test and repeat
    end
    Path(1:3,:)=[];         %remove path stack that has been passed
end
Collide=0;






