// ----------------------------------------------------------------------------
// Copyright (C) 2018 Louise A. Dennis, Felix Lindner, Martin Moze Bentzen, Michael Fisher
//
// This file is part of Juno
//
// Juno is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Juno is distributed in the hope that it will be useful,
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
package juno.semantics.operationalrules;

import java.util.Iterator;

import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import ail.syntax.Unifier;
import ajpf.util.VerifyMap;
import hera.language.Formula;
import juno.semantics.JunoAgent;

/**
 * Transition for updating the utilities.
 * @author louisedennis
 *
 */
public class UpdateUtilities implements OSRule {
	private String name="Update Utilities";

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.OSRule#checkPreconditions(ail.semantics.AILAgent)
	 */
	@Override
	public boolean checkPreconditions(AILAgent a) {
		if (a instanceof JunoAgent) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.OSRule#apply(ail.semantics.AILAgent)
	 */
	@Override
	public void apply(AILAgent a) {
		JunoAgent juno = (JunoAgent) a;
		juno.setUtilities(juno.defaultUtilities());
		for (Formula f: juno.getContextUtilities().keySet()) {
			
			Iterator<Unifier> u_it = juno.believes(f.toAILGuard(), new Unifier());
			
			if (u_it.hasNext()) {
				VerifyMap<String, Double> new_utilities = juno.getContextUtilities().get(f);
				
				for (String s: new_utilities.keySet()) {
					juno.setUtility(s, new_utilities.get(s));
				}
				
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.OSRule#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

}
