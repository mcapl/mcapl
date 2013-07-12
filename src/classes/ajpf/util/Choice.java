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

package ajpf.util;

import java.util.ArrayList;
import java.util.Random;


/**
 * 
 * @author louiseadennis
 *
 */
public class Choice<O extends Object> { 
	public ArrayList<Option<O>> choicelist = new ArrayList<Option<O>>();
	public double thischoice;
	public Random r = new Random();
	
	public void addChoice(double d, O o) {
		choicelist.add(new Option<O>(d, o));
	}
	
	public int choose() {
		int i = pickChoice(choicelist.size() - 1);
		thischoice = choicelist.get(i).getProb();
		return i;
	}

	public int pickChoice(int limit) {
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

	public O get_choice() {
		int i = choose();
		O choice = choicelist.get(i).getObj();
		return choice;
	}
		
	public String toString() {
		return choicelist.toString();
	}
	
	public class Option<O1 extends Object> {
		public double probability;
		public O1 value;
		
		public Option(double d, O1 v) {
			probability = d;
			value = v;
		}
		
		public double getProb() {
			return probability;
		}
		
		public O1 getObj() {
			return value;
		}
		
		public String toString() {
			return "(" + probability + ", " + value + ")";
		}
	}
}