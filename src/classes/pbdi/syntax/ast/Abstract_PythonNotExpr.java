package pbdi.syntax.ast;

import java.util.List;

import ail.syntax.ast.Abstract_GLogicalFormula;
import ail.syntax.ast.Abstract_Guard;
import ail.syntax.ast.Abstract_Term;
import gov.nasa.jpf.vm.MJIEnv;

public class Abstract_PythonNotExpr implements Abstract_PythonExpr {
	Abstract_PythonExpr negated_expr;
	
	public Abstract_PythonNotExpr(Abstract_PythonExpr expr) {
		negated_expr = expr;
	}

	@Override
	public Abstract_GLogicalFormula toGuard(List<Abstract_Term> args) {
		Abstract_Guard g = new Abstract_Guard(Abstract_Guard.not, negated_expr.toGuard(args));
		return g;
	}

	@Override
	public int newJPFObject(MJIEnv env) {
		int objref = env.newObject("pbdi.syntax.ast.Abstract_PythonNotExpr");
		int expr_ref = negated_expr.newJPFObject(env);
		env.setReferenceField(objref, "negated_expr", expr_ref);
		// TODO Auto-generated method stub
		return objref;
	}

}
