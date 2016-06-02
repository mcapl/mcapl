// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of the Agent Infrastructure Layer (AIL)
// 
// The AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The AIL is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ail.syntax;

import org.junit.Test;
import org.junit.Assert;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import ail.semantics.AILAgent;
import ail.syntax.annotation.SourceAnnotation;

/**
 * Various tests for classes in ail.syntax.* .  These have mostly been created as bugs in the operation of these
 * classes have come to light.  Any alteration to classes in ail.syntax.* should at a minimum pass these tests before
 * being commited.
 * @author lad
 *
 */
public class TermSyntaxQuickTests {
	
	/*
	 * Test that literal hashes and equality are behaving sensible.
	 */
	@Test public void literalHashTest() {

		Literal l1 = new Literal("can_plan");
		Predicate l2 = new Literal("can_plan");
		Literal s1 = new Literal("source");
		s1.addTerm(new Predicate("percept"));
		Literal s2 = new Literal("source");
		s2.addTerm(new Predicate("percept"));
		l1.addAnnot(new SourceAnnotation(s1));

		Set<Predicate> litset = new HashSet<Predicate>();
		litset.add(l2);
		
		
		Assert.assertTrue(litset.contains(l1));
		
	}
	
	/**
	 * Test that the various constants indicating trivial guards and literals are equated correctly.
	 */
	/*@Test public void trivialGuards() {
		Guard g = new Guard(new GBelief());
		Term gt = g.toTerm();
		Literal l = new Literal(true, new PredicatewAnnotation((Predicate) gt));
		Assert.assertTrue(l.equals(Predicate.PTrue));
	} */
	
	/**
	 * Check that unification is working properly with non-default databases.
	 */
	@Test public void unificationOfDBsTrue() {
		
		Literal l1 = new Literal("l");
		Literal l2 = new Literal("l");
		Literal lb1 = new Literal("lb");
		Literal lb2 = new Literal("lb");

		VarTerm a3 = new VarTerm("C");
		
		
		GBelief gb1 = new GBelief(l2);
		gb1.setEB(a3);
		GBelief gb2 = new GBelief(lb2);
		gb2.setEB(a3);
		
		AILAgent a = new AILAgent("agent");
		a.addBeliefBase(new BeliefBase(), "a");
		a.addBel(l1, new SourceAnnotation(new Predicate("s")), new StringTermImpl("a"));
		a.addBel(lb1, new SourceAnnotation(new Predicate("s")), new StringTermImpl("a"));
		
		Unifier u = new Unifier();
		Iterator<Unifier> iu = a.believes(new Guard(gb2), u);
		Assert.assertTrue(iu.hasNext());
		Unifier un = iu.next();
		Assert.assertTrue(a.believesyn(new Guard(gb1), un));
	}

	/**
	 * As above.
	 */
	@Test public void unificationOfDBsFalse() {
		
		Literal l1 = new Literal("l");
		Literal l2 = new Literal("l");
		Literal lb1 = new Literal("lb");
		Literal lb2 = new Literal("lb");

		
		VarTerm a3 = new VarTerm("C");
		
		
		GBelief gb1 = new GBelief(l2);
		gb1.setEB(a3);
		GBelief gb2 = new GBelief(lb2);
		gb2.setEB(a3);
		
		AILAgent a = new AILAgent("agent");
		a.addBeliefBase(new BeliefBase(), "a");
		a.addBeliefBase(new BeliefBase(), "b");
		a.addBel(l1, new SourceAnnotation(new Predicate("s")), new StringTermImpl("a"));
		a.addBel(lb1, new SourceAnnotation(new Predicate("s")), new StringTermImpl("b"));
		
		Unifier u = new Unifier();
		Iterator<Unifier> iu = a.believes(new Guard(gb2), u);
		Assert.assertTrue(iu.hasNext());
		Unifier un = iu.next();
		Assert.assertFalse(a.believesyn(new Guard(gb1), un));
	}
	
	/**
	 * Test that unificaiton is working properly with non-standard goal bases.
	 */
	@Test public void unificationofDBsGoals() {
		Goal g1 = new Goal("g");
		Goal g2 = new Goal("g");
		
		VarTerm a3 = new VarTerm("C");
		g2.setGoalBase(a3);
		g1.setGoalBase(new StringTermImpl("b"));
		
		AILAgent a = new AILAgent("agent");
		a.addGoal(g1);
		
		Assert.assertTrue(a.believesyn(new Guard(g2), new Unifier()));
	}
	
	/**
	 * Checking unification with non-standard databases where one of the databases is referred to with a 
	 * variable.
	 */
	@Test public void unificationofDBsTerms() {
		Literal l1 = new Literal("l");
		Literal l2 = new Literal("l");
		StringTerm a = new StringTermImpl("a");
		
		VarTerm a3 = new VarTerm("C");
		
		
		GBelief gb1 = new GBelief(l2);
		gb1.setEB(a3);
		
		AILAgent ag = new AILAgent("agent");
		ag.addBeliefBase(new BeliefBase(), "a");
		ag.addBel(l1, new SourceAnnotation(new Predicate("s")), new StringTermImpl("a"));
		
		Unifier u = new Unifier();
		a.unifies(a3, u);
		Assert.assertTrue(ag.believesyn(new Guard(gb1), u));
	}
	
	/**
	 * Check the handling of sub-terms in list terms.
	 */
	@Test public void constructionOfListTerms() {
		ListTermImpl l1 = new ListTermImpl();
		l1.add(new Predicate("e1"));
		l1.add(new VarTerm("E"));
		
		ListTermImpl l2 = new ListTermImpl();
		l2.add(new Predicate("e1"));
		l2.add(new Predicate("e2"));
		
		Unifier u = new Unifier();
		l1.unifies(l2, u);
		l1.apply(u);
		
		l1.strip_varterm();
		Term t = ((ListTerm) l1.getTerm(1)).getHead();
		Assert.assertFalse(t instanceof VarTerm);
		
	}
	
	@Test public void prologLists() {
		Literal ethics_of = new Literal("ethics_of");
		ethics_of.addTerm(new Predicate("a1"));
		ethics_of.addTerm(new Predicate("e1"));
		
		AILAgent ag = new AILAgent("agent");
		ag.addBel(ethics_of, BeliefBase.TSelf);
		
		Literal ethics_in_h = new Literal("ethics_in");
		ethics_in_h.addTerm(new Predicate("a1"));
		ListTermImpl ethics_in_h_t = new ListTermImpl();
		ethics_in_h_t.setHead(new VarTerm("Eth"));
		ethics_in_h_t.setTail(new VarTerm("T"));
		ethics_in_h.addTerm(ethics_in_h_t);
		
		ethics_in_h_t.toString();
		
		Literal ethics_of_vars = new Literal("ethics_of");
		ethics_of_vars.addTerm(new Predicate("a1"));
		ethics_of_vars.addTerm(new VarTerm("Eth"));

		Rule r1 = new Rule(new GBelief(ethics_in_h), new GBelief(ethics_of_vars));
		
		Literal ethics_in_t = new Literal("ethics_in");
		ethics_in_t.addTerm(new Predicate("a1"));
		ethics_in_t.addTerm(new VarTerm("T"));
		
		Rule r2 = new Rule(new GBelief(ethics_in_h.clone()), new GBelief(ethics_in_t));
		
		ag.addRule(r1);
		ag.addRule(r2);
		
		Literal ethics_belief = new Literal("ethics_in");
		ethics_belief.addTerm(new Predicate("a1"));
		ListTermImpl ethics_list = new ListTermImpl();
		ethics_list.add(new Predicate("e1"));
		ethics_list.add(new Predicate("e2"));
		ethics_belief.addTerm(ethics_list);
		
		Assert.assertTrue(ag.believesyn(new Guard(new GBelief(ethics_belief)), new Unifier()));
	
	}
	
	@Test public void goals_from_vars() {
		Goal gv = new Goal("G", Goal.performGoal);
		
		Goal g = new Goal("goal", Goal.performGoal);
		
		Unifier u = new Unifier();
		gv.unifies(g, u);
		gv.apply(u);
		gv.strip_varterm();
	}
	
	@Test public void unnamedvarTest() {
		Predicate p1 = new Predicate("on");
		Predicate p2 = new Predicate("under");
		p1.addTerm(new Predicate("b3"));
		p1.addTerm(new Predicate("b4"));
		p2.addTerm(new Predicate("b3"));
		p2.addTerm(new Predicate("b2"));
		
		Predicate p1u = new Predicate("on");
		p1u.addTerm(new Predicate("b3"));
		p1u.addTerm(new UnnamedVar());
		Predicate p2u = new Predicate("under");
		p2u.addTerm(new Predicate("b3"));
		p2u.addTerm(new UnnamedVar());
		
		Unifier u = new Unifier();
		Assert.assertTrue(u.unifies(p1, p1u));
		Assert.assertTrue(u.unifies(p2, p2u));
		
	}
}
