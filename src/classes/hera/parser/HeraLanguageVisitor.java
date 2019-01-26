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

import org.antlr.v4.runtime.misc.NotNull;

import hera.language.Affects;
import hera.language.AffectsNeg;
import hera.language.AffectsPos;
import hera.language.And;
import hera.language.Atom;
import hera.language.Causes;
import hera.language.Consequence;
import hera.language.Exists;
import hera.language.Explains;
import hera.language.Forall;
import hera.language.Formula;
import hera.language.FormulaString;
import hera.language.Geq;
import hera.language.Goal;
import hera.language.Gt;
import hera.language.I;
import hera.language.Impl;
import hera.language.Intervention;
import hera.language.K;
import hera.language.May;
import hera.language.Means;
import hera.language.Must;
import hera.language.Not;
import hera.language.Or;
import hera.language.PCauses;
import hera.language.SCauses;
import hera.language.Term;
import hera.parser.HeraParser.FormulaContext;
import hera.parser.HeraParser.TermContext;

public class HeraLanguageVisitor extends HeraBaseVisitor<Formula> {
	HeraTermVisitor termvisitor = new HeraTermVisitor(this);
	
	@Override public Formula visitPcausesfmla(@NotNull HeraParser.PcausesfmlaContext ctx) { 
		FormulaContext f1ctx = ctx.formula(0);
		FormulaContext f2ctx = ctx.formula(1);
		PCauses pcauses = new PCauses((Formula) visitFormula(f1ctx), (Formula) visitFormula(f2ctx));
		return pcauses; 
	}

	@Override public Formula visitInterventionfmla(@NotNull HeraParser.InterventionfmlaContext ctx) { 
		FormulaContext f1ctx = ctx.formula(0);
		FormulaContext f2ctx = ctx.formula(1);
		Intervention intervention = new Intervention((Formula) visitFormula(f1ctx), (Formula) visitFormula(f2ctx));
		return intervention; 
		
	}

	@Override public Formula visitConsequencefmla(@NotNull HeraParser.ConsequencefmlaContext ctx) { 
		FormulaContext f1ctx = ctx.formula();
		Consequence consequence = new Consequence((Formula) visitFormula(f1ctx));
		return consequence; 
	}

	@Override public Formula visitMayfmla(@NotNull HeraParser.MayfmlaContext ctx) { 
		FormulaContext f1ctx = ctx.formula();
		May may = new May((Formula) visitFormula(f1ctx));
		return may; 
	}

	@Override public Formula visitStringfmla(@NotNull HeraParser.StringfmlaContext ctx) { 
		String word = ctx.WORD().getText();
		return new FormulaString(word);
	}

	@Override public Formula visitIfmla(@NotNull HeraParser.IfmlaContext ctx) { 
		FormulaContext f1ctx = ctx.formula();
		I i = new I((Formula) visitFormula(f1ctx));
		return i; 
	}

	@Override public Formula visitExistsfmla(@NotNull HeraParser.ExistsfmlaContext ctx) { 
		FormulaContext f1ctx = ctx.formula(0);
		FormulaContext f2ctx = ctx.formula(1);
		Exists exists = new Exists((Formula) visitFormula(f1ctx), (Formula) visitFormula(f2ctx));
		return exists; 
	}

	@Override public Formula visitPreventsfmla(@NotNull HeraParser.PreventsfmlaContext ctx) { 
		FormulaContext f1ctx = ctx.formula(0);
		FormulaContext f2ctx = ctx.formula(1);
		Forall forall = new Forall((Formula) visitFormula(f1ctx), (Formula) visitFormula(f2ctx));
		return forall; 		
	}

	@Override public Formula visitGoalfmla(@NotNull HeraParser.GoalfmlaContext ctx) { 
		FormulaContext f1ctx = ctx.formula();
		Goal goal = new Goal((Formula) visitFormula(f1ctx));
		return goal; 
	}

	@Override public Formula visitScausesfmla(@NotNull HeraParser.ScausesfmlaContext ctx) { 
		FormulaContext f1ctx = ctx.formula(0);
		FormulaContext f2ctx = ctx.formula(1);
		SCauses scauses = new SCauses((Formula) visitFormula(f1ctx), (Formula) visitFormula(f2ctx));
		return scauses; 
	}

	@Override public Formula visitExplainsfmla(@NotNull HeraParser.ExplainsfmlaContext ctx) { 
		FormulaContext f1ctx = ctx.formula(0);
		FormulaContext f2ctx = ctx.formula(1);
		Explains explains = new Explains((Formula) visitFormula(f1ctx), (Formula) visitFormula(f2ctx));
		return explains; 
	}

	@Override public Formula visitNotfmla(@NotNull HeraParser.NotfmlaContext ctx) { 
		FormulaContext f1ctx = ctx.formula();
		Not not = new Not((Formula) visitFormula(f1ctx));
		return not; 
	}

	@Override public Formula visitForallfmla(@NotNull HeraParser.ForallfmlaContext ctx) { 
		FormulaContext f1ctx = ctx.formula(0);
		FormulaContext f2ctx = ctx.formula(1);
		Forall forall = new Forall((Formula) visitFormula(f1ctx), (Formula) visitFormula(f2ctx));
		return forall; 
	}

	@Override public Formula visitAffectsposfmla(@NotNull HeraParser.AffectsposfmlaContext ctx) { 
		FormulaContext f1ctx = ctx.formula(0);
		FormulaContext f2ctx = ctx.formula(1);
		AffectsPos affectspos = new AffectsPos((Formula) visitFormula(f1ctx), (Formula) visitFormula(f2ctx));
		return affectspos; 
	}

	@Override public Formula visitGeqfmla(@NotNull HeraParser.GeqfmlaContext ctx) { 
		TermContext t1ctx = ctx.term(0);
		TermContext t2ctx = ctx.term(1);
		Geq geq = new Geq((Term) termvisitor.visitTerm(t1ctx), (Term) termvisitor.visitTerm(t2ctx));
		return geq;
	}

	@Override public Formula visitMustfmla(@NotNull HeraParser.MustfmlaContext ctx) { 
		FormulaContext f1ctx = ctx.formula();
		Must must = new Must((Formula) visitFormula(f1ctx));
		return must; 
	}

	@Override public Formula visitCausesfmla(@NotNull HeraParser.CausesfmlaContext ctx) { 
		FormulaContext f1ctx = ctx.formula(0);
		FormulaContext f2ctx = ctx.formula(1);
		Causes causes = new Causes((Formula) visitFormula(f1ctx), (Formula) visitFormula(f2ctx));
		return causes; 
	}

	@Override public Formula visitAndfmla(@NotNull HeraParser.AndfmlaContext ctx) { 
		FormulaContext f1ctx = ctx.formula(0);
		FormulaContext f2ctx = ctx.formula(1);
		And causes = new And((Formula) visitFormula(f1ctx), (Formula) visitFormula(f2ctx));
		return causes; 
	}

	@Override public Formula visitAtomfmla(@NotNull HeraParser.AtomfmlaContext ctx) { 
		FormulaContext f1ctx = ctx.formula();
		Atom atom = new Atom((Formula) visitFormula(f1ctx));
		return atom; 
	}

	@Override public Formula visitKfmla(@NotNull HeraParser.KfmlaContext ctx) { 
		FormulaContext f1ctx = ctx.formula();
		K k = new K((Formula) visitFormula(f1ctx));
		return k; 		
	}

	@Override public Formula visitFormula(@NotNull HeraParser.FormulaContext ctx) { 
		if (ctx.affectsfmla() != null) {
			return visitAffectsfmla(ctx.affectsfmla());
		} else if (ctx.affectsnegfmla() != null) {
			return visitAffectsnegfmla(ctx.affectsnegfmla());
		} else if (ctx.affectsposfmla() != null) {
			return visitAffectsposfmla(ctx.affectsposfmla());
		} else if (ctx.andfmla() != null) {
			return visitAndfmla(ctx.andfmla());
		} else if (ctx.atomfmla() != null) {
			return visitAtomfmla(ctx.atomfmla());
		} else if (ctx.orfmla() != null) {
			return visitOrfmla(ctx.orfmla());
		} else if (ctx.implfmla() != null) {
			return visitImplfmla(ctx.implfmla());
		} else if (ctx.notfmla() != null) {
			return visitNotfmla(ctx.notfmla());
		} else if (ctx.causesfmla() != null) {
			return visitCausesfmla(ctx.causesfmla());
		} else if (ctx.pcausesfmla() != null) {
			return visitPcausesfmla(ctx.pcausesfmla());
		} else if (ctx.scausesfmla() != null) {
			return visitScausesfmla(ctx.scausesfmla());
		} else if (ctx.existsfmla() != null) {
			return visitExistsfmla(ctx.existsfmla());
		} else if (ctx.forallfmla() != null) {
			return visitForallfmla(ctx.forallfmla());
		} else if (ctx.mustfmla() != null) {
			return visitMustfmla(ctx.mustfmla());
		} else if (ctx.mayfmla() != null) {
			return visitMayfmla(ctx.mayfmla());
		} else if (ctx.geqfmla() != null) {
			return visitGeqfmla(ctx.geqfmla());
		} else if (ctx.gtfmla() != null) {
			return visitGtfmla(ctx.gtfmla());
		} else if (ctx.interventionfmla() != null) {
			return visitInterventionfmla(ctx.interventionfmla());
		} else if (ctx.consequencefmla() != null) {
			return visitConsequencefmla(ctx.consequencefmla());
		} else if (ctx.preventsfmla() != null) {
			return visitPreventsfmla(ctx.preventsfmla());
		} else if (ctx.stringfmla() != null) {
			return visitStringfmla(ctx.stringfmla());
		} else if (ctx.explainsfmla() != null) {
			return visitExplainsfmla(ctx.explainsfmla());
		} else if (ctx.kfmla() != null) {
			return visitKfmla(ctx.kfmla());
		} else if (ctx.ifmla() != null) {
			return visitIfmla(ctx.ifmla());
		} else if (ctx.goalfmla() != null) {
			return visitGoalfmla(ctx.goalfmla());
		} else if (ctx.meansfmla() != null) {
			return visitMeansfmla(ctx.meansfmla());
		}
		return visitChildren(ctx); 
	}

	@Override public Formula visitMeansfmla(@NotNull HeraParser.MeansfmlaContext ctx) { 
		FormulaContext f1ctx = ctx.formula(0);
		FormulaContext f2ctx = ctx.formula(1);
		Means means = new Means((Formula) visitFormula(f1ctx), (Formula) visitFormula(f2ctx));
		return means; 
	}

	@Override public Formula visitGtfmla(@NotNull HeraParser.GtfmlaContext ctx) { 
		TermContext t1ctx = ctx.term(0);
		TermContext t2ctx = ctx.term(1);
		Gt gt = new Gt((Term) termvisitor.visitTerm(t1ctx), (Term) termvisitor.visitTerm(t2ctx));
		return gt;
	}

	@Override public Formula visitAffectsnegfmla(@NotNull HeraParser.AffectsnegfmlaContext ctx) { 
		FormulaContext f1ctx = ctx.formula(0);
		FormulaContext f2ctx = ctx.formula(1);
		AffectsNeg affectsneg = new AffectsNeg((Formula) visitFormula(f1ctx), (Formula) visitFormula(f2ctx));
		return affectsneg; 
	}

	@Override public Formula visitOrfmla(@NotNull HeraParser.OrfmlaContext ctx) { 
		FormulaContext f1ctx = ctx.formula(0);
		FormulaContext f2ctx = ctx.formula(1);
		Or or = new Or((Formula) visitFormula(f1ctx), (Formula) visitFormula(f2ctx));
		return or; 
	}

	@Override public Formula visitImplfmla(@NotNull HeraParser.ImplfmlaContext ctx) { 
		FormulaContext f1ctx = ctx.formula(0);
		FormulaContext f2ctx = ctx.formula(1);
		Impl impl = new Impl((Formula) visitFormula(f1ctx), (Formula) visitFormula(f2ctx));
		return impl; 
		}

	@Override public Formula visitAffectsfmla(@NotNull HeraParser.AffectsfmlaContext ctx) { 
		FormulaContext f1ctx = ctx.formula(0);
		FormulaContext f2ctx = ctx.formula(1);
		Affects affects = new Affects((Formula) visitFormula(f1ctx), (Formula) visitFormula(f2ctx));
		return affects; 		 
	}

}
