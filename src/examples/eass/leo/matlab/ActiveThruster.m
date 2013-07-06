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


function AT = ActiveThruster(U)
%Trival m-function to determine if thruster within Simulink model is 
%outputting thrust within associated Simulink model
%
%U=[SC;T;F];
%SC=ShortCircuit present on grid?yes==1, no ==2;
%T=thruster on? yes==2,no==1;
%F=feed pressure? yes>0;

SC=U(1);
T=U(2);
F=U(3);

%condition to be active:
if (SC==2) && (T==2) && (F>0)
    AT=1;
else
    AT=0;
end