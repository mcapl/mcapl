package ail.syntax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;

import ail.semantics.AILAgent;

import ail.syntax.BeliefBase.BelEntry;

public class CapabilityLibrary implements EvaluationBase<Capability> {
	HashMap<PredicateIndicator, ArrayList<Capability>> capMap = new HashMap<PredicateIndicator, ArrayList<Capability>>();

	@Override
	public Iterator<Capability> getRelevant(EBCompare<Capability> ga) {
		Capability c = ((GCapability) ga).getCap();
		Predicate cPred = c.getCap();
		return getRelevant(cPred);
	}
	
	public Iterator<Capability> getRelevant(Predicate cPred) {
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
	
	public Capability getByName(String s) {
		Iterator<Capability> cs = iterator();
		while (cs.hasNext()) {
			Capability c = cs.next();
			if (c.getCap().getFunctor().equals(s)) {
				return c;
			}
		}
		return null;
	}
	
	public Iterator<Capability> iterator() {
		ArrayList<Capability> cs = new ArrayList<Capability>();
		
		for (ArrayList<Capability> cl: capMap.values()) {
			cs.addAll(cl);
		}
		
		return cs.iterator();

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
	
	// WARNING: This is going to need to be made more general.  At the moment it is assuming we
	// are supplying the pre and post conditions for reasoning about equivalence.
	public Capability findEquivalent(Capability oldcap, Predicate capname, Predicate Pre, Predicate Post, RuleBase rb, Unifier u) {
		PredicateIndicator pi = capname.getPredicateIndicator();
		
		// Note assuming here there is only one capability with this pi.  Is this a sensible
		// assumption (probably), if so refactor capMap.
		// Capability toReplace = capMap.get(pi).get(0);
		
		// Capability oldcap = capMap.get(pi).get(0);

		
		GBelief pgb = new GBelief(Post);

		for (ArrayList<Capability> l: capMap.values()) {
			
			Capability c = l.get(0);
			
			if (c != capMap.get(pi).get(0)) {
			
				EvaluationBasewNames<PredicateTerm> eb = 
	     			 new NamedEvaluationBase<PredicateTerm>(new ConjunctionFormulaEvaluationBase(c.getPre()), "precondition");
				GBelief gb = new GBelief(Pre);
				Iterator<Unifier> preuni = gb.logicalConsequence(eb, rb, new Unifier(), Pre.getVarNames());
				if (preuni.hasNext()) {
				
					Capability cc = (Capability) c.clone();
					cc.standardise_apart(oldcap, u, oldcap.getVarNames());
					Unifier u1 = preuni.next();
					cc.apply(u1);
					//BeliefBase postbb = new BeliefBase();
					//Post.apply(u);
					//postbb.add(new Literal(true, Post));
				
					//AILAgent minag = new AILAgent("tmp");
				
					//minag.setBeliefBase(postbb);
					//minag.setRuleBase(rb);
					
					// pgb.apply(u);
					
					EvaluationBasewNames<PredicateTerm> posteb = 
							new NamedEvaluationBase<PredicateTerm>(new ConjunctionFormulaEvaluationBase(cc.getPost()), "post");
					
					// cc.apply(u);
				
					// NEED TO RETURN THE UNIFIER!!
					Iterator<Unifier> postuni = pgb.logicalConsequence(posteb, rb, new Unifier(), c.getPost().getVarNames());
					if (postuni.hasNext()) {
						u.compose(postuni.next());
						cc.apply(u);
						// cc.toString();
						
//						oldcap.standardise_apart(cc, u, cc.getVarNames());
						pgb.apply(u);
						
						EvaluationBasewNames<PredicateTerm> peb = new NamedEvaluationBase<PredicateTerm>(new ConjunctionFormulaEvaluationBase(oldcap.getPost()), "postcondition");
						Iterator<Unifier> pun = pgb.logicalConsequence(peb, rb, new  Unifier(), Post.getVarNames());
						Unifier puni = pun.next();
						// puni infies vars in post but not in oldcap.
						
						u.compose(puni);

						return cc;
						
						
					}
				}
			}
			
		}
		
		return null;
	}

}
