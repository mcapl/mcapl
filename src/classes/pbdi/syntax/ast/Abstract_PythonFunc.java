// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis and Michael Fisher
//
// This file is part of the Python BDI Agent Model (PBDI) Library.
// 
// The PBDI Library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The EASS Library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the EASS Library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------
package pbdi.syntax.ast;

import java.util.ArrayList;

import ail.syntax.Deed;
import ail.syntax.Event;
import ail.syntax.Goal;
import ail.syntax.Guard;
import ail.syntax.Plan;
import ail.syntax.Predicate;
import ail.syntax.VarTerm;
import ail.syntax.ast.Abstract_GBelief;
import ail.syntax.ast.Abstract_GLogicalFormula;
import ail.syntax.ast.Abstract_Guard;
import ail.syntax.ast.Abstract_Term;
import ail.syntax.ast.Abstract_VarTerm;
import gov.nasa.jpf.vm.MJIEnv;

public class Abstract_PythonFunc {
	String name;
	Abstract_PythonS[] statements = new Abstract_PythonS[0];
	String[] parameters = new String[0];
	
	public Abstract_PythonFunc(String name) {
		if (name.substring(0, 4).equals("self.")) {
			this.name = name;
		} else {
			this.name = "self." + name;
		}
	}
	
	public void addParameter(String s) {
		int newsize = parameters.length + 1;
		String[] new_parameters = new String[newsize];
		for (int i = 0; i < parameters.length; i++ ) {
			new_parameters[i] = parameters[i];
		}
		new_parameters[parameters.length] = s;
		parameters = new_parameters;
	}
	
	public void addStatement(Abstract_PythonS s) {
		int newsize = statements.length + 1;
		Abstract_PythonS[] newstmts = new Abstract_PythonS[newsize];
		for (int i = 0; i < statements.length; i++) {
			newstmts[i] = statements[i];
		}
		newstmts[statements.length] = s;
		statements = newstmts;
	}
	
	public String getName() {
		return name;
	}
	
	public Plan toPlan(Guard g) {
		Plan p = new Plan();
		p.setTrigger(new Event(Event.AILAddition, new Goal(new VarTerm("Any"), Goal.achieveGoal)));
		ArrayList<Deed> deeds = new ArrayList<Deed>();
		int j = statements.length;
		int k = j - 1;
		for (int i = k ; i >  -1; i--) {
			if (! statements[i].getString().equals("return\n")) {
				Deed d = statements[i].getDeed().toMCAPL();				
				deeds.add(statements[i].getDeed().toMCAPL());
			}
		}
		p.setContextSingle(g, deeds.size());
		p.setPrefix(new ArrayList<Deed>());
		p.setBody(deeds);
		return p;
	}
	
	public Plan toPlan(Guard g, Abstract_VarTerm v) {
		Plan p = new Plan();
		p.setTrigger(new Event(Event.AILAddition, new Goal(new VarTerm("Any"), Goal.achieveGoal)));
		ArrayList<Deed> deeds = new ArrayList<Deed>();
		int j = statements.length;
		int k = j - 1;
		for (int i = k ; i >  -1; i--) {
			if (! statements[i].getString().equals("return\n")) {
				Deed d = statements[i].getDeed().toMCAPL();		
				Deed new_deed = (Deed) d.substitute(new Predicate(parameters[1]), v.toMCAPL());
				deeds.add(new_deed);
			}
		}
		p.setContextSingle(g, deeds.size());
		p.setPrefix(new ArrayList<Deed>());
		p.setBody(deeds);
		return p;
	}

	
	private Abstract_GBelief find_bel_in_form(Abstract_GLogicalFormula form) {
		if (form instanceof Abstract_GBelief) {
			return (Abstract_GBelief) form;
		} else {
			Abstract_Guard g = (Abstract_Guard) form;
			if (g.getLHS() == null) {
				return find_bel_in_form(g.getRHS());
			} else {
				return find_bel_in_form(((Abstract_Guard) form).getLHS());
			}
		}
	}
	
	// g1 is some guard - for starters let's say B(b1), var is V, the function is a comparison function (should be)
	// We want to return the formula  B(b1(V)) /\ ~(B(b1(X)) /\ B(condition(X, V)))
	// Only can't use P within the program (!) - Might I be able to with Python?
	public Abstract_Guard toGuard(Abstract_Guard g1, Abstract_VarTerm var) {
		Abstract_GLogicalFormula form = g1.getLHS();
		Abstract_GBelief bel = find_bel_in_form(form);
		Abstract_GBelief bel2 = bel.clone();
		// bel should now be b1(V)
		bel.addTerm(var);
		Abstract_Guard new_guard = new Abstract_Guard(bel);
		
		
		// Ignoring the rest of form for now
		if (g1.getRHS() != null) {
			new_guard = new Abstract_Guard(bel, g1.getOp(), g1.getRHS());
		}
		Abstract_VarTerm x = new Abstract_VarTerm("X1");
		// bel2 should now be b1(X)
		bel2.addTerm(x);
		
		Abstract_Guard neg_guard = new Abstract_Guard(bel2);
		// new_guard.add(bel2);
		if (statements[0] instanceof Abstract_PythonIfStmt) {
			
			Abstract_GLogicalFormula condition_belief = ifstmt_to_guard((Abstract_PythonIfStmt) statements[0], x, var);
			// condition_belief should be condition(X, V)
			neg_guard.add(condition_belief, true);
			// neg_guard is b1(X) /\ condition(X, V)
			Abstract_Guard negated = new Abstract_Guard(Abstract_Guard.not, neg_guard);
			// negated is ~(b1(X) /\ condition(X, V))
			Abstract_Guard conj = new Abstract_Guard(new_guard, Abstract_Guard.and, negated);
			new_guard = conj;
		}
		return new_guard;
	}
	
	public Abstract_GLogicalFormula ifstmt_to_guard (Abstract_PythonIfStmt ifstmt, Abstract_VarTerm x, Abstract_VarTerm var) {
		Abstract_PythonExpr condition = ifstmt.getCondition();
		
		ArrayList<Abstract_Term> vars = new ArrayList<Abstract_Term>();
		vars.add(x);
		vars.add(var);
		Abstract_GLogicalFormula condition_belief = condition.toGuard(vars);
		
		Abstract_PythonS[] elsebody = ifstmt.getElse();
		if (elsebody.length > 0 && elsebody[0] instanceof Abstract_PythonIfStmt) {
			Abstract_GLogicalFormula else_fmla = ifstmt_to_guard((Abstract_PythonIfStmt) elsebody[0], x, var);
			return new Abstract_Guard(condition_belief, Abstract_Guard.or, else_fmla);
		}
		return condition_belief;
	}
	
    public int newJPFObject(MJIEnv env) {
	    	int objref = env.newObject("pbdi.syntax.ast.Abstract_PythonFunc");
	    	env.setReferenceField(objref, "name", env.newString(name));
	    	int sRef = env.newObjectArray("pbdi.syntax.ast.Abstract_PythonStmt", statements.length);
	    for (int i = 0; i < statements.length; i++) {
	       	env.setReferenceArrayElement(sRef, i, statements[i].newJPFObject(env));
	    }
	    
	    int pRef = env.newObjectArray("java.lang.String", parameters.length);
	    for (int i = 0; i < parameters.length; i++) {
	    		env.setReferenceArrayElement(pRef, i, env.newString(parameters[i]));
	    }
       	env.setReferenceField(objref, "statements", sRef);
       	env.setReferenceField(objref, "parameters", pRef);
     	return objref;
   	
    }
    

}
