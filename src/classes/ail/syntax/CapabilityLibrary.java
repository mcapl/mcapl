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

}
