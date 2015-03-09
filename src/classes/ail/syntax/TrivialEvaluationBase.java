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
import java.util.Collections;

import ail.semantics.AILAgent;
import ail.util.Tuple;

/**
 * Creates a trivial (i.e., empty) named evaluation base.
 * @author louiseadennis
 *
 * @param <K>
 */
public class TrivialEvaluationBase<K extends Unifiable> implements EvaluationBasewNames<K> {

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.EvaluationBase#getRelevant(ail.syntax.EBCompare)
	 */
	public Iterator<K> getRelevant(EBCompare<K> ga, AILAgent.SelectionOrder so) {
		return Collections.<K>emptyList().iterator();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.EvaluationBasewNames#getRelevantTuple(ail.syntax.EBCompare)
	 */
	public Iterator<Tuple<K, String>> getRelevantTuple(EBCompare<K> ga, AILAgent.SelectionOrder so) {
		return Collections.<Tuple<K, String>>emptyList().iterator();
	}



}
