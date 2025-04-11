// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis, Michael Fisher, and Koen Hindriks
// 
// This file is part of AIL GOAL.  An AIL Implementation of the GOAL Programming
// Language
//
// AIL GOAL is free software: you can redistribute it and/or modify it under
// the terms of the GNU General Public License as published by the Free Software
// Foundation, either version 3 of the License, or (at your option) any later
// version.
//
// AIL GOAL is distributed in the hope that it will be useful, but WITHOUT
// ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
// FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
// details.
//
// You should have received a copy of the GNU General Public License along with
// this program. If not, see <http://www.gnu.org/licenses/>.
//
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------
package goal.syntax.ast;

import gov.nasa.jpf.vm.MJIEnv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import ail.semantics.AILAgent;
import ail.syntax.ast.Abstract_Deed;
import ail.syntax.ast.Abstract_GLogicalFormula;
import ail.syntax.ast.Abstract_Literal;
import ail.syntax.ast.Abstract_LogExpr;
import ail.syntax.ast.Abstract_LogicalFormula;
import ail.syntax.ast.Abstract_Guard;
import ail.syntax.ast.Abstract_Predicate;
import ail.syntax.ast.Abstract_Equation;
import ail.syntax.ast.Abstract_Term;
import ail.syntax.GLogicalFormula;
import ail.syntax.GuardAtom;
import ail.syntax.LogicalFormula;
import ail.syntax.StringTermImpl;
import ail.syntax.Unifiable;
import ail.syntax.Unifier;
import ail.syntax.Guard;
import ail.syntax.ast.Abstract_BaseAILStructure;
import ail.syntax.GBelief;
import ail.syntax.Goal;

public class Abstract_MentalAtom implements Abstract_GLogicalFormula {
	Abstract_LogicalFormula[] logical_formulas = new Abstract_LogicalFormula[0];
	
	byte type;
	
	public static byte agoal = 100;
	public static byte goala = 101;
	
	
	public Abstract_MentalAtom(ArrayList<Abstract_LogicalFormula> lf, byte i) {
		Abstract_LogicalFormula[] lfs = new Abstract_LogicalFormula[lf.size()];
		int count = 0;
		for (Abstract_LogicalFormula l: lf) {
			lfs[count] = l;
			count++;
		}
		logical_formulas = lfs;
		type = i;
	}

	public Abstract_MentalAtom(Abstract_LogicalFormula lf, byte i) {
		Abstract_LogicalFormula[] lfs = new Abstract_LogicalFormula[1];
		lfs[0] = lf;
		logical_formulas = lfs;
		type = i;
	}
	
	@Override
	public Guard toMCAPL() {
		ArrayList<Abstract_LogicalFormula> lits = new ArrayList<Abstract_LogicalFormula>(Arrays.asList(logical_formulas));
		Guard g = guard_from_lf(lits.remove(0));
		if (type == Abstract_BaseAILStructure.AILBel) {
			for (Abstract_LogicalFormula l: lits) {
				if (l instanceof Abstract_Predicate) {
					Abstract_Predicate lp = (Abstract_Predicate) l;
					GBelief gb; 
					if (lp.getFunctor().equals("percept")) {
						gb = new GBelief(((Abstract_Predicate) lp.getTerm(0)).toMCAPL());
						gb.setEB(new StringTermImpl("percepts"));
					} else if (lp.getFunctor().equals("received")) {
						gb = new GBelief(((Abstract_Predicate) lp.getTerm(0)).toMCAPL());
						gb.setEB(new StringTermImpl("messages"));
					} else {
						gb = new GBelief(((Abstract_Predicate) l).toMCAPL());
					}
					g.add(gb);
				} else {
					g.add(((Abstract_Equation) l).toMCAPL());
				}
			}
			return g;
		} else {
			for (Abstract_LogicalFormula l: lits) {
				g.add(new Goal(((Abstract_Predicate) l).toMCAPL(), Goal.achieveGoal));
			}
			return g;
		}
	}
	
	private Guard guard_from_lf(Abstract_LogicalFormula lf) {
		if (lf instanceof Abstract_Predicate) {
			if (type == Abstract_BaseAILStructure.AILBel ) {
				Abstract_Predicate lp = (Abstract_Predicate) lf;
				GBelief gb;
				if (lp.getFunctor().equals("percept")) {
					Abstract_Predicate lpterm = (Abstract_Predicate) lp.getTerm(0);
					/* if (lpterm.getFunctor().equals("not")) {
						gb = new GBelief(((Abstract_Predicate) lpterm.getTerm(0)).toMCAPL());
						gb.setNegated(true);
					} else { */
						gb = new GBelief(((Abstract_Predicate) lp.getTerm(0)).toMCAPL());
					// } */
					gb.setEB(new StringTermImpl("percepts"));
				} else if (lp.getFunctor().equals("received")) {
					//Abstract_Predicate lpterm = (Abstract_Predicate) lp.getTerm(0);
					/* if (lpterm.getFunctor().equals("not")) {
						gb = new GBelief(((Abstract_Predicate) lpterm.getTerm(0)).toMCAPL());
						gb.setNegated(true);
					} else { */
						gb = new GBelief(((Abstract_Predicate) lp).toMCAPL());
					// } */
					gb.setEB(new StringTermImpl("messages"));
					
				} else {
					gb = new GBelief(((Abstract_Predicate) lf).toMCAPL());
				}
				return new Guard(gb);
			} else {
				return new Guard(new Goal(((Abstract_Predicate) lf).toMCAPL(), Goal.achieveGoal));
			}
		} else if (lf instanceof Abstract_LogExpr && ((Abstract_LogExpr) lf).isTrivial()) {
			return new Guard();
		} else if (lf instanceof Abstract_Equation ){
			return new Guard(Guard.GLogicalOp.none, ((Abstract_Equation) lf).toMCAPL());
		} else if (lf instanceof Abstract_LogExpr && ((Abstract_LogExpr) lf).getOp() == Abstract_LogExpr.and) {
			Guard glhs = guard_from_lf (((Abstract_LogExpr) lf).getLHS());
			Guard grhs = guard_from_lf (((Abstract_LogExpr) lf).getRHS());
			return new Guard(glhs, Guard.GLogicalOp.and, grhs);
		} else if (lf instanceof Abstract_LogExpr && ((Abstract_LogExpr) lf).getOp() == Abstract_LogExpr.or){
			Guard glhs = guard_from_lf (((Abstract_LogExpr) lf).getLHS());
			Guard grhs = guard_from_lf (((Abstract_LogExpr) lf).getRHS());
			return new Guard(glhs, Guard.GLogicalOp.or, grhs);			
		} else if (lf instanceof Abstract_LogExpr && ((Abstract_LogExpr) lf).getOp() == Abstract_LogExpr.not){
			Guard grhs = guard_from_lf (((Abstract_LogExpr) lf).getRHS());
			return new Guard(Guard.GLogicalOp.not, grhs);	
		} else if (lf instanceof Abstract_LogExpr && ((Abstract_LogExpr) lf).getOp() == Abstract_LogExpr.forall) {
			Guard glhs = guard_from_lf (((Abstract_LogExpr) lf).getLHS());
			Guard grhs = guard_from_lf (((Abstract_LogExpr) lf).getRHS());
			return new Guard(glhs, Guard.GLogicalOp.forall, grhs);
		} else {
			return guard_from_lf(((Abstract_LogExpr) lf).getRHS());
		}
	}
	
	private void split(Abstract_LogicalFormula lf, ArrayList<Abstract_LogicalFormula> ds) {
		if (lf instanceof Abstract_Predicate) {
			Abstract_Predicate lit = (Abstract_Predicate) lf;
			ds.add(new Abstract_Literal(lit));
		} else if (lf instanceof Abstract_Equation) {
			ds. add((Abstract_Equation) lf);
		} else {
			Abstract_LogExpr le = (Abstract_LogExpr) lf;
			if (le.getOp() == Abstract_LogExpr.and) {
				split(le.getRHS(), ds);
				split(le.getLHS(), ds);
			} else {
				split(le.getRHS(), ds);
			}
		}
	}


	@Override
	public int newJPFObject(MJIEnv env) {
    	int objref = env.newObject("goal.syntax.ast.Abstract_MentalAtom");
    	env.setByteField(objref, "type", type);
       	int lfRef = env.newObjectArray("ail.syntax.ast.Abstract_LogicalFormula", logical_formulas.length);
       	for (int i = 0; i < logical_formulas.length; i++) {
       		env.setReferenceArrayElement(lfRef, i, logical_formulas[i].newJPFObject(env));
       	}
		env.setReferenceField(objref, "logical_formulas", lfRef);
       	return objref;
	}

	@Override
	public boolean isTrivial() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		ArrayList<Abstract_LogicalFormula> lits = new ArrayList<Abstract_LogicalFormula>(Arrays.asList(logical_formulas));
		if (type == Abstract_BaseAILStructure.AILBel) {
			return "bel( " + lits.toString() + ")";
		} else {
			return "goal( " + lits.toString() + ")";
		}
	}

}
