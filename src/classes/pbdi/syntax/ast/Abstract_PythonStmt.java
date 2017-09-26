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
package pbdi.syntax.ast;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import ail.parser.FOFVisitor;
import ail.syntax.Action;
import ail.syntax.Deed;
import ail.syntax.ast.Abstract_Action;
import ail.syntax.ast.Abstract_Predicate;
import ajpf.psl.parser.LogicalFmlasLexer;
import ajpf.psl.parser.LogicalFmlasParser;
import gov.nasa.jpf.vm.MJIEnv;

public class Abstract_PythonStmt {
	String statementstring;
	Abstract_Action statement;
	
	public Abstract_PythonStmt(String s) {
		statementstring = s;
		statement = string_to_action(s);
	}
	
	public void addString(String s) {
		statementstring = s;
		statement = string_to_action(s);
	}
	
	public String getString() {
		return statementstring;
	}
	
	public Abstract_Action getAction() {
		return statement;
	}
	
	public int newJPFObject(MJIEnv env) {
	    int objref = env.newObject("pbdi.syntax.ast.Abstract_PythonStmt");
	    env.setReferenceField(objref, "statementstring", env.newString(statementstring));
	    env.setReferenceField(objref, "statement", statement.newJPFObject(env));
	    return objref;
	}
	
	private Abstract_Action string_to_action(String s) {
		LogicalFmlasParser fof_parser = fofparser(s);
		FOFVisitor fof_visitor = new FOFVisitor();
		Abstract_Predicate p1 = (Abstract_Predicate) fof_visitor.visitFunction(fof_parser.function());
		
		Abstract_Action a = new Abstract_Action(p1, 0);
		return a;

	}
	
	private LogicalFmlasParser fofparser(String s) {
		LogicalFmlasLexer lexer = new LogicalFmlasLexer(CharStreams.fromString(s));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		LogicalFmlasParser parser = new LogicalFmlasParser(tokens);
		return parser;
	}


	
}
