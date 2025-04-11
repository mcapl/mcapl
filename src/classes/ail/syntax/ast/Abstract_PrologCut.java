package ail.syntax.ast;

import ail.syntax.LogicalFormula;
import ail.syntax.PrologCut;
import gov.nasa.jpf.vm.MJIEnv;

public class Abstract_PrologCut implements Abstract_LogicalFormula {

	@Override
	public LogicalFormula toMCAPL() {
		// TODO Auto-generated method stub
		return new PrologCut();
	}

	@Override
	public int newJPFObject(MJIEnv env) {
		// TODO Auto-generated method stub
		int ref = env.newObject("ail.syntax.ast.Abstract_PrologCut");
		return ref;
	}

}
