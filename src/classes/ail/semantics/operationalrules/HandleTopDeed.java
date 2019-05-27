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

package ail.semantics.operationalrules;

import java.util.Iterator;

import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import ail.syntax.Intention;
import ail.syntax.Unifier;
import ail.syntax.Deed;

import gov.nasa.jpf.annotation.FilterField;

/**
 * The basics of handling the top deed on an intention's deed stack.  Made
 * abstract to force sub-classing.  This class only implements check preconditions
 * which extracts the top deed and checks that the agent believes the guard.
 * 
 * @author lad
 *
 */
public abstract class HandleTopDeed implements OSRule {
	@FilterField
	protected Intention i;
	
	@FilterField
	protected int i_id;
	
	@FilterField
	protected Unifier thetahd;
	
	@FilterField
	protected Unifier thetab;
	
	@FilterField
	protected Deed topdeed;
	
	@FilterField
	private static final String name = "Handle Top Deed";
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#getName()
	 */
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.operationalrules.OSRule#checkPreconditions(ail.semantics.AILAgent)
	 */
	public boolean checkPreconditions(AILAgent a) {
		i  = a.getIntention();
		if (i != null) {
			i_id = i.getID();
		}

		if (i != null && (! i.deeds().isEmpty())) {
			thetahd = i.hdU();
			Iterator<Unifier> ui = a.believes(i.hdG(), thetahd);
			
			if (ui.hasNext()) {
				thetab = ui.next();
	
				topdeed = i.hdD().clone();
				topdeed.apply(thetab);
 				return true;
			}
		}
		
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.OSRule#apply(ail.semantics.AILAgent)
	 */
	public abstract void apply(AILAgent a); 
}