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

function CommunicateWithTagsMulti(in)
%Agent Framework file to perform automatic configuring of model block names 
%and conditional sending of information across socket.
%-Configuration for sending predicate information to Java agent.

verbose=0;
global clientsocket;
global PortNames;
global PortSizes;
global written;

if verbose, disp('entered communicate with tags');end

if (isempty(PortNames)) && (isempty(PortSizes)),
    %find current name of block being run
    MainBlock=find_system(find_system('type','block_diagram'),'Regexp', 'on','Name','Multiple');
    ModelBlock=strcat(MainBlock(1),'/StatePropagation/SatelliteControlAccel/TriggeredSendAgent/SendToAIL');
    %extact port names (ordered)
    Ports=find_system(ModelBlock,'regexp', 'on', 'blocktype', 'port');
    PortNames=get_param(Ports, 'Name');   
    %seqencially determine sizes of data ports
    for i=1:size(PortNames,1),
        if strcmp('',PortNames(i)), continue; end
        Part=strcat(ModelBlock,strcat('/',PortNames(i)));        
        Info=get_param(Part,'CompiledPortWidths');
        sizes(i,1)=Info{1,1}.Outport;
    end
    %remove null information in both store items
    PortSizes=sizes(sizes~=0);
    PortNames=PortNames(sizes~=0);
end

%data names and sizes known
%-associate relevant data
Data=mat2cell(in,PortSizes,1);

%communicate information to Java link sequentially
%send Data sequentially
%- format is 'name tag', number of data points, data, end subset
clientsocket.write('NEWDATA');
for i=1:size(PortNames,1),   
    tag=char(PortNames(i));
    clientsocket.write(tag);    
    num=num2str(PortSizes(i));
    clientsocket.write(num);    
    data=Data{i};
    for j=1:size(data),
        info=num2str(data(j));
        clientsocket.write(info);
    end
    %disp(sprintf('sent data stub: %s',tag));
    clientsocket.write('ENDSUBDATA');
end

if verbose, disp('shake'), disp(written);end
written = written + 1;
clientsocket.write('ENDDATA');