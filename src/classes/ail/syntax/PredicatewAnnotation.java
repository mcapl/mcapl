// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
// 
// This file is part of the Agent Infrastructure Layer (AIL)
//
// The AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The AIL is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
// This file is based on code from the Open Source software "Jason", copyright
// by Jomi F. Hubner and Rafael H. Bordini.  http://jason.sf.net
//----------------------------------------------------------------------------

package ail.syntax;

import ajpf.psl.MCAPLPredicate;
import gov.nasa.jpf.annotation.FilterField;

/**
 * A Predicate with annotations, eg a(1)[an1,an2].
 */
public class PredicatewAnnotation extends Predicate {

	/**
	 * The annotation.
	 */
	AILAnnotation annotation;
	
	@FilterField
	public static final Predicate Self = new Predicate("self");
	@FilterField
	public final static Predicate TSelf = new Predicate ("source");

	/**
	 * Constructor.
	 * @param ps
	 */
    public PredicatewAnnotation(String ps) {
        super(ps);
    }

    /**
     * Constructor.
     * @param t
     */
    public PredicatewAnnotation(Predicate t) {
        this(t, null);
    }
    

    public PredicatewAnnotation(Predicate t, AILAnnotation a) {
    	super(t);
    	if (t instanceof PredicatewAnnotation) {
    		addAnnot(((PredicatewAnnotation) t).getAnnot());
    	} else {
    		addAnnot(a);
    	}
    }

    /**
     * Constructor.
     * @param t
     */
    public PredicatewAnnotation(MCAPLPredicate t) {
        super(t);
    }

    /**
     * Constructor.
     * @param p
     */
    public PredicatewAnnotation(PredicatewAnnotation p) {
        this((Predicate) p);
        copyAnnot(p);
     }
    
    /**
     * Constructor.
     */
    public PredicatewAnnotation() {
    	
    }

    /**
     * Does this predicate have an annotation?
     */
     public boolean hasAnnotation() {
        return true;
    }

     /*
      * (non-Javadoc)
      * @see ail.syntax.Predicate#isGround()
      */
     @Override
     public boolean isGround() {
    	 if (annotation == null) {
             return super.isGround();
    	 } else {
    		 return super.isGround() && annotation.isGround();
    	 }
    }

     /*
      * (non-Javadoc)
      * @see ail.syntax.Predicate#apply(ail.syntax.Unifier)
      */
     @Override
    public boolean apply(Unifier u) {
    	boolean r = super.apply(u);
        if (annotation != null) {
        	annotation.apply(u);
        }
        return r;
    }
    
    /**
     * Set the annotation.
     * @param l
     */
    public void setAnnot(AILAnnotation l) {
    	annotation = l;
    }

    /**
     * Add an annotation.
     * @param a
     * @return
     */
    public boolean addAnnot(AILAnnotation a) {
    	if (annotation != null) {
    		return annotation.addAnnot(a);
    	} else {
    		setAnnot(a);
    		return true;
    	}
    }
    
    /**
     * Add the annotations from another predicate.
     * @param p
     * @return
     */
    public boolean addAnnotFrom(PredicatewAnnotation p) {
    	if (p.hasAnnot()) {
    		if (hasAnnot()) {
    			return annotation.addAnnot(p.getAnnot());
    		} else {
    			annotation = p.getAnnot();
    			return true;
    		}
    	}
    	
    	return false;
    }

    /**
     * Get the annotation.
     * @return
     */
    public AILAnnotation getAnnot() {
        return annotation;
    }

    /**
     * Does this predicate have this annotation?
     * @param t
     * @return
     */
    public boolean hasAnnot(AILAnnotation t) {
    	if (annotation != null) {
    		return annotation.equals(t);
    	} else {
    		return false;
    	}
    } 

    /** returns true if the pred has at least one annot */
    public boolean hasAnnot() {
    	boolean b = annotation != null;
    	boolean c = false;
    	if (b) {
    		c = !annotation.isEmpty();
    	}
    	boolean result = b && c;
        return result;
    } 


    /**
     * Copy the annotations from another predicate into this one.
     * @param p
     */
    public void copyAnnot(PredicatewAnnotation p) {
        if (p.getAnnot() != null) {
        	if (p.getAnnot().equals(BeliefBase.TPercept)) {
        		annotation = BeliefBase.TPercept;
        	} else {
        		annotation = p.getAnnot().clone();
        	}
       } else {
            annotation = null;
        }
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.Predicate#equals(java.lang.Object)
     */
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (o instanceof PredicatewAnnotation) {
        	//PredicatewAnnotation p = (PredicatewAnnotation) o;
        	if (super.equals(o)) {
        		// Ignore annotations during unification until we have a use for them
        		//if (hasAnnot() && p.hasAnnot()) {
        		//	return getAnnot().equals(p.getAnnot());
        		//}
        		//if (!hasAnnot() && !p.hasAnnot()) {
        		//	return true;
        		//}
        		// If one has an annotation and one doesn't they still unify?
        		return true;
        	}
        } else if (o instanceof Predicate) {
          //  return !hasAnnot() && super.equals(o);
        	return super.equals(o);
        }
        return false;
    }

    /**
     * Check two predicates are equal up to their annotations.
     * @param o
     * @return
     */
    public boolean equalsInclAnnots(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (o instanceof PredicatewAnnotation) {
        	PredicatewAnnotation p = (PredicatewAnnotation) o;
        	if (super.equals(o)) {
        		if (hasAnnot() && p.hasAnnot()) {
        			return getAnnot().equals(p.getAnnot());
        		}
        		if (!hasAnnot() && !p.hasAnnot()) {
        			return true;
        		}
        		// If one has an annotation and one doesn't they still unify?
        		return false;
        	}
        } else if (o instanceof Predicate) {
        	return super.equals(o);
        }
        return false;
    }

    /**
     * Is this equal as a term.
     * @param p
     * @return
     */
    public boolean equalsAsTerm(Object p) {
        return super.equals((Term) p);
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.Predicate#clone()
     */
    @Override
    public PredicatewAnnotation clone() {

    	return new PredicatewAnnotation(this);
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.Predicate#toString()
     */
    public String toString() {
        StringBuilder s = new StringBuilder(super.toString());
        if (hasAnnot()) {
            s.append(annotation.toString());
        }
        return s.toString();
    }
    
    /**
     * A more comprehensive string!
     */
    public String fullstring() {
        StringBuilder s = new StringBuilder(super.toString());
        if (hasAnnot()) {
        	s.append(annotation.toString());
        } else {
        	s.append("(null annotation)");
        }
        return s.toString();
    	
    }
    
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.EBCompare#unifieswith(ail.syntax.Unifiable, ail.syntax.Unifier, java.lang.String)
	 */
    @Override
	public boolean unifieswith(PredicateTerm obj, Unifier u, String ebname) {
		return unifies(obj, u);
	}

	/*
     * (non-Javadoc)
     * @see ail.syntax.DefaultTerm#unifies(ail.syntax.Unifiable, ail.semantics.Unifier)
     */
    @Override
    public boolean unifies(Unifiable t1g, Unifier u) {
    	if (t1g instanceof PredicatewAnnotation) {
    		PredicatewAnnotation np1 = (PredicatewAnnotation)t1g;		
	
    		boolean ok = super.unifies(t1g, u);
 
        // if np1 is a var that was unified, clear its annots, as in
        //      X[An] = p(1)[a]
        // X is mapped to p(1) and not p(1)[a]
    		if (ok && np1 != null) { // they are predicates
    			if (np1.isVar() && np1.hasAnnot()) {
    				u.clearAnnots((VarTerm) np1);
    			}
    			if (isVar() && hasAnnot()) {
    				u.clearAnnots((VarTerm) this);
    			}
    			if (hasAnnot()) {
    				ok = annotation.compatibleAnnotations(np1.getAnnot(), u);
    			}
    		}
   		return ok;
    	} else if (isVar()) {
    		return super.unifies(t1g, u);
    	} else {
    		return false;
    	}
    }

}
