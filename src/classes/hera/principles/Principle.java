// ----------------------------------------------------------------------------
// Copyright (C) 2018 Louise A. Dennis, Felix Lindner, Martin Moze Bentzen, Michael Fisher
//
// This file is part of Juno
//
// Juno is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Juno is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package hera.principles;

import java.util.ArrayList;

import hera.language.Formula;
import hera.semantics.Model;

/**
 * Abstract class representing an ethical principle.
 * @author louisedennis
 *
 */
public abstract class Principle {
	Model model;
	ArrayList<Formula> formulae = new ArrayList<Formula>();
	ArrayList<Boolean> result = new ArrayList<Boolean>();
	String label;
	String action;
	
	public static int NOT_PERMISSIBLE = 0;
	public static int PERMISSIBLE = 1;
	public static int NOT_APPLICABLE = 2;
	
	/**
	 * Priniciples are initialised with a model.
	 * @param m
	 */
	public void init(Model m) {
		model = m;
	}
	
	// Not sure what the difference between the next two methods is since in all the 
	// principles used in this implementation permissible calls check and then returns the first
	// result from the list.
	/**
	 * This checks whether some causal model is permissible according to the ethical principle.
	 * @return
	 */
	public abstract ArrayList<Boolean> _check();
	
	/**
	 * Checks whether some causal model is permissible according to the ethical principle.
	 * 
	 * Switched to an int in contrast to the Python versions true/false + null because
	 * JPF doesn't like NullPointerExceptions.
	 * @return
	 */
	public abstract int permissible();
	
	/**
	 * Text explanation for the result.
	 * @return
	 */
	public String explain() {
		int pd = permissible();
		String result = "";
		if (pd == NOT_APPLICABLE) {
			result = "The " + label + " is not applicable to this instance!";
		} else if (pd == PERMISSIBLE) {
			result = "According to the "+ label + ", the action " + action + " is permissible!"; 
		} else {
			result = result + "According to the " + label + " principle, the action " + action +" is not permissible!\n";
		    result = result + "Because the following does not hold: \n";
		    for (int i = 0; i < this.result.size(); i++ ) {
		    		if (! this.result.get(i)) {
		    			result = result + formulae.get(i) + "\n";
		    		}
		    }
		}
		return result;
	}
}
