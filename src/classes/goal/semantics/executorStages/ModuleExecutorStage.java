package goal.semantics.executorStages;

import goal.semantics.AbstractGoalStage;
import goal.semantics.GOALRC;
import goal.semantics.GOALRCStage;
import goal.semantics.operationalrules.ModuleInitialisation;
import goal.semantics.operationalrules.SelectRule;
import goal.semantics.operationalrules.UserSpecAction;
import goal.semantics.operationalrules.ModuleExit;
import goal.semantics.operationalrules.ActionRuleExecutor;

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
	boolean agintention = false;
		
	
	ModuleInitialisation init = new ModuleInitialisation(this);
	SelectRule ruleSelection = new SelectRule();
	ActionRuleExecutor actionRule = new ActionRuleExecutor();
	UserSpecAction userspec= new UserSpecAction();
	ModuleExit exitModule = new ModuleExit(this);
	
	boolean performedAnAction = false;
		
	public ModuleExecutorStage(GOALModule m) {
		module = m;
		ruleSelection.setModule(m);
		actionRule.setModule(m);
		userspec.setModule(m);
	}
	
	public GOALModule getModule() {
		return module;
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
		} else if (!selectedrules & !exit & !agintention) {
			rules.add(ruleSelection);
			selectedrules = true;
		} else if (selectedrules & !exit) {
			rules.add(actionRule);
		} else if (agintention & !exit) {
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
		if (ag.getIntention() != null) {
			agintention = true;
		}
		if (agintention && ag.getIntention().empty()) {
			ag.setIntention(null);
			agintention = false;
		}
		if (!agintention && !selectedrules && !first) {
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
				if (!agintention) {
					performedAnAction = false;
				}
			}
			
			if (exit) {
				first = true;
			}
		}
	}


	@Override
	public GOALRCStage getNextStage(GOALRC rc, GOALAgent ag) {
		if (first) {
			first = false;
			return this;
		}
		if (selectedrules & !first & !exit & !agintention) {
			selectedrules = true;
			return this;
		} else if (selectedrules & agintention) {
			selectedrules = false;
			return this;
		} else {
			if (module.getType() == GOALModule.ModuleType.MAIN) {
				rc.setStopandCheck(true);
			}
			if (rc.getAgent().isMainModuleRunning()) {
				//	nextStage = new startCycle(this, ag, this.hasPerformedAction());
				return rc.startCycle;
			} else {
				return this;
			}

		}
	}
	
	public void performedAnAction() {
		performedAnAction = true;
	}
	
	public boolean first() {
		return first;
	}

}
