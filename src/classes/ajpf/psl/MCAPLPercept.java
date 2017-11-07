// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
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
// License along with AJPF if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package ajpf.psl;

import ajpf.MCAPLmas;

/**
 * The formula P(phi) means phi is "true" in the environment.
 * 
 * @author louiseadennis
 * 
 */
public class MCAPLPercept extends Proposition {
	
	/**
	 * The formula that is the percept.
	 */
	private MCAPLFormula percept;
	
	/**
	 * The multi-agent system - from which the environment can be extracted.
	 */
	private MCAPLmas mas;
	
	/**
	 * Constructor.
	 * @param m the multi-agent system.
	 * @param f the formula to be checked.
	 */
	public MCAPLPercept(MCAPLmas m, MCAPLFormula f) {
		percept = f;
		mas = m;
	}
	
	
	/**
	 * Checks the truth of the formula agent believs fmla
	 * 
	 * @return the truth of the formula.
	 */
	public boolean check() {
		boolean r = mas.hasPercept(percept);
		// System.err.println("CHECKING PERCEPT" + r);
		return r;
	}
	
	/*
	 * (non-Javadoc)
	 * @see mcapl.psl.Proposition#equals(mcapl.psl.MCAPLProperty)
	 */
	// As with last action this assume it will only ever be compared to percepts using the same mas.
	public boolean equals(Object p) {
		if (p instanceof MCAPLPercept) {
			return (((MCAPLPercept) p).getPercept().equals(percept));
		}
		
		return false;
	}
	
	/*
	 * 
	 */
	public boolean equals(MCAPLProperty p) {
		if (p instanceof MCAPLPercept) {
			return (((MCAPLPercept) p).getPercept().equals(percept));
		}
		
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return percept.hashCode();
	}
	
	/**
	 * Getter method for the Formula.
	 * 
	 * @return the formula/percept/proposition.
	 */
	public MCAPLFormula getPercept() {
		return percept;
	}
	
	/**
	 * Getter method for the multi-agent system.
	 * @return the multi-agent system.
	 */
	public MCAPLmas getMAS() {
		return mas;
	}
	
	/**
	 * We don't need to clone the agent - its the same one we want to query.
	 */
	public MCAPLPercept clone() {
		return(new MCAPLPercept(mas, (MCAPLFormula) percept.clone()));
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String s = "P(" + percept.toString() + ")";
		return s;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.MCAPLProperty#quickCompareVal()
	 */
	public int quickCompareVal() {
		return 16;
	}

	    
}
