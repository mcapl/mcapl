// ----------------------------------------------------------------------------
// Copyright (C) 2013 Louise A. Dennis, Michael Fisher
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

/**
 * An Evaluation Base is a set of ground terms - typically a belief base or a goal base, against which some logical
 * formula can be evaluated.
 * @author lad
 *
 */
public interface EvaluationBase<K extends Unifiable> {

	/**
	 * An iterator of all objects within the evaluation base that may be unifiable with ga.  This potentially allows some pre-filtering of 
	 * elements for efficiency.
	 * @param ga
	 * @return
	 */
	public Iterator<K> getRelevant(EBCompare<K> ga, AILAgent.SelectionOrder so);
}
