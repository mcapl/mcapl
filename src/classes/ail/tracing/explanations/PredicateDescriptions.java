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
package ail.tracing.explanations;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import ail.syntax.Predicate;
import ail.syntax.PredicatewAnnotation;
import ail.syntax.Unifier;
import ail.syntax.ast.Abstract_PredicateDescription;

public class PredicateDescriptions {
	private final Map<Predicate, String> descriptions;

	public PredicateDescriptions(final List<Abstract_PredicateDescription> descriptions) {
		this.descriptions = new LinkedHashMap<>(descriptions.size());
		for (final Abstract_PredicateDescription description : descriptions) {
			this.descriptions.put(description.getPredicate().toMCAPL(), description.getDescription().toString());
		}
	}

	public boolean isEmpty() {
		return this.descriptions.isEmpty();
	}

	public String getDescription(Predicate predicate) {
		if (predicate instanceof PredicatewAnnotation) {
			// Strip info to make sure we match as much as possible below!
			predicate = new Predicate(predicate);
			// TODO: use info from annotation (and e.g. goaltype)?
		}
		for (final Predicate described : descriptions.keySet()) {
			final Unifier u = new Unifier();
			if (predicate.match(described, u)) {
				String description = descriptions.get(described);
				for (final String var : u.getVarNames()) {
					description = description.replace("%" + var, u.get(var).toString());
				}
				return description;
			}
		}
		return predicate.toString();
	}

	@Override
	public String toString() {
		return descriptions.toString();
	}

	@Override
	public int hashCode() {
		return descriptions.hashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PredicateDescriptions)) {
			return false;
		}
		final PredicateDescriptions other = (PredicateDescriptions) obj;
		return descriptions.equals(other.descriptions);
	}
}
