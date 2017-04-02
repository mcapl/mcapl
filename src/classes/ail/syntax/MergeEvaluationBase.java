// ----------------------------------------------------------------------------
// Copyright (C) 2014 Louise A. Dennis, Michael Fisher
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
//----------------------------------------------------------------------------
package ail.syntax;

import java.util.Iterator;

import ail.semantics.AILAgent;
import ail.util.Tuple;

/**
 * An Evaluation Base composed of two other evaluation bases.
 * @author louiseadennis
 *
 * @param <K>
 */
public class MergeEvaluationBase<K extends Unifiable> implements EvaluationBasewNames<K> {
	EvaluationBasewNames<K> eb1;
	EvaluationBasewNames<K> eb2;
	
	public MergeEvaluationBase(EvaluationBasewNames<K> a, EvaluationBasewNames<K> b) {
		eb1 = a;
		eb2 = b;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.EvaluationBasewNames#getRelevantTuple(ail.syntax.Unifiable)
	 */
	public Iterator<Tuple<K, String>> getRelevantTuple(final EBCompare<K> p, AILAgent.SelectionOrder so) {
		
		return new Iterator<Tuple<K, String>>() {
				Iterator<Tuple<K, String>> eb1it = eb1.getRelevantTuple(p, so);
				Iterator<Tuple<K, String>> eb2it = eb2.getRelevantTuple(p, so);

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
				}
		
		};
		
	} 
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.EvaluationBase#getRelevant(ail.syntax.Unifiable)
	 */
	public Iterator<K> getRelevant(final EBCompare<K> p, AILAgent.SelectionOrder so) {
		
		return new Iterator<K>() {
				Iterator<K> eb1it = eb1.getRelevant(p, so);
				Iterator<K> eb2it = eb2.getRelevant(p, so);

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
				}
			
		};
		
	} 

	
}
