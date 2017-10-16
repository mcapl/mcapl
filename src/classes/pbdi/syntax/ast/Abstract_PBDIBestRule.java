package pbdi.syntax.ast;

public class Abstract_PBDIBestRule extends Abstract_PBDIRule {
	String compare_function;
	
	public Abstract_PBDIBestRule(String rulename) {
		super(rulename);
	}

	public void addCompare(String compare_function_name) {
		this.compare_function = compare_function_name;
		
	}
}
