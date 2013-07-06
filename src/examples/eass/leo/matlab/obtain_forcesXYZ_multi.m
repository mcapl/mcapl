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

function [OutPut]=obtain_forcesXYZ_multi(U)
%Selective output of control forces within associated Simulink model
% -modified from obtain_forces to permit cross coupled actuation
%when using substitute thruster
%
% U(33,1)           =[ControlType(15,1);StateInfo(12,1);Time(1,1);ThrusterUsage(4,1);AgentNumber(1,1)]
% ControlType(15,1) =uint8 transformed char
% StateInfo(16:21,1)=Hill Errors (pos,vel)
% Hill derivative(22:27,1)
% Time(28,1)         =current simulation time
% ThrusterUsage(29:32,1)  =thrusters active [1=active,0=inactive]
% Agent(33,1)       =Agent number designation
%
% OutPut(4,1)       =[PlanMsg;Forces]
% PlanMsg(1,1)      =0 plan not running
%                   =1 plan running
% Forces(3,1)       =output forces

%extract data
%-control type
C=U(1:17);
CC=C(C~=1);%remove ones padding
ControlType=char(CC)';
%-state info
HillError=U(18:23);
HillDerivative=U(24:29);
%-operational info:
TU=U(31:34);
TimeNow=U(30);
AgentNumber=U(35);

global ClusterMemory;
aname=sprintf('Agent%d',AgentNumber);


%Evaluate operational thrusters and maximum thrust output
F0=ClusterMemory.(aname).ThrustSaturation;
if TU(4)==1, %XYZ thruster being used
   Fxyz=[F0*cos(M.theta)*cos(M.phi);F0*sin(M.theta);F0*cos(M.theta)*sin(M.phi)];
   Fmax=min(Fxyz);
else
   Fmax=F0; 
end
%Conditionally use control type requested
if strcmp(ControlType,'NullOutput'),
    Forces=zeros(3,1);
    PlanMsg=0;
    ClusterMemory.(aname).Reset=1;
    ClusterMemory.(aname).ResetMaintain=1;
elseif strcmp(ControlType,'Maintain'),
    PlanMsg=0;ClusterMemory.(aname).Reset=1;
    %check to see if this is being newly activated and assign new maintain
    %location if relevant
    if ClusterMemory.(aname).ResetMaintain==1,
        ClusterMemory.(aname).MaintainStateHE=HillError;
        ClusterMemory.(aname).ResetMaintain=0;
        display(sprintf('==>%s: Commencing position maintenance at [%3.1f,%3.1f,%3.1f]', (aname),HillError(1),HillError(2),HillError(3)));
    end
    Forces=run_smcXYZ_multi(HillError,HillDerivative,Fmax,aname);    
elseif strfind(ControlType,'Follow'),
    ClusterMemory.(aname).ResetMaintain=1;
    %request to follow path (Follow PlanAIL@)
    if isempty(ClusterMemory.(aname).Reset) || ClusterMemory.(aname).Reset==1,
        ClusterMemory.(aname).StartTime=TimeNow;
        ClusterMemory.(aname).Reset=0;
    end   
    %strip out Follow_
    Path=ControlType(8:end);
    [PlanMsg,Forces,ClusterMemory.(aname).Reset]=follow_path_multi(aname,Path,HillError,HillDerivative,TimeNow,Fmax);
else 
    %request to follow openloop plan
    if ~isfield(ClusterMemory.(aname),'ActivePlan') || ~strcmp(ClusterMemory.(aname).ActivePlan,ControlType),
        ClusterMemory.(aname).Reset=1;
    end
    
    if isempty(ClusterMemory.(aname).Reset) || ClusterMemory.(aname).Reset==1,
        ClusterMemory.(aname).StartTime=TimeNow;
        ClusterMemory.(aname).Reset=0;
        ClusterMemory.(aname).ActivePlan=[];
    end

    [PlanMsg,Forces,ClusterMemory.(aname).Reset]=run_sequence_multi(ControlType,TimeNow,ClusterMemory.(aname).StartTime,AgentNumber);
    
end

%Evaluate desired output based upon available thrusters
Tmat=[diag(TU(1:3));
TU(4)*cos(ClusterMemory.(aname).theta)*cos(ClusterMemory.(aname).phi),TU(4)*sin(ClusterMemory.(aname).theta),TU(4)*cos(ClusterMemory.(aname).theta)*sin(ClusterMemory.(aname).phi)];
Tsignal=Forces'*pinv(double(Tmat));
OutPut=[PlanMsg;Forces;Tsignal'];