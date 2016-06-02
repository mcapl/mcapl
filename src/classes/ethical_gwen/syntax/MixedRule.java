// ----------------------------------------------------------------------------
// Copyright (C) 2016 Louise A. Dennis, Michael Fisher, Marija Slavkovik and Matt Webster
// 
// This file is part of Ethical Gwendolen
//
// Ethical Gwendolen is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Ethical Gwendolen is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with Ethical Gwendolen if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------
package ethical_gwen.syntax;

import ail.syntax.LogicalFormula;
import ail.syntax.Predicate;
import ail.syntax.Rule;
import ail.syntax.LogExpr;

import ethical_gwen.semantics.EthicalGwendolenAgent;

public class MixedRule extends Rule {
	
	public MixedRule(Rule r) {
		super(r.getHead(), r.getBody());
	}
	/**
	 * Create a rule from a head and a body.
	 * @param h
	 * @param body
	 */
    public MixedRule(Predicate h, LogicalFormula body) {
    	super(h, body);
    }
    
    /**
     * Create a rule with just a head - i.e. true by default.
     * @param head
     */
    public MixedRule(Predicate h) {
    	super(h);
    }

    public void addEBs(EthicalGwendolenAgent a) {
    	Predicate h = getHead();
    	if (h instanceof PredicatewEB) {
    		((PredicatewEB) h).transformEB(a);
    	}
    	
    	LogicalFormula b = getBody();
    	
    	if (b instanceof PredicatewEB) {
    		((PredicatewEB) b).transformEB(a);
    	} else if (b instanceof LogExpr) {
    		addEBsLE(((LogExpr) b), a);
    	}
		
	}
    
    private void addEBsLE(LogExpr b, EthicalGwendolenAgent a) {
    	LogicalFormula lhs = b.getLHS();
    	LogicalFormula rhs = b.getRHS();
    	
    	if (lhs != null) {
    		if (lhs instanceof PredicatewEB) {
    			((PredicatewEB) lhs).transformEB(a);
    		} else if (lhs instanceof LogExpr) {
    			addEBsLE((LogExpr) lhs, a);
    		}
    	}
    	if (rhs != null) {
    		if (rhs instanceof PredicatewEB) {
    			((PredicatewEB) rhs).transformEB(a);
    		} else if (rhs instanceof LogExpr) {
    			addEBsLE((LogExpr) rhs, a);
    		}
    	}
    }
}
