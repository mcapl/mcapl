package ajpf.psl;

import java.util.Iterator;
import java.util.List;

public class MCAPLListTermImpl implements MCAPLListTerm {
	MCAPLTerm head;
	MCAPLListTerm tail;
	
	public MCAPLListTermImpl(MCAPLTerm h) {
		head = h;
	}
	
	public MCAPLListTermImpl clone() {
		return this;
	}

	@Override
	public boolean isNumeric() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isList() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isString() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getFunctor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends MCAPLTerm> getTerms() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTermsSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isUnnamedVar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int compareTo(MCAPLTerm o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public MCAPLTerm getHead() {
		return head;
	}
	
	public MCAPLListTerm getTail() {
		return tail;
	}

	@Override
	public void addEnd(MCAPLTerm t) {
		// TODO Auto-generated method stub
		if (tail == null) {
			tail = new MCAPLListTermImpl(t);
		} else {
			tail.addEnd(t);
		}
	}
	
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
	
	public void setTail(MCAPLListTerm t) {
		tail = t;
	}


}
