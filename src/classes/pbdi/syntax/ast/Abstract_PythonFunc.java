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

import ail.syntax.Action;
import ail.syntax.Deed;
import ail.syntax.Event;
import ail.syntax.Goal;
import ail.syntax.Guard;
import ail.syntax.Plan;
import ail.syntax.VarTerm;
import gov.nasa.jpf.vm.MJIEnv;

public class Abstract_PythonFunc {
	String name;
	Abstract_PythonStmt[] statements = new Abstract_PythonStmt[0];
	
	public Abstract_PythonFunc(String name) {
		this.name = name;
	}
	
	public void addStatement(Abstract_PythonStmt stmt) {
		int newsize = statements.length + 1;
		Abstract_PythonStmt[] newstmts = new Abstract_PythonStmt[newsize];
		for (int i = 0; i < statements.length; i++) {
			newstmts[i] = statements[i];
		}
		newstmts[statements.length] = stmt;
		statements = newstmts;
	}
	
	public String getName() {
		return name;
	}
	
	public Plan toPlan(Guard g) {
		Plan p = new Plan();
		p.setTrigger(new Event(Event.AILAddition, new Goal(new VarTerm("Any"), Goal.achieveGoal)));
		ArrayList<Deed> deeds = new ArrayList<Deed>();
		for (int i = 0; i < statements.length; i++) {
			if (! statements[i].getString().equals("return\n")) {
				Action a = new Action(statements[i].getString());
				deeds.add(new Deed(a));
			}
		}
		p.setContextSingle(g, deeds.size());
		p.setPrefix(new ArrayList<Deed>());
		p.setBody(deeds);
		return p;
	}
	
    public int newJPFObject(MJIEnv env) {
	    	int objref = env.newObject("pbdi.syntax.ast.Abstract_PythonFunc");
	    	env.setReferenceField(objref, "name", env.newString(name));
	    	int sRef = env.newObjectArray("pbdi.syntax.ast.Abstract_PythonStmt", statements.length);
	    for (int i = 0; i < statements.length; i++) {
	       	env.setReferenceArrayElement(sRef, i, statements[i].newJPFObject(env));
	    }
       	env.setReferenceField(objref, "statements", sRef);
     	return objref;
   	
    }

}
