function  [Mf,Frow,Fcol] = interpm(M,n,option)

% INTERPM   Interpolation between rows and columns of a matrix
%	MF = INTERPM(M,[NROW NCOL])  Resamples matrix  M  with
%	NROW times original rate for rows and NCOL for columns.
%	The resulting matrix  MF has (size(M,1)-1)*NROW+1  by
%	(size(M,2)-1)*NCOL+1 size and is obtained by local
%	interpolation with Lagrange polynomials.
%	MF = INTERPM(M,N) uses the same resampling rate N for
%	rows and columns,
%	MF = INTERPM(M) uses default resampling rate equal 2.
%	MF = INTERPM(M,[NROW NCOL],[NPTROW NPTCOL]),
%	MF = INTERPM(... ,NPT)  or
%	MF = INTERPM(... ,'linear')  (or 'quadratic' or 'cubic';
%	'l', 'q' or 'c' is enough) also allows to specify
%	the order of Lagrange polynomial to be used: NPTROW
%	for interpolation between rows and NPTCOL between columns
%	('cubic' is equivalent to 4).
%
%	[MF,FROW,FCOL] = INTERPM(...)  Also returns (sparse)
%	matrices FROW, FCOL of interpolation coefficients so that
%	the matrix MF is the result of the matrix product
%	MF = FROW*M*FCOL.

%  Kirill K. Pankratov,  kirill@plume.mit.edu
%  3/11/93,  12/12/94

 % Defaults and parameters ......................................
n_dflt = 2;     % Default for resample rate
                % (expansion of matrix size)
npt_dflt = 4;   % Default for nmb. of points for interpolation
                % (4-pt. - cubic)

 % Handle input :::::::::::::::::::::::::::::::::::::::::::::::::
npt = [];
Options = ['linear   '; 'quadratic'; 'cubic    '];
if nargin == 3
  if isstr(option),
    option = [option(:)' ' '];
    [a,npt] = max(option(1)==Options(:,1));
    npt = npt+1;
  else
    npt = option;
  end
end
if isempty(npt), npt =  npt_dflt; end
npt = npt([1 1]);

if nargin < 2, n = n_dflt; end
if isempty(n), n = n_dflt; n = n([1 1]);end


 % Calculate sizes and determine
 % whether sparseness is useful and possible ....................
v = version;       % If 4x sparseness is possible
szM = size(M);
npt = min([npt; szM]); % Make sure interp. order is not more
                       % than input matrix size
 % Size of resized (filtered) matrices
szMf = (szM-1).*n+1;

 % Initialize filter matrices ...............

  Frow = sparse(szM(1),szMf(1));
  Fcol = sparse(szM(2),szMf(2));


 % Coefficients (Lagrange polynomials) ......
Crow = lagrcoef(0:npt(1)-1,0:1/n(1):npt(1)-1);
Ccol = lagrcoef(0:npt(2)-1,0:1/n(2):npt(2)-1);


 % Compute indices into filter matrices ^^^^^^^^^^^^^^^^^^^^^^^^^

 % For interpolations between rows ..............................
if szM(1)>1
  % Auxillary numbers and vectors .........
  n_low = floor((npt(1)-1)/2);
  n_up = npt(1)-1-n_low;
  vn_low = 1:n_low;
  vn_up = szM(1)-(1:n_up);

  ob = ones(npt(1)*(n(1)+1),1);
  ooffs = ones(1,szM(1)-1);
  [xb,yb] = meshgrid(1:n(1)+1,(1:npt(1))-n_low-1); % Local block
  xb = xb(:); yb = yb(:);
  yoffs = (1:szM(1)-1);                    % Offsets for blocks
  xoffs = (yoffs-1)*n(1);
  yoffs(vn_low) = n_low+ones(1,n_low);     % Lower edge
  yoffs(vn_up) = szM(1)-n_up*ones(1,n_up); % Upper edge
  Indf = xb(:,ooffs)+xoffs(ob,:);          % Composite index
  Indf = (Indf-1)*szM(1)+yb(:,ooffs)+yoffs(ob,:);
  Indf = Indf(:);

  % Indices into coefficient matrices .....
  xb = (1:length(xb))';
  xoffs = n_low*ones(1,szM(1)-1);
  xoffs(vn_low) = vn_low-1;
  xoffs(vn_up) = vn_up-szM(1)+n_up+n_low;
  Indc = xb(:,ooffs)+xoffs(ob,:)*npt(1)*n(1);
  Indc = Indc(:);

  % Put coefficients in Frow filter matrix
  Frow(Indf) = Crow(Indc);
else
  Frow = 1;
end
Frow = Frow';


 % For interpolations between columns ...........................
if szM(2)>1
  % Auxillary numbers and vectors .........
  n_low = floor((npt(2)-1)/2);
  n_up = npt(2)-1-n_low;
  vn_low = 1:n_low;
  vn_up = szM(2)-(1:n_up);

  ob = ones(npt(2)*(n(2)+1),1);
  ooffs = ones(1,szM(2)-1);
  [xb,yb] = meshgrid(1:n(2)+1,(1:npt(2))-n_low-1); % Local block
  xb = xb(:); yb = yb(:);
  yoffs = (1:szM(2)-1);                    % Offsets for blocks
  xoffs = (yoffs-1)*n(2);
  yoffs(vn_low) = n_low+ones(1,n_low);     % Lower edge
  yoffs(vn_up) = szM(2)-n_up*ones(1,n_up); % Upper edge
  Indf = xb(:,ooffs)+xoffs(ob,:);          % Composite index
  Indf = (Indf-1)*szM(2)+yb(:,ooffs)+yoffs(ob,:);
  Indf = Indf(:);

  % Indices into coefficient matrices .....
  xb = (1:length(xb))';
  xoffs = n_low*ones(1,szM(2)-1);
  xoffs(vn_low) = vn_low-1;
  xoffs(vn_up) = vn_up-szM(2)+n_up+n_low;
  Indc = xb(:,ooffs)+xoffs(ob,:)*npt(2)*n(2);
  Indc = Indc(:);

  % Put coefficients in Frow filter matrix
  Fcol(Indf) = Ccol(Indc);
else
  Fcol = 1;
end


 % Interpolation itself *****************************************
Mf = Frow*M*Fcol;

