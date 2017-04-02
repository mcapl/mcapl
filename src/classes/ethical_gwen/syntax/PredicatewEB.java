// ----------------------------------------------------------------------------
// Copyright (C) 2016 Louise A. Dennis, Michael Fisher, Marija Slavkovik and Matt Webster
// 
// This file is part of Ethical Gwendolen
//
// Ethical Gwendolen is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Ethical Gwendolen is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with Ethical Gwendolen if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------
package ethical_gwen.syntax;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import ail.semantics.AILAgent;
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
	@Override
	public Iterator<Unifier> logicalConsequence(final EvaluationBasewNames<PredicateTerm> e, final RuleBase rb, final Unifier un, final Set<String> varnames, AILAgent.SelectionOrder so) {
		return new EvaluationAndRuleBaseIterator(eb, rb, un, this, varnames, so);
	}
	
	public void transformEB(EthicalGwendolenAgent a) {
		eb = new NamedEvaluationBase(a.getBB(ebname), ebname);
	}
	
	public PredicatewEB clone() {
		Predicate p = super.clone();
		return new PredicatewEB(p, eb);
	}

}
