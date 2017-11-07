package pbdi.syntax.ast;

import java.util.List;

import ail.syntax.ast.Abstract_GBelief;
import ail.syntax.ast.Abstract_GLogicalFormula;
import ail.syntax.ast.Abstract_Literal;
import ail.syntax.ast.Abstract_Term;
import gov.nasa.jpf.vm.MJIEnv;

public class Abstract_PythonComparison implements Abstract_PythonExpr {
	Abstract_PythonExpr lhs;
	Abstract_PythonExpr rhs;
	int comp_op;
	
	public static int less_than = 0;
	public static int more_than = 1;
	
	public Abstract_PythonComparison(Abstract_PythonExpr lhs, int comp_op, Abstract_PythonExpr rhs) {
		this.lhs = lhs;
		this.comp_op = comp_op;
		this.rhs = rhs;
	}
	
	public Abstract_PythonExpr getLHS() {
		return lhs;
	}
	
	public Abstract_PythonExpr getRHS() {
		return rhs;
	}
	
	public int getOp() {
		return comp_op;
	}

	@Override
	public int newJPFObject(MJIEnv env) {
		int objref = env.newObject("pbdi.syntax.ast.Abstract_PythonComparison");
		env.setReferenceField(objref, "lhs", lhs.newJPFObject(env));
		env.setIntField(objref, "comp_op", comp_op);
		env.setReferenceField(objref, "rhs", rhs.newJPFObject(env));
		return objref;
	}
	
	@Override
	public Abstract_GLogicalFormula toGuard(List<Abstract_Term> args) {
		Abstract_Literal condition_lit = new Abstract_Literal(toString());
		condition_lit.addTerm(args.get(0));
		condition_lit.addTerm(args.get(1));
		Abstract_PythonCalculation condition_belief = new Abstract_PythonCalculation(condition_lit);
		return condition_belief;
	}
	
	@Override
	public String toString() {
		String s = lhs.toString();
		if (comp_op == less_than) {
			s += "LT";
		} else {
			s += "GT";
		}
		s += rhs.toString();
		return s;
	}


}
