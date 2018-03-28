package ail.semantics;

import java.util.List;
import java.util.Set;

import ail.syntax.BeliefBase;
import ail.syntax.CapabilityLibrary;
import ail.syntax.GoalBase;
import ail.syntax.Message;
import ail.syntax.PlanLibrary;
import ail.syntax.RuleBase;
import ail.syntax.StringTerm;

public interface AgentMentalState {
	public BeliefBase getBB(StringTerm s);
	
	public Set<String> getBBList();
	
	public RuleBase getRuleBase();
	
	public CapabilityLibrary getCL();
	
	public List<Message> getOutbox();
	
	public List<Message> getInbox();
	
	public GoalBase getGoalBase(StringTerm s);
	
	public Set<String> getGBList();
	
	public PlanLibrary getPL();
}
