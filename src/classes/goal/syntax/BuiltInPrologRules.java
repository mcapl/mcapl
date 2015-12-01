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
	}
	
	public ArrayList<Predicate> getFacts() {
		return facts;
	}
	public ArrayList<Rule> getRules() {
		return rules;
	}
	
	public void memberPredicate() {
		try {
			Predicate nil_rule_hd = ruleHead("member(X, [])");
			LogExpr nil_rule_body = ruleBody("false");
			rules.add(new Rule(nil_rule_hd, nil_rule_body));
			
			Predicate cons_hd_rule = ruleHead("member(H, [H | T])");
			facts.add(cons_hd_rule);
			
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
				rule_body = new LogExpr(rule_body, LogExpr.LogicalOp.or, alf.toMCAPL());
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
