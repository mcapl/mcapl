// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis, and Michael Fisher and 
// Rafael H. Bordini.
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
// License along with Gwendolen if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package actiononly.parser;

import java.util.ArrayList;
import java.util.HashMap;

import org.antlr.v4.runtime.misc.NotNull;

import ail.syntax.ast.Abstract_ArithExpr;
import ail.syntax.ast.Abstract_Equation;
import ail.syntax.ast.Abstract_Literal;
import ail.syntax.ast.Abstract_NumberTerm;
import ail.syntax.ast.Abstract_NumberTermImpl;
import ail.syntax.ast.Abstract_Pred;
import ail.syntax.ast.Abstract_Predicate;
import ail.syntax.ast.Abstract_StringTermImpl;
import ail.syntax.ast.Abstract_Term;
import ail.syntax.ast.Abstract_VarTerm;

@SuppressWarnings("deprecation")
public class FOFVisitor extends LogicalFmlasBaseVisitor<Object> {
	private static HashMap<String,Abstract_VarTerm> variables = new HashMap<String,Abstract_VarTerm>();	
	/* literal returns [Abstract_Literal l]:  (TRUE {$l = new Abstract_Literal(Abstract_Literal.LTrue);} | 
			NOT nt=pred {
			if ($nt.t instanceof Abstract_VarTerm) 
				{$l = (Abstract_VarTerm) $nt.t; $l.setNegated(false);}
				else { $l = new Abstract_Literal(Abstract_Literal.LNeg, new Abstract_Pred($nt.t));}}) | 
			t=pred {if ($t.t instanceof Abstract_VarTerm) 
			            {$l = (Abstract_VarTerm) $t.t;} 
			            else {$l = new Abstract_Literal(Abstract_Literal.LPos, new Abstract_Pred($t.t));}}; */
	@Override public Object visitLiteral(@NotNull LogicalFmlasParser.LiteralContext ctx) {
		if (ctx.TRUE() != null) {
			return new Abstract_Literal(Abstract_Literal.LTrue);
		} else if (ctx.NOT() != null){
			Abstract_Predicate nt = (Abstract_Predicate) visitPred(ctx.pred());
			if (nt instanceof Abstract_VarTerm) {
				Abstract_VarTerm l = (Abstract_VarTerm) nt;
				l.setNegated(false);
				return l;
			} else {
				return new Abstract_Literal(Abstract_Literal.LNeg, new Abstract_Pred(nt));
			}
		} else {
			Abstract_Predicate t = (Abstract_Predicate) visitPred(ctx.pred());
			if (t instanceof Abstract_VarTerm) {
				return t;
			} else {
				return new Abstract_Literal(Abstract_Literal.LPos, new Abstract_Pred(t));
			}
		}
	}
	
	//pred 	returns [Abstract_Predicate t]:	v=var {$t = $v.v;}| f=function {$t = $f.f;};
	@Override public Object visitPred(@NotNull LogicalFmlasParser.PredContext ctx) {
		if (ctx.v != null) {
			return visitVar(ctx.v);
		} else {
			return visitFunction(ctx.f);
		}
	}

	//function returns [Abstract_Predicate f]: CONST {$f = new Abstract_Predicate($CONST.getText());} (OPEN terms[$f] CLOSE)?;
	@Override public Object visitFunction(@NotNull LogicalFmlasParser.FunctionContext ctx) {
		Abstract_Predicate f = new Abstract_Predicate(ctx.CONST().getText());
		if (ctx.terms() != null) {
			@SuppressWarnings("unchecked")
			ArrayList<Abstract_Term> visitTerms = (ArrayList<Abstract_Term>) visitTerms(ctx.terms());
			for (Abstract_Term t: visitTerms) {
				f.addTerm(t);
			}
		}
		return f;
	}

	// terms[Abstract_Predicate f] : t=term {$f.addTerm($t.t);} (COMMA terms[$f])? ;	            
	@SuppressWarnings("unchecked")
	@Override public Object visitTerms(@NotNull LogicalFmlasParser.TermsContext ctx) {
		ArrayList<Abstract_Term> terms = new ArrayList<Abstract_Term>();
		Abstract_Term t = (Abstract_Term) visitTerm(ctx.t);
		terms.add(t);
		if (ctx.terms() != null) {
			terms.addAll((ArrayList<Abstract_Term>) visitTerms(ctx.terms()));
		}
		return terms;
	}
	
	// term	returns [Abstract_Term t]:  a = atom {$t = $a.t;} | s = stringterm {$t = $s.s;} | f=function {$t = $f.f;};
	@Override public Object visitTerm(@NotNull LogicalFmlasParser.TermContext ctx) {
		if (ctx.a != null) {
			return visitAtom(ctx.a);
		} else if (ctx.s != null) {
			return visitStringterm(ctx.s);
		} else {
			return visitFunction(ctx.f);
		}
	}
	
	//atom	returns [Abstract_NumberTerm t]	:	n = numberstring {$t = new Abstract_NumberTermImpl($n.s);}| 
	//		v=var {$t = $v.v;} | OPEN a=arithexpr CLOSE; // {$t = $a.t;};
	@Override public Object visitAtom(@NotNull LogicalFmlasParser.AtomContext ctx) {
		if (ctx.n != null) {
			return new Abstract_NumberTermImpl((String) visitNumberstring(ctx.n));
		} else if (ctx.v != null) {
			return visitVar(ctx.v);
		} else {
			return visitArithexpr(ctx.a);
		}
	}
	
	// stringterm returns [Abstract_StringTerm s] : QUOTED_STRING ; //{		 
    //     $s = new Abstract_StringTermImpl($STRING.getText());};
	@Override public Object visitStringterm(@NotNull LogicalFmlasParser.StringtermContext ctx) {
		String s = ctx.QUOTED_STRING().toString();
		s.substring(1, s.length() - 1);
		return new Abstract_StringTermImpl(s);
	}
	
	/* var 	returns [Abstract_VarTerm v]:	VAR {
		if (variables.containsKey($VAR.getText())) {
			$v = variables.get($VAR.getText());
			} else {
			$v = new Abstract_VarTerm($VAR.getText());
			variables.put($VAR.getText(), $v);
			}
		}; */
	@Override public Object visitVar(@NotNull LogicalFmlasParser.VarContext ctx) {
		if (variables.containsKey(ctx.VAR().getText())) {
			return variables.get(ctx.VAR().getText());
		} else {
			Abstract_VarTerm v = new Abstract_VarTerm(ctx.VAR().getText());
			variables.put(ctx.VAR().getText(), v);
			return v;
		}
	}
	// numberstring returns [String s] :	{$s = "";} (MINUS {$s += "-";})? (n1=NUMBER {$s += $n1.getText();}
	// (POINT {$s += ".";} n2=NUMBER {$s += $n2.getText();})?);
	@Override public Object visitNumberstring(@NotNull LogicalFmlasParser.NumberstringContext ctx) {
		String s = "";
		if (ctx.MINUS() != null) {
			s += "-";
		}
		s += ctx.n1.getText();
		if (ctx.POINT() != null) {
			s += ".";
			s += ctx.n2.getText();
		}
		return s;
	}
	
    //equation returns[Abstract_Equation eq] : a1=arithexpr oper=eqoper a2=arithexpr; //  {$eq = new Abstract_Equation($a1.t, $oper.oper, $a2.t);};
	@Override public Object visitEquation(@NotNull LogicalFmlasParser.EquationContext ctx) {
		return new Abstract_Equation((Abstract_ArithExpr) visitArithexpr(ctx.a1), (int) visitEqoper(ctx.oper), (Abstract_ArithExpr) visitArithexpr(ctx.a2));
	}
	
	//eqoper returns [int oper] : LESS {$oper=Abstract_Equation.less;} | EQ {$oper=Abstract_Equation.equal;};
	@Override public Object visitEqoper(@NotNull LogicalFmlasParser.EqoperContext ctx) {
		if (ctx.LESS() != null) {
			return Abstract_Equation.less;
		} else {
			return Abstract_Equation.equal;
		}
	}
	
	@Override public Object visitAddoper(@NotNull LogicalFmlasParser.AddoperContext ctx) {
		if (ctx.PLUS() != null) {
			return Abstract_ArithExpr.plus;
		} else {
			return Abstract_ArithExpr.minus;
		}
	}
	
	@Override public Object visitMultoper(@NotNull LogicalFmlasParser.MultoperContext ctx) { 
		if (ctx.MULT() != null) {
			return Abstract_ArithExpr.times;
		} else if (ctx.DIV() != null) {
			return Abstract_ArithExpr.div;
		} else {
			return Abstract_ArithExpr.mod;
		}
	}

	
	// multexpr returns [Abstract_NumberTerm t]	:	a=atom {$t = $a.t;} (oper=multoper a1=atom {$t = new Abstract_ArithExpr($a.t, $oper.oper, $a1.t);})?; 
	@Override public Object visitMultexpr(@NotNull LogicalFmlasParser.MultexprContext ctx) {
		Abstract_NumberTerm a1 = (Abstract_NumberTerm) visitAtom(ctx.a1);
		int oper = (int) visitMultoper(ctx.multoper());
		Abstract_NumberTerm a2 = (Abstract_NumberTerm) visitAtom(ctx.a2);
		
		return new Abstract_ArithExpr(a1, oper, a2);
		
	}
	
	// arithexpr returns [Abstract_NumberTerm t]	:	m=multexpr {$t = $m.t;} ( oper=addoper m1=multexpr {$t = new Abstract_ArithExpr($m.t, $oper.oper, $m1.t);})?;

//	@Override public Object visitArithexpr(@NotNull LogicalFmlasParser.ArithexprContext ctx) {
//		
//	}

}
