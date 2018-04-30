package gwendolen.parser;

import java.util.ArrayList;

import ail.syntax.ast.Abstract_StringTerm;
import ail.syntax.ast.Abstract_Term;
import ail.syntax.ast.Abstract_Unifier;
import ajpf.psl.MCAPLTerm;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.VM;

public class AbstractStringTermImpl implements Abstract_StringTerm {

	@Override
	public Abstract_Term clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Abstract_Term getTerm(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Abstract_Term applyu(Abstract_Unifier u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void unifies(Abstract_Term t, Abstract_Unifier u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addParams(ArrayList<Abstract_Term> tl) {
		// TODO Auto-generated method stub

	}

	@Override
	public int createInJPF(VM vm) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MCAPLTerm toMCAPL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int newJPFObject(MJIEnv env) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getString() {
		// TODO Auto-generated method stub
		return null;
	}

}
