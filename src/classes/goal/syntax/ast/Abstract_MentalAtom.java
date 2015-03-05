package goal.syntax.ast;

import gov.nasa.jpf.vm.MJIEnv;

import java.util.ArrayList;
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
import ail.syntax.GLogicalFormula;
import ail.syntax.LogicalFormula;
import ail.syntax.Unifiable;
import ail.syntax.Unifier;
import ail.syntax.Guard;
import ail.syntax.ast.Abstract_BaseAILStructure;
import ail.syntax.GBelief;
import ail.syntax.Goal;

public class Abstract_MentalAtom extends Abstract_Guard {
	Abstract_LogicalFormula logical_formula;
	
	byte type;
	
	public Abstract_MentalAtom(Abstract_LogicalFormula lf, byte i) {
		logical_formula = lf;
		type = i;
	}

	@Override
	public Guard toMCAPL() {
		ArrayList<Abstract_LogicalFormula> lits = new ArrayList<Abstract_LogicalFormula>();
		split(logical_formula, lits);
		if (type == Abstract_BaseAILStructure.AILBel) {
			Guard g = guard_from_lf(lits.get(0));
			lits.remove(0);
			for (Abstract_LogicalFormula l: lits) {
				if (l instanceof Abstract_Literal) {
					g.add(new GBelief(((Abstract_Literal) l).toMCAPL()));
				} else {
					g.add(((Abstract_Equation) l).toMCAPL());
				}
			}
			return g;
		} else {
			Guard g = new Guard(new Goal(((Abstract_Literal) lits.get(0)).toMCAPL(), Goal.achieveGoal));
			lits.remove(0);
			for (Abstract_LogicalFormula l: lits) {
				g.add(new Goal(((Abstract_Literal) l).toMCAPL(), Goal.achieveGoal));
			}
			return g;
		}
	}
	
	private Guard guard_from_lf(Abstract_LogicalFormula lf) {
		if (lf instanceof Abstract_Literal) {
			return new Guard(new GBelief(((Abstract_Literal) lf).toMCAPL()));
		} else {
			return new Guard(Guard.GLogicalOp.none, ((Abstract_Equation) lf).toMCAPL());
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isTrivial() {
		// TODO Auto-generated method stub
		return false;
	}



}
