package goal.semantics.executorStages;

import goal.semantics.AbstractGoalStage;
import goal.semantics.GOALRC;
import goal.semantics.GOALRCStage;
import goal.semantics.operationalrules.ModuleInitialisation;
import goal.semantics.operationalrules.SelectRule;
import goal.semantics.operationalrules.UserSpecAction;
import goal.semantics.operationalrules.ModuleExit;

import java.util.Iterator;
import java.util.ArrayList;

import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import goal.syntax.GOALModule;
import goal.semantics.GOALAgent;

public class ModuleExecutorStage extends AbstractGoalStage {
	private final GOALModule module;
	private boolean first = true;
	private boolean exit = false;
	boolean selectedrules = false;
		
	private GOALRCStage nextStage;
	
	ModuleInitialisation init = new ModuleInitialisation();
	SelectRule ruleSelection = new SelectRule();
	UserSpecAction userspec= new UserSpecAction(this);
	ModuleExit exitModule = new ModuleExit();
	
	boolean performedAnAction = false;
		
	public ModuleExecutorStage(GOALModule m) {
		module = m;
		ruleSelection.setRules(m.getRules());
	}

	@Override
	public String getStageName() {
		return "Module Executor";
	}

	@Override
	public Iterator<OSRule> getStageRules() {
		ArrayList<OSRule> rules = new ArrayList<OSRule>();
		if (first) {
			rules.add(init);
		} else if (!selectedrules & !exit) {
			rules.add(ruleSelection);
		} else if (selectedrules & !exit) {
			rules.add(userspec);
		} else {
			rules.add(exitModule);
		}
		// TODO Auto-generated method stub
		return rules.iterator();
	}

	@Override
	public void setRule(OSRule r) {
		// TODO Auto-generated method stub

	}

	@Override
	public void advance(AILAgent ag) {
		if (selectedrules) {
			exit = module.isModuleTerminated();
		
			switch (module.getExitCondition()) {
				case NOGOALS:
					exit |= ((GOALAgent) ag).getAttentionSet().isEmpty();
					break;
				case NOACTION:
					exit |= !performedAnAction;
				case ALWAYS:
					exit = true;
					break;
				default:
				case NEVER:
				// exit whenever module has been terminated (see above)
					break;
				}
					
				if (exit) {
					// If module termination flag has been set, reset it except when
					// this is an anonymous module. In that case, module termination
					// needs to be propagated to enclosing module(s).
					if (this.module.getType() != GOALModule.ModuleType.ANONYMOUS) {
						this.module.setModuleTerminated(false);
					}
				} 
		} else {
			if (!exit) {
				first = false;
				if (!selectedrules) {
					selectedrules = true;
					performedAnAction = false;
				}
			}
			
			if (exit) {
				first = true;
			}
		}
	}


	@Override
	public GOALRCStage getNextStage(GOALRC rc) {
		if (!selectedrules & !first & !exit) {
			if (module.getType() == GOALModule.ModuleType.MAIN) {
				rc.setStopandCheck(true);
			}
			if (!this.performedAnAction && rc.getAgent().isMainModuleRunning()) {
				//	nextStage = new startCycle(this, ag, this.hasPerformedAction());
				return rc.startCycle;
			} else {
				return this;
			}

		}
		// TODO Auto-generated method stub
		return null;
	}
	
	public void performedAnAction() {
		performedAnAction = true;
	}

}
