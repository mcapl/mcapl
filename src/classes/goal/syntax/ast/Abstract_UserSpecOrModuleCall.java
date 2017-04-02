package goal.syntax.ast;

import gov.nasa.jpf.vm.MJIEnv;
import ail.syntax.ast.Abstract_Action;
import ail.syntax.ast.Abstract_Predicate;
import ail.syntax.ast.Abstract_Term;

public class Abstract_UserSpecOrModuleCall extends Abstract_Action {
	
	public Abstract_UserSpecOrModuleCall(Abstract_Predicate p) {
		super(p.getFunctor());
		for (Abstract_Term t: p.getTerms()) {
			super.addTerm(t);
		}
	}
	
	
	public int newJPFObject(MJIEnv env) {
		int objref = env.newObject("goal.syntax.ast.Abstract_UserSpecOrModuleCall");
		super.JPFFields(objref, env);
		return objref;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Abstract_Predicate) {
			Abstract_Predicate p = (Abstract_Predicate) o;
			if (getFunctor().equals(p.getFunctor())) {
				int size = getTerms().length;
				for (int i = 0; i < size; i++) {
					if (! getTerm(i).equals(p.getTerm(i))) {
						return false;
					}
				}
				return true;
			} else {
				return false;
			}
		} else {
			return super.equals(o);
		}

	} 
}
