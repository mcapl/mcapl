// ----------------------------------------------------------------------------
// Copyright (C) 2018 Louise A. Dennis, Michael Fisher, and Vincent Koeman
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
// License along with the AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------
package ail.util;

import java.util.ArrayList;
import java.util.ListIterator;

import ail.syntax.ApplicablePlan;
import ail.syntax.Deed;
import ail.syntax.Guard;
import ail.syntax.Intention;
import ail.syntax.IntentionRow;
import ail.tracing.explanations.PredicateDescriptions;

public class AILPrettyPrinter {
	protected PredicateDescriptions descriptions;

	public AILPrettyPrinter() {
		this.descriptions = new PredicateDescriptions(new ArrayList<>(0));
	}

	public AILPrettyPrinter(PredicateDescriptions descriptions) {
		this.descriptions = descriptions;
	}

	public PredicateDescriptions getPredicateDescriptions() {
		return this.descriptions;
	}
	
	public void setDescriptions(PredicateDescriptions des) {
		descriptions = des;
	}

	public String prettyIntention(Intention i) {
		StringBuilder s = new StringBuilder();
		if (i.suspended()) {
			s.append("SUSPENDED\n");
		}
		s.append(i.getSource()).append(":: ");
		if (i.getAnnotation() != null) {
			s.append(i.getAnnotation());
		}
		s.append("\n");

		String s1 = "";
		for (IntentionRow ir : i.getRows()) {
			s1 = "   *  " + ir.toString(descriptions) + s1;
		}
		s.append(s1);

		return s.toString();
	}

	public String prettyAppPlan(ApplicablePlan p) {
		StringBuilder s = new StringBuilder();

		ListIterator<Guard> gi = p.getGuard().listIterator();
		ListIterator<Deed> di = p.getPrefix().listIterator();
		String triggers = p.getEvent().toString(descriptions);
		String us = "[]";
		if (!  (p.getUnifier() == null)) {
			us = p.getUnifier().toString();
		}
		while (gi.hasNext()) {
			Guard gu = gi.next();
			Deed d = di.next();
			s.append(p.getID()).append(" :: ").append(triggers).append("||").append(gu.toString(descriptions));
			s.append("||").append(d.toString(descriptions)).append("||").append(us).append("\n");
		}

		return s.toString();
	}

}
