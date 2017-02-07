package goal.semantics.operationalrules;

import goal.syntax.PrintAction;
import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import ail.syntax.Action;
import ail.syntax.Deed;

public class PrintActionExecutor extends ActionExecutor {
	Action action;

	@Override
	public boolean checkPreconditions(AILAgent a) {
		Deed d = a.getIntention().hdD();
		
		boolean isaction = d.getCategory() == Deed.DAction;
		
		if (isaction) {
			action = (Action) d.getContent();
			action.apply(a.getIntention().hdU());
			return (action instanceof PrintAction);
		} else {
			return false;
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void apply(AILAgent a) {
		super.apply(a);
		System.out.println(action.getTerm(0));
		a.getIntention().tlI(a);
	//	a.setIntention(null);
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Print Action Executor";
	}

}
