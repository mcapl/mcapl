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

package goal.semantics;

import java.util.LinkedList;

import ail.semantics.ReasoningCycle;
import ail.semantics.RCStage;
import ail.semantics.AILAgent;
import ail.semantics.operationalrules.*;
import ail.semantics.OSRule;
import ail.syntax.Goal;
import goal.semantics.operationalrules.*;
import goal.semantics.executorStages.ModuleExecutorStage;
import goal.semantics.executorStages.startCycleStage;
import gov.nasa.jpf.annotation.FilterField;
import goal.syntax.GOALModule;
//import gov.nasa.jpf.jvm.abstraction.filter.FilterField;

/**
 * The GOAL Reasonning Cycle.
 * 
 * @author louiseadennis
 *
 */
public class GOALRC implements ReasoningCycle {
	
	public final GOALRCStage startCycle = new startCycleStage();
	public GOALRCStage mainModule;
	public GOALRCStage initModule;
	public GOALRCStage eventModule;
		
	GOALRCStage currentStage = startCycle; 
	boolean stopandcheck = false;
	private GOALAgent ag;
		
	public GOALRC(GOALAgent ag) {
		this.ag = ag;
	}
	
	public void init(GOALAgent ag) {
		setMainModule(ag.getMainModule());
		setInitModule(ag.getInitModule());
		setEventModule(ag.getEventModule());
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.ReasoningCycle#cycle(ail.semantics.AILAgent)
	 */
	public void cycle(AILAgent ag) {
		currentStage.advance(ag);
		currentStage = currentStage.getNextStage(this, (GOALAgent) ag);
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.ReasoningCycle#getStage()
	 */
	public RCStage getStage() {
		return currentStage;
	}
	
	public GOALAgent getAgent() {
		return ag;
	}

	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.ReasoningCycle#stopandcheck()
	 */
	public boolean stopandcheck() {
		if (! stopandcheck ) {
			return stopandcheck;
		} else {
			setStopandCheck(false);
			return true;
		}
	} 
	
	public void setStopandCheck(boolean b) {
		stopandcheck = b;
	}

	public void setCurrentStage(RCStage rcs) {
		currentStage = (GOALRCStage) rcs;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.ReasoningCycle#not_interrupted()
	 */
	public boolean not_interrupted() {
		return true;
	}
	
	public boolean mainModuleInstantiated() {
		return mainModule != null;
	}

	public boolean initModuleInstantiated() {
		return initModule != null;
	}
	
	public boolean eventModuleInstantiated() {
		return eventModule != null;
	}
	
	public void setMainModule(GOALModule m) {
		mainModule = new ModuleExecutorStage(m);
	}
	
	public void setInitModule(GOALModule m) {
		if (m != null) {
			initModule = new ModuleExecutorStage(m);
		}
	}

	public void setEventModule(GOALModule m) {
		if (m != null) {
			eventModule = new ModuleExecutorStage(m);
		}
	}

	public void setCurrentModuleExecuteFully(GOALModule module) {
		// module.setExecuteFully();
		switch (module.getType()){
		case INIT:
			currentStage.setNextStage((ModuleExecutorStage) initModule);
			return;
		case EVENT:
			currentStage.setNextStage((ModuleExecutorStage) eventModule);
			return;
		case MAIN:
			currentStage.setNextStage((ModuleExecutorStage) mainModule);
			return;
		default:
			currentStage.setNextStage(module);
			
		}
	}
	
	public GOALRCStage getCurrentStage() {
		return currentStage;
	}
}
