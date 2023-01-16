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

package ail.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import ail.syntax.ast.Abstract_ArithExpr;
import ail.syntax.ast.Abstract_Equation;
import ail.syntax.ast.Abstract_ListTermImpl;
import ail.syntax.ast.Abstract_Literal;
import ail.syntax.ast.Abstract_LogExpr;
import ail.syntax.ast.Abstract_LogicalFormula;
import ail.syntax.ast.Abstract_NumberTerm;
import ail.syntax.ast.Abstract_NumberTermImpl;
import ail.syntax.ast.Abstract_Pred;
import ail.syntax.ast.Abstract_Predicate;
import ail.syntax.ast.Abstract_PrologCut;
import ail.syntax.ast.Abstract_Rule;
import ail.syntax.ast.Abstract_StringTermImpl;
import ail.syntax.ast.Abstract_Term;
import ail.syntax.ast.Abstract_UnnamedVar;
import ail.syntax.ast.Abstract_VarTerm;
import ajpf.psl.parser.LogicalFmlasBaseVisitor;
import ajpf.psl.parser.LogicalFmlasParser;

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
		} else if (ctx.l != null) {
			return visitListterm(ctx.l);
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
		} else if (ctx.s != null) { 
			return visitStringterm(ctx.s);
		} else {
			return visitArithexpr(ctx.a);
		}
	}
	
	// stringterm returns [Abstract_StringTerm s] : QUOTED_STRING ; //{		 
    //     $s = new Abstract_StringTermImpl($STRING.getText());};
	@Override public Object visitStringterm(@NotNull LogicalFmlasParser.StringtermContext ctx) {
		String s = ctx.QUOTED_STRING().toString();
		// Removing quotation marks...
		String s1 = s.substring(1, s.length() - 1);
		return new Abstract_StringTermImpl(s1);
	}
	
    
	/* listterm returns [Abstract_ListTerm l] : 
	 * {$l = new Abstract_ListTermImpl();} SQOPEN (hl=listheads {$l.addAll($hl.tl);} (BAR v=var {$l.addTail($v.v);})?)? SQCLOSE; 
	 */

	/* listheads returns [ArrayList<Abstract_Term> tl]: 
	 * t1 = term {$tl = new ArrayList<Abstract_Term>(); $tl.add($t1.t);} (COMMA tl2= term {$tl.add($tl2.t);})*;
	 */
	@Override public Object visitListterm(LogicalFmlasParser.ListtermContext ctx) {
		Abstract_ListTermImpl l = new Abstract_ListTermImpl();
		if (ctx.hl != null) {
			l.addAll((ArrayList<Abstract_Term>) visitListheads(ctx.hl));
			if (ctx.BAR() != null) {
				l.addTail((Abstract_VarTerm) visitVar(ctx.v));
			}
		}
		
		return l;
	}
	
	@Override public Object visitListheads(LogicalFmlasParser.ListheadsContext ctx) {
		ArrayList<Abstract_Term> tl = new ArrayList<Abstract_Term>();
		// tl.add((Abstract_Term) visitTerm(ctx.t1));
		List<LogicalFmlasParser.TermContext> tl2s = ctx.term();
		for (LogicalFmlasParser.TermContext tl2: tl2s) {
			tl.add((Abstract_Term) visitTerm(tl2));
		}
		
		return tl;
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
		if (ctx.VAR() != null) {
			if (variables.containsKey(ctx.VAR().getText())) {
				return variables.get(ctx.VAR().getText());
			} else {
				Abstract_VarTerm v = new Abstract_VarTerm(ctx.VAR().getText());
				variables.put(ctx.VAR().getText(), v);
				return v;
			}
		} else {
			return new Abstract_UnnamedVar(); 
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
		return new Abstract_Equation((Abstract_NumberTerm) visitArithexpr(ctx.a1), (int) visitEqoper(ctx.oper), (Abstract_NumberTerm) visitArithexpr(ctx.a2));
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
		int oper = 0;
		Abstract_NumberTerm a2 = null;
		if (ctx.multoper() != null) {
			oper = (int) visitMultoper(ctx.multoper());
			a2 = (Abstract_NumberTerm) visitAtom(ctx.a2);
			return new Abstract_ArithExpr(a1, oper, a2);
		}
			
		return a1; 
	 
		
	}
	
	// arithexpr returns [Abstract_NumberTerm t]	:	m=multexpr {$t = $m.t;} ( oper=addoper m1=multexpr {$t = new Abstract_ArithExpr($m.t, $oper.oper, $m1.t);})?;
	@Override public Object visitArithexpr(@NotNull LogicalFmlasParser.ArithexprContext ctx) {
		Abstract_NumberTerm m1 = (Abstract_NumberTerm) visitMultexpr(ctx.m1);
		int oper = 0;
		Abstract_NumberTerm m2 = null;
		if (ctx.addoper() != null) {
			oper = (int) visitAddoper(ctx.addoper());
			m2 = (Abstract_NumberTerm) visitMultexpr(ctx.m2);
			return new Abstract_ArithExpr(m1, oper, m2);
		}
		return m1;
	}
	
	@Override public Object visitLitlist(@NotNull LogicalFmlasParser.LitlistContext ctx) {
		ArrayList<Abstract_Literal> lits = new ArrayList<Abstract_Literal>();
		lits.add((Abstract_Literal) visitLiteral(ctx.literal()));
		if (ctx.litlist() != null) {
			lits.addAll((ArrayList<Abstract_Literal>) visitLitlist(ctx.litlist()));
		}
		return lits;
		
	}
	
	@Override public Object visitLitlist_poss_empty(@NotNull LogicalFmlasParser.Litlist_poss_emptyContext ctx) { 
		if (ctx.litlist() != null) {
			return visitLitlist(ctx.litlist());
		} else {
			return new ArrayList<Abstract_Literal>();
		}
	}
	
	@Override public Object visitRulelist(@NotNull LogicalFmlasParser.RulelistContext ctx) {
		ArrayList<Abstract_Rule> rules = new ArrayList<Abstract_Rule>();
		rules.add((Abstract_Rule) visitProlog_rule(ctx.prolog_rule()));
		if (ctx.rulelist() != null) {
			rules.addAll((ArrayList<Abstract_Rule>) visitRulelist(ctx.rulelist()));
		}
		return rules;
		
	}
	
	@Override public Object visitRulelist_poss_empty(@NotNull LogicalFmlasParser.Rulelist_poss_emptyContext ctx) { 
		if (ctx.rulelist() != null) {
			return visitRulelist(ctx.rulelist());
		} else {
			return new ArrayList<Abstract_Rule>();
		}
	}

	
	//prolog_rule returns [Abstract_Rule r] : head=pred (RULEARROW f=logicalfmla {$r = new Abstract_Rule(head, $f.f);} SEMI | SEMI {$r = new Abstract_Rule(head);});
	@Override public Object visitProlog_rule(@NotNull LogicalFmlasParser.Prolog_ruleContext ctx) {
		Abstract_Predicate head = (Abstract_Predicate) visitPred(ctx.head);
		if (ctx.RULEARROW()!= null) {
			Abstract_LogicalFormula f = (Abstract_LogicalFormula) visitLogicalfmla(ctx.logicalfmla());
			return new Abstract_Rule(head, f);
		} else {
			return new Abstract_Rule(head);
		}
	}
	
	//logicalfmla returns [Abstract_LogicalFormula f] : n=notfmla {$f = $n.f;}
	//               (COMMA n2=notfmla {$f = new Abstract_LogExpr($f, Abstract_LogExpr.and, $n2.f);})*?;
	               // | and=subfmla {$f = new Abstract_LogExpr($n.f, Abstract_LogExpr.and, $and.f);}))?; 
	@Override public Object visitLogicalfmla(@NotNull LogicalFmlasParser.LogicalfmlaContext ctx) {
		// Abstract_LogicalFormula f = (Abstract_LogicalFormula) visitNotfmla(ctx.n);
		List<LogicalFmlasParser.NotfmlaContext> subfmlas = ctx.notfmla();
		Abstract_LogicalFormula f = null;
		for (LogicalFmlasParser.NotfmlaContext n:subfmlas) {
			Abstract_LogicalFormula f2 = (Abstract_LogicalFormula) visitNotfmla(n);
			if (f == null) {
				f = f2;
			} else {
				f = new Abstract_LogExpr(f, Abstract_LogExpr.and, f2);
			}
		}
		return f;
	}

	//	notfmla returns [Abstract_LogicalFormula f] : (gb = pred {$f = gb;} | SQOPEN eq = equation {$f = eq;} SQCLOSE) | 
//	                                   NOT (gb2 = pred {$f = new Abstract_LogExpr(Abstract_LogExpr.not, gb2);} | 
//	                                              SQOPEN eq = equation SQCLOSE {$f = new Abstract_LogExpr(Abstract_LogExpr.not, eq);} |
//	                                          lf = subfmla {$f = new Abstract_LogExpr(Abstract_LogExpr.not, $lf.f);});
	@Override public Object visitNotfmla(@NotNull LogicalFmlasParser.NotfmlaContext ctx) {
		if (ctx.gb != null) {
			return (Abstract_LogicalFormula) visitPred(ctx.gb);
		}
		
		if (ctx.eq != null) {
			return (Abstract_LogicalFormula) visitEquation(ctx.eq);
		}
		
		if (ctx.gb2 != null) {
			return new Abstract_LogExpr(Abstract_LogExpr.not, (Abstract_LogicalFormula) visitPred(ctx.gb2));
		}
		
		if (ctx.eq2 != null) {
			return new Abstract_LogExpr(Abstract_LogExpr.not, (Abstract_LogicalFormula) visitEquation(ctx.eq2));
		}
		
		if (ctx.cut != null) {
			return new Abstract_PrologCut();
		}
		
		return new Abstract_LogExpr(Abstract_LogExpr.not, (Abstract_LogicalFormula) visitSubfmla(ctx.lf));
		
	}
	
	//	subfmla returns [Abstract_LogicalFormula f] : OPEN lf = logicalfmla {$f = $lf.f;} CLOSE;
	@Override public Object visitSubfmla(@NotNull LogicalFmlasParser.SubfmlaContext ctx) {
		return visitLogicalfmla(ctx.lf);
	}



}
