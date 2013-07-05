// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
// 
// This file is part of the Agent Infrastructure Layer (AIL)
//
// The AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The AIL is distributed in the hope that it will be useful,
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
//
// This file is based on code from the Open Source software "Jason", copyright
// by Jomi F. Hubner and Rafael H. Bordini.  http://jason.sf.net
//----------------------------------------------------------------------------

package ail.syntax;

import java.util.Iterator;
import java.util.List;

/**
 * List of Terms Interface
 * 
 */
public interface ListTerm extends java.util.List<Term>, Term {
	
	/**
	 * Set the head of the list.
	 * @param t
	 */
	public void setHead(Term t);
	/**
	 * Get the head of the list.
	 * @return
	 */
	public Term getHead();
	
	/**
	 * Set the tail of the list.
	 * @param l
	 */
	public void setTail(ListTerm l);
	/**
	 * Get the tail of the list.
	 * @return
	 */
	public ListTerm getTail();
		
	/**
	 * Add a new item to the head of the list.
	 * @param t
	 * @return
	 */
	public boolean cons(Term t);
	
	/**
	 * Append two lists together.
	 * @param lt
	 * @return
	 */
	public void concat(ListTerm lt);
	
	/**
	 * Returns an iterator over the tails of the list.
	 * @return
	 */
	public Iterator<ListTerm> listTermIterator();
	
	/**
	 * Return as a java list of terms.
	 * @return
	 */
    public List<Term> getAsList();
}
