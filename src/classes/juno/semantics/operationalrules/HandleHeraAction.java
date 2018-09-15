// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
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

package juno.semantics.operationalrules;

import ail.util.AILexception;
import hera.language.FormulaString;
import juno.semantics.JunoAgent;
import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import ail.syntax.Unifier;
import ail.syntax.Action;
import ail.syntax.Deed;

/**
 * Handle an action.  Calls immediately executeAction in the environment.
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
		// System.err.println(juno.toString());

		try {
			// System.err.println("Hera doing " + act);
			a.getEnv().executeAction(a.getAgName(), act);
			// System.err.println(juno.toString());
		} catch (AILexception e) {
			
		}
		
	}
}