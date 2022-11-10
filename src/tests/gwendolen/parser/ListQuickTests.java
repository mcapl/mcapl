// ----------------------------------------------------------------------------
// Copyright (C) 2015 Louise A. Dennis,  and Michael Fisher
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

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import ail.parser.FOFVisitor;
import ail.syntax.ListTerm;
import ail.syntax.ast.Abstract_ListTerm;
import ajpf.psl.parser.LogicalFmlasLexer;
import ajpf.psl.parser.LogicalFmlasParser;

public class ListQuickTests {
	@Test public void list1test() {
		LogicalFmlasLexer list1_lexer = new LogicalFmlasLexer(CharStreams.fromString("[]"));
		CommonTokenStream list1_tokens = new CommonTokenStream(list1_lexer);
		LogicalFmlasParser list1_parser = new LogicalFmlasParser(list1_tokens);
		FOFVisitor visitor = new FOFVisitor();
		
		try {
			Abstract_ListTerm l = ((Abstract_ListTerm) visitor.visitListterm(list1_parser.listterm()));
			ListTerm cl = (ListTerm) l.toMCAPL(); 
			
			Assert.assertTrue(cl.isEmpty());
		}  catch (Exception e) {
			System.err.println(e);
			Assert.assertFalse(true);
		}
		
	} 
	
	@Test public void list2test() {
		LogicalFmlasLexer list1_lexer = new LogicalFmlasLexer(CharStreams.fromString("[a,d,z,c]")); 
		CommonTokenStream list1_tokens = new CommonTokenStream(list1_lexer);
		LogicalFmlasParser list1_parser = new LogicalFmlasParser(list1_tokens);
		FOFVisitor visitor = new FOFVisitor();
				
		try {
			Abstract_ListTerm l = ((Abstract_ListTerm) visitor.visitListterm(list1_parser.listterm()));
			ListTerm cl = (ListTerm) l.toMCAPL();
			
			Assert.assertTrue(cl.getHead().getFunctor().equals("a"));
			cl.remove(0);
			Assert.assertTrue(cl.getHead().getFunctor().equals("d"));
		}  catch (Exception e) {
			System.err.println(e);
			Assert.assertFalse(true);
		}
		
	}
	
	@Test public void list3test() {
		LogicalFmlasLexer list1_lexer = new LogicalFmlasLexer(CharStreams.fromString("[H|T]"));
		CommonTokenStream list1_tokens = new CommonTokenStream(list1_lexer);
		LogicalFmlasParser list1_parser = new LogicalFmlasParser(list1_tokens);
		FOFVisitor visitor = new FOFVisitor();
		
		try {
			Abstract_ListTerm l = ((Abstract_ListTerm) visitor.visitListterm(list1_parser.listterm()));
			ListTerm cl = (ListTerm) l.toMCAPL();
			
			Assert.assertTrue(cl.getHead().getFunctor().equals("H"));
			Assert.assertTrue(cl.getTail().isVar());
		}  catch (Exception e) {
			System.err.println(e);
			Assert.assertFalse(true);
		}
		
	}
	
	@Test public void list4test() {
		LogicalFmlasLexer list1_lexer = new LogicalFmlasLexer(CharStreams.fromString("[a,b|T]"));
		CommonTokenStream list1_tokens = new CommonTokenStream(list1_lexer);
		LogicalFmlasParser list1_parser = new LogicalFmlasParser(list1_tokens);
		FOFVisitor visitor = new FOFVisitor();
		
		try {
			Abstract_ListTerm l = ((Abstract_ListTerm) visitor.visitListterm(list1_parser.listterm()));
			ListTerm cl = (ListTerm) l.toMCAPL();
			
			Assert.assertTrue(cl.getHead().getFunctor().equals("a"));
			cl.remove(0);
			Assert.assertTrue(cl.getHead().getFunctor().equals("b"));
			Assert.assertTrue(cl.getTail().isVar());
		}  catch (Exception e) {
			System.err.println(e);
			Assert.assertFalse(true);
		}

	}

}
