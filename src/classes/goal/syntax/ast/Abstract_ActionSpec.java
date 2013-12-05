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


import goal.syntax.ActionSpec;
import goal.syntax.MentalState;
import gov.nasa.jpf.vm.MJIEnv;

import java.util.ArrayList;

import ail.syntax.Deed;
import ail.syntax.Goal;
import ail.syntax.ast.Abstract_Event;
import ail.syntax.ast.Abstract_Plan;
import ail.syntax.ast.Abstract_Goal;
import ail.syntax.ast.Abstract_Deed;
import ail.syntax.ast.Abstract_GBelief;
import ail.syntax.ast.Abstract_Guard;
import ail.syntax.ast.Abstract_VarTerm;
import ail.syntax.ast.Abstract_LogExpr;
import ail.syntax.ast.Abstract_LogicalFormula;

/**
 * Class for GOAL Capabilities/Action Specifications.  Capabilities are, in fact 
 * plans but we provide customised
 * constructors to make them more natural from a GOAL perspective.
 * @author louiseadennis
 *
 */
public class Abstract_ActionSpec extends Abstract_Plan { 
	/**
	 * Create a capability from a Goal (the capability), a mental states
	 * (the precondition) and a list of deeds (the effects).
	 * 
	 * @param g
	 * @param gs
	 * @param ds
	 */
	public Abstract_ActionSpec(Abstract_Goal g, Abstract_MentalState ms, ArrayList<Abstract_Deed> ds) {
		setTrigger(new Abstract_Event(Abstract_Event.AILAddition, g));
		setContextSingle(ms, ds.size());
		ArrayList<Abstract_Deed> prf = new ArrayList<Abstract_Deed>();
		prf.add(new Abstract_Deed(Abstract_Deed.Dnpy));
		setPrefix(prf);
		setBody(ds);
	}
	
	/**
	 * Create a capability from a Goal (the capability), a mental states
	 * (the precondition) and a list of deeds (the effects).
	 * 
	 * @param g
	 * @param gs
	 * @param ds
	 */
	public Abstract_ActionSpec(Abstract_Goal g, Abstract_Guard ms, ArrayList<Abstract_Deed> ds) {
		setTrigger(new Abstract_Event(Abstract_Event.AILAddition, g));
		setContextSingle(ms, ds.size());
		ArrayList<Abstract_Deed> prf = new ArrayList<Abstract_Deed>();
		prf.add(new Abstract_Deed(Abstract_Deed.Dnpy));
		setPrefix(prf);
		setBody(ds);
	}
	
	public Abstract_ActionSpec(Abstract_Goal g, Abstract_Guard ms, Abstract_LogicalFormula lf) {
		
	}

	/**
	 * Create a capability from a goal and a deed list (effects).  Assumes that the
	 * precondition is simply T.
	 * @param g
	 * @param ds
	 */
	public Abstract_ActionSpec(Abstract_Goal g, ArrayList<Abstract_Deed> ds) {
		setTrigger(new Abstract_Event(Abstract_Event.AILAddition, new Abstract_Goal(new Abstract_VarTerm("Any"), Abstract_Goal.achieveGoal)));
		ArrayList<Abstract_Guard> gs2 = new ArrayList<Abstract_Guard>(ds.size());
		for (int i = 0; i < ds.size(); i++) {
			gs2.add(i, new Abstract_MentalState(new Abstract_GBelief(Abstract_GBelief.GTrue)));
		}
		setContext(gs2);
		ArrayList<Abstract_Deed> prf = new ArrayList<Abstract_Deed>();
		prf.add(new Abstract_Deed(Abstract_Deed.AILAddition, g));
		setPrefix(prf);
		setBody(ds);
	}
	
    public ActionSpec toMCAPL() {
    	ArrayList<Deed> newdeed = new ArrayList<Deed>();
    	for (int i = 0; i < body.length; i++) {
    		newdeed.add(i, body[i].toMCAPL());
    	}
    	MentalState ms = new MentalState(context[context.length - 1].toMCAPL());
    	return new ActionSpec((Goal) (event.getContent().toMCAPL()), ms, newdeed);
    }
    
    public int newJPFObject(MJIEnv env) {
    	int objref = env.newObject("goal.syntax.ast.Abstract_ActionSpec");
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
