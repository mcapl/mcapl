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

function VC = ThrusterData(U)
%determine and output voltage and current based upon input value U
%U=[SC;T;F];
%SC=ShortCircuit present on grid?yes==1, no ==2;
%T=thruster on? yes==2,no==1;
%F=feed pressure? yes>0;

SC=U(1);
T=U(2);
F=U(3);

%no propellant no SC, thruster on
if (F<1) && (SC==2) && (T==2)
    V=1500;
    I=0;

%no propellant no SC, thruster off
elseif (F<1) && (SC==2) && (T==1)
    V=0;
    I=0;    
      
%propellant, no SC, thruster on
elseif (F>0) && (SC==2) && (T==2)
    V=1500;
    I=0.1;

%propellant, no SC, thruster off
elseif (F>0) && (SC==2) && (T==1)
    V=0;
    I=0;

    
%short circuit, thruster on
elseif (SC==1) && (T==2)
    V=0.5;
    I=1;
    
%short circuit, thruster off
elseif (SC==1) && (T==1)
    V=0;
    I=0;
    
else
    V=0;I=0;
end

VC=[V;I];