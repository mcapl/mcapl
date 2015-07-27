package ail.syntax.ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ail.syntax.Literal;
import ail.syntax.Predicate;
import ail.syntax.PredicatewAnnotation;

public class GroundPredSets {
	public Map<String, Predicate> ground_preds = new HashMap<String, Predicate>();
	public Map<String, PredicatewAnnotation> ground_annot_preds = new HashMap<String, PredicatewAnnotation>();
	public Map<String, Literal> ground_literals = new HashMap<String, Literal>();
	
	private static GroundPredSets gps = new GroundPredSets();
	
	private GroundPredSets() {
		
	}
	
	public static GroundPredSets getInstance() {
		return gps;
	}
	
	public void clear() {
		ground_preds.clear();
	}
	
	public Predicate check_add(Predicate p) {
		if (ground_preds.containsKey(p.toString())) {
			return ground_preds.get(p.toString());
		} else {
			ground_preds.put(p.toString(), p);
			return p;
		}
	}
	
	public PredicatewAnnotation check_add(PredicatewAnnotation p) {
		if (ground_annot_preds.containsKey(p.toString())) {
			return ground_annot_preds.get(p.toString());
		} else {
			ground_annot_preds.put(p.toString(), p);
			return p;
		}
	}

	public Literal check_add(Literal p) {
		if (ground_literals.containsKey(p.toString())) {
			return ground_literals.get(p.toString());
		} else {
			ground_literals.put(p.toString(), p);
			return p;
		}
	}

}
