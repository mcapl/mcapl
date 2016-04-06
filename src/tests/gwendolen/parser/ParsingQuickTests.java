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

import org.junit.Test;

import mcaplantlr.runtime.ANTLRStringStream;
import mcaplantlr.runtime.CommonTokenStream;
import ail.semantics.AILAgent;
import ail.syntax.ast.Abstract_Goal;
import ail.syntax.ast.Abstract_Predicate;
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
		GwendolenLexer var_goal_lexer = new GwendolenLexer(new ANTLRStringStream("G [perform]"));
		CommonTokenStream var_goal_tokens = new CommonTokenStream(var_goal_lexer);
		GwendolenParser var_goal_parser = new GwendolenParser(var_goal_tokens);
		GwendolenLexer literal_goal_lexer = new GwendolenLexer(new ANTLRStringStream("send_pos [perform]"));
		CommonTokenStream literal_goal_tokens = new CommonTokenStream(literal_goal_lexer);
		GwendolenParser literal_goal_parser = new GwendolenParser(literal_goal_tokens);
		try {
			Abstract_Goal var_a_goal = var_goal_parser.goal();
			Abstract_Goal literal_a_goal = literal_goal_parser.goal();
			
			Goal var_goal = var_a_goal.toMCAPL();
			Goal literal_goal = literal_a_goal.toMCAPL();
			
			Assert.assertTrue(var_goal.unifies(literal_goal, new Unifier()));
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	/**
	 * Testing parsing of message constructs in guards.
	 */
	@Test public void MessagesInGuardsTest() {
		GwendolenLexer msg_lexer = new GwendolenLexer(new ANTLRStringStream("+e:{.sent(Ag, ag1, :tell, win)} <- d;"));
		CommonTokenStream msg_tokens = new CommonTokenStream(msg_lexer);
		GwendolenParser msg_parser = new GwendolenParser(msg_tokens);
		
		try {
			Abstract_GPlan abs_plan = msg_parser.plan();
			Guard guard = abs_plan.toMCAPL().getContext().get(0);
		
			@SuppressWarnings("unchecked")
			GuardAtom<GMessage> ga = (GuardAtom<GMessage>) guard.getRHS();
			AILAgent ag = new AILAgent();
			Message msg = new Message(1, "ag1", "r", new Literal("win"));
			ag.newSentMessage(msg);

			Assert.assertTrue(ag.believesyn(new Guard(ga), new Unifier()));
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}
	
	@Test public void parseOrderTest() {
		GwendolenLexer plan_lexer = new GwendolenLexer(new ANTLRStringStream("+win(Ag, X): {B my_name(Name), ~ B win(Name, Any), B collaborator(Coll)} <- +!coalition(Coll) [achieve];"));
		CommonTokenStream plan_tokens = new CommonTokenStream(plan_lexer);
		GwendolenParser plan_parser = new GwendolenParser(plan_tokens);
		
		try {
			Abstract_GPlan ast_plan = plan_parser.plan();
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
		}
	}
	
	@Test public void unnamed_varTest() {
		GwendolenParser term = parser_for("on(X,_)");
		
		try {
			Abstract_Predicate p = term.pred();
			Predicate pred = p.toMCAPL();
			Assert.assertTrue(pred.getTerm(1) instanceof UnnamedVar);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	GwendolenParser parser_for(String s) {
		GwendolenLexer lexer = new GwendolenLexer(new ANTLRStringStream(s));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		GwendolenParser parser = new GwendolenParser(tokens);
		return parser;
	}
	
	
 
}
