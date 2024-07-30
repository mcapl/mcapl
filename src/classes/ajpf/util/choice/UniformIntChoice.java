// ----------------------------------------------------------------------------
// Copyright (C) 2015 Louise A. Dennis, and  Michael Fisher 
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

import ajpf.MCAPLcontroller;

/**
 * A choice representing a uniform distribution over integers between 0 and some limit.
 * @author louiseadennis
 *
 */
public class UniformIntChoice extends Choice<Integer> {
		
	/**
	 * Constructor.
	 * @param control
	 */
	public UniformIntChoice(MCAPLcontroller control) {
		super(control);
	}

	public UniformIntChoice() {
		super();
	}

	/**
	 * Get the next integer.
	 * @param limit
	 * @return
	 */
	public int nextInt(int limit) {
		this.clearChoices();
		for (int i = 0; i < limit; i++) {
			double prob = 1.0/limit;
			// System.err.println("limit is " + limit + " and prob is " + prob);
			addChoice(prob, i);
		}
		int i = get_choice();
		return i;
	}

}
