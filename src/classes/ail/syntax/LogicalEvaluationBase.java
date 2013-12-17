package ail.syntax;

import java.util.List;

import java.util.Iterator;

public interface LogicalEvaluationBase extends EvaluationBase {
	public Iterator<Predicate> getRelevant(Predicate t);

}
