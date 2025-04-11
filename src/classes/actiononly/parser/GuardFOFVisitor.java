package actiononly.parser;

import org.antlr.v4.runtime.misc.NotNull;

import ail.parser.FOFVisitor;
import ail.syntax.ast.Abstract_Equation;
import ail.syntax.ast.Abstract_GBelief;
import ail.syntax.ast.Abstract_GLogicalFormula;
import ail.syntax.ast.Abstract_Guard;
import ail.syntax.ast.Abstract_Literal;
import ail.syntax.ast.Abstract_LogExpr;
import ail.syntax.ast.Abstract_LogicalFormula;
import ail.syntax.ast.Abstract_Pred;
import ajpf.psl.parser.LogicalFmlasParser;

public class GuardFOFVisitor extends FOFVisitor {
	/* 	
	clogicalfmla returns [Abstract_GLogicalFormula f] : n=cnotfmla {$f = $n.f;}
	               (COMMA n2=cnotfmla {$f = new Abstract_Guard($f, Abstract_Guard.and, $n2.f);})*?;
	cnotfmla returns [Abstract_GLogicalFormula f] : gb = pred {$f = new Abstract_GBelief(new Abstract_Literal(gb));} | 
	                                                                              NOT (gb2 = pred {$f = new Abstract_Guard(Abstract_Guard.not, new Abstract_GBelief(new Abstract_Literal(gb2)));} | 
	                                                                              lf = csubfmla {$f = new Abstract_Guard(Abstract_Guard.not, $lf.f);});
	csubfmla returns [Abstract_GLogicalFormula f] : OPEN lf = clogicalfmla {$f = $lf.f;} CLOSE; */
	@Override public Object visitLogicalfmla( LogicalFmlasParser.LogicalfmlaContext ctx) {
		Abstract_GLogicalFormula f = (Abstract_GLogicalFormula) visitNotfmla(ctx.n);
		if (ctx.n2 != null) {
			Abstract_GLogicalFormula f2 = (Abstract_GLogicalFormula) visitNotfmla(ctx.n2);
			return new Abstract_Guard(f, Abstract_Guard.and, f2);
		}
		return f;
	}

	@Override public Object visitNotfmla(LogicalFmlasParser.NotfmlaContext ctx) {
		if (ctx.gb != null) {
			return new Abstract_GBelief(new Abstract_Literal((Abstract_Pred) visitPred(ctx.gb)));
		}
		
		if (ctx.cut != null) {
			
		}
		
		if (ctx.eq != null) {
			return (Abstract_Equation) visitEquation(ctx.eq);
		}
		
		if (ctx.gb2 != null) {
			return new Abstract_Guard(Abstract_Guard.not, new Abstract_GBelief(new Abstract_Literal((Abstract_Pred) visitPred(ctx.gb2))));
		}
		
		if (ctx.eq2 != null) {
			return new Abstract_Guard(Abstract_Guard.not, (Abstract_Equation) visitEquation(ctx.eq2));
		}
		
		return new Abstract_Guard(Abstract_Guard.not, (Abstract_GLogicalFormula) visitSubfmla(ctx.lf));
		
	}
	
	//	subfmla returns [Abstract_LogicalFormula f] : OPEN lf = logicalfmla {$f = $lf.f;} CLOSE;
	@Override public Object visitSubfmla( LogicalFmlasParser.SubfmlaContext ctx) {
		return visitLogicalfmla(ctx.lf);
	}

}
