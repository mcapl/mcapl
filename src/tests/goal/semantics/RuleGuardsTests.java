// ----------------------------------------------------------------------------
// Copyright (C) 2016 Louise A. Dennis,  and Michael Fisher
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
package goal.semantics;

import java.util.ArrayList;
import java.util.HashSet;

import goal.parser.GOALLexer;
import goal.parser.GOALParser;
import goal.syntax.ActionRule;
import goal.syntax.ConjGoalBase;
import goal.syntax.GOALModule;
import goal.syntax.MentalState;
import goal.syntax.ast.Abstract_ActionRule;
import goal.syntax.ast.Abstract_GOALModule;
import goal.syntax.ast.Abstract_MentalState;
import junit.framework.Assert;
import mcaplantlr.runtime.ANTLRStringStream;
import mcaplantlr.runtime.CommonTokenStream;

import org.junit.Test;

import ail.syntax.GBelief;
import ail.syntax.Guard;
import ail.syntax.ListTermImpl;
import ail.syntax.Literal;
import ail.syntax.NumberTermImpl;
import ail.syntax.Predicate;
import ail.syntax.Rule;
import ail.syntax.Unifier;
import ail.syntax.UnnamedVar;


public class RuleGuardsTests {
	@Test public void not_perceptguard() {
		GOALParser parser = parser_for("bel(not(visible(Brick, Color)), percept(visible(Brick, Color)))");
		GOALParser parser2 = parser_for("bel(percept(visible(Brick, Color)), not(visible(Brick, Color)))");
		
		try {
			Abstract_MentalState l = parser.mentalstate();
			Guard m  = l.toMCAPL();
			
			Abstract_MentalState l2 = parser2.mentalstate();
			Guard m2 = l2.toMCAPL();
			
			GOALAgent g = new GOALAgent("agent");
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
		
	@Test public void buildins() {
		GOALParser length_parser = parser_for("init module {knowledge {finished(Index) :- index(Index), shopping_list(Colours), length(Colours, Index).}}");
		GOALParser member_parser = parser_for("bel(colour(Colour), shopping_list(Colours), not(member(Colour, Colours)))");
		
		try {
			Abstract_MentalState ms = member_parser.mentalstate();
			Guard gu = ms.toMCAPL();
			
			Abstract_GOALModule gm = length_parser.module();
			
			GOALAgent g = new GOALAgent("agent");
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
	

	
	GOALParser parser_for(String s) {
		GOALLexer lexer = new GOALLexer(new ANTLRStringStream(s));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		GOALParser parser = new GOALParser(tokens);
		return parser;
	}

}
