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


function [PlanMsg,Forces,Reset]=follow_path_multi(aname,PlanName,Hill_e,Hill_dot,Time,Fmax)
%Function to follow an existing path via feedback methods
%
%Inputs:
%
%Path           =String, path to be followed
%Hill_e(6,1)    =Current measured hill error (m & m/s)
%Hill_dot(6,1)  =Measured hill derrivative   (m & m/s)
%Fmax(3,1)      =Thrust saturation (Newtons)

%Outputs:
%
%PlanMsg(1,1)   =Running plan message (1=yes;0=not)
%Forces(3,1)    =Output forces (x,y,z) (Newtons)
%Reset(1,1)     =reset indication for end (1=yes;0=not)

%load globals to be used here & load plan
global ClusterMemory;

type=1;

% Selectively load in desired plan to CurrentPlan.ClosedLoop and
% PlanMemory.ClosedLoop
pname=sprintf(PlanName);
if ~isfield(ClusterMemory.(aname),'PlanMemory') || ~isfield(ClusterMemory.(aname).PlanMemory.ClosedLoop,(pname)), 
    display(['-->',aname,': Loading path ',PlanName]);
    A=load(PlanName);
    TrackPath=A.PlanAIL.Path;
    TrackPath(4:6,:)=zeros(3,size(TrackPath,2));
    ExtendedPath=ExtendedTrack(aname,TrackPath);
    ClusterMemory.(aname).PlanMemory.ClosedLoop.(pname).content=ExtendedPath;          %the path to follow
    ClusterMemory.(aname).PlanMemory.ClosedLoop.(pname).status='active';               %status
    ClusterMemory.(aname).PlanMemory.ClosedLoop.(pname).startpoint=ExtendedPath(:,1);  %initial state
    ClusterMemory.(aname).PlanMemory.ClosedLoop.(pname).endpoint=ExtendedPath(:,end);  %final state
    ClusterMemory.(aname).PlanMemory.ClosedLoop.(pname).TotalPoints=size(ExtendedPath,2);
    
    ClusterMemory.(aname).CurrentPlan.ClosedLoop.name=pname;                           %plan to manipulate
    ClusterMemory.(aname).CurrentPlan.ClosedLoop.content=ExtendedPath;
    ClusterMemory.(aname).CurrentPlan.ClosedLoop.TotalPoints=size(ExtendedPath,2);
    ClusterMemory.(aname).CurrentPlan.ClosedLoop.PointsPassed=0;
    ClusterMemory.(aname).CurrentPlan.ClosedLoop.ReachedLast='no'; 
    %need to save the planmemory for reading by continuous engine but also
    %want to always overwrite the plan!
    %save('ClusterMemory','ClusterMemory');
elseif isfield(ClusterMemory.(aname).PlanMemory.ClosedLoop,(pname)) && ~strcmp(ClusterMemory.(aname).CurrentPlan.ClosedLoop.name,pname),
    ClusterMemory.(aname).CurrentPlan.ClosedLoop.content=PlanMemory.ClosedLoop.(pname).content;      %reload existing plan
    display(['-->',aname,': Loading existing path',PlanName]);
end    


%% Determine part of plan to run and return [PlanMsg,Forces,Reset]

%-following path within CurrentPlan.ClosedLoop(name/content)
%-point is considered reached when state is within bound given within M.PathBounding(2,1)
%-path is of the form [xyz;xyz_dot, ...., xyz;xyz_dot]
%-will seek first column until empty

%remove if considered 'reached'
if ~isempty(ClusterMemory.(aname).CurrentPlan.ClosedLoop.content),
    %do not remove final reaching point
    if (size(ClusterMemory.(aname).CurrentPlan.ClosedLoop.content,2)==1) && (strcmp(ClusterMemory.(aname).CurrentPlan.ClosedLoop.ReachedLast,'no')) ,
        px=ClusterMemory.(aname).CurrentPlan.ClosedLoop.content(1,1);
        py=ClusterMemory.(aname).CurrentPlan.ClosedLoop.content(2,1);
        pz=ClusterMemory.(aname).CurrentPlan.ClosedLoop.content(3,1);
        display(sprintf('-->%s: Maintaining final path point [%1.1f,%1.1f,%1.1f]',(aname),px,py,pz));
        ClusterMemory.(aname).CurrentPlan.ClosedLoop.ReachedLast='yes';
    elseif (size(ClusterMemory.(aname).CurrentPlan.ClosedLoop.content,2)==1) && (strcmp(ClusterMemory.(aname).CurrentPlan.ClosedLoop.ReachedLast,'yes')),
        %do nothing, in a refactor, this should be a switch case expression
    else    
        current_bound=[norm(Hill_e(1:3)-ClusterMemory.(aname).CurrentPlan.ClosedLoop.content(1:3,1));norm(Hill_e(4:6)-ClusterMemory.(aname).CurrentPlan.ClosedLoop.content(4:6,1))];
        if current_bound(1)<=ClusterMemory.(aname).PathBounding(1) && current_bound(2)<=ClusterMemory.(aname).PathBounding(2) && strcmp(ClusterMemory.(aname).ControlType,'path'),
            ClusterMemory.(aname).CurrentPlan.ClosedLoop.content(:,1)=[];
            ClusterMemory.(aname).CurrentPlan.ClosedLoop.PointsPassed=ClusterMemory.(aname).CurrentPlan.ClosedLoop.PointsPassed+1;            
            if mod(ClusterMemory.(aname).CurrentPlan.ClosedLoop.PointsPassed,20)==0,
                TotP=ClusterMemory.(aname).CurrentPlan.ClosedLoop.TotalPoints;
                PoiP=ClusterMemory.(aname).CurrentPlan.ClosedLoop.PointsPassed;
                display(sprintf('--> %s: Point %3.0f of %3.0f on state path passed...',(aname),PoiP,TotP));
            end
        end
    end
end

%look for force to apply
if (isempty(ClusterMemory.(aname).CurrentPlan.ClosedLoop.content) || (strcmp(ClusterMemory.(aname).PlanMemory.ClosedLoop.(pname).status,'complete')==1)) && strcmp(ClusterMemory.(aname).ControlType,'path'),
    %have completed plan
    ClusterMemory.(aname).PlanMemory.ClosedLoop.(pname).status='complete';
    Forces=[0;0;0];
    PlanMsg=0;
    Reset=1;
    display(['-->',aname,': Completed following of path: ',PlanName]);
    display(['-->',aname,': I am currently drifting!!']);
    ClusterMemory.(aname).ControlType='NullOutput';
elseif (isempty(ClusterMemory.(aname).CurrentPlan.ClosedLoop.content) || (strcmp(ClusterMemory.(aname).PlanMemory.ClosedLoop.(pname).status,'complete')==1)) && strcmp(ClusterMemory.(aname).ControlType,'NullOutput'),
    %plan completed and output drifting message to console
    Forces=[0;0;0];PlanMsg=0;Reset=1;    
else %plan remains
    if ~strcmp(ClusterMemory.(aname).ControlType,'path'),
        ClusterMemory.(aname).ControlType='path';
        display(['-->',aname,': Following path ',PlanName]);
    end
    TrackPoint=ClusterMemory.(aname).CurrentPlan.ClosedLoop.content(:,1);
    
    if type==1,
    %Sliding Mode Control
        Forces=run_smc_follow(aname,TrackPoint,Hill_e,Hill_dot,Fmax);
        %Forces=run_smcXYZ_multi(HillError,HillDerivative,Fmax,aname);
    elseif type==2
    %Full state feedback via pole placement:
        Forces=FSFB_multi(aname,TrackPoint,Hill_e); 
    else
    %Universal Adaptive Control
        Forces=UAC(TrackPoint,Hill_e);
    end
    PlanMsg=1;
    Reset=0;
end


% %% Inbuilt functions
% 
function FilledTrack=ExtendedTrack(aname,Track)
%bridge state track to smooth reference trajectory
TempTrack=Track;i=2;
FilledTrack=TempTrack;
global ClusterMemory;
display(['-->',aname,': Interpolating optimal path']);
while max(max(abs(diff(TempTrack,1,2)),[],2))>=ClusterMemory.(aname).PathBounding(1),
    TempTrack=interpm(Track,[1 i],'cubic');
    FilledTrack=TempTrack;
    i=i+1;
end

%end %end function ExtendedTrack
