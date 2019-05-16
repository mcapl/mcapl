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

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.mapdb.IndexTreeList;

import ail.tracing.events.AbstractEvent;

/**
 * This class ensures {@link AbstractEvent}s are actually written to the MapDB
 * that underlies the {@link EventStorage}. It does so using a pool of threads
 * (at most 1 thread per agent) that are set at the lowest possible priority in
 * order to intervene with execution as little as possible. A busy waiting loop
 * is used to allow more events to be written away at once than with e.g. a
 * wait-notify structure (this relies on the low thread priority).
 * {@link #finish()} guarantees all queued events have been written.
 */
public class EventStorageWriter implements Runnable {
	private final static ThreadPoolExecutor pool;
	static {
		pool = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 1L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
		pool.setThreadFactory(new ThreadFactory() {
			@Override
			public Thread newThread(final Runnable r) {
				final Thread t = new Thread(r);
				t.setPriority(Thread.MIN_PRIORITY);
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
				} catch (final InterruptedException ignore) {
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
