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
		//GwendolenParser list1_parser = gwendolen_parser_for("[]");
		
		try {
			ListTerm cl = list_term_from_string("[]");
			
			Assert.assertTrue(cl.isEmpty());
		}  catch (Exception e) {
			System.err.println(e);
			Assert.assertFalse(true);
		}
		
	}
	
	@Test public void list2test() {
		// GwendolenLexer list1_lexer = new GwendolenLexer(new ANTLRStringStream("[a,d,z,c]"));
		
		try {
			ListTerm cl = list_term_from_string("[a,d,z,c]");
			
			Assert.assertTrue(cl.getHead().getFunctor().equals("a"));
			cl.remove(0);
			Assert.assertTrue(cl.getHead().getFunctor().equals("d"));
		}  catch (Exception e) {
			System.err.println(e);
			Assert.assertFalse(true);
		}
		
	}
	
	@Test public void list3test() {
		// GwendolenLexer list1_lexer = new GwendolenLexer(new ANTLRStringStream("[H|T]"));
		
		try {
			ListTerm cl = list_term_from_string("[H|T]");
			
			Assert.assertTrue(cl.getHead().getFunctor().equals("H"));
			Assert.assertTrue(cl.getTail().isVar());
		}  catch (Exception e) {
			System.err.println(e);
			Assert.assertFalse(true);
		}
		
	} 
	
	@Test public void list4test() {
		// GwendolenLexer list1_lexer = new GwendolenLexer(new ANTLRStringStream("[a,b|T]"));
		
		try {
			ListTerm cl = list_term_from_string("[a,b|T]");
			
			Assert.assertTrue(cl.getHead().getFunctor().equals("a"));
			cl.remove(0);
			Assert.assertTrue(cl.getHead().getFunctor().equals("b"));
			Assert.assertTrue(cl.getTail().isVar());
		}  catch (Exception e) {
			System.err.println(e);
			Assert.assertFalse(true);
		}

	}
	
	private ListTerm list_term_from_string(String  s) {
		LogicalFmlasLexer fof_lexer = new LogicalFmlasLexer(CharStreams.fromString(s));
		CommonTokenStream tokens = new CommonTokenStream(fof_lexer);
		LogicalFmlasParser fof_parser = new LogicalFmlasParser(tokens);
		FOFVisitor fof_visitor = new FOFVisitor();
		
		Abstract_ListTerm l = (Abstract_ListTerm) fof_visitor.visitListterm(fof_parser.listterm());
		return (ListTerm) l.toMCAPL();
	}
	


}
