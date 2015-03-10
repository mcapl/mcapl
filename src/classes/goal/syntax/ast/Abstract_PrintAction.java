package goal.syntax.ast;

import goal.syntax.PrintAction;
import gov.nasa.jpf.vm.MJIEnv;

import java.util.ArrayList;

import ail.syntax.Action;
import ail.syntax.Predicate;
import ail.syntax.ast.Abstract_Deed;
import ail.syntax.ast.Abstract_Predicate;
import ail.syntax.ast.Abstract_Term;
import ail.syntax.ast.Abstract_Action;

public class Abstract_PrintAction extends Abstract_Action {
	public Abstract_PrintAction() {
		super("print");
	}
	
	public void addParams(ArrayList<Abstract_Term> tl) {
		addTerm(tl.get(0));
	}
	
	@Override
	public PrintAction toMCAPL() {
		return new PrintAction(super.toMCAPL());
	}
	
	@Override
	public int newJPFObject(MJIEnv env) {
		return super.newJPFObject(env);
	}
}
