function [x,lambda,how]=lgbt2(f,A,B,vlb,vub,x,neqcstr,verbosity)
%LP     Linear programming.                   
%   X=LP(f,A,b) solves the linear programming problem:
%        
%            min f'x    subject to:   Ax <= b 
%             x
%   
%   X=LP(f,A,b,VLB,VUB) defines a set of lower and upper
%   bounds on the design variables, X, so that the solution is always in
%   the range VLB <= X <= VUB.
%
%   X=LP(f,A,b,VLB,VUB,X0) sets the initial starting point to X0.
%
%   X=LP(f,A,b,VLB,VUB,X0,N) indicates that the first N constraints defined
%   by A and b are equality constraints.
%
%   X=LP(f,A,b,VLB,VUB,X0,N,DISPLAY) controls the level of warning
%   messages displayed.  Warning messages can be turned off with
%   DISPLAY = -1.
%
%   [x,LAMBDA]=LP(f,A,b) returns the set of Lagrangian multipliers,
%   LAMBDA, at the solution. 
%   
%   [X,LAMBDA,HOW] = LP(f,A,b) also returns a string how that indicates 
%   error conditions at the final iteration.
%
%   LP produces warning messages when the solution is either unbounded
%   or infeasible. 

%   Copyright (c) 1990-98 by The MathWorks, Inc.
%   $Revision: 1.11 $  $Date: 1997/11/29 01:23:16 $
%   Andy Grace 7-9-90. Mary Ann Branch 9-30-96.
         
if nargin<8, verbosity = -1; 
    if nargin<7, neqcstr = 0; 
        if nargin<6, x = []; 
            if nargin<5, vub = [];
                if nargin<4, vlb = [];
        end, end, end, end, end
[ncstr,nvars]=size(A);
nvars = max([length(f),nvars]); % In case A is empty
        
if isempty(verbosity), verbosity = 0; end
if isempty(neqcstr), neqcstr = 0; end
if isempty(x), x=zeros(nvars,1); end       
        
if isempty(A), A=zeros(0,nvars); end
if isempty(B), B=zeros(0,1); end       

% Set to column vectors
f = f(:);
B = B(:);
x = x(:);

caller = 'lp'; 
[x,lambda,how]=qpsub2([],f,A,B,vlb,vub,x,neqcstr,verbosity,caller,ncstr,nvars);          

