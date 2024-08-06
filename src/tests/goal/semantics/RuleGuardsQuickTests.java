// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis, Michael Fisher, and Koen Hindriks
// 
// This file is part of AIL GOAL.  An AIL Implementation of the GOAL Programming
// Language
//
// AIL GOAL is free software: you can redistribute it and/or modify it under
// the terms of the GNU General Public License as published by the Free Software
// Foundation, either version 3 of the License, or (at your option) any later
// version.
//
// AIL GOAL is distributed in the hope that it will be useful, but WITHOUT
// ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
// FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
// details.
//
// You should have received a copy of the GNU General Public License along with
// this program. If not, see <http://www.gnu.org/licenses/>.
//
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------
package goal.semantics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import goal.parser.GOALLexer;
import goal.parser.GOALParser;
import goal.semantics.operationalrules.ProcessMessages;
import goal.syntax.ActionRule;
import goal.syntax.ConjGoal;
import goal.syntax.ConjGoalBase;
import goal.syntax.GOALModule;
import goal.syntax.GoalMessage;
import goal.syntax.MentalState;
import goal.syntax.ast.Abstract_ActionRule;
import goal.syntax.ast.Abstract_GOALModule;
import goal.syntax.ast.Abstract_MentalState;
import junit.framework.Assert;
import mcaplantlr.runtime.ANTLRStringStream;
import mcaplantlr.runtime.CommonTokenStream;

import org.junit.Test;

import ail.syntax.BroadcastMessage;
import ail.syntax.EBCompare;
import ail.syntax.GBelief;
import ail.syntax.Guard;
import ail.syntax.ListTermImpl;
import ail.syntax.Literal;
import ail.syntax.NumberTermImpl;
import ail.syntax.Predicate;
import ail.syntax.PredicateTerm;
import ail.syntax.Rule;
import ail.syntax.Unifier;
import ail.syntax.UnnamedVar;
import ail.syntax.VarTerm;


public class RuleGuardsQuickTests {
	@Test public void not_perceptguard() {
		GOALParser parser = parser_for("bel(not(visible(Brick, Color)), percept(visible(Brick, Color)))");
		GOALParser parser2 = parser_for("bel(percept(visible(Brick, Color)), not(visible(Brick, Color)))");
		
		try {
			Abstract_MentalState l = parser.mentalstate();
			Guard m  = l.toMCAPL();
			
			Abstract_MentalState l2 = parser2.mentalstate();
			Guard m2 = l2.toMCAPL();
			
			GOALAgent g = new GOALAgent("agent");
			g.ms = new MentalState("agent");
			g.getMentalState().addBB(g.getBB());
			g.getMentalState().addPerceptBase(g.getBB("percepts"));
			Predicate visible1 = new Predicate("visible");
			visible1.addTerm(new Predicate("brick1"));
			visible1.addTerm(new Predicate("blue"));
			g.addBel(new Literal(visible1), g.refertoself());
			
			Predicate visible2 = new Predicate("visible");
			visible2.addTerm(new Predicate("brick2"));
			visible2.addTerm(new Predicate("green"));
			HashSet<Predicate> percepts = new HashSet<Predicate>();
			percepts.add(visible2);
			g.getMentalState().addPercepts(percepts);
			
			Assert.assertTrue(g.believesyn(m2, new Unifier()));
			Assert.assertTrue(g.believesyn(m, new Unifier()));
		}  catch (Exception e) {
			System.err.println(e);
			Assert.assertFalse(true);
		}
	}
		
	@Test public void builtins() {
		GOALParser length_parser = parser_for("init module {knowledge {finished(Index) :- index(Index), shopping_list(Colours), length(Colours, Index).}}");
		GOALParser member_parser = parser_for("bel(colour(Colour), shopping_list(Colours), not(member(Colour, Colours)))");
		
		try {
			Abstract_MentalState ms = member_parser.mentalstate();
			Guard gu = ms.toMCAPL();
			
			Abstract_GOALModule gm = length_parser.module();
			
			GOALAgent g = new GOALAgent("agent");
			g.ms = new MentalState("agent");
			g.getMentalState().addBB(g.getBB());
			g.getMentalState().addPerceptBase(g.getBB("percepts"));
			GOALModule module = gm.toMCAPL();
			g.addModule(module);
			for (Rule r : module.getRuleBase().getAll()) {
				g.addRule(r);
			}
			
			Predicate index = new Predicate("index");
			index.addTerm(new NumberTermImpl(4));
			
			ListTermImpl list = new ListTermImpl();
			list.setTail(new ListTermImpl());
			list.setHead(new Predicate("red"));
			list.cons(new Predicate("green"));
			list.cons(new Predicate("green"));
			list.cons(new Predicate("blue"));
			Predicate shopping_list = new Predicate("shopping_list");
			shopping_list.addTerm(list);
			
			Predicate colour = new Predicate("colour");
			colour.addTerm(new Predicate("red"));
			
			g.addBel(new Literal(index), g.refertoself());
			g.addBel(new Literal(shopping_list), g.refertoself());
			g.addBel(new Literal(colour), g.refertoself());
			
			Predicate finished = new Predicate("finished");
			finished.addTerm(new UnnamedVar());
			Guard guard = new Guard(new GBelief(finished));
			
			Assert.assertTrue(g.believesyn(guard, new Unifier()));
			Assert.assertFalse(g.believesyn(gu, new Unifier()));

			
			
		} catch (Exception e) {
			System.err.println(e);
			Assert.assertFalse(true);
		}
			
		
	}
	
	@Test public void prologrules() {
		GOALParser constructivemove = parser_for("a-goal( tower([X, Y | T]) ), bel( tower([Y | T]), clear(Y), (clear(X); holding(X)) ).");
		GOALParser tower = parser_for("init module {knowledge {clear(table). clear(X) :- block(X), not( on(_, X) ), not( holding(X) ). tower([X]) :- on(X, table).  tower([X, Y | T]) :- on(X, Y), tower([Y | T]).}}");
		
		try {
			Abstract_MentalState ams = constructivemove.mentalstate();
			Guard ms = ams.toMCAPL();
			
			Abstract_GOALModule agm = tower.module();
			
			GOALAgent g = new GOALAgent("agent");
			g.ms = new MentalState("agent");
			g.getMentalState().addBB(g.getBB());
			g.getMentalState().addPerceptBase(g.getBB("percepts"));
			GOALModule module = agm.toMCAPL();
			g.addModule(module);
			for (Rule r : module.getRuleBase().getAll()) {
				g.addRule(r);
			}
			g.getMentalState().addRB(g.getRuleBase());
			g.getMentalState().addGB((ConjGoalBase) g.getGoalBase());
			
			Predicate blocka = new Predicate("block");
			blocka.addTerm(new Predicate("a"));
			Predicate blockb = new Predicate("block");
			blockb.addTerm(new Predicate("b"));
			
			Predicate ontablea = new Predicate("on");
			ontablea.addTerm(new Predicate("a"));
			ontablea.addTerm(new Predicate("table"));			
			Predicate ontableb = new Predicate("on");
			ontableb.addTerm(new Predicate("b"));
			ontableb.addTerm(new Predicate("table"));
			
			Predicate onab = new Predicate("on");
			onab.addTerm(new Predicate("a"));
			onab.addTerm(new Predicate("b"));
			
			ConjGoal goal = new ConjGoal();
			goal.addConj(onab);
			goal.addConj(ontableb);
			
			
			g.adopt(goal);
			
			g.addBel(new Literal(blocka), g.refertoself());
			g.addBel(new Literal(blockb), g.refertoself());
			g.addBel(new Literal(ontablea), g.refertoself());
			g.addBel(new Literal(ontableb), g.refertoself());
			
			Assert.assertTrue(g.believesyn(ms, new Unifier()));

			
		} catch (Exception e) {
			System.err.println(e);
			Assert.assertFalse(true);
		}
	}

	@Test public void macros() {
		VarTerm x = new VarTerm("X");
		VarTerm y = new VarTerm("Y");
		Predicate key = new Predicate("constructiveMove");
		key.addTerm(x);
		key.addTerm(y);
		
		
		Predicate lookup = new Predicate("constructiveMove");
		lookup.addTerm(new VarTerm("Z"));
		lookup.addTerm(new VarTerm("K"));
		
		Predicate guard = new Predicate("guard");
		guard.addTerm(x);
		guard.addTerm(y);
		Guard g = new Guard(new GBelief(guard));
		Abstract_MentalState.unificationProcess(lookup, key, g);	
		
		GOALParser tower = parser_for("init module {knowledge {guard(C, D) :- guarda(C, D).}}");

		try {
			GOALAgent ag = new GOALAgent("agent");
			ag.ms = new MentalState("agent");
			ag.getMentalState().addBB(ag.getBB());
			ag.getMentalState().addPerceptBase(ag.getBB("percepts"));

			Abstract_GOALModule agm = tower.module();
			GOALModule module = agm.toMCAPL();
			ag.addModule(module);
			for (Rule r : module.getRuleBase().getAll()) {
				ag.addRule(r);
			}
			
			
			
			
			Predicate guard1 = new Predicate("guarda");
			guard1.addTerm(new Predicate("brick1"));
			guard1.addTerm(new Predicate("blue"));
			ag.addBel(new Literal(guard1), ag.refertoself());
			Unifier un = new Unifier();
			Iterator<Unifier> iun = ag.believes(g, un);
			
			Unifier unif = iun.next();
			
			Predicate guard2 = new Predicate("guard");
			guard2.addTerm(new VarTerm("X0"));
			guard2.addTerm(new Predicate("blue"));
			
			Predicate gcontent = ((GBelief) g.getRHS()).toPredicate();
			
			unif.unifies(guard2, gcontent);
			
			Predicate guard3 = new Predicate("guard");
			guard3.addTerm(new Predicate("brick3"));
			guard3.addTerm(new Predicate("blue"));
			
			Assert.assertFalse(((EBCompare<PredicateTerm>) gcontent).unifieswith(guard3, unif, ""));
			
			
			
		} catch (Exception e) {
			System.err.println(e);
			Assert.assertFalse(true);
			
		}
		

	}
	
	@Test public void macros2() {
		VarTerm x = new VarTerm("Y");
		VarTerm y = new VarTerm("Z");
		Predicate lookup = new Predicate("constructiveMove");
		lookup.addTerm(x);
		lookup.addTerm(y);
		
		
		Predicate key = new Predicate("constructiveMove");
		key.addTerm(new VarTerm("X"));
		key.addTerm(new VarTerm("Y"));

		
		Predicate guard = new Predicate("guard");
		guard.addTerm(x);
		guard.addTerm(y);
		Guard g = new Guard(new GBelief(guard));
		Abstract_MentalState.unificationProcess(lookup, key, g);	
		
		Assert.assertTrue(g.getVarNames().contains("Y"));
		
		

	}

	@Test public void messageRecievedTest() {
		GOALParser ruleParser = parser_for("bel(me(Me), received(A, int(canMake(Me,_))), canMake(Me, Prod))");
		
		try {
			GOALAgent ag = new GOALAgent("grinder");
			ag.ms = new MentalState("grinder");
			ag.getMentalState().addBB(ag.getBB());
			ag.getMentalState().addPerceptBase(ag.getBB("percepts"));
			ag.getMentalState().addMessageBase(ag.getBB("messages"));
			
			Literal me = new Literal("me");
			me.addTerm(new Predicate("grinder"));
			ag.addBel(me, ag.refertoself());
			
			Literal canMake = new Literal("canMake");
			canMake.addTerm(new Predicate("grinder"));
			ListTermImpl list = new ListTermImpl();
			list.add(new Predicate("coffee"));
			list.add(new Predicate("grounds"));
			canMake.addTerm(list);
			ag.addBel(canMake, ag.refertoself());
			
			HashSet<String> receivers = new HashSet<String>();
			receivers.add("grinder");
			Literal canMakeQuestion = new Literal("canMake");
			canMakeQuestion.addTerm(new Predicate("grinder"));
			canMakeQuestion.addTerm(new UnnamedVar());
			BroadcastMessage msg = new BroadcastMessage(1, "maker", receivers, canMakeQuestion);
			GoalMessage message = new GoalMessage(msg);
			ProcessMessages.processMessageMentalModel(message, ag);
        	ag.getMentalState().addReceivedMessage(message);
        	
			Abstract_MentalState l = ruleParser.mentalstate();
			Guard m  = l.toMCAPL();
			Assert.assertTrue(ag.believesyn(m, new Unifier()));


		}  catch (Exception e) {
			System.err.println(e);
			Assert.assertFalse(true);
			
		}
	}

	
	GOALParser parser_for(String s) {
		GOALLexer lexer = new GOALLexer(new ANTLRStringStream(s));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		GOALParser parser = new GOALParser(tokens);
		return parser;
	}
	
	

}
