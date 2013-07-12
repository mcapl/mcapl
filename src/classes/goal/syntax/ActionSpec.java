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
import ail.syntax.annotation.SourceAnnotation;

/**
 * Class for GOAL Capabilities/Action Specifications.  Capabilities are, in fact 
 * plans but we provide customised
 * constructors to make them more natural from a GOAL perspective.
 * @author louiseadennis
 *
 */
public class ActionSpec extends Plan { 
	/**
	 * Create a capability from a Goal (the capability), a mental states
	 * (the precondition) and a list of deeds (the effects).
	 * 
	 * @param g
	 * @param gs
	 * @param ds
	 */
	public ActionSpec(Goal g, MentalState ms, ArrayList<Deed> ds) {
		setTrigger(new Event(Event.AILAddition, g));
		setContextSingle(ms, ds.size());
		ArrayList<Deed> prf = new ArrayList<Deed>();
		prf.add(new Deed(Deed.Dnpy));
		setPrefix(prf);
		setBody(ds);
		setSource(new SourceAnnotation(new Predicate("self")));
	}
	
	/**
	 * Create a capability from a goal and a deed list (effects).  Assumes that the
	 * precondition is simply T.
	 * @param g
	 * @param ds
	 */
	public ActionSpec(Goal g, ArrayList<Deed> ds) {
		setTrigger(new Event(Event.AILAddition, new Goal(new VarTerm("Any"), Goal.achieveGoal)));
		ArrayList<Guard> gs2 = new ArrayList<Guard>(ds.size());
		for (int i = 0; i < ds.size(); i++) {
			gs2.add(i, new MentalState(new GBelief(GBelief.GTrue)));
		}
		setContext(gs2);
		ArrayList<Deed> prf = new ArrayList<Deed>();
		prf.add(new Deed(Deed.AILAddition, g));
		setPrefix(prf);
		setBody(ds);
		setSource(new SourceAnnotation(new Predicate("self")));
	}

}
