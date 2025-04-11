// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis, and Michael Fisher and 
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

package actiononly.parser;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;

import actiononly.syntax.ast.Abstract_ActionOnlyAgent;
import ail.parser.FOFVisitor;
import ail.syntax.ast.Abstract_Capability;
import ail.syntax.ast.Abstract_GBelief;
import ail.syntax.ast.Abstract_GLogicalFormula;
import ail.syntax.ast.Abstract_Goal;
import ail.syntax.ast.Abstract_Literal;
import ail.syntax.ast.Abstract_MAS;
import ail.syntax.ast.Abstract_Predicate;
import ail.syntax.ast.Abstract_Rule;
import ajpf.psl.parser.LogicalFmlasLexer;
import ajpf.psl.parser.LogicalFmlasParser;

public class ActionOnlyAILVisitor extends ActionOnlyBaseVisitor<Object> {
	
	// mas  :  aoagents;
	@Override public Object visitMas(ActionOnlyParser.MasContext ctx) { 
		Abstract_MAS mas = new Abstract_MAS();
		ArrayList<Abstract_ActionOnlyAgent> gags = (ArrayList<Abstract_ActionOnlyAgent>) visitAoagents(ctx.aoagents()); 
		mas.setAgs(gags);
		return mas;
	}

	// aoagents returns[ArrayList<Abstract_ActionOnlyAgent> gags]: ACTIONONLY 
	// 	(g=aoagent {gags.add($g.g);})+;
	@Override public Object visitAoagents(@NotNull ActionOnlyParser.AoagentsContext ctx) {
		ArrayList<Abstract_ActionOnlyAgent> gags = new ArrayList<Abstract_ActionOnlyAgent>();
		List<ActionOnlyParser.AoagentContext> gctxs = ctx.aoagent();
		for (ActionOnlyParser.AoagentContext gctx: gctxs) {
			Abstract_ActionOnlyAgent g = (Abstract_ActionOnlyAgent) visitAoagent(gctx);
			gags.add(g);
		}
		return gags;
	}

	// Agent stuff
	// aoagent returns [Abstract_ActionOnlyAgent g] : 
	//         (ACTIONONLY?) 
	// 	NAME w=word {try {$g = new Abstract_ActionOnlyAgent($w.s);} 
	//		catch (Exception e) {System.err.println(e); agentname = new Abstract_StringTermImpl($w.s);}}
	//	BELIEFS PRED_BLOCK //(l=literal )* // {$g.addInitialBel($l.l);})*
	//	(BELIEFRULES FOF_BLOCK )? //(r=brule {$g.addRule($r.r);})*)?
	//	GOAL PRED_BLOCK //(l = literal )+ //{$g.addInitialGoal(new Abstract_Goal($l.l, Abstract_Goal.achieveGoal));})+
	//	ACTIONS (c = capability {$g.addCapability($c.c);})*;
	@Override public Object visitAoagent(@NotNull ActionOnlyParser.AoagentContext ctx) { 
		String name = ctx.WORD().getText();
		try {
			Abstract_ActionOnlyAgent g = new Abstract_ActionOnlyAgent(name);
		
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
			
			List<TerminalNode> goalblocks = ctx.GOAL_BLOCK();
			for (TerminalNode gb: goalblocks) {
				LogicalFmlasParser fofparser_gs = fofparser(gb.getText());
				ArrayList<Abstract_Literal> gs = (ArrayList<Abstract_Literal>) fofvisitor.visitLitlist(fofparser_gs.litlist());
				for (Abstract_Literal l: gs) {
					g.addInitialGoal(new Abstract_Goal(l, Abstract_Goal.achieveGoal));
				}
			}
			
			List<ActionOnlyParser.CapabilityContext> cctx_s = ctx.capability();
			for (ActionOnlyParser.CapabilityContext cctx:cctx_s) {
				Abstract_Capability c = (Abstract_Capability) visitCapability(cctx);
				g.addCapability(c);
			} 
			
			return g;
			
		} catch (Exception e) {
			System.err.println(e);
			return name;
		}
	}
	
	//capability returns [Abstract_Capability c] : CURLYOPEN (pres=FOF_BLOCK)? CURLYCLOSE a=PRED_BLOCK; // {$c = new Abstract_Capability($a.a); if ($f.f != null) {$c.addPre($f.f); $c.addPost(new Abstract_GBelief());}};
 	@Override public Object visitCapability(ActionOnlyParser.CapabilityContext ctx) {
		FOFVisitor fofvisitor = new FOFVisitor();
		GuardFOFVisitor gfofvisitor = new GuardFOFVisitor();
		
		LogicalFmlasParser action_parser = fofparser(ctx.a.getText());
		Abstract_Predicate p = (Abstract_Predicate) fofvisitor.visitPred(action_parser.pred());
		Abstract_Capability c = new Abstract_Capability(p);
		
		if (ctx.pres != null) {
			
			LogicalFmlasParser pre_parser = fofparser(ctx.pres.getText());
			Abstract_GLogicalFormula lf = (Abstract_GLogicalFormula) gfofvisitor.visitLogicalfmla(pre_parser.logicalfmla());
			c.addPre(lf);
			c.addPost(new Abstract_GBelief());
		}
		return c;
		
	} 
	
	private LogicalFmlasParser fofparser(String s) {
		LogicalFmlasLexer lexer = new LogicalFmlasLexer(CharStreams.fromString(s));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		LogicalFmlasParser parser = new LogicalFmlasParser(tokens);
		return parser;
	}
}
