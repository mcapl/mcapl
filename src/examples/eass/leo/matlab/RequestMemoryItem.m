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

function INFO=RequestMemoryItem(stringReq)
%Agent Framework file to perform request for memory item held on Physical 
%Engine by the Continuous Engine; counter part operating on the Physical 
%Engine is CommunicateWithCont

global Cont2Phys;
%display(sprintf('Requesting memory item %s',stringReq));
%send request for memory item
Cont2Phys.write('Memory');
%memory bit desired
Cont2Phys.write(stringReq);

complete=0;
%await response
while complete~=1,
    if Cont2Phys.ready(),
       %item=Cont2Phys.readLine;
       if strcmp(Cont2Phys.readLine,'NEWDATA'),
           args=str2num(Cont2Phys.readLine);
           INFO=zeros(args,1);
           for i=1:args,                    
                    bit=char(Cont2Phys.readLine()); %read char and convert to uint8
                    Bit=str2num(bit)';
                    INFO(i,1)=(Bit);
           end
           if strcmp(Cont2Phys.readLine,'ENDDATA'),
               complete=1;return;
           else error('Failed completion of socket read');
           end
       else
           error('Failed completion of send on previous socket communication')
       end       
    else
        continue        
    end
end %end while