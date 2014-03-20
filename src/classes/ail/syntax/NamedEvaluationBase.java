// ----------------------------------------------------------------------------
// Copyright (C) 2014 Louise A. Dennis, Michael Fisher
//
// This file is part of the Engineering Autonomous Space Software (EASS) Library.
// 
// The EASS Library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The EASS Library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the EASS Library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------
package ail.syntax;

import java.util.Iterator;

import ail.util.Tuple;

/**
 * An Evaluation base with a name allowing it to be referred to.
 * @author louiseadennis
 *
 * @param <K>
 */
public class NamedEvaluationBase<K extends Unifiable> implements EvaluationBasewNames<K> {
	String name;
	EvaluationBase<K> eb;
	
	public NamedEvaluationBase(EvaluationBase<K> e, String s) {
		name = s;
		eb = e;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.EvaluationBase#getRelevant(ail.syntax.Unifiable)
	 */
	public Iterator<K> getRelevant(K ga) {
		return eb.getRelevant(ga);
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.EvaluationBasewNames#getRelevantTuple(ail.syntax.Unifiable)
	 */
	public Iterator<Tuple<K, String>> getRelevantTuple(K ga) {
		final Iterator<K> ebl = eb.getRelevant(ga);
		
		return new Iterator<Tuple<K, String>>() {

			/*
			 * (non-Javadoc)
			 * @see java.util.Iterator#hasNext()
			 */
			public boolean hasNext() {
				return ebl.hasNext();
			}

			/*
			 * (non-Javadoc)
			 * @see java.util.Iterator#next()
			 */
			public Tuple<K, String> next() {
				return new Tuple<K, String>(ebl.next(), name);
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
