package ail.syntax;

import java.util.Iterator;

import ail.util.Tuple;

public interface EvaluationBasewNames<K extends Unifiable> extends EvaluationBase<K> {
	public Iterator<Tuple<K, String>> getRelevantTuple(K ga);
}
