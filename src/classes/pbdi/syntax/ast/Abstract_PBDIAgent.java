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

import ail.mas.MAS;
import ail.syntax.Guard;
import ail.syntax.ast.Abstract_Agent;
import gov.nasa.jpf.vm.MJIEnv;
import pbdi.semantics.PBDIAgent;

public class Abstract_PBDIAgent extends Abstract_Agent {
	public Abstract_PythonFunc[] funcs = new Abstract_PythonFunc[0];
	public Abstract_PBDIRule[] rules = new Abstract_PBDIRule[0];
	
	public Abstract_PBDIAgent(String name) {
		super(name);
	}
	
	public void addFunc(Abstract_PythonFunc func) {
		int newsize = funcs.length + 1;
		Abstract_PythonFunc[] newfuncs = new Abstract_PythonFunc[newsize];
		for (int i = 0; i < funcs.length; i++) {
			newfuncs[i] = funcs[i];
		}
		newfuncs[funcs.length] = func;
		funcs = newfuncs;
	}
	
	public void addRule(Abstract_PBDIRule rule) {
		int newsize = rules.length + 1;
		Abstract_PBDIRule[] newrules = new Abstract_PBDIRule[newsize];
		for (int i = 0; i < rules.length; i++) {
			newrules[i] = rules[i];
		}
		newrules[rules.length] = rule;
		rules = newrules;
	}
	
	public String toString() {
		String s = getAgName();
		s += "\n";
		for (int i = 0; i < rules.length; i++) {
			s += rules[i] + "\n";
		}
		return s;
		
	}
	
	
	public PBDIAgent toMCAPL() {
		try {
			PBDIAgent pbdi = new PBDIAgent(getAgName());
			addStructures(pbdi);
		
			return pbdi;
		}  catch (Exception e) {
				e.printStackTrace();
				return null;
		}
	}
	
	public PBDIAgent toMCAPL(MAS m) {
		try {
			PBDIAgent pbdi = new PBDIAgent(m, getAgName());
			addStructures(pbdi);
		
			return pbdi;
		}  catch (Exception e) {
				e.printStackTrace();
				return null;
		}
	}

	public void addStructures(PBDIAgent pbdi) throws Exception {
		for (int i = 0; i < rules.length; i++) {
			for (int j = 0; j < funcs.length; j++) {
				if (funcs[j].getName().equals(rules[i].getName())) {
					Guard g = new Guard();
					if (rules[i].getGuard() != null) {
						g = rules[i].getGuard().toMCAPL();
					}
					pbdi.addPlan(funcs[j].toPlan(g));
				}
			}
		}
		
	}
	
    public int newJPFObject(MJIEnv env) {
    	int objref = env.newObject("pbdi.syntax.ast.Abstract_PBDIAgent");
    	env.setReferenceField(objref, "fAgName", env.newString(fAgName));
       	int rRef = env.newObjectArray("pbdi.syntax.ast.Abstract_PythonFunc", funcs.length);
       	int cRef = env.newObjectArray("pbdi.syntax.ast.Abstract_PBDIRule", rules.length);
     	for (int i = 0; i < funcs.length; i++) {
       		env.setReferenceArrayElement(rRef, i, funcs[i].newJPFObject(env));
       	}
      	for (int i = 0; i < rules.length; i++) {
       		env.setReferenceArrayElement(cRef, i, rules[i].newJPFObject(env));
       	}
      	env.setReferenceField(objref, "funcs", rRef);
      	env.setReferenceField(objref, "rules", cRef);
     	return objref;
   	
    }


}
