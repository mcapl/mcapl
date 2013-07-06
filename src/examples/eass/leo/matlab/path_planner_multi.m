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

function [x_path,u_path,fuel,how]=path_planner_multi(Np,x_start,x_finish,Ad1,Bd1,Umax,Xm)
%Path planning algorithm to solve the generic disctrete time planning
%problem by linear programming. Here Umax is defined as a vector (x,y,z) 
%rather than a basic single maximum output constraint

Cm=Bd1;ANp=Ad1;for k=1:Np-1,  Cm=[Ad1*Cm,Bd1];ANp=Ad1*ANp;end
 
Xm=Xm/10; 
x_f=x_finish-ANp*x_start;

%building up the inequality matrix
A=[Cm,zeros(size(Cm))];b=x_f+Xm;
nou=round(size(A,2)/2);
A=[A;-Cm,zeros(size(Cm))];b=[b;-x_f+Xm];

%A=[A;zeros(nou,nou),-eye(nou)];b=[b;zeros(nou,1)];
A=[A;eye(nou),-eye(nou)];b=[b;zeros(nou,1)];
A=[A;-eye(nou),-eye(nou)];b=[b;zeros(nou,1)];

f=[zeros(nou,1);ones(nou,1)];

%more complex Umax argument/constraint
vub=[repmat(Umax,nou/3,1);2*repmat(Umax,nou/3,1)];
vlb=[-repmat(Umax,nou/3,1);zeros(nou,1)];

[sol,lam,how]=lgbt2(f,A,b,vlb,vub);

x_path=x_start;u_path=[];fuel=[];
if  ~isempty(findstr(how,'infeasible')), return;end
if  ~isempty(findstr(how,'unbounded')), return;end
u=sol(1:nou);
fuel=sum(abs(u));
for k=1:Np,
    up=u(3*k-2: 3*k);
    x_path=[x_path,(Ad1*x_path(:,end)+Bd1*up)];
    u_path=[u_path,up];
end

% testing 
if min(x_finish+1.1*Xm-x_path(:,end))<0 ||  max(-x_path(:,end)+x_finish-1.1*Xm)>0,
        disp('final contraint is violated');
end

umax=max(max(abs(u_path)));
if umax>1.1*Umax, disp('input contraint is violated');end