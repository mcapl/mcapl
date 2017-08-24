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
package pbdi.parser;

import java.util.ArrayList;
import java.util.List;

import ail.syntax.ast.Abstract_MAS;
import pbdi.syntax.ast.Abstract_PBDIAgent;
import pbdi.syntax.ast.Abstract_PythonFunc;
import pbdi.syntax.ast.Abstract_PythonStmt;

public class P3BDIVisitor extends Python3BaseVisitor<Object> {
	Abstract_PBDIAgent agent = new Abstract_PBDIAgent("agent");
	
	@Override public Object visitFile_input(Python3Parser.File_inputContext ctx) { 
		Abstract_MAS mas = new Abstract_MAS();
		List<Python3Parser.StmtContext> stmts = ctx.stmt();
		for (Python3Parser.StmtContext stmt:stmts) {
			Object item = visitStmt(stmt);
			if (item instanceof Abstract_PythonFunc) {
				agent.addFunc((Abstract_PythonFunc) item);
			}
		}
		ArrayList<Abstract_PBDIAgent> ags = new ArrayList<Abstract_PBDIAgent>();
		ags.add(agent);
		mas.setAgs(ags);
		return mas;
	}
	
	@Override public Object visitFuncdef(Python3Parser.FuncdefContext ctx) { 
		String name = ctx.NAME().getText();
		// funcdef: 'def' NAME parameters ('->' test)? ':' suite;
		ArrayList<Abstract_PythonStmt> stmts = (ArrayList<Abstract_PythonStmt>) visitSuite(ctx.suite()); 
		Abstract_PythonFunc func = new Abstract_PythonFunc(name);
		for (Abstract_PythonStmt s: stmts) {
			func.addStatement(s);
		}
		return func;
	}
	
	@Override public Object visitSuite(Python3Parser.SuiteContext ctx) {
		// suite: simple_stmt | NEWLINE INDENT stmt+ DEDENT;
		ArrayList<Abstract_PythonStmt> stmts = new ArrayList<Abstract_PythonStmt>();
		if (ctx.simple_stmt() != null) {
			String stmt_string = ctx.simple_stmt().getText();
			stmts.add(new Abstract_PythonStmt(stmt_string));
		} else {
			List<Python3Parser.StmtContext> statements = ctx.stmt();
			for (Python3Parser.StmtContext stmt: statements) {
				stmts.add(new Abstract_PythonStmt(stmt.getText()));
			}
		}
		return stmts;
	}
	
	@Override public Object visitAtom_expr(Python3Parser.Atom_exprContext ctx) { 
		List<Python3Parser.TrailerContext> trailers = ctx.trailer();
		for (int i = 0; i < trailers.size(); i++) {
			String s = trailers.get(i).getText();
			if (s.equals(".add_rule")) {
				String arglist = trailers.get(i+1).getText();
				agent.addRuleName(arglist.substring(1, arglist.length() - 1));
				return arglist.substring(1, arglist.length());
			}
		}
		return visitChildren(ctx); 
	}

}
