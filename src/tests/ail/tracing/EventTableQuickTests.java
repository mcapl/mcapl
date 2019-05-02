package ail.tracing;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import ail.tracing.events.SelectPlanEvent;
import ail.tracing.explanations.ExplanationLevel;
import ail.tracing.explanations.SelectPlanReason;
import ail.tracing.explanations.WhyQuestions;
import ajpf.MCAPLcontroller;

public class EventTableQuickTests {
	
	@Test public void readInTest() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/tracing/traces/robot_19-05-02_17-26-17-051.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		System.err.println(whys.verboseString());
	}
	
	@Test public void selectContinuePlanTest() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/tracing/traces/robot_19-04-03_09-00-27-814.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		SelectPlanEvent spe = (SelectPlanEvent) whys.getEvent(7);
		SelectPlanReason spr = new SelectPlanReason(7, spe);
		whys.whySelectPlan(spe, spr, whys.getTrace(), 7);
		String s = "<font face=\"Courier New\">continue processing: add the goal achieve &quot;the robot is holding rubble&quot;</font> was selected in state 7 because starting goal +!_aholding(rubble) was posted in state 3.";
		String s2 = spr.getExplanation(ExplanationLevel.FINE, whys.getDescriptions());
		Boolean b = s2.equals(s);
		assertTrue(b);
	}
	
	@Test public void selectPlanTest() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/tracing/traces/robot_19-04-03_09-00-27-814.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		SelectPlanEvent spe = (SelectPlanEvent) whys.getEvent(165);
		SelectPlanReason spr = new SelectPlanReason(165, spe);
		whys.whySelectPlan(spe, spr, whys.getTrace(), 165);
		String s = "<font face=\"Courier New\">Plan 4: in response to the event: added the belief &quot;the robot is holding rubble&quot; do print(done)</font> was selected in state 165 because its guard <font face=\"Courier New\">True</font> held  and  event <font face=\"Courier New\">+holding(rubble)[source(percept)]</font> was posted in state 153.";
		String s2 = spr.getExplanation(ExplanationLevel.FINE, whys.getDescriptions());
		System.err.println(s2);
		Boolean b = s2.equals(s);
		assertTrue(b);
	}

	@Test public void selectPlanModifyIntentionTest() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/tracing/traces/robot_19-05-02_17-26-17-051.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		SelectPlanEvent spe = (SelectPlanEvent) whys.getEvent(48);
		SelectPlanReason spr = new SelectPlanReason(48, spe);
		whys.whySelectPlan(spe, spr, whys.getTrace(), 48);
		String s = "<font face=\"Courier New\">Plan 2: in response to the event: added the goal achieve &quot;the robot is holding rubble&quot; do move_to(X,Y) with [X=3, Y=3]</font> was selected in state 48 because its guard <font face=\"Courier New\">possible_rubble(X,Y) &amp; ~no_rubble(X,Y)</font> held with possible solution(s) <font face=\"Courier New\">[[X=3, Y=3], [X=5, Y=5]]</font> and  the event <font face=\"Courier New\">+!_aholding(rubble)</font> was posted because it appeared next in intention 1 in state 37";
		String s2 = spr.getExplanation(ExplanationLevel.FINE, whys.getDescriptions());
		// System.err.println(s2);
		Boolean b = s2.equals(s);
		assertTrue(b);
	}

}
