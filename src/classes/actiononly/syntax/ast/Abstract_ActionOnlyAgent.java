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
import ail.semantics.AILAgent;
import ail.syntax.ast.Abstract_Agent;
import ail.syntax.ast.Abstract_Goal;
import ail.syntax.ast.Abstract_Literal;
import ail.syntax.ast.Abstract_Capability;
import ail.syntax.ast.Abstract_Rule;

/**
 * Generic Description of Abstract Classes in AIL and AJPF
 * -------------------------------------------------------
 * 
 * We use "Abstract" versions of syntax items for all bits of state that we sometimes wish to store in the native
 * java VM as well in the JavaPathfinder VM.  In particular files are parsed into the native VM and then the relevant
 * initial state of the multi-agent system is reconstructed in the model-checking VM.  This is done to improve
 * efficiency of parsing (the native VM is faster).  We also represent properties for model checking in the native VM 
 * and, indeed the property automata is stored only in the native VM.  We used Abstract classes partly because less
 * computational content is needed for these objects in the native VM and so a smaller representation can be used
 * but also because specific support is needed for transferring information between the two virtual machines both
 * in terms of methods and in terms of the data types chosen for the various fields.  It was felt preferable to 
 * separate these things out from the classes used for the objects that determine the run time behaviour of a MAS.
 * 
 * Abstract classes all have a method (toMCAPL) for creating a class for the equivalent concrete object used
 * when executing the MAS.  They also have a method (newJPFObject) that will create an equivalent object in the 
 * model-checking virtual machine from one that is held in the native VM.  At the start of execution the agent
 * program is parsed into abstract classes in the native VM.  An equivalent structure is then created in the JVM
 * using calls to newJPFObject and this structure is then converted into the structures used for executing the MAS
 * by calls to toMCAPL.
 * 
 */

/**
 * An abstract class for action only agents.
 * @author lad
 *
 */
public class Abstract_ActionOnlyAgent extends Abstract_Agent {
	public Abstract_ActionOnlyAgent(String name) {
		super(name);
	}
	
	/**
	 * Return a concrete agent (when the MAS is unknown)
	 * @return
	 */
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
	
	/**
	 * Return a concrete agent, when the MAS is known.
	 */
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
	
	/**
	 * This utility method is useful when building an agent without knowing the MAS in advance.
	 * @param ag
	 */
	@Override
	public void addStructures(AILAgent ag) {
		    	for (Abstract_Literal l: beliefs) {
		    		ag.addInitialBel(l.toMCAPL());
		    	}
		    	for (Abstract_Rule r: rules) {
		    		ag.addRule(r.toMCAPL());
		    	}
		    	for (Abstract_Capability c: capabilities) {
		    		ag.addCapability(c.toMCAPL());
		    	}
		    	
		    	for (Abstract_Goal g: goals) {
		    		ag.addGoal(g.toMCAPL());
		    	}
		    	try {
		    		ag.initAg();
		    	} catch (Exception e) {
		    		e.printStackTrace();
		    	}
		   

	}
	
	@Override
	public String toString() {
		String s = super.getName();
		s += "\n";
		s += beliefs.toString();
		s += "\n\n";
		s += rules.toString();
		s += "\n\n";
		for (Abstract_Capability c: capabilities) {
			s += c.toString();
			s += "\n";
		}
		s += "\n\n";
		s += goals.toString();
		return s;
	}

    public int newJPFObject(MJIEnv env) {
    	int objref = env.newObject("actiononly.syntax.ast.Abstract_ActionOnlyAgent");
    	env.setReferenceField(objref, "fAgName", env.newString(fAgName));
    	int bRef = env.newObjectArray("ail.syntax.ast.Abstract_Literal", beliefs.length);
      	int rRef = env.newObjectArray("ail.syntax.ast.Abstract_Rule", rules.length);
       	int cRef = env.newObjectArray("ail.syntax.ast.Abstract_Capability", capabilities.length);
       	int gRef = env.newObjectArray("ail.syntax.ast.Abstract_Goal", goals.length);
       	for (int i = 0; i < beliefs.length; i++) {
       		env.setReferenceArrayElement(bRef, i, beliefs[i].newJPFObject(env));
       	}
     	for (int i = 0; i < rules.length; i++) {
       		env.setReferenceArrayElement(rRef, i, rules[i].newJPFObject(env));
       	}
      	for (int i = 0; i < capabilities.length; i++) {
       		env.setReferenceArrayElement(cRef, i, capabilities[i].newJPFObject(env));
       	}
      	for (int i = 0; i < goals.length; i++) {
       		env.setReferenceArrayElement(gRef, i, goals[i].newJPFObject(env));
       	}
      	env.setReferenceField(objref, "beliefs", bRef);
      	env.setReferenceField(objref, "rules", rRef);
      	env.setReferenceField(objref, "capabilities", cRef);
      	env.setReferenceField(objref, "goals", gRef);
     	return objref;
   	
    }

}
