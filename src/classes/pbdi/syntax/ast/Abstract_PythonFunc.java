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

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import ail.parser.FOFVisitor;
import ail.syntax.Action;
import ail.syntax.Deed;
import ail.syntax.Event;
import ail.syntax.Goal;
import ail.syntax.Guard;
import ail.syntax.Plan;
import ail.syntax.VarTerm;
import ail.syntax.ast.Abstract_GBelief;
import ail.syntax.ast.Abstract_GLogicalFormula;
import ail.syntax.ast.Abstract_Guard;
import ail.syntax.ast.Abstract_Predicate;
import ail.syntax.ast.Abstract_VarTerm;
import ajpf.psl.parser.LogicalFmlasLexer;
import ajpf.psl.parser.LogicalFmlasParser;
import gov.nasa.jpf.vm.MJIEnv;

public class Abstract_PythonFunc {
	String name;
	Abstract_PythonS[] statements = new Abstract_PythonS[0];
	String[] parameters = new String[0];
	
	public Abstract_PythonFunc(String name) {
		this.name = name;
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
				deeds.add(statements[i].getDeed().toMCAPL());
			}
		}
		p.setContextSingle(g, deeds.size());
		p.setPrefix(new ArrayList<Deed>());
		p.setBody(deeds);
		return p;
	}
	
	// g1 is some guard - for startes let's say B(b1), var is V, the function is a comparison function (should be)
	// We want to return the formula  b1(V) /\ b1(X) /\ P(value(V, N1)) /\ P(value(X, N2)) -> N1 >= N2
	// Only can't use P within the program (!) - Might I be able to with Python?
	public Abstract_Guard toGuard(Abstract_Guard g1, Abstract_VarTerm var) {
		Abstract_GLogicalFormula form = g1.getLHS();
		if (form instanceof Abstract_GBelief) {
			Abstract_GBelief bel = (Abstract_GBelief) form;
			Abstract_GBelief bel2 = bel.clone();
			bel.addTerm(var);
			Abstract_Guard new_guard = new Abstract_Guard(bel);
			// This should now be b1(V)
			if (g1.getRHS() != null) {
				new_guard = new Abstract_Guard(bel, g1.getOp(), g1.getRHS());
			}
			Abstract_VarTerm x = new Abstract_VarTerm("X");
			bel2.addTerm(x);
			new_guard.add(bel2);
			if (statements[0] instanceof Abstract_PythonIfStmt) {
				Abstract_PythonIfStmt ifstmt = (Abstract_PythonIfStmt) statements[0];
				// Note might not be comparison!!!
				Abstract_PythonComparison comparison = (Abstract_PythonComparison) ifstmt.getCondition();
				// Assuming for the moment that if clause returns 1 and else clause returns 0 -- need to generalise.
				Abstract_PythonExpr lhs = comparison.getLHS();
				Abstract_PythonExpr rhs = comparison.getRHS();
				
			}
		}
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
