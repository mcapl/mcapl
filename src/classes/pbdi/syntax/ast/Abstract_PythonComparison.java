package pbdi.syntax.ast;

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

}
