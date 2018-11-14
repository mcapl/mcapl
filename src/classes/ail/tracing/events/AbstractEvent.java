package ail.tracing.events;

import java.util.List;

import org.nustaq.serialization.FSTConfiguration;
import org.nustaq.serialization.FSTObjectInput;
import org.nustaq.serialization.FSTObjectOutput;

import ail.semantics.AILAgent;
import ail.syntax.Action;
import ail.syntax.ApplicablePlan;
import ail.syntax.Guard;
import ail.syntax.Intention;

public abstract class AbstractEvent {
	@SuppressWarnings("unchecked")
	public static FSTConfiguration getSerialization() {
		final FSTConfiguration conf = FSTConfiguration.createDefaultConfiguration();
		conf.setForceSerializable(true);
		conf.getStreamCoderFactory().getInput().set(new FSTObjectInput(conf));
		conf.getStreamCoderFactory().getOutput().set(new FSTObjectOutput(conf));
		conf.registerClass(ActionEvent.class, Action.class, CreateIntentionEvent.class, Intention.class,
				GeneratePlansEvent.class, ApplicablePlan.class, GuardEvent.class, Guard.class, ModificationAction.class,
				ModificationEvent.class, SelectIntentionEvent.class, SelectPlanEvent.class);
		return conf;
	}

	abstract public List<String> getLookupData();

	abstract public void execute(final AILAgent agent, final boolean reverse);

	@Override
	abstract public String toString();

	@Override
	abstract public boolean equals(final Object other);

	@Override
	abstract public int hashCode();
}
