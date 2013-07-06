function  C = lagrcoef(xb,xi)
% LAGRCOEF Coefficients of Lagrange polynomial interpolation.
%	C = LAGRCOEF(XB,XI)  returns matrix C of the size
%	length(XB) by length(XI) of Lagrange polynomials
%	interpolation coefficients from vector of "basis" points XB
%	to vector of points to be interpolated XI.
%	The interpolated function values FI are can be obtained from
%	values at basis points FB as a matrix product:
%	        FI = C*FB'
%	The order of interpolation is length(XB)-1.

%  Kirill K. Pankratov, kirill@plume.mit.edu
%  11/91,   12/13/94

 % Handle input ............................................
if nargin < 2
  error('  Needs 2 input arguments: x_basis, x_interp. ')
end

 % Auxillary
xb = xb(:);
xi = xi(:)';
lxb = length(xb);
lxi = length(xi);
ob = ones(1,lxb);
oi = ones(1,lxi);

 % If 1 basis point, fast exit
if lxb < 2
  C = oi;
  return
end

xi = xi(ob,:);        % Make matrices out of vectors
xb = xb(:,oi);
C = zeros(size(xb));  % Initialize output

 % For each basis point compute products ....................
for jj = 1:lxb
  vv = xb(jj,:);
  D = vv(ob,:)-xb;    % Denominator matrix
  D(jj,:) = oi;
  N = xi-xb;          % Numerator matrix
  N(jj,:) = oi;
  C(jj,:) = prod(N)./prod(D);
end

