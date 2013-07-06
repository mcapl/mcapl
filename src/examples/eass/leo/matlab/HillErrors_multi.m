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


function Output=HillErrors_multi(U)
%Trival m-function to convert from geocentric coordinates to give Hill 
%Based Errors
%U=[PosAgent,VelAgent,PosLead,Vellead];

%note input distances are in km's
%output is in meters

%Extract
PosA=U(1:3);  %geocentric agent position (km)
VelA=U(4:6);  %geocentric agent velocity (km/s)   
PosL=U(7:9);  %geocentric lead agent position (km) 
VelL=U(10:12);%geocentric lead agent velocity (km/s)   

%Find error between lead and agent
%Error between agent location and lead agent (relative distance)
Rho=PosA-PosL;      %geocentric relative distance (wrt lead) [Rho in literature]
RhoM=norm(Rho);     %magnitude of rho
RhoDot=VelA-VelL;   %geocentric relative vel                  [Rho dot in literature]

%Determine Hill components from geocentric data
%determine conversion matrix
[RIC,Beta]=FormRIC(PosL,VelL);
%use!!
HillPos=Beta*(Rho);
HillVel=Beta*(RhoDot);

%concantenate and convert to meters
Output=1000*[RhoM;HillPos;HillVel];