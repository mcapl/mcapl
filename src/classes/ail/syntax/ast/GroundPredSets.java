package ail.syntax.ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ail.syntax.Literal;
import ail.syntax.NumberTermImpl;
import ail.syntax.Predicate;
import ail.syntax.PredicatewAnnotation;
import ail.syntax.Term;

public class GroundPredSets {
	public static Map<String, Predicate> ground_preds = new HashMap<String, Predicate>();
	public static Map<String, PredicatewAnnotation> ground_annot_preds = new HashMap<String, PredicatewAnnotation>();
	public static Map<String, Literal> ground_literals = new HashMap<String, Literal>();
	public static Map<String, NumberTermImpl> ground_numbers = new HashMap<String, NumberTermImpl>();
	
	public static Map<String, Term> grounds = new  HashMap<String, Term>();
	
	private static GroundPredSets gps = new GroundPredSets();
	
	private GroundPredSets() {
		
	}
	
	public static GroundPredSets getInstance() {
		return gps;
	}
	
	public static void clear() {
		ground_preds.clear();
		ground_annot_preds.clear();
		ground_literals.clear();
		ground_numbers.clear();
		grounds.clear();
	}
	
	public static Predicate check_add(Predicate p) {
		if (ground_preds.containsKey(p.fullstring())) {
			return ground_preds.get(p.fullstring());
		} else {
			ground_preds.put(p.fullstring(), p);
			return p;
		}
	}
	
	public static Predicate check(Predicate p) {
		if (ground_preds.containsKey(p.fullstring())) {
			return ground_preds.get(p.fullstring());
		} else {
			return p;
		}
	}

	public static PredicatewAnnotation check_add(PredicatewAnnotation p) {
		if (ground_annot_preds.containsKey(p.fullstring())) {
			return ground_annot_preds.get(p.fullstring());
		} else {
			ground_annot_preds.put(p.fullstring(), p);
			return p;
		}
	}

	public static PredicatewAnnotation check(PredicatewAnnotation p) {
		if (ground_annot_preds.containsKey(p.fullstring())) {
			return ground_annot_preds.get(p.fullstring());
		} else {
			return p;
		}
	}

	public static Literal check_add(Literal p) {
		if (ground_literals.containsKey(p.fullstring())) {
			return ground_literals.get(p.fullstring());
		} else {
			ground_literals.put(p.fullstring(), p);
			return p;
		}
	}

	public static Literal check(Literal p) {
		if (ground_literals.containsKey(p.fullstring())) {
			return ground_literals.get(p.fullstring());
		} else {
			ground_literals.put(p.fullstring(), p);
			return p;
		}
	}

	public static NumberTermImpl check_add(NumberTermImpl p) {
		if (ground_numbers.containsKey(p.fullstring())) {
			return ground_numbers.get(p.fullstring());
		} else {
			ground_numbers.put(p.fullstring(), p);
			return p;
		}
	}

	public static NumberTermImpl check(NumberTermImpl p) {
		if (ground_numbers.containsKey(p.fullstring())) {
			return ground_numbers.get(p.fullstring());
		} else {
			ground_numbers.put(p.fullstring(), p);
			return p;
		}
	}

	public static Term check_add(Term p) {
		if (p instanceof Literal) {
			return check_add((Literal) p);
		} else if (p instanceof PredicatewAnnotation) {
			return check_add((PredicatewAnnotation) p);
		} else if (p instanceof Predicate) {
			return check_add((Predicate) p);
		} else if (p instanceof NumberTermImpl) {
			return check_add((NumberTermImpl) p);
		}
		if (grounds.containsKey(p.fullstring())) {
			return grounds.get(p.fullstring());
		} else {
			grounds.put(p.fullstring(), p);
			return p;
		}
	}
	
	public static Term check(Term p) {
		if (p instanceof Literal) {
			return check((Literal) p);
		} else if (p instanceof PredicatewAnnotation) {
			return check((PredicatewAnnotation) p);
		} else if (p instanceof Predicate) {
			return check((Predicate) p);
		} else if (p instanceof NumberTermImpl) {
			return check((NumberTermImpl) p);
		}
		if (grounds.containsKey(p.fullstring())) {
			return grounds.get(p.fullstring());
		} else {
			return p;
		}
	}

}
