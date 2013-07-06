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


function  [PlanAIL PathAIL]=feasible_movement_to_location_multi(U)
%Discrete time path planning in Hill frame
%extract from U:
% -start position in hill frame
x_start=U(1:6);
% -end position in hill frame
x_finish=U(7:12);

%-constraints:
Umax=U(13:15);
T=U(16);
ms=U(17);
Om=U(18);

Xmax=0.01;

A=[zeros(3,3),eye(3,3);
   3*Om^2,0,0,0,2*Om,0;
   0,0,0,-2*Om,0,0;
   0,0,-Om^2,0,0,0];

B=[zeros(3,3);(1/ms)*eye(3,3)];
% computation of the discrete time model state space equations:
Ad1=expm(A*T);
N=10000;dT=T/N;Bd1=zeros(6,3);
for i=1:N, Bd1=Bd1+dT*expm(A*i*dT)*B;end;

Np=3;

how='infeasible';
while ~isempty(findstr(how,'infeasible')) && Np<1000,
       [x_path,u_path,fuel,how]=path_planner_multi(Np,x_start,x_finish,Ad1,Bd1,Umax,Xmax);       
       Np=Np+1;
end 

%compound planned forces with time instance
time=T;
for i=1:size(u_path,2)
timings(1,i)=time;
time=time+T;
end
PlanAIL=[timings;u_path];
PathAIL=x_path;
