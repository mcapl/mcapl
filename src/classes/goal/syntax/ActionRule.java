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

import ail.syntax.Action;
import ail.syntax.Event;
import ail.syntax.GBelief;
import ail.syntax.Guard;
import ail.syntax.Literal;
import ail.syntax.Plan;
import ail.syntax.Goal;
import ail.syntax.Deed;
import ail.syntax.PredicatewAnnotation;
import ail.syntax.Predicate;
import ail.syntax.Term;
import ail.syntax.VarTerm;
import ail.syntax.annotation.SourceAnnotation;

/**
 * Class for GOAL Conditional Actions.  These are just plans but we
 * provide more GOAL natural constructors.
 * @author louiseadennis
 *
 */
public class ActionRule extends Plan { 
	int type = ifthen;
	
	public static int ifthen = 0;
	public static int foralldo = 1;
	public static int listalldo = 2;
	
	/**
	 * Construct a conditional action from a mental state and a goal.  This
	 * is a reactive conditional action.
	 * @param ms
	 * @param g2
	 */
	public ActionRule(Guard ms, ArrayList<Deed> ds, int type) {
		setTrigger(new Event(Event.AILAddition, new Goal(new VarTerm("Any"), Goal.achieveGoal)));
		setContextSingle(ms, ds.size());
		ArrayList<Deed> prf = new ArrayList<Deed>();
		setPrefix(prf);
		ArrayList<Deed> body = ds;
		setBody(body);
		setSource(new SourceAnnotation(new Predicate("self")));
	}
	
	  /**
     * Constructs a plan from a Literal.  This needs to be expanded.
     * @param l
     */
    public ActionRule(Literal l) {
    	if (l.getFunctor().equals("plan")) {
    		setTrigger(new Event(Event.AILAddition, new Goal(new VarTerm("Any"), Goal.achieveGoal)));
    		Term guard = l.getTerm(0);
    		ArrayList<Guard> guards = new ArrayList<Guard>();
    		guards.add(new Guard(new Goal(new Literal(true, new PredicatewAnnotation((Predicate) guard)), Goal.achieveGoal)));
    		setContext(guards);
    		setPrefix(new ArrayList<Deed>());
    		ArrayList<Deed> deeds = new ArrayList<Deed>();
    		Term body = l.getTerm(2);
    		Deed deed = new Deed(Deed.AILAddition, new Goal(new Literal(true, new PredicatewAnnotation((Predicate) body)), Goal.performGoal));
    		deeds.add(deed);
    		setBody(deeds);
    	}
    }
    
    public boolean isIfThenRule() {
    	return type == ifthen;
    }
    
    public boolean isForallDoRule() {
    	return type == foralldo;
    }

}
