// ----------------------------------------------------------------------------
// Copyright (C) 2018 Louise A. Dennis, Michael Fisher, and Vincent Koeman
//
// This file is part of the Gwendolen
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
// License along with the AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ail.tracing;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import ail.syntax.Action;
import ail.syntax.NumberTermImpl;
import ail.syntax.Predicate;
import ail.tracing.events.CreateIntentionEvent;
import ail.tracing.events.ModifyIntentionEvent;
import ail.tracing.events.SelectPlanEvent;
import ail.tracing.explanations.AbstractReason;
import gwendolen.tracing.explanations.CreateIntentionReason;
import ail.tracing.explanations.ExplanationLevel;
import gwendolen.tracing.explanations.ModifyIntentionReason;
import gwendolen.tracing.explanations.SelectPlanReason;
import gwendolen.tracing.explanations.WhyQuestions;
import ajpf.MCAPLcontroller;

/**
 * Test rig focused on testing the generation of explanations in Gwendolen.
 * @author louisedennis
 *
 */
public class GwendolenExplanationQuickTests {
	
	@Test public void readInTest() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/orca/Prototype6VK/traces/executive_19-05-28_18-11-31-199.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		System.err.println(whys.verboseString());
	}
	
	// Test 1
	@Test public void selectContinuePlanTest() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/tracing/traces/robot_19-05-28_17-06-15-054.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		SelectPlanEvent spe = (SelectPlanEvent) whys.getEvent(28);
		SelectPlanReason spr = new SelectPlanReason(28, spe);
		whys.whySelectPlan(spe, spr, whys.getTrace(), 28);
		String s = "because \"the robot is at [1,1]\" was perceived in state 24";
		String s2 = spr.getExplanation(ExplanationLevel.FINE, whys.getDescriptions());
		// System.err.println(s2);
		Boolean b = s2.equals(s);
		assertTrue(b);
	}
	
	// Test 2
	@Test public void selectPlanTest() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/tracing/traces/robot_19-05-28_17-06-15-054.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		SelectPlanEvent spe = (SelectPlanEvent) whys.getEvent(84);
		SelectPlanReason spr = new SelectPlanReason(84, spe);
		whys.whySelectPlan(spe, spr, whys.getTrace(), 84);
		String s = "<font face=\"Courier New\">Plan 3: in response to the event: added the belief &quot;the robot is at [3,3]&quot; do add no_rubble(X,Y) with [X=3, X0=3, Y=3, Y0=3]</font> was selected in state 84 because its guard <font face=\"Courier New\">~rubble(X,Y)</font> held with possible solution(s) <font face=\"Courier New\">[X=3, X0=3, Y=3, Y0=3]</font> and \"the robot is at [3,3]\" was perceived in state 53";
		String s2 = spr.getExplanation(ExplanationLevel.FINE, whys.getDescriptions());
		// System.err.println(s2);
		Boolean b = s2.equals(s);
		assertTrue(b);
	}

	// Test 3
	@Test public void selectPlanModifyIntentionTest() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/tracing/traces/robot_19-05-28_17-06-15-054.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		SelectPlanEvent spe = (SelectPlanEvent) whys.getEvent(148);
		SelectPlanReason spr = new SelectPlanReason(148, spe);
		whys.whySelectPlan(spe, spr, whys.getTrace(), 148);
		String s = "<font face=\"Courier New\">Plan 2: in response to the event: added the goal achieve &quot;the robot is holding rubble&quot; do move_to(X,Y) with [X=5, Y=5]</font> was selected in state 148 because its guard <font face=\"Courier New\">possible_rubble(X,Y) &amp; ~no_rubble(X,Y)</font> held with possible solution(s) <font face=\"Courier New\">[X=5, Y=5]</font> and added the goal achieve \"the robot is holding rubble\" was posted in state 126 because <font face=\"Courier New\">Plan 1: in response to the event: added the goal achieve rubble(2,2) do add the goal achieve &quot;the robot is holding rubble&quot; AND move_to(2,2) AND drop</font> was selected in state 13";
		String s2 = spr.getExplanation(ExplanationLevel.FINE, whys.getDescriptions());
		// System.err.println(s2);
		Boolean b = s2.equals(s);
		assertTrue(b);
	}
	
	// Test 4
	@Test public void whyBeliefCreated() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/tracing/traces/robot_19-05-28_17-06-15-054.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		Predicate at11 = new Predicate("at");
		at11.addTerm(new NumberTermImpl(1));
		at11.addTerm(new NumberTermImpl(1));
		AbstractReason reason = whys.whyBelief(at11, 36);
		String s = "\"the robot is at [1,1]\" was believed in state 36 because the belief <font face=\"Courier New\">&quot;the robot is at [1,1]&quot;</font> was added because \"the robot is at [1,1]\" was perceived in state 24"; 
		String s2 = reason.getExplanation(ExplanationLevel.FINE, whys.getDescriptions());
		// System.err.println(s2);
		Boolean b = s2.equals(s);
		assertTrue(b);
	}

	// Test 5
	@Test public void whyInitialBelief() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/tracing/traces/robot_19-05-28_17-06-15-054.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		Predicate at11 = new Predicate("possible_rubble");
		at11.addTerm(new NumberTermImpl(1));
		at11.addTerm(new NumberTermImpl(1));
		AbstractReason reason = whys.whyBelief(at11, 36);
		String s = "possible_rubble(1,1) was believed in state 36 because the belief <font face=\"Courier New\">possible_rubble(1,1)</font> was added upon starting the agent.";
		String s2 = reason.getExplanation(ExplanationLevel.FINE, whys.getDescriptions());
		// System.err.println(s2);
		Boolean b = s2.equals(s);
		assertTrue(b);
	}
	
	// Test 6
	@Test public void whyInitialGoal() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/tracing/traces/robot_19-05-28_17-06-15-054.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		Predicate at11 = new Predicate("rubble");
		at11.addTerm(new NumberTermImpl(2));
		at11.addTerm(new NumberTermImpl(2));
		AbstractReason reason = whys.whyGoal(at11, 10);
		String s = "rubble(2,2) was a goal in state 10 because added the goal achieve rubble(2,2) was posted in state 9 because add the goal achieve rubble(2,2) was an initial goal."; 
		String s2 = reason.getExplanation(ExplanationLevel.FINE, whys.getDescriptions());
		// System.err.println(s2);
		Boolean b = s2.equals(s);
		assertTrue(b);
	}
	
	// Test 7
	@Test public void whySubGoal() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/tracing/traces/robot_19-05-28_17-06-15-054.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		Predicate at11 = new Predicate("holding");
		at11.addTerm(new Predicate("rubble"));
		// at11.addTerm(new NumberTermImpl(2));
		AbstractReason reason = whys.whyGoal(at11, 37);
		String s = "\"the robot is holding rubble\" was a goal in state 37 because added the goal achieve \"the robot is holding rubble\" was posted in state 37 because <font face=\"Courier New\">Plan 1: in response to the event: added the goal achieve rubble(2,2) do add the goal achieve &quot;the robot is holding rubble&quot; AND move_to(2,2) AND drop</font> was selected in state 13";
		String s2 = reason.getExplanation(ExplanationLevel.FINE, whys.getDescriptions());
		//System.err.println(s2);
		Boolean b = s2.equals(s);
		assertTrue(b);
	}
	
	// Test 8
	@Test public void whyAddInitialGoal() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/tracing/traces/robot_19-05-28_17-06-15-054.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		ModifyIntentionEvent mie = (ModifyIntentionEvent) whys.getEvent(9);
		ModifyIntentionReason mir = new ModifyIntentionReason(9, mie);
		whys.whyAddGoal(mie, mir, whys.getTrace(), 9);
		String s = "added the goal achieve rubble(2,2) was posted in state 9 because add the goal achieve rubble(2,2) was an initial goal."; 
		String s2 = mir.getExplanation(ExplanationLevel.FINE, whys.getDescriptions());
		//System.err.println(s2);
		Boolean b = s2.equals(s);
		assertTrue(b);
	}

	// Test 9
	@Test public void whyAddSubGoal() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/tracing/traces/robot_19-05-28_17-06-15-054.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		ModifyIntentionEvent mie = (ModifyIntentionEvent) whys.getEvent(126);
		ModifyIntentionReason mir = new ModifyIntentionReason(126, mie);
		whys.whyAddGoal(mie, mir, whys.getTrace(), 126);
		String s = "added the goal achieve \"the robot is holding rubble\" was posted in state 126 because <font face=\"Courier New\">Plan 1: in response to the event: added the goal achieve rubble(2,2) do add the goal achieve &quot;the robot is holding rubble&quot; AND move_to(2,2) AND drop</font> was selected in state 13";
		String s2 = mir.getExplanation(ExplanationLevel.FINE, whys.getDescriptions());
		// System.err.println(s2);
		Boolean b = s2.equals(s);
		assertTrue(b);
	}
	
	// Test 10
	@Test public void whyAction() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/tracing/traces/robot_19-05-28_17-06-15-054.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		Action drop = new Action("drop");
		AbstractReason reason = whys.whyAction(drop, 202);
		String s = "<font face=\"Courier New\">drop</font> was executed because <font face=\"Courier New\">Plan 1: in response to the event: added the goal achieve rubble(2,2) do add the goal achieve &quot;the robot is holding rubble&quot; AND move_to(2,2) AND drop</font> was selected in state 13 because added the goal achieve rubble(2,2) was posted in state 9 because add the goal achieve rubble(2,2) was an initial goal."; 
		String s2 = reason.getExplanation(ExplanationLevel.FINE, whys.getDescriptions());
		// System.err.println(s2);
		Boolean b = s2.equals(s);
		assertTrue(b);
	}
	
	// Test 11
	@Test public void whyMove11() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/tracing/traces/robot_19-05-28_17-06-15-054.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		Action move = new Action("move_to");
		move.addTerm(new NumberTermImpl(1));	
		move.addTerm(new NumberTermImpl(1));
		AbstractReason reason = whys.whyAction(move, 22);
		String s = "<font face=\"Courier New\">move_to(1,1)</font> was executed because <font face=\"Courier New\">Plan 2: in response to the event: added the goal achieve &quot;the robot is holding rubble&quot; do move_to(1,1)</font> was selected in state 20 because its guard <font face=\"Courier New\">possible_rubble(X,Y) &amp; ~no_rubble(X,Y)</font> held with possible solution(s) <font face=\"Courier New\">[[X=1, Y=1], [X=3, Y=3], [X=5, Y=5]]</font> and added the goal achieve \"the robot is holding rubble\" was posted in state 16 because <font face=\"Courier New\">Plan 1: in response to the event: added the goal achieve rubble(2,2) do add the goal achieve &quot;the robot is holding rubble&quot; AND move_to(2,2) AND drop</font> was selected in state 13"; 
		String s2 = reason.getExplanation(ExplanationLevel.FINE, whys.getDescriptions());
		// System.err.println(s2);
		Boolean b = s2.equals(s);
		assertTrue(b);
	}

	// Doesn't work because we haven't yet considered goal deletion
	/* @Test public void whySendTaskAgent() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/orca/Prototype6VK/traces/executive_19-05-28_18-11-31-199.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		Action send = new Action("send");
		send.addTerm(new Predicate("taskAgent"));	
		send.addTerm(new Predicate("targetRequest"));
		AbstractReason reason = whys.whyAction(send, 47);
		String s = "<font face=\"Courier New\">move_to(1,1)</font> was executed because <font face=\"Courier New\">Plan 2: in response to the event: added the goal achieve &quot;the robot is holding rubble&quot; do move_to(1,1)</font> was selected in state 20 because its guard <font face=\"Courier New\">possible_rubble(X,Y) &amp; ~no_rubble(X,Y)</font> held with possible solution(s) <font face=\"Courier New\">[[X=1, Y=1], [X=3, Y=3], [X=5, Y=5]]</font> and  the event <font face=\"Courier New\">added the goal achieve &quot;the robot is holding rubble&quot;</font> was posted  in state 16";
		String s2 = reason.getExplanation(ExplanationLevel.FINE, whys.getDescriptions());
		System.err.println(s2);
		Boolean b = s2.equals(s);
		assertTrue(b);
	} */
	
	@Test public void whyEnactRoute() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/orca/Prototype6VK/traces/executive_19-05-28_18-11-31-199.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		Action send = new Action("send");
		send.addTerm(new Predicate("routePlanner"));	
		send.addTerm(new Predicate("enactRoute"));
		send.addTerm(new Predicate("route2"));
		send.addTerm(new Predicate("t2"));
		send.addTerm(new Predicate("safety"));
		AbstractReason reason = whys.whyAction(send, 183);
		String s = "<font face=\"Courier New\">&quot;Request the Route Planner to enact route2 with target t2 and prioritisation safety&quot;</font> was executed because <font face=\"Courier New\">Plan 6: in response to the event: added the belief &quot;The UAV has 3 possible routes&quot; do &quot;Request the Route Planner to enact route2 with target t2 and prioritisation safety&quot; AND delete &quot;The UAV requested a route towards t2 prioritising safety&quot;</font> was selected in state 181 because its guard <font face=\"Courier New\">prioritise(safety) &amp; requestedRoute(T,U) &amp; route1(A1,B1,C1) &amp; route2(A2,B2,C2) &amp; route3(A3,B3,C3) &amp; (C2&lt;C1) &amp; (C2&lt;C3)</font> held with possible solution(s) <font face=\"Courier New\">[A1=324, A2=345, A3=410, B1=28099, B2=28545, B3=24848, C1=4, C2=2, C3=3, T=t2, U=safety]</font> and <font face=\"Courier New\">Plan 1: in response to the event: added the received message &quot;The Route Planner replied with routesSent(3)&quot; do add &quot;The UAV has 3 possible routes&quot;</font> was selected in state 138 because its guard <font face=\"Courier New\">~M</font> held with possible solution(s) <font face=\"Courier New\">[From=routePlanner, From0=routePlanner, M=routesSent(3), M0=routesSent(3), To=executive, To0=executive]</font> and  the message <\"mid\",\"thid\",routePlanner,1,executive,routesSent(3)> was received in state 102"; 
		String s2 = reason.getExplanation(ExplanationLevel.FINE, whys.getDescriptions());
		// System.err.println(s2);
		Boolean b = s2.equals(s);
		assertTrue(b);
	}

	// Test 12
	@Test public void whyCreateIStart() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/tracing/traces/robot_19-05-28_17-06-15-054.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		CreateIntentionEvent cie = (CreateIntentionEvent) whys.getEvent(3);
		CreateIntentionReason cier = new CreateIntentionReason(3, cie);
		whys.whyCreateIntention(cie, cier, whys.getTrace(), 3);
		String s = "add the goal achieve rubble(2,2) was an initial goal.";
		String s2 = cier.getExplanation(ExplanationLevel.FINE, whys.getDescriptions());
		// System.err.println(s2);
		Boolean b = s.equals(s2);
		assertTrue(b);
		
	}
	
	// Test 13
	@Test public void whyCreateFromPercept() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/tracing/traces/robot_19-05-28_17-06-15-054.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		CreateIntentionEvent cie = (CreateIntentionEvent) whys.getEvent(205);
		CreateIntentionReason cier = new CreateIntentionReason(205, cie);
		whys.whyCreateIntention(cie, cier, whys.getTrace(), 205);
		String s ="rubble(2,2) was perceived in state 205"; 
		String s2 = cier.getExplanation(ExplanationLevel.FINE, whys.getDescriptions());
		// System.err.println(s2);
		Boolean b = s.equals(s2);
		assertTrue(b);
		
	}

	// Test 14
	@Test public void whyNoRubble11() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/tracing/traces/robot_19-05-28_17-06-15-054.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		Predicate at11 = new Predicate("no_rubble");
		at11.addTerm(new NumberTermImpl(1));
		at11.addTerm(new NumberTermImpl(1));
		AbstractReason reason = whys.whyBelief(at11, 45);
		String s = "no_rubble(1,1) was believed in state 45 because the belief <font face=\"Courier New\">no_rubble(1,1)</font> was added because <font face=\"Courier New\">Plan 3: in response to the event: added the belief &quot;the robot is at [1,1]&quot; do add no_rubble(1,1)</font> was selected in state 41"; //  because its guard <font face=\"Courier New\">~rubble(X,Y)</font> held with possible solution(s) <font face=\"Courier New\">[X=1, X0=1, Y=1, Y0=1]</font> and \"the robot is at [1,1]\" was perceived in state 24";
		String s2 = reason.getExplanation(ExplanationLevel.FINE, whys.getDescriptions());
		//System.err.println(s);
		//System.err.println(s2);
		Boolean b = s2.equals(s);
		assertTrue(b);
		
	}

	// Test 15
	@Test public void whyCreateIOther() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/tracing/traces/robot_19-05-28_17-06-15-054.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		CreateIntentionEvent cie = (CreateIntentionEvent) whys.getEvent(44);
		CreateIntentionReason cier = new CreateIntentionReason(44, cie);
		whys.whyCreateIntention(cie, cier, whys.getTrace(), 44);
		String s = "<font face=\"Courier New\">Plan 3: in response to the event: added the belief &quot;the robot is at [1,1]&quot; do add no_rubble(1,1)</font> was selected in state 41 because its guard <font face=\"Courier New\">~rubble(X,Y)</font> held with possible solution(s) <font face=\"Courier New\">[X=1, X0=1, Y=1, Y0=1]</font> and \"the robot is at [1,1]\" was perceived in state 24";
		String s2 = cier.getExplanation(ExplanationLevel.FINE, whys.getDescriptions());
		// System.err.println(s2);
		Boolean b = s.equals(s2);
		assertTrue(b);
		
	}



}
