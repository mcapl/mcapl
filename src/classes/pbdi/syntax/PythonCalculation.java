package pbdi.syntax;

import java.util.Iterator;
import java.util.Set;

import ail.semantics.AILAgent.SelectionOrder;
import ail.semantics.AgentMentalState;
import ail.syntax.EvaluationBase;
import ail.syntax.EvaluationBaseIterator;
import ail.syntax.GuardAtom;
import ail.syntax.ListEvaluationBase;
import ail.syntax.Literal;
//import ail.syntax.LogicalFormula;
import ail.syntax.PredicateIndicator;
import ail.syntax.PredicateTerm;
import ail.syntax.StringTerm;
import ail.syntax.StringTermImpl;
import ail.syntax.Unifier;
import pbdi.semantics.PBDIAgent;

public class PythonCalculation extends Literal implements GuardAtom<PredicateTerm> {
	
	public static byte PythonCalculation = 20;
	
	public PythonCalculation(Literal l) {
		super(l);
	}

	@Override
	public Iterator<Unifier> logicalConsequence(AgentMentalState ag, Unifier un, Set<String> varnames,
			SelectionOrder so) {
		PBDIAgent agent = (PBDIAgent) ag;
		EvaluationBase<PredicateTerm> eb = new ListEvaluationBase(agent.getPCs());
		return new EvaluationBaseIterator(eb, un, this, so);
		
	}

	@Override
	public boolean unifieswith(PredicateTerm obj, Unifier u, String ebname) {
		// TODO Auto-generated method stub
		return super.unifieswith(obj, u, ebname);
	}

	@Override
	public PythonCalculation clone() {
		// TODO Auto-generated method stub
		return new PythonCalculation(super.clone());
	}

	@Override
	public boolean isTrivial() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public StringTerm getEB() {
		// TODO Auto-generated method stub
		return new StringTermImpl("");
	}

	@Override
	public byte getEBType() {
		// TODO Auto-generated method stub
		return PythonCalculation;
	}

	@Override
	public PredicateIndicator getPurePredicateIndicator() {
		return getPredicateIndicator();
	}

}
