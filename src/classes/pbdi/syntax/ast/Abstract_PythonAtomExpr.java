package pbdi.syntax.ast;

import gov.nasa.jpf.vm.MJIEnv;

public class Abstract_PythonAtomExpr implements Abstract_PythonExpr {
	String atom_expr;
	
	public Abstract_PythonAtomExpr(String s) {
		atom_expr = s;
	}

	@Override
	public int newJPFObject(MJIEnv env) {
	    int objref = env.newObject("pbdi.syntax.ast.Abstract_PythonAtomExpr");
	    env.setReferenceField(objref, "atom_expr", env.newString(atom_expr));
	    return objref;
	}

}
