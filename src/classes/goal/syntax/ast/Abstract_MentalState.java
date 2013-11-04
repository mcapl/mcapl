// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of GOAL (AIL version) - GOAL-AIL
// 
// GOAL-AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// GOAL-AIL is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with GOAL-AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package goal.syntax.ast;

import goal.syntax.MentalState;
import gov.nasa.jpf.vm.MJIEnv;
import ail.syntax.Guard;
import ail.syntax.ast.Abstract_GBelief;
import ail.syntax.ast.Abstract_Goal;
import ail.syntax.ast.Abstract_Guard;
import ail.syntax.ast.Abstract_LogExpr;
import ail.syntax.ast.Abstract_StringTerm;

public class Abstract_MentalState extends Abstract_Guard {
	boolean conjunct = false;
	boolean negation = false;
	Abstract_MentalState conjunct1;
	Abstract_MentalState conjunct2;
		
	public Abstract_MentalState() {
		super();
	}
		
	/**
	 * B(me, phi)
	 * @param gb
	 */
	public Abstract_MentalState(Abstract_GBelief gb) {
		super(new Abstract_GBelief(gb));
	} 
		
	/**
	 * G(me, phi)
	 * @param g
	 */
	public Abstract_MentalState(Abstract_Goal g) {
		super(g);
	}
		
		public Abstract_MentalState(Abstract_StringTerm i, Abstract_GBelief gb) {
			super();
			Abstract_GBelief newgb = new Abstract_GBelief(gb);
			newgb.setDBnum(i);
			add(newgb);
		}
		
		public Abstract_MentalState(Abstract_StringTerm i, Abstract_Goal g) {
			super();
		//	Abstract_GBelief newgb = new Abstract_GBelief(g);
		//	newgb.setDBnum(i);
			add(g);
		}

		public Abstract_MentalState(Abstract_MentalState m1, Abstract_MentalState m2) {
			conjunct = true;
			conjunct1 = m1;
			conjunct2 = m2;
			setGuardExpression(new Abstract_LogExpr(m1.getGuardExpression(), Abstract_LogExpr.and, m2.getGuardExpression()));
		}
		
		public Abstract_MentalState(Abstract_MentalState m) {
			negation = true;
			conjunct1 = m;
			setGuardExpression(new Abstract_LogExpr(Abstract_LogExpr.not, m.getGuardExpression()));
		}
		
		public Abstract_MentalState(Abstract_Guard g) {
			setGuardExpression(g.getGuardExpression());
			
		}
		
		public Boolean isConjunct() {
			return conjunct;
		}
		
		public Boolean isNegation() {
			return negation;
		}
			
		public Abstract_MentalState getConjunct1() {
			return conjunct1;
		}
		
		public Abstract_MentalState getConjunct2() {
			return conjunct2;
		}
		
		public Abstract_MentalState getMS() {
			return conjunct1;
		}	
		
	    public MentalState toMCAPL() {
	    	if (negation) {
	    		return new MentalState(conjunct1.toMCAPL());
	    	}
	    	if (conjunct) {
	    		return new MentalState(conjunct1.toMCAPL(), conjunct2.toMCAPL());
	    	}
	    	MentalState ms = new MentalState(super.toMCAPL());
	    	return ms;
	    }
	    
	    public int newJPFObject(MJIEnv env) {
	    	int objref = env.newObject("goal.syntax.ast.Abstract_MentalState");
	    	env.setReferenceField(objref, "guardexpression", guardexpression.newJPFObject(env));
	    	env.setBooleanField(objref, "istrivial", istrivial);
	    	env.setBooleanField(objref, "conjunct", conjunct);
	    	env.setBooleanField(objref, "negation", negation);
	    	if (conjunct1 != null) {
	    		env.setReferenceField(objref, "conjunct1", conjunct1.newJPFObject(env));
	    	}
	    	if (conjunct2 != null) {
	    		env.setReferenceField(objref, "conjunct2", conjunct2.newJPFObject(env));
	    	}
	    	return objref;
	    }

}
