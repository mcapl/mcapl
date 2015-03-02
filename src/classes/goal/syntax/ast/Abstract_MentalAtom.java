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
		ArrayList<Abstract_Literal> lits = new ArrayList<Abstract_Literal>();
		lf_to_lits(logical_formula, lits);
		if (type == Abstract_BaseAILStructure.AILBel) {
			Guard g = new Guard(new GBelief(lits.get(0).toMCAPL()));
			lits.remove(0);
			for (Abstract_Literal l: lits) {
				g.add(new GBelief(l.toMCAPL()));
			}
			return g;
		} else {
			Guard g = new Guard(new Goal(lits.get(0).toMCAPL(), Goal.achieveGoal));
			lits.remove(0);
			for (Abstract_Literal l: lits) {
				g.add(new Goal(l.toMCAPL(), Goal.achieveGoal));
			}
			return g;
		}
	}
	
	private void lf_to_lits(Abstract_LogicalFormula lf, ArrayList<Abstract_Literal> ds) {
		if (lf instanceof Abstract_Literal) {
			Abstract_Literal lit = (Abstract_Literal) lf;
			ds.add(lit);
		} else {
			Abstract_LogExpr le = (Abstract_LogExpr) lf;
			lf_to_lits(le.getRHS(), ds);
			lf_to_lits(le.getLHS(), ds);
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
