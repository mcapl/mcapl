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

import ail.syntax.AILAnnotation;
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
import ail.syntax.Unifier;
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
		// this.type = type;
	}
	
	public ActionRule(ArrayList<Guard> ms, ArrayList<Deed> ds, int type) {
		setTrigger(new Event(Event.AILAddition, new Goal(new VarTerm("Any"), Goal.achieveGoal)));
		setContext(ms);
		ArrayList<Deed> prf = new ArrayList<Deed>();
		setPrefix(prf);
		ArrayList<Deed> body = ds;
		setBody(body);
		setSource(new SourceAnnotation(new Predicate("self")));
		this.type = type;
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
    
    public void resetModuleCalls() {
    	for (Deed d: getBody()) {
    		if (d.getCategory() == Deed.DAction && d.getContent() instanceof ModuleCallAction) {
    			((ModuleCallAction) d.getContent()).resetModuleCall();
    		}
    	}
    }
    
    @Override
    public Object clone() {
    	ArrayList<Guard> gs = new ArrayList<Guard>();
    	for (Guard g: this.getContext()) {
    		gs.add(g.clone());
    	}
    	
    	ArrayList<Deed> ds = new ArrayList<Deed>();
    	for (Deed d: this.getBody()) {
    		ds.add(d.clone());
    	}
    	ActionRule p = new ActionRule(gs, ds, this.type);
        if (annotation != null) {
            p.setAnnotation((AILAnnotation) annotation.clone());
        }
         p.setID(getID());
        p.setLibID(getLibID());
        return p;
    }
    
    @Override
    public boolean apply(Unifier u) {
    	return super.apply(u);
    }

}
