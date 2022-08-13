package gwendolen.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.TerminalNode;

import ail.parser.FOFVisitor;
import ail.syntax.ast.Abstract_Deed;
import ail.syntax.ast.Abstract_Event;
import ail.syntax.ast.Abstract_GBelief;
import ail.syntax.ast.Abstract_Goal;
import ail.syntax.ast.Abstract_GLogicalFormula;
import ail.syntax.ast.Abstract_Guard;
import ail.syntax.ast.Abstract_Literal;
import ail.syntax.ast.Abstract_MAS;
import ail.syntax.ast.Abstract_Rule;
import ail.syntax.ast.Abstract_StringTerm;
import ail.syntax.ast.Abstract_StringTermImpl;
import ail.syntax.ast.Abstract_VarTerm;
import ajpf.psl.parser.LogicalFmlasLexer;
import ajpf.psl.parser.LogicalFmlasParser;
import gwendolen.syntax.ast.Abstract_GPlan;
//import gwendolen.parser.GwendolenParser.Initial_goalContext;
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
		String name = ctx.CONST().getText();
		// System.err.println(name);
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
			
/*			if (ctx.BELIEFRULES() != null) {
				List<TerminalNode> rrblocks = ctx.RR_BLOCK();
				for (TerminalNode rr: rrblocks) {
					LogicalFmlasParser fofparser_brs = fofparser(rr.getText());
					ArrayList<Abstract_Rule> brs = (ArrayList<Abstract_Rule>) fofvisitor.visitRulelist(fofparser_brs.rulelist());
					for (Abstract_Rule r: brs) {
						g.addRule(r);
					}
				}
			} */
			
			List<GwendolenParser.Initial_goalContext> goals = ctx.initial_goal();
			for (GwendolenParser.Initial_goalContext gctx: goals) {
				Abstract_Goal goal = (Abstract_Goal) visitInitial_goal(gctx);
				g.addInitialGoal(goal);
			}
			
			List<GwendolenParser.PlanContext> plans = ctx.plan();
			for (GwendolenParser.PlanContext pctx: plans) {
				Abstract_GPlan plan = (Abstract_GPlan) visitPlan(pctx);
				g.addPlan(plan);
			}
			
			return g;
		} catch (Exception e) {
			System.err.println(e);
			agentname = new Abstract_StringTermImpl(name);
			return name;
		}
		
	}
	
	//goal returns [Abstract_Goal g] : l=literal SQOPEN (ACHIEVEGOAL {$g = new Abstract_Goal($l.l, Abstract_Goal.achieveGoal);} | 
	//		PERFORMGOAL {$g = new Abstract_Goal($l.l, Abstract_Goal.performGoal);}) SQCLOSE;
	@Override public Object visitInitial_goal(GwendolenParser.Initial_goalContext ctx) {
		LogicalFmlasParser fofparser_gl = fofparser(ctx.g.getText());
		FOFVisitor fofvisitor = new FOFVisitor();
		
		Abstract_Literal g_lit = (Abstract_Literal) fofvisitor.visitLiteral(fofparser_gl.literal());
		if (ctx.GL_ACHIEVEGOAL() != null) {
			return new Abstract_Goal(g_lit, Abstract_Goal.achieveGoal);
		} else {
			return new Abstract_Goal(g_lit, Abstract_Goal.performGoal);
		}

		
	}
	
	
	//plan returns [Abstract_GPlan p]
	//		: e=event  {ArrayList<Abstract_Deed> deeds=new ArrayList<Abstract_Deed>(); Abstract_Guard g = new Abstract_Guard();} 
	//			COLON CURLYOPEN {boolean gneg=true;} (NOT {gneg=false;})? gb=guard_atom {g.add($gb.g, gneg);} 
	//			(COMMA {gneg=true;} (NOT {gneg=false;})? gb=guard_atom {g.add($gb.g, gneg);})* CURLYCLOSE (RULEARROW
	//		d=deed {deeds.add($d.d);} (COMMA d=deed {deeds.add($d.d);})*)? 
	//		SEMI {$p = new Abstract_GPlan($e.e, g, deeds); $p.reverseBody(); variables.clear();};

	@Override public Object visitPlan(GwendolenParser.PlanContext ctx) {
		Abstract_Event event = (Abstract_Event) visitEvent(ctx.event());
		List<GwendolenParser.Guard_atomContext> ga_ctxs = ctx.guard_atom();
		Abstract_Guard guard = new Abstract_Guard();
		for (GwendolenParser.Guard_atomContext ga_ctx: ga_ctxs) {
			boolean gneg = true;
			if (ga_ctx.NOT() != null) {
				gneg = false;
			}
			guard.add((Abstract_GLogicalFormula) visitGuard_atom(ga_ctx), gneg);
		}
		
		ArrayList<Abstract_Deed> deeds=new ArrayList<Abstract_Deed>();
		List<GwendolenParser.DeedContext> d_ctxs = ctx.deed();
		for (GwendolenParser.DeedContext d_ctx: d_ctxs) {
			deeds.add((Abstract_Deed) visitDeed(d_ctx));
		}
		
		Abstract_GPlan p = new Abstract_GPlan(event, guard, deeds);
		p.reverseBody();
		variables.clear();
		return p;
	}
	
	/* guard_atom returns [Abstract_GLogicalFormula g] : (BELIEVE l=literal {$g = new Abstract_GBelief($l.l);} |
			GOAL gl=goal {$g = new Abstract_Goal($gl.g);} |
			SENT OPEN {Abstract_StringTerm an1=agentname;} (s=agentnameterm {an1 = s;}) 
			                        COMMA {Abstract_StringTerm agn = agentname;} (an2=agentnameterm 
				COMMA {agn = an2;})? p=performative 
				COMMA t=pred CLOSE {$g = new Abstract_GuardMessage(Abstract_BaseAILStructure.AILSent, agn, an1, $p.b, $t.t);} |
			eq = equation {$g = $eq.eq;} |
			TRUE {$g = new Abstract_GBelief();} ); */
	@Override public Object visitGuard_atom(GwendolenParser.Guard_atomContext ctx) {
		if (ctx.BELIEVE() != null) {
			LogicalFmlasParser fofparser_b = fofparser(ctx.l.getText());
			FOFVisitor fofvisitor = new FOFVisitor();
			
			Abstract_Literal b_lit = (Abstract_Literal) fofvisitor.visitLiteral(fofparser_b.literal());
			return new Abstract_GBelief(b_lit);
		} else if (ctx.GOAL() != null) {
			return visitGoal(ctx.gl);
		} else {
			return null;
		}
	}

	@Override public Object visitGoal(GwendolenParser.GoalContext ctx) {
		LogicalFmlasParser fofparser_gl = fofparser(ctx.g.getText());
		FOFVisitor fofvisitor = new FOFVisitor();
		
		Abstract_Literal g_lit = (Abstract_Literal) fofvisitor.visitLiteral(fofparser_gl.literal());
		if (ctx.PL_ACHIEVEGOAL() != null) {
			return new Abstract_Goal(g_lit, Abstract_Goal.achieveGoal);
		} else {
			return new Abstract_Goal(g_lit, Abstract_Goal.performGoal);
		}

		
	}


	
	private LogicalFmlasParser fofparser(String s) {
		LogicalFmlasLexer lexer = new LogicalFmlasLexer(CharStreams.fromString(s));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		LogicalFmlasParser parser = new LogicalFmlasParser(tokens);
		return parser;
	}

}
