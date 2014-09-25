// ----------------------------------------------------------------------------
// Copyright (C) 2014 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of the Agent Infrastructure Layer (AIL)
// 
// The AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The AIL is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------
package actiononly.syntax.ast;

import gov.nasa.jpf.vm.MJIEnv;
import actiononly.semantics.ActionOnlyAgent;
import ail.mas.MAS;
import ail.syntax.ast.Abstract_Agent;
import ail.syntax.ast.Abstract_Goal;
import ail.syntax.ast.Abstract_Literal;
import ail.syntax.ast.Abstract_Capability;
import ail.syntax.ast.Abstract_Rule;

public class Abstract_ActionOnlyAgent extends Abstract_Agent {
	public Abstract_ActionOnlyAgent(String name) {
		super(name);
	}
	
	public ActionOnlyAgent toMCAPL() {
		try {
			ActionOnlyAgent ag = new ActionOnlyAgent(fAgName);
			addStructures(ag);
			return ag;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ActionOnlyAgent toMCAPL(MAS mas) {
		try {
			ActionOnlyAgent ag = new ActionOnlyAgent(mas, fAgName);
			addStructures(ag);
			return ag;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	protected void addStructures(ActionOnlyAgent ag) {
		    	for (Abstract_Literal l: beliefs) {
		    		ag.addInitialBel(l.toMCAPL());
		    	}
		    	for (Abstract_Rule r: rules) {
		    		ag.addRule(r.toMCAPL());
		    	}
		    	for (Abstract_Capability c: capabilities) {
		    		ag.addCapability(c.toMCAPL());
		    	}
		    	try {
		    		ag.initAg();
		    	} catch (Exception e) {
		    		e.printStackTrace();
		    	}
		   

	}

    public int newJPFObject(MJIEnv env) {
    	int objref = env.newObject("gwendolen.syntax.ast.Abstract_ActionOnlyAgent");
    	env.setReferenceField(objref, "fAgName", env.newString(fAgName));
    	int bRef = env.newObjectArray("ail.syntax.ast.Abstract_Literal", beliefs.length);
      	int rRef = env.newObjectArray("ail.syntax.ast.Abstract_Rule", rules.length);
       	int cRef = env.newObjectArray("ail.syntax.ast.Abstract_Capability", capabilities.length);
       	for (int i = 0; i < beliefs.length; i++) {
       		env.setReferenceArrayElement(bRef, i, beliefs[i].newJPFObject(env));
       	}
     	for (int i = 0; i < rules.length; i++) {
       		env.setReferenceArrayElement(rRef, i, rules[i].newJPFObject(env));
       	}
      	for (int i = 0; i < plans.length; i++) {
       		env.setReferenceArrayElement(cRef, i, capabilities[i].newJPFObject(env));
       	}
      	env.setReferenceField(objref, "beliefs", bRef);
      	env.setReferenceField(objref, "rules", rRef);
      	env.setReferenceField(objref, "capabilities", cRef);
      	return objref;
   	
    }

}
