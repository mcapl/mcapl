package ail.tracing;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.mapdb.IndexTreeList;

import ail.tracing.events.AbstractEvent;

public class EventStorageWriter implements Runnable {
	private final static ThreadPoolExecutor pool;
	static {
		pool = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 1L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
		pool.setThreadFactory(new ThreadFactory() {
			@Override
			public Thread newThread(final Runnable r) {
				final Thread t = new Thread(r);
				t.setPriority(Thread.MIN_PRIORITY); // 1 less than the runtime
				return t;
			}
		});
	}
	private final IndexTreeList<AbstractEvent> storage;
	private volatile BlockingQueue<AbstractEvent> queue;

	public EventStorageWriter(final IndexTreeList<AbstractEvent> storage) {
		this.storage = storage;
		this.queue = new LinkedBlockingQueue<>();
		pool.submit(this);
	}

	public void write(final AbstractEvent value) {
		this.queue.add(value);
	}

	public void finish() {
		while (this.queue != null && !this.queue.isEmpty()) {
			synchronized (this) {
				try {
					wait();
				} catch (InterruptedException ignore) {
				}
			}
		}
		this.queue = null;
	}

	@Override
	public void run() {
		while (this.queue != null) {
			try {
				if (this.queue.drainTo(this.storage) > 0) {
					this.storage.getStore().commit();
					synchronized (this) {
						notifyAll();
					}
				}
				Thread.sleep(1);
			} catch (final Throwable e) {
				e.printStackTrace(); // FIXME
			}
		}
	}
}
