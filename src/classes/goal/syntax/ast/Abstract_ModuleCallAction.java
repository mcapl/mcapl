package goal.syntax.ast;

import goal.syntax.GOALModule;
import goal.syntax.ModuleCallAction;
import gov.nasa.jpf.vm.MJIEnv;

import java.util.List;

import ail.syntax.ast.Abstract_Action;
import ail.syntax.ast.Abstract_Deed;
import ail.syntax.ast.Abstract_Guard;
import ail.syntax.ast.Abstract_Predicate;
import ail.syntax.ast.Abstract_VarTerm;

public class Abstract_ModuleCallAction extends Abstract_Action {
	
	Abstract_ActionRule[] rules = new Abstract_ActionRule[0];
	Abstract_GOALModule module;

	public Abstract_ModuleCallAction(Abstract_Guard context, List<Abstract_ActionRule> rules) {
		super("module_call");
		for (String s: context.toMCAPL().getVarNames()) {
			this.addTerm(new Abstract_VarTerm(s));
		}
		for (Abstract_ActionRule rule: rules) {
			addRule(rule);
		}
	}
	
	public Abstract_ModuleCallAction(Abstract_Predicate dp) {
		super(dp);
	}

	public Abstract_ModuleCallAction(Abstract_GOALModule abstract_GOALModule) {
		super("module_call");
		module = abstract_GOALModule;
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
		if (module == null) {
			ModuleCallAction mca;
			if (this.getFunctor().equals("module_call")) {
				mca = new ModuleCallAction(super.toMCAPL(), GOALModule.ModuleType.ANONYMOUS);
			} else {
				mca = new ModuleCallAction(super.toMCAPL(), GOALModule.ModuleType.USERDEF);
			}
			for (Abstract_ActionRule rule: rules) {
				mca.addActionRule(rule.toMCAPL());
			}
			return mca;
		} else {
			return new ModuleCallAction(module.toMCAPL());
		}
	}
	
	public int newJPFObject(MJIEnv env) {
    	int objref = env.newObject("goal.syntax.ast.Abstract_ModeulCallAction");
    	super.JPFFields(objref, env);
		return objref;

	}
}
