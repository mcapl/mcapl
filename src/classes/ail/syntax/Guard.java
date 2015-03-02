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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ail.semantics.AILAgent;
import ajpf.util.AJPFLogger;

/**
 * AIL Guards.  This is really just a wrapper on top of LogicalExpression providing a few extra methods that are
 * not strictly logical in nature.
 * 
 * @author lad
 *
 */
public class Guard implements GLogicalFormula {

	/**
	 * The possible operators of the logical expression
	 * @author lad
	 *
	 */
	public enum GLogicalOp { 
		none   { public String toString() { return ""; } }, 
		not    { public String toString() { return "not "; } }, 
		and    { public String toString() { return " & "; } },
	}
	
	/**
	 * The LHS and RHS of the expression.
	 */
	private  GLogicalFormula lhs, rhs;
	/**
	 * The operator.
	 */
	private  GLogicalOp      op = GLogicalOp.none;

	
	/**
	 * Constructs an empty guard.
	 *
	 */
	public Guard() {}
	
	/**
	 * Construct a guard from a single Guard Atom.  This is presumed to be 
	 * positive.
	 * 
	 * @param g The GBelief in the guard.
	 */
	public Guard(GuardAtom<? extends Unifiable> g) {
		add(g);
	}

	/**
	 * Constructs a guard from a Guard Atom and a flag showing whether or not it 
	 * is to be believed.
	 * 
	 * @param g The GBelief.
	 * @param tf A flag showing whether the belief is to be believed or not.
	 */
	public Guard(GuardAtom<? extends Unifiable> g, boolean tf) {
		add(g, tf);
	}
	
	/**
	 * Construct a Guard from two Logical Formulae and an operator.
	 * @param l
	 * @param o
	 * @param r
	 */
	public Guard(GLogicalFormula l, GLogicalOp o, GLogicalFormula r) {
		lhs = l;
		op = o;
		rhs = r;
	}
	
	/**
	 * Construct a guard from an operator and a logical formula.
	 * @param o
	 * @param r
	 */
	public Guard(GLogicalOp o, GLogicalFormula r) {
		op = o;
		rhs = r;
	}
	
	/**
	 * Getter for the operator.
	 * @return
	 */
	public GLogicalOp getOp() {
		return op;
	}
	
	/**
	 * Getter for the LHS.
	 * @return
	 */
	public GLogicalFormula getLHS() {
		return lhs;
	}
	
	/**
	 * Getter for the RHS.
	 * @return
	 */
	public GLogicalFormula getRHS() {
		return rhs;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		if (o instanceof Guard) {
			Guard gu = (Guard) o;
			if (op == gu.getOp()) {
				if (lhs != null) {
					if (gu.getLHS() != null) {
						if (lhs == gu.getLHS()) {
							if (rhs != null) {
								if (gu.getRHS() != null) {
									return rhs == gu.getRHS();
								}
							} else {
								return gu.getRHS() == null;
							}
						} else {
							return false;
						}
					} else {
						return false;
					}
				} else {
					if (gu.getLHS() == null) {
						if (rhs != null) {
							if (gu.getRHS() != null) {
								return rhs == gu.getRHS();
							}
						} else {
							return gu.getRHS() == null;
						}
					}
				}
			}
		}
		
		return false;
	}
	
	/**
	 * 
	 */
	public int hashcode() {
		return lhs.hashCode() + rhs.hashCode();
	}
		
	/**
	 * Add a new Guard Atom (conjunct) to the guard.  By default this is to be believed.
	 * 
	 * @param gb  The belief to be added.
	 * @return whether the belief was successfully added.
	 */
	public boolean add(GuardAtom<? extends Unifiable> gb) {
		return add(gb, true);
	}
	
	/**
	 * Add a Guard Atom to the guard with a flag showing whether or not it should be
	 * believed or disbelieved for the guard to be true.
	 * 
	 * @param gb The GBelief.
	 * @param b Flag indicating whether gb should be believed or disbelieved.
	 * @return
	 */
	public boolean add(GuardAtom<? extends Unifiable> gb, boolean b) {
  
		if (isTrivial()) {
			if (b) {
				if (!gb.isTrivial()) {
					op = GLogicalOp.none;
					rhs = gb;
				}
			} else {
				if (!gb.isTrivial()) {
					op = GLogicalOp.not;
					rhs = gb;
				} else {
					/// This shouldn't happen but should there be a case anyway?
				}
			}
		} else {
			if (b) {
				if (op == GLogicalOp.none) {
					lhs = gb;
					op = GLogicalOp.and;
				} else {
					rhs = this.clone();
					lhs = gb;
					op = GLogicalOp.and;
				}
			} else {
				Guard ng = new Guard(GLogicalOp.not, gb);
				if (op == GLogicalOp.none) {
					lhs = ng;
					op = GLogicalOp.and;
				} else {
					rhs = this.clone();
					lhs = ng;
					op = GLogicalOp.and;
				}
			}
		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		if (op == GLogicalOp.none) {
			if (rhs != null) {
				return rhs.toString();
			} else {
				return "True";
			}
		} else if (op == GLogicalOp.not) {
			if (rhs != null) {
				return "~" + rhs.toString();
			} else {
				return "False";
			}
			
		} else {
			return lhs.toString() + " & " + rhs.toString();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Guard clone() {
		if (rhs == null) {
			return new Guard();
		} else if (lhs == null) {
			return new Guard(op, rhs.clone());
		} else {
			return new Guard(lhs.clone(), op, rhs.clone());
		}
	}
	    
	/**
	 * Succeeds if the Guard is trivial (ie., contains the belief True).
	 * 
	 * @return whether the guard contains the true belief.
	 */
	public boolean isTrivial() {
		return (rhs == null);
	}
	
	public Iterator<Unifier> gbeliefLC(final EvaluationBasewNames<PredicateTerm> eb, final RuleBase ruleb, final Unifier u, final List<String> varnames) {
		try {
			final Iterator<Unifier> ileft;
			
			switch (op) {
			case not:
				if (rhs instanceof GBelief) {
					GBelief gbrhs = (GBelief) rhs;
					if (! gbrhs.logicalConsequence(eb, ruleb, u, varnames).hasNext()) {
						return createUnifIterator(u);
					}
					break;
				} else if (rhs instanceof Guard) {
					Guard gurhs = (Guard) rhs;
					if (!gurhs.gbeliefLC(eb, ruleb, u, varnames).hasNext()) {
						return createUnifIterator(u);
					}
					break;
				}
				return createUnifIterator(u) ;
				
			case none:
				if (rhs == null) {
					return createUnifIterator(u);
				} else if (rhs instanceof GBelief) {
					return ((GBelief) rhs).logicalConsequence(eb, ruleb, u, varnames);
				} else if (rhs instanceof Guard) {
					return ((Guard) rhs).gbeliefLC(eb, ruleb, u, varnames);
				} else {
					return createUnifIterator(u);
				}
				
			case and:
				if (lhs instanceof GBelief) {
					ileft = ((GBelief) lhs).logicalConsequence(eb, ruleb, u, varnames);
				} else if (lhs instanceof Guard) {
					ileft = ((Guard) lhs).gbeliefLC(eb, ruleb, u, varnames);
				} else {
					ileft = createUnifIterator(u);
				}
				
        		return new Iterator<Unifier>() {
        			Unifier current = null;
        			Iterator<Unifier> iright = null;
        			public boolean hasNext() {
        				if (current == null) get();
        				return current != null;
        			}
        			public Unifier next() {
        				if (current == null) get();
        				Unifier a = current;
        				current = null; 
        				return a;
        			}
        			private void get() {
        				current = null;
        				if (AJPFLogger.ltFine("ail.syntax.Guard")) {
        					AJPFLogger.fine("ail.syntax.Guard", "Checking ileft has Next: " + lhs);
        					AJPFLogger.fine("ail.syntax.Guard", "Checking iright does not have Next: " + rhs);
        				}
        				
        				while ((iright == null || !iright.hasNext()) && ileft.hasNext()) {
        					Unifier ul = ileft.next();
        					if (AJPFLogger.ltFine("ail.syntax.Guard")) {
	        					AJPFLogger.fine("ail.syntax.Guard", "Check Succeeded for " + lhs + " and " + rhs + " with unifier " + ul);
	        				}	
        					if (rhs instanceof GBelief) {
        						iright = ((GBelief) rhs).logicalConsequence(eb,  ruleb,  u, varnames);
        					} else if (rhs instanceof  Guard) {
        						iright = ((Guard) rhs).gbeliefLC(eb, ruleb, u, varnames);
        					}
 	        				if (AJPFLogger.ltFine("ail.syntax.Guard")) {
	        					AJPFLogger.fine("ail.syntax.Guard", "Checking ileft has Next: " + lhs);
	        					AJPFLogger.fine("ail.syntax.Guard", "Checking iright does not have Next: " + rhs);
	        				}
        				}
        				
        				if (AJPFLogger.ltFine("ail.syntax.Guard")) {
        					AJPFLogger.fine("ail.syntax.Guard", "Either ileft has no next or iright does have next");
        					AJPFLogger.fine("ail.syntax.Guard", "Checking iright has next: " + rhs);
        				}

        				
        				if (iright != null && iright.hasNext()) {
        					if (AJPFLogger.ltFine("ail.syntax.Guard")) {
	        					AJPFLogger.fine("ail.syntax.Guard", "Check Succeeded for " + rhs);
	        				}		        					
        					current = iright.next();	 
        				}
        			}
        			
        			public void remove() {}
        		};
			}
        } catch (Exception e) {
        	return createUnifIterator(u);
        }
    	ArrayList<Unifier> empty = new ArrayList<Unifier>();
        return empty.iterator();  // empty iterator for unifier

	}
	    
	/**
	 * Returns an iterators of unifiers that satisfy agent believes this
	 * 
	 * @param ag The agent
	 * @param un An initial unifier
	 * @return An iterator of unifiers that the agent believes this guard.
	 */
	public Iterator<Unifier> logicalConsequence(final AILAgent ag, final Unifier un, final List<String> varnames) {
	       try {
		        final Iterator<Unifier> ileft;
		        switch (op) {
		        
		        	case not:
		        		if (!rhs.logicalConsequence(ag,un, varnames).hasNext()) {
		        			return createUnifIterator(un);
		        		}
		        		break;
		        	case none:
		        		if (rhs == null) {
		        			return createUnifIterator(un);
		        		} else {
		        			return rhs.logicalConsequence(ag, un, varnames);
		        		}
		        
		        	case and:
		        		ileft = lhs.logicalConsequence(ag,un, varnames);
		        		return new Iterator<Unifier>() {
		        			Unifier current = null;
		        			Iterator<Unifier> iright = null;
		        			public boolean hasNext() {
		        				if (current == null) get();
		        				return current != null;
		        			}
		        			public Unifier next() {
		        				if (current == null) get();
		        				Unifier a = current;
		        				current = null; 
		        				return a;
		        			}
		        			private void get() {
		        				current = null;
		        				if (AJPFLogger.ltFine("ail.syntax.Guard")) {
		        					AJPFLogger.fine("ail.syntax.Guard", "Checking ileft has Next: " + lhs);
		        					AJPFLogger.fine("ail.syntax.Guard", "Checking iright does not have Next: " + rhs);
		        				}
		        				
		        				while ((iright == null || !iright.hasNext()) && ileft.hasNext()) {
		        					Unifier ul = ileft.next();
		        					if (AJPFLogger.ltFine("ail.syntax.Guard")) {
			        					AJPFLogger.fine("ail.syntax.Guard", "Check Succeeded for " + lhs + " and " + rhs + " with unifier " + ul);
			        				}		        					
		        					iright = rhs.logicalConsequence(ag, ul, varnames);
			        				if (AJPFLogger.ltFine("ail.syntax.Guard")) {
			        					AJPFLogger.fine("ail.syntax.Guard", "Checking ileft has Next: " + lhs);
			        					AJPFLogger.fine("ail.syntax.Guard", "Checking iright does not have Next: " + rhs);
			        				}
		        				}
		        				
		        				if (AJPFLogger.ltFine("ail.syntax.Guard")) {
		        					AJPFLogger.fine("ail.syntax.Guard", "Either ileft has no next or iright does have next");
		        					AJPFLogger.fine("ail.syntax.Guard", "Checking iright has next: " + rhs);
		        				}

		        				
		        				if (iright != null && iright.hasNext()) {
		        					if (AJPFLogger.ltFine("ail.syntax.Guard")) {
			        					AJPFLogger.fine("ail.syntax.Guard", "Check Succeeded for " + rhs);
			        				}		        					
		        					current = iright.next();	 
		        				}
		        			}
		        			public void remove() {}
		        		};
		        }
		        
	       } catch (Exception e) {
	        		String slhs = "is null";
	        		if (lhs != null) {
	        			Iterator<Unifier> i = lhs.logicalConsequence(ag,un,varnames);
	        			if (i != null) {
	        				slhs = "";
	        				while (i.hasNext()) {
	        					slhs += i.next().toString()+", ";
	        				}
	        			} else {
	        				slhs = "iterator is null";
	        			}
	        		} 
	        		String srhs = "is null";
	        		if (lhs != null) {
	        			Iterator<Unifier> i = rhs.logicalConsequence(ag,un,varnames);
	        			if (i != null) {
	        				srhs = "";
	        				while (i.hasNext()) {
	        					srhs += i.next().toString()+", ";
	        				}
	        			} else {
	        				srhs = "iterator is null";
	        			}
	        		} 
	        		
	        		AJPFLogger.severe("ail.syntax.LogExpr", "Error evaluating expression "+this+". \nlhs elements="+slhs+". \nrhs elements="+srhs);
	        	}
	    	ArrayList<Unifier> empty = new ArrayList<Unifier>();
	        return empty.iterator();  // empty iterator for unifier
	}
	   
    /** create an iterator for a list of unifiers */
    static public Iterator<Unifier> createUnifIterator(Unifier... unifs) {
        List<Unifier> r = new ArrayList<Unifier>(unifs.length);
        for (int i=0; i<unifs.length; i++) {
            r.add(unifs[i]);
        }
        return r.iterator();
    }

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#unifies(ail.syntax.Unifiable, ail.syntax.Unifier)
	 */
	public boolean unifies(Unifiable t, Unifier u) {
		if (t instanceof Guard) {
			Guard g = (Guard) t;
			if (getOp() == g.getOp()) {
				if (rhs != null) {
					if (g.getRHS() != null) {
						if (rhs.unifies(g.getRHS(), u)) {
							if (lhs != null) {
								if (g.getLHS() != null) {
									return lhs.unifies(g.getLHS(), u);
								}
							} else if (g.getLHS() == null) {
								return true;
							}
						}
					}
				} else if (g.getRHS() == null) {
					if (lhs != null) {
						if (g.getLHS() != null) {
							return lhs.unifies(g.getLHS(), u);
						}
					} else if (g.getLHS() == null) {
						return true;
					}
				}
			}
		}
		
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#standardise_apart(ail.syntax.Unifiable, ail.syntax.Unifier)
	 */
	public void standardise_apart(Unifiable t, Unifier u, List<String> varnames) {
    	List<String> tvarnames = t.getVarNames();
    	List<String> myvarnames = getVarNames();
    	tvarnames.addAll(varnames);
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
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#getVarNames()
	 */
	public List<String> getVarNames() {
		ArrayList<String> varnames = new ArrayList<String>();
		if (getLHS() != null) {
			varnames.addAll(getLHS().getVarNames());
		} 
		if (getRHS() != null) {
			varnames.addAll(getRHS().getVarNames());
		}
		return varnames;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#renameVar(java.lang.String, java.lang.String)
	 */
	public void renameVar(String oldname, String newname) {
		if (lhs != null) {
			getLHS().renameVar(oldname, newname);
		}
		if (rhs != null) {
			getRHS().renameVar(oldname, newname);
		}
		
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#match(ail.syntax.Unifiable, ail.syntax.Unifier)
	 */
	public boolean match(Unifiable t, Unifier u) {
		if (t instanceof Guard) {
			Guard g = (Guard) t;
			if (getOp() == g.getOp()) {
				if (rhs != null) {
					if (g.getRHS() != null) {
						if (rhs.match(g.getRHS(), u)) {
							if (lhs != null) {
								if (g.getLHS() != null) {
									return lhs.match(g.getLHS(), u);
								}
							} else if (g.getLHS() == null) {
								return true;
							}
						}
					}
				} else if (g.getRHS() == null) {
					if (lhs != null) {
						if (g.getLHS() != null) {
							return lhs.match(g.getLHS(), u);
						}
					} else if (g.getLHS() == null) {
						return true;
					}
				}
			}
		}
		
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#matchNG(ail.syntax.Unifiable, ail.syntax.Unifier)
	 */
	public boolean matchNG(Unifiable t, Unifier u) {
		if (t instanceof Guard) {
			Guard g = (Guard) t;
			if (getOp() == g.getOp()) {
				if (rhs != null) {
					if (g.getRHS() != null) {
						if (rhs.matchNG(g.getRHS(), u)) {
							if (lhs != null) {
								if (g.getLHS() != null) {
									return lhs.matchNG(g.getLHS(), u);
								}
							} else if (g.getLHS() == null) {
								return true;
							}
						}
					}
				} else if (g.getRHS() == null) {
					if (lhs != null) {
						if (g.getLHS() != null) {
							return lhs.matchNG(g.getLHS(), u);
						}
					} else if (g.getLHS() == null) {
						return true;
					}
				}
			}
		}
		
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#isGround()
	 */
	public boolean isGround() {
		if (lhs != null && getLHS().isGround()) {
			if (rhs != null) {
				return getRHS().isGround();
			}
			return true;
		} else {
			if (rhs != null) {
				return getRHS().isGround();
			}
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#apply(ail.syntax.Unifier)
	 */
	public boolean apply(Unifier theta) {
		boolean la = true;
		if (lhs != null) {
			la = getLHS().apply(theta);
		}
		
		if (rhs != null) {
			return (la || getRHS().apply(theta));
		}
		
		return la;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#makeVarsAnnon()
	 */
	public void makeVarsAnnon() {
		if (lhs != null) {
			getLHS().makeVarsAnnon();
		}
		
		if (rhs != null) {
			getRHS().makeVarsAnnon();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#strip_varterm()
	 */
	public Unifiable strip_varterm() {
		if (getLHS() != null) {
			if (getRHS() != null) {
				return new Guard((GLogicalFormula) getLHS().strip_varterm(), getOp(), (GLogicalFormula) getRHS().strip_varterm());
				
			}
		} else {
			if (getRHS() != null) {
				return new Guard(getOp(), (GLogicalFormula) getRHS().strip_varterm());				
			}
		}
		return new Guard();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#resolveVarsClusters()
	 */
	public Unifiable resolveVarsClusters() {
		if (getLHS() != null) {
			if (getRHS() != null) {
				return new Guard((GLogicalFormula) getLHS().resolveVarsClusters(), getOp(), (GLogicalFormula) getRHS().resolveVarsClusters());
				
			}
		} else {
			if (getRHS() != null) {
				return new Guard(getOp(), (GLogicalFormula) getRHS().resolveVarsClusters());				
			}
		}
		return new Guard();
	}

}
