// ----------------------------------------------------------------------------
// Copyright (C) 2008-2014 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
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

import gov.nasa.jpf.annotation.FilterField;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import ail.semantics.AILAgent;
import ail.semantics.AgentMentalState;
import ajpf.util.AJPFLogger;

/**
 * Represents a variable Term: like X (starts with upper case). It may have a
 * value.
 * 
 * @author jomi
 */
public class VarTerm extends Literal implements NumberTerm, ListTerm, StringTerm, GuardAtom<PredicateTerm> {
	/**
	 * The value this variable is instantiated to, if any.
	 */
	private Term value  = null;
	
	@FilterField
	private static final String logname = "ail.syntax.VarTerm";
    
    /**
     * New constructor for sub-classes (i.e., Goals at this point) construct
     * a VarTerm from another VarTerm.
     * 
     * @param vt
     */
    protected VarTerm(VarTerm vt) {
    	super((Literal) vt);
    	if (vt.hasValue()) {
    		setValue(vt.getValue());
    	}
    }
    
    /**
     * Another constructor for use by the Goal sub-class.  Construct
     * a VarTerm from a Literal.
     * 
     * @param l
     */
    protected VarTerm(Literal l) {
    	super(l);
    	setValue(l);
    }
    
    /**
     * Constructor.
     * @param s
     */
    public VarTerm(String s) {
        super(s);
         if (s != null && Character.isLowerCase(s.charAt(0))) {
        	Exception e = new Exception("stack");
        	e.printStackTrace();
        }
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Literal#clone()
     */
    public VarTerm clone() {
        if (value != null) {
        	VarTerm t = new VarTerm(super.getFunctor());
        	t.setValue((Term) value.clone());
        	return t;
        } else {
            // do not call constructor with term parameter!
            VarTerm t = new VarTerm(super.getFunctor());
            if (hasAnnot()) {
                t.setAnnot(getAnnot().clone());
            }
            return t;
        }
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.DefaultTerm#isVar()
     */
    public boolean isVar() {
        return value == null;
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.DefaultTerm#isUnnamedVar()
     */
    public boolean isUnnamedVar() {
        return false;
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.PredicatewAnnotation#isGround()
     */
    public boolean isGround() {
        return value != null && value.isGround();
    }

    /**
     * grounds a variable, set a value for this var (e.g. X = 10; Y = a(b,c);
     * ...)
     */
    private boolean setValue(Term vl) {
        if (vl.isVar()) {
        	if (vl instanceof VarsCluster){
        		value = vl;
        		setAnnot(null);
        		return true;
        	}
             return false;
        }
        
        if (vl instanceof VarTerm) {
        	VarTerm vl1 = (VarTerm) vl;
        	value = vl1.getValue();
        	if (value == null) {
        		AJPFLogger.warning(logname, "Setting variable value to a null!!");
        	}
        	setAnnot(null);
        } else if (vl instanceof VarsCluster){
        	value = vl;
        	setAnnot(null);
        } else {
        	value = vl;
        }
        resetHashCodeCache();
        return true;
    } 

    /** returns true if this var has a value */
    public boolean hasValue() {
        return value != null;
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.PredicatewAnnotation#apply(ail.syntax.Unifier)
     */
    public boolean apply(Unifier u) {
        if (!hasValue()) {
            Term vl = u.get(this);
            if (vl != null && !(vl instanceof VarsCluster)) {
                setValue(vl);
                return vl.apply(u); // in case t has var args
            } else if (vl !=null && vl instanceof VarsCluster) {
            	// The unifier shouldn't, at this point, contain a value for anything in the var cluster (because, if so, the 
            	// cluster should have been dropped and each variable unified to the value, but that doesn't avoid the 
            	// possibility that they may get unified later.  I suggest replacing with the var cluster and hoping!!!
            	if (((VarsCluster) vl).hasValue()) {
            		Term vlp = ((VarsCluster) vl).getValue();
            		setValue(vlp);
            		return vlp.apply(u);
            	} else {
            		value = vl;
            		return vl.apply(u);
            	}
            	
            	// This is a place holder method in case we want to remove all unifications _apart_ from those involved with
            	// the actual cluster from the VarsCluster
            	// vl.trim();
            } else if (vl == null) {
            	return true;
            }
        } else {
        	if (value instanceof VarsCluster) {
               	// This variable is associated with a Vars Cluster which may not be part of the unifier
        		VarsCluster cluster = (VarsCluster) value;
        		
        		u.compose(cluster.getUnifier());
        		
        		Term vl = u.get(this);
        		
        		setValue(vl);
        		return true;
        	} else {
        		return getValue().apply(u);
        	}
        }
        return false;            	
    }    

    /**
     * returns the value of this var. 
     */
    public Term getValue() {
        return value;
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.Literal#equals(java.lang.Object)
     */
    public boolean equals(Object t) {
        if (t == null) return false;
        if (t == this) return true;
        if (t instanceof Term) {
            Term vl = getValue();
            if (vl != null) {
                // campare the values
            	if (vl instanceof VarsCluster) {
            		if (t instanceof VarTerm) {
            			final VarTerm tAsVT = (VarTerm) t;
                        if (tAsVT.getValue() == null) {
                            return super.getFunctor().equals(tAsVT.getFunctor());
                        }
            		} else {
            			if (!((VarsCluster) vl).hasValue()) {
            				((VarsCluster) vl).setValue((Term) t); 
            			}
            		}
            	}
                return vl.equals(t);
            }

            // is t also a var? (its value must also be null)
            if (t instanceof VarTerm) {
                final VarTerm tAsVT = (VarTerm) t;
                if (tAsVT.getValue() == null) {
                    return getFunctor().equals(((VarTerm)t).getFunctor());
                }
            }
        }
        return false;
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.DefaultTerm#hashCode()
     */
    public int hashCode() {
        if (value != null)
            return value.hashCode();
        else
            return getFunctor().hashCode();
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.NumberTerm#eqcompareTo(ail.syntax.NumberTerm)
     */
    public int eqcompareTo(NumberTerm t) {
        if (value != null) {
        			if (value instanceof NumberTerm) {
       				NumberTerm vt = (NumberTerm) value;
       				return vt.eqcompareTo(t);
        	}
            return value.compareTo(t);
        }
        else
            return super.compareTo(t);
    }   
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Literal#compareTo(ail.syntax.Term)
     */
    public int compareTo(Term t) {
        if (value != null) {
        	if (t instanceof NumberTerm) {
       			NumberTerm nt = (NumberTerm) t;
       			if (value instanceof NumberTerm) {
       				NumberTerm vt = (NumberTerm) value;
       				return vt.compareTo(nt);
       			}
        	}
            return value.compareTo(t);
        }
        else
            return super.compareTo(t);
    }

    // ----------
    // Term methods overridden
    // 
    // in case this VarTerm has a value, use value's methods
    // ----------

    /*
     * (non-Javadoc)
     * @see ail.syntax.Predicate#getFunctor()
     */
    public String getFunctor() {
        if (value == null) {
            return super.getFunctor();
        } else if (value.isPredicate()) {
            return ((Predicate)getValue()).getFunctor();
        } else if (value.isString()){
            return value.toString();
        } else {
        	return null;
        }
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.Literal#getPredicateIndicator()
     */
    public PredicateIndicator getPredicateIndicator() {
        if (value != null && value.isPredicate()) {
            return ((Predicate)value).getPredicateIndicator();
        } else if (predicateIndicatorCache == null) {
            predicateIndicatorCache = new PredicateIndicator(getFunctor(), 0);
        }
        return predicateIndicatorCache;
    }
    
    @Override
    public PredicateIndicator getPurePredicateIndicator() {
    	return getPredicateIndicator();
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.Predicate#getTerm(int)
     */
    public Term getTerm(int i) {
        if (value != null && value.isPredicate()) {
            return ((Predicate)getValue()).getTerm(i);
        } else {
            return null;
        }
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.Predicate#addTerm(ail.syntax.Term)
     */
    public void addTerm(Term t) {
        if (value != null && value.isPredicate()) {
            ((Predicate)getValue()).addTerm(t);
        }
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.Predicate#getTermsSize()
     */
    public int getTermsSize() {
        if (value != null && value.isPredicate()) {
            return ((Predicate)getValue()).getTermsSize();
        } else {
            return 0;
        }
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.Predicate#getTerms()
     */
    public List<Term> getTerms() {
        if (value != null && value.isPredicate()) {
            return ((Predicate)getValue()).getTerms();
        } else {
            return null;
        }
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.Predicate#setTerms(java.util.List)
     */
    public void setTerms(List<Term> l) {
        if (value != null && value.isPredicate()) {
            ((Predicate)getValue()).setTerms(l);
        }
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.Predicate#setTerm(int, ail.syntax.Term)
     */
    public void setTerm(int i, Term t) {
        if (value != null && value.isPredicate()) {
            ((Predicate)getValue()).setTerm(i,t);
        }
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.Predicate#addTerms(java.util.List)
     */
    public void addTerms(List<Term> l) {
        if (value != null && value.isPredicate()) {
            ((Predicate)getValue()).addTerms(l);
        }
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.Predicate#getTermsArray()
     */
    public Term[] getTermsArray() {
        if (value != null && value.isPredicate()) {
            return ((Predicate)getValue()).getTermsArray();
        } else {
            return null;
        }
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.DefaultTerm#isList()
     */
    public boolean isList() {
        return value == null || getValue().isList();
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.DefaultTerm#isString()
     */
    public boolean isString() {
        return value != null && getValue().isString();
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.DefaultTerm#isNumeric()
     */
    public boolean isNumeric() {
        return value != null && value.isNumeric();
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.PredicatewAnnotation#hasAnnotation()
     */
    public boolean hasAnnotation() {
        return value != null && getValue().hasAnnotation();
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.Literal#isLiteral()
     */
    public boolean isLiteral() {
        return value != null && getValue().isLiteral();
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.Predicate#isPredicate()
     */
    public boolean isPredicate() {
        return value != null && getValue().isPredicate();
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.DefaultTerm#isArithExpr()
     */
    public boolean isArithExpr() {
        return value != null && value.isArithExpr();
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.Predicate#hasVar(ail.syntax.Term)
     */
    public boolean hasVar(Term t) {
        if (value == null) {
            return super.hasVar(t);
        } else {
            return value.hasVar(t);
        }
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.Literal#toString()
     */
    public String toString() {
        if (value == null) {
            // no value, the var name must be equal
            String s = getFunctor();
            if (hasAnnot()) {
                s += getAnnot();
            }
            return s;
        } else {
        	// Term v = value;
        	return(value.toString());
        }
    }

    // ----------
    // PredicatewAnnotation methods overridden
    // 
    // in case this VarTerm has a value, use value's methods
    // ----------

    /*
     * (non-Javadoc)
     * @see ail.syntax.PredicatewAnnotation#setAnnot(ail.syntax.AILAnnotation)
     */
    public void setAnnot(AILAnnotation l) {
        if (value != null && value.hasAnnotation())
            ((PredicatewAnnotation) value).setAnnot(l);
        else
            super.setAnnot(l);
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.PredicatewAnnotation#addAnnot(ail.syntax.AILAnnotation)
     */
    public boolean addAnnot(AILAnnotation t) {
        if (value != null && getValue().hasAnnotation())
            return ((PredicatewAnnotation) getValue()).addAnnot(t);
        else
            return super.addAnnot(t);
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.PredicatewAnnotation#hasAnnot(ail.syntax.AILAnnotation)
     */
    public boolean hasAnnot(AILAnnotation t) {
        if (value != null && getValue().hasAnnotation())
            return ((PredicatewAnnotation) getValue()).hasAnnot(t);
        else
            return super.hasAnnot(t);
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.PredicatewAnnotation#hasAnnot()
     */
    public boolean hasAnnot() {
        if (value != null && getValue().hasAnnotation())
            return ((PredicatewAnnotation) getValue()).hasAnnot();
        else
            return super.hasAnnot();
    }


    // ----------
    // Literal methods overridden
    // 
    // in case this VarTerm has a value, use value's methods
    // ----------

    /*
     * (non-Javadoc)
     * @see ail.syntax.Literal#negated()
     */
    public boolean negated() {
        return value != null && getValue().isLiteral() && ((Literal) getValue()).negated();
    }

    // ----------
    // ArithmeticExpression methods overridden
    // Interface NumberTerm
    // ----------

    /*
     * (non-Javadoc)
     * @see ail.syntax.NumberTerm#solve()
     */
    public double solve() {
        if (hasValue() && value.isNumeric()) {
            return ((NumberTerm) value).solve();
        } else {
         }
        return 0;
    }

    // ----------
    //
    // ListTerm methods overridden
    // 
    // ----------

    /*
     * (non-Javadoc)
     * @see java.util.List#add(int, java.lang.Object)
     */
    public void add(int index, Term o) {
        if (value != null && getValue().isList())
            ((ListTerm) getValue()).add(index, o);
    }

    /*
     * (non-Javadoc)
     * @see java.util.List#add(java.lang.Object)
     */
    public boolean add(Term o) {
        return value != null && getValue().isList() && ((ListTerm) getValue()).add(o);
    }

    /*
     * (non-Javadoc)
     * @see java.util.List#addAll(java.util.Collection)
     */
    public boolean addAll(Collection<? extends Term> c) {
        return value != null && getValue().isList() && ((ListTerm) getValue()).addAll(c);
    }

    /*
     * (non-Javadoc)
     * @see java.util.List#addAll(int, java.util.Collection)
     */
    public boolean addAll(int index, Collection<? extends Term> c) {
        return value != null && getValue().isList() && ((ListTerm) getValue()).addAll(index, c);
    }

    /*
     * (non-Javadoc)
     * @see java.util.List#clear()
     */
    public void clear() {
        if (value != null && getValue().isList())
            ((ListTerm) getValue()).clear();
    }

    /*
     * (non-Javadoc)
     * @see java.util.List#contains(java.lang.Object)
     */
    public boolean contains(Object o) {
        return value != null && getValue().isList() && ((ListTerm) getValue()).contains(o);
    }

    /*
     * (non-Javadoc)
     * @see java.util.List#containsAll(java.util.Collection)
     */
    public boolean containsAll(Collection<?> c) {
        return value != null && getValue().isList() && ((ListTerm) getValue()).containsAll(c);
    }

    /*
     * (non-Javadoc)
     * @see java.util.List#get(int)
     */
    public Term get(int index) {
        if (value != null && getValue().isList())
            return ((ListTerm) getValue()).get(index);
        else
            return null;
    }

    /*
     * (non-Javadoc)
     * @see java.util.List#indexOf(java.lang.Object)
     */
    public int indexOf(Object o) {
        if (value != null && getValue().isList())
            return ((ListTerm) getValue()).indexOf(o);
        else
            return -1;
    }

    /*
     * (non-Javadoc)
     * @see java.util.List#lastIndexOf(java.lang.Object)
     */
    public int lastIndexOf(Object o) {
        if (value != null && getValue().isList())
            return ((ListTerm) getValue()).lastIndexOf(o);
        else
            return -1;
    }

    /*
     * (non-Javadoc)
     * @see java.util.List#iterator()
     */
    public Iterator<Term> iterator() {
        if (value != null && getValue().isList())
            return ((ListTerm) getValue()).iterator();
        else
            return null;
    }

    /*
     * (non-Javadoc)
     * @see java.util.List#listIterator()
     */
    public ListIterator<Term> listIterator() {
        if (value != null && getValue().isList())
            return ((ListTerm) getValue()).listIterator();
        else
            return null;
    }

    /*
     * (non-Javadoc)
     * @see java.util.List#listIterator(int)
     */
    public ListIterator<Term> listIterator(int index) {
        if (value != null && getValue().isList())
            return ((ListTerm) getValue()).listIterator(index);
        else
            return null;
    }

    /*
     * (non-Javadoc)
     * @see java.util.List#remove(int)
     */
    public Term remove(int index) {
        if (value != null && getValue().isList())
            return ((ListTerm) getValue()).remove(index);
        else
            return null;
    }

    /*
     * (non-Javadoc)
     * @see java.util.List#remove(java.lang.Object)
     */
    public boolean remove(Object o) {
        if (value != null && getValue().isList())
            return ((ListTerm) getValue()).remove(o);
        else
            return false;
    }

    /*
     * (non-Javadoc)
     * @see java.util.List#removeAll(java.util.Collection)
     */
    public boolean removeAll(Collection<?> c) {
        if (value != null && getValue().isList())
            return ((ListTerm) getValue()).removeAll(c);
        else
            return false;
    }

    /*
     * (non-Javadoc)
     * @see java.util.List#retainAll(java.util.Collection)
     */
    public boolean retainAll(Collection<?> c) {
        if (value != null && getValue().isList())
            return ((ListTerm) getValue()).retainAll(c);
        else
            return false;
    }

    /*
     * (non-Javadoc)
     * @see java.util.List#set(int, java.lang.Object)
     */
    public Term set(int index, Term o) {
        if (value != null && getValue().isList())
            return ((ListTerm) getValue()).set(index, o);
        else
            return null;
    }

    /*
     * (non-Javadoc)
     * @see java.util.List#subList(int, int)
     */
    public List<Term> subList(int arg0, int arg1) {
        if (value != null && getValue().isList())
            return ((ListTerm) getValue()).subList(arg0, arg1);
        else
            return null;
    }

    /*
     * (non-Javadoc)
     * @see java.util.List#toArray()
     */
    public Object[] toArray() {
        if (value != null && getValue().isList())
            return ((ListTerm) getValue()).toArray();
        else
            return null;
    }

    // from ListTerm

    /*
     * (non-Javadoc)
     * @see ail.syntax.ListTerm#setHead(ail.syntax.Term)
     */
    public void setHead(Term t) {
        if (value != null && getValue().isList())
            ((ListTerm) getValue()).setHead(t);
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.ListTerm#setTail(ail.syntax.ListTerm)
     */
    public void setTail(ListTerm t) {
        if (value != null && getValue().isList())
            ((ListTerm) getValue()).setTail(t);
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.ListTerm#cons(ail.syntax.Term)
     */
    public boolean cons(Term t) {
        if (value != null && getValue().isList())
            return ((ListTerm) getValue()).cons(t);
        else
            return false;
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.ListTerm#concat(ail.syntax.ListTerm)
     */
    public void concat(ListTerm lt) {
        if (value != null && getValue().isList())
            ((ListTerm) getValue()).concat(lt);
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.ListTerm#getAsList()
     */
    public List<Term> getAsList() {
        if (value != null && getValue().isList())
            return ((ListTerm) getValue()).getAsList();
        else
            return null;
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.ListTerm#getTail()
     */
    public ListTerm getTail() {
        if (value != null && getValue().isList())
            return ((ListTerm) getValue()).getTail();
        else
            return null;
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.ListTerm#getHead()
     */
    public Term getHead() {
        if (value != null && getValue().isList())
            return ((ListTerm) getValue()).getHead();
        else
            return null;
    }

    /*
     * (non-Javadoc)
     * @see java.util.List#isEmpty()
     */
    public boolean isEmpty() {
        return value != null && getValue().isList() && ((ListTerm) getValue()).isEmpty();
    }


    /*
     * (non-Javadoc)
     * @see ail.syntax.ListTerm#listTermIterator()
     */
    public Iterator<ListTerm> listTermIterator() {
        if (value != null && getValue().isList())
            return ((ListTerm) getValue()).listTermIterator();
        else
            return null;
    }

    /*
     * (non-Javadoc)
     * @see java.util.List#size()
     */
    public int size() {
        if (value != null && getValue().isList())
            return ((ListTerm) getValue()).size();
        else
            return -1;
    }

    // -----------------------
    // StringTerm interface implementation
    // -----------------------

    /*
     * (non-Javadoc)
     * @see ail.syntax.StringTerm#getString()
     */
    public String getString() {
        if (value != null && getValue().isString())
            return ((StringTerm) getValue()).getString();
        else
            return null;
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.StringTerm#length()
     */
    public int length() {
        if (value != null && getValue().isString())
            return ((StringTerm) getValue()).length();
        else
            return -1;
    }
    
    /*
     * (non-Javadoc)
     * @see ail.syntax.Predicate#strip_varterm()
     */
    public Term strip_varterm() {
    	if (hasValue()) {
    		return getValue().strip_varterm();
    	} else {
    		return this;
    	}
    }

    /*
     * (non-Javadoc)
     * @see ail.syntax.Predicate#resolveVarsClusters()
     */
    public Term resolveVarsClusters() {
    	if (hasValue()) {
    		return getValue().strip_varterm();
    	} else {
    		return this;
    	}
    }

    /*
	 * (non-Javadoc)
	 * @see java.util.List#toArray(T[])
	 */
	public <T> T[] toArray(T[] a) {
        if (value != null && getValue().isList())
            return ((ListTerm) getValue()).toArray(a);
        else
            return null;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.GLogicalFormula#logicalConsequence(ail.semantics.AILAgent, ail.syntax.Unifier, java.util.List)
	 */
	@Override
	public Iterator<Unifier> logicalConsequence(AgentMentalState ag, Unifier un, Set<String> varnames, AILAgent.SelectionOrder so) {
		if (value != null) {
			if (value instanceof GuardAtom<?>) {
				return ((GuardAtom<?>) value).logicalConsequence(ag, un,varnames, so);
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.GuardAtom#isTrivial()
	 */
	public boolean isTrivial() {
		if (value != null) {
			if (value instanceof GuardAtom<?>) {
				return ((GuardAtom<?>) value).isTrivial();
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.GuardAtom#getEB()
	 */
	public StringTerm getEB() {
		if (value != null) {
			if (value instanceof GuardAtom<?>) {
				return ((GuardAtom<?>) value).getEB();
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.GuardAtom#getEBType()
	 */
	public byte getEBType() {
		if (value != null) {
			if (value instanceof GuardAtom<?>) {
				return ((GuardAtom<?>) value).getEBType();
			}
		}
		return 0;
	}
    	
 }
