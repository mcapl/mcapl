package ail.syntax.ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ail.syntax.BeliefBase;
import ail.syntax.Literal;
import ail.syntax.NumberTermImpl;
import ail.syntax.Predicate;
import ail.syntax.PredicatewAnnotation;
import ail.syntax.Term;

public class GroundPredSets {
	/* public static Map<String, Predicate> ground_preds = new HashMap<String, Predicate>(); */
	public static Set<PredicatewAnnotation> ground_annot_preds = new HashSet<PredicatewAnnotation>(); 
	public static Set<Literal> ground_literals = new HashSet<Literal>();
	public static Set<NumberTermImpl> ground_numbers = new HashSet<NumberTermImpl>();
	
	public static Set<Term> grounds = new  HashSet<Term>(); 
	public static Set<Predicate> ground_preds = new HashSet<Predicate>();
	
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
	
	public static Predicate check_add_pred(Predicate p) {
		if (ground_preds.contains(p)) {
			for (Predicate p1: ground_preds) {
				if (p1.equals(p)) {
					return p1;
				}
			}
			return p;
		} else {
			ground_preds.add(p);
			return p;
		} 
	}
	
	public static Predicate check_add(Predicate p) {
		Predicate p1 = check_add_pred(p);
		
		//PredicatewAnnotation pna = new PredicatewAnnotation(p);
		//check_add(pna);
		
		PredicatewAnnotation p_p = new PredicatewAnnotation(p);
		p_p.addAnnot(BeliefBase.TPercept);
		//check_add(p_p);
		Literal pplit = new Literal(true, p_p);
		check_add(pplit);
		
		
		PredicatewAnnotation p_s = new PredicatewAnnotation(p);
		p_s.addAnnot(BeliefBase.TSelf);
		//check_add(p_s);
		Literal pslit = new Literal(true, p_s);
		check_add(pslit); 

		return p1;
		
	}
	
	public static Predicate check(Predicate p) {
		for (Predicate p1: ground_preds) {
			if (p1.equals(p)) {
				return p1;
			}
		}
		
		return p;
	}

	public static PredicatewAnnotation check_add(PredicatewAnnotation p) {
		for (PredicatewAnnotation p1: ground_annot_preds) {
			if (p1.equalsInclAnnots(p)) {
				return p1;
			}
		}
		
		ground_annot_preds.add(p);
		return p;
	}

	public static PredicatewAnnotation check(PredicatewAnnotation p) {
		for (PredicatewAnnotation p1: ground_annot_preds) {
			if (p1.equalsInclAnnots(p)) {
				return p1;
			}
		}

		return p;
	}

	public static Literal check_add(Literal p) {
		for (Literal l: ground_literals) {
			if (l.equalsInclAnnots(p)) {
				return l;
			}
		}

		ground_literals.add(p);
		return p;
	}

	public static Literal check(Literal p) {
		for (Literal l: ground_literals) {
			if (l.equalsInclAnnots(p)) {
				return l;
			}
		}

		return p;
	}

	public static NumberTermImpl check_add(NumberTermImpl p) {
		for (NumberTermImpl n: ground_numbers) {
			if (n.equals(p)) {
				return n;
			}
		}

		ground_numbers.add(p);
		return p;
	}

	public static NumberTermImpl check(NumberTermImpl p) {
		for (NumberTermImpl n: ground_numbers) {
			if (n.equals(p)) {
				return n;
			}
		}

		return p;
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
		
		for (Term t: grounds) {
			if (t.equals(p)) {
				return t;
			}
		}

		grounds.add(p);
		return p;
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
		for (Term t: grounds) {
			if (t.equals(p)) {
				return t;
			}
		}

		return p;
	}
	
	public static Predicate check_add_percept(Predicate p) {
		return check_add(p);
	}

}
