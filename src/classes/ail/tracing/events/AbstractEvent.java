package ail.tracing.events;

import java.util.List;

import org.nustaq.serialization.FSTConfiguration;
import org.nustaq.serialization.FSTObjectInput;
import org.nustaq.serialization.FSTObjectOutput;

import ail.semantics.AILAgent;

public abstract class AbstractEvent implements Comparable<AbstractEvent> {
	@SuppressWarnings("unchecked")
	public static FSTConfiguration getSerialization() {
		final FSTConfiguration conf = FSTConfiguration.createDefaultConfiguration();
		conf.setForceSerializable(true);
		conf.getStreamCoderFactory().getInput().set(new FSTObjectInput(conf));
		conf.getStreamCoderFactory().getOutput().set(new FSTObjectOutput(conf));
		// conf.registerClass(); TODO
		return conf;
	}

	abstract public List<String> getLookupData();

	abstract public String getDescription();

	abstract public void execute(final AILAgent agent, final boolean reverse);

	@Override
	abstract public boolean equals(final Object other);

	@Override
	abstract public int hashCode();

	@Override
	public int compareTo(final AbstractEvent o) {
		return 0; // FIXME?!
	}
}
