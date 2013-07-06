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

function StatePath=FuturePath(t,State,Om)
%Function to calculate path of satellite agent over period of time [t] 
%starting with state [STATE].
%-Returns temporally signed state path [StatePath] which is of the form
%[t;State,....t_fin;State_fin]
%-Based on continuous time propogation in the Hill regime and unforced
%(gravity only) dynamics


%form options set (set tollerances)
tspan = linspace(0,t,ceil(t)); % t0 = 0; tf = 10, nsteps = 100; 
X0=State;
%options=odeset('RelTol',1e-3); 
y = ode4('HillMotion',tspan,X0,Om);
%StatePath=[t';X'];
StatePath=[tspan;y'];