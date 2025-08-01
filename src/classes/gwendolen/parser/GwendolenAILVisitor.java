package gwendolen.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.TerminalNode;

import ail.parser.FOFVisitor;
import ail.syntax.ast.Abstract_Action;
import ail.syntax.ast.Abstract_BaseAILStructure;
import ail.syntax.ast.Abstract_Deed;
import ail.syntax.ast.Abstract_Equation;
import ail.syntax.ast.Abstract_Event;
import ail.syntax.ast.Abstract_GBelief;
import ail.syntax.ast.Abstract_Goal;
import ail.syntax.ast.Abstract_GLogicalFormula;
import ail.syntax.ast.Abstract_Guard;
import ail.syntax.ast.Abstract_GuardMessage;
import ail.syntax.ast.Abstract_Literal;
import ail.syntax.ast.Abstract_MAS;
import ail.syntax.ast.Abstract_Predicate;
import ail.syntax.ast.Abstract_Rule;
import ail.syntax.ast.Abstract_SendAction;
import ail.syntax.ast.Abstract_StringTerm;
import ail.syntax.ast.Abstract_StringTermImpl;
import ail.syntax.ast.Abstract_VarTerm;
import ajpf.psl.parser.LogicalFmlasLexer;
import ajpf.psl.parser.LogicalFmlasParser;
import gwendolen.syntax.ast.Abstract_GMessage;
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
		agentname = new Abstract_StringTermImpl(name);
		// System.err.println(name);
		try {
			Abstract_GwendolenAgent g = new Abstract_GwendolenAgent(name);
		
		
			FOFVisitor fofvisitor = new FOFVisitor();
	
			if (ctx.bs != null) {
				List<TerminalNode> beliefblocks = ctx.BELIEF_BLOCK();
				for (TerminalNode bb: beliefblocks) { 
					LogicalFmlasParser fofparser_bs = fofparser(bb.getText());
					ArrayList<Abstract_Literal> bs = (ArrayList<Abstract_Literal>) fofvisitor.visitLitlist_poss_empty(fofparser_bs.litlist_poss_empty());
					for (Abstract_Literal l: bs) {
						g.addInitialBel(l); 
					}
				}
			} 
			
			if (ctx.rr != null) {
				List<TerminalNode> rrblocks = ctx.RR_BLOCK();
				for (TerminalNode rr: rrblocks) {
					LogicalFmlasParser fofparser_brs = fofparser(rr.getText());
					ArrayList<Abstract_Rule> brs = (ArrayList<Abstract_Rule>) fofvisitor.visitRulelist_poss_empty(fofparser_brs.rulelist_poss_empty());
					for (Abstract_Rule r: brs) {
						g.addRule(r);
					}
				}
			} 
			
			List<GwendolenParser.Initial_goalContext> goals = ctx.initial_goal();
			for (GwendolenParser.Initial_goalContext gctx: goals) {
				Abstract_Goal goal = (Abstract_Goal) visitInitial_goal(gctx);
				// System.out.println("Addingin initial goal");
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
		FOFVisitor fofvisitor = new FOFVisitor();
		if (ctx.BELIEVE() != null) {
			LogicalFmlasParser fofparser_b = fofparser(ctx.l.getText());
			
			Abstract_Literal b_lit = (Abstract_Literal) fofvisitor.visitLiteral(fofparser_b.literal());
			return new Abstract_GBelief(b_lit);
		} else if (ctx.GOAL() != null) {
			return visitGoal(ctx.gl);
		} else if (ctx.TRUE() != null) { 
			return new Abstract_GBelief();
		} else if (ctx.eq != null) {
			String eq_text = ctx.eq.getText();
			LogicalFmlasParser fofparser_e = fofparser(ctx.eq.getText());
			Abstract_Equation e = (Abstract_Equation) fofvisitor.visitEquation(fofparser_e.equation());
			return e;
		} else if (ctx.SENT() != null) {
			// LogicalFmlasParser name1parser = fofparser(ctx.s.getText());
			Abstract_StringTerm s = (Abstract_StringTerm) visitAgentnameterm(ctx.s);
			Abstract_StringTerm an1 = agentname;
			if (ctx.an2 != null) {
				an1 = (Abstract_StringTerm) visitAgentnameterm(ctx.an2);
			}
			Integer p = (Integer) visitPerformative(ctx.p);
			LogicalFmlasParser content_parser = fofparser(ctx.t.getText());
			Abstract_Predicate t = (Abstract_Predicate) fofvisitor.visitPred(content_parser.pred());
			Abstract_GuardMessage g = new Abstract_GuardMessage(Abstract_BaseAILStructure.AILSent, an1, s, p, t);
			return g;
		} else {
			return null;
		}
	}
	
	@Override public Object visitAgentnameterm(GwendolenParser.AgentnametermContext ctx) {
		if (ctx.PL_CONST() != null) {
			return new Abstract_StringTermImpl(ctx.PL_CONST().getText());
		} else {
			return new Abstract_VarTerm(ctx.PL_VAR().getText());
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
	
	//event returns [Abstract_Event e] : (PLUS (RECEIVED OPEN p=performative COMMA t=pred CLOSE 
	//		{Abstract_GMessage message = new Abstract_GMessage(new Abstract_VarTerm("From"), 
	//			new Abstract_VarTerm("To"), $p.b, $t.t); 
	//			$e = new Abstract_Event(Abstract_Event.AILAddition, 
	//			Abstract_Event.AILReceived, message);}|
	//	(l=literal {$e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILBel, $l.l);} |
	//	SHRIEK g=goal {$e = new Abstract_Event(Abstract_Event.AILAddition, $g.g);}) |
	//	ADD_CONTENT l=literal {$e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILContent, $l.l);} |
	//	ADD_CONTEXT l=literal {$e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILContext, $l.l);}
	//	) |
	  // MINUS (l=literal {$e = new Abstract_Event(Abstract_Event.AILDeletion, Abstract_Event.AILBel, $l.l);} |
	//	SHRIEK g=goal {$e = new Abstract_Event(Abstract_Event.AILDeletion, $g.g);} |
	//	ADD_CONTENT l=literal {$e = new Abstract_Event(Abstract_Event.AILDeletion, Abstract_Event.AILContent, $l.l);} |
	//	ADD_CONTEXT l=literal {$e = new Abstract_Event(Abstract_Event.AILDeletion, Abstract_Event.AILContext, $l.l);}
	//	));

	@Override public Object visitEvent(GwendolenParser.EventContext ctx) {
		FOFVisitor visitor = new FOFVisitor();
		if (ctx.PLUS() != null) {
			if (ctx.SHRIEK() != null) {
				return new Abstract_Event(Abstract_Event.AILAddition, (Abstract_Goal) visitGoal(ctx.goal()));
			} else if (ctx.RECEIVED() != null ) {
				LogicalFmlasParser fof_parser = fofparser(ctx.t.getText());
				Abstract_GMessage message = new Abstract_GMessage(new Abstract_VarTerm("From"), new Abstract_VarTerm("To"), (int) visitPerformative(ctx.p), (Abstract_Predicate) visitor.visitPred(fof_parser.pred()));	
				return new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILReceived, message);
						
			} else {
				LogicalFmlasParser fof_parser = fofparser(ctx.l.getText());
				return new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILBel, (Abstract_Literal) visitor.visitLiteral(fof_parser.literal())); 
			}
		} else if (ctx.MINUS() != null) {
			if (ctx.SHRIEK() != null) {
				return new Abstract_Event(Abstract_Event.AILDeletion, (Abstract_Goal) visitGoal(ctx.goal()));
			} else {
				LogicalFmlasParser fof_parser = fofparser(ctx.l.getText());
				return new Abstract_Event(Abstract_Event.AILDeletion, Abstract_Event.AILBel, (Abstract_Literal) visitor.visitLiteral(fof_parser.literal())); 
			}
		}
		return null;
	}
	
	/* performative returns [int b] : (TELL {$b=1;} | PERFORM {$b=2;} | ACHIEVE {$b = 3;} | TELLHOW {$b = 4;} | CONSTRAINT {$b = 5;}); */
	@Override public Object visitPerformative(GwendolenParser.PerformativeContext ctx) {
		if (ctx.TELL() != null) {
			return 1;
		} else if (ctx.PL_PERFORMGOAL() != null) {
			return 2;
		} else {
			return 3;
		}
	}

	/* deed returns [Abstract_Deed d] : (((PLUS (l=literal {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILBel, $l.l);} |
			SHRIEK g=goal {$d = new Abstract_Deed(Abstract_Deed.AILAddition, $g.g);} |
			ADD_CONTENT l=literal {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILContent, $l.l);} |
			ADD_CONTEXT l=literal {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILContext, $l.l);} |
			ADD_PLAN p=literal {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILPlan, $p.l);} |
			ADD_CONSTRAINT c=literal {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILConstraint, $c.l);} |
			LOCK {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dlock);}) |
		   MINUS (l=literal {$d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILBel, $l.l);} |
			SHRIEK g=goal {$d = new Abstract_Deed(Abstract_Deed.AILDeletion, $g.g);} |
			ADD_CONTENT l=literal {$d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILContent, $l.l);} |
			ADD_CONTEXT l=literal {$d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILContext, $l.l);} |
			LOCK {$d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.Dlock);}
			)) |
			a=action {$d = new Abstract_Deed($a.a);}) |
			wf=waitfor {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dwaitfor, $wf.wf);}
			)
			; */
	@Override public Object visitDeed(GwendolenParser.DeedContext ctx) {
		if (ctx.PLUS() != null) {
			if (ctx.SHRIEK() != null) {
				return new Abstract_Deed(Abstract_Deed.AILAddition, (Abstract_Goal) visitGoal(ctx.g));
			} else if (ctx.LOCK() != null) {
				return new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dlock);
			} else {
				LogicalFmlasParser fofparser = fofparser(ctx.l.getText());
				FOFVisitor fofvisitor = new FOFVisitor();
				return new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILBel, (Abstract_Literal) fofvisitor.visitLiteral(fofparser.literal()));
			}
		} else if (ctx.MINUS() != null) {
			if (ctx.SHRIEK() != null) {
				return new Abstract_Deed(Abstract_Deed.AILDeletion, (Abstract_Goal) visitGoal(ctx.g));
			} else if (ctx.LOCK() != null) {
				return new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.Dlock);
			} else {
				LogicalFmlasParser fofparser = fofparser(ctx.l.getText());
				FOFVisitor fofvisitor = new FOFVisitor();
				return new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILBel, (Abstract_Literal) fofvisitor.visitLiteral(fofparser.literal()));
			}
		} else if (ctx.wf != null) {
			return new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dwaitfor, (Abstract_Literal) visitWaitfor(ctx.wf));
		} else {
			return new Abstract_Deed((Abstract_Action) visitAction(ctx.a));
		}
	}
	
	/* action returns [Abstract_Action a] : 
		(SEND OPEN an=literal COMMA p=performative COMMA t=pred CLOSE {$a = new Abstract_SendAction($an.l, $p.b, $t.t);}) | 
		t=pred {$a = new Abstract_Action($t.t, Abstract_Action.normalAction);}; */
	@Override public Object visitAction(GwendolenParser.ActionContext ctx) {
		LogicalFmlasParser fofparser = fofparser(ctx.t.getText());
		FOFVisitor visitor = new FOFVisitor();
		
		if (ctx.SEND() != null) {
			LogicalFmlasParser an_parser = fofparser(ctx.an.getText());
			return new Abstract_SendAction((Abstract_Predicate) visitor.visitPred(an_parser.pred()), (Integer) visitPerformative(ctx.p), (Abstract_Predicate) visitor.visitPred(fofparser.pred()));
		} 
		
		Abstract_Predicate action_pred = (Abstract_Predicate) visitor.visitPred(fofparser.pred());		
		Abstract_Action a = new Abstract_Action(action_pred, Abstract_Action.normalAction);
		return a;
	}

/* waitfor returns [Abstract_Literal wf] :  MULT l=literal {$wf = $l.l;}; */
	@Override public Object visitWaitfor(GwendolenParser.WaitforContext ctx) {
		String text = ctx.l.getText();
		LogicalFmlasParser fofparser = fofparser(ctx.l.getText());
		FOFVisitor visitor = new FOFVisitor();
		

		Abstract_Literal l = (Abstract_Literal) visitor.visitLiteral(fofparser.literal());
		if (ctx.NOT() != null) {
			l.setNegated(Abstract_Literal.LNeg);
		}
		return l;
	}
	
	private LogicalFmlasParser fofparser(String s) {
		LogicalFmlasLexer lexer = new LogicalFmlasLexer(CharStreams.fromString(s));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		LogicalFmlasParser parser = new LogicalFmlasParser(tokens);
		return parser;
	}

}
