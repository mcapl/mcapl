// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis, Michael Fisher, and Koen Hindriks
// 
// This file is part of AIL GOAL.  An AIL Implementation of the GOAL Programming
// Language
//
// AIL GOAL is free software: you can redistribute it and/or modify it under
// the terms of the GNU General Public License as published by the Free Software
// Foundation, either version 3 of the License, or (at your option) any later
// version.
//
// AIL GOAL is distributed in the hope that it will be useful, but WITHOUT
// ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
// FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
// details.
//
// You should have received a copy of the GNU General Public License along with
// this program. If not, see <http://www.gnu.org/licenses/>.
//
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------
package goal.semantics.executorStages;

import goal.semantics.AbstractGoalStage;
import goal.semantics.GOALRC;
import goal.semantics.GOALRCStage;
import goal.semantics.operationalrules.GOALHandleAddAchieveTestGoal;
import goal.semantics.operationalrules.GOALHandleAddBelief;
import goal.semantics.operationalrules.GOALHandleDropBelief;
import goal.semantics.operationalrules.GOALHandleDropGeneralGoal;
import goal.semantics.operationalrules.ModuleCallActionExecutor;
import goal.semantics.operationalrules.ModuleInitialisation;
import goal.semantics.operationalrules.PrintActionExecutor;
import goal.semantics.operationalrules.SelectRule;
import goal.semantics.operationalrules.SendActionExecutor;
import goal.semantics.operationalrules.SendOnceActionExecutor;
import goal.semantics.operationalrules.UserSpecAction;
import goal.semantics.operationalrules.ModuleExit;
import goal.semantics.operationalrules.ActionRuleExecutor;

import java.util.Iterator;
import java.util.ArrayList;

import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import ail.semantics.operationalrules.HandleAddAchieveTestGoal;
import ail.semantics.operationalrules.HandleAddBelief;
import ail.semantics.operationalrules.HandleDropBelief;
import ail.semantics.operationalrules.HandleDropGeneralGoal;
import ail.semantics.operationalrules.HandleDropGoal;
import goal.syntax.GOALModule;
import goal.semantics.GOALAgent;

public class ModuleExecutorStage extends AbstractGoalStage {
	private final GOALModule module;
	private boolean first = true;
	private boolean exit = false;
	boolean selectedrules = false;
	boolean agintention = false;
		
	ModuleExecutorStage nextModule;
		
	
	ModuleInitialisation init = new ModuleInitialisation(this);
	SelectRule ruleSelection = new SelectRule();
	ActionRuleExecutor actionRule = new ActionRuleExecutor();
	UserSpecAction userspec= new UserSpecAction();
	ModuleCallActionExecutor mca = new ModuleCallActionExecutor();
	PrintActionExecutor printaction = new PrintActionExecutor();
	SendActionExecutor sendaction = new SendActionExecutor();
	SendOnceActionExecutor sendonceaction = new SendOnceActionExecutor();
	ModuleExit exitModule = new ModuleExit(this);
	GOALHandleAddBelief addBelief = new GOALHandleAddBelief();
	GOALHandleDropBelief dropBelief = new GOALHandleDropBelief();
	GOALHandleAddAchieveTestGoal addGoal = new GOALHandleAddAchieveTestGoal();
	GOALHandleDropGeneralGoal dropGoal = new GOALHandleDropGeneralGoal(new ArrayList<Integer>());
	
	boolean performedAnAction = false;
		
	public ModuleExecutorStage(GOALModule m) {
		module = m;
		ruleSelection.setModule(m);
		actionRule.setModule(m);
		userspec.setModule(m);
		printaction.setModule(m);
		addBelief.setModule(m);
		dropBelief.setModule(m);
		addGoal.setModule(m);
		dropGoal.setModule(m);
		sendaction.setModule(m);
		sendonceaction.setModule(m);
		mca.setModule(m);
	}
	
	public GOALModule getModule() {
		return module;
	}

	@Override
	public String getStageName() {
		return "Module Executor for " + module.getNamePhrase();
	}

	@Override
	public Iterator<OSRule> getStageRules() {
		ArrayList<OSRule> rules = new ArrayList<OSRule>();
		if (first) {
			rules.add(init);
		} else if (!selectedrules & !exit & !agintention) {
			rules.add(ruleSelection);
			// selectedrules = true;
		} else if (selectedrules & !exit) {
			rules.add(actionRule);
		} else if (agintention & !exit) {
			rules.add(printaction);
			rules.add(sendaction);
			rules.add(sendonceaction);
			rules.add(addBelief);
			rules.add(dropBelief);
			rules.add(addGoal);
			rules.add(dropGoal);
			rules.add(userspec);
			rules.add(mca);
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
		} else {
			agintention = false;
		}
		if (agintention && ag.getIntention().empty()) {
			ag.setIntention(null);
			agintention = false;
		}
		
		if (module.hasRuleSet()) {
			selectedrules = true;
		} else {
			selectedrules = false;
		}

		if (!agintention && !selectedrules && !first && !exit) {
			setExitIfAppropriate((GOALAgent) ag);
		} else {
			if (agintention) {
				//module.setRule(null);
				selectedrules = false;
				// if (! module.getExecuteFully()) {
				//	module.setRule(null);
				// }
			//	((GOALAgent) ag).actionPerformed();
			}
			
			if (!exit) {
				if (!agintention) {
					performedAnAction = false;
					((GOALAgent) ag).clearActionPerformed();
				}
			}
			
			if (exit) {
				// ? Or possibly not, maybe we only initialise modules onece.
				first = true;
			}
		}
	}
	
	public void setExitIfAppropriate(GOALAgent ag) {
		exit = module.isModuleTerminated();
		
		switch (module.getExitCondition()) {
			case NOGOALS:
				exit |= ag.getAttentionSet().isEmpty();
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
				// module.setRule(null);
			} 

	}


	@Override
	public GOALRCStage getNextStage(GOALRC rc, GOALAgent ag) {		
		if (nextModule != null) {
			ModuleExecutorStage tmp = nextModule;
			nextModule = null;
			exit = false;
			// module.setRule(null);
			if (tmp.getModule().getType() == GOALModule.ModuleType.MAIN) {
				if (module.getType() != GOALModule.ModuleType.EVENT && module.getType() != GOALModule.ModuleType.INIT) {
					if (!tmp.selectedrules) {
						if (!tmp.agintention) {
							if (!tmp.exit) {
								rc.setStopandCheck(true);
								return rc.startCycle;
							}
						}
					}
				}
			}
			return tmp;
		}

		if (first & !exit) {
			first = false;
			return this;
		}
		if (selectedrules & !first & !exit & !agintention) {
			return this;
		} else if (selectedrules & agintention) {
			// selectedrules = false;
			return this;
		} else if (agintention) {
			return this;
		} else if (!first & exit & !module.isModuleTerminated()) {
			return this;
		} else {
			// exit = false;
			if (module.getType() == GOALModule.ModuleType.MAIN) {
			//	if (rc.eventModuleInstantiated()  && ag.actionPerformedLastCycle()) {
			//		return rc.eventModule;
			//	} 
				
				rc.setStopandCheck(true);
			}
			if (module.getType() == GOALModule.ModuleType.INIT) {
				if (rc.eventModuleInstantiated() ) { // && ag.actionPerformedLastCycle()) {
					return rc.eventModule;
				} else {
					return rc.mainModule;
				}
			}
			if (module.getType() == GOALModule.ModuleType.EVENT) {
				exit = false;
				// module.setRule(null);
				return rc.mainModule;
			}
			
			if (ag.isMainModuleRunning()) {
				return rc.startCycle;
			} else {
				ag.getEnv().getScheduler().notActive(ag.getAgName());
				rc.setStopandCheck(true);
				// NB. was return null but that was throwing errors.
				ag.stop();
				return null;
			}

		}
	}
	
	/*public void performedAnAction() {
		performedAnAction = true;
	} */
	
	public boolean first() {
		return first;
	}

	@Override
	public void setNextStage(GOALModule module) {
		nextModule = new ModuleExecutorStage(module);
	}

	@Override
	public void setNextStage(ModuleExecutorStage stage) {
		// TODO Auto-generated method stub
		nextModule = stage;
	}

}
