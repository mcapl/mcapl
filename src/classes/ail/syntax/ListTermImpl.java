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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import ajpf.util.AJPFLogger;
import ajpf.psl.MCAPLListTerm;


/**
 * Represents a list node as in prolog .(t1,.(t2,.(t3,.))).
 * 
 * Each nth-ListTerm has both a head and the tail ListTerm.
 * The last ListTerm is a emptyListTerm (head==null).
 */
public class ListTermImpl extends Predicate implements ListTerm {
	
	/**
	 * The head of the list.
	 */
	private Term head;
	
	/**
	 * The tail of the list.
	 */
	private ListTerm tail;
	
	/**
	 * Constructor.  Creates a list with no head and an empty tail.
	 */
	public ListTermImpl() {
		super((String)null);
	}
	
	/**
	 * Constructor.  Converts from a MCAPL List Term to an AIL one.
	 */
	public ListTermImpl(MCAPLListTerm l) {
		head = toAIL(l.getHead());
		MCAPLListTerm t = l.getTail();
		if (t != null) {
			tail = new ListTermImpl(t);
		} else {
			tail = new ListTermImpl();
		}
	}
	
	/** make a hard copy of the terms */
	public ListTermImpl clone() {
		ListTermImpl t = new ListTermImpl();
		if (head != null) {
			t.head = (Term)this.head.clone();
		}
		if (tail != null) {
			t.tail = (ListTerm)this.tail.clone();
		}
		return t;
	}
	

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Predicate#equals(java.lang.Object)
	 */
	@Override
    public boolean equals(Object t) {
        if (t == null) return false;
        if (t == this) return true;

		if (t instanceof Term &&  ((Term)t).isVar() )  // unground var is not equals a list
		    return false;
		if (t instanceof ListTerm) {
			ListTerm tAsList = (ListTerm)t;
			if (head == null && tAsList.getHead() != null) {
				return false;
			}
			if (head != null && !head.equals(tAsList.getHead())) {
				return false;
			}
			if (tail == null && tAsList.getTail() != null) {
				return false;
			}
			if (tail != null) {
				return tail.equals(tAsList.getTail());
			}
			return true;
		} 
	    return false;
	}
	
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Predicate#calcHashCode()
     */
	@Override
    public int calcHashCode() {
        int code = 37;
        if (head != null) 
            code += head.hashCode();
        if (tail != null)
            code += tail.hashCode();
        return code;
    }
    
    /*
     *  (non-Javadoc)
     * @see ail.syntax.ListTerm#setHead(ail.syntax.Term)
     */
	@Override
	public void setHead(Term t) {
		head = t;
	}
	
	/** gets the term of this ListTerm */
	@Override
	public Term getHead() {
		return head;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ListTerm#setTail(ail.syntax.Term)
	 */
	@Override
	public void setTail(ListTerm l) {
		tail = l;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ListTerm#getTail()
	 */
	@Override
	public ListTerm getTail() {
		return (ListTerm)tail;
	}
		
	/**
	 * For unifier compatibility.
	 */
	@Override
	public int getTermsSize() {
		if (isEmpty()) {
			return 0;
		} else {
			return 2; // head and tail.
		}
	}

	/**
	 * for unifier compatibility
	 */
	@Override
	public Term getTerm(int i) {
		if (i == 0) {
			return head;
		}
		if (i == 1) {
			return tail;
		}
		return null;
	}
	
	/**
	 * For unifier compatibility.
	 */
	@Override
	public void setTerm(int i, Term t) {
		if (i == 0) {
			head = t;
		}
		if (i == 1) {
			tail = (ListTerm) t;
		}
	}

	/** return the this ListTerm elements (0=Term, 1=ListTerm) */
	@Override
	public List<Term> getTerms() {
		List<Term> l = new ArrayList<Term>(2);
		if (head != null) {
			l.add(head);
		}
		if (tail != null) {
			l.add(tail);
		}
		return l;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Predicate#addTerm(ail.syntax.Term)
	 */
	@Override
	public void addTerm(Term t) {
		AJPFLogger.warning("ail.syntax.ListTermImpl", "Do not use addTerm in lists! Use add.");
	}

	/**
	 * Length of the list.
	 */
	@Override
	public int size() {
		if (isEmpty()) {
			return 0;
		} else {
			return getTail().size() + 1;
		}
	}
	
    /*
     * (non-Javadoc)
     * @see ail.syntax.DefaultTerm#isList()
     */
	@Override
    public boolean isList() {
		return true;
	}

    /*
     * (non-Javadoc)
     * @see java.util.List#isEmpty()
     */
	@Override
    public boolean isEmpty() {
		return head == null;
	}

    /*
     * (non-Javadoc)
     * @see ail.syntax.Predicate#isGround()
     */
	@Override
	public boolean isGround() {
	    Iterator<Term> i = iterator();
		while (i.hasNext()) {
			Term t = i.next();
			if (t != null) {
				if (!t.isGround()) {
					return false;
				}
			} else {
				// If i has next and next is null then i was a variable.  This is bad program logic and should be fixed.
				return false;
			}
		}
		return true;
	}
		
	
	/** 
	 * add a term in the end of the list
	 * @return the ListTerm where the term was added
	 */
	@Override
	public boolean cons(Term t) {
		ListTerm l = this.clone();
		tail = l;
		head = t;
		return true;
	}

	
	/** 
     * Add a list in the end of this list.
	 * This method do not clone <i>lt</i>.
	 */
	@Override
	public void concat(ListTerm lt) {
		if (isEmpty()) {
			head = lt.getHead();
			tail = (ListTerm)lt.getTail();
		} else {
			((ListTerm)tail).concat(lt);
		}
	}

	
	/** returns an iterator where each element is a ListTerm */
	@Override
	public Iterator<ListTerm> listTermIterator() {
		final ListTermImpl lt = this;
		return new Iterator<ListTerm>() {
			ListTerm nextLT  = lt;
			ListTerm current = null;
			public boolean hasNext() {
				return nextLT != null && !nextLT.isEmpty() && nextLT.isList(); 
			}
			public ListTerm next() {
				current = nextLT;
				nextLT = nextLT.getTail();
				return current;
			}
			public void remove() {
				if (current != null) {
					if (nextLT != null) {
						current.setHead(nextLT.getHead());
						current.setTail(nextLT.getTail());
						nextLT = current;
					}
				}
			}
		};
	}

	/** returns an iterator where each element is a Term of this list */
	@Override
	public Iterator<Term> iterator() {
		final Iterator<ListTerm> i = this.listTermIterator();
		return new Iterator<Term>() {
			public boolean hasNext() {
				return i.hasNext();
			}
			public Term next() {
				//ListTerm l = i.next();
				//if (l.isVar()) {
				//	return l;
				//} else {
					return i.next().getHead();
				//}
			}
			public void remove() {
				i.remove();
			}
		};
	}
	
	
	/** 
	 * Returns this ListTerm as a Java List. 
	 * Note: the list Tail is considered just as the last element of the list!
	 */
	@Override
    public List<Term> getAsList() {
        List<Term> l = new ArrayList<Term>();
        Iterator<Term> i = iterator();
        while (i.hasNext()) {
            l.add( i.next() );
        }
        return l;
    }

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Predicate#toString()
	 */
	@Override
	public String toString() {
        StringBuilder s = new StringBuilder("[");
		Iterator<ListTerm> i = listTermIterator();
		while (i.hasNext()) {
			ListTerm lt = (ListTerm)i.next();
			if (lt.isVar()) {
				s.append(lt);
			} else {
				s.append( lt.getHead() );
				s.append(",");
			}
		}
		s.append("]");
		return s.toString();
	}


	/*
	 * (non-Javadoc)
	 * @see java.util.List#add(java.lang.Object)
	 */
	@Override
	public boolean add(Term o) {
		//return cons(o);
		try {
			add(size(), o);
			return true;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.List#add(int, java.lang.Object)
	 */
	@Override
	public void add(int i, Term t) throws IndexOutOfBoundsException {
		if (i == 0) {
			cons(t);
		} else {
			if (isEmpty()) {
				throw new IndexOutOfBoundsException();
			} else {
				getTail().add(i - 1, t);
			}
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.List#addAll(java.util.Collection)
	 */
	@Override
	public boolean addAll(Collection<? extends Term> c) {
		ListTerm lt = this; // where to add
		Iterator<? extends Term> i = c.iterator();
		while (i.hasNext()) {
			lt.cons(i.next());
		}
		return true;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.List#addAll(int, java.util.Collection)
	 */
	@Override
	public boolean addAll(int index, Collection<? extends Term> c) {
		Iterator<? extends Term> i = c.iterator();
		int p = index;
		while (i.hasNext()) {
			add(p, (Term)i.next()); 
			p++;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.List#clear()
	 */
	@Override
	public void clear() {
		head = null;
		tail = null;
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.List#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(Object o) {
		if (head != null && head.equals(o)) {
			return true;
		} else if (getTail() != null) {
			return getTail().contains(o);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.List#containsAll(java.util.Collection)
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		boolean r = true;
		Iterator<?> i = c.iterator();
		while (i.hasNext() && r) {
			r = r && contains((Term)i.next()); 
		}
		return r;
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.List#get(int)
	 */
	@Override
	public Term get(int index) {
		if (index == 0) {
			return this.head;
		} else if (getTail() != null) {
			return getTail().get(index-1);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.List#indexOf(java.lang.Object)
	 */
	@Override
	public int indexOf(Object o) {
		if (this.head.equals(o)) {
			return 0;
		} else if (getTail() != null) {
			int n = getTail().indexOf(o);
			if (n >= 0) {
				return n+1;
			}
		}
		return -1;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.List#lastIndexOf(java.lang.Object)
	 */
	@Override
	public int lastIndexOf(Object arg0) {
		return getAsList().lastIndexOf(arg0);
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.List#listIterator()
	 */
	@Override
	public ListIterator<Term> listIterator() {
		return listIterator(0);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.List#listIterator(int)
	 */
	@Override
	public ListIterator<Term> listIterator(final int startIndex) {
        final ListTermImpl list = this;
        return new ListIterator<Term>() {
            int pos = startIndex;
            int last = -1;
            int size = size();

            public void add(Term o) {
                list.add(last,o);
            }
            public boolean hasNext() {
                return pos < size;
            }
            public boolean hasPrevious() {
                return pos > startIndex;
            }
            public Term next() {
                last = pos;
                pos++;
                return get(last);
            }
            public int nextIndex() {
                return pos+1;
            }
            public Term previous() {
                last = pos;
                pos--;
                return get(last);
            }
            public int previousIndex() {
                return pos-1;
            }
            public void remove() {
                list.remove(last);
            }
            public void set(Term o) {
                remove();
                add(o);
            }            
        };
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.List#remove(int)
	 */
	@Override
	public Term remove(int index) {
		if (index == 0) {
			Term bt = this.head;
			if (getTail() != null) {
				this.head = getTail().getHead();
				this.tail = getTail().getTail();
			} else {
				clear();
			}
			return bt;
		} else if (getTail() != null) {
			return getTail().remove(index-1);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.List#remove(java.lang.Object)
	 */
	@Override
	public boolean remove(Object o) {
		if (head != null && head.equals(o)) {
			if (getTail() != null) {
				this.head = getTail().getHead();
				this.tail = getTail().getTail();
			} else {
				clear();
			}
			return true;
		} else if (getTail() != null) {
			return getTail().remove(o);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.List#removeAll(java.util.Collection)
	 */
	@Override
	public boolean removeAll(Collection<?> c) {
		boolean r = true;
		Iterator<?> i = c.iterator();
		while (i.hasNext() && r) {
			r = r && remove(i.next()); 
		}
		return r;
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.List#retainAll(java.util.Collection)
	 */
	@Override
	public boolean retainAll(Collection<?> c) {
		boolean r = true;
		Iterator<?> i = iterator();
		while (i.hasNext()) {
			Term t = (Term)i.next();
			if (!c.contains(t)) {
				r = r && remove(t);
			}
		}
		return r;
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.List#set(int, java.lang.Object)
	 */
	@Override
	public Term set(int index, Term t) {
		if (index == 0) {
			this.head = t;
			return t;
		} else if (getTail() != null) {
			return getTail().set(index-1, t);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.List#subList(int, int)
	 */
	@Override
	public List<Term> subList(int arg0, int arg1) {
		return getAsList().subList(arg0, arg1);
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.List#toArray()
	 */
	@Override
	public Object[] toArray() {
		return getAsList().toArray();
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.List#toArray(java.lang.Object[])
	 */
    @SuppressWarnings("unchecked")
	@Override
	public Object[] toArray(Object[] arg0) {
		return getAsList().toArray(arg0);
	}
    
    public boolean unifies(Unifiable t1g, Unifier u) {
    	return super.unifies(t1g, u);
    }

}
