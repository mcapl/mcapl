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
 * An Evaluation base with a name allowing it to be referred to - this can be used
 * for instance when an agent has several belief of goal bases and sometimes you want
 * to refer to the specific goal base when checking if something is true of the agent.
 * @author louiseadennis
 *
 * @param <K>
 */
public class NamedEvaluationBase<K extends Unifiable> implements EvaluationBasewNames<K> {
	String name;
	EvaluationBase<K> eb;
	
	/**
	 * Constructor.  The Named evaluation base consists of the evaluation base and a string.
	 * @param e
	 * @param s
	 */
	public NamedEvaluationBase(EvaluationBase<K> e, String s) {
		name = s;
		eb = e;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.EvaluationBase#getRelevant(ail.syntax.Unifiable)
	 */
	@Override
	public Iterator<K> getRelevant(EBCompare<K> ga, AILAgent.SelectionOrder so) {
		return eb.getRelevant(ga, so);
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.EvaluationBasewNames#getRelevantTuple(ail.syntax.Unifiable)
	 */
	@Override
	public Iterator<Tuple<K, String>> getRelevantTuple(EBCompare<K> ga, AILAgent.SelectionOrder so) {
		final Iterator<K> ebl = eb.getRelevant(ga, so);
		
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
