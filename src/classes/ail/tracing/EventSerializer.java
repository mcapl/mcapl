package ail.tracing;

import java.io.IOException;

import org.mapdb.DataInput2;
import org.mapdb.DataOutput2;
import org.mapdb.serializer.GroupSerializerObjectArray;
import org.nustaq.serialization.FSTConfiguration;

import ail.tracing.events.AbstractEvent;

public class EventSerializer extends GroupSerializerObjectArray<AbstractEvent> {
	private final FSTConfiguration serialization;

	public EventSerializer() {
		this.serialization = AbstractEvent.getSerialization();
	}

	@Override
	public void serialize(final DataOutput2 out, final AbstractEvent value) throws IOException {
		try {
			this.serialization.encodeToStream(out, value);
		} finally {
			out.close();
		}
	}

	@Override
	public AbstractEvent deserialize(final DataInput2 in, final int available) throws IOException {
		try {
			return (AbstractEvent) this.serialization.decodeFromStream(new DataInput2.DataInputToStream(in));
		} catch (final Exception e) {
			throw new IOException(e);
		} finally {
			in.close();
		}
	}
}
