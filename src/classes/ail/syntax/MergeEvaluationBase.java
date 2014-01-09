package ail.syntax;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

import ail.util.Tuple;

public class MergeEvaluationBase<K extends Unifiable> implements EvaluationBasewNames<K> {
	EvaluationBasewNames<K> eb1;
	EvaluationBasewNames<K> eb2;
	
	public MergeEvaluationBase(EvaluationBasewNames<K> a, EvaluationBasewNames<K> b) {
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
	public Iterator<Tuple<K, String>> getRelevantTuple(final K p) {
		
		return new Iterator<Tuple<K, String>>() {
				Iterator<Tuple<K, String>> eb1it = eb1.getRelevantTuple(p);
				Iterator<Tuple<K, String>> eb2it = eb2.getRelevantTuple(p);

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
				public Tuple<K, String> next() {
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
