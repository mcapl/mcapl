package goal.syntax.ast;

import java.util.ArrayList;

import goal.syntax.ConjGoal;
import gov.nasa.jpf.vm.MJIEnv;
import ail.syntax.ast.Abstract_BaseAILStructure;
import ail.syntax.ast.Abstract_Goal;
import ail.syntax.ast.Abstract_Predicate;
import ail.syntax.ast.Abstract_Term;

public class Abstract_ConjGoal extends Abstract_Goal {
	
	Abstract_Predicate[] goals = new Abstract_Predicate[0];

	public Abstract_ConjGoal(ArrayList<Abstract_Term> tl) {
		super(new Abstract_Predicate(), Abstract_Goal.achieveGoal);
		for (Abstract_Term t: tl) {
			addGoal((Abstract_Predicate) t);
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

	public ConjGoal toMCAPL() {
		
	}
	
    public int newJPFObject(MJIEnv env) {
    	int objref = env.newObject("goal.syntax.ast.Abstract_ConjGoal");
    	int gRef = env.newObjectArray("ail.syntax.Abstract_Predicate", goals.length);
       	for (int i = 0; i < goals.length; i++) {
       		env.setReferenceArrayElement(gRef, i, goals[i].newJPFObject(env));
       	}
      	env.setReferenceField(objref, "goals", gRef);
      	return objref;
   }

}
