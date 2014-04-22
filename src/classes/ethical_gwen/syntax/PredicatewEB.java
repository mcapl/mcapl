package ethical_gwen.syntax;

import java.util.Iterator;
import java.util.List;

import ail.syntax.EvaluationAndRuleBaseIterator;
import ail.syntax.EvaluationBasewNames;
import ail.syntax.EvaluationBase;
import ail.syntax.NamedEvaluationBase;
import ail.syntax.Predicate;
import ail.syntax.PredicateTerm;
import ail.syntax.RuleBase;
import ail.syntax.Term;
import ail.syntax.Unifier;
import ail.syntax.ast.Abstract_Term;

import ethical_gwen.semantics.EthicalGwendolenAgent;

public class PredicatewEB extends Predicate {
	NamedEvaluationBase<PredicateTerm> eb;
	String ebname;
	
	public PredicatewEB(Predicate p, String s) {
		super(p.getFunctor());
		setTerms(p.getTerms());
		ebname = s;
	}

	public PredicatewEB(Predicate p, NamedEvaluationBase<PredicateTerm> e) {
		super(p.getFunctor());
		setTerms(p.getTerms());
		eb = e;
	}

	/* (non-Javadoc)
    * @see ail.syntax.LogicalFormula#logicalConsequence(ail.syntax.EvaluationBasewNames, ail.syntax.RuleBase, ail.syntax.Unifier, java.util.List)
    */
	public Iterator<Unifier> logicalConsequence(final EvaluationBasewNames<PredicateTerm> e, final RuleBase rb, final Unifier un, final List<String> varnames) {
		return new EvaluationAndRuleBaseIterator(eb, rb, un, this, varnames);
	}
	
	public void transformEB(EthicalGwendolenAgent a) {
		eb = new NamedEvaluationBase(a.getBB(ebname), ebname);
	}
	
	public PredicatewEB clone() {
		Predicate p = super.clone();
		return new PredicatewEB(p, eb);
	}

}
