// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis, Michael Fisher, and Koen Hindriks
// 
// This file is part of AIL GOAL.  An AIL Implementation of the GOAL Programming
// Language
//
// AIL GOAL is free software: you can redistribute it and/or modify it under
// the terms of the GNU General Public License as published by the Free Software
// Foundation, either version 3 of the License, or (at your option) any later
// version.
//
// AIL GOAL is distributed in the hope that it will be useful, but WITHOUT
// ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
// FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
// details.
//
// You should have received a copy of the GNU General Public License along with
// this program. If not, see <http://www.gnu.org/licenses/>.
//
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package goal.syntax.ast;


import java.util.ArrayList;
import java.util.List;

import ail.syntax.ast.Abstract_Plan;
import ail.syntax.ast.Abstract_Rule;
import ail.syntax.ast.Abstract_Predicate;
import ail.syntax.ast.Abstract_Term;
import gov.nasa.jpf.vm.MJIEnv;
import goal.syntax.GOALModule;


/**
 * An Abstract GOAL Agent.
 * 
 * @author louiseadennis
 *
 */
public class Abstract_GOALModule implements Abstract_KRGOALS { 
	
	public static int linear = 0;
	public static int linearall = 1;
	public static int random = 2;
	public static int randomall = 3;
	public static int adaptive = 4;
	
	public static Abstract_ModuleDef main = new Abstract_ModuleDef(0);
	public static Abstract_ModuleDef event = new Abstract_ModuleDef(1);
	public static Abstract_ModuleDef init = new Abstract_ModuleDef(2);
	
	public static int always = 0;
	public static int never = 1;
	public static int nogoals = 2;
	public static int noaction = 3;
	public static int noneset = 4;
	
	Abstract_ModuleDef module_type;
	int optionorder = linear;
	int exitcondition = noneset;
		
	Abstract_Predicate[] knowledge = new Abstract_Predicate[0];

	Abstract_Rule[] knowledge_rules = new Abstract_Rule[0];
	
	Abstract_ConjGoal[] goals = new Abstract_ConjGoal[0];


	public Abstract_ActionSpec[] actionspecs = new Abstract_ActionSpec[0];

	/*
	 * The Plan Library.
	 */
	public Abstract_ActionRule[] actionrules = new Abstract_ActionRule[0];
	
	List<Abstract_GOALModule> name_map;
	List<Abstract_Predicate> names;

	
	public Abstract_GOALModule(Abstract_ModuleDef def) {
		module_type = def;
		if (def == event || def == init) {
			optionorder = linearall;
		}
	}
	
	public void addAllCap(ArrayList<Abstract_ActionSpec> as) {
		for (Abstract_ActionSpec a: as) {
			addCap(a);
		}
	}
	
	   public void addCap(Abstract_ActionSpec c) {
		   if (c instanceof Abstract_ActionSpec) {
			   int newsize = actionspecs.length + 1;
			   Abstract_ActionSpec[] newplans = new Abstract_ActionSpec[newsize];
			   for (int i = 0; i < actionspecs.length; i++) {
				   newplans[i] = actionspecs[i];
			   }
			   newplans[actionspecs.length] = c;
			   actionspecs = newplans;
		   } else {
			  System.err.println("Why doesn't abstract_agent have addCap method?");
		   }  
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
   
   public void addBel(Abstract_Predicate bel) {
	   	int newsize = knowledge.length + 1;
	   	Abstract_Predicate[] newbeliefs = new Abstract_Predicate[newsize];
	   	for (int i = 0; i < knowledge.length; i++) {
	   		newbeliefs[i] = knowledge[i];
	   	}
	   	newbeliefs[knowledge.length] = bel; 
	   	knowledge = newbeliefs;
	    	
	    }

   public void setOptionOrder(int i) {
	   optionorder = i;
   }
   
   public boolean hasName() {
	   return (getModuleName() != null);
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

   /**
    * Add a rule to the rule base.
    * @param r
    */
   public void addRule(Abstract_Rule r) {
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
    	 } else {
    		// super.addPlan(p);
    		// fPL.init(this);
    	 }  
    }
   
   public void addGoal(Abstract_ConjGoal p) {
	   int newsize = goals.length + 1;
	   Abstract_ConjGoal[] newgoals = new Abstract_ConjGoal[newsize];
	   for (int i = 0; i < goals.length; i++) {
		   newgoals[i] = goals[i];
	   }
	   newgoals[goals.length] = p;
	   goals = newgoals;
   }
   
   public void addGoal(ArrayList<ArrayList<Abstract_Term>> le) {
	   for (ArrayList<Abstract_Term> t: le) {
		   addGoal(new Abstract_ConjGoal(t));
	   }
   }

   public void setExitCondition(int i) {
	   exitcondition = i;
   }

    
    public GOALModule toMCAPL() {
    	GOALModule.ModuleType mtype;
		if (module_type.type == main.type) {
			mtype = GOALModule.ModuleType.MAIN;
    	} else if (module_type.type == event.type) {
    		mtype = GOALModule.ModuleType.EVENT;
    	} else if (module_type.type == init.type ){
    		mtype = GOALModule.ModuleType.INIT;
    	} else {
    		mtype = GOALModule.ModuleType.USERDEF;
    	}
    	
    	GOALModule m;
    	if (module_type.hasName()) {
    		m = new GOALModule(mtype, module_type.getName().toMCAPL());
    	} else {
    		m = new GOALModule(mtype);
    	}
    	
    	for (Abstract_ConjGoal g: goals) {
    		m.addGoal(g.toMCAPL());
    	}
    	for (Abstract_Rule r: knowledge_rules) {
    		m.addRule(r.toMCAPL());
    	}
    	for (Abstract_ActionRule p: actionrules) {
    		try {
    			p.resolveUserSpecOrCallModule(names, name_map);
    			m.addActionRule(p.toMCAPL());
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    	for (Abstract_ActionSpec ca: actionspecs) {
    		try {
				m.addCap(ca.toMCAPL());
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	} 

    	
    	if (optionorder == linear) {
    		m.setRuleEvaluationOrder(GOALModule.RuleEvaluationOrder.LINEAR);
    	} else if (optionorder == linearall) {
    		m.setRuleEvaluationOrder(GOALModule.RuleEvaluationOrder.LINEARALL);
    	} else if (optionorder == random) {
    		m.setRuleEvaluationOrder(GOALModule.RuleEvaluationOrder.RANDOM);
    	} else if (optionorder == randomall) {
    		m.setRuleEvaluationOrder(GOALModule.RuleEvaluationOrder.RANDOMALL);
    	}
    	
    	if (exitcondition == always) {
    		m.setExitCondition(GOALModule.ExitCondition.ALWAYS);
    	} else if (exitcondition == never) {
    		m.setExitCondition(GOALModule.ExitCondition.NEVER);
    	} else if (exitcondition == nogoals) {
    		m.setExitCondition(GOALModule.ExitCondition.NOGOALS);
    	} else if (exitcondition == noaction) {
    		m.setExitCondition(GOALModule.ExitCondition.NOACTION);
    	}
    	
    	for (Abstract_Predicate g: knowledge) {
    		m.addFact(g.toMCAPL());
    	}
		    	
    	return m;
	}

    public int newJPFObject(MJIEnv env) {
    	int objref = env.newObject("goal.syntax.ast.Abstract_GOALModule");
		env.setReferenceField(objref, "module_type", module_type.newJPFObject(env));
		env.setIntField(objref, "optionorder", optionorder);
    	env.setIntField(objref, "exitcondition", exitcondition);
     	int bRef = env.newObjectArray("ail.syntax.ast.Abstract_Predicate", knowledge.length);
     	int gRef = env.newObjectArray("goal.syntax.ast.Abstract_ConjGoal", goals.length);
       	int rRef = env.newObjectArray("goal.syntax.ast.Abstract_Rule", knowledge_rules.length);
       	int pRef = env.newObjectArray("goal.syntax.ast.Abstract_ActionRule", actionrules.length);
      	int caRef = env.newObjectArray("goal.syntax.ast.Abstract_ActionSpec", actionspecs.length);
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
      	for (int i = 0; i < actionspecs.length; i++) {
	   		env.setReferenceArrayElement(caRef, i, actionspecs[i].newJPFObject(env));
       	}
      	env.setReferenceField(objref, "knowledge", bRef);
      	env.setReferenceField(objref, "knowledge_rules", rRef);
      	env.setReferenceField(objref, "actionrules", pRef);
		env.setReferenceField(objref, "actionspecs", caRef);
      	env.setReferenceField(objref, "goals", gRef);
      	return objref;
   	
    }

	public Abstract_Predicate getModuleName() {
		return module_type.getName();
	}

	public void setModuleNames(List<Abstract_Predicate> names3, List<Abstract_GOALModule> names2) {
		this.name_map = names2;
		names = names3;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getModuleName().toString();
	}


}
