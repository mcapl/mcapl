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

import java.util.ArrayList;
import java.util.HashSet;

import gov.nasa.jpf.vm.ClassInfo;
import gov.nasa.jpf.vm.ClassLoaderInfo;
import gov.nasa.jpf.vm.MJIEnv;
import ail.syntax.GBelief;
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
import ail.syntax.ast.Abstract_VarTerm;

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
		
	public Abstract_MentalState(int i, Abstract_GLogicalFormula lf) {
		super(i, lf);
	}

	public Abstract_MentalState(Abstract_GLogicalFormula lf, int i, Abstract_GLogicalFormula lf2) {
		super(lf, i, lf2);
	}
	
	/**
	 * 
	 * @param macro_ms - is the macro content as it appears in the definition.
	 * @param macro_lookup - is the macro lookup as it appears in the definition.
	 * @param key - is the current lookup used in this mental state condition.
	 */
	public Abstract_MentalState(Abstract_MentalState macro_ms, Abstract_Term macro_lookup, Abstract_Predicate key) {
		// Dealt with in toMCAPL
		macro = true;
		mms = macro_ms;
		t = macro_lookup;
		p = key;
	}
	
	/**
	 * 
	 * @param v is a list to be created by all instantiations of lf in the current context.
	 * @param lf
	 */
	public Abstract_MentalState(Abstract_VarTerm v, Abstract_MentalState lf) {
		super(Abstract_Guard.none, new Abstract_ListAll(v, lf));
	}
		
		
	public Guard toMCAPL() {
		if (!macro) {
			return super.toMCAPL();
		} else {
			Guard g = mms.toMCAPL();
			Predicate lookup = ((Abstract_Predicate) t).toMCAPL();
			Predicate key = p.toMCAPL();
			unificationProcess(lookup, key, g);
			return g;
		}
	}
	
	public static void unificationProcess(Predicate lookup, Predicate key, Guard g) {
		Unifier u = new Unifier();
		u.varsNotClusters();
		GBelief gkey = new GBelief(key);
		GBelief glookup = new GBelief(lookup);
		Guard gtmp = new Guard(g, Guard.GLogicalOp.and, glookup);
		gtmp.standardise_apart(gkey, u, new HashSet<String>());
		glookup.unifies(gkey, u);
		g.apply(u);
	}
	    
	public int newJPFObject(MJIEnv env) {
		int objref = env.newObject("goal.syntax.ast.Abstract_MentalState");
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
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_Guard#toString()
	 */
	@Override
	public String toString() {
		if (macro == false) {
			return super.toString();
		} else {
			return p.toString();
		}
	}
	
	public boolean isMacro() {
		return macro;
	}
	
	public Abstract_Predicate getKey() {
		return p;
	}

}
