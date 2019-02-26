package juno.syntax.ast;

import java.util.ArrayList;
import java.util.List;

import ail.syntax.ast.Abstract_Literal;
import gov.nasa.jpf.vm.MJIEnv;
import juno.syntax.JunoBeliefRule;

public class Abstract_JunoBeliefRule {
	Abstract_Literal trigger;
	Abstract_Literal[] beliefs = new Abstract_Literal[0];
	
	
	public Abstract_JunoBeliefRule(Abstract_Literal trigger) {
		this.trigger = trigger;
	}
	
	public void add_beliefs(List<Abstract_Literal> beliefs) {
		int newsize = beliefs.size();
		Abstract_Literal[] newbeliefs = new Abstract_Literal[newsize];
		for (int i = 0; i < newsize; i++) {
			newbeliefs[i] = beliefs.get(i);
		}
		this.beliefs = newbeliefs;
	}
	
	public JunoBeliefRule toMCAPL() {
		JunoBeliefRule rule = new JunoBeliefRule(trigger.toMCAPL());
		
		for (Abstract_Literal b: beliefs) {
			rule.add_belief(b.toMCAPL());
		}
		
		return rule;
	}
	
	public int newJPFObject(MJIEnv env) {
		int objref = env.newObject("juno.syntax.ast.Abstract_JunoBeliefRule");
		env.setReferenceField(objref, "trigger", trigger.newJPFObject(env));
		int bRef = env.newObjectArray("ail.syntax.ast.Abstract_Literal", beliefs.length);
		
		for (int i = 0; i < beliefs.length; i++) {
			env.setReferenceArrayElement(bRef, i, beliefs[i].newJPFObject(env));
		}
		
		env.setReferenceField(objref, "beliefs", bRef);
		return objref;
	}

}
