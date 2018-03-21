package hera.parser;

import hera.language.Add;
import hera.language.DB;
import hera.language.DR;
import hera.language.IntegerTerm;
import hera.language.Minus;
import hera.language.Sub;
import hera.language.Term;
import hera.language.U;
import hera.parser.HeraParser.TermContext;

public class HeraTermVisitor extends HeraBaseVisitor<Term> {
	HeraLanguageVisitor formula_visitor;
	
	public HeraTermVisitor(HeraLanguageVisitor formula_visitor) {
		this.formula_visitor = formula_visitor;
	}
	
	// term: uterm | drterm | dbterm | minusterm | subterm | addterm | intterm;
	@Override public Term visitTerm(TermContext ctx) {
		if (ctx.uterm() != null) {
			return visitUterm(ctx.uterm());
		}
		if (ctx.drterm() != null) {
			return visitDrterm(ctx.drterm());
		}
		if (ctx.dbterm()!= null) {
			return visitDbterm(ctx.dbterm());
		}
		if (ctx.minusterm() != null) {
			return visitMinusterm(ctx.minusterm());
		}
		if (ctx.addterm() != null) {
			return visitAddterm(ctx.addterm());
		}
		if (ctx.subterm() != null) {
			return visitSubterm(ctx.subterm());
		}
		
		return visitIntterm(ctx.intterm());
 	}
	
	@Override public Term visitUterm(HeraParser.UtermContext ctx) {
		HeraParser.FormulaContext fctx = ctx.formula();
		return new U(formula_visitor.visitFormula(fctx));
	}
	
	@Override public Term visitDrterm(HeraParser.DrtermContext ctx) {
		HeraParser.FormulaContext f1ctx = ctx.formula(0);
		HeraParser.FormulaContext f2ctx = ctx.formula(1);
		return new DR(formula_visitor.visitFormula(f1ctx), formula_visitor.visitFormula(f2ctx));
		
	}
	
	@Override public Term visitDbterm(HeraParser.DbtermContext ctx) {
		HeraParser.FormulaContext f1ctx = ctx.formula(0);
		HeraParser.FormulaContext f2ctx = ctx.formula(1);
		return new DB(formula_visitor.visitFormula(f1ctx), formula_visitor.visitFormula(f2ctx));
		
	}
	
	@Override public Term visitMinusterm(HeraParser.MinustermContext ctx) {
		HeraParser.TermContext tctx = ctx.term();
		return new Minus(visitTerm(tctx));
	}
	
	@Override public Term visitAddterm(HeraParser.AddtermContext ctx) {
		HeraParser.TermContext t1ctx = ctx.term(0);
		HeraParser.TermContext t2ctx = ctx.term(1);
		
		return new Add(visitTerm(t1ctx), visitTerm(t2ctx));
	}
	
	@Override public Term visitSubterm(HeraParser.SubtermContext ctx) {
		HeraParser.TermContext t1ctx = ctx.term(0);
		HeraParser.TermContext t2ctx = ctx.term(1);
		
		return new Sub(visitTerm(t1ctx), visitTerm(t2ctx));
	}
	
	@Override public Term visitIntterm(HeraParser.InttermContext ctx) {
		int i = Integer.parseInt(ctx.INT().getText());
		return new IntegerTerm(i);
	}
	


}
