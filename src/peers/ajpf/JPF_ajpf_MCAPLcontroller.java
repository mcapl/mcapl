// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of Agent JPF (AJPF)
// 
// AJPF is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// AJPF is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with AJPF; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ajpf;

import java.util.logging.Logger;

import ajpf.psl.MCAPLProperty;
import ajpf.psl.parser.A_PSLParser;
import ajpf.psl.parser.A_PSLLexer;

import ajpf.MCAPLmas;
import ajpf.MCAPLcontroller;

import mcaplantlr.runtime.CommonTokenStream;
import mcaplantlr.runtime.ANTLRStringStream;

import gov.nasa.jpf.JPF;
import gov.nasa.jpf.annotation.MJI;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.choice.IntChoiceFromSet;
import gov.nasa.jpf.vm.ChoiceGenerator;
import gov.nasa.jpf.vm.VM;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.SystemState;
import gov.nasa.jpf.vm.NativePeer;

/**
 * Interface for formulas in the MCAPL Property Specification Language.
 * 
 * @author louiseadennis
 *
 */
public class JPF_ajpf_MCAPLcontroller extends NativePeer {
//	static Abstract_Property property;
	 protected static Logger log = JPF.getLogger("ajpf.MCAPLcontroller");
		
/*	 @MJI
	 public static int pickJob__I__I(MJIEnv env, int objref, int limit) {
		int myChoice = 0;
		VM vm = env.getVM();
		ThreadInfo ti = env.getThreadInfo();
		if (!ti.isFirstStepInsn()) {
			log.fine("creating a choice generator");
			int[] choicearray = new int[limit];
			int index = 0;
			for (int i = 0; i < limit; i++) {
				choicearray[index] = i;
				index ++;
			}
			IntChoiceFromSet choices = new IntChoiceFromSet("agentSchedulerChoice", choicearray);
			vm.getSystemState().setNextChoiceGenerator(choices);
			env.repeatInvocation();
		} else {
			log.fine("getting a choice");
			IntChoiceFromSet cg = vm.getSystemState().getCurrentChoiceGenerator("agentSchedulerChoice", IntChoiceFromSet.class);
			assert cg != null : "no 'agentSchedulerChoice' IntChoiceFromSet found";
			myChoice = cg.getNextChoice();
			log.fine("Selecting " + myChoice + " from " + limit);
		}
		return myChoice;

	} */
	
	/*
	 * Not, I think a good way to do this but forces a transition before the system closes everything down and so forces checking of
	 * final state properly.
	 */
	  @MJI
	public static boolean force_transition____Z(MJIEnv env, int objref) {
		log.fine("attempting to yield");
		int myChoice = 0;
		VM vm = env.getVM();
		ThreadInfo ti = env.getThreadInfo();
		if (!ti.isFirstStepInsn()) {
			log.fine("creating a choice generator");
			int[] choicearray = new int[1];
			int index = 0;
			for (int i = 0; i < 1; i++) {
				choicearray[index] = i;
				index ++;
			}
			if (choicearray.length > 0) {
				IntChoiceFromSet choices = new IntChoiceFromSet("NewAgentProgramState", choicearray);
				vm.getSystemState().setNextChoiceGenerator(choices);
				env.repeatInvocation();
			}
		} else {
			log.fine("getting a choice");
			IntChoiceFromSet cg = vm.getSystemState().getCurrentChoiceGenerator("NewAgentProgramState", IntChoiceFromSet.class);
			assert cg != null : "no 'NewAgentProgramState' IntChoiceFromSet found";
			myChoice = cg.getNextChoice();
			log.fine("Selecting " + myChoice + " from " + 1);
		}
	/*	   ThreadInfo ti = env.getThreadInfo();
		    SystemState ss = env.getSystemState();

		    if (!ti.isFirstStepInsn()) { // first time we see this (may be the only time)
		      ChoiceGenerator<?> cg = ss.getSchedulerFactory().createThreadYieldCG( ti);
		      if (ss.setNextChoiceGenerator(cg)) {
		        env.repeatInvocation();
		      }
		    } else {
		      // nothing to do, this was just a forced reschedule
		    } */
		return true;
	}

}