package goal.syntax.ast;

import ail.syntax.ast.Abstract_Predicate;
import ail.syntax.ast.Abstract_Rule;
import ail.syntax.ast.Abstract_Goal;

public interface Abstract_KRGOALS {
	public void addFact(Abstract_Predicate p);
	
	public void addKRule(Abstract_Rule r);
	
	public void addGoal(Abstract_Predicate g);
}
