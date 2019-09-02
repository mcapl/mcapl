// ----------------------------------------------------------------------------
// Copyright (C) 2008-2017 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ail.semantics.AILAgent;
import ail.tracing.explanations.PredicateDescriptions;
import ajpf.util.VerifyMap;
import ajpf.psl.MCAPLFormula;
import ajpf.psl.MCAPLTerm;
import ajpf.psl.MCAPLPredicate;
import ajpf.psl.MCAPLTermImpl;
import gov.nasa.jpf.annotation.FilterField;

/**
 * Represents a predicate in first order logic.
 */
public class Predicate extends DefaultTerm implements PredicateTerm, MCAPLFormula {

	/**
	 * The name of the predicate.
	 */
	private String functor; // immutable field- not if you want to rename variables!
	/**
	 * The predicate arguments.
	 */
    private List<Term> terms = null;
    
    /**
     * The true and false predicatess.
     */
	@FilterField
    public static final Predicate PTrue  = new Predicate("true");

	@FilterField
	public static final Predicate PFalse = new Predicate("false");
	
	/**
	 * Represents the predicate as a string of the functor name and number of arguments.  Used in indexing.
	 */
    @FilterField
    protected PredicateIndicator predicateIndicatorCache = null; // to not compute it all the time (is is called many many times)


	/**
	 * Constructor.
	 * @param functor
	 */
	public Predicate(String functor) {
        this.functor = functor;
        if (functor != null) {
        	this.functor.hashCode();
        }
    }

	/**
	 * Constructor.
	 * @param t
	 */
    public Predicate(Predicate t) {
    	
     	if (t.getFunctor() != null) {
    		// Shenanigans to attempt to help state matching during verification by
    		// ensuring this is a new string object.
    		String s = " " + t.getFunctor();
     		this.functor = s.substring(1);
    	}
        List<Term> l = new ArrayList<Term>();
        List<Term> tl = t.getTerms();
        if (tl == null) {
        	setTerms(null);
        } else {
        	for (MCAPLTerm ti: t.getTerms()) {
        		l.add((Term) ti.clone());
        	}
        	setTerms(l);
        }
        functor.hashCode();
    }
    
    /**
     * Constructor.
     * @param t
     */
    public Predicate(MCAPLPredicate t) {
        this.functor = t.getFunctor();
        List<Term> l = new ArrayList<Term>();
        List<MCAPLTerm> tl = t.getTerms();
        if (tl == null || tl.isEmpty()) {
        	setTerms(null);
        } else {
        	for (MCAPLTerm ti: t.getTerms()) {
        		Term t1 = toAIL(ti);
        		l.add(t1);
        	}
        	setTerms(l);
        }
        functor.hashCode();
    }
    
    /**
     * Constructor.
     * @param t
     */
    public Predicate(MCAPLTermImpl t) {
        this.functor = t.getFunctor();
        List<Term> l = new ArrayList<Term>();
        List<MCAPLTerm> tl = t.getTerms();
        if (tl == null || tl.isEmpty()) {
        	setTerms(null);
        } else {
        	for (MCAPLTerm ti: t.getTerms()) {
        		Term t1 = toAIL(ti);
        		l.add(t1);
        	}
        	setTerms(l);
        }
    }
    
    /**
     * Constructor.
     */
    public Predicate() {
    	
    }

    /**
     * Getter for the functor.
     */
    public String getFunctor() {
    	if (functor != null) {
    		return functor;
    	} else {
    		return null;
    	}
    }
       
    /** returns functor symbol "/" arity */
    public PredicateIndicator getPredicateIndicator() {
        if (predicateIndicatorCache == null) {
            predicateIndicatorCache = new PredicateIndicator(getFunctor(),getTermsSize());
        }
        return predicateIndicatorCache;
    }
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object t) {
        if (t == null) return false;
        if (t == this) return true;

        if (t instanceof Predicate) {
            Predicate tAsStruct = (Predicate)t;

            // if t is a VarTerm, uses var's equals
            if (tAsStruct instanceof VarTerm) {
                return ((VarTerm)t).equals(this);
            }
            
            if (getFunctor() == null && tAsStruct.getFunctor() != null) {
                return false;
            }
            if (getFunctor() != null && !getFunctor().equals(tAsStruct.getFunctor())) {
                return false;
            }
            if (getTerms() == null && tAsStruct.getTerms() == null) {
                return true;
            }
            if (getTerms() == null || tAsStruct.getTerms() == null) {
                return false;
            }
            final int ts = getTermsSize(); 
            if (ts != tAsStruct.getTermsSize()) {
                return false;
            }

            for (int i=0; i<ts; i++) {
               if (!getTerm(i).equals(tAsStruct.getTerm(i))) {
                    return false;
                }
            }
            return true;
        } 
        return false;
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.DefaultTerm#apply(ail.syntax.Unifier)
     */
    public boolean apply(Unifier u) {
    	boolean r = false;
        // do not use iterator! (see ListTermImpl class)
        final int tss = getTermsSize();
        for (int i = 0; i < tss; i++) {
	        	Term t = getTerm(i);
	        	if (t instanceof VarTerm && u.swaps_vars() & u.get(t) instanceof VarTerm) {
	        		setTerm(i, u.get(t));
	        		r = true;
	        	} else {
	        		boolean tr = getTerm(i).apply(u); 
	        		r = r || tr;
	        	}
        }
        return r;
    }
    
    @Override
    public Unifiable substitute(Unifiable term, Unifiable subst) {
    		if (equals(term)) return subst;
    		
    		final int tss = getTermsSize();
    		Predicate p = new Predicate(getFunctor());
    		for (int i = 0;  i < tss; i++) {
    			Term t = (Term) getTerm(i).substitute(term, subst);
    			p.addTerm(t);
    		}
    		return p;
    }

    /** make a deep copy of the terms */
    public Predicate clone() {
    	if (isGround()) {
    		return this;
    	}
    	
        Predicate c = new Predicate(this);
        c.predicateIndicatorCache = this.predicateIndicatorCache;
        c.hashCodeCache = this.hashCodeCache;
         return c;
    }
    
    public Predicate toPredicate() {
        Predicate c = new Predicate(this);
        c.predicateIndicatorCache = this.predicateIndicatorCache;
        c.hashCodeCache = this.hashCodeCache;
         return c;    	
    }

    /**
     * Add another parameter.
     * @param t
     */
    public void addTerm(Term t) {
    	if (t == null)
    		return;
        if (terms == null)
            terms = new ArrayList<Term>();
        terms.add(t);
        predicateIndicatorCache = null;
        hashCodeCache = null;
      }
    
    /**
     * Add several parameters.
     * @param l
     */
    public void addTerms(List<Term> l) {
    	if (l != null) {
    		for (Term t: l) {
    			addTerm( t);
    		}
    	}
    }

    /**
     * Set the parameters.
     * @param l
     */
    public void setTerms(List<Term> l) {
        terms = l;
        predicateIndicatorCache = null;
      }
    
    /**
     * Set the functor.
     * @param s
     */
    public void setFunctor(String s) {
    	functor = s;
    }
    
    /**
     * Set parameter i.
     * @param i
     * @param t
     */
    public void setTerm(int i, Term t) {
        terms.set(i,t);
     }
     
    /** returns the i-th term (first term is 0) */
    public Term getTerm(int i) {
        if (terms != null && terms.size() > i) {
              return (Term) terms.get(i);
        } else {
            return null;
        }
    }

    /**
     * How many parameters/arguments does this predicate have?
     */
    public int getTermsSize() {
 
        if (terms != null) {
            return terms.size();
        } else {
             return 0;
        }
    }

    /**
     * Get the parameters/arguments.
     */
    public List<Term> getTerms() {
    	return terms;
     }
    
    /**
     * Does this predicate have parameters/arguments.
     * @return
     */
    public boolean hasTerm() {
    	return getTermsSize() > 0;
    }
    
    /**
     * Get parameters as an array.
     * @return
     */
    public Term[] getTermsArray() {
        Term ts[] = null;
        if (getTermsSize() == 0) {
            ts = new Term[0];
        } else {
            ts = new Term[getTermsSize()];
            for (int i=0; i<getTermsSize(); i++) { // use "for" instead of iterator for ListTerm compatibility
                ts[i] = getTerm(i);
            }
        }
        return ts;
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.DefaultTerm#isPredicate()
     */
    public boolean isPredicate() {
        return true;
    }
    
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.DefaultTerm#isGround()
	 */
    public boolean isGround() {
         for (int i=0; i<getTermsSize(); i++) {
               if (!getTerm(i).isGround()) {
                return false;
            }
        }
         return true;
    }
    
    /** Replaces all variables of the term for unnamed variables (_). */
    public void makeVarsAnnon() {
        makeVarsAnnon(new VerifyMap<VarTerm,UnnamedVar>());
    }

    /**
     * Replaces all variables of the term for unnamed variables (_).
     *
     * @param changes is the map of replacements
     */
    public void makeVarsAnnon(Map<VarTerm,UnnamedVar> changes) {
        for (int i=0; i<getTermsSize(); i++) {
            Term ti = getTerm(i);
            if (ti.isVar()) {
                // replace ti for an unnamed var
                UnnamedVar uv = changes.get(ti);
                if (uv == null) {
                    uv = new UnnamedVar();
                    changes.put((VarTerm)ti, uv);
                }
                setTerm(i,uv);
            } else if (ti.isPredicate()) {
                Predicate tis = (Predicate)ti;
                if (tis.getTermsSize()>0) {
                    tis.makeVarsAnnon(changes);
                }
            }
            hashCodeCache = null;
            
        }
     } 
    
    /**
     * Replace all terms with anonymous variables.
     */
    public void makeTermsAnnon() {
        for (int i=0; i<getTermsSize(); i++) {
            setTerm(i,new UnnamedVar());
        }
        hashCodeCache = null;
     }

    /**
     * Is there a variable among the parameters to this predicate?
     */
    public boolean hasVar(Term t) {
        if (this.equals(t))
            return true;
        for (int i=0; i<getTermsSize(); i++) {
            if (getTerm(i).hasVar(t)) {
                return true;
            }
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
         StringBuilder s = new StringBuilder();
         if (functor != null) {
            s.append(functor);
          }
         if (terms != null) {
            s.append("(");
            Iterator<Term> i = terms.iterator();
            while (i.hasNext()) {
            	try {
            		Term it = (Term) i.next();
            		if (!it.isGround()) {
            			it = (Term) it.clone();
            		}
            		s.append(it);
            	} catch (Exception e) {
            		s.append(terms);
            		break;
            	}
                if (i.hasNext())
                    s.append(",");
            	}
            	s.append(")");
        }
        return s.toString();
    }
    
    public String fullstring() {
    	return "Predicate-" + toString();
    }
    
    public String toString(PredicateDescriptions descriptions) {
		String full = descriptions.getDescription(this);
		if (full == null) {
			StringBuilder s = new StringBuilder();
			if (functor != null) {
				s.append(functor);
			}
			if (terms != null) {
				s.append("(");
				Iterator<Term> i = terms.iterator();
				while (i.hasNext()) {
					try {
						Term it = (Term) i.next();
						if (!it.isGround()) {
							it = (Term) it.clone();
						}
						s.append(it.toString(descriptions));
					} catch (Exception e) {
						s.append(terms);
						break;
					}
					if (i.hasNext())
						s.append(",");
				}
				s.append(")");
			}
			return s.toString();
		} else {
			return full;
		}
   }
      
        
    /*
     * (non-Javadoc)
     * @see ail.syntax.DefaultTerm#calcHashCode()
     */
    @Override
    protected int calcHashCode() {
        final int PRIME = 7;
        int result = 1;
        if (functor != null) {
            result = PRIME * result + functor.hashCode();
        }
        final int ts = getTermsSize();
        if (ts > 0) {
            result = PRIME * result + getTermsSize();
            for (int i=0; i<ts; i++) {
                result = PRIME * result + getTerm(i).hashCode();
            }
        }
        return result;
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Term#strip_varterm()
     */
    @Override
    public Term strip_varterm() {
    	
    	for (int i = 0; i < getTermsSize(); i++) {
    		try{
     			setTerm(i, getTerm(i).strip_varterm());
    		} catch (Exception  e) {
    			System.err.println(this); System.err.println(i);
    		}
   	}
    	
    	return this;
    }
   
    /*
     * (non-Javadoc)
     * @see ail.syntax.Term#resolveVarsClusters()
     */
    @Override
    public Term resolveVarsClusters() {
    	
    	for (int i = 0; i < getTermsSize(); i++) {
    		try{
     			setTerm(i, getTerm(i).resolveVarsClusters());
    		} catch (Exception  e) {
    			System.err.println(this); System.err.println(i);
    		}
   	}
    	
    	return this;
    }

    
    /**
     * Assuming we are not higher order here!
     */
    public Set<String> getVarNames() {
     	HashSet<String> varnames = new HashSet<String>();
     	if (isVar()) {
     		varnames.add(getFunctor());
     	} else {
     		if (getTerms() != null) {
     			for (MCAPLTerm t: getTerms()) {
     				varnames.addAll(((Term) t).getVarNames());
     			}
     		}
     	}
    	return varnames;
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Unifiable#renameVar(java.lang.String, java.lang.String)
     */
    @Override
    public void renameVar(String oldname, String newname) {
    	if (isVar()) {
    		if (getFunctor().equals(oldname)) {
    			functor = newname;
    		}
    	} else {
    		if (getTerms() != null) {
    			for (MCAPLTerm t: getTerms()) {
    				((Term) t).renameVar(oldname, newname);
    			}
    		}
    	}
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.DefaultTerm#standardise_apart(ail.syntax.Unifiable, ail.syntax.Unifier)
     */
  /*  @Override
    public void standardise_apart(Unifiable t, Unifier u) {
    	List<String> tvarnames = t.getVarNames();
    	List<String> myvarnames = getVarNames();
    	ArrayList<String> replacednames = new ArrayList<String>();
    	ArrayList<String> newnames = new ArrayList<String>();
    	for (String s:myvarnames) {
    		if (tvarnames.contains(s)) {
    			if (!replacednames.contains(s)) {
    				String s1 = DefaultAILStructure.generate_fresh(s, tvarnames, myvarnames, newnames, u);
    				renameVar(s, s1);
    				u.renameVar(s, s1);
    			}
    		}
    	}
 
    } */
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.LogicalFormula#logicalConsequence(ail.syntax.EvaluationBasewNames, ail.syntax.RuleBase, ail.syntax.Unifier, java.util.List)
     */
    @Override
	public Iterator<Unifier> logicalConsequence(final EvaluationBasewNames<PredicateTerm> eb, final RuleBase rb, final Unifier un, final Set<String> varnames, AILAgent.SelectionOrder so) {
		return new EvaluationAndRuleBaseIterator(eb, rb, un, this, varnames, so);
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
	 * @see ail.syntax.DefaultTerm#isVar()
	 */
    @Override
	public boolean isVar() {
    	return false;
		//return Character.isUpperCase(getFunctor().charAt(0));
	}
}
