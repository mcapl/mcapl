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

import java.util.List;
import java.util.ArrayList;

import ajpf.util.VerifyMap;

/**
 * Unifiers for formulas.  Very similar to the Jason Unifier class by Rafael
 * H. Bordini and Jomi F. Hubner.    Changed in a couple of places for AIL
 * but unchanged methods left untouched and commented as by Rafael and Jomi.
 * Loggers removed because JPF doesn't like them.
 * 
 * @author louiseadennis
 *
 */
public class Unifier implements Cloneable, Comparable<Unifier> {
	String logname = "ail.syntax.Unifier";

	/**
	 * A Function mapping variables to their instantiations.
	 */
   private VerifyMap<VarTerm, Term> function = new VerifyMap<VarTerm, Term>();

    /**
     * gets the value for a Var, if it is unified with another var, gets this
     * other's value
     */
    public Term get(String var) {
        return get(new VarTerm(var));
    }

    /**
     * gets the value for a Var, if it is unified with another var, gets this
     * other's value
     */
    public Term get(VarTerm vtp) {
    	for (VarTerm v: function.keySet() ) {
    		if (vtp.equals(v)) {
    			return function.get(v);
    		}
    	}
        return function.get(vtp);
    }

    public Term get(Term t) {
        if (t.isVar()) {
            return function.get((VarTerm) t);
        } else {
            return null;
        }
    }

    // ----- Unify for Predicates/Literals
    
    /**
     * sunifies is a function in the AIL interface for Standardise
     * apart (<code>makeVarsAnnon</code> in Jason) then unify.  This
     * version is for logical formulae.  NB. does not return a unifier
     * this unifier object is updated.
     * 
     * @param t1g A Structure (i.e., a logical formula of some sort)
     * @param t2g A Structure (i.e., a logical formula of some sort).
     * @retun whether or not the two structures unify.
     */
    public boolean sunifies(Predicate t1g, Predicate t2g) {
    	t2g.standardise_apart(t1g, this);
    	return unifies(t1g, t2g);
    }
    
    /**
     * sunifies is a function in the AIL interface for Standardise
     * Apart (<code>makeVarsAnnon</code> in Jason) then Unify.  This
     * version is for AIL Structures - i.e., deeds, events, beliefs etc.
     * NB. does not return a unifier.  This unifier object is updated.
     * 
     * @param t1g An AIL Structure (deed, event, belief, etc.)
     * @param t2g An AIL Structure (deed, event, belief, etc.)
     * @return whether the two structures can be unified.
     */
    public boolean sunifies(AILStructure t1g, AILStructure t2g) {
    	if (! t1g.sameType(t2g)) {
    		return false;
    	}
    	
    	// AIL Structures can return a "unifying term" consisting of 
    	// those bits relevant for unification.
        Predicate t1gl = t1g.UnifyingTerm();
    	Predicate t2gl = t2g.UnifyingTerm();
    	
    	if (t1gl == null && t2gl == null) {
    		return true;
     	} else {
    		return sunifies(t1gl, t2gl);
    	}
    }
    
   /**
    * Unify two unifiable things.
    * @param t1g
    * @param t2g
    * @return
    */
    public boolean unifies(Unifiable t1g, Unifiable t2g) {
    	// System.err.println("Unifying " + t1g + " " + t2g);
    
    	if (t1g.isGround()) {
    		return matches(t1g, t2g);
    	}
        
    	if (t1g instanceof Event && t2g instanceof Event) {
    		Event e1 = (Event) t1g;
    		Event e2 = (Event) t2g;
    		
    		return e1.unifies(e2, this);
    		
        } else if (t1g instanceof Deed && t2g instanceof Deed) {
        	Deed d1 = (Deed) t1g;
        	Deed d2 = (Deed) t2g;
        	
        	return d1.unifies(d2, this);
        	
        }	else if (t1g instanceof Goal && t2g instanceof Goal) {
			Goal g1 = (Goal) t1g;
			Goal g2 = (Goal) t2g;
			
			return g1.unifies(g2, this);
		} else if (t1g instanceof PredicatewAnnotation && t2g instanceof PredicatewAnnotation) {
    		PredicatewAnnotation np1 = (PredicatewAnnotation)t1g;
    		PredicatewAnnotation np2 = (PredicatewAnnotation)t2g;
    		
    		return np1.unifies(np2, this);
 
    	} else {
    		Term tt1 = (Term) t1g;
    		Term tt2 = (Term) t2g;
    		return (unifyTerms(tt1, tt2));
    	}
    	
     }
    
    /**
     * Matches two unifiable things.  Assumes the first is ground.
     * @param t1g
     * @param t2g
     * @return
     */
     public boolean matches(Unifiable t1g, Unifiable t2g) {
    	 if (t2g.isGround()) {
    		 return t1g.equals(t2g);
    	 }
          
     	if (t1g instanceof Event && t2g instanceof Event) {
     		Event e1 = (Event) t1g;
     		Event e2 = (Event) t2g;
     		
     		return e1.match(e2, this);
     		
         } else if (t1g instanceof Deed && t2g instanceof Deed) {
         	Deed d1 = (Deed) t1g;
         	Deed d2 = (Deed) t2g;
         	
         	return d1.match(d2, this);
         	
         }	else if (t1g instanceof Goal && t2g instanceof Goal) {
 			Goal g1 = (Goal) t1g;
 			Goal g2 = (Goal) t2g;
 			
 			return g1.match(g2, this);
 		} else if (t1g instanceof PredicatewAnnotation && t2g instanceof PredicatewAnnotation) {
     		PredicatewAnnotation np1 = (PredicatewAnnotation)t1g;
     		PredicatewAnnotation np2 = (PredicatewAnnotation)t2g;
     		
     		return np1.match(np2, this);
  
     	} else {
     		Term tt1 = (Term) t1g;
     		Term tt2 = (Term) t2g;
     		return (matchTerms(tt1, tt2));
     	}
     	
      }

     /**
      * Matches two unifiable things.  Although the first isn't necessarily ground
      * unification can be applied just to the second.
      * @param t1g
      * @param t2g
      * @return
      */
      public boolean matchesNG(Unifiable t1g, Unifiable t2g) {
           
      	if (t1g instanceof Event && t2g instanceof Event) {
      		Event e1 = (Event) t1g;
      		Event e2 = (Event) t2g;
      		
      		return e1.matchNG(e2, this);
      		
          } else if (t1g instanceof Deed && t2g instanceof Deed) {
          	Deed d1 = (Deed) t1g;
          	Deed d2 = (Deed) t2g;
          	
          	return d1.matchNG(d2, this);
          	
          }	else if (t1g instanceof Goal && t2g instanceof Goal) {
  			Goal g1 = (Goal) t1g;
  			Goal g2 = (Goal) t2g;
  			
  			return g1.matchNG(g2, this);
  		} else if (t1g instanceof PredicatewAnnotation && t2g instanceof PredicatewAnnotation) {
      		PredicatewAnnotation np1 = (PredicatewAnnotation)t1g;
      		PredicatewAnnotation np2 = (PredicatewAnnotation)t2g;
      		
      		return np1.matchNG(np2, this);
   
      	} else {
      		Term tt1 = (Term) t1g;
      		Term tt2 = (Term) t2g;
      		return (matchTermsNG(tt1, tt2));
      	}
      	
       }

    
    // ----- Unify for Terms

    /**
     * Unify two logical terms.
     * @param t1g
     * @param t2g
     * @return
     */
    public boolean unifyTerms(Term t1g, Term t2g) {
         // if args are expressions, apply them and use their values
        if (t1g.isArithExpr()) {
            t1g = (Term) t1g.clone();
            t1g.apply(this);
        }
        if (t2g.isArithExpr()) {
            t2g = (Term) t2g.clone();
            t2g.apply(this);
        }

        // both are vars
        if (t1g.isVar() && t2g.isVar()) {
            VarTerm t1gv = (VarTerm) t1g;
            VarTerm t2gv = (VarTerm) t2g;
            
            // get their values
            Term t1vl = function.get(t1gv);
            Term t2vl = function.get(t2gv);

            // if the variable value is a var cluster, it means it has no value
            if (t1vl instanceof VarsCluster)
                t1vl = null;
            if (t2vl instanceof VarsCluster)
                t2vl = null;

            // both has value, their values should unify
            if (t1vl != null && t2vl != null) {
                return unifies(t1vl, t2vl);
            }
            // only t1 has value, t1's value should unify with var t2
            if (t1vl != null) {
                return unifies(t2gv, t1vl);
            }
            // only t2 has value, t2's value should unify with var t1
            if (t2vl != null) {
                return unifies(t1gv, t2vl);
            }

            // both are var (not unnamedvar) with no value, like X=Y
            // we must ensure that these vars will form a cluster
            if (! t1gv.isUnnamedVar() && ! t2gv.isUnnamedVar()) {
            	VarTerm t1c = (VarTerm) t1gv.clone();
                VarTerm t2c = (VarTerm) t2gv.clone();
                VarsCluster cluster = new VarsCluster(t1c, t2c, this);
                if (cluster.hasValue()) {
                    // all vars of the cluster should have the same value
                    for (VarTerm vtc : cluster) {
                        function.put(vtc, cluster);
                    }
                }
            }
            return true;
        }

        // t1 is var that doesn't occur in t2
        if (t1g.isVar()) {
            VarTerm t1gv = (VarTerm) t1g;
            // if t1g is not free, must unify values
            Term t1vl = function.get(t1gv);
            if (t1vl != null && !(t1vl instanceof VarsCluster)) {
                return unifies(t1vl,t2g);
            } else if (!t2g.hasVar(t1g)) {
                return setVarValue(t1gv, t2g);
            }
            return false;
        }

        // t2 is var that doesn't occur in t1
        if (t2g.isVar()) {
            VarTerm t2gv = (VarTerm) t2g;
            // if t1g is not free, must unify values
            Term t2vl = function.get(t2gv);
            if (t2vl != null && !(t2vl instanceof VarsCluster)) {
                return unifies(t2vl,t1g);
            } else if (!t1g.hasVar(t2g)) {
                return setVarValue(t2gv, t1g);
            } 
            return false;
        }

        // both terms are not vars
        
        // if any of the terms is not a structure (is a number or a
        // string), they must be equal
        if (!t1g.isPredicate() || !t2g.isPredicate()) {
         	return t1g.equals(t2g);
        	
        }

        // both terms are structures

        // if both are literal, they must have the same negated
        if (t1g.isLiteral() && t2g.isLiteral() && ((Literal)t1g).negated() != ((Literal)t2g).negated()) {
        	return false;
        }
        	
        // if one term is literal and the other not, the literal should not be negated
        if (t1g.isLiteral() && !t2g.isLiteral() && ((Literal)t1g).negated()) {
        	return false;
        }
        if (t2g.isLiteral() && !t1g.isLiteral() && ((Literal)t2g).negated()) {
        	return false;
        }
        
        // if the first term is a predicate and the second not, the first should not have annots 
        if (t1g.hasAnnotation() && !t2g.hasAnnotation() && ((PredicatewAnnotation)t1g).hasAnnot()) {
        	return false;
        }
        
        // if both are predicates, the first's annots must be subset of the second's annots
        if (t1g.hasAnnotation() && t2g.hasAnnotation()) {
        	PredicatewAnnotation pwa1 = (PredicatewAnnotation) t1g;
           	PredicatewAnnotation pwa2 = (PredicatewAnnotation) t2g;
           	if (pwa1.hasAnnot() && pwa2.hasAnnot()) {
           		if ( ! ((PredicatewAnnotation)t1g).getAnnot().compatibleAnnotations(((PredicatewAnnotation)t2g).getAnnot(), this)) {
           			return false;
           		}
        	}
        }
        
         
        Predicate t1s = (Predicate)t1g;
        Predicate t2s = (Predicate)t2g;
        
        // different arities
        if ((t1s.getTerms() == null && t2s.getTerms() != null) || (t1s.getTerms() != null && t2s.getTerms() == null)) {
            return false;
        }
        if (t1s.getTermsSize() != t2s.getTermsSize()) {
            return false;
        }
        
        // different functor
        if (t1s.getFunctor() != null && !t1s.getFunctor().equals(t2s.getFunctor())) {
            return false;
        }
    
        // unify inner terms
        // do not use iterator! (see ListTermImpl class)
        final int ts = t1s.getTermsSize();
        for (int i = 0; i < ts; i++) {
            if (!unifies(t1s.getTerm(i), t2s.getTerm(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Unify two logical terms.  We assume t1g is ground.
     * @param t1g
     * @param t2g
     * @return
     */
    public boolean matchTerms(Term t1g, Term t2g) {
    	if (t2g.isGround()) {
    		return t1g.equals(t2g);
    	}
         // if args are expressions, apply them and use their values
        if (t2g.isArithExpr()) {
            t2g = (Term) t2g.clone();
            t2g.apply(this);
        }


        // t2 is var that doesn't occur in t1
        if (t2g.isVar()) {
            VarTerm t2gv = (VarTerm) t2g;
            // if t1g is not free, must unify values
            Term t2vl = function.get(t2gv);
            if (t2vl != null && !(t2vl instanceof VarsCluster)) {
                return matches(t1g, t2vl);
            } else {
                return setVarValue(t2gv, t1g);
            } 
        }

        // both terms are not vars
        
        // if any of the terms is not a structure (is a number or a
        // string), they must be equal
        if (!t1g.isPredicate() || !t2g.isPredicate()) {
         	return t1g.equals(t2g);
        	
        }

        // both terms are structures

        // if both are literal, they must have the same negated
        if (t1g.isLiteral() && t2g.isLiteral() && ((Literal)t1g).negated() != ((Literal)t2g).negated()) {
        	return false;
        }
        	
        // if one term is literal and the other not, the literal should not be negated
        if (t1g.isLiteral() && !t2g.isLiteral() && ((Literal)t1g).negated()) {
        	return false;
        }
        if (t2g.isLiteral() && !t1g.isLiteral() && ((Literal)t2g).negated()) {
        	return false;
        }
        
        // if the first term is a predicate and the second not, the first should not have annots 
        if (t1g.hasAnnotation() && !t2g.hasAnnotation() && ((PredicatewAnnotation)t1g).hasAnnot()) {
        	return false;
        }
        
        // if both are predicates, the first's annots must be subset of the second's annots
        if (t1g.hasAnnotation() && t2g.hasAnnotation()) {
        	PredicatewAnnotation pwa1 = (PredicatewAnnotation) t1g;
           	PredicatewAnnotation pwa2 = (PredicatewAnnotation) t2g;
           	if (pwa1.hasAnnot() && pwa2.hasAnnot()) {
           		if ( ! ((PredicatewAnnotation)t1g).getAnnot().compatibleAnnotations(((PredicatewAnnotation)t2g).getAnnot(), this)) {
           			return false;
           		}
        	}
        }
        
         
        Predicate t1s = (Predicate)t1g;
        Predicate t2s = (Predicate)t2g;
        
        // different arities
        if ((t1s.getTerms() == null && t2s.getTerms() != null) || (t1s.getTerms() != null && t2s.getTerms() == null)) {
            return false;
        }
        if (t1s.getTermsSize() != t2s.getTermsSize()) {
            return false;
        }
        
        // different functor
        if (t1s.getFunctor() != null && !t1s.getFunctor().equals(t2s.getFunctor())) {
            return false;
        }
    
        // unify inner terms
        // do not use iterator! (see ListTermImpl class)
        final int ts = t1s.getTermsSize();
        for (int i = 0; i < ts; i++) {
            if (!matches(t1s.getTerm(i), t2s.getTerm(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean setVarValue(VarTerm vt, Term value) {
        // if the var has a cluster, set value for all cluster
        Term currentVl = function.get(vt);
        if (currentVl != null && currentVl instanceof VarsCluster) {
            VarsCluster cluster = (VarsCluster) currentVl;
            for (VarTerm cvt : cluster) {
                function.put(cvt, (Term) value.clone());
            }
        } else {
            // no value in cluster
            function.put((VarTerm) vt.clone(), (Term) value.clone());
        }
        return true;
    }

    /**
     * Clear the unifier.
     */
    public void clear() {
        function.clear();
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return function.toString();
    }

    /**
     * Size of the unifier.
     * @return
     */
    public int size() {
        return function.size();
    }

    /** add all unifications from u */
    /**
     * NB. simply removes duplicate unifiers from incoming unifier
     */
    public void compose(Unifier u) {
        for (VarTerm k: u.function.keySet()) {
        	if (! function.keySet().contains(k) ) { // || function.get(k) instanceof VarsCluster) {
        		function.put( (VarTerm)k.clone(), (Term)u.function.get(k).clone());
        	} else  {
        		Term t1 = u.get(k);
        		Term t2 = get(k);
        		if (t1 instanceof VarsCluster) {
        			if (t2 instanceof VarsCluster) {
        				for (VarTerm v: (VarsCluster) t2) {
         					function.put(v, t1);
        				}
        			} else {
        				Unifier uc = u.clone();
        				uc.unifies(k, t2);
        				compose(uc);
        			}
        		} else if (t2 instanceof VarsCluster) {
        			unifies(t1, k);
        		} else {
        			// we assume if neither are vars clusters we can throw away the oldest version.
        			// This _really_ should only be used in intentions where we can safely assume one unifier is an extension of the other.
        		}
        	}
        }
    }
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    public Unifier clone() {
        try {
            Unifier newUn = new Unifier();
            newUn.compose(this);
            return newUn;
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        	System.err.flush();
              return null;
        }
    }
    
    /**
     * Clear annotations from a variable.
     * @param v
     */
    public void clearAnnots(VarTerm v) {
   		Term np1vl = function.get(v);
		if (np1vl.hasAnnotation()) {
			((PredicatewAnnotation) np1vl).setAnnot(null);
		}

    }
 
    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (o instanceof Unifier) {
            return function.equals( ((Unifier)o).function);
        }
        return false;
    }
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
    	return function.hashCode();
    }
        
    /*
     * (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(Unifier u) {
    	if (size() == u.size()) {
    		return toString().compareTo(u.toString());
    	} else {
    		if (size() < u.size()) return -1;
    		else return 1;
    	}
    }

    /*
     * 
     */
    public void renameVar(String oldname, String newname) {
    	for (VarTerm v: function.keySet()) {
    		if (v.getFunctor().equals(oldname)) {
    			v.renameVar(oldname, newname);
    		}
    	}
    }
    
    /**
     * Prune away any unifiers not mentioned in this list of terms.
     * @param terms
     */
    public void pruneRedundant(List<Unifiable> terms) {
    	List<String> varnames = new ArrayList<String>();
    	for (Unifiable u: terms) {
    		varnames.addAll(u.getVarNames());
    	}
    	List<VarTerm> vars = new ArrayList<VarTerm>();
    	for (VarTerm v: function.keySet()) {
    		if (! varnames.contains(v.getFunctor())) {
    			vars.add(v);
    		}
    	}
    	for (VarTerm v1: vars) {
    		function.remove(v1);
    	}
    }
    
    /**
     * Prune any variable names not mentioned in this list.
     * @param varnames
     */
    public void pruneRedundantNames(List<String> varnames) {
    	List<VarTerm> vars = new ArrayList<VarTerm>();
    	for (VarTerm v: function.keySet()) {
    		if (! varnames.contains(v.getFunctor())) {
    			vars.add(v);
    		}
    	}
    	for (VarTerm v1: vars) {
    		function.remove(v1);
    	}
    }

    /**
     * Return all varClusters in this unifier.
     * @return
     */
   // public Unifier varClusters() {
   // 	Unifier u = new Unifier();
   // 	for (VarTerm v: function.keySet()) {
   // 		if (get(v) instanceof VarsCluster) {
   // 			u.setVarValue(v, get(v));
   // 		}
   // 	}
   // 	return u;
  //  }
    
    /**
     * Unify two logical terms.  We assume t1g is not to be unified but may contain variables.
     * @param t1g
     * @param t2g
     * @return
     */
    public boolean matchTermsNG(Term t1g, Term t2g) {

          // if args are expressions, apply them and use their values
        if (t2g.isArithExpr()) {
            t2g = (Term) t2g.clone();
            t2g.apply(this);
        }

        // both are vars
        if (t1g.isVar() && t2g.isVar()) {
            VarTerm t1gv = (VarTerm) t1g;
            VarTerm t2gv = (VarTerm) t2g;
            
            // get their values
            Term t1vl = function.get(t1gv);
            Term t2vl = function.get(t2gv);

            // if the variable value is a var cluster, it means it has no value
            if (t1vl instanceof VarsCluster)
                t1vl = null;
            if (t2vl instanceof VarsCluster)
                t2vl = null;

            // both have value, their values should unify
            if (t1vl != null && t2vl != null) {
                return matchesNG(t1vl, t2vl);
            }
            // only t1 has value, t1's value should unify with var t2
            if (t1vl != null) {
                return false;
            }
            // only t2 has value, t2's value should unify with var t1
            if (t2vl != null) {
                return matchesNG(t1gv, t2vl);
            }

            // both are var (not unnamedvar) with no value, like X=Y
            // we must ensure that these vars will form a cluster
            if (! t1gv.isUnnamedVar() && ! t2gv.isUnnamedVar()) {
            	VarTerm t1c = (VarTerm) t1gv.clone();
                VarTerm t2c = (VarTerm) t2gv.clone();
                VarsCluster cluster = new VarsCluster(t1c, t2c, this);
                if (cluster.hasValue()) {
                    // all vars of the cluster should have the same value
                    for (VarTerm vtc : cluster) {
                        function.put(vtc, cluster);
                    }
                }
            }
            return true;
        }

        // t1 is var that doesn't occur in t2
        if (t1g.isVar()) {
            VarTerm t1gv = (VarTerm) t1g;
            // if t1g is not free, must unify values
            Term t1vl = function.get(t1gv);
            if (t1vl != null && !(t1vl instanceof VarsCluster)) {
                return t1vl.equals(t2g);
            } else if (!t2g.hasVar(t1g)) {
                return false;
            }
            return false;
        }


        // t2 is var that doesn't occur in t1
        if (t2g.isVar()) {
            VarTerm t2gv = (VarTerm) t2g;
            // if t1g is not free, must unify values
            Term t2vl = function.get(t2gv);
            if (t2vl != null && !(t2vl instanceof VarsCluster)) {
                return matchesNG(t1g, t2vl);
            } else {
                return setVarValue(t2gv, t1g);
            } 
        }

        // both terms are not vars
        
        // if any of the terms is not a structure (is a number or a
        // string), they must be equal
        if (!t1g.isPredicate() || !t2g.isPredicate()) {
         	return t1g.equals(t2g);
        	
        }

        // both terms are structures

        // if both are literal, they must have the same negated
        if (t1g.isLiteral() && t2g.isLiteral() && ((Literal)t1g).negated() != ((Literal)t2g).negated()) {
        	return false;
        }
        	
        // if one term is literal and the other not, the literal should not be negated
        if (t1g.isLiteral() && !t2g.isLiteral() && ((Literal)t1g).negated()) {
        	return false;
        }
        if (t2g.isLiteral() && !t1g.isLiteral() && ((Literal)t2g).negated()) {
        	return false;
        }
        
        // if the first term is a predicate and the second not, the first should not have annots 
        if (t1g.hasAnnotation() && !t2g.hasAnnotation() && ((PredicatewAnnotation)t1g).hasAnnot()) {
        	return false;
        }
        
        // if both are predicates, the first's annots must be subset of the second's annots
        if (t1g.hasAnnotation() && t2g.hasAnnotation()) {
        	PredicatewAnnotation pwa1 = (PredicatewAnnotation) t1g;
           	PredicatewAnnotation pwa2 = (PredicatewAnnotation) t2g;
           	if (pwa1.hasAnnot() && pwa2.hasAnnot()) {
           		if ( ! ((PredicatewAnnotation)t1g).getAnnot().compatibleAnnotations(((PredicatewAnnotation)t2g).getAnnot(), this)) {
           			return false;
           		}
        	}
        }
        
         
        Predicate t1s = (Predicate)t1g;
        Predicate t2s = (Predicate)t2g;
        
        // different arities
        if ((t1s.getTerms() == null && t2s.getTerms() != null) || (t1s.getTerms() != null && t2s.getTerms() == null)) {
            return false;
        }
        if (t1s.getTermsSize() != t2s.getTermsSize()) {
            return false;
        }
        
        // different functor
        if (t1s.getFunctor() != null && !t1s.getFunctor().equals(t2s.getFunctor())) {
            return false;
        }
    
        // unify inner terms
        // do not use iterator! (see ListTermImpl class)
        final int ts = t1s.getTermsSize();
        for (int i = 0; i < ts; i++) {
            if (!matchesNG(t1s.getTerm(i), t2s.getTerm(i))) {
                return false;
            }
        }
        return true;
    }

    
    /**
     * This unifier contians the following variable name.
     * @param v
     * @return
     */
    public boolean containsVarName(String v) {
    	for (VarTerm var: function.keySet()) {
    		if (var.getFunctor().equals(v)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    /**
     * This unifier contians the following variable name.
     * @param v
     * @return
     */
    public ArrayList<String> getVarNames() {
    	ArrayList<String> varnames = new ArrayList<String>();
    	for (VarTerm var: function.keySet()) {
    		varnames.add(var.getFunctor());
    	}
    	return varnames;
    }

    /**
     * Method for working with MJI.  
     */
    // NOT USED WORK IN PROGRESS
    public Term[] mapToArray() {
    	int array_size = size()*2;
    	Term[] array = new Term[array_size];
    	int i = 0;
    	for (VarTerm v : function.keySet()) {
    		array[i] = v;
    		i++;
    		array[i] = function.get(v);
    		i++;
    	}
    	return array;
    }
}
