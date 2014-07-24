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
// License along with AJPF; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
// This file is based on code from the Open Source software "Jason", copyright
// by Jomi F. Hubner and Rafael H. Bordini.  http://jason.sf.net
//----------------------------------------------------------------------------

package ajpf.psl;

/**
 * An interface for list type terms appearing in properties.
 * @author louiseadennis
 *
 */
public interface MCAPLListTerm extends MCAPLTerm {
	/**
	 * Add a term to the end of the list.
	 * @param t
	 */
	public void addEnd(MCAPLTerm t);
	
	/**
	 * Get the tail of the list.
	 * @return
	 */
	public MCAPLListTerm getTail();
	
	/**
	 * Get the head of the list.
	 * @return
	 */
	public MCAPLTerm getHead();
}
