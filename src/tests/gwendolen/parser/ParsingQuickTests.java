// ----------------------------------------------------------------------------
// Copyright (C) 2012-2014 Louise A. Dennis,  and Michael Fisher
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
// License along with Gwendolen; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package gwendolen.parser;

import java.util.Iterator;

import junit.framework.Assert;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import ail.parser.FOFVisitor;
import ail.semantics.AILAgent;
import ail.syntax.ast.Abstract_Goal;
import ail.syntax.ast.Abstract_Predicate;
import ajpf.psl.parser.LogicalFmlasLexer;
import ajpf.psl.parser.LogicalFmlasParser;
import ail.syntax.Goal;
import ail.syntax.Guard;
import ail.syntax.Literal;
import ail.syntax.Message;
import ail.syntax.NumberTermImpl;
import ail.syntax.Predicate;
import ail.syntax.Unifier;
import ail.syntax.GuardAtom;
import ail.syntax.GMessage;
import ail.syntax.Plan;
import ail.syntax.UnnamedVar;
import gwendolen.syntax.ast.Abstract_GPlan;

/**
 * Tests that the Gwendolen parser works correctly.
 * @author louiseadennis
 *
 */
public class ParsingQuickTests { 

	
	/*
	 * Test that a variable appearing as a goal gets parsed properly - including converstion to concrete datatypes.
	 */
	@Test public void VarsinGoalsTest() {
		GwendolenParser var_goal_parser = parser_for("G [perform]");
		GwendolenParser literal_goal_parser = parser_for("send_pos [perform]");
		GwendolenAILVisitor visitor = new GwendolenAILVisitor();
		try {
			Abstract_Goal var_a_goal = (Abstract_Goal) visitor.visitGoal(var_goal_parser.goal());
			Abstract_Goal literal_a_goal = (Abstract_Goal) visitor.visitGoal(literal_goal_parser.goal());
			
			Goal var_goal = var_a_goal.toMCAPL();
			Goal literal_goal = literal_a_goal.toMCAPL();
			
			Assert.assertTrue(var_goal.unifies(literal_goal, new Unifier()));
		} catch (Exception e) {
			System.err.println(e);
			Assert.assertTrue(false);
		}
	}
	
	/**
	 * Testing parsing of message constructs in guards.
	 */
	@Test public void MessagesInGuardsTest() {
		GwendolenParser msg_parser = parser_for("+e:{.sent(Ag, ag1, :tell, win)} <- d;");
		GwendolenAILVisitor visitor = new GwendolenAILVisitor();
		
		try {
			Abstract_GPlan abs_plan = (Abstract_GPlan) visitor.visitPlan(msg_parser.plan());
			Guard guard = abs_plan.toMCAPL().getContext().get(0);
		
			@SuppressWarnings("unchecked")
			GuardAtom<GMessage> ga = (GuardAtom<GMessage>) guard.getRHS();
			AILAgent ag = new AILAgent();
			Message msg = new Message(1, "ag1", "r", new Literal("win"));
			ag.newSentMessage(msg);

			Assert.assertTrue(ag.believesyn(new Guard(ga), new Unifier()));
		} catch (Exception e) {
			System.err.println(e);
			Assert.assertTrue(false);
		}
		
	}
	
	@Test public void parseOrderTest() {
		GwendolenParser plan_parser = parser_for("+win(Ag, X): {B my_name(Name), ~ B win(Name, Any), B collaborator(Coll)} <- +!coalition(Coll) [achieve];");
		GwendolenAILVisitor visitor = new GwendolenAILVisitor();
		
		try {
			Abstract_GPlan ast_plan = (Abstract_GPlan) visitor.visitPlan(plan_parser.plan());
			Plan plan = ast_plan.toMCAPL();
			
			AILAgent ag = new AILAgent();

			Literal myname = new Literal("my_name");
			myname.addTerm(new Literal("ag2"));
			ag.addBel(myname, AILAgent.refertoself());

			Literal winner = new Literal("win");
			winner.addTerm(new Literal("ag4"));
			winner.addTerm(new NumberTermImpl("1"));
			ag.addBel(winner, AILAgent.refertoself());
			
			Literal collaborator = new Literal("collaborator");
			collaborator.addTerm(new Literal("ag4"));
			ag.addBel(collaborator, AILAgent.refertoself());
						
			Iterator<Unifier> ui = ag.believes(plan.getContext().get(plan.getContext().size() - 1), new Unifier());
			
			Unifier un = ui.next();
			Assert.assertTrue(un != null);
		} catch (Exception e) {
			System.err.println(e);
			Assert.assertTrue(false);
		}
	}
	
	@Test public void unnamed_varTest() {
		GwendolenParser term = parser_for("on(X,_)");
		GwendolenAILVisitor visitor = new GwendolenAILVisitor();
		
		try {
			GwendolenParser.Fof_exprContext ctx = term.fof_expr();
			LogicalFmlasParser fofparser = fofparser(ctx.getText());
			FOFVisitor fof_visitor = new FOFVisitor();
			Abstract_Predicate p = (Abstract_Predicate) fof_visitor.visitPred(fofparser.pred());
			Predicate pred = p.toMCAPL();
			Assert.assertTrue(pred.getTerm(1) instanceof UnnamedVar);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	GwendolenParser parser_for(String s) {
		GwendolenLexer lexer = new GwendolenLexer(CharStreams.fromString(s));
		lexer.pushMode(GwendolenLexer.PLANS_MODE);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		GwendolenParser parser = new GwendolenParser(tokens);
		return parser;
	}
	
	private LogicalFmlasParser fofparser(String s) {
		LogicalFmlasLexer lexer = new LogicalFmlasLexer(CharStreams.fromString(s));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		LogicalFmlasParser parser = new LogicalFmlasParser(tokens);
		return parser;
	}
 
}
