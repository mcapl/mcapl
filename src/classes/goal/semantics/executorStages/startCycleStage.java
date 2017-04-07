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

import java.util.Iterator;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.ArrayList;

import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import ail.syntax.Message;
import ail.syntax.Predicate;
import goal.semantics.AbstractGoalStage;
import goal.semantics.GOALRC;
import goal.semantics.GOALRCStage;
import goal.semantics.operationalrules.ProcessMessages;
import goal.semantics.operationalrules.ProcessPercepts;
import goal.semantics.operationalrules.GOALSleepRule;
import goal.semantics.GOALAgent;
import goal.syntax.GOALModule;

public class startCycleStage extends AbstractGoalStage {
    private Set<Predicate> current_percepts = new LinkedHashSet<>();
    // ? Use agent inbox for this.
    private Set<Message> current_messages = new LinkedHashSet<>();

	
	GOALSleepRule sleep = new GOALSleepRule(this);
	ProcessMessages messages = new ProcessMessages(this);
	ProcessPercepts percepts = new ProcessPercepts(this);
	
	boolean firstround = true;
	
	public void setMessages(Set<Message> ms) {
		current_messages = ms;
	}
	
	public void setPercepts(Set<Predicate> ps) {
		current_percepts = ps;
	}
	
	OSRule atstart = sleep;

	@Override
	public void advance(AILAgent ag) {
		if (atstart instanceof ProcessPercepts) {
			atstart = messages;
		} else if (atstart instanceof ProcessMessages) {
			atstart = sleep;
		} else if (atstart instanceof GOALSleepRule) {
			atstart = percepts;
		}
	}

	@Override
	public GOALRCStage getNextStage(GOALRC rc, GOALAgent ag) {
		if (atstart instanceof GOALSleepRule) {
			if (rc.initModuleInstantiated() && firstround) {
				firstround = false;
				return rc.initModule;
			} else if (ag.hasInitModule() && firstround ){
				firstround = false;
				rc.setInitModule(ag.getInitModule());
				return rc.initModule;
			} else if (rc.eventModuleInstantiated() && ! firstround ) { // ag.actionPerformedLastCycle()) {
				//ag.clearActionPerformed();
				return rc.eventModule;
			} else if (ag.hasEventModule() && ! firstround) { //ag.actionPerformedLastCycle()){
				//ag.clearActionPerformed();
				rc.setEventModule(ag.getEventModule());
				return rc.eventModule;
			} else if (rc.mainModuleInstantiated()) {
				return rc.mainModule;
			} else {
				// This isn't right what if agent has all three modules?
				rc.setMainModule(ag.getMainModule());
				return rc.mainModule;
			}
		} else {
		// TODO Auto-generated method stub
			return this;
		}
	}

	@Override
	public String getStageName() {
		// TODO Auto-generated method stub
		return "startCycle";
	}

	@Override
	public Iterator<OSRule> getStageRules() {
		// TODO Auto-generated method stub
		ArrayList<OSRule> rules = new ArrayList<OSRule>();
		rules.add(atstart);
		return rules.iterator();
	}
	
	public Set<Message> getMessages() {
		return current_messages;
	}
	
	public Set<Predicate> getPercepts() {
		return current_percepts;
	}

	@Override
	public void setNextStage(GOALModule module) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNextStage(ModuleExecutorStage stage) {
		// TODO Auto-generated method stub
		
	}

}
