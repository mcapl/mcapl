package goal.syntax;

import java.util.ArrayList;

import ail.syntax.Action;
import ail.syntax.Unifier;

public class ModuleCallAction extends Action {
	GOALModule module;
	
	public ModuleCallAction() {
		this(new Action("module_call"), GOALModule.ModuleType.ANONYMOUS);
	}

	public ModuleCallAction(Action name) {
		this(name, GOALModule.ModuleType.USERDEF);
	}
	
	public ModuleCallAction(Action  name, GOALModule.ModuleType type) {
		super(name);
		module = new GOALModule(type, name);
	}

	public ModuleCallAction(GOALModule mcapl) {
		super("module_call");
		module = mcapl;
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
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Action#clone()
	 */
	@Override
	public ModuleCallAction clone() {
		return new ModuleCallAction(module);
	}
}
