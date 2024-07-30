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

import goal.syntax.ActionRule;
import gov.nasa.jpf.vm.MJIEnv;

import java.util.ArrayList;
import java.util.List;

import ail.syntax.Deed;
import ail.syntax.Guard;
import ail.syntax.ast.Abstract_Unifier;
import ail.syntax.ast.Abstract_Action;
import ail.syntax.ast.Abstract_BaseAILStructure;
import ail.syntax.ast.Abstract_Predicate;
import ail.syntax.ast.Abstract_Deed;
import ail.syntax.ast.Abstract_Event;
import ail.syntax.ast.Abstract_GBelief;
import ail.syntax.ast.Abstract_Goal;
import ail.syntax.ast.Abstract_Guard;
import ail.syntax.ast.Abstract_Literal;
import ail.syntax.ast.Abstract_Pred;
import ail.syntax.ast.Abstract_Term;
import ail.syntax.ast.Abstract_VarTerm;
import ail.syntax.ast.Abstract_Plan;

public class Abstract_ActionRule extends Abstract_Plan {
	int type = ActionRule.ifthen;
	
	public Abstract_ActionRule() {
		setTrigger(new Abstract_Event(Abstract_Event.AILAddition, new Abstract_Goal(new Abstract_VarTerm("Any"), Abstract_Goal.achieveGoal)));
		ArrayList<Abstract_Deed> prf = new ArrayList<Abstract_Deed>();
		setPrefix(prf);
		
	}
	
	public void setMentalStateCond(Abstract_MentalState lf) {
		Abstract_Guard guard = lf;
		if (guard != null) {
			setContextSingle(guard, 1);
		}
	}
	
	/**
     * Setter method for the plan body.
     * 
     * @param bd The plan's body.
     */
    public void setBody(ArrayList<Abstract_Deed> bd) {
       	super.setBody(bd);

    	Abstract_Guard current_context = context[0];
    	
    	context = new Abstract_Guard[bd.size()];

  		if (bd.size() > 1) {
  			for (int j = 0; j < (bd.size() - 1); j++) {
  				context[j] = new Abstract_Guard(new Abstract_GBelief());
  			}
  		}
  		
  		context[bd.size() - 1] = current_context;
    }
	
	public Abstract_ActionRule(Abstract_MentalState ms, ArrayList<Abstract_Deed> ds) {
		setTrigger(new Abstract_Event(Abstract_Event.AILAddition, new Abstract_Goal(new Abstract_VarTerm("Any"), Abstract_Goal.achieveGoal)));
		setContextSingle(ms, ds.size());
		ArrayList<Abstract_Deed> prf = new ArrayList<Abstract_Deed>();
		setPrefix(prf);
		ArrayList<Abstract_Deed> body = ds;
		setBody(body);
	}
	
	  /**
     * Constructs a plan from a Literal.  This needs to be expanded.
     * @param l
     */
    public Abstract_ActionRule(Abstract_Literal l) {
    	if (l.getFunctor().equals("plan")) {
    		setTrigger(new Abstract_Event(Abstract_Event.AILAddition, new Abstract_Goal(new Abstract_VarTerm("Any"), Abstract_Goal.achieveGoal)));
    		Abstract_Term guard = l.getTerm(0);
    		ArrayList<Abstract_Guard> guards = new ArrayList<Abstract_Guard>();
    		guards.add(new Abstract_Guard(new Abstract_Goal(new Abstract_Literal(true, new Abstract_Pred((Abstract_Predicate) guard)), Abstract_Goal.achieveGoal)));
    		setContext(guards);
    		setPrefix(new ArrayList<Abstract_Deed>());
    		ArrayList<Abstract_Deed> deeds = new ArrayList<Abstract_Deed>();
    		Abstract_Term body = l.getTerm(2);
    		Abstract_Deed deed = new Abstract_Deed(Abstract_Deed.AILAddition, new Abstract_Goal(new Abstract_Literal(true, new Abstract_Pred((Abstract_Predicate) body)), Abstract_Goal.performGoal));
    		deeds.add(deed);
    		setBody(deeds);
    	}
    }
    
    public ActionRule toMCAPL() {
    	ArrayList<Deed> newdeed = new ArrayList<Deed>();
    	int counter=0;
    	ArrayList<Abstract_Deed> newbody = transform(body);
    	for (int i = newbody.size() - 1; i >= 0; i--) {
    		newdeed.add(counter, newbody.get(i).toMCAPL());
    		counter++;
    	}
    	Guard ms = context[context.length - 1].toMCAPL();
    	return new ActionRule(ms, newdeed, type);
    }
        
    private ArrayList<Abstract_Deed> transform(Abstract_Deed[] oldbody) {
    	ArrayList<Abstract_Deed> newbody = new ArrayList<Abstract_Deed>();
       	for (int i = 0; i < oldbody.length; i++) {
    		Abstract_Deed deed = oldbody[i];
    		Abstract_Predicate dcontent = (Abstract_Predicate) deed.getContent();
    		if (dcontent.getFunctor().equals("tuple")) {
    			if (dcontent.getTermSize() > 1) {
    				ArrayList<Abstract_Deed> insertions = new ArrayList<Abstract_Deed>();
    				ArrayList<Abstract_Deed> deletions = new ArrayList<Abstract_Deed>();
    				for (Abstract_Term t: dcontent.getTerms()) {
    					Abstract_Deed newdeed = new Abstract_Deed(deed.getTrigType(), deed.getCategory(), (Abstract_Predicate) t);
    					handle_not(newdeed);
    					if (newdeed.getTrigType() == Abstract_BaseAILStructure.AILAddition) {
    						insertions.add(newdeed);
    					} else {
    						deletions.add(newdeed);
    					}
    				}
   					for (Abstract_Deed d: deletions) {
						newbody.add(d);
					}
					for (Abstract_Deed d: insertions) {
						newbody.add(d);
					}

    			} else {
    				handle_not(deed);
    				newbody.add(deed);
    			}
    		} else {
    			handle_not(deed);
    			newbody.add(deed);
    		}
       	}
       	return newbody;
  
    }
       	
    private void handle_not(Abstract_Deed deed) {
		Abstract_Predicate dcontent = (Abstract_Predicate) deed.getContent();
		if (dcontent.getFunctor().equals("not")) {
			if (deed.getTrigType() == Abstract_BaseAILStructure.AILAddition) {
				deed.setTrigType(Abstract_BaseAILStructure.AILDeletion);
				deed.setContent(dcontent.getTerm(0));
			} else {
				deed.setTrigType(Abstract_BaseAILStructure.AILAddition);
				deed.setContent(dcontent.getTerm(0));
			}
		}
    	
    }
    
    public void setType(int t) {
    	type = t;
    }
    
    public void merge(ArrayList<Abstract_ActionRule> rs) {
    	Abstract_ModuleCallAction mca = new Abstract_ModuleCallAction(context[0], rs);
    	ArrayList<Abstract_Deed> deeds = new ArrayList<Abstract_Deed>();
    	deeds.add(new Abstract_Deed(mca));
    	setBody(deeds);
    }
    
    public int newJPFObject(MJIEnv env) {
    	int objref = env.newObject("goal.syntax.ast.Abstract_ActionRule");
    	int bodyref = env.newObjectArray("ail.syntax.ast.Abstract_Deed", body.length);
    	int prefixref = env.newObjectArray("ail.syntax.ast.Abstract_Deed", prefix.length);
    	int contextref = env.newObjectArray("ail.syntax.ast.Guard", context.length);
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
    	env.setIntField(objref, "type", type);
    	return objref;
    }
    
    public static Abstract_Unifier getUnifier(String functor, Abstract_Term[] parameters, Abstract_Term target) {
    	Abstract_Predicate pred = new Abstract_Predicate(functor);
    	pred.setTerms(parameters);
    	
    	Abstract_Predicate t = (Abstract_Predicate) target;
    	
     	Abstract_Unifier u = new Abstract_Unifier();
    	pred.unifies(target, u);
    	return u;
    }

	public void resolveUserSpecOrCallModule(List<Abstract_Predicate> names2, List<Abstract_GOALModule> names) {
		for (int index = 0; index < body.length; index++) {
			Abstract_Deed d = body[index];
			if (d.getContent() instanceof Abstract_UserSpecOrModuleCall) {
				Abstract_Predicate dp = (Abstract_Predicate) d.getContent();
				if (names2.contains(dp)) {
					body[index] = new Abstract_Deed(new Abstract_ModuleCallAction(names.get(names2.indexOf(dp))));
				} else {
					body[index] = new Abstract_Deed(new Abstract_Action(dp));
				}
			}
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.ast.Abstract_Plan#toString()
	 */
	@Override
	public String toString() {
		String s = "";
		if (type == ActionRule.ifthen) {
			s = "if ";
			boolean first = true;
			s += context[context.length - 1].toString(); 
			s += " then " ;
			for (Abstract_Deed d: body) {
				if (first) {
					first = false;
				} else {
					s += ", ";
				}
				s += d.toString(); 
			}
		} else if (type == ActionRule.foralldo) {
			s = "forall ";
			boolean first = true;
			s += context[context.length - 1].toString(); 
			s +=  " do ";
			for (Abstract_Deed d: body) {
				if (first) {
					first = false;
				} else {
					s += ", ";
				}
				s += d.toString(); 
			}
			
		} else if (type == ActionRule.listalldo) {
			s = "listall " + context.toString() + " do " + body.toString();
		} else {
			s = "unknown rule type";
		}
		return s;
	}



}
