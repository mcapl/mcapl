package goal.syntax;

import ail.syntax.Action;

public class PrintAction extends Action {
	public PrintAction(String s) {
		super(s);
	}
	
	public PrintAction(Action a) {
		super(a.getFunctor());
		addTerms(a.getTerms());
	}
	
	public PrintAction clone() {
		return new PrintAction(super.clone());
	}
}
