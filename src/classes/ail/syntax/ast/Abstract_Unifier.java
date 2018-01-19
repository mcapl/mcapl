package ail.syntax.ast;

import ail.syntax.Term;
import ail.syntax.VarTerm;
import ajpf.util.VerifyMap;

public class Abstract_Unifier {
	/**
	 * A Function mapping variables to their instantiations.
	 */
   private VerifyMap<Abstract_VarTerm, Abstract_Term> function = new VerifyMap<Abstract_VarTerm, Abstract_Term>();

    /**
     * gets the value for a Var, if it is unified with another var, gets this
     * other's value
     */
    public Abstract_Term get(String var) {
        return get(new Abstract_VarTerm(var));
    }

    /**
     * gets the value for a Var, if it is unified with another var, gets this
     * other's value
     */
    public Abstract_Term get(Abstract_VarTerm vtp) {
    	for (Abstract_VarTerm v: function.keySet() ) {
    		if (vtp.equals(v)) {
    			return function.get(v);
    		}
    	}
        return function.get(vtp);
    }
    
    public void put(Abstract_VarTerm key, Abstract_Term value) {
    	function.put(key, value);
    }

}
