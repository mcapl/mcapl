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

function OrbitalState=StartIdeal(U)
%Function to output orbital initial state for given altitude and eccentricity
%U(2,1)=[altitude(km), eccentricity(deg)
%
%OrbitalState(6,1)=[Pos(3,1),Vel(3,1)]


%Based upon vis-visa integral and orbital energy eqns 
%-S/C Systems Eng p80&82, eqns 4.5 &4.11
%-Fortescue and Stark
muE=398600.4418; %km3/s^2
Erad=6378; %Earth radius in km
Pos=[U(1)+Erad;0;0];
VelMag=sqrt(muE/Pos(1));
VelZ=-VelMag*sin(U(2)*pi/180);%-ve as assume northern hemisphere launch
VelY=VelMag*cos(U(2)*pi/180);
OrbitalState=[Pos;0;VelY;VelZ];