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
import ail.syntax.LogicalFormula;
import ail.syntax.Unifiable;
import ail.syntax.Unifier;
import ail.syntax.Guard;
import ail.syntax.ast.Abstract_BaseAILStructure;
import ail.syntax.GBelief;
import ail.syntax.Goal;

public class Abstract_MentalAtom implements Abstract_GLogicalFormula {
	Abstract_LogicalFormula[] logical_formulas = new Abstract_LogicalFormula[0];
	
	byte type;
	
	
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
					g.add(new GBelief(((Abstract_Predicate) l).toMCAPL()));
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
				return new Guard(new GBelief(((Abstract_Predicate) lf).toMCAPL()));
			} else {
				return new Guard(new Goal(((Abstract_Predicate) lf).toMCAPL(), Goal.achieveGoal));
			}
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
    	int objref = env.newObject("goal.syntax.ast.Abstract_MentalAtom");
    	env.setByteField(objref, "type", type);
       	int lfRef = env.newObjectArray("ail.syntax.ast.Abstract_LogicalFormula", logical_formulas.length);
       	for (int i = 0; i < logical_formulas.length; i++) {
       		env.setReferenceArrayElement(lfRef, i, logical_formulas[i].newJPFObject(env));
       	}
       	return objref;
	}

	@Override
	public boolean isTrivial() {
		// TODO Auto-generated method stub
		return false;
	}



}
