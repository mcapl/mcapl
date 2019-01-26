// ----------------------------------------------------------------------------
// Copyright (C) 2018 Louise A. Dennis, Felix Lindner, Martin Moze Bentzen, Michael Fisher
//
// This file is part of Juno
//
// Juno is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Juno is distributed in the hope that it will be useful,
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
//----------------------------------------------------------------------------


package hera.language;

import java.util.ArrayList;
import java.util.Set;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import ail.syntax.GBelief;
import ail.syntax.Guard;
import ail.syntax.Predicate;
import gov.nasa.jpf.vm.MJIEnv;
import hera.parser.HeraLanguageVisitor;
import hera.parser.HeraLexer;
import hera.parser.HeraParser;

/**
 * Formula class.
 * @author louisedennis
 *
 */
public class Formula implements Comparable<Object> {
	// Most formulae have two subformulae.
	public Formula f1;
	public Formula f2;
	
	/**
	 * Constructor
	 * @param f1
	 * @param f2
	 */
	public Formula(Formula f1, Formula f2) {
		this.f1 = f1;
		this.f2 = f2;
	}
	
	/**
	 * Create a conjunction from a set of formulae.
	 * @param s
	 * @return
	 */
	public static Formula makeConjunction(Set<Formula> s) {
		Formula f = null;
		for (Formula e : s) {
			if (f == null) {
				f = e;
			} else {
				f = new And(e, f);
			}
		}
		return f;
	}
	
	/**
	 * Create a disjunction from a set of formulae.
	 * @param s
	 * @return
	 */
	public static Formula makeDisjunction(ArrayList<Formula> s) {
		Formula f = null;
		for (Formula e : s) {
			if (f == null) {
				f = e;
			} else {
				f = new Or(e, f);
			}
		}
		return f;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Formula) {
			Formula f = (Formula) o;
			if (f1 == f.f1 && f2 == f.f2) {
				return true;
			}
		}
		
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		if (f2 != null) {
			return f1.hashCode() + f2.hashCode();
		} else {
			return f1.hashCode();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override 
	public String toString() {
		String f1s = "";
		String f2s = "";
		if (f1 != null && f1 instanceof FormulaString) {
			f1s = "'" + ((FormulaString) f1).getString() +"'";
		} else if (f1 != null ) {
			f1s = f1.toString();
		}
		
		if (f2 != null && f2 instanceof FormulaString) {
			f2s = "'" + ((FormulaString) f2).getString() + "'";
		} else if (f2 != null) {
			f2s = f2.toString();
		}
		
		if (this instanceof Atom) {
			return "Atom(" + f1s + ")";
		}
		
		if (this instanceof Not) {
			return "Not(" + f1s + ")";
		}
		
		if (this instanceof Or) {
			return "Or(" + f1s + ", " + f2s + ")";
		}
		
		if (this instanceof And) {
			return "And(" + f1s + ", " + f2s + ")";
		}
		
		if (this instanceof Impl) {
			return "Impl(" + f1s + ", " + f2s + ")";
		}
		
		if (this instanceof Affects) {
			return ("Affects(" + f1s + ", " + f2s + ")");
		}
		
		if (this instanceof AffectsPos) {
			return ("AffectsPos(" + f1s + ", " + f2s + ")");
		}
		
		if (this instanceof AffectsNeg) {
			return ("AffectsNeg(" + f1s + ", " + f2s + ")");
		}
		
		if (this instanceof I) {
			return ("I(" + f1s + ")");
		}
		
		if (this instanceof hera.language.Goal) {
			return ("Goal(" + f1s + ")");
		}
		
		if (this instanceof Means) {
			return "Means(" + f1s + ", " + f2s + ")";
		}
		
		if (this instanceof Causes) {
			return "Causes(" + f1s + ", " + f2s + ")";
		}
		
		if (this instanceof PCauses) {
			return "PCauses(" + f1s + ", " + f2s + ")";
		}
		
		if (this instanceof SCauses) {
			return "SCauses(" + f1s + ", " + f2s + ")";
		}
		
		if (this instanceof Explains) {
			return "Explains(" + f1s + ", " + f2s + ")";
		}
		
		if (this instanceof Prevents) {
			return "Prevents(" + f1s + ", " + f2s + ")";
		}
		
		if (this instanceof Intervention) {
			return "Intervention(" + f1s + ", " + f2s + ")";
		}
		
		if (this instanceof Exists) {
			return "Exists(" + f1s + ", " + f2s + ")";
		}
		
		if (this instanceof Forall) {
			return "Forall(" + f1s + ", " + f2s + ")";
		}
		
		if (this instanceof Gt) {
			return "Gt(" + f1s + ", " + f2s + ")";
		}
		
		if (this instanceof Geq) {
			return "Geq(" + f1s + ", " + f2s + ")";
		}
		
		if (this instanceof Must) {
			return "Must(" + f1s + ")";
		}
		
		if (this instanceof May) {
			return "May(" + f1s + ")";
		}
		
		if (this instanceof K) {
			return "K(" + f1s + ")";
		}
		
		if (this instanceof Consequence) {
			return "Consequence(" + f1s + ")";
		}
		
		return "";
	}
	
	/**
	 * For Juno we need to be able to check context expressions against an agent's belief base.  
	 * To do this we have to represent the formula as an object of class ail.syntax.Guard.
	 * @return
	 */
	public Guard toAILGuard() {
		Guard f1t = null;
		Guard f2t = null;
		
		if (f1 != null && f1 instanceof FormulaString) {
			f1t = new Guard(new GBelief(new Predicate(((FormulaString) f1).getString())));
		} else if (f1 != null ) {
			f1t = f1.toAILGuard();
		}
		
		if (f2 != null && f2 instanceof FormulaString) {
			f2t = new Guard(new GBelief(new Predicate(((FormulaString) f2).getString())));
		} else if (f2 != null) {
			f2t = f2.toAILGuard();
		}
		
		if (this instanceof FormulaString) {
			return new Guard(new GBelief(new Predicate(((FormulaString) this).getString())));
		}
		
		if (this instanceof Atom) {
			return f1t;
		}
		
		if (this instanceof Not) {
			return new Guard(Guard.GLogicalOp.not, f1t);
		}
		
		if (this instanceof Or) {
			return new Guard(f1t, Guard.GLogicalOp.or, f2t);
		}
		
		if (this instanceof And) {
			return new Guard(f1t, Guard.GLogicalOp.and, f2t);
		}
		
		if (this instanceof Impl) {
			return new Guard(new Guard(Guard.GLogicalOp.not, f1t), Guard.GLogicalOp.or, f2t);
		}
		
		// A lot of formulae shouldn't appear in these guard expressions.
		// Only and, or and not.
		if (this instanceof Affects) {
			System.err.println("THIS FORMULA IS NOT A GUARD");
		}
		
		if (this instanceof AffectsPos) {
			System.err.println("THIS FORMULA IS NOT A GUARD");
		}
		
		if (this instanceof AffectsNeg) {
			System.err.println("THIS FORMULA IS NOT A GUARD");

		}
		
		if (this instanceof I) {
			System.err.println("THIS FORMULA IS NOT A GUARD");

		}
		
		if (this instanceof hera.language.Goal) {
			System.err.println("THIS FORMULA IS NOT A GUARD");
		}
		
		if (this instanceof Means) {
			System.err.println("THIS FORMULA IS NOT A GUARD");
		}
		
		if (this instanceof Causes) {
			System.err.println("THIS FORMULA IS NOT A GUARD");
		}
		
		if (this instanceof PCauses) {
			System.err.println("THIS FORMULA IS NOT A GUARD");
		}
		
		if (this instanceof SCauses) {
			System.err.println("THIS FORMULA IS NOT A GUARD");
		}
		
		if (this instanceof Explains) {
			System.err.println("THIS FORMULA IS NOT A GUARD");
		}
		
		if (this instanceof Prevents) {
			System.err.println("THIS FORMULA IS NOT A GUARD");
		}
		
		if (this instanceof Intervention) {
			System.err.println("THIS FORMULA IS NOT A GUARD");
		}
		
		if (this instanceof Exists) {
			System.err.println("THIS FORMULA IS NOT A GUARD");
		}
		
		if (this instanceof Forall) {
			System.err.println("THIS FORMULA IS NOT A GUARD");
		}
		
		if (this instanceof Gt) {
			System.err.println("THIS FORMULA IS NOT A GUARD");
		}
		
		if (this instanceof Geq) {
			System.err.println("THIS FORMULA IS NOT A GUARD");
		}
		
		if (this instanceof Must) {
			System.err.println("THIS FORMULA IS NOT A GUARD");
		}
		
		if (this instanceof May) {
			System.err.println("THIS FORMULA IS NOT A GUARD");
		}
		
		if (this instanceof K) {
			System.err.println("THIS FORMULA IS NOT A GUARD");
		}
		
		if (this instanceof Consequence) {
			System.err.println("THIS FORMULA IS NOT A GUARD");
		}
		
		return null;
	}

	// Because we can'd use the json parser in JPF we have to perform our initial
	// parsing natively and then reconstruct the relevant objects in the JPF JVM.
	// We store the formula as a string to enable this.
	Formula fromStringFormula;
	
	/**
	 * Create a formula from a string.
	 * @param s
	 * @return
	 */
	public  Formula fromString(String s) {
		createFormulaFromString(s);
		// Forcing the creation of a hashcode to help with state matching when model-checking.
		fromStringFormula.hashCode();
		return fromStringFormula;
	}
	
	/**
	 * We create a formula from a string by using a parser.  This has to occur natively 
	 * when we are using the JPF JVM and so this method is intercepted (see peers folder).
	 * @param s
	 */
	public void createFormulaFromString(String s) {
		HeraLexer lexer = new HeraLexer(CharStreams.fromString(s));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		HeraParser parser = new HeraParser(tokens);
		HeraLanguageVisitor visitor = new HeraLanguageVisitor();
		Formula formula = visitor.visitFormula(parser.formula());
		fromStringFormula = formula;
	}

	/**
	 * Get all the positive literals in a formula.
	 * @return
	 */
	public ArrayList<Formula> getPosLiteralsEvent() {
		ArrayList<Formula> r = new ArrayList<Formula>();
		
		ArrayList<Formula> l = getAllLiteralsEvent();
		
		for (Formula e: l) {
			if (e instanceof Not) {
				r.add(e.f1);
			} else {
				r.add(e);
			}
		}
		
		return r;
	}
	
	/**
	 * Get all the literals in a formula.
	 * @return
	 */
	public ArrayList<Formula> getAllLiteralsEvent() {
		if (this instanceof Not) {
			ArrayList<Formula> r = new ArrayList<Formula>();
			r.add(this);
			return r;
		} else if (this instanceof And) {
			ArrayList<Formula> f1 = new ArrayList<Formula>();
			ArrayList<Formula> f2 = new ArrayList<Formula>();
			
			if (this.f1 instanceof FormulaString) {
				f1.add(this.f1);
			} else {
				f1.addAll(this.f1.getAllLiteralsEvent());
			}
			
			if (this.f2 instanceof FormulaString) {
				f2.add(this.f2);
			} else {
				f2.addAll(this.f2.getAllLiteralsEvent());
			}
			f1.addAll(f2);
			return f1;

		}
		
		return null;
	}
	
	/**
	 * Return a list of the atomic sub-formulae in this formula.
	 * @return
	 */
	public ArrayList<Formula> stripParentsFromMechanism() {
		if (f2 == null) {
			if (f1 instanceof FormulaString) {
				ArrayList<Formula> r = new ArrayList<Formula>();
				r.add(f1);
				return r; 
			} else {
				return f1.stripParentsFromMechanism();
			}
		}
		
		if (f1 instanceof FormulaString && f2 instanceof FormulaString) {
			ArrayList<Formula> r = new ArrayList<Formula>();
			r.add(f1);
			r.add(f2);
			return r;
		}
		
		if (f1 instanceof FormulaString && !(f2 instanceof FormulaString)) {
			ArrayList<Formula> r = new ArrayList<Formula>();
			r.add(f1);
			r.addAll(f2.stripParentsFromMechanism());
			return r;
		}
		
		if (!(f1 instanceof FormulaString) && f2 instanceof FormulaString) {
			ArrayList<Formula> r = new ArrayList<Formula>();
			r.addAll(f1.stripParentsFromMechanism());
			r.add(f2);
			return r;
		}
		
		return null;
	}
	
	/**
	 * If this object has been constructed in the native JVM during model-checking then
	 * this method allows it to be recreated in the JPF JVM.
	 * @param env
	 * @return
	 */
	public int newJPFObject(MJIEnv env) {
		if (this instanceof FormulaString) {
			int ref = env.newObject("hera.language.FormulaString");
			env.setReferenceField(ref, "s", env.newString(((FormulaString) this).getString()));
			return ref;
		} 
		
		if (this instanceof Atom) {
			int ref = env.newObject("hera.language.Atom");
			int f1ref = f1.newJPFObject(env);
			env.setReferenceField(ref, "f1", f1ref);
			return ref;
		}
		
		if (this instanceof Not) {
			int ref = env.newObject("hera.language.Not");
			int f1ref = f1.newJPFObject(env);
			env.setReferenceField(ref, "f1", f1ref);
			return ref;
		}
		
		if (this instanceof Or) {
			int ref = env.newObject("hera.language.Or");
			int f1ref = f1.newJPFObject(env);
			int f2ref = f2.newJPFObject(env);
			env.setReferenceField(ref, "f1", f1ref);
			env.setReferenceField(ref, "f2", f2ref);
			return ref;
		}
		
		if (this instanceof And) {
			int ref = env.newObject("hera.language.And");
			int f1ref = f1.newJPFObject(env);
			int f2ref = f2.newJPFObject(env);
			env.setReferenceField(ref, "f1", f1ref);
			env.setReferenceField(ref, "f2", f2ref);
			return ref;
		}
		
		if (this instanceof Impl) {
			int ref = env.newObject("hera.language.Impl");
			int f1ref = f1.newJPFObject(env);
			int f2ref = f2.newJPFObject(env);
			env.setReferenceField(ref, "f1", f1ref);
			env.setReferenceField(ref, "f2", f2ref);
			return ref;
		}
		
		if (this instanceof Affects) {
			int ref = env.newObject("hera.language.Affects");
			int f1ref = f1.newJPFObject(env);
			int f2ref = f2.newJPFObject(env);
			env.setReferenceField(ref, "f1", f1ref);
			env.setReferenceField(ref, "f2", f2ref);
			return ref;
		}
		
		if (this instanceof AffectsPos) {
			int ref = env.newObject("hera.language.AffectsPos");
			int f1ref = f1.newJPFObject(env);
			int f2ref = f2.newJPFObject(env);
			env.setReferenceField(ref, "f1", f1ref);
			env.setReferenceField(ref, "f2", f2ref);
			return ref;
		}
		
		if (this instanceof AffectsNeg) {
			int ref = env.newObject("hera.language.AffectsNeg");
			int f1ref = f1.newJPFObject(env);
			int f2ref = f2.newJPFObject(env);
			env.setReferenceField(ref, "f1", f1ref);
			env.setReferenceField(ref, "f2", f2ref);
			return ref;
		}
		
		if (this instanceof I) {
			int ref = env.newObject("hera.language.I");
			int f1ref = f1.newJPFObject(env);
			env.setReferenceField(ref, "f1", f1ref);
			return ref;
		}
		
		if (this instanceof hera.language.Goal) {
			int ref = env.newObject("hera.language.Goal");
			int f1ref = f1.newJPFObject(env);
			env.setReferenceField(ref, "f1", f1ref);
			return ref;
		}
		
		if (this instanceof Means) {
			int ref = env.newObject("hera.language.Means");
			int f1ref = f1.newJPFObject(env);
			int f2ref = f2.newJPFObject(env);
			env.setReferenceField(ref, "f1", f1ref);
			env.setReferenceField(ref, "f2", f2ref);
			return ref;
		}
		
		if (this instanceof Causes) {
			int ref = env.newObject("hera.language.Causes");
			int f1ref = f1.newJPFObject(env);
			int f2ref = f2.newJPFObject(env);
			env.setReferenceField(ref, "f1", f1ref);
			env.setReferenceField(ref, "f2", f2ref);
			return ref;
		}
		
		if (this instanceof PCauses) {
			int ref = env.newObject("hera.language.PCauses");
			int f1ref = f1.newJPFObject(env);
			int f2ref = f2.newJPFObject(env);
			env.setReferenceField(ref, "f1", f1ref);
			env.setReferenceField(ref, "f2", f2ref);
			return ref;
		}
		
		if (this instanceof SCauses) {
			int ref = env.newObject("hera.language.SCauses");
			int f1ref = f1.newJPFObject(env);
			int f2ref = f2.newJPFObject(env);
			env.setReferenceField(ref, "f1", f1ref);
			env.setReferenceField(ref, "f2", f2ref);
			return ref;
		}
		
		if (this instanceof Explains) {
			int ref = env.newObject("hera.language.Explains");
			int f1ref = f1.newJPFObject(env);
			int f2ref = f2.newJPFObject(env);
			env.setReferenceField(ref, "f1", f1ref);
			env.setReferenceField(ref, "f2", f2ref);
			return ref;
		}
		
		if (this instanceof Prevents) {
			int ref = env.newObject("hera.language.Prevents");
			int f1ref = f1.newJPFObject(env);
			int f2ref = f2.newJPFObject(env);
			env.setReferenceField(ref, "f1", f1ref);
			env.setReferenceField(ref, "f2", f2ref);
			return ref;
		}
		
		if (this instanceof Intervention) {
			int ref = env.newObject("hera.language.Intervention");
			int f1ref = f1.newJPFObject(env);
			int f2ref = f2.newJPFObject(env);
			env.setReferenceField(ref, "f1", f1ref);
			env.setReferenceField(ref, "f2", f2ref);
			return ref;
		}
		
		if (this instanceof Exists) {
			int ref = env.newObject("hera.language.Exists");
			int f1ref = f1.newJPFObject(env);
			int f2ref = f2.newJPFObject(env);
			env.setReferenceField(ref, "f1", f1ref);
			env.setReferenceField(ref, "f2", f2ref);
			return ref;
		}
		
		if (this instanceof Forall) {
			int ref = env.newObject("hera.language.Forall");
			int f1ref = f1.newJPFObject(env);
			int f2ref = f2.newJPFObject(env);
			env.setReferenceField(ref, "f1", f1ref);
			env.setReferenceField(ref, "f2", f2ref);
			return ref;
		}
		
		if (this instanceof Gt) {
			int ref = env.newObject("hera.language.Gt");
			int f1ref = f1.newJPFObject(env);
			int f2ref = f2.newJPFObject(env);
			env.setReferenceField(ref, "f1", f1ref);
			env.setReferenceField(ref, "f2", f2ref);
			return ref;
		}
		
		if (this instanceof Geq) {
			int ref = env.newObject("hera.language.Geq");
			int f1ref = f1.newJPFObject(env);
			int f2ref = f2.newJPFObject(env);
			env.setReferenceField(ref, "f1", f1ref);
			env.setReferenceField(ref, "f2", f2ref);
			return ref;
		}
		
		if (this instanceof Must) {
			int ref = env.newObject("hera.language.Must");
			int f1ref = f1.newJPFObject(env);
			env.setReferenceField(ref, "f1", f1ref);
			return ref;
		}
		
		if (this instanceof May) {
			int ref = env.newObject("hera.language.May");
			int f1ref = f1.newJPFObject(env);
			env.setReferenceField(ref, "f1", f1ref);
			return ref;
		}
		
		if (this instanceof K) {
			int ref = env.newObject("hera.language.K");
			int f1ref = f1.newJPFObject(env);
			env.setReferenceField(ref, "f1", f1ref);
			return ref;
		}
		
		if (this instanceof Consequence) {
			int ref = env.newObject("hera.language.Consequence");
			int f1ref = f1.newJPFObject(env);
			env.setReferenceField(ref, "f1", f1ref);
			return ref;
		}
		
		if (this instanceof TermFormula) {
			int ref = env.newObject("hera.language.TermFormula");
			int tref = ((TermFormula) this).getTerm().newJPFObject(env);
			env.setReferenceField(ref, "t", tref);
			return ref;
			
		}
		
		return 0;
		
	}

	// Ordering on Formulas
	// FormulaString
	// Atom
	// Not
	// Or
	// And
	// Impl
	// Affects
	// AffectsPos
	// AffectsNeg
	// I
	// hera.language.Goal
	// Means
	// Causes
	// PCauses
	// SCauses
	// Explains
	// Prevents
	// Intervention
	// Exists
	// Forall
	// Gt
	// Geq
	// Must
	// May
	// K
	// Consequence
	// TermFormula
	/**
	 * This is largely redundant but at one point I thought we would need an ordering on formulae to 
	 * assist state matching when model-checking.
	 * @return
	 */
	private int ordernum() { 
		if (this instanceof FormulaString) {
			return 0;
		} else if (this instanceof Atom) {
			return 1;
		} else if (this instanceof Not) {
			return 2;
		} else if (this instanceof Or) {
			return 3;
		} else if (this instanceof And) {
			return 4;
		} else if (this instanceof Impl) {
			return 5;
		} else if (this instanceof Affects) {
			return 6;
		} else if (this instanceof AffectsPos) {
			return 7;
		} else if (this instanceof AffectsNeg) {
			return 8;
		} else if (this instanceof I) {
			return 9;
		} else if (this instanceof hera.language.Goal) {
			return 10;
		} else if (this instanceof Means) {
			return 11;
		} else if (this instanceof Causes) {
			return 12;
		} else if (this instanceof PCauses) {
			return 13;
		} else if (this instanceof SCauses) {
			return 14;
		} else if (this instanceof Explains) {
			return 15;
		} else if (this instanceof Prevents) {
			return 16;
		} else if (this instanceof Intervention) {
			return 17;
		} else if (this instanceof Exists) {
			return 18;
		} else if (this instanceof Forall) {
			return 19;
		} else if (this instanceof Gt) {
			return 20;
		} else if (this instanceof Geq) {
			return 21;
		} else if (this  instanceof Must) {
			return 22;
		} else if (this  instanceof May) {
			return 23;
		} else if (this  instanceof K) {
			return 24;
		} else if (this instanceof Consequence){
			return 25;
		} else {
			return 26;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Object o) {
		if (o instanceof Formula) {
			Formula of = (Formula) o;
			if (ordernum() == of.ordernum()) {
				if (this instanceof FormulaString) {
					FormulaString thiss = (FormulaString) this;
					FormulaString os = (FormulaString) o;
					return thiss.getString().compareTo(os.getString());
				}
				
				if (this instanceof Atom || this instanceof Not || this instanceof I || this instanceof hera.language.Goal ||
						this  instanceof Must || this instanceof May || this  instanceof K || this instanceof  Consequence) {
					return f1.compareTo(of.f1);
				}
				
				if (this instanceof Or || this instanceof And || this instanceof Impl || this instanceof AffectsPos || 
						this instanceof AffectsNeg || this instanceof Means || this  instanceof Causes || this instanceof PCauses ||
						this instanceof SCauses || this instanceof Explains || this instanceof Prevents || this instanceof Intervention ||
						this instanceof Exists || this instanceof Forall || this instanceof Gt || this instanceof Geq) {
					if (f1.compareTo(of.f1) == 0) {
						return (f2.compareTo(of.f2));
					}
					return f1.compareTo(of.f1);
				}
				
				// Cheating but I can't be bothered to set up compareTo on Terms
				return this.toString().compareTo(of.toString());
				
			} else if (ordernum() < of.ordernum()){
				return -1;
			}
			return 1;
		}
		return 1;
	}
	
	// This is a hack to state that a universally quantified formula just quantifies 
	// over moral patients.  This improves the effeciency of checking in the Kantian 
	// reasoner with therefore a significant speed up in model-checking time.
	boolean rtp = false;
	public void restrictopatients() {
		rtp = true;
	}
	public boolean retrictedtopatients() {
		return rtp;
	}


	// This is a hack to state that a universally quantified formula just quantifies 
	// over events (actions and consequences).  This improves the effeciency of checking in the Kantian 
	// reasoner with therefore a significant speed up in model-checking time.
	boolean rte = false;
	public void restrictoevents() {
		rte = true;
	}
	public boolean retrictedtoevents() {
		return rte;
	}


}
