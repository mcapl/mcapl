// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis and Michael Fisher
//
// This file is part of the Python BDI Agent Model (PBDI) Library.
// 
// The PBDI Library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The EASS Library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the EASS Library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------
package pbdi.pi2goagent.parser;


import java.util.ArrayList;

import org.antlr.v4.runtime.CharStreams;
import org.junit.Assert;
import org.junit.Test;

import ail.syntax.Deed;
import ail.syntax.Guard;
import ail.syntax.Plan;
import ail.syntax.Term;
import pbdi.parser.P3BDIVisitor;
import pbdi.parser.Python3Lexer;
import pbdi.parser.Python3Parser;
import pbdi.syntax.ast.Abstract_PythonFunc;
import pbdi.syntax.ast.Abstract_PythonStmt;

public class PBDIParserQuickTests {
	/*
	 * Test that literal hashes and equality are behaving sensible.
	 */
	@Test public void actioniTest() throws Exception {
		
		String actionstring = "pi2go.forward(2)\n";
		
		Python3Lexer lexer = new Python3Lexer(CharStreams.fromString(actionstring));
		org.antlr.v4.runtime.CommonTokenStream tokens = new org.antlr.v4.runtime.CommonTokenStream(lexer);
		Python3Parser pslparser = new Python3Parser(tokens);
		P3BDIVisitor visitor = new P3BDIVisitor();
		try {
			@SuppressWarnings("unchecked")
			ArrayList<Abstract_PythonStmt> stmts = (ArrayList<Abstract_PythonStmt>) visitor.visitSuite(pslparser.suite());
			
			Abstract_PythonFunc function = new Abstract_PythonFunc("dummy");
			function.addStatement(stmts.get(0));
			
			Plan p = function.toPlan(new Guard());
			Deed d = p.getBody().get(0);
			String functor = ((Term) d.getContent()).getFunctor();
			Assert.assertTrue(functor.equals("pi2go.forward"));
			
			
		} catch (Exception e) {
			throw e;
		}
		
	}

}
