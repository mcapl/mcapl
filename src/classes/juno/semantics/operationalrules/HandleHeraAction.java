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

import ail.util.AILexception;
import hera.language.FormulaString;
import juno.semantics.JunoAgent;
import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import ail.syntax.Action;

/**
 * Handle a Hera action.  
 * 
 * @author lad
 *
 */
public class HandleHeraAction implements OSRule {
	private static final String name = "Handle Hera Action";

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#getName()
	 */
	public String getName() {
		return name;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.HandleTopDeed#checkPreconditions(ail.semantics.AILAgent)
	 */
	public boolean checkPreconditions(AILAgent a) {
		if (a instanceof JunoAgent) {
			JunoAgent juno = (JunoAgent) a;
			if (juno.getAction() != null) {
				return true;
			}
		}

		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.HandleTopDeed#apply(ail.semantics.AILAgent)
	 */
	public void apply(AILAgent a) {
		/**
		 * The action to be handled
		 */
		JunoAgent juno = (JunoAgent) a;
		FormulaString s = juno.getAction();
		Action act = new Action(s.getString());
		// Empty the belief base.  This assists state matching in model checking
		// but assumes that reasoning can start afresh each cycle and does not 
		// involve any persistent beliefs.  This may be a suspect assumption in some 
		// settings.
		juno.getBB().clear();

		try {
			a.getEnv().executeAction(a.getAgName(), act);
		} catch (AILexception e) {
			
		}
		
	}
}