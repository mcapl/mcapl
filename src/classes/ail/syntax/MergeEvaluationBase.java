package ail.syntax;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class MergeEvaluationBase<K extends Unifiable> implements EvaluationBase<K> {
	EvaluationBase<K> eb1;
	EvaluationBase<K> eb2;
	
	public MergeEvaluationBase(EvaluationBase<K> a, EvaluationBase<K> b) {
		eb1 = a;
		eb2 = b;
	}

//	@Override
/*	public Iterator<K> getRelevant(final GuardAtom<K> ga) {
		
		return new Iterator<K>() {
			Iterator<K> eb1it = eb1.getRelevant(ga);
			Iterator<K> eb2it = eb2.getRelevant(ga);

			/*
			 * (non-Javadoc)
			 * @see java.util.Iterator#hasNext()
			 */
	/*		public boolean hasNext() {
				if (eb1it.hasNext()) {
					return true;
				}
			
				return eb2it.hasNext();
			} */
		
			/*
			 * (non-Javadoc)
			 * @see java.util.Iterator#next()
			 */
	/*		public K next() {
				if (eb1it.hasNext()) {
					return eb1it.next();
				} else {
					return eb2it.next();
				}
			
			} */
		
			/*
			 * (non-Javadoc)
			 * @see java.util.Iterator#remove()
			 */
	/*		public void remove() {
			// TODO Auto-generated method stub
			
			}

		
	};
	} */

	@Override
	public Iterator<K> getRelevant(final K p) {
		
		return new Iterator<K>() {
				Iterator<K> eb1it = eb1.getRelevant(p);
				Iterator<K> eb2it = eb2.getRelevant(p);

				/*
				 * (non-Javadoc)
				 * @see java.util.Iterator#hasNext()
				 */
				public boolean hasNext() {
					if (eb1it.hasNext()) {
						return true;
					}
				
					return eb2it.hasNext();
				}
			
				/*
				 * (non-Javadoc)
				 * @see java.util.Iterator#next()
				 */
				public K next() {
					if (eb1it.hasNext()) {
						return eb1it.next();
					} else {
						return eb2it.next();
					}
				
				}
			
				/*
				 * (non-Javadoc)
				 * @see java.util.Iterator#remove()
				 */
				public void remove() {
				// TODO Auto-generated method stub
				
				}

			
		};
		
	} 
	
}
