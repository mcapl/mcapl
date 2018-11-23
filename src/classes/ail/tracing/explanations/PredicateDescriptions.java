package ail.tracing.explanations;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import ail.syntax.Predicate;
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

	public String getDescription(final Predicate predicate) {
		for (final Predicate description : descriptions.keySet()) {
			final Unifier u = new Unifier();
			if (description.unifies(predicate, u)) {
				return descriptions.get(description); // TODO: apply unification to string
			}
		}
		return null;
	}
}
