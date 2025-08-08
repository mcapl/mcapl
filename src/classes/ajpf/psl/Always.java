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

/**
 * Class for the property G(phi) defined as F R phi
 * 
 * @author lad
 *
 */
public class Always extends Release {
	
	/**
	 * Constructor.
	 * @param p
	 */
	public Always(MCAPLProperty p) {
		super(new FalseProp(), p);
	}
	
	/*
	 * (non-Javadoc)
	 * @see mcapl.psl.Release#toString()
	 */
	public String toString() {
		String s = "[]";
		s += trueuntil.toString();
		return s;
	}
	
}
