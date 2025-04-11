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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ail.util.AILexception;
import ail.mas.MAS;
import ail.semantics.AILAgent;
import ail.syntax.Plan;
import ail.syntax.Literal;
import ail.syntax.ast.Abstract_Event;
import ail.syntax.ast.Abstract_Goal;
import ail.syntax.ast.Abstract_LogicalFormula;
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
import ail.syntax.ast.Abstract_LogExpr;
import ail.mas.DefaultEnvironment;
import gov.nasa.jpf.vm.MJIEnv;
import goal.semantics.GOALAgent;
import goal.syntax.ActionRule;


/**
 * A Gwendolen Agent - a demonstration of how to subclass an AIL Agent and
 * create a reasoning cycle.
 * 
 * @author louiseadennis
 *
 */
public class Abstract_GOALAgent extends Abstract_Agent implements Abstract_KRGOALS { 
		
	Abstract_Predicate[] knowledge = new Abstract_Predicate[0];

	Abstract_Rule[] knowledge_rules = new Abstract_Rule[0];

	Abstract_Rule[] belief_rules = new Abstract_Rule[0];

	Abstract_GOALModule[] modules = new Abstract_GOALModule[0];
	
	 /**
	 * Construct a Gwendolen agent from an architecture and a name.
	 * 
	 * @param arch the Agent Architecture.
	 * @param name te name of the agent.
	 */
	public Abstract_GOALAgent(String name) {
		super(name);
	}
	
	public void addModule(Abstract_GOALModule gm) {
		int newsize = modules.length + 1;
		Abstract_GOALModule[] newmodules = new Abstract_GOALModule[newsize];
		for (int i = 0; i < modules.length; i++) {
			newmodules[i] = modules[i];
		}
		newmodules[modules.length] = gm;
		modules = newmodules;
	}
	
    /**
    * Adds a belief to the belief base annotating it with a source.
    * 
    */
   public void addFact(Abstract_Predicate bel) {
	   addBel(bel);
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
   
   public void addGoal(Abstract_ConjGoal p) {
	   super.addGoal(p);
   }
   
   public void addGoal(Abstract_LogExpr le) {
	  ArrayList<Abstract_Predicate> goals = lf_to_lits(le);
	  for (Abstract_Predicate p: goals) {
		  addGoal(p);
	  }
   }
   
   private static ArrayList<Abstract_Predicate> lf_to_lits(Abstract_LogicalFormula le) {
	   ArrayList<Abstract_Predicate> out = new ArrayList<Abstract_Predicate>();
	   if (le instanceof Abstract_Predicate) {
		   out.add((Abstract_Predicate) le);
	   } else {
		   Abstract_LogExpr ale = (Abstract_LogExpr) le;
	  
		   if (ale.getOp() == Abstract_LogExpr.none) {
			   out.addAll(lf_to_lits(ale.getRHS()));
		   } else if (ale.getOp() == Abstract_LogExpr.and) {
			   out.addAll(lf_to_lits(ale.getLHS()));
			   out.addAll(lf_to_lits(ale.getRHS()));
		   }
	   }
	   return out;
   }

   
   public void addBel(Abstract_Predicate gb) {
	   addBel(new Abstract_Literal((Abstract_Predicate) gb));
   }

    
   public GOALAgent toMCAPL() {
		try{
		    GOALAgent ag = new GOALAgent(fAgName);
		    add_fields(ag);
		    return ag;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

   public GOALAgent toMCAPL(MAS mas) {
		try{
		    	GOALAgent ag = new GOALAgent(mas, fAgName);
		    	add_fields(ag);
		    	return ag;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
    
    private void add_fields(GOALAgent ag) {
    	List<Abstract_GOALModule> name_map = new ArrayList<Abstract_GOALModule>();
    	List<Abstract_Predicate> names = new ArrayList<Abstract_Predicate>();
    	for (Abstract_GOALModule m: modules) {
    		if (m.hasName()) {
    			name_map.add(m);
    			names.add(m.getModuleName());
    		}
    	}
    	
    	for (Abstract_GOALModule m: modules) {
    		m.setModuleNames(names, name_map);
    		try {
    			ag.addModule(m.toMCAPL());
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	for (Abstract_Predicate l: beliefs) {
    		ag.addInitialBel(new Literal(l.toMCAPL()));
    	}
       	for (Abstract_Goal g: goals) {
    		ag.addGoal(g.toMCAPL());
    	}
    	for (Abstract_Rule r: knowledge_rules) {
    		ag.addRule(r.toMCAPL());
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

    public int newJPFObject(MJIEnv env) {
    	int objref = env.newObject("goal.syntax.ast.Abstract_GOALAgent");
    	env.setReferenceField(objref, "fAgName", env.newString(fAgName));
    	int bRef = env.newObjectArray("ail.syntax.ast.Abstract_Literal", beliefs.length);
     	int gRef = env.newObjectArray("ail.syntax.ast.Abstract_Goal", goals.length);
       	int rRef = env.newObjectArray("ail.syntax.ast.Abstract_Rule", rules.length);
		int krRef = env.newObjectArray("ail.syntax.ast.Abstract_Rule", knowledge_rules.length);
		int pRef = env.newObjectArray("goal.syntax.ast.Abstract_GOALModule", modules.length);
    	for (int i = 0; i < beliefs.length; i++) {
    		env.setReferenceArrayElement(bRef, i, beliefs[i].newJPFObject(env));
    	}
     	for (int i = 0; i < rules.length; i++) {
       		env.setReferenceArrayElement(rRef, i, rules[i].newJPFObject(env));
       	}
		for (int i = 0; i < knowledge_rules.length; i++) {
			env.setReferenceArrayElement(krRef, i, knowledge_rules[i].newJPFObject(env));
		}
		for (int i = 0; i < modules.length; i++) {
       		env.setReferenceArrayElement(pRef, i, modules[i].newJPFObject(env));
       	}
      	for (int i = 0; i < goals.length; i++) {
       		env.setReferenceArrayElement(gRef, i, goals[i].newJPFObject(env));
       	}
      	env.setReferenceField(objref, "beliefs", bRef);
		env.setReferenceField(objref, "rules", rRef);
		env.setReferenceField(objref, "knowledge_rules", krRef);
		env.setReferenceField(objref, "modules", pRef);
      	env.setReferenceField(objref, "goals", gRef);
      	return objref;
   	
    }

    
    public void addGoal(Abstract_Term g) {
    	Abstract_Goal gl = new Abstract_Goal((Abstract_Predicate) g, Abstract_Goal.achieveGoal);
    	// gl.setGoalBase(i);
       	int newsize = goals.length + 1;
    	Abstract_Goal[] newgoals = new Abstract_Goal[newsize];
    	for (int j = 0; j < goals.length; j++) {
    		newgoals[j] = goals[j];
    	}
    	newgoals[goals.length] = gl; 
    	goals = newgoals;

    }
    

}
