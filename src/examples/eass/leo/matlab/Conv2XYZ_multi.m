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


function Fout=Conv2XYZ_multi(U)

%Converts the input forces to xyz body forces for specified spacecraft
% -based on implementation of substitute thruster which is oriented by
% theta, phi wrt satellite body hence has component forces in xyz to be
% combined with existing (working) thrusters
%
%U=force input [x(1,1),y(1,1),z(1,1),xyz(1,1)]
%U(end)=agent number


global ClusterMemory;

aname=sprintf('Agent%d',U(5));

Fx=U(1);Fy=U(2);Fz=U(3);Fxyz=U(4);

Fx2=Fxyz*cos(ClusterMemory.(aname).theta)*cos(ClusterMemory.(aname).phi);
Fy2=Fxyz*sin(ClusterMemory.(aname).theta);
Fz2=Fxyz*cos(ClusterMemory.(aname).theta)*sin(ClusterMemory.(aname).phi);

Fout=[Fx+Fx2;Fy+Fy2;Fz+Fz2];