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

function Qsat=SatOrient(INPUT)
%Function for calculating satellite orientation to have
%constant Earth pointing face 

%X is given in geocentric coordinates. Conversion between the satellite
%body frame and geocentric frame is completed by:
%   radial dir= (X,Y)dir
%   vertical dir= Z dir
%   along track dir = cross(radial dir,vertical dir)

Pos=INPUT(1:3);
Vel=INPUT(4:6);
[RIC,Beta]=FormRIC(Pos,Vel);
%Beta is dir cosine matrix
%-convert to quat
Qsat=DCM2Quat(Beta);