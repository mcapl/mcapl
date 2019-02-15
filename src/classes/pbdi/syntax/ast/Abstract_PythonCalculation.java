package pbdi.syntax.ast;

import ail.syntax.LogicalFormula;
import ail.syntax.ast.Abstract_GuardAtom;
import ail.syntax.ast.Abstract_Literal;
import gov.nasa.jpf.vm.MJIEnv;
import pbdi.syntax.PythonCalculation;

public class Abstract_PythonCalculation extends Abstract_Literal implements Abstract_GuardAtom {
	
	public Abstract_PythonCalculation(Abstract_Literal l) {
		super(l);
	}

	@Override
	public PythonCalculation toMCAPL() {
		// TODO Auto-generated method stub
		return new PythonCalculation(super.toMCAPL());
	}

	@Override
	public boolean isTrivial() {
		// TODO Auto-generated method stub
		return false;
	}
	
    public int newJPFObject(MJIEnv env) {
    		int ref = env.newObject("pbdi.syntax.ast.Abstract_PythonCalculation");
		String functor = getFunctor();
		if (strings.containsKey(functor)) {
			env.setReferenceField(ref, "functor", strings.get(functor));
		} else {
			int stringref = env.newString(functor);
			strings.put(functor, stringref);
			env.setReferenceField(ref, "functor", stringref);
		}
		env.setReferenceField(ref, "terms", newJPFTermArray(env));
		env.setBooleanField(ref, "type", getType());
		return ref;
	
}


}
