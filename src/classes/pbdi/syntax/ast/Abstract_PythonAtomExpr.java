package pbdi.syntax.ast;

import java.util.List;

import ail.syntax.ast.Abstract_GLogicalFormula;
import ail.syntax.ast.Abstract_Literal;
import ail.syntax.ast.Abstract_Term;
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
	
	@Override
	public String toString() {
		return atom_expr;
	}

	@Override
	public Abstract_GLogicalFormula toGuard(List<Abstract_Term> args) {
		// TODO Auto-generated method stub
		String s1 = atom_expr.replace('(', '_');
		String s2 = s1.replace(')', '_');
		String s3 = s2.replace(',', '_');
		String s4 = s3.replaceAll("\'", "");
		Abstract_Literal lit = new Abstract_Literal(s4);
		lit.addTerm(args.get(0));
		lit.addTerm(args.get(1));
		
		return new Abstract_PythonCalculation(lit);
	}

}
