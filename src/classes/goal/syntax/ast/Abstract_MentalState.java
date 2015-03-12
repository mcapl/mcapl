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

import gov.nasa.jpf.vm.ClassInfo;
import gov.nasa.jpf.vm.ClassLoaderInfo;
import gov.nasa.jpf.vm.MJIEnv;
import ail.syntax.Guard;
import ail.syntax.Term;
import ail.syntax.Predicate;
import ail.syntax.Unifier;
import ail.syntax.ast.Abstract_GBelief;
import ail.syntax.ast.Abstract_Goal;
import ail.syntax.ast.Abstract_Guard;
import ail.syntax.ast.Abstract_LogExpr;
import ail.syntax.ast.Abstract_StringTerm;
import ail.syntax.ast.Abstract_Unifier;
import ail.syntax.ast.Abstract_GLogicalFormula;
import ail.syntax.ast.Abstract_Predicate;
import ail.syntax.ast.Abstract_Term;

public class Abstract_MentalState extends Abstract_Guard {
	boolean macro = false;
	Abstract_MentalState mms;
	Abstract_Term t;
	Abstract_Predicate p;
		
	public Abstract_MentalState() {
		super();
	}
		
	/**
	 * B(me, phi)
	 * @param gb
	 */
//	public Abstract_MentalState(Abstract_GBelief gb) {
//		super(new Abstract_GBelief(gb));
//	} 
	
	public Abstract_MentalState(Abstract_GLogicalFormula lf) {
		super(lf, true);
	}
		
	public Abstract_MentalState(Abstract_GLogicalFormula lf, int i, Abstract_GLogicalFormula lf2) {
		super(lf, i, lf2);
	}
	
	public Abstract_MentalState(Abstract_MentalState macro_ms, Abstract_Term macro_lookup, Abstract_Predicate key) {
		macro = true;
		mms = macro_ms;
		t = macro_lookup;
		p = key;
	}
		
		
	public Guard toMCAPL() {
		if (!macro) {
			return super.toMCAPL();
		} else {
			Guard g = mms.toMCAPL();
			Predicate lookup = ((Abstract_Predicate) t).toMCAPL();
			Predicate key = p.toMCAPL();
			Unifier u = new Unifier();
			lookup.unifies(key, u);
			g.apply(u);
			return g;
		}
	}
	    
	public int newJPFObject(MJIEnv env) {
		int objref = env.newObject("ail.syntax.ast.Abstract_MentalState");
		env.setBooleanField(objref, "macro", macro);
		if (!macro) {
			ClassInfo ci = ClassLoaderInfo.getCurrentClassLoader().getResolvedClassInfo("ail.syntax.ast.Abstract_Guard");
			if (env.requiresClinitExecution(ci)) {
				env.repeatInvocation();
				return 0;
			}
			if (rhs != null) {
				env.setReferenceField(objref, "rhs", rhs.newJPFObject(env));
			}
			if (lhs != null) {
				env.setReferenceField(objref, "lhs", lhs.newJPFObject(env));
			}
			env.setIntField(objref, "op", op);
		} else {
			env.setReferenceField(objref, "mms", mms.newJPFObject(env));
			env.setReferenceField(objref, "p", p.newJPFObject(env));
			env.setReferenceField(objref, "t", t.newJPFObject(env));
		}
		return objref;
	}

}