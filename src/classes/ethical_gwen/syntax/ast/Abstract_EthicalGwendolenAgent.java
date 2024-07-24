// ----------------------------------------------------------------------------
// Copyright (C) 2016 Louise A. Dennis, Michael Fisher, Marija Slavkovik and Matt Webster
// 
// This file is part of Ethical Gwendolen
//
// Ethical Gwendolen is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Ethical Gwendolen is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with Ethical Gwendolen if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------
package ethical_gwen.syntax.ast;

import gov.nasa.jpf.vm.MJIEnv;

import ethical_gwen.semantics.EthicalGwendolenAgent;

import ail.mas.MAS;
import gwendolen.syntax.ast.Abstract_GwendolenAgent;

public class Abstract_EthicalGwendolenAgent extends Abstract_GwendolenAgent {
	Abstract_Ethic[] ethics = new Abstract_Ethic[0];
	
	public Abstract_EthicalGwendolenAgent(String name) {
		super(name);
	}
	
	public EthicalGwendolenAgent toMCAPL() {
		try {
			EthicalGwendolenAgent ag = new EthicalGwendolenAgent(fAgName);
			addStructures(ag);
			return ag;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public EthicalGwendolenAgent toMCAPL(MAS mas) {
		try {
			EthicalGwendolenAgent ag = new EthicalGwendolenAgent(mas, fAgName);
			addStructures(ag);
			return ag;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void addEthic(Abstract_Ethic e) {
    	int newsize = ethics.length + 1;
    	Abstract_Ethic[] newethics = new Abstract_Ethic[newsize];
    	for (int i = 0; i < ethics.length; i++) {
    		newethics[i] = ethics[i];
    	}
    	newethics[ethics.length] = e; 
    	ethics = newethics;
	}
	
	protected void addStructures(EthicalGwendolenAgent ag) {
	   	for (Abstract_Ethic e: ethics) {
    		ag.addEthic(e.toMCAPL());
    	}
		super.addStructures(ag);
	}
	
	public int newJPFObject(MJIEnv env) {
    	int objref = env.newObject("ethical_gwen.syntax.ast.Abstract_EthicalGwendolenAgent");
    	env.setReferenceField(objref, "fAgName", env.newString(fAgName));
//    	if (initialgoal != null) {
//    		env.setReferenceField(objref, "initialgoal", initialgoal.newJPFObject(env));
//    	}
    	int eRef = env.newObjectArray("ethical_gwen.syntax.ast.Abstract_Ethic", ethics.length);
    	int bRef = env.newObjectArray("ail.syntax.ast.Abstract_Literal", beliefs.length);
		int gRef = env.newObjectArray("ail.syntax.ast.Abstract_Goal", goals.length);
       	int rRef = env.newObjectArray("ail.syntax.ast.Abstract_Rule", rules.length);
       	int pRef = env.newObjectArray("ail.syntax.ast.Abstract_Plan", plans.length);
       	for (int i = 0; i < ethics.length; i++) {
       		env.setReferenceArrayElement(eRef, i, ethics[i].newJPFObject(env));
       	}
       	for (int i = 0; i < beliefs.length; i++) {
       		env.setReferenceArrayElement(bRef, i, beliefs[i].newJPFObject(env));
       	}
      	for (int i = 0; i < rules.length; i++) {
       		env.setReferenceArrayElement(rRef, i, rules[i].newJPFObject(env));
       	}
		for (int i = 0; i < goals.length; i++) {
			env.setReferenceArrayElement(gRef, i, goals[i].newJPFObject(env));
		}
		for (int i = 0; i < plans.length; i++) {
       		env.setReferenceArrayElement(pRef, i, plans[i].newJPFObject(env));
       	}
		env.setReferenceField(objref, "ethics", eRef);
      	env.setReferenceField(objref, "beliefs", bRef);
      	env.setReferenceField(objref, "rules", rRef);
		env.setReferenceField(objref, "goals", gRef);
      	env.setReferenceField(objref, "plans", pRef);
      	return objref;
   	
    }

}
