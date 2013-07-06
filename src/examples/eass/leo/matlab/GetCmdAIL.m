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

function INFO=GetCmdAIL(u)
% Agent Framework file for setting control actions as specified from AIL
% command passed via socket communications.
% INFO(n,1)= task information taken from Java side to be implemented
% INFO(i,:)=0 if no action
% INTO(i,:)~=0 relates to a particular action

%ensure global socket available
global clientsocket;

INFO=zeros(u,1);
%check for message:
if clientsocket.ready()==0,             %nothing waiting
    return
else                                    %cmd waiting- read lines and assign as appropriate
    %INFO=zeros(6,1);
    ToDo=char(clientsocket.readLine()); %what to do? (do task/run mfile)
    
    if strcmpi(ToDo,'RUNTASK'),
        %find name of task
        Task=char(clientsocket.readLine());
%% Agent 1            
        if strcmpi(Task,'a1set_control'),
            %num of args required for process
            args=str2num(clientsocket.readLine());
            for i=1:args,
                INFO(1:17)=ones(17,1);
                bit=char(clientsocket.readLine()); %read char and convert to uint8
                Bit=uint8(bit)';
                INFO(i:size(Bit,1),1)=(Bit);
            end
            %reply requirement
            reply=str2num(clientsocket.readLine());
        elseif strcmpi(Task,'A1set_x1_valves'),
            %num of args required for process
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'on'),
                    INFO(i+17,1)=2;
                else
                    INFO(i+17,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
        elseif strcmpi(Task,'A1set_x1_main'),
            %num of args required for process
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'on'),
                    INFO(i+ 21,1)=2;
                else
                    INFO(i+21,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
        elseif strcmpi(Task,'A1set_y_valves'),
            %num of args required for process
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'on'),
                    INFO(i+22,1)=2;
                else
                    INFO(i+22,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
        elseif strcmpi(Task,'A1set_y_main'),
            %num of args required for process
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'on'),
                    INFO(i+26,1)=2;
                else
                    INFO(i+26,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine()); 
        elseif strcmpi(Task,'A1set_z_valves'),
            %num of args required for process
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'on'),
                    INFO(i+27,1)=2;
                else
                    INFO(i+27,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
        elseif strcmpi(Task,'A1set_z_main'),
            %num of args required for process
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'on'),
                    INFO(i+31,1)=2;
                else
                    INFO(i+31,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
        elseif strcmpi(Task,'A1set_xyz_valves'),
            %num of args required for process
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'on'),
                    INFO(i+32,1)=2;
                else
                    INFO(i+32,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
        elseif strcmpi(Task,'A1set_xyz_main'),
            %num of args required for process
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'on'),
                    INFO(i+36,1)=2;
                else
                    INFO(i+36,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
        elseif strcmpi(Task,'A1UseX'),
            %num of args required for process
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'yes'),
                    INFO(i+37,1)=2;
                else
                    INFO(i+37,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
        elseif strcmpi(Task,'A1UseY'),
            %num of args required for process
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'yes'),
                    INFO(i+38,1)=2;
                else
                    INFO(i+38,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
        elseif strcmpi(Task,'A1UseZ'),
            %num of args required for process
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'yes'),
                    INFO(i+39,1)=2;
                else
                    INFO(i+39,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
        elseif strcmpi(Task,'A1UseXYZ'),
            %num of args required for process
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'yes'),
                    INFO(i+40,1)=2;
                else
                    INFO(i+40,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
%% Agent 2
        elseif strcmpi(Task,'a2set_control'),
            %num of args required for process
            args=str2num(clientsocket.readLine());
            for i=1:args,
                INFO(42:58)=ones(17,1);
                bit=char(clientsocket.readLine()); %read char and convert to uint8
                Bit=uint8(bit)';
                INFO(41+i:41+size(Bit,1),1)=(Bit);
            end
            %reply requirement
            reply=str2num(clientsocket.readLine());         
        elseif strcmpi(Task,'A2set_x1_valves'),
            %num of args required for process (4)
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'on'),
                    INFO(i+58,1)=2;
                else
                    INFO(i+58,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
        elseif strcmpi(Task,'A2set_x1_main'),
            %num of args required for process (1)
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'on'),
                    INFO(i+62,1)=2;
                else
                    INFO(i+62,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
        elseif strcmpi(Task,'A2set_y_valves'),
            %num of args required for process (4)
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'on'),
                    INFO(i+63,1)=2;
                else
                    INFO(i+63,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
        elseif strcmpi(Task,'A2set_y_main'),
            %num of args required for process (1)
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'on'),
                    INFO(i+67,1)=2;
                else
                    INFO(i+67,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine()); 
        elseif strcmpi(Task,'A2set_z_valves'),
            %num of args required for process (4)
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'on'),
                    INFO(i+68,1)=2;
                else
                    INFO(i+68,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
        elseif strcmpi(Task,'A2set_z_main'),
            %num of args required for process (1)
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'on'),
                    INFO(i+72,1)=2;
                else
                    INFO(i+72,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
        elseif strcmpi(Task,'A2set_xyz_valves'),
            %num of args required for process (4)
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'on'),
                    INFO(i+73,1)=2;
                else
                    INFO(i+73,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
        elseif strcmpi(Task,'A2set_xyz_main'),
            %num of args required for process (1)
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'on'),
                    INFO(i+77,1)=2;
                else
                    INFO(i+77,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
        elseif strcmpi(Task,'A2UseX'),
            %num of args required for process (1)
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'yes'),
                    INFO(i+78,1)=2;
                else
                    INFO(i+78,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
        elseif strcmpi(Task,'A2UseY'),
            %num of args required for process (1)
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'yes'),
                    INFO(i+79,1)=2;
                else
                    INFO(i+79,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
        elseif strcmpi(Task,'A2UseZ'),
            %num of args required for process (1)
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'yes'),
                    INFO(i+80,1)=2;
                else
                    INFO(i+80,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
        elseif strcmpi(Task,'A2UseXYZ'),
            %num of args required for process (1)
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'yes'),
                    INFO(i+81,1)=2;
                else
                    INFO(i+81,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
%% Agent 3
        elseif strcmpi(Task,'a3set_control'),
            %num of args required for process (15)
            args=str2num(clientsocket.readLine());
            for i=1:args,
                INFO(83:99)=ones(17,1);
                bit=char(clientsocket.readLine()); %read char and convert to uint8
                Bit=uint8(bit)';
                INFO(82+i:82+size(Bit,1),1)=(Bit); %care in location!!
            end
            %reply requirement
            reply=str2num(clientsocket.readLine());         
        elseif strcmpi(Task,'A3set_x1_valves'),
            %num of args required for process (4)
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'on'),
                    INFO(i+99,1)=2;
                else
                    INFO(i+99,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
        elseif strcmpi(Task,'A3set_x1_main'),
            %num of args required for process (1)
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'on'),
                    INFO(i+103,1)=2;
                else
                    INFO(i+103,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
        elseif strcmpi(Task,'A3set_y_valves'),
            %num of args required for process (4)
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'on'),
                    INFO(i+104,1)=2;
                else
                    INFO(i+104,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
        elseif strcmpi(Task,'A3set_y_main'),
            %num of args required for process (1)
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'on'),
                    INFO(i+108,1)=2;
                else
                    INFO(i+108,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine()); 
        elseif strcmpi(Task,'A3set_z_valves'),
            %num of args required for process (4)
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'on'),
                    INFO(i+109,1)=2;
                else
                    INFO(i+109,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
        elseif strcmpi(Task,'A3set_z_main'),
            %num of args required for process (1)
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'on'),
                    INFO(i+113,1)=2;
                else
                    INFO(i+113,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
        elseif strcmpi(Task,'A3set_xyz_valves'),
            %num of args required for process (4)
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'on'),
                    INFO(i+114,1)=2;
                else
                    INFO(i+114,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
        elseif strcmpi(Task,'A3set_xyz_main'),
            %num of args required for process (1)
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'on'),
                    INFO(i+118,1)=2;
                else
                    INFO(i+118,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
        elseif strcmpi(Task,'A3UseX'),
            %num of args required for process (1)
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'yes'),
                    INFO(i+119,1)=2;
                else
                    INFO(i+119,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
        elseif strcmpi(Task,'A3UseY'),
            %num of args required for process (1)
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'yes'),
                    INFO(i+120,1)=2;
                else
                    INFO(i+120,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
        elseif strcmpi(Task,'A3UseZ'),
            %num of args required for process (1)
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'yes'),
                    INFO(i+121,1)=2;
                else
                    INFO(i+121,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
        elseif strcmpi(Task,'A3UseXYZ'),
            %num of args required for process (1)
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'yes'),
                    INFO(i+122,1)=2;
                else
                    INFO(i+122,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
%% Set 'lead' Agent
        elseif strcmpi(Task,'SetLead'),
            %num of args required for process (1)
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                INFO(i+123,1)=bit;
            end
            reply=str2num(clientsocket.readLine());
            
%% Test Break lines
        elseif strcmpi(Task,'A1Break'),
            %num of args required for process
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'yes'),
                    INFO(i+124,1)=2;
                else
                    INFO(i+124,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
        elseif strcmpi(Task,'A2Break'),
            %num of args required for process
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'yes'),
                    INFO(i+125,1)=2;
                else
                    INFO(i+125,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());
        elseif strcmpi(Task,'A3Break'),
            %num of args required for process
            args=str2num(clientsocket.readLine());
            for i=1:args,
                bit=char(clientsocket.readLine());
                if strcmpi(bit,'yes'),
                    INFO(i+126,1)=2;
                else
                    INFO(i+126,1)=1;
                end
            end
            reply=str2num(clientsocket.readLine());

%% End 
        else
            return
        end 
    end
end