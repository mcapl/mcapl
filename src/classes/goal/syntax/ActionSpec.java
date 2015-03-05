// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
// 
// This file is part of GOAL (AIL version) - GOAL-AIL
//
// GOAL-AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// GOAL-AIL is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with GOAL-AIL if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
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
	
	public ActionSpec(Capability c) {
		super(c.getPre(), c.getCap(), c.getPost());
	};
	
}
