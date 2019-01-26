%% ----------------------------------------------------------------------------
%% Copyright (C) 2018 Angelo Ferrando, Louise A. Dennis, Davide Ancona, Michael Fisher and Viviana Mascardi
%%
%% This file is part of the Runtime Verification for MCAPL (RVMCAPL) Library.
%% 
%% The RVMCAPL Library is free software; you can redistribute it and/or
%% modify it under the terms of the GNU Lesser General Public
%% License as published by the Free Software Foundation; either
%% version 3 of the License, or (at your option) any later version.
%% 
%% The RVMCAPL Library is distributed in the hope that it will be useful,
%% but WITHOUT ANY WARRANTY; without even the implied warranty of
%% MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
%% Lesser General Public License for more details.
%% 
%% You should have received a copy of the GNU Lesser General Public
%% License along with the EASS Library; if not, write to the Free Software
%% Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
%% 
%% To contact the authors:
%% http://www.csc.liv.ac.uk/~lad
%%
%% ----------------------------------------------------------------------------

:- use_module(library(assoc)).
:- use_module(library(coinduction)).
:- coinductive substitution_aux/3.
:- coinductive check_constraints/1.
:- coinductive check_constraints/2.
:- dynamic message_list/1, str/1, attrType/3, agents/1.
%% Note - trace expression file should be pre-loaded by generate_env.pl - this is currently in examples/eass/cruise_control/prolog_files and probably should be moved here -
%% which then calls generate_abstract_environment
% :- include('trace_expression.pl').


/*******************************************************************************************/
/*                              GENERATION ABSTRACT ENVIRONMENT                            */
/*******************************************************************************************/

% main predicate used to generate the abstract environment starting from a trace expression
% Arguments:
% ClassName, the name of the abstract environment class that we want to create
% PackageName, the package of the abstract environment class
% SuperClassName, the name of the super class (for instance, EASSVerificationEnvironment)
% SuperClassPackageName, the package of the super class
% MaxDepth, in the case the trace expression is cyclic (it accepts also infinite traces), it is the max number of times we can consume a cycle in the trace expression
% TraceExpressionInitialBeliefs, preamble of the trace expression
% TraceExpressionSharedBeliefs, the trace expression representing all the beliefs
% TraceExpressionMessages, the trace expression representing all the messages
% Constraints, the constraints among the beliefs
generate_abstract_environment(ClassName, PackageName, SuperClassName, SuperClassPackageName, TraceExpressionInitialBeliefs, TraceExpressionSharedBeliefs, TraceExpressionMessages, Constraints) :-
    string_concat(ClassName, '.java', ClassName1),
  open(ClassName1, write, Stream),
  write_preamble(ClassName, PackageName, SuperClassName, SuperClassPackageName, Stream),

  get_initial_beliefs(TraceExpressionInitialBeliefs, InitialBeliefs),
  writeln(Stream, InitialBeliefs), nl(Stream),

  extract_all_boolean_flags(TraceExpressionMessages, BooleanFlagsMsg),
  initialize_all_boolean_flags(2, BooleanFlagsMsg, BooleanFlagsMsgDefinition),
  writeln(Stream, BooleanFlagsMsgDefinition),
  
  extract_predicate_list(TraceExpressionSharedBeliefs, PredicateList, PredicatesToDefine),
  extract_constrained_beliefs(Constraints, ConstraintsStructures),
  
%   compile_with_abstraction(TraceExpressionSharedBeliefs, AbstractEnvironmentSharedBeliefs, MaxDepth, PredicatesToDefine, Constraints),
  list_to_set(PredicatesToDefine, PredicatesToDefineWithoutDuplicates),
  findall(Definition,
	(
	    member(P, PredicatesToDefineWithoutDuplicates),
	    from_event_type_to_java_aux(P, Definition, Arguments, _F, false),
	    write_indent(1, Stream, 'Predicate '),
	    writeln(Stream, Definition),
	    writeln_indent(1, Stream, Arguments)
%                string_concat('boolean ', P, S1),
%                string_concat(S1, '_b = false;', S2),
%                writeln(Stream, S2)
	),
	_), nl(Stream),

%  writeln_indent(1, Stream, 'public Set<Predicate> generate_sharedbeliefs() { return new TreeSet<Predicate>(); }'), nl(Stream), nl(Stream),
  writeln_indent(1, Stream, 'public Set<Predicate> generate_sharedbeliefs(String agName, Action act) {'), nl(Stream),

  %% Creating random beliefs
%  extract_all_boolean_flags(TraceExpressionSharedBeliefs, BooleanFlagsBel),
%  initialize_all_boolean_flags(2, BooleanFlagsBel, BooleanFlagsBelDefinition),
  
%  writeln(Stream, BooleanFlagsBelDefinition),
%  writeln_indent(2, Stream, 'boolean assert_belief;'),
%  writeln_indent(2, Stream, 'int assert_random_int;'),
  writeln_indent(2, Stream, 'Set<Predicate> predicates = new TreeSet<Predicate>();'), nl(Stream),

  create_belief_sets(2, PredicateList, ConstraintsStructures, AbstractEnvironmentSharedBeliefs),
  writeln_indent(2, Stream, AbstractEnvironmentSharedBeliefs),
  writeln_indent(2, Stream, 'return predicates;'),
  writeln_indent(2, Stream, '}'), nl(Stream), nl(Stream),

  %% Messages
%  writeln_indent(1, Stream, 'public Set<Message> generate_messages() { return new TreeSet<Message>(); }'), nl(Stream),
  writeln_indent(1, Stream, 'public Set<Message> generate_messages(String agName, Action act) {'),
  writeln_indent(2, Stream, 'Set<Message> messages = new TreeSet<Message>();'),
%  writeln_indent(2, Stream, 'boolean assert_belief;'),
%  writeln_indent(2, Stream, 'int assert_random_int;'), nl(Stream),
%  compile(TraceExpressionMessages, AbstractEnvironmentMessages, MaxDepth, MessagesToDefine, Constraints),%)),
%  list_to_set(MessagesToDefine, MessagesToDefineWithoutDuplicates),
%	findall(MessageDefinition,
%	(
%		member(M, MessagesToDefineWithoutDuplicates),
%		string_concat('Message ', M, Str),
%		string_concat(Str, ';', MessageDefinition),
%		writeln(Stream, MessageDefinition)
%	),
%	_), nl(Stream),
%  writeln(Stream, AbstractEnvironmentMessages),
  writeln_indent(2, Stream, 'return messages;'),
  writeln_indent(1, Stream, '}'),
  writeln(Stream, '\n}'),
  close(Stream).

create_indent(0, String, String).
create_indent(N, String, StringOut):-
    N > 0,
    !, N1 is N - 1,
    string_concat('   ', String, NewString),
    create_indent(N1, NewString, StringOut).

write_indent(N, Stream, String):-
    create_indent(N, '', IndentString),
    write(Stream, IndentString),
    write(Stream, String).
writeln_indent(N, Stream, String):-
    create_indent(N, '', IndentString),
    write(Stream, IndentString),
    writeln(Stream, String).

write_preamble(ClassName, PackageName, SuperClassName, SuperClassPackageName, Stream):-
  string_concat('//This is an automatically generated environment\n\npackage ', PackageName, PackageNameStr),
  string_concat(PackageNameStr, ';\n', PackageNameStr1),
  writeln_indent(0, Stream, PackageNameStr1),
  writeln(Stream, 'import java.util.Set;'),
  writeln(Stream, 'import java.util.TreeSet;'),
  write(Stream, 'import '),% eass.mas.verification.EASSVerificationEnvironment;'),
  write(Stream, SuperClassPackageName),
  write(Stream, '.'),
  write(Stream, SuperClassName),
  writeln(Stream, ';'),
  writeln(Stream, 'import ail.syntax.Predicate;'),
  writeln(Stream, 'import ajpf.util.AJPFLogger;'),
  writeln(Stream, 'import ail.syntax.Action;'),
  writeln(Stream, 'import ail.syntax.Literal;'),
  writeln(Stream, 'import ail.syntax.ast.GroundPredSets;'),
  writeln(Stream, 'import ail.syntax.NumberTermImpl;'),
  writeln(Stream, 'import ail.syntax.Message;'), nl(Stream),
  write(Stream, 'public class '),
  write(Stream, ClassName),
  write(Stream, ' extends '),
  write(Stream, SuperClassName),
  writeln(Stream, ' {'),
  write_indent(1, Stream, 'public String logname = "'),
  write(Stream, PackageName),
  write(Stream, '.'),
  write(Stream, ClassName),
  writeln(Stream, '";'), nl(Stream), !.

extract_constrained_beliefs(epsilon, []).
extract_constrained_beliefs(C1/\C2, Constraints):-
    extract_constrained_beliefs(C1, C1Out),
    extract_constrained_beliefs(C2, C2Out),
    append(C1Out, C2Out, Constraints).
%% Because \/ is communtative we have a lot of variations here.

% Sample
%%        CantAccel = (bel(safe):CanAccelOrBeUnsafe) \/ (((not_bel(safe):epsilon) \/ (not_bel(driver_acclerates):epsilon)) * CantAccel),
%%        CanAccelOrBeUnsafe = ((bel(driver_accelerates):CanAccel) \/ (((not_bel(driver_acclerates):epsilon) \/ (bel(safe):epsilon)) * CanAccelOrBeUnsafe) \/ (not_bel(safe):CantAccel)),
%%        CanAccel = (not_bel(driver_accelerates):CanAccelOrBeUnsafe) \/ (((bel(safe):epsilon) \/ (bel(driver_accelerates):epsilon)) * CanAccel).


extract_constrained_beliefs(_ >> Can1, [constraint(C1, C2)]):-
    (
	Can1 = (NC1:CanEither) \/ (((NC2:epsilon) \/ (C1:epsilon)) * Can1);
	Can1 = (((NC2:epsilon) \/ (C1:epsilon)) * Can1) \/ (NC1:CanEither);
	Can1 = (NC1:CanEither) \/ (((C1:epsilon) \/ (NC2:epsilon)) * Can1);
	Can1 = (((C1:epsilon) \/ (NC2:epsilon)) * Can1) \/ (NC1:CanEither)
    ),
    (
	CanEither = (C2:Can2) \/ (((_:epsilon) \/ (_:epsilon)) * CanEither) \/ (C1:Can1);
	CanEither = (((_:epsilon) \/ (_:epsilon)) * CanEither) \/ (C1:Can1) \/ (C2:Can2);
	CanEither = (C1:Can1) \/ (C2:Can2) \/ (((_:epsilon) \/ (_:epsilon)) * CanEither);
	CanEither = (C1:Can1) \/ (((_:epsilon) \/ (_:epsilon)) * CanEither) \/ (C2:Can2);
	CanEither = (((_:epsilon) \/ (_:epsilon)) * CanEither) \/ (C2:Can2) \/ (C1:Can1);
	CanEither = (C2:Can2) \/ (C1:Can1) \/ (((_:epsilon) \/ (_:epsilon)) * CanEither)
    ),
    (
	Can2 = (((C2:epsilon) \/ (NC1:epsilon))*Can2) \/ (NC2:CanEither);
	Can2 = (NC2:CanEither) \/ (((C2:epsilon) \/ (NC1:epsilon))*Can2);
	Can2 = (((NC1:epsilon) \/ (C2:epsilon))*Can2) \/ (NC2:CanEither);
	Can2 = (NC2:CanEither) \/ (((NC1:epsilon) \/ (C2:epsilon))*Can2)
    ),
    !.
extract_constrained_beliefs(_ >> CanEither, [constraint(C1, C2)]):-
    (
	CanEither = (C2:Can2) \/ (((_:epsilon) \/ (_:epsilon)) * CanEither) \/ (C1:Can1);
	CanEither = (((_:epsilon) \/ (_:epsilon)) * CanEither) \/ (C1:Can1) \/ (C2:Can2);
	CanEither = (C1:Can1) \/ (C2:Can2) \/ (((_:epsilon) \/ (_:epsilon)) * CanEither);
	CanEither = (C1:Can1) \/ (((_:epsilon) \/ (_:epsilon)) * CanEither) \/ (C2:Can2);
	CanEither = (((_:epsilon) \/ (_:epsilon)) * CanEither) \/ (C2:Can2) \/ (C1:Can1);
	CanEither = (C2:Can2) \/ (C1:Can1) \/ (((_:epsilon) \/ (_:epsilon)) * CanEither)
    ),
    (
	Can1 = (NC1:CanEither) \/ (((NC2:epsilon) \/ (C1:epsilon)) * Can1);
	Can1 = (((NC2:epsilon) \/ (C1:epsilon)) * Can1) \/ (NC1:CanEither);
	Can1 = (NC1:CanEither) \/ (((C1:epsilon) \/ (NC2:epsilon)) * Can1);
	Can1 = (((C1:epsilon) \/ (NC2:epsilon)) * Can1) \/ (NC1:CanEither)
    ), !,
    (
	Can2 = (((C2:epsilon) \/ (NC1:epsilon))*Can2) \/ (NC2:CanEither);
	Can2 = (NC2:CanEither) \/ (((C2:epsilon) \/ (NC1:epsilon))*Can2);
	Can2 = (((NC1:epsilon) \/ (C2:epsilon))*Can2) \/ (NC2:CanEither);
	Can2 = (NC2:CanEither) \/ (((NC1:epsilon) \/ (C2:epsilon))*Can2)
    ),
    !.



extract_constraints(_, epsilon, '').
extract_constraints(E, T1/\T2, Constraints) :-
  extract_constraints(E, T1, Constraints1),
  ((Constraints1 == '')->(extract_constraints(E, T2, Constraints));(Constraints = Constraints1)).
extract_constraints(E, _ >> T, Res) :-
    %  extract_prefix(E, T, Prefix),
    extract_constraints_aux(E, T, Prefix),
    from_list_to_conditions(Prefix, Conditions1),
    ((Conditions1 == '')->(Res = '');(Res = Conditions1)).

create_belief_sets(Indent, Predicates, Constraints, BeliefJava):-
    create_sets(Predicates, [[]], AllBeliefSets),
    filter_belief_sets(AllBeliefSets, Constraints, AllowedBeliefSets),
    length(AllowedBeliefSets, Len),
    create_indent(Indent, '', IndentString),
    string_concat(IndentString, 'int assert_random_int = random_int_generator.nextInt(', Str1),
    string_concat(Str1, Len, Str2),
    string_concat(Str2, ');\n', JavaIn),
    belief_sets_to_java(Indent, 0, AllowedBeliefSets, JavaIn, BeliefJava).

create_sets([], BeliefSets, BeliefSets).
create_sets([H|T], BeliefSets, BOut):-
    extend(bel(H), BeliefSets, BeliefSets1),
    extend(not_bel(H), BeliefSets, BeliefSets2),
    append(BeliefSets1, BeliefSets2, NewBeliefSets),
    create_sets(T, NewBeliefSets, BOut).

extend(_, [], []).
extend(B, [H|T], [[B|H]|BS]):-
    extend(B, T, BS).

filter_belief_sets([], _, []).
filter_belief_sets([BS | T], Constraints, Out):-
    forbidden_set(BS, Constraints),
    filter_belief_sets(T, Constraints, Out).
filter_belief_sets([BS | T], Constraints, [BS|Out]):-
    not(forbidden_set(BS, Constraints)),
    filter_belief_sets(T, Constraints, Out).

forbidden_set(_, []):- !, fail.
forbidden_set(BS, [constraint(A, B) | _]):-
    member(A, BS),
    member(B, BS), !.
forbidden_set(BS, [_C | T]):-
    forbidden_set(BS, T).

belief_sets_to_java(_Indent, _, [], Java, Java).
belief_sets_to_java(Indent, Count, [BS|T], JavaIn, JavaOut):-
    create_indent(Indent, '', IndentString),
    string_concat(IndentString, 'if (assert_random_int ==', Str1),
    string_concat(Str1, Count, Str2),
    string_concat(Str2, ') {\n', Str3),
    string_concat(JavaIn, Str3, JavaIn2),
    NewIndent is Indent + 1,
    belief_set_to_java(NewIndent, BS, JavaIn2, NewJava),
    string_concat(NewJava, IndentString, IndentJava),
    string_concat(IndentJava, '}\n', NewJava2),
    Count1 is Count + 1,
    belief_sets_to_java(Indent, Count1, T, NewJava2, JavaOut).

belief_set_to_java(_Indent, [], Java, Java).
belief_set_to_java(Indent, [EventType | T], JavaIn, JavaOut):-
    from_event_type_to_java(Indent, EventType, EventJava),
    string_concat(JavaIn, EventJava, JavaNew),
    belief_set_to_java(Indent, T, JavaNew, JavaOut).
    

from_event_type_to_java_aux(EventType, Definition, Arguments, F, Static) :-
    (EventType = bel(Belief); EventType = not_bel(Belief); EventType = bel(_, Belief); EventType = not_bel(_, Belief)),
    functor(Belief, F1, _),
  
    (Static ->(string_concat(F1, '_s', F));(F = F1)),
    string_concat(F, ' = new Predicate("', Str2),
    string_concat(Str2, F, Str3),
    string_concat(Str3, '");\n', Definition),
    findall(S,
	    (
		compound(Belief),
		arg(_, Belief, Arg),
		((number(Arg))->
		     (string_concat(F, '.addTerm(new NumberTermImpl(', S1),
		      string_concat(S1, Arg, S2),
		      string_concat(S2, '));\n', S));
		 (string_concat(F, '.addTerm(new Literal("', S1),
		  string_concat(S1, Arg, S2),
		  string_concat(S2, '"));\n', S)))
	    )
	    , Args),
    concat_all_string(Args, '', Arguments).


from_event_type_to_java(Indent, bel(Belief), Java) :-
%    from_event_type_to_java_aux(bel(Belief), Definition, Arguments, F, false),
    create_indent(Indent, '', IndentString),
    functor(Belief, F, _),
%    string_concat(IndentString, Definition, DefString),
%    string_concat(IndentString, Arguments, ArgString),
%    string_concat(DefString, ArgString, Str0),
    %   string_concat(Str0, IndentString, IndentStr0),
%    string_concat(IndentString, 'addPercept(', Str1),
%    string_concat(Str1, F, Str2),
%    string_concat(Str2, ');\n', Str3),
%    string_concat(Str3, IndentString, IndentStr3),
    string_concat(IndentString, 'AJPFLogger.info(logname, "Asserting ', Str4),
    string_concat(Str4, F, Str5),
    string_concat(Str5, '");\n', Str6),
    string_concat(Str6, IndentString, IndentStr6),
%    string_concat(IndentStr6, Belief, Str7),
%    string_concat(Str7, '_b = true;\n', Str8),
%    string_concat(Str8, IndentString, IndentStr8),
    string_concat(IndentStr6, 'predicates.add(', Str9),
    string_concat(Str9, F, Str10),
    string_concat(Str10, ');\n', Java).
from_event_type_to_java(_, not_bel(_Belief), '').

concat_all_string([], Concatenation, Concatenation).
concat_all_string([H|T], CurrentConcatenation, NewConcatenation) :-
  concat_all_string(T, CurrentConcatenation, Concatenation1),
  string_concat(H, Concatenation1, NewConcatenation).

extract_all_boolean_flags(T, Res) :-
  empty_assoc(A),
  extract_all_boolean_flags(T, Res1, A),
  list_to_set(Res1, Res).
extract_all_boolean_flags(epsilon, [], _).
extract_all_boolean_flags(T, [], A) :-
  get_assoc(T, A, _), !.
extract_all_boolean_flags(ET:T, Res, A) :-
  put_assoc(ET:T, A, _, A1),
  (ET = bel(C); ET = bel(_, C); ET = msg(_,_,_,C)), !,
  string_concat(C, '_b', C1),
  extract_all_boolean_flags(T, Res1, A1),
  append([C1], Res1, Res).
extract_all_boolean_flags(ET:T, Res, A) :-
  put_assoc(ET:T, A, _, A1),
  extract_all_boolean_flags(T, Res, A1).
extract_all_boolean_flags(T1\/T2, Res, A) :-
  put_assoc(T1\/T2, A, _, A1),
  extract_all_boolean_flags(T1, Res1, A1),
  extract_all_boolean_flags(T2, Res2, A1),
  append(Res1, Res2, Res).
extract_all_boolean_flags(T1|T2, Res, A) :-
  put_assoc(T1|T2, A, _, A1),
  extract_all_boolean_flags(T1, Res1, A1),
  extract_all_boolean_flags(T2, Res2, A1),
  append(Res1, Res2, Res).
extract_all_boolean_flags(T1*T2, Res, A) :-
  put_assoc(T1*T2, A, _, A1),
  extract_all_boolean_flags(T1, Res1, A1),
  extract_all_boolean_flags(T2, Res2, A1),
  append(Res1, Res2, Res).
extract_all_boolean_flags(T1/\T2, Res, A) :-
  put_assoc(T1/\T2, A, _, A1),
  extract_all_boolean_flags(T1, Res1, A1),
  extract_all_boolean_flags(T2, Res2, A1),
  append(Res1, Res2, Res).
extract_all_boolean_flags(ET>>T, Res, A) :-
  put_assoc(ET>>T, A, _, A1),
  extract_all_boolean_flags(T, Res, A1).

extract_predicate_list(T, Res, PtD) :-
    extract_predicate_list(T, [], Res, [], PtD).
extract_predicate_list(epsilon, Res, Res, PtD, PtD).
extract_predicate_list(ET:epsilon, In1, [Belief|In1], In2, [ET|In2]) :-
    (ET = bel(Belief); ET = bel(_, Belief)), !.
extract_predicate_list(_ET:T, In1, Out1, In2, Out2) :-
    !, extract_predicate_list(T, In1, Out1, In2, Out2).
extract_predicate_list(T1\/T2, In1, Out1, In2, Out2) :-
    extract_predicate_list(T1, In1, Out1a, In2, Out2a),
    extract_predicate_list(T2, Out1a, Out1, Out2a, Out2).
extract_predicate_list(T1|T2, In1, Out1, In2, Out2) :-
    extract_predicate_list(T1, In1, Out1a, In2, Out2a),
    extract_predicate_list(T2, Out1a, Out1, Out2a, Out2).
extract_predicate_list(T1*_T2, In1, Out1a, In2, Out2a) :-
    extract_predicate_list(T1, In1, Out1a, In2, Out2a).

initialize_all_boolean_flags(_, [], '').
initialize_all_boolean_flags(Indent, [H|T], Res) :-
    create_indent(Indent, '', IndentString),
    string_concat(IndentString, 'boolean ', BStr),
    string_concat(BStr, H, Str),
    string_concat(Str, ' = false;\n', Str1),
    initialize_all_boolean_flags(Indent, T, Res1),
    string_concat(Str1, Res1, Res).


range(X, L, H) :- X is L, X < H.
range(X, L, H) :- L1 is L + 1, L1 < H, range(X, L1, H).

get_initial_beliefs(_T, '').
%% get_initial_beliefs(epsilon, '') :- !.
%% get_initial_beliefs(T, InitialBeliefs) :-
%%	findall(Str,
%%		(
%%			next(T, Ev, _),
%%			from_event_type_to_java_aux(Ev, F, Definition, Arguments, true),
%%			string_concat('static Predicate ', Definition, Str1),
%%			string_concat(Str1, 'static{\n', Str2),
%%			string_concat(Str2, Arguments, Str3),
%%			string_concat(Str3, ' GroundPredSets.check_add(', Str4),
%%			string_concat(Str4, F, Str5),
%%			string_concat(Str5, ');\n}\n', Str)
%%		),
%%	Strs),
%%	concat_all_string(Strs, '', InitialBeliefs).


%extract_belief_part(Action:(epsilon|_Tmsg), epsilon) :-
	%(Action = action(_); Action = action(_, _)), !.
extract_belief_part(action(Action):((Tbel|_Tmsg) * _), action(Action):Tbel).
extract_belief_part(action(Agent, Action):((Tbel|_Tmsg) * _), action(Agent, Action):Tbel).
extract_belief_part(T1\/T2, T) :-
	extract_belief_part(T1, Tbel1),
	extract_belief_part(T2, Tbel2),
	((Tbel1 = epsilon) -> (T = Tbel2);((Tbel2 = epsilon) -> (T = Tbel1);(T = Tbel1\/Tbel2))).

%extract_msg_part(Action:(_Tbel|epsilon), epsilon) :-
	%(Action = action(_); Action = action(_, _)), !.
extract_msg_part(action(Action):((_Tbel|Tmsg) * _), action(Action):Tmsg).
extract_msg_part(action(Agent, Action):((_Tbel|Tmsg) * _), action(Agent, Action):Tmsg).
extract_msg_part(T1\/T2, T) :-
	extract_msg_part(T1, Tmsg1),
	extract_msg_part(T2, Tmsg2),
	((Tmsg1 = epsilon) -> (T = Tmsg2);((Tmsg2 = epsilon) -> (T = Tmsg1);(T = Tmsg1\/Tmsg2))).


match_at_least(_, []).
match_at_least(ET, [H|T]) :-
  match(E, H), match(E, ET), !,
  match_at_least(ET, T).

all_shuffles(T) :-
  empty_assoc(A),
  all_shuffles(T, A).
all_shuffles(T, A) :-
  get_assoc(T, A, _), !.
all_shuffles(_:epsilon, _).
%all_shuffles((_:epsilon)\/epsilon, _).
all_shuffles(NotAction, _) :-
  NotAction = ((not_action:NotAction)\/epsilon).
all_shuffles(T1|T2, A) :-
  put_assoc(T1|T2, A, _, A1),
  all_shuffles(T1, A1),
  all_shuffles(T2, A1).

all_unions_of_actions(T, ProtocolBelMsgs) :-
  empty_assoc(A),
  all_unions_of_actions(T, A, ProtocolBelMsgs).
all_unions_of_actions(T, A, []) :-
  get_assoc(T, A, _), !.
all_unions_of_actions(ET:T, _, [T]) :-
  ET = action(_); ET = action(_,_).
  all_unions_of_actions(T1\/T2, A, ProtocolBelMsgs) :-
  put_assoc(T1\/T2, A, _, A1),
  all_unions_of_actions(T1, A1, ProtocolBelMsgs1),
  all_unions_of_actions(T2, A1, ProtocolBelMsgs2),
  append(ProtocolBelMsgs1, ProtocolBelMsgs2, ProtocolBelMsgs).

all_shuffles_of_add_remove_bel(T, Beliefs) :-
  empty_assoc(A),
  all_shuffles_of_add_remove_bel(T, A, Beliefs).
all_shuffles_of_add_remove_bel(T, A, []) :-
  get_assoc(T, A, _), !.
all_shuffles_of_add_remove_bel(TT, _, [ET]) :-
  TT = (NET:TT)\/(ET:(T1\/T2)),
  ((T1 = epsilon);(T2 = epsilon)),
  (((ET = bel(Belief); ET = bel(_, Belief)),
  (NET = not_bel(Belief); NET = not_bel(_, Belief)));
  ((ET = not_bel(Belief); ET = not_bel(_, Belief)),
  (NET = bel(Belief); NET = bel(_, Belief)))).
  %((End = epsilon);(End = TT)).
all_shuffles_of_add_remove_bel(T1|T2, A, Beliefs) :-
  put_assoc(T1|T2, A, _, A1),
  all_shuffles_of_add_remove_bel(T1, A1, Beliefs1),
  all_shuffles_of_add_remove_bel(T2, A1, Beliefs2),
  append(Beliefs1, Beliefs2, Beliefs3),
  list_to_set(Beliefs3, Beliefs).

all_shuffles_of_remove_bel(T, Beliefs) :-
  empty_assoc(A),
  all_shuffles_of_remove_bel(T, A, Beliefs).
all_shuffles_of_remove_bel(T, A, []) :-
  get_assoc(T, A, _), !.
all_shuffles_of_remove_bel(ET:epsilon, _, [ET]).
% all_shuffles_of_remove_bel(T1*_, A, Beliefs) :-
%   all_shuffles_of_remove_bel(T1, A, Beliefs).
all_shuffles_of_remove_bel(T1|T2, A, Beliefs) :-
  put_assoc(T1|T2, A, _, A1),
  all_shuffles_of_remove_bel(T1, A1, Beliefs1),
  all_shuffles_of_remove_bel(T2, A1, Beliefs2),
  append(Beliefs1, Beliefs2, Beliefs3),
  list_to_set(Beliefs3, Beliefs).

contains_only_beliefs(T) :-
  empty_assoc(A),
  contains_only_beliefs(T, A).
contains_only_beliefs(epsilon, _).
contains_only_beliefs(T, A) :-
  get_assoc(T, A, _), !.
contains_only_beliefs(ET:T, A) :-
  (ET = bel(_); ET = not_bel(_); ET = bel(_, _); ET = not_bel(_, _)),
  put_assoc(ET:T, A, _, A1),
  contains_only_beliefs(T, A1).
contains_only_beliefs(T1\/T2, A) :-
  put_assoc(T1\/T2, A, _, A1),
  contains_only_beliefs(T1, A1),
  contains_only_beliefs(T2, A1).
contains_only_beliefs(T1|T2, A) :-
  put_assoc(T1|T2, A, _, A1),
  contains_only_beliefs(T1, A1),
  contains_only_beliefs(T2, A1).
contains_only_beliefs(T1*T2, A) :-
  put_assoc(T1*T2, A, _, A1),
  contains_only_beliefs(T1, A1),
  contains_only_beliefs(T2, A1).
contains_only_beliefs(T1/\T2, A) :-
  put_assoc(T1/\T2, A, _, A1),
  contains_only_beliefs(T1, A1),
  contains_only_beliefs(T2, A1).
contains_only_beliefs(ET>>T, A) :-
  put_assoc(ET>>T, A, _, A1),
  contains_only_beliefs(T, A1).

contains_only_msgs(T) :-
  empty_assoc(A),
  contains_only_msgs(T, A).
contains_only_msgs(epsilon, _).
contains_only_msgs(T, A) :-
  get_assoc(T, A, _), !.
contains_only_msgs(ET:T, A) :-
  ET = msg(_,_,_,_),
  put_assoc(ET:T, A, _, A1),
  contains_only_msgs(T, A1).
contains_only_msgs(T1\/T2, A) :-
  put_assoc(T1\/T2, A, _, A1),
  contains_only_msgs(T1, A1),
  contains_only_msgs(T2, A1).
contains_only_msgs(T1|T2, A) :-
  put_assoc(T1|T2, A, _, A1),
  contains_only_msgs(T1, A1),
  contains_only_msgs(T2, A1).
contains_only_msgs(T1*T2, A) :-
  put_assoc(T1*T2, A, _, A1),
  contains_only_msgs(T1, A1),
  contains_only_msgs(T2, A1).
contains_only_msgs(T1/\T2, A) :-
  put_assoc(T1/\T2, A, _, A1),
  contains_only_msgs(T1, A1),
  contains_only_msgs(T2, A1).
contains_only_msgs(ET>>T, A) :-
  put_assoc(ET>>T, A, _, A1),
  contains_only_msgs(T, A1).


