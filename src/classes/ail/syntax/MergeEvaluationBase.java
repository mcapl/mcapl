package ail.syntax;

import java.util.Iterator;

public class MergeEvaluationBase implements EvaluationBase {
	EvaluationBase eb1;
	EvaluationBase eb2;
	
	public MergeEvaluationBase(EvaluationBase a, EvaluationBase b) {
		eb1 = a;
		eb2 = b;
	}

	@Override
	public Iterator<Unifiable> getRelevant(final GuardAtom ga) {
		
		return new Iterator<Unifiable>() {
			Iterator<Unifiable> eb1it = eb1.getRelevant(ga);
			Iterator<Unifiable> eb2it = eb2.getRelevant(ga);

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
			public Unifiable next() {
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
