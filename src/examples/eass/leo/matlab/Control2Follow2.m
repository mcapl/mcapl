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


function OutPut=Control2Follow2(u)
%Function to selct appropriate plan based upon string name passed through
%Simulink as uint8 
%u(30,1) = [old control type; new control type];
%old control type(15:1) = uint8 assigned char 
%new control type(15:1) = uint8 assigned char
%                       = zeros if no change
%                       = named control type if change (padded with ones)
%u(1:17)  = current plan
%u(18:34) = new plan format

if u(18)==0,
    OutPut=u(1:17);
else
    OutPut=u(18:34);
end  