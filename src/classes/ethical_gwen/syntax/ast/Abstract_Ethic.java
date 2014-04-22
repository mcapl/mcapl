package ethical_gwen.syntax.ast;

import ail.syntax.ast.Abstract_Predicate;

import ethical_gwen.syntax.Ethic;
import gov.nasa.jpf.vm.MJIEnv;

public class Abstract_Ethic {
	Abstract_Predicate context;
	Abstract_Predicate ethic;
	int score;
	
	public Abstract_Ethic(Abstract_Predicate c, Abstract_Predicate e, String s) {
		context = c;
		ethic = e;
		score = Integer.parseInt(s);
	}
	
	public Ethic toMCAPL() {
		return new Ethic(context.toMCAPL(), ethic.toMCAPL(), score);
	}
	
    public int newJPFObject(MJIEnv env) {
    	int objref = env.newObject("ethical_gwen.syntax.ast.Abstract_Ethic");
		env.setReferenceField(objref, "context", context.newJPFObject(env));
		env.setReferenceField(objref, "ethic", ethic.newJPFObject(env));
		env.setIntField(objref, "score", score);
		return objref;
    }
}
