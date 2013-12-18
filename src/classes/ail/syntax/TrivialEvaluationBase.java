package ail.syntax;

import java.util.Iterator;
import java.util.List;
import java.util.Collections;

public class TrivialEvaluationBase<K extends Unifiable> implements EvaluationBase<K> {

	//@Override
	//public Iterator<K> getRelevant(GuardAtom<K> ga) {
		// TODO Auto-generated method stub
	//	return Collections.<K>emptyList().iterator();
	//}

	@Override
	public Iterator<K> getRelevant(K ga) {
		// TODO Auto-generated method stub
		return Collections.<K>emptyList().iterator();
	}



}
