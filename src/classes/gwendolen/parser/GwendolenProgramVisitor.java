// ----------------------------------------------------------------------------
// Copyright (C) 2018 Louise A. Dennis and Michael Fisher and 
// Rafael H. Bordini.
// 
// This file is part of Gwendolen
//
// Gwendolen is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Gwendolen is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with Gwendolen if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------
package gwendolen.parser;

import java.util.ArrayList;
import java.util.HashMap;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import ail.parser.FOFVisitor;
import ail.syntax.ast.Abstract_Action;
import ail.syntax.ast.Abstract_BaseAILStructure;
import ail.syntax.ast.Abstract_Deed;
import ail.syntax.ast.Abstract_Equation;
import ail.syntax.ast.Abstract_Event;
import ail.syntax.ast.Abstract_GBelief;
import ail.syntax.ast.Abstract_GLogicalFormula;
import ail.syntax.ast.Abstract_Goal;
import ail.syntax.ast.Abstract_Guard;
import ail.syntax.ast.Abstract_GuardAtom;
import ail.syntax.ast.Abstract_GuardMessage;
import ail.syntax.ast.Abstract_Literal;
import ail.syntax.ast.Abstract_LogicalFormula;
import ail.syntax.ast.Abstract_MAS;
import ail.syntax.ast.Abstract_Pred;
import ail.syntax.ast.Abstract_Predicate;
import ail.syntax.ast.Abstract_Rule;
import ail.syntax.ast.Abstract_SendAction;
import ail.syntax.ast.Abstract_StringTerm;
import ail.syntax.ast.Abstract_StringTermImpl;
import ail.syntax.ast.Abstract_UnnamedVar;
import ail.syntax.ast.Abstract_VarTerm;
import ail.util.Tuple;
import ajpf.psl.parser.LogicalFmlasLexer;
import ajpf.psl.parser.LogicalFmlasParser;
import gwendolen.syntax.ast.Abstract_GMessage;
import gwendolen.syntax.ast.Abstract_GPlan;
import gwendolen.syntax.ast.Abstract_GwendolenAgent;

public class GwendolenProgramVisitor extends GwendolenBaseVisitor<Object> {
	private Abstract_StringTerm agentname = new Abstract_StringTermImpl("");;
	private static HashMap<String,Abstract_VarTerm> variables = new HashMap<String,Abstract_VarTerm>();

	// Mas involving Gwendolen Agents
	// mas returns [Abstract_MAS mas] : {$mas = new Abstract_MAS();} 
	//	glist=gwendolenagents {$mas.setAgs($glist.gags);};
	@Override public Object visitMas(GwendolenParser.MasContext ctx) {
		Abstract_MAS mas = new Abstract_MAS();
		ArrayList<Abstract_GwendolenAgent> glist = (ArrayList<Abstract_GwendolenAgent>) visitGwendolenagents(ctx.glist);
		mas.setAgs(glist);
		return mas;
	}

	//gwendolenagents returns[ArrayList<Abstract_GwendolenAgent> gags]: GWENDOLEN 
	//	{gags=new ArrayList<Abstract_GwendolenAgent>();} 
	//	(g=gwendolenagent {gags.add($g.g);})+;
	@Override public Object visitGwendolenagents(GwendolenParser.GwendolenagentsContext ctx) {
		ArrayList<Abstract_GwendolenAgent> gags = new ArrayList<Abstract_GwendolenAgent>();
		for (GwendolenParser.GwendolenagentContext g: ctx.gwendolenagent()) {
			gags.add((Abstract_GwendolenAgent) visitGwendolenagent(g));
		}
		return gags;
	}

	// Gwendolen Agent stuff
	//gwendolenagent returns [Abstract_GwendolenAgent g] : 
	 //       (GWENDOLEN?) 
	//	NAME w=word {try {$g = new Abstract_GwendolenAgent($w.s);} 
	// catch (Exception e) {System.err.println(e); agentname = new Abstract_StringTermImpl($w.s);}}
	//	BELIEFS (l=literal {$g.addInitialBel($l.l);})*
	//	(BELIEFRULES (r=brule {$g.addRule($r.r);})*)?
	//	GOALS (gl=goal {$g.addInitialGoal($gl.g);})*
	//	PLANS (p=plan {try {$g.addPlan($p.p);} catch (Exception e) {System.err.println(e);}})*;
	@Override public Object visitGwendolenagent(GwendolenParser.GwendolenagentContext ctx) {
		Abstract_GwendolenAgent g = null;
		try {
			g = new Abstract_GwendolenAgent((String) visitWord(ctx.w));
		} catch (Exception e) {
			System.err.println(e);
			agentname = new Abstract_StringTermImpl((String) visitWord(ctx.w));
		}
		
		FOFVisitor fofvisitor = new FOFVisitor();
		for (GwendolenParser.Fof_exprContext fof_expr : ctx.fof_expr()) {
			LogicalFmlasParser fof_parser = fofparser(fof_expr.getText());
			Abstract_Literal l = (Abstract_Literal) fofvisitor.visitLiteral(fof_parser.literal());
			g.addInitialBel(l);
		}
		
		if (ctx.brule() != null) {
			for (GwendolenParser.BruleContext r: ctx.brule()) {
				g.addRule((Abstract_Rule) visitBrule(r));
			}
		}
		
		for (GwendolenParser.GoalContext gl: ctx.goal()) {
			g.addInitialGoal((Abstract_Goal) visitGoal(gl));
		}
		
		for (GwendolenParser.PlanContext p: ctx.plan()) {
			try {
				g.addPlan((Abstract_GPlan) visitPlan(p));
			} catch (Exception e) {
				System.err.println(e);
			}
		}
		
		return g;
		
	}
		

	//guard_atom returns [Abstract_GLogicalFormula g] : (BELIEVE l=literal {$g = new Abstract_GBelief($l.l);} |
	//				GOAL gl=goal {$g = new Abstract_Goal($gl.g);} |
	//				SENT OPEN {Abstract_StringTerm an1=agentname;} (s=agentnameterm {an1 = s;}) 
	//				                        COMMA {Abstract_StringTerm agn = agentname;} (an2=agentnameterm 
	//					COMMA {agn = an2;})? p=performative 
	//					COMMA t=pred CLOSE {$g = new Abstract_GuardMessage(Abstract_BaseAILStructure.AILSent, agn, an1, $p.b, $t.t);} |
	//				eq = equation {$g = $eq.eq;} |
	//				TRUE {$g = new Abstract_GBelief();} );
	//				
	@Override public Object visitGuard_atom(GwendolenParser.Guard_atomContext ctx) {
		Abstract_GLogicalFormula g = null;
		
		FOFVisitor fofvisitor = new FOFVisitor();
		if (ctx.l != null) {
			LogicalFmlasParser fof_parser = fofparser(ctx.l.getText());
			Abstract_Literal lit = (Abstract_Literal) fofvisitor.visitLiteral(fof_parser.literal());
			g = new Abstract_GBelief(lit);
		}
		
		if (ctx.gl != null) {
			g = new Abstract_Goal((Abstract_Goal) visitGoal(ctx.gl));
		}
		
		if (ctx.SENT() != null) {
			String agname = ctx.s.getText();
			Abstract_StringTerm an1 = agname_to_stringterm(agname);
		
			Abstract_StringTerm agn = agentname;
			if (ctx.an2 != null) {
				agn = agname_to_stringterm(ctx.an2.getText());
			}
			Integer p = (Integer) visitPerformative(ctx.p);
			
			LogicalFmlasParser t_parser = fofparser(ctx.t.getText());
			Abstract_Predicate pred = (Abstract_Predicate) fofvisitor.visitPred(t_parser.pred());
			g = new Abstract_GuardMessage(Abstract_BaseAILStructure.AILSent, agn, an1, p, pred);
		}
		
		if (ctx.eq != null) {
			LogicalFmlasParser eq_parser = fofparser(ctx.eq.getText());
			g = (Abstract_Equation) fofvisitor.visitEquation(eq_parser.equation());
		}
		
		if (ctx.TRUE() != null) {
			g = new Abstract_GBelief();
		}
		
		return g;
	}
	
	private Abstract_StringTerm agname_to_stringterm(String agname) {
		if (Character.isUpperCase(agname.charAt(0))) {
			return new Abstract_VarTerm(agname);
		} else if (Character.isLowerCase(agname.charAt(0))){
			return new Abstract_StringTermImpl(agname);
		} else {
			return new Abstract_UnnamedVar();
		}
	}

	///goal returns [Abstract_Goal g] : l=literal SQOPEN (ACHIEVEGOAL {$g = new Abstract_Goal($l.l, Abstract_Goal.achieveGoal);} | 
	//			PERFORMGOAL {$g = new Abstract_Goal($l.l, Abstract_Goal.performGoal);}) SQCLOSE;	
	@Override public Object visitGoal(GwendolenParser.GoalContext ctx) {
		FOFVisitor fofvisitor = new FOFVisitor();
		LogicalFmlasParser fof_parser = fofparser(ctx.l.getText());
		Abstract_Literal lit = (Abstract_Literal) fofvisitor.visitLiteral(fof_parser.literal());
		
		if (ctx.ACHIEVEGOAL() != null) {
			return new Abstract_Goal(lit, Abstract_Goal.achieveGoal);
		} else {
			return new Abstract_Goal(lit, Abstract_Goal.performGoal);
		}
		
		
	}
	
	//plan returns [Abstract_GPlan p]
	//	: e=event  {ArrayList<Abstract_Deed> deeds=new ArrayList<Abstract_Deed>(); Abstract_Guard g = new Abstract_Guard();} 
	//		COLON CURLYOPEN {boolean gneg=true;} (NOT {gneg=false;})? gb=guard_atom {g.add($gb.g, gneg);} 
	//		(COMMA {gneg=true;} (NOT {gneg=false;})? gb=guard_atom {g.add($gb.g, gneg);})* CURLYCLOSE (RULEARROW
	//	d=deed {deeds.add($d.d);} (COMMA d=deed {deeds.add($d.d);})*)? 
	//	SEMI {$p = new Abstract_GPlan($e.e, g, deeds); $p.reverseBody(); variables.clear();};
	@Override public Object visitPlan(GwendolenParser.PlanContext ctx) {
		ArrayList<Abstract_Deed> deeds=new ArrayList<Abstract_Deed>();
		Abstract_Guard g = new Abstract_Guard();
		for (GwendolenParser.Pn_guard_atomContext g_ctx: ctx.pn_guard_atom()) {
				Tuple<Abstract_GuardAtom, Boolean> png1 = (Tuple<Abstract_GuardAtom, Boolean>) visitPn_guard_atom(g_ctx); 
				g.add(png1.getLeft(), png1.getRight());
		}
		
		for (GwendolenParser.DeedContext d: ctx.deed()) {
			deeds.add((Abstract_Deed) visitDeed(d));
		}
		
		Abstract_GPlan p = new Abstract_GPlan((Abstract_Event) visitEvent(ctx.e), g, deeds);
		p.reverseBody();
		variables.clear();
		return p;
	
	}
	
	@Override public Object visitPn_guard_atom(GwendolenParser.Pn_guard_atomContext ctx) {
		boolean gneg = true;
		if (ctx.NOT() != null) {
			gneg = false;
		}
		Abstract_GuardAtom ga = (Abstract_GuardAtom) visitGuard_atom(ctx.gb);
		return new Tuple<Abstract_GuardAtom, Boolean>(ga, gneg);
		
	}
		
	//event returns [Abstract_Event e] : (PLUS (RECEIVED OPEN p=performative COMMA t=pred CLOSE 
	//					{Abstract_GMessage message = new Abstract_GMessage(new Abstract_VarTerm("From"), 
	//						new Abstract_VarTerm("To"), $p.b, $t.t); 
	//						$e = new Abstract_Event(Abstract_Event.AILAddition, 
	//						Abstract_Event.AILReceived, message);}|
	//				(l=literal {$e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILBel, $l.l);} |
	//				SHRIEK g=goal {$e = new Abstract_Event(Abstract_Event.AILAddition, $g.g);}) |
	//				ADD_CONTENT l=literal {$e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILContent, $l.l);} |
	//				ADD_CONTEXT l=literal {$e = new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILContext, $l.l);}
	//				) |
	//			   MINUS (l=literal {$e = new Abstract_Event(Abstract_Event.AILDeletion, Abstract_Event.AILBel, $l.l);} |
	//				SHRIEK g=goal {$e = new Abstract_Event(Abstract_Event.AILDeletion, $g.g);} |
	//				ADD_CONTENT l=literal {$e = new Abstract_Event(Abstract_Event.AILDeletion, Abstract_Event.AILContent, $l.l);} |
	//				ADD_CONTEXT l=literal {$e = new Abstract_Event(Abstract_Event.AILDeletion, Abstract_Event.AILContext, $l.l);}
	//				));
	@Override public Object visitEvent(GwendolenParser.EventContext ctx) {
		FOFVisitor fofvisitor = new FOFVisitor();
		if (ctx.PLUS() != null) {
			if (ctx.RECEIVED() != null) {
				LogicalFmlasParser t_parser = fofparser(ctx.t.getText());
				Abstract_Predicate pred = (Abstract_Predicate) fofvisitor.visitPred(t_parser.pred());
				Abstract_GMessage message = new Abstract_GMessage(new Abstract_VarTerm("From"), new Abstract_VarTerm("To"), (Integer) visitPerformative(ctx.p), pred); 
				return new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILReceived, message);
			}
			
			if (ctx.SHRIEK() != null) {
				return new Abstract_Event(Abstract_Event.AILAddition, (Abstract_Goal) visitGoal(ctx.g));
			}
			
			LogicalFmlasParser l_parser = fofparser(ctx.l.getText());
			Abstract_Literal lit = (Abstract_Literal) fofvisitor.visitLiteral(l_parser.literal());
			return new Abstract_Event(Abstract_Event.AILAddition, Abstract_Event.AILBel, lit);
		} else {
			if (ctx.SHRIEK() != null) {
				return new Abstract_Event(Abstract_Event.AILDeletion, (Abstract_Goal) visitGoal(ctx.g));
			}
			
			LogicalFmlasParser l_parser = fofparser(ctx.l.getText());
			Abstract_Literal lit = (Abstract_Literal) fofvisitor.visitLiteral(l_parser.literal());
			return new Abstract_Event(Abstract_Event.AILDeletion, Abstract_Event.AILBel, lit);
		}
		
	}

	//performative returns [int b] : (TELL {$b=1;} | PERFORM {$b=2;} | ACHIEVE {$b = 3;} | TELLHOW {$b = 4;} | CONSTRAINT {$b = 5;});
	@Override public Integer visitPerformative(GwendolenParser.PerformativeContext ctx) {
		if (ctx.TELL() != null) {
			return 1;
		} else if (ctx.PERFORM() != null) {
			return 2;
		} else {
			return 3;
		}
	}
									
	//deed returns [Abstract_Deed d] : (((PLUS (l=literal {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILBel, $l.l);} |
	//				SHRIEK g=goal {$d = new Abstract_Deed(Abstract_Deed.AILAddition, $g.g);} |
	//				ADD_CONTENT l=literal {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILContent, $l.l);} |
	//				ADD_CONTEXT l=literal {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILContext, $l.l);} |
	//				ADD_PLAN p=literal {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILPlan, $p.l);} |
	//				ADD_CONSTRAINT c=literal {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILConstraint, $c.l);} |
	//				LOCK {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dlock);}) |
	//			   MINUS (l=literal {$d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILBel, $l.l);} |
	//				SHRIEK g=goal {$d = new Abstract_Deed(Abstract_Deed.AILDeletion, $g.g);} |
	//				ADD_CONTENT l=literal {$d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILContent, $l.l);} |
	//				ADD_CONTEXT l=literal {$d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILContext, $l.l);} |
	//				LOCK {$d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.Dlock);}
	//				)) |
	//				a=action {$d = new Abstract_Deed($a.a);}) |
	//				wf=waitfor {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dwaitfor, $wf.wf);}
	//				)
	//				;
	@Override public Object visitDeed(GwendolenParser.DeedContext ctx) {
		FOFVisitor fofvisitor = new FOFVisitor();
		if (ctx.PLUS() != null) {
			if (ctx.SHRIEK() != null) {
				return new Abstract_Deed(Abstract_Deed.AILAddition, (Abstract_Goal) visitGoal(ctx.g));
			}
			if (ctx.ADD_PLAN() != null) {
				LogicalFmlasParser p_parser = fofparser(ctx.p.getText());
				Abstract_Literal lit = (Abstract_Literal) fofvisitor.visitLiteral(p_parser.literal());
				return new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILPlan, lit);
			}
			if (ctx.LOCK() != null) {
				return new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dlock);
			}
			
			LogicalFmlasParser l_parser = fofparser(ctx.l.getText());
			Abstract_Literal lit = (Abstract_Literal) fofvisitor.visitLiteral(l_parser.literal());
			return new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILBel, lit);
		}
		
		if (ctx.MINUS() != null) {
			if (ctx.SHRIEK() != null) {
				return new Abstract_Deed(Abstract_Deed.AILDeletion, (Abstract_Goal) visitGoal(ctx.g));
			}
			if (ctx.LOCK() != null) {
				return new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.Dlock);
			}
			
			LogicalFmlasParser l_parser = fofparser(ctx.l.getText());
			Abstract_Literal lit = (Abstract_Literal) fofvisitor.visitLiteral(l_parser.literal());
			return new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILBel, lit);
		}
		
		if (ctx.action() != null) {
			return new Abstract_Deed((Abstract_Action) visitAction(ctx.action()));
		}
		
		return new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dwaitfor, (Abstract_Literal) visitWaitfor(ctx.wf));
		
	}
						
	//brule returns [Abstract_Rule r] : head=pred (BRULEARROW f=logicalfmla {$r = new Abstract_Rule(head, $f.f);} SEMI | SEMI {$r = new Abstract_Rule(head);});
	@Override public Object visitBrule(GwendolenParser.BruleContext ctx) {
		FOFVisitor fofvisitor = new FOFVisitor();
		LogicalFmlasParser l_parser = fofparser(ctx.head.getText());
		Abstract_Predicate head = (Abstract_Predicate) fofvisitor.visitPred(l_parser.pred());
		if (ctx.BRULEARROW() != null) {
			LogicalFmlasParser body_parser = fofparser(ctx.f.getText());
			Abstract_LogicalFormula body = (Abstract_LogicalFormula) fofvisitor.visitLogicalfmla(body_parser.logicalfmla());
			return new Abstract_Rule(head, body);
		} else {
			return new Abstract_Rule(head);
		}
		
	}

	//waitfor returns [Abstract_Literal wf] :  MULT l=literal {$wf = $l.l;};
	@Override public Object visitWaitfor(GwendolenParser.WaitforContext ctx) {
		FOFVisitor fofvisitor = new FOFVisitor();
		LogicalFmlasParser l_parser = fofparser(ctx.l.getText());
		return fofvisitor.visitLiteral(l_parser.literal());
		
	}

	//action returns [Abstract_Action a] : 
	//	(SEND OPEN an=literal COMMA p=performative COMMA t=pred CLOSE {$a = new Abstract_SendAction($an.l, $p.b, $t.t);}) | 
	//	t=pred {$a = new Abstract_Action($t.t, Abstract_Action.normalAction);};
	@Override public Object visitAction(GwendolenParser.ActionContext ctx) {
		FOFVisitor fofvisitor = new FOFVisitor();
		LogicalFmlasParser t_parser = fofparser(ctx.t.getText());
		Abstract_Predicate pred = (Abstract_Predicate) fofvisitor.visitPred(t_parser.pred());

		if (ctx.SEND() != null) {
			LogicalFmlasParser l_parser = fofparser(ctx.an.getText());
			Abstract_Literal lit = (Abstract_Literal) fofvisitor.visitLiteral(l_parser.literal());
			return new Abstract_SendAction(lit, visitPerformative(ctx.p), pred);
		}
		
		return new Abstract_Action(pred, Abstract_Action.normalAction);
	}
	
	private LogicalFmlasParser fofparser(String s) {
		LogicalFmlasLexer lexer = new LogicalFmlasLexer(CharStreams.fromString(s));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		LogicalFmlasParser parser = new LogicalFmlasParser(tokens);
		return parser;
	}


}
