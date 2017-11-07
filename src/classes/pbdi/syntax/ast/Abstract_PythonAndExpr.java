package pbdi.syntax.ast;

import java.util.List;

import ail.syntax.ast.Abstract_GLogicalFormula;
import ail.syntax.ast.Abstract_Guard;
import ail.syntax.ast.Abstract_Term;
import gov.nasa.jpf.vm.MJIEnv;

public class Abstract_PythonAndExpr implements Abstract_PythonExpr {
	Abstract_PythonExpr[] conjuncts = new Abstract_PythonExpr[0];
	
	public Abstract_PythonAndExpr(Abstract_PythonExpr conjunct) {
		addConjunct(conjunct);
	}
	
	public void addConjunct(Abstract_PythonExpr conjunct) {
		int newsize = conjuncts.length + 1;
		Abstract_PythonExpr[] new_conjuncts = new Abstract_PythonExpr[newsize];
		for (int i = 0; i < conjuncts.length; i++ ) {
			new_conjuncts[i] = conjuncts[i];
		}
		new_conjuncts[conjuncts.length] = conjunct;
		conjuncts = new_conjuncts;
		
	}

	@Override
	public Abstract_GLogicalFormula toGuard(List<Abstract_Term> args) {
		Abstract_Guard g = new Abstract_Guard(Abstract_Guard.none, conjuncts[0].toGuard(args));
		for (int i = 1; i < conjuncts.length; i++) {
			g.add(conjuncts[i].toGuard(args), true);
		}
		return g;
	}

	@Override
	public int newJPFObject(MJIEnv env) {
		int objref = env.newObject("pbdi.syntax.ast.Abstract_PythonAndExpr");
    		int sRef = env.newObjectArray("pbdi.syntax.ast.Abstract_PythonExpr", conjuncts.length);
    		for (int i = 0; i < conjuncts.length; i++) {
    			env.setReferenceArrayElement(sRef, i, conjuncts[i].newJPFObject(env));
    		}
    
    		env.setReferenceField(objref, "conjuncts", sRef);
    		return objref;		// TODO Auto-generated method stub
	}

}
