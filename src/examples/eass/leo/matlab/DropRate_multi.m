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

function [Rate]=DropRate_multi(U)
%Trival m-function to determine the pressure drop rate of n thrusters 
%within the associated Simulink model

%calculates 
%U(1)=num of thrusters
%U(2:x,1)=thruster activity in multiples of 3info bits:
% -venting line1 (1 for venting, 0 for not)
% -venting line2
% -thruster active (1 for active, 0 for not)

if U(1)~=((size(U,1)-1)/3)
    error('number of thrusters declared != thruster data being passed');
end

%define drop rates
NORM=-0.001;
VENT=-0.2;
DROP=[VENT,VENT,NORM];
%number of thrusters
TN=U(1);

%reform input to matrix
% [T1|T2|...|Tn]
info=U;info(1)=[];
InfoMat=reshape(info,3,TN);

%sum over all activity
InfoMat=sum(InfoMat,2);
Rate=DROP*InfoMat;