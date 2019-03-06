package juno.syntax.parser;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;

import ail.parser.FOFVisitor;
import ail.syntax.ast.Abstract_Literal;
import ajpf.psl.parser.LogicalFmlasLexer;
import ajpf.psl.parser.LogicalFmlasParser;
import juno.syntax.ast.Abstract_JunoActionRule;
import juno.syntax.ast.Abstract_JunoAgent;
import juno.syntax.ast.Abstract_JunoBeliefRule;
import juno.syntax.parser.JunoParser.Action_ruleContext;
import juno.syntax.parser.JunoParser.Belief_modifierContext;
import juno.syntax.parser.JunoParser.Belief_ruleContext;
import juno.syntax.parser.JunoParser.Json_fileContext;

public class JunoAILVisitor extends JunoBaseVisitor<Object> {
	
	@Override public Object visitJunoAgent(@NotNull JunoParser.JunoAgentContext ctx) { 
		try {
			
			Abstract_JunoAgent juno = new Abstract_JunoAgent((String) visitJson_file(ctx.json_file()));
			
			if (ctx.bs != null) {
				for (Belief_ruleContext br_ctx: ctx.belief_rule()) {
					Abstract_JunoBeliefRule jbr = (Abstract_JunoBeliefRule) visitBelief_rule(br_ctx);
					juno.add_brule(jbr);
				}
			}
			
			if (ctx.as != null) {
				for (Action_ruleContext ar_ctx: ctx.action_rule()) {
					Abstract_JunoActionRule jar = (Abstract_JunoActionRule) visitAction_rule(ar_ctx);
					juno.add_arule(jar);
				}
			}
			return juno;
		} catch (Exception e) {
				System.err.println(e);
				return "juno";
		}
	}
	
	
	@Override public Object visitBelief_rule(Belief_ruleContext ctx) {
		Abstract_Literal trigger = (Abstract_Literal) visitBelief_modifier(ctx.b);
		Abstract_JunoBeliefRule rule = new Abstract_JunoBeliefRule(trigger);
		FOFVisitor fofvisitor = new FOFVisitor();
		ArrayList<Abstract_Literal> beliefs = new ArrayList<Abstract_Literal>();
		
		for (JunoParser.Fof_exprContext fof: ctx.fof_expr()) {
			LogicalFmlasParser fofparser_bs = fofparser(fof.getText());
			Abstract_Literal belief = (Abstract_Literal) fofvisitor.visitLiteral(fofparser_bs.literal());
			beliefs.add(belief);
	
		}
		rule.add_beliefs(beliefs);
		
		return rule;

	}
	
	@Override public Object visitAction_rule(Action_ruleContext ctx) {
		FOFVisitor fofvisitor = new FOFVisitor();

		LogicalFmlasParser fofparser_a = fofparser(ctx.fof_expr().getText());
		
		Abstract_Literal trigger = (Abstract_Literal) fofvisitor.visitLiteral(fofparser_a.literal());
		Abstract_JunoActionRule rule = new Abstract_JunoActionRule(trigger);
		
		List<Abstract_Literal> beliefs = new ArrayList<Abstract_Literal>();
	 
		
		for (JunoParser.Belief_modifierContext bm: ctx.belief_modifier()) {
			beliefs.add((Abstract_Literal) visitBelief_modifier(bm));
		}
		
		rule.add_beliefs(beliefs);
		
		return rule;

	}
	
	@Override public Object visitBelief_modifier(Belief_modifierContext ctx) {
		FOFVisitor fofvisitor = new FOFVisitor();

		LogicalFmlasParser fofparser_b = fofparser(ctx.fof_expr().getText());
		
		Abstract_Literal b = (Abstract_Literal) fofvisitor.visitLiteral(fofparser_b.literal());
		return b;
		
	}
	
	@Override public Object visitJson_file(Json_fileContext ctx) {
		return ctx.FILE_BLOCK().getText();
	}

	
	private LogicalFmlasParser fofparser(String s) {
		LogicalFmlasLexer lexer = new LogicalFmlasLexer(CharStreams.fromString(s));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		LogicalFmlasParser parser = new LogicalFmlasParser(tokens);
		return parser;
	}

}
