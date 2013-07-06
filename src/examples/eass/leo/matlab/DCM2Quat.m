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

function Quat=DCM2Quat(DCM)
%Converts DCM to quaternion

Quat=zeros(4,1);
d=diag(DCM);
%conditionally calculate quaternion based upon max value within DCM
%diagonal (prevent numerical instability)

tr=trace(DCM);
if tr>0,
    Quat(4,1)=0.5*sqrt(1+tr);
    Quat(1,1)=0.25*(DCM(2,3)-DCM(3,2))/Quat(4,1);
    Quat(2,1)=0.25*(DCM(3,1)-DCM(1,3))/Quat(4,1);
    Quat(3,1)=0.25*(DCM(1,2)-DCM(2,1))/Quat(4,1);    
    
elseif((d(2) > d(1)) && (d(2) > d(3)))
% max value at dcm(2,2)
    Quat(2,1)=0.5*sqrt(1+DCM(2,2)-DCM(1,1)-DCM(3,3));
    Quat(1,1)=0.25*(DCM(1,2)+DCM(2,1))/Quat(2,1);
    Quat(3,1)=0.25*(DCM(2,3)+DCM(3,2))/Quat(2,1);
    Quat(4,1)=0.25*(DCM(3,1)-DCM(1,3))/Quat(2,1);  

elseif (d(3) > d(1))
% max value at dcm(3,3)  
    Quat(3,1)=0.5*sqrt(1+DCM(3,3)-DCM(1,1)-DCM(2,2));
    Quat(1,1)=0.25*(DCM(1,3)+DCM(3,1))/Quat(3,1);
    Quat(2,1)=0.25*(DCM(2,3)+DCM(3,2))/Quat(3,1);
    Quat(4,1)=0.25*(DCM(1,2)-DCM(2,1))/Quat(3,1); 

else
% max value at dcm(1,1)
    Quat(1,1)=0.5*sqrt(1+DCM(1,1)-DCM(3,3)-DCM(2,2));
    Quat(2,1)=0.25*(DCM(1,2)+DCM(2,1))/Quat(1,1);
    Quat(3,1)=0.25*(DCM(1,3)+DCM(3,1))/Quat(1,1);
    Quat(4,1)=0.25*(DCM(2,3)+DCM(3,2))/Quat(1,1);
end