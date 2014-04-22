package ethical_gwen.syntax.ast;

import java.util.HashMap;

import ethical_gwen.syntax.PredicatewEB;
import gov.nasa.jpf.vm.MJIEnv;
import ail.syntax.Predicate;
import ail.syntax.Term;
import ail.syntax.ast.Abstract_Predicate;
import ail.syntax.ast.Abstract_Term;

public class Abstract_PredicatewEB extends Abstract_Predicate {
	static HashMap<String,Integer> strings = new HashMap<String,Integer>();
	String eb;
	
	public Abstract_PredicatewEB(Abstract_Predicate t, String w) {
		super(t.getFunctor());
		setTerms(t.getTerms());
		eb = w;
		
	}
	
	public PredicatewEB toMCAPL() {
		Predicate s = new Predicate(getFunctor());
		for (Abstract_Term t: getTerms()) {
			s.addTerm((Term) t.toMCAPL());
		}
		return new PredicatewEB(s, eb);

	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.psl.ast.Abstract_MCAPLTerm#newJPFObject(gov.nasa.jpf.jvm.MJIEnv)
	 */
	public int newJPFObject(MJIEnv env) {
		int ref = env.newObject("ethical_gwen.syntax.ast.Abstract_PredicatewEB");
		if (strings.containsKey(getFunctor())) {
			env.setReferenceField(ref, "functor", strings.get(getFunctor()));
		} else {
			int stringref = env.newString(getFunctor());
			strings.put(getFunctor(), stringref);
			env.setReferenceField(ref, "functor", stringref);
		}
		env.setReferenceField(ref, "terms", newJPFTermArray(env));
		return ref;

	}



}
