// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis, Michael Fisher, and Koen Hindriks
// 
// This file is part of AIL GOAL.  An AIL Implementation of the GOAL Programming
// Language
//
// AIL GOAL is free software: you can redistribute it and/or modify it under
// the terms of the GNU General Public License as published by the Free Software
// Foundation, either version 3 of the License, or (at your option) any later
// version.
//
// AIL GOAL is distributed in the hope that it will be useful, but WITHOUT
// ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
// FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
// details.
//
// You should have received a copy of the GNU General Public License along with
// this program. If not, see <http://www.gnu.org/licenses/>.
//
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------
package ail.syntax;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import ail.parser.FOFVisitor;
import ail.semantics.AILAgent;
import ail.syntax.ast.Abstract_LogicalFormula;
import ail.syntax.ast.Abstract_Predicate;
import ail.syntax.ast.Abstract_Rule;
import ail.tracing.explanations.PredicateDescriptions;
import ajpf.psl.parser.LogicalFmlasLexer;
import ajpf.psl.parser.LogicalFmlasParser;
import ajpf.util.AJPFLogger;

public class BuiltInPrologRules {
	ArrayList<Predicate> facts = new ArrayList<Predicate>();
	ArrayList<Rule> rules = new ArrayList<Rule>();
	
	Abstract_Predicate tmp_predicate = new Abstract_Predicate();
	Abstract_Rule tmp_rule = new Abstract_Rule(new Abstract_Predicate(), (Abstract_LogicalFormula) new Abstract_Predicate());
	
	public BuiltInPrologRules() {
		memberPredicate();
		/* nth0Predicate();
		lengthPredicate(); */

		rules.add(nonvar());
	}
	
	public ArrayList<Predicate> getFacts() {
		return facts;
	}
	public ArrayList<Rule> getRules() {
		return rules;
	}
	
	public void nth0Predicate() {
		try {
			Rule nth0 = rule("nth0(0, [H|_], H).");
			rules.add(nth0);
			Rule nth_nonvar = rule("nth0(N, [_|Tail], Elem):- M is N - 1, nth0(M, Tail, Elem);");
			
			/* Predicate nth_nonvar_hd = ruleHead("nth0(N, [_|Tail], Elem)");
			LogExpr nth_nonvar_body = ruleBody("M is N - 1, nth0(M, Tail, Elem)");
			rules.add(new Rule(nth_nonvar_hd, nth_nonvar_body)); */
			
			/*
			 * Missing
			 * nth0(N, [_|Tail], Elem) :-
			 *  nonvar(N)
			 *  M is N-1,
			 *  nth0(M, Tail, Elem).
			 */
			
			//Predicate nth_var_hd = ruleHead("nth0(N,[_|T], Item)");
			//NB. skipping var(N)
			//LogExpr nth_var_body = ruleBody("nth0(M, T, Item), N is M + 1");
			//rules.add(new Rule(nth_var_hd, nth_var_body));
		} catch (Exception e) {
			AJPFLogger.severe("goal.syntax.BuiltInPrologRules", e.getMessage());
		}
	}
	
	public void memberPredicate() {
		try {
			/* member(El, [H|T]) :-
    			member_(T, El, H).

				member_(_, El, El).
				member_([H|T], El, _) :-
    				member_(T, El, H). */
			
			Rule member_rule = rule("member(El, [H|T]) :- member_(T, El, H);");
			//LogExpr nil_rule_body = ruleBody("false");
			rules.add(member_rule);
			
			Rule member__rule1 = rule("member_(_, El, El);");
			// LogExpr cons_rule_body = ruleBody("true");
			rules.add(member__rule1);
			
			Rule member__rule2 = rule("member_([H|T], El, _) :- member_(T, El, H);");
			// LogExpr cons_tl_rule_body = ruleBody("member(H, T)");
			rules.add(member__rule2);
			
		} catch (Exception e) {
			AJPFLogger.severe("goal.syntax.BuiltInPrologRules", e.getMessage());
		}
	}
	
	/**
	 * Actually length1 - need to implement properly.
	 */
	public void lengthPredicate() {
		try {
			Rule nil_rule = rule("length([], 0);");
			rules.add(nil_rule);
			
			Rule cons_rule = rule("length[_|L], Length):- N1 is Length-1, length(L, N1);");
			rules.add(cons_rule);
			
			/* Rule cons_rule = rule("length([_|L], Length) :- ");
			LogExpr cons_rule_body = ruleBody("N1 is Length-1, length(L, N1)");
			rules.add(new Rule(cons_rule_hd, cons_rule_body)); */
			
			/* length(List, Length) :-
	        ( var(Length) ->
	          length(List, 0, Length)
	        ;
	          Length >= 0,
	          length1(List, Length) ).

	          length([], Length, Length).
	          length([_|L], N, Length) :-
	          N1 is N+1,
	          length(L, N1, Length).

	          length1([], 0) :- !.
	          length1([_|L], Length) :-
	          N1 is Length-1,
	          length1(L, N1). */
			} catch (Exception e) {
				AJPFLogger.severe("goal.syntax.BuiltInPrologRules", e.getMessage());
			}
	}
	
	public Rule nonvar() {
		try {
			Predicate head =  predicate("nonvar(T)");
			//Predicate head = new Predicate("head");
			
			class NonVarBody implements LogicalFormula {
				@Override
			    public Iterator<Unifier> logicalConsequence(final EvaluationBasewNames<PredicateTerm> eb, 
			    		final RuleBase rb, Unifier un, final Set<String> varnames, AILAgent.SelectionOrder so) {
					return new Iterator<Unifier>() {
						boolean start = true;
						
						public boolean hasNext() {
							// nonvar only succeeds once.
							if (!start) {
								return false;
							}
							
							if (un.containsVarName("T")) {
								Term unifiedwith = un.get("T");
								if (unifiedwith.isVar()) {
									return false;
								} else if (unifiedwith instanceof VarsCluster) {
									if (((VarsCluster) unifiedwith).getValue() == null) {
										return false;
									}
								}
							}
							return true;
						}
						
						public Unifier next() {
							if (hasNext() && start) {
								start = false;
								return un;
							}
							return null;
						}
						
						public void remove() {}
					};
				}

				@Override
				public boolean unifies(Unifiable t, Unifier u) {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public void standardise_apart(Unifiable t, Unifier u, Set<String> varnames) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public Set<String> getVarNames() {
					// TODO Auto-generated method stub
					return new HashSet<String>();
				}

				@Override
				public void renameVar(String oldname, String newname) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public boolean match(Unifiable t, Unifier u) {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public boolean matchNG(Unifiable t, Unifier u) {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public boolean isGround() {
					// TODO Auto-generated method stub
					return true;
				}

				@Override
				public boolean apply(Unifier theta) {
					// TODO Auto-generated method stub
					return true;
				}

				@Override
				public void makeVarsAnnon() {
					// TODO Auto-generated method stub
					
				}

				@Override
				public Unifiable strip_varterm() {
					// TODO Auto-generated method stub
					return this;
				}

				@Override
				public Unifiable resolveVarsClusters() {
					// TODO Auto-generated method stub
					return this;
				}

				@Override
				public Unifiable substitute(Unifiable term, Unifiable subst) {
					// TODO Auto-generated method stub
					return this;
				}

				@Override
				public String toString(PredicateDescriptions descriptions) {
					// TODO Auto-generated method stub
					return "no prolog code";
				}

				@Override
				public LogicalFormula clone() {
					// TODO Auto-generated method stub
					return new NonVarBody();
				}

			}
			
			return new Rule(head, new NonVarBody());
		} catch (Exception e) {
			AJPFLogger.severe("ail.syntax.BuiltInPrologRules", e.getMessage());
			System.exit(0);
		}
		return null;
	}
	
	/*public void forallPredicate() {
		try {
			Predicate rule_head = ruleHead("forall(Cond, Action)");
			LogExpr rule_body = ruleBody("~(Cond, ~Action)");
		}
	}*/
	
	FOFVisitor fofvisitor = new FOFVisitor();

	public Rule rule(String s) throws Exception {
		abstract_rule(s);
		
		Abstract_Rule rule = tmp_rule;
		return (rule.toMCAPL());
	}
	
	public void abstract_rule(String s) throws Exception {
		LogicalFmlasParser parser = fofparser(s);

		Abstract_Rule rule = (Abstract_Rule) fofvisitor.visitProlog_rule(parser.prolog_rule());
		// Doing this an apparently crazy way to allow a native peer to be used when running JPF because
		// JPF's virtual machine can't cope with Token Streams.
		tmp_rule = rule;
	}
	
	public Predicate predicate(String s) throws Exception {
		abstract_predicate(s);
		
		return (tmp_predicate.toMCAPL());
	}
	
	public void abstract_predicate(String s) throws Exception {
		LogicalFmlasParser parser = fofparser(s);

		Abstract_Predicate rule = (Abstract_Predicate) fofvisitor.visitPred(parser.pred());
		// Doing this an apparently crazy way to allow a native peer to be used when running JPF because
		// JPF's virtual machine can't cope with Token Streams.
		tmp_predicate = rule;
	}
	
	
	private LogicalFmlasParser fofparser(String s) {
		LogicalFmlasLexer lexer = new LogicalFmlasLexer(CharStreams.fromString(s));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		LogicalFmlasParser parser = new LogicalFmlasParser(tokens);
		return parser;
	}
}
