package ethical_gwen.mas;

import ail.mas.DefaultEnvironment;
import ail.syntax.Action;
import ail.syntax.Unifier;
import ail.syntax.VarTerm;
import ail.syntax.ListTerm;
import ail.util.AILexception;
import ail.syntax.PlanLibrary;
import ail.syntax.Event;
import ail.mas.AILEnv;

import ajpf.MCAPLJobber;

import ethical_gwen.semantics.EthicalGwendolenAgent;

public interface DefaultEthicalEnvironment extends AILEnv {
	public PlanLibrary invokeEthicalPlanner(Event e, ListTerm policy);


}
