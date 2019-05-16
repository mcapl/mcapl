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
package ail.tracing;

import java.io.IOException;

import org.mapdb.DataInput2;
import org.mapdb.DataOutput2;
import org.mapdb.serializer.GroupSerializerObjectArray;
import org.nustaq.serialization.FSTConfiguration;

import ail.tracing.events.AbstractEvent;

/**
 * This class allows the MapDB database to directly store
 * {@link AbstractEvent}s. This is done using the FST serialization library.
 */
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
