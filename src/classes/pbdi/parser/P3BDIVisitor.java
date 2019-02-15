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

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import ail.syntax.ast.Abstract_Guard;
import ail.syntax.ast.Abstract_MAS;
import pbdi.syntax.ast.Abstract_PBDIAgent;
import pbdi.syntax.ast.Abstract_PBDIBestRule;
import pbdi.syntax.ast.Abstract_PBDIRule;
import pbdi.syntax.ast.Abstract_PythonAndExpr;
import pbdi.syntax.ast.Abstract_PythonAtomExpr;
import pbdi.syntax.ast.Abstract_PythonComparison;
import pbdi.syntax.ast.Abstract_PythonExpr;
import pbdi.syntax.ast.Abstract_PythonFunc;
import pbdi.syntax.ast.Abstract_PythonIfStmt;
import pbdi.syntax.ast.Abstract_PythonNotExpr;
import pbdi.syntax.ast.Abstract_PythonS;
import pbdi.syntax.ast.Abstract_PythonStmt;

public class P3BDIVisitor extends Python3BaseVisitor<Object> {
	Abstract_PBDIAgent agent = new Abstract_PBDIAgent("agent");
	String agent_name = "agent";
	String pi2go = "pi2go";
	
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
	
	/* @Override public Object visitStmt(Python3Parser.StmtContext ctx) {
		Object stmt_object = super.visitStmt(ctx);
		
		agent.addStatement(stmt_object);
	} */
	
	@Override public Object visitFuncdef(Python3Parser.FuncdefContext ctx) { 
		String name = ctx.NAME().getText();
		// funcdef: 'def' NAME parameters ('->' test)? ':' suite;
		@SuppressWarnings("unchecked")
		ArrayList<Abstract_PythonStmt> stmts = (ArrayList<Abstract_PythonStmt>) visitSuite(ctx.suite()); 
		Abstract_PythonFunc func = new Abstract_PythonFunc(name);
		for (Abstract_PythonS s: stmts) {
			func.addStatement(s);
		}
		
		Python3Parser.ParametersContext p_ctx = ctx.parameters();
		if (p_ctx.typedargslist() != null) {
			for (Python3Parser.TfpdefContext tpfdef: p_ctx.typedargslist().tfpdef()) {
				func.addParameter(tpfdef.NAME().toString());
			}
		}
		return func;
	}
	
	@Override public Object visitSuite(Python3Parser.SuiteContext ctx) {
		// suite: simple_stmt | NEWLINE INDENT stmt+ DEDENT;
		ArrayList<Abstract_PythonS> stmts = new ArrayList<Abstract_PythonS>();
		if (ctx.simple_stmt() != null) {
			Python3Parser.Simple_stmtContext simple_stmt = ctx.simple_stmt();
			boolean parsed = false;
			try {
				Python3Parser.Atom_exprContext atom_expr = atom_expr_from_simple_stmt(simple_stmt);
				stmts.add(atom_expr_to_Action(atom_expr));
				parsed = true;
			} catch (Exception e) {
				
			}
		
			if  (!parsed) {
				String stmt_string = ctx.simple_stmt().getText();
				stmts.add(new Abstract_PythonStmt(stmt_string));
			}
		} else {
			List<Python3Parser.StmtContext> statements = ctx.stmt();
			for (Python3Parser.StmtContext stmt: statements) {
				if (stmt.simple_stmt() != null) {
					Python3Parser.Simple_stmtContext simple_stmt = stmt.simple_stmt();
					boolean parsed = false;
					try {
						Python3Parser.Atom_exprContext atom_expr = atom_expr_from_simple_stmt(simple_stmt);
						stmts.add(atom_expr_to_Action(atom_expr));
						parsed = true;
					} catch (Exception e) {
						
					}
				
					if  (!parsed) {
						String stmt_string = simple_stmt.getText();
						stmts.add(new Abstract_PythonStmt(stmt_string));
					}
				} else {
					Python3Parser.Compound_stmtContext compound = stmt.compound_stmt();
					if (compound.if_stmt() != null) {
						Python3Parser.If_stmtContext ifstmt = compound.if_stmt();
						ArrayList<Abstract_PythonS> if_stmts = (ArrayList<Abstract_PythonS>) visitSuite(ifstmt.suite(0));
						ArrayList<Abstract_PythonS> else_stmts = new ArrayList<Abstract_PythonS>();
						if (ifstmt.suite().size() > 1) {
							else_stmts = (ArrayList<Abstract_PythonS>) visitSuite(ifstmt.suite(1));
						}
						Abstract_PythonExpr expr = (Abstract_PythonExpr) visitTest(ifstmt.test(0));
						stmts.add(new Abstract_PythonIfStmt(expr, if_stmts, else_stmts));
					} else {
						stmts.add(new Abstract_PythonStmt(stmt.getText()));
					}
				}
			}
		}
		return stmts;
	}
	
	private Abstract_PythonStmt atom_expr_to_Action(Python3Parser.Atom_exprContext ctx) {
		if (ctx.atom().getText().equals(agent_name)) {
			Python3Parser.TrailerContext trailer = ctx.trailer(0);
			String trailerstring = trailer.getText().substring(1);
			boolean first = true;
			for (Python3Parser.TrailerContext trail: ctx.trailer()) {
				if (!first) {
					String st = trail.getText();
					if (! st.equals("()")) {
						trailerstring = trailerstring + st;
					}
				} else {
					first = false;
				}
				
			}
			return new Abstract_PythonStmt(trailerstring);
		} else {
			String start = ctx.atom().getText();
			Python3Parser.TrailerContext trailer = ctx.trailer(0);
			String trailerstring = trailer.getText();
			boolean first = true;
			int trailer_num = 0;
			boolean add_belief = false;
			for (Python3Parser.TrailerContext trail: ctx.trailer()) {
				if (!first) {
					String st = trail.getText();
					if (st.equals(".add_belief")) {
						trailerstring = st;
						add_belief = true;
					} else if (! st.equals("()")) {
						trailerstring = trailerstring + st;
					}
				} else {
					first = false;
				}
				trailer_num++;
				
			}
			String expr = start + trailerstring;
			if (add_belief) {
				expr = trailerstring;
			}
			return new Abstract_PythonStmt(expr);
		}
		
	}
	
	private Python3Parser.Atom_exprContext atom_expr_from_simple_stmt(Python3Parser.Simple_stmtContext ctx) throws Exception {
		Python3Parser.Small_stmtContext small_stmt = ctx.small_stmt(0);
		Python3Parser.Expr_stmtContext expr_stmt = small_stmt.expr_stmt();
		if (expr_stmt != null) {
			List<Python3Parser.Testlist_star_exprContext> test_list_stars = expr_stmt.testlist_star_expr();
			if (test_list_stars.size() == 1) {
				Python3Parser.Testlist_star_exprContext test_list_star_expr = expr_stmt.testlist_star_expr(0);
				List<Python3Parser.TestContext> tests = test_list_star_expr.test();
				if (tests.size() == 1) {
					try {
						Python3Parser.Atom_exprContext atom_expr = extract_atom_expr_context(tests.get(0));
						return atom_expr;
					} catch (Exception e) {
						throw e;
					}
				}
			}
		}
		throw new Exception("Not an Atom_expr");
		
	}
	
	@Override public Object visitExpr_stmt(Python3Parser.Expr_stmtContext ctx) {
		List<Python3Parser.Testlist_star_exprContext> test_list_stars = ctx.testlist_star_expr();
		if (test_list_stars.size() == 2) {
			Python3Parser.Testlist_star_exprContext assigned = test_list_stars.get(1);
			if (assigned.test().size() == 1) {
				Python3Parser.TestContext value = assigned.test().get(0);
				try {
					Python3Parser.Atom_exprContext atom_expr = extract_atom_expr_context(value);
					List<Python3Parser.TrailerContext> trailers = atom_expr.trailer();
					for (int i = 0; i < trailers.size(); i++) {
						String s = trailers.get(i).getText();
						if (s.equals(".Agent")) {
							agent_name = test_list_stars.get(0).getText();
							agent.setName(agent_name);
						} else if (s.equals(".NaoAgent")) {
							agent_name = test_list_stars.get(0).getText();
							agent.setName(agent_name);
						}
					}
				} catch (Exception e) {
					
				}
			}
		}
		return visitChildren(ctx);
	}
	
	private Python3Parser.Atom_exprContext extract_atom_expr_context(Python3Parser.TestContext ctx) throws Exception {
		Python3Parser.Or_testContext or_test = ctx.or_test(0);
		Python3Parser.And_testContext and_test = or_test.and_test(0);
		Python3Parser.Not_testContext not_test = and_test.not_test(0);
		if (not_test.comparison() != null) {
			Python3Parser.ComparisonContext comparison = not_test.comparison();
			Python3Parser.ExprContext expr = comparison.expr(0);
			Python3Parser.Xor_exprContext xor_expr = expr.xor_expr(0);
			Python3Parser.And_exprContext and_expr = xor_expr.and_expr(0);
			Python3Parser.Shift_exprContext shift_expr = and_expr.shift_expr(0);
			Python3Parser.Arith_exprContext arith_expr = shift_expr.arith_expr(0);
			Python3Parser.TermContext term = arith_expr.term(0);
			Python3Parser.FactorContext factor = term.factor(0);
			if (factor.power() != null) {
				Python3Parser.PowerContext power = factor.power();
				return power.atom_expr();
			}
		}
		
		throw new Exception("Not an Atom Expr");
	}
	
	@Override public Object visitAtom_expr(Python3Parser.Atom_exprContext ctx) { 
		List<Python3Parser.TrailerContext> trailers = ctx.trailer();
		for (int i = 0; i < trailers.size(); i++) {
			String s = trailers.get(i).getText();
			if (s.equals(".add_rule")) {
				String arglist = trailers.get(i+1).getText();
				agent.addRule(new Abstract_PBDIRule(arglist.substring(1, arglist.length() - 1)));
				return arglist.substring(1, arglist.length());
			} else if (s.equals(".add_condition_rule")) {
				Python3Parser.TrailerContext trailer = trailers.get(i+1);
				Python3Parser.ArglistContext arglist = trailer.arglist();
				List<Python3Parser.ArgumentContext> args = arglist.argument();
				String guard = args.get(0).getText();
				String rulename = args.get(1).getText();
				
				RuleConditionLexer rclexer = new RuleConditionLexer(CharStreams.fromString(guard));
				CommonTokenStream tokens = new CommonTokenStream(rclexer);
				RuleConditionParser rcparser = new RuleConditionParser(tokens);
				PBDIRuleConditionVisitor visitor = new PBDIRuleConditionVisitor();
				Abstract_Guard g = visitor.visitRule_condition(rcparser.rule_condition());
				
				Abstract_PBDIRule rule = new Abstract_PBDIRule(rulename);
				rule.addGuard(g);
				agent.addRule(rule);
				
				return rulename;
				
			} else if (s.equals(".add_pick_best_rule")) {
				Python3Parser.TrailerContext trailer = trailers.get(i+1);
				Python3Parser.ArglistContext arglist = trailer.arglist();
				List<Python3Parser.ArgumentContext> args = arglist.argument();
				String guard = args.get(0).getText();
				String compare_function_name = args.get(1).getText();
				String rulename = args.get(2).getText();
				
				RuleConditionLexer rclexer = new RuleConditionLexer(CharStreams.fromString(guard));
				CommonTokenStream tokens = new CommonTokenStream(rclexer);
				RuleConditionParser rcparser = new RuleConditionParser(tokens);
				PBDIRuleConditionVisitor visitor = new PBDIRuleConditionVisitor();
				Abstract_Guard g = visitor.visitRule_condition(rcparser.rule_condition());
				
				Abstract_PBDIBestRule rule = new Abstract_PBDIBestRule(rulename);
				rule.addGuard(g);
				rule.addCompare(compare_function_name);
				agent.addRule(rule);
				
				return rulename;
				
			} 
		}
		
		if (trailers.size() > 0) {
			if (trailers.get(trailers.size() - 1).NAME() != null) {
				return new Abstract_PythonAtomExpr(ctx.getText());
			} else {
				String s = ctx.atom().getText();
				// ArrayList<Object> args = new ArrayList<Object>();
				for (Python3Parser.TrailerContext trailer: trailers) {
					//if (trailer.arglist() != null) {
					//	args = (ArrayList<Object>) visitArglist(trailer.arglist());
					//} else if (trailer.NAME() != null) {
						s += trailer.getText();
					// }
				}
				return new Abstract_PythonAtomExpr(s);
				
			}
		}
		
		
		return visitChildren(ctx);
	}
	
	@Override public Object visitArglist(Python3Parser.ArglistContext ctx) {
		ArrayList<Object> args = new ArrayList<Object>();
		for (Python3Parser.ArgumentContext arg: ctx.argument()) {
			args.add(visitArgument(arg));
		}
		return args;
	}
	
	@Override public Object visitAtom(Python3Parser.AtomContext ctx) {
		if (ctx.NAME() != null) {
			return new Abstract_PythonAtomExpr(ctx.getText());
		} else if (ctx.testlist_comp() != null){
			return visitTestlist_comp(ctx.testlist_comp());
		} else if (ctx.STRING() != null) {
			return new Abstract_PythonAtomExpr(ctx.getText());
		}
		
		return super.visitAtom(ctx);
	}
	
	@Override public Object visitComparison(Python3Parser.ComparisonContext ctx) {
		if (ctx.comp_op() != null && ctx.comp_op().size() == 1) {
			Abstract_PythonExpr lhs = (Abstract_PythonExpr) visitExpr(ctx.expr(0));
			Abstract_PythonExpr rhs = (Abstract_PythonExpr) visitExpr(ctx.expr(1));
			int comp_op = (int) visitComp_op(ctx.comp_op(0));
			return new Abstract_PythonComparison(lhs, comp_op, rhs);
		}
		
		else return visitChildren(ctx);
	}
	
	@Override public Object visitAnd_test(Python3Parser.And_testContext ctx) {
		if (ctx.not_test().size() > 1) {
			boolean first = true;
			Abstract_PythonAndExpr and = new Abstract_PythonAndExpr((Abstract_PythonExpr) visitNot_test(ctx.not_test(0)));
			for (Python3Parser.Not_testContext not_ctx: ctx.not_test()) {
				if (first) {
					first = false;
				} else {
					and.addConjunct((Abstract_PythonExpr) visitNot_test(not_ctx));
				}
			}
			return and;
		} else 
			return super.visitAnd_test(ctx);
	}
	
	@Override public Object visitNot_test(Python3Parser.Not_testContext ctx) {
		if (ctx.not_test() != null) {
			Abstract_PythonNotExpr not = new Abstract_PythonNotExpr((Abstract_PythonExpr) visitNot_test(ctx.not_test()));
			return not;
		} else 
			return super.visitNot_test(ctx);
	}
	
	@Override public Object visitComp_op(Python3Parser.Comp_opContext ctx) {
		String s = ctx.getText();
		if (ctx.getText().equals("<")) {
			return Abstract_PythonComparison.less_than;
		} else if (ctx.getText().equals(">")) {
			return Abstract_PythonComparison.more_than;
		}
		
		return super.visitComp_op(ctx);
	}
	
}
