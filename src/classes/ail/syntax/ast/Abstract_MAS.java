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

import java.util.ArrayList;

import ail.mas.MAS;
import gov.nasa.jpf.vm.MJIEnv;

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
 * AIL's view of a multi-agent system.  Abstract Syntax.
 * 
 * @author louiseadennis
 *
 */
public class Abstract_MAS  {

	/**
     * The agents in the MAS indexed by agent name.
     */
	Abstract_Agent[] agents;
 
	
	/**
	 * Constructor
	 */
	public Abstract_MAS() {};
  
    /**
     * Add a new agent to the multi-agent system.
     * 
     * @param ag the <code>AgArch</code> object for an agent.
     */
    public void setAgs(ArrayList<? extends Abstract_Agent> ags) {
     	Abstract_Agent[] agent = new Abstract_Agent[ags.size()];
    	for (int i = 0; i < ags.size(); i++) {
    		agent[i] = ags.get(i);
    	}
    	agents = agent;
    }

     /**
     * Getter method for the agents.
     * 
     * @return the indexed set of agents.
     */
    protected Abstract_Agent[] getAgs() {
    	return agents;
    }
  
    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
   public String toString() {
	   String s = "";
     	for (Abstract_Agent a : agents) {
    		s += "\n" + a.toString();
    	}
    	return s;
    }
   
   /**
    * Create a concrete version of the MAS.
    * @return
    */
   public MAS toMCAPL(String tracedir) {

	   MAS mas = new MAS();			

	   mas.setTraceDir(tracedir);
	   if (agents != null) {
		   for (Abstract_Agent ag: agents) {

			   mas.addAg(ag.toMCAPL(mas));
		   }
	   }
	   return mas;
   }
   
   /**
    * Copy this into the JVM.
    * @param env
    * @return
    */
   public int newJPFObject(MJIEnv env) {
	   int objref = env.newObject("ail.syntax.ast.Abstract_MAS");
	   int aRef = env.newObjectArray("ail.syntax.ast.Abstract_Agent", agents.length);
	   for (int i = 0; i < agents.length; i++) {
		   Abstract_Agent ag = agents[i];
		   env.setReferenceArrayElement(aRef, i, ag.newJPFObject(env));
	   }
	   env.setReferenceField(objref, "agents", aRef);
	   return objref;
   }
    
 
}
