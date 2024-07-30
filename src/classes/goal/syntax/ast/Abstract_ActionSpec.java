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

package goal.syntax.ast;


import goal.syntax.ActionSpec;
import gov.nasa.jpf.vm.MJIEnv;

import java.util.ArrayList;

import ail.syntax.Deed;
import ail.syntax.Goal;
import ail.syntax.Capability;
import ail.syntax.ast.Abstract_Event;
import ail.syntax.ast.Abstract_Capability;
import ail.syntax.ast.Abstract_Action;
import ail.syntax.ast.Abstract_Deed;
import ail.syntax.ast.Abstract_GBelief;
import ail.syntax.ast.Abstract_Guard;
import ail.syntax.ast.Abstract_VarTerm;
import ail.syntax.ast.Abstract_LogExpr;
import ail.syntax.ast.Abstract_LogicalFormula;
import ail.syntax.ast.Abstract_Predicate;
import ail.syntax.ast.Abstract_Literal;
import ail.syntax.ast.Abstract_Pred;
import ail.syntax.ast.Abstract_BaseAILStructure;

/**
 * Class for GOAL Capabilities/Action Specifications.  Capabilities are, in fact 
 * plans but we provide customised
 * constructors to make them more natural from a GOAL perspective.
 * @author louiseadennis
 *
 */
public class Abstract_ActionSpec extends Abstract_Capability { 
	boolean internal = false;
	/**
	 * Create a capability from a Goal (the capability), a mental states
	 * (the precondition) and a list of deeds (the effects).
	 * 
	 * @param g
	 */
	public Abstract_ActionSpec(Abstract_Deed g, Abstract_MentalAtom ms, Abstract_LogicalFormula lf) {
		super((Abstract_Predicate) g.getContent());
		addPre(ms);
		addPost(new Abstract_MentalAtom(lf, Abstract_BaseAILStructure.AILBel));
	}
	
	public Abstract_ActionSpec(Abstract_Predicate p, Abstract_LogicalFormula pre, Abstract_LogicalFormula pos, boolean internal) {
		super(p);
		addPre(new Abstract_MentalAtom(pre, Abstract_BaseAILStructure.AILBel));
		addPost(new Abstract_MentalAtom(pos, Abstract_BaseAILStructure.AILBel));
		this.internal = internal;
	}
	
    public ActionSpec toMCAPL() {
    	Capability c = super.toMCAPL();
    	return new ActionSpec(c, internal);
    }
    
    public int newJPFObject(MJIEnv env) {
    	int objref = env.newObject("goal.syntax.ast.Abstract_ActionSpec");
		env.setReferenceField(objref, "cap", getCap().newJPFObject(env));
		env.setReferenceField(objref, "pre", getPre().newJPFObject(env));
		env.setReferenceField(objref, "post", getPost().newJPFObject(env));
		env.setBooleanField(objref, "internal", internal);
    	return objref;
    }



}
