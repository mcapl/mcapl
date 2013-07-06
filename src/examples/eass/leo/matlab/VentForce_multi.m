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

function Fvent=VentForce_multi(U)

%Function to prescribe force effect is line has ruptured and is being
%supplied with gas (ie valve not shut off)

% U(1:2)=x line venting (top;bottom) logical 0=no
% U(3:4)=y line vent
% U(5:6)=z line vent
% U(7:8)= xyz line vent
Fvent=zeros(3,1);
for i=1:2:8,
    F=U(i)+U(i+1);
    %direction
    if (i==1), %xline        
        Fvent=Fvent+F.*[0.1;0.3;0.3];        
    elseif (i==3), %yline
        Fvent=Fvent+F.*[0.3;0.1;0.3]; 
    elseif (i==5),%zline
        Fvent=Fvent+F.*[0.3;0.3;0.1]; 
    elseif (i==6),%xyz line
        Fvent=Fvent+F.*[0.3;0.3;0.3]; 
    end
end
   
