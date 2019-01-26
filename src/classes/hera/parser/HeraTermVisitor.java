// ----------------------------------------------------------------------------
// Copyright (C) 2018 Louise A. Dennis, Felix Lindner, Martin Moze Bentzen, Michael Fisher
//
// This file is part of Juno
//
// Juno is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Juno is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

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

/**
 * Special parser for string represting Hera Terms.
 * @author louisedennis
 *
 */
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
