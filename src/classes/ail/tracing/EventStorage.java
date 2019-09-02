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

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.IndexTreeList;
import org.mapdb.Store;

import ail.semantics.AILAgent;
import ail.tracing.events.AbstractEvent;
import ail.tracing.events.CreateIntentionEvent;
import ail.tracing.explanations.PredicateDescriptions;
import ail.util.AILPrettyPrinter;

/**
 * A holder for all {@link AbstractEvent}s. This class ensures the MapDB is
 * initialized properly, and allows events to be read from and written to it
 * (using a {@link EventStorageWriter} for the latter). This class can also
 * cycle an agent through the recorded events, modifying the state of that agent
 * to 'revert' it to as it were at that point in the execution.
 */
public class EventStorage {
	private static final DateFormat format = new SimpleDateFormat("yy-MM-dd_HH-mm-ss-SSS");
	private final File datafile;
	private PredicateDescriptions descriptions;
	private final IndexTreeList<AbstractEvent> storage;
	private final EventStorageWriter writer;
	private int counter;

	/**
	 * Create a new, empty database for a given agent. Needs to be closed at some
	 * point!
	 * 
	 * @param agent
	 * @param directory The directory to store the database file in. The filename is
	 *                  set automatically (agent name + datetimestamp).
	 */
	public EventStorage(final AILAgent agent, final String directory) {
		this.datafile = new File(
				directory + File.separator + agent.getAgName() + "_" + format.format(new Date()) + ".db");
		if (!this.datafile.getParentFile().exists()) {
			this.datafile.getParentFile().mkdirs();
		}
		setPrettyPrinter(agent.getPrettyPrinter());
		// single-threaded memory-mapped file containing the event list
		final DB database = DBMaker.fileDB(datafile).fileMmapEnable().fileMmapPreclearDisable().cleanerHackEnable()
				.concurrencyDisable().transactionEnable().closeOnJvmShutdown().make();
		this.storage = database.indexTreeList("", new EventSerializer()).create();
		this.counter = this.storage.size();
		// provides an asynchronous storage writer
		this.writer = new EventStorageWriter(this.storage);
	}

	/**
	 * Load in an existing database file. NOTE: no writer is created in this case.
	 * 
	 * @param datafile
	 */
	public EventStorage(final File datafile) {
		this.datafile = datafile;
		final DB database = DBMaker.fileDB(datafile).fileMmapEnable().fileMmapPreclearDisable().cleanerHackEnable()
				.concurrencyDisable().readOnly().closeOnJvmShutdown().make();
		this.storage = database.indexTreeList("", new EventSerializer()).open();
		this.counter = this.storage.size();
		this.writer = null;
		PredicateDescriptions get = new PredicateDescriptions(new ArrayList<>(0));
		for (int i = (this.counter - 1); i >= 0; --i) { // initial events might not have the PredicateDescriptions
			final AbstractEvent event = this.storage.get(i);
			if (event instanceof CreateIntentionEvent) {
				get = ((CreateIntentionEvent) event).getIntention().pretty_printer.getPredicateDescriptions();
				break;
			}
		}
		this.descriptions = get;
	}

	/**
	 * When an agent and thus its EventStorage is created, its appropriate pretty
	 * printer might not have been set yet. This allows setting it correctly
	 * afterwards. When reading a datafile, this is not necessary.
	 * 
	 * @param printer
	 */
	public void setPrettyPrinter(final AILPrettyPrinter printer) {
		this.descriptions = printer.getPredicateDescriptions();
	}

	public PredicateDescriptions getDescriptions() {
		return this.descriptions;
	}

	/**
	 * @return The state index we are currently at (see oneStepForward and
	 *         oneStepBack).
	 */
	public int getIndex() {
		return this.counter;
	}

	/**
	 * @return The maximum state index (i.e. the amount of events recorded).
	 */
	public int getMax() {
		return this.storage.size();
	}

	/**
	 * Record an event (asynchronously through the {@link EventStorageWriter}).
	 * 
	 * @param event
	 */
	public void write(final AbstractEvent event) {
		if (this.writer != null) {
			System.out.println(event.toString(this.descriptions)); // FIXME
			this.writer.write(event);
			++this.counter;
		}
	}

	/**
	 * Makes sure all events queued for writing have been written to the trace, and
	 * that no more events can be written to the trace afterwards. Required to be
	 * called as otherwise events can be lost due to the asynchronous event writing!
	 * 
	 * @param close Iff true, the database will be unloaded from memory, thus not
	 *              allowing any read operations anymore either.
	 */
	public void finish(final boolean close) {
		if (this.writer != null) {
			this.writer.finish();
		}
		final Store store = this.storage.getStore();
		if (close && !store.isClosed()) {
			store.close();
		}
	}

	/**
	 * Take one step back in the trace from the current index (see
	 * {@link #getIndex()}). The state of the agent is modified to UNDO the current
	 * event on it.
	 * 
	 * @param agent
	 * @return The event which was reversed.
	 * @throws RuntimeException if we cannot step back any further (index is 0).
	 */
	public AbstractEvent oneStepBack(final AILAgent agent) {
		if (this.counter > 0) {
			final AbstractEvent previous = this.storage.get(--this.counter);
			previous.execute(agent, true);
			return previous;
		} else {
			throw new RuntimeException("cannot step back any further.");
		}
	}

	/**
	 * Take one step forward in the trace from the current index (see
	 * {@link #getIndex()}). The state of the agent is modified to APPLY the current
	 * event on it.
	 * 
	 * @param agent
	 * @return The event which was applied.
	 * @throws RuntimeException if we cannot step any further (index is at
	 *                          {@link #getMax()}).
	 */
	public AbstractEvent oneStepForward(final AILAgent agent) {
		if (this.counter < getMax()) {
			final AbstractEvent next = this.storage.get(this.counter++);
			next.execute(agent, false);
			return next;
		} else {
			throw new RuntimeException("cannot step ahead any further.");
		}
	}

	/**
	 * @return The current event (see {@link #getIndex()}).
	 */
	public AbstractEvent getCurrent() {
		return this.storage.get(this.counter);
	}

	/**
	 * @return The full list of events. Do not modify!
	 */
	public List<AbstractEvent> getAll() {
		return this.storage;
	}

	/**
	 * @return See {@link AbstractEvent#getLookupData()}
	 */
	public Set<String> getAllLookupData() {
		final Set<String> result = new LinkedHashSet<>();
		for (final AbstractEvent event : this.storage) {
			result.addAll(event.getLookupData());
		}
		return result;
	}

	private static boolean matches(final List<String> data, final Set<String> search) {
		if (search.isEmpty()) {
			return true;
		} else if (data.isEmpty()) {
			return false;
		} else {
			return !Collections.disjoint(data, search);
		}
	}

	/**
	 * @param signatures
	 * @return All events (at their respective state number) that are related to the
	 *         given signature(s), see {@link AbstractEvent#getLookupData()}.
	 */
	public Map<Integer, AbstractEvent> onlyAllMatching(final Set<String> signatures) {
		final Map<Integer, AbstractEvent> result = new LinkedHashMap<>();
		for (int i = 0; i < getMax(); ++i) {
			final AbstractEvent compare = this.storage.get(i);
			if (matches(compare.getLookupData(), signatures)) {
				result.put(i, compare);
			} else {
				result.put(i, null);
			}
		}
		return result;
	}

	/**
	 * @param signatures
	 * @return At most one event (at its respective state number) that is the first
	 *         to be found in the trace related to the given signature(s), see
	 *         {@link AbstractEvent#getLookupData()}.
	 */
	public Map<Integer, AbstractEvent> onlyFirstMatching(final Set<String> signatures) {
		final Map<Integer, AbstractEvent> result = new LinkedHashMap<>();
		boolean hadFirst = false;
		for (int i = 0; i < getMax(); ++i) {
			final AbstractEvent compare = this.storage.get(i);
			if (!hadFirst && matches(compare.getLookupData(), signatures)) {
				result.put(i, compare);
				hadFirst = true;
			} else {
				result.put(i, null);
			}
		}
		return result;
	}

	/**
	 * @param signatures
	 * @return At most one event (at its respective state number) that is the last
	 *         to be found in the trace related to the given signature(s), see
	 *         {@link AbstractEvent#getLookupData()}.
	 */
	public Map<Integer, AbstractEvent> onlyLastMatching(final Set<String> signatures) {
		final Map<Integer, AbstractEvent> subresult = new LinkedHashMap<>();
		boolean hadLast = false;
		for (int i = (getMax() - 1); i >= 0; --i) {
			final AbstractEvent compare = this.storage.get(i);
			if (!hadLast && matches(compare.getLookupData(), signatures)) {
				subresult.put(i, compare);
				hadLast = true;
			} else {
				subresult.put(i, null);
			}
		}
		final Map<Integer, AbstractEvent> result = new LinkedHashMap<>(subresult.size());
		for (int i = 0; i < getMax(); ++i) {
			result.put(i, subresult.get(i));
		}
		return result;
	}
}
