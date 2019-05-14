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
import ail.tracing.explanations.CreateIntentionReason;
import ail.tracing.explanations.ExplanationLevel;
import ail.tracing.explanations.ModifyIntentionReason;
import ail.tracing.explanations.SelectPlanReason;
import ail.tracing.explanations.WhyQuestions;
import ajpf.MCAPLcontroller;

public class EventTableQuickTests {
	
	@Test public void readInTest() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/tracing/traces/robot_19-05-08_08-21-36-142.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		System.err.println(whys.verboseString());
	}
	
	@Test public void selectContinuePlanTest() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/tracing/traces/robot_19-05-08_08-21-36-142.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		SelectPlanEvent spe = (SelectPlanEvent) whys.getEvent(28);
		SelectPlanReason spr = new SelectPlanReason(28, spe);
		whys.whySelectPlan(spe, spr, whys.getTrace(), 28);
		// String s = "<font face=\"Courier New\">continue processing: add the goal achieve &quot;the robot is holding rubble&quot;</font> was selected in state 7 because starting goal +!_aholding(rubble) was posted in state 3.";
		String s2 = spr.getExplanation(ExplanationLevel.FINE, whys.getDescriptions());
		System.err.println(s2);
		//Boolean b = s2.equals(s);
		//assertTrue(b);
	}
	
	@Test public void selectPlanTest() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/tracing/traces/robot_19-05-08_08-21-36-142.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		SelectPlanEvent spe = (SelectPlanEvent) whys.getEvent(84);
		SelectPlanReason spr = new SelectPlanReason(84, spe);
		whys.whySelectPlan(spe, spr, whys.getTrace(), 84);
		//String s = "<font face=\"Courier New\">Plan 4: in response to the event: added the belief &quot;the robot is holding rubble&quot; do print(done)</font> was selected in state 165 because its guard <font face=\"Courier New\">True</font> held  and  event <font face=\"Courier New\">+holding(rubble)[source(percept)]</font> was posted in state 153.";
		String s2 = spr.getExplanation(ExplanationLevel.FINE, whys.getDescriptions());
		System.err.println(s2);
		//Boolean b = s2.equals(s);
		//assertTrue(b);
	}

	@Test public void selectPlanModifyIntentionTest() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/tracing/traces/robot_19-05-08_08-21-36-142.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		SelectPlanEvent spe = (SelectPlanEvent) whys.getEvent(148);
		SelectPlanReason spr = new SelectPlanReason(148, spe);
		whys.whySelectPlan(spe, spr, whys.getTrace(), 148);
		String s = "<font face=\"Courier New\">Plan 2: in response to the event: added the goal achieve &quot;the robot is holding rubble&quot; do move_to(X,Y) with [X=3, Y=3]</font> was selected in state 48 because its guard <font face=\"Courier New\">possible_rubble(X,Y) &amp; ~no_rubble(X,Y)</font> held with possible solution(s) <font face=\"Courier New\">[[X=3, Y=3], [X=5, Y=5]]</font> and  the event <font face=\"Courier New\">+!_aholding(rubble)</font> was posted because it appeared next in intention 1 in state 37";
		String s2 = spr.getExplanation(ExplanationLevel.FINE, whys.getDescriptions());
		System.err.println(s2);
		//Boolean b = s2.equals(s);
		//assertTrue(b);
	}
	
	@Test public void whyBeliefCreated() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/tracing/traces/robot_19-05-08_08-21-36-142.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		Predicate at11 = new Predicate("at");
		at11.addTerm(new NumberTermImpl(1));
		at11.addTerm(new NumberTermImpl(1));
		AbstractReason reason = whys.whyBelief(at11, 36);
		//String s = "";
		String s2 = reason.getExplanation(ExplanationLevel.FINE, whys.getDescriptions());
		System.err.println(s2);
		//Boolean b = s2.equals(s);
		//assertTrue(b);
	}

	@Test public void whyInitialBelief() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/tracing/traces/robot_19-05-08_08-21-36-142.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		Predicate at11 = new Predicate("possible_rubble");
		at11.addTerm(new NumberTermImpl(1));
		at11.addTerm(new NumberTermImpl(1));
		AbstractReason reason = whys.whyBelief(at11, 36);
		String s = "Belief possible_rubble(1,1) was believed in state 36 because the belief(s) <font face=\"Courier New\">possible_rubble(1,1)</font> were added upon starting the agent.";
		String s2 = reason.getExplanation(ExplanationLevel.FINE, whys.getDescriptions());
		System.err.println(s2);
		Boolean b = s2.equals(s);
		assertTrue(b);
	}
	
	@Test public void whyInitialGoal() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/tracing/traces/robot_19-05-08_08-21-36-142.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		Predicate at11 = new Predicate("rubble");
		at11.addTerm(new NumberTermImpl(2));
		at11.addTerm(new NumberTermImpl(2));
		AbstractReason reason = whys.whyGoal(at11, 9);
		// String s = "Belief possible_rubble(1,1) was believed in state 36 because the belief(s) <font face=\"Courier New\">possible_rubble(1,1)</font> were added upon starting the agent.";
		String s2 = reason.getExplanation(ExplanationLevel.FINE, whys.getDescriptions());
		System.err.println(s2);
		//Boolean b = s2.equals(s);
		//assertTrue(b);
	}
	
	@Test public void whySubGoal() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/tracing/traces/robot_19-05-08_08-21-36-142.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		Predicate at11 = new Predicate("holding");
		at11.addTerm(new Predicate("rubble"));
		// at11.addTerm(new NumberTermImpl(2));
		AbstractReason reason = whys.whyGoal(at11, 37);
		// String s = "Belief possible_rubble(1,1) was believed in state 36 because the belief(s) <font face=\"Courier New\">possible_rubble(1,1)</font> were added upon starting the agent.";
		String s2 = reason.getExplanation(ExplanationLevel.FINE, whys.getDescriptions());
		System.err.println(s2);
		//Boolean b = s2.equals(s);
		//assertTrue(b);
	}
	
	@Test public void whyAddInitialGoal() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/tracing/traces/robot_19-05-08_08-21-36-142.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		ModifyIntentionEvent mie = (ModifyIntentionEvent) whys.getEvent(9);
		ModifyIntentionReason mir = new ModifyIntentionReason(9, mie);
		whys.whyAddGoal(mie, mir, whys.getTrace(), 9);
		// String s = "Belief possible_rubble(1,1) was believed in state 36 because the belief(s) <font face=\"Courier New\">possible_rubble(1,1)</font> were added upon starting the agent.";
		String s2 = mir.getExplanation(ExplanationLevel.FINE, whys.getDescriptions());
		System.err.println(s2);
		//Boolean b = s2.equals(s);
		//assertTrue(b);
	}

	@Test public void whyAddSubGoal() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/tracing/traces/robot_19-05-08_08-21-36-142.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		ModifyIntentionEvent mie = (ModifyIntentionEvent) whys.getEvent(126);
		ModifyIntentionReason mir = new ModifyIntentionReason(126, mie);
		whys.whyAddGoal(mie, mir, whys.getTrace(), 126);
		// String s = "Belief possible_rubble(1,1) was believed in state 36 because the belief(s) <font face=\"Courier New\">possible_rubble(1,1)</font> were added upon starting the agent.";
		String s2 = mir.getExplanation(ExplanationLevel.FINE, whys.getDescriptions());
		System.err.println(s2);
		//Boolean b = s2.equals(s);
		//assertTrue(b);
	}
	
	@Test public void whyAction() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/tracing/traces/robot_19-05-08_08-21-36-142.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		Action drop = new Action("drop");
		AbstractReason reason = whys.whyAction(drop, 202);
		// String s = "Belief possible_rubble(1,1) was believed in state 36 because the belief(s) <font face=\"Courier New\">possible_rubble(1,1)</font> were added upon starting the agent.";
		String s2 = reason.getExplanation(ExplanationLevel.FINE, whys.getDescriptions());
		System.err.println(s2);
		//Boolean b = s2.equals(s);
		//assertTrue(b);
	}
	
	@Test public void whyCreateIStart() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/tracing/traces/robot_19-05-08_08-21-36-142.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		CreateIntentionEvent cie = (CreateIntentionEvent) whys.getEvent(3);
		CreateIntentionReason cier = new CreateIntentionReason(3, cie);
		whys.whyCreateIntention(cie, cier, whys.getTrace(), 3);
		String s2 = cier.getExplanation(ExplanationLevel.FINE, whys.getDescriptions());
		System.err.println(s2);
		
	}
	
	@Test public void whyCreateFromPercept() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/tracing/traces/robot_19-05-08_08-21-36-142.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		CreateIntentionEvent cie = (CreateIntentionEvent) whys.getEvent(205);
		CreateIntentionReason cier = new CreateIntentionReason(205, cie);
		whys.whyCreateIntention(cie, cier, whys.getTrace(), 205);
		String s2 = cier.getExplanation(ExplanationLevel.FINE, whys.getDescriptions());
		System.err.println(s2);
		
	}

	@Test public void whyCreateIOther() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/tracing/traces/robot_19-05-08_08-21-36-142.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		CreateIntentionEvent cie = (CreateIntentionEvent) whys.getEvent(44);
		CreateIntentionReason cier = new CreateIntentionReason(44, cie);
		whys.whyCreateIntention(cie, cier, whys.getTrace(), 44);
		String s2 = cier.getExplanation(ExplanationLevel.FINE, whys.getDescriptions());
		System.err.println(s2);
		
	}



}
