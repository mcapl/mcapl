package hera.parser;

import hera.language.DB;
import hera.language.DR;
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


}
