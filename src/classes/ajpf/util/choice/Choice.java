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

import java.util.ArrayList;
import java.util.Random;

import ajpf.MCAPLcontroller;

/**
 * A class that represents a probablistic choice among a finite set of options.
 * This is important for representing probabilities in AJPF since methods can be
 * intercepted by native peers in order to branch the search space.
 * @author louiseadennis
 *
 */
public class Choice<O extends Object> { 
	// The fine set of options
	public ArrayList<Option<O>> choicelist = new ArrayList<Option<O>>();
	// Index to the current choice in choicelist - represented as a double to ease
	// access from the Native JVM.
	public double thischoice;
	
	public MCAPLcontroller control;

	public Choice() {

	}

	public Choice(MCAPLcontroller control) {
		this.control = control;
	}
	
	/**
	 * Add an option to this choice, with probability d.
	 * @param d
	 * @param o
	 */
	public void addChoice(double d, O o) {
		choicelist.add(new Option<O>(d, o));
	}
	
	/**
	 * Pick a choice, update this choice accordingly, return index to the choice.
	 * @return
	 */
	public int choose() {
		if (control == null || ! control.replayMode()) {
			// System.err.println("choosing");
			int i = pickChoice(choicelist.size() - 1);
			//  System.err.println(i);
			thischoice = choicelist.get(i).getProb();
			if (control != null && control.recordMode()) {
				// System.out.println("HERE");
				control.getRecord().add(i);
			}
			return i;
		} else {
			return control.getRecord().next();
		}
	}

	/**
	 * This method is intercepted by the native peer when running in JPF.  When running
	 * outside of JPF it selects an option from the list according to the probability 
	 * distribution.  When running in JPF it is intercepted and a choice generator created
	 * that will explore all possible options.
	 * @param limit
	 * @return
	 */
	public int pickChoice(int limit) {
		Random r = new Random();
		double rvalue = r.nextDouble();
		int list_index = 0;
		Option<O> current = choicelist.get(list_index);
		double accumulator = current.getProb();
		while (rvalue > accumulator) {
			list_index++;
			if (list_index == limit) {
				break;
			}
			current = choicelist.get(list_index);
			accumulator += current.getProb();
		}
		
		return list_index;
	}

	/**
	 * Choose an options.
	 * @return
	 */
	public O get_choice() {
		int i = choose();
		O choice = choicelist.get(i).getObj();
		return choice;
	}
	
	public void clearChoices() {
		choicelist = new ArrayList<Option<O>>();
	}
		
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return choicelist.toString();
	}
	
	/**
	 * A class for the options in the probabilistic distribution.  An option
	 * is a tuple of a probability and a value.
	 * @author louiseadennis
	 *
	 * @param <O1>
	 */
	public class Option<O1 extends Object> {
		public double probability;
		public O1 value;
		
		public Option(double d, O1 v) {
			probability = d;
			value = v;
		}
		
		/**
		 * Return the probability.
		 * @return
		 */
		public double getProb() {
			return probability;
		}
		
		/**
		 * Return the value.
		 * @return
		 */
		public O1 getObj() {
			return value;
		}
		
		/*
		 * (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			return "(" + probability + ", " + value + ")";
		}
	}
}