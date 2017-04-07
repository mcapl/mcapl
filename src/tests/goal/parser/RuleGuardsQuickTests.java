// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis, Michael Fisher, and Koen Hindriks
// 
// This file is part of AIL GOAL.  An AIL Implementation of the GOAL Programming
// Language
//
// AIL GOAL is free software: you can redistribute it and/or modify it under
// the terms of the GNU General Public License as published by the Free Software
// Foundation, either version 3 of the License, or (at your option) any later
// version.
//
// AIL GOAL is distributed in the hope that it will be useful, but WITHOUT
// ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
// FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
// details.
//
// You should have received a copy of the GNU General Public License along with
// this program. If not, see <http://www.gnu.org/licenses/>.
//
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------
package goal.parser;

import goal.syntax.ActionRule;
import goal.syntax.ast.Abstract_ActionRule;
import junit.framework.Assert;
import mcaplantlr.runtime.ANTLRStringStream;
import mcaplantlr.runtime.CommonTokenStream;

import org.junit.Test;


public class RuleGuardsQuickTests {
	@Test public void notgoalguard() {
		GOALParser parser = parser_for("if not(goal(in(I))), not(goal(atBrick(B))), not(goal(holding(H))), not(goal(delivered(D))), bel(not(finished(_)), nextItemInSeq(Color), hasColour(Brick, Color)) then adopt(atBrick(Brick)).");
		
		try {
			Abstract_ActionRule l = parser.programRule();
			ActionRule r = l.toMCAPL();
			
			Assert.assertTrue(true);
		}  catch (Exception e) {
			System.err.println(e);
			Assert.assertFalse(true);
		}
		
	}
	

	
	GOALParser parser_for(String s) {
		GOALLexer lexer = new GOALLexer(new ANTLRStringStream(s));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		GOALParser parser = new GOALParser(tokens);
		return parser;
	}

}
