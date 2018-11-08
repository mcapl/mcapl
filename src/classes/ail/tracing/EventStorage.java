package ail.tracing;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

import ail.tracing.events.AbstractEvent;

public class EventStorage {
	private static final DateFormat format = new SimpleDateFormat("yy-MM-dd_HH-mm-ss-SSS");
	private final File datafile;
	private final IndexTreeList<AbstractEvent> storage;
	private final EventStorageWriter writer;
	private int counter;

	protected EventStorage(final String agent) {
		final File datafile = new File(agent + "_" + format.format(new Date()) + ".db"); // TODO: right dir?
		if (!datafile.getParentFile().exists()) {
			datafile.getParentFile().mkdirs();
		}
		this.datafile = datafile;
		// single-threaded memory-mapped file containing the event list
		final DB database = DBMaker.fileDB(datafile).fileMmapEnable().fileMmapPreclearDisable().cleanerHackEnable()
				.concurrencyDisable().transactionEnable().closeOnJvmShutdown().make();
		this.storage = database.indexTreeList("", new EventSerializer()).create();
		this.counter = this.storage.size();
		// provides an asynchronous storage writer
		this.writer = new EventStorageWriter(this.storage);
	}

	public EventStorage(final File datafile) {
		this.datafile = datafile;
		final DB database = DBMaker.fileDB(datafile).fileMmapEnable().fileMmapPreclearDisable().cleanerHackEnable()
				.concurrencyDisable().readOnly().closeOnJvmShutdown().make();
		this.storage = database.indexTreeList("", new EventSerializer()).open();
		this.counter = this.storage.size();
		this.writer = null;
	}

	public File getDataFile() {
		return this.datafile;
	}

	public int getIndex() {
		return this.counter;
	}

	public int getMax() {
		return this.storage.size();
	}

	public void write(final AbstractEvent event) {
		if (this.writer != null) {
			this.writer.write(event);
			++this.counter;
		}
	}

	public void finish(boolean close) throws InterruptedException {
		if (this.writer != null) {
			this.writer.finish();
		}
		if (close) {
			this.storage.getStore().close();
		}
	}

	public List<AbstractEvent> getAll() {
		return this.storage;
	}

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