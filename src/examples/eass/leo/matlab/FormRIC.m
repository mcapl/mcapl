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

function [RIC,Beta] =FormRIC(Pos,Vel)
%function to form RIC coordinate structure based upon ECI data specified
%within Pos(3,1) and Vel (3,1)

Rbar=Pos/norm(Pos);                         %Direction vector radially outwards
Cbar=cross(Pos,Vel)/norm(cross(Pos,Vel));   %Direction vector vertical
Ibar=cross(Cbar,Rbar);                      %Orthogonal completion
%test=Vel/norm(Vel); differnt way of obtaining same Ibar

RIC=[Rbar,Ibar,Cbar]*ones(3,1);
Beta=[Rbar';Ibar';Cbar']; 

%Beta here is Beta^{ECI}_{Hill}
%Hill=Beta*[geocentric]
%geocentric=Beta'*[Hill]