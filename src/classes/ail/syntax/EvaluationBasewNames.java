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
 * An Evaluation Base indexed with a Name, or containing several sub evaluation bases indexed with names.
 * @author louiseadennis
 *
 * @param <K>
 */
public interface EvaluationBasewNames<K extends Unifiable> extends EvaluationBase<K> {
	public Iterator<Tuple<K, String>> getRelevantTuple(EBCompare<K> ga, AILAgent.SelectionOrder so);
}
