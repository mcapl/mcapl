// ----------------------------------------------------------------------------
// Copyright (C) 2015 Louise A. Dennis and Michael Fisher
// 
// This file is part of GOAL (AIL version) - GOAL-AIL
//
// GOAL-AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// GOAL-AIL is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with GOAL-AIL if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package goal.semantics;

import java.util.Iterator;
import java.util.LinkedList;

import ail.semantics.OSRule;
import ail.semantics.RCStage;
import ail.semantics.AILAgent;
import goal.semantics.executorStages.ModuleExecutorStage;
import goal.syntax.GOALModule;
import gov.nasa.jpf.annotation.FilterField;
//import gov.nasa.jpf.jvm.abstraction.filter.FilterField;

/**
 * A GOAL Reasoning stage - an example of how to implement a Languages
 * Specific reasoning stage.
 * 
 * @author louiseadennis
 *
 */
public interface GOALRCStage extends RCStage {
	public void advance(AILAgent ag);
	public GOALRCStage getNextStage(GOALRC rc, GOALAgent ag);
	public void setNextStage(GOALModule module);
	public void setNextStage(ModuleExecutorStage stage);
}
