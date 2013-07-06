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

function CommunicateWithCont(in)
%Agent Framework file to perform automatic configuring of model block names 
%and conditional sending of information across socket to the Continuos
%Engine

verbose=0;
global Phys2Cont;
global ContPortNames;
global ContPortSizes;
global ClusterMemory;

%condintionally setup data entries
if (isempty(ContPortNames)) && (isempty(ContPortSizes)),
    %find current name of block being run
    MainBlock=find_system(find_system('type','block_diagram'),'Regexp', 'on','Name','Multiple');
    ModelBlock=strcat(MainBlock(1),'/StatePropagation/SatelliteControlAccel/TriggeredSendCont/SendToCont');
    %extact port names (ordered)
    Ports=find_system(ModelBlock,'regexp', 'on', 'blocktype', 'port');
    ContPortNames=get_param(Ports, 'Name');
    %seqencially determine sizes of data ports
    for i=1:size(ContPortNames,1),
        if strcmp('',ContPortNames(i)), continue; end
        Part=strcat(ModelBlock,strcat('/',ContPortNames(i)));        
        Info=get_param(Part,'CompiledPortWidths');
        sizes(i,1)=Info{1,1}.Outport;
    end
    %remove null information in both store items
    ContPortSizes=sizes(sizes~=0);
    ContPortNames=ContPortNames(sizes~=0);
    if verbose, 
        disp('Data input ports configured');
    end
end

%only run if there is a request for data:
if Phys2Cont.ready(),
    %data names and sizes known
    %-associate relevant data
    Data=mat2cell(in,ContPortSizes,1);
    %communicate requested information continuous
    %- may be Memory or Data
    request=Phys2Cont.readLine;   
    if strcmp(request,'Data'),
        if verbose, display('request for data item'); end
        req=Phys2Cont.readLine;
        DataBit=strmatch(req,ContPortNames); %match data request with available
        if isempty(DataBit), display('Request for non-existant data');            
            Phys2Cont.write('NEWDATA');
            num='1';
            Phys2Cont.write('Does not exist');
            Phys2Cont.write('ENDDATA');
            return;
        else
            Phys2Cont.write('NEWDATA'); 
            num=num2str(ContPortSizes(DataBit));
            data=Data{DataBit};            
            Phys2Cont.write(num);           %send # args followed by args
            for j=1:length(data),
                info=num2str(data(j));
                Phys2Cont.write(info);
            end
            Phys2Cont.write('ENDDATA');     %signal end
            return
        end
    elseif strcmp(request,'Memory'),
        if verbose, display('request for memory item');end
        %pass memory item
        info=Phys2Cont.readLine;    %particular memory bit desired        
        data=eval('base',info);     %assign memory bit 
        num=num2str(length(data));  %number of args the data entry has
        
        Phys2Cont.write('NEWDATA');
        Phys2Cont.write(num);           %send # args followed by args
        for j=1:length(data),
            info=num2str(data(j));
            Phys2Cont.write(info);
        end
        Phys2Cont.write('ENDDATA');     %signal end
        return
    end    
else %nothing waiting
    return
end