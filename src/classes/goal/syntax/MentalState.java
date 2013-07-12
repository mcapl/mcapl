// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
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
// License along with GOAL-AIL if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package goal.syntax;


import ail.syntax.Goal;
import ail.syntax.GBelief;
import ail.syntax.Guard;
import ail.syntax.LogExpr;
import ail.syntax.StringTerm;
import ail.syntax.Unifier;

import goal.semantics.GOALAgent;

/**
 * Class for GOAL mental state formulae. 
 * @author louiseadennis
 *
 */
public class MentalState extends Guard { 
	Boolean conjunct = false;
	Boolean negation = false;
	MentalState conjunct1;
	MentalState conjunct2;
	
	public MentalState() {
		super();
	}
	
	/**
	 * B(me, phi)
	 * @param gb
	 */
	public MentalState(GBelief gb) {
		super(new GBelief(gb));
	}
	
	/**
	 * G(me, phi)
	 * @param g
	 */
	public MentalState(Goal g) {
		super(g);
	}
	
	public MentalState(StringTerm i, GBelief gb) {
		super();
		GBelief newgb = new GBelief(gb);
		newgb.setDBnum(i);
		add(newgb);
	}
	
	public MentalState(StringTerm i, Goal g) {
		super();
		//GBelief newgb = new GBelief(g);
		//newgb.setDBnum(i);
		add(g);
	}

	public MentalState(MentalState m1, MentalState m2) {
		conjunct = true;
		conjunct1 = m1;
		conjunct2 = m2;
		setGuardExpression(new LogExpr(m1.getGuardExpression(), LogExpr.LogicalOp.and, m2.getGuardExpression()));
	}
	
	public MentalState(MentalState m) {
		negation = true;
		conjunct1 = m;
		setGuardExpression(new LogExpr(LogExpr.LogicalOp.not, m.getGuardExpression()));
	}
	
	public MentalState(Guard g) {
		setGuardExpression(g.getGuardExpression());
		
	}
	
	public Boolean isConjunct() {
		return conjunct;
	}
	
	public Boolean isNegation() {
		return negation;
	}
		
	public MentalState getConjunct1() {
		return conjunct1;
	}
	
	public MentalState getConjunct2() {
		return conjunct2;
	}
	
	public MentalState getMS() {
		return conjunct1;
	}	
	
	public MentalState clone() {
		if (isNegation()) {
			return (new MentalState((Guard) super.clone()));
		} else if (isConjunct()) {
			return (new MentalState(getConjunct1().clone(), getConjunct2().clone()));
		} else {
			MentalState ms = new MentalState();
			ms.setGuardExpression((LogExpr) getGuardExpression().clone());
			return ms;
		}
	}
	
	
}

