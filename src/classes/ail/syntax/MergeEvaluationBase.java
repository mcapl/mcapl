package ail.syntax;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class MergeEvaluationBase implements LogicalEvaluationBase {
	EvaluationBase eb1;
	EvaluationBase eb2;
	
	public MergeEvaluationBase(EvaluationBase a, EvaluationBase b) {
		eb1 = a;
		eb2 = b;
	}

	@Override
	public Iterator<GuardAtom> getRelevant(final GuardAtom ga) {
		
		return new Iterator<GuardAtom>() {
			Iterator<GuardAtom> eb1it = eb1.getRelevant(ga);
			Iterator<GuardAtom> eb2it = eb2.getRelevant(ga);

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
			public GuardAtom next() {
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

	@Override
	public Iterator<Predicate> getRelevant(final Predicate p) {
		
		if (eb1 instanceof LogicalEvaluationBase & eb2 instanceof LogicalEvaluationBase) {
			final LogicalEvaluationBase leb1 = (LogicalEvaluationBase) eb1;
			final LogicalEvaluationBase leb2 = (LogicalEvaluationBase) eb2;
		
			return new Iterator<Predicate>() {
				Iterator<Predicate> eb1it = leb1.getRelevant(p);
				Iterator<Predicate> eb2it = leb2.getRelevant(p);

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
				public Predicate next() {
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
		
	} else {
		return Collections.<Predicate>emptyList().iterator();

	}
	}
}
