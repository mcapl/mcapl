package goal.syntax.ast;

import ail.syntax.Predicate;
import ail.syntax.ast.Abstract_Predicate;
import gov.nasa.jpf.vm.MJIEnv;

public class Abstract_ModuleDef {
	Abstract_Predicate name;
	int type = 100;
	
	public Abstract_ModuleDef(Abstract_Predicate p) {
		name = p;
	}
	
	public Abstract_ModuleDef(int i) {
		type = i;
	}

	public int newJPFObject(MJIEnv env) {
		int objref = env.newObject("goal.syntax.ast.Abstract_ModuleDef");
		if (name != null) {
			int nameref = name.newJPFObject(env);
			env.setReferenceField(objref, "name", nameref);
		}
		env.setIntField(objref, "type", type);
		return objref;
	}
	
	public boolean hasName() {
		return (name != null);
	}
	
	public Abstract_Predicate getName() {
		return name;
	}
}
