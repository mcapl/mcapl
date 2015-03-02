// ----------------------------------------------------------------------------
// Copyright (C) 2014 Louise A. Dennis, Michael Fisher.
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
//----------------------------------------------------------------------------

package ajpf.psl;

import java.util.Iterator;
import java.util.List;

/**
 * A class representing list type terms that appear in AJPF Properties.
 * @author louiseadennis
 *
 */
public class MCAPLListTermImpl implements MCAPLListTerm {
	MCAPLTerm head;
	MCAPLListTerm tail;
	
	/**
	 * Constructor.
	 */
	public MCAPLListTermImpl(MCAPLTerm h) {
		head = h;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public MCAPLListTermImpl clone() {
		return this;
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.MCAPLTerm#isNumeric()
	 */
	public boolean isNumeric() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.MCAPLTerm#isList()
	 */
	public boolean isList() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.MCAPLTerm#isString()
	 */
	public boolean isString() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.MCAPLTerm#getFunctor()
	 */
	public String getFunctor() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.MCAPLTerm#getTerms()
	 */
	public List<? extends MCAPLTerm> getTerms() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.MCAPLTerm#getTermsSize()
	 */
	public int getTermsSize() {
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.MCAPLTerm#isUnnamedVar()
	 */
	public boolean isUnnamedVar() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(MCAPLTerm o) {
		if (o instanceof MCAPLListTerm) {
			int compVal = getHead().compareTo(((MCAPLListTerm) o).getHead());
			if (compVal == 0) {
				return getTail().compareTo(((MCAPLListTerm) o).getTail());
			} else {
				return compVal;
			}
		} else {
			return -1;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.MCAPLListTerm#getHead()
	 */
	public MCAPLTerm getHead() {
		return head;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.MCAPLListTerm#getTail()
	 */
	public MCAPLListTerm getTail() {
		return tail;
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.MCAPLListTerm#addEnd(ajpf.psl.MCAPLTerm)
	 */
	public void addEnd(MCAPLTerm t) {
		if (tail == null) {
			tail = new MCAPLListTermImpl(t);
		} else {
			tail.addEnd(t);
		}
	}
	
	/**
	 * Is this the empty list?
	 * @return
	 */
	public boolean isEmpty() {
		return tail == null;
	}

	/** returns an iterator where each element is a ListTerm */
	public Iterator<MCAPLListTerm> listTermIterator() {
		final MCAPLListTermImpl lt = this;
		return new Iterator<MCAPLListTerm>() {
			MCAPLListTerm nextLT  = lt;
			MCAPLListTerm current = null;
			public boolean hasNext() {
				return nextLT != null && nextLT.isList(); 
			}
			public MCAPLListTerm next() {
				current = nextLT;
				nextLT = nextLT.getTail();
				return current;
			}
			public void remove() {};
		};
	}

	
/*
	 * (non-Javadoc)
	 * @see ail.syntax.Predicate#toString()
	 */
	public String toString() {
        StringBuilder s = new StringBuilder("[");
		Iterator<MCAPLListTerm> i = listTermIterator();
		while (i.hasNext()) {
			MCAPLListTerm lt = (MCAPLListTerm)i.next();
			s.append( lt.getHead() );
			s.append(",");
		}
		s.append("]");
		return s.toString();
	}
	
	/**
	 * Set the tail of the list.  Use with caution.
	 * @param t
	 */
	public void setTail(MCAPLListTerm t) {
		tail = t;
	}


}
