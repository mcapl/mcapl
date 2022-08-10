package gwendolen.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.TerminalNode;

import ail.parser.FOFVisitor;
import ail.syntax.ast.Abstract_Goal;
import ail.syntax.ast.Abstract_Literal;
import ail.syntax.ast.Abstract_MAS;
import ail.syntax.ast.Abstract_Rule;
import ail.syntax.ast.Abstract_StringTerm;
import ail.syntax.ast.Abstract_StringTermImpl;
import ail.syntax.ast.Abstract_VarTerm;
import ajpf.psl.parser.LogicalFmlasLexer;
import ajpf.psl.parser.LogicalFmlasParser;
import gwendolen.parser.GwendolenParser.Initial_goalContext;
import gwendolen.syntax.ast.Abstract_GwendolenAgent;

public class GwendolenAILVisitor extends GwendolenBaseVisitor<Object> {
	private static HashMap<String,Abstract_VarTerm> variables = new HashMap<String,Abstract_VarTerm>();
	private Abstract_StringTerm agentname = new Abstract_StringTermImpl("");

	// mas  :  aoagents;
	@Override public Object visitMas(GwendolenParser.MasContext ctx) { 
		Abstract_MAS mas = new Abstract_MAS();
		ArrayList<Abstract_GwendolenAgent> gags = (ArrayList<Abstract_GwendolenAgent>) visitGwendolenagents(ctx.gwendolenagents()); 
		mas.setAgs(gags);
		return mas;
	}
	
	// gwendolenagents returns[ArrayList<Abstract_GwendolenAgent> gags]: GWENDOLEN 
	// {gags=new ArrayList<Abstract_GwendolenAgent>();} 
	// (g=gwendolenagent {gags.add($g.g);})+;
	@Override public Object visitGwendolenagents(GwendolenParser.GwendolenagentsContext ctx) {
		ArrayList<Abstract_GwendolenAgent> gags = new ArrayList<Abstract_GwendolenAgent>();
		List<GwendolenParser.GwendolenagentContext> gctxs = ctx.gwendolenagent();
		for (GwendolenParser.GwendolenagentContext gctx: gctxs) {
			Abstract_GwendolenAgent g = (Abstract_GwendolenAgent) visitGwendolenagent(gctx);
			gags.add(g);
		}
		return gags;
	}

	// Gwendolen Agent stuff
	// gwendolenagent returns [Abstract_GwendolenAgent g] : 
	//        (GWENDOLEN?) 
	//	NAME w=word {try {$g = new Abstract_GwendolenAgent($w.s);} 
	//		catch (Exception e) {System.err.println(e); agentname = new Abstract_StringTermImpl($w.s);}}
	//	BELIEFS (l=literal {$g.addInitialBel($l.l);})*
	//	(BELIEFRULES (r=brule {$g.addRule($r.r);})*)?
	//	GOALS (gl=goal {$g.addInitialGoal($gl.g);})*
	//	PLANS (p=plan {try {$g.addPlan($p.p);} catch (Exception e) {System.err.println(e);}})*;
	@Override public Object visitGwendolenagent(GwendolenParser.GwendolenagentContext ctx) {
		String name = ctx.word().getText();
		try {
			Abstract_GwendolenAgent g = new Abstract_GwendolenAgent(name);
		
		
			FOFVisitor fofvisitor = new FOFVisitor();
	
			if (ctx.bs != null) {
				List<TerminalNode> beliefblocks = ctx.BELIEF_BLOCK();
				for (TerminalNode bb: beliefblocks) {
					LogicalFmlasParser fofparser_bs = fofparser(bb.getText());
					ArrayList<Abstract_Literal> bs = (ArrayList<Abstract_Literal>) fofvisitor.visitLitlist(fofparser_bs.litlist());
					for (Abstract_Literal l: bs) {
						g.addInitialBel(l);
					}
				}
			} 
			
			if (ctx.BELIEFRULES() != null) {
				List<TerminalNode> rrblocks = ctx.RR_BLOCK();
				for (TerminalNode rr: rrblocks) {
					LogicalFmlasParser fofparser_brs = fofparser(rr.getText());
					ArrayList<Abstract_Rule> brs = (ArrayList<Abstract_Rule>) fofvisitor.visitRulelist(fofparser_brs.rulelist());
					for (Abstract_Rule r: brs) {
						g.addRule(r);
					}
				}
			} 
			
			List<GwendolenParser.Initial_goalContext> goals = ctx.initial_goal();
			for (Initial_goalContext gctx: goals) {
				Abstract_Goal goal = (Abstract_Goal) visitInitial_goal(gctx);
				g.addInitialGoal(goal);
			}
			
			return g;
		} catch (Exception e) {
			System.err.println(e);
			agentname = new Abstract_StringTermImpl(name);
			return name;
		}
		
	}

	
	private LogicalFmlasParser fofparser(String s) {
		LogicalFmlasLexer lexer = new LogicalFmlasLexer(CharStreams.fromString(s));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		LogicalFmlasParser parser = new LogicalFmlasParser(tokens);
		return parser;
	}

}
