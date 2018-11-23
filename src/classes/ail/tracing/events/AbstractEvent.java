package ail.tracing.events;

import java.util.ArrayList;
import java.util.List;

import org.nustaq.serialization.FSTConfiguration;
import org.nustaq.serialization.FSTObjectInput;
import org.nustaq.serialization.FSTObjectOutput;

import ail.semantics.AILAgent;
import ail.syntax.Action;
import ail.syntax.ApplicablePlan;
import ail.syntax.Guard;
import ail.syntax.Intention;
import ail.syntax.Unifier;
import ail.tracing.explanations.PredicateDescriptions;

public abstract class AbstractEvent {
	@SuppressWarnings("unchecked")
	public static FSTConfiguration getSerialization() {
		final FSTConfiguration conf = FSTConfiguration.createDefaultConfiguration();
		conf.setForceSerializable(true);
		conf.getStreamCoderFactory().getInput().set(new FSTObjectInput(conf));
		conf.getStreamCoderFactory().getOutput().set(new FSTObjectOutput(conf));
		conf.registerClass(ActionEvent.class, Action.class, CreateIntentionEvent.class, Intention.class,
				GeneratePlansEvent.class, ApplicablePlan.class, GuardEvent.class, Guard.class, Unifier.class,
				ModificationAction.class, ModificationEvent.class, SelectIntentionEvent.class, SelectPlanEvent.class);
		return conf;
	}

	abstract public List<String> getLookupData();

	abstract public void execute(final AILAgent agent, final boolean reverse);

	abstract public String toString(final PredicateDescriptions descriptions);

	@Override
	public final String toString() {
		return toString(new PredicateDescriptions(new ArrayList<>(0)));
	}

	@Override
	abstract public boolean equals(final Object other);

	@Override
	abstract public int hashCode();
}
