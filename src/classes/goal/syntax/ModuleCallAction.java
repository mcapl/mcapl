package goal.syntax;

import java.util.ArrayList;

import ail.syntax.Action;
import ail.syntax.Unifier;

public class ModuleCallAction extends Action {
	GOALModule module;
	
	public ModuleCallAction() {
		super("module_call");
		module = new GOALModule(GOALModule.ModuleType.ANONYMOUS);
	}

	public ModuleCallAction(Action name) {
		super(name);
		module = new GOALModule(GOALModule.ModuleType.USERDEF, name);
	}

	public void addActionRule(ActionRule r) {
		module.addActionRule(r);
	}

	public GOALModule getModule() {
		return module;
	}

	public Unifier getUnifier() {
		return new Unifier();
	}
}
