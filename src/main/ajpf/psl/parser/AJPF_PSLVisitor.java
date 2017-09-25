// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of Agent JPF (AJPF)
// 
// AJPF is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// AJPF is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with AJPF; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ajpf.psl.parser;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import ajpf.psl.ast.Abstract_AgBelief;
import ajpf.psl.ast.Abstract_AgGoal;
import ajpf.psl.ast.Abstract_AgIntendToDo;
import ajpf.psl.ast.Abstract_AgIntention;
import ajpf.psl.ast.Abstract_Always;
import ajpf.psl.ast.Abstract_And;
import ajpf.psl.ast.Abstract_FalseProp;
import ajpf.psl.ast.Abstract_Finally;
import ajpf.psl.ast.Abstract_LastAction;
import ajpf.psl.ast.Abstract_MCAPLPredicate;
import ajpf.psl.ast.Abstract_Not;
import ajpf.psl.ast.Abstract_Or;
import ajpf.psl.ast.Abstract_Percept;
import ajpf.psl.ast.Abstract_Property;
import ajpf.psl.ast.Abstract_Release;
import ajpf.psl.ast.Abstract_TrueProp;
import ajpf.psl.ast.Abstract_Until;

public class AJPF_PSLVisitor extends A_PSLBaseVisitor<Abstract_Property> {
	
	// spec returns [Abstract_Property p1] : p = property {$p1 = $p.p1;};
	@Override public Abstract_Property visitSpec(A_PSLParser.SpecContext ctx) { 
		return visitProperty(ctx.property()); 
	}
	
	// property returns [Abstract_Property p1] : p=untilproperty {$p1 = $p.p;};
	@Override public Abstract_Property visitProperty(A_PSLParser.PropertyContext ctx) {
		return visitUntilproperty(ctx.untilproperty());
	}

    // untilproperty returns [Abstract_Property p] :
	//rp = releaseproperty {Abstract_Property prop = $rp.p;} (UNTIL a = releaseproperty {prop = new Abstract_Until(prop, $a.p);})* 
	//{$p = prop;};
	@Override public Abstract_Property visitUntilproperty(A_PSLParser.UntilpropertyContext ctx) {
		Abstract_Property prop = visitReleaseproperty(ctx.releaseproperty(0));
		boolean first = true;
		for (A_PSLParser.ReleasepropertyContext r_ctx: ctx.releaseproperty()) {
			if (!first) {
				prop = new Abstract_Until(prop, visitReleaseproperty(r_ctx));
			} else {
				first =false;
			}
		}
		return prop;
	}
	
	// releaseproperty returns [Abstract_Property p] :
	// ip = impproperty {Abstract_Property prop = $ip.p;} (RELEASE a = impproperty {prop = new Abstract_Release(prop, $a.p);})* 
	// {$p = prop;};
	@Override public Abstract_Property visitReleaseproperty(A_PSLParser.ReleasepropertyContext ctx) {
		Abstract_Property prop = visitImpproperty(ctx.impproperty(0));
		boolean first = true;
		for (A_PSLParser.ImppropertyContext r_ctx: ctx.impproperty()) {
			if (!first) {
				prop = new Abstract_Release(prop, visitImpproperty(r_ctx));
			} else {
				first =false;
			}
		}
		return prop;
	}
	
	// impproperty returns [Abstract_Property p] :
	// ap = andproperty {Abstract_Property prop = $ap.p;} 
	// (IMP a = andproperty {prop = new Abstract_Or(new Abstract_Not(prop), $a.p);})* {$p = prop;};
	@Override public Abstract_Property visitImpproperty(A_PSLParser.ImppropertyContext ctx) {
		Abstract_Property prop = visitAndproperty(ctx.andproperty(0));
		boolean first = true;
		for (A_PSLParser.AndpropertyContext r_ctx: ctx.andproperty()) {
			if (!first) {
				prop = new Abstract_Or(new Abstract_Not(prop), visitAndproperty(r_ctx));
			} else {
				first =false;
			}
		}
		return prop;
	}

	// andproperty returns [Abstract_Property p] :
	// at = orproperty {Abstract_Property prop = $at.p;} (AND a = orproperty {prop = new Abstract_And(prop, $a.p);})* {$p = prop;};
	@Override public Abstract_Property visitAndproperty(A_PSLParser.AndpropertyContext ctx) {
		Abstract_Property prop = visitOrproperty(ctx.orproperty(0));
		boolean first = true;
		for (A_PSLParser.OrpropertyContext r_ctx: ctx.orproperty()) {
			if (!first) {
				prop = new Abstract_And(prop, visitOrproperty(r_ctx));
			} else {
				first =false;
			}
		}
		return prop;
	}

	// orproperty returns [Abstract_Property p] :
	// at = alwaysproperty {Abstract_Property prop = $at.p;} 
	// (OR a = alwaysproperty {prop = new Abstract_Or(prop, $a.p);})* {$p = prop;};
	@Override public Abstract_Property visitOrproperty(A_PSLParser.OrpropertyContext ctx) {
		Abstract_Property prop = visitAlwaysproperty(ctx.alwaysproperty(0));
		boolean first = true;
		for (A_PSLParser.AlwayspropertyContext r_ctx: ctx.alwaysproperty()) {
			if (!first) {
				prop = new Abstract_Or(prop, visitAlwaysproperty(r_ctx));
			} else {
				first =false;
			}
		}
		return prop;
	}

	// alwaysproperty returns [Abstract_Property p] :
	// np = finallyproperty {$p = $np.p;} |
	// ALWAYS pl = finallyproperty {$p = new Abstract_Always($pl.p);};
	@Override public Abstract_Property visitAlwaysproperty(A_PSLParser.AlwayspropertyContext ctx) {
		if (ctx.ALWAYS() != null) {
			return new Abstract_Always(visitFinallyproperty(ctx.finallyproperty()));
		} else {
			return visitFinallyproperty(ctx.finallyproperty());
		}
	}


	// finallyproperty returns [Abstract_Property p] :
	// np = notproperty {$p = $np.p;} |
	// FINALLY pl = notproperty {$p = new Abstract_Finally($pl.p);};
	@Override public Abstract_Property visitFinallyproperty(A_PSLParser.FinallypropertyContext ctx) {
		if (ctx.FINALLY() != null) {
			return new Abstract_Finally(visitNotproperty(ctx.notproperty()));
		} else {
			return visitNotproperty(ctx.notproperty());
		}
	}


	// notproperty returns [Abstract_Property p] :
	// at = atom {$p = $at.p;}|
	// NOT p1 = atom {$p = new Abstract_Not($p1.p);};
	@Override public Abstract_Property visitNotproperty(A_PSLParser.NotpropertyContext ctx) {
		if (ctx.NOT() != null) {
			return new Abstract_Not(visitAtom(ctx.atom()));
		} else {
			return visitAtom(ctx.atom());
		}
	}
	
	
	// atom returns [Abstract_Property p] : 
	// prop = proposition {$p = $prop.p1;} |
	// OPENBRACKET tp = property {$p = $tp.p1;} CLOSEBRACKET;
	@Override public Abstract_Property visitAtom(A_PSLParser.AtomContext ctx) {
		if (ctx.OPEN() != null) {
			return visitProperty(ctx.property());
		} else {
			return visitProposition(ctx.proposition());
		}
	}
	
	//proposition returns [Abstract_Proposition p1] :
	// p2 = beliefproperty  {$p1 = (Abstract_Proposition) $p2.p;} |
	// p3 = goalproperty {$p1 = (Abstract_Proposition) $p3.p;} | p4 = falseprop {$p1 = (Abstract_Proposition) $p4.p;} | 
	// p5 = intentionproperty {$p1 = (Abstract_Proposition) $p5.p;} | p6 = lastactionproperty {$p1 = (Abstract_Proposition) $p6.p;} |
	// p7 = perceptproperty {$p1 = (Abstract_Proposition) $p7.p;} | 
	// p8 = intendtodoproperty {$p1 = (Abstract_Proposition) $p8.p;} |
	// p = trueprop {$p1 = (Abstract_Proposition) $p.p;};
	@Override public Abstract_Property visitProposition(A_PSLParser.PropositionContext ctx) {
		if (ctx.beliefproperty() != null) {
			return visitBeliefproperty(ctx.beliefproperty());
		} else if (ctx.goalproperty()!=null) {
			return visitGoalproperty(ctx.goalproperty());
		} else if (ctx.falseprop()!= null) {
			return visitFalseprop(ctx.falseprop());
		} else if (ctx.intentionproperty()!=null) {
			return visitIntentionproperty(ctx.intentionproperty());
		} else if (ctx.lastactionproperty()!=null) {
			return visitLastactionproperty(ctx.lastactionproperty());
		} else if (ctx.perceptproperty()!=null) {
			return visitPerceptproperty(ctx.perceptproperty());
		} else if (ctx.intendtodoproperty()!= null) {
			return visitIntendtodoproperty(ctx.intendtodoproperty());
		} else {
			return visitTrueprop(ctx.trueprop());
		}
	}
	
	// beliefproperty returns [Abstract_AgBelief p] :
	// BELIEVE OPENBRACKET ag=agentname COMMASEP f=formula CLOSEBRACKET {$p = new Abstract_AgBelief($ag.s, (Abstract_Formula) $f.f);};
	@Override public Abstract_Property visitBeliefproperty(A_PSLParser.BeliefpropertyContext ctx) {
		FOFVisitor fofvisitor = new FOFVisitor();
		A_PSLParser.Fof_exprContext fof_expr = ctx.fof_expr();
		LogicalFmlasParser fof_parser = fofparser(fof_expr.getText());
		
		Abstract_MCAPLPredicate p = (Abstract_MCAPLPredicate) fofvisitor.visitFunction(fof_parser.function());
		return new Abstract_AgBelief(ctx.agentname().getText(), p);
	}
	
	
	// goalproperty returns [Abstract_AgGoal p] :
	// GOAL OPENBRACKET ag=agentname COMMASEP f=formula CLOSEBRACKET {$p = new Abstract_AgGoal($ag.s, (Abstract_Formula) $f.f);};
	@Override public Abstract_Property visitGoalproperty(A_PSLParser.GoalpropertyContext ctx) {
		FOFVisitor fofvisitor = new FOFVisitor();
		A_PSLParser.Fof_exprContext fof_expr = ctx.fof_expr();
		LogicalFmlasParser fof_parser = fofparser(fof_expr.getText());
		
		Abstract_MCAPLPredicate p = (Abstract_MCAPLPredicate) fofvisitor.visitFunction(fof_parser.function());
		return new Abstract_AgGoal(ctx.agentname().getText(), p);
	}

	
	// falseprop returns [Abstract_FalseProp p] :
	// FALSE {$p = new Abstract_FalseProp();};
	@Override public Abstract_Property visitFalseprop(A_PSLParser.FalsepropContext ctx) {
		return new Abstract_FalseProp();
	}
	
	// intentionproperty returns [Abstract_AgIntention p] :
	// INTENTION OPENBRACKET ag=agentname COMMASEP f=formula CLOSEBRACKET {$p = new Abstract_AgIntention($ag.s, (Abstract_Formula) $f.f);};
	@Override public Abstract_Property visitIntentionproperty(A_PSLParser.IntentionpropertyContext ctx) {
		FOFVisitor fofvisitor = new FOFVisitor();
		A_PSLParser.Fof_exprContext fof_expr = ctx.fof_expr();
		LogicalFmlasParser fof_parser = fofparser(fof_expr.getText());
		
		Abstract_MCAPLPredicate p = (Abstract_MCAPLPredicate) fofvisitor.visitFunction(fof_parser.function());
		return new Abstract_AgIntention(ctx.agentname().getText(), p);
	}

	
	// lastactionproperty returns [Abstract_LastAction p] :
	// ACTION OPENBRACKET ag=agentname COMMASEP f=formula CLOSEBRACKET {$p = new Abstract_LastAction($ag.s, (Abstract_Formula) $f.f);};
	@Override public Abstract_Property visitLastactionproperty(A_PSLParser.LastactionpropertyContext ctx) {
		FOFVisitor fofvisitor = new FOFVisitor();
		A_PSLParser.Fof_exprContext fof_expr = ctx.fof_expr();
		LogicalFmlasParser fof_parser = fofparser(fof_expr.getText());
		
		Abstract_MCAPLPredicate p = (Abstract_MCAPLPredicate) fofvisitor.visitFunction(fof_parser.function());
		return new Abstract_LastAction(ctx.agentname().getText(), p);
	}	
	
	// perceptproperty returns [Abstract_Percept p] :
	// PERCEPT OPENBRACKET f = formula CLOSEBRACKET {$p = new Abstract_Percept((Abstract_Formula) $f.f);};
	@Override public Abstract_Property visitPerceptproperty(A_PSLParser.PerceptpropertyContext ctx) {
		FOFVisitor fofvisitor = new FOFVisitor();
		A_PSLParser.Fof_exprContext fof_expr = ctx.fof_expr();
		LogicalFmlasParser fof_parser = fofparser(fof_expr.getText());
		
		Abstract_MCAPLPredicate p = (Abstract_MCAPLPredicate) fofvisitor.visitFunction(fof_parser.function());
		return new Abstract_Percept(p);
	}

	
	// intendtodoproperty returns [Abstract_AgIntendToDo p]:
	// INTENDTODO OPENBRACKET ag=agentname COMMASEP f = formula CLOSEBRACKET {$p = new Abstract_AgIntendToDo($ag.s, (Abstract_Formula) $f.f);};
	@Override public Abstract_Property visitIntendtodoproperty(A_PSLParser.IntendtodopropertyContext ctx) {
		FOFVisitor fofvisitor = new FOFVisitor();
		A_PSLParser.Fof_exprContext fof_expr = ctx.fof_expr();
		LogicalFmlasParser fof_parser = fofparser(fof_expr.getText());
		
		Abstract_MCAPLPredicate p = (Abstract_MCAPLPredicate) fofvisitor.visitFunction(fof_parser.function());
		return new Abstract_AgIntendToDo(ctx.agentname().getText(), p);
	}

	// trueprop returns [Abstract_TrueProp p] :
	// TRUE {$p = new Abstract_TrueProp();};	
	@Override public Abstract_Property visitTrueprop(A_PSLParser.TruepropContext ctx) {
		return new Abstract_TrueProp();
	}
	
	private LogicalFmlasParser fofparser(String s) {
		LogicalFmlasLexer lexer = new LogicalFmlasLexer(CharStreams.fromString(s));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		LogicalFmlasParser parser = new LogicalFmlasParser(tokens);
		return parser;
	}

}
