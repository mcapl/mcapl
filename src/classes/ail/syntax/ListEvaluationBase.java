// ----------------------------------------------------------------------------
// Copyright (C) 2013 Louise A. Dennis, Michael Fisher
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
import java.util.List;
import java.util.ArrayList;

import ail.syntax.Unifiable;

/**
 * This is an evaluation base constructed from a list of items with no particular optimisation for lookups.
 * The class provides a simple way to create an Evaluation Base.
 *
 * @author lad
 *
 */
public class ListEvaluationBase<K extends Unifiable> implements EvaluationBase<K> {
	List<K> list;
	
	public ListEvaluationBase(List<K> l) {
		list = l;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.EvaluationBase#getRelevant(ail.syntax.GuardAtom)
	 */
	public Iterator<K> getRelevant(K ga) {
		return list.iterator();
	}

	@Override
	public Iterator<K> getRelevant(GuardAtom<K> ga) {
		// TODO Auto-generated method stub
		return list.iterator();
	}


}
