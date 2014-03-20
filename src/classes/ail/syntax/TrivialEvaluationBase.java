package ail.syntax;

import java.util.Iterator;
import java.util.List;
import java.util.Collections;

import ail.util.Tuple;

public class TrivialEvaluationBase<K extends Unifiable> implements EvaluationBasewNames<K> {

	//@Override
	//public Iterator<K> getRelevant(GuardAtom<K> ga) {
		// TODO Auto-generated method stub
	//	return Collections.<K>emptyList().iterator();
	//}

	@Override
	public Iterator<K> getRelevant(EBCompare<K> ga) {
		// TODO Auto-generated method stub
		return Collections.<K>emptyList().iterator();
	}
	
	public Iterator<Tuple<K, String>> getRelevantTuple(EBCompare<K> ga) {
		return Collections.<Tuple<K, String>>emptyList().iterator();
	}



}
