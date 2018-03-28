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
import goal.syntax.ActionSpec;
import goal.syntax.ConjGoal;
import goal.syntax.ConjGoalBase;
import goal.syntax.GOALModule;
import goal.syntax.GoalMessage;
import goal.syntax.MentalState;
import goal.syntax.ast.Abstract_ActionRule;
import goal.syntax.ast.Abstract_ActionSpec;
import goal.syntax.ast.Abstract_GOALModule;
import goal.syntax.ast.Abstract_MentalState;
import junit.framework.Assert;
import mcaplantlr.runtime.ANTLRStringStream;
import mcaplantlr.runtime.CommonTokenStream;

import org.junit.Test;

import ail.syntax.Action;
import ail.syntax.BroadcastMessage;
import ail.syntax.Deed;
import ail.syntax.EBCompare;
import ail.syntax.GBelief;
import ail.syntax.GLogicalFormula;
import ail.syntax.Goal;
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
import ail.syntax.ast.Abstract_Predicate;


public class ActionSpecPreQuickTests {
	@Test public void forall_pre() {
		GOALParser actionspec = parser_for("make(Prod) {pre{ forall(requiredFor(Prod, Req), have(Req)) } post { have(Prod) }}");
		
		try {
			Abstract_ActionSpec as = actionspec.actionSpec();
			ActionSpec action  = as.toMCAPL();
			
			
			GOALAgent g = new GOALAgent("agent");
			g.ms = new MentalState("agent");
			g.getMentalState().addBB(g.getBB());
			g.getMentalState().addPerceptBase(g.getBB("percepts"));
			Literal b1 = new Literal("have");
			b1.addTerm(new Literal("grounds"));
			g.addBel(b1, g.refertoself());
			Literal r1 = new Literal("requiredFor");
			r1.addTerm(new Predicate("coffee"));
			r1.addTerm(new Predicate("water"));
			g.addBel(r1, g.refertoself());
			Literal r2 = new Literal("requiredFor");
			r2.addTerm(new Predicate("coffee"));
			r2.addTerm(new Predicate("grounds"));
			g.addBel(r2, g.refertoself());
			
			Guard pres = (Guard) action.getPre();
			VarTerm prod = new VarTerm("Prod");
			Predicate coffee = new Predicate("coffee");
			Unifier u = new Unifier();
			u.unifies(prod, coffee);
			
			Assert.assertFalse(g.believesyn(pres, u));
			
			
			Literal b2 = new Literal("have");
			b2.addTerm(new Literal("water"));
			g.addBel(b2, g.refertoself());
			
			Assert.assertTrue(g.believesyn(pres, u));
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
