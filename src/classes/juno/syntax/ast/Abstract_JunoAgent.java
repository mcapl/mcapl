package juno.syntax.ast;

import java.util.ArrayList;

import ail.syntax.ast.Abstract_Agent;
import ail.syntax.ast.Abstract_Literal;
import gov.nasa.jpf.vm.MJIEnv;
import juno.semantics.JunoAgent;

public class Abstract_JunoAgent extends Abstract_Agent {
	String json_file;
	
	Abstract_JunoBeliefRule[] brules = new Abstract_JunoBeliefRule[0];
	Abstract_JunoActionRule[] arules = new Abstract_JunoActionRule[0];
	
	public Abstract_JunoAgent(String json_file) {
		super("juno");
		this.json_file = json_file;
	}

	public JunoAgent toMCAPL() {
		try {
			JunoAgent juno = new JunoAgent(json_file);
			for (Abstract_JunoBeliefRule b:brules) {
				juno.add_brule(b.toMCAPL());
			}
			
			for (Abstract_JunoActionRule a:arules) {
				juno.add_arule(a.toMCAPL());
			}
			return juno;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void add_brule(Abstract_JunoBeliefRule rule) {
		int newsize = brules.length + 1;
    	Abstract_JunoBeliefRule[] newbeliefs = new Abstract_JunoBeliefRule[newsize];
    	for (int i = 0; i < brules.length; i++) {
    		newbeliefs[i] = brules[i];
    	}
    	newbeliefs[brules.length] = rule; 
    	brules = newbeliefs;
	}
	
	public void add_arule(Abstract_JunoActionRule rule) {
		int newsize = arules.length + 1;
    	Abstract_JunoActionRule[] newbeliefs = new Abstract_JunoActionRule[newsize];
    	for (int i = 0; i < arules.length; i++) {
    		newbeliefs[i] = arules[i];
    	}
    	newbeliefs[arules.length] = rule; 
    	arules = newbeliefs;
	}
	
	public int newJPFObject(MJIEnv env) {
		int objref = env.newObject("juno.syntax.ast.Abstract_JunoAgent");
		env.setReferenceField(objref, "fAgName", env.newString(fAgName));
		env.setReferenceField(objref, "json_file", env.newString(json_file));
		
		int bRef = env.newObjectArray("juno.syntax.ast.Abstract_JunoBeliefRule", brules.length);
		int aRef = env.newObjectArray("juno.syntax.ast.Abstract_JunoActionRule", arules.length);
		
		for (int i = 0; i < brules.length; i++) {
			env.setReferenceArrayElement(bRef, i, brules[i].newJPFObject(env));
		}
		
		for (int i = 0; i < arules.length; i++) {
			env.setReferenceArrayElement(aRef, i, arules[i].newJPFObject(env));
		}
		
		env.setReferenceField(objref, "brules", bRef);
		env.setReferenceField(objref, "arules", aRef);

		// System.err.println("returning objref");
		return objref;
	}
}
