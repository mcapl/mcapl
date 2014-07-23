package ail.syntax;

import gwendolen.parser.GwendolenLexer;
import gwendolen.parser.GwendolenParser;
import junit.framework.Assert;

import mcaplantlr.runtime.ANTLRStringStream;
import mcaplantlr.runtime.CommonTokenStream;

import org.junit.Test;

import ail.semantics.AILAgent;
import ail.semantics.operationalrules.*;

import java.util.Random;

public class PlanTests {
	@Test public void planBodyUnification() {
		GwendolenLexer plan_lexer = new GwendolenLexer(new ANTLRStringStream("+received(LG): {~B handling(LG)} <- +handling(LG), +!LG [perform], -handling(LG);"));
		CommonTokenStream plan_tokens = new CommonTokenStream(plan_lexer);
		GwendolenParser plan_parser = new GwendolenParser(plan_tokens);
		
		try {
			Plan plan = (plan_parser.plan()).toMCAPL();
			
			Literal received = new Literal("received");
			received.addTerm(new Literal("goal"));
			
			Intention i = new Intention(new Event(Event.AILAddition, Event.AILBel, received), AILAgent.refertoself());
			AILAgent a = new AILAgent("ag");
			a.setIntention(i);
			a.addPlan(plan);
			
			GenerateApplicablePlansIfNonEmpty gplans = new GenerateApplicablePlansIfNonEmpty();
			Assert.assertTrue(gplans.checkPreconditions(a));
			gplans.apply(a);
			
			ApplyApplicablePlans aplans = new ApplyApplicablePlans();
			Assert.assertTrue(aplans.checkPreconditions(a));
			aplans.apply(a);
			System.err.println(i);
			Deed d = i.deeds().get(1);
			Assert.assertFalse(d.getContent().getVarNames().isEmpty());
			Assert.assertFalse(d.getContent().getVarNames().contains(new VarTerm("LG")));
		

			
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}

}
