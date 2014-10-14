// ----------------------------------------------------------------------------
// Copyright (C) 2014 Louise A. Dennis, and  Michael Fisher 
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
// License along with the AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------
package ail.syntax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.HashMap;

/**
 * A Library of an agent's capabilities.
 * @author lad
 *
 */
public class CapabilityLibrary implements EvaluationBase<Capability> {
	HashMap<PredicateIndicator, ArrayList<Capability>> capMap = new HashMap<PredicateIndicator, ArrayList<Capability>>();

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.EvaluationBase#getRelevant(ail.syntax.EBCompare)
	 */
	public Iterator<Capability> getRelevant(EBCompare<Capability> ga) {
		Capability c = ((GCapability) ga).getCap();
		Predicate cPred = c.getCap();
		return getRelevant(cPred);
	}
	
	/**
	 * Get the capabilities relevent to some predicate - assumed to be the action.
	 * @param cPred
	 * @return
	 */
	public Iterator<Capability> getRelevant(Predicate cPred) {
		if (cPred.isVar()) {
			ArrayList<Capability> out = new ArrayList<Capability>();
			for (ArrayList<Capability> cl: capMap.values()) {
				out.addAll(cl);
			}
			return out.iterator();
		} else {
			ArrayList<Capability> cList = capMap.get(cPred.getPredicateIndicator());
            if (cList != null) {
                 return cList.iterator();
           } else {
                return Collections.<Capability>emptyList().iterator();
            }
        }
		
	}
	
	/**
	 * An iterator over all the capabilities in the library.
	 * @return
	 */
	public Iterator<Capability> iterator() {
		ArrayList<Capability> cs = new ArrayList<Capability>();
		
		for (ArrayList<Capability> cl: capMap.values()) {
			cs.addAll(cl);
		}
		
		return cs.iterator();

	}
	
	/**
	 * Add a capability to the library.
	 * @param c
	 */
	public void add(Capability c) {
		PredicateIndicator pi = c.getCap().getPredicateIndicator();
		if (capMap.containsKey(pi)) {
			capMap.get(pi).add(c);
		} else {
			ArrayList<Capability> cl = new ArrayList<Capability>();
			cl.add(c);
			capMap.put(pi, cl);
		}
	}

}
