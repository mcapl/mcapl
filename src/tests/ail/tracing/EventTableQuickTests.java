package ail.tracing;

import java.io.File;

import org.junit.Test;

import ail.tracing.explanations.WhyQuestions;
import ajpf.MCAPLcontroller;

public class EventTableQuickTests {
	
	@Test public void readInTest() {
		File example_file = new File(MCAPLcontroller.getAbsFilename("/src/examples/gwendolen/tracing/traces/robot_19-04-03_09-00-27-814.db"));
		EventTableTestRig test_rig = new EventTableTestRig(example_file);
		WhyQuestions whys = test_rig.getTrace();
		System.err.println(whys);
	}

}
