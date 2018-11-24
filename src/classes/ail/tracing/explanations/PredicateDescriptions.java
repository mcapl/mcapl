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
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PredicateDescriptions)) {
			return false;
		}
		PredicateDescriptions other = (PredicateDescriptions) obj;
		return descriptions.equals(other.descriptions);
	}
}
