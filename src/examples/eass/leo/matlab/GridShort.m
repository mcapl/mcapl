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


function Short=GridShort(u)
%Trival m-function to provide a short in the grid based upon the 'reliability' of the
%thruster within the associated Simulink model. Less reliable, more prone to shorting
%
%u(1)=reliability factor 1=reliable, 0=not.
%u(2)=current status (ie short or no short)

%output:
% -Short circuit=1
% -No short=0

if u(2)==1, %if already short circuited, return short circuit
    Short=1; 
elseif (u(2)==2) && (u(1)~=1), %no short, unreliable
    dice=rand+0.3;%roll dice!
    if dice<=0.5,
        Short=1; %short
    else
        Short=0;
    end
    
else %final case is no short, reliable  
    dice=rand+0.6;%roll dice!
    if dice<=0.5,
        Short=1; %short
    else
        Short=0;
    end
end 