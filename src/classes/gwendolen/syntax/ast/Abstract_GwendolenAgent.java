// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of Gwendolen
// 
// Gwendolen is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Gwendolen is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with Gwendolen; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package gwendolen.syntax.ast;


import ail.mas.MAS;
import ail.syntax.ast.Abstract_Agent;
import ail.syntax.ast.Abstract_Literal;
import ail.syntax.ast.Abstract_Goal;
import ail.syntax.ast.Abstract_Plan;
import ail.syntax.ast.Abstract_Rule;
import gov.nasa.jpf.vm.MJIEnv;
import gwendolen.semantics.GwendolenAgent;
import gwendolen.util.GwendolenPrettyPrinter;


/**
 * A Gwendolen Agent - a demonstration of how to subclass an AIL Agent and
 * create a reasoning cycle.
 * 
 * @author louiseadennis
 *
 */
public class Abstract_GwendolenAgent extends Abstract_Agent { 

	/**
	 * Construct a Gwendolen agent from an architecture and a name.
	 * 
	 * @param arch the Agent Architecture.
	 * @param name te name of the agent.
	 */
	public Abstract_GwendolenAgent(String name) {
		super(name);
		// first we create an AIL Agent.		
 
		
	}
	
	public GwendolenAgent toMCAPL() {
		try {
			GwendolenAgent ag = new GwendolenAgent(fAgName);
			addStructures(ag);

			return ag;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public GwendolenAgent toMCAPL(MAS mas) {
		try {
			GwendolenAgent ag = new GwendolenAgent(mas, fAgName);
			// ag.setPretty(new GwendolenPrettyPrinter());
			addStructures(ag);

			return ag;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	protected void addStructures(GwendolenAgent ag) {
		    	for (Abstract_Literal l: beliefs) {
		    		ag.addInitialBel(l.toMCAPL());
		    	}
		    	for (Abstract_Rule r: rules) {
		    		ag.addRule(r.toMCAPL());
		    	}
		    	for (Abstract_Plan p: plans) {
		    		try {
		    			ag.addPlan(p.toMCAPL()); 
		    		} catch (Exception e) {
		    			e.printStackTrace();
		    		}
		    	}
		    	for (Abstract_Goal g: goals) {
		    		ag.addInitialGoal(g.toMCAPL());
		    	}
		    	try { 
		    		ag.initAg();
		    	} catch (Exception e) {
		    		e.printStackTrace(); 
		    	}
		   

	}

    public int newJPFObject(MJIEnv env) {
    	int objref = env.newObject("gwendolen.syntax.ast.Abstract_GwendolenAgent");
    	env.setReferenceField(objref, "fAgName", env.newString(fAgName));
    	int bRef = env.newObjectArray("ail.syntax.ast.Abstract_Literal", beliefs.length);
    	int gRef = env.newObjectArray("ail.syntax.ast.Abstract_Goal", goals.length);
      	int rRef = env.newObjectArray("ail.syntax.ast.Abstract_Rule", rules.length);
       	int pRef = env.newObjectArray("ail.syntax.ast.Abstract_Plan", plans.length);
       	for (int i = 0; i < beliefs.length; i++) {
       		env.setReferenceArrayElement(bRef, i, beliefs[i].newJPFObject(env));
       	}
       	for (int i = 0; i < goals.length; i++) {
       		env.setReferenceArrayElement(gRef, i, goals[i].newJPFObject(env));
       	}
     	for (int i = 0; i < rules.length; i++) {
       		env.setReferenceArrayElement(rRef, i, rules[i].newJPFObject(env));
       	}
      	for (int i = 0; i < plans.length; i++) {
       		env.setReferenceArrayElement(pRef, i, plans[i].newJPFObject(env));
       	}
      	env.setReferenceField(objref, "beliefs", bRef);
      	env.setReferenceField(objref, "goals", gRef);
      	env.setReferenceField(objref, "rules", rRef);
      	env.setReferenceField(objref, "plans", pRef);
      	return objref;
   	
    }

}
