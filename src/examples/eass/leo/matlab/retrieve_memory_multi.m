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

%Script to provide agent 'memory' relating to desired orbital attributes
%and internal properties (mass etc)

function M=retrieve_memory_multi(N)

M.AgentMass=20;         %agent mass (kg)
M.InnerBound=100;       %inner bound for regional information (m)
M.ThrustSaturation=10;  %max thruster output (N)
M.StartAltitude=400;    %starting altitude in km
M.StartEcentricity=0;   %starting ecentricity (deg)
M.LeadAgentGeocentric=[6778;0;0]; %lead agent geocentric position


%useful constants
M.muE=398600.4418;      %km3/s^2
M.Erad=6378;            %Earth radius in km
M.RefOrbitVelocity=sqrt(M.muE/(M.Erad+M.StartAltitude));

%thruster considerations
M.ThrusterUse=[1;1;1;0];
M.ThrusterGains=ones(4,1);
M.theta=45*pi/180;
M.phi=45*pi/180;

M.Tswitch=10;           %switching time for plan motion

%group issues
M.GroupSize=N;

%plan
M.AgentPlan=[];

M.ControlType='drifting';

M.PathBounding=[0.5;0.4];   %path following bound [m;m/s] norm

%SMC control gains
M.Kp=10;
M.Kv=5;
M.alpha=21;
M.CurrentState=zeros(6,1);
M.MaintainStateHM=zeros(6,1);
M.ResetMaintain=1;

%variable structure control gains
M.VSMRACalpha=1e-8;
M.VSMRACepsilon=1e-4;
M.VSMRAC_g0=0;
M.VSMRAC_g1=0;
M.VSMRAClambda=0.01;
M.VSMRACeta=0.01;
M.VSMRCforce=zeros(3,1);
M.VSMRCstate=[];

%universal adaptive control gains
M.UACk=0.01;
M.UACepsilon=0.01;
M.UACbeta=0.01;

M.FSFBgain=[];

M.CurrentPlan=[];
M.StartTime=[];
M.Reset=[];
