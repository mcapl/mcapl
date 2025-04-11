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

import ail.syntax.Plan;
import ail.syntax.Deed;
import ail.syntax.Guard;

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
 * AIL Plan class.  A plan consists of an event (trigger), prefix (deed stack), guard (guard
 * stack) and a body (deed stack).  Both the event and prefix must match the current 
 * intention for the plan to be applicable.  This class is based on the Jason Plan class
 * by Rafael H. Bordini, Jomi F. Hubner, et al.
 * 
 * @author louiseadennis
 *
 */
public class Abstract_Plan {
  
	/**
	 * The event (trigger) of the plan.
	 */
    protected Abstract_Event           event = null;
    /**
     * The guard stack of the plan.
     */
    protected Abstract_Guard[]   context;
    /**
     * The body of the plan.
     */
    protected Abstract_Deed[] body;
    /**
     * The prefix of the plan.
     */
    protected Abstract_Deed[] prefix;
    
      /** 
     * Construct an empty plan.
     *
     */
    public Abstract_Plan() {
    }
    
    /**
     * Construct a plan from an event, two deed stacks and a guard stack.  It is assumed the 
     * second deed stack and the guard stack are the same length.  This assumes that the
     * plan is "from" the agent.
     * 
     * @param e  The plan's trigger event.
     * @param prf The plan's prefix.
     * @param ct The plan's guard stack.
     * @param bd The plan's body.
     */
    public Abstract_Plan(Abstract_Event e, ArrayList<Abstract_Deed> prf, ArrayList<Abstract_Guard> ct, ArrayList<Abstract_Deed> bd) {
        event = e;
        setContext(ct);
        setBody(bd);
        setPrefix(prf);
     }
    
   /**
     * Setter method for the plan's trigger event.
     * 
     * @param e the plan's trigger event.
     */
    public void setTrigger(Abstract_Event e) {
    	event = e;
    }

    /**
     * Setter method for the plan's context.
     * 
     * @param le a guard stack for the plan.
     */
    public void setContext(ArrayList<Abstract_Guard> le) {
    	context = new Abstract_Guard[le.size()];
    	for (int i = 0; i < le.size(); i++) {
    		context[i] = le.get(i);
    	}
     }
    
    /**
     * Creates a context with a single entry at the top - all other entries are True.  The
     * most common context for plans.
     * 
     * @param g  The Guard for the top of the context stack.
     * @param i  The size of the plan body.
     */
    public void setContextSingle (Abstract_Guard g, int i) {
  		context = new Abstract_Guard[i];

  		if (i > 1) {
  			for (int j = 0; j < (i - 1); j++) {
  				context[j] = new Abstract_Guard(new Abstract_GBelief());
  			}
  		}
  		
  		context[i - 1] = g;
    }
    
    /**
     * Setter method for the plan body.
     * 
     * @param bd The plan's body.
     */
    public void setBody(ArrayList<Abstract_Deed> bd) {
       	body = new Abstract_Deed[bd.size()];
    	for (int i = 0; i < bd.size(); i++) {
    		body[i] = bd.get(i);
    	}
    }
    
    /**
     * Presumably for pretty printing.
     *
     */
    public void reverseBody() {
    	Abstract_Deed[] oldbody = body;
     	ArrayList<Abstract_Deed> newbody = new ArrayList<Abstract_Deed>();
    	for (Abstract_Deed d: oldbody) {
    		newbody.add(0, d);
    	}
    	setBody(newbody);
    }
    
    /**
     * Setter method for the plan prefix.
     * 
     * @param prf the plan's prefix.
     */
    public void setPrefix(ArrayList<Abstract_Deed> prf) {
      	prefix = new Abstract_Deed[prf.size()];
    	for (int i = 0; i < prf.size(); i++) {
    		prefix[i] = prf.get(i);
    	}
    }
    
    /**
     * Getter method for the plan's trigger event.
     * 
     * @return the trigger event.
     */
    public Abstract_Event getTriggerEvent() {
        return event;
    }
    
    /**
     * Getter method for the plan's guard stack.
     * 
     * @return the plan's guard stack.
     */
    public Abstract_Guard[] getContext() {
        return context;
    }
    
    
    /**
     * Getter method for the plan's body.
     * 
     * @return the plan's body.
     */
    public Abstract_Deed[] getBody() {
        return body;
    }
    
    /**
     * Getter method for the plan's prefix.
     * 
     * @return the plan's prefix.
     */
    public Abstract_Deed[] getPrefix() {
    	return prefix;
    }
    
 
    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return toASString();
    }
    
    /** returns this plan in a string compliant with AS syntax */
    private String toASString() {
    	StringBuilder s = new StringBuilder();
     	s.append(event.toString());
    	s.append((prefix.length == 0) ? "" : " + ");
    	s.append((prefix.length == 0) ? "" : prefix.toString());
    	s.append((context.length == 0) ? "" : " : ");
    	s.append((context.length == 0) ? "" : context.toString());
    	s.append((body.length == 0) ? "" : " <- ");
    	s.append((body.length == 0) ? "" : body.toString());
    	s.append(".");
    	return s.toString();
     }
    
 
    /**
     * Transform this to a concrete plan.
     * @return
     */
    public Plan toMCAPL() {
		ArrayList<Deed> newdeed = new ArrayList<Deed>();
    	for (int i = 0; i < body.length; i++) {
			newdeed.add(i, body[i].toMCAPL());
    	}
		ArrayList<Guard> newguard = new ArrayList<Guard>();
    	for (int i = 0; i < context.length; i++) {
    		newguard.add(i, context[i].toMCAPL());
    	}
		ArrayList<Deed> newpref = new ArrayList<Deed>();
    	for (int i = 0; i < prefix.length; i++) {
    		newpref.add(i, prefix[i].toMCAPL());
    	}
		return new Plan(event.toMCAPL(), newpref, newguard, newdeed);
    }
    
    /**
     * Replicate this in the JVM.
     * @param env
     * @return
     */
    public int newJPFObject(MJIEnv env) {
    	int objref = env.newObject("ail.syntax.ast.Abstract_Plan");
    	int bodyref = env.newObjectArray("ail.syntax.Abstract_Deed", body.length);
    	int prefixref = env.newObjectArray("ail.syntax.Abstract_Deed", prefix.length);
    	int contextref = env.newObjectArray("ail.syntax.Guard", context.length);
    	for (int index = 0; index < body.length; index++) {
			env.setReferenceArrayElement(bodyref, index, body[index].newJPFObject(env));
		}
    	for (int index = 0; index < prefix.length; index++) {
			env.setReferenceArrayElement(prefixref, index, prefix[index].newJPFObject(env));
		}
    	for (int index = 0; index < context.length; index++) {
			env.setReferenceArrayElement(contextref, index, context[index].newJPFObject(env));
		}
    	env.setReferenceField(objref, "body", bodyref);
    	env.setReferenceField(objref, "prefix", prefixref);
    	env.setReferenceField(objref, "context", contextref);
    	env.setReferenceField(objref, "event", event.newJPFObject(env));
    	return objref;
    }
    
}