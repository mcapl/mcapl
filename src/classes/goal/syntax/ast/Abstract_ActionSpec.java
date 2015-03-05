// ----------------------------------------------------------------------------
// Copyright (C) 2015 Louise A. Dennis, and  Michael Fisher 
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
	/**
	 * Create a capability from a Goal (the capability), a mental states
	 * (the precondition) and a list of deeds (the effects).
	 * 
	 * @param g
	 * @param gs
	 * @param ds
	 */
	public Abstract_ActionSpec(Abstract_Deed g, Abstract_MentalAtom ms, Abstract_LogicalFormula lf) {
		super((Abstract_Predicate) g.getContent());
		addPre(ms);
		addPost(new Abstract_MentalAtom(lf, Abstract_BaseAILStructure.AILBel));
	}
	
    public ActionSpec toMCAPL() {
    	Capability c = super.toMCAPL();
    	return new ActionSpec(c);
    }
    
    public int newJPFObject(MJIEnv env) {
    	int objref = env.newObject("goal.syntax.ast.Abstract_ActionSpec");
		env.setReferenceField(objref, "cap", getCap().newJPFObject(env));
		env.setReferenceField(objref, "pre", getPre().newJPFObject(env));
		env.setReferenceField(objref, "post", getPost().newJPFObject(env));
    	return objref;
    }



}
