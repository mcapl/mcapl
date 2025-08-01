// ----------------------------------------------------------------------------
// Copyright (C) 2008-2016 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
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
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import ail.semantics.AILAgent;
import ail.semantics.AgentMentalState;
import ail.tracing.explanations.PredicateDescriptions;
import ajpf.util.AJPFCollections;
import ajpf.util.AJPFLogger;

/**
 * Guards that appear primarily in the conditions on plans and which are checked for truth against the agent's state.
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
	public static enum GLogicalOp { 
		none   { public String toString() { return ""; } }, 
		not    { public String toString() { return "not "; } }, 
		and    { public String toString() { return " & "; } },
		or	   { public String toString() { return " || "; } },
		forall { public String toString() { return " forall "; } }
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
	
	public List<GuardAtom<?>> getAllAtoms() {
		List<GuardAtom<?>> result = new LinkedList<>();
		if(this.lhs instanceof Guard) {
			result.addAll(((Guard)this.lhs).getAllAtoms());
		} else if(this.lhs instanceof GuardAtom<?>) {
			result.add((GuardAtom<?>)this.lhs);
		}
		if(this.rhs instanceof Guard) {
			result.addAll(((Guard)this.rhs).getAllAtoms());
		} else if(this.rhs instanceof GuardAtom<?>) {
			result.add((GuardAtom<?>)this.rhs);
		}
		return result;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
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
	 * Add a new Guard Atom (conjunct) to the guard.  By default this is to be checked as true.
	 * 
	 * @param gb  The belief to be added.
	 * @return whether the belief was successfully added.
	 */
	public boolean add(GuardAtom<? extends Unifiable> gb) {
		return add(gb, true);
	}
	
	int remenbertoadcomments;
	public boolean add(GLogicalFormula gb) {
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
	public boolean add(GLogicalFormula gb, boolean b) {
  
		if (isTrivial()) {
			if (b) {
				if (gb instanceof GuardAtom<?> && !((GuardAtom<?>) gb).isTrivial()) {
					op = GLogicalOp.none;
					rhs = gb;
				}
			} else {
				if (gb instanceof GuardAtom<?> && !((GuardAtom<?>) gb).isTrivial()) {
					op = GLogicalOp.not;
					rhs = gb;
				} else {
					/// This shouldn't happen but should there be a case anyway?
				}
			}
		} else {
			if (b) {
				if (op == GLogicalOp.none) {
					lhs = rhs;
					op = GLogicalOp.and;
					rhs = gb;
				} else {
					lhs = this.clone();
					rhs = gb;
					op = GLogicalOp.and;
				}
			} else {
				Guard ng = new Guard(GLogicalOp.not, gb);
				if (op == GLogicalOp.none) {
					lhs = rhs;
					rhs = ng;
					op = GLogicalOp.and;
				} else {
					lhs = this.clone();
					rhs = ng;
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
	@Override
	public String toString() {
		if (op == GLogicalOp.none) {
			if (rhs != null) {
				return "" + rhs;
			} else {
				return "True";
			}
		} else if (op == GLogicalOp.not) {
			if (rhs != null) {
				return "~" + rhs;
			} else {
				return "False";
			}
			
		} else if (op == GLogicalOp.and) {
			return lhs + " & " + rhs;
		} else if (op == GLogicalOp.forall) {
			return " forall (" + lhs + ", " + rhs + ")";
		} else {
			return lhs + " || " + rhs;
		}
	}
	
	@Override
	public String toString(PredicateDescriptions descriptions) {
		if (descriptions.isEmpty()) {
			return toString();
		}
		if (op == GLogicalOp.none) {
			if (rhs != null) {
				return rhs.toString(descriptions);
			} else {
				return "True";
			}
		} else if (op == GLogicalOp.not) {
			if (rhs != null) {
				return "NOT " + rhs.toString(descriptions);
			} else {
				return "False";
			}
			
		} else if (op == GLogicalOp.and) {
			return lhs.toString(descriptions) + " AND " + rhs.toString(descriptions);
		} else if (op == GLogicalOp.forall) {
			return " forall (" + lhs.toString(descriptions) + ", " + rhs.toString(descriptions) + ")";
		} else {
			return lhs.toString(descriptions) + " OR " + rhs.toString(descriptions);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
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
	    
	/**
	 * Returns an iterators of unifiers that satisfy agent believes this
	 * 
	 * @param ag The agent
	 * @param un An initial unifier
	 * @return An iterator of unifiers that the agent believes this guard.
	 */
	@Override
	public Iterator<Unifier> logicalConsequence(final AgentMentalState ag, final Unifier un, final Set<String> varnames, AILAgent.SelectionOrder so) {
	       try {
		        final Iterator<Unifier> ileft;
		        switch (op) {
		        
		        	case not:
		        		if (!rhs.logicalConsequence(ag, un, varnames, AILAgent.SelectionOrder.LINEAR).hasNext()) {
		        			return createUnifIterator(un);
		        		}
		        		break;
		        	case none:
		        		if (rhs == null) {
		        			return createUnifIterator(un);
		        		} else {
		        			return rhs.logicalConsequence(ag, un, varnames, so);
		        		}
		        
		        	case and:
		        		if (lhs instanceof Guard && ((Guard) lhs).getOp().equals(GLogicalOp.not)
		        			&& (!(rhs instanceof Guard) || (!((Guard) rhs).getOp().equals(GLogicalOp.not)))) {
		        			GLogicalFormula g1 = lhs;
		        			lhs = rhs;
		        			rhs = g1;
		        		}
		        		ileft = lhs.logicalConsequence(ag,un, varnames, AILAgent.SelectionOrder.LINEAR);
	        			List<Unifier> currents = new ArrayList<Unifier>();
		        		return new Iterator<Unifier>() {
		        			Unifier current = null;
		        			Iterator<Unifier> iright = null;
		        			Iterator<Unifier> cit = null;
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
		        				
		        				if (so == AILAgent.SelectionOrder.RANDOM) {
		        					if (currents.isEmpty()) {
		        						while (ileft.hasNext()) {
		        							Unifier ul = ileft.next();
				        					iright = rhs.logicalConsequence(ag, ul, varnames, AILAgent.SelectionOrder.LINEAR);
				        					while (iright.hasNext()) {
				        						currents.add(iright.next());
				        					}
		        						}
										AJPFCollections.shuffle(currents);
										cit = currents.iterator();
		        					}
		        					
		        					if (cit != null && cit.hasNext()) {
		        						current = cit.next();
		        					}
		        					
		        					
		        				} else {
			        				while ((iright == null || !iright.hasNext()) && ileft.hasNext()) {
			        					Unifier ul = ileft.next();
			        					if (AJPFLogger.ltFine("ail.syntax.Guard")) {
				        					AJPFLogger.fine("ail.syntax.Guard", "Check Succeeded for " + lhs + " and " + rhs + " with unifier " + ul);
				        				}		        					
			        					iright = rhs.logicalConsequence(ag, ul, varnames, AILAgent.SelectionOrder.LINEAR);
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
		        			}
		        			public void remove() {}
		        			
		        			public String toString() {
		        				String s = "Iterator for: ";
		        				s += Guard.this.toString();
		        				s += " -- ";
		        				s += un;
		        				s += "\n";
		        				s += "Current Unifier: ";
		        				s += current;
		        				return s;
		        			}
		        		};
		        		
					case or:
						ileft = lhs.logicalConsequence(ag, un, varnames, so);
						/* if (lhs instanceof GBelief) {
							ileft = ((GBelief) lhs).logicalConsequence(ag, un, varnames, so);
						} else if (lhs instanceof Guard) {
							ileft = ((Guard) lhs).logicalConsequence(ag, un, varnames, so);
						} else  {
							ileft = createUnifIterator(un);
						} */
						final Iterator<Unifier> iright;
						iright = rhs.logicalConsequence(ag, un, varnames, so);
						/* if (rhs instanceof GBelief) {
							iright = ((GBelief) rhs).logicalConsequence(ag, un, varnames, so);
						} else if (rhs instanceof  Guard) {
							iright = ((Guard) rhs).logicalConsequence(ag, un, varnames, so);
						} else {
							iright = createUnifIterator(un);
						} */
								
		        		return new Iterator<Unifier>() {
		        			Unifier current = null;
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
		        				}
		        				
		        				
		        				// NOTE: if so = random the order these are evaluated should be random.
		        				if (ileft.hasNext()) {
		        					current = ileft.next();
		        					if (AJPFLogger.ltFine("ail.syntax.Guard")) {
			        					AJPFLogger.fine("ail.syntax.Guard", "Check Succeeded for lhs of " + lhs + " or " + rhs + " with unifier " + current);
			        				}	
		        				} else if (iright.hasNext()) {
		        					current = iright.next();
		           					if (AJPFLogger.ltFine("ail.syntax.Guard")) {
		           						AJPFLogger.fine("ail.syntax.Guard", "Check Succeeded for rhs of  " + lhs + " or "+ rhs + " with unifier " + current);
		           					}		        					
		        					}
		         			}
		        			
		        			public void remove() {}
		        			
		        			public String toString() {
		        				String s = "Iterator for: ";
		        				s += Guard.this.toString();
		        				s += " -- ";
		        				s += un;
		        				s += "\n";
		        				s += "Current Unifier: ";
		        				s += current;
		        				return s;
		        			}
		        		};
					case forall:
						if (lhs instanceof GBelief) {
							ileft = ((GBelief) lhs).logicalConsequence(ag, un, varnames, so);
						} else if (lhs instanceof Guard) {
							ileft = ((Guard) lhs).logicalConsequence(ag, un, varnames, so);
						} else  {
							ileft = createUnifIterator(un);
						}
														
		        		return new Iterator<Unifier>() {
		        			Unifier current = null;
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
		        				}
		        				
		        				
		        				// NOTE: if so = random the order these are evaluated should be random.
		        				while (ileft.hasNext()) {
									Iterator<Unifier> firight;
									Unifier fun = ileft.next();
									if (rhs instanceof GBelief) {
										firight = ((GBelief) rhs).logicalConsequence(ag, fun, varnames, so);
									} else if (rhs instanceof  Guard) {
										firight = ((Guard) rhs).logicalConsequence(ag, fun, varnames, so);
									} else {
										firight = createUnifIterator(fun);
									}
									if (!firight.hasNext()) {
										current = null;
										return;
									}
									
									if (AJPFLogger.ltFine("ail.syntax.Guard")) {
			        					AJPFLogger.fine("ail.syntax.Guard", "Check Succeeded for " + lhs + " and " + rhs + " with unifier " + fun);
			        				}	
								}
		        				
		        				current = un;
		        			}
		        			
		        			public void remove() {}
		        			
		        			public String toString() {
		        				String s = "Iterator for: ";
		        				s += Guard.this.toString();
		        				s += " -- ";
		        				s += un;
		        				s += "\n";
		        				s += "Current Unifier: ";
		        				s += current;
		        				return s;
		        			}
		        		};


		        }
		        
	       } catch (Exception e) {
	        		String slhs = "is null";
	        		if (lhs != null) {
	        			Iterator<Unifier> i = lhs.logicalConsequence(ag,un,varnames, so);
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
	        		if (rhs != null) {
	        			Iterator<Unifier> i = rhs.logicalConsequence(ag,un,varnames, so);
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
    @Override
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
	public void standardise_apart(Unifiable t, Unifier u, Set<String> varnames) {
		DefaultAILStructure.standardise_apart(t, u, varnames, this);
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#getVarNames()
	 */
    @Override
	public Set<String> getVarNames() {
		HashSet<String> varnames = new HashSet<String>();
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
	public boolean apply(Unifier theta) {
		boolean la = true;
		if (lhs != null) {
			la = getLHS().apply(theta);
		}
		
		if (rhs != null) {
			return (getRHS().apply(theta) || la);
		}
		
		return la;
	}
    
    @Override 
    public Unifiable substitute(Unifiable term, Unifiable subst) {
    		if (equals(term)) return subst;
    		
    		return new Guard((GLogicalFormula) getLHS().substitute(term, subst), getOp(), (GLogicalFormula) getRHS().substitute(term, subst));
    }

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#makeVarsAnnon()
	 */
    @Override
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
    @Override
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
    @Override
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
