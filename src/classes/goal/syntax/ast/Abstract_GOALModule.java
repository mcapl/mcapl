// ----------------------------------------------------------------------------
// Copyright (C) 2015 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of GOAL (AIL version) - GOAL-AIL
// 
// GOAL-AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// GOAL-AIL is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with GOAL-AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package goal.syntax.ast;


import ail.util.AILexception;
import ail.mas.MAS;
import ail.semantics.AILAgent;
import ail.syntax.Plan;
import ail.syntax.ast.Abstract_Event;
import ail.syntax.ast.Abstract_Goal;
import ail.syntax.ast.Abstract_StringTerm;
import ail.syntax.ast.Abstract_Term;
import ail.syntax.ast.Abstract_Agent;
import ail.syntax.ast.Abstract_Literal;
import ail.syntax.ast.Abstract_Plan;
import ail.syntax.ast.Abstract_Rule;
import ail.syntax.ast.Abstract_GBelief;
import ail.syntax.ast.Abstract_Predicate;
import ail.syntax.ast.Abstract_GLogicalFormula;
import ail.syntax.ast.Abstract_Capability;
import ail.mas.DefaultEnvironment;
import gov.nasa.jpf.vm.MJIEnv;
import goal.semantics.GOALAgent;
import goal.syntax.ActionRule;
import goal.syntax.GOALModule;


/**
 * A Gwendolen Agent - a demonstration of how to subclass an AIL Agent and
 * create a reasoning cycle.
 * 
 * @author louiseadennis
 *
 */
public class Abstract_GOALModule implements Abstract_KRGOALS { 
	
	public static int main = 0;
	public static int event = 1;
	
	int module_type;
		
	Abstract_Predicate[] knowledge = new Abstract_Predicate[0];

	Abstract_Rule[] knowledge_rules = new Abstract_Rule[0];
	
	Abstract_Predicate[] goals = new Abstract_Predicate[0];

	/*
	 * The Plan Library.
	 */
	public Abstract_ActionRule[] actionrules = new Abstract_ActionRule[0];

	 /**
	 * Construct a Gwendolen agent from an architecture and a name.
	 * 
	 * @param arch the Agent Architecture.
	 * @param name te name of the agent.
	 */
	public Abstract_GOALModule(int type) {
		module_type = type;
	}
	
    /**
    * Adds a belief to the belief base annotating it with a source.
    * 
    */
   public void addFact(Abstract_Predicate bel) {
   	int newsize = knowledge.length + 1;
   	Abstract_Predicate[] newbeliefs = new Abstract_Predicate[newsize];
   	for (int i = 0; i < knowledge.length; i++) {
   		newbeliefs[i] = knowledge[i];
   	}
   	newbeliefs[knowledge.length] = bel; 
   	knowledge = newbeliefs;
    	
    }
   
   /**
    * Add a rule to the rule base.
    * @param r
    */
   public void addKRule(Abstract_Rule r) {
      	int newsize = knowledge_rules.length + 1;
   	Abstract_Rule[] newrules = new Abstract_Rule[newsize];
   	for (int i = 0; i < knowledge_rules.length; i++) {
   		newrules[i] = knowledge_rules[i];
   	}
   	newrules[knowledge_rules.length] = r;
   	knowledge_rules = newrules;
  }

   public void addPlan(Abstract_Plan p)  {
     	if (p instanceof Abstract_ActionRule) {
          	int newsize = actionrules.length + 1;
        	Abstract_ActionRule[] newplans = new Abstract_ActionRule[newsize];
        	for (int i = 0; i < actionrules.length; i++) {
        		newplans[i] = actionrules[i];
        	}
           	newplans[actionrules.length] = (Abstract_ActionRule) p;
        	actionrules = newplans;
    		// CondActions.init(this);
    	 } else { 
    		// super.addPlan(p);
    		// fPL.init(this);
    	 }  
    }
   
   public void addGoal(Abstract_Predicate p) {
	   int newsize = goals.length + 1;
	   Abstract_Predicate[] newgoals = new Abstract_Predicate[newsize];
	   for (int i = 0; i < goals.length; i++) {
		   newgoals[i] = goals[i];
	   }
	   newgoals[goals.length] = p;
	   goals = newgoals;
   }
    
    public GOALModule toMCAPL() {
    	GOALModule.ModuleType mtype;
    	if (module_type == main) {
    		mtype = GOALModule.ModuleType.MAIN;
    	} else {
    		mtype = GOALModule.ModuleType.EVENT;
    	}
    	GOALModule m = new GOALModule(mtype);
    	for (Abstract_Predicate g: goals) {
    		m.addGoal(g.toMCAPL());
    	}
    	for (Abstract_Rule r: knowledge_rules) {
    		m.addRule(r.toMCAPL());
    	}
    	for (Abstract_ActionRule p: actionrules) {
    		try {
    			m.addActionRule(p.toMCAPL());
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    	for (Abstract_Predicate g: knowledge) {
    		m.addFact(g.toMCAPL());
    	}
		    	
    	return m;
	}

    public int newJPFObject(MJIEnv env) {
    	int objref = env.newObject("goal.syntax.ast.Abstract_GOALModule");
    	env.setIntField(objref, "module_type", module_type);
    	int bRef = env.newObjectArray("ail.syntax.ast.Abstract_Predicate", knowledge.length);
     	int gRef = env.newObjectArray("ail.syntax.ast.Abstract_Goal", goals.length);
       	int rRef = env.newObjectArray("ail.syntax.ast.Abstract_Rule", knowledge_rules.length);
       	int pRef = env.newObjectArray("ail.syntax.ast.Abstract_ActionRule", actionrules.length);
       	for (int i = 0; i < knowledge.length; i++) {
       		env.setReferenceArrayElement(bRef, i, knowledge[i].newJPFObject(env));
       	}
      	for (int i = 0; i < knowledge_rules.length; i++) {
       		env.setReferenceArrayElement(rRef, i, knowledge_rules[i].newJPFObject(env));
       	}
      	for (int i = 0; i < actionrules.length; i++) {
       		env.setReferenceArrayElement(pRef, i, actionrules[i].newJPFObject(env));
       	}
       	for (int i = 0; i < goals.length; i++) {
       		env.setReferenceArrayElement(gRef, i, goals[i].newJPFObject(env));
       	}
      	env.setReferenceField(objref, "knowledge", bRef);
      	env.setReferenceField(objref, "knowledge_rules", rRef);
      	env.setReferenceField(objref, "action_rules", pRef);
      	env.setReferenceField(objref, "goals", gRef);
      	return objref;
   	
    }


}
