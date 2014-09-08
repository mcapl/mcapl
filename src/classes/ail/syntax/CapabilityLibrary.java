package ail.syntax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;

import ail.syntax.BeliefBase.BelEntry;

public class CapabilityLibrary implements EvaluationBase<Capability> {
	HashMap<PredicateIndicator, ArrayList<Capability>> capMap = new HashMap<PredicateIndicator, ArrayList<Capability>>();

	@Override
	public Iterator<Capability> getRelevant(EBCompare<Capability> ga) {
		Capability c = ((GCapability) ga).getCap();
		Predicate cPred = c.getCap();
		if (cPred.isVar()) {
			ArrayList<Capability> out = new ArrayList<Capability>();
			for (ArrayList<Capability> cl: capMap.values()) {
				out.addAll(cl);
			}
			return out.iterator();
		} else {
			ArrayList<Capability> cList = capMap.get(cPred.getPredicateIndicator());
            if (cList != null) {
                 return cList.iterator();
           } else {
                return Collections.<Capability>emptyList().iterator();
            }
        }
	}
	
	public void add(Capability c) {
		PredicateIndicator pi = c.getCap().getPredicateIndicator();
		if (capMap.containsKey(pi)) {
			capMap.get(pi).add(c);
		} else {
			ArrayList<Capability> cl = new ArrayList<Capability>();
			cl.add(c);
			capMap.put(pi, cl);
		}
	}
	
	public Capability findEquivalent(Predicate capname, Predicate Pre, Predicate Post, RuleBase rb) {
		PredicateIndicator pi = capname.getPredicateIndicator();
		
		// Note assuming here there is only one capability with this pi.  Is this a sensible
		// assumption (probably), if so refactor capMap.
		// Capability toReplace = capMap.get(pi).get(0);

		
		for (ArrayList<Capability> l: capMap.values()) {
			
			Capability c = l.get(0);
			
			if (c != capMap.get(pi).get(0)) {
			
	     	EvaluationBasewNames<PredicateTerm> eb = 
	     			 new NamedEvaluationBase<PredicateTerm>(new ConjunctionFormulaEvaluationBase(c.getPre()), "precondition");
	     	GBelief gb = new GBelief(Pre);
			if (gb.logicalConsequence(eb, rb, new Unifier(), Pre.getVarNames()).hasNext()) {
				
				BeliefBase postbb = new BeliefBase();
				postbb.add(new Literal(true, Post));
				
				if (c.getPost().logicalConsequence(new NamedEvaluationBase<PredicateTerm>(postbb, "post"), rb, new Unifier(), c.getPost().getVarNames()).hasNext()) {
					return c;
				}
			}
			}
			
		}
		
		return null;
	}

}
