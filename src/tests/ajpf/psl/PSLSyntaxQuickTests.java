// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of Agent JPF (AJPF)
// 
// AJPF is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// AJPF is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with AJPF; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ajpf.psl;

import org.junit.Test;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Assert;

import gwendolen.parser.GwendolenLexer;
import gwendolen.parser.GwendolenParser;

import ail.parser.FOFVisitor;
import ail.syntax.Predicate;
import ail.syntax.Unifier;
import ail.syntax.ast.Abstract_Predicate;
import ail.mas.MAS;
import ajpf.psl.ast.Abstract_Property;
import ajpf.psl.parser.AJPF_PSLVisitor;
import ajpf.psl.parser.A_PSLLexer;
import ajpf.psl.parser.A_PSLParser;
import ajpf.psl.parser.LogicalFmlasLexer;
import ajpf.psl.parser.LogicalFmlasParser;
import ajpf.psl.ast.Abstract_Formula;

/**
 * Regression tests for the syntax elements of the property specification language.
 * @author louiseadennis
 *
 */
public class PSLSyntaxQuickTests {
	
	@Test public void UntilReleaseEqualityTest() {

		FalseProp f1 = new FalseProp();
		FalseProp f2 = new FalseProp();
		TrueProp t1 = new TrueProp();
		TrueProp t2 = new TrueProp();
		 
		Release r1 = new Release(f1, t1);
		Release r2 = new Release(f2, t2);
		
		Until u1 = new Until(t1, r1);
		Until u2 = new Until(t2, r2);
		
		
		Assert.assertTrue(u1.equals(u2));
		
	}
	
	@Test public void UntilEqualityTest() {

		MAS m = new MAS();
		MCAPLPercept p1 = new MCAPLPercept(m, new Predicate("s"));
		MCAPLPercept p2 = new MCAPLPercept(m, new Predicate("s"));
		TrueProp t1 = new TrueProp();
		TrueProp t2 = new TrueProp();
		
		
		Until u1 = new Until(t1, p1);
		Until u2 = new Until(t2, p2);
		
		
		Assert.assertTrue(u1.equals(u2));
		
	}
	
	@Test public void PerceptTest() {

		MAS m = new MAS();
		MCAPLPercept p1 = new MCAPLPercept(m, new Predicate("s"));
		MCAPLPercept p2 = new MCAPLPercept(m, new Predicate("s"));
		
		
		
		Assert.assertTrue(p1.equals(p2));
		
	}
	
	@Test public void UnnamedVarTest() throws Exception {
		String mcaplwithvar = "somebelief(_)";
		String inbeliefbase = "somebelief(somebelief)";
		
		LogicalFmlasLexer lexer = new LogicalFmlasLexer(CharStreams.fromString(mcaplwithvar));
		org.antlr.v4.runtime.CommonTokenStream psltokens = new org.antlr.v4.runtime.CommonTokenStream(lexer);
		LogicalFmlasParser pslparser = new LogicalFmlasParser(psltokens);
		ajpf.psl.parser.FOFVisitor ajpf_visitor = new ajpf.psl.parser.FOFVisitor();
		ail.parser.FOFVisitor ail_visitor = new ail.parser.FOFVisitor();
		try {
			Abstract_Formula p = (Abstract_Formula) ajpf_visitor.visitFunction(pslparser.function());
		
			LogicalFmlasLexer g_lexer = new LogicalFmlasLexer(CharStreams.fromString(inbeliefbase));
			CommonTokenStream g_tokens = new CommonTokenStream(g_lexer);
			LogicalFmlasParser g_parser = new LogicalFmlasParser(g_tokens);
		
			Abstract_Predicate b = ((Abstract_Predicate) ail_visitor.visitPred(g_parser.pred()));

			MCAPLPredicate mp = (MCAPLPredicate) p.toMCAPL();
			Predicate gb = b.toMCAPL();
			
			Predicate gmp = new Predicate(mp);
			Assert.assertTrue(gmp.unifies(gb, new Unifier()));

		} catch (Exception e) {
			throw e;
		}
		


	}

	@Test public void dPropTest() throws Exception {
		String propertystring = "query(get_close_to(middle,_))";
		A_PSLLexer lexer = new A_PSLLexer(CharStreams.fromString(propertystring));
		org.antlr.v4.runtime.CommonTokenStream psltokens = new org.antlr.v4.runtime.CommonTokenStream(lexer);
		A_PSLParser pslparser = new A_PSLParser(psltokens);
		AJPF_PSLVisitor visitor = new AJPF_PSLVisitor();
		pslparser.fof_expr();
	}

	
	@Test public void toMCAPLNativeTest() throws Exception {
		String propertystring = "(  [] ( D(ag1, query(get_close_to(middle, _))) -> <> B(ag1, have_plan(middle, plan_middle)) )\n     &     [] ( D(ag1, perf(execute(plan_middle))) ->  <> B(ag1, in_position(middle))  )    ) \n ->     <> B(ag1, something_false)";
		A_PSLLexer lexer = new A_PSLLexer(CharStreams.fromString(propertystring));
		org.antlr.v4.runtime.CommonTokenStream psltokens = new org.antlr.v4.runtime.CommonTokenStream(lexer);
		A_PSLParser pslparser = new A_PSLParser(psltokens);
		AJPF_PSLVisitor visitor = new AJPF_PSLVisitor();
		Abstract_Property p = (Abstract_Property) visitor.visitProperty(pslparser.property());
		Abstract_Property np = p.toNormalForm();
		MCAPLProperty mp = np.toMCAPLNative();
		Assert.assertTrue(mp instanceof Or);
	}
	

}
