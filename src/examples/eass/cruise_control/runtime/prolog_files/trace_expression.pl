
:- use_module(library(assoc)).
:- use_module(library(coinduction)).
:- coinductive substitution_aux/3.
:- dynamic message_list/1, str/1, attrType/3, agents/1.


/*******************************************************************************************/
/*                              PARAMETRIC TRACE EXPRESSIONS                               */
/*******************************************************************************************/

match(E, E).

/* Transition rules */

% next transition function (parametric version)
next(ET:T, E, T, S) :-
  genvar(ET, ETFree, S1),
  match(E, ETFree),
  clear(S1, S).
next(T1\/_, E, T2, S) :-
  next(T1, E, T2, S).
next(_\/T1, E, T2, S) :-
  !, next(T1, E, T2, S).
next(T1|T2, E, T, S) :-
  next(T1, E, T3, S),
  fork(T3, T2, T).
next(T1|T2, E, T, S) :-
  !, next(T2, E, T3, S),
  fork(T1, T3, T).
next(T1*T2, E, T, S) :-
  next(T1, E, T3, S),
  concat(T3, T2, T).
next(T1*T2, E, T3, S) :-
  !, may_halt(T1),
  next(T2, E, T3, S).
next(T1/\T2, E, T, S) :-
  !, next(T1, E, T3, S1),
  next(T2, E, T4, S2),
  merge(S1, S2, S),
  conj(T3, T4, T).
next(ET>>T, E, ET>>T1, S) :-
  event(E),
  genvar(ET, ETFree, S1),
  (match(E, ETFree) *->
    (clear(S1, S2),
     next(T, E, T1, S3),
     merge(S2, S3, S));
     (T=T1)).
next(var(X, T), E, T2, S) :-
  next(T, E, T1, S1),
  (syntactic_member_couples((X=V), S1) ->
    (substitution(T1, (X=V), T2),% !,
     remove((X=V), S1, S));
    (T2 = var(X, T1), S = S1)).
% (main)
next(T, E, T1) :-
  next(T, E, T1, S), S = [].

% the trace expression can terminate?
may_halt(epsilon) :- !.
may_halt(T1\/T2) :- (may_halt(T1), !; may_halt(T2)).
may_halt(T1|T2) :- !, may_halt(T1), may_halt(T2).
may_halt(T1*T2) :- !, may_halt(T1), may_halt(T2).
may_halt(T1/\T2) :- !, may_halt(T1), may_halt(T2).
may_halt(_>>T) :- !, may_halt(T).
may_halt(var(_, T)) :- !, may_halt(T).

does_not_halt(_:_).
does_not_halt(T1\/T2) :- !, does_not_halt(T1), does_not_halt(T2).
does_not_halt(T1|T2) :- (does_not_halt(T1), !; does_not_halt(T2)).
does_not_halt(T1*T2) :- (does_not_halt(T1), !; does_not_halt(T2)).
does_not_halt(T1/\T2) :- (does_not_halt(T1), !; does_not_halt(T2)).
does_not_halt(_>>T) :- !, does_not_halt(T).
does_not_halt(var(_, T)) :- !, does_not_halt(T).

%%% optimization
fork(epsilon, T, T) :- !.
fork(T, epsilon, T) :- !.
fork((T1l|T1r), T2, (T1l|(T1r|T2))) :- !.
fork(T1, T2, (T1|T2)).

concat(epsilon, T, T) :- !.
concat(T, epsilon, T) :- !.
concat((T1l*T1r), T2, T1l*(T1r*T2)) :- !.
concat(T1, T2, T1*T2).

conj(epsilon/\epsilon, epsilon) :- !.
conj((T1l/\T1r), T2, T1l/\(T1r/\T2)) :- !.
conj(T1, T2, T1/\T2).

% Predicate which takes an event type and a variable ('$VAR'(N)) returning
% a new event type where all '$VAR'(N) are substituted with free variables
% and a list of substitutions recording the association between each ground
% variables with the new free variables.
% Example: genvar(ping('$VAR'(0)), ping(X), ['$VAR'(0)=X], '$VAR'(0))
% Example: genvar(ping('$VAR'(1)), ping('$VAR'(1)), [], '$VAR'(0))
genvar(ET, ETFree, [(X=V)], X) :-
  genvar(ET, ETFree, [(X=V)]), !.
genvar(ET, ET, [], _).

% Predicate which takes an event type returning a new event type where
% all '$VAR'(_) are substituted with free variables and a list of substitutions recording the association between each ground
% variables with the new free variables.
% Example: genvar(ping('$VAR'(0)), ping(X), ['$VAR'(0)=X])
% Example: genvar(ping('$VAR'(1)), ping(X), ['$VAR'(1)=X])
% Example: genvar(pong('$VAR'(0), '$VAR'(1)), pong(X, Y), ['$VAR'(0)=X, '$VAR'(1)=Y])
genvar(ET, ETFree, S) :-
  functor(ET, F, N),
  (N == 0 -> (ETFree = ET, S = []);
  (findall(Arg, arg(_, ET, Arg), Args),
  functor(ETFree, F, N),
  genvar_aux(Args, ETFree, 1, S))).
genvar_aux([], _, _, []).
genvar_aux([H1|T1], ETFree, N, [(H1=Arg)|S]) :-
  functor(H1, '$VAR', _), !,
  arg(N, ETFree, Arg),
  N1 is N+1,
  genvar_aux(T1, ETFree, N1, S).
genvar_aux([H1|T1], ETFree, N, S) :-
  arg(N, ETFree, Arg),
  H1 = Arg,
  N1 is N+1,
  genvar_aux(T1, ETFree, N1, S).

% Substitution function -
% It is used to substitute a variable inside an event types
% Example: substitution(ping('$VAR'(0)):epsilon, ('$VAR'(0)=a), ping(a):epsilon)
substitution(T, S, T1) :-
  substitution_aux(T, S, T1), !.
substitution_aux(epsilon, _, epsilon).
substitution_aux(ET:T, (X=V), ET1:T1) :-
  genvar(ET, ET1, S, X),
  ((member((X=V), S), !);true),
  substitution_aux(T, (X=V), T1).
substitution_aux(T1\/T2, S, T3\/T4) :-
  substitution_aux(T1, S, T3),
  substitution_aux(T2, S, T4).
substitution_aux(T1|T2, S, T3|T4) :-
  substitution_aux(T1, S, T3),
  substitution_aux(T2, S, T4).
substitution_aux(T1*T2, S, T3*T4) :-
  substitution_aux(T1, S, T3),
  substitution_aux(T2, S, T4).
substitution_aux(T1/\T2, S, T3/\T4) :-
  substitution_aux(T1, S, T3),
  substitution_aux(T2, S, T4).
substitution_aux(ET>>T, (X=V), ET1>>T1) :-
  genvar(ET, ET1, S, X),
  ((member((X=V), S), !);true),
  substitution_aux(T, (X=V), T1).
substitution_aux(var(X, T), (X=_), var(X, T)) :- !.
substitution_aux(var(X, T), S, var(X, T1)) :-
  substitution_aux(T, S, T1).

% Member function with syntactic equality (on couples)
% Example: syntactic_member_couples((X=a), [(Y=a), (Z=b), (X=a)]) -> true
% Example: syntactic_member_couples((X=a), [(Y=a), (Z=b)]) -> false
syntactic_member_couples((E=V), [(H=V)|_]) :-
  E == H, !.
syntactic_member_couples(E, [_|T]) :-
  syntactic_member_couples(E, T).

% Member function with syntactic equality (on singleton)
syntactic_member(E, [H|_]) :-
  E == H, !.
syntactic_member(E, [_|T]) :-
  syntactic_member(E, T).

% Add a new substitution to the substitution set
% Example: add((X=a), [X=a], [X=a]).
% Example: add((X=a), [], [X=a]).
% Example: add((X=a), [X=b], _) -> false
add(E, [], [E]).
add((E=X), [(H=V)|T], [(H=V)|T1]) :-
  E \== H, !,
  add((E=X), T, T1).
add((_=V), [(H=V)|T], [(H=V)|T]).

% Remove a substitution from the substitution set
% Example: remove((X=a), [X=a], []).
% Example: remove((X=a), [], []).
% Example: remove((X=a), [X=b], _) -> false
remove(_, [], []).
remove((E=X), [(H=V)|T], [(H=V)|T1]) :-
  E \== H, !,
  remove((E=X), T, T1).
remove((E=V), [(_=V)|T], T1) :-
  remove((E=V), T, T1).

% Merge two substitution sets
% Example: merge([(X=a)], [(Y=b)], [Y=b, X=a])
% Example: merge([(X=a)], [(X=a)], [X=a])
% Example: merge([(X=a)], [(X=b)], _) -> false
merge([], L, L).
merge([H|T], L, L2) :-
  add(H, L, L1),
  merge(T, L1, L2), !.

% Remove from a substitution set all couples (_=_)
% Example: clear([(X=a), (Y=b)], [(X=a), (Y=b)])
% Example: clear([(X=a), (Y=_)], [(X=a)])
clear([], []).
clear([(_=Y)|T], T1) :-
  var(Y), !, clear(T, T1).
clear([H|T], [H|T1]) :-
  clear(T, T1).


accept(T, []) :-
  may_halt(T).
accept(T1, [E|L]) :-
  next(T1, E, T2), accept(T2, L).

accept(_, T, [*]) :-
  may_halt(T).
accept(0, T, []) :-
  !, does_not_halt(T).
accept(N, T1, [E|L]) :-
  !, next(T1, E, T2),
  M is N - 1,
  accept(M, T2, L).

% one more argument: the residual term
accept(_,T,[*],T) :-
  may_halt(T).
accept(0,T,[],T) :-
  !,does_not_halt(T).
accept(N,T1,[E|L],T3) :-
  !, next(T1,E,T2),
  M is N - 1,
  accept(M,T2,L,T3).


