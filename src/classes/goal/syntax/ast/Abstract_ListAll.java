package goal.syntax.ast;

import goal.syntax.ListAll;
import goal.syntax.MentalState;
import gov.nasa.jpf.vm.MJIEnv;

import java.util.Iterator;
import java.util.List;

import ail.semantics.AILAgent.SelectionOrder;
import ail.semantics.AgentMentalState;
import ail.syntax.GLogicalFormula;
import ail.syntax.Unifiable;
import ail.syntax.Unifier;
import ail.syntax.ast.Abstract_GLogicalFormula;
import ail.syntax.ast.Abstract_VarTerm;

public class Abstract_ListAll implements Abstract_GLogicalFormula {
	Abstract_VarTerm v;
	Abstract_MentalState ms;
	
	public Abstract_ListAll(Abstract_VarTerm v, Abstract_MentalState ms) {
		this.v = v;
		this.ms = ms;
	}

	@Override
	public ListAll toMCAPL() {
		return new ListAll(v.toMCAPL(), ms.toMCAPL());
	}

	@Override
	public int newJPFObject(MJIEnv env) {
    	int objref = env.newObject("goal.syntax.ast.Abstract_ListAll");
    	env.setReferenceField(objref, "v", v.newJPFObject(env));
    	env.setReferenceField(objref, "ms", ms.newJPFObject(env));
    	return objref;
	}

	@Override
	public boolean isTrivial() {
		return false;
	}
	
	@Override
	public String toString() {
		String s = "listall " +  v.toString();
		s += " <- ";
		s += ms.toString();
		return s;
	}
}
