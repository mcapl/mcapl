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


function Accel=Hill2ECI(INPUT)
%This provides Hill to ECI conversion, required within the associated
%Simulink model.

%Function for calculating satellite control accelerations constant mass is 
%assumed constant Earth pointing face is assumed

%control is applied in radial direction, vertical z direction and
%along-track velocity direction.

%X is given in geocentric coordinates. Conversion between the satellite
%body frame and geocentric frame is completed by:
%   radial dir= (X,Y)dir
%   vertical dir= Z dir
%   along track dir = cross(radial dir,vertical dir)

%Inputs: [Body Accelerations(3,1);GeocentricPos(3,1);GeocentricVel(3,1)];
%outputs: Accel(3,1) in geocentric frame

Thrust=INPUT(1:3)';
Pos=INPUT(4:6);
Vel=INPUT(7:9);
[RIC,Beta]=FormRIC(Pos,Vel);
%convert body centered thrust to geocentric coords
Accel=(Beta)'*Thrust'; %hill to ECI due to transpose of beta being used