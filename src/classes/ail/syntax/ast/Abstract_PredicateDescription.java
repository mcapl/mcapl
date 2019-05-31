package ail.syntax.ast;

public class Abstract_PredicateDescription {
	private final Abstract_Predicate predicate;
	private final Abstract_StringTerm description;

	public Abstract_PredicateDescription(final Abstract_Predicate predicate, final Abstract_StringTerm description) {
		this.predicate = predicate;
		this.description = description;
	}

	public Abstract_Predicate getPredicate() {
		return this.predicate;
	}

	public Abstract_StringTerm getDescription() {
		return this.description;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(predicate).append(" : ").append(description);
		return builder.toString();
	}
}
