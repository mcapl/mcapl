package ail.syntax;

import gov.nasa.jpf.annotation.FilterField;

import java.util.Iterator;

public class EvaluationBaseIterator implements Iterator<Unifier> {
	EvaluationBase eb;
	Unifier un;
	GuardAtom ga;
	Iterator<GuardAtom> il;
	
 	/**
   	 * This holds the current unification solution.
   	 */
	@FilterField
	Unifier current = null;

	public EvaluationBaseIterator(EvaluationBase e, Unifier u, GuardAtom g) {
		eb = e;
		un = u;
		ga = g;
		il = eb.getRelevant(ga);
	}
	           
	/*
	 * (non-Javadoc)
	 * @see java.util.Iterator#hasNext()
	 */
	public boolean hasNext() {
		if (current == null)
			get();
		return current != null;
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Iterator#next()
	 */
	public Unifier next() {
		if (current == null)
			get();
		Unifier a = current;
		current = null; //get();
		return a;
	}

   	/**
   	 * Work horse method that calculate the next unifier.
   	 *
   	 */
   	private void get() {
   		current = null;
   		// il is all possible Beliefs/messages/whatever that potentially unify with this GBelief
   		if (il != null) {
   			while (il.hasNext()) {
   				Unifier unC = (Unifier) un.clone();
   				Unifiable u = il.next();
   				Unifiable h2 = ga.clone();
   				if (h2.unifies(u, unC)) {
      					return;
   				}
   			}
   		}
   	}

   	/*
   	 * (non-Javadoc)
   	 * @see java.util.Iterator#remove()
   	 */
   	public void remove() {
   	}
}
