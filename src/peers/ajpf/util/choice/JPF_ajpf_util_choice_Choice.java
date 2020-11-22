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

package ajpf.util.choice;

import gov.nasa.jpf.JPF;
import gov.nasa.jpf.annotation.MJI;
import gov.nasa.jpf.vm.VM;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.choice.IntChoiceFromSet;
import gov.nasa.jpf.vm.NativePeer;

import java.util.logging.Logger;


/**
 * 
 * @author louiseadennis
 *
 */
public class JPF_ajpf_util_choice_Choice<O extends Object> extends NativePeer { 
	protected static Logger log = JPF.getLogger("ajpf.util");

	  @MJI
	public static int pickChoice__I__I(MJIEnv env, int objref, int limit) {
		int myChoice = 0;
		VM vm = env.getVM();
		ThreadInfo ti = env.getThreadInfo();
		// We only create a choice if there is more than 1 option. 
		if (limit > 0) {
			if (!ti.isFirstStepInsn()) {
				log.fine("creating a choice generator");
				int[] choicearray = new int[limit + 1];
				int index = 0;
				for (int i = 0; i <= limit; i++) {
					choicearray[index] = i;
					index ++;
				}
				IntChoiceFromSet choices = new IntChoiceFromSet("probabilisticChoice", choicearray);
				vm.getSystemState().setNextChoiceGenerator(choices);
				env.repeatInvocation();
			} else {
				log.fine("getting a choice from " + limit);
				IntChoiceFromSet cg = vm.getSystemState().getCurrentChoiceGenerator("probabilisticChoice", IntChoiceFromSet.class);
				assert cg != null : "no 'probabilisticChoice' IntChoiceFromSet found";
				myChoice = cg.getNextChoice();
				log.fine("choice was " + myChoice);
			}
		} else {
			myChoice = 0;
		}
		// System.err.println("Returning " + myChoice);
		return myChoice;

	}

}