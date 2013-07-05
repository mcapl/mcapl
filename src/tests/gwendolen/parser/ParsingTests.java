// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis,  and Michael Fisher
//
// This file is part of Gwendolen
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
// License along with Gwendolen; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package gwendolen.parser;

import junit.framework.Assert;

import org.junit.Test;
import mcaplantlr.runtime.ANTLRStringStream;
import mcaplantlr.runtime.CommonTokenStream;
import ail.syntax.ast.Abstract_Goal;
import ail.syntax.Goal;
import ail.syntax.Unifier;

public class ParsingTests {

	
	/*
	 * Test that a variable appearing as a goal gets parsed properly - including converstion to concrete datatypes.
	 */
	@Test public void VarsinGoalsTest() {
		GwendolenLexer var_goal_lexer = new GwendolenLexer(new ANTLRStringStream("G [perform]"));
		CommonTokenStream var_goal_tokens = new CommonTokenStream(var_goal_lexer);
		GwendolenParser var_goal_parser = new GwendolenParser(var_goal_tokens);
		GwendolenLexer literal_goal_lexer = new GwendolenLexer(new ANTLRStringStream("send_pos [perform]"));
		CommonTokenStream literal_goal_tokens = new CommonTokenStream(literal_goal_lexer);
		GwendolenParser literal_goal_parser = new GwendolenParser(literal_goal_tokens);
		try {
			Abstract_Goal var_a_goal = var_goal_parser.goal();
			Abstract_Goal literal_a_goal = literal_goal_parser.goal();
			
			Goal var_goal = var_a_goal.toMCAPL();
			Goal literal_goal = literal_a_goal.toMCAPL();
			
			Assert.assertTrue(var_goal.unifies(literal_goal, new Unifier()));
		} catch (Exception e) {
			System.err.println(e);
		}
	}
 
}
