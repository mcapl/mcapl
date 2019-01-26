package ail.syntax;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PrintingStringTermsQuickTests {
	@Test public void PrintStringTermTest() {
		Predicate p = new Predicate("flightPhase");
   		p.addTerm(new StringTermImpl("landed"));
   		
   		String s = p.toString();
   		String s1 = "flightPhase(\"landed\")";
   		
   		assertTrue(s1.equals(s));
	}

}
