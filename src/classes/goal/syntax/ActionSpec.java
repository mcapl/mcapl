// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis, Michael Fisher, and Koen Hindriks
// 
// This file is part of AIL GOAL.  An AIL Implementation of the GOAL Programming
// Language
//
// AIL GOAL is free software: you can redistribute it and/or modify it under
// the terms of the GNU General Public License as published by the Free Software
// Foundation, either version 3 of the License, or (at your option) any later
// version.
//
// AIL GOAL is distributed in the hope that it will be useful, but WITHOUT
// ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
// FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
// details.
//
// You should have received a copy of the GNU General Public License along with
// this program. If not, see <http://www.gnu.org/licenses/>.
//
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package goal.syntax;


import java.util.ArrayList;

import ail.syntax.Event;
import ail.syntax.Plan;
import ail.syntax.Goal;
import ail.syntax.Deed;
import ail.syntax.GBelief;
import ail.syntax.Guard;
import ail.syntax.Predicate;
import ail.syntax.VarTerm;
import ail.syntax.Capability;
import ail.syntax.annotation.SourceAnnotation;

/**
 * Class for GOAL Capabilities/Action Specifications.  Capabilities are, in fact 
 * plans but we provide customised
 * constructors to make them more natural from a GOAL perspective.
 * @author louiseadennis
 *
 */
public class ActionSpec extends Capability { 
	boolean internal;
	
	public ActionSpec(Capability c, boolean internal) {
		super(c.getPre(), c.getCap(), c.getPost());
		this.internal = internal;
	};
	
	public boolean isInternalAction() {
		return internal;
	}
	
	public ActionSpec clone() {
		return new ActionSpec(super.clone(), internal);
	}
	
}
