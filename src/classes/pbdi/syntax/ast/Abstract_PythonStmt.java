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
import ail.syntax.ast.Abstract_Action;
import ail.syntax.ast.Abstract_Deed;
import ail.syntax.ast.Abstract_Literal;
import ail.syntax.ast.Abstract_Predicate;
import ail.syntax.ast.Abstract_StringTermImpl;
import ail.syntax.ast.Abstract_Term;
import ajpf.psl.parser.LogicalFmlasLexer;
import ajpf.psl.parser.LogicalFmlasParser;
import gov.nasa.jpf.vm.MJIEnv;

public class Abstract_PythonStmt implements Abstract_PythonS {
	String statementstring;
	Abstract_Deed statement;
	
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
	
	public Abstract_Deed getDeed() {
		return statement;
	}
	
	public int newJPFObject(MJIEnv env) {
	    int objref = env.newObject("pbdi.syntax.ast.Abstract_PythonStmt");
	    env.setReferenceField(objref, "statementstring", env.newString(statementstring));
	    env.setReferenceField(objref, "statement", statement.newJPFObject(env));
	    return objref;
	}
	
	private Abstract_Deed string_to_action(String s) {
		LogicalFmlasParser fof_parser = fofparser(s);
		FOFVisitor fof_visitor = new FOFVisitor();
		Abstract_Predicate p1 = (Abstract_Predicate) fof_visitor.visitFunction(fof_parser.function());
		if (p1.getFunctor().equals("add_belief") || p1.getFunctor().equals(".add_belief")) {
			Abstract_Term arg = (Abstract_Term) p1.getTerm(0);
			Abstract_Literal p2;
			if (arg instanceof Abstract_StringTermImpl) {
				p2 = new Abstract_Literal(((Abstract_StringTermImpl) arg).getString());
				if (p1.getTermSize() > 1) {
					p2.addTerm(p1.getTerm(1));
				}
			} else {
				p2 = (Abstract_Literal) arg;
			}
			return new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILBel, p2);
		} else {
			return new Abstract_Deed(new Abstract_Action(p1));
		}

	}
	
	private LogicalFmlasParser fofparser(String s) {
		LogicalFmlasLexer lexer = new LogicalFmlasLexer(CharStreams.fromString(s));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		LogicalFmlasParser parser = new LogicalFmlasParser(tokens);
		return parser;
	}


	
}
