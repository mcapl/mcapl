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

function RunRequestAIL_Internal(u)
%Agent Framework file to run generic AIL requests within Matlab
% -looks for request
% -reads request
% -deals with request
%Pertinent information is extracted internally, only the calling agent is
%known; MINIMAL info is passed from agent

%u=socket port number for AIL
%defined under MatlabSocket
global MatlabSocket;

%look for request
% - if none, wait.
% -if request read in and deal with it
if MatlabSocket.ready()==0,
    %no cmd waiting
    pause(0.001);
    return
else
    %task waiting- read lines and assign as appropriate
    % -know that next readline will ask for an mfile to be called
    scrap=MatlabSocket.readLine(); 
    TASK= char(MatlabSocket.readLine());             %task is the mfile to be run
    % -inform user task being run
    display(sprintf('=>Running Task: %s', TASK));
    % -number of args
    args= MatlabSocket.readLine();
    % -get the agent (arguments)
    Args=str2num(args);
    for i=1:Args,
            bit= MatlabSocket.readLine();
            Bit=str2num(bit);
            Vals(i,1)=Bit;
    end
    % -what is to be returned?
    Return2AIL=str2num(MatlabSocket.readLine());
    % -run requested mfile (here Vals is [agent number; other stuff])
    OUTPUT=feval(TASK,Vals);    
    if Return2AIL>0,
        if ischar(OUTPUT),
            MatlabSocket.write(OUTPUT);
        else
            MatlabSocket.write(num2str(OUTPUT));
        end
    end      
end