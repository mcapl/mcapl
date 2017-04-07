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
package goal.parser;

import goal.semantics.GOALAgent;
import goal.semantics.GOALRC;
import goal.semantics.executorStages.ModuleExecutorStage;
import goal.semantics.operationalrules.ActionRuleExecutor;
import goal.semantics.operationalrules.ModuleCallActionExecutor;
import goal.semantics.operationalrules.SelectRule;
import goal.syntax.ActionRule;
import goal.syntax.ConjGoal;
import goal.syntax.ConjGoalBase;
import goal.syntax.GOALModule;
import goal.syntax.MentalState;
import goal.syntax.ast.Abstract_ActionRule;
import goal.syntax.ast.Abstract_GOALModule;
import junit.framework.Assert;
import mcaplantlr.runtime.ANTLRStringStream;
import mcaplantlr.runtime.CommonTokenStream;

import org.junit.Test;

import ail.syntax.BeliefBase;
import ail.syntax.Predicate;
import ail.syntax.Rule;
import ail.syntax.VarTerm;


public class nestedRulesQuickTests {
	@Test public void notgoalguard() {
		GOALParser parser = parser_for("event module{ program {if goal( holding(X) ) then { if bel( not( clear(X) ) ) then drop( holding(X) ). if bel( holding(_) ) then drop( holding(X) ).  listall L <- bel ( constructiveMove(Y, Z) ) do {   if bel( not( L=[] ), not( member([X,_], L) ) ) then drop( holding(X) ).}}}}");
		
		try {
			Abstract_GOALModule agm = parser.module();
			
			GOALAgent g = new GOALAgent("agent");
			g.setReasoningCycle(new GOALRC(g));
			GOALModule module = agm.toMCAPL();
			g.ms = new MentalState("agent");
			MentalState ms = g.getMentalState();
			ms.addBB(g.getBB());
			ms.addPerceptBase(g.getBB("percepts"));
			g.addModule(module);
			for (Rule r : module.getRuleBase().getAll()) {
				g.addRule(r);
			}
			g.getMentalState().addRB(g.getRuleBase());
			g.getMentalState().addGB((ConjGoalBase) g.getGoalBase());
			
			Predicate holding = new Predicate("holding");
			holding.addTerm(new Predicate("s"));
			ConjGoal goal = new ConjGoal();
			goal.addConj(holding);
			g.adopt(goal);
			
			SelectRule sr = new SelectRule();
			sr.setModule(module);
			Assert.assertTrue(sr.checkPreconditions(g));
			sr.apply(g);
			
			ActionRuleExecutor are = new ActionRuleExecutor();
			are.setModule(module);
			Assert.assertTrue(are.checkPreconditions(g));
			are.apply(g);
			
			Assert.assertTrue(g.getIntention().hdU().containsVarName("X"));
			
			ModuleCallActionExecutor mcae = new ModuleCallActionExecutor();
			mcae.setModule(module);
			Assert.assertTrue(mcae.checkPreconditions(g));
			mcae.apply(g);
			GOALModule action_module = mcae.getModule();
			
			SelectRule sr2 = new SelectRule();
			sr2.setModule(action_module);
			Assert.assertTrue(sr2.checkPreconditions(g));
			sr2.apply(g);
			
			ActionRuleExecutor are2 = new ActionRuleExecutor();
			are2.setModule(action_module);
			Assert.assertTrue(are2.checkPreconditions(g));
			are2.apply(g);
			
			Assert.assertTrue(g.getIntention().hdD().isGround());
		}  catch (Exception e) {
			System.err.println(e);
			Assert.assertFalse(true);
		}
		
	}
	
	@Test public void listallguard() {
		GOALParser parser = parser_for("event module{ program {if goal( holding(X) ) then { listall L <- bel ( constructiveMove(Y, Z) ) do {   if bel( not( L=[] ), not( member([X,_], L) ) ) then drop( holding(X) ).}}}}");
		
		try {
			Abstract_GOALModule agm = parser.module();
			
			GOALAgent g = new GOALAgent("agent");
			g.ms = new MentalState("agent");
			MentalState ms = g.getMentalState();
			ms.addBB(g.getBB());
			ms.addPerceptBase(g.getBB("percepts"));
			GOALModule module = agm.toMCAPL();
			g.addModule(module);
			for (Rule r : module.getRuleBase().getAll()) {
				g.addRule(r);
			}
			g.getMentalState().addRB(g.getRuleBase());
			g.getMentalState().addGB((ConjGoalBase) g.getGoalBase());
			
			Predicate holding = new Predicate("holding");
			holding.addTerm(new Predicate("s"));
			ConjGoal goal = new ConjGoal();
			goal.addConj(holding);
			g.adopt(goal);
			
			Predicate cm1 = new Predicate("constructiveMove");
			cm1.addTerm(new Predicate("a"));
			cm1.addTerm(new Predicate("b"));
			
			Predicate cm2 = new Predicate("constructiveMove");
			cm2.addTerm(new Predicate("c"));
			cm2.addTerm(new Predicate("d"));
			
			SelectRule sr = new SelectRule();
			sr.setModule(module);
			Assert.assertTrue(sr.checkPreconditions(g));
			sr.apply(g);
			
			ActionRuleExecutor are = new ActionRuleExecutor();
			are.setModule(module);
			Assert.assertTrue(are.checkPreconditions(g));
			are.apply(g);
						
			ModuleCallActionExecutor mcae = new ModuleCallActionExecutor();
			mcae.setModule(module);
			Assert.assertTrue(mcae.checkPreconditions(g));
			mcae.apply(g);
			GOALModule action_module = mcae.getModule();
			
			SelectRule sr2 = new SelectRule();
			sr2.setModule(action_module);
			Assert.assertTrue(sr2.checkPreconditions(g));
			sr2.apply(g);
			
			ActionRuleExecutor are2 = new ActionRuleExecutor();
			are2.setModule(action_module);
			Assert.assertTrue(are2.checkPreconditions(g));
			are2.apply(g);
			
			Assert.assertTrue(g.getIntention().hdD().isGround());
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
