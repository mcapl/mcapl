package ail.syntax;

import java.util.Iterator;
import java.util.List;
import java.util.Collections;

public class TrivialEvaluationBase implements LogicalEvaluationBase {

	@Override
	public Iterator<GuardAtom> getRelevant(GuardAtom ga) {
		return Collections.<GuardAtom>emptyList().iterator();
	}
	
	public Iterator<Predicate> getRelevant(Predicate p) {
		return Collections.<Predicate>emptyList().iterator();
		
	}

}
