package goal.syntax.ast;

import goal.syntax.ModuleCallAction;
import gov.nasa.jpf.vm.MJIEnv;

import java.util.List;

import ail.syntax.ast.Abstract_Action;
import ail.syntax.ast.Abstract_Deed;
import ail.syntax.ast.Abstract_Predicate;

public class Abstract_ModuleCallAction extends Abstract_Action {
	
	Abstract_ActionRule[] rules = new Abstract_ActionRule[0];

	public Abstract_ModuleCallAction(List<Abstract_ActionRule> rules) {
		super("module_call");
		for (Abstract_ActionRule rule: rules) {
			addRule(rule);
		}
	}
	
	public Abstract_ModuleCallAction(Abstract_Predicate dp) {
		super(dp);
	}

	public void addRule(Abstract_ActionRule rule) {
		int newsize = rules.length + 1;
		Abstract_ActionRule[] newrules = new Abstract_ActionRule[newsize];
		for (int i = 0; i < rules.length; i++) {
			newrules[i] = rules[i];
		}
		newrules[rules.length] = rule;
		rules = newrules;

	}
	
	public ModuleCallAction toMCAPL() {
		ModuleCallAction mca = new ModuleCallAction(super.toMCAPL());
		for (Abstract_ActionRule rule: rules) {
			mca.addActionRule(rule.toMCAPL());
		}
		return mca;
	}
	
	public int newJPFObject(MJIEnv env) {
    	int objref = env.newObject("goal.syntax.ast.Abstract_ModeulCallAction");
    	super.JPFFields(objref, env);
		return objref;

	}
}
