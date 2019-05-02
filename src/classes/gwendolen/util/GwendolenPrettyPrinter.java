// ----------------------------------------------------------------------------
// Copyright (C) 2018 Louise A. Dennis, Michael Fisher and Vincent Koeman
// 
// This file is part of Gwendolen
//
// Gwendolen is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Gwendolen is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with Gwendolen if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------
package gwendolen.util;

import java.util.HashSet;
import java.util.Set;

import ail.syntax.ApplicablePlan;
import ail.syntax.Deed;
import ail.syntax.Intention;
import ail.syntax.Unifier;
import ail.tracing.explanations.PredicateDescriptions;
import ail.util.AILPrettyPrinter;

public class GwendolenPrettyPrinter extends AILPrettyPrinter {
	public GwendolenPrettyPrinter() {
		super();
	}

	public GwendolenPrettyPrinter(PredicateDescriptions descriptions) {
		super(descriptions);
	}

	public String prettyIntention(Intention i) {
		StringBuilder s = new StringBuilder();

		s.append("Intention ").append(i.getID()).append(": ");

		String s1 = "";
		boolean first = true;
		int rownum = 0;
		final String and = descriptions.isEmpty() ? " ; " : " THEN ";
		for (Deed d : i.deeds()) { // TODO: with descriptions enabled,
			// we might want to filter the deeds (e.g. only print actions?)
			// or even allow developers to provide a single general descriptions of them
			if (first) {
				first = false;
				s1 = d.toString(descriptions);
			} else {
				s1 = d.toString(descriptions) + and + s1;
			}
			if (d.getCategory() == Deed.Dnpy) {
				s1 = "respond to the event " + i.getEventforDeed(rownum).toString(descriptions) + " " + s1;
			}
			rownum++;
		}
		if (first) {
			s.append("the intention is now empty and will be removed");
		} else {
			s.append(s1);
		}

		return s.toString();
	}

	public String prettyAppPlan(ApplicablePlan p) {
		StringBuilder s = new StringBuilder();

		Set<String> vars = new HashSet<>(0);
		if (p.getID() == 0) {
			s.append("continue processing: ");
		} else {
			s.append("Plan ").append(p.getID()).append(": ");
			if (!descriptions.isEmpty()) {
				s.append("in response to the event: ");
			}
			s.append(p.getEvent().toString(descriptions));
			s.append(descriptions.isEmpty() ? " <- " : " do ");
			vars = p.getEvent().getVarNames();
		}
		// I left out guards here now because those are printed on their own as well,
		// usually very near the printing of the plan -Vincent

		String s1 = "";
		boolean first = true;
		final String and = descriptions.isEmpty() ? " ; " : " AND ";
		for (Deed d : p.getPrefix()) { // TODO: see printing intention deeds
			vars.addAll(d.getVarNames());
			if (first) {
				first = false;
				s1 = d.toString(descriptions);
			} else {
				s1 = d.toString(descriptions) + and + s1;
			}
		}
		if (first) { // no deed processed
			s.append("<empty>");
		} else {
			s.append(s1);
		}

		Unifier pruned = (p.getUnifier() == null) ? new Unifier() : p.getUnifier().clone();
		pruned.pruneRedundantNames(vars);
		if (pruned.size() > 0) {
			s.append(" with ").append(p.getUnifier());
		}

		return s.toString();
	}

}
