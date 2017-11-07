package pbdi.syntax.ast;

import gov.nasa.jpf.vm.MJIEnv;

public class Abstract_PBDIBestRule extends Abstract_PBDIRule {
	String compare_function;
	
	public Abstract_PBDIBestRule(String rulename) {
		super(rulename);
	}

	public void addCompare(String compare_function_name) {
		this.compare_function = compare_function_name;
		
	}
	
	public String getCompare() {
		return compare_function;
	}
	
    public int newJPFObject(MJIEnv env) {
    		int objref = env.newObject("pbdi.syntax.ast.Abstract_PBDIBestRule");
    		env.setReferenceField(objref, "rulename", env.newString(rulename));
    		if (guard != null) {
    			env.setReferenceField(objref, "guard", guard.newJPFObject(env));
    		}
    		env.setReferenceField(objref, "compare_function", env.newString(compare_function));
    		return objref;

    }

}
