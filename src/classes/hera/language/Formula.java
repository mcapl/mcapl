// ----------------------------------------------------------------------------
// Copyright (C) 2018 Louise A. Dennis, Martin Mose Bentzen, Michael Fisher 
// 
// This file is part of HERA Java Implementation
// 
// HERA Java is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// HERA Java is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with HERA Java; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package hera.language;

import java.util.ArrayList;
import java.util.Set;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import hera.parser.HeraLanguageVisitor;
import hera.parser.HeraLexer;
import hera.parser.HeraParser;

public class Formula {
	public Formula f1;
	public Formula f2;
	
	public Formula(Formula f1, Formula f2) {
		this.f1 = f1;
		this.f2 = f2;
	}
	
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
	
	@Override
	public int hashCode() {
		return f1.hashCode() + f2.hashCode();
	}

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
		
		if (this instanceof Goal) {
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
	
	public static Formula fromString(String s) {
		HeraLexer lexer = new HeraLexer(CharStreams.fromString(s));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		HeraParser parser = new HeraParser(tokens);
		HeraLanguageVisitor visitor = new HeraLanguageVisitor();
		Formula formula = visitor.visitFormula(parser.formula());
		return formula;
	}

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
}
