package ail.syntax;

import gwendolen.parser.GwendolenLexer;
import gwendolen.parser.GwendolenParser;

import java.util.Iterator;

import mcaplantlr.runtime.ANTLRStringStream;
import mcaplantlr.runtime.CommonTokenStream;

import org.junit.Assert;
import org.junit.Test;

import ail.semantics.AILAgent;
import ail.syntax.ast.Abstract_Predicate;
import ajpf.psl.MCAPLPredicate;
import ajpf.psl.MCAPLTermImpl;
import ajpf.psl.ast.Abstract_Formula;
import ajpf.psl.parser.A_PSLLexer;
import ajpf.psl.parser.A_PSLParser;

public class MatchingAJPFSyntaxTests {

	@Test public void beliefPropertyTest() {
		
		MCAPLPredicate l1 = new MCAPLPredicate("l");
		Literal l2 = new Literal("l");
		
		
		AILAgent a = new AILAgent("agent");
		a.addBel(l2, a.refertoself());
		
		Assert.assertTrue(a.MCAPLbelieves(l1));
	}

	@Test public void beliefSubTermPropertyTest() {
		
		MCAPLPredicate l1 = new MCAPLPredicate("l");
		MCAPLTermImpl p = new MCAPLTermImpl("p");
		l1.addTerm(p);
		Literal l2 = new Literal("l");
		Predicate p1 = new Predicate("p");
		l2.addTerm(p1);
		
		
		AILAgent a = new AILAgent("agent");
		a.addBel(l2, a.refertoself());
		
		Assert.assertTrue(a.MCAPLbelieves(l1));
	}
	
	/**
	 * Testing parsing of beliefs with numbers.
	 * @throws Exception
	 */
	@Test public void BeliefsWithNumbersTest() throws Exception {
		String mcaplbelief = "at(0, 1))";
		String inbeliefbase = "at(0, 1)";
		
		A_PSLLexer lexer = new A_PSLLexer(new ANTLRStringStream(mcaplbelief));
		CommonTokenStream psltokens = new CommonTokenStream(lexer);
		A_PSLParser pslparser = new A_PSLParser(psltokens);
		try {
			Abstract_Formula p = pslparser.formula();
			AILAgent a = new AILAgent("ag1");
		
			GwendolenLexer g_lexer = new GwendolenLexer(new ANTLRStringStream(inbeliefbase));
			CommonTokenStream g_tokens = new CommonTokenStream(g_lexer);
			GwendolenParser g_parser = new GwendolenParser(g_tokens);
		
			Abstract_Predicate b = g_parser.pred();

			MCAPLPredicate mp = (MCAPLPredicate) p.toMCAPL();
			Predicate gb = b.toMCAPL();
			a.addBel(new Literal(true, new PredicatewAnnotation(gb)), a.refertoself());
			
			Predicate gmp = new Predicate(mp);
			Assert.assertTrue(a.MCAPLbelieves(mp));

		} catch (Exception e) {
			throw e;
		}
		


	}

}
