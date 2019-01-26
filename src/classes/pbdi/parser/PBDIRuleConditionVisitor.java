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

import org.antlr.v4.runtime.misc.NotNull;

import ail.syntax.ast.Abstract_GBelief;
import ail.syntax.ast.Abstract_Guard;
import ail.syntax.ast.Abstract_GuardAtom;
import ail.syntax.ast.Abstract_Literal;

@SuppressWarnings("deprecation")
public class PBDIRuleConditionVisitor extends RuleConditionBaseVisitor<Abstract_Guard> {
	
	@Override public Abstract_Guard visitAnd_expr(RuleConditionParser.And_exprContext ctx) {
		if (ctx.AND() != null) {
			Abstract_Guard lhs = visitRule_condition(ctx.rule_condition(0));
			Abstract_Guard rhs = visitRule_condition(ctx.rule_condition(1));
			return new Abstract_Guard(lhs, Abstract_Guard.and, rhs);
		} else {
			return visitNot_expr(ctx.not_expr());
		}
	}
	
	@Override public Abstract_Guard visitNot_expr(RuleConditionParser.Not_exprContext ctx) {
		if (ctx.NOT() != null) {
			Abstract_Guard expr = visitRule_condition(ctx.rule_condition());
			return new Abstract_Guard(Abstract_Guard.not, expr);
		} else {
			return visitBelief_expression(ctx.belief_expression());
		}
	}
	
	@Override public Abstract_Guard visitBelief_expression(@SuppressWarnings("deprecation") @NotNull RuleConditionParser.Belief_expressionContext ctx) {
		Abstract_GBelief gb = new Abstract_GBelief(new Abstract_Literal(ctx.WORD().getText()));
		return new Abstract_Guard(gb);
	}

}
