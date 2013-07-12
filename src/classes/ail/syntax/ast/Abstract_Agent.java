// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
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

package ail.syntax.ast;

import ail.util.AILexception;
import ail.mas.MAS;
import ail.semantics.AILAgent;

import gov.nasa.jpf.jvm.MJIEnv;
import gov.nasa.jpf.annotation.FilterField;

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
 * Abstract class for an AIL Agent.
 * 
 * @author louiseadennis
 *
 */
public class Abstract_Agent {
	
   /**
	 * The agent's name.
	 */
	@FilterField
	protected String fAgName = null;

	// Semantically important state components.
	public Abstract_Literal[] beliefs = new Abstract_Literal[0];

	/**
	 * The logical inference rules used in both belief and goal inference.
	 */
	public Abstract_Rule[] rules = new Abstract_Rule[0];

	/**
	 * The Plan Library.
	 */
	public Abstract_Plan[] plans = new Abstract_Plan[0];
	
	/**
	 * An initial goal.
	 */
	public Abstract_Goal initialgoal;
	  	   
    /**
     * Constructor.
     * 
     * @param mas The multi-agent system within which the agent finds itself.
     * @param name The name of the agent.
     */
    public Abstract_Agent(String name) {
    	fAgName = name;
 	}
    
    /**
     * Constructor.
     */
    public Abstract_Agent() {}
      
    /**
     * Getter method for the agent's name.
     * @return the name of the agent.
     */
    public String getAgName() {
    	return fAgName;
    }
    
    /**
     * Getter method for the agent's name.
     * @return the name of the agent.
     */
    public String getName() {
    	return getAgName();
    }

    /**
     * Adds a new initial goal.
     * 
     * @param g the new initial Goal.
     */
    public void addInitialGoal(Abstract_Goal g) {
    	initialgoal = g;
    }
    
     
    /**
     * Add a new initial belief.
     * 
     * @param b the new belief.
     */
    public void addInitialBel(Abstract_Literal b) {
    	addBel(b);
    }
        
 
     /**
     * Adds a belief to the belief base annotating it with a source.
     * 
     */
    public void addBel(Abstract_Literal bel) {
    	int newsize = beliefs.length + 1;
    	Abstract_Literal[] newbeliefs = new Abstract_Literal[newsize];
    	for (int i = 0; i < beliefs.length; i++) {
    		newbeliefs[i] = beliefs[i];
    	}
    	newbeliefs[beliefs.length] = bel; 
    	beliefs = newbeliefs;
     	
     }
    
    /**
     * Add a rule to the rule base.
     * @param r
     */
    public void addRule(Abstract_Rule r) {
       	int newsize = rules.length + 1;
    	Abstract_Rule[] newrules = new Abstract_Rule[newsize];
    	for (int i = 0; i < rules.length; i++) {
    		newrules[i] = rules[i];
    	}
    	newrules[rules.length] = r;
    	rules = newrules;
   }
    
     
    /**
     * Adds a plan from itself to the library.
     * 
     * @param p The plan to be added.
     * @throws AILexception
     */
    public void addPlan(Abstract_Plan p) {
       	int newsize = plans.length + 1;
    	Abstract_Plan[] newplans = new Abstract_Plan[newsize];
    	for (int i = 0; i < plans.length; i++) {
    		newplans[i] = plans[i];
    	}
       	newplans[plans.length] = p;
    	plans = newplans;
   }
 	
 	/*
 	 * (non-Javadoc)
 	 * @see java.lang.Object#toString()
 	 */
 	public String toString() {
 		StringBuilder s1 = new StringBuilder();
 		s1.append(getAgName());
 		s1.append("\n=============\n");
		String s = s1.toString();
 		return s;
 	}

 	/**
 	 * Construct an AILAgent from this Abstract Agent.
 	 * @param mas
 	 * @return
 	 */
    public AILAgent toMCAPL(MAS mas) {
    	AILAgent ag = new AILAgent(mas, fAgName);
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
    			
    		}
    	}
    	if (initialgoal != null) {
    		ag.addInitialGoal(initialgoal.toMCAPL());
    	}
    	try {
    		ag.initAg();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return ag;
    }
    
    /**
     * Duplicate this class in the Java Pathfinder Virtual Machine.
     * @param env
     * @return
     */
    public int newJPFObject(MJIEnv env) {
    	int objref = env.newObject("ail.syntax.ast.Abstract_Agent");
     	env.setReferenceField(objref, "fAgName", env.newString(fAgName));
     	env.setReferenceField(objref, "initialgoal", initialgoal.newJPFObject(env));
    	int bRef = env.newObjectArray("ail.syntax.ast.Abstract_Literal", beliefs.length);
       	int rRef = env.newObjectArray("ail.syntax.ast.Abstract_Rule", rules.length);
       	int pRef = env.newObjectArray("ail.syntax.ast.Abstract_Plan", plans.length);
       	for (int i = 0; i < beliefs.length; i++) {
       		env.setReferenceArrayElement(bRef, i, beliefs[i].newJPFObject(env));
       	}
      	for (int i = 0; i < rules.length; i++) {
       		env.setReferenceArrayElement(rRef, i, rules[i].newJPFObject(env));
       	}
      	for (int i = 0; i < plans.length; i++) {
       		env.setReferenceArrayElement(pRef, i, plans[i].newJPFObject(env));
       	}
      	env.setReferenceField(objref, "beliefs", bRef);
      	env.setReferenceField(objref, "rules", rRef);
      	env.setReferenceField(objref, "plans", pRef);
      	return objref;
   	
    }
		
}