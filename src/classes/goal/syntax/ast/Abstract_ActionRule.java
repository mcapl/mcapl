// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
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
// License along with GOAL-AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package goal.syntax.ast;

import goal.syntax.MentalState;
import goal.syntax.ActionRule;
import gov.nasa.jpf.vm.MJIEnv;

import java.util.ArrayList;

import ail.syntax.Deed;
import ail.syntax.Guard;
import ail.syntax.Plan;
import ail.syntax.ast.Abstract_Predicate;
import ail.syntax.ast.Abstract_Deed;
import ail.syntax.ast.Abstract_Event;
import ail.syntax.ast.Abstract_GBelief;
import ail.syntax.ast.Abstract_Goal;
import ail.syntax.ast.Abstract_Guard;
import ail.syntax.ast.Abstract_Literal;
import ail.syntax.ast.Abstract_Pred;
import ail.syntax.ast.Abstract_Term;
import ail.syntax.ast.Abstract_VarTerm;
import ail.syntax.ast.Abstract_Plan;

public class Abstract_ActionRule extends Abstract_Plan {
	public Abstract_ActionRule(Abstract_MentalState ms, ArrayList<Abstract_Deed> ds) {
		setTrigger(new Abstract_Event(Abstract_Event.AILAddition, new Abstract_Goal(new Abstract_VarTerm("Any"), Abstract_Goal.achieveGoal)));
		setContextSingle(ms, ds.size());
		ArrayList<Abstract_Deed> prf = new ArrayList<Abstract_Deed>();
		setPrefix(prf);
		ArrayList<Abstract_Deed> body = ds;
		setBody(body);
	}
	
	  /**
     * Constructs a plan from a Literal.  This needs to be expanded.
     * @param l
     */
    public Abstract_ActionRule(Abstract_Literal l) {
    	if (l.getFunctor().equals("plan")) {
    		setTrigger(new Abstract_Event(Abstract_Event.AILAddition, new Abstract_Goal(new Abstract_VarTerm("Any"), Abstract_Goal.achieveGoal)));
    		Abstract_Term guard = l.getTerm(0);
    		ArrayList<Abstract_Guard> guards = new ArrayList<Abstract_Guard>();
    		guards.add(new Abstract_Guard(new Abstract_Goal(new Abstract_Literal(true, new Abstract_Pred((Abstract_Predicate) guard)), Abstract_Goal.achieveGoal)));
    		setContext(guards);
    		setPrefix(new ArrayList<Abstract_Deed>());
    		ArrayList<Abstract_Deed> deeds = new ArrayList<Abstract_Deed>();
    		Abstract_Term body = l.getTerm(2);
    		Abstract_Deed deed = new Abstract_Deed(Abstract_Deed.AILAddition, new Abstract_Goal(new Abstract_Literal(true, new Abstract_Pred((Abstract_Predicate) body)), Abstract_Goal.performGoal));
    		deeds.add(deed);
    		setBody(deeds);
    	}
    }
    
    public ActionRule toMCAPL() {
    	ArrayList<Deed> newdeed = new ArrayList<Deed>();
    	for (int i = 0; i < body.length; i++) {
    		newdeed.add(i, body[i].toMCAPL());
    	}
    	MentalState ms = new MentalState(context[context.length - 1].toMCAPL());
    	return new ActionRule(ms, newdeed);
    }
    
    public int newJPFObject(MJIEnv env) {
    	int objref = env.newObject("goal.syntax.ast.Abstract_ActionRule");
    	int bodyref = env.newObjectArray("ail.syntax.Abstract_Deed", body.length);
    	int prefixref = env.newObjectArray("ail.syntax.Abstract_Deed", prefix.length);
    	int contextref = env.newObjectArray("ail.syntax.Guard", context.length);
    	for (int index = 0; index < body.length; index++) {
			env.setReferenceArrayElement(bodyref, index, body[index].newJPFObject(env));
		}
    	for (int index = 0; index < prefix.length; index++) {
			env.setReferenceArrayElement(prefixref, index, prefix[index].newJPFObject(env));
		}
    	for (int index = 0; index < context.length; index++) {
			env.setReferenceArrayElement(contextref, index, context[index].newJPFObject(env));
		}
    	env.setReferenceField(objref, "body", bodyref);
    	env.setReferenceField(objref, "prefix", prefixref);
    	env.setReferenceField(objref, "context", contextref);
    	env.setReferenceField(objref, "event", event.newJPFObject(env));
    	return objref;
    }


}
