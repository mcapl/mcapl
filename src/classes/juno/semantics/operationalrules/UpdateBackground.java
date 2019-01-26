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
import ail.syntax.Literal;
import ail.syntax.Unifier;
import ail.util.Tuple;
import hera.language.Formula;
import hera.language.FormulaString;
import juno.semantics.JunoAgent;

/**
 * Represents a transition rule for updating the background information according to context.
 * @author louisedennis
 *
 */
public class UpdateBackground implements OSRule {
	private String name="Update Background";

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
		// juno.clearBackground();
		for (Tuple<Formula, FormulaString> bck: juno.getContextBackground()) {
			
			Iterator<Unifier> u_it = juno.believes(bck.getLeft().toAILGuard(), new Unifier());
			
			if (u_it.hasNext()) {
				juno.addBel(new Literal(bck.getRight().getString()), AILAgent.refertoself());
			} else {
				juno.delBel(new Literal(bck.getRight().getString()));
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
