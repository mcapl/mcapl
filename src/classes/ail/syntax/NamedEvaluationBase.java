package ail.syntax;

import java.util.Iterator;

import ail.util.Tuple;

public class NamedEvaluationBase<K extends Unifiable> implements EvaluationBasewNames<K> {
	String name;
	EvaluationBase<K> eb;
	
	public NamedEvaluationBase(EvaluationBase<K> e, String s) {
		name = s;
		eb = e;
	}

	@Override
	public Iterator<K> getRelevant(K ga) {
		// TODO Auto-generated method stub
		return eb.getRelevant(ga);
	}

	@Override
	public Iterator<Tuple<K, String>> getRelevantTuple(K ga) {
		final Iterator<K> ebl = eb.getRelevant(ga);
		
		// TODO Auto-generated method stub
		return new Iterator<Tuple<K, String>>() {

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return ebl.hasNext();
			}

			@Override
			public Tuple<K, String> next() {
				// TODO Auto-generated method stub
				return new Tuple(ebl.next(), name);
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				
			}
			
		};
	}
	
	

}
