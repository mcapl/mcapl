package ail.syntax;

import java.util.Iterator;
import java.util.List;

import ail.semantics.AILAgent.SelectionOrder;
import ail.semantics.AgentMentalState;

public abstract class AILComparison implements GLogicalFormula, LogicalFormula {

	@Override
	abstract public AILComparison clone();
	
}
