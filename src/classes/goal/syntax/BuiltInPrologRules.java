package goal.syntax;

import java.util.ArrayList;

import mcaplantlr.runtime.ANTLRStringStream;
import mcaplantlr.runtime.CommonTokenStream;
import goal.parser.GOALLexer;
import goal.parser.GOALParser;
import ail.syntax.LogExpr;
import ail.syntax.LogicalFormula;
import ail.syntax.Predicate;
import ail.syntax.Rule;
import ail.syntax.ast.Abstract_LogicalFormula;
import ail.syntax.ast.Abstract_Predicate;
import ajpf.util.AJPFLogger;

public class BuiltInPrologRules {
	ArrayList<Predicate> facts = new ArrayList<Predicate>();
	ArrayList<Rule> rules = new ArrayList<Rule>();
	
	public BuiltInPrologRules() {
		memberPredicate();
		nth0Predicate();
	}
	
	public ArrayList<Predicate> getFacts() {
		return facts;
	}
	public ArrayList<Rule> getRules() {
		return rules;
	}
	
	public void nth0Predicate() {
		try {
			Predicate nth0_0_hd = ruleHead("nth0(0, [H|_], H)");
			rules.add(new Rule(nth0_0_hd, Predicate.PTrue));
			
			Predicate nth_nonvar_hd = ruleHead("nth0(N, [_|Tail], Elem)");
			LogExpr nth_nonvar_body = ruleBody("M is N - 1, nth0(M, Tail, Elem)");
			rules.add(new Rule(nth_nonvar_hd, nth_nonvar_body));
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
			Predicate nil_rule_hd = ruleHead("member(X, [])");
			LogExpr nil_rule_body = ruleBody("false");
			rules.add(new Rule(nil_rule_hd, nil_rule_body));
			
			Predicate cons_hd_rule = ruleHead("member(H, [H | T])");
			// LogExpr cons_rule_body = ruleBody("true");
			rules.add(new Rule(cons_hd_rule, Predicate.PTrue));
			
			Predicate cons_tl_rule_hd = ruleHead("member(H, [X | T])");
			LogExpr cons_tl_rule_body = ruleBody("member(H, T)");
			rules.add(new Rule(cons_tl_rule_hd, cons_tl_rule_body));
			
		} catch (Exception e) {
			AJPFLogger.severe("goal.syntax.BuiltInPrologRules", e.getMessage());
		}
	}
	
	public Predicate ruleHead(String s) throws Exception {
		GOALParser parser = getParser(s);
		return (parser.declarationOrCallWithTerms()).toMCAPL();
	}
	
	public LogExpr ruleBody(String s) throws Exception {
		GOALParser parser = getParser(s);
		ArrayList<Abstract_LogicalFormula> rule_a = (parser.no_bracket_literals());
		boolean first = true;
		LogExpr rule_body = new LogExpr();
		for (Abstract_LogicalFormula alf: rule_a) {
			if (first) {
				rule_body = new LogExpr(LogExpr.LogicalOp.none, alf.toMCAPL());
				first = false;
			} else {
				rule_body = new LogExpr(rule_body, LogExpr.LogicalOp.and, alf.toMCAPL());
			}
			
		}
		return rule_body;
		
	}
	
	public GOALParser getParser(String s) {
		GOALLexer lexer = new GOALLexer(new ANTLRStringStream(s));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		return new GOALParser(tokens);
	}
}
